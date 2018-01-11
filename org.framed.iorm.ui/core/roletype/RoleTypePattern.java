package roletype;

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
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.pattern.AbstractPattern;
import org.eclipse.graphiti.pattern.IPattern;
import org.framed.iorm.model.Model;
import org.framed.iorm.model.NamedElement;
import org.framed.iorm.model.OrmFactory;
import org.framed.iorm.model.Segment;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.FRaMEDShapePattern;
import org.framed.iorm.ui.editPolicy.EditPolicyService;
import org.framed.iorm.ui.palette.FeaturePaletteDescriptor;
import org.framed.iorm.ui.palette.PaletteCategory;
import org.framed.iorm.ui.palette.ViewVisibility;
import org.framed.iorm.ui.util.UIUtil;

import roletype.Literals;
import roletype.Util;
import roletype.references.AttributeAndOperationsReference;

//TODO Doku
public class RoleTypePattern extends FRaMEDShapePattern implements IPattern {

	/**
	 * the object to get names, ids and so on for this feature
	 */
	private final Literals literals = new Literals();
	
	/**
	 * the object to call utility operations on
	 */
	private final Util util = new Util();
	
	/**
	 * a reference class which encapsulates the dependency to the attribute and operation features
	 */
	private final AttributeAndOperationsReference attOpsReference = new AttributeAndOperationsReference();
	
	/**
	 * the feature palette descriptor manages the palette visibility, see {@link FeaturePaletteDescriptor}
	 */
	private final FeaturePaletteDescriptor spec_FPD = new FeaturePaletteDescriptor(
			PaletteCategory.ENTITIES_CATEGORY,
			ViewVisibility.COMPARTMENT_VIEW);
	
	/**
	 * class constructor		
	 */
	public RoleTypePattern() {
		super();
		FEATURE_NAME = literals.FEATURE_NAME;
		ICON_IMG_ID = literals.ICON_IMG_ID;
		ICON_IMG_PATH = literals.ICON_IMG_PATH;
		modelType = Type.ROLE_TYPE;
		FPD = spec_FPD;
	}
	
	/**
	 * checks if pattern is applicable for a given business object
	 * @return true, if business object is a {@link org.framed.iorm.model.Shape} of type {@link Type#ROLE_TYPE}
	 */
	@Override
	public boolean isMainBusinessObjectApplicable(Object businessObject) {
		if(businessObject instanceof org.framed.iorm.model.Shape) {
			org.framed.iorm.model.Shape shape = (org.framed.iorm.model.Shape) businessObject;
			if(shape.getType() == Type.ROLE_TYPE) return true;
		}
		return false;
	}

	/**
	 * checks if pattern is applicable for a given pictogram element
	 * @return true, if business object of the pictogram element is a {@link org.framed.iorm.model.Shape} of type {@link Type#ROLE_TYPE}
	 */
	@Override
	protected boolean isPatternControlled(PictogramElement pictogramElement) {
		Object businessObject = getBusinessObjectForPictogramElement(pictogramElement);
		return isMainBusinessObjectApplicable(businessObject);
	}

	/**
	 * checks if the pictogram element to edit with the pattern is its root
	 * @return true, if business object of the pictogram element is a {@link org.framed.iorm.model.Shape} of type {@link Type#ROLE_TYPE}
	 */
	@Override
	protected boolean isPatternRoot(PictogramElement pictogramElement) {
		Object businessObject = getBusinessObjectForPictogramElement(pictogramElement);
		return isMainBusinessObjectApplicable(businessObject);
	}	
	
	//add feature
	//~~~~~~~~~~~
	/**
	 * calculates if the role type can be added to the diagram
	 * <p>
	 * returns true if:<br>
	 * (1) if the added business object is a role type and <br>
	 * (2) if the target container is a diagram with a model linked and<br>
	 * (3) the target container is a diagram of a compartment type
	 * @return if the role type can be added
	 */
	@Override
	public boolean canAdd(IAddContext addContext) {
		if(addContext.getNewObject() instanceof org.framed.iorm.model.Shape) {
			org.framed.iorm.model.Shape shape = (org.framed.iorm.model.Shape) addContext.getNewObject();
			if(shape.getType()==Type.ROLE_TYPE) {
				ContainerShape containerShape = getDiagram();
				if(containerShape instanceof Diagram) {
					if(UIUtil.getLinkedModelForDiagram((Diagram) containerShape) != null) {
						return EditPolicyService.canAdd(addContext, getDiagram());
		}	}	}	}
		return false;
	}
		
