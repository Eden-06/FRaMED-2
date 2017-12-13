package org.framed.iorm.ui.pattern.shapes;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IDirectEditingInfo;
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
import org.eclipse.graphiti.pattern.IPattern;
import org.eclipse.graphiti.util.IColorConstant;
import org.framed.iorm.model.Model;
import org.framed.iorm.model.OrmFactory;
import org.framed.iorm.model.Segment;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.editPolicy.EditPolicyService;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.literals.LayoutLiterals;
import org.framed.iorm.ui.literals.NameLiterals;
import org.framed.iorm.ui.literals.TextLiterals;
import org.framed.iorm.ui.palette.FeaturePaletteDescriptor;
import org.framed.iorm.ui.palette.PaletteCategory;
import org.framed.iorm.ui.palette.ViewVisibility;
import org.framed.iorm.ui.util.DiagramUtil;
import org.framed.iorm.ui.util.NameUtil;
import org.framed.iorm.ui.util.GeneralUtil;
import org.framed.iorm.ui.util.ShapePatternUtil;
import org.framed.iorm.ui.util.PropertyUtil;
import org.eclipse.graphiti.pattern.AbstractPattern; //*import for javadoc link

/**
 * This graphiti pattern class is used to work with {@link org.framed.iorm.model.Shape}s
 * of the type {@link Type#NATURAL_TYPE} in the editor.
 * <p>
 * It deals with the following aspects of natural types:<br>
 * (1) adding a natural types to the diagram, especially its pictogram elements<br>
 * (2) creating the natural types, especially its business object<br>
 * (3) direct editing of the natural types name<br>
 * (4) layout the natural types, especially setting lines, attributes and operations at the right positions<br>
 * (5) updating the natural types names, attributes names/ position and operation/ position<br>
 * (6) move the drop shadow with the type body and disables moving the drop shadow manually<br>
 * (7) resizes the drop shadow with the type body and disables resizing the drop shadow manually<br>
 * (8) deleting all the natural types pictogram elements and its attached connections, also disables deleting
 *     the drop shadow manually
 * <p>
 * If its not clear what <em>drop shadow shape</em> and <em>type body shape</em> means, see 
 * {@link #add} for reference. 
 * @author Kevin Kassin
 */
public class NaturalTypePattern extends FRaMEDShapePattern implements IPattern {

	/**
	 * name literals gathered from {@link NameLiterals}
	 * <p>
	 * can be:<br>
	 * (1) the name of the create feature in this pattern or<br>
	 * (2) the standard names for natural types
	 */
	private final String NATURALTYPE_FEATURE_NAME = NameLiterals.NATURALTYPE_FEATURE_NAME,
						 STANDARD_NATURALTYPE_NAME = NameLiterals.STANDARD_NATURALTYPE_NAME;
	
	/**
	 * identifier literals used as shape ids for the natural type 
	 * <p>
	 * See {@link IdentifierLiterals} for the meaning of the identifiers.
	 */
	private final String SHAPE_ID_NATURALTYPE_CONTAINER = IdentifierLiterals.SHAPE_ID_NATURALTYPE_CONTAINER,
						 SHAPE_ID_NATURALTYPE_TYPEBODY = IdentifierLiterals.SHAPE_ID_NATURALTYPE_TYPEBODY,
						 SHAPE_ID_NATURALTYPE_SHADOW = IdentifierLiterals.SHAPE_ID_NATURALTYPE_SHADOW,
						 SHAPE_ID_NATURALTYPE_NAME = IdentifierLiterals.SHAPE_ID_NATURALTYPE_NAME,
						 SHAPE_ID_NATURALTYPE_FIRSTLINE = IdentifierLiterals.SHAPE_ID_NATURALTYPE_FIRSTLINE,
						 SHAPE_ID_NATURALTYPE_SECONDLINE = IdentifierLiterals.SHAPE_ID_NATURALTYPE_SECONDLINE,
						 SHAPE_ID_NATURALTYPE_ATTRIBUTECONTAINER = IdentifierLiterals.SHAPE_ID_NATURALTYPE_ATTRIBUTECONTAINER, 
						 SHAPE_ID_NATURALTYPE_OPERATIONCONTAINER = IdentifierLiterals.SHAPE_ID_NATURALTYPE_OPERATIONCONTAINER;
	
	/**
	 * the image identifier for the icon of the create feature in this pattern gathered from
	 * {@link IdentifierLiterals}
	 */
	private final String IMG_ID_FEATURE_NATURALTYPE = IdentifierLiterals.IMG_ID_FEATURE_NATURALTYPE;
	
	/**
	 * the feature palette descriptor manages the palette visibility, see {@link FeaturePaletteDescriptor}
	 */
	private final FeaturePaletteDescriptor spec_FPD = new FeaturePaletteDescriptor(
			PaletteCategory.ENTITIES_CATEGORY,
			ViewVisibility.TOPLEVEL_VIEW);
	
