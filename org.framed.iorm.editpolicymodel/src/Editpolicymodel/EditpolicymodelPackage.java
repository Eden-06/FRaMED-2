/**
 */
package Editpolicymodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see Editpolicymodel.EditpolicymodelFactory
 * @model kind="package"
 * @generated
 */
public interface EditpolicymodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Editpolicymodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://framed/editpolicymodel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "Editpolicymodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EditpolicymodelPackage eINSTANCE = Editpolicymodel.impl.EditpolicymodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.ModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.ModelImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getModel()
	 * @generated
	 */
	int MODEL = 0;

	/**
	 * The feature id for the '<em><b>Policies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__POLICIES = 0;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.PolicyImpl <em>Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.PolicyImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getPolicy()
	 * @generated
	 */
	int POLICY = 1;

	/**
	 * The feature id for the '<em><b>Override</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY__OVERRIDE = 0;

	/**
	 * The feature id for the '<em><b>Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY__ACTION = 1;

	/**
	 * The feature id for the '<em><b>Action Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY__ACTION_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Feature Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY__FEATURE_RULE = 3;

	/**
	 * The feature id for the '<em><b>Constraint Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY__CONSTRAINT_RULE = 4;

	/**
	 * The number of structural features of the '<em>Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.ConstraintRuleImpl <em>Constraint Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.ConstraintRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getConstraintRule()
	 * @generated
	 */
	int CONSTRAINT_RULE = 11;

	/**
	 * The number of structural features of the '<em>Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_RULE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_RULE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.TypeArgumentRuleImpl <em>Type Argument Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.TypeArgumentRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getTypeArgumentRule()
	 * @generated
	 */
	int TYPE_ARGUMENT_RULE = 22;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ARGUMENT_RULE__TYPE = CONSTRAINT_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Type Argument Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ARGUMENT_RULE_FEATURE_COUNT = CONSTRAINT_RULE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Type Argument Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ARGUMENT_RULE_OPERATION_COUNT = CONSTRAINT_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.ContainsImpl <em>Contains</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.ContainsImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getContains()
	 * @generated
	 */
	int CONTAINS = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS__TYPE = TYPE_ARGUMENT_RULE__TYPE;

	/**
	 * The number of structural features of the '<em>Contains</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS_FEATURE_COUNT = TYPE_ARGUMENT_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Contains</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS_OPERATION_COUNT = TYPE_ARGUMENT_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.IsStepInImpl <em>Is Step In</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.IsStepInImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getIsStepIn()
	 * @generated
	 */
	int IS_STEP_IN = 3;

	/**
	 * The number of structural features of the '<em>Is Step In</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_STEP_IN_FEATURE_COUNT = CONSTRAINT_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Is Step In</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_STEP_IN_OPERATION_COUNT = CONSTRAINT_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.IsTargetImpl <em>Is Target</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.IsTargetImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getIsTarget()
	 * @generated
	 */
	int IS_TARGET = 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_TARGET__TYPE = TYPE_ARGUMENT_RULE__TYPE;

	/**
	 * The number of structural features of the '<em>Is Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_TARGET_FEATURE_COUNT = TYPE_ARGUMENT_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Is Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_TARGET_OPERATION_COUNT = TYPE_ARGUMENT_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.IsSourceImpl <em>Is Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.IsSourceImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getIsSource()
	 * @generated
	 */
	int IS_SOURCE = 5;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_SOURCE__TYPE = TYPE_ARGUMENT_RULE__TYPE;

	/**
	 * The number of structural features of the '<em>Is Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_SOURCE_FEATURE_COUNT = TYPE_ARGUMENT_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Is Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_SOURCE_OPERATION_COUNT = TYPE_ARGUMENT_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.IsParentImpl <em>Is Parent</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.IsParentImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getIsParent()
	 * @generated
	 */
	int IS_PARENT = 6;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_PARENT__TYPE = TYPE_ARGUMENT_RULE__TYPE;

	/**
	 * The number of structural features of the '<em>Is Parent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_PARENT_FEATURE_COUNT = TYPE_ARGUMENT_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Is Parent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_PARENT_OPERATION_COUNT = TYPE_ARGUMENT_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.AbstractRule <em>Abstract Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.AbstractRule
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getAbstractRule()
	 * @generated
	 */
	int ABSTRACT_RULE = 7;

	/**
	 * The number of structural features of the '<em>Abstract Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RULE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Abstract Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RULE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.RuleImpl <em>Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.RuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getRule()
	 * @generated
	 */
	int RULE = 8;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__RULE = ABSTRACT_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FEATURE_COUNT = ABSTRACT_RULE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_OPERATION_COUNT = ABSTRACT_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.FeatureRuleImpl <em>Feature Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.FeatureRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getFeatureRule()
	 * @generated
	 */
	int FEATURE_RULE = 9;

	/**
	 * The number of structural features of the '<em>Feature Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_RULE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Feature Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_RULE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.IsFeatureImpl <em>Is Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.IsFeatureImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getIsFeature()
	 * @generated
	 */
	int IS_FEATURE = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_FEATURE__NAME = FEATURE_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Is Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_FEATURE_FEATURE_COUNT = FEATURE_RULE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Is Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_FEATURE_OPERATION_COUNT = FEATURE_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.IsTargetTypeImpl <em>Is Target Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.IsTargetTypeImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getIsTargetType()
	 * @generated
	 */
	int IS_TARGET_TYPE = 12;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_TARGET_TYPE__TYPE = TYPE_ARGUMENT_RULE__TYPE;

	/**
	 * The number of structural features of the '<em>Is Target Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_TARGET_TYPE_FEATURE_COUNT = TYPE_ARGUMENT_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Is Target Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_TARGET_TYPE_OPERATION_COUNT = TYPE_ARGUMENT_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.UnaryRuleImpl <em>Unary Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.UnaryRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getUnaryRule()
	 * @generated
	 */
	int UNARY_RULE = 13;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_RULE__RULE = ABSTRACT_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Unary Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_RULE_FEATURE_COUNT = ABSTRACT_RULE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Unary Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_RULE_OPERATION_COUNT = ABSTRACT_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.NotRuleImpl <em>Not Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.NotRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getNotRule()
	 * @generated
	 */
	int NOT_RULE = 14;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_RULE__RULE = UNARY_RULE__RULE;

	/**
	 * The number of structural features of the '<em>Not Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_RULE_FEATURE_COUNT = UNARY_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Not Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_RULE_OPERATION_COUNT = UNARY_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.NaryRuleImpl <em>Nary Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.NaryRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getNaryRule()
	 * @generated
	 */
	int NARY_RULE = 23;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_RULE__RULES = ABSTRACT_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Nary Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_RULE_FEATURE_COUNT = ABSTRACT_RULE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Nary Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_RULE_OPERATION_COUNT = ABSTRACT_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.AndRuleImpl <em>And Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.AndRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getAndRule()
	 * @generated
	 */
	int AND_RULE = 15;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_RULE__RULES = NARY_RULE__RULES;

	/**
	 * The number of structural features of the '<em>And Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_RULE_FEATURE_COUNT = NARY_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>And Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_RULE_OPERATION_COUNT = NARY_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.BinaryRuleImpl <em>Binary Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.BinaryRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getBinaryRule()
	 * @generated
	 */
	int BINARY_RULE = 16;

	/**
	 * The feature id for the '<em><b>Right Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_RULE__RIGHT_RULE = ABSTRACT_RULE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Left Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_RULE__LEFT_RULE = ABSTRACT_RULE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Binary Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_RULE_FEATURE_COUNT = ABSTRACT_RULE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Binary Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_RULE_OPERATION_COUNT = ABSTRACT_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.TrueRuleImpl <em>True Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.TrueRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getTrueRule()
	 * @generated
	 */
	int TRUE_RULE = 17;

	/**
	 * The number of structural features of the '<em>True Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_RULE_FEATURE_COUNT = ABSTRACT_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>True Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_RULE_OPERATION_COUNT = ABSTRACT_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.FalseRuleImpl <em>False Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.FalseRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getFalseRule()
	 * @generated
	 */
	int FALSE_RULE = 18;

	/**
	 * The number of structural features of the '<em>False Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE_RULE_FEATURE_COUNT = ABSTRACT_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>False Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE_RULE_OPERATION_COUNT = ABSTRACT_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.OrRuleImpl <em>Or Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.OrRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getOrRule()
	 * @generated
	 */
	int OR_RULE = 19;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_RULE__RULES = NARY_RULE__RULES;

	/**
	 * The number of structural features of the '<em>Or Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_RULE_FEATURE_COUNT = NARY_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Or Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_RULE_OPERATION_COUNT = NARY_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.ImplicationRuleImpl <em>Implication Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.ImplicationRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getImplicationRule()
	 * @generated
	 */
	int IMPLICATION_RULE = 20;

	/**
	 * The feature id for the '<em><b>Right Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICATION_RULE__RIGHT_RULE = BINARY_RULE__RIGHT_RULE;

	/**
	 * The feature id for the '<em><b>Left Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICATION_RULE__LEFT_RULE = BINARY_RULE__LEFT_RULE;

	/**
	 * The number of structural features of the '<em>Implication Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICATION_RULE_FEATURE_COUNT = BINARY_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Implication Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICATION_RULE_OPERATION_COUNT = BINARY_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.IsSourceTypeImpl <em>Is Source Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.IsSourceTypeImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getIsSourceType()
	 * @generated
	 */
	int IS_SOURCE_TYPE = 21;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_SOURCE_TYPE__TYPE = TYPE_ARGUMENT_RULE__TYPE;

	/**
	 * The number of structural features of the '<em>Is Source Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_SOURCE_TYPE_FEATURE_COUNT = TYPE_ARGUMENT_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Is Source Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_SOURCE_TYPE_OPERATION_COUNT = TYPE_ARGUMENT_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.ActionEnum <em>Action Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.ActionEnum
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getActionEnum()
	 * @generated
	 */
	int ACTION_ENUM = 24;


	/**
	 * Returns the meta object for class '{@link Editpolicymodel.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see Editpolicymodel.Model
	 * @generated
	 */
	EClass getModel();

	/**
	 * Returns the meta object for the containment reference list '{@link Editpolicymodel.Model#getPolicies <em>Policies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Policies</em>'.
	 * @see Editpolicymodel.Model#getPolicies()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Policies();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.Policy <em>Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Policy</em>'.
	 * @see Editpolicymodel.Policy
	 * @generated
	 */
	EClass getPolicy();

	/**
	 * Returns the meta object for the attribute '{@link Editpolicymodel.Policy#getOverride <em>Override</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Override</em>'.
	 * @see Editpolicymodel.Policy#getOverride()
	 * @see #getPolicy()
	 * @generated
	 */
	EAttribute getPolicy_Override();

	/**
	 * Returns the meta object for the attribute '{@link Editpolicymodel.Policy#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action</em>'.
	 * @see Editpolicymodel.Policy#getAction()
	 * @see #getPolicy()
	 * @generated
	 */
	EAttribute getPolicy_Action();

	/**
	 * Returns the meta object for the attribute '{@link Editpolicymodel.Policy#getActionType <em>Action Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action Type</em>'.
	 * @see Editpolicymodel.Policy#getActionType()
	 * @see #getPolicy()
	 * @generated
	 */
	EAttribute getPolicy_ActionType();

	/**
	 * Returns the meta object for the containment reference '{@link Editpolicymodel.Policy#getFeatureRule <em>Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Feature Rule</em>'.
	 * @see Editpolicymodel.Policy#getFeatureRule()
	 * @see #getPolicy()
	 * @generated
	 */
	EReference getPolicy_FeatureRule();

	/**
	 * Returns the meta object for the containment reference '{@link Editpolicymodel.Policy#getConstraintRule <em>Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Constraint Rule</em>'.
	 * @see Editpolicymodel.Policy#getConstraintRule()
	 * @see #getPolicy()
	 * @generated
	 */
	EReference getPolicy_ConstraintRule();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.Contains <em>Contains</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contains</em>'.
	 * @see Editpolicymodel.Contains
	 * @generated
	 */
	EClass getContains();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.IsStepIn <em>Is Step In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Is Step In</em>'.
	 * @see Editpolicymodel.IsStepIn
	 * @generated
	 */
	EClass getIsStepIn();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.IsTarget <em>Is Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Is Target</em>'.
	 * @see Editpolicymodel.IsTarget
	 * @generated
	 */
	EClass getIsTarget();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.IsSource <em>Is Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Is Source</em>'.
	 * @see Editpolicymodel.IsSource
	 * @generated
	 */
	EClass getIsSource();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.IsParent <em>Is Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Is Parent</em>'.
	 * @see Editpolicymodel.IsParent
	 * @generated
	 */
	EClass getIsParent();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.AbstractRule <em>Abstract Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Rule</em>'.
	 * @see Editpolicymodel.AbstractRule
	 * @generated
	 */
	EClass getAbstractRule();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule</em>'.
	 * @see Editpolicymodel.Rule
	 * @generated
	 */
	EClass getRule();

	/**
	 * Returns the meta object for the containment reference '{@link Editpolicymodel.Rule#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rule</em>'.
	 * @see Editpolicymodel.Rule#getRule()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_Rule();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.FeatureRule <em>Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Rule</em>'.
	 * @see Editpolicymodel.FeatureRule
	 * @generated
	 */
	EClass getFeatureRule();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.IsFeature <em>Is Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Is Feature</em>'.
	 * @see Editpolicymodel.IsFeature
	 * @generated
	 */
	EClass getIsFeature();

	/**
	 * Returns the meta object for the attribute '{@link Editpolicymodel.IsFeature#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see Editpolicymodel.IsFeature#getName()
	 * @see #getIsFeature()
	 * @generated
	 */
	EAttribute getIsFeature_Name();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.ConstraintRule <em>Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint Rule</em>'.
	 * @see Editpolicymodel.ConstraintRule
	 * @generated
	 */
	EClass getConstraintRule();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.IsTargetType <em>Is Target Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Is Target Type</em>'.
	 * @see Editpolicymodel.IsTargetType
	 * @generated
	 */
	EClass getIsTargetType();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.UnaryRule <em>Unary Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Rule</em>'.
	 * @see Editpolicymodel.UnaryRule
	 * @generated
	 */
	EClass getUnaryRule();

	/**
	 * Returns the meta object for the containment reference '{@link Editpolicymodel.UnaryRule#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rule</em>'.
	 * @see Editpolicymodel.UnaryRule#getRule()
	 * @see #getUnaryRule()
	 * @generated
	 */
	EReference getUnaryRule_Rule();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.NotRule <em>Not Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not Rule</em>'.
	 * @see Editpolicymodel.NotRule
	 * @generated
	 */
	EClass getNotRule();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.AndRule <em>And Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And Rule</em>'.
	 * @see Editpolicymodel.AndRule
	 * @generated
	 */
	EClass getAndRule();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.BinaryRule <em>Binary Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Rule</em>'.
	 * @see Editpolicymodel.BinaryRule
	 * @generated
	 */
	EClass getBinaryRule();

	/**
	 * Returns the meta object for the containment reference '{@link Editpolicymodel.BinaryRule#getRightRule <em>Right Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Rule</em>'.
	 * @see Editpolicymodel.BinaryRule#getRightRule()
	 * @see #getBinaryRule()
	 * @generated
	 */
	EReference getBinaryRule_RightRule();

	/**
	 * Returns the meta object for the containment reference '{@link Editpolicymodel.BinaryRule#getLeftRule <em>Left Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Rule</em>'.
	 * @see Editpolicymodel.BinaryRule#getLeftRule()
	 * @see #getBinaryRule()
	 * @generated
	 */
	EReference getBinaryRule_LeftRule();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.TrueRule <em>True Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>True Rule</em>'.
	 * @see Editpolicymodel.TrueRule
	 * @generated
	 */
	EClass getTrueRule();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.FalseRule <em>False Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>False Rule</em>'.
	 * @see Editpolicymodel.FalseRule
	 * @generated
	 */
	EClass getFalseRule();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.OrRule <em>Or Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or Rule</em>'.
	 * @see Editpolicymodel.OrRule
	 * @generated
	 */
	EClass getOrRule();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.ImplicationRule <em>Implication Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Implication Rule</em>'.
	 * @see Editpolicymodel.ImplicationRule
	 * @generated
	 */
	EClass getImplicationRule();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.IsSourceType <em>Is Source Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Is Source Type</em>'.
	 * @see Editpolicymodel.IsSourceType
	 * @generated
	 */
	EClass getIsSourceType();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.TypeArgumentRule <em>Type Argument Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Argument Rule</em>'.
	 * @see Editpolicymodel.TypeArgumentRule
	 * @generated
	 */
	EClass getTypeArgumentRule();

	/**
	 * Returns the meta object for the attribute '{@link Editpolicymodel.TypeArgumentRule#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see Editpolicymodel.TypeArgumentRule#getType()
	 * @see #getTypeArgumentRule()
	 * @generated
	 */
	EAttribute getTypeArgumentRule_Type();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.NaryRule <em>Nary Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nary Rule</em>'.
	 * @see Editpolicymodel.NaryRule
	 * @generated
	 */
	EClass getNaryRule();

	/**
	 * Returns the meta object for the containment reference list '{@link Editpolicymodel.NaryRule#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rules</em>'.
	 * @see Editpolicymodel.NaryRule#getRules()
	 * @see #getNaryRule()
	 * @generated
	 */
	EReference getNaryRule_Rules();

	/**
	 * Returns the meta object for enum '{@link Editpolicymodel.ActionEnum <em>Action Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Action Enum</em>'.
	 * @see Editpolicymodel.ActionEnum
	 * @generated
	 */
	EEnum getActionEnum();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EditpolicymodelFactory getEditpolicymodelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.ModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.ModelImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getModel()
		 * @generated
		 */
		EClass MODEL = eINSTANCE.getModel();

		/**
		 * The meta object literal for the '<em><b>Policies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__POLICIES = eINSTANCE.getModel_Policies();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.PolicyImpl <em>Policy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.PolicyImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getPolicy()
		 * @generated
		 */
		EClass POLICY = eINSTANCE.getPolicy();

		/**
		 * The meta object literal for the '<em><b>Override</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POLICY__OVERRIDE = eINSTANCE.getPolicy_Override();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POLICY__ACTION = eINSTANCE.getPolicy_Action();

		/**
		 * The meta object literal for the '<em><b>Action Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POLICY__ACTION_TYPE = eINSTANCE.getPolicy_ActionType();

		/**
		 * The meta object literal for the '<em><b>Feature Rule</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POLICY__FEATURE_RULE = eINSTANCE.getPolicy_FeatureRule();

		/**
		 * The meta object literal for the '<em><b>Constraint Rule</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POLICY__CONSTRAINT_RULE = eINSTANCE.getPolicy_ConstraintRule();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.ContainsImpl <em>Contains</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.ContainsImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getContains()
		 * @generated
		 */
		EClass CONTAINS = eINSTANCE.getContains();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.IsStepInImpl <em>Is Step In</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.IsStepInImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getIsStepIn()
		 * @generated
		 */
		EClass IS_STEP_IN = eINSTANCE.getIsStepIn();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.IsTargetImpl <em>Is Target</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.IsTargetImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getIsTarget()
		 * @generated
		 */
		EClass IS_TARGET = eINSTANCE.getIsTarget();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.IsSourceImpl <em>Is Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.IsSourceImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getIsSource()
		 * @generated
		 */
		EClass IS_SOURCE = eINSTANCE.getIsSource();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.IsParentImpl <em>Is Parent</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.IsParentImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getIsParent()
		 * @generated
		 */
		EClass IS_PARENT = eINSTANCE.getIsParent();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.AbstractRule <em>Abstract Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.AbstractRule
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getAbstractRule()
		 * @generated
		 */
		EClass ABSTRACT_RULE = eINSTANCE.getAbstractRule();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.RuleImpl <em>Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.RuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getRule()
		 * @generated
		 */
		EClass RULE = eINSTANCE.getRule();

		/**
		 * The meta object literal for the '<em><b>Rule</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__RULE = eINSTANCE.getRule_Rule();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.FeatureRuleImpl <em>Feature Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.FeatureRuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getFeatureRule()
		 * @generated
		 */
		EClass FEATURE_RULE = eINSTANCE.getFeatureRule();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.IsFeatureImpl <em>Is Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.IsFeatureImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getIsFeature()
		 * @generated
		 */
		EClass IS_FEATURE = eINSTANCE.getIsFeature();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IS_FEATURE__NAME = eINSTANCE.getIsFeature_Name();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.ConstraintRuleImpl <em>Constraint Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.ConstraintRuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getConstraintRule()
		 * @generated
		 */
		EClass CONSTRAINT_RULE = eINSTANCE.getConstraintRule();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.IsTargetTypeImpl <em>Is Target Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.IsTargetTypeImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getIsTargetType()
		 * @generated
		 */
		EClass IS_TARGET_TYPE = eINSTANCE.getIsTargetType();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.UnaryRuleImpl <em>Unary Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.UnaryRuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getUnaryRule()
		 * @generated
		 */
		EClass UNARY_RULE = eINSTANCE.getUnaryRule();

		/**
		 * The meta object literal for the '<em><b>Rule</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNARY_RULE__RULE = eINSTANCE.getUnaryRule_Rule();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.NotRuleImpl <em>Not Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.NotRuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getNotRule()
		 * @generated
		 */
		EClass NOT_RULE = eINSTANCE.getNotRule();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.AndRuleImpl <em>And Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.AndRuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getAndRule()
		 * @generated
		 */
		EClass AND_RULE = eINSTANCE.getAndRule();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.BinaryRuleImpl <em>Binary Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.BinaryRuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getBinaryRule()
		 * @generated
		 */
		EClass BINARY_RULE = eINSTANCE.getBinaryRule();

		/**
		 * The meta object literal for the '<em><b>Right Rule</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_RULE__RIGHT_RULE = eINSTANCE.getBinaryRule_RightRule();

		/**
		 * The meta object literal for the '<em><b>Left Rule</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_RULE__LEFT_RULE = eINSTANCE.getBinaryRule_LeftRule();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.TrueRuleImpl <em>True Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.TrueRuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getTrueRule()
		 * @generated
		 */
		EClass TRUE_RULE = eINSTANCE.getTrueRule();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.FalseRuleImpl <em>False Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.FalseRuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getFalseRule()
		 * @generated
		 */
		EClass FALSE_RULE = eINSTANCE.getFalseRule();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.OrRuleImpl <em>Or Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.OrRuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getOrRule()
		 * @generated
		 */
		EClass OR_RULE = eINSTANCE.getOrRule();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.ImplicationRuleImpl <em>Implication Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.ImplicationRuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getImplicationRule()
		 * @generated
		 */
		EClass IMPLICATION_RULE = eINSTANCE.getImplicationRule();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.IsSourceTypeImpl <em>Is Source Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.IsSourceTypeImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getIsSourceType()
		 * @generated
		 */
		EClass IS_SOURCE_TYPE = eINSTANCE.getIsSourceType();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.TypeArgumentRuleImpl <em>Type Argument Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.TypeArgumentRuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getTypeArgumentRule()
		 * @generated
		 */
		EClass TYPE_ARGUMENT_RULE = eINSTANCE.getTypeArgumentRule();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_ARGUMENT_RULE__TYPE = eINSTANCE.getTypeArgumentRule_Type();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.NaryRuleImpl <em>Nary Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.NaryRuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getNaryRule()
		 * @generated
		 */
		EClass NARY_RULE = eINSTANCE.getNaryRule();

		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NARY_RULE__RULES = eINSTANCE.getNaryRule_Rules();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.ActionEnum <em>Action Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.ActionEnum
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getActionEnum()
		 * @generated
		 */
		EEnum ACTION_ENUM = eINSTANCE.getActionEnum();

	}

} //EditpolicymodelPackage
