/**
 */
package editpolicymodel.provider;


import editpolicymodel.BinaryFeatureRule;
import editpolicymodel.editpolicymodelFactory;
import editpolicymodel.editpolicymodelPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link editpolicymodel.BinaryFeatureRule} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class BinaryFeatureRuleItemProvider extends LogicalFeatureRuleItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryFeatureRuleItemProvider(AdapterFactory adapterFactory) {
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

		}
		return itemPropertyDescriptors;
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
			childrenFeatures.add(editpolicymodelPackage.Literals.BINARY_FEATURE_RULE__RIGHT_RULE);
			childrenFeatures.add(editpolicymodelPackage.Literals.BINARY_FEATURE_RULE__LEFT_RULE);
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
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_BinaryFeatureRule_type");
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

		switch (notification.getFeatureID(BinaryFeatureRule.class)) {
			case editpolicymodelPackage.BINARY_FEATURE_RULE__RIGHT_RULE:
			case editpolicymodelPackage.BINARY_FEATURE_RULE__LEFT_RULE:
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
				(editpolicymodelPackage.Literals.BINARY_FEATURE_RULE__RIGHT_RULE,
				 editpolicymodelFactory.eINSTANCE.createIsFeature()));

		newChildDescriptors.add
			(createChildParameter
				(editpolicymodelPackage.Literals.BINARY_FEATURE_RULE__RIGHT_RULE,
				 editpolicymodelFactory.eINSTANCE.createLogicalFeatureRule()));

		newChildDescriptors.add
			(createChildParameter
				(editpolicymodelPackage.Literals.BINARY_FEATURE_RULE__RIGHT_RULE,
				 editpolicymodelFactory.eINSTANCE.createTrueFeatureRule()));

		newChildDescriptors.add
			(createChildParameter
				(editpolicymodelPackage.Literals.BINARY_FEATURE_RULE__RIGHT_RULE,
				 editpolicymodelFactory.eINSTANCE.createNotFeatureRule()));

		newChildDescriptors.add
			(createChildParameter
				(editpolicymodelPackage.Literals.BINARY_FEATURE_RULE__RIGHT_RULE,
				 editpolicymodelFactory.eINSTANCE.createFalseFeatureRule()));

		newChildDescriptors.add
			(createChildParameter
				(editpolicymodelPackage.Literals.BINARY_FEATURE_RULE__RIGHT_RULE,
				 editpolicymodelFactory.eINSTANCE.createImplicationFeatureRule()));

		newChildDescriptors.add
			(createChildParameter
				(editpolicymodelPackage.Literals.BINARY_FEATURE_RULE__RIGHT_RULE,
				 editpolicymodelFactory.eINSTANCE.createOrFeatureRule()));

		newChildDescriptors.add
			(createChildParameter
				(editpolicymodelPackage.Literals.BINARY_FEATURE_RULE__RIGHT_RULE,
				 editpolicymodelFactory.eINSTANCE.createAndFeatureRule()));

		newChildDescriptors.add
			(createChildParameter
				(editpolicymodelPackage.Literals.BINARY_FEATURE_RULE__LEFT_RULE,
				 editpolicymodelFactory.eINSTANCE.createIsFeature()));

		newChildDescriptors.add
			(createChildParameter
				(editpolicymodelPackage.Literals.BINARY_FEATURE_RULE__LEFT_RULE,
				 editpolicymodelFactory.eINSTANCE.createLogicalFeatureRule()));

		newChildDescriptors.add
			(createChildParameter
				(editpolicymodelPackage.Literals.BINARY_FEATURE_RULE__LEFT_RULE,
				 editpolicymodelFactory.eINSTANCE.createTrueFeatureRule()));

		newChildDescriptors.add
			(createChildParameter
				(editpolicymodelPackage.Literals.BINARY_FEATURE_RULE__LEFT_RULE,
				 editpolicymodelFactory.eINSTANCE.createNotFeatureRule()));

		newChildDescriptors.add
			(createChildParameter
				(editpolicymodelPackage.Literals.BINARY_FEATURE_RULE__LEFT_RULE,
				 editpolicymodelFactory.eINSTANCE.createFalseFeatureRule()));

		newChildDescriptors.add
			(createChildParameter
				(editpolicymodelPackage.Literals.BINARY_FEATURE_RULE__LEFT_RULE,
				 editpolicymodelFactory.eINSTANCE.createImplicationFeatureRule()));

		newChildDescriptors.add
			(createChildParameter
				(editpolicymodelPackage.Literals.BINARY_FEATURE_RULE__LEFT_RULE,
				 editpolicymodelFactory.eINSTANCE.createOrFeatureRule()));

		newChildDescriptors.add
			(createChildParameter
				(editpolicymodelPackage.Literals.BINARY_FEATURE_RULE__LEFT_RULE,
				 editpolicymodelFactory.eINSTANCE.createAndFeatureRule()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == editpolicymodelPackage.Literals.BINARY_FEATURE_RULE__RIGHT_RULE ||
			childFeature == editpolicymodelPackage.Literals.BINARY_FEATURE_RULE__LEFT_RULE;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