	/**
	 * identifier literals used as shape ids for the shapes of the attribute and operation containers
	 * <p>
	 * See {@link IdentifierLiterals} for the meaning of the identifiers.
	 */
	private final String SHAPE_ID_OPERATION_TEXT = IdentifierLiterals.SHAPE_ID_OPERATION_TEXT,
			 			 SHAPE_ID_OPERATION_INDICATOR_DOTS = IdentifierLiterals.SHAPE_ID_OPERATION_INDICATOR_DOTS,
			 			 SHAPE_ID_ATTRIBUTE_TEXT = IdentifierLiterals.SHAPE_ID_ATTRIBUTE_TEXT,
			 			 SHAPE_ID_ATTRIBUTE_INDICATOR_DOTS = IdentifierLiterals.SHAPE_ID_ATTRIBUTE_INDICATOR_DOTS;
	
	/**
	 * values for the property diagram kind for the diagrams in which a natural type can be created and added in
	 */
	private final String DIAGRAM_KIND_MAIN_DIAGRAM = IdentifierLiterals.DIAGRAM_KIND_MAIN_DIAGRAM,
					 	 DIAGRAM_KIND_GROUP_DIAGRAM = IdentifierLiterals.DIAGRAM_KIND_GROUP_DIAGRAM;
	
	/**
	 * text literals gathered from {@link TextLiterals}
	 * <p>
	 * can be:<br>
	 * (1) the message if the form of a chosen natural type name is not correct when direct editing or<br>
	 * (2) the message if a chosen name for a natural type is already used when direct editing 
	 */
	private final String DIRECTEDITING_NATURALTYPE = TextLiterals.DIRECTEDITING_NATURALTYPE,
						 NAME_ALREADY_USED_NATURALTYPE = TextLiterals.NAME_ALREADY_USED_NATURALTYPE;
	
	/**
	 * reason messages used in the operation {@link #updateNeeded} gathered from {@link TextLiterals}
	 */
	private final String REASON_NAME_NULL = TextLiterals.REASON_NAME_NULL,
						 REASON_NAME_OUT_OF_DATE = TextLiterals.REASON_NAME_OUT_OF_DATE,
					 	 REASON_AMOUNT_ATTRIBUTES = TextLiterals.REASON_AMOUNT_ATTRIBUTES,
					 	 REASON_AMOUNT_OPERATION = TextLiterals.REASON_AMOUNT_OPERATION,
					 	 REASON_NAMES_ATTRIBUTES = TextLiterals.REASON_NAMES_ATTRIBUTES,
					 	 REASON_NAMES_OPERATIONS = TextLiterals.REASON_NAMES_OPERATIONS;

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
	public NaturalTypePattern() {
		super();
		FPD = spec_FPD;
	}
	
	/**
	 * get method for the create features name
	 * @return the name of the create feature
	 */
	@Override
	public String getCreateName() {
		return NATURALTYPE_FEATURE_NAME;
	}
	
	/**
	 * enables the icon for the create feature in this pattern
	 * @return the image identifier for the icon of the create feature in this pattern
	 */
	@Override
	public String getCreateImageId() {
		return IMG_ID_FEATURE_NATURALTYPE;
	}
	
	/**
	 * checks if pattern is applicable for a given business object
	 * @return true, if business object is a {@link org.framed.iorm.model.Shape} of type {@link Type#NATURAL_TYPE}
	 */
	@Override
	public boolean isMainBusinessObjectApplicable(Object businessObject) {
		if(businessObject instanceof org.framed.iorm.model.Shape) {
			org.framed.iorm.model.Shape shape = (org.framed.iorm.model.Shape) businessObject;
			if(shape.getType() == Type.NATURAL_TYPE) return true;
		}
		return false;
	}

	/**
	 * checks if pattern is applicable for a given pictogram element
	 * @return true, if business object of the pictogram element is a {@link org.framed.iorm.model.Shape} of type {@link Type#NATURAL_TYPE}
	 */
	@Override
	protected boolean isPatternControlled(PictogramElement pictogramElement) {
		Object businessObject = getBusinessObjectForPictogramElement(pictogramElement);
		return isMainBusinessObjectApplicable(businessObject);
	}

	/**
	 * checks if the pictogram element to edit with the pattern is its root
	 * @return true, if business object of the pictogram element is a {@link org.framed.iorm.model.Shape} of type {@link Type#NATURAL_TYPE}
	 */
	@Override
	protected boolean isPatternRoot(PictogramElement pictogramElement) {
		Object businessObject = getBusinessObjectForPictogramElement(pictogramElement);
		return isMainBusinessObjectApplicable(businessObject);
	}
		
