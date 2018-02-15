/**
 */
package genmodel.impl;

import genmodel.GenmodelPackage;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.codegen.ecore.genmodel.GenAnnotation;
import org.eclipse.emf.codegen.ecore.genmodel.GenBase;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Base</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link genmodel.impl.GenBaseImpl#getGenAnnotations <em>Gen Annotations</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class GenBaseImpl extends MinimalEObjectImpl.Container implements GenBase {
	/**
	 * The cached value of the '{@link #getGenAnnotations() <em>Gen Annotations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EList<GenAnnotation> genAnnotations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenBaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GenmodelPackage.Literals.GEN_BASE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GenAnnotation> getGenAnnotations() {
		if (genAnnotations == null) {
			genAnnotations = new EObjectContainmentWithInverseEList<GenAnnotation>(GenAnnotation.class, this, GenmodelPackage.GEN_BASE__GEN_ANNOTATIONS, GenmodelPackage.GEN_ANNOTATION__GEN_BASE);
		}
		return genAnnotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenAnnotation getGenAnnotation(String source) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
			case GenmodelPackage.GEN_BASE__GEN_ANNOTATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getGenAnnotations()).basicAdd(otherEnd, msgs);
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
			case GenmodelPackage.GEN_BASE__GEN_ANNOTATIONS:
				return ((InternalEList<?>)getGenAnnotations()).basicRemove(otherEnd, msgs);
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
			case GenmodelPackage.GEN_BASE__GEN_ANNOTATIONS:
				return getGenAnnotations();
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
			case GenmodelPackage.GEN_BASE__GEN_ANNOTATIONS:
				getGenAnnotations().clear();
				getGenAnnotations().addAll((Collection<? extends GenAnnotation>)newValue);
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
			case GenmodelPackage.GEN_BASE__GEN_ANNOTATIONS:
				getGenAnnotations().clear();
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
			case GenmodelPackage.GEN_BASE__GEN_ANNOTATIONS:
				return genAnnotations != null && !genAnnotations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case GenmodelPackage.GEN_BASE___GET_GEN_ANNOTATION__STRING:
				return getGenAnnotation((String)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} //GenBaseImpl
