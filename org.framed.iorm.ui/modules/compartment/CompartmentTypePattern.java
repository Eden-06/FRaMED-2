package compartment;

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
import org.framed.iorm.model.Segment;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.FRaMEDShapePattern;
import org.framed.iorm.ui.editPolicy.EditPolicyService;
import org.framed.iorm.ui.exceptions.NoDiagramFoundException;
import org.framed.iorm.ui.literals.UILiterals;
import org.framed.iorm.ui.palette.FeaturePaletteDescriptor;
import org.framed.iorm.ui.palette.PaletteCategory;
import org.framed.iorm.ui.palette.PaletteView;
import org.framed.iorm.ui.palette.ViewVisibility;
import org.framed.iorm.ui.util.UIUtil;
import org.framed.iorm.ui.wizards.RoleModelWizard;

import compartment.references.AbstractInnerGroupingReference;
import compartment.references.AttributeAndOperationsReference;
import compartment.references.StepInReference;

/**
 * This graphiti pattern class is used to work with {@link org.framed.iorm.model.Shape}s
 * of the type {@link Type#COMPARTMENT_TYPE} in the editor.
 * <p>
 * It deals with the following aspects of compartment types:<br>
 * (1) adding a compartment type to the diagram, especially its pictogram elements<br>
 * (2) creating the compartment type, especially its business object<br>
 * (3) direct editing of the compartment types name<br>
 * (4) layout the group, especially setting lines, attributes, operations and  group elements at the right positions<br>
 * (5) updating the groups name, attributes, operations and its content overview<br>
 * (6) moves the drop shadow with the type body and disables moving the drop shadow manually<br>
 * (7) resizes the drop shadow with the type body and disables resizing the drop shadow manually<br>
 * (8) deleting all the compartments pictogram elements and its diagram, also disables deleting the drop 
 *     shadow manually
 * @author Kevin Kassin
 */
public class CompartmentTypePattern extends FRaMEDShapePattern implements IPattern {

	/**
	 * the object to get names, ids and so on for this feature
	 */
	private final Literals literals = new Literals();
	
	/**
	 * the object to call utility operations on
	 */
	private final Util util = new Util();
	
	//TODO doku
	private final StepInReference stepInReference = new StepInReference();
	
	/**
	 * a reference class which encapsulates the dependency to the attribute and operation features
	 */
	private final AttributeAndOperationsReference attOpsReference = new AttributeAndOperationsReference();
	
	/**
	 * the list of reference classes which save in which other module feature's shapes a attribute or
	 * operation can be added with specific informations for these.
	 * @see AbstractUsedInReference
	 */
	private List<AbstractInnerGroupingReference> innerGroupingReferences;
	
	/**
	 * the feature palette descriptor manages the palette visibility, see {@link FeaturePaletteDescriptor}
	 */	
	private final FeaturePaletteDescriptor spec_FPD = new FeaturePaletteDescriptor(
		PaletteCategory.ENTITIES_CATEGORY,
		ViewVisibility.ALL_VIEWS) {
			@Override
			public boolean featureExpression(List<String> framedFeatureNames, PaletteView paletteView) {
				switch(paletteView) {
					case TOPLEVEL_VIEW: return framedFeatureNames.contains("Compartment_Types");
					case COMPARTMENT_VIEW: return framedFeatureNames.contains("Contains_Compartments");
					default: return false;
		}	}	};
	
