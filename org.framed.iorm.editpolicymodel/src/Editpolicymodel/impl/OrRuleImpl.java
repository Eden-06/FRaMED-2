/**
 */
package Editpolicymodel.impl;

import Editpolicymodel.EditpolicymodelPackage;
import Editpolicymodel.OrRule;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Or Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class OrRuleImpl<T> extends NaryRuleImpl<T> implements OrRule<T> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OrRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EditpolicymodelPackage.Literals.OR_RULE;
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
			rules = new EObjectContainmentEList<T>(Object.class, this, EditpolicymodelPackage.OR_RULE__RULES);
		}
		return rules;
	}

} //OrRuleImpl
