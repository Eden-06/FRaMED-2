/**
 */
package genmodel.provider;


import genmodel.GenmodelFactory;
import genmodel.GenmodelPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class GenPackageItemProvider extends GenBaseItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenPackageItemProvider(AdapterFactory adapterFactory) {
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

			addPrefixPropertyDescriptor(object);
			addBasePackagePropertyDescriptor(object);
			addResourcePropertyDescriptor(object);
			addDisposableProviderFactoryPropertyDescriptor(object);
			addAdapterFactoryPropertyDescriptor(object);
			addLoadInitializationPropertyDescriptor(object);
			addInterfacePackageSuffixPropertyDescriptor(object);
			addMetaDataPackageSuffixPropertyDescriptor(object);
			addClassPackageSuffixPropertyDescriptor(object);
			addUtilityPackageSuffixPropertyDescriptor(object);
			addProviderPackageSuffixPropertyDescriptor(object);
			addPresentationPackageSuffixPropertyDescriptor(object);
			addTestsPackageSuffixPropertyDescriptor(object);
			addGenerateExampleClassPropertyDescriptor(object);
			addLiteralsInterfacePropertyDescriptor(object);
			addDataTypeConvertersPropertyDescriptor(object);
			addMultipleEditorPagesPropertyDescriptor(object);
			addGenerateModelWizardPropertyDescriptor(object);
			addExtensibleProviderFactoryPropertyDescriptor(object);
			addChildCreationExtendersPropertyDescriptor(object);
			addContentTypeIdentifierPropertyDescriptor(object);
			addFileExtensionsPropertyDescriptor(object);
			addEcorePackagePropertyDescriptor(object);
			addGenClassifiersPropertyDescriptor(object);
			addPublicationLocationPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Prefix feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPrefixPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenPackage_prefix_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenPackage_prefix_feature", "_UI_GenPackage_type"),
				 GenmodelPackage.Literals.GEN_PACKAGE__PREFIX,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Base Package feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBasePackagePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenPackage_basePackage_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenPackage_basePackage_feature", "_UI_GenPackage_type"),
				 GenmodelPackage.Literals.GEN_PACKAGE__BASE_PACKAGE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Resource feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addResourcePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenPackage_resource_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenPackage_resource_feature", "_UI_GenPackage_type"),
				 GenmodelPackage.Literals.GEN_PACKAGE__RESOURCE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Disposable Provider Factory feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDisposableProviderFactoryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenPackage_disposableProviderFactory_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenPackage_disposableProviderFactory_feature", "_UI_GenPackage_type"),
				 GenmodelPackage.Literals.GEN_PACKAGE__DISPOSABLE_PROVIDER_FACTORY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Adapter Factory feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAdapterFactoryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenPackage_adapterFactory_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenPackage_adapterFactory_feature", "_UI_GenPackage_type"),
				 GenmodelPackage.Literals.GEN_PACKAGE__ADAPTER_FACTORY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Load Initialization feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLoadInitializationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenPackage_loadInitialization_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenPackage_loadInitialization_feature", "_UI_GenPackage_type"),
				 GenmodelPackage.Literals.GEN_PACKAGE__LOAD_INITIALIZATION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Interface Package Suffix feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInterfacePackageSuffixPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenPackage_interfacePackageSuffix_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenPackage_interfacePackageSuffix_feature", "_UI_GenPackage_type"),
				 GenmodelPackage.Literals.GEN_PACKAGE__INTERFACE_PACKAGE_SUFFIX,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Meta Data Package Suffix feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMetaDataPackageSuffixPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenPackage_metaDataPackageSuffix_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenPackage_metaDataPackageSuffix_feature", "_UI_GenPackage_type"),
				 GenmodelPackage.Literals.GEN_PACKAGE__META_DATA_PACKAGE_SUFFIX,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Class Package Suffix feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addClassPackageSuffixPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenPackage_classPackageSuffix_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenPackage_classPackageSuffix_feature", "_UI_GenPackage_type"),
				 GenmodelPackage.Literals.GEN_PACKAGE__CLASS_PACKAGE_SUFFIX,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Utility Package Suffix feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUtilityPackageSuffixPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenPackage_utilityPackageSuffix_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenPackage_utilityPackageSuffix_feature", "_UI_GenPackage_type"),
				 GenmodelPackage.Literals.GEN_PACKAGE__UTILITY_PACKAGE_SUFFIX,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Provider Package Suffix feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProviderPackageSuffixPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenPackage_providerPackageSuffix_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenPackage_providerPackageSuffix_feature", "_UI_GenPackage_type"),
				 GenmodelPackage.Literals.GEN_PACKAGE__PROVIDER_PACKAGE_SUFFIX,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Presentation Package Suffix feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPresentationPackageSuffixPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenPackage_presentationPackageSuffix_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenPackage_presentationPackageSuffix_feature", "_UI_GenPackage_type"),
				 GenmodelPackage.Literals.GEN_PACKAGE__PRESENTATION_PACKAGE_SUFFIX,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Tests Package Suffix feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTestsPackageSuffixPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenPackage_testsPackageSuffix_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenPackage_testsPackageSuffix_feature", "_UI_GenPackage_type"),
				 GenmodelPackage.Literals.GEN_PACKAGE__TESTS_PACKAGE_SUFFIX,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Generate Example Class feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGenerateExampleClassPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenPackage_generateExampleClass_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenPackage_generateExampleClass_feature", "_UI_GenPackage_type"),
				 GenmodelPackage.Literals.GEN_PACKAGE__GENERATE_EXAMPLE_CLASS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Literals Interface feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLiteralsInterfacePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenPackage_literalsInterface_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenPackage_literalsInterface_feature", "_UI_GenPackage_type"),
				 GenmodelPackage.Literals.GEN_PACKAGE__LITERALS_INTERFACE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Data Type Converters feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDataTypeConvertersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenPackage_dataTypeConverters_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenPackage_dataTypeConverters_feature", "_UI_GenPackage_type"),
				 GenmodelPackage.Literals.GEN_PACKAGE__DATA_TYPE_CONVERTERS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Multiple Editor Pages feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMultipleEditorPagesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenPackage_multipleEditorPages_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenPackage_multipleEditorPages_feature", "_UI_GenPackage_type"),
				 GenmodelPackage.Literals.GEN_PACKAGE__MULTIPLE_EDITOR_PAGES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Generate Model Wizard feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGenerateModelWizardPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenPackage_generateModelWizard_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenPackage_generateModelWizard_feature", "_UI_GenPackage_type"),
				 GenmodelPackage.Literals.GEN_PACKAGE__GENERATE_MODEL_WIZARD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Extensible Provider Factory feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExtensibleProviderFactoryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenPackage_extensibleProviderFactory_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenPackage_extensibleProviderFactory_feature", "_UI_GenPackage_type"),
				 GenmodelPackage.Literals.GEN_PACKAGE__EXTENSIBLE_PROVIDER_FACTORY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Child Creation Extenders feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addChildCreationExtendersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenPackage_childCreationExtenders_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenPackage_childCreationExtenders_feature", "_UI_GenPackage_type"),
				 GenmodelPackage.Literals.GEN_PACKAGE__CHILD_CREATION_EXTENDERS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Content Type Identifier feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addContentTypeIdentifierPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenPackage_contentTypeIdentifier_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenPackage_contentTypeIdentifier_feature", "_UI_GenPackage_type"),
				 GenmodelPackage.Literals.GEN_PACKAGE__CONTENT_TYPE_IDENTIFIER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the File Extensions feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFileExtensionsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenPackage_fileExtensions_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenPackage_fileExtensions_feature", "_UI_GenPackage_type"),
				 GenmodelPackage.Literals.GEN_PACKAGE__FILE_EXTENSIONS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Ecore Package feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEcorePackagePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenPackage_ecorePackage_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenPackage_ecorePackage_feature", "_UI_GenPackage_type"),
				 GenmodelPackage.Literals.GEN_PACKAGE__ECORE_PACKAGE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Gen Classifiers feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGenClassifiersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenPackage_genClassifiers_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenPackage_genClassifiers_feature", "_UI_GenPackage_type"),
				 GenmodelPackage.Literals.GEN_PACKAGE__GEN_CLASSIFIERS,
				 false,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Publication Location feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPublicationLocationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenPackage_publicationLocation_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenPackage_publicationLocation_feature", "_UI_GenPackage_type"),
				 GenmodelPackage.Literals.GEN_PACKAGE__PUBLICATION_LOCATION,
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
			childrenFeatures.add(GenmodelPackage.Literals.GEN_PACKAGE__GEN_ENUMS);
			childrenFeatures.add(GenmodelPackage.Literals.GEN_PACKAGE__GEN_DATA_TYPES);
			childrenFeatures.add(GenmodelPackage.Literals.GEN_PACKAGE__GEN_CLASSES);
			childrenFeatures.add(GenmodelPackage.Literals.GEN_PACKAGE__NESTED_GEN_PACKAGES);
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
	 * This returns GenPackage.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/GenPackage"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((GenPackage)object).getPrefix();
		return label == null || label.length() == 0 ?
			getString("_UI_GenPackage_type") :
			getString("_UI_GenPackage_type") + " " + label;
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

		switch (notification.getFeatureID(GenPackage.class)) {
			case GenmodelPackage.GEN_PACKAGE__PREFIX:
			case GenmodelPackage.GEN_PACKAGE__BASE_PACKAGE:
			case GenmodelPackage.GEN_PACKAGE__RESOURCE:
			case GenmodelPackage.GEN_PACKAGE__DISPOSABLE_PROVIDER_FACTORY:
			case GenmodelPackage.GEN_PACKAGE__ADAPTER_FACTORY:
			case GenmodelPackage.GEN_PACKAGE__LOAD_INITIALIZATION:
			case GenmodelPackage.GEN_PACKAGE__INTERFACE_PACKAGE_SUFFIX:
			case GenmodelPackage.GEN_PACKAGE__META_DATA_PACKAGE_SUFFIX:
			case GenmodelPackage.GEN_PACKAGE__CLASS_PACKAGE_SUFFIX:
			case GenmodelPackage.GEN_PACKAGE__UTILITY_PACKAGE_SUFFIX:
			case GenmodelPackage.GEN_PACKAGE__PROVIDER_PACKAGE_SUFFIX:
			case GenmodelPackage.GEN_PACKAGE__PRESENTATION_PACKAGE_SUFFIX:
			case GenmodelPackage.GEN_PACKAGE__TESTS_PACKAGE_SUFFIX:
			case GenmodelPackage.GEN_PACKAGE__GENERATE_EXAMPLE_CLASS:
			case GenmodelPackage.GEN_PACKAGE__LITERALS_INTERFACE:
			case GenmodelPackage.GEN_PACKAGE__DATA_TYPE_CONVERTERS:
			case GenmodelPackage.GEN_PACKAGE__MULTIPLE_EDITOR_PAGES:
			case GenmodelPackage.GEN_PACKAGE__GENERATE_MODEL_WIZARD:
			case GenmodelPackage.GEN_PACKAGE__EXTENSIBLE_PROVIDER_FACTORY:
			case GenmodelPackage.GEN_PACKAGE__CHILD_CREATION_EXTENDERS:
			case GenmodelPackage.GEN_PACKAGE__CONTENT_TYPE_IDENTIFIER:
			case GenmodelPackage.GEN_PACKAGE__FILE_EXTENSIONS:
			case GenmodelPackage.GEN_PACKAGE__PUBLICATION_LOCATION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case GenmodelPackage.GEN_PACKAGE__GEN_ENUMS:
			case GenmodelPackage.GEN_PACKAGE__GEN_DATA_TYPES:
			case GenmodelPackage.GEN_PACKAGE__GEN_CLASSES:
			case GenmodelPackage.GEN_PACKAGE__NESTED_GEN_PACKAGES:
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
				(GenmodelPackage.Literals.GEN_PACKAGE__GEN_ENUMS,
				 GenmodelFactory.eINSTANCE.createGenEnum()));

		newChildDescriptors.add
			(createChildParameter
				(GenmodelPackage.Literals.GEN_PACKAGE__GEN_DATA_TYPES,
				 GenmodelFactory.eINSTANCE.createGenDataType()));

		newChildDescriptors.add
			(createChildParameter
				(GenmodelPackage.Literals.GEN_PACKAGE__GEN_DATA_TYPES,
				 GenmodelFactory.eINSTANCE.createGenEnum()));

		newChildDescriptors.add
			(createChildParameter
				(GenmodelPackage.Literals.GEN_PACKAGE__GEN_CLASSES,
				 GenmodelFactory.eINSTANCE.createGenClass()));

		newChildDescriptors.add
			(createChildParameter
				(GenmodelPackage.Literals.GEN_PACKAGE__NESTED_GEN_PACKAGES,
				 GenmodelFactory.eINSTANCE.createGenPackage()));
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
			childFeature == GenmodelPackage.Literals.GEN_PACKAGE__GEN_ENUMS ||
			childFeature == GenmodelPackage.Literals.GEN_PACKAGE__GEN_DATA_TYPES;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
