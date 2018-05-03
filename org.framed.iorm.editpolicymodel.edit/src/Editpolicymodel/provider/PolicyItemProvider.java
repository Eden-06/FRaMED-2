/**
 */
package Editpolicymodel.provider;


import Editpolicymodel.EditpolicymodelFactory;
import Editpolicymodel.EditpolicymodelPackage;
import Editpolicymodel.Policy;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link Editpolicymodel.Policy} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PolicyItemProvider 
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PolicyItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addOverridePropertyDescriptor(object);
			addActionPropertyDescriptor(object);
			addActionTypePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Override feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOverridePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Policy_override_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Policy_override_feature", "_UI_Policy_type"),
				 EditpolicymodelPackage.Literals.POLICY__OVERRIDE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Action feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addActionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Policy_action_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Policy_action_feature", "_UI_Policy_type"),
				 EditpolicymodelPackage.Literals.POLICY__ACTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Action Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addActionTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Policy_actionType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Policy_actionType_feature", "_UI_Policy_type"),
				 EditpolicymodelPackage.Literals.POLICY__ACTION_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(EditpolicymodelPackage.Literals.POLICY__FEATURE_RULE);
			childrenFeatures.add(EditpolicymodelPackage.Literals.POLICY__CONSTRAINT_RULE);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Policy.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Policy"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		Boolean labelValue = ((Policy)object).getOverride();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ?
			getString("_UI_Policy_type") :
			getString("_UI_Policy_type") + " " + label;
	}
	

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Policy.class)) {
			case EditpolicymodelPackage.POLICY__OVERRIDE:
			case EditpolicymodelPackage.POLICY__ACTION:
			case EditpolicymodelPackage.POLICY__ACTION_TYPE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EditpolicymodelPackage.POLICY__FEATURE_RULE:
			case EditpolicymodelPackage.POLICY__CONSTRAINT_RULE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(EditpolicymodelPackage.Literals.POLICY__FEATURE_RULE,
				 EditpolicymodelFactory.eINSTANCE.createIsFeature()));

		newChildDescriptors.add
			(createChildParameter
				(EditpolicymodelPackage.Literals.POLICY__FEATURE_RULE,
				 EditpolicymodelFactory.eINSTANCE.createLogicalFeatureRule()));

		newChildDescriptors.add
			(createChildParameter
				(EditpolicymodelPackage.Literals.POLICY__FEATURE_RULE,
				 EditpolicymodelFactory.eINSTANCE.createTrueFeatureRule()));

		newChildDescriptors.add
			(createChildParameter
				(EditpolicymodelPackage.Literals.POLICY__FEATURE_RULE,
				 EditpolicymodelFactory.eINSTANCE.createNotFeatureRule()));

		newChildDescriptors.add
			(createChildParameter
				(EditpolicymodelPackage.Literals.POLICY__FEATURE_RULE,
				 EditpolicymodelFactory.eINSTANCE.createFalseFeatureRule()));

		newChildDescriptors.add
			(createChildParameter
				(EditpolicymodelPackage.Literals.POLICY__FEATURE_RULE,
				 EditpolicymodelFactory.eINSTANCE.createImplicationFeatureRule()));

		newChildDescriptors.add
			(createChildParameter
				(EditpolicymodelPackage.Literals.POLICY__FEATURE_RULE,
				 EditpolicymodelFactory.eINSTANCE.createOrFeatureRule()));

		newChildDescriptors.add
			(createChildParameter
				(EditpolicymodelPackage.Literals.POLICY__FEATURE_RULE,
				 EditpolicymodelFactory.eINSTANCE.createAndFeatureRule()));

		newChildDescriptors.add
			(createChildParameter
				(EditpolicymodelPackage.Literals.POLICY__CONSTRAINT_RULE,
				 EditpolicymodelFactory.eINSTANCE.createContainsCompartment()));

		newChildDescriptors.add
			(createChildParameter
				(EditpolicymodelPackage.Literals.POLICY__CONSTRAINT_RULE,
				 EditpolicymodelFactory.eINSTANCE.createIsTarget()));

		newChildDescriptors.add
			(createChildParameter
				(EditpolicymodelPackage.Literals.POLICY__CONSTRAINT_RULE,
				 EditpolicymodelFactory.eINSTANCE.createIsParent()));

		newChildDescriptors.add
			(createChildParameter
				(EditpolicymodelPackage.Literals.POLICY__CONSTRAINT_RULE,
				 EditpolicymodelFactory.eINSTANCE.createIsTargetType()));

		newChildDescriptors.add
			(createChildParameter
				(EditpolicymodelPackage.Literals.POLICY__CONSTRAINT_RULE,
				 EditpolicymodelFactory.eINSTANCE.createLogicalConstraintRule()));

		newChildDescriptors.add
			(createChildParameter
				(EditpolicymodelPackage.Literals.POLICY__CONSTRAINT_RULE,
				 EditpolicymodelFactory.eINSTANCE.createNotConstraintRule()));

		newChildDescriptors.add
			(createChildParameter
				(EditpolicymodelPackage.Literals.POLICY__CONSTRAINT_RULE,
				 EditpolicymodelFactory.eINSTANCE.createAndConstraintRule()));

		newChildDescriptors.add
			(createChildParameter
				(EditpolicymodelPackage.Literals.POLICY__CONSTRAINT_RULE,
				 EditpolicymodelFactory.eINSTANCE.createTrueConstraintRule()));

		newChildDescriptors.add
			(createChildParameter
				(EditpolicymodelPackage.Literals.POLICY__CONSTRAINT_RULE,
				 EditpolicymodelFactory.eINSTANCE.createFalseConstraintRule()));

		newChildDescriptors.add
			(createChildParameter
				(EditpolicymodelPackage.Literals.POLICY__CONSTRAINT_RULE,
				 EditpolicymodelFactory.eINSTANCE.createOrConstraintRule()));

		newChildDescriptors.add
			(createChildParameter
				(EditpolicymodelPackage.Literals.POLICY__CONSTRAINT_RULE,
				 EditpolicymodelFactory.eINSTANCE.createImplicationConstraintRule()));

		newChildDescriptors.add
			(createChildParameter
				(EditpolicymodelPackage.Literals.POLICY__CONSTRAINT_RULE,
				 EditpolicymodelFactory.eINSTANCE.createIsSourceType()));

		newChildDescriptors.add
			(createChildParameter
				(EditpolicymodelPackage.Literals.POLICY__CONSTRAINT_RULE,
				 EditpolicymodelFactory.eINSTANCE.createSourceEqualsTarget()));

		newChildDescriptors.add
			(createChildParameter
				(EditpolicymodelPackage.Literals.POLICY__CONSTRAINT_RULE,
				 EditpolicymodelFactory.eINSTANCE.createSourceEqualsTargetType()));

		newChildDescriptors.add
			(createChildParameter
				(EditpolicymodelPackage.Literals.POLICY__CONSTRAINT_RULE,
				 EditpolicymodelFactory.eINSTANCE.createInCompartment()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return EditpolicymodelEditPlugin.INSTANCE;
	}

}
