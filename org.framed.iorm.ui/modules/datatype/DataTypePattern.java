package datatype;

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
import org.eclipse.graphiti.mm.algorithms.Polygon;
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
import org.framed.iorm.model.Model;
import org.framed.iorm.model.OrmFactory;
import org.framed.iorm.model.Segment;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.editPolicy.EditPolicyService;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.literals.UILiterals;
import org.framed.iorm.ui.palette.FeaturePaletteDescriptor;
import org.framed.iorm.ui.palette.PaletteCategory;
import org.framed.iorm.ui.palette.PaletteView;
import org.framed.iorm.ui.palette.ViewVisibility;
import org.framed.iorm.ui.pattern.shapes.FRaMEDShapePattern;
import org.framed.iorm.ui.util.UIUtil;

/**
 * This graphiti pattern class is used to work with {@link org.framed.iorm.model.Shape}s
 * of the type {@link Type#DATA_TYPE} in the editor.
 * <p>
 * It deals with the following aspects of data types:<br>
 * (1) adding a data type to the diagram, especially its pictogram elements<br>
 * (2) creating the data type, especially its business object<br>
 * (3) direct editing of the data types name<br>
 * (4) layout the data type, especially setting lines, attributes and operations at the right positions<br>
 * (5) updating the data types names, attributes names/ position and operation/ position<br>
 * (6) move the drop shadow with the type body and disables moving the drop shadow manually<br>
 * (7) resizes the drop shadow with the type body and disables resizing the drop shadow manually<br>
 * (8) deleting all the data types pictogram elements and its attached connections, also diables deleting
 *     the drop shadow manually
 * <p>
 * If its not clear what <em>drop shadow shape</em> and <em>type body shape</em> means, see 
 * {@link #add} for reference. 
 * @author Kevin Kassin
 */
public class DataTypePattern extends FRaMEDShapePattern implements IPattern {
	
	/**
	 * the object to get names, id and so on for this feature
	 */
	private final Literals literals = new Literals();
	
	/**
	 * the object to call util operations on
	 */
	private final Util util = new Util();
	
	/**
	 * the feature palette descriptor manages the palette visibility, see {@link FeaturePaletteDescriptor}
	 */
	private final FeaturePaletteDescriptor spec_FPD = new FeaturePaletteDescriptor(
			PaletteCategory.ENTITIES_CATEGORY,
			ViewVisibility.TOPLEVEL_VIEW) {
				@Override
				public boolean featureExpression(List<String> featureNames, PaletteView paletteView) {
					return featureNames.contains("Data_Types");		
			}	};
			
	/**
	 * class constructor		
	 */
	public DataTypePattern() {
		super();
		FEATURE_NAME = literals.FEATURE_NAME;
		ICON_IMG_ID = literals.ICON_IMG_ID;
		ICON_IMG_PATH = literals.ICON_IMG_PATH;
		FPD = spec_FPD;
	}
	
	/**
	 * checks if pattern is applicable for a given business object
	 * @return true, if business object is a {@link org.framed.iorm.model.Shape} of type {@link Type#DATA_TYPE}
	 */
	@Override
	public boolean isMainBusinessObjectApplicable(Object businessObject) {
		if(businessObject instanceof org.framed.iorm.model.Shape) {
			org.framed.iorm.model.Shape shape = (org.framed.iorm.model.Shape) businessObject;
			if(shape.getType() == Type.DATA_TYPE) return true;
		}
		return false;
	}

	/**
	 * checks if pattern is applicable for a given pictogram element
	 * @return true, if business object of the pictogram element is a {@link org.framed.iorm.model.Shape} of type {@link Type#DATA_TYPE}
	 */
	@Override
	protected boolean isPatternControlled(PictogramElement pictogramElement) {
		Object businessObject = getBusinessObjectForPictogramElement(pictogramElement);
		return isMainBusinessObjectApplicable(businessObject);
	}

	/**
	 * checks if the pictogram element to edit with the pattern is its root
	 * @return true, if business object of the pictogram element is a {@link org.framed.iorm.model.Shape} of type {@link Type#DATA_TYPE}
	 */
	@Override
	protected boolean isPatternRoot(PictogramElement pictogramElement) {
		Object businessObject = getBusinessObjectForPictogramElement(pictogramElement);
		return isMainBusinessObjectApplicable(businessObject);
	}
	

