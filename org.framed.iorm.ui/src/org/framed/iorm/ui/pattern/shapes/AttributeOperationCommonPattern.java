package org.framed.iorm.ui.pattern.shapes;

import org.eclipse.graphiti.features.IDirectEditingInfo;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.impl.DeleteContext;
import org.eclipse.graphiti.features.context.impl.MultiDeleteInfo;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.pattern.IPattern;
import org.eclipse.graphiti.util.IColorConstant;
import org.framed.iorm.model.ModelElement;
import org.framed.iorm.model.NamedElement;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.literals.LayoutLiterals;
import org.framed.iorm.ui.literals.NameLiterals;
import org.framed.iorm.ui.literals.TextLiterals;
import org.framed.iorm.ui.util.NameUtil;
import org.framed.iorm.ui.util.GeneralUtil;
import org.framed.iorm.ui.util.PropertyUtil;

/**
 * This graphiti pattern is used to work with {@link NamedElement}s
 * of the type attribute and operation in the editor.
 * <p>
 * It deals with the following aspects of attributes and operations:<br>
 * (1) adding attributes and operations to the diagram, especially their pictogram elements<br>
 * (2) direct editing of the attributes or operations name<br>
 * (3) deleting attributes and operations from a class or role<br>
 * (4) disabling the move feature for attributes and operations<br>
 * (5) disabling the resize feature for attributes and operations
 * @author Kevin Kassin
 */
public class AttributeOperationCommonPattern extends FRaMEDShapePattern implements IPattern {
	
	/**
	 * the identifiers for the text rectangle of attributes or operations gathered from {@link IdentifierLiterals}
	 */
	private final String SHAPE_ID_ATTRIBUTE_TEXT = IdentifierLiterals.SHAPE_ID_ATTRIBUTE_TEXT,
						 SHAPE_ID_OPERATION_TEXT = IdentifierLiterals.SHAPE_ID_OPERATION_TEXT;
	
	/**
	 * the standard names for attributes and operations gathered from {@link NameLiterals}
	 */
	private final String STANDARD_ATTRIBUTE_NAME = NameLiterals.STANDARD_ATTRIBUTE_NAME,
						 STANDARD_OPERATION_NAME = NameLiterals.STANDARD_OPERATION_NAME;
						
	/**
	 * the feature name of the create feature in this pattern gathered from {@link NameLiterals}
	 */
	private final String ATTRIBUTE_OPERATION_COMMON_FEATURE_NAME = NameLiterals.ATTRIBUTE_OPERATION_COMMON_FEATURE_NAME;
	
	/**
	 * text literals used as warning if an invalid name for attributes or operation is chosen
	 * or another attribute or operation in the same class or role already has the same name 
	 * when direct editing
	 * gathered from {@link TextLiterals}
	 */
	private final String DIRECTEDITING_ATTRIBUTES = TextLiterals.DIRECTEDITING_ATTRIBUTES,
						 NAME_ALREADY_USED_ATTRIBUTES = TextLiterals.NAME_ALREADY_USED_ATTRIBUTES,
						 DIRECTEDITING_OPERATIONS = TextLiterals.DIRECTEDITING_OPERATIONS,
						 NAME_ALREADY_USED_OPERATIONS = TextLiterals.NAME_ALREADY_USED_OPERATIONS;
	
	/**
	 * layout integers used to add attributes and operations at the right position
	 */
	private final int HEIGHT_NAME_SHAPE = LayoutLiterals.HEIGHT_NAME_SHAPE,
			          PUFFER_BETWEEN_ELEMENTS = LayoutLiterals.PUFFER_BETWEEN_ELEMENTS,
			          HEIGHT_ATTRIBUTE_SHAPE = LayoutLiterals.HEIGHT_ATTRITBUTE_SHAPE,
			          HEIGHT_OPERATION_SHAPE = LayoutLiterals.HEIGHT_OPERATION_SHAPE;
	
	/**
	 * the color of the text in which attribute and operation names are written
	 */
	private final IColorConstant COLOR_TEXT = LayoutLiterals.COLOR_TEXT;
	
