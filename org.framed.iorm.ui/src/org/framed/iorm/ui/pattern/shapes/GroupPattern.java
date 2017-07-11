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
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.pattern.IPattern;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.IColorConstant;
import org.framed.iorm.model.Model;
import org.framed.iorm.model.ModelElement;
import org.framed.iorm.model.OrmFactory;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.contexts.AddGroupOrCompartmentTypeContext;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.literals.LayoutLiterals;
import org.framed.iorm.ui.literals.NameLiterals;
import org.framed.iorm.ui.literals.TextLiterals;
import org.framed.iorm.ui.util.DiagramUtil;
import org.framed.iorm.ui.util.NameUtil;
import org.framed.iorm.ui.util.GeneralUtil;
import org.framed.iorm.ui.util.PatternUtil;
import org.framed.iorm.ui.util.PropertyUtil;
import org.framed.iorm.ui.wizards.RoleModelWizard;

/**
 * This graphiti pattern class is used to work with {@link org.framed.iorm.model.Shape}s
 * of the type Group in the editor.
 * <p>
 * It deals with the following aspects of Inheritances:<br>
 * TODO
 * @author Kevin Kassin
 */
public class GroupPattern extends FRaMEDShapePattern implements IPattern {
	
	//names
	private final String GROUP_FEATURE_NAME = NameLiterals.GROUP_FEATURE_NAME,
				   		 STANDARD_GROUP_NAME = NameLiterals.STANDARD_GROUP_NAME;
	
	//identifier
	private final String SHAPE_ID_GROUP_CONTAINER = IdentifierLiterals.SHAPE_ID_GROUP_CONTAINER,
				   		 SHAPE_ID_GROUP_TYPEBODY = IdentifierLiterals.SHAPE_ID_GROUP_TYPEBODY,
				   		 SHAPE_ID_GROUP_SHADOW = IdentifierLiterals.SHAPE_ID_GROUP_SHADOW,
				   		 SHAPE_ID_GROUP_NAME = IdentifierLiterals.SHAPE_ID_GROUP_NAME, 
				   		 SHAPE_ID_GROUP_LINE = IdentifierLiterals.SHAPE_ID_GROUP_LINE,
				   		 SHAPE_ID_GROUP_MODEL = IdentifierLiterals.SHAPE_ID_GROUP_MODEL,
				   		 SHAPE_ID_GROUP_ELEMENT = IdentifierLiterals.SHAPE_ID_GROUP_ELEMENT,
				   		 SHAPE_ID_GROUPS_INDICATOR_DOTS = IdentifierLiterals.SHAPE_ID_GROUPS_INDICATOR_DOTS;
				   
	private final String DIAGRAM_KIND_GROUP_DIAGRAM = IdentifierLiterals.DIAGRAM_KIND_GROUP_DIAGRAM;			  
				   		 
	private final String IMG_ID_FEATURE_GROUP = IdentifierLiterals.IMG_ID_FEATURE_GROUP,
				   		 DIAGRAM_TYPE = IdentifierLiterals.DIAGRAM_TYPE_ID;
				   
	//text
	private final String DIRECTEDITING_GROUP = TextLiterals.DIRECTEDITING_GROUP,
				   NAME_ALREADY_USED_GROUP = TextLiterals.NAME_ALREADY_USED_GROUP;
	
	//layout
	private final int MIN_WIDTH = LayoutLiterals.MIN_WIDTH_FOR_CLASS_OR_ROLE,
				MIN_HEIGHT = LayoutLiterals.MIN_HEIGHT_FOR_CLASS_OR_ROLE,
				HEIGHT_NAME_SHAPE = LayoutLiterals.HEIGHT_NAME_SHAPE,
				PUFFER_BETWEEN_ELEMENTS = LayoutLiterals.PUFFER_BETWEEN_ELEMENTS,
				GROUP_CORNER_RADIUS = LayoutLiterals.GROUP_CORNER_RADIUS,
				SHADOW_SIZE = LayoutLiterals.SHADOW_SIZE,
				HEIGHT_GROUP_ELEMENT_SHAPE = LayoutLiterals.HEIGHT_GROUP_ELEMENT_SHAPE;
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
	
	//services
	private static final IPeCreateService pictogramElementCreateService = Graphiti.getPeCreateService();
	private static final IGaService graphicAlgorithmService = Graphiti.getGaService();
	
