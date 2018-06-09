/**
 */
package editpolicymodel.provider;


import editpolicymodel.UnaryConstraintRule;
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
 * This is the item provider adapter for a {@link editpolicymodel.UnaryConstraintRule} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class UnaryConstraintRuleItemProvider extends LogicalConstraintRuleItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnaryConstraintRuleItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(editpolicymodelPackage.Literals.UNARY_CONSTRAINT_RULE__RULE);
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
		return getString("_UI_UnaryConstraintRule_type");
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

		switch (notification.getFeatureID(UnaryConstraintRule.class)) {
			case editpolicymodelPackage.UNARY_CONSTRAINT_RULE__RULE:
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
				(editpolicymodelPackage.Literals.UNARY_CONSTRAINT_RULE__RULE,
				 editpolicymodelFactory.eINSTANCE.createContainsCompartment()));

		newChildDescriptors.add
			(createChildParameter
				(editpolicymodelPackage.Literals.UNARY_CONSTRAINT_RULE__RULE,
				 editpolicymodelFactory.eINSTANCE.createIsTarget()));

		newChildDescriptors.add
			(createChildParameter
				(editpolicymodelPackage.Literals.UNARY_CONSTRAINT_RULE__RULE,
				 editpolicymodelFactory.eINSTANCE.createIsParent()));

		newChildDescriptors.add
			(createChildParameter
				(editpolicymodelPackage.Literals.UNARY_CONSTRAINT_RULE__RULE,
				 editpolicymodelFactory.eINSTANCE.createIsTargetType()));

		newChildDescriptors.add
			(createChildParameter
				(editpolicymodelPackage.Literals.UNARY_CONSTRAINT_RULE__RULE,
				 editpolicymodelFactory.eINSTANCE.createLogicalConstraintRule()));

		newChildDescriptors.add
			(createChildParameter
				(editpolicymodelPackage.Literals.UNARY_CONSTRAINT_RULE__RULE,
				 editpolicymodelFactory.eINSTANCE.createNotConstraintRule()));

		newChildDescriptors.add
			(createChildParameter
				(editpolicymodelPackage.Literals.UNARY_CONSTRAINT_RULE__RULE,
				 editpolicymodelFactory.eINSTANCE.createAndConstraintRule()));

		newChildDescriptors.add
			(createChildParameter
				(editpolicymodelPackage.Literals.UNARY_CONSTRAINT_RULE__RULE,
				 editpolicymodelFactory.eINSTANCE.createTrueConstraintRule()));

		newChildDescriptors.add
			(createChildParameter
				(editpolicymodelPackage.Literals.UNARY_CONSTRAINT_RULE__RULE,
				 editpolicymodelFactory.eINSTANCE.createFalseConstraintRule()));

		newChildDescriptors.add
			(createChildParameter
				(editpolicymodelPackage.Literals.UNARY_CONSTRAINT_RULE__RULE,
				 editpolicymodelFactory.eINSTANCE.createOrConstraintRule()));

		newChildDescriptors.add
			(createChildParameter
				(editpolicymodelPackage.Literals.UNARY_CONSTRAINT_RULE__RULE,
				 editpolicymodelFactory.eINSTANCE.createImplicationConstraintRule()));

		newChildDescriptors.add
			(createChildParameter
				(editpolicymodelPackage.Literals.UNARY_CONSTRAINT_RULE__RULE,
				 editpolicymodelFactory.eINSTANCE.createIsSourceType()));

		newChildDescriptors.add
			(createChildParameter
				(editpolicymodelPackage.Literals.UNARY_CONSTRAINT_RULE__RULE,
				 editpolicymodelFactory.eINSTANCE.createSourceEqualsTarget()));

		newChildDescriptors.add
			(createChildParameter
				(editpolicymodelPackage.Literals.UNARY_CONSTRAINT_RULE__RULE,
				 editpolicymodelFactory.eINSTANCE.createSourceEqualsTargetType()));

		newChildDescriptors.add
			(createChildParameter
				(editpolicymodelPackage.Literals.UNARY_CONSTRAINT_RULE__RULE,
				 editpolicymodelFactory.eINSTANCE.createInType()));
	}

}
