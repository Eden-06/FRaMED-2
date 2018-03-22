/**
 */
package Editpolicymodel.provider;


import Editpolicymodel.EditpolicymodelFactory;
import Editpolicymodel.EditpolicymodelPackage;
import Editpolicymodel.NaryConstraintRule;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link Editpolicymodel.NaryConstraintRule} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class NaryConstraintRuleItemProvider extends LogicalConstraintRuleItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NaryConstraintRuleItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(EditpolicymodelPackage.Literals.NARY_CONSTRAINT_RULE__RULES);
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
		return getString("_UI_NaryConstraintRule_type");
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

		switch (notification.getFeatureID(NaryConstraintRule.class)) {
			case EditpolicymodelPackage.NARY_CONSTRAINT_RULE__RULES:
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
				(EditpolicymodelPackage.Literals.NARY_CONSTRAINT_RULE__RULES,
				 EditpolicymodelFactory.eINSTANCE.createContains()));

		newChildDescriptors.add
			(createChildParameter
				(EditpolicymodelPackage.Literals.NARY_CONSTRAINT_RULE__RULES,
				 EditpolicymodelFactory.eINSTANCE.createIsStepIn()));

		newChildDescriptors.add
			(createChildParameter
				(EditpolicymodelPackage.Literals.NARY_CONSTRAINT_RULE__RULES,
				 EditpolicymodelFactory.eINSTANCE.createIsTarget()));

		newChildDescriptors.add
			(createChildParameter
				(EditpolicymodelPackage.Literals.NARY_CONSTRAINT_RULE__RULES,
				 EditpolicymodelFactory.eINSTANCE.createIsSource()));

		newChildDescriptors.add
			(createChildParameter
				(EditpolicymodelPackage.Literals.NARY_CONSTRAINT_RULE__RULES,
				 EditpolicymodelFactory.eINSTANCE.createIsParent()));

		newChildDescriptors.add
			(createChildParameter
				(EditpolicymodelPackage.Literals.NARY_CONSTRAINT_RULE__RULES,
				 EditpolicymodelFactory.eINSTANCE.createIsTargetType()));

		newChildDescriptors.add
			(createChildParameter
				(EditpolicymodelPackage.Literals.NARY_CONSTRAINT_RULE__RULES,
				 EditpolicymodelFactory.eINSTANCE.createLogicalConstraintRule()));

		newChildDescriptors.add
			(createChildParameter
				(EditpolicymodelPackage.Literals.NARY_CONSTRAINT_RULE__RULES,
				 EditpolicymodelFactory.eINSTANCE.createNotConstraintRule()));

		newChildDescriptors.add
			(createChildParameter
				(EditpolicymodelPackage.Literals.NARY_CONSTRAINT_RULE__RULES,
				 EditpolicymodelFactory.eINSTANCE.createAndConstraintRule()));

		newChildDescriptors.add
			(createChildParameter
				(EditpolicymodelPackage.Literals.NARY_CONSTRAINT_RULE__RULES,
				 EditpolicymodelFactory.eINSTANCE.createTrueConstraintRule()));

		newChildDescriptors.add
			(createChildParameter
				(EditpolicymodelPackage.Literals.NARY_CONSTRAINT_RULE__RULES,
				 EditpolicymodelFactory.eINSTANCE.createFalseConstraintRule()));

		newChildDescriptors.add
			(createChildParameter
				(EditpolicymodelPackage.Literals.NARY_CONSTRAINT_RULE__RULES,
				 EditpolicymodelFactory.eINSTANCE.createOrConstraintRule()));

		newChildDescriptors.add
			(createChildParameter
				(EditpolicymodelPackage.Literals.NARY_CONSTRAINT_RULE__RULES,
				 EditpolicymodelFactory.eINSTANCE.createImplicationConstraintRule()));

		newChildDescriptors.add
			(createChildParameter
				(EditpolicymodelPackage.Literals.NARY_CONSTRAINT_RULE__RULES,
				 EditpolicymodelFactory.eINSTANCE.createIsSourceType()));
	}

}
