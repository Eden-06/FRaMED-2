/**
 */
package Editpolicymodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see Editpolicymodel.EditpolicymodelPackage
 * @generated
 */
public interface EditpolicymodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EditpolicymodelFactory eINSTANCE = Editpolicymodel.impl.EditpolicymodelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model</em>'.
	 * @generated
	 */
	Model createModel();

	/**
	 * Returns a new object of class '<em>Policy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Policy</em>'.
	 * @generated
	 */
	Policy createPolicy();

	/**
	 * Returns a new object of class '<em>Contains</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Contains</em>'.
	 * @generated
	 */
	Contains createContains();

	/**
	 * Returns a new object of class '<em>Is Step In</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Is Step In</em>'.
	 * @generated
	 */
	IsStepIn createIsStepIn();

	/**
	 * Returns a new object of class '<em>Is Target</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Is Target</em>'.
	 * @generated
	 */
	IsTarget createIsTarget();

	/**
	 * Returns a new object of class '<em>Is Source</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Is Source</em>'.
	 * @generated
	 */
	IsSource createIsSource();

	/**
	 * Returns a new object of class '<em>Is Parent</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Is Parent</em>'.
	 * @generated
	 */
	IsParent createIsParent();

	/**
	 * Returns a new object of class '<em>Is Feature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Is Feature</em>'.
	 * @generated
	 */
	IsFeature createIsFeature();

	/**
	 * Returns a new object of class '<em>Is Target Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Is Target Type</em>'.
	 * @generated
	 */
	IsTargetType createIsTargetType();

	/**
	 * Returns a new object of class '<em>Not Constraint Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Not Constraint Rule</em>'.
	 * @generated
	 */
	NotConstraintRule createNotConstraintRule();

	/**
	 * Returns a new object of class '<em>And Constraint Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>And Constraint Rule</em>'.
	 * @generated
	 */
	AndConstraintRule createAndConstraintRule();

	/**
	 * Returns a new object of class '<em>True Constraint Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>True Constraint Rule</em>'.
	 * @generated
	 */
	TrueConstraintRule createTrueConstraintRule();

	/**
	 * Returns a new object of class '<em>False Constraint Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>False Constraint Rule</em>'.
	 * @generated
	 */
	FalseConstraintRule createFalseConstraintRule();

	/**
	 * Returns a new object of class '<em>Or Constraint Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Or Constraint Rule</em>'.
	 * @generated
	 */
	OrConstraintRule createOrConstraintRule();

	/**
	 * Returns a new object of class '<em>Implication Constraint Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Implication Constraint Rule</em>'.
	 * @generated
	 */
	ImplicationConstraintRule createImplicationConstraintRule();

	/**
	 * Returns a new object of class '<em>Is Source Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Is Source Type</em>'.
	 * @generated
	 */
	IsSourceType createIsSourceType();

	/**
	 * Returns a new object of class '<em>Logical Constraint Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Logical Constraint Rule</em>'.
	 * @generated
	 */
	LogicalConstraintRule createLogicalConstraintRule();

	/**
	 * Returns a new object of class '<em>True Feature Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>True Feature Rule</em>'.
	 * @generated
	 */
	TrueFeatureRule createTrueFeatureRule();

	/**
	 * Returns a new object of class '<em>Not Feature Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Not Feature Rule</em>'.
	 * @generated
	 */
	NotFeatureRule createNotFeatureRule();

	/**
	 * Returns a new object of class '<em>False Feature Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>False Feature Rule</em>'.
	 * @generated
	 */
	FalseFeatureRule createFalseFeatureRule();

	/**
	 * Returns a new object of class '<em>Logical Feature Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Logical Feature Rule</em>'.
	 * @generated
	 */
	LogicalFeatureRule createLogicalFeatureRule();

	/**
	 * Returns a new object of class '<em>Implication Feature Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Implication Feature Rule</em>'.
	 * @generated
	 */
	ImplicationFeatureRule createImplicationFeatureRule();

	/**
	 * Returns a new object of class '<em>Or Feature Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Or Feature Rule</em>'.
	 * @generated
	 */
	OrFeatureRule createOrFeatureRule();

	/**
	 * Returns a new object of class '<em>And Feature Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>And Feature Rule</em>'.
	 * @generated
	 */
	AndFeatureRule createAndFeatureRule();

	/**
	 * Returns a new object of class '<em>Source Equals Target</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Source Equals Target</em>'.
	 * @generated
	 */
	SourceEqualsTarget createSourceEqualsTarget();

	/**
	 * Returns a new object of class '<em>Source Equals Target Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Source Equals Target Type</em>'.
	 * @generated
	 */
	SourceEqualsTargetType createSourceEqualsTargetType();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EditpolicymodelPackage getEditpolicymodelPackage();

} //EditpolicymodelFactory