	/**
	 * Class constructor
	 */
	public AttributeOperationCommonPattern() {
		super();
	}
	
	/**
	 * get method for the create features name
	 * @return the name of the create feature
	 */
	@Override
	public String getCreateName() {
		return ATTRIBUTE_OPERATION_COMMON_FEATURE_NAME;
	}
	
	/**
	 * checks if pattern is applicable for a given business object
	 * @return true, if business object is of type {@link org.framed.iorm.model.NamedElement} but not
	 * of type {@link org.framed.iorm.model.ModelElement}
	 */
	@Override
	public boolean isMainBusinessObjectApplicable(Object businessObject) {
		return (businessObject instanceof NamedElement &&
				!(businessObject instanceof ModelElement));
	}

	/**
	 * checks if pattern is applicable for a given pictogram element
	 * @return true, if business object of the pictogram element is of type {@link org.framed.iorm.model.NamedElement} 
	 * but not of type {@link org.framed.iorm.model.ModelElement}
	 */
	@Override
	protected boolean isPatternControlled(PictogramElement pictogramElement) {
		Object businessObject = getBusinessObjectForPictogramElement(pictogramElement);
		return isMainBusinessObjectApplicable(businessObject);
	}

	/**
	 * checks if the pictogram element to edit with the pattern is its root
	 * @return true, if business object of the pictogram element is of type {@link org.framed.iorm.model.NamedElement} 
	 * but not of type {@link org.framed.iorm.model.ModelElement}
	 */
	@Override
	protected boolean isPatternRoot(PictogramElement pictogramElement) {
		Object businessObject = getBusinessObjectForPictogramElement(pictogramElement);
		return isMainBusinessObjectApplicable(businessObject);
	}
	
	//add feature
	//~~~~~~~~~~~
	/**
	 * calculates if the attribute or operation can be added to the class or role
	 * <p>
	 * returns true if:<br>
	 * (1) the new business object is a named element with the standard attribute name or operation name and<br> 
	 * (2) the attribute or operation is added to a class or role that is a {@link org.framed.iorm.model.Shape} of the
	 * 	   right type
	 * @return if the attribute or operation can be added
	 */
	@Override
	public boolean canAdd(IAddContext addContext) {
		if(addContext.getNewObject() instanceof NamedElement) {
			NamedElement namedElement = (NamedElement) addContext.getNewObject();
			if(namedElement.getName().startsWith(STANDARD_ATTRIBUTE_NAME) || namedElement.getName().startsWith(STANDARD_OPERATION_NAME)) {
				PictogramElement pictogramElement = addContext.getTargetContainer();
				Object businessObject = getBusinessObjectForPictogramElement(pictogramElement);
				if(businessObject instanceof org.framed.iorm.model.Shape) {
					org.framed.iorm.model.Shape shape = (org.framed.iorm.model.Shape) businessObject;
					if(shape.getType() == Type.NATURAL_TYPE) return true;
					if(shape.getType() == Type.DATA_TYPE) return true;			
		}	}	}	
		return false;
	}

