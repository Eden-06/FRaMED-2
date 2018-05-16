/**
 */
package editpolicymodel.impl;

import editpolicymodel.BinaryConstraintRule;
import editpolicymodel.ConstraintRule;
import editpolicymodel.editpolicymodelPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binary Constraint Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link editpolicymodel.impl.BinaryConstraintRuleImpl#getLeftRule <em>Left Rule</em>}</li>
 *   <li>{@link editpolicymodel.impl.BinaryConstraintRuleImpl#getRightRule <em>Right Rule</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class BinaryConstraintRuleImpl extends LogicalConstraintRuleImpl implements BinaryConstraintRule {
	/**
	 * The cached value of the '{@link #getLeftRule() <em>Left Rule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftRule()
	 * @generated
	 * @ordered
	 */
	protected ConstraintRule leftRule;

	/**
	 * The cached value of the '{@link #getRightRule() <em>Right Rule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightRule()
	 * @generated
	 * @ordered
	 */
	protected ConstraintRule rightRule;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BinaryConstraintRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return editpolicymodelPackage.Literals.BINARY_CONSTRAINT_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstraintRule getLeftRule() {
		return leftRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLeftRule(ConstraintRule newLeftRule, NotificationChain msgs) {
		ConstraintRule oldLeftRule = leftRule;
		leftRule = newLeftRule;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, editpolicymodelPackage.BINARY_CONSTRAINT_RULE__LEFT_RULE, oldLeftRule, newLeftRule);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeftRule(ConstraintRule newLeftRule) {
		if (newLeftRule != leftRule) {
			NotificationChain msgs = null;
			if (leftRule != null)
				msgs = ((InternalEObject)leftRule).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - editpolicymodelPackage.BINARY_CONSTRAINT_RULE__LEFT_RULE, null, msgs);
			if (newLeftRule != null)
				msgs = ((InternalEObject)newLeftRule).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - editpolicymodelPackage.BINARY_CONSTRAINT_RULE__LEFT_RULE, null, msgs);
			msgs = basicSetLeftRule(newLeftRule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, editpolicymodelPackage.BINARY_CONSTRAINT_RULE__LEFT_RULE, newLeftRule, newLeftRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstraintRule getRightRule() {
		return rightRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRightRule(ConstraintRule newRightRule, NotificationChain msgs) {
		ConstraintRule oldRightRule = rightRule;
		rightRule = newRightRule;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, editpolicymodelPackage.BINARY_CONSTRAINT_RULE__RIGHT_RULE, oldRightRule, newRightRule);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRightRule(ConstraintRule newRightRule) {
		if (newRightRule != rightRule) {
			NotificationChain msgs = null;
			if (rightRule != null)
				msgs = ((InternalEObject)rightRule).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - editpolicymodelPackage.BINARY_CONSTRAINT_RULE__RIGHT_RULE, null, msgs);
			if (newRightRule != null)
				msgs = ((InternalEObject)newRightRule).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - editpolicymodelPackage.BINARY_CONSTRAINT_RULE__RIGHT_RULE, null, msgs);
			msgs = basicSetRightRule(newRightRule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, editpolicymodelPackage.BINARY_CONSTRAINT_RULE__RIGHT_RULE, newRightRule, newRightRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case editpolicymodelPackage.BINARY_CONSTRAINT_RULE__LEFT_RULE:
				return basicSetLeftRule(null, msgs);
			case editpolicymodelPackage.BINARY_CONSTRAINT_RULE__RIGHT_RULE:
				return basicSetRightRule(null, msgs);
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
			case editpolicymodelPackage.BINARY_CONSTRAINT_RULE__LEFT_RULE:
				return getLeftRule();
			case editpolicymodelPackage.BINARY_CONSTRAINT_RULE__RIGHT_RULE:
				return getRightRule();
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
			case editpolicymodelPackage.BINARY_CONSTRAINT_RULE__LEFT_RULE:
				setLeftRule((ConstraintRule)newValue);
				return;
			case editpolicymodelPackage.BINARY_CONSTRAINT_RULE__RIGHT_RULE:
				setRightRule((ConstraintRule)newValue);
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
			case editpolicymodelPackage.BINARY_CONSTRAINT_RULE__LEFT_RULE:
				setLeftRule((ConstraintRule)null);
				return;
			case editpolicymodelPackage.BINARY_CONSTRAINT_RULE__RIGHT_RULE:
				setRightRule((ConstraintRule)null);
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
			case editpolicymodelPackage.BINARY_CONSTRAINT_RULE__LEFT_RULE:
				return leftRule != null;
			case editpolicymodelPackage.BINARY_CONSTRAINT_RULE__RIGHT_RULE:
				return rightRule != null;
		}
		return super.eIsSet(featureID);
	}

} //BinaryConstraintRuleImpl
