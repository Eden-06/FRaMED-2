/**
 */
package editpolicymodel.impl;

import editpolicymodel.BinaryFeatureRule;
import editpolicymodel.FeatureRule;
import editpolicymodel.editpolicymodelPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binary Feature Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link editpolicymodel.impl.BinaryFeatureRuleImpl#getRightRule <em>Right Rule</em>}</li>
 *   <li>{@link editpolicymodel.impl.BinaryFeatureRuleImpl#getLeftRule <em>Left Rule</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class BinaryFeatureRuleImpl extends LogicalFeatureRuleImpl implements BinaryFeatureRule {
	/**
	 * The cached value of the '{@link #getRightRule() <em>Right Rule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightRule()
	 * @generated
	 * @ordered
	 */
	protected FeatureRule rightRule;

	/**
	 * The cached value of the '{@link #getLeftRule() <em>Left Rule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftRule()
	 * @generated
	 * @ordered
	 */
	protected FeatureRule leftRule;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BinaryFeatureRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return editpolicymodelPackage.Literals.BINARY_FEATURE_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureRule getRightRule() {
		return rightRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRightRule(FeatureRule newRightRule, NotificationChain msgs) {
		FeatureRule oldRightRule = rightRule;
		rightRule = newRightRule;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, editpolicymodelPackage.BINARY_FEATURE_RULE__RIGHT_RULE, oldRightRule, newRightRule);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRightRule(FeatureRule newRightRule) {
		if (newRightRule != rightRule) {
			NotificationChain msgs = null;
			if (rightRule != null)
				msgs = ((InternalEObject)rightRule).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - editpolicymodelPackage.BINARY_FEATURE_RULE__RIGHT_RULE, null, msgs);
			if (newRightRule != null)
				msgs = ((InternalEObject)newRightRule).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - editpolicymodelPackage.BINARY_FEATURE_RULE__RIGHT_RULE, null, msgs);
			msgs = basicSetRightRule(newRightRule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, editpolicymodelPackage.BINARY_FEATURE_RULE__RIGHT_RULE, newRightRule, newRightRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureRule getLeftRule() {
		return leftRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLeftRule(FeatureRule newLeftRule, NotificationChain msgs) {
		FeatureRule oldLeftRule = leftRule;
		leftRule = newLeftRule;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, editpolicymodelPackage.BINARY_FEATURE_RULE__LEFT_RULE, oldLeftRule, newLeftRule);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeftRule(FeatureRule newLeftRule) {
		if (newLeftRule != leftRule) {
			NotificationChain msgs = null;
			if (leftRule != null)
				msgs = ((InternalEObject)leftRule).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - editpolicymodelPackage.BINARY_FEATURE_RULE__LEFT_RULE, null, msgs);
			if (newLeftRule != null)
				msgs = ((InternalEObject)newLeftRule).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - editpolicymodelPackage.BINARY_FEATURE_RULE__LEFT_RULE, null, msgs);
			msgs = basicSetLeftRule(newLeftRule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, editpolicymodelPackage.BINARY_FEATURE_RULE__LEFT_RULE, newLeftRule, newLeftRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case editpolicymodelPackage.BINARY_FEATURE_RULE__RIGHT_RULE:
				return basicSetRightRule(null, msgs);
			case editpolicymodelPackage.BINARY_FEATURE_RULE__LEFT_RULE:
				return basicSetLeftRule(null, msgs);
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
			case editpolicymodelPackage.BINARY_FEATURE_RULE__RIGHT_RULE:
				return getRightRule();
			case editpolicymodelPackage.BINARY_FEATURE_RULE__LEFT_RULE:
				return getLeftRule();
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
			case editpolicymodelPackage.BINARY_FEATURE_RULE__RIGHT_RULE:
				setRightRule((FeatureRule)newValue);
				return;
			case editpolicymodelPackage.BINARY_FEATURE_RULE__LEFT_RULE:
				setLeftRule((FeatureRule)newValue);
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
			case editpolicymodelPackage.BINARY_FEATURE_RULE__RIGHT_RULE:
				setRightRule((FeatureRule)null);
				return;
			case editpolicymodelPackage.BINARY_FEATURE_RULE__LEFT_RULE:
				setLeftRule((FeatureRule)null);
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
			case editpolicymodelPackage.BINARY_FEATURE_RULE__RIGHT_RULE:
				return rightRule != null;
			case editpolicymodelPackage.BINARY_FEATURE_RULE__LEFT_RULE:
				return leftRule != null;
		}
		return super.eIsSet(featureID);
	}

} //BinaryFeatureRuleImpl
