package attributeAndOperation;

import java.util.List;

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
import org.framed.iorm.model.ModelElement;
import org.framed.iorm.model.NamedElement;
import org.framed.iorm.ui.FRaMEDShapePattern;
import org.framed.iorm.ui.UIUtil;
import org.framed.iorm.ui.editPolicy.EditPolicyService;
import org.framed.iorm.ui.palette.FeaturePaletteDescriptor;
import org.framed.iorm.ui.palette.PaletteCategory;
import org.framed.iorm.ui.palette.PaletteView;
import org.framed.iorm.ui.palette.ViewVisibility;
import org.framed.iorm.ui.references.AbstractHasAttsAndOpsReference;

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
 * <p>
 * This is the abstract super class managing all common attributes and behavior for its sub classes of the 
 * attribute and the operation pattern.
 * @author Kevin Kassin
 */
public abstract class AttributeOperationCommonPattern extends FRaMEDShapePattern implements IPattern {
	
	/**
	 * the object to get names, id and so on for this feature
	 */
	protected final Literals literals = new Literals();
	
	/**
	 * the object to call utility operations on
	 */
	protected final Util util = new Util();
			
	/**
	 * the list of reference classes which save in which other module feature's shapes a attribute or
	 * operation can be added with specific informations for these.
	 * @see AbstractUsedInReference
	 */
	protected List<AbstractHasAttsAndOpsReference> usedInReferences;
	
	/**
	 * the feature palette descriptor manages the palette visibility, see {@link FeaturePaletteDescriptor}
	 */
	protected final FeaturePaletteDescriptor spec_FPD = new FeaturePaletteDescriptor(
		PaletteCategory.PROPERTIES_CATEGORY,
		ViewVisibility.ALL_VIEWS) {
			@Override
			public boolean featureExpression(List<String> framedFeatureNames, PaletteView paletteView) {
				switch(paletteView) {
				case NON_COMPARTMENT_VIEW: return true;
				case COMPARTMENT_VIEW: 
					return (framedFeatureNames.contains("Role_Properties") ||
							framedFeatureNames.contains("Compartment_Properties"));
				default: return false;
		}	}	};
	
