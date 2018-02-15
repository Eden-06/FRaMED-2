/**
 */
package genmodel.impl;

import genmodel.GenDecoration;
import genmodel.GenDelegationKind;
import genmodel.GenJDKLevel;
import genmodel.GenRuntimePlatform;
import genmodel.GenRuntimeVersion;
import genmodel.GenmodelPackage;

import java.util.Collection;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link genmodel.impl.GenModelImpl#getCopyrightText <em>Copyright Text</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getModelDirectory <em>Model Directory</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#isCreationCommands <em>Creation Commands</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#isCreationIcons <em>Creation Icons</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#isCreationSubmenus <em>Creation Submenus</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getEditDirectory <em>Edit Directory</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getEditorDirectory <em>Editor Directory</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getModelPluginID <em>Model Plugin ID</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getTemplateDirectory <em>Template Directory</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#isRuntimeJar <em>Runtime Jar</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getForeignModel <em>Foreign Model</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#isDynamicTemplates <em>Dynamic Templates</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getRedirection <em>Redirection</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#isForceOverwrite <em>Force Overwrite</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getNonExternalizedStringTag <em>Non Externalized String Tag</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getModelName <em>Model Name</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getModelPluginClass <em>Model Plugin Class</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getEditPluginClass <em>Edit Plugin Class</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getEditorPluginClass <em>Editor Plugin Class</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#isUpdateClasspath <em>Update Classpath</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#isGenerateSchema <em>Generate Schema</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#isNonNLSMarkers <em>Non NLS Markers</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getStaticPackages <em>Static Packages</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getModelPluginVariables <em>Model Plugin Variables</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getRootExtendsInterface <em>Root Extends Interface</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getRootExtendsClass <em>Root Extends Class</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getRootImplementsInterface <em>Root Implements Interface</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#isSuppressEMFTypes <em>Suppress EMF Types</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#isSuppressEMFMetaData <em>Suppress EMF Meta Data</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#isSuppressEMFModelTags <em>Suppress EMF Model Tags</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#isSuppressInterfaces <em>Suppress Interfaces</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getFeatureMapWrapperInterface <em>Feature Map Wrapper Interface</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getFeatureMapWrapperInternalInterface <em>Feature Map Wrapper Internal Interface</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getFeatureMapWrapperClass <em>Feature Map Wrapper Class</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#isRuntimeCompatibility <em>Runtime Compatibility</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#isRichClientPlatform <em>Rich Client Platform</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#isReflectiveDelegation <em>Reflective Delegation</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#isCodeFormatting <em>Code Formatting</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#isCommentFormatting <em>Comment Formatting</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getTestsDirectory <em>Tests Directory</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getTestSuiteClass <em>Test Suite Class</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getBooleanFlagsField <em>Boolean Flags Field</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getBooleanFlagsReservedBits <em>Boolean Flags Reserved Bits</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getImporterID <em>Importer ID</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#isBundleManifest <em>Bundle Manifest</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getFeatureDelegation <em>Feature Delegation</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#isContainmentProxies <em>Containment Proxies</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#isMinimalReflectiveMethods <em>Minimal Reflective Methods</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#isSuppressContainment <em>Suppress Containment</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#isSuppressNotification <em>Suppress Notification</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#isArrayAccessors <em>Array Accessors</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#isSuppressUnsettable <em>Suppress Unsettable</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getFacadeHelperClass <em>Facade Helper Class</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getComplianceLevel <em>Compliance Level</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#isSuppressGenModelAnnotations <em>Suppress Gen Model Annotations</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#isCopyrightFields <em>Copyright Fields</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#isBinaryCompatibleReflectiveMethods <em>Binary Compatible Reflective Methods</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#isPublicConstructors <em>Public Constructors</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getTemplatePluginVariables <em>Template Plugin Variables</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getProviderRootExtendsClass <em>Provider Root Extends Class</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getEditPluginID <em>Edit Plugin ID</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getEditPluginVariables <em>Edit Plugin Variables</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getEditorPluginID <em>Editor Plugin ID</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getEditorPluginVariables <em>Editor Plugin Variables</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getTestsPluginID <em>Tests Plugin ID</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getTestsPluginVariables <em>Tests Plugin Variables</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#isOptimizedHasChildren <em>Optimized Has Children</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#isTableProviders <em>Table Providers</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#isColorProviders <em>Color Providers</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#isFontProviders <em>Font Providers</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getRuntimeVersion <em>Runtime Version</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getLanguage <em>Language</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#isPackedEnums <em>Packed Enums</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getGenPackages <em>Gen Packages</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getUsedGenPackages <em>Used Gen Packages</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getInterfaceNamePattern <em>Interface Name Pattern</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getClassNamePattern <em>Class Name Pattern</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#isOperationReflection <em>Operation Reflection</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#isRichAjaxPlatform <em>Rich Ajax Platform</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getRuntimePlatform <em>Runtime Platform</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#isImportOrganizing <em>Import Organizing</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getPluginKey <em>Plugin Key</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#getDecoration <em>Decoration</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#isStyleProviders <em>Style Providers</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#isCleanup <em>Cleanup</em>}</li>
 *   <li>{@link genmodel.impl.GenModelImpl#isOSGiCompatible <em>OS Gi Compatible</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenModelImpl extends GenBaseImpl implements GenModel {
	/**
	 * The default value of the '{@link #getCopyrightText() <em>Copyright Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCopyrightText()
	 * @generated
	 * @ordered
	 */
	protected static final String COPYRIGHT_TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCopyrightText() <em>Copyright Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCopyrightText()
	 * @generated
	 * @ordered
	 */
	protected String copyrightText = COPYRIGHT_TEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getModelDirectory() <em>Model Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelDirectory()
	 * @generated
	 * @ordered
	 */
	protected static final String MODEL_DIRECTORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModelDirectory() <em>Model Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelDirectory()
	 * @generated
	 * @ordered
	 */
	protected String modelDirectory = MODEL_DIRECTORY_EDEFAULT;

	/**
	 * The default value of the '{@link #isCreationCommands() <em>Creation Commands</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCreationCommands()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CREATION_COMMANDS_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isCreationCommands() <em>Creation Commands</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCreationCommands()
	 * @generated
	 * @ordered
	 */
	protected boolean creationCommands = CREATION_COMMANDS_EDEFAULT;

	/**
	 * The default value of the '{@link #isCreationIcons() <em>Creation Icons</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCreationIcons()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CREATION_ICONS_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isCreationIcons() <em>Creation Icons</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCreationIcons()
	 * @generated
	 * @ordered
	 */
	protected boolean creationIcons = CREATION_ICONS_EDEFAULT;

	/**
	 * The default value of the '{@link #isCreationSubmenus() <em>Creation Submenus</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCreationSubmenus()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CREATION_SUBMENUS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCreationSubmenus() <em>Creation Submenus</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCreationSubmenus()
	 * @generated
	 * @ordered
	 */
	protected boolean creationSubmenus = CREATION_SUBMENUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getEditDirectory() <em>Edit Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditDirectory()
	 * @generated
	 * @ordered
	 */
	protected static final String EDIT_DIRECTORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEditDirectory() <em>Edit Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditDirectory()
	 * @generated
	 * @ordered
	 */
	protected String editDirectory = EDIT_DIRECTORY_EDEFAULT;

	/**
	 * This is true if the Edit Directory attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean editDirectoryESet;

	/**
	 * The default value of the '{@link #getEditorDirectory() <em>Editor Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditorDirectory()
	 * @generated
	 * @ordered
	 */
	protected static final String EDITOR_DIRECTORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEditorDirectory() <em>Editor Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditorDirectory()
	 * @generated
	 * @ordered
	 */
	protected String editorDirectory = EDITOR_DIRECTORY_EDEFAULT;

	/**
	 * This is true if the Editor Directory attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean editorDirectoryESet;

	/**
	 * The default value of the '{@link #getModelPluginID() <em>Model Plugin ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelPluginID()
	 * @generated
	 * @ordered
	 */
	protected static final String MODEL_PLUGIN_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModelPluginID() <em>Model Plugin ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelPluginID()
	 * @generated
	 * @ordered
	 */
	protected String modelPluginID = MODEL_PLUGIN_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getTemplateDirectory() <em>Template Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplateDirectory()
	 * @generated
	 * @ordered
	 */
	protected static final String TEMPLATE_DIRECTORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTemplateDirectory() <em>Template Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplateDirectory()
	 * @generated
	 * @ordered
	 */
	protected String templateDirectory = TEMPLATE_DIRECTORY_EDEFAULT;

	/**
	 * The default value of the '{@link #isRuntimeJar() <em>Runtime Jar</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRuntimeJar()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RUNTIME_JAR_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRuntimeJar() <em>Runtime Jar</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRuntimeJar()
	 * @generated
	 * @ordered
	 */
	protected boolean runtimeJar = RUNTIME_JAR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getForeignModel() <em>Foreign Model</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForeignModel()
	 * @generated
	 * @ordered
	 */
	protected EList<String> foreignModel;

	/**
	 * The default value of the '{@link #isDynamicTemplates() <em>Dynamic Templates</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDynamicTemplates()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DYNAMIC_TEMPLATES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDynamicTemplates() <em>Dynamic Templates</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDynamicTemplates()
	 * @generated
	 * @ordered
	 */
	protected boolean dynamicTemplates = DYNAMIC_TEMPLATES_EDEFAULT;

	/**
	 * The default value of the '{@link #getRedirection() <em>Redirection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRedirection()
	 * @generated
	 * @ordered
	 */
	protected static final String REDIRECTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRedirection() <em>Redirection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRedirection()
	 * @generated
	 * @ordered
	 */
	protected String redirection = REDIRECTION_EDEFAULT;

	/**
	 * The default value of the '{@link #isForceOverwrite() <em>Force Overwrite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isForceOverwrite()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FORCE_OVERWRITE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isForceOverwrite() <em>Force Overwrite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isForceOverwrite()
	 * @generated
	 * @ordered
	 */
	protected boolean forceOverwrite = FORCE_OVERWRITE_EDEFAULT;

	/**
	 * The default value of the '{@link #getNonExternalizedStringTag() <em>Non Externalized String Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNonExternalizedStringTag()
	 * @generated
	 * @ordered
	 */
	protected static final String NON_EXTERNALIZED_STRING_TAG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNonExternalizedStringTag() <em>Non Externalized String Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNonExternalizedStringTag()
	 * @generated
	 * @ordered
	 */
	protected String nonExternalizedStringTag = NON_EXTERNALIZED_STRING_TAG_EDEFAULT;

	/**
	 * The default value of the '{@link #getModelName() <em>Model Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelName()
	 * @generated
	 * @ordered
	 */
	protected static final String MODEL_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModelName() <em>Model Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelName()
	 * @generated
	 * @ordered
	 */
	protected String modelName = MODEL_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getModelPluginClass() <em>Model Plugin Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelPluginClass()
	 * @generated
	 * @ordered
	 */
	protected static final String MODEL_PLUGIN_CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModelPluginClass() <em>Model Plugin Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelPluginClass()
	 * @generated
	 * @ordered
	 */
	protected String modelPluginClass = MODEL_PLUGIN_CLASS_EDEFAULT;

	/**
	 * The default value of the '{@link #getEditPluginClass() <em>Edit Plugin Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditPluginClass()
	 * @generated
	 * @ordered
	 */
	protected static final String EDIT_PLUGIN_CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEditPluginClass() <em>Edit Plugin Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditPluginClass()
	 * @generated
	 * @ordered
	 */
	protected String editPluginClass = EDIT_PLUGIN_CLASS_EDEFAULT;

	/**
	 * This is true if the Edit Plugin Class attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean editPluginClassESet;

	/**
	 * The default value of the '{@link #getEditorPluginClass() <em>Editor Plugin Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditorPluginClass()
	 * @generated
	 * @ordered
	 */
	protected static final String EDITOR_PLUGIN_CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEditorPluginClass() <em>Editor Plugin Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditorPluginClass()
	 * @generated
	 * @ordered
	 */
	protected String editorPluginClass = EDITOR_PLUGIN_CLASS_EDEFAULT;

	/**
	 * This is true if the Editor Plugin Class attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean editorPluginClassESet;

	/**
	 * The default value of the '{@link #isUpdateClasspath() <em>Update Classpath</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUpdateClasspath()
	 * @generated
	 * @ordered
	 */
	protected static final boolean UPDATE_CLASSPATH_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isUpdateClasspath() <em>Update Classpath</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUpdateClasspath()
	 * @generated
	 * @ordered
	 */
	protected boolean updateClasspath = UPDATE_CLASSPATH_EDEFAULT;

	/**
	 * The default value of the '{@link #isGenerateSchema() <em>Generate Schema</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGenerateSchema()
	 * @generated
	 * @ordered
	 */
	protected static final boolean GENERATE_SCHEMA_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isGenerateSchema() <em>Generate Schema</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGenerateSchema()
	 * @generated
	 * @ordered
	 */
	protected boolean generateSchema = GENERATE_SCHEMA_EDEFAULT;

	/**
	 * The default value of the '{@link #isNonNLSMarkers() <em>Non NLS Markers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNonNLSMarkers()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NON_NLS_MARKERS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNonNLSMarkers() <em>Non NLS Markers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNonNLSMarkers()
	 * @generated
	 * @ordered
	 */
	protected boolean nonNLSMarkers = NON_NLS_MARKERS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getStaticPackages() <em>Static Packages</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStaticPackages()
	 * @generated
	 * @ordered
	 */
	protected EList<String> staticPackages;

	/**
	 * The cached value of the '{@link #getModelPluginVariables() <em>Model Plugin Variables</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelPluginVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<String> modelPluginVariables;

	/**
	 * The default value of the '{@link #getRootExtendsInterface() <em>Root Extends Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootExtendsInterface()
	 * @generated
	 * @ordered
	 */
	protected static final String ROOT_EXTENDS_INTERFACE_EDEFAULT = "org.eclipse.emf.ecore.EObject";

	/**
	 * The cached value of the '{@link #getRootExtendsInterface() <em>Root Extends Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootExtendsInterface()
	 * @generated
	 * @ordered
	 */
	protected String rootExtendsInterface = ROOT_EXTENDS_INTERFACE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRootExtendsClass() <em>Root Extends Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootExtendsClass()
	 * @generated
	 * @ordered
	 */
	protected static final String ROOT_EXTENDS_CLASS_EDEFAULT = "org.eclipse.emf.ecore.impl.EObjectImpl";

	/**
	 * The cached value of the '{@link #getRootExtendsClass() <em>Root Extends Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootExtendsClass()
	 * @generated
	 * @ordered
	 */
	protected String rootExtendsClass = ROOT_EXTENDS_CLASS_EDEFAULT;

	/**
	 * The default value of the '{@link #getRootImplementsInterface() <em>Root Implements Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootImplementsInterface()
	 * @generated
	 * @ordered
	 */
	protected static final String ROOT_IMPLEMENTS_INTERFACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRootImplementsInterface() <em>Root Implements Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootImplementsInterface()
	 * @generated
	 * @ordered
	 */
	protected String rootImplementsInterface = ROOT_IMPLEMENTS_INTERFACE_EDEFAULT;

	/**
	 * The default value of the '{@link #isSuppressEMFTypes() <em>Suppress EMF Types</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSuppressEMFTypes()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SUPPRESS_EMF_TYPES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSuppressEMFTypes() <em>Suppress EMF Types</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSuppressEMFTypes()
	 * @generated
	 * @ordered
	 */
	protected boolean suppressEMFTypes = SUPPRESS_EMF_TYPES_EDEFAULT;

	/**
	 * The default value of the '{@link #isSuppressEMFMetaData() <em>Suppress EMF Meta Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSuppressEMFMetaData()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SUPPRESS_EMF_META_DATA_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSuppressEMFMetaData() <em>Suppress EMF Meta Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSuppressEMFMetaData()
	 * @generated
	 * @ordered
	 */
	protected boolean suppressEMFMetaData = SUPPRESS_EMF_META_DATA_EDEFAULT;

	/**
	 * The default value of the '{@link #isSuppressEMFModelTags() <em>Suppress EMF Model Tags</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSuppressEMFModelTags()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SUPPRESS_EMF_MODEL_TAGS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSuppressEMFModelTags() <em>Suppress EMF Model Tags</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSuppressEMFModelTags()
	 * @generated
	 * @ordered
	 */
	protected boolean suppressEMFModelTags = SUPPRESS_EMF_MODEL_TAGS_EDEFAULT;

	/**
	 * The default value of the '{@link #isSuppressInterfaces() <em>Suppress Interfaces</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSuppressInterfaces()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SUPPRESS_INTERFACES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSuppressInterfaces() <em>Suppress Interfaces</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSuppressInterfaces()
	 * @generated
	 * @ordered
	 */
	protected boolean suppressInterfaces = SUPPRESS_INTERFACES_EDEFAULT;

	/**
	 * The default value of the '{@link #getFeatureMapWrapperInterface() <em>Feature Map Wrapper Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureMapWrapperInterface()
	 * @generated
	 * @ordered
	 */
	protected static final String FEATURE_MAP_WRAPPER_INTERFACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFeatureMapWrapperInterface() <em>Feature Map Wrapper Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureMapWrapperInterface()
	 * @generated
	 * @ordered
	 */
	protected String featureMapWrapperInterface = FEATURE_MAP_WRAPPER_INTERFACE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFeatureMapWrapperInternalInterface() <em>Feature Map Wrapper Internal Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureMapWrapperInternalInterface()
	 * @generated
	 * @ordered
	 */
	protected static final String FEATURE_MAP_WRAPPER_INTERNAL_INTERFACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFeatureMapWrapperInternalInterface() <em>Feature Map Wrapper Internal Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureMapWrapperInternalInterface()
	 * @generated
	 * @ordered
	 */
	protected String featureMapWrapperInternalInterface = FEATURE_MAP_WRAPPER_INTERNAL_INTERFACE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFeatureMapWrapperClass() <em>Feature Map Wrapper Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureMapWrapperClass()
	 * @generated
	 * @ordered
	 */
	protected static final String FEATURE_MAP_WRAPPER_CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFeatureMapWrapperClass() <em>Feature Map Wrapper Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureMapWrapperClass()
	 * @generated
	 * @ordered
	 */
	protected String featureMapWrapperClass = FEATURE_MAP_WRAPPER_CLASS_EDEFAULT;

	/**
	 * The default value of the '{@link #isRuntimeCompatibility() <em>Runtime Compatibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRuntimeCompatibility()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RUNTIME_COMPATIBILITY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRuntimeCompatibility() <em>Runtime Compatibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRuntimeCompatibility()
	 * @generated
	 * @ordered
	 */
	protected boolean runtimeCompatibility = RUNTIME_COMPATIBILITY_EDEFAULT;

	/**
	 * The default value of the '{@link #isRichClientPlatform() <em>Rich Client Platform</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRichClientPlatform()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RICH_CLIENT_PLATFORM_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isReflectiveDelegation() <em>Reflective Delegation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReflectiveDelegation()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REFLECTIVE_DELEGATION_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isCodeFormatting() <em>Code Formatting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCodeFormatting()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CODE_FORMATTING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCodeFormatting() <em>Code Formatting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCodeFormatting()
	 * @generated
	 * @ordered
	 */
	protected boolean codeFormatting = CODE_FORMATTING_EDEFAULT;

	/**
	 * The default value of the '{@link #isCommentFormatting() <em>Comment Formatting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCommentFormatting()
	 * @generated
	 * @ordered
	 */
	protected static final boolean COMMENT_FORMATTING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCommentFormatting() <em>Comment Formatting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCommentFormatting()
	 * @generated
	 * @ordered
	 */
	protected boolean commentFormatting = COMMENT_FORMATTING_EDEFAULT;

	/**
	 * The default value of the '{@link #getTestsDirectory() <em>Tests Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestsDirectory()
	 * @generated
	 * @ordered
	 */
	protected static final String TESTS_DIRECTORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTestsDirectory() <em>Tests Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestsDirectory()
	 * @generated
	 * @ordered
	 */
	protected String testsDirectory = TESTS_DIRECTORY_EDEFAULT;

	/**
	 * This is true if the Tests Directory attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean testsDirectoryESet;

	/**
	 * The default value of the '{@link #getTestSuiteClass() <em>Test Suite Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestSuiteClass()
	 * @generated
	 * @ordered
	 */
	protected static final String TEST_SUITE_CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTestSuiteClass() <em>Test Suite Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestSuiteClass()
	 * @generated
	 * @ordered
	 */
	protected String testSuiteClass = TEST_SUITE_CLASS_EDEFAULT;

	/**
	 * This is true if the Test Suite Class attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean testSuiteClassESet;

	/**
	 * The default value of the '{@link #getBooleanFlagsField() <em>Boolean Flags Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBooleanFlagsField()
	 * @generated
	 * @ordered
	 */
	protected static final String BOOLEAN_FLAGS_FIELD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBooleanFlagsField() <em>Boolean Flags Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBooleanFlagsField()
	 * @generated
	 * @ordered
	 */
	protected String booleanFlagsField = BOOLEAN_FLAGS_FIELD_EDEFAULT;

	/**
	 * The default value of the '{@link #getBooleanFlagsReservedBits() <em>Boolean Flags Reserved Bits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBooleanFlagsReservedBits()
	 * @generated
	 * @ordered
	 */
	protected static final int BOOLEAN_FLAGS_RESERVED_BITS_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getBooleanFlagsReservedBits() <em>Boolean Flags Reserved Bits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBooleanFlagsReservedBits()
	 * @generated
	 * @ordered
	 */
	protected int booleanFlagsReservedBits = BOOLEAN_FLAGS_RESERVED_BITS_EDEFAULT;

	/**
	 * The default value of the '{@link #getImporterID() <em>Importer ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImporterID()
	 * @generated
	 * @ordered
	 */
	protected static final String IMPORTER_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImporterID() <em>Importer ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImporterID()
	 * @generated
	 * @ordered
	 */
	protected String importerID = IMPORTER_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #isBundleManifest() <em>Bundle Manifest</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBundleManifest()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BUNDLE_MANIFEST_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isBundleManifest() <em>Bundle Manifest</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBundleManifest()
	 * @generated
	 * @ordered
	 */
	protected boolean bundleManifest = BUNDLE_MANIFEST_EDEFAULT;

	/**
	 * The default value of the '{@link #getFeatureDelegation() <em>Feature Delegation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureDelegation()
	 * @generated
	 * @ordered
	 */
	protected static final GenDelegationKind FEATURE_DELEGATION_EDEFAULT = GenDelegationKind.NONE;

	/**
	 * The cached value of the '{@link #getFeatureDelegation() <em>Feature Delegation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureDelegation()
	 * @generated
	 * @ordered
	 */
	protected GenDelegationKind featureDelegation = FEATURE_DELEGATION_EDEFAULT;

	/**
	 * The default value of the '{@link #isContainmentProxies() <em>Containment Proxies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContainmentProxies()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONTAINMENT_PROXIES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isContainmentProxies() <em>Containment Proxies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContainmentProxies()
	 * @generated
	 * @ordered
	 */
	protected boolean containmentProxies = CONTAINMENT_PROXIES_EDEFAULT;

	/**
	 * The default value of the '{@link #isMinimalReflectiveMethods() <em>Minimal Reflective Methods</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMinimalReflectiveMethods()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MINIMAL_REFLECTIVE_METHODS_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isMinimalReflectiveMethods() <em>Minimal Reflective Methods</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMinimalReflectiveMethods()
	 * @generated
	 * @ordered
	 */
	protected boolean minimalReflectiveMethods = MINIMAL_REFLECTIVE_METHODS_EDEFAULT;

	/**
	 * The default value of the '{@link #isSuppressContainment() <em>Suppress Containment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSuppressContainment()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SUPPRESS_CONTAINMENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSuppressContainment() <em>Suppress Containment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSuppressContainment()
	 * @generated
	 * @ordered
	 */
	protected boolean suppressContainment = SUPPRESS_CONTAINMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #isSuppressNotification() <em>Suppress Notification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSuppressNotification()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SUPPRESS_NOTIFICATION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSuppressNotification() <em>Suppress Notification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSuppressNotification()
	 * @generated
	 * @ordered
	 */
	protected boolean suppressNotification = SUPPRESS_NOTIFICATION_EDEFAULT;

	/**
	 * The default value of the '{@link #isArrayAccessors() <em>Array Accessors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isArrayAccessors()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ARRAY_ACCESSORS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isArrayAccessors() <em>Array Accessors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isArrayAccessors()
	 * @generated
	 * @ordered
	 */
	protected boolean arrayAccessors = ARRAY_ACCESSORS_EDEFAULT;

	/**
	 * The default value of the '{@link #isSuppressUnsettable() <em>Suppress Unsettable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSuppressUnsettable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SUPPRESS_UNSETTABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSuppressUnsettable() <em>Suppress Unsettable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSuppressUnsettable()
	 * @generated
	 * @ordered
	 */
	protected boolean suppressUnsettable = SUPPRESS_UNSETTABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFacadeHelperClass() <em>Facade Helper Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacadeHelperClass()
	 * @generated
	 * @ordered
	 */
	protected static final String FACADE_HELPER_CLASS_EDEFAULT = "org.eclipse.emf.codegen.merge.java.facade.ast.ASTFacadeHelper";

	/**
	 * The cached value of the '{@link #getFacadeHelperClass() <em>Facade Helper Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacadeHelperClass()
	 * @generated
	 * @ordered
	 */
	protected String facadeHelperClass = FACADE_HELPER_CLASS_EDEFAULT;

	/**
	 * The default value of the '{@link #getComplianceLevel() <em>Compliance Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComplianceLevel()
	 * @generated
	 * @ordered
	 */
	protected static final GenJDKLevel COMPLIANCE_LEVEL_EDEFAULT = GenJDKLevel.JDK14;

	/**
	 * The cached value of the '{@link #getComplianceLevel() <em>Compliance Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComplianceLevel()
	 * @generated
	 * @ordered
	 */
	protected GenJDKLevel complianceLevel = COMPLIANCE_LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #isSuppressGenModelAnnotations() <em>Suppress Gen Model Annotations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSuppressGenModelAnnotations()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SUPPRESS_GEN_MODEL_ANNOTATIONS_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isSuppressGenModelAnnotations() <em>Suppress Gen Model Annotations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSuppressGenModelAnnotations()
	 * @generated
	 * @ordered
	 */
	protected boolean suppressGenModelAnnotations = SUPPRESS_GEN_MODEL_ANNOTATIONS_EDEFAULT;

	/**
	 * The default value of the '{@link #isCopyrightFields() <em>Copyright Fields</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCopyrightFields()
	 * @generated
	 * @ordered
	 */
	protected static final boolean COPYRIGHT_FIELDS_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isCopyrightFields() <em>Copyright Fields</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCopyrightFields()
	 * @generated
	 * @ordered
	 */
	protected boolean copyrightFields = COPYRIGHT_FIELDS_EDEFAULT;

	/**
	 * The default value of the '{@link #isBinaryCompatibleReflectiveMethods() <em>Binary Compatible Reflective Methods</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBinaryCompatibleReflectiveMethods()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BINARY_COMPATIBLE_REFLECTIVE_METHODS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isBinaryCompatibleReflectiveMethods() <em>Binary Compatible Reflective Methods</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBinaryCompatibleReflectiveMethods()
	 * @generated
	 * @ordered
	 */
	protected boolean binaryCompatibleReflectiveMethods = BINARY_COMPATIBLE_REFLECTIVE_METHODS_EDEFAULT;

	/**
	 * The default value of the '{@link #isPublicConstructors() <em>Public Constructors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPublicConstructors()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PUBLIC_CONSTRUCTORS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPublicConstructors() <em>Public Constructors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPublicConstructors()
	 * @generated
	 * @ordered
	 */
	protected boolean publicConstructors = PUBLIC_CONSTRUCTORS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTemplatePluginVariables() <em>Template Plugin Variables</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplatePluginVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<String> templatePluginVariables;

	/**
	 * The default value of the '{@link #getProviderRootExtendsClass() <em>Provider Root Extends Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProviderRootExtendsClass()
	 * @generated
	 * @ordered
	 */
	protected static final String PROVIDER_ROOT_EXTENDS_CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProviderRootExtendsClass() <em>Provider Root Extends Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProviderRootExtendsClass()
	 * @generated
	 * @ordered
	 */
	protected String providerRootExtendsClass = PROVIDER_ROOT_EXTENDS_CLASS_EDEFAULT;

	/**
	 * The default value of the '{@link #getEditPluginID() <em>Edit Plugin ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditPluginID()
	 * @generated
	 * @ordered
	 */
	protected static final String EDIT_PLUGIN_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEditPluginID() <em>Edit Plugin ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditPluginID()
	 * @generated
	 * @ordered
	 */
	protected String editPluginID = EDIT_PLUGIN_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEditPluginVariables() <em>Edit Plugin Variables</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditPluginVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<String> editPluginVariables;

	/**
	 * The default value of the '{@link #getEditorPluginID() <em>Editor Plugin ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditorPluginID()
	 * @generated
	 * @ordered
	 */
	protected static final String EDITOR_PLUGIN_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEditorPluginID() <em>Editor Plugin ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditorPluginID()
	 * @generated
	 * @ordered
	 */
	protected String editorPluginID = EDITOR_PLUGIN_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEditorPluginVariables() <em>Editor Plugin Variables</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditorPluginVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<String> editorPluginVariables;

	/**
	 * The default value of the '{@link #getTestsPluginID() <em>Tests Plugin ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestsPluginID()
	 * @generated
	 * @ordered
	 */
	protected static final String TESTS_PLUGIN_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTestsPluginID() <em>Tests Plugin ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestsPluginID()
	 * @generated
	 * @ordered
	 */
	protected String testsPluginID = TESTS_PLUGIN_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTestsPluginVariables() <em>Tests Plugin Variables</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestsPluginVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<String> testsPluginVariables;

	/**
	 * The default value of the '{@link #isOptimizedHasChildren() <em>Optimized Has Children</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOptimizedHasChildren()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OPTIMIZED_HAS_CHILDREN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOptimizedHasChildren() <em>Optimized Has Children</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOptimizedHasChildren()
	 * @generated
	 * @ordered
	 */
	protected boolean optimizedHasChildren = OPTIMIZED_HAS_CHILDREN_EDEFAULT;

	/**
	 * The default value of the '{@link #isTableProviders() <em>Table Providers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTableProviders()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TABLE_PROVIDERS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTableProviders() <em>Table Providers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTableProviders()
	 * @generated
	 * @ordered
	 */
	protected boolean tableProviders = TABLE_PROVIDERS_EDEFAULT;

	/**
	 * The default value of the '{@link #isColorProviders() <em>Color Providers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isColorProviders()
	 * @generated
	 * @ordered
	 */
	protected static final boolean COLOR_PROVIDERS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isColorProviders() <em>Color Providers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isColorProviders()
	 * @generated
	 * @ordered
	 */
	protected boolean colorProviders = COLOR_PROVIDERS_EDEFAULT;

	/**
	 * The default value of the '{@link #isFontProviders() <em>Font Providers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFontProviders()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FONT_PROVIDERS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFontProviders() <em>Font Providers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFontProviders()
	 * @generated
	 * @ordered
	 */
	protected boolean fontProviders = FONT_PROVIDERS_EDEFAULT;

	/**
	 * The default value of the '{@link #getRuntimeVersion() <em>Runtime Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuntimeVersion()
	 * @generated
	 * @ordered
	 */
	protected static final GenRuntimeVersion RUNTIME_VERSION_EDEFAULT = GenRuntimeVersion.EMF22;

	/**
	 * The cached value of the '{@link #getRuntimeVersion() <em>Runtime Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuntimeVersion()
	 * @generated
	 * @ordered
	 */
	protected GenRuntimeVersion runtimeVersion = RUNTIME_VERSION_EDEFAULT;

	/**
	 * This is true if the Runtime Version attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean runtimeVersionESet;

	/**
	 * The default value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String LANGUAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected String language = LANGUAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #isPackedEnums() <em>Packed Enums</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPackedEnums()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PACKED_ENUMS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPackedEnums() <em>Packed Enums</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPackedEnums()
	 * @generated
	 * @ordered
	 */
	protected boolean packedEnums = PACKED_ENUMS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getGenPackages() <em>Gen Packages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenPackages()
	 * @generated
	 * @ordered
	 */
	protected EList<GenPackage> genPackages;

	/**
	 * The cached value of the '{@link #getUsedGenPackages() <em>Used Gen Packages</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsedGenPackages()
	 * @generated
	 * @ordered
	 */
	protected EList<GenPackage> usedGenPackages;

	/**
	 * The default value of the '{@link #getInterfaceNamePattern() <em>Interface Name Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterfaceNamePattern()
	 * @generated
	 * @ordered
	 */
	protected static final String INTERFACE_NAME_PATTERN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInterfaceNamePattern() <em>Interface Name Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterfaceNamePattern()
	 * @generated
	 * @ordered
	 */
	protected String interfaceNamePattern = INTERFACE_NAME_PATTERN_EDEFAULT;

	/**
	 * The default value of the '{@link #getClassNamePattern() <em>Class Name Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassNamePattern()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASS_NAME_PATTERN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClassNamePattern() <em>Class Name Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassNamePattern()
	 * @generated
	 * @ordered
	 */
	protected String classNamePattern = CLASS_NAME_PATTERN_EDEFAULT;

	/**
	 * The default value of the '{@link #isOperationReflection() <em>Operation Reflection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOperationReflection()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OPERATION_REFLECTION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOperationReflection() <em>Operation Reflection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOperationReflection()
	 * @generated
	 * @ordered
	 */
	protected boolean operationReflection = OPERATION_REFLECTION_EDEFAULT;

	/**
	 * The default value of the '{@link #isRichAjaxPlatform() <em>Rich Ajax Platform</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRichAjaxPlatform()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RICH_AJAX_PLATFORM_EDEFAULT = false;

	/**
	 * The default value of the '{@link #getRuntimePlatform() <em>Runtime Platform</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuntimePlatform()
	 * @generated
	 * @ordered
	 */
	protected static final GenRuntimePlatform RUNTIME_PLATFORM_EDEFAULT = GenRuntimePlatform.IDE;

	/**
	 * The cached value of the '{@link #getRuntimePlatform() <em>Runtime Platform</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuntimePlatform()
	 * @generated
	 * @ordered
	 */
	protected GenRuntimePlatform runtimePlatform = RUNTIME_PLATFORM_EDEFAULT;

	/**
	 * The default value of the '{@link #isImportOrganizing() <em>Import Organizing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isImportOrganizing()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IMPORT_ORGANIZING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isImportOrganizing() <em>Import Organizing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isImportOrganizing()
	 * @generated
	 * @ordered
	 */
	protected boolean importOrganizing = IMPORT_ORGANIZING_EDEFAULT;

	/**
	 * The default value of the '{@link #getPluginKey() <em>Plugin Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPluginKey()
	 * @generated
	 * @ordered
	 */
	protected static final String PLUGIN_KEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPluginKey() <em>Plugin Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPluginKey()
	 * @generated
	 * @ordered
	 */
	protected String pluginKey = PLUGIN_KEY_EDEFAULT;

	/**
	 * The default value of the '{@link #getDecoration() <em>Decoration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDecoration()
	 * @generated
	 * @ordered
	 */
	protected static final GenDecoration DECORATION_EDEFAULT = GenDecoration.NONE;

	/**
	 * The cached value of the '{@link #getDecoration() <em>Decoration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDecoration()
	 * @generated
	 * @ordered
	 */
	protected GenDecoration decoration = DECORATION_EDEFAULT;

	/**
	 * The default value of the '{@link #isStyleProviders() <em>Style Providers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStyleProviders()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STYLE_PROVIDERS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isStyleProviders() <em>Style Providers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStyleProviders()
	 * @generated
	 * @ordered
	 */
	protected boolean styleProviders = STYLE_PROVIDERS_EDEFAULT;

	/**
	 * The default value of the '{@link #isCleanup() <em>Cleanup</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCleanup()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CLEANUP_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCleanup() <em>Cleanup</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCleanup()
	 * @generated
	 * @ordered
	 */
	protected boolean cleanup = CLEANUP_EDEFAULT;

	/**
	 * The default value of the '{@link #isOSGiCompatible() <em>OS Gi Compatible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOSGiCompatible()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OS_GI_COMPATIBLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOSGiCompatible() <em>OS Gi Compatible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOSGiCompatible()
	 * @generated
	 * @ordered
	 */
	protected boolean oSGiCompatible = OS_GI_COMPATIBLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GenmodelPackage.Literals.GEN_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCopyrightText() {
		return copyrightText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCopyrightText(String newCopyrightText) {
		String oldCopyrightText = copyrightText;
		copyrightText = newCopyrightText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__COPYRIGHT_TEXT, oldCopyrightText, copyrightText));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getModelDirectory() {
		return modelDirectory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelDirectory(String newModelDirectory) {
		String oldModelDirectory = modelDirectory;
		modelDirectory = newModelDirectory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__MODEL_DIRECTORY, oldModelDirectory, modelDirectory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCreationCommands() {
		return creationCommands;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreationCommands(boolean newCreationCommands) {
		boolean oldCreationCommands = creationCommands;
		creationCommands = newCreationCommands;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__CREATION_COMMANDS, oldCreationCommands, creationCommands));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCreationIcons() {
		return creationIcons;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreationIcons(boolean newCreationIcons) {
		boolean oldCreationIcons = creationIcons;
		creationIcons = newCreationIcons;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__CREATION_ICONS, oldCreationIcons, creationIcons));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCreationSubmenus() {
		return creationSubmenus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreationSubmenus(boolean newCreationSubmenus) {
		boolean oldCreationSubmenus = creationSubmenus;
		creationSubmenus = newCreationSubmenus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__CREATION_SUBMENUS, oldCreationSubmenus, creationSubmenus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEditDirectory() {
		return editDirectory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEditDirectory(String newEditDirectory) {
		String oldEditDirectory = editDirectory;
		editDirectory = newEditDirectory;
		boolean oldEditDirectoryESet = editDirectoryESet;
		editDirectoryESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__EDIT_DIRECTORY, oldEditDirectory, editDirectory, !oldEditDirectoryESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEditDirectory() {
		String oldEditDirectory = editDirectory;
		boolean oldEditDirectoryESet = editDirectoryESet;
		editDirectory = EDIT_DIRECTORY_EDEFAULT;
		editDirectoryESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, GenmodelPackage.GEN_MODEL__EDIT_DIRECTORY, oldEditDirectory, EDIT_DIRECTORY_EDEFAULT, oldEditDirectoryESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEditDirectory() {
		return editDirectoryESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEditorDirectory() {
		return editorDirectory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEditorDirectory(String newEditorDirectory) {
		String oldEditorDirectory = editorDirectory;
		editorDirectory = newEditorDirectory;
		boolean oldEditorDirectoryESet = editorDirectoryESet;
		editorDirectoryESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__EDITOR_DIRECTORY, oldEditorDirectory, editorDirectory, !oldEditorDirectoryESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEditorDirectory() {
		String oldEditorDirectory = editorDirectory;
		boolean oldEditorDirectoryESet = editorDirectoryESet;
		editorDirectory = EDITOR_DIRECTORY_EDEFAULT;
		editorDirectoryESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, GenmodelPackage.GEN_MODEL__EDITOR_DIRECTORY, oldEditorDirectory, EDITOR_DIRECTORY_EDEFAULT, oldEditorDirectoryESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEditorDirectory() {
		return editorDirectoryESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getModelPluginID() {
		return modelPluginID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelPluginID(String newModelPluginID) {
		String oldModelPluginID = modelPluginID;
		modelPluginID = newModelPluginID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__MODEL_PLUGIN_ID, oldModelPluginID, modelPluginID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTemplateDirectory() {
		return templateDirectory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemplateDirectory(String newTemplateDirectory) {
		String oldTemplateDirectory = templateDirectory;
		templateDirectory = newTemplateDirectory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__TEMPLATE_DIRECTORY, oldTemplateDirectory, templateDirectory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRuntimeJar() {
		return runtimeJar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRuntimeJar(boolean newRuntimeJar) {
		boolean oldRuntimeJar = runtimeJar;
		runtimeJar = newRuntimeJar;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__RUNTIME_JAR, oldRuntimeJar, runtimeJar));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getForeignModel() {
		if (foreignModel == null) {
			foreignModel = new EDataTypeUniqueEList<String>(String.class, this, GenmodelPackage.GEN_MODEL__FOREIGN_MODEL);
		}
		return foreignModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDynamicTemplates() {
		return dynamicTemplates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDynamicTemplates(boolean newDynamicTemplates) {
		boolean oldDynamicTemplates = dynamicTemplates;
		dynamicTemplates = newDynamicTemplates;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__DYNAMIC_TEMPLATES, oldDynamicTemplates, dynamicTemplates));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRedirection() {
		return redirection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRedirection(String newRedirection) {
		String oldRedirection = redirection;
		redirection = newRedirection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__REDIRECTION, oldRedirection, redirection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isForceOverwrite() {
		return forceOverwrite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setForceOverwrite(boolean newForceOverwrite) {
		boolean oldForceOverwrite = forceOverwrite;
		forceOverwrite = newForceOverwrite;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__FORCE_OVERWRITE, oldForceOverwrite, forceOverwrite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNonExternalizedStringTag() {
		return nonExternalizedStringTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNonExternalizedStringTag(String newNonExternalizedStringTag) {
		String oldNonExternalizedStringTag = nonExternalizedStringTag;
		nonExternalizedStringTag = newNonExternalizedStringTag;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__NON_EXTERNALIZED_STRING_TAG, oldNonExternalizedStringTag, nonExternalizedStringTag));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getModelName() {
		return modelName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelName(String newModelName) {
		String oldModelName = modelName;
		modelName = newModelName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__MODEL_NAME, oldModelName, modelName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getModelPluginClass() {
		return modelPluginClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelPluginClass(String newModelPluginClass) {
		String oldModelPluginClass = modelPluginClass;
		modelPluginClass = newModelPluginClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__MODEL_PLUGIN_CLASS, oldModelPluginClass, modelPluginClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEditPluginClass() {
		return editPluginClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEditPluginClass(String newEditPluginClass) {
		String oldEditPluginClass = editPluginClass;
		editPluginClass = newEditPluginClass;
		boolean oldEditPluginClassESet = editPluginClassESet;
		editPluginClassESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__EDIT_PLUGIN_CLASS, oldEditPluginClass, editPluginClass, !oldEditPluginClassESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEditPluginClass() {
		String oldEditPluginClass = editPluginClass;
		boolean oldEditPluginClassESet = editPluginClassESet;
		editPluginClass = EDIT_PLUGIN_CLASS_EDEFAULT;
		editPluginClassESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, GenmodelPackage.GEN_MODEL__EDIT_PLUGIN_CLASS, oldEditPluginClass, EDIT_PLUGIN_CLASS_EDEFAULT, oldEditPluginClassESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEditPluginClass() {
		return editPluginClassESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEditorPluginClass() {
		return editorPluginClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEditorPluginClass(String newEditorPluginClass) {
		String oldEditorPluginClass = editorPluginClass;
		editorPluginClass = newEditorPluginClass;
		boolean oldEditorPluginClassESet = editorPluginClassESet;
		editorPluginClassESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__EDITOR_PLUGIN_CLASS, oldEditorPluginClass, editorPluginClass, !oldEditorPluginClassESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEditorPluginClass() {
		String oldEditorPluginClass = editorPluginClass;
		boolean oldEditorPluginClassESet = editorPluginClassESet;
		editorPluginClass = EDITOR_PLUGIN_CLASS_EDEFAULT;
		editorPluginClassESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, GenmodelPackage.GEN_MODEL__EDITOR_PLUGIN_CLASS, oldEditorPluginClass, EDITOR_PLUGIN_CLASS_EDEFAULT, oldEditorPluginClassESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEditorPluginClass() {
		return editorPluginClassESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUpdateClasspath() {
		return updateClasspath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpdateClasspath(boolean newUpdateClasspath) {
		boolean oldUpdateClasspath = updateClasspath;
		updateClasspath = newUpdateClasspath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__UPDATE_CLASSPATH, oldUpdateClasspath, updateClasspath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isGenerateSchema() {
		return generateSchema;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenerateSchema(boolean newGenerateSchema) {
		boolean oldGenerateSchema = generateSchema;
		generateSchema = newGenerateSchema;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__GENERATE_SCHEMA, oldGenerateSchema, generateSchema));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNonNLSMarkers() {
		return nonNLSMarkers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNonNLSMarkers(boolean newNonNLSMarkers) {
		boolean oldNonNLSMarkers = nonNLSMarkers;
		nonNLSMarkers = newNonNLSMarkers;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__NON_NLS_MARKERS, oldNonNLSMarkers, nonNLSMarkers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getStaticPackages() {
		if (staticPackages == null) {
			staticPackages = new EDataTypeUniqueEList<String>(String.class, this, GenmodelPackage.GEN_MODEL__STATIC_PACKAGES);
		}
		return staticPackages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getModelPluginVariables() {
		if (modelPluginVariables == null) {
			modelPluginVariables = new EDataTypeUniqueEList<String>(String.class, this, GenmodelPackage.GEN_MODEL__MODEL_PLUGIN_VARIABLES);
		}
		return modelPluginVariables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRootExtendsInterface() {
		return rootExtendsInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRootExtendsInterface(String newRootExtendsInterface) {
		String oldRootExtendsInterface = rootExtendsInterface;
		rootExtendsInterface = newRootExtendsInterface;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__ROOT_EXTENDS_INTERFACE, oldRootExtendsInterface, rootExtendsInterface));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRootExtendsClass() {
		return rootExtendsClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRootExtendsClass(String newRootExtendsClass) {
		String oldRootExtendsClass = rootExtendsClass;
		rootExtendsClass = newRootExtendsClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__ROOT_EXTENDS_CLASS, oldRootExtendsClass, rootExtendsClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRootImplementsInterface() {
		return rootImplementsInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRootImplementsInterface(String newRootImplementsInterface) {
		String oldRootImplementsInterface = rootImplementsInterface;
		rootImplementsInterface = newRootImplementsInterface;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__ROOT_IMPLEMENTS_INTERFACE, oldRootImplementsInterface, rootImplementsInterface));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSuppressEMFTypes() {
		return suppressEMFTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuppressEMFTypes(boolean newSuppressEMFTypes) {
		boolean oldSuppressEMFTypes = suppressEMFTypes;
		suppressEMFTypes = newSuppressEMFTypes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__SUPPRESS_EMF_TYPES, oldSuppressEMFTypes, suppressEMFTypes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSuppressEMFMetaData() {
		return suppressEMFMetaData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuppressEMFMetaData(boolean newSuppressEMFMetaData) {
		boolean oldSuppressEMFMetaData = suppressEMFMetaData;
		suppressEMFMetaData = newSuppressEMFMetaData;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__SUPPRESS_EMF_META_DATA, oldSuppressEMFMetaData, suppressEMFMetaData));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSuppressEMFModelTags() {
		return suppressEMFModelTags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuppressEMFModelTags(boolean newSuppressEMFModelTags) {
		boolean oldSuppressEMFModelTags = suppressEMFModelTags;
		suppressEMFModelTags = newSuppressEMFModelTags;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__SUPPRESS_EMF_MODEL_TAGS, oldSuppressEMFModelTags, suppressEMFModelTags));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSuppressInterfaces() {
		return suppressInterfaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuppressInterfaces(boolean newSuppressInterfaces) {
		boolean oldSuppressInterfaces = suppressInterfaces;
		suppressInterfaces = newSuppressInterfaces;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__SUPPRESS_INTERFACES, oldSuppressInterfaces, suppressInterfaces));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFeatureMapWrapperInterface() {
		return featureMapWrapperInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureMapWrapperInterface(String newFeatureMapWrapperInterface) {
		String oldFeatureMapWrapperInterface = featureMapWrapperInterface;
		featureMapWrapperInterface = newFeatureMapWrapperInterface;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__FEATURE_MAP_WRAPPER_INTERFACE, oldFeatureMapWrapperInterface, featureMapWrapperInterface));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFeatureMapWrapperInternalInterface() {
		return featureMapWrapperInternalInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureMapWrapperInternalInterface(String newFeatureMapWrapperInternalInterface) {
		String oldFeatureMapWrapperInternalInterface = featureMapWrapperInternalInterface;
		featureMapWrapperInternalInterface = newFeatureMapWrapperInternalInterface;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__FEATURE_MAP_WRAPPER_INTERNAL_INTERFACE, oldFeatureMapWrapperInternalInterface, featureMapWrapperInternalInterface));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFeatureMapWrapperClass() {
		return featureMapWrapperClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureMapWrapperClass(String newFeatureMapWrapperClass) {
		String oldFeatureMapWrapperClass = featureMapWrapperClass;
		featureMapWrapperClass = newFeatureMapWrapperClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__FEATURE_MAP_WRAPPER_CLASS, oldFeatureMapWrapperClass, featureMapWrapperClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRuntimeCompatibility() {
		return runtimeCompatibility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRuntimeCompatibility(boolean newRuntimeCompatibility) {
		boolean oldRuntimeCompatibility = runtimeCompatibility;
		runtimeCompatibility = newRuntimeCompatibility;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__RUNTIME_COMPATIBILITY, oldRuntimeCompatibility, runtimeCompatibility));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRichClientPlatform() {
		// TODO: implement this method to return the 'Rich Client Platform' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRichClientPlatform(boolean newRichClientPlatform) {
		// TODO: implement this method to set the 'Rich Client Platform' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReflectiveDelegation() {
		// TODO: implement this method to return the 'Reflective Delegation' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReflectiveDelegation(boolean newReflectiveDelegation) {
		// TODO: implement this method to set the 'Reflective Delegation' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCodeFormatting() {
		return codeFormatting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCodeFormatting(boolean newCodeFormatting) {
		boolean oldCodeFormatting = codeFormatting;
		codeFormatting = newCodeFormatting;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__CODE_FORMATTING, oldCodeFormatting, codeFormatting));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCommentFormatting() {
		return commentFormatting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCommentFormatting(boolean newCommentFormatting) {
		boolean oldCommentFormatting = commentFormatting;
		commentFormatting = newCommentFormatting;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__COMMENT_FORMATTING, oldCommentFormatting, commentFormatting));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTestsDirectory() {
		return testsDirectory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTestsDirectory(String newTestsDirectory) {
		String oldTestsDirectory = testsDirectory;
		testsDirectory = newTestsDirectory;
		boolean oldTestsDirectoryESet = testsDirectoryESet;
		testsDirectoryESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__TESTS_DIRECTORY, oldTestsDirectory, testsDirectory, !oldTestsDirectoryESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTestsDirectory() {
		String oldTestsDirectory = testsDirectory;
		boolean oldTestsDirectoryESet = testsDirectoryESet;
		testsDirectory = TESTS_DIRECTORY_EDEFAULT;
		testsDirectoryESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, GenmodelPackage.GEN_MODEL__TESTS_DIRECTORY, oldTestsDirectory, TESTS_DIRECTORY_EDEFAULT, oldTestsDirectoryESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTestsDirectory() {
		return testsDirectoryESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTestSuiteClass() {
		return testSuiteClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTestSuiteClass(String newTestSuiteClass) {
		String oldTestSuiteClass = testSuiteClass;
		testSuiteClass = newTestSuiteClass;
		boolean oldTestSuiteClassESet = testSuiteClassESet;
		testSuiteClassESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__TEST_SUITE_CLASS, oldTestSuiteClass, testSuiteClass, !oldTestSuiteClassESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTestSuiteClass() {
		String oldTestSuiteClass = testSuiteClass;
		boolean oldTestSuiteClassESet = testSuiteClassESet;
		testSuiteClass = TEST_SUITE_CLASS_EDEFAULT;
		testSuiteClassESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, GenmodelPackage.GEN_MODEL__TEST_SUITE_CLASS, oldTestSuiteClass, TEST_SUITE_CLASS_EDEFAULT, oldTestSuiteClassESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTestSuiteClass() {
		return testSuiteClassESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBooleanFlagsField() {
		return booleanFlagsField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBooleanFlagsField(String newBooleanFlagsField) {
		String oldBooleanFlagsField = booleanFlagsField;
		booleanFlagsField = newBooleanFlagsField;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__BOOLEAN_FLAGS_FIELD, oldBooleanFlagsField, booleanFlagsField));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBooleanFlagsReservedBits() {
		return booleanFlagsReservedBits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBooleanFlagsReservedBits(int newBooleanFlagsReservedBits) {
		int oldBooleanFlagsReservedBits = booleanFlagsReservedBits;
		booleanFlagsReservedBits = newBooleanFlagsReservedBits;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__BOOLEAN_FLAGS_RESERVED_BITS, oldBooleanFlagsReservedBits, booleanFlagsReservedBits));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getImporterID() {
		return importerID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImporterID(String newImporterID) {
		String oldImporterID = importerID;
		importerID = newImporterID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__IMPORTER_ID, oldImporterID, importerID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBundleManifest() {
		return bundleManifest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBundleManifest(boolean newBundleManifest) {
		boolean oldBundleManifest = bundleManifest;
		bundleManifest = newBundleManifest;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__BUNDLE_MANIFEST, oldBundleManifest, bundleManifest));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenDelegationKind getFeatureDelegation() {
		return featureDelegation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureDelegation(GenDelegationKind newFeatureDelegation) {
		GenDelegationKind oldFeatureDelegation = featureDelegation;
		featureDelegation = newFeatureDelegation == null ? FEATURE_DELEGATION_EDEFAULT : newFeatureDelegation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__FEATURE_DELEGATION, oldFeatureDelegation, featureDelegation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isContainmentProxies() {
		return containmentProxies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainmentProxies(boolean newContainmentProxies) {
		boolean oldContainmentProxies = containmentProxies;
		containmentProxies = newContainmentProxies;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__CONTAINMENT_PROXIES, oldContainmentProxies, containmentProxies));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMinimalReflectiveMethods() {
		return minimalReflectiveMethods;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimalReflectiveMethods(boolean newMinimalReflectiveMethods) {
		boolean oldMinimalReflectiveMethods = minimalReflectiveMethods;
		minimalReflectiveMethods = newMinimalReflectiveMethods;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__MINIMAL_REFLECTIVE_METHODS, oldMinimalReflectiveMethods, minimalReflectiveMethods));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSuppressContainment() {
		return suppressContainment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuppressContainment(boolean newSuppressContainment) {
		boolean oldSuppressContainment = suppressContainment;
		suppressContainment = newSuppressContainment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__SUPPRESS_CONTAINMENT, oldSuppressContainment, suppressContainment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSuppressNotification() {
		return suppressNotification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuppressNotification(boolean newSuppressNotification) {
		boolean oldSuppressNotification = suppressNotification;
		suppressNotification = newSuppressNotification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__SUPPRESS_NOTIFICATION, oldSuppressNotification, suppressNotification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isArrayAccessors() {
		return arrayAccessors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArrayAccessors(boolean newArrayAccessors) {
		boolean oldArrayAccessors = arrayAccessors;
		arrayAccessors = newArrayAccessors;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__ARRAY_ACCESSORS, oldArrayAccessors, arrayAccessors));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSuppressUnsettable() {
		return suppressUnsettable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuppressUnsettable(boolean newSuppressUnsettable) {
		boolean oldSuppressUnsettable = suppressUnsettable;
		suppressUnsettable = newSuppressUnsettable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__SUPPRESS_UNSETTABLE, oldSuppressUnsettable, suppressUnsettable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFacadeHelperClass() {
		return facadeHelperClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFacadeHelperClass(String newFacadeHelperClass) {
		String oldFacadeHelperClass = facadeHelperClass;
		facadeHelperClass = newFacadeHelperClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__FACADE_HELPER_CLASS, oldFacadeHelperClass, facadeHelperClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenJDKLevel getComplianceLevel() {
		return complianceLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComplianceLevel(GenJDKLevel newComplianceLevel) {
		GenJDKLevel oldComplianceLevel = complianceLevel;
		complianceLevel = newComplianceLevel == null ? COMPLIANCE_LEVEL_EDEFAULT : newComplianceLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__COMPLIANCE_LEVEL, oldComplianceLevel, complianceLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSuppressGenModelAnnotations() {
		return suppressGenModelAnnotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuppressGenModelAnnotations(boolean newSuppressGenModelAnnotations) {
		boolean oldSuppressGenModelAnnotations = suppressGenModelAnnotations;
		suppressGenModelAnnotations = newSuppressGenModelAnnotations;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__SUPPRESS_GEN_MODEL_ANNOTATIONS, oldSuppressGenModelAnnotations, suppressGenModelAnnotations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCopyrightFields() {
		return copyrightFields;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCopyrightFields(boolean newCopyrightFields) {
		boolean oldCopyrightFields = copyrightFields;
		copyrightFields = newCopyrightFields;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__COPYRIGHT_FIELDS, oldCopyrightFields, copyrightFields));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBinaryCompatibleReflectiveMethods() {
		return binaryCompatibleReflectiveMethods;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBinaryCompatibleReflectiveMethods(boolean newBinaryCompatibleReflectiveMethods) {
		boolean oldBinaryCompatibleReflectiveMethods = binaryCompatibleReflectiveMethods;
		binaryCompatibleReflectiveMethods = newBinaryCompatibleReflectiveMethods;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__BINARY_COMPATIBLE_REFLECTIVE_METHODS, oldBinaryCompatibleReflectiveMethods, binaryCompatibleReflectiveMethods));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPublicConstructors() {
		return publicConstructors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPublicConstructors(boolean newPublicConstructors) {
		boolean oldPublicConstructors = publicConstructors;
		publicConstructors = newPublicConstructors;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__PUBLIC_CONSTRUCTORS, oldPublicConstructors, publicConstructors));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getTemplatePluginVariables() {
		if (templatePluginVariables == null) {
			templatePluginVariables = new EDataTypeUniqueEList<String>(String.class, this, GenmodelPackage.GEN_MODEL__TEMPLATE_PLUGIN_VARIABLES);
		}
		return templatePluginVariables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProviderRootExtendsClass() {
		return providerRootExtendsClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProviderRootExtendsClass(String newProviderRootExtendsClass) {
		String oldProviderRootExtendsClass = providerRootExtendsClass;
		providerRootExtendsClass = newProviderRootExtendsClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__PROVIDER_ROOT_EXTENDS_CLASS, oldProviderRootExtendsClass, providerRootExtendsClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEditPluginID() {
		return editPluginID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEditPluginID(String newEditPluginID) {
		String oldEditPluginID = editPluginID;
		editPluginID = newEditPluginID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__EDIT_PLUGIN_ID, oldEditPluginID, editPluginID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getEditPluginVariables() {
		if (editPluginVariables == null) {
			editPluginVariables = new EDataTypeUniqueEList<String>(String.class, this, GenmodelPackage.GEN_MODEL__EDIT_PLUGIN_VARIABLES);
		}
		return editPluginVariables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEditorPluginID() {
		return editorPluginID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEditorPluginID(String newEditorPluginID) {
		String oldEditorPluginID = editorPluginID;
		editorPluginID = newEditorPluginID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__EDITOR_PLUGIN_ID, oldEditorPluginID, editorPluginID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getEditorPluginVariables() {
		if (editorPluginVariables == null) {
			editorPluginVariables = new EDataTypeUniqueEList<String>(String.class, this, GenmodelPackage.GEN_MODEL__EDITOR_PLUGIN_VARIABLES);
		}
		return editorPluginVariables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTestsPluginID() {
		return testsPluginID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTestsPluginID(String newTestsPluginID) {
		String oldTestsPluginID = testsPluginID;
		testsPluginID = newTestsPluginID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__TESTS_PLUGIN_ID, oldTestsPluginID, testsPluginID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getTestsPluginVariables() {
		if (testsPluginVariables == null) {
			testsPluginVariables = new EDataTypeUniqueEList<String>(String.class, this, GenmodelPackage.GEN_MODEL__TESTS_PLUGIN_VARIABLES);
		}
		return testsPluginVariables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOptimizedHasChildren() {
		return optimizedHasChildren;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOptimizedHasChildren(boolean newOptimizedHasChildren) {
		boolean oldOptimizedHasChildren = optimizedHasChildren;
		optimizedHasChildren = newOptimizedHasChildren;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__OPTIMIZED_HAS_CHILDREN, oldOptimizedHasChildren, optimizedHasChildren));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTableProviders() {
		return tableProviders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTableProviders(boolean newTableProviders) {
		boolean oldTableProviders = tableProviders;
		tableProviders = newTableProviders;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__TABLE_PROVIDERS, oldTableProviders, tableProviders));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isColorProviders() {
		return colorProviders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColorProviders(boolean newColorProviders) {
		boolean oldColorProviders = colorProviders;
		colorProviders = newColorProviders;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__COLOR_PROVIDERS, oldColorProviders, colorProviders));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFontProviders() {
		return fontProviders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFontProviders(boolean newFontProviders) {
		boolean oldFontProviders = fontProviders;
		fontProviders = newFontProviders;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__FONT_PROVIDERS, oldFontProviders, fontProviders));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenRuntimeVersion getRuntimeVersion() {
		return runtimeVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRuntimeVersion(GenRuntimeVersion newRuntimeVersion) {
		GenRuntimeVersion oldRuntimeVersion = runtimeVersion;
		runtimeVersion = newRuntimeVersion == null ? RUNTIME_VERSION_EDEFAULT : newRuntimeVersion;
		boolean oldRuntimeVersionESet = runtimeVersionESet;
		runtimeVersionESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__RUNTIME_VERSION, oldRuntimeVersion, runtimeVersion, !oldRuntimeVersionESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRuntimeVersion() {
		GenRuntimeVersion oldRuntimeVersion = runtimeVersion;
		boolean oldRuntimeVersionESet = runtimeVersionESet;
		runtimeVersion = RUNTIME_VERSION_EDEFAULT;
		runtimeVersionESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, GenmodelPackage.GEN_MODEL__RUNTIME_VERSION, oldRuntimeVersion, RUNTIME_VERSION_EDEFAULT, oldRuntimeVersionESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRuntimeVersion() {
		return runtimeVersionESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLanguage(String newLanguage) {
		String oldLanguage = language;
		language = newLanguage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__LANGUAGE, oldLanguage, language));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPackedEnums() {
		return packedEnums;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPackedEnums(boolean newPackedEnums) {
		boolean oldPackedEnums = packedEnums;
		packedEnums = newPackedEnums;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__PACKED_ENUMS, oldPackedEnums, packedEnums));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GenPackage> getGenPackages() {
		if (genPackages == null) {
			genPackages = new EObjectContainmentWithInverseEList<GenPackage>(GenPackage.class, this, GenmodelPackage.GEN_MODEL__GEN_PACKAGES, GenmodelPackage.GEN_PACKAGE__GEN_MODEL);
		}
		return genPackages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GenPackage> getUsedGenPackages() {
		if (usedGenPackages == null) {
			usedGenPackages = new EObjectResolvingEList<GenPackage>(GenPackage.class, this, GenmodelPackage.GEN_MODEL__USED_GEN_PACKAGES);
		}
		return usedGenPackages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInterfaceNamePattern() {
		return interfaceNamePattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterfaceNamePattern(String newInterfaceNamePattern) {
		String oldInterfaceNamePattern = interfaceNamePattern;
		interfaceNamePattern = newInterfaceNamePattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__INTERFACE_NAME_PATTERN, oldInterfaceNamePattern, interfaceNamePattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClassNamePattern() {
		return classNamePattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassNamePattern(String newClassNamePattern) {
		String oldClassNamePattern = classNamePattern;
		classNamePattern = newClassNamePattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__CLASS_NAME_PATTERN, oldClassNamePattern, classNamePattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOperationReflection() {
		return operationReflection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperationReflection(boolean newOperationReflection) {
		boolean oldOperationReflection = operationReflection;
		operationReflection = newOperationReflection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__OPERATION_REFLECTION, oldOperationReflection, operationReflection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRichAjaxPlatform() {
		// TODO: implement this method to return the 'Rich Ajax Platform' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRichAjaxPlatform(boolean newRichAjaxPlatform) {
		// TODO: implement this method to set the 'Rich Ajax Platform' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenRuntimePlatform getRuntimePlatform() {
		return runtimePlatform;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRuntimePlatform(GenRuntimePlatform newRuntimePlatform) {
		GenRuntimePlatform oldRuntimePlatform = runtimePlatform;
		runtimePlatform = newRuntimePlatform == null ? RUNTIME_PLATFORM_EDEFAULT : newRuntimePlatform;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__RUNTIME_PLATFORM, oldRuntimePlatform, runtimePlatform));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isImportOrganizing() {
		return importOrganizing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImportOrganizing(boolean newImportOrganizing) {
		boolean oldImportOrganizing = importOrganizing;
		importOrganizing = newImportOrganizing;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__IMPORT_ORGANIZING, oldImportOrganizing, importOrganizing));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPluginKey() {
		return pluginKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPluginKey(String newPluginKey) {
		String oldPluginKey = pluginKey;
		pluginKey = newPluginKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__PLUGIN_KEY, oldPluginKey, pluginKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenDecoration getDecoration() {
		return decoration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDecoration(GenDecoration newDecoration) {
		GenDecoration oldDecoration = decoration;
		decoration = newDecoration == null ? DECORATION_EDEFAULT : newDecoration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__DECORATION, oldDecoration, decoration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStyleProviders() {
		return styleProviders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStyleProviders(boolean newStyleProviders) {
		boolean oldStyleProviders = styleProviders;
		styleProviders = newStyleProviders;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__STYLE_PROVIDERS, oldStyleProviders, styleProviders));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCleanup() {
		return cleanup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCleanup(boolean newCleanup) {
		boolean oldCleanup = cleanup;
		cleanup = newCleanup;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__CLEANUP, oldCleanup, cleanup));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOSGiCompatible() {
		return oSGiCompatible;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOSGiCompatible(boolean newOSGiCompatible) {
		boolean oldOSGiCompatible = oSGiCompatible;
		oSGiCompatible = newOSGiCompatible;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_MODEL__OS_GI_COMPATIBLE, oldOSGiCompatible, oSGiCompatible));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GenmodelPackage.GEN_MODEL__GEN_PACKAGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getGenPackages()).basicAdd(otherEnd, msgs);
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
			case GenmodelPackage.GEN_MODEL__GEN_PACKAGES:
				return ((InternalEList<?>)getGenPackages()).basicRemove(otherEnd, msgs);
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
			case GenmodelPackage.GEN_MODEL__COPYRIGHT_TEXT:
				return getCopyrightText();
			case GenmodelPackage.GEN_MODEL__MODEL_DIRECTORY:
				return getModelDirectory();
			case GenmodelPackage.GEN_MODEL__CREATION_COMMANDS:
				return isCreationCommands();
			case GenmodelPackage.GEN_MODEL__CREATION_ICONS:
				return isCreationIcons();
			case GenmodelPackage.GEN_MODEL__CREATION_SUBMENUS:
				return isCreationSubmenus();
			case GenmodelPackage.GEN_MODEL__EDIT_DIRECTORY:
				return getEditDirectory();
			case GenmodelPackage.GEN_MODEL__EDITOR_DIRECTORY:
				return getEditorDirectory();
			case GenmodelPackage.GEN_MODEL__MODEL_PLUGIN_ID:
				return getModelPluginID();
			case GenmodelPackage.GEN_MODEL__TEMPLATE_DIRECTORY:
				return getTemplateDirectory();
			case GenmodelPackage.GEN_MODEL__RUNTIME_JAR:
				return isRuntimeJar();
			case GenmodelPackage.GEN_MODEL__FOREIGN_MODEL:
				return getForeignModel();
			case GenmodelPackage.GEN_MODEL__DYNAMIC_TEMPLATES:
				return isDynamicTemplates();
			case GenmodelPackage.GEN_MODEL__REDIRECTION:
				return getRedirection();
			case GenmodelPackage.GEN_MODEL__FORCE_OVERWRITE:
				return isForceOverwrite();
			case GenmodelPackage.GEN_MODEL__NON_EXTERNALIZED_STRING_TAG:
				return getNonExternalizedStringTag();
			case GenmodelPackage.GEN_MODEL__MODEL_NAME:
				return getModelName();
			case GenmodelPackage.GEN_MODEL__MODEL_PLUGIN_CLASS:
				return getModelPluginClass();
			case GenmodelPackage.GEN_MODEL__EDIT_PLUGIN_CLASS:
				return getEditPluginClass();
			case GenmodelPackage.GEN_MODEL__EDITOR_PLUGIN_CLASS:
				return getEditorPluginClass();
			case GenmodelPackage.GEN_MODEL__UPDATE_CLASSPATH:
				return isUpdateClasspath();
			case GenmodelPackage.GEN_MODEL__GENERATE_SCHEMA:
				return isGenerateSchema();
			case GenmodelPackage.GEN_MODEL__NON_NLS_MARKERS:
				return isNonNLSMarkers();
			case GenmodelPackage.GEN_MODEL__STATIC_PACKAGES:
				return getStaticPackages();
			case GenmodelPackage.GEN_MODEL__MODEL_PLUGIN_VARIABLES:
				return getModelPluginVariables();
			case GenmodelPackage.GEN_MODEL__ROOT_EXTENDS_INTERFACE:
				return getRootExtendsInterface();
			case GenmodelPackage.GEN_MODEL__ROOT_EXTENDS_CLASS:
				return getRootExtendsClass();
			case GenmodelPackage.GEN_MODEL__ROOT_IMPLEMENTS_INTERFACE:
				return getRootImplementsInterface();
			case GenmodelPackage.GEN_MODEL__SUPPRESS_EMF_TYPES:
				return isSuppressEMFTypes();
			case GenmodelPackage.GEN_MODEL__SUPPRESS_EMF_META_DATA:
				return isSuppressEMFMetaData();
			case GenmodelPackage.GEN_MODEL__SUPPRESS_EMF_MODEL_TAGS:
				return isSuppressEMFModelTags();
			case GenmodelPackage.GEN_MODEL__SUPPRESS_INTERFACES:
				return isSuppressInterfaces();
			case GenmodelPackage.GEN_MODEL__FEATURE_MAP_WRAPPER_INTERFACE:
				return getFeatureMapWrapperInterface();
			case GenmodelPackage.GEN_MODEL__FEATURE_MAP_WRAPPER_INTERNAL_INTERFACE:
				return getFeatureMapWrapperInternalInterface();
			case GenmodelPackage.GEN_MODEL__FEATURE_MAP_WRAPPER_CLASS:
				return getFeatureMapWrapperClass();
			case GenmodelPackage.GEN_MODEL__RUNTIME_COMPATIBILITY:
				return isRuntimeCompatibility();
			case GenmodelPackage.GEN_MODEL__RICH_CLIENT_PLATFORM:
				return isRichClientPlatform();
			case GenmodelPackage.GEN_MODEL__REFLECTIVE_DELEGATION:
				return isReflectiveDelegation();
			case GenmodelPackage.GEN_MODEL__CODE_FORMATTING:
				return isCodeFormatting();
			case GenmodelPackage.GEN_MODEL__COMMENT_FORMATTING:
				return isCommentFormatting();
			case GenmodelPackage.GEN_MODEL__TESTS_DIRECTORY:
				return getTestsDirectory();
			case GenmodelPackage.GEN_MODEL__TEST_SUITE_CLASS:
				return getTestSuiteClass();
			case GenmodelPackage.GEN_MODEL__BOOLEAN_FLAGS_FIELD:
				return getBooleanFlagsField();
			case GenmodelPackage.GEN_MODEL__BOOLEAN_FLAGS_RESERVED_BITS:
				return getBooleanFlagsReservedBits();
			case GenmodelPackage.GEN_MODEL__IMPORTER_ID:
				return getImporterID();
			case GenmodelPackage.GEN_MODEL__BUNDLE_MANIFEST:
				return isBundleManifest();
			case GenmodelPackage.GEN_MODEL__FEATURE_DELEGATION:
				return getFeatureDelegation();
			case GenmodelPackage.GEN_MODEL__CONTAINMENT_PROXIES:
				return isContainmentProxies();
			case GenmodelPackage.GEN_MODEL__MINIMAL_REFLECTIVE_METHODS:
				return isMinimalReflectiveMethods();
			case GenmodelPackage.GEN_MODEL__SUPPRESS_CONTAINMENT:
				return isSuppressContainment();
			case GenmodelPackage.GEN_MODEL__SUPPRESS_NOTIFICATION:
				return isSuppressNotification();
			case GenmodelPackage.GEN_MODEL__ARRAY_ACCESSORS:
				return isArrayAccessors();
			case GenmodelPackage.GEN_MODEL__SUPPRESS_UNSETTABLE:
				return isSuppressUnsettable();
			case GenmodelPackage.GEN_MODEL__FACADE_HELPER_CLASS:
				return getFacadeHelperClass();
			case GenmodelPackage.GEN_MODEL__COMPLIANCE_LEVEL:
				return getComplianceLevel();
			case GenmodelPackage.GEN_MODEL__SUPPRESS_GEN_MODEL_ANNOTATIONS:
				return isSuppressGenModelAnnotations();
			case GenmodelPackage.GEN_MODEL__COPYRIGHT_FIELDS:
				return isCopyrightFields();
			case GenmodelPackage.GEN_MODEL__BINARY_COMPATIBLE_REFLECTIVE_METHODS:
				return isBinaryCompatibleReflectiveMethods();
			case GenmodelPackage.GEN_MODEL__PUBLIC_CONSTRUCTORS:
				return isPublicConstructors();
			case GenmodelPackage.GEN_MODEL__TEMPLATE_PLUGIN_VARIABLES:
				return getTemplatePluginVariables();
			case GenmodelPackage.GEN_MODEL__PROVIDER_ROOT_EXTENDS_CLASS:
				return getProviderRootExtendsClass();
			case GenmodelPackage.GEN_MODEL__EDIT_PLUGIN_ID:
				return getEditPluginID();
			case GenmodelPackage.GEN_MODEL__EDIT_PLUGIN_VARIABLES:
				return getEditPluginVariables();
			case GenmodelPackage.GEN_MODEL__EDITOR_PLUGIN_ID:
				return getEditorPluginID();
			case GenmodelPackage.GEN_MODEL__EDITOR_PLUGIN_VARIABLES:
				return getEditorPluginVariables();
			case GenmodelPackage.GEN_MODEL__TESTS_PLUGIN_ID:
				return getTestsPluginID();
			case GenmodelPackage.GEN_MODEL__TESTS_PLUGIN_VARIABLES:
				return getTestsPluginVariables();
			case GenmodelPackage.GEN_MODEL__OPTIMIZED_HAS_CHILDREN:
				return isOptimizedHasChildren();
			case GenmodelPackage.GEN_MODEL__TABLE_PROVIDERS:
				return isTableProviders();
			case GenmodelPackage.GEN_MODEL__COLOR_PROVIDERS:
				return isColorProviders();
			case GenmodelPackage.GEN_MODEL__FONT_PROVIDERS:
				return isFontProviders();
			case GenmodelPackage.GEN_MODEL__RUNTIME_VERSION:
				return getRuntimeVersion();
			case GenmodelPackage.GEN_MODEL__LANGUAGE:
				return getLanguage();
			case GenmodelPackage.GEN_MODEL__PACKED_ENUMS:
				return isPackedEnums();
			case GenmodelPackage.GEN_MODEL__GEN_PACKAGES:
				return getGenPackages();
			case GenmodelPackage.GEN_MODEL__USED_GEN_PACKAGES:
				return getUsedGenPackages();
			case GenmodelPackage.GEN_MODEL__INTERFACE_NAME_PATTERN:
				return getInterfaceNamePattern();
			case GenmodelPackage.GEN_MODEL__CLASS_NAME_PATTERN:
				return getClassNamePattern();
			case GenmodelPackage.GEN_MODEL__OPERATION_REFLECTION:
				return isOperationReflection();
			case GenmodelPackage.GEN_MODEL__RICH_AJAX_PLATFORM:
				return isRichAjaxPlatform();
			case GenmodelPackage.GEN_MODEL__RUNTIME_PLATFORM:
				return getRuntimePlatform();
			case GenmodelPackage.GEN_MODEL__IMPORT_ORGANIZING:
				return isImportOrganizing();
			case GenmodelPackage.GEN_MODEL__PLUGIN_KEY:
				return getPluginKey();
			case GenmodelPackage.GEN_MODEL__DECORATION:
				return getDecoration();
			case GenmodelPackage.GEN_MODEL__STYLE_PROVIDERS:
				return isStyleProviders();
			case GenmodelPackage.GEN_MODEL__CLEANUP:
				return isCleanup();
			case GenmodelPackage.GEN_MODEL__OS_GI_COMPATIBLE:
				return isOSGiCompatible();
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
			case GenmodelPackage.GEN_MODEL__COPYRIGHT_TEXT:
				setCopyrightText((String)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__MODEL_DIRECTORY:
				setModelDirectory((String)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__CREATION_COMMANDS:
				setCreationCommands((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__CREATION_ICONS:
				setCreationIcons((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__CREATION_SUBMENUS:
				setCreationSubmenus((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__EDIT_DIRECTORY:
				setEditDirectory((String)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__EDITOR_DIRECTORY:
				setEditorDirectory((String)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__MODEL_PLUGIN_ID:
				setModelPluginID((String)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__TEMPLATE_DIRECTORY:
				setTemplateDirectory((String)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__RUNTIME_JAR:
				setRuntimeJar((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__FOREIGN_MODEL:
				getForeignModel().clear();
				getForeignModel().addAll((Collection<? extends String>)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__DYNAMIC_TEMPLATES:
				setDynamicTemplates((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__REDIRECTION:
				setRedirection((String)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__FORCE_OVERWRITE:
				setForceOverwrite((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__NON_EXTERNALIZED_STRING_TAG:
				setNonExternalizedStringTag((String)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__MODEL_NAME:
				setModelName((String)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__MODEL_PLUGIN_CLASS:
				setModelPluginClass((String)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__EDIT_PLUGIN_CLASS:
				setEditPluginClass((String)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__EDITOR_PLUGIN_CLASS:
				setEditorPluginClass((String)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__UPDATE_CLASSPATH:
				setUpdateClasspath((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__GENERATE_SCHEMA:
				setGenerateSchema((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__NON_NLS_MARKERS:
				setNonNLSMarkers((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__STATIC_PACKAGES:
				getStaticPackages().clear();
				getStaticPackages().addAll((Collection<? extends String>)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__MODEL_PLUGIN_VARIABLES:
				getModelPluginVariables().clear();
				getModelPluginVariables().addAll((Collection<? extends String>)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__ROOT_EXTENDS_INTERFACE:
				setRootExtendsInterface((String)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__ROOT_EXTENDS_CLASS:
				setRootExtendsClass((String)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__ROOT_IMPLEMENTS_INTERFACE:
				setRootImplementsInterface((String)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__SUPPRESS_EMF_TYPES:
				setSuppressEMFTypes((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__SUPPRESS_EMF_META_DATA:
				setSuppressEMFMetaData((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__SUPPRESS_EMF_MODEL_TAGS:
				setSuppressEMFModelTags((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__SUPPRESS_INTERFACES:
				setSuppressInterfaces((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__FEATURE_MAP_WRAPPER_INTERFACE:
				setFeatureMapWrapperInterface((String)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__FEATURE_MAP_WRAPPER_INTERNAL_INTERFACE:
				setFeatureMapWrapperInternalInterface((String)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__FEATURE_MAP_WRAPPER_CLASS:
				setFeatureMapWrapperClass((String)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__RUNTIME_COMPATIBILITY:
				setRuntimeCompatibility((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__RICH_CLIENT_PLATFORM:
				setRichClientPlatform((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__REFLECTIVE_DELEGATION:
				setReflectiveDelegation((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__CODE_FORMATTING:
				setCodeFormatting((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__COMMENT_FORMATTING:
				setCommentFormatting((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__TESTS_DIRECTORY:
				setTestsDirectory((String)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__TEST_SUITE_CLASS:
				setTestSuiteClass((String)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__BOOLEAN_FLAGS_FIELD:
				setBooleanFlagsField((String)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__BOOLEAN_FLAGS_RESERVED_BITS:
				setBooleanFlagsReservedBits((Integer)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__IMPORTER_ID:
				setImporterID((String)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__BUNDLE_MANIFEST:
				setBundleManifest((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__FEATURE_DELEGATION:
				setFeatureDelegation((GenDelegationKind)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__CONTAINMENT_PROXIES:
				setContainmentProxies((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__MINIMAL_REFLECTIVE_METHODS:
				setMinimalReflectiveMethods((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__SUPPRESS_CONTAINMENT:
				setSuppressContainment((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__SUPPRESS_NOTIFICATION:
				setSuppressNotification((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__ARRAY_ACCESSORS:
				setArrayAccessors((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__SUPPRESS_UNSETTABLE:
				setSuppressUnsettable((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__FACADE_HELPER_CLASS:
				setFacadeHelperClass((String)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__COMPLIANCE_LEVEL:
				setComplianceLevel((GenJDKLevel)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__SUPPRESS_GEN_MODEL_ANNOTATIONS:
				setSuppressGenModelAnnotations((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__COPYRIGHT_FIELDS:
				setCopyrightFields((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__BINARY_COMPATIBLE_REFLECTIVE_METHODS:
				setBinaryCompatibleReflectiveMethods((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__PUBLIC_CONSTRUCTORS:
				setPublicConstructors((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__TEMPLATE_PLUGIN_VARIABLES:
				getTemplatePluginVariables().clear();
				getTemplatePluginVariables().addAll((Collection<? extends String>)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__PROVIDER_ROOT_EXTENDS_CLASS:
				setProviderRootExtendsClass((String)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__EDIT_PLUGIN_ID:
				setEditPluginID((String)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__EDIT_PLUGIN_VARIABLES:
				getEditPluginVariables().clear();
				getEditPluginVariables().addAll((Collection<? extends String>)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__EDITOR_PLUGIN_ID:
				setEditorPluginID((String)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__EDITOR_PLUGIN_VARIABLES:
				getEditorPluginVariables().clear();
				getEditorPluginVariables().addAll((Collection<? extends String>)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__TESTS_PLUGIN_ID:
				setTestsPluginID((String)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__TESTS_PLUGIN_VARIABLES:
				getTestsPluginVariables().clear();
				getTestsPluginVariables().addAll((Collection<? extends String>)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__OPTIMIZED_HAS_CHILDREN:
				setOptimizedHasChildren((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__TABLE_PROVIDERS:
				setTableProviders((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__COLOR_PROVIDERS:
				setColorProviders((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__FONT_PROVIDERS:
				setFontProviders((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__RUNTIME_VERSION:
				setRuntimeVersion((GenRuntimeVersion)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__LANGUAGE:
				setLanguage((String)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__PACKED_ENUMS:
				setPackedEnums((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__GEN_PACKAGES:
				getGenPackages().clear();
				getGenPackages().addAll((Collection<? extends GenPackage>)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__USED_GEN_PACKAGES:
				getUsedGenPackages().clear();
				getUsedGenPackages().addAll((Collection<? extends GenPackage>)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__INTERFACE_NAME_PATTERN:
				setInterfaceNamePattern((String)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__CLASS_NAME_PATTERN:
				setClassNamePattern((String)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__OPERATION_REFLECTION:
				setOperationReflection((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__RICH_AJAX_PLATFORM:
				setRichAjaxPlatform((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__RUNTIME_PLATFORM:
				setRuntimePlatform((GenRuntimePlatform)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__IMPORT_ORGANIZING:
				setImportOrganizing((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__PLUGIN_KEY:
				setPluginKey((String)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__DECORATION:
				setDecoration((GenDecoration)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__STYLE_PROVIDERS:
				setStyleProviders((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__CLEANUP:
				setCleanup((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_MODEL__OS_GI_COMPATIBLE:
				setOSGiCompatible((Boolean)newValue);
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
			case GenmodelPackage.GEN_MODEL__COPYRIGHT_TEXT:
				setCopyrightText(COPYRIGHT_TEXT_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__MODEL_DIRECTORY:
				setModelDirectory(MODEL_DIRECTORY_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__CREATION_COMMANDS:
				setCreationCommands(CREATION_COMMANDS_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__CREATION_ICONS:
				setCreationIcons(CREATION_ICONS_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__CREATION_SUBMENUS:
				setCreationSubmenus(CREATION_SUBMENUS_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__EDIT_DIRECTORY:
				unsetEditDirectory();
				return;
			case GenmodelPackage.GEN_MODEL__EDITOR_DIRECTORY:
				unsetEditorDirectory();
				return;
			case GenmodelPackage.GEN_MODEL__MODEL_PLUGIN_ID:
				setModelPluginID(MODEL_PLUGIN_ID_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__TEMPLATE_DIRECTORY:
				setTemplateDirectory(TEMPLATE_DIRECTORY_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__RUNTIME_JAR:
				setRuntimeJar(RUNTIME_JAR_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__FOREIGN_MODEL:
				getForeignModel().clear();
				return;
			case GenmodelPackage.GEN_MODEL__DYNAMIC_TEMPLATES:
				setDynamicTemplates(DYNAMIC_TEMPLATES_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__REDIRECTION:
				setRedirection(REDIRECTION_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__FORCE_OVERWRITE:
				setForceOverwrite(FORCE_OVERWRITE_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__NON_EXTERNALIZED_STRING_TAG:
				setNonExternalizedStringTag(NON_EXTERNALIZED_STRING_TAG_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__MODEL_NAME:
				setModelName(MODEL_NAME_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__MODEL_PLUGIN_CLASS:
				setModelPluginClass(MODEL_PLUGIN_CLASS_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__EDIT_PLUGIN_CLASS:
				unsetEditPluginClass();
				return;
			case GenmodelPackage.GEN_MODEL__EDITOR_PLUGIN_CLASS:
				unsetEditorPluginClass();
				return;
			case GenmodelPackage.GEN_MODEL__UPDATE_CLASSPATH:
				setUpdateClasspath(UPDATE_CLASSPATH_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__GENERATE_SCHEMA:
				setGenerateSchema(GENERATE_SCHEMA_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__NON_NLS_MARKERS:
				setNonNLSMarkers(NON_NLS_MARKERS_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__STATIC_PACKAGES:
				getStaticPackages().clear();
				return;
			case GenmodelPackage.GEN_MODEL__MODEL_PLUGIN_VARIABLES:
				getModelPluginVariables().clear();
				return;
			case GenmodelPackage.GEN_MODEL__ROOT_EXTENDS_INTERFACE:
				setRootExtendsInterface(ROOT_EXTENDS_INTERFACE_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__ROOT_EXTENDS_CLASS:
				setRootExtendsClass(ROOT_EXTENDS_CLASS_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__ROOT_IMPLEMENTS_INTERFACE:
				setRootImplementsInterface(ROOT_IMPLEMENTS_INTERFACE_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__SUPPRESS_EMF_TYPES:
				setSuppressEMFTypes(SUPPRESS_EMF_TYPES_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__SUPPRESS_EMF_META_DATA:
				setSuppressEMFMetaData(SUPPRESS_EMF_META_DATA_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__SUPPRESS_EMF_MODEL_TAGS:
				setSuppressEMFModelTags(SUPPRESS_EMF_MODEL_TAGS_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__SUPPRESS_INTERFACES:
				setSuppressInterfaces(SUPPRESS_INTERFACES_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__FEATURE_MAP_WRAPPER_INTERFACE:
				setFeatureMapWrapperInterface(FEATURE_MAP_WRAPPER_INTERFACE_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__FEATURE_MAP_WRAPPER_INTERNAL_INTERFACE:
				setFeatureMapWrapperInternalInterface(FEATURE_MAP_WRAPPER_INTERNAL_INTERFACE_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__FEATURE_MAP_WRAPPER_CLASS:
				setFeatureMapWrapperClass(FEATURE_MAP_WRAPPER_CLASS_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__RUNTIME_COMPATIBILITY:
				setRuntimeCompatibility(RUNTIME_COMPATIBILITY_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__RICH_CLIENT_PLATFORM:
				setRichClientPlatform(RICH_CLIENT_PLATFORM_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__REFLECTIVE_DELEGATION:
				setReflectiveDelegation(REFLECTIVE_DELEGATION_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__CODE_FORMATTING:
				setCodeFormatting(CODE_FORMATTING_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__COMMENT_FORMATTING:
				setCommentFormatting(COMMENT_FORMATTING_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__TESTS_DIRECTORY:
				unsetTestsDirectory();
				return;
			case GenmodelPackage.GEN_MODEL__TEST_SUITE_CLASS:
				unsetTestSuiteClass();
				return;
			case GenmodelPackage.GEN_MODEL__BOOLEAN_FLAGS_FIELD:
				setBooleanFlagsField(BOOLEAN_FLAGS_FIELD_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__BOOLEAN_FLAGS_RESERVED_BITS:
				setBooleanFlagsReservedBits(BOOLEAN_FLAGS_RESERVED_BITS_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__IMPORTER_ID:
				setImporterID(IMPORTER_ID_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__BUNDLE_MANIFEST:
				setBundleManifest(BUNDLE_MANIFEST_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__FEATURE_DELEGATION:
				setFeatureDelegation(FEATURE_DELEGATION_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__CONTAINMENT_PROXIES:
				setContainmentProxies(CONTAINMENT_PROXIES_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__MINIMAL_REFLECTIVE_METHODS:
				setMinimalReflectiveMethods(MINIMAL_REFLECTIVE_METHODS_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__SUPPRESS_CONTAINMENT:
				setSuppressContainment(SUPPRESS_CONTAINMENT_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__SUPPRESS_NOTIFICATION:
				setSuppressNotification(SUPPRESS_NOTIFICATION_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__ARRAY_ACCESSORS:
				setArrayAccessors(ARRAY_ACCESSORS_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__SUPPRESS_UNSETTABLE:
				setSuppressUnsettable(SUPPRESS_UNSETTABLE_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__FACADE_HELPER_CLASS:
				setFacadeHelperClass(FACADE_HELPER_CLASS_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__COMPLIANCE_LEVEL:
				setComplianceLevel(COMPLIANCE_LEVEL_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__SUPPRESS_GEN_MODEL_ANNOTATIONS:
				setSuppressGenModelAnnotations(SUPPRESS_GEN_MODEL_ANNOTATIONS_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__COPYRIGHT_FIELDS:
				setCopyrightFields(COPYRIGHT_FIELDS_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__BINARY_COMPATIBLE_REFLECTIVE_METHODS:
				setBinaryCompatibleReflectiveMethods(BINARY_COMPATIBLE_REFLECTIVE_METHODS_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__PUBLIC_CONSTRUCTORS:
				setPublicConstructors(PUBLIC_CONSTRUCTORS_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__TEMPLATE_PLUGIN_VARIABLES:
				getTemplatePluginVariables().clear();
				return;
			case GenmodelPackage.GEN_MODEL__PROVIDER_ROOT_EXTENDS_CLASS:
				setProviderRootExtendsClass(PROVIDER_ROOT_EXTENDS_CLASS_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__EDIT_PLUGIN_ID:
				setEditPluginID(EDIT_PLUGIN_ID_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__EDIT_PLUGIN_VARIABLES:
				getEditPluginVariables().clear();
				return;
			case GenmodelPackage.GEN_MODEL__EDITOR_PLUGIN_ID:
				setEditorPluginID(EDITOR_PLUGIN_ID_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__EDITOR_PLUGIN_VARIABLES:
				getEditorPluginVariables().clear();
				return;
			case GenmodelPackage.GEN_MODEL__TESTS_PLUGIN_ID:
				setTestsPluginID(TESTS_PLUGIN_ID_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__TESTS_PLUGIN_VARIABLES:
				getTestsPluginVariables().clear();
				return;
			case GenmodelPackage.GEN_MODEL__OPTIMIZED_HAS_CHILDREN:
				setOptimizedHasChildren(OPTIMIZED_HAS_CHILDREN_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__TABLE_PROVIDERS:
				setTableProviders(TABLE_PROVIDERS_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__COLOR_PROVIDERS:
				setColorProviders(COLOR_PROVIDERS_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__FONT_PROVIDERS:
				setFontProviders(FONT_PROVIDERS_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__RUNTIME_VERSION:
				unsetRuntimeVersion();
				return;
			case GenmodelPackage.GEN_MODEL__LANGUAGE:
				setLanguage(LANGUAGE_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__PACKED_ENUMS:
				setPackedEnums(PACKED_ENUMS_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__GEN_PACKAGES:
				getGenPackages().clear();
				return;
			case GenmodelPackage.GEN_MODEL__USED_GEN_PACKAGES:
				getUsedGenPackages().clear();
				return;
			case GenmodelPackage.GEN_MODEL__INTERFACE_NAME_PATTERN:
				setInterfaceNamePattern(INTERFACE_NAME_PATTERN_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__CLASS_NAME_PATTERN:
				setClassNamePattern(CLASS_NAME_PATTERN_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__OPERATION_REFLECTION:
				setOperationReflection(OPERATION_REFLECTION_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__RICH_AJAX_PLATFORM:
				setRichAjaxPlatform(RICH_AJAX_PLATFORM_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__RUNTIME_PLATFORM:
				setRuntimePlatform(RUNTIME_PLATFORM_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__IMPORT_ORGANIZING:
				setImportOrganizing(IMPORT_ORGANIZING_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__PLUGIN_KEY:
				setPluginKey(PLUGIN_KEY_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__DECORATION:
				setDecoration(DECORATION_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__STYLE_PROVIDERS:
				setStyleProviders(STYLE_PROVIDERS_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__CLEANUP:
				setCleanup(CLEANUP_EDEFAULT);
				return;
			case GenmodelPackage.GEN_MODEL__OS_GI_COMPATIBLE:
				setOSGiCompatible(OS_GI_COMPATIBLE_EDEFAULT);
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
			case GenmodelPackage.GEN_MODEL__COPYRIGHT_TEXT:
				return COPYRIGHT_TEXT_EDEFAULT == null ? copyrightText != null : !COPYRIGHT_TEXT_EDEFAULT.equals(copyrightText);
			case GenmodelPackage.GEN_MODEL__MODEL_DIRECTORY:
				return MODEL_DIRECTORY_EDEFAULT == null ? modelDirectory != null : !MODEL_DIRECTORY_EDEFAULT.equals(modelDirectory);
			case GenmodelPackage.GEN_MODEL__CREATION_COMMANDS:
				return creationCommands != CREATION_COMMANDS_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__CREATION_ICONS:
				return creationIcons != CREATION_ICONS_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__CREATION_SUBMENUS:
				return creationSubmenus != CREATION_SUBMENUS_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__EDIT_DIRECTORY:
				return isSetEditDirectory();
			case GenmodelPackage.GEN_MODEL__EDITOR_DIRECTORY:
				return isSetEditorDirectory();
			case GenmodelPackage.GEN_MODEL__MODEL_PLUGIN_ID:
				return MODEL_PLUGIN_ID_EDEFAULT == null ? modelPluginID != null : !MODEL_PLUGIN_ID_EDEFAULT.equals(modelPluginID);
			case GenmodelPackage.GEN_MODEL__TEMPLATE_DIRECTORY:
				return TEMPLATE_DIRECTORY_EDEFAULT == null ? templateDirectory != null : !TEMPLATE_DIRECTORY_EDEFAULT.equals(templateDirectory);
			case GenmodelPackage.GEN_MODEL__RUNTIME_JAR:
				return runtimeJar != RUNTIME_JAR_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__FOREIGN_MODEL:
				return foreignModel != null && !foreignModel.isEmpty();
			case GenmodelPackage.GEN_MODEL__DYNAMIC_TEMPLATES:
				return dynamicTemplates != DYNAMIC_TEMPLATES_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__REDIRECTION:
				return REDIRECTION_EDEFAULT == null ? redirection != null : !REDIRECTION_EDEFAULT.equals(redirection);
			case GenmodelPackage.GEN_MODEL__FORCE_OVERWRITE:
				return forceOverwrite != FORCE_OVERWRITE_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__NON_EXTERNALIZED_STRING_TAG:
				return NON_EXTERNALIZED_STRING_TAG_EDEFAULT == null ? nonExternalizedStringTag != null : !NON_EXTERNALIZED_STRING_TAG_EDEFAULT.equals(nonExternalizedStringTag);
			case GenmodelPackage.GEN_MODEL__MODEL_NAME:
				return MODEL_NAME_EDEFAULT == null ? modelName != null : !MODEL_NAME_EDEFAULT.equals(modelName);
			case GenmodelPackage.GEN_MODEL__MODEL_PLUGIN_CLASS:
				return MODEL_PLUGIN_CLASS_EDEFAULT == null ? modelPluginClass != null : !MODEL_PLUGIN_CLASS_EDEFAULT.equals(modelPluginClass);
			case GenmodelPackage.GEN_MODEL__EDIT_PLUGIN_CLASS:
				return isSetEditPluginClass();
			case GenmodelPackage.GEN_MODEL__EDITOR_PLUGIN_CLASS:
				return isSetEditorPluginClass();
			case GenmodelPackage.GEN_MODEL__UPDATE_CLASSPATH:
				return updateClasspath != UPDATE_CLASSPATH_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__GENERATE_SCHEMA:
				return generateSchema != GENERATE_SCHEMA_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__NON_NLS_MARKERS:
				return nonNLSMarkers != NON_NLS_MARKERS_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__STATIC_PACKAGES:
				return staticPackages != null && !staticPackages.isEmpty();
			case GenmodelPackage.GEN_MODEL__MODEL_PLUGIN_VARIABLES:
				return modelPluginVariables != null && !modelPluginVariables.isEmpty();
			case GenmodelPackage.GEN_MODEL__ROOT_EXTENDS_INTERFACE:
				return ROOT_EXTENDS_INTERFACE_EDEFAULT == null ? rootExtendsInterface != null : !ROOT_EXTENDS_INTERFACE_EDEFAULT.equals(rootExtendsInterface);
			case GenmodelPackage.GEN_MODEL__ROOT_EXTENDS_CLASS:
				return ROOT_EXTENDS_CLASS_EDEFAULT == null ? rootExtendsClass != null : !ROOT_EXTENDS_CLASS_EDEFAULT.equals(rootExtendsClass);
			case GenmodelPackage.GEN_MODEL__ROOT_IMPLEMENTS_INTERFACE:
				return ROOT_IMPLEMENTS_INTERFACE_EDEFAULT == null ? rootImplementsInterface != null : !ROOT_IMPLEMENTS_INTERFACE_EDEFAULT.equals(rootImplementsInterface);
			case GenmodelPackage.GEN_MODEL__SUPPRESS_EMF_TYPES:
				return suppressEMFTypes != SUPPRESS_EMF_TYPES_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__SUPPRESS_EMF_META_DATA:
				return suppressEMFMetaData != SUPPRESS_EMF_META_DATA_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__SUPPRESS_EMF_MODEL_TAGS:
				return suppressEMFModelTags != SUPPRESS_EMF_MODEL_TAGS_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__SUPPRESS_INTERFACES:
				return suppressInterfaces != SUPPRESS_INTERFACES_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__FEATURE_MAP_WRAPPER_INTERFACE:
				return FEATURE_MAP_WRAPPER_INTERFACE_EDEFAULT == null ? featureMapWrapperInterface != null : !FEATURE_MAP_WRAPPER_INTERFACE_EDEFAULT.equals(featureMapWrapperInterface);
			case GenmodelPackage.GEN_MODEL__FEATURE_MAP_WRAPPER_INTERNAL_INTERFACE:
				return FEATURE_MAP_WRAPPER_INTERNAL_INTERFACE_EDEFAULT == null ? featureMapWrapperInternalInterface != null : !FEATURE_MAP_WRAPPER_INTERNAL_INTERFACE_EDEFAULT.equals(featureMapWrapperInternalInterface);
			case GenmodelPackage.GEN_MODEL__FEATURE_MAP_WRAPPER_CLASS:
				return FEATURE_MAP_WRAPPER_CLASS_EDEFAULT == null ? featureMapWrapperClass != null : !FEATURE_MAP_WRAPPER_CLASS_EDEFAULT.equals(featureMapWrapperClass);
			case GenmodelPackage.GEN_MODEL__RUNTIME_COMPATIBILITY:
				return runtimeCompatibility != RUNTIME_COMPATIBILITY_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__RICH_CLIENT_PLATFORM:
				return isRichClientPlatform() != RICH_CLIENT_PLATFORM_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__REFLECTIVE_DELEGATION:
				return isReflectiveDelegation() != REFLECTIVE_DELEGATION_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__CODE_FORMATTING:
				return codeFormatting != CODE_FORMATTING_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__COMMENT_FORMATTING:
				return commentFormatting != COMMENT_FORMATTING_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__TESTS_DIRECTORY:
				return isSetTestsDirectory();
			case GenmodelPackage.GEN_MODEL__TEST_SUITE_CLASS:
				return isSetTestSuiteClass();
			case GenmodelPackage.GEN_MODEL__BOOLEAN_FLAGS_FIELD:
				return BOOLEAN_FLAGS_FIELD_EDEFAULT == null ? booleanFlagsField != null : !BOOLEAN_FLAGS_FIELD_EDEFAULT.equals(booleanFlagsField);
			case GenmodelPackage.GEN_MODEL__BOOLEAN_FLAGS_RESERVED_BITS:
				return booleanFlagsReservedBits != BOOLEAN_FLAGS_RESERVED_BITS_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__IMPORTER_ID:
				return IMPORTER_ID_EDEFAULT == null ? importerID != null : !IMPORTER_ID_EDEFAULT.equals(importerID);
			case GenmodelPackage.GEN_MODEL__BUNDLE_MANIFEST:
				return bundleManifest != BUNDLE_MANIFEST_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__FEATURE_DELEGATION:
				return featureDelegation != FEATURE_DELEGATION_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__CONTAINMENT_PROXIES:
				return containmentProxies != CONTAINMENT_PROXIES_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__MINIMAL_REFLECTIVE_METHODS:
				return minimalReflectiveMethods != MINIMAL_REFLECTIVE_METHODS_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__SUPPRESS_CONTAINMENT:
				return suppressContainment != SUPPRESS_CONTAINMENT_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__SUPPRESS_NOTIFICATION:
				return suppressNotification != SUPPRESS_NOTIFICATION_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__ARRAY_ACCESSORS:
				return arrayAccessors != ARRAY_ACCESSORS_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__SUPPRESS_UNSETTABLE:
				return suppressUnsettable != SUPPRESS_UNSETTABLE_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__FACADE_HELPER_CLASS:
				return FACADE_HELPER_CLASS_EDEFAULT == null ? facadeHelperClass != null : !FACADE_HELPER_CLASS_EDEFAULT.equals(facadeHelperClass);
			case GenmodelPackage.GEN_MODEL__COMPLIANCE_LEVEL:
				return complianceLevel != COMPLIANCE_LEVEL_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__SUPPRESS_GEN_MODEL_ANNOTATIONS:
				return suppressGenModelAnnotations != SUPPRESS_GEN_MODEL_ANNOTATIONS_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__COPYRIGHT_FIELDS:
				return copyrightFields != COPYRIGHT_FIELDS_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__BINARY_COMPATIBLE_REFLECTIVE_METHODS:
				return binaryCompatibleReflectiveMethods != BINARY_COMPATIBLE_REFLECTIVE_METHODS_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__PUBLIC_CONSTRUCTORS:
				return publicConstructors != PUBLIC_CONSTRUCTORS_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__TEMPLATE_PLUGIN_VARIABLES:
				return templatePluginVariables != null && !templatePluginVariables.isEmpty();
			case GenmodelPackage.GEN_MODEL__PROVIDER_ROOT_EXTENDS_CLASS:
				return PROVIDER_ROOT_EXTENDS_CLASS_EDEFAULT == null ? providerRootExtendsClass != null : !PROVIDER_ROOT_EXTENDS_CLASS_EDEFAULT.equals(providerRootExtendsClass);
			case GenmodelPackage.GEN_MODEL__EDIT_PLUGIN_ID:
				return EDIT_PLUGIN_ID_EDEFAULT == null ? editPluginID != null : !EDIT_PLUGIN_ID_EDEFAULT.equals(editPluginID);
			case GenmodelPackage.GEN_MODEL__EDIT_PLUGIN_VARIABLES:
				return editPluginVariables != null && !editPluginVariables.isEmpty();
			case GenmodelPackage.GEN_MODEL__EDITOR_PLUGIN_ID:
				return EDITOR_PLUGIN_ID_EDEFAULT == null ? editorPluginID != null : !EDITOR_PLUGIN_ID_EDEFAULT.equals(editorPluginID);
			case GenmodelPackage.GEN_MODEL__EDITOR_PLUGIN_VARIABLES:
				return editorPluginVariables != null && !editorPluginVariables.isEmpty();
			case GenmodelPackage.GEN_MODEL__TESTS_PLUGIN_ID:
				return TESTS_PLUGIN_ID_EDEFAULT == null ? testsPluginID != null : !TESTS_PLUGIN_ID_EDEFAULT.equals(testsPluginID);
			case GenmodelPackage.GEN_MODEL__TESTS_PLUGIN_VARIABLES:
				return testsPluginVariables != null && !testsPluginVariables.isEmpty();
			case GenmodelPackage.GEN_MODEL__OPTIMIZED_HAS_CHILDREN:
				return optimizedHasChildren != OPTIMIZED_HAS_CHILDREN_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__TABLE_PROVIDERS:
				return tableProviders != TABLE_PROVIDERS_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__COLOR_PROVIDERS:
				return colorProviders != COLOR_PROVIDERS_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__FONT_PROVIDERS:
				return fontProviders != FONT_PROVIDERS_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__RUNTIME_VERSION:
				return isSetRuntimeVersion();
			case GenmodelPackage.GEN_MODEL__LANGUAGE:
				return LANGUAGE_EDEFAULT == null ? language != null : !LANGUAGE_EDEFAULT.equals(language);
			case GenmodelPackage.GEN_MODEL__PACKED_ENUMS:
				return packedEnums != PACKED_ENUMS_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__GEN_PACKAGES:
				return genPackages != null && !genPackages.isEmpty();
			case GenmodelPackage.GEN_MODEL__USED_GEN_PACKAGES:
				return usedGenPackages != null && !usedGenPackages.isEmpty();
			case GenmodelPackage.GEN_MODEL__INTERFACE_NAME_PATTERN:
				return INTERFACE_NAME_PATTERN_EDEFAULT == null ? interfaceNamePattern != null : !INTERFACE_NAME_PATTERN_EDEFAULT.equals(interfaceNamePattern);
			case GenmodelPackage.GEN_MODEL__CLASS_NAME_PATTERN:
				return CLASS_NAME_PATTERN_EDEFAULT == null ? classNamePattern != null : !CLASS_NAME_PATTERN_EDEFAULT.equals(classNamePattern);
			case GenmodelPackage.GEN_MODEL__OPERATION_REFLECTION:
				return operationReflection != OPERATION_REFLECTION_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__RICH_AJAX_PLATFORM:
				return isRichAjaxPlatform() != RICH_AJAX_PLATFORM_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__RUNTIME_PLATFORM:
				return runtimePlatform != RUNTIME_PLATFORM_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__IMPORT_ORGANIZING:
				return importOrganizing != IMPORT_ORGANIZING_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__PLUGIN_KEY:
				return PLUGIN_KEY_EDEFAULT == null ? pluginKey != null : !PLUGIN_KEY_EDEFAULT.equals(pluginKey);
			case GenmodelPackage.GEN_MODEL__DECORATION:
				return decoration != DECORATION_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__STYLE_PROVIDERS:
				return styleProviders != STYLE_PROVIDERS_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__CLEANUP:
				return cleanup != CLEANUP_EDEFAULT;
			case GenmodelPackage.GEN_MODEL__OS_GI_COMPATIBLE:
				return oSGiCompatible != OS_GI_COMPATIBLE_EDEFAULT;
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
		result.append(" (copyrightText: ");
		result.append(copyrightText);
		result.append(", modelDirectory: ");
		result.append(modelDirectory);
		result.append(", creationCommands: ");
		result.append(creationCommands);
		result.append(", creationIcons: ");
		result.append(creationIcons);
		result.append(", creationSubmenus: ");
		result.append(creationSubmenus);
		result.append(", editDirectory: ");
		if (editDirectoryESet) result.append(editDirectory); else result.append("<unset>");
		result.append(", editorDirectory: ");
		if (editorDirectoryESet) result.append(editorDirectory); else result.append("<unset>");
		result.append(", modelPluginID: ");
		result.append(modelPluginID);
		result.append(", templateDirectory: ");
		result.append(templateDirectory);
		result.append(", runtimeJar: ");
		result.append(runtimeJar);
		result.append(", foreignModel: ");
		result.append(foreignModel);
		result.append(", dynamicTemplates: ");
		result.append(dynamicTemplates);
		result.append(", redirection: ");
		result.append(redirection);
		result.append(", forceOverwrite: ");
		result.append(forceOverwrite);
		result.append(", nonExternalizedStringTag: ");
		result.append(nonExternalizedStringTag);
		result.append(", modelName: ");
		result.append(modelName);
		result.append(", modelPluginClass: ");
		result.append(modelPluginClass);
		result.append(", editPluginClass: ");
		if (editPluginClassESet) result.append(editPluginClass); else result.append("<unset>");
		result.append(", editorPluginClass: ");
		if (editorPluginClassESet) result.append(editorPluginClass); else result.append("<unset>");
		result.append(", updateClasspath: ");
		result.append(updateClasspath);
		result.append(", generateSchema: ");
		result.append(generateSchema);
		result.append(", nonNLSMarkers: ");
		result.append(nonNLSMarkers);
		result.append(", staticPackages: ");
		result.append(staticPackages);
		result.append(", modelPluginVariables: ");
		result.append(modelPluginVariables);
		result.append(", rootExtendsInterface: ");
		result.append(rootExtendsInterface);
		result.append(", rootExtendsClass: ");
		result.append(rootExtendsClass);
		result.append(", rootImplementsInterface: ");
		result.append(rootImplementsInterface);
		result.append(", suppressEMFTypes: ");
		result.append(suppressEMFTypes);
		result.append(", suppressEMFMetaData: ");
		result.append(suppressEMFMetaData);
		result.append(", suppressEMFModelTags: ");
		result.append(suppressEMFModelTags);
		result.append(", suppressInterfaces: ");
		result.append(suppressInterfaces);
		result.append(", featureMapWrapperInterface: ");
		result.append(featureMapWrapperInterface);
		result.append(", featureMapWrapperInternalInterface: ");
		result.append(featureMapWrapperInternalInterface);
		result.append(", featureMapWrapperClass: ");
		result.append(featureMapWrapperClass);
		result.append(", runtimeCompatibility: ");
		result.append(runtimeCompatibility);
		result.append(", codeFormatting: ");
		result.append(codeFormatting);
		result.append(", commentFormatting: ");
		result.append(commentFormatting);
		result.append(", testsDirectory: ");
		if (testsDirectoryESet) result.append(testsDirectory); else result.append("<unset>");
		result.append(", testSuiteClass: ");
		if (testSuiteClassESet) result.append(testSuiteClass); else result.append("<unset>");
		result.append(", booleanFlagsField: ");
		result.append(booleanFlagsField);
		result.append(", booleanFlagsReservedBits: ");
		result.append(booleanFlagsReservedBits);
		result.append(", importerID: ");
		result.append(importerID);
		result.append(", bundleManifest: ");
		result.append(bundleManifest);
		result.append(", featureDelegation: ");
		result.append(featureDelegation);
		result.append(", containmentProxies: ");
		result.append(containmentProxies);
		result.append(", minimalReflectiveMethods: ");
		result.append(minimalReflectiveMethods);
		result.append(", suppressContainment: ");
		result.append(suppressContainment);
		result.append(", suppressNotification: ");
		result.append(suppressNotification);
		result.append(", arrayAccessors: ");
		result.append(arrayAccessors);
		result.append(", suppressUnsettable: ");
		result.append(suppressUnsettable);
		result.append(", facadeHelperClass: ");
		result.append(facadeHelperClass);
		result.append(", complianceLevel: ");
		result.append(complianceLevel);
		result.append(", suppressGenModelAnnotations: ");
		result.append(suppressGenModelAnnotations);
		result.append(", copyrightFields: ");
		result.append(copyrightFields);
		result.append(", binaryCompatibleReflectiveMethods: ");
		result.append(binaryCompatibleReflectiveMethods);
		result.append(", publicConstructors: ");
		result.append(publicConstructors);
		result.append(", templatePluginVariables: ");
		result.append(templatePluginVariables);
		result.append(", providerRootExtendsClass: ");
		result.append(providerRootExtendsClass);
		result.append(", editPluginID: ");
		result.append(editPluginID);
		result.append(", editPluginVariables: ");
		result.append(editPluginVariables);
		result.append(", editorPluginID: ");
		result.append(editorPluginID);
		result.append(", editorPluginVariables: ");
		result.append(editorPluginVariables);
		result.append(", testsPluginID: ");
		result.append(testsPluginID);
		result.append(", testsPluginVariables: ");
		result.append(testsPluginVariables);
		result.append(", optimizedHasChildren: ");
		result.append(optimizedHasChildren);
		result.append(", tableProviders: ");
		result.append(tableProviders);
		result.append(", colorProviders: ");
		result.append(colorProviders);
		result.append(", fontProviders: ");
		result.append(fontProviders);
		result.append(", runtimeVersion: ");
		if (runtimeVersionESet) result.append(runtimeVersion); else result.append("<unset>");
		result.append(", language: ");
		result.append(language);
		result.append(", packedEnums: ");
		result.append(packedEnums);
		result.append(", interfaceNamePattern: ");
		result.append(interfaceNamePattern);
		result.append(", classNamePattern: ");
		result.append(classNamePattern);
		result.append(", operationReflection: ");
		result.append(operationReflection);
		result.append(", runtimePlatform: ");
		result.append(runtimePlatform);
		result.append(", importOrganizing: ");
		result.append(importOrganizing);
		result.append(", pluginKey: ");
		result.append(pluginKey);
		result.append(", decoration: ");
		result.append(decoration);
		result.append(", styleProviders: ");
		result.append(styleProviders);
		result.append(", cleanup: ");
		result.append(cleanup);
		result.append(", oSGiCompatible: ");
		result.append(oSGiCompatible);
		result.append(')');
		return result.toString();
	}

} //GenModelImpl