	// add features
	//~~~~~~~~~~~~~
	/**
	 * calculates if the natural type can be added to the diagram
	 * <p>
	 * returns true if:<br>
	 * (1) if the added business object is a natural type and <br>
	 * (2) if the target container is a diagram with a model linked and<br>
	 * (3) the target container is the main diagram or a diagram of group
	 * @return if the natural type can be added
	 */
	@Override
	public boolean canAdd(IAddContext addContext) {
		if(addContext.getNewObject() instanceof org.framed.iorm.model.Shape) {
			org.framed.iorm.model.Shape shape = (org.framed.iorm.model.Shape) addContext.getNewObject();
			if(shape.getType()==Type.NATURAL_TYPE) {
				ContainerShape containerShape = getDiagram();
				if(containerShape instanceof Diagram) {
					if(DiagramUtil.getLinkedModelForDiagram((Diagram) containerShape) != null) {
						if(PropertyUtil.isDiagram_KindValue(getDiagram(), DIAGRAM_KIND_MAIN_DIAGRAM) ||
						   PropertyUtil.isDiagram_KindValue(getDiagram(), DIAGRAM_KIND_GROUP_DIAGRAM))
							return EditPolicyService.canAdd(addContext, this.getDiagram());
		}	}	}	}
		return false;
	}

	/**
	 * adds the graphical representation of a natural type to the pictogram model
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
	 * 		   </ul>
	 * 	   </ul>
	 * </ul> 
	 * <p>
	 * It uses follows this steps:<br>
	 * Step 1: It gets the new object, the diagram to create the natural type in and calculates the height and width 
	 * 		   of the natural types representation.<br>
	 * Step 2: It creates the structure shown above.<br>
	 * Step 3: It sets the shape identifiers for the created graphics algorithms of the natural type.<br>
	 * Step 4: It links the created shapes of the natural type to its business objects.<br> 
	 * Step 5: It enables direct editing, anchors and layouting of the natural type. It also updates the group in which 
	 * 		   its created, if any.
	 */
	@Override
	public PictogramElement add(IAddContext addContext) {		
		//Step 1
		org.framed.iorm.model.Shape addedNaturalType = (org.framed.iorm.model.Shape) addContext.getNewObject();
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
		Text text = graphicAlgorithmService.createText(nameShape, addedNaturalType.getName());	
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
		attributeRectangle.setLineVisible(false);
		attributeRectangle.setBackground(manageColor(COLOR_BACKGROUND));
		int horizontalCenter = GeneralUtil.calculateHorizontalCenter(Type.NATURAL_TYPE, height);
		graphicAlgorithmService.setLocationAndSize(attributeRectangle, PUFFER_BETWEEN_ELEMENTS, HEIGHT_NAME_SHAPE+PUFFER_BETWEEN_ELEMENTS, 
												   width-2*PUFFER_BETWEEN_ELEMENTS, horizontalCenter-HEIGHT_NAME_SHAPE-2*PUFFER_BETWEEN_ELEMENTS);
		//second line
		Shape secondLineShape = pictogramElementCreateService.createShape(typeBodyShape, false);	
		Polyline secondPolyline = graphicAlgorithmService.createPolyline(secondLineShape, new int[] {0, horizontalCenter, width, horizontalCenter});
		secondPolyline.setForeground(manageColor(COLOR_LINES));
		
		//operation container
		ContainerShape operationContainer = pictogramElementCreateService.createContainerShape(typeBodyShape, false);
		Rectangle operationRectangle = graphicAlgorithmService.createRectangle(operationContainer);
		operationRectangle.setLineVisible(false);
		operationRectangle.setBackground(manageColor(COLOR_BACKGROUND));
		graphicAlgorithmService.setLocationAndSize(operationRectangle, PUFFER_BETWEEN_ELEMENTS, horizontalCenter+PUFFER_BETWEEN_ELEMENTS, 
									 			   width-2*PUFFER_BETWEEN_ELEMENTS, horizontalCenter-HEIGHT_NAME_SHAPE-2*PUFFER_BETWEEN_ELEMENTS);
		
		//Step 3
		PropertyUtil.setShape_IdValue(containerShape, SHAPE_ID_NATURALTYPE_CONTAINER);
		PropertyUtil.setShape_IdValue(typeBodyShape, SHAPE_ID_NATURALTYPE_TYPEBODY);
		PropertyUtil.setShape_IdValue(dropShadowShape, SHAPE_ID_NATURALTYPE_SHADOW);
		PropertyUtil.setShape_IdValue(nameShape, SHAPE_ID_NATURALTYPE_NAME);
		PropertyUtil.setShape_IdValue(firstLineShape, SHAPE_ID_NATURALTYPE_FIRSTLINE);
		PropertyUtil.setShape_IdValue(attributeContainer, SHAPE_ID_NATURALTYPE_ATTRIBUTECONTAINER);
		PropertyUtil.setShape_IdValue(secondLineShape, SHAPE_ID_NATURALTYPE_SECONDLINE);
		PropertyUtil.setShape_IdValue(operationContainer, SHAPE_ID_NATURALTYPE_OPERATIONCONTAINER);
		
		//Step 4
		link(containerShape, addedNaturalType);
		link(typeBodyShape, addedNaturalType);
		link(dropShadowShape, addedNaturalType);
		link(nameShape, addedNaturalType);
		link(firstLineShape, addedNaturalType);
		link(attributeContainer, addedNaturalType);
		link(secondLineShape, addedNaturalType);
		link(operationContainer, addedNaturalType);
		
		//Step 5
		getFeatureProvider().getDirectEditingInfo().setActive(true);
		IDirectEditingInfo directEditingInfo = getFeatureProvider().getDirectEditingInfo();
		directEditingInfo.setMainPictogramElement(typeBodyShape);
		directEditingInfo.setPictogramElement(nameShape);
		directEditingInfo.setGraphicsAlgorithm(text);
		pictogramElementCreateService.createChopboxAnchor(typeBodyShape);
		layoutPictogramElement(typeBodyShape);
		updateContainingGroupOrCompartmentType();
		return containerShape;
	}
	
