/**
 */
package genmodel.impl;

import genmodel.GenmodelPackage;

import java.util.Collection;

import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenTypeParameter;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Classifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link genmodel.impl.GenClassifierImpl#getGenPackage <em>Gen Package</em>}</li>
 *   <li>{@link genmodel.impl.GenClassifierImpl#getGenTypeParameters <em>Gen Type Parameters</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class GenClassifierImpl extends GenBaseImpl implements GenClassifier {
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
	protected GenClassifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GenmodelPackage.Literals.GEN_CLASSIFIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenPackage getGenPackage() {
		// TODO: implement this method to return the 'Gen Package' reference
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GenTypeParameter> getGenTypeParameters() {
		if (genTypeParameters == null) {
			genTypeParameters = new EObjectContainmentEList<GenTypeParameter>(GenTypeParameter.class, this, GenmodelPackage.GEN_CLASSIFIER__GEN_TYPE_PARAMETERS);
		}
		return genTypeParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GenmodelPackage.GEN_CLASSIFIER__GEN_TYPE_PARAMETERS:
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GenmodelPackage.GEN_CLASSIFIER__GEN_PACKAGE:
				return getGenPackage();
			case GenmodelPackage.GEN_CLASSIFIER__GEN_TYPE_PARAMETERS:
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
			case GenmodelPackage.GEN_CLASSIFIER__GEN_TYPE_PARAMETERS:
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
			case GenmodelPackage.GEN_CLASSIFIER__GEN_TYPE_PARAMETERS:
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
			case GenmodelPackage.GEN_CLASSIFIER__GEN_PACKAGE:
				return getGenPackage() != null;
			case GenmodelPackage.GEN_CLASSIFIER__GEN_TYPE_PARAMETERS:
				return genTypeParameters != null && !genTypeParameters.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //GenClassifierImpl
