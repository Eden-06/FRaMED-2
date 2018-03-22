/**
 */
package Editpolicymodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Nary Feature Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Editpolicymodel.NaryFeatureRule#getRules <em>Rules</em>}</li>
 * </ul>
 *
 * @see Editpolicymodel.EditpolicymodelPackage#getNaryFeatureRule()
 * @model abstract="true"
 * @generated
 */
public interface NaryFeatureRule extends LogicalFeatureRule {
	/**
	 * Returns the value of the '<em><b>Rules</b></em>' containment reference list.
	 * The list contents are of type {@link Editpolicymodel.FeatureRule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rules</em>' containment reference list.
	 * @see Editpolicymodel.EditpolicymodelPackage#getNaryFeatureRule_Rules()
	 * @model containment="true"
	 * @generated
	 */
	EList<FeatureRule> getRules();

} // NaryFeatureRule