	// add features
	//~~~~~~~~~~~~~
	@Override
	public boolean canAdd(IAddContext addContext) {
		//new Object is a group
		if(addContext.getNewObject() instanceof org.framed.iorm.model.Shape) {
			org.framed.iorm.model.Shape shape = (org.framed.iorm.model.Shape) addContext.getNewObject();
			if(shape.getType()==Type.GROUP) {
				//target container is diagram with root model
				ContainerShape containerShape = getDiagram();
				if(containerShape instanceof Diagram) {
					if(DiagramUtil.getLinkedModelForDiagram((Diagram) containerShape) != null)
						return true;
		}	}	}
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
	 * 			<li>model content container</li>
	 * 			  <ul><li>model content rectangle</li></ul>
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
	 * Step 5: It enables direct editing and layouting of the group.
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
	
		//model content container and model content rectangle
		ContainerShape modelContainer = pictogramElementCreateService.createContainerShape(typeBodyShape, false);
		Rectangle modelRectangle = graphicAlgorithmService.createRectangle(modelContainer);
		modelRectangle.setLineVisible(false);
		modelRectangle.setBackground(manageColor(COLOR_BACKGROUND));
		graphicAlgorithmService.setLocationAndSize(modelRectangle, PUFFER_BETWEEN_ELEMENTS, HEIGHT_NAME_SHAPE+PUFFER_BETWEEN_ELEMENTS, 
												   width-2*PUFFER_BETWEEN_ELEMENTS, height-GROUP_CORNER_RADIUS);
		
		//groups diagram
		Diagram contentDiagram = pictogramElementCreateService.createDiagram(DIAGRAM_TYPE, addedGroup.getName(), 10, false);
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
		PropertyUtil.setShape_IdValue(modelContainer, SHAPE_ID_GROUP_MODEL);
		
		//Step 4
		link(containerShape, addedGroup);
		link(typeBodyShape, addedGroup);
		link(dropShadowShape, addedGroup);
		link(nameShape, addedGroup);
		link(firstLineShape, addedGroup);
		link(modelContainer, addedGroup);
				
		//Step 5
		IDirectEditingInfo directEditingInfo = getFeatureProvider().getDirectEditingInfo();
		directEditingInfo.setMainPictogramElement(typeBodyShape);
		directEditingInfo.setPictogramElement(nameShape);
		directEditingInfo.setGraphicsAlgorithm(text);
		layoutPictogramElement(containerShape);
		updateContainingGroup();
		return containerShape;
	}
		
	//create feature
	//~~~~~~~~~~~~~~
	@Override
	public boolean canCreate(ICreateContext createContext) {
		//target container is either diagram with model
		ContainerShape containerShape = getDiagram();
		if(containerShape instanceof Diagram) {
			if(DiagramUtil.getLinkedModelForDiagram((Diagram) containerShape) != null)
				return true;
		}
		return false;
	}

