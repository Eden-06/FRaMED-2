/**
 */
package Editpolicymodel.impl;

import Editpolicymodel.AbstractConstraintRule;
import Editpolicymodel.EditpolicymodelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Constraint Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Editpolicymodel.impl.AbstractConstraintRuleImpl#getRule2 <em>Rule2</em>}</li>
 *   <li>{@link Editpolicymodel.impl.AbstractConstraintRuleImpl#getRule1 <em>Rule1</em>}</li>
 *   <li>{@link Editpolicymodel.impl.AbstractConstraintRuleImpl#getArgument <em>Argument</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractConstraintRuleImpl extends MinimalEObjectImpl.Container implements AbstractConstraintRule {
	/**
	 * The cached value of the '{@link #getRule2() <em>Rule2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRule2()
	 * @generated
	 * @ordered
	 */
	protected AbstractConstraintRule rule2;

	/**
	 * The cached value of the '{@link #getRule1() <em>Rule1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRule1()
	 * @generated
	 * @ordered
	 */
	protected AbstractConstraintRule rule1;

	/**
	 * The default value of the '{@link #getArgument() <em>Argument</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgument()
	 * @generated
	 * @ordered
	 */
	protected static final String ARGUMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getArgument() <em>Argument</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgument()
	 * @generated
	 * @ordered
	 */
	protected String argument = ARGUMENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractConstraintRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EditpolicymodelPackage.Literals.ABSTRACT_CONSTRAINT_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractConstraintRule getRule2() {
		if (rule2 != null && rule2.eIsProxy()) {
			InternalEObject oldRule2 = (InternalEObject)rule2;
			rule2 = (AbstractConstraintRule)eResolveProxy(oldRule2);
			if (rule2 != oldRule2) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EditpolicymodelPackage.ABSTRACT_CONSTRAINT_RULE__RULE2, oldRule2, rule2));
			}
		}
		return rule2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractConstraintRule basicGetRule2() {
		return rule2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRule2(AbstractConstraintRule newRule2) {
		AbstractConstraintRule oldRule2 = rule2;
		rule2 = newRule2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditpolicymodelPackage.ABSTRACT_CONSTRAINT_RULE__RULE2, oldRule2, rule2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractConstraintRule getRule1() {
		if (rule1 != null && rule1.eIsProxy()) {
			InternalEObject oldRule1 = (InternalEObject)rule1;
			rule1 = (AbstractConstraintRule)eResolveProxy(oldRule1);
			if (rule1 != oldRule1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EditpolicymodelPackage.ABSTRACT_CONSTRAINT_RULE__RULE1, oldRule1, rule1));
			}
		}
		return rule1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractConstraintRule basicGetRule1() {
		return rule1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRule1(AbstractConstraintRule newRule1) {
		AbstractConstraintRule oldRule1 = rule1;
		rule1 = newRule1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditpolicymodelPackage.ABSTRACT_CONSTRAINT_RULE__RULE1, oldRule1, rule1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getArgument() {
		return argument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArgument(String newArgument) {
		String oldArgument = argument;
		argument = newArgument;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditpolicymodelPackage.ABSTRACT_CONSTRAINT_RULE__ARGUMENT, oldArgument, argument));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EditpolicymodelPackage.ABSTRACT_CONSTRAINT_RULE__RULE2:
				if (resolve) return getRule2();
				return basicGetRule2();
			case EditpolicymodelPackage.ABSTRACT_CONSTRAINT_RULE__RULE1:
				if (resolve) return getRule1();
				return basicGetRule1();
			case EditpolicymodelPackage.ABSTRACT_CONSTRAINT_RULE__ARGUMENT:
				return getArgument();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EditpolicymodelPackage.ABSTRACT_CONSTRAINT_RULE__RULE2:
				setRule2((AbstractConstraintRule)newValue);
				return;
			case EditpolicymodelPackage.ABSTRACT_CONSTRAINT_RULE__RULE1:
				setRule1((AbstractConstraintRule)newValue);
				return;
			case EditpolicymodelPackage.ABSTRACT_CONSTRAINT_RULE__ARGUMENT:
				setArgument((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EditpolicymodelPackage.ABSTRACT_CONSTRAINT_RULE__RULE2:
				setRule2((AbstractConstraintRule)null);
				return;
			case EditpolicymodelPackage.ABSTRACT_CONSTRAINT_RULE__RULE1:
				setRule1((AbstractConstraintRule)null);
				return;
			case EditpolicymodelPackage.ABSTRACT_CONSTRAINT_RULE__ARGUMENT:
				setArgument(ARGUMENT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EditpolicymodelPackage.ABSTRACT_CONSTRAINT_RULE__RULE2:
				return rule2 != null;
			case EditpolicymodelPackage.ABSTRACT_CONSTRAINT_RULE__RULE1:
				return rule1 != null;
			case EditpolicymodelPackage.ABSTRACT_CONSTRAINT_RULE__ARGUMENT:
				return ARGUMENT_EDEFAULT == null ? argument != null : !ARGUMENT_EDEFAULT.equals(argument);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (argument: ");
		result.append(argument);
		result.append(')');
		return result.toString();
	}

} //AbstractConstraintRuleImpl
