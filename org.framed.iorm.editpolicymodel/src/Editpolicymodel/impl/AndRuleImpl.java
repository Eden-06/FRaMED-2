/**
 */
package Editpolicymodel.impl;

import Editpolicymodel.AndRule;
import Editpolicymodel.EditpolicymodelPackage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>And Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class AndRuleImpl<T> extends NaryRuleImpl<T> implements AndRule<T> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AndRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EditpolicymodelPackage.Literals.AND_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific element type known in this context.
	 * @generated
	 */
	@Override
	public EList<T> getRules() {
		if (rules == null) {
			rules = new EObjectContainmentEList<T>(Object.class, this, EditpolicymodelPackage.AND_RULE__RULES);
		}
		return rules;
	}

} //AndRuleImpl
