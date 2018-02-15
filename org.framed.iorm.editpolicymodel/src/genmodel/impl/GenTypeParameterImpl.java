/**
 */
package genmodel.impl;

import genmodel.GenmodelPackage;

import org.eclipse.emf.codegen.ecore.genmodel.GenTypeParameter;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Type Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link genmodel.impl.GenTypeParameterImpl#getEcoreTypeParameter <em>Ecore Type Parameter</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenTypeParameterImpl extends GenBaseImpl implements GenTypeParameter {
	/**
	 * The cached value of the '{@link #getEcoreTypeParameter() <em>Ecore Type Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEcoreTypeParameter()
	 * @generated
	 * @ordered
	 */
	protected ETypeParameter ecoreTypeParameter;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenTypeParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GenmodelPackage.Literals.GEN_TYPE_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ETypeParameter getEcoreTypeParameter() {
		if (ecoreTypeParameter != null && ecoreTypeParameter.eIsProxy()) {
			InternalEObject oldEcoreTypeParameter = (InternalEObject)ecoreTypeParameter;
			ecoreTypeParameter = (ETypeParameter)eResolveProxy(oldEcoreTypeParameter);
			if (ecoreTypeParameter != oldEcoreTypeParameter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GenmodelPackage.GEN_TYPE_PARAMETER__ECORE_TYPE_PARAMETER, oldEcoreTypeParameter, ecoreTypeParameter));
			}
		}
		return ecoreTypeParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ETypeParameter basicGetEcoreTypeParameter() {
		return ecoreTypeParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEcoreTypeParameter(ETypeParameter newEcoreTypeParameter) {
		ETypeParameter oldEcoreTypeParameter = ecoreTypeParameter;
		ecoreTypeParameter = newEcoreTypeParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_TYPE_PARAMETER__ECORE_TYPE_PARAMETER, oldEcoreTypeParameter, ecoreTypeParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GenmodelPackage.GEN_TYPE_PARAMETER__ECORE_TYPE_PARAMETER:
				if (resolve) return getEcoreTypeParameter();
				return basicGetEcoreTypeParameter();
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
			case GenmodelPackage.GEN_TYPE_PARAMETER__ECORE_TYPE_PARAMETER:
				setEcoreTypeParameter((ETypeParameter)newValue);
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
			case GenmodelPackage.GEN_TYPE_PARAMETER__ECORE_TYPE_PARAMETER:
				setEcoreTypeParameter((ETypeParameter)null);
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
			case GenmodelPackage.GEN_TYPE_PARAMETER__ECORE_TYPE_PARAMETER:
				return ecoreTypeParameter != null;
		}
		return super.eIsSet(featureID);
	}

} //GenTypeParameterImpl