	// add features
	//~~~~~~~~~~~~~
	/**
	 * calculates if the data type can be added to the diagram
	 * <p>
	 * returns true if:<br>
	 * (1) if the added business object is a data type and <br>
	 * (2) if the target container is a diagram with a model linked and<br>
	 * (3) the target container is the main diagram or a diagram of group
	 * @return if the data type can be added
	 */
	@Override
	public boolean canAdd(IAddContext addContext) {
		if(addContext.getNewObject() instanceof org.framed.iorm.model.Shape) {
			org.framed.iorm.model.Shape shape = (org.framed.iorm.model.Shape) addContext.getNewObject();
			if(shape.getType()==Type.DATA_TYPE) {
				ContainerShape containerShape = getDiagram();
				if(containerShape instanceof Diagram) {
					if(UIUtil.getLinkedModelForDiagram((Diagram) containerShape) != null) {
						if(UIUtil.isDiagram_KindValue(getDiagram(), UILiterals.DIAGRAM_KIND_MAIN_DIAGRAM) ||
						   UIUtil.isDiagram_KindValue(getDiagram(), UILiterals.DIAGRAM_KIND_GROUP_DIAGRAM))
							return EditPolicyService.canAdd(addContext, this.getDiagram());
		}	}	}	}
		return false;
	}

	//add feature
	/**
	 * adds the graphical representation of a data type to the pictogram model
	 * <p>
	 * It creates the following structure:<br>
	 * <ul>
	 *   <li>container shape</li>
	 * 	   <ul>
	 * 	     <li>drop shadow shape</li>
	 *         <ul><li>drop shadow octagon</li></ul>
	 * 		 <li>type body shape</li>
	 * 		   <ul><li>type body octagon</li></ul>
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
	 * Step 1: It gets the new object, the diagram to create the data type in and calculates the height, width 
	 * 		   and octagonal shape of the data types representation.<br>
	 * Step 2: It creates the structure shown above.<br>
	 * Step 3: It sets the shape identifiers for the created graphics algorithms of the data type.<br>
	 * Step 4: It links the created shapes of the data type to its business objects.<br> 
	 * Step 5: It enables direct editing, anchors and layouting of the group. It also updates the group in which 
	 * 		   its created, if any.
	 */
	@Override
	public PictogramElement add(IAddContext addContext) {
		//Step 1
		org.framed.iorm.model.Shape addedDataType = (org.framed.iorm.model.Shape) addContext.getNewObject();
		ContainerShape targetDiagram = getDiagram();
		int width = addContext.getWidth(), height = addContext.getHeight();
		if(addContext.getWidth() < literals.MIN_WIDTH) width = literals.MIN_WIDTH;
		if(addContext.getHeight() < literals.MIN_HEIGHT) height = literals.MIN_HEIGHT;
		int points[] = new int[] { 0, 0+literals.DATATYPE_CORNER_SIZE,			//Point 1  
								   0+literals.DATATYPE_CORNER_SIZE, 0, 			//P2
								   width-literals.DATATYPE_CORNER_SIZE, 0, 		//P3
								   width, literals.DATATYPE_CORNER_SIZE,  		//P4
								   width, height-literals.DATATYPE_CORNER_SIZE,	//P5 
								   width-literals.DATATYPE_CORNER_SIZE, height,	//P6
								   literals.DATATYPE_CORNER_SIZE, height,	    //P7
								   0, height-literals.DATATYPE_CORNER_SIZE };	//P8
		//Step 2
		//container for body shape and shadow
		ContainerShape containerShape = pictogramElementCreateService.createContainerShape(targetDiagram, false);
		
		//drop shadow
		ContainerShape dropShadowShape = pictogramElementCreateService.createContainerShape(containerShape, true);
		Polygon dropShadowPolygon = graphicAlgorithmService.createPolygon(dropShadowShape, points);
		dropShadowPolygon.setForeground(manageColor(literals.COLOR_SHADOW));
		dropShadowPolygon.setBackground(manageColor(literals.COLOR_SHADOW));
		graphicAlgorithmService.setLocationAndSize(dropShadowPolygon, addContext.getX()+literals.SHADOW_SIZE, addContext.getY()+literals.SHADOW_SIZE, width, height);
		
		//type body shape
		ContainerShape typeBodyShape = pictogramElementCreateService.createContainerShape(containerShape, true);
		Polygon typeBodyPolygon = graphicAlgorithmService.createPolygon(typeBodyShape, points);
		typeBodyPolygon.setForeground(manageColor(literals.COLOR_LINES));
		typeBodyPolygon.setBackground(manageColor(literals.COLOR_BACKGROUND));
		graphicAlgorithmService.setLocationAndSize(typeBodyPolygon, addContext.getX(), addContext.getY(), width, height);
			
		//name
		Shape nameShape = pictogramElementCreateService.createShape(typeBodyShape, false);
		Text text = graphicAlgorithmService.createText(nameShape, addedDataType.getName());	
		text.setForeground(manageColor(literals.COLOR_TEXT));	
		text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);	
		graphicAlgorithmService.setLocationAndSize(text, literals.DATATYPE_CORNER_SIZE, 0, width-2*literals.DATATYPE_CORNER_SIZE, literals.HEIGHT_NAME_SHAPE);
		
