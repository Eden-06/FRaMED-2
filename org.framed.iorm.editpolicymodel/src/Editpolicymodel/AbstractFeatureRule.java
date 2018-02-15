/**
 */
package Editpolicymodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Feature Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Editpolicymodel.AbstractFeatureRule#getRule2 <em>Rule2</em>}</li>
 *   <li>{@link Editpolicymodel.AbstractFeatureRule#getRule1 <em>Rule1</em>}</li>
 *   <li>{@link Editpolicymodel.AbstractFeatureRule#getArgument <em>Argument</em>}</li>
 * </ul>
 *
 * @see Editpolicymodel.EditpolicymodelPackage#getAbstractFeatureRule()
 * @model abstract="true"
 * @generated
 */
public interface AbstractFeatureRule extends EObject {
	/**
	 * Returns the value of the '<em><b>Rule2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule2</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule2</em>' reference.
	 * @see #setRule2(AbstractFeatureRule)
	 * @see Editpolicymodel.EditpolicymodelPackage#getAbstractFeatureRule_Rule2()
	 * @model
	 * @generated
	 */
	AbstractFeatureRule getRule2();

	/**
	 * Sets the value of the '{@link Editpolicymodel.AbstractFeatureRule#getRule2 <em>Rule2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule2</em>' reference.
	 * @see #getRule2()
	 * @generated
	 */
	void setRule2(AbstractFeatureRule value);

	/**
	 * Returns the value of the '<em><b>Rule1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule1</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule1</em>' reference.
	 * @see #setRule1(AbstractFeatureRule)
	 * @see Editpolicymodel.EditpolicymodelPackage#getAbstractFeatureRule_Rule1()
	 * @model
	 * @generated
	 */
	AbstractFeatureRule getRule1();

	/**
	 * Sets the value of the '{@link Editpolicymodel.AbstractFeatureRule#getRule1 <em>Rule1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule1</em>' reference.
	 * @see #getRule1()
	 * @generated
	 */
	void setRule1(AbstractFeatureRule value);

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
	 * @see Editpolicymodel.EditpolicymodelPackage#getAbstractFeatureRule_Argument()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 * @generated
	 */
	String getArgument();

	/**
	 * Sets the value of the '{@link Editpolicymodel.AbstractFeatureRule#getArgument <em>Argument</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Argument</em>' attribute.
	 * @see #getArgument()
	 * @generated
	 */
	void setArgument(String value);

} // AbstractFeatureRule
