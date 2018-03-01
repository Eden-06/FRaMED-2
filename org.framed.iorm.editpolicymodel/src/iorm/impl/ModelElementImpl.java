/**
 */
package iorm.impl;

import iorm.IormPackage;
import iorm.Model;
import iorm.ModelElement;
import iorm.Relation;
import iorm.Type;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link iorm.impl.ModelElementImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link iorm.impl.ModelElementImpl#getIncomingRelations <em>Incoming Relations</em>}</li>
 *   <li>{@link iorm.impl.ModelElementImpl#getOutgoingRelations <em>Outgoing Relations</em>}</li>
 *   <li>{@link iorm.impl.ModelElementImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelElementImpl extends NamedElementImpl implements ModelElement {
	/**
	 * The cached value of the '{@link #getIncomingRelations() <em>Incoming Relations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingRelations()
	 * @generated
	 * @ordered
	 */
	protected EList<Relation> incomingRelations;

	/**
	 * The cached value of the '{@link #getOutgoingRelations() <em>Outgoing Relations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingRelations()
	 * @generated
	 * @ordered
	 */
	protected EList<Relation> outgoingRelations;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final Type TYPE_EDEFAULT = Type.COMPARTMENT_TYPE;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected Type type = TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IormPackage.Literals.MODEL_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model getContainer() {
		if (eContainerFeatureID() != IormPackage.MODEL_ELEMENT__CONTAINER) return null;
		return (Model)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainer(Model newContainer, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContainer, IormPackage.MODEL_ELEMENT__CONTAINER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainer(Model newContainer) {
		if (newContainer != eInternalContainer() || (eContainerFeatureID() != IormPackage.MODEL_ELEMENT__CONTAINER && newContainer != null)) {
			if (EcoreUtil.isAncestor(this, newContainer))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainer != null)
				msgs = ((InternalEObject)newContainer).eInverseAdd(this, IormPackage.MODEL__ELEMENTS, Model.class, msgs);
			msgs = basicSetContainer(newContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IormPackage.MODEL_ELEMENT__CONTAINER, newContainer, newContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Relation> getIncomingRelations() {
		if (incomingRelations == null) {
			incomingRelations = new EObjectWithInverseResolvingEList<Relation>(Relation.class, this, IormPackage.MODEL_ELEMENT__INCOMING_RELATIONS, IormPackage.RELATION__TARGET);
		}
		return incomingRelations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Relation> getOutgoingRelations() {
		if (outgoingRelations == null) {
			outgoingRelations = new EObjectWithInverseResolvingEList<Relation>(Relation.class, this, IormPackage.MODEL_ELEMENT__OUTGOING_RELATIONS, IormPackage.RELATION__SOURCE);
		}
		return outgoingRelations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(Type newType) {
		Type oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IormPackage.MODEL_ELEMENT__TYPE, oldType, type));
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
			case IormPackage.MODEL_ELEMENT__CONTAINER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContainer((Model)otherEnd, msgs);
			case IormPackage.MODEL_ELEMENT__INCOMING_RELATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingRelations()).basicAdd(otherEnd, msgs);
			case IormPackage.MODEL_ELEMENT__OUTGOING_RELATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingRelations()).basicAdd(otherEnd, msgs);
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
			case IormPackage.MODEL_ELEMENT__CONTAINER:
				return basicSetContainer(null, msgs);
			case IormPackage.MODEL_ELEMENT__INCOMING_RELATIONS:
				return ((InternalEList<?>)getIncomingRelations()).basicRemove(otherEnd, msgs);
			case IormPackage.MODEL_ELEMENT__OUTGOING_RELATIONS:
				return ((InternalEList<?>)getOutgoingRelations()).basicRemove(otherEnd, msgs);
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
			case IormPackage.MODEL_ELEMENT__CONTAINER:
				return eInternalContainer().eInverseRemove(this, IormPackage.MODEL__ELEMENTS, Model.class, msgs);
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
			case IormPackage.MODEL_ELEMENT__CONTAINER:
				return getContainer();
			case IormPackage.MODEL_ELEMENT__INCOMING_RELATIONS:
				return getIncomingRelations();
			case IormPackage.MODEL_ELEMENT__OUTGOING_RELATIONS:
				return getOutgoingRelations();
			case IormPackage.MODEL_ELEMENT__TYPE:
				return getType();
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
			case IormPackage.MODEL_ELEMENT__CONTAINER:
				setContainer((Model)newValue);
				return;
			case IormPackage.MODEL_ELEMENT__INCOMING_RELATIONS:
				getIncomingRelations().clear();
				getIncomingRelations().addAll((Collection<? extends Relation>)newValue);
				return;
			case IormPackage.MODEL_ELEMENT__OUTGOING_RELATIONS:
				getOutgoingRelations().clear();
				getOutgoingRelations().addAll((Collection<? extends Relation>)newValue);
				return;
			case IormPackage.MODEL_ELEMENT__TYPE:
				setType((Type)newValue);
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
			case IormPackage.MODEL_ELEMENT__CONTAINER:
				setContainer((Model)null);
				return;
			case IormPackage.MODEL_ELEMENT__INCOMING_RELATIONS:
				getIncomingRelations().clear();
				return;
			case IormPackage.MODEL_ELEMENT__OUTGOING_RELATIONS:
				getOutgoingRelations().clear();
				return;
			case IormPackage.MODEL_ELEMENT__TYPE:
				setType(TYPE_EDEFAULT);
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
			case IormPackage.MODEL_ELEMENT__CONTAINER:
				return getContainer() != null;
			case IormPackage.MODEL_ELEMENT__INCOMING_RELATIONS:
				return incomingRelations != null && !incomingRelations.isEmpty();
			case IormPackage.MODEL_ELEMENT__OUTGOING_RELATIONS:
				return outgoingRelations != null && !outgoingRelations.isEmpty();
			case IormPackage.MODEL_ELEMENT__TYPE:
				return type != TYPE_EDEFAULT;
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
		result.append(" (type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //ModelElementImpl
