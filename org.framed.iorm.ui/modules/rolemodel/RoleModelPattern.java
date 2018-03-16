package rolemodel;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.DeleteContext;
import org.eclipse.graphiti.features.context.impl.MoveShapeContext;
import org.eclipse.graphiti.features.context.impl.MultiDeleteInfo;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.pattern.AbstractPattern;
import org.eclipse.graphiti.pattern.IPattern;
import org.eclipse.graphiti.ui.editor.DiagramEditorInput;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.framed.iorm.model.Model;
import org.framed.iorm.model.ModelElement;
import org.framed.iorm.model.OrmFactory;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.FRaMEDShapePattern;
import org.framed.iorm.ui.UILiterals;
import org.framed.iorm.ui.UIUtil;
import org.framed.iorm.ui.editPolicy.EditPolicyService;
import org.framed.iorm.ui.exceptions.NoDiagramFoundException;
import org.framed.iorm.ui.palette.FeaturePaletteDescriptor;
import org.framed.iorm.ui.palette.PaletteCategory;
import org.framed.iorm.ui.palette.PaletteView;
import org.framed.iorm.ui.palette.ViewVisibility;
import org.framed.iorm.ui.references.AbstractGroupingFeatureReference;
import org.framed.iorm.ui.references.AbstractStepInReference;
import org.framed.iorm.ui.wizards.RoleModelWizard;

/**
 * This graphiti pattern class is used to work with role models, which {@link org.framed.iorm.model.Shape}s
 * of the type {@link Type#COMPARTMENT_TYPE} when compartment_type feature is not choosen.
 * <p>
 * It deals with the following aspects of role models:<br>
 * (1) adding a role model to the diagram, especially its pictogram elements<br>
 * (2) creating the role model, especially its business object<br>
 * (3) layout the group, especially setting lines and role models elements at the right positions<br>
 * (4) updating its content overview<br>
 * (5) moves the drop shadow with the type body and disables moving the drop shadow manually<br>
 * (6) resizes the drop shadow with the type body and disables resizing the drop shadow manually<br>
 * (7) deleting all the compartments pictogram elements and its diagram, also disables deleting the drop 
 *     shadow manually
 * @author Kevin Kassin
 */
public class RoleModelPattern extends FRaMEDShapePattern implements IPattern {

	/**
	 * the object to get names, ids and so on for this feature
	 */
	private final Literals literals = new Literals();
	
	/**
	 * the object to call utility operations on
	 */
	private final Util util = new Util();
	
	/**
	 * the reference to the step in feature 
	 */
	private final AbstractStepInReference stepInReference = UIUtil.getStepInFeatureReference();
		
	/**
	 * the list of reference classes which save in module feature's shapes can group objects
	 * @see AbstractGroupingFeatureReference
	 */
	private final List<AbstractGroupingFeatureReference> groupingFeatureReferences; 
	
	/**
	 * the feature palette descriptor manages the palette visibility, see {@link FeaturePaletteDescriptor}
	 */	
	private final FeaturePaletteDescriptor spec_FPD = new FeaturePaletteDescriptor(
		PaletteCategory.ENTITIES_CATEGORY,
		ViewVisibility.TOPLEVEL_VIEW) {
			@Override
			public boolean featureExpression(List<String> framedFeatureNames, PaletteView paletteView) {
				return !(framedFeatureNames.contains("Compartment_Types"));
		}	};
	
	/**
	 * class constructor		
	 */
	public RoleModelPattern() {
		super();
		FEATURE_NAME = literals.FEATURE_NAME;
		ICON_IMG_ID = literals.ICON_IMG_ID;
		ICON_IMG_PATH = literals.ICON_IMG_PATH;
		modelType = Type.COMPARTMENT_TYPE;
		FPD = spec_FPD;
		//Note
		groupingFeatureReferences = UIUtil.getGroupingFeatureReferences();
	}
	
	/**
	 * returns the double click feature of this pattern 
	 */
	@Override
	public IFeature getDoubleClickFeature(ICustomFeature[] customFeatures) {
		if(stepInReference == null) return null;
		return (ICustomFeature) UIUtil.findFeatureByName(customFeatures, stepInReference.getStepInFeatureName());
	}
		
