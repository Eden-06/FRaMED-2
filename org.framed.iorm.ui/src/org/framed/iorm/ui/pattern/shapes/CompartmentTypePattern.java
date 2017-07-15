package org.framed.iorm.ui.pattern.shapes;

import org.eclipse.graphiti.features.IDirectEditingInfo;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.impl.DeleteContext;
import org.eclipse.graphiti.features.context.impl.MoveShapeContext;
import org.eclipse.graphiti.features.context.impl.MultiDeleteInfo;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.pattern.IPattern;
import org.eclipse.graphiti.util.IColorConstant;
import org.framed.iorm.model.Model;
import org.framed.iorm.model.OrmFactory;
import org.framed.iorm.model.Segment;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.contexts.AddGroupOrCompartmentTypeContext;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.literals.LayoutLiterals;
import org.framed.iorm.ui.literals.NameLiterals;
import org.framed.iorm.ui.literals.TextLiterals;
import org.framed.iorm.ui.util.DiagramUtil;
import org.framed.iorm.ui.util.GeneralUtil;
import org.framed.iorm.ui.util.NameUtil;
import org.framed.iorm.ui.util.PropertyUtil;
import org.framed.iorm.ui.wizards.RoleModelWizard;

//TODO
public class CompartmentTypePattern extends FRaMEDShapePattern implements IPattern {

	//TODO
	private final String COMPARTMENTTYPE_FEATURE_NAME = NameLiterals.COMPARTMENTTYPE_FEATURE_NAME,
						 STANDARD_COMPARTMENTTYPE_NAME = NameLiterals.STANDARD_COMPARTMENTTYPE_NAME;
	
	//TODO
	private final String IMG_ID_FEATURE_COMPARTMENTTYPE = IdentifierLiterals.IMG_ID_FEATURE_COMPARTMENTTYPE;
	
	private final String DIAGRAM_KIND_COMPARTMENT_DIAGRAM = IdentifierLiterals.DIAGRAM_KIND_COMPARTMENT_DIAGRAM,
						 DIAGRAM_TYPE = IdentifierLiterals.DIAGRAM_TYPE_ID;
	
	/**
	 * identifier literals used as shape ids for the natural type 
	 * <p>
	 * See {@link IdentifierLiterals} for the meaning of the identifiers.
	 */
	private final String SHAPE_ID_COMPARTMENTTYPE_CONTAINER = IdentifierLiterals.SHAPE_ID_COMPARTMENTTYPE_CONTAINER,
						 SHAPE_ID_COMPARTMENTTYPE_TYPEBODY = IdentifierLiterals.SHAPE_ID_COMPARTMENTTYPE_TYPEBODY,
						 SHAPE_ID_COMPARTMENTTYPE_SHADOW = IdentifierLiterals.SHAPE_ID_COMPARTMENTTYPE_SHADOW,
						 SHAPE_ID_COMPARTMENTTYPE_NAME = IdentifierLiterals.SHAPE_ID_COMPARTMENTTYPE_NAME,
						 SHAPE_ID_COMPARTMENTTYPE_FIRSTLINE = IdentifierLiterals.SHAPE_ID_COMPARTMENTTYPE_FIRSTLINE,
						 SHAPE_ID_COMPARTMENTTYPE_SECONDLINE = IdentifierLiterals.SHAPE_ID_COMPARTMENTTYPE_SECONDLINE,
						 SHAPE_ID_COMPARTMENTTYPE_THIRDLINE = IdentifierLiterals.SHAPE_ID_COMPARTMENTTYPE_THIRDLINE,
						 SHAPE_ID_COMPARTMENTTYPE_ATTRIBUTECONTAINER = IdentifierLiterals.SHAPE_ID_COMPARTMENTTYPE_ATTRIBUTECONTAINER, 
						 SHAPE_ID_COMPARTMENTTYPE_OPERATIONCONTAINER = IdentifierLiterals.SHAPE_ID_COMPARTMENTTYPE_OPERATIONCONTAINER,
						 SHAPE_ID_COMPARTMENTTYPE_CONTENT_PREVIEW = IdentifierLiterals.SHAPE_ID_COMPARTMENTTYPE_CONTENT_PREVIEW,
						 SHAPE_ID_COMPARTMENTTYPE_ELEMENT = IdentifierLiterals.SHAPE_ID_COMPARTMENTTYPE_CONTENT_PREVIEW,
						 SHAPE_ID_COMPARTMENTTYPE_INDICATOR_DOTS = IdentifierLiterals.SHAPE_ID_COMPARTMENTTYPE_INDICATOR_DOTS;
						 
