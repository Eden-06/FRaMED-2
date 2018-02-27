/**
 */
package Editpolicymodel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Policy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Editpolicymodel.Policy#getOverride <em>Override</em>}</li>
 *   <li>{@link Editpolicymodel.Policy#getAction <em>Action</em>}</li>
 *   <li>{@link Editpolicymodel.Policy#getActionType <em>Action Type</em>}</li>
 *   <li>{@link Editpolicymodel.Policy#getFeatureRule <em>Feature Rule</em>}</li>
 *   <li>{@link Editpolicymodel.Policy#getConstraintRule <em>Constraint Rule</em>}</li>
 * </ul>
 *
 * @see Editpolicymodel.EditpolicymodelPackage#getPolicy()
 * @model
 * @generated
 */
public interface Policy extends EObject {
	/**
	 * Returns the value of the '<em><b>Override</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Override</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Override</em>' attribute.
	 * @see #setOverride(Boolean)
	 * @see Editpolicymodel.EditpolicymodelPackage#getPolicy_Override()
	 * @model default="false"
	 * @generated
	 */
	Boolean getOverride();

	/**
	 * Sets the value of the '{@link Editpolicymodel.Policy#getOverride <em>Override</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Override</em>' attribute.
	 * @see #getOverride()
	 * @generated
	 */
	void setOverride(Boolean value);

	/**
	 * Returns the value of the '<em><b>Action</b></em>' attribute.
	 * The literals are from the enumeration {@link Editpolicymodel.ActionEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' attribute.
	 * @see Editpolicymodel.ActionEnum
	 * @see #setAction(ActionEnum)
	 * @see Editpolicymodel.EditpolicymodelPackage#getPolicy_Action()
	 * @model
	 * @generated
	 */
	ActionEnum getAction();

	/**
	 * Sets the value of the '{@link Editpolicymodel.Policy#getAction <em>Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' attribute.
	 * @see Editpolicymodel.ActionEnum
	 * @see #getAction()
	 * @generated
	 */
	void setAction(ActionEnum value);

	/**
	 * Returns the value of the '<em><b>Action Type</b></em>' attribute.
	 * The literals are from the enumeration {@link Editpolicymodel.ActionTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Type</em>' attribute.
	 * @see Editpolicymodel.ActionTypeEnum
	 * @see #setActionType(ActionTypeEnum)
	 * @see Editpolicymodel.EditpolicymodelPackage#getPolicy_ActionType()
	 * @model
	 * @generated
	 */
	ActionTypeEnum getActionType();

	/**
	 * Sets the value of the '{@link Editpolicymodel.Policy#getActionType <em>Action Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action Type</em>' attribute.
	 * @see Editpolicymodel.ActionTypeEnum
	 * @see #getActionType()
	 * @generated
	 */
	void setActionType(ActionTypeEnum value);

	/**
	 * Returns the value of the '<em><b>Feature Rule</b></em>' containment reference list.
	 * The list contents are of type {@link Editpolicymodel.AbstractRule}<code>&lt;Editpolicymodel.Feature&gt;</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Rule</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Rule</em>' containment reference list.
	 * @see Editpolicymodel.EditpolicymodelPackage#getPolicy_FeatureRule()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractRule<Feature>> getFeatureRule();

	/**
	 * Returns the value of the '<em><b>Constraint Rule</b></em>' containment reference list.
	 * The list contents are of type {@link Editpolicymodel.AbstractRule}<code>&lt;Editpolicymodel.Constraint&gt;</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Rule</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint Rule</em>' containment reference list.
	 * @see Editpolicymodel.EditpolicymodelPackage#getPolicy_ConstraintRule()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractRule<Constraint>> getConstraintRule();

} // Policy
