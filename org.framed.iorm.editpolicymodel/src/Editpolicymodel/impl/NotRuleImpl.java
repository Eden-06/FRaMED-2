/**
 */
package Editpolicymodel.impl;

import Editpolicymodel.EditpolicymodelPackage;
import Editpolicymodel.NotRule;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Not Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class NotRuleImpl<T> extends UnaryRuleImpl<T> implements NotRule<T> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NotRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EditpolicymodelPackage.Literals.NOT_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific type known in this context.
	 * @generated
	 */
	@Override
	public NotificationChain basicSetRule(T newRule, NotificationChain msgs) {
		return super.basicSetRule(newRule, msgs);
	}

} //NotRuleImpl