	/**
	 * text literals gathered from {@link TextLiterals}
	 * <p>
	 * can be:<br>
	 * (1) the message if the form of a chosen natural type name is not correct when direct editing or<br>
	 * (2) the message if a chosen name for a natural type is already used when direct editing 
	 */
	private final String DIRECTEDITING_COMPARTMENTTYPE = TextLiterals.DIRECTEDITING_COMPARTMENTTYPE,
						 NAME_ALREADY_USED_COMPARTMENTTYPE = TextLiterals.NAME_ALREADY_USED_COMPARTMENTTYPE;
	
	/**
	 * layout integers gathered from {@link LayoutLiterals}, look there for reference
	 */
	private final int MIN_WIDTH = LayoutLiterals.MIN_WIDTH_FOR_CLASS_OR_ROLE, 
					  MIN_HEIGHT = LayoutLiterals.MIN_HEIGHT_FOR_CLASS_OR_ROLE, 
					  HEIGHT_NAME_SHAPE = LayoutLiterals.HEIGHT_NAME_SHAPE,
					  PUFFER_BETWEEN_ELEMENTS = LayoutLiterals.PUFFER_BETWEEN_ELEMENTS,
					  SHADOW_SIZE = LayoutLiterals.SHADOW_SIZE,
					  HEIGHT_ATTRIBUTE_SHAPE = LayoutLiterals.HEIGHT_ATTRITBUTE_SHAPE,
					  HEIGHT_OPERATION_SHAPE = LayoutLiterals.HEIGHT_OPERATION_SHAPE;
	
	/**
	 * colors gathered from {@link LayoutLiterals}, look there for reference
	 */
	private final IColorConstant COLOR_TEXT = LayoutLiterals.COLOR_TEXT,
								 COLOR_LINES = LayoutLiterals.COLOR_LINES,
								 COLOR_BACKGROUND = LayoutLiterals.COLOR_BACKGROUND,
								 COLOR_SHADOW = LayoutLiterals.COLOR_SHADOW;
	
	/**
	 * Class constructor
	 */
	public CompartmentTypePattern() {
		super();
	}
	
	/**
	 * get method for the create features name
	 * @return the name of the create feature
	 */
	@Override
	public String getCreateName() {
		return COMPARTMENTTYPE_FEATURE_NAME;
	}
	