	@Override
	public Object[] create(ICreateContext createContext) {
		//create new natural type
		org.framed.iorm.model.Shape newGroup = OrmFactory.eINSTANCE.createShape();
		newGroup.setType(Type.GROUP);
		String standardName = NameUtil.calculateStandardNameForClassOrRole(getDiagram(), Type.GROUP, STANDARD_GROUP_NAME);
		newGroup.setName(standardName);
		//add new group to the elements of the model
		Model model = DiagramUtil.getLinkedModelForDiagram((Diagram) getDiagram());
		if(newGroup.eResource() != null) getDiagram().eResource().getContents().add(newGroup);
		model.getElements().add(newGroup);
		newGroup.setContainer(model);
		//set inner model of the group
		Model groupModel = OrmFactory.eINSTANCE.createModel();
		getDiagram().eResource().getContents().add(groupModel);
		newGroup.setModel(groupModel);
		//enable direct editing
		getFeatureProvider().getDirectEditingInfo().setActive(true);
		//add to graphiti representation
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

	@Override
	public String getInitialValue(IDirectEditingContext editingContext) {
		org.framed.iorm.model.Shape group = (org.framed.iorm.model.Shape) getBusinessObject(editingContext);
		return group.getName();
	}
		
	@Override
	public String checkValueValid(String newName, IDirectEditingContext editingContext) {
		if(getInitialValue(editingContext).contentEquals(newName)) return null;
		if(!(NameUtil.matchesIdentifier(newName))) return DIRECTEDITING_GROUP;
		if(NameUtil.nameAlreadyUsedForClassOrRole(getDiagram(), Type.GROUP, newName)) 
			return NAME_ALREADY_USED_GROUP;
	    return null;
	}
		
	@Override
	public void setValue(String value, IDirectEditingContext editingContext) {	     
		org.framed.iorm.model.Shape group = (org.framed.iorm.model.Shape) getBusinessObject(editingContext);
		group.setName(value);
		updatePictogramElement(((Shape) editingContext.getPictogramElement()).getContainer());
		updateContainingGroup();
	}
		
	//layout feature
	//~~~~~~~~~~~~~~
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

	@Override
	public boolean layout(ILayoutContext layoutContext) {	
		boolean layoutChanged = false;
		ContainerShape container = (ContainerShape) layoutContext.getPictogramElement();
		RoundedRectangle typeBodyRectangle = null;
		//return false is container is overall container that has typeBodyShape and dropShadowShape as children
		if(container.getGraphicsAlgorithm() == null)  return false; 
		//container is typeBodyShape, else return false
		if(PropertyUtil.isShape_IdValue(container, SHAPE_ID_GROUP_TYPEBODY))
			typeBodyRectangle = (RoundedRectangle) container.getGraphicsAlgorithm(); 
		else return false;
		//get the drop shadow rectangle to the type body rectangle
		RoundedRectangle dropShadowRectangle = (RoundedRectangle) container.getContainer().getChildren().get(0).getGraphicsAlgorithm();
			        
		//ensure the minimal width and height
	    if(typeBodyRectangle.getWidth() < MIN_WIDTH) typeBodyRectangle.setWidth(MIN_WIDTH);
		if(typeBodyRectangle.getHeight() < MIN_HEIGHT) typeBodyRectangle.setHeight(MIN_HEIGHT);
		int containerWidth = typeBodyRectangle.getWidth();
	    int containerHeight = typeBodyRectangle.getHeight();
	    //set the size of the drop shadow to the new size of the type body
	    dropShadowRectangle.setWidth(containerWidth);
	    dropShadowRectangle.setHeight(containerHeight);
	    //set the x and y value of the drop shadow to the values of the type body
	    dropShadowRectangle.setX(typeBodyRectangle.getX()+SHADOW_SIZE);
	    dropShadowRectangle.setY(typeBodyRectangle.getY()+SHADOW_SIZE);
	        
	    for (Shape shape : container.getChildren()){
	    	GraphicsAlgorithm graphicsAlgorithm = shape.getGraphicsAlgorithm();                         	                 
	        //name
	        if (graphicsAlgorithm instanceof Text) {
	        	Text text = (Text) graphicsAlgorithm;	
	            if(PropertyUtil.isShape_IdValue(shape, SHAPE_ID_GROUP_NAME)) {
	            	graphicAlgorithmService.setLocationAndSize(text, 0, 0, containerWidth, HEIGHT_NAME_SHAPE);
	            	layoutChanged=true;
	        }	}
	        //first line
	        if (graphicsAlgorithm instanceof Polyline) {	   
	        	Polyline polyline = (Polyline) graphicsAlgorithm;  
	        	if(PropertyUtil.isShape_IdValue(shape, SHAPE_ID_GROUP_LINE)) {
		            polyline.getPoints().set(1, graphicAlgorithmService.createPoint(containerWidth, polyline.getPoints().get(1).getY()));
		            layoutChanged=true;
		    }	}
	        //model container
	        if (graphicsAlgorithm instanceof Rectangle) {
	        	Rectangle rectangle = (Rectangle) graphicsAlgorithm;  
		        if(PropertyUtil.isShape_IdValue(shape, SHAPE_ID_GROUP_MODEL)) {
		        	int newHeight = (containerHeight-GROUP_CORNER_RADIUS),
		            	newWidth = (containerWidth-2*PUFFER_BETWEEN_ELEMENTS);            				
		        	rectangle.setHeight(newHeight);
		            rectangle.setWidth(newWidth);
		            ContainerShape groupElementsShape = (ContainerShape) shape;
	            	EList<Shape> groupElements = groupElementsShape.getChildren();  
		     
		            //set place of group elements
	            	//for(int i = 0; i<groupElements.size(); i++) {
	            	//	((ContainerShape) shape).getChildren().get(i).getGraphicsAlgorithm().setY(i*HEIGHT_GROUP_ELEMENT_SHAPE);
            		//}
	     
	            	Shape indicatorDotsShapeToDelete = null;
	            	for(Shape elementShape : groupElements) {
	            		elementShape.setVisible(true);
	            		if(PropertyUtil.isShape_IdValue(elementShape, SHAPE_ID_GROUPS_INDICATOR_DOTS))
	            			indicatorDotsShapeToDelete = elementShape;
	            	}
	            	groupElementsShape.getChildren().remove(indicatorDotsShapeToDelete);
	            	
	            	//check if not all attributes fit in the attribute field
	            	if(groupElements.size()*HEIGHT_GROUP_ELEMENT_SHAPE > newHeight) {	            		
	            		int fittingAttributes = (newHeight-HEIGHT_GROUP_ELEMENT_SHAPE)/HEIGHT_GROUP_ELEMENT_SHAPE;	   
	            		//set not fitting attributes to invisible
	            		for(int k = fittingAttributes; k<groupElements.size(); k++) {
	            			groupElements.get(k).setVisible(false);            				
	            		}	
	            		Shape indicatorDotsShape = pictogramElementCreateService.createShape(groupElementsShape, true); 
	            		Text indicatorDots = graphicAlgorithmService.createText(indicatorDotsShape, "...");
	            		indicatorDots.setForeground(manageColor(COLOR_TEXT));
	            		graphicAlgorithmService.setLocationAndSize(indicatorDots, 
	            				PUFFER_BETWEEN_ELEMENTS, HEIGHT_NAME_SHAPE+fittingAttributes*HEIGHT_GROUP_ELEMENT_SHAPE, 
	            				newWidth-2*PUFFER_BETWEEN_ELEMENTS, HEIGHT_GROUP_ELEMENT_SHAPE);
	            		PropertyUtil.setShape_IdValue(indicatorDotsShape, SHAPE_ID_GROUPS_INDICATOR_DOTS); 
	            	}
	            	layoutChanged = true;
	     }	}	}        
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
			String pictogramTypeName = PatternUtil.getNameOfPictogramElement(pictogramElement, SHAPE_ID_GROUP_NAME);
			//business name and attributes
			String businessTypeName = PatternUtil.getNameOfBusinessObject(getBusinessObjectForPictogramElement(pictogramElement));
			//model element names in groups model
			List<String> modelElementsNames = PatternUtil.getGroupOrCompartmentTypeElementNames(pictogramElement, getDiagram());
 			//model element names in model container of shape
			List<String> modelContainerElementsNames = PatternUtil.getModelContainerElementsNames(pictogramElement);		
				
			//check for update: different names, different amount of attibutes/ operations
			if(pictogramTypeName==null || businessTypeName==null) return Reason.createTrueReason("Name is null.");
			if(!(pictogramTypeName.equals(businessTypeName))) return Reason.createTrueReason("Name is out of date.");
			if(modelElementsNames.size() != modelContainerElementsNames.size()) return Reason.createTrueReason("Different amount of Group Elements.");
			for(int i=0; i<modelElementsNames.size(); i++) {
				modelContainerElementName = modelContainerElementsNames.get(i);
				rawModelContainerElementName = modelContainerElementName.substring(modelContainerElementName.indexOf(" ")+1);
				if(!(modelElementsNames.get(i).equals(rawModelContainerElementName))) return Reason.createTrueReason("Different names of Group Elements.");
		}	}
		return Reason.createFalseReason();
	}
		
