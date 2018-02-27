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
			case EditpolicymodelPackage.AND_CONSTRAINT_RULE: return createAndConstraintRule();
			case EditpolicymodelPackage.OR_CONSTRAINT_RULE: return createOrConstraintRule();
			case EditpolicymodelPackage.CONTAINS_CONSTRAINT_RULE: return createContainsConstraintRule();
			case EditpolicymodelPackage.IS_STEP_OUT_CONSTRAINT_RULE: return createIsStepOutConstraintRule();
			case EditpolicymodelPackage.IS_TARGET_CONSTRAINT_RULE: return createIsTargetConstraintRule();
			case EditpolicymodelPackage.IS_SOURCE_CONSTRAINT_RULE: return createIsSourceConstraintRule();
			case EditpolicymodelPackage.IS_PARENT_CONSTRAINT_RULE: return createIsParentConstraintRule();
			case EditpolicymodelPackage.TRUE_CONSTRAINT_RULE: return createTrueConstraintRule();
			case EditpolicymodelPackage.FALSE_CONSTRAINT_RULE: return createFalseConstraintRule();
			case EditpolicymodelPackage.RULE: return createRule();
			case EditpolicymodelPackage.IS_FEATURE: return createIsFeature();
			case EditpolicymodelPackage.IS_TARGET_TYPE: return createIsTargetType();
			case EditpolicymodelPackage.NOT_RULE: return createNotRule();
			case EditpolicymodelPackage.AND_RULE: return createAndRule();
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
			case EditpolicymodelPackage.ACTION_TYPE_ENUM:
				return createActionTypeEnumFromString(eDataType, initialValue);
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
			case EditpolicymodelPackage.ACTION_TYPE_ENUM:
				return convertActionTypeEnumToString(eDataType, instanceValue);
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
	public AndConstraintRule createAndConstraintRule() {
		AndConstraintRuleImpl andConstraintRule = new AndConstraintRuleImpl();
		return andConstraintRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrConstraintRule createOrConstraintRule() {
		OrConstraintRuleImpl orConstraintRule = new OrConstraintRuleImpl();
		return orConstraintRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContainsConstraintRule createContainsConstraintRule() {
		ContainsConstraintRuleImpl containsConstraintRule = new ContainsConstraintRuleImpl();
		return containsConstraintRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IsStepOutConstraintRule createIsStepOutConstraintRule() {
		IsStepOutConstraintRuleImpl isStepOutConstraintRule = new IsStepOutConstraintRuleImpl();
		return isStepOutConstraintRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IsTargetConstraintRule createIsTargetConstraintRule() {
		IsTargetConstraintRuleImpl isTargetConstraintRule = new IsTargetConstraintRuleImpl();
		return isTargetConstraintRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IsSourceConstraintRule createIsSourceConstraintRule() {
		IsSourceConstraintRuleImpl isSourceConstraintRule = new IsSourceConstraintRuleImpl();
		return isSourceConstraintRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IsParentConstraintRule createIsParentConstraintRule() {
		IsParentConstraintRuleImpl isParentConstraintRule = new IsParentConstraintRuleImpl();
		return isParentConstraintRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrueConstraintRule createTrueConstraintRule() {
		TrueConstraintRuleImpl trueConstraintRule = new TrueConstraintRuleImpl();
		return trueConstraintRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FalseConstraintRule createFalseConstraintRule() {
		FalseConstraintRuleImpl falseConstraintRule = new FalseConstraintRuleImpl();
		return falseConstraintRule;
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
	public NotRule createNotRule() {
		NotRuleImpl notRule = new NotRuleImpl();
		return notRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AndRule createAndRule() {
		AndRuleImpl andRule = new AndRuleImpl();
		return andRule;
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
	public ActionTypeEnum createActionTypeEnumFromString(EDataType eDataType, String initialValue) {
		ActionTypeEnum result = ActionTypeEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertActionTypeEnumToString(EDataType eDataType, Object instanceValue) {
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
