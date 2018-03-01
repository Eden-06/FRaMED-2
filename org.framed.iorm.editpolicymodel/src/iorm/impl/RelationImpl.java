/**
 */
package iorm.impl;

import iorm.IormPackage;
import iorm.ModelElement;
import iorm.NamedElement;
import iorm.Relation;
import iorm.Shape;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link iorm.impl.RelationImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link iorm.impl.RelationImpl#getSource <em>Source</em>}</li>
 *   <li>{@link iorm.impl.RelationImpl#getSourceLabel <em>Source Label</em>}</li>
 *   <li>{@link iorm.impl.RelationImpl#getTargetLabel <em>Target Label</em>}</li>
 *   <li>{@link iorm.impl.RelationImpl#getReferencedRelation <em>Referenced Relation</em>}</li>
 *   <li>{@link iorm.impl.RelationImpl#getReferencedRoles <em>Referenced Roles</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RelationImpl extends ModelElementImpl implements Relation {
	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected ModelElement target;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected ModelElement source;

	/**
	 * The cached value of the '{@link #getSourceLabel() <em>Source Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceLabel()
	 * @generated
	 * @ordered
	 */
	protected NamedElement sourceLabel;

	/**
	 * The cached value of the '{@link #getTargetLabel() <em>Target Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetLabel()
	 * @generated
	 * @ordered
	 */
	protected NamedElement targetLabel;

	/**
	 * The cached value of the '{@link #getReferencedRelation() <em>Referenced Relation</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedRelation()
	 * @generated
	 * @ordered
	 */
	protected EList<Relation> referencedRelation;

	/**
	 * The cached value of the '{@link #getReferencedRoles() <em>Referenced Roles</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedRoles()
	 * @generated
	 * @ordered
	 */
	protected EList<Shape> referencedRoles;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IormPackage.Literals.RELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElement getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (ModelElement)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IormPackage.RELATION__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElement basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(ModelElement newTarget, NotificationChain msgs) {
		ModelElement oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IormPackage.RELATION__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(ModelElement newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, IormPackage.MODEL_ELEMENT__INCOMING_RELATIONS, ModelElement.class, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, IormPackage.MODEL_ELEMENT__INCOMING_RELATIONS, ModelElement.class, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IormPackage.RELATION__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElement getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (ModelElement)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IormPackage.RELATION__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElement basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(ModelElement newSource, NotificationChain msgs) {
		ModelElement oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IormPackage.RELATION__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(ModelElement newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, IormPackage.MODEL_ELEMENT__OUTGOING_RELATIONS, ModelElement.class, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, IormPackage.MODEL_ELEMENT__OUTGOING_RELATIONS, ModelElement.class, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IormPackage.RELATION__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement getSourceLabel() {
		return sourceLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourceLabel(NamedElement newSourceLabel, NotificationChain msgs) {
		NamedElement oldSourceLabel = sourceLabel;
		sourceLabel = newSourceLabel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IormPackage.RELATION__SOURCE_LABEL, oldSourceLabel, newSourceLabel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceLabel(NamedElement newSourceLabel) {
		if (newSourceLabel != sourceLabel) {
			NotificationChain msgs = null;
			if (sourceLabel != null)
				msgs = ((InternalEObject)sourceLabel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IormPackage.RELATION__SOURCE_LABEL, null, msgs);
			if (newSourceLabel != null)
				msgs = ((InternalEObject)newSourceLabel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IormPackage.RELATION__SOURCE_LABEL, null, msgs);
			msgs = basicSetSourceLabel(newSourceLabel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IormPackage.RELATION__SOURCE_LABEL, newSourceLabel, newSourceLabel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement getTargetLabel() {
		return targetLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetLabel(NamedElement newTargetLabel, NotificationChain msgs) {
		NamedElement oldTargetLabel = targetLabel;
		targetLabel = newTargetLabel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IormPackage.RELATION__TARGET_LABEL, oldTargetLabel, newTargetLabel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetLabel(NamedElement newTargetLabel) {
		if (newTargetLabel != targetLabel) {
			NotificationChain msgs = null;
			if (targetLabel != null)
				msgs = ((InternalEObject)targetLabel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IormPackage.RELATION__TARGET_LABEL, null, msgs);
			if (newTargetLabel != null)
				msgs = ((InternalEObject)newTargetLabel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IormPackage.RELATION__TARGET_LABEL, null, msgs);
			msgs = basicSetTargetLabel(newTargetLabel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IormPackage.RELATION__TARGET_LABEL, newTargetLabel, newTargetLabel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Relation> getReferencedRelation() {
		if (referencedRelation == null) {
			referencedRelation = new EObjectResolvingEList<Relation>(Relation.class, this, IormPackage.RELATION__REFERENCED_RELATION);
		}
		return referencedRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Shape> getReferencedRoles() {
		if (referencedRoles == null) {
			referencedRoles = new EObjectResolvingEList<Shape>(Shape.class, this, IormPackage.RELATION__REFERENCED_ROLES);
		}
		return referencedRoles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IormPackage.RELATION__TARGET:
				if (target != null)
					msgs = ((InternalEObject)target).eInverseRemove(this, IormPackage.MODEL_ELEMENT__INCOMING_RELATIONS, ModelElement.class, msgs);
				return basicSetTarget((ModelElement)otherEnd, msgs);
			case IormPackage.RELATION__SOURCE:
				if (source != null)
					msgs = ((InternalEObject)source).eInverseRemove(this, IormPackage.MODEL_ELEMENT__OUTGOING_RELATIONS, ModelElement.class, msgs);
				return basicSetSource((ModelElement)otherEnd, msgs);
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
			case IormPackage.RELATION__TARGET:
				return basicSetTarget(null, msgs);
			case IormPackage.RELATION__SOURCE:
				return basicSetSource(null, msgs);
			case IormPackage.RELATION__SOURCE_LABEL:
				return basicSetSourceLabel(null, msgs);
			case IormPackage.RELATION__TARGET_LABEL:
				return basicSetTargetLabel(null, msgs);
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
			case IormPackage.RELATION__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case IormPackage.RELATION__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case IormPackage.RELATION__SOURCE_LABEL:
				return getSourceLabel();
			case IormPackage.RELATION__TARGET_LABEL:
				return getTargetLabel();
			case IormPackage.RELATION__REFERENCED_RELATION:
				return getReferencedRelation();
			case IormPackage.RELATION__REFERENCED_ROLES:
				return getReferencedRoles();
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
			case IormPackage.RELATION__TARGET:
				setTarget((ModelElement)newValue);
				return;
			case IormPackage.RELATION__SOURCE:
				setSource((ModelElement)newValue);
				return;
			case IormPackage.RELATION__SOURCE_LABEL:
				setSourceLabel((NamedElement)newValue);
				return;
			case IormPackage.RELATION__TARGET_LABEL:
				setTargetLabel((NamedElement)newValue);
				return;
			case IormPackage.RELATION__REFERENCED_RELATION:
				getReferencedRelation().clear();
				getReferencedRelation().addAll((Collection<? extends Relation>)newValue);
				return;
			case IormPackage.RELATION__REFERENCED_ROLES:
				getReferencedRoles().clear();
				getReferencedRoles().addAll((Collection<? extends Shape>)newValue);
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
			case IormPackage.RELATION__TARGET:
				setTarget((ModelElement)null);
				return;
			case IormPackage.RELATION__SOURCE:
				setSource((ModelElement)null);
				return;
			case IormPackage.RELATION__SOURCE_LABEL:
				setSourceLabel((NamedElement)null);
				return;
			case IormPackage.RELATION__TARGET_LABEL:
				setTargetLabel((NamedElement)null);
				return;
			case IormPackage.RELATION__REFERENCED_RELATION:
				getReferencedRelation().clear();
				return;
			case IormPackage.RELATION__REFERENCED_ROLES:
				getReferencedRoles().clear();
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
			case IormPackage.RELATION__TARGET:
				return target != null;
			case IormPackage.RELATION__SOURCE:
				return source != null;
			case IormPackage.RELATION__SOURCE_LABEL:
				return sourceLabel != null;
			case IormPackage.RELATION__TARGET_LABEL:
				return targetLabel != null;
			case IormPackage.RELATION__REFERENCED_RELATION:
				return referencedRelation != null && !referencedRelation.isEmpty();
			case IormPackage.RELATION__REFERENCED_ROLES:
				return referencedRoles != null && !referencedRoles.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RelationImpl