	/**
	 * checks if pattern is applicable for a given business object
	 * @return true, if business object is a {@link org.framed.iorm.model.Shape} of type {@link Type#COMPARTMENT_TYPE}
	 */
	@Override
	public boolean isMainBusinessObjectApplicable(Object businessObject) {
		if(businessObject instanceof org.framed.iorm.model.Shape) {
			org.framed.iorm.model.Shape shape = (org.framed.iorm.model.Shape) businessObject;
			if(shape.getType() == Type.COMPARTMENT_TYPE && 
			   shape.getFirstSegment()==null &&
			   shape.getSecondSegment()==null) return true;
		}
		return false;
	}

	/**
	 * checks if pattern is applicable for a given pictogram element
	 * @return true, if business object of the pictogram element is a {@link org.framed.iorm.model.Shape} of type {@link Type#COMPARTMENT_TYPE}
	 */
	@Override
	protected boolean isPatternControlled(PictogramElement pictogramElement) {
		Object businessObject = getBusinessObjectForPictogramElement(pictogramElement);
		return isMainBusinessObjectApplicable(businessObject);
	}

	/**
	 * checks if the pictogram element to edit with the pattern is its root
	 * @return true, if business object of the pictogram element is a {@link org.framed.iorm.model.Shape} of type {@link Type#COMPARTMENT_TYPE}
	 */
	@Override
	protected boolean isPatternRoot(PictogramElement pictogramElement) {
		Object businessObject = getBusinessObjectForPictogramElement(pictogramElement);
		return isMainBusinessObjectApplicable(businessObject);
	}
	
	
	// add feature
	//~~~~~~~~~~~~~
	/**
	 * calculates if the role model can be added to the diagram
	 * <p>
	 * returns true if:<br>
	 * (1) if the added business object is a role model and <br>
	 * (2) if the target container is a diagram with a model linked
	 * @return if the role model can be added
	 */
	@Override
	public boolean canAdd(IAddContext addContext) {
		if(addContext.getNewObject() instanceof org.framed.iorm.model.Shape) {
			org.framed.iorm.model.Shape shape = (org.framed.iorm.model.Shape) addContext.getNewObject();
			if(shape.getType()==Type.COMPARTMENT_TYPE) {
				if(UIUtil.getLinkedModelForDiagram(getDiagram()) != null) {
					   return EditPolicyService.getHandler(this.getDiagram()).canAdd(addContext);
		}	}	}
		return false;
	}
	
	/**
	 * adds the graphical representation of a role model to the pictogram model
	 * <p>
	 * It creates the following structure:<br>
	 * <ul>
	 *   <li>container shape</li>
	 * 	   <ul>
	 * 	     <li>drop shadow shape</li>
	 *         <ul><li>drop shadow rectangle</li></ul>
	 * 		 <li>type body shape</li>
	 * 		   <ul><li>type body rectangle</li></ul>
	 * 		   <ul>
	 * 		     <li>name container</li>
	 * 			  <ul><li>name text</li></ul>
	 * 			<li>first line container</li>
	 * 			  <ul><li>first polyline</li></ul>
	 * 			<li>model content preview container</li>
	 * 			  <ul><li>model content preview rectangle</li></ul>
	 * 		   </ul>
	 * 	   </ul>
	 * </ul> 
	 * <p>
	 * The (this patterns) role model diagram will be created outside of (this patterns) role models <em>container shape</em>. 
	 * It can be found as child of the <em>container diagram</em> of the overall model. If its not clear what <em>container 
	 * diagram</em> means, see {@link RoleModelWizard#createEmfFileForDiagram} for reference.
	 * <p>
	 * It uses follows this steps:<br>
	 * Step 1: It gets the new object, the diagram to create the role model in and calculates the height and width 
	 * 		   of the role model's representation.<br>
	 * Step 2: It creates the structure shown above.<br>
	 * Step 3: It sets the shape identifiers for the created graphics algorithms of the role model.<br>
	 * Step 4: It links the created shapes of the role model to its business objects.<br> 
	 * Step 5: It enables anchors and layouting of the role model. Also updates the group it is created in.
	 */
	@Override
	public PictogramElement add(IAddContext addContext) {
		//Step 1
		org.framed.iorm.model.Shape addedCompartmentType = (org.framed.iorm.model.Shape) addContext.getNewObject();
		ContainerShape targetDiagram = getDiagram();
		int width = addContext.getWidth(), height = addContext.getHeight();
		if(addContext.getWidth() < literals.MIN_WIDTH) width = literals.MIN_WIDTH;
		if(addContext.getHeight() < literals.MIN_HEIGHT) height = literals.MIN_HEIGHT;
				
		//Step 2
		//container for body shape and shadow
		ContainerShape containerShape = pictogramElementCreateService.createContainerShape(targetDiagram, false);
							  
		//drop shadow
		ContainerShape dropShadowShape = pictogramElementCreateService.createContainerShape(containerShape, true);
		Rectangle dropShadowRectangle = graphicAlgorithmService.createRectangle(dropShadowShape);
		dropShadowRectangle.setForeground(manageColor(literals.COLOR_SHADOW));
		dropShadowRectangle.setBackground(manageColor(literals.COLOR_SHADOW));
		graphicAlgorithmService.setLocationAndSize(dropShadowRectangle, addContext.getX()+literals.SHADOW_SIZE, addContext.getY()+literals.SHADOW_SIZE, width, height);
				
		//body shape of type
		ContainerShape typeBodyShape = pictogramElementCreateService.createContainerShape(containerShape, true);		
		Rectangle typeBodyRectangle = graphicAlgorithmService.createRectangle(typeBodyShape);
		typeBodyRectangle.setForeground(manageColor(literals.COLOR_LINES));
		typeBodyRectangle.setBackground(manageColor(literals.COLOR_BACKGROUND));
		graphicAlgorithmService.setLocationAndSize(typeBodyRectangle, addContext.getX(), addContext.getY(), width, height);
				
		//name
		Shape nameShape = pictogramElementCreateService.createShape(typeBodyShape, false);
		Text text = graphicAlgorithmService.createText(nameShape, addedCompartmentType.getName());	
		text.setForeground(manageColor(literals.COLOR_TEXT));	
		text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);	
		graphicAlgorithmService.setLocationAndSize(text, 0, 0, width, literals.HEIGHT_NAME_SHAPE);	
				
