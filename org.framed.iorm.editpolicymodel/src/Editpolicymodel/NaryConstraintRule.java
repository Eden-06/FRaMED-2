/**
 */
package Editpolicymodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Nary Constraint Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Editpolicymodel.NaryConstraintRule#getRules <em>Rules</em>}</li>
 * </ul>
 *
 * @see Editpolicymodel.EditpolicymodelPackage#getNaryConstraintRule()
 * @model abstract="true"
 * @generated
 */
public interface NaryConstraintRule extends LogicalConstraintRule {
	/**
	 * Returns the value of the '<em><b>Rules</b></em>' containment reference list.
	 * The list contents are of type {@link Editpolicymodel.ConstraintRule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rules</em>' containment reference list.
	 * @see Editpolicymodel.EditpolicymodelPackage#getNaryConstraintRule_Rules()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ConstraintRule> getRules();

} // NaryConstraintRule