		//first line
		Shape firstLineShape = pictogramElementCreateService.createShape(typeBodyShape, false);
		Polyline firstPolyline = graphicAlgorithmService.createPolyline(firstLineShape, new int[] {literals.PUFFER_BETWEEN_ELEMENTS, literals.HEIGHT_NAME_SHAPE, width-2*literals.PUFFER_BETWEEN_ELEMENTS, literals.HEIGHT_NAME_SHAPE});
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
		graphicAlgorithmService.setLocationAndSize(operationRectangle, literals.PUFFER_BETWEEN_ELEMENTS, horizontalCenter+literals.PUFFER_BETWEEN_ELEMENTS, 
												   width-2*literals.PUFFER_BETWEEN_ELEMENTS, horizontalCenter-literals.HEIGHT_NAME_SHAPE-2*literals.PUFFER_BETWEEN_ELEMENTS);
		
		//Step 3
		UIUtil.setShape_IdValue(containerShape, literals.SHAPE_ID_DATATYPE_CONTAINER);
		UIUtil.setShape_IdValue(typeBodyShape, literals.SHAPE_ID_DATATYPE_TYPEBODY);
		UIUtil.setShape_IdValue(dropShadowShape, literals.SHAPE_ID_DATATYPE_SHADOW);
		UIUtil.setShape_IdValue(nameShape, literals.SHAPE_ID_DATATYPE_NAME);
		UIUtil.setShape_IdValue(firstLineShape, literals.SHAPE_ID_DATATYPE_FIRSTLINE);
		UIUtil.setShape_IdValue(attributeContainer, literals.SHAPE_ID_DATATYPE_ATTRIBUTECONTAINER);
		UIUtil.setShape_IdValue(secondLineShape, literals.SHAPE_ID_DATATYPE_SECONDLINE);
		UIUtil.setShape_IdValue(operationContainer, literals.SHAPE_ID_DATATYPE_OPERATIONCONTAINER);
		
		//Step 4
		link(containerShape, addedDataType);
		link(dropShadowShape, addedDataType);
		link(typeBodyShape, addedDataType);
		link(nameShape, addedDataType);
		link(firstLineShape, addedDataType);	
		link(attributeContainer, addedDataType);
		link(secondLineShape, addedDataType);
		link(operationContainer, addedDataType);
		
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
	 * calculates if a data type can be created
	 * <p>Diagram
	 * returns true if:<br>
	 * (1) the target container is a diagram with a model linked
	 * (2) the target container is the main diagram or a diagram of group 
	 * @return if an data type can be created
	 */
	@Override
	public boolean canCreate(ICreateContext createContext) {
		if(UIUtil.getLinkedModelForDiagram(getDiagram()) != null) {
			if(UIUtil.isDiagram_KindValue(getDiagram(), UILiterals.DIAGRAM_KIND_MAIN_DIAGRAM) ||
					UIUtil.isDiagram_KindValue(getDiagram(), UILiterals.DIAGRAM_KIND_GROUP_DIAGRAM))
				return true && EditPolicyService.canCreate(createContext, this.getDiagram());
		}   
		return false;
	}

	/**
	 * creates the business objects of the data type, adds it to model of the diagram in which the data type is 
	 * created in and calls the add function for the data type
	 * <p>
	 * It creates the following structure:<br>
	 * <ul>
	 *   <li>(org.framed.iorm.model.Shape) data type</li>
	 * 	   <ul>
	 * 	     <li>(Segment) first segment (for attributes)</li> 
	 *  	 <li>(Segment) second segment (for operations)</li> 
	 * 	   </ul>
	 * </ul> 
	 * <p>
	 * It uses follows this steps:<br>
	 * Step 1: It creates the structure shown above.<br>
	 * Step 2: It adds the new data type to the elements of the model of the diagram in which its created.<br>
	 * Step 3: It call the add function to add the pictogram elements of the data type.
	 * @return the created business object of the group
	 */
	@Override
	public Object[] create(ICreateContext createContext) {
		//Step 1
		//data type
		org.framed.iorm.model.Shape newDataType = OrmFactory.eINSTANCE.createShape();
		newDataType.setType(Type.DATA_TYPE);
		String standardName = util.calculateStandardNameForClass(getDiagram());
		newDataType.setName(standardName);
		//create segments
		Segment attributeSegment = OrmFactory.eINSTANCE.createSegment(),
				operationSegment = OrmFactory.eINSTANCE.createSegment();
		getDiagram().eResource().getContents().add(attributeSegment);
		getDiagram().eResource().getContents().add(operationSegment);
		newDataType.setFirstSegment(attributeSegment);
		newDataType.setSecondSegment(operationSegment);
			
		//Step 2
		Model model = UIUtil.getLinkedModelForDiagram(getDiagram());
		if(newDataType.eResource() != null) getDiagram().eResource().getContents().add(newDataType);
		model.getElements().add(newDataType);
		newDataType.setContainer(model);
				
		//Step 3
		addGraphicalRepresentation(createContext, newDataType);
		return new Object[] { newDataType };
	}
	