	/**
	 * class constructor
	 * <p>	
	 * Note: It gets the references which save in which other module feature's shapes a attribute or
	 * operations can be added here and saves them it into {@link #usedInReferences}.		
	 */
	public AttributeOperationCommonPattern() {
		FPD = spec_FPD;
		//Note
		List<Class<?>> classes = UIUtil.findModuleJavaClasses();
		usedInReferences = util.getHasAttsAndOpsReferences(classes);
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
	 * 	   right type. Which types these are is saved in {@link #usedInReferences}.
	 * 
	 * @return if the attribute or operation can be added
	 */
	@Override
	public boolean canAdd(IAddContext addContext) {
		if(addContext.getNewObject() instanceof NamedElement) {
			NamedElement namedElement = (NamedElement) addContext.getNewObject();
			if(namedElement.getName().startsWith(literals.ATT_STANDARD_NAME) || namedElement.getName().startsWith(literals.OPS_STANDARD_NAME)) {
				PictogramElement pictogramElement = addContext.getTargetContainer();
				Object businessObject = getBusinessObjectForPictogramElement(pictogramElement);
				if(businessObject instanceof org.framed.iorm.model.Shape) {
					org.framed.iorm.model.Shape shape = (org.framed.iorm.model.Shape) businessObject;
					if(util.usedInModelTypes(usedInReferences).contains(shape.getType()))
					   return EditPolicyService.getHandler(this.getDiagram()).canAdd(addContext);
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
	 * Step 2: It calculates the needed sizes and position of the horizontal center line. To calculate the horizontal center it uses
	 * 		   list {@link usedInReferences} and checks for the correct operation there by type of the shape to which a attribute or
	 * 	       operation is added to.<br>
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
		int horizontalCenter = -1;
		for(AbstractHasAttsAndOpsReference haaor : usedInReferences) {
			if(businessObjectOfClassOrRole.getType() == haaor.getModelType())
				horizontalCenter = haaor.getHorizontalCenter(classOrRoleContainer.getGraphicsAlgorithm().getHeight());
		}	
		if(horizontalCenter == -1) return null;
		//Step 3
		if(addedAttributeOrOperation.getName().startsWith(literals.ATT_STANDARD_NAME)) {
		   	attributeOrOperationShape = pictogramElementCreateService.createShape(attributeContainer, true);
		   	text = graphicAlgorithmService.createText(attributeOrOperationShape, addedAttributeOrOperation.getName());
		   	text.setForeground(manageColor(literals.COLOR_TEXT));
		    graphicAlgorithmService.setLocationAndSize(text, literals.PUFFER_BETWEEN_ELEMENTS, literals.HEIGHT_NAME_SHAPE+literals.PUFFER_BETWEEN_ELEMENTS+literals.HEIGHT_ATTRIBUTE_SHAPE*attributeContainerSize, 
		    	classOrRoleContainer.getGraphicsAlgorithm().getWidth()-2*literals.PUFFER_BETWEEN_ELEMENTS, literals.HEIGHT_ATTRIBUTE_SHAPE);
		    UIUtil.setShape_IdValue(attributeOrOperationShape, literals.SHAPE_ID_ATTRIBUTE_TEXT);
		} else {
			if(addedAttributeOrOperation.getName().startsWith(literals.OPS_STANDARD_NAME)) {
				attributeOrOperationShape = pictogramElementCreateService.createShape(operationContainer, true);
			    text = graphicAlgorithmService.createText(attributeOrOperationShape, addedAttributeOrOperation.getName());
			    text.setForeground(manageColor(literals.COLOR_TEXT));
			    graphicAlgorithmService.setLocationAndSize(text, literals.PUFFER_BETWEEN_ELEMENTS, literals.PUFFER_BETWEEN_ELEMENTS+horizontalCenter+literals.HEIGHT_OPERATION_SHAPE*operationContainerSize, 
			    	classOrRoleContainer.getGraphicsAlgorithm().getWidth()-2*literals.PUFFER_BETWEEN_ELEMENTS, literals.HEIGHT_OPERATION_SHAPE);
			    UIUtil.setShape_IdValue(attributeOrOperationShape, literals.SHAPE_ID_OPERATION_TEXT);	      	
			} else return null;    
		}	
		//Step 4
		IDirectEditingInfo directEditingInfo = getFeatureProvider().getDirectEditingInfo();
		directEditingInfo.setMainPictogramElement(attributeOrOperationShape);
		directEditingInfo.setPictogramElement(attributeOrOperationShape);
		directEditingInfo.setGraphicsAlgorithm(text);
		link(attributeOrOperationShape, addedAttributeOrOperation);
		layoutPictogramElement(classOrRoleContainer);
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
		if(businessObject instanceof NamedElement && graphicsAlgorithm instanceof Text) {
			Shape shape = (Shape) editingContext.getPictogramElement();
			return (UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_ATTRIBUTE_TEXT) ||
					UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_OPERATION_TEXT));
		}		
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
		//TODO use properties to get attribute and operation container 
		ContainerShape attributeContainer = (ContainerShape) classOrRoleShape.getChildren().get(2);
		ContainerShape operationContainer = (ContainerShape) classOrRoleShape.getChildren().get(4);
		if(attributeContainer.getChildren().contains(shape))	{
			if(!(util.matchesAttribute(newName))) return literals.DIRECTEDITING_ATTRIBUTES;
			if(util.nameAlreadyUsedForAttributeOrOperation(attributeContainer, newName))
				return literals.NAME_ALREADY_USED_ATTRIBUTES;
		}
		if(operationContainer.getChildren().contains(shape))	{
			if(!(util.matchesOperation(newName))) return literals.DIRECTEDITING_OPERATIONS;
			if(util.nameAlreadyUsedForAttributeOrOperation(operationContainer, newName)) 
				return literals.NAME_ALREADY_USED_OPERATIONS;
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
