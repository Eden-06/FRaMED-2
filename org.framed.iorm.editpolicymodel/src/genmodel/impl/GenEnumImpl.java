/**
 */
package genmodel.impl;

import genmodel.GenmodelPackage;

import java.util.Collection;

import org.eclipse.emf.codegen.ecore.genmodel.GenEnum;
import org.eclipse.emf.codegen.ecore.genmodel.GenEnumLiteral;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Enum</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link genmodel.impl.GenEnumImpl#isTypeSafeEnumCompatible <em>Type Safe Enum Compatible</em>}</li>
 *   <li>{@link genmodel.impl.GenEnumImpl#getEcoreEnum <em>Ecore Enum</em>}</li>
 *   <li>{@link genmodel.impl.GenEnumImpl#getGenEnumLiterals <em>Gen Enum Literals</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenEnumImpl extends GenDataTypeImpl implements GenEnum {
	/**
	 * The default value of the '{@link #isTypeSafeEnumCompatible() <em>Type Safe Enum Compatible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTypeSafeEnumCompatible()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TYPE_SAFE_ENUM_COMPATIBLE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isTypeSafeEnumCompatible() <em>Type Safe Enum Compatible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTypeSafeEnumCompatible()
	 * @generated
	 * @ordered
	 */
	protected boolean typeSafeEnumCompatible = TYPE_SAFE_ENUM_COMPATIBLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEcoreEnum() <em>Ecore Enum</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEcoreEnum()
	 * @generated
	 * @ordered
	 */
	protected EEnum ecoreEnum;

	/**
	 * The cached value of the '{@link #getGenEnumLiterals() <em>Gen Enum Literals</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenEnumLiterals()
	 * @generated
	 * @ordered
	 */
	protected EList<GenEnumLiteral> genEnumLiterals;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenEnumImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GenmodelPackage.Literals.GEN_ENUM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTypeSafeEnumCompatible() {
		return typeSafeEnumCompatible;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeSafeEnumCompatible(boolean newTypeSafeEnumCompatible) {
		boolean oldTypeSafeEnumCompatible = typeSafeEnumCompatible;
		typeSafeEnumCompatible = newTypeSafeEnumCompatible;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_ENUM__TYPE_SAFE_ENUM_COMPATIBLE, oldTypeSafeEnumCompatible, typeSafeEnumCompatible));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEcoreEnum() {
		if (ecoreEnum != null && ecoreEnum.eIsProxy()) {
			InternalEObject oldEcoreEnum = (InternalEObject)ecoreEnum;
			ecoreEnum = (EEnum)eResolveProxy(oldEcoreEnum);
			if (ecoreEnum != oldEcoreEnum) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GenmodelPackage.GEN_ENUM__ECORE_ENUM, oldEcoreEnum, ecoreEnum));
			}
		}
		return ecoreEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum basicGetEcoreEnum() {
		return ecoreEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEcoreEnum(EEnum newEcoreEnum) {
		EEnum oldEcoreEnum = ecoreEnum;
		ecoreEnum = newEcoreEnum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_ENUM__ECORE_ENUM, oldEcoreEnum, ecoreEnum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GenEnumLiteral> getGenEnumLiterals() {
		if (genEnumLiterals == null) {
			genEnumLiterals = new EObjectContainmentWithInverseEList<GenEnumLiteral>(GenEnumLiteral.class, this, GenmodelPackage.GEN_ENUM__GEN_ENUM_LITERALS, GenmodelPackage.GEN_ENUM_LITERAL__GEN_ENUM);
		}
		return genEnumLiterals;
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
			case GenmodelPackage.GEN_ENUM__GEN_ENUM_LITERALS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getGenEnumLiterals()).basicAdd(otherEnd, msgs);
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
			case GenmodelPackage.GEN_ENUM__GEN_ENUM_LITERALS:
				return ((InternalEList<?>)getGenEnumLiterals()).basicRemove(otherEnd, msgs);
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
			case GenmodelPackage.GEN_ENUM__TYPE_SAFE_ENUM_COMPATIBLE:
				return isTypeSafeEnumCompatible();
			case GenmodelPackage.GEN_ENUM__ECORE_ENUM:
				if (resolve) return getEcoreEnum();
				return basicGetEcoreEnum();
			case GenmodelPackage.GEN_ENUM__GEN_ENUM_LITERALS:
				return getGenEnumLiterals();
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
			case GenmodelPackage.GEN_ENUM__TYPE_SAFE_ENUM_COMPATIBLE:
				setTypeSafeEnumCompatible((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_ENUM__ECORE_ENUM:
				setEcoreEnum((EEnum)newValue);
				return;
			case GenmodelPackage.GEN_ENUM__GEN_ENUM_LITERALS:
				getGenEnumLiterals().clear();
				getGenEnumLiterals().addAll((Collection<? extends GenEnumLiteral>)newValue);
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
			case GenmodelPackage.GEN_ENUM__TYPE_SAFE_ENUM_COMPATIBLE:
				setTypeSafeEnumCompatible(TYPE_SAFE_ENUM_COMPATIBLE_EDEFAULT);
				return;
			case GenmodelPackage.GEN_ENUM__ECORE_ENUM:
				setEcoreEnum((EEnum)null);
				return;
			case GenmodelPackage.GEN_ENUM__GEN_ENUM_LITERALS:
				getGenEnumLiterals().clear();
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
			case GenmodelPackage.GEN_ENUM__TYPE_SAFE_ENUM_COMPATIBLE:
				return typeSafeEnumCompatible != TYPE_SAFE_ENUM_COMPATIBLE_EDEFAULT;
			case GenmodelPackage.GEN_ENUM__ECORE_ENUM:
				return ecoreEnum != null;
			case GenmodelPackage.GEN_ENUM__GEN_ENUM_LITERALS:
				return genEnumLiterals != null && !genEnumLiterals.isEmpty();
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
		result.append(" (typeSafeEnumCompatible: ");
		result.append(typeSafeEnumCompatible);
		result.append(')');
		return result.toString();
	}

} //GenEnumImpl
