/**
 */
package editpolicymodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Argument Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link editpolicymodel.TypeArgumentRule#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see editpolicymodel.editpolicymodelPackage#getTypeArgumentRule()
 * @model abstract="true"
 * @generated
 */
public interface TypeArgumentRule extends ConstraintRule {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link editpolicymodel.TypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see editpolicymodel.TypeEnum
	 * @see #setType(TypeEnum)
	 * @see editpolicymodel.editpolicymodelPackage#getTypeArgumentRule_Type()
	 * @model
	 * @generated
	 */
	TypeEnum getType();

	/**
	 * Sets the value of the '{@link editpolicymodel.TypeArgumentRule#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see editpolicymodel.TypeEnum
	 * @see #getType()
	 * @generated
	 */
	void setType(TypeEnum value);

} // TypeArgumentRule