	@Override
	public boolean update(IUpdateContext updateContext) {
		int counter;
		boolean changed = false;
	         
		PictogramElement pictogramElement = updateContext.getPictogramElement();
		String businessTypeName = PatternUtil.getNameOfBusinessObject(getBusinessObjectForPictogramElement(pictogramElement));
			
		//set type name in pictogram model
	    if (pictogramElement instanceof ContainerShape) {     
	    	ContainerShape typeBodyShape = (ContainerShape) pictogramElement;
	        for (Shape shape : typeBodyShape.getChildren()) {
	        	if (shape.getGraphicsAlgorithm() instanceof Text) {
	        		Text text = (Text) shape.getGraphicsAlgorithm();
	                if(PropertyUtil.isShape_IdValue(shape, SHAPE_ID_GROUP_NAME)) {
	                    //change diagram name
	                	Diagram diagram = DiagramUtil.getGroupDiagramForGroupShape(shape, getDiagram());
	                	diagram.setName(businessTypeName);
	                	//change group name
	                	text.setValue(businessTypeName);
	                	changed = true;
	                }
	        	}    
	        	if (shape.getGraphicsAlgorithm() instanceof Rectangle) {  
	        		if(PropertyUtil.isShape_IdValue(shape, SHAPE_ID_GROUP_MODEL)) {
		                ContainerShape modelContainerShape = (ContainerShape) shape;
			            Diagram groupsDiagram = DiagramUtil.getGroupDiagramForGroupShape(typeBodyShape, getDiagram());
			            Model groupModel = DiagramUtil.getLinkedModelForDiagram(groupsDiagram);
		             
			            counter = 0;
		                modelContainerShape.getChildren().clear();
			            for(ModelElement modelElement : groupModel.getElements()) {		
			            	Shape groupElementShape = pictogramElementCreateService.createShape(modelContainerShape, true);
			            	Text groupElementText = graphicAlgorithmService.createText(groupElementShape, PatternUtil.getGroupOrCompartmentTypeElementText(modelElement));
			            	groupElementText.setForeground(manageColor(COLOR_TEXT));
			            	graphicAlgorithmService.setLocationAndSize(groupElementText, PUFFER_BETWEEN_ELEMENTS, HEIGHT_NAME_SHAPE+PUFFER_BETWEEN_ELEMENTS+HEIGHT_GROUP_ELEMENT_SHAPE*counter, 
			            			modelContainerShape.getGraphicsAlgorithm().getWidth()-2*PUFFER_BETWEEN_ELEMENTS, HEIGHT_GROUP_ELEMENT_SHAPE);
			            	PropertyUtil.setShape_IdValue(groupElementShape, SHAPE_ID_GROUP_ELEMENT);
			            	counter++;		
			            }
			            changed = true;
			            this.layoutPictogramElement(typeBodyShape);
	        		} 	
	        	}	
	        }
	   }     
	return changed;
	}	
	 
