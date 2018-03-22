/**
 */
package Editpolicymodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Feature Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Editpolicymodel.BinaryFeatureRule#getRightRule <em>Right Rule</em>}</li>
 *   <li>{@link Editpolicymodel.BinaryFeatureRule#getLeftRule <em>Left Rule</em>}</li>
 * </ul>
 *
 * @see Editpolicymodel.EditpolicymodelPackage#getBinaryFeatureRule()
 * @model abstract="true"
 * @generated
 */
public interface BinaryFeatureRule extends LogicalFeatureRule {
	/**
	 * Returns the value of the '<em><b>Right Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right Rule</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Rule</em>' containment reference.
	 * @see #setRightRule(FeatureRule)
	 * @see Editpolicymodel.EditpolicymodelPackage#getBinaryFeatureRule_RightRule()
	 * @model containment="true" required="true"
	 * @generated
	 */
	FeatureRule getRightRule();

	/**
	 * Sets the value of the '{@link Editpolicymodel.BinaryFeatureRule#getRightRule <em>Right Rule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Rule</em>' containment reference.
	 * @see #getRightRule()
	 * @generated
	 */
	void setRightRule(FeatureRule value);

	/**
	 * Returns the value of the '<em><b>Left Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left Rule</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Rule</em>' containment reference.
	 * @see #setLeftRule(FeatureRule)
	 * @see Editpolicymodel.EditpolicymodelPackage#getBinaryFeatureRule_LeftRule()
	 * @model containment="true" required="true"
	 * @generated
	 */
	FeatureRule getLeftRule();

	/**
	 * Sets the value of the '{@link Editpolicymodel.BinaryFeatureRule#getLeftRule <em>Left Rule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Rule</em>' containment reference.
	 * @see #getLeftRule()
	 * @generated
	 */
	void setLeftRule(FeatureRule value);

} // BinaryFeatureRule