	//create feature
	//~~~~~~~~~~~~~~
	/**
	 * calculates if a natural type can be created
	 * <p>
	 * returns true if:<br>
	 * (1) the target container is a diagram with a model linked
	 * (2) the target container is the main diagram or a diagram of group 
	 * @return if an natural type can be created
	 */
	@Override
	public boolean canCreate(ICreateContext createContext) {
		if(DiagramUtil.getLinkedModelForDiagram(getDiagram()) != null) {
		   if(PropertyUtil.isDiagram_KindValue(getDiagram(), DIAGRAM_KIND_MAIN_DIAGRAM) ||
			  PropertyUtil.isDiagram_KindValue(getDiagram(), DIAGRAM_KIND_GROUP_DIAGRAM))
				return true && EditPolicyService.canCreate(createContext, this.getDiagram());
		}   
		return false;
	}

	/**
	 * creates the business objects of the natural type, adds it to model of the diagram in which the natural type is 
	 * created in and calls the add function for the natural type
	 * <p>
	 * It creates the following structure:<br>
	 * <ul>
	 *   <li>(org.framed.iorm.model.Shape) natural type</li>
	 * 	   <ul>
	 * 	     <li>(Segment) first segment (for attributes)</li> 
	 *  	 <li>(Segment) second segment (for operations)</li> 
	 * 	   </ul>
	 * </ul> 
	 * <p>
	 * It follows this steps:<br>
	 * Step 1: It creates the structure shown above.<br>
	 * Step 2: It adds the new natural type to the elements of the model of the diagram in which its created.<br>
	 * Step 3: It call the add function to add the pictogram elements of the natural type.
	 * @return the created business object of the natural type
	 */
	@Override
	public Object[] create(ICreateContext createContext) {
		//Step 1
		//natural type
		org.framed.iorm.model.Shape newNaturalType = OrmFactory.eINSTANCE.createShape();
		newNaturalType.setType(Type.NATURAL_TYPE);
		String standardName = NameUtil.calculateStandardNameForClass(getDiagram(), Type.NATURAL_TYPE, STANDARD_NATURALTYPE_NAME);
		newNaturalType.setName(standardName);
		//create segments
		Segment attributeSegment = OrmFactory.eINSTANCE.createSegment(),
				operationSegment = OrmFactory.eINSTANCE.createSegment();
		getDiagram().eResource().getContents().add(attributeSegment);
		getDiagram().eResource().getContents().add(operationSegment);
		newNaturalType.setFirstSegment(attributeSegment);
		newNaturalType.setSecondSegment(operationSegment);
		
		//Step 2
		Model model = DiagramUtil.getLinkedModelForDiagram((Diagram) getDiagram());
		if(newNaturalType.eResource() != null) getDiagram().eResource().getContents().add(newNaturalType);
		model.getElements().add(newNaturalType);
		newNaturalType.setContainer(model);
	
		//Step 3
		addGraphicalRepresentation(createContext, newNaturalType);
		return new Object[] { newNaturalType };
	}
		
	//direct editing
	//~~~~~~~~~~~~~~
	/**
	 * sets the editing type as a text field for the direct editing of the natural types name
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
	 * 	   of the type {@link Type#NATURAL_TYPE} and<br>
	 * (2) the graphics algorithm of the pictogram element is a {@link Text}
	 * @return if the selected pictogram can be direct edited
	 */
	@Override
	public boolean canDirectEdit(IDirectEditingContext editingContext) {
		Object businessObject = getBusinessObject(editingContext);
		GraphicsAlgorithm graphicsAlgorithm = editingContext.getGraphicsAlgorithm();
		if(businessObject instanceof org.framed.iorm.model.Shape && graphicsAlgorithm instanceof Text) {
			org.framed.iorm.model.Shape shape = (org.framed.iorm.model.Shape) businessObject;
			if(shape.getType() == Type.NATURAL_TYPE) {
				return true;
		}	}
		return false;
	}

