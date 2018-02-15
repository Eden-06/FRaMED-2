/**
 */
package Editpolicymodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Editpolicymodel.Model#getPolicy <em>Policy</em>}</li>
 * </ul>
 *
 * @see Editpolicymodel.EditpolicymodelPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject {
	/**
	 * Returns the value of the '<em><b>Policy</b></em>' containment reference list.
	 * The list contents are of type {@link Editpolicymodel.Policy}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Policy</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Policy</em>' containment reference list.
	 * @see Editpolicymodel.EditpolicymodelPackage#getModel_Policy()
	 * @model containment="true"
	 * @generated
	 */
	EList<Policy> getPolicy();

} // Model
