package group;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IDirectEditingInfo;
import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
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
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
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
import org.framed.iorm.ui.palette.ViewVisibility;
import org.framed.iorm.ui.references.AbstractGroupingFeatureReference;
import org.framed.iorm.ui.references.AbstractStepInReference;
import org.framed.iorm.ui.wizards.RoleModelWizard;

/**
 * This graphiti pattern class is used to work with {@link org.framed.iorm.model.Shape}s
 * of the type {@link Type#GROUP} in the editor.
 * <p>
 * It deals with the following aspects of groups:<br>
 * (1) adding a group to the diagram, especially its pictogram elements<br>
 * (2) creating the group, especially its business object<br>
 * (3) direct editing of the groups name<br>
 * (4) layout the group, especially setting lines and group elements at the right positions<br>
 * (5) updating the groups name and its content overview<br>
 * (6) moves the drop shadow with the type body and disables moving the drop shadow manually<br>
 * (7) resizes the drop shadow with the type body and disables resizing the drop shadow manually<br>
 * (8) deleting all the group pictogram elements and its diagram, also disables deleting the drop 
 *     shadow manually
 * @author Kevin Kassin
 */
public class GroupPattern extends FRaMEDShapePattern implements IPattern {
	
	/**
	 * the object to get names, id and so on for this feature
	 */
	private final Literals literals = new Literals();
	
	/**
	 * the object to call utility operations on
	 */
	private final Util util = new Util();
	
	/**
	 * the list of reference classes which save in module feature's shapes can group objects
	 * @see AbstractGroupingFeatureReference
	 */
	private final List<AbstractGroupingFeatureReference> groupingFeatureReferences; 
	
	/**
	 * the reference to the step in feature 
	 */
	private final AbstractStepInReference stepInReference = UIUtil.getStepInFeatureReference();
	
	/**
	 * the feature palette descriptor manages the palette visibility, see {@link FeaturePaletteDescriptor}
	 */
	private final FeaturePaletteDescriptor spec_FPD = new FeaturePaletteDescriptor(
			PaletteCategory.ENTITIES_CATEGORY,
			ViewVisibility.TOPLEVEL_VIEW);
	
	/**
	 * class constructor	
	 * <p>
	 * Note: It gets the references which save in which other module feature's shapes a attribute or
	 * operations can be added here and saves them it into {@link #usedInReferences}.		
	 */
	public GroupPattern() {
		super();
		FEATURE_NAME = literals.FEATURE_NAME;
		ICON_IMG_ID = literals.ICON_IMG_ID;
		ICON_IMG_PATH = literals.ICON_IMG_PATH;
		modelType = Type.GROUP;
		DIAGRAM_KIND = literals.DIAGRAM_KIND;
		FPD = spec_FPD;
		//Note
		groupingFeatureReferences = UIUtil.getGroupingFeatureReferences();
	}
	
	/**
	 * returns the double click feature of this pattern 
	 */
	@Override
	public IFeature getDoubleClickFeature(ICustomFeature[] customFeatures) {
		return (ICustomFeature) UIUtil.findFeatureByName(customFeatures, stepInReference.getStepInFeatureName());
	}
			
	/**
	 * checks if pattern is applicable for a given business object
	 * @return true, if business object is a {@link org.framed.iorm.model.Shape} of type {@link Type#GROUP}
	 */
	@Override
	public boolean isMainBusinessObjectApplicable(Object businessObject) {
		if(businessObject instanceof org.framed.iorm.model.Shape) {
			org.framed.iorm.model.Shape shape = (org.framed.iorm.model.Shape) businessObject;
			if(shape.getType() == Type.GROUP) return true;
		}
		return false;
	}

	/**
	 * checks if pattern is applicable for a given pictogram element
	 * @return true, if business object of the pictogram element is a {@link org.framed.iorm.model.Shape} of type {@link Type#GROUP}
	 */
	@Override
	protected boolean isPatternControlled(PictogramElement pictogramElement) {
		Object businessObject = getBusinessObjectForPictogramElement(pictogramElement);
		return isMainBusinessObjectApplicable(businessObject);
	}

	/**
	 * checks if the pictogram element to edit with the pattern is its root
	 * @return true, if business object of the pictogram element is a {@link org.framed.iorm.model.Shape} of type {@link Type#GROUP}
	 */
	@Override
	protected boolean isPatternRoot(PictogramElement pictogramElement) {
		Object businessObject = getBusinessObjectForPictogramElement(pictogramElement);
		return isMainBusinessObjectApplicable(businessObject);
	}