		//first line
		Shape firstLineShape = pictogramElementCreateService.createShape(typeBodyShape, false);
		Polyline firstPolyline = graphicAlgorithmService.createPolyline(firstLineShape, new int[] {0, literals.HEIGHT_NAME_SHAPE, width, literals.HEIGHT_NAME_SHAPE});
		firstPolyline.setForeground(manageColor(literals.COLOR_LINES));
					
		//model content preview container
		ContainerShape modelContainer = pictogramElementCreateService.createContainerShape(typeBodyShape, false);
		Rectangle modelRectangle = graphicAlgorithmService.createRectangle(modelContainer);
		modelRectangle.setBackground(manageColor(literals.COLOR_BACKGROUND));
		modelRectangle.setLineVisible(false);
		graphicAlgorithmService.setLocationAndSize(modelRectangle, literals.PUFFER_BETWEEN_ELEMENTS, literals.HEIGHT_NAME_SHAPE+literals.PUFFER_BETWEEN_ELEMENTS, 
												   width-2*literals.PUFFER_BETWEEN_ELEMENTS, height-literals.HEIGHT_NAME_SHAPE-2*literals.PUFFER_BETWEEN_ELEMENTS);	
		
		//role model diagram
		Diagram contentDiagram = pictogramElementCreateService.createDiagram(UILiterals.DIAGRAM_TYPE_ID, addedCompartmentType.getName(), 10, true);
		UIUtil.setDiagram_KindValue(contentDiagram, literals.DIAGRAM_KIND);
		AddRoleModelContext agctc = (AddRoleModelContext) addContext;
		link(contentDiagram, agctc.getModelToLink());
		getDiagram().getContainer().getChildren().add(contentDiagram);
		
		//Step 3
		UIUtil.setShape_IdValue(containerShape, literals.SHAPE_ID_COMPARTMENTTYPE_CONTAINER);
		UIUtil.setShape_IdValue(typeBodyShape, literals.SHAPE_ID_COMPARTMENTTYPE_TYPEBODY);
		UIUtil.setShape_IdValue(dropShadowShape, literals.SHAPE_ID_COMPARTMENTTYPE_SHADOW);
		UIUtil.setShape_IdValue(nameShape, literals.SHAPE_ID_COMPARTMENTTYPE_NAME);
		UIUtil.setShape_IdValue(firstLineShape, literals.SHAPE_ID_COMPARTMENTTYPE_FIRSTLINE);
		UIUtil.setShape_IdValue(modelContainer, literals.SHAPE_ID_COMPARTMENTTYPE_CONTENT_PREVIEW);
		
		//Step 4
		link(containerShape, addedCompartmentType);
		link(typeBodyShape, addedCompartmentType);
		link(dropShadowShape, addedCompartmentType);
		link(nameShape, addedCompartmentType);
		link(firstLineShape, addedCompartmentType);
		link(modelContainer, addedCompartmentType);
		
