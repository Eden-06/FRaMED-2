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
	 * Returns a new object of class '<em>Is Step Out</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Is Step Out</em>'.
	 * @generated
	 */
	IsStepOut createIsStepOut();

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
	 * Returns a new object of class '<em>True Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>True Rule</em>'.
	 * @generated
	 */
	TrueRule createTrueRule();

	/**
	 * Returns a new object of class '<em>False Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>False Rule</em>'.
	 * @generated
	 */
	FalseRule createFalseRule();

	/**
	 * Returns a new object of class '<em>Or Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Or Rule</em>'.
	 * @generated
	 */
	OrRule createOrRule();

	/**
	 * Returns a new object of class '<em>Implication Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Implication Rule</em>'.
	 * @generated
	 */
	ImplicationRule createImplicationRule();

	/**
	 * Returns a new object of class '<em>Is Source Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Is Source Type</em>'.
	 * @generated
	 */
	IsSourceType createIsSourceType();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EditpolicymodelPackage getEditpolicymodelPackage();

} //EditpolicymodelFactory
