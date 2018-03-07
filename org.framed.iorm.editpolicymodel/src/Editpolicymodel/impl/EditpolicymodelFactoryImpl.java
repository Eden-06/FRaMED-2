/**
 */
package Editpolicymodel.impl;

import Editpolicymodel.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EditpolicymodelFactoryImpl extends EFactoryImpl implements EditpolicymodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EditpolicymodelFactory init() {
		try {
			EditpolicymodelFactory theEditpolicymodelFactory = (EditpolicymodelFactory)EPackage.Registry.INSTANCE.getEFactory(EditpolicymodelPackage.eNS_URI);
			if (theEditpolicymodelFactory != null) {
				return theEditpolicymodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EditpolicymodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EditpolicymodelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EditpolicymodelPackage.MODEL: return createModel();
			case EditpolicymodelPackage.POLICY: return createPolicy();
			case EditpolicymodelPackage.CONTAINS: return createContains();
			case EditpolicymodelPackage.IS_STEP_IN: return createIsStepIn();
			case EditpolicymodelPackage.IS_TARGET: return createIsTarget();
			case EditpolicymodelPackage.IS_SOURCE: return createIsSource();
			case EditpolicymodelPackage.IS_PARENT: return createIsParent();
			case EditpolicymodelPackage.RULE: return createRule();
			case EditpolicymodelPackage.IS_FEATURE: return createIsFeature();
			case EditpolicymodelPackage.IS_TARGET_TYPE: return createIsTargetType();
			case EditpolicymodelPackage.NOT_RULE: return createNotRule();
			case EditpolicymodelPackage.AND_RULE: return createAndRule();
			case EditpolicymodelPackage.TRUE_RULE: return createTrueRule();
			case EditpolicymodelPackage.FALSE_RULE: return createFalseRule();
			case EditpolicymodelPackage.OR_RULE: return createOrRule();
			case EditpolicymodelPackage.IMPLICATION_RULE: return createImplicationRule();
			case EditpolicymodelPackage.IS_SOURCE_TYPE: return createIsSourceType();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case EditpolicymodelPackage.ACTION_ENUM:
				return createActionEnumFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case EditpolicymodelPackage.ACTION_ENUM:
				return convertActionEnumToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model createModel() {
		ModelImpl model = new ModelImpl();
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Policy createPolicy() {
		PolicyImpl policy = new PolicyImpl();
		return policy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Contains createContains() {
		ContainsImpl contains = new ContainsImpl();
		return contains;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IsStepIn createIsStepIn() {
		IsStepInImpl isStepIn = new IsStepInImpl();
		return isStepIn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IsTarget createIsTarget() {
		IsTargetImpl isTarget = new IsTargetImpl();
		return isTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IsSource createIsSource() {
		IsSourceImpl isSource = new IsSourceImpl();
		return isSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IsParent createIsParent() {
		IsParentImpl isParent = new IsParentImpl();
		return isParent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T> Rule<T> createRule() {
		RuleImpl<T> rule = new RuleImpl<T>();
		return rule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IsFeature createIsFeature() {
		IsFeatureImpl isFeature = new IsFeatureImpl();
		return isFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IsTargetType createIsTargetType() {
		IsTargetTypeImpl isTargetType = new IsTargetTypeImpl();
		return isTargetType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T> NotRule<T> createNotRule() {
		NotRuleImpl<T> notRule = new NotRuleImpl<T>();
		return notRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T> AndRule<T> createAndRule() {
		AndRuleImpl<T> andRule = new AndRuleImpl<T>();
		return andRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T> TrueRule<T> createTrueRule() {
		TrueRuleImpl<T> trueRule = new TrueRuleImpl<T>();
		return trueRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T> FalseRule<T> createFalseRule() {
		FalseRuleImpl<T> falseRule = new FalseRuleImpl<T>();
		return falseRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T> OrRule<T> createOrRule() {
		OrRuleImpl<T> orRule = new OrRuleImpl<T>();
		return orRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T> ImplicationRule<T> createImplicationRule() {
		ImplicationRuleImpl<T> implicationRule = new ImplicationRuleImpl<T>();
		return implicationRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IsSourceType createIsSourceType() {
		IsSourceTypeImpl isSourceType = new IsSourceTypeImpl();
		return isSourceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionEnum createActionEnumFromString(EDataType eDataType, String initialValue) {
		ActionEnum result = ActionEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertActionEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EditpolicymodelPackage getEditpolicymodelPackage() {
		return (EditpolicymodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EditpolicymodelPackage getPackage() {
		return EditpolicymodelPackage.eINSTANCE;
	}

} //EditpolicymodelFactoryImpl
