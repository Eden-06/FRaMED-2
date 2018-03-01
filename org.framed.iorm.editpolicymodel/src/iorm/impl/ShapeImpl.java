/**
 */
package iorm.impl;

import iorm.IormPackage;
import iorm.Model;
import iorm.NamedElement;
import iorm.Segment;
import iorm.Shape;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Shape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link iorm.impl.ShapeImpl#getFirstSegment <em>First Segment</em>}</li>
 *   <li>{@link iorm.impl.ShapeImpl#getSecondSegment <em>Second Segment</em>}</li>
 *   <li>{@link iorm.impl.ShapeImpl#getModel <em>Model</em>}</li>
 *   <li>{@link iorm.impl.ShapeImpl#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ShapeImpl extends ModelElementImpl implements Shape {
	/**
	 * The cached value of the '{@link #getFirstSegment() <em>First Segment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstSegment()
	 * @generated
	 * @ordered
	 */
	protected Segment firstSegment;

	/**
	 * The cached value of the '{@link #getSecondSegment() <em>Second Segment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecondSegment()
	 * @generated
	 * @ordered
	 */
	protected Segment secondSegment;

	/**
	 * The cached value of the '{@link #getModel() <em>Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModel()
	 * @generated
	 * @ordered
	 */
	protected Model model;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected NamedElement description;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ShapeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IormPackage.Literals.SHAPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Segment getFirstSegment() {
		return firstSegment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFirstSegment(Segment newFirstSegment, NotificationChain msgs) {
		Segment oldFirstSegment = firstSegment;
		firstSegment = newFirstSegment;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IormPackage.SHAPE__FIRST_SEGMENT, oldFirstSegment, newFirstSegment);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstSegment(Segment newFirstSegment) {
		if (newFirstSegment != firstSegment) {
			NotificationChain msgs = null;
			if (firstSegment != null)
				msgs = ((InternalEObject)firstSegment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IormPackage.SHAPE__FIRST_SEGMENT, null, msgs);
			if (newFirstSegment != null)
				msgs = ((InternalEObject)newFirstSegment).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IormPackage.SHAPE__FIRST_SEGMENT, null, msgs);
			msgs = basicSetFirstSegment(newFirstSegment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IormPackage.SHAPE__FIRST_SEGMENT, newFirstSegment, newFirstSegment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Segment getSecondSegment() {
		return secondSegment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSecondSegment(Segment newSecondSegment, NotificationChain msgs) {
		Segment oldSecondSegment = secondSegment;
		secondSegment = newSecondSegment;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IormPackage.SHAPE__SECOND_SEGMENT, oldSecondSegment, newSecondSegment);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecondSegment(Segment newSecondSegment) {
		if (newSecondSegment != secondSegment) {
			NotificationChain msgs = null;
			if (secondSegment != null)
				msgs = ((InternalEObject)secondSegment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IormPackage.SHAPE__SECOND_SEGMENT, null, msgs);
			if (newSecondSegment != null)
				msgs = ((InternalEObject)newSecondSegment).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IormPackage.SHAPE__SECOND_SEGMENT, null, msgs);
			msgs = basicSetSecondSegment(newSecondSegment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IormPackage.SHAPE__SECOND_SEGMENT, newSecondSegment, newSecondSegment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetModel(Model newModel, NotificationChain msgs) {
		Model oldModel = model;
		model = newModel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IormPackage.SHAPE__MODEL, oldModel, newModel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModel(Model newModel) {
		if (newModel != model) {
			NotificationChain msgs = null;
			if (model != null)
				msgs = ((InternalEObject)model).eInverseRemove(this, IormPackage.MODEL__PARENT, Model.class, msgs);
			if (newModel != null)
				msgs = ((InternalEObject)newModel).eInverseAdd(this, IormPackage.MODEL__PARENT, Model.class, msgs);
			msgs = basicSetModel(newModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IormPackage.SHAPE__MODEL, newModel, newModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDescription(NamedElement newDescription, NotificationChain msgs) {
		NamedElement oldDescription = description;
		description = newDescription;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IormPackage.SHAPE__DESCRIPTION, oldDescription, newDescription);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(NamedElement newDescription) {
		if (newDescription != description) {
			NotificationChain msgs = null;
			if (description != null)
				msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IormPackage.SHAPE__DESCRIPTION, null, msgs);
			if (newDescription != null)
				msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IormPackage.SHAPE__DESCRIPTION, null, msgs);
			msgs = basicSetDescription(newDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IormPackage.SHAPE__DESCRIPTION, newDescription, newDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IormPackage.SHAPE__MODEL:
				if (model != null)
					msgs = ((InternalEObject)model).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IormPackage.SHAPE__MODEL, null, msgs);
				return basicSetModel((Model)otherEnd, msgs);
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
			case IormPackage.SHAPE__FIRST_SEGMENT:
				return basicSetFirstSegment(null, msgs);
			case IormPackage.SHAPE__SECOND_SEGMENT:
				return basicSetSecondSegment(null, msgs);
			case IormPackage.SHAPE__MODEL:
				return basicSetModel(null, msgs);
			case IormPackage.SHAPE__DESCRIPTION:
				return basicSetDescription(null, msgs);
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
			case IormPackage.SHAPE__FIRST_SEGMENT:
				return getFirstSegment();
			case IormPackage.SHAPE__SECOND_SEGMENT:
				return getSecondSegment();
			case IormPackage.SHAPE__MODEL:
				return getModel();
			case IormPackage.SHAPE__DESCRIPTION:
				return getDescription();
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
			case IormPackage.SHAPE__FIRST_SEGMENT:
				setFirstSegment((Segment)newValue);
				return;
			case IormPackage.SHAPE__SECOND_SEGMENT:
				setSecondSegment((Segment)newValue);
				return;
			case IormPackage.SHAPE__MODEL:
				setModel((Model)newValue);
				return;
			case IormPackage.SHAPE__DESCRIPTION:
				setDescription((NamedElement)newValue);
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
			case IormPackage.SHAPE__FIRST_SEGMENT:
				setFirstSegment((Segment)null);
				return;
			case IormPackage.SHAPE__SECOND_SEGMENT:
				setSecondSegment((Segment)null);
				return;
			case IormPackage.SHAPE__MODEL:
				setModel((Model)null);
				return;
			case IormPackage.SHAPE__DESCRIPTION:
				setDescription((NamedElement)null);
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
			case IormPackage.SHAPE__FIRST_SEGMENT:
				return firstSegment != null;
			case IormPackage.SHAPE__SECOND_SEGMENT:
				return secondSegment != null;
			case IormPackage.SHAPE__MODEL:
				return model != null;
			case IormPackage.SHAPE__DESCRIPTION:
				return description != null;
		}
		return super.eIsSet(featureID);
	}

} //ShapeImpl
