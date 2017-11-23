package org.framed.iorm.ui.pattern.shapes;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IDeleteFeature;
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
import org.eclipse.graphiti.util.IColorConstant;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.framed.iorm.model.Model;
import org.framed.iorm.model.ModelElement;
import org.framed.iorm.model.OrmFactory;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.contexts.AddGroupOrCompartmentTypeContext;
import org.framed.iorm.ui.editPolicy.EditPolicyHandler;
import org.framed.iorm.ui.exceptions.NoDiagramFoundException;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.literals.LayoutLiterals;
import org.framed.iorm.ui.literals.NameLiterals;
import org.framed.iorm.ui.literals.TextLiterals;
import org.framed.iorm.ui.util.DiagramUtil;
import org.framed.iorm.ui.util.EditorInputUtil;
import org.framed.iorm.ui.util.NameUtil;
import org.framed.iorm.ui.util.GeneralUtil;
import org.framed.iorm.ui.util.ShapePatternUtil;
import org.framed.iorm.ui.util.PropertyUtil;
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
	 * name literals gathered from {@link NameLiterals}
	 * <p>
	 * can be:<br>
	 * (1) the name of the create feature in this pattern or<br>
	 * (2) the standard names for group
	 */
	private final String GROUP_FEATURE_NAME = NameLiterals.GROUP_FEATURE_NAME,
				   		 STANDARD_GROUP_NAME = NameLiterals.STANDARD_GROUP_NAME;
	
	/**
	 * text literals gathered from {@link TextLiterals}
	 * <p>
	 * can be:<br>
	 * (1) the message if the form of a chosen group name is not correct when direct editing or<br>
	 * (2) the message if a chosen name for a group is already used when direct editing
	 */
	private final String DIRECTEDITING_GROUP = TextLiterals.DIRECTEDITING_GROUP,
				         NAME_ALREADY_USED_GROUP = TextLiterals.NAME_ALREADY_USED_GROUP;
	
	/**
	 * identifier literals used as shape ids for the group
	 * <p>
	 * See {@link IdentifierLiterals} for the meaning of the identifiers.
	 */
	private final String SHAPE_ID_GROUP_CONTAINER = IdentifierLiterals.SHAPE_ID_GROUP_CONTAINER,
				   		 SHAPE_ID_GROUP_TYPEBODY = IdentifierLiterals.SHAPE_ID_GROUP_TYPEBODY,
				   		 SHAPE_ID_GROUP_SHADOW = IdentifierLiterals.SHAPE_ID_GROUP_SHADOW,
				   		 SHAPE_ID_GROUP_NAME = IdentifierLiterals.SHAPE_ID_GROUP_NAME, 
				   		 SHAPE_ID_GROUP_LINE = IdentifierLiterals.SHAPE_ID_GROUP_LINE,
				   		 SHAPE_ID_GROUP_CONTENT_PREVIEW = IdentifierLiterals.SHAPE_ID_GROUP_CONTENT_PREVIEW,
				   		 SHAPE_ID_GROUP_ELEMENT = IdentifierLiterals.SHAPE_ID_GROUP_ELEMENT,
				   		 SHAPE_ID_GROUPS_INDICATOR_DOTS = IdentifierLiterals.SHAPE_ID_GROUPS_INDICATOR_DOTS;
	
	/**
	 * value of the property shape id for a container shape and a type body shape of a compartment type
	 */
	private final String SHAPE_ID_COMPARTMENTTYPE_CONTAINER = IdentifierLiterals.SHAPE_ID_COMPARTMENTTYPE_CONTAINER,
						 SHAPE_ID_COMPARTMENTTYPE_TYPEBODY = IdentifierLiterals.SHAPE_ID_COMPARTMENTTYPE_TYPEBODY;

	/**
	 * identifier literals used for the groups content diagram gathered from {@link IdentifierLiterals}
	 * <p>
	 * Also for the diagrams in which a group type can be created and added in
	 */
	private final String DIAGRAM_KIND_GROUP_DIAGRAM = IdentifierLiterals.DIAGRAM_KIND_GROUP_DIAGRAM,
						 DIAGRAM_TYPE = IdentifierLiterals.DIAGRAM_TYPE_ID,
						 DIAGRAM_KIND_MAIN_DIAGRAM = IdentifierLiterals.DIAGRAM_KIND_MAIN_DIAGRAM;
		
	/**
	 * the image identifier for the icon of the create feature in this pattern gathered from
	 * {@link IdentifierLiterals}
	 */
	private final String IMG_ID_FEATURE_GROUP = IdentifierLiterals.IMG_ID_FEATURE_GROUP;
	
	/**
	 * reason messages used in the operation {@link #updateNeeded} gathered from {@link TextLiterals}
	 */
	private final String REASON_NAME_NULL = TextLiterals.REASON_NAME_NULL,
					 	 REASON_NAME_OUT_OF_DATE = TextLiterals.REASON_NAME_OUT_OF_DATE,
					 	 REASON_AMOUNT_GROUP_ELEMENTS = TextLiterals.REASON_AMOUNT_ELEMENTS,
						 REASON_NAMES_GROUP_ELEMENTS = TextLiterals.REASON_NAMES_ELEMENTS;
				   		
	/**
	 * layout integers gathered from {@link IdentifierLiterals}, look there for reference
	 */
	private final int MIN_WIDTH = LayoutLiterals.MIN_WIDTH_FOR_CLASS_OR_ROLE,
					  MIN_HEIGHT = LayoutLiterals.MIN_HEIGHT_FOR_CLASS_OR_ROLE,
					  HEIGHT_NAME_SHAPE = LayoutLiterals.HEIGHT_NAME_SHAPE,
					  PUFFER_BETWEEN_ELEMENTS = LayoutLiterals.PUFFER_BETWEEN_ELEMENTS,
					  GROUP_CORNER_RADIUS = LayoutLiterals.GROUP_CORNER_RADIUS,
					  SHADOW_SIZE = LayoutLiterals.SHADOW_SIZE,
					  HEIGHT_GROUP_ELEMENT_SHAPE = LayoutLiterals.HEIGHT_ELEMENT_SHAPE;
	
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
	public GroupPattern() {
		super();
	}
	
	/**
	 * get method for the create features name
	 * @return the name of the create feature
	 */
	@Override
	public String getCreateName() {
		return GROUP_FEATURE_NAME;
	}
	
	/**
	 * enables the icon for the create feature in this pattern
	 * @return the image identifier for the icon of the create feature in this pattern
	 */
	@Override
	public String getCreateImageId() {
		return IMG_ID_FEATURE_GROUP;
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
	 * (2) if the target container is a diagram with a model linked and<br>
	 * (3) the target container is the main diagram or a diagram of group
	 * @return if the group can be added
	 */
	@Override
	public boolean canAdd(IAddContext addContext) {
		if(addContext.getNewObject() instanceof org.framed.iorm.model.Shape) {
			org.framed.iorm.model.Shape shape = (org.framed.iorm.model.Shape) addContext.getNewObject();
			if(shape.getType()==Type.GROUP) {
				ContainerShape containerShape = getDiagram();
				if(containerShape instanceof Diagram) {
					if(DiagramUtil.getLinkedModelForDiagram((Diagram) containerShape) != null) {
						if(PropertyUtil.isDiagram_KindValue(getDiagram(), DIAGRAM_KIND_MAIN_DIAGRAM) ||
						   PropertyUtil.isDiagram_KindValue(getDiagram(), DIAGRAM_KIND_GROUP_DIAGRAM))
							   return true && EditPolicyHandler.canAdd(addContext, this.getDiagram());
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
		if(addContext.getWidth() < MIN_WIDTH) width = MIN_WIDTH;
		if(addContext.getHeight() < MIN_HEIGHT) height = MIN_HEIGHT;
		
		//Step 2		
		//container shape
		ContainerShape containerShape = pictogramElementCreateService.createContainerShape(targetDiagram, false);
		
		//drop shadow shape and drop shadow rectangle
		ContainerShape dropShadowShape = pictogramElementCreateService.createContainerShape(containerShape, true);
		RoundedRectangle dropShadowRectangle = graphicAlgorithmService.createRoundedRectangle(dropShadowShape, GROUP_CORNER_RADIUS, GROUP_CORNER_RADIUS);
		dropShadowRectangle.setForeground(manageColor(COLOR_SHADOW));
		dropShadowRectangle.setBackground(manageColor(COLOR_SHADOW));
		graphicAlgorithmService.setLocationAndSize(dropShadowRectangle, addContext.getX()+SHADOW_SIZE, addContext.getY()+SHADOW_SIZE, width, height);
		
		//type body shape and type body shape rectangle
		ContainerShape typeBodyShape = pictogramElementCreateService.createContainerShape(containerShape, true);	
		pictogramElementCreateService.createChopboxAnchor(typeBodyShape);
		RoundedRectangle typeBodyRectangle = graphicAlgorithmService.createRoundedRectangle(typeBodyShape, GROUP_CORNER_RADIUS, GROUP_CORNER_RADIUS);
		typeBodyRectangle.setForeground(manageColor(COLOR_LINES));
		typeBodyRectangle.setBackground(manageColor(COLOR_BACKGROUND));
		graphicAlgorithmService.setLocationAndSize(typeBodyRectangle, addContext.getX(), addContext.getY(), width, height);
		
		//name container and name text
		Shape nameShape = pictogramElementCreateService.createShape(typeBodyShape, false);
		Text text = graphicAlgorithmService.createText(nameShape, addedGroup.getName());	
		text.setForeground(manageColor(COLOR_TEXT));	
		text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);	
		graphicAlgorithmService.setLocationAndSize(text, 0, 0, width, HEIGHT_NAME_SHAPE);	
		
		//line container and polyline
		Shape firstLineShape = pictogramElementCreateService.createShape(typeBodyShape, false);
		Polyline firstPolyline = graphicAlgorithmService.createPolyline(firstLineShape, new int[] {0, HEIGHT_NAME_SHAPE, width, HEIGHT_NAME_SHAPE});
		firstPolyline.setForeground(manageColor(COLOR_LINES));		
	
		//model content preview container
		ContainerShape modelContainer = pictogramElementCreateService.createContainerShape(typeBodyShape, false);
		Rectangle modelRectangle = graphicAlgorithmService.createRectangle(modelContainer);
		modelRectangle.setLineVisible(false);
		modelRectangle.setBackground(manageColor(COLOR_BACKGROUND));
		graphicAlgorithmService.setLocationAndSize(modelRectangle, PUFFER_BETWEEN_ELEMENTS, HEIGHT_NAME_SHAPE+PUFFER_BETWEEN_ELEMENTS, 
												   width-2*PUFFER_BETWEEN_ELEMENTS, height-GROUP_CORNER_RADIUS);
		
		//groups diagram
		Diagram contentDiagram = pictogramElementCreateService.createDiagram(DIAGRAM_TYPE, addedGroup.getName(), 10, true);
		PropertyUtil.setDiagram_KindValue(contentDiagram, DIAGRAM_KIND_GROUP_DIAGRAM);
		AddGroupOrCompartmentTypeContext agctc = (AddGroupOrCompartmentTypeContext) addContext;
		link(contentDiagram, agctc.getModelToLink());
		getDiagram().getContainer().getChildren().add(contentDiagram);
		
		//Step 3
		PropertyUtil.setShape_IdValue(containerShape, SHAPE_ID_GROUP_CONTAINER);
		PropertyUtil.setShape_IdValue(typeBodyShape, SHAPE_ID_GROUP_TYPEBODY);
		PropertyUtil.setShape_IdValue(dropShadowShape, SHAPE_ID_GROUP_SHADOW);
		PropertyUtil.setShape_IdValue(nameShape, SHAPE_ID_GROUP_NAME);
		PropertyUtil.setShape_IdValue(firstLineShape, SHAPE_ID_GROUP_LINE);
		PropertyUtil.setShape_IdValue(modelContainer, SHAPE_ID_GROUP_CONTENT_PREVIEW);
		
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
		updateContainingGroupOrCompartmentType();
		return containerShape;
	}
		
	//create feature
	//~~~~~~~~~~~~~~
	/**
	 * calculates if a group can be created
	 * <p>
	 * returns true if:<br>
	 * (1) the target container is a diagram with a model linked
	 * (2) the target container is the main diagram or a diagram of group 
	 * @return if an group can be created
	 */
	@Override
	public boolean canCreate(ICreateContext createContext) {
		if(DiagramUtil.getLinkedModelForDiagram(getDiagram()) != null) {
		   if(PropertyUtil.isDiagram_KindValue(getDiagram(), DIAGRAM_KIND_MAIN_DIAGRAM) ||
			  PropertyUtil.isDiagram_KindValue(getDiagram(), DIAGRAM_KIND_GROUP_DIAGRAM))
				return true && EditPolicyHandler.canCreate(createContext, this.getDiagram());
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
		String standardName = NameUtil.calculateStandardNameForClass(getDiagram(), Type.GROUP, STANDARD_GROUP_NAME);
		newGroup.setName(standardName);
		//model
		Model groupModel = OrmFactory.eINSTANCE.createModel();
		getDiagram().eResource().getContents().add(groupModel);
		newGroup.setModel(groupModel);
		
		//Step 2
		Model model = DiagramUtil.getLinkedModelForDiagram((Diagram) getDiagram());
		if(newGroup.eResource() != null) getDiagram().eResource().getContents().add(newGroup);
		model.getElements().add(newGroup);
		newGroup.setContainer(model);
				
		//Step 3
		AddGroupOrCompartmentTypeContext agctc = new AddGroupOrCompartmentTypeContext();
		GeneralUtil.getAddContextForCreateShapeContext(agctc, createContext);
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
		if(!(NameUtil.matchesIdentifier(newName))) return DIRECTEDITING_GROUP;
		if(NameUtil.nameAlreadyUsedForClass(getDiagram(), Type.GROUP, newName)) 
			return NAME_ALREADY_USED_GROUP;
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
		updateContainingGroupOrCompartmentType();
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
		if(!(PropertyUtil.isShape_IdValue(container, SHAPE_ID_GROUP_TYPEBODY))) return false;
		else {
			RoundedRectangle typeBodyRectangle = (RoundedRectangle) container.getGraphicsAlgorithm(); 
			RoundedRectangle dropShadowRectangle = (RoundedRectangle) container.getContainer().getChildren().get(0).getGraphicsAlgorithm();
			//Step 2
			if(typeBodyRectangle.getWidth() < MIN_WIDTH) typeBodyRectangle.setWidth(MIN_WIDTH);
			if(typeBodyRectangle.getHeight() < MIN_HEIGHT) typeBodyRectangle.setHeight(MIN_HEIGHT);
			int containerWidth = typeBodyRectangle.getWidth();
		    int containerHeight = typeBodyRectangle.getHeight();
		    dropShadowRectangle.setWidth(containerWidth);
		    dropShadowRectangle.setHeight(containerHeight);
		    dropShadowRectangle.setX(typeBodyRectangle.getX()+SHADOW_SIZE);
		    dropShadowRectangle.setY(typeBodyRectangle.getY()+SHADOW_SIZE);
		    //Step 3    
		    for (Shape shape : container.getChildren()){
		    	GraphicsAlgorithm graphicsAlgorithm = shape.getGraphicsAlgorithm();                         	                 
		        //(a) name shape
		        if (graphicsAlgorithm instanceof Text) {
		        	Text text = (Text) graphicsAlgorithm;	
		            if(PropertyUtil.isShape_IdValue(shape, SHAPE_ID_GROUP_NAME)) {
		            	graphicAlgorithmService.setLocationAndSize(text, 0, 0, containerWidth, HEIGHT_NAME_SHAPE);
		            	layoutChanged=true;
		        }	}
		        ///(b) line
		        if (graphicsAlgorithm instanceof Polyline) {	   
		        	Polyline polyline = (Polyline) graphicsAlgorithm;  
		        	if(PropertyUtil.isShape_IdValue(shape, SHAPE_ID_GROUP_LINE)) {
			            polyline.getPoints().set(1, graphicAlgorithmService.createPoint(containerWidth, polyline.getPoints().get(1).getY()));
			            layoutChanged=true;
			    }	}
		        if (graphicsAlgorithm instanceof Rectangle) {
		        	Rectangle rectangle = (Rectangle) graphicsAlgorithm; 
		        	//(c) content preview container
			        if(PropertyUtil.isShape_IdValue(shape, SHAPE_ID_GROUP_CONTENT_PREVIEW)) {
			        	//resize and positioning the container
			        	int newHeight = (containerHeight-GROUP_CORNER_RADIUS),
			            	newWidth = (containerWidth-2*PUFFER_BETWEEN_ELEMENTS);            				
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
		            				PUFFER_BETWEEN_ELEMENTS, HEIGHT_NAME_SHAPE+PUFFER_BETWEEN_ELEMENTS+HEIGHT_GROUP_ELEMENT_SHAPE*counter, 
			            			newWidth-2*PUFFER_BETWEEN_ELEMENTS, HEIGHT_GROUP_ELEMENT_SHAPE);
		            		if(PropertyUtil.isShape_IdValue(elementShape, SHAPE_ID_GROUPS_INDICATOR_DOTS))
		            			indicatorDotsShapeToDelete = elementShape;
		            		counter++;
		            	}
		            	groupElementsShape.getChildren().remove(indicatorDotsShapeToDelete);
		            	//check if not all elements fit in the attribute field
		            	if(groupElements.size()*HEIGHT_GROUP_ELEMENT_SHAPE > newHeight) {	            		
		            		int fittingAttributes = (newHeight-HEIGHT_GROUP_ELEMENT_SHAPE)/HEIGHT_GROUP_ELEMENT_SHAPE;	   
		            		//set not fitting elements invisible
		            		for(int k = fittingAttributes; k<groupElements.size(); k++) {
		            			groupElements.get(k).setVisible(false);            				
		            		}	
		            		//add dots to indicate that not all elements fit
		            		Shape indicatorDotsShape = pictogramElementCreateService.createShape(groupElementsShape, true); 
		            		Text indicatorDots = graphicAlgorithmService.createText(indicatorDotsShape, "...");
		            		indicatorDots.setForeground(manageColor(COLOR_TEXT));
		            		graphicAlgorithmService.setLocationAndSize(indicatorDots, 
		            				PUFFER_BETWEEN_ELEMENTS, HEIGHT_NAME_SHAPE+fittingAttributes*HEIGHT_GROUP_ELEMENT_SHAPE, 
		            				newWidth-2*PUFFER_BETWEEN_ELEMENTS, HEIGHT_GROUP_ELEMENT_SHAPE);
		            		PropertyUtil.setShape_IdValue(indicatorDotsShape, SHAPE_ID_GROUPS_INDICATOR_DOTS); 
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
		
		if(PropertyUtil.isShape_IdValue((Shape) pictogramElement, SHAPE_ID_GROUP_TYPEBODY)) {
			//pictogram name of natural type, attributes and operations
			String pictogramTypeName = ShapePatternUtil.getNameOfPictogramElement(pictogramElement, SHAPE_ID_GROUP_NAME);
			//business name and attributes
			String businessTypeName = ShapePatternUtil.getNameOfBusinessObject(getBusinessObjectForPictogramElement(pictogramElement));
			//model element names in groups model
			//at creation no diagram is existing so catch this
			List<String> modelElementsNames = null;
			try {
				modelElementsNames = ShapePatternUtil.getGroupOrCompartmentTypeElementNames(pictogramElement, getDiagram(), Type.GROUP);
			} catch(NoDiagramFoundException e) { return Reason.createFalseReason(); }
 			//model element names in model container of shape
			List<String> pictogramElementsNames = ShapePatternUtil.getContentPreviewElementsNames(pictogramElement);		
				
			//check for update: different names, different amount of attibutes/ operations
			if(pictogramTypeName==null || businessTypeName==null) return Reason.createTrueReason(REASON_NAME_NULL);
			if(!(pictogramTypeName.equals(businessTypeName))) return Reason.createTrueReason(REASON_NAME_OUT_OF_DATE);
			if(modelElementsNames.size() != pictogramElementsNames.size()) return Reason.createTrueReason(REASON_AMOUNT_GROUP_ELEMENTS);
			for(int i=0; i<modelElementsNames.size(); i++) {
				modelContainerElementName = pictogramElementsNames.get(i);
				rawModelContainerElementName = modelContainerElementName.substring(modelContainerElementName.indexOf(" ")+1);
				if(!(modelElementsNames.get(i).equals(rawModelContainerElementName))) return Reason.createTrueReason(REASON_NAMES_GROUP_ELEMENTS);
		}	}
		return Reason.createFalseReason();
	}
		
	@Override
	public boolean update(IUpdateContext updateContext) {
		boolean changed = false;
	         
		PictogramElement pictogramElement = updateContext.getPictogramElement();
		String businessTypeName = ShapePatternUtil.getNameOfBusinessObject(getBusinessObjectForPictogramElement(pictogramElement));
			
		//set type name in pictogram model
	    if (pictogramElement instanceof ContainerShape) {     
	    	ContainerShape typeBodyShape = (ContainerShape) pictogramElement;
        	Diagram diagram = DiagramUtil.getGroupOrCompartmentTypeDiagramForItsShape(typeBodyShape, getDiagram(), Type.GROUP);
	        for (Shape shape : typeBodyShape.getChildren()) {
	        	if (shape.getGraphicsAlgorithm() instanceof Text) {
	        		Text text = (Text) shape.getGraphicsAlgorithm();
	                if(PropertyUtil.isShape_IdValue(shape, SHAPE_ID_GROUP_NAME)) {
	                    //change diagram name
	                	diagram.setName(businessTypeName);
	                	//change group name
	                	text.setValue(businessTypeName);
	                	changed = true;
	                }
	        	}    
	        	if (shape.getGraphicsAlgorithm() instanceof Rectangle) {  
	        		if(PropertyUtil.isShape_IdValue(shape, SHAPE_ID_GROUP_CONTENT_PREVIEW)) {
		                ContainerShape modelContainerShape = (ContainerShape) shape;
			            Model groupModel = DiagramUtil.getLinkedModelForDiagram(diagram);
		             
		                modelContainerShape.getChildren().clear();
			            for(ModelElement modelElement : groupModel.getElements()) {
			            	Shape groupElementShape = pictogramElementCreateService.createShape(modelContainerShape, true);
			            	Text groupElementText = graphicAlgorithmService.createText(groupElementShape, ShapePatternUtil.getGroupOrCompartmentTypeElementText(modelElement));
			            	groupElementText.setForeground(manageColor(COLOR_TEXT));
			            	PropertyUtil.setShape_IdValue(groupElementShape, SHAPE_ID_GROUP_ELEMENT);
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
		if(PropertyUtil.isShape_IdValue((Shape) moveContext.getPictogramElement(), SHAPE_ID_GROUP_SHADOW)) {
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
	}	}
		
	//resize feature
	//~~~~~~~~~~~~~~
	/**
	 * disables that the user can resize the drop shadow manually
	 */
	@Override
	public boolean canResizeShape(IResizeShapeContext resizeContext) {
		if(PropertyUtil.isShape_IdValue((Shape) resizeContext.getPictogramElement(), SHAPE_ID_GROUP_SHADOW)) {
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
		if(PropertyUtil.isShape_IdValue((Shape) deleteContext.getPictogramElement(), SHAPE_ID_GROUP_SHADOW)) {
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
		Diagram groupDiagram = DiagramUtil.getGroupOrCompartmentTypeDiagramForItsShape((Shape) deleteContext.getPictogramElement(), getDiagram(), Type.GROUP);
		if(groupDiagram != null) {	
			DeleteContext deleteContextForGroupDiagram = new DeleteContext(groupDiagram);
			deleteContextForGroupDiagram.setMultiDeleteInfo(new MultiDeleteInfo(false, false, 0));
			//Step 2
			for(Shape shape : groupDiagram.getChildren()) {
				if(shape instanceof ContainerShape) {
					if(PropertyUtil.isShape_IdValue(shape, SHAPE_ID_GROUP_CONTAINER)) 
						innerGroupsOrCompartmentTypesToDelete.add(ShapePatternUtil.getTypeBodyForGroupOrCompartmentContainer((ContainerShape) shape, Type.GROUP));
					if(PropertyUtil.isShape_IdValue(shape, SHAPE_ID_COMPARTMENTTYPE_CONTAINER))
						innerGroupsOrCompartmentTypesToDelete.add(ShapePatternUtil.getTypeBodyForGroupOrCompartmentContainer((ContainerShape) shape, Type.COMPARTMENT_TYPE));
			}	}
			//Step 3
			IEditorReference[] openEditors = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditorReferences();
			for(IEditorReference editorReference : openEditors) {
				try {
					if(editorReference.getEditorInput() instanceof DiagramEditorInput) {
						Resource resource = EditorInputUtil.getResourceFromEditorInput(editorReference.getEditorInput());
						Diagram diagramOfEditorInput = DiagramUtil.getDiagramForResourceOfDiagramEditorInput(resource);
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
				if(PropertyUtil.isShape_IdValue(innerGroupOrCompartmentTypeToDelete, SHAPE_ID_GROUP_TYPEBODY)) {
					DeleteContext deleteContextForChildDiagram = new DeleteContext(innerGroupOrCompartmentTypeToDelete);
					deleteContextForChildDiagram.setMultiDeleteInfo(new MultiDeleteInfo(false, false, 0));
					delete(deleteContextForChildDiagram);
				} else {
					if(PropertyUtil.isShape_IdValue(innerGroupOrCompartmentTypeToDelete, SHAPE_ID_COMPARTMENTTYPE_TYPEBODY)) {
						DeleteContext deleteContextForChildDiagram = new DeleteContext(innerGroupOrCompartmentTypeToDelete);
						deleteContextForChildDiagram.setMultiDeleteInfo(new MultiDeleteInfo(false, false, 0));
						IDeleteFeature deleteFeatureForCompartmentDiagram = getFeatureProvider().getDeleteFeature(deleteContextForChildDiagram);
						deleteFeatureForCompartmentDiagram.delete(deleteContextForChildDiagram);	
			}	}	}
			super.delete(deleteContextForAllShapes);
			super.delete(deleteContextForGroupDiagram);
			updateContainingGroupOrCompartmentType();
		}
	}
}