	/**
	 * adds the graphical representation of a role type to the pictogram model
	 * <p>
	 * It creates the following structure:<br>
	 * <ul>
	 *   <li>container shape</li>
	 * 	   <ul>
	 * 	     <li>drop shadow shape</li>
	 *         <ul><li>drop shadow rectangle</li></ul>
	 * 		<li>occurence costraints shape</li>
	 *         <ul><li>occurence costraints rectangle</li></ul>
	 * 		<li>type body shape</li>
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
	 * Step 1: It gets the new object, the diagram to create the role type in and calculates the height and width 
	 * 		   of the role types representation.<br>
	 * Step 2: It creates the structure shown above.<br>
	 * Step 3: It sets the shape identifiers for the created graphics algorithms of the role type.<br>
	 * Step 4: It links the created shapes of the role to its business objects.<br> 
	 * Step 5: It enables direct editing, anchors and layouting of the role. It also updates the compartment type in which 
	 * 		   its created, if any.
	 */
	@Override
	public PictogramElement add(IAddContext addContext) {
		//Step 1
		org.framed.iorm.model.Shape addedRoleType = (org.framed.iorm.model.Shape) addContext.getNewObject();
		ContainerShape targetDiagram = getDiagram();
		int width = addContext.getWidth(), height = addContext.getHeight();
		if(addContext.getWidth() < literals.MIN_WIDTH) width = literals.MIN_WIDTH;
		if(addContext.getHeight() < literals.MIN_HEIGHT) height = literals.MIN_HEIGHT;
					
		//Step 2
		//container for body shape and shadow
		ContainerShape containerShape = pictogramElementCreateService.createContainerShape(targetDiagram, false);
								  
		//drop shadow
		ContainerShape dropShadowShape = pictogramElementCreateService.createContainerShape(containerShape, true);
		RoundedRectangle dropShadowRectangle = graphicAlgorithmService.createRoundedRectangle(dropShadowShape, literals.ROLE_CORNER_RADIUS, literals.ROLE_CORNER_RADIUS);
		dropShadowRectangle.setForeground(manageColor(literals.COLOR_SHADOW));
		dropShadowRectangle.setBackground(manageColor(literals.COLOR_SHADOW));
		graphicAlgorithmService.setLocationAndSize(dropShadowRectangle, addContext.getX()+literals.SHADOW_SIZE, addContext.getY()+literals.SHADOW_SIZE, width, height);
			
		//occurence costraint
		Shape cardinalityShape = pictogramElementCreateService.createShape(containerShape, true);
		Text cardinalityText = graphicAlgorithmService.createText(cardinalityShape, addedRoleType.getDescription().getName());
		cardinalityText.setForeground(manageColor(literals.COLOR_TEXT));													
		graphicAlgorithmService.setLocationAndSize(cardinalityText, 
			addContext.getX()+width/2-literals.HEIGHT_OCCURRENCE_CONSTRAINT/2, 
			addContext.getY()-literals.HEIGHT_OCCURRENCE_CONSTRAINT-literals.PUFFER_BETWEEN_ELEMENTS, 
			literals.WIDTH_OCCURRENCE_CONSTRAINT, 
			literals.HEIGHT_OCCURRENCE_CONSTRAINT);
			
		//body shape of type
		ContainerShape typeBodyShape = pictogramElementCreateService.createContainerShape(containerShape, true);		
		RoundedRectangle typeBodyRectangle = graphicAlgorithmService.createRoundedRectangle(typeBodyShape, literals.ROLE_CORNER_RADIUS, literals.ROLE_CORNER_RADIUS);
		typeBodyRectangle.setForeground(manageColor(literals.COLOR_LINES));
		typeBodyRectangle.setBackground(manageColor(literals.COLOR_BACKGROUND));
		graphicAlgorithmService.setLocationAndSize(typeBodyRectangle, addContext.getX(), addContext.getY(), width, height);

		//name
		Shape nameShape = pictogramElementCreateService.createShape(typeBodyShape, false);
		Text text = graphicAlgorithmService.createText(nameShape, addedRoleType.getName());	
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
		int horizontalCenter = util.calculateHorizontalCenter(height);
		graphicAlgorithmService.setLocationAndSize(attributeRectangle, literals.PUFFER_BETWEEN_ELEMENTS, literals.HEIGHT_NAME_SHAPE+literals.PUFFER_BETWEEN_ELEMENTS, 
															   width-2*literals.PUFFER_BETWEEN_ELEMENTS, horizontalCenter-literals.HEIGHT_NAME_SHAPE-2*literals.PUFFER_BETWEEN_ELEMENTS);
		//second line
		Shape secondLineShape = pictogramElementCreateService.createShape(typeBodyShape, false);	
		Polyline secondPolyline = graphicAlgorithmService.createPolyline(secondLineShape, new int[] {0, horizontalCenter, width, horizontalCenter});
		secondPolyline.setForeground(manageColor(literals.COLOR_LINES));
					
		//operation container
		ContainerShape operationContainer = pictogramElementCreateService.createContainerShape(typeBodyShape, false);
		Rectangle operationRectangle = graphicAlgorithmService.createRectangle(operationContainer);
		operationRectangle.setLineVisible(false);
		operationRectangle.setBackground(manageColor(literals.COLOR_BACKGROUND));
		graphicAlgorithmService.setLocationAndSize(operationRectangle, 
			literals.PUFFER_BETWEEN_ELEMENTS, horizontalCenter+literals.PUFFER_BETWEEN_ELEMENTS, 
			width-2*literals.PUFFER_BETWEEN_ELEMENTS, horizontalCenter-literals.ROLE_CORNER_RADIUS/2);
					
		//Step 3
		UIUtil.setShape_IdValue(containerShape, literals.SHAPE_ID_ROLETYPE_CONTAINER);
		UIUtil.setShape_IdValue(cardinalityShape, literals.SHAPE_ID_ROLETYPE_OCCURRENCE_CONSTRAINT);
		UIUtil.setShape_IdValue(typeBodyShape, literals.SHAPE_ID_ROLETYPE_TYPEBODY);
		UIUtil.setShape_IdValue(dropShadowShape, literals.SHAPE_ID_ROLETYPE_SHADOW);
		UIUtil.setShape_IdValue(nameShape, literals.SHAPE_ID_ROLETYPE_NAME);
		UIUtil.setShape_IdValue(firstLineShape, literals.SHAPE_ID_ROLETYPE_FIRSTLINE);
		UIUtil.setShape_IdValue(attributeContainer, literals.SHAPE_ID_ROLETYPE_ATTRIBUTECONTAINER);
		UIUtil.setShape_IdValue(secondLineShape, literals.SHAPE_ID_ROLETYPE_SECONDLINE);
		UIUtil.setShape_IdValue(operationContainer, literals.SHAPE_ID_ROLETYPE_OPERATIONCONTAINER);
					
		//Step 4
		link(containerShape, addedRoleType);
		link(cardinalityShape, addedRoleType);
		link(typeBodyShape, addedRoleType);
		link(dropShadowShape, addedRoleType);
		link(nameShape, addedRoleType);
		link(firstLineShape, addedRoleType);
		link(attributeContainer, addedRoleType);
		link(secondLineShape, addedRoleType);
		link(operationContainer, addedRoleType);
					
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
	 * calculates if a role type can be created
	 * <p>
	 * returns true if:<br>
	 * (1) the target container is a diagram with a model linked and<br>
	 * (2) the target container is a diagram of a compartment type
	 * @return if an role type can be created
	 */
	@Override
	public boolean canCreate(ICreateContext createContext) {
		if(UIUtil.getLinkedModelForDiagram(getDiagram()) != null)
			return EditPolicyService.canCreate(createContext, this.getDiagram());
		return false;
	}
		
	/**
	 * creates the business objects of the role type, adds it to model of the diagram in which the role type is 
	 * created in and calls the add function for the role type
	 * <p>
	 * It creates the following structure:<br>
	 * <ul>
	 *   <li>(org.framed.iorm.model.Shape) role type</li>
	 * 	   <ul>
	 * 	     <li>(Segment) first segment (for attributes)</li> 
	 *  	 <li>(Segment) second segment (for operations)</li> 
	 *  	 <li>(NamedElement) description (for occurence constraint)</li> 
	 * 	   </ul>
	 * </ul> 
	 * <p>
	 * It follows this steps:<br>
	 * Step 1: It creates the structure shown above.<br>
	 * Step 2: It adds the new role type to the elements of the model of the diagram in which its created.<br>
	 * Step 3: It call the add function to add the pictogram elements of the role type.
	 * @return the created business object of the role type
	 */
	@Override
	public Object[] create(ICreateContext createContext) {
		//Step 1
		//natural type
		org.framed.iorm.model.Shape newRoleType = OrmFactory.eINSTANCE.createShape();
		newRoleType.setType(Type.ROLE_TYPE);
		String standardName = UIUtil.calculateStandardNameForCompartmentsTypeElement(getDiagram(), Type.ROLE_TYPE, literals.STANDARD_NAME);
		newRoleType.setName(standardName);
		//create segments
		Segment attributeSegment = OrmFactory.eINSTANCE.createSegment(),
				operationSegment = OrmFactory.eINSTANCE.createSegment();
		getDiagram().eResource().getContents().add(attributeSegment);
		getDiagram().eResource().getContents().add(operationSegment);
		newRoleType.setFirstSegment(attributeSegment);
		newRoleType.setSecondSegment(operationSegment);
		//occurence constraint
		NamedElement occurenceConstraint = OrmFactory.eINSTANCE.createNamedElement();
		occurenceConstraint.setName(literals.STANDARD_CARDINALITY);
		getDiagram().eResource().getContents().add(occurenceConstraint);
		newRoleType.setDescription(occurenceConstraint);
			
		//Step 2
		Model model = UIUtil.getLinkedModelForDiagram((Diagram) getDiagram());
		if(newRoleType.eResource() != null) getDiagram().eResource().getContents().add(newRoleType);
		model.getElements().add(newRoleType);
		newRoleType.setContainer(model);
		
		//Step 3
		addGraphicalRepresentation(createContext, newRoleType);
		return new Object[] { newRoleType };
	}	
	
	//direct editing
	//~~~~~~~~~~~~~~
	/**
	 * sets the editing type as a text field for the direct editing of the role types name or
	 * its occurrence constraint
	 */
	@Override
	public int getEditingType() {
		return TYPE_TEXT;
	}
			
	/**
	 * calculates if a pictogram element of a role type can be direct edited
	 * <p>
	 * returns true if the clicked shape is the role type name shape or the shape for the occurrence constraint
	 * @return if the clicked pictogram can be direct edited
	 */
	@Override
	public boolean canDirectEdit(IDirectEditingContext editingContext) {
		PictogramElement pictogramElement = editingContext.getPictogramElement();
		if(pictogramElement instanceof Shape) {
		   if(UIUtil.isShape_IdValue((Shape) pictogramElement, literals.SHAPE_ID_ROLETYPE_NAME) ||
			  UIUtil.isShape_IdValue((Shape) pictogramElement, literals.SHAPE_ID_ROLETYPE_OCCURRENCE_CONSTRAINT))
			  return true;
		}   
		return false;
	}

	/**
	 * returns the current role types name or occurrence constraint value as initial value for direct editing
	 */
	@Override
	public String getInitialValue(IDirectEditingContext editingContext) {
		org.framed.iorm.model.Shape roleType = (org.framed.iorm.model.Shape) getBusinessObject(editingContext);
		PictogramElement pictogramElement = editingContext.getPictogramElement();
		if(UIUtil.isShape_IdValue((Shape) pictogramElement, literals.SHAPE_ID_ROLETYPE_NAME)) 
			return roleType.getName();
		if(UIUtil.isShape_IdValue((Shape) pictogramElement, literals.SHAPE_ID_ROLETYPE_OCCURRENCE_CONSTRAINT))
			return roleType.getDescription().getName();
		return null;
	}
			
	/**
	 * calculates if a chosen value for the role types name or the occurrence constraint is valid
	 * <p>
	 * A valid value for the role type name is in a specific form checked by {@link NameUtil#matchesIdentifier} 
	 * and is not already chosen for another natural type. This is checked by {@link NameUtil#nameAlreadyUsedForClassOrRole}.<br>
	 * A valid value for the occurrence constraint is in a specific form checked by  {@link NameUtil#matchesCardinality}.
	 * @return if a chosen value for the role types name is valid
	 */
	@Override
	public String checkValueValid(String newValue, IDirectEditingContext editingContext) {
		PictogramElement pictogramElement = editingContext.getPictogramElement();
		if(getInitialValue(editingContext).contentEquals(newValue)) return null;
		if(UIUtil.isShape_IdValue((Shape) pictogramElement, literals.SHAPE_ID_ROLETYPE_NAME)) {
			if(!(UIUtil.matchesIdentifier(newValue))) return literals.DIRECTEDITING_ROLETYPE;
			if(UIUtil.nameAlreadyUsedForCompartmentTypeElements(getDiagram(), Type.ROLE_TYPE, newValue)) 
				return literals.NAME_ALREADY_USED_ROLETYPE;
		}	
		if(UIUtil.isShape_IdValue((Shape) pictogramElement, literals.SHAPE_ID_ROLETYPE_OCCURRENCE_CONSTRAINT)) {
			if(!(UIUtil.matchesCardinality(newValue))) return literals.DIRECTEDITING_OCCURRENCE_CONSTRAINT;
		}
		return null;
	} 
			
	/**
	 * sets value of the role types name or the occurrence constraint, updates its own pictogram element and a 
	 * compartment in which its in, if any.
	 * <p>
	 * When direct editing the occurrence constraint it is not needed to update a containing compartment type
	 */
	@Override
	public void setValue(String value, IDirectEditingContext editingContext) {	     
		org.framed.iorm.model.Shape roleType = (org.framed.iorm.model.Shape) getBusinessObject(editingContext);
		Shape shape = (Shape) editingContext.getPictogramElement();
		if(UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_ROLETYPE_NAME)) {
			roleType.setName(value);
			updatePictogramElement(shape.getContainer());
			updateContainingGroupOrCompartmentType();
		}	
		if(UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_ROLETYPE_OCCURRENCE_CONSTRAINT)) {
			roleType.getDescription().setName(value);
			for(Shape containerChild : shape.getContainer().getChildren()) {
		    	if(UIUtil.isShape_IdValue(containerChild, literals.SHAPE_ID_ROLETYPE_TYPEBODY)) {
		    		updatePictogramElement(containerChild);
	}	}	}	}
	
	//layout feature
	//~~~~~~~~~~~~~~
	/**
	 * calculates if a pictogram element of a role type can be layouted
	 * <p>
	 * returns true if:<br>
	 * (1) if exactly one pictogram element is given by the layout context
	 * (2) the business object of the pictogram element is a {@link org.framed.iorm.model.Shape} 
	 * 	   of the type {@link Type#ROLE_TYPE} 
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
					if(shape.getType() == Type.ROLE_TYPE) return true;
		}	}	}
		return false;
	}

	/**
	 * layout the whole role type using the following steps:
	 * <p>
	 * Step 1: Its fetches the type body shape and drop shadow shape<br>
	 * Step 2: It calculates the new height, width and horizontal center. It also uses this data to set
	 * 		   the size of the type body and drop shadow shape.<br>
	 * Step 3: It now iterates over all shapes of the role type:<br>
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
		if(!(UIUtil.isShape_IdValue(container, literals.SHAPE_ID_ROLETYPE_TYPEBODY))) return false;
		else {	
			RoundedRectangle typeBodyRectangle = (RoundedRectangle) container.getGraphicsAlgorithm(); 
			RoundedRectangle dropShadowRectangle = (RoundedRectangle) container.getContainer().getChildren().get(0).getGraphicsAlgorithm();
		    //Step 2
		    if(typeBodyRectangle.getWidth() < literals.MIN_WIDTH) typeBodyRectangle.setWidth(literals.MIN_WIDTH);
			if(typeBodyRectangle.getHeight() < literals.MIN_HEIGHT) typeBodyRectangle.setHeight(literals.MIN_HEIGHT);
			int width = typeBodyRectangle.getWidth();
			int height = typeBodyRectangle.getHeight();
			int horizontalCenter = util.calculateHorizontalCenter(height);
			dropShadowRectangle.setWidth(width);
			dropShadowRectangle.setHeight(height);
			dropShadowRectangle.setX(typeBodyRectangle.getX()+literals.SHADOW_SIZE);
			dropShadowRectangle.setY(typeBodyRectangle.getY()+literals.SHADOW_SIZE);    
			//Step 4
		    for(Shape shape : container.getChildren()){
	    	GraphicsAlgorithm graphicsAlgorithm = shape.getGraphicsAlgorithm();                         	                 
	        //(a) name
	    	if (graphicsAlgorithm instanceof Text) {
	    		Text text = (Text) graphicsAlgorithm;	
			   	if(UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_ROLETYPE_NAME)) {
			   		graphicAlgorithmService.setLocationAndSize(text, 0, 0, width, literals.HEIGHT_NAME_SHAPE);
			   		layoutChanged=true;
			}	}
			//(b) first and second line
	    	if (graphicsAlgorithm instanceof Polyline) {	   
			   	Polyline polyline = (Polyline) graphicsAlgorithm;  
			   	if(UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_ROLETYPE_FIRSTLINE)) {
			   		polyline.getPoints().set(1, graphicAlgorithmService.createPoint(width, polyline.getPoints().get(1).getY()));
			       	layoutChanged=true;
			   	}	
			   	if(UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_ROLETYPE_SECONDLINE)) {   
		          	polyline.getPoints().set(0, graphicAlgorithmService.createPoint(0, horizontalCenter));
		           	polyline.getPoints().set(1, graphicAlgorithmService.createPoint(width, horizontalCenter));
		           	layoutChanged=true;
		   }	}
	    		if (graphicsAlgorithm instanceof Rectangle) {
	    			Rectangle rectangle = (Rectangle) graphicsAlgorithm;  
			       	//(c) attribute container shape
				    if(UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_ROLETYPE_ATTRIBUTECONTAINER)) {
				    	//resize and positioning the container
				       	newHeight = horizontalCenter-literals.HEIGHT_NAME_SHAPE-2*literals.PUFFER_BETWEEN_ELEMENTS;
				        newWidth = (typeBodyRectangle.getWidth()-2*literals.PUFFER_BETWEEN_ELEMENTS);      
				       	newY = literals.HEIGHT_NAME_SHAPE+literals.PUFFER_BETWEEN_ELEMENTS;
				       	rectangle.setHeight(newHeight);
				        rectangle.setWidth(newWidth);
				        ContainerShape attributeContainerShape = (ContainerShape) shape;	       
				        EList<Shape> attributes = attributeContainerShape.getChildren();
				        //set places of attributes
				        for(int m = 0; m<attributes.size(); m++) {
				          	Text attributeText = (Text) attributeContainerShape.getChildren().get(m).getGraphicsAlgorithm();
				           	attributeText.setY(newY+m*attOpsReference.HEIGHT_OPERATION_SHAPE);
				           	attributeText.setWidth(newWidth);
			           	}   	
				        //set all attributes visible and delete indicator dots
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
					           	literals.PUFFER_BETWEEN_ELEMENTS, attOpsReference.HEIGHT_ATTRIBUTE_SHAPE+fittingAttributes*attOpsReference.HEIGHT_ATTRIBUTE_SHAPE, 						           	newWidth-2*literals.PUFFER_BETWEEN_ELEMENTS, attOpsReference.HEIGHT_OPERATION_SHAPE-2*literals.PUFFER_BETWEEN_ELEMENTS);
						        UIUtil.setShape_IdValue(indicatorDotsShape, attOpsReference.SHAPE_ID_ATTRIBUTE_INDICATOR_DOTS);
				        }	            			
				        layoutChanged=true;
				    }
				    //(d) operation container shape
				    if(UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_ROLETYPE_OPERATIONCONTAINER)) {
				    	//resize and positioning the container
				    	newHeight = horizontalCenter-literals.HEIGHT_NAME_SHAPE-2*literals.PUFFER_BETWEEN_ELEMENTS;
				    	newWidth = width-2*literals.PUFFER_BETWEEN_ELEMENTS;		
				    	newY = horizontalCenter+literals.PUFFER_BETWEEN_ELEMENTS;	            	
				    	rectangle.setHeight(newHeight);
				    	rectangle.setWidth(newWidth);
				    	rectangle.setY(newY);
				    	ContainerShape operationContainerShape = (ContainerShape) shape;
				    	EList<Shape> operations = operationContainerShape.getChildren();
				    	//set place of operations
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
		}  	}	}	}        
		return layoutChanged;
	}
	
	//update feature
	//~~~~~~~~~~~~~~
	@Override
	public boolean canUpdate(IUpdateContext updateContext) {
		//check if object to update is a role Type
		PictogramElement pictogramElement = updateContext.getPictogramElement();
			Object businessObject =  getBusinessObjectForPictogramElement(pictogramElement);
			if(businessObject instanceof org.framed.iorm.model.Shape) {
			org.framed.iorm.model.Shape shape = (org.framed.iorm.model.Shape) businessObject;
			if(shape.getType() == Type.ROLE_TYPE) {
				return true;
		}	}
		return false;
	}

	@Override
	public IReason updateNeeded(IUpdateContext updateContext) {
		PictogramElement pictogramElement = updateContext.getPictogramElement();
				
		if(UIUtil.isShape_IdValue((Shape) pictogramElement, literals.SHAPE_ID_ROLETYPE_TYPEBODY)) {
			//pictogram name of natural type, attributes and operations, occurrence constraint
			String pictogramTypeName = util.getNameOfPictogramElement(pictogramElement);
			List<String> pictogramAttributeNames = util.getpictogramAttributeNames(pictogramElement);
			List<String> pictogramOperationNames = util.getpictogramOperationNames(pictogramElement);
			String pictogramOccurrenceConstraint = util.getOccurenceConstraintOfPictogramElement(pictogramElement);
			//business name and attributes
			String businessTypeName = UIUtil.getNameOfBusinessObject(getBusinessObjectForPictogramElement(pictogramElement));
			List<String> businessAttributeNames = util.getBusinessAttributeNames(pictogramElement);
			List<String> businessOperationNames = util.getBusinessOperationNames(pictogramElement);
			String businessTypeOccurrenceConstraint = UIUtil.getOccurrenceConstraintOfBusinessObject(getBusinessObjectForPictogramElement(pictogramElement));
				
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
			if(!pictogramOccurrenceConstraint.equals(businessTypeOccurrenceConstraint)) return Reason.createTrueReason(literals.REASON_OCCURRENCE_CONSTRAINTS);
		}
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
		String businessTypeOccurrenceConstraint = UIUtil.getOccurrenceConstraintOfBusinessObject(getBusinessObjectForPictogramElement(pictogramElement));	
			
		//set type name in pictogram model
		if (pictogramElement instanceof ContainerShape &&
		   	UIUtil.isShape_IdValue((Shape) pictogramElement, literals.SHAPE_ID_ROLETYPE_TYPEBODY)) {     
		   	ContainerShape typeBodyShape = (ContainerShape) pictogramElement;
		   	//occurrence
		   	for(Shape containerChild : typeBodyShape.getContainer().getChildren()) {
		   		if(UIUtil.isShape_IdValue(containerChild, literals.SHAPE_ID_ROLETYPE_OCCURRENCE_CONSTRAINT)) {
		   			((Text) containerChild.getGraphicsAlgorithm()).setValue(businessTypeOccurrenceConstraint);
		   	}	}
		    //iterate
		    for(Shape shape : typeBodyShape.getChildren()) {
		      	if (shape.getGraphicsAlgorithm() instanceof Text) {
		       		Text text = (Text) shape.getGraphicsAlgorithm();
		       		if(UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_ROLETYPE_NAME)) {
		               	text.setValue(businessTypeName);
		                  	changed = true;
		       	}   }
		      	//set attribute and operation names and thier places in pictogram model
		      	if(shape instanceof ContainerShape) {
		           	ContainerShape innerContainerShape = (ContainerShape) shape;
					if(innerContainerShape.getGraphicsAlgorithm() instanceof Rectangle) {
						//Attributes
						counter = 0;
						if(UIUtil.isShape_IdValue(innerContainerShape, literals.SHAPE_ID_ROLETYPE_ATTRIBUTECONTAINER)) {
							for(Shape attributeShape : innerContainerShape.getChildren()) {
								if(UIUtil.isShape_IdValue(attributeShape, attOpsReference.SHAPE_ID_ATTRIBUTE_TEXT)) {
									Text text = (Text) attributeShape.getGraphicsAlgorithm();
									text.setValue(businessAttributeNames.get(counter));
									changed = true;
									counter++;
						}	}	}
						//Operations
						counter = 0;
						//newY = horizontalCenter+PUFFER_BETWEEN_ELEMENTS;
						if(UIUtil.isShape_IdValue(innerContainerShape, literals.SHAPE_ID_ROLETYPE_OPERATIONCONTAINER)) {
							for(Shape operationShape : innerContainerShape.getChildren()) {
								if(UIUtil.isShape_IdValue(operationShape, attOpsReference.SHAPE_ID_OPERATION_TEXT)) {
									Text text = (Text) operationShape.getGraphicsAlgorithm();
									text.setValue(businessOperationNames.get(counter));									
									//operationShape.getGraphicsAlgorithm().setY(newY+counter*HEIGHT_OPERATION_SHAPE);
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
		if(UIUtil.isShape_IdValue((Shape) moveContext.getPictogramElement(), literals.SHAPE_ID_ROLETYPE_SHADOW)) {
			return false;
		}
		if(UIUtil.isShape_IdValue((Shape) moveContext.getPictogramElement(), literals.SHAPE_ID_ROLETYPE_TYPEBODY)) {
			ContainerShape typeBodyShape = (ContainerShape) moveContext.getPictogramElement();
			ContainerShape dropShadowShape = (ContainerShape) ((ContainerShape) typeBodyShape).getContainer().getChildren().get(0);
			return moveContext.getSourceContainer() != null && 
				  (moveContext.getSourceContainer().equals(moveContext.getTargetContainer()) ||
				   moveContext.getTargetContainer().equals(dropShadowShape)) && 
				   isPatternRoot(moveContext.getPictogramElement());
		}
		return super.canMoveShape(moveContext);
	}
		
	//move the type body and the drop shadow 
	@Override
	public void moveShape(IMoveShapeContext moveContext) {
		if(UIUtil.isShape_IdValue((Shape) moveContext.getPictogramElement(), literals.SHAPE_ID_ROLETYPE_OCCURRENCE_CONSTRAINT))
			super.moveShape(moveContext);
		else {
			ContainerShape typeBodyShape = (ContainerShape) moveContext.getPictogramElement();
			RoundedRectangle typeBodyRectangle = (RoundedRectangle) typeBodyShape.getGraphicsAlgorithm();
			ContainerShape dropShadowShape = (ContainerShape) ((ContainerShape) typeBodyShape).getContainer().getChildren().get(0);
			RoundedRectangle dropShadowRectangle = (RoundedRectangle) dropShadowShape.getGraphicsAlgorithm();
			Shape OCShape = (Shape) ((ContainerShape) typeBodyShape).getContainer().getChildren().get(1);
			Text OCText = (Text) OCShape.getGraphicsAlgorithm();
				
			
			
			if(moveContext.getSourceContainer().equals(moveContext.getTargetContainer())) {
				dropShadowRectangle.setX(moveContext.getX()+literals.SHADOW_SIZE);
				dropShadowRectangle.setY(moveContext.getY()+literals.SHADOW_SIZE);
				OCText.setX(OCText.getX() + moveContext.getDeltaX());
				OCText.setY(OCText.getY() + moveContext.getDeltaY());
				super.moveShape(moveContext);
			} else {
				//targetContainer of moveContext is dropShadowShape
				//set targetContainer to diagram and use special calculation for the new position of type body and drop shadow 
				dropShadowRectangle.setX(typeBodyRectangle.getX()+moveContext.getX()+2*literals.SHADOW_SIZE);
				dropShadowRectangle.setY(typeBodyRectangle.getY()+moveContext.getY()+2*literals.SHADOW_SIZE);
				OCText.setX(OCText.getX() + moveContext.getX()+literals.SHADOW_SIZE);
				OCText.setY(OCText.getY() + moveContext.getY()+literals.SHADOW_SIZE);
				MoveShapeContext changedMoveContextForTypeBody = new MoveShapeContext(moveContext.getShape());
				changedMoveContextForTypeBody.setTargetContainer(dropShadowShape.getContainer());
				changedMoveContextForTypeBody.setX(typeBodyRectangle.getX()+moveContext.getX()+literals.SHADOW_SIZE);
				changedMoveContextForTypeBody.setY(typeBodyRectangle.getY()+moveContext.getY()+literals.SHADOW_SIZE);
				super.moveShape(changedMoveContextForTypeBody);
			}	
		this.layoutPictogramElement(typeBodyShape);
		}
	}
		
	//resize feature
	//~~~~~~~~~~~~~~
	/**
	 * disables that the user can resize the drop shadow and the cardinality manually
	 */
	@Override
	public boolean canResizeShape(IResizeShapeContext resizeContext) {
		if(UIUtil.isShape_IdValue((Shape) resizeContext.getPictogramElement(), literals.SHAPE_ID_ROLETYPE_SHADOW) ||
		   UIUtil.isShape_IdValue((Shape) resizeContext.getPictogramElement(), literals.SHAPE_ID_ROLETYPE_OCCURRENCE_CONSTRAINT)) {
			return false;
		}
		return super.canResizeShape(resizeContext);
	}
		
	//delete feature
	//~~~~~~~~~~~~~~
	/**
	 * disables that the user can delete the drop shadow and the cardinality manually
	 */
	@Override
	public boolean canDelete(IDeleteContext deleteContext) {
		if(UIUtil.isShape_IdValue((Shape) deleteContext.getPictogramElement(), literals.SHAPE_ID_ROLETYPE_SHADOW) ||
		   UIUtil.isShape_IdValue((Shape) deleteContext.getPictogramElement(), literals.SHAPE_ID_ROLETYPE_OCCURRENCE_CONSTRAINT)) {
			return false;
		}
		return super.canDelete(deleteContext);
	}
			
	/**
	 * deletes the container shape of the role type instead of the type body and updates the compartment type the role type is in,
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