	/**
	 * enables the icon for the create feature in this pattern
	 * @return the image identifier for the icon of the create feature in this pattern
	 */
	@Override
	public String getCreateImageId() {
		return IMG_ID_FEATURE_COMPARTMENTTYPE;
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
				ContainerShape containerShape = getDiagram();
				if(containerShape instanceof Diagram) {
					if(DiagramUtil.getLinkedModelForDiagram((Diagram) containerShape) != null)
						return true;
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
	 * 			<li>model content container</li>
	 * 			  <ul><li>model content rectangle</li></ul>
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
		if(addContext.getWidth() < MIN_WIDTH) width = MIN_WIDTH;
		if(addContext.getHeight() < MIN_HEIGHT) height = MIN_HEIGHT;
				
		//Step 2
		//container for body shape and shadow
		ContainerShape containerShape = pictogramElementCreateService.createContainerShape(targetDiagram, false);
							  
		//drop shadow
		ContainerShape dropShadowShape = pictogramElementCreateService.createContainerShape(containerShape, true);
		Rectangle dropShadowRectangle = graphicAlgorithmService.createRectangle(dropShadowShape);
		dropShadowRectangle.setForeground(manageColor(COLOR_SHADOW));
		dropShadowRectangle.setBackground(manageColor(COLOR_SHADOW));
		graphicAlgorithmService.setLocationAndSize(dropShadowRectangle, addContext.getX()+SHADOW_SIZE, addContext.getY()+SHADOW_SIZE, width, height);
				
		//body shape of type
		ContainerShape typeBodyShape = pictogramElementCreateService.createContainerShape(containerShape, true);		
		Rectangle typeBodyRectangle = graphicAlgorithmService.createRectangle(typeBodyShape);
		typeBodyRectangle.setForeground(manageColor(COLOR_LINES));
		typeBodyRectangle.setBackground(manageColor(COLOR_BACKGROUND));
		graphicAlgorithmService.setLocationAndSize(typeBodyRectangle, addContext.getX(), addContext.getY(), width, height);
				
		//name
		Shape nameShape = pictogramElementCreateService.createShape(typeBodyShape, false);
		Text text = graphicAlgorithmService.createText(nameShape, addedCompartmentType.getName());	
		text.setForeground(manageColor(COLOR_TEXT));	
		text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);	
		graphicAlgorithmService.setLocationAndSize(text, 0, 0, width, HEIGHT_NAME_SHAPE);	
				
		//first line
		Shape firstLineShape = pictogramElementCreateService.createShape(typeBodyShape, false);
		Polyline firstPolyline = graphicAlgorithmService.createPolyline(firstLineShape, new int[] {0, HEIGHT_NAME_SHAPE, width, HEIGHT_NAME_SHAPE});
		firstPolyline.setForeground(manageColor(COLOR_LINES));
				
		//attribute container
		ContainerShape attributeContainer = pictogramElementCreateService.createContainerShape(typeBodyShape, false);
		Rectangle attributeRectangle = graphicAlgorithmService.createRectangle(attributeContainer);
		//attributeRectangle.setLineVisible(false);
		attributeRectangle.setBackground(manageColor(COLOR_BACKGROUND));
		int horizontalFirstThird = GeneralUtil.calculateHorizontaltFirstThird(height);
		graphicAlgorithmService.setLocationAndSize(attributeRectangle, PUFFER_BETWEEN_ELEMENTS, HEIGHT_NAME_SHAPE+PUFFER_BETWEEN_ELEMENTS, 
												   width-2*PUFFER_BETWEEN_ELEMENTS, horizontalFirstThird-HEIGHT_NAME_SHAPE-2*PUFFER_BETWEEN_ELEMENTS);
		//second line
		Shape secondLineShape = pictogramElementCreateService.createShape(typeBodyShape, false);	
		Polyline secondPolyline = graphicAlgorithmService.createPolyline(secondLineShape, new int[] {0, horizontalFirstThird, width, horizontalFirstThird});
		secondPolyline.setForeground(manageColor(COLOR_LINES));
				
		//operation container
		ContainerShape operationContainer = pictogramElementCreateService.createContainerShape(typeBodyShape, false);
		Rectangle operationRectangle = graphicAlgorithmService.createRectangle(operationContainer);
		//operationRectangle.setLineVisible(false);
		operationRectangle.setBackground(manageColor(COLOR_BACKGROUND));
		graphicAlgorithmService.setLocationAndSize(operationRectangle, PUFFER_BETWEEN_ELEMENTS, horizontalFirstThird+PUFFER_BETWEEN_ELEMENTS, 
											 	   width-2*PUFFER_BETWEEN_ELEMENTS, horizontalFirstThird-HEIGHT_NAME_SHAPE-2*PUFFER_BETWEEN_ELEMENTS);
		
		//third line
		Shape thirdLineShape = pictogramElementCreateService.createShape(typeBodyShape, false);	
		int horizontalSecondThird = GeneralUtil.calculateHorizontaltSecondThird(height);
		Polyline thirdPolyline = graphicAlgorithmService.createPolyline(thirdLineShape, new int[] {0, horizontalSecondThird, width, horizontalSecondThird});
		thirdPolyline.setForeground(manageColor(COLOR_LINES));
			
		//model content preview container
		ContainerShape modelContainer = pictogramElementCreateService.createContainerShape(typeBodyShape, false);
		Rectangle modelRectangle = graphicAlgorithmService.createRectangle(modelContainer);
		//modelRectangle.setLineVisible(false);
		modelRectangle.setBackground(manageColor(COLOR_BACKGROUND));
		graphicAlgorithmService.setLocationAndSize(modelRectangle, PUFFER_BETWEEN_ELEMENTS, horizontalSecondThird+PUFFER_BETWEEN_ELEMENTS, 
												   width-2*PUFFER_BETWEEN_ELEMENTS, horizontalFirstThird-HEIGHT_NAME_SHAPE-2*PUFFER_BETWEEN_ELEMENTS);	
		
		//groups diagram
		Diagram contentDiagram = pictogramElementCreateService.createDiagram(DIAGRAM_TYPE, addedCompartmentType.getName(), 10, false);
		PropertyUtil.setDiagram_KindValue(contentDiagram, DIAGRAM_KIND_COMPARTMENT_DIAGRAM);
		AddGroupOrCompartmentTypeContext agctc = (AddGroupOrCompartmentTypeContext) addContext;
		link(contentDiagram, agctc.getModelToLink());
		getDiagram().getContainer().getChildren().add(contentDiagram);
		
		//Step 3
		PropertyUtil.setShape_IdValue(containerShape, SHAPE_ID_COMPARTMENTTYPE_CONTAINER);
		PropertyUtil.setShape_IdValue(typeBodyShape, SHAPE_ID_COMPARTMENTTYPE_TYPEBODY);
		PropertyUtil.setShape_IdValue(dropShadowShape, SHAPE_ID_COMPARTMENTTYPE_SHADOW);
		PropertyUtil.setShape_IdValue(nameShape, SHAPE_ID_COMPARTMENTTYPE_NAME);
		PropertyUtil.setShape_IdValue(firstLineShape, SHAPE_ID_COMPARTMENTTYPE_FIRSTLINE);
		PropertyUtil.setShape_IdValue(attributeContainer, SHAPE_ID_COMPARTMENTTYPE_ATTRIBUTECONTAINER);
		PropertyUtil.setShape_IdValue(secondLineShape, SHAPE_ID_COMPARTMENTTYPE_SECONDLINE);
		PropertyUtil.setShape_IdValue(operationContainer, SHAPE_ID_COMPARTMENTTYPE_OPERATIONCONTAINER);
		PropertyUtil.setShape_IdValue(thirdLineShape, SHAPE_ID_COMPARTMENTTYPE_THIRDLINE);
		PropertyUtil.setShape_IdValue(modelContainer, SHAPE_ID_COMPARTMENTTYPE_CONTENT_PREVIEW);
		
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
		updateContainingGroup();
		return containerShape;
	}
	
