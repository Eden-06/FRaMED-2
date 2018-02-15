/**
 */
package genmodel.impl;

import genmodel.GenmodelPackage;

import org.eclipse.emf.codegen.ecore.genmodel.GenDataType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Data Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link genmodel.impl.GenDataTypeImpl#getEcoreDataType <em>Ecore Data Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenDataTypeImpl extends GenClassifierImpl implements GenDataType {
	/**
	 * The cached value of the '{@link #getEcoreDataType() <em>Ecore Data Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEcoreDataType()
	 * @generated
	 * @ordered
	 */
	protected EDataType ecoreDataType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenDataTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GenmodelPackage.Literals.GEN_DATA_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEcoreDataType() {
		if (ecoreDataType != null && ecoreDataType.eIsProxy()) {
			InternalEObject oldEcoreDataType = (InternalEObject)ecoreDataType;
			ecoreDataType = (EDataType)eResolveProxy(oldEcoreDataType);
			if (ecoreDataType != oldEcoreDataType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GenmodelPackage.GEN_DATA_TYPE__ECORE_DATA_TYPE, oldEcoreDataType, ecoreDataType));
			}
		}
		return ecoreDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType basicGetEcoreDataType() {
		return ecoreDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEcoreDataType(EDataType newEcoreDataType) {
		EDataType oldEcoreDataType = ecoreDataType;
		ecoreDataType = newEcoreDataType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_DATA_TYPE__ECORE_DATA_TYPE, oldEcoreDataType, ecoreDataType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GenmodelPackage.GEN_DATA_TYPE__ECORE_DATA_TYPE:
				if (resolve) return getEcoreDataType();
				return basicGetEcoreDataType();
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
			case GenmodelPackage.GEN_DATA_TYPE__ECORE_DATA_TYPE:
				setEcoreDataType((EDataType)newValue);
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
			case GenmodelPackage.GEN_DATA_TYPE__ECORE_DATA_TYPE:
				setEcoreDataType((EDataType)null);
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
			case GenmodelPackage.GEN_DATA_TYPE__ECORE_DATA_TYPE:
				return ecoreDataType != null;
		}
		return super.eIsSet(featureID);
	}

} //GenDataTypeImpl
