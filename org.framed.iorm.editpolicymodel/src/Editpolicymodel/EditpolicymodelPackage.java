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
	String eNS_URI = "http://www.example.org/editpolicymodel";

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
	 * The feature id for the '<em><b>Policy</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__POLICY = 0;

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
	 * The feature id for the '<em><b>Constraint Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY__CONSTRAINT_RULE = 1;

	/**
	 * The feature id for the '<em><b>Feature Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY__FEATURE_RULE = 2;

	/**
	 * The feature id for the '<em><b>Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY__ACTION = 3;

	/**
	 * The feature id for the '<em><b>Action Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY__ACTION_TYPE = 4;

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
	 * The meta object id for the '{@link Editpolicymodel.impl.AbstractConstraintRuleImpl <em>Abstract Constraint Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.AbstractConstraintRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getAbstractConstraintRule()
	 * @generated
	 */
	int ABSTRACT_CONSTRAINT_RULE = 2;

	/**
	 * The feature id for the '<em><b>Rule2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CONSTRAINT_RULE__RULE2 = 0;

	/**
	 * The feature id for the '<em><b>Rule1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CONSTRAINT_RULE__RULE1 = 1;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CONSTRAINT_RULE__ARGUMENT = 2;

	/**
	 * The number of structural features of the '<em>Abstract Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CONSTRAINT_RULE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Abstract Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CONSTRAINT_RULE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.AbstractFeatureRuleImpl <em>Abstract Feature Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.AbstractFeatureRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getAbstractFeatureRule()
	 * @generated
	 */
	int ABSTRACT_FEATURE_RULE = 3;

	/**
	 * The feature id for the '<em><b>Rule2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FEATURE_RULE__RULE2 = 0;

	/**
	 * The feature id for the '<em><b>Rule1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FEATURE_RULE__RULE1 = 1;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FEATURE_RULE__ARGUMENT = 2;

	/**
	 * The number of structural features of the '<em>Abstract Feature Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FEATURE_RULE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Abstract Feature Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FEATURE_RULE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.AndConstraintRuleImpl <em>And Constraint Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.AndConstraintRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getAndConstraintRule()
	 * @generated
	 */
	int AND_CONSTRAINT_RULE = 4;

	/**
	 * The feature id for the '<em><b>Rule2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_CONSTRAINT_RULE__RULE2 = ABSTRACT_CONSTRAINT_RULE__RULE2;

	/**
	 * The feature id for the '<em><b>Rule1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_CONSTRAINT_RULE__RULE1 = ABSTRACT_CONSTRAINT_RULE__RULE1;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_CONSTRAINT_RULE__ARGUMENT = ABSTRACT_CONSTRAINT_RULE__ARGUMENT;

	/**
	 * The number of structural features of the '<em>And Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_CONSTRAINT_RULE_FEATURE_COUNT = ABSTRACT_CONSTRAINT_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>And Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_CONSTRAINT_RULE_OPERATION_COUNT = ABSTRACT_CONSTRAINT_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.OrConstraintRuleImpl <em>Or Constraint Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.OrConstraintRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getOrConstraintRule()
	 * @generated
	 */
	int OR_CONSTRAINT_RULE = 5;

	/**
	 * The feature id for the '<em><b>Rule2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_CONSTRAINT_RULE__RULE2 = ABSTRACT_CONSTRAINT_RULE__RULE2;

	/**
	 * The feature id for the '<em><b>Rule1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_CONSTRAINT_RULE__RULE1 = ABSTRACT_CONSTRAINT_RULE__RULE1;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_CONSTRAINT_RULE__ARGUMENT = ABSTRACT_CONSTRAINT_RULE__ARGUMENT;

	/**
	 * The number of structural features of the '<em>Or Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_CONSTRAINT_RULE_FEATURE_COUNT = ABSTRACT_CONSTRAINT_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Or Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_CONSTRAINT_RULE_OPERATION_COUNT = ABSTRACT_CONSTRAINT_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.ContainsConstraintRuleImpl <em>Contains Constraint Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.ContainsConstraintRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getContainsConstraintRule()
	 * @generated
	 */
	int CONTAINS_CONSTRAINT_RULE = 6;

	/**
	 * The feature id for the '<em><b>Rule2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS_CONSTRAINT_RULE__RULE2 = ABSTRACT_CONSTRAINT_RULE__RULE2;

	/**
	 * The feature id for the '<em><b>Rule1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS_CONSTRAINT_RULE__RULE1 = ABSTRACT_CONSTRAINT_RULE__RULE1;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS_CONSTRAINT_RULE__ARGUMENT = ABSTRACT_CONSTRAINT_RULE__ARGUMENT;

	/**
	 * The number of structural features of the '<em>Contains Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS_CONSTRAINT_RULE_FEATURE_COUNT = ABSTRACT_CONSTRAINT_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Contains Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS_CONSTRAINT_RULE_OPERATION_COUNT = ABSTRACT_CONSTRAINT_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.NotConstraintRuleImpl <em>Not Constraint Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.NotConstraintRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getNotConstraintRule()
	 * @generated
	 */
	int NOT_CONSTRAINT_RULE = 7;

	/**
	 * The number of structural features of the '<em>Not Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_CONSTRAINT_RULE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Not Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_CONSTRAINT_RULE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.IsStepOutConstraintRuleImpl <em>Is Step Out Constraint Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.IsStepOutConstraintRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getIsStepOutConstraintRule()
	 * @generated
	 */
	int IS_STEP_OUT_CONSTRAINT_RULE = 8;

	/**
	 * The feature id for the '<em><b>Rule2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_STEP_OUT_CONSTRAINT_RULE__RULE2 = ABSTRACT_CONSTRAINT_RULE__RULE2;

	/**
	 * The feature id for the '<em><b>Rule1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_STEP_OUT_CONSTRAINT_RULE__RULE1 = ABSTRACT_CONSTRAINT_RULE__RULE1;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_STEP_OUT_CONSTRAINT_RULE__ARGUMENT = ABSTRACT_CONSTRAINT_RULE__ARGUMENT;

	/**
	 * The number of structural features of the '<em>Is Step Out Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_STEP_OUT_CONSTRAINT_RULE_FEATURE_COUNT = ABSTRACT_CONSTRAINT_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Is Step Out Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_STEP_OUT_CONSTRAINT_RULE_OPERATION_COUNT = ABSTRACT_CONSTRAINT_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.IsTargetConstraintRuleImpl <em>Is Target Constraint Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.IsTargetConstraintRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getIsTargetConstraintRule()
	 * @generated
	 */
	int IS_TARGET_CONSTRAINT_RULE = 9;

	/**
	 * The feature id for the '<em><b>Rule2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_TARGET_CONSTRAINT_RULE__RULE2 = ABSTRACT_CONSTRAINT_RULE__RULE2;

	/**
	 * The feature id for the '<em><b>Rule1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_TARGET_CONSTRAINT_RULE__RULE1 = ABSTRACT_CONSTRAINT_RULE__RULE1;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_TARGET_CONSTRAINT_RULE__ARGUMENT = ABSTRACT_CONSTRAINT_RULE__ARGUMENT;

	/**
	 * The number of structural features of the '<em>Is Target Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_TARGET_CONSTRAINT_RULE_FEATURE_COUNT = ABSTRACT_CONSTRAINT_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Is Target Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_TARGET_CONSTRAINT_RULE_OPERATION_COUNT = ABSTRACT_CONSTRAINT_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.IsSourceConstraintRuleImpl <em>Is Source Constraint Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.IsSourceConstraintRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getIsSourceConstraintRule()
	 * @generated
	 */
	int IS_SOURCE_CONSTRAINT_RULE = 10;

	/**
	 * The feature id for the '<em><b>Rule2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_SOURCE_CONSTRAINT_RULE__RULE2 = ABSTRACT_CONSTRAINT_RULE__RULE2;

	/**
	 * The feature id for the '<em><b>Rule1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_SOURCE_CONSTRAINT_RULE__RULE1 = ABSTRACT_CONSTRAINT_RULE__RULE1;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_SOURCE_CONSTRAINT_RULE__ARGUMENT = ABSTRACT_CONSTRAINT_RULE__ARGUMENT;

	/**
	 * The number of structural features of the '<em>Is Source Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_SOURCE_CONSTRAINT_RULE_FEATURE_COUNT = ABSTRACT_CONSTRAINT_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Is Source Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_SOURCE_CONSTRAINT_RULE_OPERATION_COUNT = ABSTRACT_CONSTRAINT_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.IsParentConstraintRuleImpl <em>Is Parent Constraint Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.IsParentConstraintRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getIsParentConstraintRule()
	 * @generated
	 */
	int IS_PARENT_CONSTRAINT_RULE = 11;

	/**
	 * The feature id for the '<em><b>Rule2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_PARENT_CONSTRAINT_RULE__RULE2 = ABSTRACT_CONSTRAINT_RULE__RULE2;

	/**
	 * The feature id for the '<em><b>Rule1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_PARENT_CONSTRAINT_RULE__RULE1 = ABSTRACT_CONSTRAINT_RULE__RULE1;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_PARENT_CONSTRAINT_RULE__ARGUMENT = ABSTRACT_CONSTRAINT_RULE__ARGUMENT;

	/**
	 * The number of structural features of the '<em>Is Parent Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_PARENT_CONSTRAINT_RULE_FEATURE_COUNT = ABSTRACT_CONSTRAINT_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Is Parent Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_PARENT_CONSTRAINT_RULE_OPERATION_COUNT = ABSTRACT_CONSTRAINT_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.AndFeatureRuleImpl <em>And Feature Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.AndFeatureRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getAndFeatureRule()
	 * @generated
	 */
	int AND_FEATURE_RULE = 12;

	/**
	 * The feature id for the '<em><b>Rule2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_FEATURE_RULE__RULE2 = ABSTRACT_FEATURE_RULE__RULE2;

	/**
	 * The feature id for the '<em><b>Rule1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_FEATURE_RULE__RULE1 = ABSTRACT_FEATURE_RULE__RULE1;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_FEATURE_RULE__ARGUMENT = ABSTRACT_FEATURE_RULE__ARGUMENT;

	/**
	 * The number of structural features of the '<em>And Feature Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_FEATURE_RULE_FEATURE_COUNT = ABSTRACT_FEATURE_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>And Feature Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_FEATURE_RULE_OPERATION_COUNT = ABSTRACT_FEATURE_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.OrFeatureRuleImpl <em>Or Feature Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.OrFeatureRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getOrFeatureRule()
	 * @generated
	 */
	int OR_FEATURE_RULE = 13;

	/**
	 * The feature id for the '<em><b>Rule2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_FEATURE_RULE__RULE2 = ABSTRACT_FEATURE_RULE__RULE2;

	/**
	 * The feature id for the '<em><b>Rule1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_FEATURE_RULE__RULE1 = ABSTRACT_FEATURE_RULE__RULE1;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_FEATURE_RULE__ARGUMENT = ABSTRACT_FEATURE_RULE__ARGUMENT;

	/**
	 * The number of structural features of the '<em>Or Feature Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_FEATURE_RULE_FEATURE_COUNT = ABSTRACT_FEATURE_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Or Feature Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_FEATURE_RULE_OPERATION_COUNT = ABSTRACT_FEATURE_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.NotFeatureRuleImpl <em>Not Feature Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.NotFeatureRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getNotFeatureRule()
	 * @generated
	 */
	int NOT_FEATURE_RULE = 14;

	/**
	 * The feature id for the '<em><b>Rule2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_FEATURE_RULE__RULE2 = ABSTRACT_FEATURE_RULE__RULE2;

	/**
	 * The feature id for the '<em><b>Rule1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_FEATURE_RULE__RULE1 = ABSTRACT_FEATURE_RULE__RULE1;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_FEATURE_RULE__ARGUMENT = ABSTRACT_FEATURE_RULE__ARGUMENT;

	/**
	 * The number of structural features of the '<em>Not Feature Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_FEATURE_RULE_FEATURE_COUNT = ABSTRACT_FEATURE_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Not Feature Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_FEATURE_RULE_OPERATION_COUNT = ABSTRACT_FEATURE_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.TrueFeatureRuleImpl <em>True Feature Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.TrueFeatureRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getTrueFeatureRule()
	 * @generated
	 */
	int TRUE_FEATURE_RULE = 15;

	/**
	 * The feature id for the '<em><b>Rule2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_FEATURE_RULE__RULE2 = ABSTRACT_FEATURE_RULE__RULE2;

	/**
	 * The feature id for the '<em><b>Rule1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_FEATURE_RULE__RULE1 = ABSTRACT_FEATURE_RULE__RULE1;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_FEATURE_RULE__ARGUMENT = ABSTRACT_FEATURE_RULE__ARGUMENT;

	/**
	 * The number of structural features of the '<em>True Feature Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_FEATURE_RULE_FEATURE_COUNT = ABSTRACT_FEATURE_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>True Feature Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_FEATURE_RULE_OPERATION_COUNT = ABSTRACT_FEATURE_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.FalseFeatureRuleImpl <em>False Feature Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.FalseFeatureRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getFalseFeatureRule()
	 * @generated
	 */
	int FALSE_FEATURE_RULE = 16;

	/**
	 * The feature id for the '<em><b>Rule2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE_FEATURE_RULE__RULE2 = ABSTRACT_FEATURE_RULE__RULE2;

	/**
	 * The feature id for the '<em><b>Rule1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE_FEATURE_RULE__RULE1 = ABSTRACT_FEATURE_RULE__RULE1;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE_FEATURE_RULE__ARGUMENT = ABSTRACT_FEATURE_RULE__ARGUMENT;

	/**
	 * The number of structural features of the '<em>False Feature Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE_FEATURE_RULE_FEATURE_COUNT = ABSTRACT_FEATURE_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>False Feature Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE_FEATURE_RULE_OPERATION_COUNT = ABSTRACT_FEATURE_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.TrueConstraintRuleImpl <em>True Constraint Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.TrueConstraintRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getTrueConstraintRule()
	 * @generated
	 */
	int TRUE_CONSTRAINT_RULE = 17;

	/**
	 * The feature id for the '<em><b>Rule2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_CONSTRAINT_RULE__RULE2 = ABSTRACT_CONSTRAINT_RULE__RULE2;

	/**
	 * The feature id for the '<em><b>Rule1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_CONSTRAINT_RULE__RULE1 = ABSTRACT_CONSTRAINT_RULE__RULE1;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_CONSTRAINT_RULE__ARGUMENT = ABSTRACT_CONSTRAINT_RULE__ARGUMENT;

	/**
	 * The number of structural features of the '<em>True Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_CONSTRAINT_RULE_FEATURE_COUNT = ABSTRACT_CONSTRAINT_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>True Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_CONSTRAINT_RULE_OPERATION_COUNT = ABSTRACT_CONSTRAINT_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.impl.FalseConstraintRuleImpl <em>False Constraint Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.impl.FalseConstraintRuleImpl
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getFalseConstraintRule()
	 * @generated
	 */
	int FALSE_CONSTRAINT_RULE = 18;

	/**
	 * The feature id for the '<em><b>Rule2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE_CONSTRAINT_RULE__RULE2 = ABSTRACT_CONSTRAINT_RULE__RULE2;

	/**
	 * The feature id for the '<em><b>Rule1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE_CONSTRAINT_RULE__RULE1 = ABSTRACT_CONSTRAINT_RULE__RULE1;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE_CONSTRAINT_RULE__ARGUMENT = ABSTRACT_CONSTRAINT_RULE__ARGUMENT;

	/**
	 * The number of structural features of the '<em>False Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE_CONSTRAINT_RULE_FEATURE_COUNT = ABSTRACT_CONSTRAINT_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>False Constraint Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE_CONSTRAINT_RULE_OPERATION_COUNT = ABSTRACT_CONSTRAINT_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Editpolicymodel.ActionEnum <em>Action Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.ActionEnum
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getActionEnum()
	 * @generated
	 */
	int ACTION_ENUM = 19;

	/**
	 * The meta object id for the '{@link Editpolicymodel.ActionTypeEnum <em>Action Type Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Editpolicymodel.ActionTypeEnum
	 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getActionTypeEnum()
	 * @generated
	 */
	int ACTION_TYPE_ENUM = 20;


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
	 * Returns the meta object for the containment reference list '{@link Editpolicymodel.Model#getPolicy <em>Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Policy</em>'.
	 * @see Editpolicymodel.Model#getPolicy()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Policy();

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
	 * Returns the meta object for class '{@link Editpolicymodel.AbstractConstraintRule <em>Abstract Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Constraint Rule</em>'.
	 * @see Editpolicymodel.AbstractConstraintRule
	 * @generated
	 */
	EClass getAbstractConstraintRule();

	/**
	 * Returns the meta object for the reference '{@link Editpolicymodel.AbstractConstraintRule#getRule2 <em>Rule2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rule2</em>'.
	 * @see Editpolicymodel.AbstractConstraintRule#getRule2()
	 * @see #getAbstractConstraintRule()
	 * @generated
	 */
	EReference getAbstractConstraintRule_Rule2();

	/**
	 * Returns the meta object for the reference '{@link Editpolicymodel.AbstractConstraintRule#getRule1 <em>Rule1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rule1</em>'.
	 * @see Editpolicymodel.AbstractConstraintRule#getRule1()
	 * @see #getAbstractConstraintRule()
	 * @generated
	 */
	EReference getAbstractConstraintRule_Rule1();

	/**
	 * Returns the meta object for the attribute '{@link Editpolicymodel.AbstractConstraintRule#getArgument <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Argument</em>'.
	 * @see Editpolicymodel.AbstractConstraintRule#getArgument()
	 * @see #getAbstractConstraintRule()
	 * @generated
	 */
	EAttribute getAbstractConstraintRule_Argument();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.AbstractFeatureRule <em>Abstract Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Feature Rule</em>'.
	 * @see Editpolicymodel.AbstractFeatureRule
	 * @generated
	 */
	EClass getAbstractFeatureRule();

	/**
	 * Returns the meta object for the reference '{@link Editpolicymodel.AbstractFeatureRule#getRule2 <em>Rule2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rule2</em>'.
	 * @see Editpolicymodel.AbstractFeatureRule#getRule2()
	 * @see #getAbstractFeatureRule()
	 * @generated
	 */
	EReference getAbstractFeatureRule_Rule2();

	/**
	 * Returns the meta object for the reference '{@link Editpolicymodel.AbstractFeatureRule#getRule1 <em>Rule1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rule1</em>'.
	 * @see Editpolicymodel.AbstractFeatureRule#getRule1()
	 * @see #getAbstractFeatureRule()
	 * @generated
	 */
	EReference getAbstractFeatureRule_Rule1();

	/**
	 * Returns the meta object for the attribute '{@link Editpolicymodel.AbstractFeatureRule#getArgument <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Argument</em>'.
	 * @see Editpolicymodel.AbstractFeatureRule#getArgument()
	 * @see #getAbstractFeatureRule()
	 * @generated
	 */
	EAttribute getAbstractFeatureRule_Argument();

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
	 * Returns the meta object for class '{@link Editpolicymodel.OrConstraintRule <em>Or Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or Constraint Rule</em>'.
	 * @see Editpolicymodel.OrConstraintRule
	 * @generated
	 */
	EClass getOrConstraintRule();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.ContainsConstraintRule <em>Contains Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contains Constraint Rule</em>'.
	 * @see Editpolicymodel.ContainsConstraintRule
	 * @generated
	 */
	EClass getContainsConstraintRule();

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
	 * Returns the meta object for class '{@link Editpolicymodel.IsStepOutConstraintRule <em>Is Step Out Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Is Step Out Constraint Rule</em>'.
	 * @see Editpolicymodel.IsStepOutConstraintRule
	 * @generated
	 */
	EClass getIsStepOutConstraintRule();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.IsTargetConstraintRule <em>Is Target Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Is Target Constraint Rule</em>'.
	 * @see Editpolicymodel.IsTargetConstraintRule
	 * @generated
	 */
	EClass getIsTargetConstraintRule();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.IsSourceConstraintRule <em>Is Source Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Is Source Constraint Rule</em>'.
	 * @see Editpolicymodel.IsSourceConstraintRule
	 * @generated
	 */
	EClass getIsSourceConstraintRule();

	/**
	 * Returns the meta object for class '{@link Editpolicymodel.IsParentConstraintRule <em>Is Parent Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Is Parent Constraint Rule</em>'.
	 * @see Editpolicymodel.IsParentConstraintRule
	 * @generated
	 */
	EClass getIsParentConstraintRule();

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
	 * Returns the meta object for class '{@link Editpolicymodel.OrFeatureRule <em>Or Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or Feature Rule</em>'.
	 * @see Editpolicymodel.OrFeatureRule
	 * @generated
	 */
	EClass getOrFeatureRule();

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
	 * Returns the meta object for class '{@link Editpolicymodel.TrueFeatureRule <em>True Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>True Feature Rule</em>'.
	 * @see Editpolicymodel.TrueFeatureRule
	 * @generated
	 */
	EClass getTrueFeatureRule();

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
	 * Returns the meta object for enum '{@link Editpolicymodel.ActionEnum <em>Action Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Action Enum</em>'.
	 * @see Editpolicymodel.ActionEnum
	 * @generated
	 */
	EEnum getActionEnum();

	/**
	 * Returns the meta object for enum '{@link Editpolicymodel.ActionTypeEnum <em>Action Type Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Action Type Enum</em>'.
	 * @see Editpolicymodel.ActionTypeEnum
	 * @generated
	 */
	EEnum getActionTypeEnum();

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
		 * The meta object literal for the '<em><b>Policy</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__POLICY = eINSTANCE.getModel_Policy();

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
		 * The meta object literal for the '<em><b>Constraint Rule</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POLICY__CONSTRAINT_RULE = eINSTANCE.getPolicy_ConstraintRule();

		/**
		 * The meta object literal for the '<em><b>Feature Rule</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POLICY__FEATURE_RULE = eINSTANCE.getPolicy_FeatureRule();

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
		 * The meta object literal for the '{@link Editpolicymodel.impl.AbstractConstraintRuleImpl <em>Abstract Constraint Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.AbstractConstraintRuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getAbstractConstraintRule()
		 * @generated
		 */
		EClass ABSTRACT_CONSTRAINT_RULE = eINSTANCE.getAbstractConstraintRule();

		/**
		 * The meta object literal for the '<em><b>Rule2</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_CONSTRAINT_RULE__RULE2 = eINSTANCE.getAbstractConstraintRule_Rule2();

		/**
		 * The meta object literal for the '<em><b>Rule1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_CONSTRAINT_RULE__RULE1 = eINSTANCE.getAbstractConstraintRule_Rule1();

		/**
		 * The meta object literal for the '<em><b>Argument</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_CONSTRAINT_RULE__ARGUMENT = eINSTANCE.getAbstractConstraintRule_Argument();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.AbstractFeatureRuleImpl <em>Abstract Feature Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.AbstractFeatureRuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getAbstractFeatureRule()
		 * @generated
		 */
		EClass ABSTRACT_FEATURE_RULE = eINSTANCE.getAbstractFeatureRule();

		/**
		 * The meta object literal for the '<em><b>Rule2</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_FEATURE_RULE__RULE2 = eINSTANCE.getAbstractFeatureRule_Rule2();

		/**
		 * The meta object literal for the '<em><b>Rule1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_FEATURE_RULE__RULE1 = eINSTANCE.getAbstractFeatureRule_Rule1();

		/**
		 * The meta object literal for the '<em><b>Argument</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_FEATURE_RULE__ARGUMENT = eINSTANCE.getAbstractFeatureRule_Argument();

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
		 * The meta object literal for the '{@link Editpolicymodel.impl.OrConstraintRuleImpl <em>Or Constraint Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.OrConstraintRuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getOrConstraintRule()
		 * @generated
		 */
		EClass OR_CONSTRAINT_RULE = eINSTANCE.getOrConstraintRule();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.ContainsConstraintRuleImpl <em>Contains Constraint Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.ContainsConstraintRuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getContainsConstraintRule()
		 * @generated
		 */
		EClass CONTAINS_CONSTRAINT_RULE = eINSTANCE.getContainsConstraintRule();

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
		 * The meta object literal for the '{@link Editpolicymodel.impl.IsStepOutConstraintRuleImpl <em>Is Step Out Constraint Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.IsStepOutConstraintRuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getIsStepOutConstraintRule()
		 * @generated
		 */
		EClass IS_STEP_OUT_CONSTRAINT_RULE = eINSTANCE.getIsStepOutConstraintRule();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.IsTargetConstraintRuleImpl <em>Is Target Constraint Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.IsTargetConstraintRuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getIsTargetConstraintRule()
		 * @generated
		 */
		EClass IS_TARGET_CONSTRAINT_RULE = eINSTANCE.getIsTargetConstraintRule();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.IsSourceConstraintRuleImpl <em>Is Source Constraint Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.IsSourceConstraintRuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getIsSourceConstraintRule()
		 * @generated
		 */
		EClass IS_SOURCE_CONSTRAINT_RULE = eINSTANCE.getIsSourceConstraintRule();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.impl.IsParentConstraintRuleImpl <em>Is Parent Constraint Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.IsParentConstraintRuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getIsParentConstraintRule()
		 * @generated
		 */
		EClass IS_PARENT_CONSTRAINT_RULE = eINSTANCE.getIsParentConstraintRule();

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
		 * The meta object literal for the '{@link Editpolicymodel.impl.OrFeatureRuleImpl <em>Or Feature Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.OrFeatureRuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getOrFeatureRule()
		 * @generated
		 */
		EClass OR_FEATURE_RULE = eINSTANCE.getOrFeatureRule();

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
		 * The meta object literal for the '{@link Editpolicymodel.impl.TrueFeatureRuleImpl <em>True Feature Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.impl.TrueFeatureRuleImpl
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getTrueFeatureRule()
		 * @generated
		 */
		EClass TRUE_FEATURE_RULE = eINSTANCE.getTrueFeatureRule();

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
		 * The meta object literal for the '{@link Editpolicymodel.ActionEnum <em>Action Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.ActionEnum
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getActionEnum()
		 * @generated
		 */
		EEnum ACTION_ENUM = eINSTANCE.getActionEnum();

		/**
		 * The meta object literal for the '{@link Editpolicymodel.ActionTypeEnum <em>Action Type Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Editpolicymodel.ActionTypeEnum
		 * @see Editpolicymodel.impl.EditpolicymodelPackageImpl#getActionTypeEnum()
		 * @generated
		 */
		EEnum ACTION_TYPE_ENUM = eINSTANCE.getActionTypeEnum();

	}

} //EditpolicymodelPackage
