/**
 */
package iorm.impl;

import iorm.IormPackage;
import iorm.Model;
import iorm.ModelElement;
import iorm.Shape;

import iorm.featuremodel.FRaMEDConfiguration;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link iorm.impl.ModelImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link iorm.impl.ModelImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link iorm.impl.ModelImpl#getFramedConfiguration <em>Framed Configuration</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model {
	/**
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelElement> elements;

	/**
	 * The cached value of the '{@link #getFramedConfiguration() <em>Framed Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFramedConfiguration()
	 * @generated
	 * @ordered
	 */
	protected FRaMEDConfiguration framedConfiguration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IormPackage.Literals.MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelElement> getElements() {
		if (elements == null) {
			elements = new EObjectContainmentWithInverseEList<ModelElement>(ModelElement.class, this, IormPackage.MODEL__ELEMENTS, IormPackage.MODEL_ELEMENT__CONTAINER);
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Shape getParent() {
		if (eContainerFeatureID() != IormPackage.MODEL__PARENT) return null;
		return (Shape)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(Shape newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, IormPackage.MODEL__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(Shape newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID() != IormPackage.MODEL__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, IormPackage.SHAPE__MODEL, Shape.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IormPackage.MODEL__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FRaMEDConfiguration getFramedConfiguration() {
		return framedConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFramedConfiguration(FRaMEDConfiguration newFramedConfiguration, NotificationChain msgs) {
		FRaMEDConfiguration oldFramedConfiguration = framedConfiguration;
		framedConfiguration = newFramedConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IormPackage.MODEL__FRAMED_CONFIGURATION, oldFramedConfiguration, newFramedConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFramedConfiguration(FRaMEDConfiguration newFramedConfiguration) {
		if (newFramedConfiguration != framedConfiguration) {
			NotificationChain msgs = null;
			if (framedConfiguration != null)
				msgs = ((InternalEObject)framedConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IormPackage.MODEL__FRAMED_CONFIGURATION, null, msgs);
			if (newFramedConfiguration != null)
				msgs = ((InternalEObject)newFramedConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IormPackage.MODEL__FRAMED_CONFIGURATION, null, msgs);
			msgs = basicSetFramedConfiguration(newFramedConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IormPackage.MODEL__FRAMED_CONFIGURATION, newFramedConfiguration, newFramedConfiguration));
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
			case IormPackage.MODEL__ELEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getElements()).basicAdd(otherEnd, msgs);
			case IormPackage.MODEL__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((Shape)otherEnd, msgs);
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
			case IormPackage.MODEL__ELEMENTS:
				return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
			case IormPackage.MODEL__PARENT:
				return basicSetParent(null, msgs);
			case IormPackage.MODEL__FRAMED_CONFIGURATION:
				return basicSetFramedConfiguration(null, msgs);
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
			case IormPackage.MODEL__PARENT:
				return eInternalContainer().eInverseRemove(this, IormPackage.SHAPE__MODEL, Shape.class, msgs);
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
			case IormPackage.MODEL__ELEMENTS:
				return getElements();
			case IormPackage.MODEL__PARENT:
				return getParent();
			case IormPackage.MODEL__FRAMED_CONFIGURATION:
				return getFramedConfiguration();
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
			case IormPackage.MODEL__ELEMENTS:
				getElements().clear();
				getElements().addAll((Collection<? extends ModelElement>)newValue);
				return;
			case IormPackage.MODEL__PARENT:
				setParent((Shape)newValue);
				return;
			case IormPackage.MODEL__FRAMED_CONFIGURATION:
				setFramedConfiguration((FRaMEDConfiguration)newValue);
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
			case IormPackage.MODEL__ELEMENTS:
				getElements().clear();
				return;
			case IormPackage.MODEL__PARENT:
				setParent((Shape)null);
				return;
			case IormPackage.MODEL__FRAMED_CONFIGURATION:
				setFramedConfiguration((FRaMEDConfiguration)null);
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
			case IormPackage.MODEL__ELEMENTS:
				return elements != null && !elements.isEmpty();
			case IormPackage.MODEL__PARENT:
				return getParent() != null;
			case IormPackage.MODEL__FRAMED_CONFIGURATION:
				return framedConfiguration != null;
		}
		return super.eIsSet(featureID);
	}

} //ModelImpl
