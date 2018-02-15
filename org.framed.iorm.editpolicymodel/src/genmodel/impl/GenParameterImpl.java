/**
 */
package genmodel.impl;

import genmodel.GenmodelPackage;

import org.eclipse.emf.codegen.ecore.genmodel.GenOperation;
import org.eclipse.emf.codegen.ecore.genmodel.GenParameter;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link genmodel.impl.GenParameterImpl#getGenOperation <em>Gen Operation</em>}</li>
 *   <li>{@link genmodel.impl.GenParameterImpl#getEcoreParameter <em>Ecore Parameter</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenParameterImpl extends GenTypedElementImpl implements GenParameter {
	/**
	 * The cached value of the '{@link #getEcoreParameter() <em>Ecore Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEcoreParameter()
	 * @generated
	 * @ordered
	 */
	protected EParameter ecoreParameter;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GenmodelPackage.Literals.GEN_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenOperation getGenOperation() {
		if (eContainerFeatureID() != GenmodelPackage.GEN_PARAMETER__GEN_OPERATION) return null;
		return (GenOperation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGenOperation(GenOperation newGenOperation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newGenOperation, GenmodelPackage.GEN_PARAMETER__GEN_OPERATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenOperation(GenOperation newGenOperation) {
		if (newGenOperation != eInternalContainer() || (eContainerFeatureID() != GenmodelPackage.GEN_PARAMETER__GEN_OPERATION && newGenOperation != null)) {
			if (EcoreUtil.isAncestor(this, newGenOperation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newGenOperation != null)
				msgs = ((InternalEObject)newGenOperation).eInverseAdd(this, GenmodelPackage.GEN_OPERATION__GEN_PARAMETERS, GenOperation.class, msgs);
			msgs = basicSetGenOperation(newGenOperation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_PARAMETER__GEN_OPERATION, newGenOperation, newGenOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EParameter getEcoreParameter() {
		if (ecoreParameter != null && ecoreParameter.eIsProxy()) {
			InternalEObject oldEcoreParameter = (InternalEObject)ecoreParameter;
			ecoreParameter = (EParameter)eResolveProxy(oldEcoreParameter);
			if (ecoreParameter != oldEcoreParameter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GenmodelPackage.GEN_PARAMETER__ECORE_PARAMETER, oldEcoreParameter, ecoreParameter));
			}
		}
		return ecoreParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EParameter basicGetEcoreParameter() {
		return ecoreParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEcoreParameter(EParameter newEcoreParameter) {
		EParameter oldEcoreParameter = ecoreParameter;
		ecoreParameter = newEcoreParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_PARAMETER__ECORE_PARAMETER, oldEcoreParameter, ecoreParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GenmodelPackage.GEN_PARAMETER__GEN_OPERATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetGenOperation((GenOperation)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GenmodelPackage.GEN_PARAMETER__GEN_OPERATION:
				return basicSetGenOperation(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case GenmodelPackage.GEN_PARAMETER__GEN_OPERATION:
				return eInternalContainer().eInverseRemove(this, GenmodelPackage.GEN_OPERATION__GEN_PARAMETERS, GenOperation.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GenmodelPackage.GEN_PARAMETER__GEN_OPERATION:
				return getGenOperation();
			case GenmodelPackage.GEN_PARAMETER__ECORE_PARAMETER:
				if (resolve) return getEcoreParameter();
				return basicGetEcoreParameter();
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
			case GenmodelPackage.GEN_PARAMETER__GEN_OPERATION:
				setGenOperation((GenOperation)newValue);
				return;
			case GenmodelPackage.GEN_PARAMETER__ECORE_PARAMETER:
				setEcoreParameter((EParameter)newValue);
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
			case GenmodelPackage.GEN_PARAMETER__GEN_OPERATION:
				setGenOperation((GenOperation)null);
				return;
			case GenmodelPackage.GEN_PARAMETER__ECORE_PARAMETER:
				setEcoreParameter((EParameter)null);
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
			case GenmodelPackage.GEN_PARAMETER__GEN_OPERATION:
				return getGenOperation() != null;
			case GenmodelPackage.GEN_PARAMETER__ECORE_PARAMETER:
				return ecoreParameter != null;
		}
		return super.eIsSet(featureID);
	}

} //GenParameterImpl
