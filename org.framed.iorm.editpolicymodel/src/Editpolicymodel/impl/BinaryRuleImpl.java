/**
 */
package Editpolicymodel.impl;

import Editpolicymodel.AbstractRule;
import Editpolicymodel.BinaryRule;
import Editpolicymodel.EditpolicymodelPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binary Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Editpolicymodel.impl.BinaryRuleImpl#getLeftRule <em>Left Rule</em>}</li>
 *   <li>{@link Editpolicymodel.impl.BinaryRuleImpl#getRightRule <em>Right Rule</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class BinaryRuleImpl<T> extends MinimalEObjectImpl.Container implements BinaryRule<T> {
	/**
	 * The cached value of the '{@link #getLeftRule() <em>Left Rule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftRule()
	 * @generated
	 * @ordered
	 */
	protected AbstractRule<T> leftRule;

	/**
	 * The cached value of the '{@link #getRightRule() <em>Right Rule</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightRule()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractRule<T>> rightRule;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BinaryRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EditpolicymodelPackage.Literals.BINARY_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractRule<T> getLeftRule() {
		return leftRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLeftRule(AbstractRule<T> newLeftRule, NotificationChain msgs) {
		AbstractRule<T> oldLeftRule = leftRule;
		leftRule = newLeftRule;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EditpolicymodelPackage.BINARY_RULE__LEFT_RULE, oldLeftRule, newLeftRule);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeftRule(AbstractRule<T> newLeftRule) {
		if (newLeftRule != leftRule) {
			NotificationChain msgs = null;
			if (leftRule != null)
				msgs = ((InternalEObject)leftRule).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EditpolicymodelPackage.BINARY_RULE__LEFT_RULE, null, msgs);
			if (newLeftRule != null)
				msgs = ((InternalEObject)newLeftRule).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EditpolicymodelPackage.BINARY_RULE__LEFT_RULE, null, msgs);
			msgs = basicSetLeftRule(newLeftRule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditpolicymodelPackage.BINARY_RULE__LEFT_RULE, newLeftRule, newLeftRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractRule<T>> getRightRule() {
		if (rightRule == null) {
			rightRule = new EObjectContainmentEList<AbstractRule<T>>(AbstractRule.class, this, EditpolicymodelPackage.BINARY_RULE__RIGHT_RULE);
		}
		return rightRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EditpolicymodelPackage.BINARY_RULE__LEFT_RULE:
				return basicSetLeftRule(null, msgs);
			case EditpolicymodelPackage.BINARY_RULE__RIGHT_RULE:
				return ((InternalEList<?>)getRightRule()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EditpolicymodelPackage.BINARY_RULE__LEFT_RULE:
				return getLeftRule();
			case EditpolicymodelPackage.BINARY_RULE__RIGHT_RULE:
				return getRightRule();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EditpolicymodelPackage.BINARY_RULE__LEFT_RULE:
				setLeftRule((AbstractRule<T>)newValue);
				return;
			case EditpolicymodelPackage.BINARY_RULE__RIGHT_RULE:
				getRightRule().clear();
				getRightRule().addAll((Collection<? extends AbstractRule<T>>)newValue);
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
			case EditpolicymodelPackage.BINARY_RULE__LEFT_RULE:
				setLeftRule((AbstractRule<T>)null);
				return;
			case EditpolicymodelPackage.BINARY_RULE__RIGHT_RULE:
				getRightRule().clear();
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
			case EditpolicymodelPackage.BINARY_RULE__LEFT_RULE:
				return leftRule != null;
			case EditpolicymodelPackage.BINARY_RULE__RIGHT_RULE:
				return rightRule != null && !rightRule.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //BinaryRuleImpl