	// add features
	//~~~~~~~~~~~~~
	/**
	 * calculates if the group can be added to the diagram
	 * <p>
	 * returns true if:<br>
	 * (1) if the added business object is a group and <br>
	 * (2) if the target container is a diagram with a model linked
	 * @return if the group can be added
	 */
	@Override
	public boolean canAdd(IAddContext addContext) {
		if(addContext.getNewObject() instanceof org.framed.iorm.model.Shape) {
			org.framed.iorm.model.Shape shape = (org.framed.iorm.model.Shape) addContext.getNewObject();
			if(shape.getType()==Type.GROUP) {
				ContainerShape containerShape = getDiagram();
				if(containerShape instanceof Diagram) {
					if(UIUtil.getLinkedModelForDiagram((Diagram) containerShape) != null) {
						return EditPolicyService.getHandler(this.getDiagram()).canAdd(addContext);
		}	}	}	}
		return false;
	}

	/**
	 * adds the graphical representation of a group to the pictogram model
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
	 * 			<li>line container</li>
	 * 			  <ul><li>polyline</li></ul>
	 * 			<li>model content preview container</li>
	 * 			  <ul><li>model content preview rectangle</li></ul>
	 * 		   </ul>
	 * 	   </ul>
	 * </ul> 
	 * <p>
	 * The groups diagram will be created outside of the groups <em>container shape</em>. It can be found as child of
	 * the <em>container diagram</em> of the role model. If its not clear what <em>container diagram</em> means, see 
	 * {@link RoleModelWizard#createEmfFileForDiagram} for reference.
	 * <p>
	 * It uses follows this steps:<br>
	 * Step 1: It gets the new object, the diagram to create the group in and calculates the height 
	 * 		   and width of the groups representation.<br>
	 * Step 2: It creates the structure shown above.<br>
	 * Step 3: It sets the shape identifiers for the created graphics algorithms of the group.<br>
	 * Step 4: It links the created shapes of the group to its business objects.<br> 
	 * Step 5: It enables direct editing and layouting of the group. It also updates the group in which its
	 * 		   created, if any.
	 */
	@Override
	public PictogramElement add(IAddContext addContext) {
		//Step 1
		org.framed.iorm.model.Shape addedGroup = (org.framed.iorm.model.Shape) addContext.getNewObject();
		ContainerShape targetDiagram = getDiagram();
		int width = addContext.getWidth(), height = addContext.getHeight();
		if(addContext.getWidth() < literals.MIN_WIDTH) width = literals.MIN_WIDTH;
		if(addContext.getHeight() < literals.MIN_HEIGHT) height = literals.MIN_HEIGHT;
		
		//Step 2		
		//container shape
		ContainerShape containerShape = pictogramElementCreateService.createContainerShape(targetDiagram, false);
		
		//drop shadow shape and drop shadow rectangle
		ContainerShape dropShadowShape = pictogramElementCreateService.createContainerShape(containerShape, true);
		RoundedRectangle dropShadowRectangle = graphicAlgorithmService.createRoundedRectangle(dropShadowShape, literals.GROUP_CORNER_RADIUS, literals.GROUP_CORNER_RADIUS);
		dropShadowRectangle.setForeground(manageColor(literals.COLOR_SHADOW));
		dropShadowRectangle.setBackground(manageColor(literals.COLOR_SHADOW));
		graphicAlgorithmService.setLocationAndSize(dropShadowRectangle, addContext.getX()+literals.SHADOW_SIZE, addContext.getY()+literals.SHADOW_SIZE, width, height);
		
		//type body shape and type body shape rectangle
		ContainerShape typeBodyShape = pictogramElementCreateService.createContainerShape(containerShape, true);	
		pictogramElementCreateService.createChopboxAnchor(typeBodyShape);
		RoundedRectangle typeBodyRectangle = graphicAlgorithmService.createRoundedRectangle(typeBodyShape, literals.GROUP_CORNER_RADIUS, literals.GROUP_CORNER_RADIUS);
		typeBodyRectangle.setForeground(manageColor(literals.COLOR_LINES));
		typeBodyRectangle.setBackground(manageColor(literals.COLOR_BACKGROUND));
		graphicAlgorithmService.setLocationAndSize(typeBodyRectangle, addContext.getX(), addContext.getY(), width, height);
		
		//name container and name text
		Shape nameShape = pictogramElementCreateService.createShape(typeBodyShape, false);
		Text text = graphicAlgorithmService.createText(nameShape, addedGroup.getName());	
		text.setForeground(manageColor(literals.COLOR_TEXT));	
		text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);	
		graphicAlgorithmService.setLocationAndSize(text, 0, 0, width, literals.HEIGHT_NAME_SHAPE);	
		