	/**
	 * adds the graphical representation of an attribute or operation in the class or role
	 * <p>
	 * It creates the following structure in the class or roles <em>attribute container shape</em>
	 * or <em>operation container shape</em>:<br>
	 * <ul>
	 *   <li>attribute or operation shape</li>
	 *   	<ul><li>attribute or operation name text</li></ul>
	 * </ul>  
	 * <p>
	 * It uses follows this steps:<br>
	 * Step 1: It gets the new object and the class or roles <em>attribute container shape</em> or <em>operation container shape</em> 
	 * 		   to create the attribute or operation in.<br>
	 * Step 2: It calculates the needed sizes and position of the horizontal center line.<br>
	 * Step 3: It creates the structure shown above and sets the shape identifiers for the created graphics algorithms.<br>
	 * Step 4: It enables direct editing for the attribute or operation and links it pictogram element to its business object.
	 * <p>
	 * If its not clear what <em>attribute container shape</em>, <em>operation container shape</em> and 
	 * <em>horizontal center line</em> means, see for example {@link NaturalTypePattern#add} for reference.
	 * @return the added pictogram element
	 */
	@Override
	public PictogramElement add(IAddContext addContext) {
		//Step 1
		Shape attributeOrOperationShape = null;
		Text text = null;
		NamedElement addedAttributeOrOperation = (NamedElement) addContext.getNewObject();
		ContainerShape classOrRoleContainer = (ContainerShape) addContext.getTargetContainer();
		org.framed.iorm.model.Shape businessObjectOfClassOrRole = (org.framed.iorm.model.Shape) getBusinessObjectForPictogramElement(classOrRoleContainer);
		ContainerShape attributeContainer = (ContainerShape) addContext.getTargetContainer().getChildren().get(2),
					   operationContainer = (ContainerShape) addContext.getTargetContainer().getChildren().get(4);
		//Step 2
		int attributeContainerSize = attributeContainer.getChildren().size(),
		    operationContainerSize = operationContainer.getChildren().size(); 	
		int horizontalCenter;
			horizontalCenter = GeneralUtil.calculateHorizontalCenter(businessObjectOfClassOrRole.getType(), 
							    	classOrRoleContainer.getGraphicsAlgorithm().getHeight());
		//Step 3
		 if(addedAttributeOrOperation.getName().startsWith(STANDARD_ATTRIBUTE_NAME)) {
	    	attributeOrOperationShape = pictogramElementCreateService.createShape(attributeContainer, true);
	    	text = graphicAlgorithmService.createText(attributeOrOperationShape, addedAttributeOrOperation.getName());
	    	text.setForeground(manageColor(COLOR_TEXT));
	    	graphicAlgorithmService.setLocationAndSize(text, PUFFER_BETWEEN_ELEMENTS, HEIGHT_NAME_SHAPE+PUFFER_BETWEEN_ELEMENTS+HEIGHT_ATTRIBUTE_SHAPE*attributeContainerSize, 
	    								 classOrRoleContainer.getGraphicsAlgorithm().getWidth()-2*PUFFER_BETWEEN_ELEMENTS, HEIGHT_ATTRIBUTE_SHAPE);
	    	PropertyUtil.setShape_IdValue(attributeOrOperationShape, SHAPE_ID_ATTRIBUTE_TEXT);
	    } else {
			if(addedAttributeOrOperation.getName().startsWith(STANDARD_OPERATION_NAME)) {
		    	attributeOrOperationShape = pictogramElementCreateService.createShape(operationContainer, true);
		    	text = graphicAlgorithmService.createText(attributeOrOperationShape, addedAttributeOrOperation.getName());
		    	text.setForeground(manageColor(COLOR_TEXT));
		    	graphicAlgorithmService.setLocationAndSize(text, PUFFER_BETWEEN_ELEMENTS, PUFFER_BETWEEN_ELEMENTS+horizontalCenter+HEIGHT_OPERATION_SHAPE*operationContainerSize, 
						 classOrRoleContainer.getGraphicsAlgorithm().getWidth()-2*PUFFER_BETWEEN_ELEMENTS, HEIGHT_OPERATION_SHAPE);
		    	PropertyUtil.setShape_IdValue(attributeOrOperationShape, SHAPE_ID_OPERATION_TEXT);	      	
		    } else return null;    
	    }	
		//Step 4
	    IDirectEditingInfo directEditingInfo = getFeatureProvider().getDirectEditingInfo();
		directEditingInfo.setMainPictogramElement(classOrRoleContainer);
		directEditingInfo.setPictogramElement(attributeOrOperationShape);
		directEditingInfo.setGraphicsAlgorithm(text);
	    link(attributeOrOperationShape, addedAttributeOrOperation);
	    this.layoutPictogramElement(classOrRoleContainer);
		return attributeOrOperationShape;
	}
	
	//direct editing feature
	//~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * sets the editing type as a text field for the direct editing of the attributes or operations name
	 */
	@Override
	public int getEditingType() {
		return TYPE_TEXT;
	}
		