	//direct editing feature
	//~~~~~~~~~~~~~~~~~~~~~~~	
	/**
	 * sets the editing type as a text field for the direct editing of the data types name
	 */
	@Override
	public int getEditingType() {
		return TYPE_TEXT;
	}
		
	/**
	 * calculates if a pictogram element of a data type can be direct edited
	 * <p>
	 * returns true if:<br>
	 * (1) the business object of the pictogram element is a {@link org.framed.iorm.model.Shape} 
	 * 	   of the type {@link Type#DATA_TYPE} and<br>
	 * (2) the graphics algorithm of the pictogram element is a {@link Text}
	 * @return if the selected pictogram can be direct edited
	 */
	@Override
	public boolean canDirectEdit(IDirectEditingContext editingContext) {
		Object businessObject = getBusinessObject(editingContext);
		GraphicsAlgorithm graphicsAlgorithm = editingContext.getGraphicsAlgorithm();
		if(businessObject instanceof org.framed.iorm.model.Shape && graphicsAlgorithm instanceof Text) {
			org.framed.iorm.model.Shape shape = (org.framed.iorm.model.Shape) businessObject;
			if(shape.getType() == Type.DATA_TYPE) {
				return true;
		}	}
		return false;
	}

	/**
	 * returns the current data types name as initial value for direct editing
	 */
	@Override
	public String getInitialValue(IDirectEditingContext editingContext) {
		org.framed.iorm.model.Shape dateType = (org.framed.iorm.model.Shape) getBusinessObject(editingContext);
		return dateType.getName();
	}
			
	/**
	 * calculates if a chosen value for the data type name is valid
	 * <p>
	 * A valid value is a specific form checked by {@link NameUtil#matchesIdentifier} and is not already
	 * chosen for another data type. This is checked by {@link NameUtil#nameAlreadyUsedForClassOrRole}.
	 * @return if a chosen value for the data type name is valid
	 */
	@Override
	public String checkValueValid(String newName, IDirectEditingContext editingContext) {
		if(getInitialValue(editingContext).contentEquals(newName)) return null;
		if(!(util.matchesIdentifier(newName))) return literals.DIRECTEDITING_DATATYPE;
		if(util.nameAlreadyUsedForClass(getDiagram(), newName)) 
			return literals.NAME_ALREADY_USED_DATATYPE;
		return null;
	}
			
