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
public interface BinaryRule<T> extends AbstractRule {
	/**
	 * Returns the value of the '<em><b>Right Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right Rule</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Rule</em>' containment reference.
	 * @see #setRightRule(AbstractRule)
	 * @see Editpolicymodel.EditpolicymodelPackage#getBinaryRule_RightRule()
	 * @model containment="true"
	 * @generated
	 */
	AbstractRule<T> getRightRule();

	/**
	 * Sets the value of the '{@link Editpolicymodel.BinaryRule#getRightRule <em>Right Rule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Rule</em>' containment reference.
	 * @see #getRightRule()
	 * @generated
	 */
	void setRightRule(AbstractRule<T> value);

	/**
	 * Returns the value of the '<em><b>Left Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left Rule</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Rule</em>' containment reference.
	 * @see #setLeftRule(AbstractRule)
	 * @see Editpolicymodel.EditpolicymodelPackage#getBinaryRule_LeftRule()
	 * @model containment="true"
	 * @generated
	 */
	AbstractRule<T> getLeftRule();

	/**
	 * Sets the value of the '{@link Editpolicymodel.BinaryRule#getLeftRule <em>Left Rule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Rule</em>' containment reference.
	 * @see #getLeftRule()
	 * @generated
	 */
	void setLeftRule(AbstractRule<T> value);

} // BinaryRule
