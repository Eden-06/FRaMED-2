/**
 */
package genmodel.provider;


import Editpolicymodel.EditpolicymodelFactory;

import genmodel.GenmodelFactory;
import genmodel.GenmodelPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenAnnotation;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link org.eclipse.emf.codegen.ecore.genmodel.GenAnnotation} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class GenAnnotationItemProvider extends GenBaseItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenAnnotationItemProvider(AdapterFactory adapterFactory) {
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

			addSourcePropertyDescriptor(object);
			addReferencesPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Source feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSourcePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenAnnotation_source_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenAnnotation_source_feature", "_UI_GenAnnotation_type"),
				 GenmodelPackage.Literals.GEN_ANNOTATION__SOURCE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the References feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReferencesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenAnnotation_references_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenAnnotation_references_feature", "_UI_GenAnnotation_type"),
				 GenmodelPackage.Literals.GEN_ANNOTATION__REFERENCES,
				 true,
				 false,
				 true,
				 null,
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
			childrenFeatures.add(GenmodelPackage.Literals.GEN_ANNOTATION__DETAILS);
			childrenFeatures.add(GenmodelPackage.Literals.GEN_ANNOTATION__CONTENTS);
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
	 * This returns GenAnnotation.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/GenAnnotation"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((GenAnnotation)object).getSource();
		return label == null || label.length() == 0 ?
			getString("_UI_GenAnnotation_type") :
			getString("_UI_GenAnnotation_type") + " " + label;
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

		switch (notification.getFeatureID(GenAnnotation.class)) {
			case GenmodelPackage.GEN_ANNOTATION__SOURCE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case GenmodelPackage.GEN_ANNOTATION__DETAILS:
			case GenmodelPackage.GEN_ANNOTATION__CONTENTS:
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
				(GenmodelPackage.Literals.GEN_ANNOTATION__CONTENTS,
				 GenmodelFactory.eINSTANCE.createGenModel()));

		newChildDescriptors.add
			(createChildParameter
				(GenmodelPackage.Literals.GEN_ANNOTATION__CONTENTS,
				 GenmodelFactory.eINSTANCE.createGenPackage()));

		newChildDescriptors.add
			(createChildParameter
				(GenmodelPackage.Literals.GEN_ANNOTATION__CONTENTS,
				 GenmodelFactory.eINSTANCE.createGenClass()));

		newChildDescriptors.add
			(createChildParameter
				(GenmodelPackage.Literals.GEN_ANNOTATION__CONTENTS,
				 GenmodelFactory.eINSTANCE.createGenFeature()));

		newChildDescriptors.add
			(createChildParameter
				(GenmodelPackage.Literals.GEN_ANNOTATION__CONTENTS,
				 GenmodelFactory.eINSTANCE.createGenDataType()));

		newChildDescriptors.add
			(createChildParameter
				(GenmodelPackage.Literals.GEN_ANNOTATION__CONTENTS,
				 GenmodelFactory.eINSTANCE.createGenEnum()));

		newChildDescriptors.add
			(createChildParameter
				(GenmodelPackage.Literals.GEN_ANNOTATION__CONTENTS,
				 GenmodelFactory.eINSTANCE.createGenEnumLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(GenmodelPackage.Literals.GEN_ANNOTATION__CONTENTS,
				 GenmodelFactory.eINSTANCE.createGenOperation()));

		newChildDescriptors.add
			(createChildParameter
				(GenmodelPackage.Literals.GEN_ANNOTATION__CONTENTS,
				 GenmodelFactory.eINSTANCE.createGenParameter()));

		newChildDescriptors.add
			(createChildParameter
				(GenmodelPackage.Literals.GEN_ANNOTATION__CONTENTS,
				 GenmodelFactory.eINSTANCE.createGenAnnotation()));

		newChildDescriptors.add
			(createChildParameter
				(GenmodelPackage.Literals.GEN_ANNOTATION__CONTENTS,
				 GenmodelFactory.eINSTANCE.createGenTypeParameter()));

		newChildDescriptors.add
			(createChildParameter
				(GenmodelPackage.Literals.GEN_ANNOTATION__CONTENTS,
				 EditpolicymodelFactory.eINSTANCE.createModel()));

		newChildDescriptors.add
			(createChildParameter
				(GenmodelPackage.Literals.GEN_ANNOTATION__CONTENTS,
				 EditpolicymodelFactory.eINSTANCE.createPolicy()));

		newChildDescriptors.add
			(createChildParameter
				(GenmodelPackage.Literals.GEN_ANNOTATION__CONTENTS,
				 EditpolicymodelFactory.eINSTANCE.createAndConstraintRule()));

		newChildDescriptors.add
			(createChildParameter
				(GenmodelPackage.Literals.GEN_ANNOTATION__CONTENTS,
				 EditpolicymodelFactory.eINSTANCE.createOrConstraintRule()));

		newChildDescriptors.add
			(createChildParameter
				(GenmodelPackage.Literals.GEN_ANNOTATION__CONTENTS,
				 EditpolicymodelFactory.eINSTANCE.createContainsConstraintRule()));

		newChildDescriptors.add
			(createChildParameter
				(GenmodelPackage.Literals.GEN_ANNOTATION__CONTENTS,
				 EditpolicymodelFactory.eINSTANCE.createNotConstraintRule()));

		newChildDescriptors.add
			(createChildParameter
				(GenmodelPackage.Literals.GEN_ANNOTATION__CONTENTS,
				 EditpolicymodelFactory.eINSTANCE.createIsStepOutConstraintRule()));

		newChildDescriptors.add
			(createChildParameter
				(GenmodelPackage.Literals.GEN_ANNOTATION__CONTENTS,
				 EditpolicymodelFactory.eINSTANCE.createIsTargetConstraintRule()));

		newChildDescriptors.add
			(createChildParameter
				(GenmodelPackage.Literals.GEN_ANNOTATION__CONTENTS,
				 EditpolicymodelFactory.eINSTANCE.createIsSourceConstraintRule()));

		newChildDescriptors.add
			(createChildParameter
				(GenmodelPackage.Literals.GEN_ANNOTATION__CONTENTS,
				 EditpolicymodelFactory.eINSTANCE.createIsParentConstraintRule()));

		newChildDescriptors.add
			(createChildParameter
				(GenmodelPackage.Literals.GEN_ANNOTATION__CONTENTS,
				 EditpolicymodelFactory.eINSTANCE.createAndFeatureRule()));

		newChildDescriptors.add
			(createChildParameter
				(GenmodelPackage.Literals.GEN_ANNOTATION__CONTENTS,
				 EditpolicymodelFactory.eINSTANCE.createOrFeatureRule()));

		newChildDescriptors.add
			(createChildParameter
				(GenmodelPackage.Literals.GEN_ANNOTATION__CONTENTS,
				 EditpolicymodelFactory.eINSTANCE.createNotFeatureRule()));

		newChildDescriptors.add
			(createChildParameter
				(GenmodelPackage.Literals.GEN_ANNOTATION__CONTENTS,
				 EditpolicymodelFactory.eINSTANCE.createTrueFeatureRule()));

		newChildDescriptors.add
			(createChildParameter
				(GenmodelPackage.Literals.GEN_ANNOTATION__CONTENTS,
				 EditpolicymodelFactory.eINSTANCE.createFalseFeatureRule()));

		newChildDescriptors.add
			(createChildParameter
				(GenmodelPackage.Literals.GEN_ANNOTATION__CONTENTS,
				 EditpolicymodelFactory.eINSTANCE.createTrueConstraintRule()));

		newChildDescriptors.add
			(createChildParameter
				(GenmodelPackage.Literals.GEN_ANNOTATION__CONTENTS,
				 EditpolicymodelFactory.eINSTANCE.createFalseConstraintRule()));
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
			childFeature == GenmodelPackage.Literals.GEN_BASE__GEN_ANNOTATIONS ||
			childFeature == GenmodelPackage.Literals.GEN_ANNOTATION__CONTENTS;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
