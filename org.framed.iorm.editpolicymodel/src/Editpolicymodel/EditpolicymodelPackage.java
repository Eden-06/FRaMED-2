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
	int CONSTRAINT_RULE = 9;

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
	int TYPE_ARGUMENT_RULE = 20;

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
	 * The meta object id for the '{@link Editpolicymodel.impl.FeatureRuleImpl <em>Feature Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.FeatureRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getFeatureRule()
	 * @generated
	 */
	int FEATURE_RULE = 7;

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
	int IS_FEATURE = 8;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_FEATURE__FEATURE_NAME = FEATURE_RULE_FEATURE_COUNT + 0;

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
	int IS_TARGET_TYPE = 10;

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
	 * The meta object id for the '{@link Editpolicymodel.impl.LogicalConstraintRuleImpl <em>Logical Constraint Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.LogicalConstraintRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getLogicalConstraintRule()
	 * @generated
	 */
	int LOGICAL_CONSTRAINT_RULE = 22;

	/**
	 * The number of structural features of the '<em>Logical Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_CONSTRAINT_RULE_FEATURE_COUNT = CONSTRAINT_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Logical Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_CONSTRAINT_RULE_OPERATION_COUNT = CONSTRAINT_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.UnaryConstraintRuleImpl <em>Unary Constraint Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.UnaryConstraintRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getUnaryConstraintRule()
	 * @generated
	 */
	int UNARY_CONSTRAINT_RULE = 11;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_CONSTRAINT_RULE__RULE = LOGICAL_CONSTRAINT_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Unary Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_CONSTRAINT_RULE_FEATURE_COUNT = LOGICAL_CONSTRAINT_RULE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Unary Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_CONSTRAINT_RULE_OPERATION_COUNT = LOGICAL_CONSTRAINT_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.NotConstraintRuleImpl <em>Not Constraint Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.NotConstraintRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getNotConstraintRule()
	 * @generated
	 */
	int NOT_CONSTRAINT_RULE = 12;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_CONSTRAINT_RULE__RULE = UNARY_CONSTRAINT_RULE__RULE;

	/**
	 * The number of structural features of the '<em>Not Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_CONSTRAINT_RULE_FEATURE_COUNT = UNARY_CONSTRAINT_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Not Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_CONSTRAINT_RULE_OPERATION_COUNT = UNARY_CONSTRAINT_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.NaryConstraintRuleImpl <em>Nary Constraint Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.NaryConstraintRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getNaryConstraintRule()
	 * @generated
	 */
	int NARY_CONSTRAINT_RULE = 21;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_CONSTRAINT_RULE__RULES = LOGICAL_CONSTRAINT_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Nary Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_CONSTRAINT_RULE_FEATURE_COUNT = LOGICAL_CONSTRAINT_RULE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Nary Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_CONSTRAINT_RULE_OPERATION_COUNT = LOGICAL_CONSTRAINT_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.AndConstraintRuleImpl <em>And Constraint Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.AndConstraintRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getAndConstraintRule()
	 * @generated
	 */
	int AND_CONSTRAINT_RULE = 13;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_CONSTRAINT_RULE__RULES = NARY_CONSTRAINT_RULE__RULES;

	/**
	 * The number of structural features of the '<em>And Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_CONSTRAINT_RULE_FEATURE_COUNT = NARY_CONSTRAINT_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>And Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_CONSTRAINT_RULE_OPERATION_COUNT = NARY_CONSTRAINT_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.BinaryConstraintRuleImpl <em>Binary Constraint Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.BinaryConstraintRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getBinaryConstraintRule()
	 * @generated
	 */
	int BINARY_CONSTRAINT_RULE = 14;

	/**
	 * The feature id for the '<em><b>Left Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CONSTRAINT_RULE__LEFT_RULE = LOGICAL_CONSTRAINT_RULE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CONSTRAINT_RULE__RIGHT_RULE = LOGICAL_CONSTRAINT_RULE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Binary Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CONSTRAINT_RULE_FEATURE_COUNT = LOGICAL_CONSTRAINT_RULE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Binary Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CONSTRAINT_RULE_OPERATION_COUNT = LOGICAL_CONSTRAINT_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.TrueConstraintRuleImpl <em>True Constraint Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.TrueConstraintRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getTrueConstraintRule()
	 * @generated
	 */
	int TRUE_CONSTRAINT_RULE = 15;

	/**
	 * The number of structural features of the '<em>True Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_CONSTRAINT_RULE_FEATURE_COUNT = LOGICAL_CONSTRAINT_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>True Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_CONSTRAINT_RULE_OPERATION_COUNT = LOGICAL_CONSTRAINT_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.FalseConstraintRuleImpl <em>False Constraint Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.FalseConstraintRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getFalseConstraintRule()
	 * @generated
	 */
	int FALSE_CONSTRAINT_RULE = 16;

	/**
	 * The number of structural features of the '<em>False Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE_CONSTRAINT_RULE_FEATURE_COUNT = LOGICAL_CONSTRAINT_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>False Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE_CONSTRAINT_RULE_OPERATION_COUNT = LOGICAL_CONSTRAINT_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.OrConstraintRuleImpl <em>Or Constraint Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.OrConstraintRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getOrConstraintRule()
	 * @generated
	 */
	int OR_CONSTRAINT_RULE = 17;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_CONSTRAINT_RULE__RULES = NARY_CONSTRAINT_RULE__RULES;

	/**
	 * The number of structural features of the '<em>Or Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_CONSTRAINT_RULE_FEATURE_COUNT = NARY_CONSTRAINT_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Or Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_CONSTRAINT_RULE_OPERATION_COUNT = NARY_CONSTRAINT_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.ImplicationConstraintRuleImpl <em>Implication Constraint Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.ImplicationConstraintRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getImplicationConstraintRule()
	 * @generated
	 */
	int IMPLICATION_CONSTRAINT_RULE = 18;

	/**
	 * The feature id for the '<em><b>Left Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICATION_CONSTRAINT_RULE__LEFT_RULE = BINARY_CONSTRAINT_RULE__LEFT_RULE;

	/**
	 * The feature id for the '<em><b>Right Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICATION_CONSTRAINT_RULE__RIGHT_RULE = BINARY_CONSTRAINT_RULE__RIGHT_RULE;

	/**
	 * The number of structural features of the '<em>Implication Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICATION_CONSTRAINT_RULE_FEATURE_COUNT = BINARY_CONSTRAINT_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Implication Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICATION_CONSTRAINT_RULE_OPERATION_COUNT = BINARY_CONSTRAINT_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.IsSourceTypeImpl <em>Is Source Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.IsSourceTypeImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getIsSourceType()
	 * @generated
	 */
	int IS_SOURCE_TYPE = 19;

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
	 * The meta object id for the '{@link Editpolicymodel.impl.LogicalFeatureRuleImpl <em>Logical Feature Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.LogicalFeatureRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getLogicalFeatureRule()
	 * @generated
	 */
	int LOGICAL_FEATURE_RULE = 28;

	/**
	 * The number of structural features of the '<em>Logical Feature Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_FEATURE_RULE_FEATURE_COUNT = FEATURE_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Logical Feature Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_FEATURE_RULE_OPERATION_COUNT = FEATURE_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.TrueFeatureRuleImpl <em>True Feature Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.TrueFeatureRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getTrueFeatureRule()
	 * @generated
	 */
	int TRUE_FEATURE_RULE = 23;

	/**
	 * The number of structural features of the '<em>True Feature Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_FEATURE_RULE_FEATURE_COUNT = LOGICAL_FEATURE_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>True Feature Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_FEATURE_RULE_OPERATION_COUNT = LOGICAL_FEATURE_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.UnaryFeatureRuleImpl <em>Unary Feature Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.UnaryFeatureRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getUnaryFeatureRule()
	 * @generated
	 */
	int UNARY_FEATURE_RULE = 30;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_FEATURE_RULE__RULE = LOGICAL_FEATURE_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Unary Feature Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_FEATURE_RULE_FEATURE_COUNT = LOGICAL_FEATURE_RULE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Unary Feature Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_FEATURE_RULE_OPERATION_COUNT = LOGICAL_FEATURE_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.NotFeatureRuleImpl <em>Not Feature Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.NotFeatureRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getNotFeatureRule()
	 * @generated
	 */
	int NOT_FEATURE_RULE = 24;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_FEATURE_RULE__RULE = UNARY_FEATURE_RULE__RULE;

	/**
	 * The number of structural features of the '<em>Not Feature Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_FEATURE_RULE_FEATURE_COUNT = UNARY_FEATURE_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Not Feature Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_FEATURE_RULE_OPERATION_COUNT = UNARY_FEATURE_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.FalseFeatureRuleImpl <em>False Feature Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.FalseFeatureRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getFalseFeatureRule()
	 * @generated
	 */
	int FALSE_FEATURE_RULE = 25;

	/**
	 * The number of structural features of the '<em>False Feature Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE_FEATURE_RULE_FEATURE_COUNT = LOGICAL_FEATURE_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>False Feature Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE_FEATURE_RULE_OPERATION_COUNT = LOGICAL_FEATURE_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.NaryFeatureRuleImpl <em>Nary Feature Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.NaryFeatureRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getNaryFeatureRule()
	 * @generated
	 */
	int NARY_FEATURE_RULE = 26;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_FEATURE_RULE__RULES = LOGICAL_FEATURE_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Nary Feature Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_FEATURE_RULE_FEATURE_COUNT = LOGICAL_FEATURE_RULE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Nary Feature Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_FEATURE_RULE_OPERATION_COUNT = LOGICAL_FEATURE_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.BinaryFeatureRuleImpl <em>Binary Feature Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.BinaryFeatureRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getBinaryFeatureRule()
	 * @generated
	 */
	int BINARY_FEATURE_RULE = 27;

	/**
	 * The feature id for the '<em><b>Right Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_FEATURE_RULE__RIGHT_RULE = LOGICAL_FEATURE_RULE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Left Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_FEATURE_RULE__LEFT_RULE = LOGICAL_FEATURE_RULE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Binary Feature Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_FEATURE_RULE_FEATURE_COUNT = LOGICAL_FEATURE_RULE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Binary Feature Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_FEATURE_RULE_OPERATION_COUNT = LOGICAL_FEATURE_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.ImplicationFeatureRuleImpl <em>Implication Feature Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.ImplicationFeatureRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getImplicationFeatureRule()
	 * @generated
	 */
	int IMPLICATION_FEATURE_RULE = 29;

	/**
	 * The feature id for the '<em><b>Right Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICATION_FEATURE_RULE__RIGHT_RULE = BINARY_FEATURE_RULE__RIGHT_RULE;

	/**
	 * The feature id for the '<em><b>Left Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICATION_FEATURE_RULE__LEFT_RULE = BINARY_FEATURE_RULE__LEFT_RULE;

	/**
	 * The number of structural features of the '<em>Implication Feature Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICATION_FEATURE_RULE_FEATURE_COUNT = BINARY_FEATURE_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Implication Feature Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICATION_FEATURE_RULE_OPERATION_COUNT = BINARY_FEATURE_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.OrFeatureRuleImpl <em>Or Feature Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.OrFeatureRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getOrFeatureRule()
	 * @generated
	 */
	int OR_FEATURE_RULE = 31;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_FEATURE_RULE__RULES = NARY_FEATURE_RULE__RULES;

	/**
	 * The number of structural features of the '<em>Or Feature Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_FEATURE_RULE_FEATURE_COUNT = NARY_FEATURE_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Or Feature Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_FEATURE_RULE_OPERATION_COUNT = NARY_FEATURE_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.AndFeatureRuleImpl <em>And Feature Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.AndFeatureRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getAndFeatureRule()
	 * @generated
	 */
	int AND_FEATURE_RULE = 32;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_FEATURE_RULE__RULES = NARY_FEATURE_RULE__RULES;

	/**
	 * The number of structural features of the '<em>And Feature Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_FEATURE_RULE_FEATURE_COUNT = NARY_FEATURE_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>And Feature Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_FEATURE_RULE_OPERATION_COUNT = NARY_FEATURE_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.ActionEnum <em>Action Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.ActionEnum
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getActionEnum()
	 * @generated
	 */
	int ACTION_ENUM = 33;


	/**
	 * The meta object id for the '{@link Editpolicymodel.TypeEnum <em>Type Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.TypeEnum
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getTypeEnum()
	 * @generated
	 */
	int TYPE_ENUM = 34;

	/**
	 * The meta object id for the '{@link Editpolicymodel.FeatureNameEnum <em>Feature Name Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.FeatureNameEnum
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getFeatureNameEnum()
	 * @generated
	 */
	int FEATURE_NAME_ENUM = 35;

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
	 * Returns the meta object for the attribute '{@link Editpolicymodel.IsFeature#getFeatureName <em>Feature Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature Name</em>'.
	 * @see Editpolicymodel.IsFeature#getFeatureName()
	 * @see #getIsFeature()
	 * @generated
	 */
	EAttribute getIsFeature_FeatureName();

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
	 * Returns the meta object for class '{@link Editpolicymodel.UnaryConstraintRule <em>Unary Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Constraint Rule</em>'.
	 * @see Editpolicymodel.UnaryConstraintRule
	 * @generated
	 */
	EClass getUnaryConstraintRule();

	/**
	 * Returns the meta object for the containment reference '{@link Editpolicymodel.UnaryConstraintRule#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rule</em>'.
	 * @see Editpolicymodel.UnaryConstraintRule#getRule()
	 * @see #getUnaryConstraintRule()
	 * @generated
	 */
	EReference getUnaryConstraintRule_Rule();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.NotConstraintRule <em>Not Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not Constraint Rule</em>'.
	 * @see Editpolicymodel.NotConstraintRule
	 * @generated
	 */
	EClass getNotConstraintRule();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.AndConstraintRule <em>And Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And Constraint Rule</em>'.
	 * @see Editpolicymodel.AndConstraintRule
	 * @generated
	 */
	EClass getAndConstraintRule();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.BinaryConstraintRule <em>Binary Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Constraint Rule</em>'.
	 * @see Editpolicymodel.BinaryConstraintRule
	 * @generated
	 */
	EClass getBinaryConstraintRule();

	/**
	 * Returns the meta object for the containment reference '{@link Editpolicymodel.BinaryConstraintRule#getLeftRule <em>Left Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Rule</em>'.
	 * @see Editpolicymodel.BinaryConstraintRule#getLeftRule()
	 * @see #getBinaryConstraintRule()
	 * @generated
	 */
	EReference getBinaryConstraintRule_LeftRule();

	/**
	 * Returns the meta object for the containment reference '{@link Editpolicymodel.BinaryConstraintRule#getRightRule <em>Right Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Rule</em>'.
	 * @see Editpolicymodel.BinaryConstraintRule#getRightRule()
	 * @see #getBinaryConstraintRule()
	 * @generated
	 */
	EReference getBinaryConstraintRule_RightRule();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.TrueConstraintRule <em>True Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>True Constraint Rule</em>'.
	 * @see Editpolicymodel.TrueConstraintRule
	 * @generated
	 */
	EClass getTrueConstraintRule();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.FalseConstraintRule <em>False Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>False Constraint Rule</em>'.
	 * @see Editpolicymodel.FalseConstraintRule
	 * @generated
	 */
	EClass getFalseConstraintRule();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.OrConstraintRule <em>Or Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or Constraint Rule</em>'.
	 * @see Editpolicymodel.OrConstraintRule
	 * @generated
	 */
	EClass getOrConstraintRule();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.ImplicationConstraintRule <em>Implication Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Implication Constraint Rule</em>'.
	 * @see Editpolicymodel.ImplicationConstraintRule
	 * @generated
	 */
	EClass getImplicationConstraintRule();

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
	 * Returns the meta object for class '{@link Editpolicymodel.NaryConstraintRule <em>Nary Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nary Constraint Rule</em>'.
	 * @see Editpolicymodel.NaryConstraintRule
	 * @generated
	 */
	EClass getNaryConstraintRule();

	/**
	 * Returns the meta object for the containment reference list '{@link Editpolicymodel.NaryConstraintRule#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rules</em>'.
	 * @see Editpolicymodel.NaryConstraintRule#getRules()
	 * @see #getNaryConstraintRule()
	 * @generated
	 */
	EReference getNaryConstraintRule_Rules();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.LogicalConstraintRule <em>Logical Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Logical Constraint Rule</em>'.
	 * @see Editpolicymodel.LogicalConstraintRule
	 * @generated
	 */
	EClass getLogicalConstraintRule();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.TrueFeatureRule <em>True Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>True Feature Rule</em>'.
	 * @see Editpolicymodel.TrueFeatureRule
	 * @generated
	 */
	EClass getTrueFeatureRule();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.NotFeatureRule <em>Not Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not Feature Rule</em>'.
	 * @see Editpolicymodel.NotFeatureRule
	 * @generated
	 */
	EClass getNotFeatureRule();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.FalseFeatureRule <em>False Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>False Feature Rule</em>'.
	 * @see Editpolicymodel.FalseFeatureRule
	 * @generated
	 */
	EClass getFalseFeatureRule();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.NaryFeatureRule <em>Nary Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nary Feature Rule</em>'.
	 * @see Editpolicymodel.NaryFeatureRule
	 * @generated
	 */
	EClass getNaryFeatureRule();

	/**
	 * Returns the meta object for the containment reference list '{@link Editpolicymodel.NaryFeatureRule#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rules</em>'.
	 * @see Editpolicymodel.NaryFeatureRule#getRules()
	 * @see #getNaryFeatureRule()
	 * @generated
	 */
	EReference getNaryFeatureRule_Rules();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.BinaryFeatureRule <em>Binary Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Feature Rule</em>'.
	 * @see Editpolicymodel.BinaryFeatureRule
	 * @generated
	 */
	EClass getBinaryFeatureRule();

	/**
	 * Returns the meta object for the containment reference '{@link Editpolicymodel.BinaryFeatureRule#getRightRule <em>Right Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Rule</em>'.
	 * @see Editpolicymodel.BinaryFeatureRule#getRightRule()
	 * @see #getBinaryFeatureRule()
	 * @generated
	 */
	EReference getBinaryFeatureRule_RightRule();

	/**
	 * Returns the meta object for the containment reference '{@link Editpolicymodel.BinaryFeatureRule#getLeftRule <em>Left Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Rule</em>'.
	 * @see Editpolicymodel.BinaryFeatureRule#getLeftRule()
	 * @see #getBinaryFeatureRule()
	 * @generated
	 */
	EReference getBinaryFeatureRule_LeftRule();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.LogicalFeatureRule <em>Logical Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Logical Feature Rule</em>'.
	 * @see Editpolicymodel.LogicalFeatureRule
	 * @generated
	 */
	EClass getLogicalFeatureRule();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.ImplicationFeatureRule <em>Implication Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Implication Feature Rule</em>'.
	 * @see Editpolicymodel.ImplicationFeatureRule
	 * @generated
	 */
	EClass getImplicationFeatureRule();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.UnaryFeatureRule <em>Unary Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Feature Rule</em>'.
	 * @see Editpolicymodel.UnaryFeatureRule
	 * @generated
	 */
	EClass getUnaryFeatureRule();

	/**
	 * Returns the meta object for the containment reference '{@link Editpolicymodel.UnaryFeatureRule#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rule</em>'.
	 * @see Editpolicymodel.UnaryFeatureRule#getRule()
	 * @see #getUnaryFeatureRule()
	 * @generated
	 */
	EReference getUnaryFeatureRule_Rule();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.OrFeatureRule <em>Or Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or Feature Rule</em>'.
	 * @see Editpolicymodel.OrFeatureRule
	 * @generated
	 */
	EClass getOrFeatureRule();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.AndFeatureRule <em>And Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And Feature Rule</em>'.
	 * @see Editpolicymodel.AndFeatureRule
	 * @generated
	 */
	EClass getAndFeatureRule();

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
	 * Returns the meta object for enum '{@link Editpolicymodel.TypeEnum <em>Type Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Type Enum</em>'.
	 * @see Editpolicymodel.TypeEnum
	 * @generated
	 */
	EEnum getTypeEnum();

	/**
	 * Returns the meta object for enum '{@link Editpolicymodel.FeatureNameEnum <em>Feature Name Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Feature Name Enum</em>'.
	 * @see Editpolicymodel.FeatureNameEnum
	 * @generated
	 */
	EEnum getFeatureNameEnum();

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
		 * The meta object literal for the '<em><b>Feature Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IS_FEATURE__FEATURE_NAME = eINSTANCE.getIsFeature_FeatureName();

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
		 * The meta object literal for the '{@link Editpolicymodel.impl.UnaryConstraintRuleImpl <em>Unary Constraint Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.UnaryConstraintRuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getUnaryConstraintRule()
		 * @generated
		 */
		EClass UNARY_CONSTRAINT_RULE = eINSTANCE.getUnaryConstraintRule();

		/**
		 * The meta object literal for the '<em><b>Rule</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNARY_CONSTRAINT_RULE__RULE = eINSTANCE.getUnaryConstraintRule_Rule();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.NotConstraintRuleImpl <em>Not Constraint Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.NotConstraintRuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getNotConstraintRule()
		 * @generated
		 */
		EClass NOT_CONSTRAINT_RULE = eINSTANCE.getNotConstraintRule();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.AndConstraintRuleImpl <em>And Constraint Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.AndConstraintRuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getAndConstraintRule()
		 * @generated
		 */
		EClass AND_CONSTRAINT_RULE = eINSTANCE.getAndConstraintRule();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.BinaryConstraintRuleImpl <em>Binary Constraint Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.BinaryConstraintRuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getBinaryConstraintRule()
		 * @generated
		 */
		EClass BINARY_CONSTRAINT_RULE = eINSTANCE.getBinaryConstraintRule();

		/**
		 * The meta object literal for the '<em><b>Left Rule</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_CONSTRAINT_RULE__LEFT_RULE = eINSTANCE.getBinaryConstraintRule_LeftRule();

		/**
		 * The meta object literal for the '<em><b>Right Rule</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_CONSTRAINT_RULE__RIGHT_RULE = eINSTANCE.getBinaryConstraintRule_RightRule();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.TrueConstraintRuleImpl <em>True Constraint Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.TrueConstraintRuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getTrueConstraintRule()
		 * @generated
		 */
		EClass TRUE_CONSTRAINT_RULE = eINSTANCE.getTrueConstraintRule();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.FalseConstraintRuleImpl <em>False Constraint Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.FalseConstraintRuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getFalseConstraintRule()
		 * @generated
		 */
		EClass FALSE_CONSTRAINT_RULE = eINSTANCE.getFalseConstraintRule();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.OrConstraintRuleImpl <em>Or Constraint Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.OrConstraintRuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getOrConstraintRule()
		 * @generated
		 */
		EClass OR_CONSTRAINT_RULE = eINSTANCE.getOrConstraintRule();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.ImplicationConstraintRuleImpl <em>Implication Constraint Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.ImplicationConstraintRuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getImplicationConstraintRule()
		 * @generated
		 */
		EClass IMPLICATION_CONSTRAINT_RULE = eINSTANCE.getImplicationConstraintRule();

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
		 * The meta object literal for the '{@link Editpolicymodel.impl.NaryConstraintRuleImpl <em>Nary Constraint Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.NaryConstraintRuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getNaryConstraintRule()
		 * @generated
		 */
		EClass NARY_CONSTRAINT_RULE = eINSTANCE.getNaryConstraintRule();

		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NARY_CONSTRAINT_RULE__RULES = eINSTANCE.getNaryConstraintRule_Rules();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.LogicalConstraintRuleImpl <em>Logical Constraint Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.LogicalConstraintRuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getLogicalConstraintRule()
		 * @generated
		 */
		EClass LOGICAL_CONSTRAINT_RULE = eINSTANCE.getLogicalConstraintRule();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.TrueFeatureRuleImpl <em>True Feature Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.TrueFeatureRuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getTrueFeatureRule()
		 * @generated
		 */
		EClass TRUE_FEATURE_RULE = eINSTANCE.getTrueFeatureRule();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.NotFeatureRuleImpl <em>Not Feature Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.NotFeatureRuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getNotFeatureRule()
		 * @generated
		 */
		EClass NOT_FEATURE_RULE = eINSTANCE.getNotFeatureRule();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.FalseFeatureRuleImpl <em>False Feature Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.FalseFeatureRuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getFalseFeatureRule()
		 * @generated
		 */
		EClass FALSE_FEATURE_RULE = eINSTANCE.getFalseFeatureRule();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.NaryFeatureRuleImpl <em>Nary Feature Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.NaryFeatureRuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getNaryFeatureRule()
		 * @generated
		 */
		EClass NARY_FEATURE_RULE = eINSTANCE.getNaryFeatureRule();

		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NARY_FEATURE_RULE__RULES = eINSTANCE.getNaryFeatureRule_Rules();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.BinaryFeatureRuleImpl <em>Binary Feature Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.BinaryFeatureRuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getBinaryFeatureRule()
		 * @generated
		 */
		EClass BINARY_FEATURE_RULE = eINSTANCE.getBinaryFeatureRule();

		/**
		 * The meta object literal for the '<em><b>Right Rule</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_FEATURE_RULE__RIGHT_RULE = eINSTANCE.getBinaryFeatureRule_RightRule();

		/**
		 * The meta object literal for the '<em><b>Left Rule</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_FEATURE_RULE__LEFT_RULE = eINSTANCE.getBinaryFeatureRule_LeftRule();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.LogicalFeatureRuleImpl <em>Logical Feature Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.LogicalFeatureRuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getLogicalFeatureRule()
		 * @generated
		 */
		EClass LOGICAL_FEATURE_RULE = eINSTANCE.getLogicalFeatureRule();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.ImplicationFeatureRuleImpl <em>Implication Feature Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.ImplicationFeatureRuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getImplicationFeatureRule()
		 * @generated
		 */
		EClass IMPLICATION_FEATURE_RULE = eINSTANCE.getImplicationFeatureRule();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.UnaryFeatureRuleImpl <em>Unary Feature Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.UnaryFeatureRuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getUnaryFeatureRule()
		 * @generated
		 */
		EClass UNARY_FEATURE_RULE = eINSTANCE.getUnaryFeatureRule();

		/**
		 * The meta object literal for the '<em><b>Rule</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNARY_FEATURE_RULE__RULE = eINSTANCE.getUnaryFeatureRule_Rule();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.OrFeatureRuleImpl <em>Or Feature Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.OrFeatureRuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getOrFeatureRule()
		 * @generated
		 */
		EClass OR_FEATURE_RULE = eINSTANCE.getOrFeatureRule();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.AndFeatureRuleImpl <em>And Feature Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.AndFeatureRuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getAndFeatureRule()
		 * @generated
		 */
		EClass AND_FEATURE_RULE = eINSTANCE.getAndFeatureRule();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.ActionEnum <em>Action Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.ActionEnum
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getActionEnum()
		 * @generated
		 */
		EEnum ACTION_ENUM = eINSTANCE.getActionEnum();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.TypeEnum <em>Type Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.TypeEnum
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getTypeEnum()
		 * @generated
		 */
		EEnum TYPE_ENUM = eINSTANCE.getTypeEnum();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.FeatureNameEnum <em>Feature Name Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.FeatureNameEnum
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getFeatureNameEnum()
		 * @generated
		 */
		EEnum FEATURE_NAME_ENUM = eINSTANCE.getFeatureNameEnum();

	}

} //EditpolicymodelPackage
