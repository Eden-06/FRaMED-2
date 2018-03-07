/**
 */
package Editpolicymodel.impl;

import Editpolicymodel.EditpolicymodelPackage;
import Editpolicymodel.ImplicationRule;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Implication Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ImplicationRuleImpl<T> extends BinaryRuleImpl<T> implements ImplicationRule<T> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImplicationRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EditpolicymodelPackage.Literals.IMPLICATION_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific type known in this context.
	 * @generated
	 */
	@Override
	public NotificationChain basicSetRightRule(T newRightRule, NotificationChain msgs) {
		return super.basicSetRightRule(newRightRule, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific type known in this context.
	 * @generated
	 */
	@Override
	public NotificationChain basicSetLeftRule(T newLeftRule, NotificationChain msgs) {
		return super.basicSetLeftRule(newLeftRule, msgs);
	}

} //ImplicationRuleImpl
