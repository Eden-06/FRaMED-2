/**
 */
package Editpolicymodel;

import org.framed.iorm.model.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Argument Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Editpolicymodel.TypeArgumentRule#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see Editpolicymodel.EditpolicymodelPackage#getTypeArgumentRule()
 * @model abstract="true"
 * @generated
 */
public interface TypeArgumentRule extends ConstraintRule {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.framed.iorm.model.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.framed.iorm.model.Type
	 * @see #setType(Type)
	 * @see Editpolicymodel.EditpolicymodelPackage#getTypeArgumentRule_Type()
	 * @model
	 * @generated
	 */
	Type getType();

	/**
	 * Sets the value of the '{@link Editpolicymodel.TypeArgumentRule#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.framed.iorm.model.Type
	 * @see #getType()
	 * @generated
	 */
	void setType(Type value);

} // TypeArgumentRule
