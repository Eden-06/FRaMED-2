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
	 * Returns a new object of class '<em>And Constraint Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>And Constraint Rule</em>'.
	 * @generated
	 */
	AndConstraintRule createAndConstraintRule();

	/**
	 * Returns a new object of class '<em>Or Constraint Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Or Constraint Rule</em>'.
	 * @generated
	 */
	OrConstraintRule createOrConstraintRule();

	/**
	 * Returns a new object of class '<em>Contains Constraint Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Contains Constraint Rule</em>'.
	 * @generated
	 */
	ContainsConstraintRule createContainsConstraintRule();

	/**
	 * Returns a new object of class '<em>Is Step Out Constraint Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Is Step Out Constraint Rule</em>'.
	 * @generated
	 */
	IsStepOutConstraintRule createIsStepOutConstraintRule();

	/**
	 * Returns a new object of class '<em>Is Target Constraint Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Is Target Constraint Rule</em>'.
	 * @generated
	 */
	IsTargetConstraintRule createIsTargetConstraintRule();

	/**
	 * Returns a new object of class '<em>Is Source Constraint Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Is Source Constraint Rule</em>'.
	 * @generated
	 */
	IsSourceConstraintRule createIsSourceConstraintRule();

	/**
	 * Returns a new object of class '<em>Is Parent Constraint Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Is Parent Constraint Rule</em>'.
	 * @generated
	 */
	IsParentConstraintRule createIsParentConstraintRule();

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
	 * Returns a new object of class '<em>Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rule</em>'.
	 * @generated
	 */
	<T> Rule<T> createRule();

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
	 * Returns a new object of class '<em>Not Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Not Rule</em>'.
	 * @generated
	 */
	NotRule createNotRule();

	/**
	 * Returns a new object of class '<em>And Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>And Rule</em>'.
	 * @generated
	 */
	AndRule createAndRule();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EditpolicymodelPackage getEditpolicymodelPackage();

} //EditpolicymodelFactory
