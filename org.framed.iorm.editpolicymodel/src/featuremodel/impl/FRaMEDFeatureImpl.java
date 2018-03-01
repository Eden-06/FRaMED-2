/**
 */
package featuremodel.impl;

import featuremodel.FRaMEDFeature;
import featuremodel.FeaturemodelPackage;

import iorm.featuremodel.FeatureName;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>FRa MED Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link featuremodel.impl.FRaMEDFeatureImpl#getName <em>Name</em>}</li>
 *   <li>{@link featuremodel.impl.FRaMEDFeatureImpl#isManuallySelected <em>Manually Selected</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FRaMEDFeatureImpl extends MinimalEObjectImpl.Container implements FRaMEDFeature {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final FeatureName NAME_EDEFAULT = FeatureName.RML_FEATURE_MODEL;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected FeatureName name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isManuallySelected() <em>Manually Selected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isManuallySelected()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MANUALLY_SELECTED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isManuallySelected() <em>Manually Selected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isManuallySelected()
	 * @generated
	 * @ordered
	 */
	protected boolean manuallySelected = MANUALLY_SELECTED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FRaMEDFeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FeaturemodelPackage.Literals.FRA_MED_FEATURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureName getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(FeatureName newName) {
		FeatureName oldName = name;
		name = newName == null ? NAME_EDEFAULT : newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeaturemodelPackage.FRA_MED_FEATURE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isManuallySelected() {
		return manuallySelected;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setManuallySelected(boolean newManuallySelected) {
		boolean oldManuallySelected = manuallySelected;
		manuallySelected = newManuallySelected;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeaturemodelPackage.FRA_MED_FEATURE__MANUALLY_SELECTED, oldManuallySelected, manuallySelected));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FeaturemodelPackage.FRA_MED_FEATURE__NAME:
				return getName();
			case FeaturemodelPackage.FRA_MED_FEATURE__MANUALLY_SELECTED:
				return isManuallySelected();
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
			case FeaturemodelPackage.FRA_MED_FEATURE__NAME:
				setName((FeatureName)newValue);
				return;
			case FeaturemodelPackage.FRA_MED_FEATURE__MANUALLY_SELECTED:
				setManuallySelected((Boolean)newValue);
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
			case FeaturemodelPackage.FRA_MED_FEATURE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case FeaturemodelPackage.FRA_MED_FEATURE__MANUALLY_SELECTED:
				setManuallySelected(MANUALLY_SELECTED_EDEFAULT);
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
			case FeaturemodelPackage.FRA_MED_FEATURE__NAME:
				return name != NAME_EDEFAULT;
			case FeaturemodelPackage.FRA_MED_FEATURE__MANUALLY_SELECTED:
				return manuallySelected != MANUALLY_SELECTED_EDEFAULT;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", manuallySelected: ");
		result.append(manuallySelected);
		result.append(')');
		return result.toString();
	}

} //FRaMEDFeatureImpl