	/**
	 * sets value of the datatypes name, updates its own pictogram element and a group in which its in, if any
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
	 * calculates if a pictogram element of a data type can be layouted
	 * <p>
	 * returns true if:<br>
	 * (1) if exactly one pictogram element is given by the layout context
	 * (2) the business object of the pictogram element is a {@link org.framed.iorm.model.Shape} 
	 * 	   of the type {@link Type#DATA_TYPE} 
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
					if(shape.getType() == Type.DATA_TYPE) return true;
		}	}	}
		return false;
	}

	/**
	 * layout the whole data type using the following steps:
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
		if(!(UIUtil.isShape_IdValue(container, literals.SHAPE_ID_DATATYPE_TYPEBODY))) return false;
		else {
			Polygon typeBodyPolygon = (Polygon) container.getGraphicsAlgorithm(); 
			Polygon dropShadowPolygon = (Polygon) container.getContainer().getChildren().get(0).getGraphicsAlgorithm();
			//Step 2
			if(typeBodyPolygon.getWidth() < literals.MIN_WIDTH) typeBodyPolygon.setWidth(literals.MIN_WIDTH);
			if(typeBodyPolygon.getHeight() < literals.MIN_HEIGHT) typeBodyPolygon.setHeight(literals.MIN_HEIGHT);
			int width = typeBodyPolygon.getWidth();
			int height = typeBodyPolygon.getHeight();
			int horizontalCenter = util.calculateHorizontalCenter(height);
			dropShadowPolygon.setWidth(width);
			dropShadowPolygon.setHeight(height);
			dropShadowPolygon.setX(typeBodyPolygon.getX()+literals.SHADOW_SIZE);
			dropShadowPolygon.setY(typeBodyPolygon.getY()+literals.SHADOW_SIZE);
			//Step 3
			for (Shape shape : container.getChildren()){
				GraphicsAlgorithm graphicsAlgorithm = shape.getGraphicsAlgorithm();
				//(a) name shape
				if (graphicsAlgorithm instanceof Text) {
					Text text = (Text) graphicsAlgorithm;	
			      	if(UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_DATATYPE_NAME)) {
			      		graphicAlgorithmService.setLocationAndSize(text, literals.DATATYPE_CORNER_SIZE, 0, width-2*literals.DATATYPE_CORNER_SIZE, literals.HEIGHT_NAME_SHAPE);
			      		layoutChanged=true;
			    }	}
			    //(b) line shapes
			    if (graphicsAlgorithm instanceof Polyline) {	   
			    	Polyline polyline = (Polyline) graphicsAlgorithm;  
			    	if(UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_DATATYPE_FIRSTLINE)) {
			    		polyline.getPoints().set(1, graphicAlgorithmService.createPoint(width-literals.PUFFER_BETWEEN_ELEMENTS, polyline.getPoints().get(1).getY()));
			    		layoutChanged=true;
			    	}
			    	if(UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_DATATYPE_SECONDLINE)) {   
			    		polyline.getPoints().set(0, graphicAlgorithmService.createPoint(0, horizontalCenter));
			    		polyline.getPoints().set(1, graphicAlgorithmService.createPoint(width, horizontalCenter));
			    		layoutChanged=true;
			    } 	}
			    if (graphicsAlgorithm instanceof Rectangle) {
			    	Rectangle rectangle = (Rectangle) graphicsAlgorithm;  
			    	//(c) attribute container
				    if(UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_DATATYPE_ATTRIBUTECONTAINER)) {
				    	//resize and positioning the container
				    	newHeight = horizontalCenter-literals.HEIGHT_NAME_SHAPE-2*literals.PUFFER_BETWEEN_ELEMENTS;
				    	newWidth = (typeBodyPolygon.getWidth()-2*literals.PUFFER_BETWEEN_ELEMENTS);        
				    	newY = literals.HEIGHT_NAME_SHAPE+literals.PUFFER_BETWEEN_ELEMENTS;
				    	rectangle.setHeight(newHeight);
				    	rectangle.setWidth(newWidth);
				    	ContainerShape attributeContainerShape = (ContainerShape) shape;	       
				    	EList<Shape> attributes = attributeContainerShape.getChildren();
				    	//set place of attributes
				    	for(int m = 0; m<attributes.size(); m++) {
				    		Text attributeText = (Text) attributeContainerShape.getChildren().get(m).getGraphicsAlgorithm();
				    		attributeText.setY(newY+m*literals.HEIGHT_OPERATION_SHAPE);
				          	attributeText.setWidth(newWidth);
				    	}
				    	//set all attributes visible
				    	indicatorDotsShapeToDelete = null;
				    	for(int j = 0; j<attributes.size(); j++) {
				    		attributes.get(j).setVisible(true);
				    		if(UIUtil.isShape_IdValue(attributes.get(j), SHAPE_ID_ATTRIBUTE_INDICATOR_DOTS))
				    			indicatorDotsShapeToDelete = attributes.get(j);
				    	}
				    	attributeContainerShape.getChildren().remove(indicatorDotsShapeToDelete);
				    	//check if not all attributes fit in the attribute field
				    	if(attributeContainerShape.getChildren().size()*literals.HEIGHT_ATTRITBUTE_SHAPE>newHeight) {	            		
				    		int fittingAttributes = (newHeight-literals.HEIGHT_ATTRITBUTE_SHAPE)/literals.HEIGHT_ATTRITBUTE_SHAPE;	   
				    		//set not fitting attributes to invisible
				    		for(int k = fittingAttributes; k<attributes.size(); k++) {
				    			attributeContainerShape.getChildren().get(k).setVisible(false);
				    		}
				    		//add dots to indicate that not all attributes fit
				    		Shape indicatorDotsShape = pictogramElementCreateService.createShape(attributeContainerShape, true); 
				    		Text indicatorDots = graphicAlgorithmService.createText(indicatorDotsShape, "...");
				    		indicatorDots.setForeground(manageColor(literals.COLOR_TEXT));
				    		graphicAlgorithmService.setLocationAndSize(indicatorDots, 
				    				literals.PUFFER_BETWEEN_ELEMENTS, literals.HEIGHT_NAME_SHAPE+fittingAttributes*literals.HEIGHT_OPERATION_SHAPE, 
				    				newWidth-2*literals.PUFFER_BETWEEN_ELEMENTS, literals.HEIGHT_OPERATION_SHAPE-2*literals.PUFFER_BETWEEN_ELEMENTS);
				    		UIUtil.setShape_IdValue(indicatorDotsShape, SHAPE_ID_ATTRIBUTE_INDICATOR_DOTS); 	
				    	}	            			
				    	layoutChanged=true;
				    }
				    //(d) operation container
				    if(UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_DATATYPE_OPERATIONCONTAINER)) {
				    	//resize and positioning the container
				    	newHeight = horizontalCenter-literals.HEIGHT_NAME_SHAPE-2*literals.PUFFER_BETWEEN_ELEMENTS;
				    	newWidth = typeBodyPolygon.getWidth()-2*literals.PUFFER_BETWEEN_ELEMENTS;		
				    	newY = horizontalCenter+literals.PUFFER_BETWEEN_ELEMENTS;	            	
				    	rectangle.setHeight(newHeight);
				    	rectangle.setWidth(newWidth);
				    	rectangle.setY(newY);
				    	ContainerShape operationContainerShape = (ContainerShape) shape;
				    	EList<Shape> operations = operationContainerShape.getChildren();
				    	//set place of operations
				    	for(int m = 0; m<operations.size(); m++) {
				    		Text operationText = (Text) operationContainerShape.getChildren().get(m).getGraphicsAlgorithm();
				    		operationText.setY(newY+m*literals.HEIGHT_OPERATION_SHAPE);
				    		operationText.setWidth(newWidth);
				    	}
				    	//set all operations visible
				    	indicatorDotsShapeToDelete = null;
				    	for(int n = 0; n<operations.size(); n++) {
				    		operations.get(n).setVisible(true);
				    		if(UIUtil.isShape_IdValue(operations.get(n), SHAPE_ID_OPERATION_INDICATOR_DOTS))
				    			indicatorDotsShapeToDelete = operations.get(n);
				    	}
				    	operationContainerShape.getChildren().remove(indicatorDotsShapeToDelete);
				    	//check if not all operations fit in the operations field
					    if(operations.size()*literals.HEIGHT_OPERATION_SHAPE>newHeight) {	            		
					    	int fittingOperations = (newHeight-literals.HEIGHT_OPERATION_SHAPE)/literals.HEIGHT_OPERATION_SHAPE;	   
					      	//set not fitting operations to invisible
					   		for(int o = fittingOperations; o<operations.size(); o++) {
					   			operationContainerShape.getChildren().get(o).setVisible(false);            				
					   		}   	
					      	//add dots to indicate not all operations fit
					   		Shape indicatorDotsShape = pictogramElementCreateService.createShape(operationContainerShape, true); 
				          	Text indicatorDots = graphicAlgorithmService.createText(indicatorDotsShape, "...");
				          	indicatorDots.setForeground(manageColor(literals.COLOR_TEXT));
				          	graphicAlgorithmService.setLocationAndSize(indicatorDots, 
				          			literals.PUFFER_BETWEEN_ELEMENTS, newY+fittingOperations*literals.HEIGHT_OPERATION_SHAPE, 
				          			newWidth-2*literals.PUFFER_BETWEEN_ELEMENTS, literals.HEIGHT_OPERATION_SHAPE);
				          	UIUtil.setShape_IdValue(indicatorDotsShape, SHAPE_ID_OPERATION_INDICATOR_DOTS); 	
					    }    
					    layoutChanged=true;
		}	}	}	}
		return layoutChanged;
	}
	
	//update feature
	//~~~~~~~~~~~~~~
	@Override
	public boolean canUpdate(IUpdateContext updateContext) {
		//check if object to update is a Data Type
		PictogramElement pictogramElement = updateContext.getPictogramElement();
		Object businessObject =  getBusinessObjectForPictogramElement(pictogramElement);
		if(businessObject instanceof org.framed.iorm.model.Shape) {
			org.framed.iorm.model.Shape shape = (org.framed.iorm.model.Shape) businessObject;
			if(shape.getType() == Type.DATA_TYPE) {
				return true;
		}	}
		return false;
	}
			
	@Override
	public IReason updateNeeded(IUpdateContext updateContext) {
		//check for changed names 
		PictogramElement pictogramElement = updateContext.getPictogramElement();
		if(pictogramElement.getGraphicsAlgorithm() != null &&
		   UIUtil.isShape_IdValue((Shape) pictogramElement, literals.SHAPE_ID_DATATYPE_TYPEBODY)) {
			//pictogram name of data type, attributes and operations
			String pictogramTypeName = util.getNameOfPictogramElement(pictogramElement);
			List<String> pictogramAttributeNames = util.getpictogramAttributeNames(pictogramElement);
			List<String> pictogramOperationNames = util.getpictogramOperationNames(pictogramElement);
			//business name and attributes
			String businessTypeName = util.getNameOfBusinessObject(getBusinessObjectForPictogramElement(pictogramElement));
			List<String> businessAttributeNames = util.getBusinessAttributeNames(pictogramElement);
			List<String> businessOperationNames = util.getBusinessOperationNames(pictogramElement);
								
			//check for update: different names, different amount of attibutes/ operations
			if(pictogramTypeName==null || businessTypeName==null) return Reason.createTrueReason(literals.REASON_NAME_NULL);
			if(!(pictogramTypeName.equals(businessTypeName))) return Reason.createTrueReason(literals.REASON_NAME_OUT_OF_DATE);  
			if(pictogramAttributeNames.size() != businessAttributeNames.size()) return Reason.createTrueReason(literals.REASON_AMOUNT_ATTRIBUTES);
			if(pictogramOperationNames.size() != businessOperationNames.size()) return Reason.createTrueReason(literals.REASON_AMOUNT_OPERATION);
			for(int i=0; i<pictogramAttributeNames.size(); i++) {
				if(!(pictogramAttributeNames.get(i).equals(businessAttributeNames.get(i)))) return Reason.createTrueReason(literals.REASON_NAMES_ATTRIBUTES);
			}	
			for(int i=0; i<pictogramOperationNames.size(); i++) {
				if(!(pictogramOperationNames.get(i).equals(businessOperationNames.get(i)))) return Reason.createTrueReason(literals.REASON_NAMES_OPERATIONS);
		}	}
		return Reason.createFalseReason();
	}
		
	@Override
	public boolean update(IUpdateContext updateContext) {
		int counter;
		boolean returnValue = false;
	         
		PictogramElement pictogramElement = updateContext.getPictogramElement();
		//business names of natural type, attributes and operations
		String businessTypeName = util.getNameOfBusinessObject(getBusinessObjectForPictogramElement(pictogramElement));
		List<String> businessAttributeNames = util.getBusinessAttributeNames(pictogramElement);
		List<String> businessOperationNames = util.getBusinessOperationNames(pictogramElement);
			
		//set type name in pictogram model
	    if(pictogramElement instanceof ContainerShape) {     
	    	ContainerShape containerShape = (ContainerShape) pictogramElement;
	    	for(Shape shape : containerShape.getChildren()) {
	    		if(shape.getGraphicsAlgorithm() instanceof Text) {
	    			Text text = (Text) shape.getGraphicsAlgorithm();
	                if(UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_DATATYPE_NAME)) {
	                   	text.setValue(businessTypeName);
	                   	returnValue = true;
	            }  	}
	            //set attribute and operation names and their places in pictogram model
	    		if(shape instanceof ContainerShape) {
	    			ContainerShape innerContainerShape = (ContainerShape) shape;
					if(innerContainerShape.getGraphicsAlgorithm() instanceof Rectangle) {
						//Attributes
						counter = 0;
						if(UIUtil.isShape_IdValue(innerContainerShape, literals.SHAPE_ID_DATATYPE_ATTRIBUTECONTAINER)) {
							for(Shape attributeShape : innerContainerShape.getChildren()) {
								if(UIUtil.isShape_IdValue(attributeShape, SHAPE_ID_ATTRIBUTE_TEXT)) {	
									Text text = (Text) attributeShape.getGraphicsAlgorithm();
									text.setValue(businessAttributeNames.get(counter));
									returnValue = true;
									counter++;
						}	}	}
						//Operations
						counter = 0;
						if(UIUtil.isShape_IdValue(innerContainerShape, literals.SHAPE_ID_DATATYPE_OPERATIONCONTAINER)) {
							for(Shape operationShape : innerContainerShape.getChildren()) {
								if(UIUtil.isShape_IdValue(operationShape, SHAPE_ID_OPERATION_TEXT)) {
									Text text = (Text) operationShape.getGraphicsAlgorithm();
									text.setValue(businessOperationNames.get(counter));									
									returnValue = true;
									counter++;
		}	}	}	}	}	}	}
	    return returnValue;
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
		if(UIUtil.isShape_IdValue((Shape) moveContext.getPictogramElement(), literals.SHAPE_ID_DATATYPE_SHADOW)) {
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
		Polygon typeBodyPolygon = (Polygon) typeBodyShape.getGraphicsAlgorithm();
		ContainerShape dropShadowShape = (ContainerShape) ((ContainerShape) typeBodyShape).getContainer().getChildren().get(0);
		Polygon dropShadowPolygon = (Polygon) dropShadowShape.getGraphicsAlgorithm();
			
		if(moveContext.getSourceContainer().equals(moveContext.getTargetContainer())) {
			dropShadowPolygon.setX(moveContext.getX()+literals.SHADOW_SIZE);
			dropShadowPolygon.setY(moveContext.getY()+literals.SHADOW_SIZE);
			super.moveShape(moveContext);
		} else {
			//targetContainer of moveContext is dropShadowShape
			//set targetContainer to diagram and use special calculation for the new position of type body and drop shadow 
			dropShadowPolygon.setX(typeBodyPolygon.getX()+moveContext.getX()+2*literals.SHADOW_SIZE);
			dropShadowPolygon.setY(typeBodyPolygon.getY()+moveContext.getY()+2*literals.SHADOW_SIZE);
			MoveShapeContext changedMoveContextForTypeBody = new MoveShapeContext(moveContext.getShape());
			changedMoveContextForTypeBody.setTargetContainer(dropShadowShape.getContainer());
			changedMoveContextForTypeBody.setX(typeBodyPolygon.getX()+moveContext.getX()+literals.SHADOW_SIZE);
			changedMoveContextForTypeBody.setY(typeBodyPolygon.getY()+moveContext.getY()+literals.SHADOW_SIZE);
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
		if(UIUtil.isShape_IdValue((Shape) resizeContext.getPictogramElement(), literals.SHAPE_ID_DATATYPE_SHADOW)) {
			return false;
		}
		return super.canResizeShape(resizeContext);
	}
			
	/**
	 * resizes the type body shape and drop shadow shape together and layouts the body shape to set the positions of its inner
	 * shapes.
	 * <p>
	 * This is needed to be done explicitly for the type body shape too, since the data type is a polygon.
	 */
	@Override
	public void resizeShape(IResizeShapeContext resizeContext) {
		ContainerShape typeBodyShape = (ContainerShape) resizeContext.getPictogramElement();
		Polygon typeBodyPolygon = (Polygon) typeBodyShape.getGraphicsAlgorithm();
		ContainerShape dropShadowShape = (ContainerShape) ((ContainerShape) typeBodyShape).getContainer().getChildren().get(0);
		Polygon dropShadowPolygon = (Polygon) dropShadowShape.getGraphicsAlgorithm();
		int X = resizeContext.getX();
		int Y = resizeContext.getY();
		int height = literals.MIN_HEIGHT, width = literals.MIN_WIDTH;
		if(resizeContext.getHeight() > literals.MIN_HEIGHT) height = resizeContext.getHeight();
		if(resizeContext.getWidth() > literals.MIN_WIDTH) width = resizeContext.getWidth();
		graphicAlgorithmService.setLocationAndSize(typeBodyPolygon, X, Y, width, height);
			
		//Point 1 stays the same
		//P2 stays the same		
		//P3 x=width-DATATYPE_CORNER_SIZE, y=0		
		typeBodyPolygon.getPoints().set(2, graphicAlgorithmService.createPoint(width-literals.DATATYPE_CORNER_SIZE, 0));
		dropShadowPolygon.getPoints().set(2, graphicAlgorithmService.createPoint(width-literals.DATATYPE_CORNER_SIZE, 0));
		//P4 x= width, y=DATATYPE_CORNER_SIZE
		typeBodyPolygon.getPoints().set(3, graphicAlgorithmService.createPoint(width, literals.DATATYPE_CORNER_SIZE));
		dropShadowPolygon.getPoints().set(3, graphicAlgorithmService.createPoint(width, literals.DATATYPE_CORNER_SIZE));
		//P5 x=width, y=height-DATATYPE_CORNER_SIZE
		typeBodyPolygon.getPoints().set(4, graphicAlgorithmService.createPoint(width, height-literals.DATATYPE_CORNER_SIZE));
		dropShadowPolygon.getPoints().set(4, graphicAlgorithmService.createPoint(width, height-literals.DATATYPE_CORNER_SIZE));
		//P6 x=width-DATATYPE_CORNER_SIZE y=height
		typeBodyPolygon.getPoints().set(5, graphicAlgorithmService.createPoint(width-literals.DATATYPE_CORNER_SIZE, height));
		dropShadowPolygon.getPoints().set(5, graphicAlgorithmService.createPoint(width-literals.DATATYPE_CORNER_SIZE, height));
		//P7 x=DATATYPE_CORNER_SIZE, x=height
		typeBodyPolygon.getPoints().set(6, graphicAlgorithmService.createPoint(literals.DATATYPE_CORNER_SIZE, height));
		dropShadowPolygon.getPoints().set(6, graphicAlgorithmService.createPoint(literals.DATATYPE_CORNER_SIZE, height));
		//P8 x=0, y=height-DATATYPE_CORNER_SIZE 
		typeBodyPolygon.getPoints().set(7, graphicAlgorithmService.createPoint(0, height-literals.DATATYPE_CORNER_SIZE));
		dropShadowPolygon.getPoints().set(7, graphicAlgorithmService.createPoint(0, height-literals.DATATYPE_CORNER_SIZE));
		layoutPictogramElement(resizeContext.getShape());
	}
	
	//delete feature
	//~~~~~~~~~~~~~~
	/**
	 * disables that the user can delete the drop shadow manually
	 */
	@Override
	public boolean canDelete(IDeleteContext deleteContext) {
		if(UIUtil.isShape_IdValue((Shape) deleteContext.getPictogramElement(), literals.SHAPE_ID_DATATYPE_SHADOW)) {
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
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * identifier literals used as shape ids for the shapes the attribute and operation containers
	 * <p>
	 * See {@link IdentifierLiterals} for the meaning of the identifiers.
	 */
	private final String SHAPE_ID_OPERATION_TEXT = IdentifierLiterals.SHAPE_ID_OPERATION_TEXT,
						 SHAPE_ID_OPERATION_INDICATOR_DOTS = IdentifierLiterals.SHAPE_ID_OPERATION_INDICATOR_DOTS,
						 SHAPE_ID_ATTRIBUTE_TEXT = IdentifierLiterals.SHAPE_ID_ATTRIBUTE_TEXT,
					     SHAPE_ID_ATTRIBUTE_INDICATOR_DOTS = IdentifierLiterals.SHAPE_ID_ATTRIBUTE_INDICATOR_DOTS;
	
	
	
	
	
	
	
	
		
	
		
	
}