	//create feature
	//~~~~~~~~~~~~~~
	/**
	 * calculates if a compartment type can be created
	 * <p>
	 * returns true if the target container is a diagram with a model linked
	 * @return if a compartment type can be created
	 */
	@Override
	public boolean canCreate(ICreateContext createContext) {
		if(DiagramUtil.getLinkedModelForDiagram(getDiagram()) != null)
			return true;
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
	 * It uses follows this steps:<br>
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
		String standardName = NameUtil.calculateStandardNameForClassOrRole(getDiagram(), Type.COMPARTMENT_TYPE, STANDARD_COMPARTMENTTYPE_NAME);
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
		Model model = DiagramUtil.getLinkedModelForDiagram((Diagram) getDiagram());
		if(newCompartmentType.eResource() != null) getDiagram().eResource().getContents().add(newCompartmentType);
		model.getElements().add(newCompartmentType);
		newCompartmentType.setContainer(model);
	
		//Step 3
		AddGroupOrCompartmentTypeContext agctc = new AddGroupOrCompartmentTypeContext();
		GeneralUtil.getAddContextForCreateShapeContext(agctc, createContext);
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
		if(!(NameUtil.matchesIdentifier(newName))) return DIRECTEDITING_COMPARTMENTTYPE;
		if(NameUtil.nameAlreadyUsedForClassOrRole(getDiagram(), Type.COMPARTMENT_TYPE, newName)) 
			return NAME_ALREADY_USED_COMPARTMENTTYPE;
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
		updateContainingGroup();
	}
	
