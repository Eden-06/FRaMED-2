/**
 */
package Editpolicymodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Editpolicymodel.BinaryRule#getRightRule <em>Right Rule</em>}</li>
 *   <li>{@link Editpolicymodel.BinaryRule#getLeftRule <em>Left Rule</em>}</li>
 * </ul>
 *
 * @see Editpolicymodel.EditpolicymodelPackage#getBinaryRule()
 * @model abstract="true"
 * @generated
 */
public interface BinaryRule<T> extends AbstractRule<T> {
	/**
	 * Returns the value of the '<em><b>Right Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right Rule</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Rule</em>' containment reference.
	 * @see #setRightRule(Object)
	 * @see Editpolicymodel.EditpolicymodelPackage#getBinaryRule_RightRule()
	 * @model kind="reference" containment="true"
	 * @generated
	 */
	T getRightRule();

	/**
	 * Sets the value of the '{@link Editpolicymodel.BinaryRule#getRightRule <em>Right Rule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Rule</em>' containment reference.
	 * @see #getRightRule()
	 * @generated
	 */
	void setRightRule(T value);

	/**
	 * Returns the value of the '<em><b>Left Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left Rule</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Rule</em>' containment reference.
	 * @see #setLeftRule(Object)
	 * @see Editpolicymodel.EditpolicymodelPackage#getBinaryRule_LeftRule()
	 * @model kind="reference" containment="true"
	 * @generated
	 */
	T getLeftRule();

	/**
	 * Sets the value of the '{@link Editpolicymodel.BinaryRule#getLeftRule <em>Left Rule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Rule</em>' containment reference.
	 * @see #getLeftRule()
	 * @generated
	 */
	void setLeftRule(T value);

} // BinaryRule
