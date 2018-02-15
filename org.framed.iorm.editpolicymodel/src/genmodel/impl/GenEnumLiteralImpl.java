/**
 */
package genmodel.impl;

import genmodel.GenmodelPackage;

import org.eclipse.emf.codegen.ecore.genmodel.GenEnum;
import org.eclipse.emf.codegen.ecore.genmodel.GenEnumLiteral;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Enum Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link genmodel.impl.GenEnumLiteralImpl#getGenEnum <em>Gen Enum</em>}</li>
 *   <li>{@link genmodel.impl.GenEnumLiteralImpl#getEcoreEnumLiteral <em>Ecore Enum Literal</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenEnumLiteralImpl extends GenBaseImpl implements GenEnumLiteral {
	/**
	 * The cached value of the '{@link #getEcoreEnumLiteral() <em>Ecore Enum Literal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEcoreEnumLiteral()
	 * @generated
	 * @ordered
	 */
	protected EEnumLiteral ecoreEnumLiteral;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenEnumLiteralImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GenmodelPackage.Literals.GEN_ENUM_LITERAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenEnum getGenEnum() {
		if (eContainerFeatureID() != GenmodelPackage.GEN_ENUM_LITERAL__GEN_ENUM) return null;
		return (GenEnum)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGenEnum(GenEnum newGenEnum, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newGenEnum, GenmodelPackage.GEN_ENUM_LITERAL__GEN_ENUM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenEnum(GenEnum newGenEnum) {
		if (newGenEnum != eInternalContainer() || (eContainerFeatureID() != GenmodelPackage.GEN_ENUM_LITERAL__GEN_ENUM && newGenEnum != null)) {
			if (EcoreUtil.isAncestor(this, newGenEnum))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newGenEnum != null)
				msgs = ((InternalEObject)newGenEnum).eInverseAdd(this, GenmodelPackage.GEN_ENUM__GEN_ENUM_LITERALS, GenEnum.class, msgs);
			msgs = basicSetGenEnum(newGenEnum, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_ENUM_LITERAL__GEN_ENUM, newGenEnum, newGenEnum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnumLiteral getEcoreEnumLiteral() {
		if (ecoreEnumLiteral != null && ecoreEnumLiteral.eIsProxy()) {
			InternalEObject oldEcoreEnumLiteral = (InternalEObject)ecoreEnumLiteral;
			ecoreEnumLiteral = (EEnumLiteral)eResolveProxy(oldEcoreEnumLiteral);
			if (ecoreEnumLiteral != oldEcoreEnumLiteral) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GenmodelPackage.GEN_ENUM_LITERAL__ECORE_ENUM_LITERAL, oldEcoreEnumLiteral, ecoreEnumLiteral));
			}
		}
		return ecoreEnumLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnumLiteral basicGetEcoreEnumLiteral() {
		return ecoreEnumLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEcoreEnumLiteral(EEnumLiteral newEcoreEnumLiteral) {
		EEnumLiteral oldEcoreEnumLiteral = ecoreEnumLiteral;
		ecoreEnumLiteral = newEcoreEnumLiteral;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_ENUM_LITERAL__ECORE_ENUM_LITERAL, oldEcoreEnumLiteral, ecoreEnumLiteral));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GenmodelPackage.GEN_ENUM_LITERAL__GEN_ENUM:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetGenEnum((GenEnum)otherEnd, msgs);
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
			case GenmodelPackage.GEN_ENUM_LITERAL__GEN_ENUM:
				return basicSetGenEnum(null, msgs);
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
			case GenmodelPackage.GEN_ENUM_LITERAL__GEN_ENUM:
				return eInternalContainer().eInverseRemove(this, GenmodelPackage.GEN_ENUM__GEN_ENUM_LITERALS, GenEnum.class, msgs);
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
			case GenmodelPackage.GEN_ENUM_LITERAL__GEN_ENUM:
				return getGenEnum();
			case GenmodelPackage.GEN_ENUM_LITERAL__ECORE_ENUM_LITERAL:
				if (resolve) return getEcoreEnumLiteral();
				return basicGetEcoreEnumLiteral();
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
			case GenmodelPackage.GEN_ENUM_LITERAL__GEN_ENUM:
				setGenEnum((GenEnum)newValue);
				return;
			case GenmodelPackage.GEN_ENUM_LITERAL__ECORE_ENUM_LITERAL:
				setEcoreEnumLiteral((EEnumLiteral)newValue);
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
			case GenmodelPackage.GEN_ENUM_LITERAL__GEN_ENUM:
				setGenEnum((GenEnum)null);
				return;
			case GenmodelPackage.GEN_ENUM_LITERAL__ECORE_ENUM_LITERAL:
				setEcoreEnumLiteral((EEnumLiteral)null);
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
			case GenmodelPackage.GEN_ENUM_LITERAL__GEN_ENUM:
				return getGenEnum() != null;
			case GenmodelPackage.GEN_ENUM_LITERAL__ECORE_ENUM_LITERAL:
				return ecoreEnumLiteral != null;
		}
		return super.eIsSet(featureID);
	}

} //GenEnumLiteralImpl
