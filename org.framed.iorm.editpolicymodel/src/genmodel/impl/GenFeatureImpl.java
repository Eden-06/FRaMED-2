/**
 */
package genmodel.impl;

import genmodel.GenPropertyKind;
import genmodel.GenmodelPackage;

import java.util.Collection;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link genmodel.impl.GenFeatureImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link genmodel.impl.GenFeatureImpl#isNotify <em>Notify</em>}</li>
 *   <li>{@link genmodel.impl.GenFeatureImpl#isChildren <em>Children</em>}</li>
 *   <li>{@link genmodel.impl.GenFeatureImpl#isCreateChild <em>Create Child</em>}</li>
 *   <li>{@link genmodel.impl.GenFeatureImpl#getPropertyCategory <em>Property Category</em>}</li>
 *   <li>{@link genmodel.impl.GenFeatureImpl#getPropertyFilterFlags <em>Property Filter Flags</em>}</li>
 *   <li>{@link genmodel.impl.GenFeatureImpl#getPropertyDescription <em>Property Description</em>}</li>
 *   <li>{@link genmodel.impl.GenFeatureImpl#isPropertyMultiLine <em>Property Multi Line</em>}</li>
 *   <li>{@link genmodel.impl.GenFeatureImpl#isPropertySortChoices <em>Property Sort Choices</em>}</li>
 *   <li>{@link genmodel.impl.GenFeatureImpl#getGenClass <em>Gen Class</em>}</li>
 *   <li>{@link genmodel.impl.GenFeatureImpl#getEcoreFeature <em>Ecore Feature</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenFeatureImpl extends GenTypedElementImpl implements GenFeature {
	/**
	 * The default value of the '{@link #getProperty() <em>Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperty()
	 * @generated
	 * @ordered
	 */
	protected static final GenPropertyKind PROPERTY_EDEFAULT = GenPropertyKind.EDITABLE;

	/**
	 * The cached value of the '{@link #getProperty() <em>Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperty()
	 * @generated
	 * @ordered
	 */
	protected GenPropertyKind property = PROPERTY_EDEFAULT;

	/**
	 * The default value of the '{@link #isNotify() <em>Notify</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNotify()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NOTIFY_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isNotify() <em>Notify</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNotify()
	 * @generated
	 * @ordered
	 */
	protected boolean notify = NOTIFY_EDEFAULT;

	/**
	 * The default value of the '{@link #isChildren() <em>Children</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isChildren()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CHILDREN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isChildren() <em>Children</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isChildren()
	 * @generated
	 * @ordered
	 */
	protected boolean children = CHILDREN_EDEFAULT;

	/**
	 * The default value of the '{@link #isCreateChild() <em>Create Child</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCreateChild()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CREATE_CHILD_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCreateChild() <em>Create Child</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCreateChild()
	 * @generated
	 * @ordered
	 */
	protected boolean createChild = CREATE_CHILD_EDEFAULT;

	/**
	 * This is true if the Create Child attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean createChildESet;

	/**
	 * The default value of the '{@link #getPropertyCategory() <em>Property Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyCategory()
	 * @generated
	 * @ordered
	 */
	protected static final String PROPERTY_CATEGORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPropertyCategory() <em>Property Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyCategory()
	 * @generated
	 * @ordered
	 */
	protected String propertyCategory = PROPERTY_CATEGORY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPropertyFilterFlags() <em>Property Filter Flags</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyFilterFlags()
	 * @generated
	 * @ordered
	 */
	protected EList<String> propertyFilterFlags;

	/**
	 * The default value of the '{@link #getPropertyDescription() <em>Property Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String PROPERTY_DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPropertyDescription() <em>Property Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyDescription()
	 * @generated
	 * @ordered
	 */
	protected String propertyDescription = PROPERTY_DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #isPropertyMultiLine() <em>Property Multi Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPropertyMultiLine()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PROPERTY_MULTI_LINE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPropertyMultiLine() <em>Property Multi Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPropertyMultiLine()
	 * @generated
	 * @ordered
	 */
	protected boolean propertyMultiLine = PROPERTY_MULTI_LINE_EDEFAULT;

	/**
	 * The default value of the '{@link #isPropertySortChoices() <em>Property Sort Choices</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPropertySortChoices()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PROPERTY_SORT_CHOICES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPropertySortChoices() <em>Property Sort Choices</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPropertySortChoices()
	 * @generated
	 * @ordered
	 */
	protected boolean propertySortChoices = PROPERTY_SORT_CHOICES_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEcoreFeature() <em>Ecore Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEcoreFeature()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature ecoreFeature;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenFeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GenmodelPackage.Literals.GEN_FEATURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenPropertyKind getProperty() {
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProperty(GenPropertyKind newProperty) {
		GenPropertyKind oldProperty = property;
		property = newProperty == null ? PROPERTY_EDEFAULT : newProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_FEATURE__PROPERTY, oldProperty, property));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNotify() {
		return notify;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNotify(boolean newNotify) {
		boolean oldNotify = notify;
		notify = newNotify;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_FEATURE__NOTIFY, oldNotify, notify));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isChildren() {
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChildren(boolean newChildren) {
		boolean oldChildren = children;
		children = newChildren;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_FEATURE__CHILDREN, oldChildren, children));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCreateChild() {
		return createChild;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreateChild(boolean newCreateChild) {
		boolean oldCreateChild = createChild;
		createChild = newCreateChild;
		boolean oldCreateChildESet = createChildESet;
		createChildESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_FEATURE__CREATE_CHILD, oldCreateChild, createChild, !oldCreateChildESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCreateChild() {
		boolean oldCreateChild = createChild;
		boolean oldCreateChildESet = createChildESet;
		createChild = CREATE_CHILD_EDEFAULT;
		createChildESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, GenmodelPackage.GEN_FEATURE__CREATE_CHILD, oldCreateChild, CREATE_CHILD_EDEFAULT, oldCreateChildESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCreateChild() {
		return createChildESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPropertyCategory() {
		return propertyCategory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyCategory(String newPropertyCategory) {
		String oldPropertyCategory = propertyCategory;
		propertyCategory = newPropertyCategory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_FEATURE__PROPERTY_CATEGORY, oldPropertyCategory, propertyCategory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getPropertyFilterFlags() {
		if (propertyFilterFlags == null) {
			propertyFilterFlags = new EDataTypeUniqueEList<String>(String.class, this, GenmodelPackage.GEN_FEATURE__PROPERTY_FILTER_FLAGS);
		}
		return propertyFilterFlags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPropertyDescription() {
		return propertyDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyDescription(String newPropertyDescription) {
		String oldPropertyDescription = propertyDescription;
		propertyDescription = newPropertyDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_FEATURE__PROPERTY_DESCRIPTION, oldPropertyDescription, propertyDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPropertyMultiLine() {
		return propertyMultiLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyMultiLine(boolean newPropertyMultiLine) {
		boolean oldPropertyMultiLine = propertyMultiLine;
		propertyMultiLine = newPropertyMultiLine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_FEATURE__PROPERTY_MULTI_LINE, oldPropertyMultiLine, propertyMultiLine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPropertySortChoices() {
		return propertySortChoices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertySortChoices(boolean newPropertySortChoices) {
		boolean oldPropertySortChoices = propertySortChoices;
		propertySortChoices = newPropertySortChoices;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_FEATURE__PROPERTY_SORT_CHOICES, oldPropertySortChoices, propertySortChoices));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenClass getGenClass() {
		if (eContainerFeatureID() != GenmodelPackage.GEN_FEATURE__GEN_CLASS) return null;
		return (GenClass)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGenClass(GenClass newGenClass, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newGenClass, GenmodelPackage.GEN_FEATURE__GEN_CLASS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenClass(GenClass newGenClass) {
		if (newGenClass != eInternalContainer() || (eContainerFeatureID() != GenmodelPackage.GEN_FEATURE__GEN_CLASS && newGenClass != null)) {
			if (EcoreUtil.isAncestor(this, newGenClass))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newGenClass != null)
				msgs = ((InternalEObject)newGenClass).eInverseAdd(this, GenmodelPackage.GEN_CLASS__GEN_FEATURES, GenClass.class, msgs);
			msgs = basicSetGenClass(newGenClass, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_FEATURE__GEN_CLASS, newGenClass, newGenClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature getEcoreFeature() {
		if (ecoreFeature != null && ecoreFeature.eIsProxy()) {
			InternalEObject oldEcoreFeature = (InternalEObject)ecoreFeature;
			ecoreFeature = (EStructuralFeature)eResolveProxy(oldEcoreFeature);
			if (ecoreFeature != oldEcoreFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GenmodelPackage.GEN_FEATURE__ECORE_FEATURE, oldEcoreFeature, ecoreFeature));
			}
		}
		return ecoreFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature basicGetEcoreFeature() {
		return ecoreFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEcoreFeature(EStructuralFeature newEcoreFeature) {
		EStructuralFeature oldEcoreFeature = ecoreFeature;
		ecoreFeature = newEcoreFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_FEATURE__ECORE_FEATURE, oldEcoreFeature, ecoreFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GenmodelPackage.GEN_FEATURE__GEN_CLASS:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetGenClass((GenClass)otherEnd, msgs);
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
			case GenmodelPackage.GEN_FEATURE__GEN_CLASS:
				return basicSetGenClass(null, msgs);
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
			case GenmodelPackage.GEN_FEATURE__GEN_CLASS:
				return eInternalContainer().eInverseRemove(this, GenmodelPackage.GEN_CLASS__GEN_FEATURES, GenClass.class, msgs);
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
			case GenmodelPackage.GEN_FEATURE__PROPERTY:
				return getProperty();
			case GenmodelPackage.GEN_FEATURE__NOTIFY:
				return isNotify();
			case GenmodelPackage.GEN_FEATURE__CHILDREN:
				return isChildren();
			case GenmodelPackage.GEN_FEATURE__CREATE_CHILD:
				return isCreateChild();
			case GenmodelPackage.GEN_FEATURE__PROPERTY_CATEGORY:
				return getPropertyCategory();
			case GenmodelPackage.GEN_FEATURE__PROPERTY_FILTER_FLAGS:
				return getPropertyFilterFlags();
			case GenmodelPackage.GEN_FEATURE__PROPERTY_DESCRIPTION:
				return getPropertyDescription();
			case GenmodelPackage.GEN_FEATURE__PROPERTY_MULTI_LINE:
				return isPropertyMultiLine();
			case GenmodelPackage.GEN_FEATURE__PROPERTY_SORT_CHOICES:
				return isPropertySortChoices();
			case GenmodelPackage.GEN_FEATURE__GEN_CLASS:
				return getGenClass();
			case GenmodelPackage.GEN_FEATURE__ECORE_FEATURE:
				if (resolve) return getEcoreFeature();
				return basicGetEcoreFeature();
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
			case GenmodelPackage.GEN_FEATURE__PROPERTY:
				setProperty((GenPropertyKind)newValue);
				return;
			case GenmodelPackage.GEN_FEATURE__NOTIFY:
				setNotify((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_FEATURE__CHILDREN:
				setChildren((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_FEATURE__CREATE_CHILD:
				setCreateChild((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_FEATURE__PROPERTY_CATEGORY:
				setPropertyCategory((String)newValue);
				return;
			case GenmodelPackage.GEN_FEATURE__PROPERTY_FILTER_FLAGS:
				getPropertyFilterFlags().clear();
				getPropertyFilterFlags().addAll((Collection<? extends String>)newValue);
				return;
			case GenmodelPackage.GEN_FEATURE__PROPERTY_DESCRIPTION:
				setPropertyDescription((String)newValue);
				return;
			case GenmodelPackage.GEN_FEATURE__PROPERTY_MULTI_LINE:
				setPropertyMultiLine((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_FEATURE__PROPERTY_SORT_CHOICES:
				setPropertySortChoices((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_FEATURE__GEN_CLASS:
				setGenClass((GenClass)newValue);
				return;
			case GenmodelPackage.GEN_FEATURE__ECORE_FEATURE:
				setEcoreFeature((EStructuralFeature)newValue);
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
			case GenmodelPackage.GEN_FEATURE__PROPERTY:
				setProperty(PROPERTY_EDEFAULT);
				return;
			case GenmodelPackage.GEN_FEATURE__NOTIFY:
				setNotify(NOTIFY_EDEFAULT);
				return;
			case GenmodelPackage.GEN_FEATURE__CHILDREN:
				setChildren(CHILDREN_EDEFAULT);
				return;
			case GenmodelPackage.GEN_FEATURE__CREATE_CHILD:
				unsetCreateChild();
				return;
			case GenmodelPackage.GEN_FEATURE__PROPERTY_CATEGORY:
				setPropertyCategory(PROPERTY_CATEGORY_EDEFAULT);
				return;
			case GenmodelPackage.GEN_FEATURE__PROPERTY_FILTER_FLAGS:
				getPropertyFilterFlags().clear();
				return;
			case GenmodelPackage.GEN_FEATURE__PROPERTY_DESCRIPTION:
				setPropertyDescription(PROPERTY_DESCRIPTION_EDEFAULT);
				return;
			case GenmodelPackage.GEN_FEATURE__PROPERTY_MULTI_LINE:
				setPropertyMultiLine(PROPERTY_MULTI_LINE_EDEFAULT);
				return;
			case GenmodelPackage.GEN_FEATURE__PROPERTY_SORT_CHOICES:
				setPropertySortChoices(PROPERTY_SORT_CHOICES_EDEFAULT);
				return;
			case GenmodelPackage.GEN_FEATURE__GEN_CLASS:
				setGenClass((GenClass)null);
				return;
			case GenmodelPackage.GEN_FEATURE__ECORE_FEATURE:
				setEcoreFeature((EStructuralFeature)null);
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
			case GenmodelPackage.GEN_FEATURE__PROPERTY:
				return property != PROPERTY_EDEFAULT;
			case GenmodelPackage.GEN_FEATURE__NOTIFY:
				return notify != NOTIFY_EDEFAULT;
			case GenmodelPackage.GEN_FEATURE__CHILDREN:
				return children != CHILDREN_EDEFAULT;
			case GenmodelPackage.GEN_FEATURE__CREATE_CHILD:
				return isSetCreateChild();
			case GenmodelPackage.GEN_FEATURE__PROPERTY_CATEGORY:
				return PROPERTY_CATEGORY_EDEFAULT == null ? propertyCategory != null : !PROPERTY_CATEGORY_EDEFAULT.equals(propertyCategory);
			case GenmodelPackage.GEN_FEATURE__PROPERTY_FILTER_FLAGS:
				return propertyFilterFlags != null && !propertyFilterFlags.isEmpty();
			case GenmodelPackage.GEN_FEATURE__PROPERTY_DESCRIPTION:
				return PROPERTY_DESCRIPTION_EDEFAULT == null ? propertyDescription != null : !PROPERTY_DESCRIPTION_EDEFAULT.equals(propertyDescription);
			case GenmodelPackage.GEN_FEATURE__PROPERTY_MULTI_LINE:
				return propertyMultiLine != PROPERTY_MULTI_LINE_EDEFAULT;
			case GenmodelPackage.GEN_FEATURE__PROPERTY_SORT_CHOICES:
				return propertySortChoices != PROPERTY_SORT_CHOICES_EDEFAULT;
			case GenmodelPackage.GEN_FEATURE__GEN_CLASS:
				return getGenClass() != null;
			case GenmodelPackage.GEN_FEATURE__ECORE_FEATURE:
				return ecoreFeature != null;
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
		result.append(" (property: ");
		result.append(property);
		result.append(", notify: ");
		result.append(notify);
		result.append(", children: ");
		result.append(children);
		result.append(", createChild: ");
		if (createChildESet) result.append(createChild); else result.append("<unset>");
		result.append(", propertyCategory: ");
		result.append(propertyCategory);
		result.append(", propertyFilterFlags: ");
		result.append(propertyFilterFlags);
		result.append(", propertyDescription: ");
		result.append(propertyDescription);
		result.append(", propertyMultiLine: ");
		result.append(propertyMultiLine);
		result.append(", propertySortChoices: ");
		result.append(propertySortChoices);
		result.append(')');
		return result.toString();
	}

} //GenFeatureImpl