		//line container and polyline
		Shape firstLineShape = pictogramElementCreateService.createShape(typeBodyShape, false);
		Polyline firstPolyline = graphicAlgorithmService.createPolyline(firstLineShape, new int[] {0, literals.HEIGHT_NAME_SHAPE, width, literals.HEIGHT_NAME_SHAPE});
		firstPolyline.setForeground(manageColor(literals.COLOR_LINES));		
	
		//model content preview container
		ContainerShape modelContainer = pictogramElementCreateService.createContainerShape(typeBodyShape, false);
		Rectangle modelRectangle = graphicAlgorithmService.createRectangle(modelContainer);
		modelRectangle.setLineVisible(false);
		modelRectangle.setBackground(manageColor(literals.COLOR_BACKGROUND));
		graphicAlgorithmService.setLocationAndSize(modelRectangle, literals.PUFFER_BETWEEN_ELEMENTS, literals.HEIGHT_NAME_SHAPE+literals.PUFFER_BETWEEN_ELEMENTS, 
												   width-2*literals.PUFFER_BETWEEN_ELEMENTS, height-literals.GROUP_CORNER_RADIUS);
		
		//groups diagram
		Diagram contentDiagram = pictogramElementCreateService.createDiagram(UILiterals.DIAGRAM_TYPE_ID, addedGroup.getName(), 10, true);
		UIUtil.setDiagram_KindValue(contentDiagram, literals.DIAGRAM_KIND);
		AddGroupContext agctc = (AddGroupContext) addContext;
		link(contentDiagram, agctc.getModelToLink());
		getDiagram().getContainer().getChildren().add(contentDiagram);
		
		//Step 3
		UIUtil.setShape_IdValue(containerShape, literals.SHAPE_ID_GROUP_CONTAINER);
		UIUtil.setShape_IdValue(typeBodyShape, literals.SHAPE_ID_GROUP_TYPEBODY);
		UIUtil.setShape_IdValue(dropShadowShape, literals.SHAPE_ID_GROUP_SHADOW);
		UIUtil.setShape_IdValue(nameShape, literals.SHAPE_ID_GROUP_NAME);
		UIUtil.setShape_IdValue(firstLineShape, literals.SHAPE_ID_GROUP_LINE);
		UIUtil.setShape_IdValue(modelContainer, literals.SHAPE_ID_GROUP_CONTENT_PREVIEW);
		
		//Step 4
		link(containerShape, addedGroup);
		link(typeBodyShape, addedGroup);
		link(dropShadowShape, addedGroup);
		link(nameShape, addedGroup);
		link(firstLineShape, addedGroup);
		link(modelContainer, addedGroup);
				
