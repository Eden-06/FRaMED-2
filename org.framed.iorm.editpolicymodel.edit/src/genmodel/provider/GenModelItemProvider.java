/**
 */
package genmodel.provider;


import genmodel.GenmodelFactory;
import genmodel.GenmodelPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link org.eclipse.emf.codegen.ecore.genmodel.GenModel} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class GenModelItemProvider extends GenBaseItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenModelItemProvider(AdapterFactory adapterFactory) {
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

			addCopyrightTextPropertyDescriptor(object);
			addModelDirectoryPropertyDescriptor(object);
			addCreationCommandsPropertyDescriptor(object);
			addCreationIconsPropertyDescriptor(object);
			addCreationSubmenusPropertyDescriptor(object);
			addEditDirectoryPropertyDescriptor(object);
			addEditorDirectoryPropertyDescriptor(object);
			addModelPluginIDPropertyDescriptor(object);
			addTemplateDirectoryPropertyDescriptor(object);
			addRuntimeJarPropertyDescriptor(object);
			addForeignModelPropertyDescriptor(object);
			addDynamicTemplatesPropertyDescriptor(object);
			addRedirectionPropertyDescriptor(object);
			addForceOverwritePropertyDescriptor(object);
			addNonExternalizedStringTagPropertyDescriptor(object);
			addModelNamePropertyDescriptor(object);
			addModelPluginClassPropertyDescriptor(object);
			addEditPluginClassPropertyDescriptor(object);
			addEditorPluginClassPropertyDescriptor(object);
			addUpdateClasspathPropertyDescriptor(object);
			addGenerateSchemaPropertyDescriptor(object);
			addNonNLSMarkersPropertyDescriptor(object);
			addStaticPackagesPropertyDescriptor(object);
			addModelPluginVariablesPropertyDescriptor(object);
			addRootExtendsInterfacePropertyDescriptor(object);
			addRootExtendsClassPropertyDescriptor(object);
			addRootImplementsInterfacePropertyDescriptor(object);
			addSuppressEMFTypesPropertyDescriptor(object);
			addSuppressEMFMetaDataPropertyDescriptor(object);
			addSuppressEMFModelTagsPropertyDescriptor(object);
			addSuppressInterfacesPropertyDescriptor(object);
			addFeatureMapWrapperInterfacePropertyDescriptor(object);
			addFeatureMapWrapperInternalInterfacePropertyDescriptor(object);
			addFeatureMapWrapperClassPropertyDescriptor(object);
			addRuntimeCompatibilityPropertyDescriptor(object);
			addRichClientPlatformPropertyDescriptor(object);
			addReflectiveDelegationPropertyDescriptor(object);
			addCodeFormattingPropertyDescriptor(object);
			addCommentFormattingPropertyDescriptor(object);
			addTestsDirectoryPropertyDescriptor(object);
			addTestSuiteClassPropertyDescriptor(object);
			addBooleanFlagsFieldPropertyDescriptor(object);
			addBooleanFlagsReservedBitsPropertyDescriptor(object);
			addImporterIDPropertyDescriptor(object);
			addBundleManifestPropertyDescriptor(object);
			addFeatureDelegationPropertyDescriptor(object);
			addContainmentProxiesPropertyDescriptor(object);
			addMinimalReflectiveMethodsPropertyDescriptor(object);
			addSuppressContainmentPropertyDescriptor(object);
			addSuppressNotificationPropertyDescriptor(object);
			addArrayAccessorsPropertyDescriptor(object);
			addSuppressUnsettablePropertyDescriptor(object);
			addFacadeHelperClassPropertyDescriptor(object);
			addComplianceLevelPropertyDescriptor(object);
			addSuppressGenModelAnnotationsPropertyDescriptor(object);
			addCopyrightFieldsPropertyDescriptor(object);
			addBinaryCompatibleReflectiveMethodsPropertyDescriptor(object);
			addPublicConstructorsPropertyDescriptor(object);
			addTemplatePluginVariablesPropertyDescriptor(object);
			addProviderRootExtendsClassPropertyDescriptor(object);
			addEditPluginIDPropertyDescriptor(object);
			addEditPluginVariablesPropertyDescriptor(object);
			addEditorPluginIDPropertyDescriptor(object);
			addEditorPluginVariablesPropertyDescriptor(object);
			addTestsPluginIDPropertyDescriptor(object);
			addTestsPluginVariablesPropertyDescriptor(object);
			addOptimizedHasChildrenPropertyDescriptor(object);
			addTableProvidersPropertyDescriptor(object);
			addColorProvidersPropertyDescriptor(object);
			addFontProvidersPropertyDescriptor(object);
			addRuntimeVersionPropertyDescriptor(object);
			addLanguagePropertyDescriptor(object);
			addPackedEnumsPropertyDescriptor(object);
			addUsedGenPackagesPropertyDescriptor(object);
			addInterfaceNamePatternPropertyDescriptor(object);
			addClassNamePatternPropertyDescriptor(object);
			addOperationReflectionPropertyDescriptor(object);
			addRichAjaxPlatformPropertyDescriptor(object);
			addRuntimePlatformPropertyDescriptor(object);
			addImportOrganizingPropertyDescriptor(object);
			addPluginKeyPropertyDescriptor(object);
			addDecorationPropertyDescriptor(object);
			addStyleProvidersPropertyDescriptor(object);
			addCleanupPropertyDescriptor(object);
			addOSGiCompatiblePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Copyright Text feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCopyrightTextPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_copyrightText_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_copyrightText_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__COPYRIGHT_TEXT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Model Directory feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addModelDirectoryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_modelDirectory_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_modelDirectory_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__MODEL_DIRECTORY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Creation Commands feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCreationCommandsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_creationCommands_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_creationCommands_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__CREATION_COMMANDS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Creation Icons feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCreationIconsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_creationIcons_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_creationIcons_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__CREATION_ICONS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Creation Submenus feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCreationSubmenusPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_creationSubmenus_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_creationSubmenus_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__CREATION_SUBMENUS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Edit Directory feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEditDirectoryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_editDirectory_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_editDirectory_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__EDIT_DIRECTORY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Editor Directory feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEditorDirectoryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_editorDirectory_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_editorDirectory_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__EDITOR_DIRECTORY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Model Plugin ID feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addModelPluginIDPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_modelPluginID_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_modelPluginID_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__MODEL_PLUGIN_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Template Directory feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTemplateDirectoryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_templateDirectory_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_templateDirectory_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__TEMPLATE_DIRECTORY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Runtime Jar feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRuntimeJarPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_runtimeJar_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_runtimeJar_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__RUNTIME_JAR,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Foreign Model feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addForeignModelPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_foreignModel_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_foreignModel_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__FOREIGN_MODEL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Dynamic Templates feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDynamicTemplatesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_dynamicTemplates_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_dynamicTemplates_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__DYNAMIC_TEMPLATES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Redirection feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRedirectionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_redirection_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_redirection_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__REDIRECTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Force Overwrite feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addForceOverwritePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_forceOverwrite_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_forceOverwrite_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__FORCE_OVERWRITE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Non Externalized String Tag feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNonExternalizedStringTagPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_nonExternalizedStringTag_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_nonExternalizedStringTag_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__NON_EXTERNALIZED_STRING_TAG,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Model Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addModelNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_modelName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_modelName_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__MODEL_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Model Plugin Class feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addModelPluginClassPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_modelPluginClass_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_modelPluginClass_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__MODEL_PLUGIN_CLASS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Edit Plugin Class feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEditPluginClassPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_editPluginClass_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_editPluginClass_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__EDIT_PLUGIN_CLASS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Editor Plugin Class feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEditorPluginClassPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_editorPluginClass_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_editorPluginClass_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__EDITOR_PLUGIN_CLASS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Update Classpath feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUpdateClasspathPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_updateClasspath_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_updateClasspath_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__UPDATE_CLASSPATH,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Generate Schema feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGenerateSchemaPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_generateSchema_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_generateSchema_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__GENERATE_SCHEMA,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Non NLS Markers feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNonNLSMarkersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_nonNLSMarkers_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_nonNLSMarkers_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__NON_NLS_MARKERS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Static Packages feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStaticPackagesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_staticPackages_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_staticPackages_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__STATIC_PACKAGES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Model Plugin Variables feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addModelPluginVariablesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_modelPluginVariables_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_modelPluginVariables_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__MODEL_PLUGIN_VARIABLES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Root Extends Interface feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRootExtendsInterfacePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_rootExtendsInterface_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_rootExtendsInterface_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__ROOT_EXTENDS_INTERFACE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Root Extends Class feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRootExtendsClassPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_rootExtendsClass_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_rootExtendsClass_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__ROOT_EXTENDS_CLASS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Root Implements Interface feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRootImplementsInterfacePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_rootImplementsInterface_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_rootImplementsInterface_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__ROOT_IMPLEMENTS_INTERFACE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Suppress EMF Types feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSuppressEMFTypesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_suppressEMFTypes_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_suppressEMFTypes_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__SUPPRESS_EMF_TYPES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Suppress EMF Meta Data feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSuppressEMFMetaDataPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_suppressEMFMetaData_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_suppressEMFMetaData_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__SUPPRESS_EMF_META_DATA,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Suppress EMF Model Tags feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSuppressEMFModelTagsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_suppressEMFModelTags_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_suppressEMFModelTags_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__SUPPRESS_EMF_MODEL_TAGS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Suppress Interfaces feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSuppressInterfacesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_suppressInterfaces_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_suppressInterfaces_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__SUPPRESS_INTERFACES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Feature Map Wrapper Interface feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFeatureMapWrapperInterfacePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_featureMapWrapperInterface_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_featureMapWrapperInterface_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__FEATURE_MAP_WRAPPER_INTERFACE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Feature Map Wrapper Internal Interface feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFeatureMapWrapperInternalInterfacePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_featureMapWrapperInternalInterface_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_featureMapWrapperInternalInterface_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__FEATURE_MAP_WRAPPER_INTERNAL_INTERFACE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Feature Map Wrapper Class feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFeatureMapWrapperClassPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_featureMapWrapperClass_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_featureMapWrapperClass_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__FEATURE_MAP_WRAPPER_CLASS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Runtime Compatibility feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRuntimeCompatibilityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_runtimeCompatibility_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_runtimeCompatibility_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__RUNTIME_COMPATIBILITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Rich Client Platform feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRichClientPlatformPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_richClientPlatform_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_richClientPlatform_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__RICH_CLIENT_PLATFORM,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Reflective Delegation feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReflectiveDelegationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_reflectiveDelegation_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_reflectiveDelegation_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__REFLECTIVE_DELEGATION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Code Formatting feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCodeFormattingPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_codeFormatting_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_codeFormatting_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__CODE_FORMATTING,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Comment Formatting feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCommentFormattingPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_commentFormatting_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_commentFormatting_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__COMMENT_FORMATTING,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Tests Directory feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTestsDirectoryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_testsDirectory_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_testsDirectory_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__TESTS_DIRECTORY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Test Suite Class feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTestSuiteClassPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_testSuiteClass_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_testSuiteClass_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__TEST_SUITE_CLASS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Boolean Flags Field feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBooleanFlagsFieldPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_booleanFlagsField_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_booleanFlagsField_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__BOOLEAN_FLAGS_FIELD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Boolean Flags Reserved Bits feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBooleanFlagsReservedBitsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_booleanFlagsReservedBits_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_booleanFlagsReservedBits_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__BOOLEAN_FLAGS_RESERVED_BITS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Importer ID feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addImporterIDPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_importerID_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_importerID_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__IMPORTER_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Bundle Manifest feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBundleManifestPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_bundleManifest_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_bundleManifest_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__BUNDLE_MANIFEST,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Feature Delegation feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFeatureDelegationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_featureDelegation_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_featureDelegation_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__FEATURE_DELEGATION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Containment Proxies feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addContainmentProxiesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_containmentProxies_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_containmentProxies_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__CONTAINMENT_PROXIES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Minimal Reflective Methods feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMinimalReflectiveMethodsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_minimalReflectiveMethods_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_minimalReflectiveMethods_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__MINIMAL_REFLECTIVE_METHODS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Suppress Containment feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSuppressContainmentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_suppressContainment_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_suppressContainment_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__SUPPRESS_CONTAINMENT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Suppress Notification feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSuppressNotificationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_suppressNotification_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_suppressNotification_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__SUPPRESS_NOTIFICATION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Array Accessors feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addArrayAccessorsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_arrayAccessors_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_arrayAccessors_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__ARRAY_ACCESSORS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Suppress Unsettable feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSuppressUnsettablePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_suppressUnsettable_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_suppressUnsettable_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__SUPPRESS_UNSETTABLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Facade Helper Class feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFacadeHelperClassPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_facadeHelperClass_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_facadeHelperClass_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__FACADE_HELPER_CLASS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Compliance Level feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addComplianceLevelPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_complianceLevel_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_complianceLevel_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__COMPLIANCE_LEVEL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Suppress Gen Model Annotations feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSuppressGenModelAnnotationsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_suppressGenModelAnnotations_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_suppressGenModelAnnotations_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__SUPPRESS_GEN_MODEL_ANNOTATIONS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Copyright Fields feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCopyrightFieldsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_copyrightFields_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_copyrightFields_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__COPYRIGHT_FIELDS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Binary Compatible Reflective Methods feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBinaryCompatibleReflectiveMethodsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_binaryCompatibleReflectiveMethods_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_binaryCompatibleReflectiveMethods_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__BINARY_COMPATIBLE_REFLECTIVE_METHODS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Public Constructors feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPublicConstructorsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_publicConstructors_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_publicConstructors_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__PUBLIC_CONSTRUCTORS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Template Plugin Variables feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTemplatePluginVariablesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_templatePluginVariables_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_templatePluginVariables_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__TEMPLATE_PLUGIN_VARIABLES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Provider Root Extends Class feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProviderRootExtendsClassPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_providerRootExtendsClass_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_providerRootExtendsClass_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__PROVIDER_ROOT_EXTENDS_CLASS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Edit Plugin ID feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEditPluginIDPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_editPluginID_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_editPluginID_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__EDIT_PLUGIN_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Edit Plugin Variables feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEditPluginVariablesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_editPluginVariables_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_editPluginVariables_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__EDIT_PLUGIN_VARIABLES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Editor Plugin ID feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEditorPluginIDPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_editorPluginID_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_editorPluginID_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__EDITOR_PLUGIN_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Editor Plugin Variables feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEditorPluginVariablesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_editorPluginVariables_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_editorPluginVariables_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__EDITOR_PLUGIN_VARIABLES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Tests Plugin ID feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTestsPluginIDPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_testsPluginID_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_testsPluginID_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__TESTS_PLUGIN_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Tests Plugin Variables feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTestsPluginVariablesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_testsPluginVariables_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_testsPluginVariables_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__TESTS_PLUGIN_VARIABLES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Optimized Has Children feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOptimizedHasChildrenPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_optimizedHasChildren_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_optimizedHasChildren_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__OPTIMIZED_HAS_CHILDREN,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Table Providers feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTableProvidersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_tableProviders_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_tableProviders_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__TABLE_PROVIDERS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Color Providers feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addColorProvidersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_colorProviders_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_colorProviders_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__COLOR_PROVIDERS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Font Providers feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFontProvidersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_fontProviders_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_fontProviders_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__FONT_PROVIDERS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Runtime Version feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRuntimeVersionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_runtimeVersion_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_runtimeVersion_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__RUNTIME_VERSION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Language feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLanguagePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_language_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_language_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__LANGUAGE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Packed Enums feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPackedEnumsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_packedEnums_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_packedEnums_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__PACKED_ENUMS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Used Gen Packages feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUsedGenPackagesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_usedGenPackages_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_usedGenPackages_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__USED_GEN_PACKAGES,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Interface Name Pattern feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInterfaceNamePatternPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_interfaceNamePattern_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_interfaceNamePattern_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__INTERFACE_NAME_PATTERN,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Class Name Pattern feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addClassNamePatternPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_classNamePattern_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_classNamePattern_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__CLASS_NAME_PATTERN,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Operation Reflection feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOperationReflectionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_operationReflection_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_operationReflection_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__OPERATION_REFLECTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Rich Ajax Platform feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRichAjaxPlatformPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_richAjaxPlatform_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_richAjaxPlatform_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__RICH_AJAX_PLATFORM,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Runtime Platform feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRuntimePlatformPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_runtimePlatform_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_runtimePlatform_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__RUNTIME_PLATFORM,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Import Organizing feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addImportOrganizingPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_importOrganizing_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_importOrganizing_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__IMPORT_ORGANIZING,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Plugin Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPluginKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_pluginKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_pluginKey_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__PLUGIN_KEY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Decoration feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDecorationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_decoration_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_decoration_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__DECORATION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Style Providers feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStyleProvidersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_styleProviders_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_styleProviders_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__STYLE_PROVIDERS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Cleanup feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCleanupPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_cleanup_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_cleanup_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__CLEANUP,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the OS Gi Compatible feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOSGiCompatiblePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenModel_oSGiCompatible_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenModel_oSGiCompatible_feature", "_UI_GenModel_type"),
				 GenmodelPackage.Literals.GEN_MODEL__OS_GI_COMPATIBLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
			childrenFeatures.add(GenmodelPackage.Literals.GEN_MODEL__GEN_PACKAGES);
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
	 * This returns GenModel.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/GenModel"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((GenModel)object).getModelName();
		return label == null || label.length() == 0 ?
			getString("_UI_GenModel_type") :
			getString("_UI_GenModel_type") + " " + label;
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

		switch (notification.getFeatureID(GenModel.class)) {
			case GenmodelPackage.GEN_MODEL__COPYRIGHT_TEXT:
			case GenmodelPackage.GEN_MODEL__MODEL_DIRECTORY:
			case GenmodelPackage.GEN_MODEL__CREATION_COMMANDS:
			case GenmodelPackage.GEN_MODEL__CREATION_ICONS:
			case GenmodelPackage.GEN_MODEL__CREATION_SUBMENUS:
			case GenmodelPackage.GEN_MODEL__EDIT_DIRECTORY:
			case GenmodelPackage.GEN_MODEL__EDITOR_DIRECTORY:
			case GenmodelPackage.GEN_MODEL__MODEL_PLUGIN_ID:
			case GenmodelPackage.GEN_MODEL__TEMPLATE_DIRECTORY:
			case GenmodelPackage.GEN_MODEL__RUNTIME_JAR:
			case GenmodelPackage.GEN_MODEL__FOREIGN_MODEL:
			case GenmodelPackage.GEN_MODEL__DYNAMIC_TEMPLATES:
			case GenmodelPackage.GEN_MODEL__REDIRECTION:
			case GenmodelPackage.GEN_MODEL__FORCE_OVERWRITE:
			case GenmodelPackage.GEN_MODEL__NON_EXTERNALIZED_STRING_TAG:
			case GenmodelPackage.GEN_MODEL__MODEL_NAME:
			case GenmodelPackage.GEN_MODEL__MODEL_PLUGIN_CLASS:
			case GenmodelPackage.GEN_MODEL__EDIT_PLUGIN_CLASS:
			case GenmodelPackage.GEN_MODEL__EDITOR_PLUGIN_CLASS:
			case GenmodelPackage.GEN_MODEL__UPDATE_CLASSPATH:
			case GenmodelPackage.GEN_MODEL__GENERATE_SCHEMA:
			case GenmodelPackage.GEN_MODEL__NON_NLS_MARKERS:
			case GenmodelPackage.GEN_MODEL__STATIC_PACKAGES:
			case GenmodelPackage.GEN_MODEL__MODEL_PLUGIN_VARIABLES:
			case GenmodelPackage.GEN_MODEL__ROOT_EXTENDS_INTERFACE:
			case GenmodelPackage.GEN_MODEL__ROOT_EXTENDS_CLASS:
			case GenmodelPackage.GEN_MODEL__ROOT_IMPLEMENTS_INTERFACE:
			case GenmodelPackage.GEN_MODEL__SUPPRESS_EMF_TYPES:
			case GenmodelPackage.GEN_MODEL__SUPPRESS_EMF_META_DATA:
			case GenmodelPackage.GEN_MODEL__SUPPRESS_EMF_MODEL_TAGS:
			case GenmodelPackage.GEN_MODEL__SUPPRESS_INTERFACES:
			case GenmodelPackage.GEN_MODEL__FEATURE_MAP_WRAPPER_INTERFACE:
			case GenmodelPackage.GEN_MODEL__FEATURE_MAP_WRAPPER_INTERNAL_INTERFACE:
			case GenmodelPackage.GEN_MODEL__FEATURE_MAP_WRAPPER_CLASS:
			case GenmodelPackage.GEN_MODEL__RUNTIME_COMPATIBILITY:
			case GenmodelPackage.GEN_MODEL__RICH_CLIENT_PLATFORM:
			case GenmodelPackage.GEN_MODEL__REFLECTIVE_DELEGATION:
			case GenmodelPackage.GEN_MODEL__CODE_FORMATTING:
			case GenmodelPackage.GEN_MODEL__COMMENT_FORMATTING:
			case GenmodelPackage.GEN_MODEL__TESTS_DIRECTORY:
			case GenmodelPackage.GEN_MODEL__TEST_SUITE_CLASS:
			case GenmodelPackage.GEN_MODEL__BOOLEAN_FLAGS_FIELD:
			case GenmodelPackage.GEN_MODEL__BOOLEAN_FLAGS_RESERVED_BITS:
			case GenmodelPackage.GEN_MODEL__IMPORTER_ID:
			case GenmodelPackage.GEN_MODEL__BUNDLE_MANIFEST:
			case GenmodelPackage.GEN_MODEL__FEATURE_DELEGATION:
			case GenmodelPackage.GEN_MODEL__CONTAINMENT_PROXIES:
			case GenmodelPackage.GEN_MODEL__MINIMAL_REFLECTIVE_METHODS:
			case GenmodelPackage.GEN_MODEL__SUPPRESS_CONTAINMENT:
			case GenmodelPackage.GEN_MODEL__SUPPRESS_NOTIFICATION:
			case GenmodelPackage.GEN_MODEL__ARRAY_ACCESSORS:
			case GenmodelPackage.GEN_MODEL__SUPPRESS_UNSETTABLE:
			case GenmodelPackage.GEN_MODEL__FACADE_HELPER_CLASS:
			case GenmodelPackage.GEN_MODEL__COMPLIANCE_LEVEL:
			case GenmodelPackage.GEN_MODEL__SUPPRESS_GEN_MODEL_ANNOTATIONS:
			case GenmodelPackage.GEN_MODEL__COPYRIGHT_FIELDS:
			case GenmodelPackage.GEN_MODEL__BINARY_COMPATIBLE_REFLECTIVE_METHODS:
			case GenmodelPackage.GEN_MODEL__PUBLIC_CONSTRUCTORS:
			case GenmodelPackage.GEN_MODEL__TEMPLATE_PLUGIN_VARIABLES:
			case GenmodelPackage.GEN_MODEL__PROVIDER_ROOT_EXTENDS_CLASS:
			case GenmodelPackage.GEN_MODEL__EDIT_PLUGIN_ID:
			case GenmodelPackage.GEN_MODEL__EDIT_PLUGIN_VARIABLES:
			case GenmodelPackage.GEN_MODEL__EDITOR_PLUGIN_ID:
			case GenmodelPackage.GEN_MODEL__EDITOR_PLUGIN_VARIABLES:
			case GenmodelPackage.GEN_MODEL__TESTS_PLUGIN_ID:
			case GenmodelPackage.GEN_MODEL__TESTS_PLUGIN_VARIABLES:
			case GenmodelPackage.GEN_MODEL__OPTIMIZED_HAS_CHILDREN:
			case GenmodelPackage.GEN_MODEL__TABLE_PROVIDERS:
			case GenmodelPackage.GEN_MODEL__COLOR_PROVIDERS:
			case GenmodelPackage.GEN_MODEL__FONT_PROVIDERS:
			case GenmodelPackage.GEN_MODEL__RUNTIME_VERSION:
			case GenmodelPackage.GEN_MODEL__LANGUAGE:
			case GenmodelPackage.GEN_MODEL__PACKED_ENUMS:
			case GenmodelPackage.GEN_MODEL__INTERFACE_NAME_PATTERN:
			case GenmodelPackage.GEN_MODEL__CLASS_NAME_PATTERN:
			case GenmodelPackage.GEN_MODEL__OPERATION_REFLECTION:
			case GenmodelPackage.GEN_MODEL__RICH_AJAX_PLATFORM:
			case GenmodelPackage.GEN_MODEL__RUNTIME_PLATFORM:
			case GenmodelPackage.GEN_MODEL__IMPORT_ORGANIZING:
			case GenmodelPackage.GEN_MODEL__PLUGIN_KEY:
			case GenmodelPackage.GEN_MODEL__DECORATION:
			case GenmodelPackage.GEN_MODEL__STYLE_PROVIDERS:
			case GenmodelPackage.GEN_MODEL__CLEANUP:
			case GenmodelPackage.GEN_MODEL__OS_GI_COMPATIBLE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case GenmodelPackage.GEN_MODEL__GEN_PACKAGES:
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
				(GenmodelPackage.Literals.GEN_MODEL__GEN_PACKAGES,
				 GenmodelFactory.eINSTANCE.createGenPackage()));
	}

}
