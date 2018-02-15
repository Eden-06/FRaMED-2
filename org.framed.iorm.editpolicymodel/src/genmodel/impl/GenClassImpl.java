/**
 */
package genmodel.impl;

import genmodel.GenProviderKind;
import genmodel.GenmodelPackage;

import java.util.Collection;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenOperation;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link genmodel.impl.GenClassImpl#getProvider <em>Provider</em>}</li>
 *   <li>{@link genmodel.impl.GenClassImpl#isImage <em>Image</em>}</li>
 *   <li>{@link genmodel.impl.GenClassImpl#isDynamic <em>Dynamic</em>}</li>
 *   <li>{@link genmodel.impl.GenClassImpl#getEcoreClass <em>Ecore Class</em>}</li>
 *   <li>{@link genmodel.impl.GenClassImpl#getGenFeatures <em>Gen Features</em>}</li>
 *   <li>{@link genmodel.impl.GenClassImpl#getGenOperations <em>Gen Operations</em>}</li>
 *   <li>{@link genmodel.impl.GenClassImpl#getLabelFeature <em>Label Feature</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenClassImpl extends GenClassifierImpl implements GenClass {
	/**
	 * The default value of the '{@link #getProvider() <em>Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvider()
	 * @generated
	 * @ordered
	 */
	protected static final GenProviderKind PROVIDER_EDEFAULT = GenProviderKind.SINGLETON;

	/**
	 * The cached value of the '{@link #getProvider() <em>Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvider()
	 * @generated
	 * @ordered
	 */
	protected GenProviderKind provider = PROVIDER_EDEFAULT;

	/**
	 * The default value of the '{@link #isImage() <em>Image</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isImage()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IMAGE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isImage() <em>Image</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isImage()
	 * @generated
	 * @ordered
	 */
	protected boolean image = IMAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #isDynamic() <em>Dynamic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDynamic()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DYNAMIC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDynamic() <em>Dynamic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDynamic()
	 * @generated
	 * @ordered
	 */
	protected boolean dynamic = DYNAMIC_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEcoreClass() <em>Ecore Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEcoreClass()
	 * @generated
	 * @ordered
	 */
	protected EClass ecoreClass;

	/**
	 * The cached value of the '{@link #getGenFeatures() <em>Gen Features</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<GenFeature> genFeatures;

	/**
	 * The cached value of the '{@link #getGenOperations() <em>Gen Operations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<GenOperation> genOperations;

	/**
	 * The cached value of the '{@link #getLabelFeature() <em>Label Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabelFeature()
	 * @generated
	 * @ordered
	 */
	protected GenFeature labelFeature;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GenmodelPackage.Literals.GEN_CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenProviderKind getProvider() {
		return provider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProvider(GenProviderKind newProvider) {
		GenProviderKind oldProvider = provider;
		provider = newProvider == null ? PROVIDER_EDEFAULT : newProvider;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_CLASS__PROVIDER, oldProvider, provider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isImage() {
		return image;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImage(boolean newImage) {
		boolean oldImage = image;
		image = newImage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_CLASS__IMAGE, oldImage, image));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDynamic() {
		return dynamic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDynamic(boolean newDynamic) {
		boolean oldDynamic = dynamic;
		dynamic = newDynamic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_CLASS__DYNAMIC, oldDynamic, dynamic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEcoreClass() {
		if (ecoreClass != null && ecoreClass.eIsProxy()) {
			InternalEObject oldEcoreClass = (InternalEObject)ecoreClass;
			ecoreClass = (EClass)eResolveProxy(oldEcoreClass);
			if (ecoreClass != oldEcoreClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GenmodelPackage.GEN_CLASS__ECORE_CLASS, oldEcoreClass, ecoreClass));
			}
		}
		return ecoreClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetEcoreClass() {
		return ecoreClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEcoreClass(EClass newEcoreClass) {
		EClass oldEcoreClass = ecoreClass;
		ecoreClass = newEcoreClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_CLASS__ECORE_CLASS, oldEcoreClass, ecoreClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GenFeature> getGenFeatures() {
		if (genFeatures == null) {
			genFeatures = new EObjectContainmentWithInverseEList<GenFeature>(GenFeature.class, this, GenmodelPackage.GEN_CLASS__GEN_FEATURES, GenmodelPackage.GEN_FEATURE__GEN_CLASS);
		}
		return genFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GenOperation> getGenOperations() {
		if (genOperations == null) {
			genOperations = new EObjectContainmentWithInverseEList<GenOperation>(GenOperation.class, this, GenmodelPackage.GEN_CLASS__GEN_OPERATIONS, GenmodelPackage.GEN_OPERATION__GEN_CLASS);
		}
		return genOperations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenFeature getLabelFeature() {
		if (labelFeature != null && labelFeature.eIsProxy()) {
			InternalEObject oldLabelFeature = (InternalEObject)labelFeature;
			labelFeature = (GenFeature)eResolveProxy(oldLabelFeature);
			if (labelFeature != oldLabelFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GenmodelPackage.GEN_CLASS__LABEL_FEATURE, oldLabelFeature, labelFeature));
			}
		}
		return labelFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenFeature basicGetLabelFeature() {
		return labelFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabelFeature(GenFeature newLabelFeature) {
		GenFeature oldLabelFeature = labelFeature;
		labelFeature = newLabelFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_CLASS__LABEL_FEATURE, oldLabelFeature, labelFeature));
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
			case GenmodelPackage.GEN_CLASS__GEN_FEATURES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getGenFeatures()).basicAdd(otherEnd, msgs);
			case GenmodelPackage.GEN_CLASS__GEN_OPERATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getGenOperations()).basicAdd(otherEnd, msgs);
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
			case GenmodelPackage.GEN_CLASS__GEN_FEATURES:
				return ((InternalEList<?>)getGenFeatures()).basicRemove(otherEnd, msgs);
			case GenmodelPackage.GEN_CLASS__GEN_OPERATIONS:
				return ((InternalEList<?>)getGenOperations()).basicRemove(otherEnd, msgs);
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
			case GenmodelPackage.GEN_CLASS__PROVIDER:
				return getProvider();
			case GenmodelPackage.GEN_CLASS__IMAGE:
				return isImage();
			case GenmodelPackage.GEN_CLASS__DYNAMIC:
				return isDynamic();
			case GenmodelPackage.GEN_CLASS__ECORE_CLASS:
				if (resolve) return getEcoreClass();
				return basicGetEcoreClass();
			case GenmodelPackage.GEN_CLASS__GEN_FEATURES:
				return getGenFeatures();
			case GenmodelPackage.GEN_CLASS__GEN_OPERATIONS:
				return getGenOperations();
			case GenmodelPackage.GEN_CLASS__LABEL_FEATURE:
				if (resolve) return getLabelFeature();
				return basicGetLabelFeature();
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
			case GenmodelPackage.GEN_CLASS__PROVIDER:
				setProvider((GenProviderKind)newValue);
				return;
			case GenmodelPackage.GEN_CLASS__IMAGE:
				setImage((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_CLASS__DYNAMIC:
				setDynamic((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_CLASS__ECORE_CLASS:
				setEcoreClass((EClass)newValue);
				return;
			case GenmodelPackage.GEN_CLASS__GEN_FEATURES:
				getGenFeatures().clear();
				getGenFeatures().addAll((Collection<? extends GenFeature>)newValue);
				return;
			case GenmodelPackage.GEN_CLASS__GEN_OPERATIONS:
				getGenOperations().clear();
				getGenOperations().addAll((Collection<? extends GenOperation>)newValue);
				return;
			case GenmodelPackage.GEN_CLASS__LABEL_FEATURE:
				setLabelFeature((GenFeature)newValue);
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
			case GenmodelPackage.GEN_CLASS__PROVIDER:
				setProvider(PROVIDER_EDEFAULT);
				return;
			case GenmodelPackage.GEN_CLASS__IMAGE:
				setImage(IMAGE_EDEFAULT);
				return;
			case GenmodelPackage.GEN_CLASS__DYNAMIC:
				setDynamic(DYNAMIC_EDEFAULT);
				return;
			case GenmodelPackage.GEN_CLASS__ECORE_CLASS:
				setEcoreClass((EClass)null);
				return;
			case GenmodelPackage.GEN_CLASS__GEN_FEATURES:
				getGenFeatures().clear();
				return;
			case GenmodelPackage.GEN_CLASS__GEN_OPERATIONS:
				getGenOperations().clear();
				return;
			case GenmodelPackage.GEN_CLASS__LABEL_FEATURE:
				setLabelFeature((GenFeature)null);
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
			case GenmodelPackage.GEN_CLASS__PROVIDER:
				return provider != PROVIDER_EDEFAULT;
			case GenmodelPackage.GEN_CLASS__IMAGE:
				return image != IMAGE_EDEFAULT;
			case GenmodelPackage.GEN_CLASS__DYNAMIC:
				return dynamic != DYNAMIC_EDEFAULT;
			case GenmodelPackage.GEN_CLASS__ECORE_CLASS:
				return ecoreClass != null;
			case GenmodelPackage.GEN_CLASS__GEN_FEATURES:
				return genFeatures != null && !genFeatures.isEmpty();
			case GenmodelPackage.GEN_CLASS__GEN_OPERATIONS:
				return genOperations != null && !genOperations.isEmpty();
			case GenmodelPackage.GEN_CLASS__LABEL_FEATURE:
				return labelFeature != null;
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
		result.append(" (provider: ");
		result.append(provider);
		result.append(", image: ");
		result.append(image);
		result.append(", dynamic: ");
		result.append(dynamic);
		result.append(')');
		return result.toString();
	}

} //GenClassImpl