	/**
	 * returns the current natural types name as initial value for direct editing
	 */
	@Override
	public String getInitialValue(IDirectEditingContext editingContext) {
		org.framed.iorm.model.Shape naturalType = (org.framed.iorm.model.Shape) getBusinessObject(editingContext);
		return naturalType.getName();
	}
	
	/**
	 * calculates if a chosen value for the natural types name is valid
	 * <p>
	 * A valid value is a specific form checked by {@link NameUtil#matchesIdentifier} and is not already
	 * chosen for another natural type. This is checked by {@link NameUtil#nameAlreadyUsedForClassOrRole}.
	 * @return if a chosen value for the natural types name is valid
	 */
	@Override
	public String checkValueValid(String newName, IDirectEditingContext editingContext) {
		if(getInitialValue(editingContext).contentEquals(newName)) return null;
		if(!(NameUtil.matchesIdentifier(newName))) return DIRECTEDITING_NATURALTYPE;
		if(NameUtil.nameAlreadyUsedForClass(getDiagram(), Type.NATURAL_TYPE, newName)) 
			return NAME_ALREADY_USED_NATURALTYPE;
        return null;
	}
	
	/**
	 * sets value of the natural types name, updates its own pictogram element and a group in which its in, if any
	 */
	@Override
	public void setValue(String value, IDirectEditingContext editingContext) {	     
		org.framed.iorm.model.Shape naturalType = (org.framed.iorm.model.Shape) getBusinessObject(editingContext);
		naturalType.setName(value);
	    updatePictogramElement(((Shape) editingContext.getPictogramElement()).getContainer());
	    updateContainingGroupOrCompartmentType();
	}
	
