package org.framed.iorm.ui.pattern.shapes;

import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.pattern.IPattern;
import org.framed.iorm.model.ModelElement;
import org.framed.iorm.model.NamedElement;
import org.framed.iorm.model.OrmFactory;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.editPolicy.EditPolicyService;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.literals.NameLiterals;
import org.framed.iorm.ui.pattern.shapes.AttributeOperationCommonPattern; //*import for javadoc link
import org.framed.iorm.ui.util.NameUtil;
import org.framed.iorm.ui.util.PropertyUtil;

/**
 * This graphiti pattern is used to work with {@link NamedElement}s
 * of the type operation in the editor.
 * <p>
 * It deals with the following aspect of operations:<br>
 * (1) creating the operation, especially its business object<br>
 * @see AttributeOperationCommonPattern
 * @author Kevin Kassin
 */
public class OperationPattern extends FRaMEDShapePattern implements IPattern {
	
	/**
	 * the name of the create feature in this pattern and the standard names of operations 
	 * gathered from {@link NameLiterals}
	 */
	private final String STANDARD_OPERATION_NAME = NameLiterals.STANDARD_OPERATION_NAME,
						 OPERATION_FEATURE_NAME = NameLiterals.OPERATION_FEATURE_NAME;
	
	/**
	 * the values of the property shape id for the drop shadows of class or roles gathered form
	 * {@link IdentifierLiterals}
	 */
	private final String SHAPE_ID_NATURALTYPE_SHADOW = IdentifierLiterals.SHAPE_ID_NATURALTYPE_SHADOW,
						 SHAPE_ID_COMPARTMENTTYPE_SHADOW = IdentifierLiterals.SHAPE_ID_COMPARTMENTTYPE_SHADOW,
						 SHAPE_ID_DATATYPE_SHADOW = IdentifierLiterals.SHAPE_ID_DATATYPE_SHADOW,
					     SHAPE_ID_ROLETYPE_SHADOW = IdentifierLiterals.SHAPE_ID_ROLETYPE_SHADOW;
	
	/**
	 * the image identifier for the icon of the create feature in this pattern gathered from
	 * {@link IdentifierLiterals}
	 */
	private final String IMG_ID_FEATURE_OPERATION = IdentifierLiterals.IMG_ID_FEATURE_OPERATION;
	
	/**
	 * Class constructor
	 */
	public OperationPattern() {
		super();
	}
	
	/**
	 * get method for the create features name
	 * @return the name of the create feature
	 */
	@Override
	public String getCreateName() {
		return OPERATION_FEATURE_NAME;
	}
	
	/**
	 * enables the icon for the create feature in this pattern
	 * @return the image identifier for the icon of the create feature in this pattern
	 */
	@Override
	public String getCreateImageId() {
		return IMG_ID_FEATURE_OPERATION;
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
	
	//create feature
	//~~~~~~~~~~~~~~
	/**
	 * calculates if an operation can be created
	 * <p>
	 * returns true if:<br>
	 * (1) the operation is created in a class or role that is a {@link org.framed.iorm.model.Shape} and<br>
	 * (2) not the drop shadow of a class or role is selected
	 * of the right type
	 * @return if an operation can be created
	 */
	@Override
	public boolean canCreate(ICreateContext createContext) {
		PictogramElement pictogramElement = createContext.getTargetContainer();
		Object businessObject =  getBusinessObjectForPictogramElement(pictogramElement);	
		if(businessObject instanceof org.framed.iorm.model.Shape) {
			org.framed.iorm.model.Shape shape = (org.framed.iorm.model.Shape) businessObject; 
			if(shape.getType() == Type.NATURAL_TYPE ||
			   shape.getType() == Type.DATA_TYPE ||
			   shape.getType() == Type.COMPARTMENT_TYPE ||
			   shape.getType() == Type.ROLE_TYPE) {
				if(!(PropertyUtil.isShape_IdValue((Shape) pictogramElement, SHAPE_ID_NATURALTYPE_SHADOW)) &&
				   !(PropertyUtil.isShape_IdValue((Shape) pictogramElement, SHAPE_ID_COMPARTMENTTYPE_SHADOW)) &&
				   !(PropertyUtil.isShape_IdValue((Shape) pictogramElement, SHAPE_ID_DATATYPE_SHADOW)) &&
				   !(PropertyUtil.isShape_IdValue((Shape) pictogramElement, SHAPE_ID_ROLETYPE_SHADOW)))
    				return true && EditPolicyService.canCreate(createContext, this.getDiagram());
		}	}
		return false;
	}

	/**
	 * creates the business object of the operation, adds it to business object of the class or role in which
	 * the operation is created in and calls the add function for the operation in 
	 * {@link AttributeOperationCommonPattern}
	 * @return the created business object of the operation
	 */
	@Override
	public Object[] create(ICreateContext createContext) {
		ContainerShape operationContainer = (ContainerShape) createContext.getTargetContainer().getChildren().get(4);
		NamedElement newOperation = OrmFactory.eINSTANCE.createNamedElement();
		String standartName = NameUtil.calculateStandardNameForAttributeOrOperation(operationContainer, STANDARD_OPERATION_NAME);
		newOperation.setName(standartName);
		org.framed.iorm.model.Shape classOrRole = 
				(org.framed.iorm.model.Shape) getBusinessObjectForPictogramElement(createContext.getTargetContainer());
		if(newOperation.eResource() != null) getDiagram().eResource().getContents().add(newOperation);
		classOrRole.getSecondSegment().getElements().add(newOperation);
		getFeatureProvider().getDirectEditingInfo().setActive(true);
		addGraphicalRepresentation(createContext, newOperation);
		return new Object[] { newOperation };
	}
}
