/**
 */
package Editpolicymodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Nary Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Editpolicymodel.NaryRule#getRules <em>Rules</em>}</li>
 * </ul>
 *
 * @see Editpolicymodel.EditpolicymodelPackage#getNaryRule()
 * @model abstract="true"
 * @generated
 */
public interface NaryRule<T> extends AbstractRule {
	/**
	 * Returns the value of the '<em><b>Rules</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rules</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rules</em>' containment reference.
	 * @see #setRules(AbstractRule)
	 * @see Editpolicymodel.EditpolicymodelPackage#getNaryRule_Rules()
	 * @model containment="true"
	 * @generated
	 */
	AbstractRule<T> getRules();

	/**
	 * Sets the value of the '{@link Editpolicymodel.NaryRule#getRules <em>Rules</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rules</em>' containment reference.
	 * @see #getRules()
	 * @generated
	 */
	void setRules(AbstractRule<T> value);

} // NaryRule