	//layout feature
	//~~~~~~~~~~~~~~
	/**
	 * calculates if a pictogram element of a natural type can be layouted
	 * <p>
	 * returns true if:<br>
	 * (1) if exactly one pictogram element is given by the layout context
	 * (2) the business object of the pictogram element is a {@link org.framed.iorm.model.Shape} 
	 * 	   of the type {@link Type#NATURAL_TYPE} 
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
					if(shape.getType() == Type.NATURAL_TYPE) return true;
				}
			}
		}
		return false;
	}

	/**
	 * layout the whole natural type using the following steps:
	 * <p>
	 * Step 1: Its fetches the type body shape and drop shadow shape<br>
	 * Step 2: It calculates the new height, width and horizontal center. It also uses this data to set
	 * 		   the size of the type body and drop shadow shape.<br>
	 * Step 3: It now iterates over all shapes of the natural type:<br>
	 * (a) It sets the width of the names shape.<br>
	 * (b) It sets the points of the lines that separate the name, attribute container and operation container shapes.<br>
	 * (c) It layouts the visualization of the attributes in the attribute container shape.<br>
	 * (d) It layouts the visualization of the operations in the operation container shape.
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
		if(!(PropertyUtil.isShape_IdValue(container, SHAPE_ID_NATURALTYPE_TYPEBODY))) return false;
		else {	
			Rectangle typeBodyRectangle = (Rectangle) container.getGraphicsAlgorithm(); 
			Rectangle dropShadowRectangle = (Rectangle) container.getContainer().getChildren().get(0).getGraphicsAlgorithm();
		    //Step 2
	        if(typeBodyRectangle.getWidth() < MIN_WIDTH) typeBodyRectangle.setWidth(MIN_WIDTH);
			if(typeBodyRectangle.getHeight() < MIN_HEIGHT) typeBodyRectangle.setHeight(MIN_HEIGHT);
			int width = typeBodyRectangle.getWidth();
	        int height = typeBodyRectangle.getHeight();
	        int horizontalCenter = GeneralUtil.calculateHorizontalCenter(Type.NATURAL_TYPE, height);
	        dropShadowRectangle.setWidth(width);
	        dropShadowRectangle.setHeight(height);
	        dropShadowRectangle.setX(typeBodyRectangle.getX()+SHADOW_SIZE);
	        dropShadowRectangle.setY(typeBodyRectangle.getY()+SHADOW_SIZE);
	        
	        //Step 3
	        for (Shape shape : container.getChildren()){
	            GraphicsAlgorithm graphicsAlgorithm = shape.getGraphicsAlgorithm();                         	                 
	            //(a) name
	            if (graphicsAlgorithm instanceof Text) {
	            	Text text = (Text) graphicsAlgorithm;	
	            	if(PropertyUtil.isShape_IdValue(shape, SHAPE_ID_NATURALTYPE_NAME)) {
	            		graphicAlgorithmService.setLocationAndSize(text, 0, 0, width, HEIGHT_NAME_SHAPE);
	            		layoutChanged=true;
	            	}	
	            }
	            //(b) first and second line
	            if (graphicsAlgorithm instanceof Polyline) {	   
		            Polyline polyline = (Polyline) graphicsAlgorithm;  
		            if(PropertyUtil.isShape_IdValue(shape, SHAPE_ID_NATURALTYPE_FIRSTLINE)) {
		            	polyline.getPoints().set(1, graphicAlgorithmService.createPoint(width, polyline.getPoints().get(1).getY()));
		            	layoutChanged=true;
		            }	
		            if(PropertyUtil.isShape_IdValue(shape, SHAPE_ID_NATURALTYPE_SECONDLINE)) {   
		            	polyline.getPoints().set(0, graphicAlgorithmService.createPoint(0, horizontalCenter));
		            	polyline.getPoints().set(1, graphicAlgorithmService.createPoint(width, horizontalCenter));
		            	layoutChanged=true;
		            }
		        }
	            if (graphicsAlgorithm instanceof Rectangle) {
	            	Rectangle rectangle = (Rectangle) graphicsAlgorithm;  
	            	//(c) attribute container shape
		            if(PropertyUtil.isShape_IdValue(shape, SHAPE_ID_NATURALTYPE_ATTRIBUTECONTAINER)) {
		            	//resize and positioning the container
		            	newHeight = horizontalCenter-HEIGHT_NAME_SHAPE-2*PUFFER_BETWEEN_ELEMENTS;
		            	newWidth = (typeBodyRectangle.getWidth()-2*PUFFER_BETWEEN_ELEMENTS);      
		            	newY = HEIGHT_NAME_SHAPE+PUFFER_BETWEEN_ELEMENTS;
		            	rectangle.setHeight(newHeight);
		            	rectangle.setWidth(newWidth);
		            	ContainerShape attributeContainerShape = (ContainerShape) shape;	       
		            	EList<Shape> attributes = attributeContainerShape.getChildren();
		            	//set places of attributes
		            	for(int m = 0; m<attributes.size(); m++) {
		            		Text attributeText = (Text) attributeContainerShape.getChildren().get(m).getGraphicsAlgorithm();
			            	attributeText.setY(newY+m*HEIGHT_OPERATION_SHAPE);
			            	attributeText.setWidth(newWidth);
	            		}   	
		            	//set all attributes visible and delete indicator dots
		            	indicatorDotsShapeToDelete = null;
		            	for(int j = 0; j<attributes.size(); j++) {
		            		attributes.get(j).setVisible(true);	   
		            		if(PropertyUtil.isShape_IdValue(attributes.get(j), SHAPE_ID_ATTRIBUTE_INDICATOR_DOTS))
					    		 indicatorDotsShapeToDelete = attributes.get(j);
		            	}
		            	attributeContainerShape.getChildren().remove(indicatorDotsShapeToDelete);
		            	//check if not all attributes fit in the attribute field
		            	if(attributeContainerShape.getChildren().size()*HEIGHT_ATTRIBUTE_SHAPE>newHeight) {	            		
		            		int fittingAttributes = (newHeight-HEIGHT_ATTRIBUTE_SHAPE)/HEIGHT_ATTRIBUTE_SHAPE;	   
		            		//set not fitting attributes to invisible
		            		for(int k = fittingAttributes; k<attributes.size(); k++) {
		            			attributeContainerShape.getChildren().get(k).setVisible(false);
		            		}	 
		            		//add dots to indicate that not all attributes fit
		            		Shape indicatorDotsShape = pictogramElementCreateService.createShape(attributeContainerShape, true); 
				            Text indicatorDots = graphicAlgorithmService.createText(indicatorDotsShape, "...");
				            indicatorDots.setForeground(manageColor(COLOR_TEXT));
				            graphicAlgorithmService.setLocationAndSize(indicatorDots, 
				            	PUFFER_BETWEEN_ELEMENTS, HEIGHT_ATTRIBUTE_SHAPE+fittingAttributes*HEIGHT_ATTRIBUTE_SHAPE, 
				            	newWidth-2*PUFFER_BETWEEN_ELEMENTS, HEIGHT_OPERATION_SHAPE-2*PUFFER_BETWEEN_ELEMENTS);
				           	PropertyUtil.setShape_IdValue(indicatorDotsShape, SHAPE_ID_ATTRIBUTE_INDICATOR_DOTS);
		            	}	            			
		            	layoutChanged=true;
		            }
		            //(d) operation container shape
		            if(PropertyUtil.isShape_IdValue(shape, SHAPE_ID_NATURALTYPE_OPERATIONCONTAINER)) {
		            	//resize and positioning the container
		            	newHeight = horizontalCenter-HEIGHT_NAME_SHAPE-2*PUFFER_BETWEEN_ELEMENTS;
		            	newWidth = width-2*PUFFER_BETWEEN_ELEMENTS;		
		            	newY = horizontalCenter+PUFFER_BETWEEN_ELEMENTS;	            	
		            	rectangle.setHeight(newHeight);
		            	rectangle.setWidth(newWidth);
		            	rectangle.setY(newY);
		            	ContainerShape operationContainerShape = (ContainerShape) shape;
		            	EList<Shape> operations = operationContainerShape.getChildren();
		            	//set place of operations
		            	for(int m = 0; m<operations.size(); m++) {
		            		Text operationText = (Text) operationContainerShape.getChildren().get(m).getGraphicsAlgorithm();
			            	operationText.setY(newY+m*HEIGHT_OPERATION_SHAPE);
			            	operationText.setWidth(newWidth);
	            		}
		            	//set all operations visible
					    indicatorDotsShapeToDelete = null;
					    for(int n = 0; n<operations.size(); n++) {
					    	operations.get(n).setVisible(true);
					    	 if(PropertyUtil.isShape_IdValue(operations.get(n), SHAPE_ID_OPERATION_INDICATOR_DOTS))
					    		 indicatorDotsShapeToDelete = operations.get(n);
					    }
					    operationContainerShape.getChildren().remove(indicatorDotsShapeToDelete);
					    //check if not all operations fit in the operations field
					    if(operations.size()*HEIGHT_OPERATION_SHAPE>newHeight) {	            		
					       	int fittingOperations = (newHeight-HEIGHT_OPERATION_SHAPE)/HEIGHT_OPERATION_SHAPE;	   
					       	//set not fitting operations to invisible
					       	for(int o = fittingOperations; o<operations.size(); o++) {
					       		operationContainerShape.getChildren().get(o).setVisible(false);            				
					       	}   	
					       	//add dots to indicate that not all operations fit
					       	Shape indicatorDotsShape = pictogramElementCreateService.createShape(operationContainerShape, true); 
				            Text indicatorDots = graphicAlgorithmService.createText(indicatorDotsShape, "...");
				            indicatorDots.setForeground(manageColor(COLOR_TEXT));
				            graphicAlgorithmService.setLocationAndSize(indicatorDots, 
				            	PUFFER_BETWEEN_ELEMENTS, newY+fittingOperations*HEIGHT_OPERATION_SHAPE, 
				            	newWidth-2*PUFFER_BETWEEN_ELEMENTS, HEIGHT_OPERATION_SHAPE);
				           	PropertyUtil.setShape_IdValue(indicatorDotsShape, SHAPE_ID_OPERATION_INDICATOR_DOTS);
					    } 	
					    layoutChanged=true;
		}   }	}	}        
		return layoutChanged;
	}
	
	//update feature
	//~~~~~~~~~~~~~~
	@Override
	public boolean canUpdate(IUpdateContext updateContext) {
		//check if object to update is a Natural Type
		PictogramElement pictogramElement = updateContext.getPictogramElement();
		Object businessObject =  getBusinessObjectForPictogramElement(pictogramElement);
		if(businessObject instanceof org.framed.iorm.model.Shape) {
			org.framed.iorm.model.Shape shape = (org.framed.iorm.model.Shape) businessObject;
			if(shape.getType() == Type.NATURAL_TYPE) {
				return true;
		}	}
		return false;
	}

	@Override
	public IReason updateNeeded(IUpdateContext updateContext) {
		PictogramElement pictogramElement = updateContext.getPictogramElement();
		
		if(pictogramElement.getGraphicsAlgorithm() != null &&
		   PropertyUtil.isShape_IdValue((Shape) pictogramElement, SHAPE_ID_NATURALTYPE_TYPEBODY)) {
			//pictogram name of natural type, attributes and operations
			String pictogramTypeName = ShapePatternUtil.getNameOfPictogramElement(pictogramElement, SHAPE_ID_NATURALTYPE_NAME);
			List<String> pictogramAttributeNames = ShapePatternUtil.getpictogramAttributeNames(pictogramElement, SHAPE_ID_NATURALTYPE_ATTRIBUTECONTAINER);
			List<String> pictogramOperationNames = ShapePatternUtil.getpictogramOperationNames(pictogramElement, SHAPE_ID_NATURALTYPE_OPERATIONCONTAINER);
			//business name and attributes
			String businessTypeName = ShapePatternUtil.getNameOfBusinessObject(getBusinessObjectForPictogramElement(pictogramElement));
			List<String> businessAttributeNames = ShapePatternUtil.getBusinessAttributeNames(pictogramElement, SHAPE_ID_NATURALTYPE_ATTRIBUTECONTAINER);
			List<String> businessOperationNames = ShapePatternUtil.getBusinessOperationNames(pictogramElement, SHAPE_ID_NATURALTYPE_OPERATIONCONTAINER);
								
			//check for update: different names, different amount of attibutes/ operations
			if(pictogramTypeName==null || businessTypeName==null) return Reason.createTrueReason(REASON_NAME_NULL);
			if(!(pictogramTypeName.equals(businessTypeName))) return Reason.createTrueReason(REASON_NAME_OUT_OF_DATE);  
			if(pictogramAttributeNames.size() != businessAttributeNames.size()) return Reason.createTrueReason(REASON_AMOUNT_ATTRIBUTES);
			if(pictogramOperationNames.size() != businessOperationNames.size()) return Reason.createTrueReason(REASON_AMOUNT_OPERATION);
			for(int i=0; i<pictogramAttributeNames.size(); i++) {
				if(!(pictogramAttributeNames.get(i).equals(businessAttributeNames.get(i)))) return Reason.createTrueReason(REASON_NAMES_ATTRIBUTES);
			}	
			for(int i=0; i<pictogramOperationNames.size(); i++) {
				if(!(pictogramOperationNames.get(i).equals(businessOperationNames.get(i)))) return Reason.createTrueReason(REASON_NAMES_OPERATIONS);
		}	}
		return Reason.createFalseReason();
	}
	
	@Override
	public boolean update(IUpdateContext updateContext) {
		int counter;
		boolean changed = false;
         
		PictogramElement pictogramElement = updateContext.getPictogramElement();
		
		//business names of natural type, attributes and operations
		String businessTypeName = ShapePatternUtil.getNameOfBusinessObject(getBusinessObjectForPictogramElement(pictogramElement));
		List<String> businessAttributeNames = ShapePatternUtil.getBusinessAttributeNames(pictogramElement, SHAPE_ID_NATURALTYPE_ATTRIBUTECONTAINER);
		List<String> businessOperationNames = ShapePatternUtil.getBusinessOperationNames(pictogramElement, SHAPE_ID_NATURALTYPE_OPERATIONCONTAINER);
		
		//set type name in pictogram model
        if (pictogramElement instanceof ContainerShape) {     
            ContainerShape containerShape = (ContainerShape) pictogramElement;
            for (Shape shape : containerShape.getChildren()) {
                if (shape.getGraphicsAlgorithm() instanceof Text) {
                    Text text = (Text) shape.getGraphicsAlgorithm();
                    if(PropertyUtil.isShape_IdValue(shape, SHAPE_ID_NATURALTYPE_NAME)) {
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
						if(PropertyUtil.isShape_IdValue(innerContainerShape, SHAPE_ID_NATURALTYPE_ATTRIBUTECONTAINER)) {
							for(Shape attributeShape : innerContainerShape.getChildren()) {
								if(PropertyUtil.isShape_IdValue(attributeShape, SHAPE_ID_ATTRIBUTE_TEXT)) {
									Text text = (Text) attributeShape.getGraphicsAlgorithm();
									text.setValue(businessAttributeNames.get(counter));
									changed = true;
									counter++;
						}	}	}
						//Operations
						counter = 0;
						if(PropertyUtil.isShape_IdValue(innerContainerShape, SHAPE_ID_NATURALTYPE_OPERATIONCONTAINER)) {
							for(Shape operationShape : innerContainerShape.getChildren()) {
								if(PropertyUtil.isShape_IdValue(operationShape, SHAPE_ID_OPERATION_TEXT)) {
									Text text = (Text) operationShape.getGraphicsAlgorithm();
									text.setValue(businessOperationNames.get(counter));									
									changed = true;
									counter++;
		}	}	}	}	}	}	}        
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
		if(PropertyUtil.isShape_IdValue((Shape) moveContext.getPictogramElement(), SHAPE_ID_NATURALTYPE_SHADOW)) {
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
	/**
	 * disables that the user can resize the drop shadow manually
	 */
	@Override
	public boolean canResizeShape(IResizeShapeContext resizeContext) {
		if(PropertyUtil.isShape_IdValue((Shape) resizeContext.getPictogramElement(), SHAPE_ID_NATURALTYPE_SHADOW)) {
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
		if(PropertyUtil.isShape_IdValue((Shape) deleteContext.getPictogramElement(), SHAPE_ID_NATURALTYPE_SHADOW)) {
			return false;
		}
		return super.canDelete(deleteContext);
	}
		
	/**
	 * deletes the container shape of the natural type instead of the type body and updates the group the natural type is in,
	 * if any and deletes attached connection to it
	 * <p>
	 * If its not clear what the different shapes means, see {@link #add} for reference.
	 */
	@Override
	public void delete(IDeleteContext deleteContext) {
		deleteAttachedConnections(deleteContext);
		ContainerShape containerShape = (ContainerShape) ((ContainerShape) deleteContext.getPictogramElement()).getContainer();
		DeleteContext deleteContextForAllShapes = new DeleteContext(containerShape);
		deleteContextForAllShapes.setMultiDeleteInfo(new MultiDeleteInfo(false, false, 0));
		super.delete(deleteContextForAllShapes);
		updateContainingGroupOrCompartmentType();
	}
}
