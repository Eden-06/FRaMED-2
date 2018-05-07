/**
 */
package Editpolicymodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Constraint Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Editpolicymodel.BinaryConstraintRule#getLeftRule <em>Left Rule</em>}</li>
 *   <li>{@link Editpolicymodel.BinaryConstraintRule#getRightRule <em>Right Rule</em>}</li>
 * </ul>
 *
 * @see Editpolicymodel.EditpolicymodelPackage#getBinaryConstraintRule()
 * @model abstract="true"
 * @generated
 */
public interface BinaryConstraintRule extends LogicalConstraintRule {
	/**
	 * Returns the value of the '<em><b>Left Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left Rule</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Rule</em>' containment reference.
	 * @see #setLeftRule(ConstraintRule)
	 * @see Editpolicymodel.EditpolicymodelPackage#getBinaryConstraintRule_LeftRule()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ConstraintRule getLeftRule();

	/**
	 * Sets the value of the '{@link Editpolicymodel.BinaryConstraintRule#getLeftRule <em>Left Rule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Rule</em>' containment reference.
	 * @see #getLeftRule()
	 * @generated
	 */
	void setLeftRule(ConstraintRule value);

	/**
	 * Returns the value of the '<em><b>Right Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right Rule</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Rule</em>' containment reference.
	 * @see #setRightRule(ConstraintRule)
	 * @see Editpolicymodel.EditpolicymodelPackage#getBinaryConstraintRule_RightRule()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ConstraintRule getRightRule();

	/**
	 * Sets the value of the '{@link Editpolicymodel.BinaryConstraintRule#getRightRule <em>Right Rule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Rule</em>' containment reference.
	 * @see #getRightRule()
	 * @generated
	 */
	void setRightRule(ConstraintRule value);

} // BinaryConstraintRule