		//Step 5
		getFeatureProvider().getDirectEditingInfo().setActive(true);
		IDirectEditingInfo directEditingInfo = getFeatureProvider().getDirectEditingInfo();
		directEditingInfo.setMainPictogramElement(typeBodyShape);
		directEditingInfo.setPictogramElement(nameShape);
		directEditingInfo.setGraphicsAlgorithm(text);
		layoutPictogramElement(containerShape);
		updateContainingGroupingFeaturesObject();
		return containerShape;
	}
		
	//create feature
	//~~~~~~~~~~~~~~
	/**
	 * calculates if a group can be created
	 * <p>
	 * returns true if:<br>
	 * (1) the target container is a diagram with a model linked
	 * @return if an group can be created
	 */
	@Override
	public boolean canCreate(ICreateContext createContext) {
		if(UIUtil.getLinkedModelForDiagram(getDiagram()) != null) {
		   return EditPolicyService.getHandler(this.getDiagram()).canCreate(createContext);
		}   
		return false;
	}

	/**
	 * creates the business objects of the group, adds it to model of the diagram in which the group is 
	 * created in and calls the add function for the group
	 * <p>
	 * It creates the following structure:<br>
	 * <ul>
	 *   <li>(org.framed.iorm.model.Shape) group</li>
	 * 	   <ul>
	 * 	     <li>(Model) group model</li> 
	 * 	   </ul>
	 * </ul> 
	 * <p>
	 * It follows this steps:<br>
	 * Step 1: It creates the structure shown above.<br>
	 * Step 2: It adds the new group to the elements of the model of the diagram in which its created.<br>
	 * Step 3: It call the add function to add the pictogram elements of the group using a 
	 * 		   {@link AddGroupOrCompartmentTypeContext}.
	 * @return the created business object of the group
	 */
	@Override
	public Object[] create(ICreateContext createContext) {
		//Step 1
		//group
		org.framed.iorm.model.Shape newGroup = OrmFactory.eINSTANCE.createShape();
		newGroup.setType(Type.GROUP);
		String standardName = UIUtil.calculateStandardNameRoleModelWide(getDiagram(), Type.GROUP, literals.STANDARD_NAME);
		newGroup.setName(standardName);
		//model
		Model groupModel = OrmFactory.eINSTANCE.createModel();
		getDiagram().eResource().getContents().add(groupModel);
		newGroup.setModel(groupModel);
		
		//Step 2
		Model model = UIUtil.getLinkedModelForDiagram((Diagram) getDiagram());
		if(newGroup.eResource() != null) getDiagram().eResource().getContents().add(newGroup);
		model.getElements().add(newGroup);
		newGroup.setContainer(model);
				
		//Step 3
		AddGroupContext agctc = new AddGroupContext();
		UIUtil.getAddContextForCreateShapeContext(agctc, createContext);
		agctc.setNewObject(newGroup);
		agctc.setModelToLink(groupModel);
		if(canAdd(agctc)) add(agctc);
		return new Object[] { newGroup };	
	}
	
	//direct editing
	//~~~~~~~~~~~~~~	
	/**
	 * sets the editing type as a text field for the direct editing of the attributes or operations name
	 */
	@Override
	public int getEditingType() {
		return TYPE_TEXT;
	}
		
	/**
	 * calculates if a pictogram element of a group can be direct edited
	 * <p>
	 * returns true if:<br>
	 * (1) the business object of the pictogram element is a {@link org.framed.iorm.model.Shape} 
	 * 	   of the type {@link Type#GROUP} and<br>
	 * (2) the graphics algorithm of the pictogram element is a {@link Text}
	 * @return if the selected pictogram can be direct edited
	 */
	@Override
	public boolean canDirectEdit(IDirectEditingContext editingContext) {
		Object businessObject = getBusinessObject(editingContext);
		GraphicsAlgorithm graphicsAlgorithm = editingContext.getGraphicsAlgorithm();
		if(businessObject instanceof org.framed.iorm.model.Shape && graphicsAlgorithm instanceof Text) {
			org.framed.iorm.model.Shape shape = (org.framed.iorm.model.Shape) businessObject;
			if(shape.getType() == Type.GROUP) {
				return true;
		}	}
		return false;
	}

	/**
	 * returns the current groups name as initial value for direct editing
	 */
	@Override
	public String getInitialValue(IDirectEditingContext editingContext) {
		org.framed.iorm.model.Shape group = (org.framed.iorm.model.Shape) getBusinessObject(editingContext);
		return group.getName();
	}
		
	/**
	 * calculates if a chosen value for the groups name is valid
	 * <p>
	 * A valid value is a specific form checked by {@link NameUtil#matchesIdentifier} and is not already
	 * chosen for another group. This is checked by {@link NameUtil#nameAlreadyUsedForClassOrRole}.
	 * @return if a chosen value for the groups name is valid
	 */
	@Override
	public String checkValueValid(String newName, IDirectEditingContext editingContext) {
		if(getInitialValue(editingContext).contentEquals(newName)) return null;
		if(!(UIUtil.matchesIdentifier(newName))) return literals.DIRECTEDITING_GROUP;
		if(UIUtil.nameAlreadyUsedRoleModelWide(getDiagram(), Type.GROUP, newName)) 
			return literals.NAME_ALREADY_USED_GROUP;
	    return null;
	}
		
	/**
	 * sets value of the groups name, updates its own pictogram element and a group in which its in, if any
	 */
	@Override
	public void setValue(String value, IDirectEditingContext editingContext) {	     
		org.framed.iorm.model.Shape group = (org.framed.iorm.model.Shape) getBusinessObject(editingContext);
		group.setName(value);
		updatePictogramElement(((Shape) editingContext.getPictogramElement()).getContainer());
		updateContainingGroupingFeaturesObject();
	}
		
	//layout feature
	//~~~~~~~~~~~~~~
	/**
	 * calculates if a pictogram element of a group can be layouted
	 * <p>
	 * returns true if:<br>
	 * (1) if exactly one pictogram element is given by the layout context
	 * (2) the business object of the pictogram element is a {@link org.framed.iorm.model.Shape} 
	 * 	   of the type {@link Type#GROUP} 
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
					if(shape.getType() == Type.GROUP) return true;
		}	}	}
		return false;
	}

	/**
	 * layout the whole group using the following steps:
	 * <p>
	 * Step 1: Its fetches the type body shape and drop shadow shape<br>
	 * Step 2: It calculates the new height, width and horizontal center. It also uses this data to set
	 * 		   the size of the type body and drop shadow shape.<br>
	 * Step 3: It now iterates over all shapes of the natural type:<br>
	 * (a) It sets the width of the names shape.<br>
	 * (b) It sets the points of the line that separates the name and content preview container.<br>
	 * (c) It layouts the visualization of the elements in the content preview container.
	 * <p>
	 * If its not clear what the different shapes means, see {@link #add} for reference.
	 */
	@Override
	public boolean layout(ILayoutContext layoutContext) {	
		boolean layoutChanged = false;
		ContainerShape container = (ContainerShape) layoutContext.getPictogramElement();
		//Step 1
		if(!(UIUtil.isShape_IdValue(container, literals.SHAPE_ID_GROUP_TYPEBODY))) return false;
		else {
			RoundedRectangle typeBodyRectangle = (RoundedRectangle) container.getGraphicsAlgorithm(); 
			RoundedRectangle dropShadowRectangle = (RoundedRectangle) container.getContainer().getChildren().get(0).getGraphicsAlgorithm();
			//Step 2
			if(typeBodyRectangle.getWidth() < literals.MIN_WIDTH) typeBodyRectangle.setWidth(literals.MIN_WIDTH);
			if(typeBodyRectangle.getHeight() < literals.MIN_HEIGHT) typeBodyRectangle.setHeight(literals.MIN_HEIGHT);
			int containerWidth = typeBodyRectangle.getWidth();
		    int containerHeight = typeBodyRectangle.getHeight();
		    dropShadowRectangle.setWidth(containerWidth);
		    dropShadowRectangle.setHeight(containerHeight);
		    dropShadowRectangle.setX(typeBodyRectangle.getX()+literals.SHADOW_SIZE);
		    dropShadowRectangle.setY(typeBodyRectangle.getY()+literals.SHADOW_SIZE);
		    //Step 3    
		    for (Shape shape : container.getChildren()){
		    	GraphicsAlgorithm graphicsAlgorithm = shape.getGraphicsAlgorithm();                         	                 
		        //(a) name shape
		        if (graphicsAlgorithm instanceof Text) {
		        	Text text = (Text) graphicsAlgorithm;	
		            if(UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_GROUP_NAME)) {
		            	graphicAlgorithmService.setLocationAndSize(text, 0, 0, containerWidth, literals.HEIGHT_NAME_SHAPE);
		            	layoutChanged=true;
		        }	}
		        ///(b) line
		        if (graphicsAlgorithm instanceof Polyline) {	   
		        	Polyline polyline = (Polyline) graphicsAlgorithm;  
		        	if(UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_GROUP_LINE)) {
			            polyline.getPoints().set(1, graphicAlgorithmService.createPoint(containerWidth, polyline.getPoints().get(1).getY()));
			            layoutChanged=true;
			    }	}
		        if (graphicsAlgorithm instanceof Rectangle) {
		        	Rectangle rectangle = (Rectangle) graphicsAlgorithm; 
		        	//(c) content preview container
			        if(UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_GROUP_CONTENT_PREVIEW)) {
			        	//resize and positioning the container
			        	int newHeight = (containerHeight-literals.GROUP_CORNER_RADIUS),
			            	newWidth = (containerWidth-2*literals.PUFFER_BETWEEN_ELEMENTS);            				
			        	rectangle.setHeight(newHeight);
			            rectangle.setWidth(newWidth);
			            ContainerShape groupElementsShape = (ContainerShape) shape;
		            	EList<Shape> groupElements = groupElementsShape.getChildren();  
		            	//set all elements visible, delete indicator dots and positions of the elements
		            	Shape indicatorDotsShapeToDelete = null;
		            	int counter = 0;
		            	for(Shape elementShape : groupElements) {
		            		elementShape.setVisible(true);
		            		graphicAlgorithmService.setLocationAndSize(elementShape.getGraphicsAlgorithm(), 
		            				literals.PUFFER_BETWEEN_ELEMENTS, literals.HEIGHT_NAME_SHAPE+literals.PUFFER_BETWEEN_ELEMENTS+literals.HEIGHT_GROUP_ELEMENT_SHAPE*counter, 
			            			newWidth-2*literals.PUFFER_BETWEEN_ELEMENTS, literals.HEIGHT_GROUP_ELEMENT_SHAPE);
		            		if(UIUtil.isShape_IdValue(elementShape, literals.SHAPE_ID_GROUPS_INDICATOR_DOTS))
		            			indicatorDotsShapeToDelete = elementShape;
		            		counter++;
		            	}
		            	groupElementsShape.getChildren().remove(indicatorDotsShapeToDelete);
		            	//check if not all elements fit in the attribute field
		            	if(groupElements.size()*literals.HEIGHT_GROUP_ELEMENT_SHAPE > newHeight) {	            		
		            		int fittingAttributes = (newHeight-literals.HEIGHT_GROUP_ELEMENT_SHAPE)/literals.HEIGHT_GROUP_ELEMENT_SHAPE;	   
		            		//set not fitting elements invisible
		            		for(int k = fittingAttributes; k<groupElements.size(); k++) {
		            			groupElements.get(k).setVisible(false);            				
		            		}	
		            		//add dots to indicate that not all elements fit
		            		Shape indicatorDotsShape = pictogramElementCreateService.createShape(groupElementsShape, true); 
		            		Text indicatorDots = graphicAlgorithmService.createText(indicatorDotsShape, "...");
		            		indicatorDots.setForeground(manageColor(literals.COLOR_TEXT));
		            		graphicAlgorithmService.setLocationAndSize(indicatorDots, 
		            				literals.PUFFER_BETWEEN_ELEMENTS, literals.HEIGHT_NAME_SHAPE+fittingAttributes*literals.HEIGHT_GROUP_ELEMENT_SHAPE, 
		            				newWidth-2*literals.PUFFER_BETWEEN_ELEMENTS, literals.HEIGHT_GROUP_ELEMENT_SHAPE);
		            		UIUtil.setShape_IdValue(indicatorDotsShape, literals.SHAPE_ID_GROUPS_INDICATOR_DOTS); 
		            	}
		            	layoutChanged = true;
		}   } 	}	}        
	    return layoutChanged;
	}

	//update feature
	//~~~~~~~~~~~~~~
	@Override
	public boolean canUpdate(IUpdateContext updateContext) {
		//check if object to update is a group
		PictogramElement pictogramElement = updateContext.getPictogramElement();
		Object businessObject =  getBusinessObjectForPictogramElement(pictogramElement);
		if(businessObject instanceof org.framed.iorm.model.Shape) {
			org.framed.iorm.model.Shape shape = (org.framed.iorm.model.Shape) businessObject;
			if(shape.getType() == Type.GROUP) {
				return true;
		}	}
		return false;
	}

	@Override
	public IReason updateNeeded(IUpdateContext updateContext) {
		String rawModelContainerElementName,
			   modelContainerElementName;
		PictogramElement pictogramElement = updateContext.getPictogramElement();
		
		if(UIUtil.isShape_IdValue((Shape) pictogramElement, literals.SHAPE_ID_GROUP_TYPEBODY)) {
			//pictogram name of natural type, attributes and operations
			String pictogramTypeName = util.getNameOfPictogramElement(pictogramElement);
			//business name and attributes
			String businessTypeName = UIUtil.getNameOfBusinessObject(getBusinessObjectForPictogramElement(pictogramElement));
			//model element names in groups model
			//at creation no diagram is existing so catch this
			List<String> modelElementsNames = null;
			try {
				modelElementsNames = UIUtil.getGroupingFeaturesModelElementNames(pictogramElement, getDiagram(), Type.GROUP);
			} catch(NoDiagramFoundException e) { return Reason.createFalseReason(); }
 			//model element names in model container of shape
			List<String> pictogramElementsNames = util.getContentPreviewElementsNames(pictogramElement);		
				
			//check for update: different names, different amount of attibutes/ operations
			if(pictogramTypeName==null || businessTypeName==null) return Reason.createTrueReason(literals.REASON_NAME_NULL);
			if(!(pictogramTypeName.equals(businessTypeName))) return Reason.createTrueReason(literals.REASON_NAME_OUT_OF_DATE);
			if(modelElementsNames.size() != pictogramElementsNames.size()) return Reason.createTrueReason(literals.REASON_AMOUNT_ELEMENTS);
			for(int i=0; i<modelElementsNames.size(); i++) {
				modelContainerElementName = pictogramElementsNames.get(i);
				rawModelContainerElementName = modelContainerElementName.substring(modelContainerElementName.indexOf(" ")+1);
				if(!(modelElementsNames.get(i).equals(rawModelContainerElementName))) return Reason.createTrueReason(literals.REASON_NAMES_ELEMENTS);
		}	}
		return Reason.createFalseReason();
	}
		
	@Override
	public boolean update(IUpdateContext updateContext) {
		boolean changed = false;
	         
		PictogramElement pictogramElement = updateContext.getPictogramElement();
		String businessTypeName = UIUtil.getNameOfBusinessObject(getBusinessObjectForPictogramElement(pictogramElement));
			
		//set type name in pictogram model
	    if (pictogramElement instanceof ContainerShape) {     
	    	ContainerShape typeBodyShape = (ContainerShape) pictogramElement;
        	Diagram diagram = util.getGroupDiagramForItsShape(typeBodyShape, getDiagram());
	        for (Shape shape : typeBodyShape.getChildren()) {
	        	if (shape.getGraphicsAlgorithm() instanceof Text) {
	        		Text text = (Text) shape.getGraphicsAlgorithm();
	                if(UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_GROUP_NAME)) {
	                    //change diagram name
	                	diagram.setName(businessTypeName);
	                	//change group name
	                	text.setValue(businessTypeName);
	                	changed = true;
	                }
	        	}    
	        	if (shape.getGraphicsAlgorithm() instanceof Rectangle) {  
	        		if(UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_GROUP_CONTENT_PREVIEW)) {
		                ContainerShape modelContainerShape = (ContainerShape) shape;
			            Model groupModel = UIUtil.getLinkedModelForDiagram(diagram);
		             
		                modelContainerShape.getChildren().clear();
			            for(ModelElement modelElement : groupModel.getElements()) {
			            	Shape groupElementShape = pictogramElementCreateService.createShape(modelContainerShape, true);
			            	Text groupElementText = graphicAlgorithmService.createText(groupElementShape, UIUtil.getGroupingFeaturesElementText(modelElement));
			            	groupElementText.setForeground(manageColor(literals.COLOR_TEXT));
			            	UIUtil.setShape_IdValue(groupElementShape, literals.SHAPE_ID_GROUP_ELEMENT);
			            }
			            changed = true;
			            layoutPictogramElement(typeBodyShape);
	   }	}	}	}     
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
		if(UIUtil.isShape_IdValue((Shape) moveContext.getPictogramElement(), literals.SHAPE_ID_GROUP_SHADOW)) {
			return false;
		}
		ContainerShape typeBodyShape = (ContainerShape) moveContext.getPictogramElement();
		ContainerShape dropShadowShape = (ContainerShape) ((ContainerShape) typeBodyShape).getContainer().getChildren().get(0);
		return moveContext.getSourceContainer() != null && 
			  (moveContext.getSourceContainer().equals(moveContext.getTargetContainer()) ||
			   moveContext.getTargetContainer().equals(dropShadowShape)) && 
			   isPatternRoot(moveContext.getPictogramElement());
	}
		
	//move the type body and the drop shadow 
	@Override
	public void moveShape(IMoveShapeContext moveContext) {
		ContainerShape typeBodyShape = (ContainerShape) moveContext.getPictogramElement();
		RoundedRectangle typeBodyRectangle = (RoundedRectangle) typeBodyShape.getGraphicsAlgorithm();
		ContainerShape dropShadowShape = (ContainerShape) ((ContainerShape) typeBodyShape).getContainer().getChildren().get(0);
		RoundedRectangle dropShadowRectangle = (RoundedRectangle) dropShadowShape.getGraphicsAlgorithm();
			
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
	}	}
		
	//resize feature
	//~~~~~~~~~~~~~~
	/**
	 * disables that the user can resize the drop shadow manually
	 */
	@Override
	public boolean canResizeShape(IResizeShapeContext resizeContext) {
		if(UIUtil.isShape_IdValue((Shape) resizeContext.getPictogramElement(), literals.SHAPE_ID_GROUP_SHADOW)) {
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
		if(UIUtil.isShape_IdValue((Shape) deleteContext.getPictogramElement(), literals.SHAPE_ID_GROUP_SHADOW)) {
			return false;
		}
		return super.canDelete(deleteContext);
	}
			
	/**
	 * deletes the group as cares about all related concerns using the following steps
	 * <p>
	 * Step 1: It gets the groups diagram and creates a {@link DeleteContext} for it.<br>
	 * Step 2: It gets all groups and compartment types that are a child of this group to delete them as well. This is needed to be 
	 * 		   explicitly since otherwise the diagrams of the child groups would not be deleted.<br>
	 * Step 3: It closes all editors that opened the diagram of this group to delete.<br>
	 * Step 4: It gets the container shape of the group, so this can be deleted instead of the type body shape.<br>
	 * Step 5: It deletes the shapes gathered in Step 1, 2 and 4. It also updates a group in which the group is in, if any.
	 * <p>
	 * If its not clear what the different shapes means, see {@link #add} for reference.
	 */
	@Override
	public void delete(IDeleteContext deleteContext) {
		List<ContainerShape> innerGroupsOrCompartmentTypesToDelete = new ArrayList<ContainerShape>();
		//Step 1
		Diagram groupDiagram = util.getGroupDiagramForItsShape((Shape) deleteContext.getPictogramElement(), getDiagram());
		if(groupDiagram != null) {	
			DeleteContext deleteContextForGroupDiagram = new DeleteContext(groupDiagram);
			deleteContextForGroupDiagram.setMultiDeleteInfo(new MultiDeleteInfo(false, false, 0));
			//Step 2
			for(Shape shape : groupDiagram.getChildren()) {
				if(shape instanceof ContainerShape) {
					for(AbstractGroupingFeatureReference reference : groupingFeatureReferences) {
						if(UIUtil.isShape_IdValue(shape, reference.getShapeIdContainer())) {
							innerGroupsOrCompartmentTypesToDelete.add(UIUtil.getTypeBodyForGroupingFeaturesContainer((ContainerShape) shape, reference.getShapeIdTypebody()));
						}
					}	
			}	}
			//Step 3
			IEditorReference[] openEditors = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditorReferences();
			for(IEditorReference editorReference : openEditors) {
				try {
					if(editorReference.getEditorInput() instanceof DiagramEditorInput) {
						Resource resource = UIUtil.getResourceFromEditorInput(editorReference.getEditorInput());
						Diagram diagramOfEditorInput = UIUtil.getDiagramForResourceOfDiagramEditorInput(resource);
						if(diagramOfEditorInput.getName().equals(groupDiagram.getName()))
							PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeEditor(editorReference.getEditor(false), false);
					}
				} catch (PartInitException e) { e.printStackTrace(); }
			}
			//Step 4
			ContainerShape containerShape = (ContainerShape) ((ContainerShape) deleteContext.getPictogramElement()).getContainer();
			DeleteContext deleteContextForAllShapes = new DeleteContext(containerShape);
			deleteContextForAllShapes.setMultiDeleteInfo(new MultiDeleteInfo(false, false, 0));
			//Step 5
			for(ContainerShape innerGroupOrCompartmentTypeToDelete : innerGroupsOrCompartmentTypesToDelete) {
				DeleteContext deleteContextForChildDiagram = new DeleteContext(innerGroupOrCompartmentTypeToDelete);
				deleteContextForChildDiagram.setMultiDeleteInfo(new MultiDeleteInfo(false, false, 0));
				IDeleteFeature deleteFeatureForCompartmentDiagram = getFeatureProvider().getDeleteFeature(deleteContextForChildDiagram);
				deleteFeatureForCompartmentDiagram.delete(deleteContextForChildDiagram);	
			}	
			super.delete(deleteContextForAllShapes);
			super.delete(deleteContextForGroupDiagram);
			updateContainingGroupingFeaturesObject();
	}	}
}
