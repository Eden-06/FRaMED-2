package attributeAndOperation;

import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.pattern.IPattern;
import org.framed.iorm.model.NamedElement;
import org.framed.iorm.model.OrmFactory;
import org.framed.iorm.ui.UIUtil;
import org.framed.iorm.ui.editPolicy.EditPolicyService;
import org.framed.iorm.ui.references.AbstractHasAttsAndOpsReference;

/**
 * This graphiti pattern is used to work with {@link NamedElement}s
 * of the type operation in the editor.
 * <p>
 * It deals with the following aspect of operations:<br>
 * (1) creating the operation, especially its business object<br>
 * @see AttributeOperationCommonPattern
 * @author Kevin Kassin
 */
public class OperationPattern extends AttributeOperationCommonPattern implements IPattern {
		
	/**
	 * class constructor	
	 */
	public OperationPattern() {
		super();
		FEATURE_NAME = literals.OPS_FEATURE_NAME;
		ICON_IMG_ID = literals.OPS_ICON_IMG_ID;
		ICON_IMG_PATH = literals.OPS_ICON_IMG_PATH;
	}	
	
	//create feature
	//~~~~~~~~~~~~~~
	/**
	 * calculates if an operation can be created
	 * <p>
	 * returns true if:<br>
	 * (1) the attribute is created in a class or role that is a {@link org.framed.iorm.model.Shape} and<br>
	 * (2) not the drop shadow of a class or role is selected of the right type. Which types these are is 
	 *     saved in {@link #usedInReferences}. This list also used to get the Shape ids of the drop shadow. 
	 * @return if an operation can be created
	 */
	@Override
	public boolean canCreate(ICreateContext createContext) {
		PictogramElement pictogramElement = createContext.getTargetContainer();
		Object businessObject =  getBusinessObjectForPictogramElement(pictogramElement);	
		if(businessObject instanceof org.framed.iorm.model.Shape) {
			org.framed.iorm.model.Shape shape = (org.framed.iorm.model.Shape) businessObject; 
			if(shape.getFirstSegment() != null && shape.getSecondSegment() !=null) {
				if(util.usedInModelTypes(usedInReferences).contains(shape.getType())) {
					boolean isShadowShape = false;
					for(AbstractHasAttsAndOpsReference haaor : usedInReferences) {
						if(UIUtil.isShape_IdValue((Shape) pictogramElement, haaor.getShadowShapeID()))
							isShadowShape = true;
					}
					if(!isShadowShape)
						return EditPolicyService.canCreate(createContext, this.getDiagram());					
		}	}	}
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
		String standartName = util.calculateStandardNameForAttributeOrOperation(operationContainer, literals.OPS_STANDARD_NAME);
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
