package attributeAndOperation;

import java.util.List;

import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.pattern.IPattern;
import org.framed.iorm.model.ModelElement;
import org.framed.iorm.model.NamedElement;
import org.framed.iorm.model.OrmFactory;
import org.framed.iorm.ui.FRaMEDShapePattern;
import org.framed.iorm.ui.editPolicy.EditPolicyService;
import org.framed.iorm.ui.palette.FeaturePaletteDescriptor;
import org.framed.iorm.ui.palette.PaletteCategory;
import org.framed.iorm.ui.palette.PaletteView;
import org.framed.iorm.ui.palette.ViewVisibility;
import org.framed.iorm.ui.util.UIUtil;

import attributeAndOperation.references.AbstractUsedInReference;

/**
 * This graphiti pattern is used to work with {@link NamedElement}s
 * of the type attribute in the editor.
 * <p>
 * It deals with the following aspect of attributes:<br>
 * (1) creating the attribute, especially its business object<br>
 * @see AttributeOperationCommonPattern
 * @author Kevin Kassin
 */
public class AttributePattern extends FRaMEDShapePattern implements IPattern {
	
	/**
	 * the object to get names, id and so on for this feature
	 */
	private final Literals literals = new Literals();
	
	/**
	 * the object to call utility operations on
	 */
	private final Util util = new Util();
	
	/**
	 * the feature palette descriptor manages the palette visibility, see {@link FeaturePaletteDescriptor}
	 */
	private final FeaturePaletteDescriptor spec_FPD = new FeaturePaletteDescriptor(
		PaletteCategory.PROPERTIES_CATEGORY,
		ViewVisibility.ALL_VIEWS) {
			@Override
			public boolean featureExpression(List<String> framedFeatureNames, PaletteView paletteView) {
				switch(paletteView) {
				case TOPLEVEL_VIEW: return true;
				case COMPARTMENT_VIEW: 
					return (framedFeatureNames.contains("Role_Properties") ||
							framedFeatureNames.contains("Compartment_Properties"));
				default: return false;
		}	}	};
		
	/**
	 * the list of reference classes which save in which other module feature's shapes a attribute or
	 * operation can be added with specific informations for these.
	 * @see AbstractUsedInReference
	 */
	private List<AbstractUsedInReference> usedInReferences; 
		
	/**
	 * class constructor
	 * <p>	
	 * Note: It gets the references which save in which other module feature's shapes a attribute or
	 * operations can be added here and saves them it into {@link #usedInReferences}.		
	 */
	public AttributePattern() {
		super();
		FEATURE_NAME = literals.ATT_FEATURE_NAME;
		ICON_IMG_ID = literals.ATT_ICON_IMG_ID;
		ICON_IMG_PATH = literals.ATT_ICON_IMG_PATH;
		FPD = spec_FPD;
		//Note
		List<Class<?>> classes = UIUtil.findModuleJavaClasses();
		usedInReferences = util.getUsedInReferences(classes);
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
			if(util.usedInModelTypes(usedInReferences).contains(shape.getType())) {
				boolean isShadowShape = false;
				for(AbstractUsedInReference auir : usedInReferences) {
					if(UIUtil.isShape_IdValue((Shape) pictogramElement, auir.getShadowShapeID()))
						isShadowShape = true;
				}
				if(!isShadowShape)
					return EditPolicyService.canCreate(createContext, this.getDiagram());
		}	}
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
		String standartName = UIUtil.calculateStandardNameForAttributeOrOperation(attributeContainer, literals.ATT_STANDARD_NAME);
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
