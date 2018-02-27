/**
 */
package Editpolicymodel.impl;

import Editpolicymodel.AbstractRule;
import Editpolicymodel.ActionEnum;
import Editpolicymodel.ActionTypeEnum;
import Editpolicymodel.Constraint;
import Editpolicymodel.EditpolicymodelPackage;
import Editpolicymodel.Feature;
import Editpolicymodel.Policy;
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
 * An implementation of the model object '<em><b>Policy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Editpolicymodel.impl.PolicyImpl#getOverride <em>Override</em>}</li>
 *   <li>{@link Editpolicymodel.impl.PolicyImpl#getAction <em>Action</em>}</li>
 *   <li>{@link Editpolicymodel.impl.PolicyImpl#getActionType <em>Action Type</em>}</li>
 *   <li>{@link Editpolicymodel.impl.PolicyImpl#getFeatureRule <em>Feature Rule</em>}</li>
 *   <li>{@link Editpolicymodel.impl.PolicyImpl#getConstraintRule <em>Constraint Rule</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PolicyImpl extends MinimalEObjectImpl.Container implements Policy {
	/**
	 * The default value of the '{@link #getOverride() <em>Override</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverride()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean OVERRIDE_EDEFAULT = Boolean.FALSE;

	/**
	 * The cached value of the '{@link #getOverride() <em>Override</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverride()
	 * @generated
	 * @ordered
	 */
	protected Boolean override = OVERRIDE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAction() <em>Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected static final ActionEnum ACTION_EDEFAULT = ActionEnum.CREATE;

	/**
	 * The cached value of the '{@link #getAction() <em>Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected ActionEnum action = ACTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getActionType() <em>Action Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionType()
	 * @generated
	 * @ordered
	 */
	protected static final ActionTypeEnum ACTION_TYPE_EDEFAULT = ActionTypeEnum.FULFILLMENT;

	/**
	 * The cached value of the '{@link #getActionType() <em>Action Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionType()
	 * @generated
	 * @ordered
	 */
	protected ActionTypeEnum actionType = ACTION_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFeatureRule() <em>Feature Rule</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureRule()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractRule<Feature>> featureRule;

	/**
	 * The cached value of the '{@link #getConstraintRule() <em>Constraint Rule</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraintRule()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractRule<Constraint>> constraintRule;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PolicyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EditpolicymodelPackage.Literals.POLICY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getOverride() {
		return override;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverride(Boolean newOverride) {
		Boolean oldOverride = override;
		override = newOverride;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditpolicymodelPackage.POLICY__OVERRIDE, oldOverride, override));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionEnum getAction() {
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAction(ActionEnum newAction) {
		ActionEnum oldAction = action;
		action = newAction == null ? ACTION_EDEFAULT : newAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditpolicymodelPackage.POLICY__ACTION, oldAction, action));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionTypeEnum getActionType() {
		return actionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActionType(ActionTypeEnum newActionType) {
		ActionTypeEnum oldActionType = actionType;
		actionType = newActionType == null ? ACTION_TYPE_EDEFAULT : newActionType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditpolicymodelPackage.POLICY__ACTION_TYPE, oldActionType, actionType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractRule<Feature>> getFeatureRule() {
		if (featureRule == null) {
			featureRule = new EObjectContainmentEList<AbstractRule<Feature>>(AbstractRule.class, this, EditpolicymodelPackage.POLICY__FEATURE_RULE);
		}
		return featureRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractRule<Constraint>> getConstraintRule() {
		if (constraintRule == null) {
			constraintRule = new EObjectContainmentEList<AbstractRule<Constraint>>(AbstractRule.class, this, EditpolicymodelPackage.POLICY__CONSTRAINT_RULE);
		}
		return constraintRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EditpolicymodelPackage.POLICY__FEATURE_RULE:
				return ((InternalEList<?>)getFeatureRule()).basicRemove(otherEnd, msgs);
			case EditpolicymodelPackage.POLICY__CONSTRAINT_RULE:
				return ((InternalEList<?>)getConstraintRule()).basicRemove(otherEnd, msgs);
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
			case EditpolicymodelPackage.POLICY__OVERRIDE:
				return getOverride();
			case EditpolicymodelPackage.POLICY__ACTION:
				return getAction();
			case EditpolicymodelPackage.POLICY__ACTION_TYPE:
				return getActionType();
			case EditpolicymodelPackage.POLICY__FEATURE_RULE:
				return getFeatureRule();
			case EditpolicymodelPackage.POLICY__CONSTRAINT_RULE:
				return getConstraintRule();
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
			case EditpolicymodelPackage.POLICY__OVERRIDE:
				setOverride((Boolean)newValue);
				return;
			case EditpolicymodelPackage.POLICY__ACTION:
				setAction((ActionEnum)newValue);
				return;
			case EditpolicymodelPackage.POLICY__ACTION_TYPE:
				setActionType((ActionTypeEnum)newValue);
				return;
			case EditpolicymodelPackage.POLICY__FEATURE_RULE:
				getFeatureRule().clear();
				getFeatureRule().addAll((Collection<? extends AbstractRule<Feature>>)newValue);
				return;
			case EditpolicymodelPackage.POLICY__CONSTRAINT_RULE:
				getConstraintRule().clear();
				getConstraintRule().addAll((Collection<? extends AbstractRule<Constraint>>)newValue);
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
			case EditpolicymodelPackage.POLICY__OVERRIDE:
				setOverride(OVERRIDE_EDEFAULT);
				return;
			case EditpolicymodelPackage.POLICY__ACTION:
				setAction(ACTION_EDEFAULT);
				return;
			case EditpolicymodelPackage.POLICY__ACTION_TYPE:
				setActionType(ACTION_TYPE_EDEFAULT);
				return;
			case EditpolicymodelPackage.POLICY__FEATURE_RULE:
				getFeatureRule().clear();
				return;
			case EditpolicymodelPackage.POLICY__CONSTRAINT_RULE:
				getConstraintRule().clear();
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
			case EditpolicymodelPackage.POLICY__OVERRIDE:
				return OVERRIDE_EDEFAULT == null ? override != null : !OVERRIDE_EDEFAULT.equals(override);
			case EditpolicymodelPackage.POLICY__ACTION:
				return action != ACTION_EDEFAULT;
			case EditpolicymodelPackage.POLICY__ACTION_TYPE:
				return actionType != ACTION_TYPE_EDEFAULT;
			case EditpolicymodelPackage.POLICY__FEATURE_RULE:
				return featureRule != null && !featureRule.isEmpty();
			case EditpolicymodelPackage.POLICY__CONSTRAINT_RULE:
				return constraintRule != null && !constraintRule.isEmpty();
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
		result.append(" (override: ");
		result.append(override);
		result.append(", action: ");
		result.append(action);
		result.append(", ActionType: ");
		result.append(actionType);
		result.append(')');
		return result.toString();
	}

} //PolicyImpl