	//move feature
	//~~~~~~~~~~~~
	//disable that the user can move the drop shadow manually
	@Override
	public boolean canMoveShape(IMoveShapeContext moveContext) {
		if(PropertyUtil.isShape_IdValue((Shape) moveContext.getPictogramElement(), SHAPE_ID_GROUP_SHADOW)) {
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
	//disable that the user can resize the drop shadow manually
	@Override
	public boolean canResizeShape(IResizeShapeContext resizeContext) {
		if(PropertyUtil.isShape_IdValue((Shape) resizeContext.getPictogramElement(), SHAPE_ID_GROUP_SHADOW)) {
			return false;
		}
		return super.canResizeShape(resizeContext);
	}
		
	//delete feature
	//~~~~~~~~~~~~~~
	//disable that the user can delete the drop shadow and group elements manually
	@Override
	public boolean canDelete(IDeleteContext deleteContext) {
		if(PropertyUtil.isShape_IdValue((Shape) deleteContext.getPictogramElement(), SHAPE_ID_GROUP_SHADOW)) {
			return false;
		}
		return super.canDelete(deleteContext);
	}
			
	//
	@Override
	public void delete(IDeleteContext deleteContext) {
		//delete groups diagram
		Diagram groupDiagram = DiagramUtil.getGroupDiagramForGroupShape((Shape) deleteContext.getPictogramElement(), getDiagram());
		DeleteContext deleteContextForGroupDiagram = new DeleteContext(groupDiagram);
		deleteContextForGroupDiagram.setMultiDeleteInfo(new MultiDeleteInfo(false, false, 0));
		super.delete(deleteContextForGroupDiagram);
		//delete container shape 
		ContainerShape containerShape = (ContainerShape) ((ContainerShape) deleteContext.getPictogramElement()).getContainer();
		DeleteContext deleteContextForAllShapes = new DeleteContext(containerShape);
		deleteContextForAllShapes.setMultiDeleteInfo(new MultiDeleteInfo(false, false, 0));
		super.delete(deleteContextForAllShapes);
		updateContainingGroup();
	}
}
