/**
 */
package editpolicymodel;

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
 * @see editpolicymodel.editpolicymodelFactory
 * @model kind="package"
 * @generated
 */
public interface editpolicymodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "editpolicymodel";

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
	String eNS_PREFIX = "editpolicymodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	editpolicymodelPackage eINSTANCE = editpolicymodel.impl.editpolicymodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link editpolicymodel.impl.ModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editpolicymodel.impl.ModelImpl
	 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getModel()
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
	 * The meta object id for the '{@link editpolicymodel.impl.PolicyImpl <em>Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editpolicymodel.impl.PolicyImpl
	 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getPolicy()
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
	 * The meta object id for the '{@link editpolicymodel.impl.ConstraintRuleImpl <em>Constraint Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editpolicymodel.impl.ConstraintRuleImpl
	 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getConstraintRule()
	 * @generated
	 */
	int CONSTRAINT_RULE = 7;

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
	 * The meta object id for the '{@link editpolicymodel.impl.ContainsCompartmentImpl <em>Contains Compartment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editpolicymodel.impl.ContainsCompartmentImpl
	 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getContainsCompartment()
	 * @generated
	 */
	int CONTAINS_COMPARTMENT = 2;

	/**
	 * The number of structural features of the '<em>Contains Compartment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS_COMPARTMENT_FEATURE_COUNT = CONSTRAINT_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Contains Compartment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS_COMPARTMENT_OPERATION_COUNT = CONSTRAINT_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link editpolicymodel.impl.TypeArgumentRuleImpl <em>Type Argument Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editpolicymodel.impl.TypeArgumentRuleImpl
	 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getTypeArgumentRule()
	 * @generated
	 */
	int TYPE_ARGUMENT_RULE = 18;

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
	 * The meta object id for the '{@link editpolicymodel.impl.IsTargetImpl <em>Is Target</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editpolicymodel.impl.IsTargetImpl
	 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getIsTarget()
	 * @generated
	 */
	int IS_TARGET = 3;

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
	 * The meta object id for the '{@link editpolicymodel.impl.IsParentImpl <em>Is Parent</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editpolicymodel.impl.IsParentImpl
	 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getIsParent()
	 * @generated
	 */
	int IS_PARENT = 4;

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
	 * The meta object id for the '{@link editpolicymodel.impl.FeatureRuleImpl <em>Feature Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editpolicymodel.impl.FeatureRuleImpl
	 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getFeatureRule()
	 * @generated
	 */
	int FEATURE_RULE = 5;

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
	 * The meta object id for the '{@link editpolicymodel.impl.IsFeatureImpl <em>Is Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editpolicymodel.impl.IsFeatureImpl
	 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getIsFeature()
	 * @generated
	 */
	int IS_FEATURE = 6;

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
	 * The meta object id for the '{@link editpolicymodel.impl.IsTargetTypeImpl <em>Is Target Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editpolicymodel.impl.IsTargetTypeImpl
	 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getIsTargetType()
	 * @generated
	 */
	int IS_TARGET_TYPE = 8;

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
	 * The meta object id for the '{@link editpolicymodel.impl.LogicalConstraintRuleImpl <em>Logical Constraint Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editpolicymodel.impl.LogicalConstraintRuleImpl
	 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getLogicalConstraintRule()
	 * @generated
	 */
	int LOGICAL_CONSTRAINT_RULE = 20;

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
	 * The meta object id for the '{@link editpolicymodel.impl.UnaryConstraintRuleImpl <em>Unary Constraint Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editpolicymodel.impl.UnaryConstraintRuleImpl
	 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getUnaryConstraintRule()
	 * @generated
	 */
	int UNARY_CONSTRAINT_RULE = 9;

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
	 * The meta object id for the '{@link editpolicymodel.impl.NotConstraintRuleImpl <em>Not Constraint Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editpolicymodel.impl.NotConstraintRuleImpl
	 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getNotConstraintRule()
	 * @generated
	 */
	int NOT_CONSTRAINT_RULE = 10;

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
	 * The meta object id for the '{@link editpolicymodel.impl.NaryConstraintRuleImpl <em>Nary Constraint Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editpolicymodel.impl.NaryConstraintRuleImpl
	 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getNaryConstraintRule()
	 * @generated
	 */
	int NARY_CONSTRAINT_RULE = 19;

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
	 * The meta object id for the '{@link editpolicymodel.impl.AndConstraintRuleImpl <em>And Constraint Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editpolicymodel.impl.AndConstraintRuleImpl
	 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getAndConstraintRule()
	 * @generated
	 */
	int AND_CONSTRAINT_RULE = 11;

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
	 * The meta object id for the '{@link editpolicymodel.impl.BinaryConstraintRuleImpl <em>Binary Constraint Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editpolicymodel.impl.BinaryConstraintRuleImpl
	 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getBinaryConstraintRule()
	 * @generated
	 */
	int BINARY_CONSTRAINT_RULE = 12;

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
	 * The meta object id for the '{@link editpolicymodel.impl.TrueConstraintRuleImpl <em>True Constraint Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editpolicymodel.impl.TrueConstraintRuleImpl
	 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getTrueConstraintRule()
	 * @generated
	 */
	int TRUE_CONSTRAINT_RULE = 13;

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
	 * The meta object id for the '{@link editpolicymodel.impl.FalseConstraintRuleImpl <em>False Constraint Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editpolicymodel.impl.FalseConstraintRuleImpl
	 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getFalseConstraintRule()
	 * @generated
	 */
	int FALSE_CONSTRAINT_RULE = 14;

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
	 * The meta object id for the '{@link editpolicymodel.impl.OrConstraintRuleImpl <em>Or Constraint Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editpolicymodel.impl.OrConstraintRuleImpl
	 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getOrConstraintRule()
	 * @generated
	 */
	int OR_CONSTRAINT_RULE = 15;

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
	 * The meta object id for the '{@link editpolicymodel.impl.ImplicationConstraintRuleImpl <em>Implication Constraint Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editpolicymodel.impl.ImplicationConstraintRuleImpl
	 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getImplicationConstraintRule()
	 * @generated
	 */
	int IMPLICATION_CONSTRAINT_RULE = 16;

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
	 * The meta object id for the '{@link editpolicymodel.impl.IsSourceTypeImpl <em>Is Source Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editpolicymodel.impl.IsSourceTypeImpl
	 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getIsSourceType()
	 * @generated
	 */
	int IS_SOURCE_TYPE = 17;

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
	 * The meta object id for the '{@link editpolicymodel.impl.LogicalFeatureRuleImpl <em>Logical Feature Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editpolicymodel.impl.LogicalFeatureRuleImpl
	 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getLogicalFeatureRule()
	 * @generated
	 */
	int LOGICAL_FEATURE_RULE = 26;

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
	 * The meta object id for the '{@link editpolicymodel.impl.TrueFeatureRuleImpl <em>True Feature Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editpolicymodel.impl.TrueFeatureRuleImpl
	 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getTrueFeatureRule()
	 * @generated
	 */
	int TRUE_FEATURE_RULE = 21;

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
	 * The meta object id for the '{@link editpolicymodel.impl.UnaryFeatureRuleImpl <em>Unary Feature Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editpolicymodel.impl.UnaryFeatureRuleImpl
	 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getUnaryFeatureRule()
	 * @generated
	 */
	int UNARY_FEATURE_RULE = 28;

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
	 * The meta object id for the '{@link editpolicymodel.impl.NotFeatureRuleImpl <em>Not Feature Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editpolicymodel.impl.NotFeatureRuleImpl
	 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getNotFeatureRule()
	 * @generated
	 */
	int NOT_FEATURE_RULE = 22;

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
	 * The meta object id for the '{@link editpolicymodel.impl.FalseFeatureRuleImpl <em>False Feature Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editpolicymodel.impl.FalseFeatureRuleImpl
	 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getFalseFeatureRule()
	 * @generated
	 */
	int FALSE_FEATURE_RULE = 23;

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
	 * The meta object id for the '{@link editpolicymodel.impl.NaryFeatureRuleImpl <em>Nary Feature Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editpolicymodel.impl.NaryFeatureRuleImpl
	 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getNaryFeatureRule()
	 * @generated
	 */
	int NARY_FEATURE_RULE = 24;

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
	 * The meta object id for the '{@link editpolicymodel.impl.BinaryFeatureRuleImpl <em>Binary Feature Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editpolicymodel.impl.BinaryFeatureRuleImpl
	 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getBinaryFeatureRule()
	 * @generated
	 */
	int BINARY_FEATURE_RULE = 25;

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
	 * The meta object id for the '{@link editpolicymodel.impl.ImplicationFeatureRuleImpl <em>Implication Feature Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editpolicymodel.impl.ImplicationFeatureRuleImpl
	 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getImplicationFeatureRule()
	 * @generated
	 */
	int IMPLICATION_FEATURE_RULE = 27;

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
	 * The meta object id for the '{@link editpolicymodel.impl.OrFeatureRuleImpl <em>Or Feature Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editpolicymodel.impl.OrFeatureRuleImpl
	 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getOrFeatureRule()
	 * @generated
	 */
	int OR_FEATURE_RULE = 29;

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
	 * The meta object id for the '{@link editpolicymodel.impl.AndFeatureRuleImpl <em>And Feature Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editpolicymodel.impl.AndFeatureRuleImpl
	 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getAndFeatureRule()
	 * @generated
	 */
	int AND_FEATURE_RULE = 30;

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
	 * The meta object id for the '{@link editpolicymodel.impl.SourceEqualsTargetImpl <em>Source Equals Target</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editpolicymodel.impl.SourceEqualsTargetImpl
	 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getSourceEqualsTarget()
	 * @generated
	 */
	int SOURCE_EQUALS_TARGET = 31;

	/**
	 * The number of structural features of the '<em>Source Equals Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_EQUALS_TARGET_FEATURE_COUNT = CONSTRAINT_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Source Equals Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_EQUALS_TARGET_OPERATION_COUNT = CONSTRAINT_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link editpolicymodel.impl.SourceEqualsTargetTypeImpl <em>Source Equals Target Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editpolicymodel.impl.SourceEqualsTargetTypeImpl
	 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getSourceEqualsTargetType()
	 * @generated
	 */
	int SOURCE_EQUALS_TARGET_TYPE = 32;

	/**
	 * The number of structural features of the '<em>Source Equals Target Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_EQUALS_TARGET_TYPE_FEATURE_COUNT = CONSTRAINT_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Source Equals Target Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_EQUALS_TARGET_TYPE_OPERATION_COUNT = CONSTRAINT_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link editpolicymodel.impl.InTypeImpl <em>In Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editpolicymodel.impl.InTypeImpl
	 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getInType()
	 * @generated
	 */
	int IN_TYPE = 33;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_TYPE__TYPE = TYPE_ARGUMENT_RULE__TYPE;

	/**
	 * The number of structural features of the '<em>In Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_TYPE_FEATURE_COUNT = TYPE_ARGUMENT_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>In Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_TYPE_OPERATION_COUNT = TYPE_ARGUMENT_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link editpolicymodel.ActionEnum <em>Action Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editpolicymodel.ActionEnum
	 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getActionEnum()
	 * @generated
	 */
	int ACTION_ENUM = 34;

	/**
	 * The meta object id for the '{@link editpolicymodel.TypeEnum <em>Type Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editpolicymodel.TypeEnum
	 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getTypeEnum()
	 * @generated
	 */
	int TYPE_ENUM = 35;

	/**
	 * The meta object id for the '{@link editpolicymodel.FeatureNameEnum <em>Feature Name Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editpolicymodel.FeatureNameEnum
	 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getFeatureNameEnum()
	 * @generated
	 */
	int FEATURE_NAME_ENUM = 36;


	/**
	 * Returns the meta object for class '{@link editpolicymodel.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see editpolicymodel.Model
	 * @generated
	 */
	EClass getModel();

	/**
	 * Returns the meta object for the containment reference list '{@link editpolicymodel.Model#getPolicies <em>Policies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Policies</em>'.
	 * @see editpolicymodel.Model#getPolicies()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Policies();

	/**
	 * Returns the meta object for class '{@link editpolicymodel.Policy <em>Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Policy</em>'.
	 * @see editpolicymodel.Policy
	 * @generated
	 */
	EClass getPolicy();

	/**
	 * Returns the meta object for the attribute '{@link editpolicymodel.Policy#getOverride <em>Override</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Override</em>'.
	 * @see editpolicymodel.Policy#getOverride()
	 * @see #getPolicy()
	 * @generated
	 */
	EAttribute getPolicy_Override();

	/**
	 * Returns the meta object for the attribute '{@link editpolicymodel.Policy#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action</em>'.
	 * @see editpolicymodel.Policy#getAction()
	 * @see #getPolicy()
	 * @generated
	 */
	EAttribute getPolicy_Action();

	/**
	 * Returns the meta object for the attribute '{@link editpolicymodel.Policy#getActionType <em>Action Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action Type</em>'.
	 * @see editpolicymodel.Policy#getActionType()
	 * @see #getPolicy()
	 * @generated
	 */
	EAttribute getPolicy_ActionType();

	/**
	 * Returns the meta object for the containment reference '{@link editpolicymodel.Policy#getFeatureRule <em>Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Feature Rule</em>'.
	 * @see editpolicymodel.Policy#getFeatureRule()
	 * @see #getPolicy()
	 * @generated
	 */
	EReference getPolicy_FeatureRule();

	/**
	 * Returns the meta object for the containment reference '{@link editpolicymodel.Policy#getConstraintRule <em>Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Constraint Rule</em>'.
	 * @see editpolicymodel.Policy#getConstraintRule()
	 * @see #getPolicy()
	 * @generated
	 */
	EReference getPolicy_ConstraintRule();

	/**
	 * Returns the meta object for class '{@link editpolicymodel.ContainsCompartment <em>Contains Compartment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contains Compartment</em>'.
	 * @see editpolicymodel.ContainsCompartment
	 * @generated
	 */
	EClass getContainsCompartment();

	/**
	 * Returns the meta object for class '{@link editpolicymodel.IsTarget <em>Is Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Is Target</em>'.
	 * @see editpolicymodel.IsTarget
	 * @generated
	 */
	EClass getIsTarget();

	/**
	 * Returns the meta object for class '{@link editpolicymodel.IsParent <em>Is Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Is Parent</em>'.
	 * @see editpolicymodel.IsParent
	 * @generated
	 */
	EClass getIsParent();

	/**
	 * Returns the meta object for class '{@link editpolicymodel.FeatureRule <em>Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Rule</em>'.
	 * @see editpolicymodel.FeatureRule
	 * @generated
	 */
	EClass getFeatureRule();

	/**
	 * Returns the meta object for class '{@link editpolicymodel.IsFeature <em>Is Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Is Feature</em>'.
	 * @see editpolicymodel.IsFeature
	 * @generated
	 */
	EClass getIsFeature();

	/**
	 * Returns the meta object for the attribute '{@link editpolicymodel.IsFeature#getFeatureName <em>Feature Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature Name</em>'.
	 * @see editpolicymodel.IsFeature#getFeatureName()
	 * @see #getIsFeature()
	 * @generated
	 */
	EAttribute getIsFeature_FeatureName();

	/**
	 * Returns the meta object for class '{@link editpolicymodel.ConstraintRule <em>Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint Rule</em>'.
	 * @see editpolicymodel.ConstraintRule
	 * @generated
	 */
	EClass getConstraintRule();

	/**
	 * Returns the meta object for class '{@link editpolicymodel.IsTargetType <em>Is Target Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Is Target Type</em>'.
	 * @see editpolicymodel.IsTargetType
	 * @generated
	 */
	EClass getIsTargetType();

	/**
	 * Returns the meta object for class '{@link editpolicymodel.UnaryConstraintRule <em>Unary Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Constraint Rule</em>'.
	 * @see editpolicymodel.UnaryConstraintRule
	 * @generated
	 */
	EClass getUnaryConstraintRule();

	/**
	 * Returns the meta object for the containment reference '{@link editpolicymodel.UnaryConstraintRule#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rule</em>'.
	 * @see editpolicymodel.UnaryConstraintRule#getRule()
	 * @see #getUnaryConstraintRule()
	 * @generated
	 */
	EReference getUnaryConstraintRule_Rule();

	/**
	 * Returns the meta object for class '{@link editpolicymodel.NotConstraintRule <em>Not Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not Constraint Rule</em>'.
	 * @see editpolicymodel.NotConstraintRule
	 * @generated
	 */
	EClass getNotConstraintRule();

	/**
	 * Returns the meta object for class '{@link editpolicymodel.AndConstraintRule <em>And Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And Constraint Rule</em>'.
	 * @see editpolicymodel.AndConstraintRule
	 * @generated
	 */
	EClass getAndConstraintRule();

	/**
	 * Returns the meta object for class '{@link editpolicymodel.BinaryConstraintRule <em>Binary Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Constraint Rule</em>'.
	 * @see editpolicymodel.BinaryConstraintRule
	 * @generated
	 */
	EClass getBinaryConstraintRule();

	/**
	 * Returns the meta object for the containment reference '{@link editpolicymodel.BinaryConstraintRule#getLeftRule <em>Left Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Rule</em>'.
	 * @see editpolicymodel.BinaryConstraintRule#getLeftRule()
	 * @see #getBinaryConstraintRule()
	 * @generated
	 */
	EReference getBinaryConstraintRule_LeftRule();

	/**
	 * Returns the meta object for the containment reference '{@link editpolicymodel.BinaryConstraintRule#getRightRule <em>Right Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Rule</em>'.
	 * @see editpolicymodel.BinaryConstraintRule#getRightRule()
	 * @see #getBinaryConstraintRule()
	 * @generated
	 */
	EReference getBinaryConstraintRule_RightRule();

	/**
	 * Returns the meta object for class '{@link editpolicymodel.TrueConstraintRule <em>True Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>True Constraint Rule</em>'.
	 * @see editpolicymodel.TrueConstraintRule
	 * @generated
	 */
	EClass getTrueConstraintRule();

	/**
	 * Returns the meta object for class '{@link editpolicymodel.FalseConstraintRule <em>False Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>False Constraint Rule</em>'.
	 * @see editpolicymodel.FalseConstraintRule
	 * @generated
	 */
	EClass getFalseConstraintRule();

	/**
	 * Returns the meta object for class '{@link editpolicymodel.OrConstraintRule <em>Or Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or Constraint Rule</em>'.
	 * @see editpolicymodel.OrConstraintRule
	 * @generated
	 */
	EClass getOrConstraintRule();

	/**
	 * Returns the meta object for class '{@link editpolicymodel.ImplicationConstraintRule <em>Implication Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Implication Constraint Rule</em>'.
	 * @see editpolicymodel.ImplicationConstraintRule
	 * @generated
	 */
	EClass getImplicationConstraintRule();

	/**
	 * Returns the meta object for class '{@link editpolicymodel.IsSourceType <em>Is Source Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Is Source Type</em>'.
	 * @see editpolicymodel.IsSourceType
	 * @generated
	 */
	EClass getIsSourceType();

	/**
	 * Returns the meta object for class '{@link editpolicymodel.TypeArgumentRule <em>Type Argument Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Argument Rule</em>'.
	 * @see editpolicymodel.TypeArgumentRule
	 * @generated
	 */
	EClass getTypeArgumentRule();

	/**
	 * Returns the meta object for the attribute '{@link editpolicymodel.TypeArgumentRule#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see editpolicymodel.TypeArgumentRule#getType()
	 * @see #getTypeArgumentRule()
	 * @generated
	 */
	EAttribute getTypeArgumentRule_Type();

	/**
	 * Returns the meta object for class '{@link editpolicymodel.NaryConstraintRule <em>Nary Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nary Constraint Rule</em>'.
	 * @see editpolicymodel.NaryConstraintRule
	 * @generated
	 */
	EClass getNaryConstraintRule();

	/**
	 * Returns the meta object for the containment reference list '{@link editpolicymodel.NaryConstraintRule#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rules</em>'.
	 * @see editpolicymodel.NaryConstraintRule#getRules()
	 * @see #getNaryConstraintRule()
	 * @generated
	 */
	EReference getNaryConstraintRule_Rules();

	/**
	 * Returns the meta object for class '{@link editpolicymodel.LogicalConstraintRule <em>Logical Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Logical Constraint Rule</em>'.
	 * @see editpolicymodel.LogicalConstraintRule
	 * @generated
	 */
	EClass getLogicalConstraintRule();

	/**
	 * Returns the meta object for class '{@link editpolicymodel.TrueFeatureRule <em>True Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>True Feature Rule</em>'.
	 * @see editpolicymodel.TrueFeatureRule
	 * @generated
	 */
	EClass getTrueFeatureRule();

	/**
	 * Returns the meta object for class '{@link editpolicymodel.NotFeatureRule <em>Not Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not Feature Rule</em>'.
	 * @see editpolicymodel.NotFeatureRule
	 * @generated
	 */
	EClass getNotFeatureRule();

	/**
	 * Returns the meta object for class '{@link editpolicymodel.FalseFeatureRule <em>False Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>False Feature Rule</em>'.
	 * @see editpolicymodel.FalseFeatureRule
	 * @generated
	 */
	EClass getFalseFeatureRule();

	/**
	 * Returns the meta object for class '{@link editpolicymodel.NaryFeatureRule <em>Nary Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nary Feature Rule</em>'.
	 * @see editpolicymodel.NaryFeatureRule
	 * @generated
	 */
	EClass getNaryFeatureRule();

	/**
	 * Returns the meta object for the containment reference list '{@link editpolicymodel.NaryFeatureRule#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rules</em>'.
	 * @see editpolicymodel.NaryFeatureRule#getRules()
	 * @see #getNaryFeatureRule()
	 * @generated
	 */
	EReference getNaryFeatureRule_Rules();

	/**
	 * Returns the meta object for class '{@link editpolicymodel.BinaryFeatureRule <em>Binary Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Feature Rule</em>'.
	 * @see editpolicymodel.BinaryFeatureRule
	 * @generated
	 */
	EClass getBinaryFeatureRule();

	/**
	 * Returns the meta object for the containment reference '{@link editpolicymodel.BinaryFeatureRule#getRightRule <em>Right Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Rule</em>'.
	 * @see editpolicymodel.BinaryFeatureRule#getRightRule()
	 * @see #getBinaryFeatureRule()
	 * @generated
	 */
	EReference getBinaryFeatureRule_RightRule();

	/**
	 * Returns the meta object for the containment reference '{@link editpolicymodel.BinaryFeatureRule#getLeftRule <em>Left Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Rule</em>'.
	 * @see editpolicymodel.BinaryFeatureRule#getLeftRule()
	 * @see #getBinaryFeatureRule()
	 * @generated
	 */
	EReference getBinaryFeatureRule_LeftRule();

	/**
	 * Returns the meta object for class '{@link editpolicymodel.LogicalFeatureRule <em>Logical Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Logical Feature Rule</em>'.
	 * @see editpolicymodel.LogicalFeatureRule
	 * @generated
	 */
	EClass getLogicalFeatureRule();

	/**
	 * Returns the meta object for class '{@link editpolicymodel.ImplicationFeatureRule <em>Implication Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Implication Feature Rule</em>'.
	 * @see editpolicymodel.ImplicationFeatureRule
	 * @generated
	 */
	EClass getImplicationFeatureRule();

	/**
	 * Returns the meta object for class '{@link editpolicymodel.UnaryFeatureRule <em>Unary Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Feature Rule</em>'.
	 * @see editpolicymodel.UnaryFeatureRule
	 * @generated
	 */
	EClass getUnaryFeatureRule();

	/**
	 * Returns the meta object for the containment reference '{@link editpolicymodel.UnaryFeatureRule#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rule</em>'.
	 * @see editpolicymodel.UnaryFeatureRule#getRule()
	 * @see #getUnaryFeatureRule()
	 * @generated
	 */
	EReference getUnaryFeatureRule_Rule();

	/**
	 * Returns the meta object for class '{@link editpolicymodel.OrFeatureRule <em>Or Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or Feature Rule</em>'.
	 * @see editpolicymodel.OrFeatureRule
	 * @generated
	 */
	EClass getOrFeatureRule();

	/**
	 * Returns the meta object for class '{@link editpolicymodel.AndFeatureRule <em>And Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And Feature Rule</em>'.
	 * @see editpolicymodel.AndFeatureRule
	 * @generated
	 */
	EClass getAndFeatureRule();

	/**
	 * Returns the meta object for class '{@link editpolicymodel.SourceEqualsTarget <em>Source Equals Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source Equals Target</em>'.
	 * @see editpolicymodel.SourceEqualsTarget
	 * @generated
	 */
	EClass getSourceEqualsTarget();

	/**
	 * Returns the meta object for class '{@link editpolicymodel.SourceEqualsTargetType <em>Source Equals Target Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source Equals Target Type</em>'.
	 * @see editpolicymodel.SourceEqualsTargetType
	 * @generated
	 */
	EClass getSourceEqualsTargetType();

	/**
	 * Returns the meta object for class '{@link editpolicymodel.InType <em>In Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>In Type</em>'.
	 * @see editpolicymodel.InType
	 * @generated
	 */
	EClass getInType();

	/**
	 * Returns the meta object for enum '{@link editpolicymodel.ActionEnum <em>Action Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Action Enum</em>'.
	 * @see editpolicymodel.ActionEnum
	 * @generated
	 */
	EEnum getActionEnum();

	/**
	 * Returns the meta object for enum '{@link editpolicymodel.TypeEnum <em>Type Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Type Enum</em>'.
	 * @see editpolicymodel.TypeEnum
	 * @generated
	 */
	EEnum getTypeEnum();

	/**
	 * Returns the meta object for enum '{@link editpolicymodel.FeatureNameEnum <em>Feature Name Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Feature Name Enum</em>'.
	 * @see editpolicymodel.FeatureNameEnum
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
	editpolicymodelFactory geteditpolicymodelFactory();

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
		 * The meta object literal for the '{@link editpolicymodel.impl.ModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editpolicymodel.impl.ModelImpl
		 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getModel()
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
		 * The meta object literal for the '{@link editpolicymodel.impl.PolicyImpl <em>Policy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editpolicymodel.impl.PolicyImpl
		 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getPolicy()
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
		 * The meta object literal for the '{@link editpolicymodel.impl.ContainsCompartmentImpl <em>Contains Compartment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editpolicymodel.impl.ContainsCompartmentImpl
		 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getContainsCompartment()
		 * @generated
		 */
		EClass CONTAINS_COMPARTMENT = eINSTANCE.getContainsCompartment();

		/**
		 * The meta object literal for the '{@link editpolicymodel.impl.IsTargetImpl <em>Is Target</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editpolicymodel.impl.IsTargetImpl
		 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getIsTarget()
		 * @generated
		 */
		EClass IS_TARGET = eINSTANCE.getIsTarget();

		/**
		 * The meta object literal for the '{@link editpolicymodel.impl.IsParentImpl <em>Is Parent</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editpolicymodel.impl.IsParentImpl
		 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getIsParent()
		 * @generated
		 */
		EClass IS_PARENT = eINSTANCE.getIsParent();

		/**
		 * The meta object literal for the '{@link editpolicymodel.impl.FeatureRuleImpl <em>Feature Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editpolicymodel.impl.FeatureRuleImpl
		 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getFeatureRule()
		 * @generated
		 */
		EClass FEATURE_RULE = eINSTANCE.getFeatureRule();

		/**
		 * The meta object literal for the '{@link editpolicymodel.impl.IsFeatureImpl <em>Is Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editpolicymodel.impl.IsFeatureImpl
		 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getIsFeature()
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
		 * The meta object literal for the '{@link editpolicymodel.impl.ConstraintRuleImpl <em>Constraint Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editpolicymodel.impl.ConstraintRuleImpl
		 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getConstraintRule()
		 * @generated
		 */
		EClass CONSTRAINT_RULE = eINSTANCE.getConstraintRule();

		/**
		 * The meta object literal for the '{@link editpolicymodel.impl.IsTargetTypeImpl <em>Is Target Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editpolicymodel.impl.IsTargetTypeImpl
		 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getIsTargetType()
		 * @generated
		 */
		EClass IS_TARGET_TYPE = eINSTANCE.getIsTargetType();

		/**
		 * The meta object literal for the '{@link editpolicymodel.impl.UnaryConstraintRuleImpl <em>Unary Constraint Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editpolicymodel.impl.UnaryConstraintRuleImpl
		 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getUnaryConstraintRule()
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
		 * The meta object literal for the '{@link editpolicymodel.impl.NotConstraintRuleImpl <em>Not Constraint Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editpolicymodel.impl.NotConstraintRuleImpl
		 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getNotConstraintRule()
		 * @generated
		 */
		EClass NOT_CONSTRAINT_RULE = eINSTANCE.getNotConstraintRule();

		/**
		 * The meta object literal for the '{@link editpolicymodel.impl.AndConstraintRuleImpl <em>And Constraint Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editpolicymodel.impl.AndConstraintRuleImpl
		 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getAndConstraintRule()
		 * @generated
		 */
		EClass AND_CONSTRAINT_RULE = eINSTANCE.getAndConstraintRule();

		/**
		 * The meta object literal for the '{@link editpolicymodel.impl.BinaryConstraintRuleImpl <em>Binary Constraint Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editpolicymodel.impl.BinaryConstraintRuleImpl
		 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getBinaryConstraintRule()
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
		 * The meta object literal for the '{@link editpolicymodel.impl.TrueConstraintRuleImpl <em>True Constraint Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editpolicymodel.impl.TrueConstraintRuleImpl
		 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getTrueConstraintRule()
		 * @generated
		 */
		EClass TRUE_CONSTRAINT_RULE = eINSTANCE.getTrueConstraintRule();

		/**
		 * The meta object literal for the '{@link editpolicymodel.impl.FalseConstraintRuleImpl <em>False Constraint Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editpolicymodel.impl.FalseConstraintRuleImpl
		 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getFalseConstraintRule()
		 * @generated
		 */
		EClass FALSE_CONSTRAINT_RULE = eINSTANCE.getFalseConstraintRule();

		/**
		 * The meta object literal for the '{@link editpolicymodel.impl.OrConstraintRuleImpl <em>Or Constraint Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editpolicymodel.impl.OrConstraintRuleImpl
		 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getOrConstraintRule()
		 * @generated
		 */
		EClass OR_CONSTRAINT_RULE = eINSTANCE.getOrConstraintRule();

		/**
		 * The meta object literal for the '{@link editpolicymodel.impl.ImplicationConstraintRuleImpl <em>Implication Constraint Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editpolicymodel.impl.ImplicationConstraintRuleImpl
		 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getImplicationConstraintRule()
		 * @generated
		 */
		EClass IMPLICATION_CONSTRAINT_RULE = eINSTANCE.getImplicationConstraintRule();

		/**
		 * The meta object literal for the '{@link editpolicymodel.impl.IsSourceTypeImpl <em>Is Source Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editpolicymodel.impl.IsSourceTypeImpl
		 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getIsSourceType()
		 * @generated
		 */
		EClass IS_SOURCE_TYPE = eINSTANCE.getIsSourceType();

		/**
		 * The meta object literal for the '{@link editpolicymodel.impl.TypeArgumentRuleImpl <em>Type Argument Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editpolicymodel.impl.TypeArgumentRuleImpl
		 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getTypeArgumentRule()
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
		 * The meta object literal for the '{@link editpolicymodel.impl.NaryConstraintRuleImpl <em>Nary Constraint Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editpolicymodel.impl.NaryConstraintRuleImpl
		 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getNaryConstraintRule()
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
		 * The meta object literal for the '{@link editpolicymodel.impl.LogicalConstraintRuleImpl <em>Logical Constraint Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editpolicymodel.impl.LogicalConstraintRuleImpl
		 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getLogicalConstraintRule()
		 * @generated
		 */
		EClass LOGICAL_CONSTRAINT_RULE = eINSTANCE.getLogicalConstraintRule();

		/**
		 * The meta object literal for the '{@link editpolicymodel.impl.TrueFeatureRuleImpl <em>True Feature Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editpolicymodel.impl.TrueFeatureRuleImpl
		 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getTrueFeatureRule()
		 * @generated
		 */
		EClass TRUE_FEATURE_RULE = eINSTANCE.getTrueFeatureRule();

		/**
		 * The meta object literal for the '{@link editpolicymodel.impl.NotFeatureRuleImpl <em>Not Feature Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editpolicymodel.impl.NotFeatureRuleImpl
		 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getNotFeatureRule()
		 * @generated
		 */
		EClass NOT_FEATURE_RULE = eINSTANCE.getNotFeatureRule();

		/**
		 * The meta object literal for the '{@link editpolicymodel.impl.FalseFeatureRuleImpl <em>False Feature Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editpolicymodel.impl.FalseFeatureRuleImpl
		 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getFalseFeatureRule()
		 * @generated
		 */
		EClass FALSE_FEATURE_RULE = eINSTANCE.getFalseFeatureRule();

		/**
		 * The meta object literal for the '{@link editpolicymodel.impl.NaryFeatureRuleImpl <em>Nary Feature Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editpolicymodel.impl.NaryFeatureRuleImpl
		 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getNaryFeatureRule()
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
		 * The meta object literal for the '{@link editpolicymodel.impl.BinaryFeatureRuleImpl <em>Binary Feature Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editpolicymodel.impl.BinaryFeatureRuleImpl
		 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getBinaryFeatureRule()
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
		 * The meta object literal for the '{@link editpolicymodel.impl.LogicalFeatureRuleImpl <em>Logical Feature Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editpolicymodel.impl.LogicalFeatureRuleImpl
		 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getLogicalFeatureRule()
		 * @generated
		 */
		EClass LOGICAL_FEATURE_RULE = eINSTANCE.getLogicalFeatureRule();

		/**
		 * The meta object literal for the '{@link editpolicymodel.impl.ImplicationFeatureRuleImpl <em>Implication Feature Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editpolicymodel.impl.ImplicationFeatureRuleImpl
		 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getImplicationFeatureRule()
		 * @generated
		 */
		EClass IMPLICATION_FEATURE_RULE = eINSTANCE.getImplicationFeatureRule();

		/**
		 * The meta object literal for the '{@link editpolicymodel.impl.UnaryFeatureRuleImpl <em>Unary Feature Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editpolicymodel.impl.UnaryFeatureRuleImpl
		 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getUnaryFeatureRule()
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
		 * The meta object literal for the '{@link editpolicymodel.impl.OrFeatureRuleImpl <em>Or Feature Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editpolicymodel.impl.OrFeatureRuleImpl
		 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getOrFeatureRule()
		 * @generated
		 */
		EClass OR_FEATURE_RULE = eINSTANCE.getOrFeatureRule();

		/**
		 * The meta object literal for the '{@link editpolicymodel.impl.AndFeatureRuleImpl <em>And Feature Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editpolicymodel.impl.AndFeatureRuleImpl
		 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getAndFeatureRule()
		 * @generated
		 */
		EClass AND_FEATURE_RULE = eINSTANCE.getAndFeatureRule();

		/**
		 * The meta object literal for the '{@link editpolicymodel.impl.SourceEqualsTargetImpl <em>Source Equals Target</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editpolicymodel.impl.SourceEqualsTargetImpl
		 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getSourceEqualsTarget()
		 * @generated
		 */
		EClass SOURCE_EQUALS_TARGET = eINSTANCE.getSourceEqualsTarget();

		/**
		 * The meta object literal for the '{@link editpolicymodel.impl.SourceEqualsTargetTypeImpl <em>Source Equals Target Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editpolicymodel.impl.SourceEqualsTargetTypeImpl
		 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getSourceEqualsTargetType()
		 * @generated
		 */
		EClass SOURCE_EQUALS_TARGET_TYPE = eINSTANCE.getSourceEqualsTargetType();

		/**
		 * The meta object literal for the '{@link editpolicymodel.impl.InTypeImpl <em>In Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editpolicymodel.impl.InTypeImpl
		 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getInType()
		 * @generated
		 */
		EClass IN_TYPE = eINSTANCE.getInType();

		/**
		 * The meta object literal for the '{@link editpolicymodel.ActionEnum <em>Action Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editpolicymodel.ActionEnum
		 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getActionEnum()
		 * @generated
		 */
		EEnum ACTION_ENUM = eINSTANCE.getActionEnum();

		/**
		 * The meta object literal for the '{@link editpolicymodel.TypeEnum <em>Type Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editpolicymodel.TypeEnum
		 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getTypeEnum()
		 * @generated
		 */
		EEnum TYPE_ENUM = eINSTANCE.getTypeEnum();

		/**
		 * The meta object literal for the '{@link editpolicymodel.FeatureNameEnum <em>Feature Name Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editpolicymodel.FeatureNameEnum
		 * @see editpolicymodel.impl.editpolicymodelPackageImpl#getFeatureNameEnum()
		 * @generated
		 */
		EEnum FEATURE_NAME_ENUM = eINSTANCE.getFeatureNameEnum();

	}

} //editpolicymodelPackage