		//Step 5
		pictogramElementCreateService.createChopboxAnchor(typeBodyShape);
		layoutPictogramElement(containerShape);
		updateContainingGroupingFeaturesObject();
		return containerShape;
	}
	
	//create feature
	//~~~~~~~~~~~~~~
	/**
	 * calculates if a role model can be created
	 * <p>
	 * returns true if:<br>
	 * (1) the target container is a diagram with a model linked
	 * @return if an role model can be created
	 */
	@Override
	public boolean canCreate(ICreateContext createContext) {
		if(UIUtil.getLinkedModelForDiagram(getDiagram()) != null) {
			return EditPolicyService.getHandler(getDiagram()).canCreate(createContext);
		}   
		return false;
	}
	
	/**
	 * creates the business objects of the role model, adds it to model of the diagram in which the role model is 
	 * created in and calls the add function for the role model
	 * <p>
	 * It creates the following structure:<br>
	 * <ul>
	 *   <li>(org.framed.iorm.model.Shape) role model</li>
	 * 	   <ul>
	 * 	     <li>(Model) model</li> 
	 * 	   </ul>
	 * </ul> 
	 * <p>
	 * It follows this steps:<br>
	 * Step 1: It creates the structure shown above.<br>
	 * Step 2: It adds the new role model to the elements of the model of the diagram in which its created.<br>
	 * Step 3: It call the add function to add the pictogram elements of the role model using a 
	 * 		   {@link AddRoleModelTypeContext}.
	 * @return the created business object of the role model
	 */
	@Override
	public Object[] create(ICreateContext createContext) {
		//Step 1
		//compartment type
		org.framed.iorm.model.Shape newRoleModel = OrmFactory.eINSTANCE.createShape();
		newRoleModel.setType(Type.COMPARTMENT_TYPE);
		String standardName = UIUtil.calculateStandardNameRoleModelWide(getDiagram(), Type.COMPARTMENT_TYPE, literals.STANDARD_NAME);
		newRoleModel.setName(standardName);
		//model
		Model compartmentsModel = OrmFactory.eINSTANCE.createModel();
		getDiagram().eResource().getContents().add(compartmentsModel);
		newRoleModel.setModel(compartmentsModel);
		
		//Step 2
		Model model = UIUtil.getLinkedModelForDiagram((Diagram) getDiagram());
		if(newRoleModel.eResource() != null) getDiagram().eResource().getContents().add(newRoleModel);
		model.getElements().add(newRoleModel);
		newRoleModel.setContainer(model);
	
		//Step 3
		AddRoleModelContext actc = new AddRoleModelContext();
		UIUtil.getAddContextForCreateShapeContext(actc, createContext);
		actc.setNewObject(newRoleModel);
		actc.setModelToLink(compartmentsModel);
		if(canAdd(actc)) add(actc);
		return new Object[] { newRoleModel };
	}
		
	//layout feature
	//~~~~~~~~~~~~~~
	/**
	 * calculates if a pictogram element of a role model can be layouted
	 * <p>
	 * returns true if:<br>
	 * (1) if exactly one pictogram element is given by the layout context
	 * (2) the business object of the pictogram element is a {@link org.framed.iorm.model.Shape} 
	 * 	   of the type {@link Type#COMPARTMENT_TYPE} 
	 * @return if the given pictogram can be layouted
	 */
	@Override
	public boolean canLayout(ILayoutContext layoutContext) {
		PictogramElement element = layoutContext.getPictogramElement();
		if(element instanceof ContainerShape) {
			EList<EObject> businessObjects = element.getLink().getBusinessObjects();
			if(businessObjects.size()==1) {
				if(businessObjects.get(0) instanceof org.framed.iorm.model.Shape) {
					org.framed.iorm.model.Shape shape = (org.framed.iorm.model.Shape) businessObjects.get(0);
					if(shape.getType() == Type.COMPARTMENT_TYPE) return true;
				}
			}
		}
		return false;
	}

    /**
	 * layout the whole role model using the following steps:
	 * <p>
	 * Step 1: Its fetches the type body shape and drop shadow shape<br>
	 * Step 2: It calculates the new height and width. It also uses this data to set
	 * 		   the size of the type body and drop shadow shape.<br>
	 * Step 3: It now iterates over all shapes of the role model:<br>
	 * (a) It sets the width of the names shape.<br>
	 * (b) It sets the points of the line that separates the name and content preview container.<br>
	 * (c) It layouts the visualization of the elements in the content preview container.
	 * <p>
	 * If its not clear what the different shapes means, see {@link #add} for reference.
	 */
	@Override
	public boolean layout(ILayoutContext layoutContext) {
		boolean layoutChanged = false;
		int newHeight, newWidth;
		Shape indicatorDotsShapeToDelete;
		ContainerShape container = (ContainerShape) layoutContext.getPictogramElement();
		//Step 1
		if(!(UIUtil.isShape_IdValue(container, literals.SHAPE_ID_COMPARTMENTTYPE_TYPEBODY))) return false;
		else {
			Rectangle typeBodyRectangle = (Rectangle) container.getGraphicsAlgorithm();
			Rectangle dropShadowRectangle = (Rectangle) container.getContainer().getChildren().get(0).getGraphicsAlgorithm();
		    //Step 2
		    if(typeBodyRectangle.getWidth() < literals.MIN_WIDTH) typeBodyRectangle.setWidth(literals.MIN_WIDTH);
		    if(typeBodyRectangle.getHeight() < literals.MIN_HEIGHT) typeBodyRectangle.setHeight(literals.MIN_HEIGHT);
			int width = typeBodyRectangle.getWidth();
		    int height = typeBodyRectangle.getHeight();
		    dropShadowRectangle.setWidth(width);
		    dropShadowRectangle.setHeight(height);
		    dropShadowRectangle.setX(typeBodyRectangle.getX()+literals.SHADOW_SIZE);
		    dropShadowRectangle.setY(typeBodyRectangle.getY()+literals.SHADOW_SIZE);
		    //Step 3    
		    for (Shape shape : container.getChildren()){
		    	GraphicsAlgorithm graphicsAlgorithm = shape.getGraphicsAlgorithm(); 
		        //(a) name shape
 		        if (graphicsAlgorithm instanceof Text) {
		        	Text text = (Text) graphicsAlgorithm;	
		        	if(UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_COMPARTMENTTYPE_NAME)) {
		        		graphicAlgorithmService.setLocationAndSize(text, 0, 0, width, literals.HEIGHT_NAME_SHAPE);
		            	layoutChanged=true;
		        }	}
		        //(b) line shapes
		        if (graphicsAlgorithm instanceof Polyline) {	
		        	Polyline polyline = (Polyline) graphicsAlgorithm;  
			        if(UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_COMPARTMENTTYPE_FIRSTLINE)) {
			        	polyline.getPoints().set(1, graphicAlgorithmService.createPoint(width, polyline.getPoints().get(1).getY()));
			        	layoutChanged=true;
			        }
			    }    
		        //attribute and operation container + elements
		        if (graphicsAlgorithm instanceof Rectangle) {
		        	Rectangle rectangle = (Rectangle) graphicsAlgorithm;  
			        //(c) content preview container
			        if(UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_COMPARTMENTTYPE_CONTENT_PREVIEW)) {
			        	//resize and positioning the container
			        	newHeight = height-literals.HEIGHT_NAME_SHAPE-2*literals.PUFFER_BETWEEN_ELEMENTS;
				        newWidth = width-2*literals.PUFFER_BETWEEN_ELEMENTS; 
				        int containerY = literals.HEIGHT_NAME_SHAPE+literals.PUFFER_BETWEEN_ELEMENTS;
				        rectangle.setHeight(newHeight);
				        rectangle.setWidth(newWidth);
				        ContainerShape elementsShape = (ContainerShape) shape;
			          	EList<Shape> elements = elementsShape.getChildren();  
			          	//set all elements visible, delete indicator dots and positions of the elements
		            	indicatorDotsShapeToDelete = null;
		            	int counter = 0;
		            	for(Shape elementShape : elements) {
			           		elementShape.setVisible(true);
			           		graphicAlgorithmService.setLocationAndSize(elementShape.getGraphicsAlgorithm(), 
			           				literals.PUFFER_BETWEEN_ELEMENTS, containerY+literals.HEIGHT_COMPARTMENT_ELEMENT_SHAPE*counter, 
			            			newWidth-2*literals.PUFFER_BETWEEN_ELEMENTS, literals.HEIGHT_COMPARTMENT_ELEMENT_SHAPE);
			           		if(UIUtil.isShape_IdValue(elementShape, literals.SHAPE_ID_ROLEMODEL_INDICATOR_DOTS))
			           			indicatorDotsShapeToDelete = elementShape;
			           		counter++;
			           	}
			           	elementsShape.getChildren().remove(indicatorDotsShapeToDelete);
			           	//check if not all elements fit in the attribute field
			           	if(elements.size()*literals.HEIGHT_COMPARTMENT_ELEMENT_SHAPE > newHeight) {	            		
			           		int fittingAttributes = (newHeight-literals.HEIGHT_COMPARTMENT_ELEMENT_SHAPE)/literals.HEIGHT_COMPARTMENT_ELEMENT_SHAPE;	   
			           		//set not fitting attributes to invisible
			           		for(int k = fittingAttributes; k<elements.size(); k++) {
			           			elements.get(k).setVisible(false);            				
			           		}	
			           		//add dots to indicate not all elements fit
			           		Shape indicatorDotsShape = pictogramElementCreateService.createShape(elementsShape, true); 
			           		Text indicatorDots = graphicAlgorithmService.createText(indicatorDotsShape, "...");
			           		indicatorDots.setForeground(manageColor(literals.COLOR_TEXT));
			           		graphicAlgorithmService.setLocationAndSize(indicatorDots, 
			           			literals.PUFFER_BETWEEN_ELEMENTS, fittingAttributes*literals.HEIGHT_COMPARTMENT_ELEMENT_SHAPE, 
			            		newWidth-2*literals.PUFFER_BETWEEN_ELEMENTS, literals.HEIGHT_COMPARTMENT_ELEMENT_SHAPE);
			            	UIUtil.setShape_IdValue(indicatorDotsShape, literals.SHAPE_ID_ROLEMODEL_INDICATOR_DOTS); 
			           	}
			           	layoutChanged = true; 
		}	}	}	}  
	    return layoutChanged;
	}
	
	//update feature
	//~~~~~~~~~~~~~~
	@Override
	public boolean canUpdate(IUpdateContext updateContext) {
		//check if object to update is a compartment
		PictogramElement pictogramElement = updateContext.getPictogramElement();
		Object businessObject =  getBusinessObjectForPictogramElement(pictogramElement);
		if(businessObject instanceof org.framed.iorm.model.Shape) {
			org.framed.iorm.model.Shape shape = (org.framed.iorm.model.Shape) businessObject;
			if(shape.getType() == Type.COMPARTMENT_TYPE &&
			   shape.getFirstSegment() == null	&&
			   shape.getSecondSegment() == null) {
				return true;
		}	}
		return false;
	}

	@Override
	public IReason updateNeeded(IUpdateContext updateContext) {
		String rawModelContainerElementName,
		       modelContainerElementName;
		PictogramElement pictogramElement = updateContext.getPictogramElement();
	
		if(UIUtil.isShape_IdValue((Shape) pictogramElement, literals.SHAPE_ID_COMPARTMENTTYPE_TYPEBODY)) {
			//model element names in model container of shape
			List<String> pictogramElementsNames = util.getContentPreviewElementsNames(pictogramElement);
			//at creation no diagram is existing so catch this
			List<String> modelElementsNames = null;
			try {
				modelElementsNames = UIUtil.getGroupingFeaturesModelElementNames(pictogramElement, getDiagram(), Type.COMPARTMENT_TYPE);
			} catch(NoDiagramFoundException e) { return Reason.createFalseReason(); }
 			
			//check for update: different names/amount in the container preview
			if(modelElementsNames.size() != pictogramElementsNames.size()) {
				return Reason.createTrueReason(literals.REASON_AMOUNT_ELEMENTS);
			}
			for(int i=0; i<modelElementsNames.size(); i++) {
				modelContainerElementName = pictogramElementsNames.get(i);
				rawModelContainerElementName = modelContainerElementName.substring(modelContainerElementName.indexOf(" ")+1);
				if(!(modelElementsNames.get(i).equals(rawModelContainerElementName))) return Reason.createTrueReason(literals.REASON_NAMES_ELEMENTS);
		}	}
		return Reason.createFalseReason();
	}
			
	@Override
	public boolean update(IUpdateContext updateContext) {
		int counter;
		boolean changed = false; 
		PictogramElement pictogramElement = updateContext.getPictogramElement();
			
		//set type name in pictogram model
	    if (pictogramElement instanceof ContainerShape) {     
	    	ContainerShape typeBodyShape = (ContainerShape) pictogramElement;
        	Diagram diagram = util.getCompartmentTypeDiagramForItsShape(typeBodyShape, getDiagram());
	        for (Shape shape : typeBodyShape.getChildren()) {
		        //set container preview texts
		        if(shape instanceof ContainerShape) {
		        	ContainerShape innerContainerShape = (ContainerShape) shape;
		        	if(innerContainerShape.getGraphicsAlgorithm() instanceof Rectangle) {
						if(UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_COMPARTMENTTYPE_CONTENT_PREVIEW)) {
			                ContainerShape modelContainerShape = (ContainerShape) shape;
				            Model compartmentModel = UIUtil.getLinkedModelForDiagram(diagram);
				            counter = 0;
			                modelContainerShape.getChildren().clear();
				            for(ModelElement modelElement : compartmentModel.getElements()) {
					            if(modelElement instanceof org.framed.iorm.model.Shape) {	
				            		Shape elementShape = pictogramElementCreateService.createShape(modelContainerShape, true);
					            	Text elementText = graphicAlgorithmService.createText(elementShape, UIUtil.getGroupingFeaturesElementText(modelElement));
					            	elementText.setForeground(manageColor(literals.COLOR_TEXT));
					            	UIUtil.setShape_IdValue(elementShape, literals.SHAPE_ID_ROLEMODEL_ELEMENT);
					            	counter=counter+1;		
				            }	}
				            changed = true;
				            layoutPictogramElement(typeBodyShape);
		} 	}	}	}	}       
	    return changed;
	}	
	
	//move feature
	//~~~~~~~~~~~~
	/**
	 * disables that the user can move the drop shadow manually
	 * <p>
	 * Its also checks if the type body shape is moved onto the drop shadow shape and allows this. There for it takes
	 * and expands some code of {@link AbstractPattern#canMoveShape}.
	 */
	@Override
	public boolean canMoveShape(IMoveShapeContext moveContext) {
		if(UIUtil.isShape_IdValue((Shape) moveContext.getPictogramElement(), literals.SHAPE_ID_COMPARTMENTTYPE_SHADOW)) {
			return false;
		}
		ContainerShape typeBodyShape = (ContainerShape) moveContext.getPictogramElement();
		ContainerShape dropShadowShape = (ContainerShape) ((ContainerShape) typeBodyShape).getContainer().getChildren().get(0);
		//copied and expanded from super.canMoveShape(IMoveShapeContext moveContext)
		return moveContext.getSourceContainer() != null && 
			   (moveContext.getSourceContainer().equals(moveContext.getTargetContainer()) ||
			   moveContext.getTargetContainer().equals(dropShadowShape)) && 
			   isPatternRoot(moveContext.getPictogramElement());
	}
		
	//move the type body and the drop shadow 
	@Override
	public void moveShape(IMoveShapeContext moveContext) {
		ContainerShape typeBodyShape = (ContainerShape) moveContext.getPictogramElement();
		Rectangle typeBodyRectangle = (Rectangle) typeBodyShape.getGraphicsAlgorithm();
		ContainerShape dropShadowShape = (ContainerShape) ((ContainerShape) typeBodyShape).getContainer().getChildren().get(0);
		Rectangle dropShadowRectangle = (Rectangle) dropShadowShape.getGraphicsAlgorithm();
			
		if(moveContext.getSourceContainer().equals(moveContext.getTargetContainer())) {
			dropShadowRectangle.setX(moveContext.getX()+literals.SHADOW_SIZE);
			dropShadowRectangle.setY(moveContext.getY()+literals.SHADOW_SIZE);
			super.moveShape(moveContext);
		} else {
			//targetContainer of moveContext is dropShadowShape
			//set targetContainer to diagram and use special calculation for the new position of type body and drop shadow 
			dropShadowRectangle.setX(typeBodyRectangle.getX()+moveContext.getX()+2*literals.SHADOW_SIZE);
			dropShadowRectangle.setY(typeBodyRectangle.getY()+moveContext.getY()+2*literals.SHADOW_SIZE);
			MoveShapeContext changedMoveContextForTypeBody = new MoveShapeContext(moveContext.getShape());
			changedMoveContextForTypeBody.setTargetContainer(dropShadowShape.getContainer());
			changedMoveContextForTypeBody.setX(typeBodyRectangle.getX()+moveContext.getX()+literals.SHADOW_SIZE);
			changedMoveContextForTypeBody.setY(typeBodyRectangle.getY()+moveContext.getY()+literals.SHADOW_SIZE);
			super.moveShape(changedMoveContextForTypeBody);
		}
	}	
	
	//resize feature
	//~~~~~~~~~~~~~~
	/**
	 * disables that the user can resize the drop shadow manually
	 */
	@Override
	public boolean canResizeShape(IResizeShapeContext resizeContext) {
		if(UIUtil.isShape_IdValue((Shape) resizeContext.getPictogramElement(), literals.SHAPE_ID_COMPARTMENTTYPE_SHADOW)) {
			return false;
		}
		return super.canResizeShape(resizeContext);
	}
			
	//delete feature
	//~~~~~~~~~~~~~~
	/**
	 * disables that the user can delete the drop shadow manually
	 */
	@Override
	public boolean canDelete(IDeleteContext deleteContext) {
		if(UIUtil.isShape_IdValue((Shape) deleteContext.getPictogramElement(), literals.SHAPE_ID_COMPARTMENTTYPE_SHADOW)) {
			return false;
		}
		return super.canDelete(deleteContext);
	}
			
	/**
	 * deletes the role model and cares about all related concerns using the following steps
	 * <p>
	 * Step 1: It deletes attached connection to it.<br>
	 * Step 2: It gets the role model diagram and creates a {@link DeleteContext} for it.<br>
	 * Step 3: It gets all compartment types that are a child of this role models to delete them as well. This is needed to be 
	 * 		   explicitly since otherwise the diagrams of the child compartments would not be deleted.<br>
	 * Step 4: It closes all editors that opened the diagram of the role model to delete.<br>
	 * Step 5: It gets the container shape of the role model, so this can be deleted instead of the type body shape.<br>
	 * Step 6: It deletes the shapes gathered in Step 2, 3 and 5. It also updates a group in which the group is in, if any.
	 * <p>
	 * If its not clear what the different shapes means, see {@link #add} for reference.
	 */
	@Override
	public void delete(IDeleteContext deleteContext) {
		List<ContainerShape> innerGroupsOrCompartmentTypesToDelete = new ArrayList<ContainerShape>();
		//Step 1
		deleteAttachedConnections(deleteContext);
		//Step 2
		Diagram compartmentDiagram = util.getCompartmentTypeDiagramForItsShape((Shape) deleteContext.getPictogramElement(), getDiagram());
		if(compartmentDiagram != null) {	
			DeleteContext deleteContextForRoleModelDiagram = new DeleteContext(compartmentDiagram);
			deleteContextForRoleModelDiagram.setMultiDeleteInfo(new MultiDeleteInfo(false, false, 0));
			//Step 3 
			for(Shape shape : compartmentDiagram.getChildren()) {
				if(shape instanceof ContainerShape) {
					for(AbstractGroupingFeatureReference reference : groupingFeatureReferences) {
						if(UIUtil.isShape_IdValue(shape, reference.getShapeIdContainer()))
							innerGroupsOrCompartmentTypesToDelete.add(UIUtil.getTypeBodyForGroupingFeaturesContainer((ContainerShape) shape, reference.getShapeIdTypebody()));
			}	}	}
			//Step 4
			IEditorReference[] openEditors = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditorReferences();
			for(IEditorReference editorReference : openEditors) {
				try {
					if(editorReference.getEditorInput() instanceof DiagramEditorInput) {
						Resource resource = UIUtil.getResourceFromEditorInput(editorReference.getEditorInput());
						Diagram diagramOfEditorInput = UIUtil.getDiagramForResourceOfDiagramEditorInput(resource);
						if(diagramOfEditorInput.getName().equals(compartmentDiagram.getName()))
							PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeEditor(editorReference.getEditor(false), false);
					}
				} catch (PartInitException e) { e.printStackTrace(); }
			}
			//Step 5 
			ContainerShape containerShape = (ContainerShape) ((ContainerShape) deleteContext.getPictogramElement()).getContainer();
			DeleteContext deleteContextForAllShapes = new DeleteContext(containerShape);
			deleteContextForAllShapes.setMultiDeleteInfo(new MultiDeleteInfo(false, false, 0));
			//Step 6 
			for(ContainerShape innerGroupOrCompartmentTypeToDelete : innerGroupsOrCompartmentTypesToDelete) {
				DeleteContext deleteContextForChildDiagram = new DeleteContext(innerGroupOrCompartmentTypeToDelete);
				deleteContextForChildDiagram.setMultiDeleteInfo(new MultiDeleteInfo(false, false, 0));
				IDeleteFeature deleteFeatureForCompartmentDiagram = getFeatureProvider().getDeleteFeature(deleteContextForChildDiagram);
				deleteFeatureForCompartmentDiagram.delete(deleteContextForChildDiagram);
			}
			super.delete(deleteContextForAllShapes);
			super.delete(deleteContextForRoleModelDiagram);
			updateContainingGroupingFeaturesObject();
		}
	}
}