	/**
	 * checks if a pictogram element can be direct edited
	 * <p>
	 * returns true if:<br>
	 * (1) the business object of the pictogram element is of the type {@link NamedElement} and<br>
	 * (2) the the graphics algorithm of the pictogram element is of the type {@link Text}
	 * @return if direct editing is possible for a pictogram element
	 */
	public boolean canDirectEdit(IDirectEditingContext editingContext) {
		Object businessObject = getBusinessObject(editingContext);
		GraphicsAlgorithm graphicsAlgorithm = editingContext.getGraphicsAlgorithm();
		if(businessObject instanceof NamedElement && graphicsAlgorithm instanceof Text)
			return true;
		return false;
	}

	/**
	 * returns the initials value of the text field when direct editing the attributes or operations name
	 * @return the current name of the attribute or operation as initial value
	 */
	@Override
	public String getInitialValue(IDirectEditingContext editingContext) {
		NamedElement operation = (NamedElement) getBusinessObject(editingContext);
		return operation.getName();
	}
		
	/**
	 * checks if the chosen attribute or operation name is a valid value for it
	 * <p>
	 * This is done by using the regular expressions and by checking if another attribute or
	 * operation in the same class or role has the same name. Both checks are done with operations
	 * in the class {@link NameUtil}.
	 * @return if the new value of an attributes or operations name is valid
	 */
	public String checkValueValid(String newName, IDirectEditingContext editingContext) {
		if(getInitialValue(editingContext).equals(newName)) return null;
		Shape shape = (Shape) editingContext.getPictogramElement();
		ContainerShape classOrRoleShape = shape.getContainer().getContainer();
		ContainerShape attributeContainer = (ContainerShape) classOrRoleShape.getChildren().get(2);
		ContainerShape operationContainer = (ContainerShape) classOrRoleShape.getChildren().get(4);
		if(attributeContainer.getChildren().contains(shape))	{
			if(!(NameUtil.matchesAttribute(newName))) return DIRECTEDITING_ATTRIBUTES;
			if(NameUtil.nameAlreadyUsedForAttributeOrOperation(attributeContainer, newName)) 
				return NAME_ALREADY_USED_ATTRIBUTES;
		}
		if(operationContainer.getChildren().contains(shape))	{
			if(!(NameUtil.matchesOperation(newName))) return DIRECTEDITING_OPERATIONS;
			if(NameUtil.nameAlreadyUsedForAttributeOrOperation(operationContainer, newName)) 
				return NAME_ALREADY_USED_OPERATIONS;
		}
		return null;
	}	
			
	/**
	 * set the new attribute or operation name if the value of it was evaluated as valid in 
	 * {@link #checkValueValid}
	 * <p>
	 * This operations also calls {@link updatePictogramElement} to update the class or role
	 * that contains the attribute or operation.
	 */
	public void setValue(String newName, IDirectEditingContext editingContext) {	   
		NamedElement attributeOrOperation = (NamedElement) getBusinessObject(editingContext);
		attributeOrOperation.setName(newName);
		updatePictogramElement(((Shape) editingContext.getPictogramElement()).getContainer().getContainer());
	}
	
	//delete feature
	//~~~~~~~~~~~~~~	
	/**
	 * deletes an attribute or operation from the pictogram and business model
	 * <p>
	 * This operation also disables the <em>"Are you sure" popup</em> when deleting an attribute
	 * or operation and calls {@link #updatePictogramElement} to update the class or role that contained
	 * the attribute or operation before.
	 */
	@Override
	public void delete(IDeleteContext deleteContext) {
		Shape ClassOrRole = ((Shape) deleteContext.getPictogramElement()).getContainer().getContainer();
		((DeleteContext) deleteContext).setMultiDeleteInfo(new MultiDeleteInfo(false, false, 0));
		super.delete(deleteContext);
		updatePictogramElement(ClassOrRole);
	}
		
	//move feature
	//~~~~~~~~~~~~
	/**
	 * disables the move feature for attributes and operations
	 */
	@Override
	public boolean canMoveShape(IMoveShapeContext moveContext) {
		return false;
	}
		
	//resize feature
	//~~~~~~~~~~~~~~
	/**
	 * disables the resize feature for attributes and operations
	 */
	@Override
	public boolean canResizeShape(IResizeShapeContext context) {
		return false; 
	}
}
