/**
 */
package Editpolicymodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Constraint Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Editpolicymodel.AbstractConstraintRule#getRule2 <em>Rule2</em>}</li>
 *   <li>{@link Editpolicymodel.AbstractConstraintRule#getRule1 <em>Rule1</em>}</li>
 *   <li>{@link Editpolicymodel.AbstractConstraintRule#getArgument <em>Argument</em>}</li>
 * </ul>
 *
 * @see Editpolicymodel.EditpolicymodelPackage#getAbstractConstraintRule()
 * @model abstract="true"
 * @generated
 */
public interface AbstractConstraintRule extends EObject {
	/**
	 * Returns the value of the '<em><b>Rule2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule2</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule2</em>' reference.
	 * @see #setRule2(AbstractConstraintRule)
	 * @see Editpolicymodel.EditpolicymodelPackage#getAbstractConstraintRule_Rule2()
	 * @model
	 * @generated
	 */
	AbstractConstraintRule getRule2();

	/**
	 * Sets the value of the '{@link Editpolicymodel.AbstractConstraintRule#getRule2 <em>Rule2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule2</em>' reference.
	 * @see #getRule2()
	 * @generated
	 */
	void setRule2(AbstractConstraintRule value);

	/**
	 * Returns the value of the '<em><b>Rule1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule1</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule1</em>' reference.
	 * @see #setRule1(AbstractConstraintRule)
	 * @see Editpolicymodel.EditpolicymodelPackage#getAbstractConstraintRule_Rule1()
	 * @model
	 * @generated
	 */
	AbstractConstraintRule getRule1();

	/**
	 * Sets the value of the '{@link Editpolicymodel.AbstractConstraintRule#getRule1 <em>Rule1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule1</em>' reference.
	 * @see #getRule1()
	 * @generated
	 */
	void setRule1(AbstractConstraintRule value);

	/**
	 * Returns the value of the '<em><b>Argument</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Argument</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Argument</em>' attribute.
	 * @see #setArgument(String)
	 * @see Editpolicymodel.EditpolicymodelPackage#getAbstractConstraintRule_Argument()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 * @generated
	 */
	String getArgument();

	/**
	 * Sets the value of the '{@link Editpolicymodel.AbstractConstraintRule#getArgument <em>Argument</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Argument</em>' attribute.
	 * @see #getArgument()
	 * @generated
	 */
	void setArgument(String value);

} // AbstractConstraintRule
