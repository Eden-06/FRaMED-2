/**
 */
package editpolicymodel.impl;

import editpolicymodel.*;

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
public class editpolicymodelFactoryImpl extends EFactoryImpl implements editpolicymodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static editpolicymodelFactory init() {
		try {
			editpolicymodelFactory theeditpolicymodelFactory = (editpolicymodelFactory)EPackage.Registry.INSTANCE.getEFactory(editpolicymodelPackage.eNS_URI);
			if (theeditpolicymodelFactory != null) {
				return theeditpolicymodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new editpolicymodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public editpolicymodelFactoryImpl() {
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
			case editpolicymodelPackage.MODEL: return createModel();
			case editpolicymodelPackage.POLICY: return createPolicy();
			case editpolicymodelPackage.CONTAINS_COMPARTMENT: return createContainsCompartment();
			case editpolicymodelPackage.IS_TARGET: return createIsTarget();
			case editpolicymodelPackage.IS_PARENT: return createIsParent();
			case editpolicymodelPackage.IS_FEATURE: return createIsFeature();
			case editpolicymodelPackage.IS_TARGET_TYPE: return createIsTargetType();
			case editpolicymodelPackage.NOT_CONSTRAINT_RULE: return createNotConstraintRule();
			case editpolicymodelPackage.AND_CONSTRAINT_RULE: return createAndConstraintRule();
			case editpolicymodelPackage.TRUE_CONSTRAINT_RULE: return createTrueConstraintRule();
			case editpolicymodelPackage.FALSE_CONSTRAINT_RULE: return createFalseConstraintRule();
			case editpolicymodelPackage.OR_CONSTRAINT_RULE: return createOrConstraintRule();
			case editpolicymodelPackage.IMPLICATION_CONSTRAINT_RULE: return createImplicationConstraintRule();
			case editpolicymodelPackage.IS_SOURCE_TYPE: return createIsSourceType();
			case editpolicymodelPackage.LOGICAL_CONSTRAINT_RULE: return createLogicalConstraintRule();
			case editpolicymodelPackage.TRUE_FEATURE_RULE: return createTrueFeatureRule();
			case editpolicymodelPackage.NOT_FEATURE_RULE: return createNotFeatureRule();
			case editpolicymodelPackage.FALSE_FEATURE_RULE: return createFalseFeatureRule();
			case editpolicymodelPackage.LOGICAL_FEATURE_RULE: return createLogicalFeatureRule();
			case editpolicymodelPackage.IMPLICATION_FEATURE_RULE: return createImplicationFeatureRule();
			case editpolicymodelPackage.OR_FEATURE_RULE: return createOrFeatureRule();
			case editpolicymodelPackage.AND_FEATURE_RULE: return createAndFeatureRule();
			case editpolicymodelPackage.SOURCE_EQUALS_TARGET: return createSourceEqualsTarget();
			case editpolicymodelPackage.SOURCE_EQUALS_TARGET_TYPE: return createSourceEqualsTargetType();
			case editpolicymodelPackage.IN_COMPARTMENT: return createInCompartment();
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
			case editpolicymodelPackage.ACTION_ENUM:
				return createActionEnumFromString(eDataType, initialValue);
			case editpolicymodelPackage.TYPE_ENUM:
				return createTypeEnumFromString(eDataType, initialValue);
			case editpolicymodelPackage.FEATURE_NAME_ENUM:
				return createFeatureNameEnumFromString(eDataType, initialValue);
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
			case editpolicymodelPackage.ACTION_ENUM:
				return convertActionEnumToString(eDataType, instanceValue);
			case editpolicymodelPackage.TYPE_ENUM:
				return convertTypeEnumToString(eDataType, instanceValue);
			case editpolicymodelPackage.FEATURE_NAME_ENUM:
				return convertFeatureNameEnumToString(eDataType, instanceValue);
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
	public ContainsCompartment createContainsCompartment() {
		ContainsCompartmentImpl containsCompartment = new ContainsCompartmentImpl();
		return containsCompartment;
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
	public IsParent createIsParent() {
		IsParentImpl isParent = new IsParentImpl();
		return isParent;
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
	public NotConstraintRule createNotConstraintRule() {
		NotConstraintRuleImpl notConstraintRule = new NotConstraintRuleImpl();
		return notConstraintRule;
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
	public OrConstraintRule createOrConstraintRule() {
		OrConstraintRuleImpl orConstraintRule = new OrConstraintRuleImpl();
		return orConstraintRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImplicationConstraintRule createImplicationConstraintRule() {
		ImplicationConstraintRuleImpl implicationConstraintRule = new ImplicationConstraintRuleImpl();
		return implicationConstraintRule;
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
	public LogicalConstraintRule createLogicalConstraintRule() {
		LogicalConstraintRuleImpl logicalConstraintRule = new LogicalConstraintRuleImpl();
		return logicalConstraintRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrueFeatureRule createTrueFeatureRule() {
		TrueFeatureRuleImpl trueFeatureRule = new TrueFeatureRuleImpl();
		return trueFeatureRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotFeatureRule createNotFeatureRule() {
		NotFeatureRuleImpl notFeatureRule = new NotFeatureRuleImpl();
		return notFeatureRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FalseFeatureRule createFalseFeatureRule() {
		FalseFeatureRuleImpl falseFeatureRule = new FalseFeatureRuleImpl();
		return falseFeatureRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogicalFeatureRule createLogicalFeatureRule() {
		LogicalFeatureRuleImpl logicalFeatureRule = new LogicalFeatureRuleImpl();
		return logicalFeatureRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImplicationFeatureRule createImplicationFeatureRule() {
		ImplicationFeatureRuleImpl implicationFeatureRule = new ImplicationFeatureRuleImpl();
		return implicationFeatureRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrFeatureRule createOrFeatureRule() {
		OrFeatureRuleImpl orFeatureRule = new OrFeatureRuleImpl();
		return orFeatureRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AndFeatureRule createAndFeatureRule() {
		AndFeatureRuleImpl andFeatureRule = new AndFeatureRuleImpl();
		return andFeatureRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceEqualsTarget createSourceEqualsTarget() {
		SourceEqualsTargetImpl sourceEqualsTarget = new SourceEqualsTargetImpl();
		return sourceEqualsTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceEqualsTargetType createSourceEqualsTargetType() {
		SourceEqualsTargetTypeImpl sourceEqualsTargetType = new SourceEqualsTargetTypeImpl();
		return sourceEqualsTargetType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InCompartment createInCompartment() {
		InCompartmentImpl inCompartment = new InCompartmentImpl();
		return inCompartment;
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
	public TypeEnum createTypeEnumFromString(EDataType eDataType, String initialValue) {
		TypeEnum result = TypeEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureNameEnum createFeatureNameEnumFromString(EDataType eDataType, String initialValue) {
		FeatureNameEnum result = FeatureNameEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFeatureNameEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public editpolicymodelPackage geteditpolicymodelPackage() {
		return (editpolicymodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static editpolicymodelPackage getPackage() {
		return editpolicymodelPackage.eINSTANCE;
	}

} //editpolicymodelFactoryImpl
