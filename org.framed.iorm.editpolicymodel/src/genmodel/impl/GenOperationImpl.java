/**
 */
package genmodel.impl;

import genmodel.GenmodelPackage;

import java.util.Collection;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenOperation;
import org.eclipse.emf.codegen.ecore.genmodel.GenParameter;
import org.eclipse.emf.codegen.ecore.genmodel.GenTypeParameter;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link genmodel.impl.GenOperationImpl#getGenClass <em>Gen Class</em>}</li>
 *   <li>{@link genmodel.impl.GenOperationImpl#getEcoreOperation <em>Ecore Operation</em>}</li>
 *   <li>{@link genmodel.impl.GenOperationImpl#getGenParameters <em>Gen Parameters</em>}</li>
 *   <li>{@link genmodel.impl.GenOperationImpl#getGenTypeParameters <em>Gen Type Parameters</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenOperationImpl extends GenTypedElementImpl implements GenOperation {
	/**
	 * The cached value of the '{@link #getEcoreOperation() <em>Ecore Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEcoreOperation()
	 * @generated
	 * @ordered
	 */
	protected EOperation ecoreOperation;

	/**
	 * The cached value of the '{@link #getGenParameters() <em>Gen Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<GenParameter> genParameters;

	/**
	 * The cached value of the '{@link #getGenTypeParameters() <em>Gen Type Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenTypeParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<GenTypeParameter> genTypeParameters;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GenmodelPackage.Literals.GEN_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenClass getGenClass() {
		if (eContainerFeatureID() != GenmodelPackage.GEN_OPERATION__GEN_CLASS) return null;
		return (GenClass)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGenClass(GenClass newGenClass, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newGenClass, GenmodelPackage.GEN_OPERATION__GEN_CLASS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenClass(GenClass newGenClass) {
		if (newGenClass != eInternalContainer() || (eContainerFeatureID() != GenmodelPackage.GEN_OPERATION__GEN_CLASS && newGenClass != null)) {
			if (EcoreUtil.isAncestor(this, newGenClass))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newGenClass != null)
				msgs = ((InternalEObject)newGenClass).eInverseAdd(this, GenmodelPackage.GEN_CLASS__GEN_OPERATIONS, GenClass.class, msgs);
			msgs = basicSetGenClass(newGenClass, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_OPERATION__GEN_CLASS, newGenClass, newGenClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEcoreOperation() {
		if (ecoreOperation != null && ecoreOperation.eIsProxy()) {
			InternalEObject oldEcoreOperation = (InternalEObject)ecoreOperation;
			ecoreOperation = (EOperation)eResolveProxy(oldEcoreOperation);
			if (ecoreOperation != oldEcoreOperation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GenmodelPackage.GEN_OPERATION__ECORE_OPERATION, oldEcoreOperation, ecoreOperation));
			}
		}
		return ecoreOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation basicGetEcoreOperation() {
		return ecoreOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEcoreOperation(EOperation newEcoreOperation) {
		EOperation oldEcoreOperation = ecoreOperation;
		ecoreOperation = newEcoreOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_OPERATION__ECORE_OPERATION, oldEcoreOperation, ecoreOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GenParameter> getGenParameters() {
		if (genParameters == null) {
			genParameters = new EObjectContainmentWithInverseEList<GenParameter>(GenParameter.class, this, GenmodelPackage.GEN_OPERATION__GEN_PARAMETERS, GenmodelPackage.GEN_PARAMETER__GEN_OPERATION);
		}
		return genParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GenTypeParameter> getGenTypeParameters() {
		if (genTypeParameters == null) {
			genTypeParameters = new EObjectContainmentEList<GenTypeParameter>(GenTypeParameter.class, this, GenmodelPackage.GEN_OPERATION__GEN_TYPE_PARAMETERS);
		}
		return genTypeParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GenmodelPackage.GEN_OPERATION__GEN_CLASS:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetGenClass((GenClass)otherEnd, msgs);
			case GenmodelPackage.GEN_OPERATION__GEN_PARAMETERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getGenParameters()).basicAdd(otherEnd, msgs);
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
			case GenmodelPackage.GEN_OPERATION__GEN_CLASS:
				return basicSetGenClass(null, msgs);
			case GenmodelPackage.GEN_OPERATION__GEN_PARAMETERS:
				return ((InternalEList<?>)getGenParameters()).basicRemove(otherEnd, msgs);
			case GenmodelPackage.GEN_OPERATION__GEN_TYPE_PARAMETERS:
				return ((InternalEList<?>)getGenTypeParameters()).basicRemove(otherEnd, msgs);
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
			case GenmodelPackage.GEN_OPERATION__GEN_CLASS:
				return eInternalContainer().eInverseRemove(this, GenmodelPackage.GEN_CLASS__GEN_OPERATIONS, GenClass.class, msgs);
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
			case GenmodelPackage.GEN_OPERATION__GEN_CLASS:
				return getGenClass();
			case GenmodelPackage.GEN_OPERATION__ECORE_OPERATION:
				if (resolve) return getEcoreOperation();
				return basicGetEcoreOperation();
			case GenmodelPackage.GEN_OPERATION__GEN_PARAMETERS:
				return getGenParameters();
			case GenmodelPackage.GEN_OPERATION__GEN_TYPE_PARAMETERS:
				return getGenTypeParameters();
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
			case GenmodelPackage.GEN_OPERATION__GEN_CLASS:
				setGenClass((GenClass)newValue);
				return;
			case GenmodelPackage.GEN_OPERATION__ECORE_OPERATION:
				setEcoreOperation((EOperation)newValue);
				return;
			case GenmodelPackage.GEN_OPERATION__GEN_PARAMETERS:
				getGenParameters().clear();
				getGenParameters().addAll((Collection<? extends GenParameter>)newValue);
				return;
			case GenmodelPackage.GEN_OPERATION__GEN_TYPE_PARAMETERS:
				getGenTypeParameters().clear();
				getGenTypeParameters().addAll((Collection<? extends GenTypeParameter>)newValue);
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
			case GenmodelPackage.GEN_OPERATION__GEN_CLASS:
				setGenClass((GenClass)null);
				return;
			case GenmodelPackage.GEN_OPERATION__ECORE_OPERATION:
				setEcoreOperation((EOperation)null);
				return;
			case GenmodelPackage.GEN_OPERATION__GEN_PARAMETERS:
				getGenParameters().clear();
				return;
			case GenmodelPackage.GEN_OPERATION__GEN_TYPE_PARAMETERS:
				getGenTypeParameters().clear();
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
			case GenmodelPackage.GEN_OPERATION__GEN_CLASS:
				return getGenClass() != null;
			case GenmodelPackage.GEN_OPERATION__ECORE_OPERATION:
				return ecoreOperation != null;
			case GenmodelPackage.GEN_OPERATION__GEN_PARAMETERS:
				return genParameters != null && !genParameters.isEmpty();
			case GenmodelPackage.GEN_OPERATION__GEN_TYPE_PARAMETERS:
				return genTypeParameters != null && !genTypeParameters.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //GenOperationImpl