	/**
	 * class constructor		
	 */
	public CompartmentTypePattern() {
		super();
		FEATURE_NAME = literals.FEATURE_NAME;
		ICON_IMG_ID = literals.ICON_IMG_ID;
		ICON_IMG_PATH = literals.ICON_IMG_PATH;
		modelType = Type.COMPARTMENT_TYPE;
		FPD = spec_FPD;
		//Note
		List<Class<?>> classes = UIUtil.findModuleJavaClasses();
		innerGroupingReferences = util.getUsedInReferences(classes);
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
	 * @return true, if business object is a {@link org.framed.iorm.model.Shape} of type {@link Type#COMPARTMENT_TYPE}
	 */
	@Override
	public boolean isMainBusinessObjectApplicable(Object businessObject) {
		if(businessObject instanceof org.framed.iorm.model.Shape) {
			org.framed.iorm.model.Shape shape = (org.framed.iorm.model.Shape) businessObject;
			if(shape.getType() == Type.COMPARTMENT_TYPE) return true;
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
	 * calculates if the compartment type can be added to the diagram
	 * <p>
	 * returns true if:<br>
	 * (1) if the added business object is a compartment type and <br>
	 * (2) if the target container is a diagram with a model linked
	 * @return if the compartment type can be added
	 */
	@Override
	public boolean canAdd(IAddContext addContext) {
		if(addContext.getNewObject() instanceof org.framed.iorm.model.Shape) {
			org.framed.iorm.model.Shape shape = (org.framed.iorm.model.Shape) addContext.getNewObject();
			if(shape.getType()==Type.COMPARTMENT_TYPE) {
				if(UIUtil.getLinkedModelForDiagram(getDiagram()) != null) {
					   return true && EditPolicyService.canAdd(addContext, this.getDiagram());
		}	}	}
		return false;
	}
	
	/**
	 * adds the graphical representation of a compartment type to the pictogram model
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
	 * 			<li>attribute container shape</li>
	 * 			  <ul><li>attribute container rectangle</li></ul>
	 * 			<li>second line container</li>
	 * 			  <ul><li>second polyline</li></ul>
	 * 			<li>operation container shape</li>
	 * 			  <ul><li>operation container rectangle</li></ul>
	 * 			<li>third line container</li>
	 * 			  <ul><li>third polyline</li></ul>
	 * 			<li>model content preview container</li>
	 * 			  <ul><li>model content preview rectangle</li></ul>
	 * 		   </ul>
	 * 	   </ul>
	 * </ul> 
	 * <p>
	 * The compartment types diagram will be created outside of the compartment types <em>container shape</em>. It can be 
	 * found as child of the <em>container diagram</em> of the role model. If its not clear what <em>container diagram</em> 
	 * means, see {@link RoleModelWizard#createEmfFileForDiagram} for reference.
	 * <p>
	 * It uses follows this steps:<br>
	 * Step 1: It gets the new object, the diagram to create the compartment type in and calculates the height and width 
	 * 		   of the natural types representation.<br>
	 * Step 2: It creates the structure shown above.<br>
	 * Step 3: It sets the shape identifiers for the created graphics algorithms of the compartment type.<br>
	 * Step 4: It links the created shapes of the group to its business objects.<br> 
	 * Step 5: It enables direct editing, anchors and layouting of the compartment type. It also updates the group in which 
	 * 		   its created, if any.
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
				
		//attribute container
		ContainerShape attributeContainer = pictogramElementCreateService.createContainerShape(typeBodyShape, false);
		Rectangle attributeRectangle = graphicAlgorithmService.createRectangle(attributeContainer);
		attributeRectangle.setLineVisible(false);
		attributeRectangle.setBackground(manageColor(literals.COLOR_BACKGROUND));
		int horizontalFirstThird = util.calculateHorizontaltFirstThird(height);
		graphicAlgorithmService.setLocationAndSize(attributeRectangle, literals.PUFFER_BETWEEN_ELEMENTS, literals.HEIGHT_NAME_SHAPE+literals.PUFFER_BETWEEN_ELEMENTS, 
												   width-2*literals.PUFFER_BETWEEN_ELEMENTS, horizontalFirstThird-literals.HEIGHT_NAME_SHAPE-2*literals.PUFFER_BETWEEN_ELEMENTS);
		//second line
		Shape secondLineShape = pictogramElementCreateService.createShape(typeBodyShape, false);	
		Polyline secondPolyline = graphicAlgorithmService.createPolyline(secondLineShape, new int[] {0, horizontalFirstThird, width, horizontalFirstThird});
		secondPolyline.setForeground(manageColor(literals.COLOR_LINES));
				
		//operation container
		ContainerShape operationContainer = pictogramElementCreateService.createContainerShape(typeBodyShape, false);
		Rectangle operationRectangle = graphicAlgorithmService.createRectangle(operationContainer);
		operationRectangle.setLineVisible(false);
		operationRectangle.setBackground(manageColor(literals.COLOR_BACKGROUND));
		graphicAlgorithmService.setLocationAndSize(operationRectangle, literals.PUFFER_BETWEEN_ELEMENTS, horizontalFirstThird+literals.PUFFER_BETWEEN_ELEMENTS, 
											 	   width-2*literals.PUFFER_BETWEEN_ELEMENTS, horizontalFirstThird-literals.HEIGHT_NAME_SHAPE-2*literals.PUFFER_BETWEEN_ELEMENTS);
		
		//third line
		Shape thirdLineShape = pictogramElementCreateService.createShape(typeBodyShape, false);	
		int horizontalSecondThird = util.calculateHorizontaltSecondThird(height);
		Polyline thirdPolyline = graphicAlgorithmService.createPolyline(thirdLineShape, new int[] {0, horizontalSecondThird, width, horizontalSecondThird});
		thirdPolyline.setForeground(manageColor(literals.COLOR_LINES));
			
		//model content preview container
		ContainerShape modelContainer = pictogramElementCreateService.createContainerShape(typeBodyShape, false);
		Rectangle modelRectangle = graphicAlgorithmService.createRectangle(modelContainer);
		modelRectangle.setLineVisible(false);
		modelRectangle.setBackground(manageColor(literals.COLOR_BACKGROUND));
		graphicAlgorithmService.setLocationAndSize(modelRectangle, literals.PUFFER_BETWEEN_ELEMENTS, horizontalSecondThird+literals.PUFFER_BETWEEN_ELEMENTS, 
												   width-2*literals.PUFFER_BETWEEN_ELEMENTS, horizontalFirstThird-literals.HEIGHT_NAME_SHAPE-2*literals.PUFFER_BETWEEN_ELEMENTS);	
		
		//groups diagram
		Diagram contentDiagram = pictogramElementCreateService.createDiagram(UILiterals.DIAGRAM_TYPE_ID, addedCompartmentType.getName(), 10, true);
		UIUtil.setDiagram_KindValue(contentDiagram, literals.DIAGRAM_KIND);
		AddCompartmentTypeContext agctc = (AddCompartmentTypeContext) addContext;
		link(contentDiagram, agctc.getModelToLink());
		getDiagram().getContainer().getChildren().add(contentDiagram);
		
		//Step 3
		UIUtil.setShape_IdValue(containerShape, literals.SHAPE_ID_COMPARTMENTTYPE_CONTAINER);
		UIUtil.setShape_IdValue(typeBodyShape, literals.SHAPE_ID_COMPARTMENTTYPE_TYPEBODY);
		UIUtil.setShape_IdValue(dropShadowShape, literals.SHAPE_ID_COMPARTMENTTYPE_SHADOW);
		UIUtil.setShape_IdValue(nameShape, literals.SHAPE_ID_COMPARTMENTTYPE_NAME);
		UIUtil.setShape_IdValue(firstLineShape, literals.SHAPE_ID_COMPARTMENTTYPE_FIRSTLINE);
		UIUtil.setShape_IdValue(attributeContainer, literals.SHAPE_ID_COMPARTMENTTYPE_ATTRIBUTECONTAINER);
		UIUtil.setShape_IdValue(secondLineShape, literals.SHAPE_ID_COMPARTMENTTYPE_SECONDLINE);
		UIUtil.setShape_IdValue(operationContainer, literals.SHAPE_ID_COMPARTMENTTYPE_OPERATIONCONTAINER);
		UIUtil.setShape_IdValue(thirdLineShape, literals.SHAPE_ID_COMPARTMENTTYPE_THIRDLINE);
		UIUtil.setShape_IdValue(modelContainer, literals.SHAPE_ID_COMPARTMENTTYPE_CONTENT_PREVIEW);
		
		//Step 4
		link(containerShape, addedCompartmentType);
		link(typeBodyShape, addedCompartmentType);
		link(dropShadowShape, addedCompartmentType);
		link(nameShape, addedCompartmentType);
		link(firstLineShape, addedCompartmentType);
		link(attributeContainer, addedCompartmentType);
		link(secondLineShape, addedCompartmentType);
		link(operationContainer, addedCompartmentType);
		link(thirdLineShape, addedCompartmentType);
		link(modelContainer, addedCompartmentType);
		
		//Step 5
		getFeatureProvider().getDirectEditingInfo().setActive(true);
		IDirectEditingInfo directEditingInfo = getFeatureProvider().getDirectEditingInfo();
		directEditingInfo.setMainPictogramElement(typeBodyShape);
		directEditingInfo.setPictogramElement(nameShape);
		directEditingInfo.setGraphicsAlgorithm(text);
		pictogramElementCreateService.createChopboxAnchor(typeBodyShape);
		layoutPictogramElement(containerShape);
		updateContainingGroupOrCompartmentType();
		return containerShape;
	}
	
	//create feature
	//~~~~~~~~~~~~~~
	/**
	 * calculates if a compartment type can be created
	 * <p>
	 * returns true if:<br>
	 * (1) the target container is a diagram with a model linked
	 * @return if an compartment type can be created
	 */
	@Override
	public boolean canCreate(ICreateContext createContext) {
		if(UIUtil.getLinkedModelForDiagram(getDiagram()) != null) {
			return true && EditPolicyService.canCreate(createContext, this.getDiagram());
		}   
		return false;
	}
	
	/**
	 * creates the business objects of the compartment type, adds it to model of the diagram in which the compartment type is 
	 * created in and calls the add function for the compartment type
	 * <p>
	 * It creates the following structure:<br>
	 * <ul>
	 *   <li>(org.framed.iorm.model.Shape) natural type</li>
	 * 	   <ul>
	 * 	     <li>(Segment) first segment (for attributes)</li> 
	 *  	 <li>(Segment) second segment (for operations)</li> 
	 * 	     <li>(Model) compartment types model</li> 
	 * 	   </ul>
	 * </ul> 
	 * <p>
	 * It follows this steps:<br>
	 * Step 1: It creates the structure shown above.<br>
	 * Step 2: It adds the new compartment type to the elements of the model of the diagram in which its created.<br>
	 * Step 3: It call the add function to add the pictogram elements of the compartment type using a 
	 * 		   {@link AddGroupOrCompartmentTypeContext}.
	 * @return the created business object of the group
	 */
	@Override
	public Object[] create(ICreateContext createContext) {
		//Step 1
		//compartment type
		org.framed.iorm.model.Shape newCompartmentType = OrmFactory.eINSTANCE.createShape();
		newCompartmentType.setType(Type.COMPARTMENT_TYPE);
		String standardName = UIUtil.calculateStandardNameForClass(getDiagram(), Type.COMPARTMENT_TYPE, literals.STANDARD_NAME);
		newCompartmentType.setName(standardName);
		//create segments
		Segment attributeSegment = OrmFactory.eINSTANCE.createSegment(),
				operationSegment = OrmFactory.eINSTANCE.createSegment();
		getDiagram().eResource().getContents().add(attributeSegment);
		getDiagram().eResource().getContents().add(operationSegment);
		newCompartmentType.setFirstSegment(attributeSegment);
		newCompartmentType.setSecondSegment(operationSegment);
		//model
		Model compartmentsModel = OrmFactory.eINSTANCE.createModel();
		getDiagram().eResource().getContents().add(compartmentsModel);
		newCompartmentType.setModel(compartmentsModel);
		
		//Step 2
		Model model = UIUtil.getLinkedModelForDiagram((Diagram) getDiagram());
		if(newCompartmentType.eResource() != null) getDiagram().eResource().getContents().add(newCompartmentType);
		model.getElements().add(newCompartmentType);
		newCompartmentType.setContainer(model);
	
		//Step 3
		AddCompartmentTypeContext agctc = new AddCompartmentTypeContext();
		UIUtil.getAddContextForCreateShapeContext(agctc, createContext);
		agctc.setNewObject(newCompartmentType);
		agctc.setModelToLink(compartmentsModel);
		if(canAdd(agctc)) add(agctc);
		return new Object[] { newCompartmentType };
	}
	
	//direct editing
	//~~~~~~~~~~~~~~
	/**
	 * sets the editing type as a text field for the direct editing of the compartment types name
	 */
	@Override
	public int getEditingType() {
		return TYPE_TEXT;
	}
		
	/**
	 * calculates if a pictogram element of a natural type can be direct edited
	 * <p>
	 * returns true if:<br>
	 * (1) the business object of the pictogram element is a {@link org.framed.iorm.model.Shape} 
	 * 	   of the type {@link Type#COMPARTMENT_TYPE} and<br>
	 * (2) the graphics algorithm of the pictogram element is a {@link Text}
	 * @return if the selected pictogram can be direct edited
	 */
	@Override
	public boolean canDirectEdit(IDirectEditingContext editingContext) {
		Object businessObject = getBusinessObject(editingContext);
		GraphicsAlgorithm graphicsAlgorithm = editingContext.getGraphicsAlgorithm();
		if(businessObject instanceof org.framed.iorm.model.Shape && graphicsAlgorithm instanceof Text) {
			org.framed.iorm.model.Shape shape = (org.framed.iorm.model.Shape) businessObject;
			if(shape.getType() == Type.COMPARTMENT_TYPE) {
				return true;
		}	}
		return false;
	}

	/**
	 * returns the current compartment types name as initial value for direct editing
	 */
	@Override
	public String getInitialValue(IDirectEditingContext editingContext) {
		org.framed.iorm.model.Shape compartmentType = (org.framed.iorm.model.Shape) getBusinessObject(editingContext);
		return compartmentType.getName();
	}
		
	/**
	 * calculates if a chosen value for the compartment types name is valid
	 * <p>
	 * A valid value is in a specific form checked by {@link NameUtil#matchesIdentifier} and is not already
	 * chosen for another compartment type. This is checked by {@link NameUtil#nameAlreadyUsedForClassOrRole}.
	 * @return if a chosen value for the compartment types name is valid
	 */
	@Override
	public String checkValueValid(String newName, IDirectEditingContext editingContext) {
		if(getInitialValue(editingContext).contentEquals(newName)) return null;
		if(!(UIUtil.matchesIdentifier(newName))) return literals.DIRECTEDITING_COMPARTMENTTYPE;
		if(UIUtil.nameAlreadyUsedForClass(getDiagram(), Type.COMPARTMENT_TYPE, newName)) 
			return literals.NAME_ALREADY_USED_COMPARTMENTTYPE;
		return null;
	}
		
	/**
	 * sets value of the compartment types name, updates its own pictogram element and a group in which its in, if any
	 */
	@Override
	public void setValue(String value, IDirectEditingContext editingContext) {	     
		org.framed.iorm.model.Shape compartmentType = (org.framed.iorm.model.Shape) getBusinessObject(editingContext);
		compartmentType.setName(value);
		updatePictogramElement(((Shape) editingContext.getPictogramElement()).getContainer());
		updateContainingGroupOrCompartmentType();
	}
	
	//layout feature
	//~~~~~~~~~~~~~~
	/**
	 * calculates if a pictogram element of a compartment type can be layouted
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
	 * layout the whole compartment type using the following steps:
	 * <p>
	 * Step 1: Its fetches the type body shape and drop shadow shape<br>
	 * Step 2: It calculates the new height, width and horizontal center. It also uses this data to set
	 * 		   the size of the type body and drop shadow shape.<br>
	 * Step 3: It now iterates over all shapes of the natural type:<br>
	 * (a) It sets the width of the names shape.<br>
	 * (b) It sets the points of the line that separates the name, attribute, operations and content preview container.<br>
	 * (c) It layouts the visualization of the attributes in the attribute container shape.<br>
	 * (d) It layouts the visualization of the operations in the operation container shape.<br>
	 * (e) It layouts the visualization of the elements in the content preview container.
	 * <p>
	 * If its not clear what the different shapes means, see {@link #add} for reference.
	 */
	@Override
	public boolean layout(ILayoutContext layoutContext) {
		boolean layoutChanged = false;
		int newHeight, newWidth, newY;
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
		        int horizontalFirstThird = util.calculateHorizontaltFirstThird(height);
		        int horizontalSecondThird = util.calculateHorizontaltSecondThird(height);
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
			        if(UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_COMPARTMENTTYPE_SECONDLINE)) {   
			        	polyline.getPoints().set(0, graphicAlgorithmService.createPoint(0, horizontalFirstThird));
			           	polyline.getPoints().set(1, graphicAlgorithmService.createPoint(width, horizontalFirstThird));
			           	layoutChanged=true;
			        }
			        if(UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_COMPARTMENTTYPE_THIRDLINE)) {   
			           	polyline.getPoints().set(0, graphicAlgorithmService.createPoint(0, horizontalSecondThird));
			           	polyline.getPoints().set(1, graphicAlgorithmService.createPoint(width, horizontalSecondThird));
			           	layoutChanged=true;
			    }	}    
		        //attribute and operation container + elements
		        if (graphicsAlgorithm instanceof Rectangle) {
		        	Rectangle rectangle = (Rectangle) graphicsAlgorithm;  
		        	//(c) attribute container shape
			        if(UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_COMPARTMENTTYPE_ATTRIBUTECONTAINER)) {
			        	//resize and positioning the container
			        	newHeight = horizontalFirstThird-literals.HEIGHT_NAME_SHAPE-2*literals.PUFFER_BETWEEN_ELEMENTS;
			            newWidth = width-2*literals.PUFFER_BETWEEN_ELEMENTS; 
			            newY = literals.HEIGHT_NAME_SHAPE+literals.PUFFER_BETWEEN_ELEMENTS;
			            rectangle.setHeight(newHeight);
			           	rectangle.setWidth(newWidth);
			           	ContainerShape attributeContainerShape = (ContainerShape) shape;	       
			           	EList<Shape> attributes = attributeContainerShape.getChildren();
			            //set place of attributes
			            for(int m = 0; m<attributes.size(); m++) {
			            	Text attributeText = (Text) attributeContainerShape.getChildren().get(m).getGraphicsAlgorithm();
			            	attributeText.setY(newY+m*attOpsReference.HEIGHT_OPERATION_SHAPE);
			            	attributeText.setWidth(newWidth);
		            	}
			            //set all attributes visible
			            indicatorDotsShapeToDelete = null;
			            for(int j = 0; j<attributes.size(); j++) {
			            	attributes.get(j).setVisible(true);	   
			            	if(UIUtil.isShape_IdValue(attributes.get(j), attOpsReference.SHAPE_ID_ATTRIBUTE_INDICATOR_DOTS))
			            		indicatorDotsShapeToDelete = attributes.get(j);
			            }
			            attributeContainerShape.getChildren().remove(indicatorDotsShapeToDelete);
			            //check if not all attributes fit in the attribute field
			            if(attributeContainerShape.getChildren().size()*attOpsReference.HEIGHT_ATTRIBUTE_SHAPE>newHeight) {	            		
			            	int fittingAttributes = (newHeight-attOpsReference.HEIGHT_ATTRIBUTE_SHAPE)/attOpsReference.HEIGHT_ATTRIBUTE_SHAPE;	   
			            	//set not fitting attributes to invisible
			            	for(int k = fittingAttributes; k<attributes.size(); k++) {
			            		attributeContainerShape.getChildren().get(k).setVisible(false);
			            	}
			            	//add dots to indicate that not all attributes fit
			            	Shape indicatorDotsShape = pictogramElementCreateService.createShape(attributeContainerShape, true); 
					        Text indicatorDots = graphicAlgorithmService.createText(indicatorDotsShape, "...");
					        indicatorDots.setForeground(manageColor(literals.COLOR_TEXT));
					        graphicAlgorithmService.setLocationAndSize(indicatorDots, 
					        	literals.PUFFER_BETWEEN_ELEMENTS, attOpsReference.HEIGHT_ATTRIBUTE_SHAPE+fittingAttributes*attOpsReference.HEIGHT_ATTRIBUTE_SHAPE, 
					           	newWidth-2*literals.PUFFER_BETWEEN_ELEMENTS, attOpsReference.HEIGHT_OPERATION_SHAPE-2*literals.PUFFER_BETWEEN_ELEMENTS);
					        UIUtil.setShape_IdValue(indicatorDotsShape, attOpsReference.SHAPE_ID_ATTRIBUTE_INDICATOR_DOTS);
			            }	            			
			            layoutChanged=true;
			        }
			        //(d) operation container shape
			        if(UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_COMPARTMENTTYPE_OPERATIONCONTAINER)) {
			        	//resize and positioning the container
			        	newHeight = horizontalFirstThird-literals.HEIGHT_NAME_SHAPE-2*literals.PUFFER_BETWEEN_ELEMENTS;
			        	newWidth = width-2*literals.PUFFER_BETWEEN_ELEMENTS;		
			        	newY = horizontalFirstThird+literals.PUFFER_BETWEEN_ELEMENTS;	 
			        	rectangle.setHeight(newHeight);
			        	rectangle.setWidth(newWidth);
			        	rectangle.setY(newY);
			        	ContainerShape operationContainerShape = (ContainerShape) shape;
			        	EList<Shape> operations = operationContainerShape.getChildren();
			            //set place of attributes
			            for(int m = 0; m<operations.size(); m++) {
			            	Text operationText = (Text) operationContainerShape.getChildren().get(m).getGraphicsAlgorithm();
			            	operationText.setY(newY+m*attOpsReference.HEIGHT_OPERATION_SHAPE);
			            	operationText.setWidth(newWidth);
		            	}
			            //set all operations visible
						indicatorDotsShapeToDelete = null;
						for(int n = 0; n<operations.size(); n++) {
						    operations.get(n).setVisible(true);
						    if(UIUtil.isShape_IdValue(operations.get(n), attOpsReference.SHAPE_ID_OPERATION_INDICATOR_DOTS))
						    	indicatorDotsShapeToDelete = operations.get(n);
						}
						operationContainerShape.getChildren().remove(indicatorDotsShapeToDelete);
						//check if not all operations fit in the operations field
						if(operations.size()*attOpsReference.HEIGHT_OPERATION_SHAPE>newHeight) {	            		
							int fittingOperations = (newHeight-attOpsReference.HEIGHT_OPERATION_SHAPE)/attOpsReference.HEIGHT_OPERATION_SHAPE;	   
						    //set not fitting operations to invisible
						    for(int o = fittingOperations; o<operations.size(); o++) {
						    	operationContainerShape.getChildren().get(o).setVisible(false);            				
						    }   	
						    //add dots to indicate that not all operations fit
						    Shape indicatorDotsShape = pictogramElementCreateService.createShape(operationContainerShape, true); 
					        Text indicatorDots = graphicAlgorithmService.createText(indicatorDotsShape, "...");
					        indicatorDots.setForeground(manageColor(literals.COLOR_TEXT));
					        graphicAlgorithmService.setLocationAndSize(indicatorDots, 
					        	literals.PUFFER_BETWEEN_ELEMENTS, newY+fittingOperations*attOpsReference.HEIGHT_OPERATION_SHAPE, 
					           	newWidth-2*literals.PUFFER_BETWEEN_ELEMENTS, attOpsReference.HEIGHT_OPERATION_SHAPE);
					        UIUtil.setShape_IdValue(indicatorDotsShape, attOpsReference.SHAPE_ID_OPERATION_INDICATOR_DOTS);
						} 	
						layoutChanged=true;
			        }	
			        //(e) content preview container
			        if(UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_COMPARTMENTTYPE_CONTENT_PREVIEW)) {
			        	//resize and positioning the container
			        	newHeight = horizontalFirstThird-literals.HEIGHT_NAME_SHAPE-2*literals.PUFFER_BETWEEN_ELEMENTS;
				        newWidth = width-2*literals.PUFFER_BETWEEN_ELEMENTS;   
				        newY = horizontalSecondThird+literals.PUFFER_BETWEEN_ELEMENTS;
				        rectangle.setHeight(newHeight);
				        rectangle.setWidth(newWidth);
				        rectangle.setY(newY);
				        ContainerShape elementsShape = (ContainerShape) shape;
			          	EList<Shape> elements = elementsShape.getChildren();  
			          	//set all elements visible, delete indicator dots and positions of the elements
		            	indicatorDotsShapeToDelete = null;
		            	int counter = 0;
		            	for(Shape elementShape : elements) {
			           		elementShape.setVisible(true);
			           		graphicAlgorithmService.setLocationAndSize(elementShape.getGraphicsAlgorithm(), 
			           				literals.PUFFER_BETWEEN_ELEMENTS, newY+literals.HEIGHT_COMPARTMENT_ELEMENT_SHAPE*counter, 
			            			newWidth-2*literals.PUFFER_BETWEEN_ELEMENTS, literals.HEIGHT_COMPARTMENT_ELEMENT_SHAPE);
			           		if(UIUtil.isShape_IdValue(elementShape, literals.SHAPE_ID_COMPARTMENTTYPE_INDICATOR_DOTS))
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
			           			literals.PUFFER_BETWEEN_ELEMENTS, newY+fittingAttributes*literals.HEIGHT_COMPARTMENT_ELEMENT_SHAPE, 
			            		newWidth-2*literals.PUFFER_BETWEEN_ELEMENTS, literals.HEIGHT_COMPARTMENT_ELEMENT_SHAPE);
			            	UIUtil.setShape_IdValue(indicatorDotsShape, literals.SHAPE_ID_COMPARTMENTTYPE_INDICATOR_DOTS); 
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
			if(shape.getType() == Type.COMPARTMENT_TYPE) {
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
			//pictogram name, attributes, operations and elements
			String pictogramTypeName = util.getNameOfPictogramElement(pictogramElement);
			List<String> pictogramAttributeNames = util.getpictogramAttributeNames(pictogramElement);
			List<String> pictogramOperationNames = util.getpictogramOperationNames(pictogramElement);
			//model element names in model container of shape
			List<String> pictogramElementsNames = util.getContentPreviewElementsNames(pictogramElement);
			//business name and attributes
			String businessTypeName = UIUtil.getNameOfBusinessObject(getBusinessObjectForPictogramElement(pictogramElement));
			List<String> businessAttributeNames = util.getBusinessAttributeNames(pictogramElement);
			List<String> businessOperationNames = util.getBusinessOperationNames(pictogramElement);
			//at creation no diagram is existing so catch this
			List<String> modelElementsNames = null;
			try {
				modelElementsNames = UIUtil.getGroupOrCompartmentTypeElementNames(pictogramElement, getDiagram(), Type.COMPARTMENT_TYPE);
			} catch(NoDiagramFoundException e) { return Reason.createFalseReason(); }
 			
			//check for update: different names, different amount of attibutes/ operations
			if(pictogramTypeName==null || businessTypeName==null) return Reason.createTrueReason(literals.REASON_NAME_NULL);
			if(!(pictogramTypeName.equals(businessTypeName))) return Reason.createTrueReason(literals.REASON_NAME_OUT_OF_DATE);  
			if(pictogramAttributeNames.size() != businessAttributeNames.size()) return Reason.createTrueReason(attOpsReference.REASON_AMOUNT_ATTRIBUTES);
			if(pictogramOperationNames.size() != businessOperationNames.size()) return Reason.createTrueReason(attOpsReference.REASON_AMOUNT_OPERATION);
			for(int i=0; i<pictogramAttributeNames.size(); i++) {
				if(!(pictogramAttributeNames.get(i).equals(businessAttributeNames.get(i)))) return Reason.createTrueReason(attOpsReference.REASON_NAMES_ATTRIBUTES);
			}	
			for(int i=0; i<pictogramOperationNames.size(); i++) {
				if(!(pictogramOperationNames.get(i).equals(businessOperationNames.get(i)))) return Reason.createTrueReason(attOpsReference.REASON_NAMES_OPERATIONS);
			}
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
			
		//business names of natural type, attributes and operations
		String businessTypeName = UIUtil.getNameOfBusinessObject(getBusinessObjectForPictogramElement(pictogramElement));
		List<String> businessAttributeNames = util.getBusinessAttributeNames(pictogramElement);
		List<String> businessOperationNames = util.getBusinessOperationNames(pictogramElement);
			
		//set type name in pictogram model
	    if (pictogramElement instanceof ContainerShape) {     
	    	ContainerShape typeBodyShape = (ContainerShape) pictogramElement;
        	Diagram diagram = util.getCompartmentTypeDiagramForItsShape(typeBodyShape, getDiagram());
	        for (Shape shape : typeBodyShape.getChildren()) {
	        	if (shape.getGraphicsAlgorithm() instanceof Text) {
	        		Text text = (Text) shape.getGraphicsAlgorithm();
	                if(UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_COMPARTMENTTYPE_NAME)) {
	                	diagram.setName(businessTypeName);
	                	//change group name
	                	text.setValue(businessTypeName);
	                	changed = true;
	                }           
	            }
		        //set attribute and operation names and thier places in pictogram model
		        if(shape instanceof ContainerShape) {
		        	ContainerShape innerContainerShape = (ContainerShape) shape;
		        	if(innerContainerShape.getGraphicsAlgorithm() instanceof Rectangle) {
						//Attributes
						counter = 0;
						if(UIUtil.isShape_IdValue(innerContainerShape, literals.SHAPE_ID_COMPARTMENTTYPE_ATTRIBUTECONTAINER)) {
							for(Shape attributeShape : innerContainerShape.getChildren()) {
								if(UIUtil.isShape_IdValue(attributeShape, attOpsReference.SHAPE_ID_ATTRIBUTE_TEXT)) {
									Text text = (Text) attributeShape.getGraphicsAlgorithm();
									text.setValue(businessAttributeNames.get(counter));
									changed = true;
									counter++;
						}	}	}
						//Operations
						counter = 0;
						if(UIUtil.isShape_IdValue(innerContainerShape, literals.SHAPE_ID_COMPARTMENTTYPE_OPERATIONCONTAINER)) {
							for(Shape operationShape : innerContainerShape.getChildren()) {
								if(UIUtil.isShape_IdValue(operationShape, attOpsReference.SHAPE_ID_OPERATION_TEXT)) {
									Text text = (Text) operationShape.getGraphicsAlgorithm();
									text.setValue(businessOperationNames.get(counter));									
									changed = true;
									counter++;
						}	}	}	
						if(UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_COMPARTMENTTYPE_CONTENT_PREVIEW)) {
			                ContainerShape modelContainerShape = (ContainerShape) shape;
				            Model compartmentModel = UIUtil.getLinkedModelForDiagram(diagram);
			             
				            counter = 0;
			                modelContainerShape.getChildren().clear();
				            for(ModelElement modelElement : compartmentModel.getElements()) {
					            if(modelElement instanceof org.framed.iorm.model.Shape) {	
				            		Shape elementShape = pictogramElementCreateService.createShape(modelContainerShape, true);
					            	Text elementText = graphicAlgorithmService.createText(elementShape, UIUtil.getGroupOrCompartmentTypeElementText(modelElement));
					            	elementText.setForeground(manageColor(literals.COLOR_TEXT));
					            	UIUtil.setShape_IdValue(elementShape, literals.SHAPE_ID_COMPARTMENTTYPE_ELEMENT);
					            	counter++;		
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
	 * deletes the group as cares about all related concerns using the following steps
	 * <p>
	 * Step 1: It deletes attached connection to it.<br>
	 * Step 2: It gets the compartment types diagram and creates a {@link DeleteContext} for it.<br>
	 * Step 3: It gets all compartment types that are a child of this compartment type to delete them as well. This is needed to be 
	 * 		   explicitly since otherwise the diagrams of the child compartments would not be deleted.<br>
	 * Step 4: It closes all editors that opened the diagram of this group to delete.<br>
	 * Step 5: It gets the container shape of the group, so this can be deleted instead of the type body shape.<br>
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
			DeleteContext deleteContextForGroupDiagram = new DeleteContext(compartmentDiagram);
			deleteContextForGroupDiagram.setMultiDeleteInfo(new MultiDeleteInfo(false, false, 0));
			//Step 3 
			for(Shape shape : compartmentDiagram.getChildren()) {
				if(shape instanceof ContainerShape) {
					for(AbstractInnerGroupingReference reference : innerGroupingReferences) {
						if(UIUtil.isShape_IdValue(shape, reference.getShapeIdContainer()))
							innerGroupsOrCompartmentTypesToDelete.add(UIUtil.getTypeBodyForGroupingContainer((ContainerShape) shape, reference.getShapeIdTypebody()));
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
			super.delete(deleteContextForGroupDiagram);
			updateContainingGroupOrCompartmentType();
		}
	}
}
