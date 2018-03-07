/**
 */
package Editpolicymodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unary Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Editpolicymodel.UnaryRule#getRule <em>Rule</em>}</li>
 * </ul>
 *
 * @see Editpolicymodel.EditpolicymodelPackage#getUnaryRule()
 * @model abstract="true"
 * @generated
 */
public interface UnaryRule<T> extends AbstractRule<T> {
	/**
	 * Returns the value of the '<em><b>Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule</em>' containment reference.
	 * @see #setRule(Object)
	 * @see Editpolicymodel.EditpolicymodelPackage#getUnaryRule_Rule()
	 * @model kind="reference" containment="true"
	 * @generated
	 */
	T getRule();

	/**
	 * Sets the value of the '{@link Editpolicymodel.UnaryRule#getRule <em>Rule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule</em>' containment reference.
	 * @see #getRule()
	 * @generated
	 */
	void setRule(T value);

} // UnaryRule