	//move feature
	//~~~~~~~~~~~~
	//disable that the user can move the drop shadow manually
	@Override
	public boolean canMoveShape(IMoveShapeContext moveContext) {
		if(PropertyUtil.isShape_IdValue((Shape) moveContext.getPictogramElement(), SHAPE_ID_COMPARTMENTTYPE_SHADOW)) {
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
			dropShadowRectangle.setX(moveContext.getX()+SHADOW_SIZE);
			dropShadowRectangle.setY(moveContext.getY()+SHADOW_SIZE);
			super.moveShape(moveContext);
		} else {
			//targetContainer of moveContext is dropShadowShape
			//set targetContainer to diagram and use special calculation for the new position of type body and drop shadow 
			dropShadowRectangle.setX(typeBodyRectangle.getX()+moveContext.getX()+2*SHADOW_SIZE);
			dropShadowRectangle.setY(typeBodyRectangle.getY()+moveContext.getY()+2*SHADOW_SIZE);
			MoveShapeContext changedMoveContextForTypeBody = new MoveShapeContext(moveContext.getShape());
			changedMoveContextForTypeBody.setTargetContainer(dropShadowShape.getContainer());
			changedMoveContextForTypeBody.setX(typeBodyRectangle.getX()+moveContext.getX()+SHADOW_SIZE);
			changedMoveContextForTypeBody.setY(typeBodyRectangle.getY()+moveContext.getY()+SHADOW_SIZE);
			super.moveShape(changedMoveContextForTypeBody);
		}
	}	
	
	//resize feature
	//~~~~~~~~~~~~~~
	//disable that the user can resize the drop shadow manually
	@Override
	public boolean canResizeShape(IResizeShapeContext resizeContext) {
		if(PropertyUtil.isShape_IdValue((Shape) resizeContext.getPictogramElement(), SHAPE_ID_COMPARTMENTTYPE_SHADOW)) {
			return false;
		}
		return super.canResizeShape(resizeContext);
	}
		
	//delete feature
	//~~~~~~~~~~~~~~
	//disable that the user can delete the drop shadow manually
	@Override
	public boolean canDelete(IDeleteContext deleteContext) {
		if(PropertyUtil.isShape_IdValue((Shape) deleteContext.getPictogramElement(), SHAPE_ID_COMPARTMENTTYPE_SHADOW)) {
			return false;
		}
		return super.canDelete(deleteContext);
	}
			
	//delete parent container (the one that contains drop shadow shape and type body shape)
	@Override
	public void delete(IDeleteContext deleteContext) {
		deleteAttachedConnections(deleteContext);
		ContainerShape containerShape = (ContainerShape) ((ContainerShape) deleteContext.getPictogramElement()).getContainer();
		DeleteContext deleteContextForAllShapes = new DeleteContext(containerShape);
		deleteContextForAllShapes.setMultiDeleteInfo(new MultiDeleteInfo(false, false, 0));
		super.delete(deleteContextForAllShapes);
		updateContainingGroup();
	}
}
