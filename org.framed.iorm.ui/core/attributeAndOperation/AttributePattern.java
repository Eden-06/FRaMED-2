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
 * of the type attribute in the editor.
 * <p>
 * It deals with the following aspect of attributes:<br>
 * (1) creating the attribute, especially its business object<br>
 * @see AttributeOperationCommonPattern
 * @author Kevin Kassin
 */
public class AttributePattern extends AttributeOperationCommonPattern implements IPattern {
			
	/**
	 * class constructor	
	 */
	public AttributePattern() {
		super();
		FEATURE_NAME = literals.ATT_FEATURE_NAME;
		ICON_IMG_ID = literals.ATT_ICON_IMG_ID;
		ICON_IMG_PATH = literals.ATT_ICON_IMG_PATH;
	}	
	
	//create feature
	//~~~~~~~~~~~~~~
	/**
	 * calculates if an attribute can be created
	 * <p>
	 * returns true if:<br>
	 * (1) the attribute is created in a class or role that is a {@link org.framed.iorm.model.Shape} and<br>
	 * (2) not the drop shadow of a class or role is selected of the right type. Which types these are is 
	 *     saved in {@link #usedInReferences}. This list also used to get the Shape ids of the drop shadow. 
	 * @return if an attribute can be created
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
						return EditPolicyService.getHandler(this.getDiagram()).canCreate(createContext);
		}	}	}
		return false;
	}

	/**
	 * creates the business object of the attribute, adds it to business object of the class or role in which
	 * the attribute is created in and calls the add function for the attribute in 
	 * {@link AttributeOperationCommonPattern}
	 * @return the created business object of the attribute
	 */
	@Override
	public Object[] create(ICreateContext createContext) {
		ContainerShape attributeContainer = (ContainerShape) createContext.getTargetContainer().getChildren().get(2);
		NamedElement newAttribute = OrmFactory.eINSTANCE.createNamedElement();
		String standartName = util.calculateStandardNameForAttributeOrOperation(attributeContainer, literals.ATT_STANDARD_NAME);
		newAttribute.setName(standartName);
		if(newAttribute.eResource() != null) getDiagram().eResource().getContents().add(newAttribute);
		org.framed.iorm.model.Shape classOrRole = 
			(org.framed.iorm.model.Shape) getBusinessObjectForPictogramElement(createContext.getTargetContainer());
		classOrRole.getFirstSegment().getElements().add(newAttribute);
		getFeatureProvider().getDirectEditingInfo().setActive(true);
		addGraphicalRepresentation(createContext, newAttribute);
		return new Object[] { newAttribute };
	}
}
