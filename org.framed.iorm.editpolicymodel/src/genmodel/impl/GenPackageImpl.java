/**
 */
package genmodel.impl;

import genmodel.GenResourceKind;
import genmodel.GenmodelPackage;

import java.util.Collection;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenDataType;
import org.eclipse.emf.codegen.ecore.genmodel.GenEnum;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Package</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link genmodel.impl.GenPackageImpl#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link genmodel.impl.GenPackageImpl#getBasePackage <em>Base Package</em>}</li>
 *   <li>{@link genmodel.impl.GenPackageImpl#getResource <em>Resource</em>}</li>
 *   <li>{@link genmodel.impl.GenPackageImpl#isDisposableProviderFactory <em>Disposable Provider Factory</em>}</li>
 *   <li>{@link genmodel.impl.GenPackageImpl#isAdapterFactory <em>Adapter Factory</em>}</li>
 *   <li>{@link genmodel.impl.GenPackageImpl#isLoadInitialization <em>Load Initialization</em>}</li>
 *   <li>{@link genmodel.impl.GenPackageImpl#getInterfacePackageSuffix <em>Interface Package Suffix</em>}</li>
 *   <li>{@link genmodel.impl.GenPackageImpl#getMetaDataPackageSuffix <em>Meta Data Package Suffix</em>}</li>
 *   <li>{@link genmodel.impl.GenPackageImpl#getClassPackageSuffix <em>Class Package Suffix</em>}</li>
 *   <li>{@link genmodel.impl.GenPackageImpl#getUtilityPackageSuffix <em>Utility Package Suffix</em>}</li>
 *   <li>{@link genmodel.impl.GenPackageImpl#getProviderPackageSuffix <em>Provider Package Suffix</em>}</li>
 *   <li>{@link genmodel.impl.GenPackageImpl#getPresentationPackageSuffix <em>Presentation Package Suffix</em>}</li>
 *   <li>{@link genmodel.impl.GenPackageImpl#getTestsPackageSuffix <em>Tests Package Suffix</em>}</li>
 *   <li>{@link genmodel.impl.GenPackageImpl#isGenerateExampleClass <em>Generate Example Class</em>}</li>
 *   <li>{@link genmodel.impl.GenPackageImpl#isLiteralsInterface <em>Literals Interface</em>}</li>
 *   <li>{@link genmodel.impl.GenPackageImpl#isDataTypeConverters <em>Data Type Converters</em>}</li>
 *   <li>{@link genmodel.impl.GenPackageImpl#isMultipleEditorPages <em>Multiple Editor Pages</em>}</li>
 *   <li>{@link genmodel.impl.GenPackageImpl#isGenerateModelWizard <em>Generate Model Wizard</em>}</li>
 *   <li>{@link genmodel.impl.GenPackageImpl#isExtensibleProviderFactory <em>Extensible Provider Factory</em>}</li>
 *   <li>{@link genmodel.impl.GenPackageImpl#isChildCreationExtenders <em>Child Creation Extenders</em>}</li>
 *   <li>{@link genmodel.impl.GenPackageImpl#getContentTypeIdentifier <em>Content Type Identifier</em>}</li>
 *   <li>{@link genmodel.impl.GenPackageImpl#getFileExtensions <em>File Extensions</em>}</li>
 *   <li>{@link genmodel.impl.GenPackageImpl#getEcorePackage <em>Ecore Package</em>}</li>
 *   <li>{@link genmodel.impl.GenPackageImpl#getGenModel <em>Gen Model</em>}</li>
 *   <li>{@link genmodel.impl.GenPackageImpl#getGenEnums <em>Gen Enums</em>}</li>
 *   <li>{@link genmodel.impl.GenPackageImpl#getGenDataTypes <em>Gen Data Types</em>}</li>
 *   <li>{@link genmodel.impl.GenPackageImpl#getGenClasses <em>Gen Classes</em>}</li>
 *   <li>{@link genmodel.impl.GenPackageImpl#getNestedGenPackages <em>Nested Gen Packages</em>}</li>
 *   <li>{@link genmodel.impl.GenPackageImpl#getGenClassifiers <em>Gen Classifiers</em>}</li>
 *   <li>{@link genmodel.impl.GenPackageImpl#getPublicationLocation <em>Publication Location</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenPackageImpl extends GenBaseImpl implements GenPackage {
	/**
	 * The default value of the '{@link #getPrefix() <em>Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String PREFIX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrefix() <em>Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrefix()
	 * @generated
	 * @ordered
	 */
	protected String prefix = PREFIX_EDEFAULT;

	/**
	 * The default value of the '{@link #getBasePackage() <em>Base Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBasePackage()
	 * @generated
	 * @ordered
	 */
	protected static final String BASE_PACKAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBasePackage() <em>Base Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBasePackage()
	 * @generated
	 * @ordered
	 */
	protected String basePackage = BASE_PACKAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getResource() <em>Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResource()
	 * @generated
	 * @ordered
	 */
	protected static final GenResourceKind RESOURCE_EDEFAULT = GenResourceKind.NONE;

	/**
	 * The cached value of the '{@link #getResource() <em>Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResource()
	 * @generated
	 * @ordered
	 */
	protected GenResourceKind resource = RESOURCE_EDEFAULT;

	/**
	 * The default value of the '{@link #isDisposableProviderFactory() <em>Disposable Provider Factory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDisposableProviderFactory()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DISPOSABLE_PROVIDER_FACTORY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDisposableProviderFactory() <em>Disposable Provider Factory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDisposableProviderFactory()
	 * @generated
	 * @ordered
	 */
	protected boolean disposableProviderFactory = DISPOSABLE_PROVIDER_FACTORY_EDEFAULT;

	/**
	 * The default value of the '{@link #isAdapterFactory() <em>Adapter Factory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAdapterFactory()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ADAPTER_FACTORY_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isAdapterFactory() <em>Adapter Factory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAdapterFactory()
	 * @generated
	 * @ordered
	 */
	protected boolean adapterFactory = ADAPTER_FACTORY_EDEFAULT;

	/**
	 * The default value of the '{@link #isLoadInitialization() <em>Load Initialization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLoadInitialization()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LOAD_INITIALIZATION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isLoadInitialization() <em>Load Initialization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLoadInitialization()
	 * @generated
	 * @ordered
	 */
	protected boolean loadInitialization = LOAD_INITIALIZATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getInterfacePackageSuffix() <em>Interface Package Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterfacePackageSuffix()
	 * @generated
	 * @ordered
	 */
	protected static final String INTERFACE_PACKAGE_SUFFIX_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getInterfacePackageSuffix() <em>Interface Package Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterfacePackageSuffix()
	 * @generated
	 * @ordered
	 */
	protected String interfacePackageSuffix = INTERFACE_PACKAGE_SUFFIX_EDEFAULT;

	/**
	 * The default value of the '{@link #getMetaDataPackageSuffix() <em>Meta Data Package Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaDataPackageSuffix()
	 * @generated
	 * @ordered
	 */
	protected static final String META_DATA_PACKAGE_SUFFIX_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getMetaDataPackageSuffix() <em>Meta Data Package Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaDataPackageSuffix()
	 * @generated
	 * @ordered
	 */
	protected String metaDataPackageSuffix = META_DATA_PACKAGE_SUFFIX_EDEFAULT;

	/**
	 * The default value of the '{@link #getClassPackageSuffix() <em>Class Package Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassPackageSuffix()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASS_PACKAGE_SUFFIX_EDEFAULT = "impl";

	/**
	 * The cached value of the '{@link #getClassPackageSuffix() <em>Class Package Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassPackageSuffix()
	 * @generated
	 * @ordered
	 */
	protected String classPackageSuffix = CLASS_PACKAGE_SUFFIX_EDEFAULT;

	/**
	 * The default value of the '{@link #getUtilityPackageSuffix() <em>Utility Package Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtilityPackageSuffix()
	 * @generated
	 * @ordered
	 */
	protected static final String UTILITY_PACKAGE_SUFFIX_EDEFAULT = "util";

	/**
	 * The cached value of the '{@link #getUtilityPackageSuffix() <em>Utility Package Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtilityPackageSuffix()
	 * @generated
	 * @ordered
	 */
	protected String utilityPackageSuffix = UTILITY_PACKAGE_SUFFIX_EDEFAULT;

	/**
	 * The default value of the '{@link #getProviderPackageSuffix() <em>Provider Package Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProviderPackageSuffix()
	 * @generated
	 * @ordered
	 */
	protected static final String PROVIDER_PACKAGE_SUFFIX_EDEFAULT = "provider";

	/**
	 * The cached value of the '{@link #getProviderPackageSuffix() <em>Provider Package Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProviderPackageSuffix()
	 * @generated
	 * @ordered
	 */
	protected String providerPackageSuffix = PROVIDER_PACKAGE_SUFFIX_EDEFAULT;

	/**
	 * The default value of the '{@link #getPresentationPackageSuffix() <em>Presentation Package Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPresentationPackageSuffix()
	 * @generated
	 * @ordered
	 */
	protected static final String PRESENTATION_PACKAGE_SUFFIX_EDEFAULT = "presentation";

	/**
	 * The cached value of the '{@link #getPresentationPackageSuffix() <em>Presentation Package Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPresentationPackageSuffix()
	 * @generated
	 * @ordered
	 */
	protected String presentationPackageSuffix = PRESENTATION_PACKAGE_SUFFIX_EDEFAULT;

	/**
	 * The default value of the '{@link #getTestsPackageSuffix() <em>Tests Package Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestsPackageSuffix()
	 * @generated
	 * @ordered
	 */
	protected static final String TESTS_PACKAGE_SUFFIX_EDEFAULT = "tests";

	/**
	 * The cached value of the '{@link #getTestsPackageSuffix() <em>Tests Package Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestsPackageSuffix()
	 * @generated
	 * @ordered
	 */
	protected String testsPackageSuffix = TESTS_PACKAGE_SUFFIX_EDEFAULT;

	/**
	 * The default value of the '{@link #isGenerateExampleClass() <em>Generate Example Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGenerateExampleClass()
	 * @generated
	 * @ordered
	 */
	protected static final boolean GENERATE_EXAMPLE_CLASS_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isGenerateExampleClass() <em>Generate Example Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGenerateExampleClass()
	 * @generated
	 * @ordered
	 */
	protected boolean generateExampleClass = GENERATE_EXAMPLE_CLASS_EDEFAULT;

	/**
	 * The default value of the '{@link #isLiteralsInterface() <em>Literals Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLiteralsInterface()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LITERALS_INTERFACE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isLiteralsInterface() <em>Literals Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLiteralsInterface()
	 * @generated
	 * @ordered
	 */
	protected boolean literalsInterface = LITERALS_INTERFACE_EDEFAULT;

	/**
	 * The default value of the '{@link #isDataTypeConverters() <em>Data Type Converters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDataTypeConverters()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DATA_TYPE_CONVERTERS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDataTypeConverters() <em>Data Type Converters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDataTypeConverters()
	 * @generated
	 * @ordered
	 */
	protected boolean dataTypeConverters = DATA_TYPE_CONVERTERS_EDEFAULT;

	/**
	 * The default value of the '{@link #isMultipleEditorPages() <em>Multiple Editor Pages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMultipleEditorPages()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MULTIPLE_EDITOR_PAGES_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isMultipleEditorPages() <em>Multiple Editor Pages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMultipleEditorPages()
	 * @generated
	 * @ordered
	 */
	protected boolean multipleEditorPages = MULTIPLE_EDITOR_PAGES_EDEFAULT;

	/**
	 * The default value of the '{@link #isGenerateModelWizard() <em>Generate Model Wizard</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGenerateModelWizard()
	 * @generated
	 * @ordered
	 */
	protected static final boolean GENERATE_MODEL_WIZARD_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isGenerateModelWizard() <em>Generate Model Wizard</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGenerateModelWizard()
	 * @generated
	 * @ordered
	 */
	protected boolean generateModelWizard = GENERATE_MODEL_WIZARD_EDEFAULT;

	/**
	 * The default value of the '{@link #isExtensibleProviderFactory() <em>Extensible Provider Factory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExtensibleProviderFactory()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXTENSIBLE_PROVIDER_FACTORY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExtensibleProviderFactory() <em>Extensible Provider Factory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExtensibleProviderFactory()
	 * @generated
	 * @ordered
	 */
	protected boolean extensibleProviderFactory = EXTENSIBLE_PROVIDER_FACTORY_EDEFAULT;

	/**
	 * The default value of the '{@link #isChildCreationExtenders() <em>Child Creation Extenders</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isChildCreationExtenders()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CHILD_CREATION_EXTENDERS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isChildCreationExtenders() <em>Child Creation Extenders</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isChildCreationExtenders()
	 * @generated
	 * @ordered
	 */
	protected boolean childCreationExtenders = CHILD_CREATION_EXTENDERS_EDEFAULT;

	/**
	 * The default value of the '{@link #getContentTypeIdentifier() <em>Content Type Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContentTypeIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTENT_TYPE_IDENTIFIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContentTypeIdentifier() <em>Content Type Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContentTypeIdentifier()
	 * @generated
	 * @ordered
	 */
	protected String contentTypeIdentifier = CONTENT_TYPE_IDENTIFIER_EDEFAULT;

	/**
	 * The default value of the '{@link #getFileExtensions() <em>File Extensions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileExtensions()
	 * @generated
	 * @ordered
	 */
	protected static final String FILE_EXTENSIONS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFileExtensions() <em>File Extensions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileExtensions()
	 * @generated
	 * @ordered
	 */
	protected String fileExtensions = FILE_EXTENSIONS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEcorePackage() <em>Ecore Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEcorePackage()
	 * @generated
	 * @ordered
	 */
	protected EPackage ecorePackage;

	/**
	 * The cached value of the '{@link #getGenEnums() <em>Gen Enums</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenEnums()
	 * @generated
	 * @ordered
	 */
	protected EList<GenEnum> genEnums;

	/**
	 * The cached value of the '{@link #getGenDataTypes() <em>Gen Data Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenDataTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<GenDataType> genDataTypes;

	/**
	 * The cached value of the '{@link #getGenClasses() <em>Gen Classes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<GenClass> genClasses;

	/**
	 * The cached value of the '{@link #getNestedGenPackages() <em>Nested Gen Packages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNestedGenPackages()
	 * @generated
	 * @ordered
	 */
	protected EList<GenPackage> nestedGenPackages;

	/**
	 * The default value of the '{@link #getPublicationLocation() <em>Publication Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublicationLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String PUBLICATION_LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPublicationLocation() <em>Publication Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublicationLocation()
	 * @generated
	 * @ordered
	 */
	protected String publicationLocation = PUBLICATION_LOCATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenPackageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GenmodelPackage.Literals.GEN_PACKAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrefix(String newPrefix) {
		String oldPrefix = prefix;
		prefix = newPrefix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_PACKAGE__PREFIX, oldPrefix, prefix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBasePackage() {
		return basePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBasePackage(String newBasePackage) {
		String oldBasePackage = basePackage;
		basePackage = newBasePackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_PACKAGE__BASE_PACKAGE, oldBasePackage, basePackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenResourceKind getResource() {
		return resource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResource(GenResourceKind newResource) {
		GenResourceKind oldResource = resource;
		resource = newResource == null ? RESOURCE_EDEFAULT : newResource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_PACKAGE__RESOURCE, oldResource, resource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDisposableProviderFactory() {
		return disposableProviderFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisposableProviderFactory(boolean newDisposableProviderFactory) {
		boolean oldDisposableProviderFactory = disposableProviderFactory;
		disposableProviderFactory = newDisposableProviderFactory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_PACKAGE__DISPOSABLE_PROVIDER_FACTORY, oldDisposableProviderFactory, disposableProviderFactory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAdapterFactory() {
		return adapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdapterFactory(boolean newAdapterFactory) {
		boolean oldAdapterFactory = adapterFactory;
		adapterFactory = newAdapterFactory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_PACKAGE__ADAPTER_FACTORY, oldAdapterFactory, adapterFactory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLoadInitialization() {
		return loadInitialization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoadInitialization(boolean newLoadInitialization) {
		boolean oldLoadInitialization = loadInitialization;
		loadInitialization = newLoadInitialization;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_PACKAGE__LOAD_INITIALIZATION, oldLoadInitialization, loadInitialization));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInterfacePackageSuffix() {
		return interfacePackageSuffix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterfacePackageSuffix(String newInterfacePackageSuffix) {
		String oldInterfacePackageSuffix = interfacePackageSuffix;
		interfacePackageSuffix = newInterfacePackageSuffix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_PACKAGE__INTERFACE_PACKAGE_SUFFIX, oldInterfacePackageSuffix, interfacePackageSuffix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMetaDataPackageSuffix() {
		return metaDataPackageSuffix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetaDataPackageSuffix(String newMetaDataPackageSuffix) {
		String oldMetaDataPackageSuffix = metaDataPackageSuffix;
		metaDataPackageSuffix = newMetaDataPackageSuffix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_PACKAGE__META_DATA_PACKAGE_SUFFIX, oldMetaDataPackageSuffix, metaDataPackageSuffix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClassPackageSuffix() {
		return classPackageSuffix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassPackageSuffix(String newClassPackageSuffix) {
		String oldClassPackageSuffix = classPackageSuffix;
		classPackageSuffix = newClassPackageSuffix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_PACKAGE__CLASS_PACKAGE_SUFFIX, oldClassPackageSuffix, classPackageSuffix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUtilityPackageSuffix() {
		return utilityPackageSuffix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUtilityPackageSuffix(String newUtilityPackageSuffix) {
		String oldUtilityPackageSuffix = utilityPackageSuffix;
		utilityPackageSuffix = newUtilityPackageSuffix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_PACKAGE__UTILITY_PACKAGE_SUFFIX, oldUtilityPackageSuffix, utilityPackageSuffix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProviderPackageSuffix() {
		return providerPackageSuffix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProviderPackageSuffix(String newProviderPackageSuffix) {
		String oldProviderPackageSuffix = providerPackageSuffix;
		providerPackageSuffix = newProviderPackageSuffix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_PACKAGE__PROVIDER_PACKAGE_SUFFIX, oldProviderPackageSuffix, providerPackageSuffix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPresentationPackageSuffix() {
		return presentationPackageSuffix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPresentationPackageSuffix(String newPresentationPackageSuffix) {
		String oldPresentationPackageSuffix = presentationPackageSuffix;
		presentationPackageSuffix = newPresentationPackageSuffix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_PACKAGE__PRESENTATION_PACKAGE_SUFFIX, oldPresentationPackageSuffix, presentationPackageSuffix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTestsPackageSuffix() {
		return testsPackageSuffix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTestsPackageSuffix(String newTestsPackageSuffix) {
		String oldTestsPackageSuffix = testsPackageSuffix;
		testsPackageSuffix = newTestsPackageSuffix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_PACKAGE__TESTS_PACKAGE_SUFFIX, oldTestsPackageSuffix, testsPackageSuffix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isGenerateExampleClass() {
		return generateExampleClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenerateExampleClass(boolean newGenerateExampleClass) {
		boolean oldGenerateExampleClass = generateExampleClass;
		generateExampleClass = newGenerateExampleClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_PACKAGE__GENERATE_EXAMPLE_CLASS, oldGenerateExampleClass, generateExampleClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLiteralsInterface() {
		return literalsInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLiteralsInterface(boolean newLiteralsInterface) {
		boolean oldLiteralsInterface = literalsInterface;
		literalsInterface = newLiteralsInterface;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_PACKAGE__LITERALS_INTERFACE, oldLiteralsInterface, literalsInterface));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDataTypeConverters() {
		return dataTypeConverters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataTypeConverters(boolean newDataTypeConverters) {
		boolean oldDataTypeConverters = dataTypeConverters;
		dataTypeConverters = newDataTypeConverters;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_PACKAGE__DATA_TYPE_CONVERTERS, oldDataTypeConverters, dataTypeConverters));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMultipleEditorPages() {
		return multipleEditorPages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMultipleEditorPages(boolean newMultipleEditorPages) {
		boolean oldMultipleEditorPages = multipleEditorPages;
		multipleEditorPages = newMultipleEditorPages;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_PACKAGE__MULTIPLE_EDITOR_PAGES, oldMultipleEditorPages, multipleEditorPages));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isGenerateModelWizard() {
		return generateModelWizard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenerateModelWizard(boolean newGenerateModelWizard) {
		boolean oldGenerateModelWizard = generateModelWizard;
		generateModelWizard = newGenerateModelWizard;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_PACKAGE__GENERATE_MODEL_WIZARD, oldGenerateModelWizard, generateModelWizard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExtensibleProviderFactory() {
		return extensibleProviderFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtensibleProviderFactory(boolean newExtensibleProviderFactory) {
		boolean oldExtensibleProviderFactory = extensibleProviderFactory;
		extensibleProviderFactory = newExtensibleProviderFactory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_PACKAGE__EXTENSIBLE_PROVIDER_FACTORY, oldExtensibleProviderFactory, extensibleProviderFactory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isChildCreationExtenders() {
		return childCreationExtenders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChildCreationExtenders(boolean newChildCreationExtenders) {
		boolean oldChildCreationExtenders = childCreationExtenders;
		childCreationExtenders = newChildCreationExtenders;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_PACKAGE__CHILD_CREATION_EXTENDERS, oldChildCreationExtenders, childCreationExtenders));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getContentTypeIdentifier() {
		return contentTypeIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContentTypeIdentifier(String newContentTypeIdentifier) {
		String oldContentTypeIdentifier = contentTypeIdentifier;
		contentTypeIdentifier = newContentTypeIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_PACKAGE__CONTENT_TYPE_IDENTIFIER, oldContentTypeIdentifier, contentTypeIdentifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFileExtensions() {
		return fileExtensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFileExtensions(String newFileExtensions) {
		String oldFileExtensions = fileExtensions;
		fileExtensions = newFileExtensions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_PACKAGE__FILE_EXTENSIONS, oldFileExtensions, fileExtensions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage getEcorePackage() {
		if (ecorePackage != null && ecorePackage.eIsProxy()) {
			InternalEObject oldEcorePackage = (InternalEObject)ecorePackage;
			ecorePackage = (EPackage)eResolveProxy(oldEcorePackage);
			if (ecorePackage != oldEcorePackage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GenmodelPackage.GEN_PACKAGE__ECORE_PACKAGE, oldEcorePackage, ecorePackage));
			}
		}
		return ecorePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage basicGetEcorePackage() {
		return ecorePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEcorePackage(EPackage newEcorePackage) {
		EPackage oldEcorePackage = ecorePackage;
		ecorePackage = newEcorePackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_PACKAGE__ECORE_PACKAGE, oldEcorePackage, ecorePackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenModel getGenModel() {
		if (eContainerFeatureID() != GenmodelPackage.GEN_PACKAGE__GEN_MODEL) return null;
		return (GenModel)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGenModel(GenModel newGenModel, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newGenModel, GenmodelPackage.GEN_PACKAGE__GEN_MODEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenModel(GenModel newGenModel) {
		if (newGenModel != eInternalContainer() || (eContainerFeatureID() != GenmodelPackage.GEN_PACKAGE__GEN_MODEL && newGenModel != null)) {
			if (EcoreUtil.isAncestor(this, newGenModel))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newGenModel != null)
				msgs = ((InternalEObject)newGenModel).eInverseAdd(this, GenmodelPackage.GEN_MODEL__GEN_PACKAGES, GenModel.class, msgs);
			msgs = basicSetGenModel(newGenModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_PACKAGE__GEN_MODEL, newGenModel, newGenModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GenEnum> getGenEnums() {
		if (genEnums == null) {
			genEnums = new EObjectContainmentEList<GenEnum>(GenEnum.class, this, GenmodelPackage.GEN_PACKAGE__GEN_ENUMS);
		}
		return genEnums;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GenDataType> getGenDataTypes() {
		if (genDataTypes == null) {
			genDataTypes = new EObjectContainmentEList<GenDataType>(GenDataType.class, this, GenmodelPackage.GEN_PACKAGE__GEN_DATA_TYPES);
		}
		return genDataTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GenClass> getGenClasses() {
		if (genClasses == null) {
			genClasses = new EObjectContainmentEList<GenClass>(GenClass.class, this, GenmodelPackage.GEN_PACKAGE__GEN_CLASSES);
		}
		return genClasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GenPackage> getNestedGenPackages() {
		if (nestedGenPackages == null) {
			nestedGenPackages = new EObjectContainmentEList<GenPackage>(GenPackage.class, this, GenmodelPackage.GEN_PACKAGE__NESTED_GEN_PACKAGES);
		}
		return nestedGenPackages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GenClassifier> getGenClassifiers() {
		// TODO: implement this method to return the 'Gen Classifiers' reference list
		// Ensure that you remove @generated or mark it @generated NOT
		// The list is expected to implement org.eclipse.emf.ecore.util.InternalEList and org.eclipse.emf.ecore.EStructuralFeature.Setting
		// so it's likely that an appropriate subclass of org.eclipse.emf.ecore.util.EcoreEList should be used.
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPublicationLocation() {
		return publicationLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPublicationLocation(String newPublicationLocation) {
		String oldPublicationLocation = publicationLocation;
		publicationLocation = newPublicationLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenmodelPackage.GEN_PACKAGE__PUBLICATION_LOCATION, oldPublicationLocation, publicationLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GenmodelPackage.GEN_PACKAGE__GEN_MODEL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetGenModel((GenModel)otherEnd, msgs);
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
			case GenmodelPackage.GEN_PACKAGE__GEN_MODEL:
				return basicSetGenModel(null, msgs);
			case GenmodelPackage.GEN_PACKAGE__GEN_ENUMS:
				return ((InternalEList<?>)getGenEnums()).basicRemove(otherEnd, msgs);
			case GenmodelPackage.GEN_PACKAGE__GEN_DATA_TYPES:
				return ((InternalEList<?>)getGenDataTypes()).basicRemove(otherEnd, msgs);
			case GenmodelPackage.GEN_PACKAGE__GEN_CLASSES:
				return ((InternalEList<?>)getGenClasses()).basicRemove(otherEnd, msgs);
			case GenmodelPackage.GEN_PACKAGE__NESTED_GEN_PACKAGES:
				return ((InternalEList<?>)getNestedGenPackages()).basicRemove(otherEnd, msgs);
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
			case GenmodelPackage.GEN_PACKAGE__GEN_MODEL:
				return eInternalContainer().eInverseRemove(this, GenmodelPackage.GEN_MODEL__GEN_PACKAGES, GenModel.class, msgs);
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
			case GenmodelPackage.GEN_PACKAGE__PREFIX:
				return getPrefix();
			case GenmodelPackage.GEN_PACKAGE__BASE_PACKAGE:
				return getBasePackage();
			case GenmodelPackage.GEN_PACKAGE__RESOURCE:
				return getResource();
			case GenmodelPackage.GEN_PACKAGE__DISPOSABLE_PROVIDER_FACTORY:
				return isDisposableProviderFactory();
			case GenmodelPackage.GEN_PACKAGE__ADAPTER_FACTORY:
				return isAdapterFactory();
			case GenmodelPackage.GEN_PACKAGE__LOAD_INITIALIZATION:
				return isLoadInitialization();
			case GenmodelPackage.GEN_PACKAGE__INTERFACE_PACKAGE_SUFFIX:
				return getInterfacePackageSuffix();
			case GenmodelPackage.GEN_PACKAGE__META_DATA_PACKAGE_SUFFIX:
				return getMetaDataPackageSuffix();
			case GenmodelPackage.GEN_PACKAGE__CLASS_PACKAGE_SUFFIX:
				return getClassPackageSuffix();
			case GenmodelPackage.GEN_PACKAGE__UTILITY_PACKAGE_SUFFIX:
				return getUtilityPackageSuffix();
			case GenmodelPackage.GEN_PACKAGE__PROVIDER_PACKAGE_SUFFIX:
				return getProviderPackageSuffix();
			case GenmodelPackage.GEN_PACKAGE__PRESENTATION_PACKAGE_SUFFIX:
				return getPresentationPackageSuffix();
			case GenmodelPackage.GEN_PACKAGE__TESTS_PACKAGE_SUFFIX:
				return getTestsPackageSuffix();
			case GenmodelPackage.GEN_PACKAGE__GENERATE_EXAMPLE_CLASS:
				return isGenerateExampleClass();
			case GenmodelPackage.GEN_PACKAGE__LITERALS_INTERFACE:
				return isLiteralsInterface();
			case GenmodelPackage.GEN_PACKAGE__DATA_TYPE_CONVERTERS:
				return isDataTypeConverters();
			case GenmodelPackage.GEN_PACKAGE__MULTIPLE_EDITOR_PAGES:
				return isMultipleEditorPages();
			case GenmodelPackage.GEN_PACKAGE__GENERATE_MODEL_WIZARD:
				return isGenerateModelWizard();
			case GenmodelPackage.GEN_PACKAGE__EXTENSIBLE_PROVIDER_FACTORY:
				return isExtensibleProviderFactory();
			case GenmodelPackage.GEN_PACKAGE__CHILD_CREATION_EXTENDERS:
				return isChildCreationExtenders();
			case GenmodelPackage.GEN_PACKAGE__CONTENT_TYPE_IDENTIFIER:
				return getContentTypeIdentifier();
			case GenmodelPackage.GEN_PACKAGE__FILE_EXTENSIONS:
				return getFileExtensions();
			case GenmodelPackage.GEN_PACKAGE__ECORE_PACKAGE:
				if (resolve) return getEcorePackage();
				return basicGetEcorePackage();
			case GenmodelPackage.GEN_PACKAGE__GEN_MODEL:
				return getGenModel();
			case GenmodelPackage.GEN_PACKAGE__GEN_ENUMS:
				return getGenEnums();
			case GenmodelPackage.GEN_PACKAGE__GEN_DATA_TYPES:
				return getGenDataTypes();
			case GenmodelPackage.GEN_PACKAGE__GEN_CLASSES:
				return getGenClasses();
			case GenmodelPackage.GEN_PACKAGE__NESTED_GEN_PACKAGES:
				return getNestedGenPackages();
			case GenmodelPackage.GEN_PACKAGE__GEN_CLASSIFIERS:
				return getGenClassifiers();
			case GenmodelPackage.GEN_PACKAGE__PUBLICATION_LOCATION:
				return getPublicationLocation();
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
			case GenmodelPackage.GEN_PACKAGE__PREFIX:
				setPrefix((String)newValue);
				return;
			case GenmodelPackage.GEN_PACKAGE__BASE_PACKAGE:
				setBasePackage((String)newValue);
				return;
			case GenmodelPackage.GEN_PACKAGE__RESOURCE:
				setResource((GenResourceKind)newValue);
				return;
			case GenmodelPackage.GEN_PACKAGE__DISPOSABLE_PROVIDER_FACTORY:
				setDisposableProviderFactory((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_PACKAGE__ADAPTER_FACTORY:
				setAdapterFactory((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_PACKAGE__LOAD_INITIALIZATION:
				setLoadInitialization((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_PACKAGE__INTERFACE_PACKAGE_SUFFIX:
				setInterfacePackageSuffix((String)newValue);
				return;
			case GenmodelPackage.GEN_PACKAGE__META_DATA_PACKAGE_SUFFIX:
				setMetaDataPackageSuffix((String)newValue);
				return;
			case GenmodelPackage.GEN_PACKAGE__CLASS_PACKAGE_SUFFIX:
				setClassPackageSuffix((String)newValue);
				return;
			case GenmodelPackage.GEN_PACKAGE__UTILITY_PACKAGE_SUFFIX:
				setUtilityPackageSuffix((String)newValue);
				return;
			case GenmodelPackage.GEN_PACKAGE__PROVIDER_PACKAGE_SUFFIX:
				setProviderPackageSuffix((String)newValue);
				return;
			case GenmodelPackage.GEN_PACKAGE__PRESENTATION_PACKAGE_SUFFIX:
				setPresentationPackageSuffix((String)newValue);
				return;
			case GenmodelPackage.GEN_PACKAGE__TESTS_PACKAGE_SUFFIX:
				setTestsPackageSuffix((String)newValue);
				return;
			case GenmodelPackage.GEN_PACKAGE__GENERATE_EXAMPLE_CLASS:
				setGenerateExampleClass((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_PACKAGE__LITERALS_INTERFACE:
				setLiteralsInterface((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_PACKAGE__DATA_TYPE_CONVERTERS:
				setDataTypeConverters((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_PACKAGE__MULTIPLE_EDITOR_PAGES:
				setMultipleEditorPages((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_PACKAGE__GENERATE_MODEL_WIZARD:
				setGenerateModelWizard((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_PACKAGE__EXTENSIBLE_PROVIDER_FACTORY:
				setExtensibleProviderFactory((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_PACKAGE__CHILD_CREATION_EXTENDERS:
				setChildCreationExtenders((Boolean)newValue);
				return;
			case GenmodelPackage.GEN_PACKAGE__CONTENT_TYPE_IDENTIFIER:
				setContentTypeIdentifier((String)newValue);
				return;
			case GenmodelPackage.GEN_PACKAGE__FILE_EXTENSIONS:
				setFileExtensions((String)newValue);
				return;
			case GenmodelPackage.GEN_PACKAGE__ECORE_PACKAGE:
				setEcorePackage((EPackage)newValue);
				return;
			case GenmodelPackage.GEN_PACKAGE__GEN_MODEL:
				setGenModel((GenModel)newValue);
				return;
			case GenmodelPackage.GEN_PACKAGE__GEN_ENUMS:
				getGenEnums().clear();
				getGenEnums().addAll((Collection<? extends GenEnum>)newValue);
				return;
			case GenmodelPackage.GEN_PACKAGE__GEN_DATA_TYPES:
				getGenDataTypes().clear();
				getGenDataTypes().addAll((Collection<? extends GenDataType>)newValue);
				return;
			case GenmodelPackage.GEN_PACKAGE__GEN_CLASSES:
				getGenClasses().clear();
				getGenClasses().addAll((Collection<? extends GenClass>)newValue);
				return;
			case GenmodelPackage.GEN_PACKAGE__NESTED_GEN_PACKAGES:
				getNestedGenPackages().clear();
				getNestedGenPackages().addAll((Collection<? extends GenPackage>)newValue);
				return;
			case GenmodelPackage.GEN_PACKAGE__PUBLICATION_LOCATION:
				setPublicationLocation((String)newValue);
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
			case GenmodelPackage.GEN_PACKAGE__PREFIX:
				setPrefix(PREFIX_EDEFAULT);
				return;
			case GenmodelPackage.GEN_PACKAGE__BASE_PACKAGE:
				setBasePackage(BASE_PACKAGE_EDEFAULT);
				return;
			case GenmodelPackage.GEN_PACKAGE__RESOURCE:
				setResource(RESOURCE_EDEFAULT);
				return;
			case GenmodelPackage.GEN_PACKAGE__DISPOSABLE_PROVIDER_FACTORY:
				setDisposableProviderFactory(DISPOSABLE_PROVIDER_FACTORY_EDEFAULT);
				return;
			case GenmodelPackage.GEN_PACKAGE__ADAPTER_FACTORY:
				setAdapterFactory(ADAPTER_FACTORY_EDEFAULT);
				return;
			case GenmodelPackage.GEN_PACKAGE__LOAD_INITIALIZATION:
				setLoadInitialization(LOAD_INITIALIZATION_EDEFAULT);
				return;
			case GenmodelPackage.GEN_PACKAGE__INTERFACE_PACKAGE_SUFFIX:
				setInterfacePackageSuffix(INTERFACE_PACKAGE_SUFFIX_EDEFAULT);
				return;
			case GenmodelPackage.GEN_PACKAGE__META_DATA_PACKAGE_SUFFIX:
				setMetaDataPackageSuffix(META_DATA_PACKAGE_SUFFIX_EDEFAULT);
				return;
			case GenmodelPackage.GEN_PACKAGE__CLASS_PACKAGE_SUFFIX:
				setClassPackageSuffix(CLASS_PACKAGE_SUFFIX_EDEFAULT);
				return;
			case GenmodelPackage.GEN_PACKAGE__UTILITY_PACKAGE_SUFFIX:
				setUtilityPackageSuffix(UTILITY_PACKAGE_SUFFIX_EDEFAULT);
				return;
			case GenmodelPackage.GEN_PACKAGE__PROVIDER_PACKAGE_SUFFIX:
				setProviderPackageSuffix(PROVIDER_PACKAGE_SUFFIX_EDEFAULT);
				return;
			case GenmodelPackage.GEN_PACKAGE__PRESENTATION_PACKAGE_SUFFIX:
				setPresentationPackageSuffix(PRESENTATION_PACKAGE_SUFFIX_EDEFAULT);
				return;
			case GenmodelPackage.GEN_PACKAGE__TESTS_PACKAGE_SUFFIX:
				setTestsPackageSuffix(TESTS_PACKAGE_SUFFIX_EDEFAULT);
				return;
			case GenmodelPackage.GEN_PACKAGE__GENERATE_EXAMPLE_CLASS:
				setGenerateExampleClass(GENERATE_EXAMPLE_CLASS_EDEFAULT);
				return;
			case GenmodelPackage.GEN_PACKAGE__LITERALS_INTERFACE:
				setLiteralsInterface(LITERALS_INTERFACE_EDEFAULT);
				return;
			case GenmodelPackage.GEN_PACKAGE__DATA_TYPE_CONVERTERS:
				setDataTypeConverters(DATA_TYPE_CONVERTERS_EDEFAULT);
				return;
			case GenmodelPackage.GEN_PACKAGE__MULTIPLE_EDITOR_PAGES:
				setMultipleEditorPages(MULTIPLE_EDITOR_PAGES_EDEFAULT);
				return;
			case GenmodelPackage.GEN_PACKAGE__GENERATE_MODEL_WIZARD:
				setGenerateModelWizard(GENERATE_MODEL_WIZARD_EDEFAULT);
				return;
			case GenmodelPackage.GEN_PACKAGE__EXTENSIBLE_PROVIDER_FACTORY:
				setExtensibleProviderFactory(EXTENSIBLE_PROVIDER_FACTORY_EDEFAULT);
				return;
			case GenmodelPackage.GEN_PACKAGE__CHILD_CREATION_EXTENDERS:
				setChildCreationExtenders(CHILD_CREATION_EXTENDERS_EDEFAULT);
				return;
			case GenmodelPackage.GEN_PACKAGE__CONTENT_TYPE_IDENTIFIER:
				setContentTypeIdentifier(CONTENT_TYPE_IDENTIFIER_EDEFAULT);
				return;
			case GenmodelPackage.GEN_PACKAGE__FILE_EXTENSIONS:
				setFileExtensions(FILE_EXTENSIONS_EDEFAULT);
				return;
			case GenmodelPackage.GEN_PACKAGE__ECORE_PACKAGE:
				setEcorePackage((EPackage)null);
				return;
			case GenmodelPackage.GEN_PACKAGE__GEN_MODEL:
				setGenModel((GenModel)null);
				return;
			case GenmodelPackage.GEN_PACKAGE__GEN_ENUMS:
				getGenEnums().clear();
				return;
			case GenmodelPackage.GEN_PACKAGE__GEN_DATA_TYPES:
				getGenDataTypes().clear();
				return;
			case GenmodelPackage.GEN_PACKAGE__GEN_CLASSES:
				getGenClasses().clear();
				return;
			case GenmodelPackage.GEN_PACKAGE__NESTED_GEN_PACKAGES:
				getNestedGenPackages().clear();
				return;
			case GenmodelPackage.GEN_PACKAGE__PUBLICATION_LOCATION:
				setPublicationLocation(PUBLICATION_LOCATION_EDEFAULT);
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
			case GenmodelPackage.GEN_PACKAGE__PREFIX:
				return PREFIX_EDEFAULT == null ? prefix != null : !PREFIX_EDEFAULT.equals(prefix);
			case GenmodelPackage.GEN_PACKAGE__BASE_PACKAGE:
				return BASE_PACKAGE_EDEFAULT == null ? basePackage != null : !BASE_PACKAGE_EDEFAULT.equals(basePackage);
			case GenmodelPackage.GEN_PACKAGE__RESOURCE:
				return resource != RESOURCE_EDEFAULT;
			case GenmodelPackage.GEN_PACKAGE__DISPOSABLE_PROVIDER_FACTORY:
				return disposableProviderFactory != DISPOSABLE_PROVIDER_FACTORY_EDEFAULT;
			case GenmodelPackage.GEN_PACKAGE__ADAPTER_FACTORY:
				return adapterFactory != ADAPTER_FACTORY_EDEFAULT;
			case GenmodelPackage.GEN_PACKAGE__LOAD_INITIALIZATION:
				return loadInitialization != LOAD_INITIALIZATION_EDEFAULT;
			case GenmodelPackage.GEN_PACKAGE__INTERFACE_PACKAGE_SUFFIX:
				return INTERFACE_PACKAGE_SUFFIX_EDEFAULT == null ? interfacePackageSuffix != null : !INTERFACE_PACKAGE_SUFFIX_EDEFAULT.equals(interfacePackageSuffix);
			case GenmodelPackage.GEN_PACKAGE__META_DATA_PACKAGE_SUFFIX:
				return META_DATA_PACKAGE_SUFFIX_EDEFAULT == null ? metaDataPackageSuffix != null : !META_DATA_PACKAGE_SUFFIX_EDEFAULT.equals(metaDataPackageSuffix);
			case GenmodelPackage.GEN_PACKAGE__CLASS_PACKAGE_SUFFIX:
				return CLASS_PACKAGE_SUFFIX_EDEFAULT == null ? classPackageSuffix != null : !CLASS_PACKAGE_SUFFIX_EDEFAULT.equals(classPackageSuffix);
			case GenmodelPackage.GEN_PACKAGE__UTILITY_PACKAGE_SUFFIX:
				return UTILITY_PACKAGE_SUFFIX_EDEFAULT == null ? utilityPackageSuffix != null : !UTILITY_PACKAGE_SUFFIX_EDEFAULT.equals(utilityPackageSuffix);
			case GenmodelPackage.GEN_PACKAGE__PROVIDER_PACKAGE_SUFFIX:
				return PROVIDER_PACKAGE_SUFFIX_EDEFAULT == null ? providerPackageSuffix != null : !PROVIDER_PACKAGE_SUFFIX_EDEFAULT.equals(providerPackageSuffix);
			case GenmodelPackage.GEN_PACKAGE__PRESENTATION_PACKAGE_SUFFIX:
				return PRESENTATION_PACKAGE_SUFFIX_EDEFAULT == null ? presentationPackageSuffix != null : !PRESENTATION_PACKAGE_SUFFIX_EDEFAULT.equals(presentationPackageSuffix);
			case GenmodelPackage.GEN_PACKAGE__TESTS_PACKAGE_SUFFIX:
				return TESTS_PACKAGE_SUFFIX_EDEFAULT == null ? testsPackageSuffix != null : !TESTS_PACKAGE_SUFFIX_EDEFAULT.equals(testsPackageSuffix);
			case GenmodelPackage.GEN_PACKAGE__GENERATE_EXAMPLE_CLASS:
				return generateExampleClass != GENERATE_EXAMPLE_CLASS_EDEFAULT;
			case GenmodelPackage.GEN_PACKAGE__LITERALS_INTERFACE:
				return literalsInterface != LITERALS_INTERFACE_EDEFAULT;
			case GenmodelPackage.GEN_PACKAGE__DATA_TYPE_CONVERTERS:
				return dataTypeConverters != DATA_TYPE_CONVERTERS_EDEFAULT;
			case GenmodelPackage.GEN_PACKAGE__MULTIPLE_EDITOR_PAGES:
				return multipleEditorPages != MULTIPLE_EDITOR_PAGES_EDEFAULT;
			case GenmodelPackage.GEN_PACKAGE__GENERATE_MODEL_WIZARD:
				return generateModelWizard != GENERATE_MODEL_WIZARD_EDEFAULT;
			case GenmodelPackage.GEN_PACKAGE__EXTENSIBLE_PROVIDER_FACTORY:
				return extensibleProviderFactory != EXTENSIBLE_PROVIDER_FACTORY_EDEFAULT;
			case GenmodelPackage.GEN_PACKAGE__CHILD_CREATION_EXTENDERS:
				return childCreationExtenders != CHILD_CREATION_EXTENDERS_EDEFAULT;
			case GenmodelPackage.GEN_PACKAGE__CONTENT_TYPE_IDENTIFIER:
				return CONTENT_TYPE_IDENTIFIER_EDEFAULT == null ? contentTypeIdentifier != null : !CONTENT_TYPE_IDENTIFIER_EDEFAULT.equals(contentTypeIdentifier);
			case GenmodelPackage.GEN_PACKAGE__FILE_EXTENSIONS:
				return FILE_EXTENSIONS_EDEFAULT == null ? fileExtensions != null : !FILE_EXTENSIONS_EDEFAULT.equals(fileExtensions);
			case GenmodelPackage.GEN_PACKAGE__ECORE_PACKAGE:
				return ecorePackage != null;
			case GenmodelPackage.GEN_PACKAGE__GEN_MODEL:
				return getGenModel() != null;
			case GenmodelPackage.GEN_PACKAGE__GEN_ENUMS:
				return genEnums != null && !genEnums.isEmpty();
			case GenmodelPackage.GEN_PACKAGE__GEN_DATA_TYPES:
				return genDataTypes != null && !genDataTypes.isEmpty();
			case GenmodelPackage.GEN_PACKAGE__GEN_CLASSES:
				return genClasses != null && !genClasses.isEmpty();
			case GenmodelPackage.GEN_PACKAGE__NESTED_GEN_PACKAGES:
				return nestedGenPackages != null && !nestedGenPackages.isEmpty();
			case GenmodelPackage.GEN_PACKAGE__GEN_CLASSIFIERS:
				return !getGenClassifiers().isEmpty();
			case GenmodelPackage.GEN_PACKAGE__PUBLICATION_LOCATION:
				return PUBLICATION_LOCATION_EDEFAULT == null ? publicationLocation != null : !PUBLICATION_LOCATION_EDEFAULT.equals(publicationLocation);
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
		result.append(" (prefix: ");
		result.append(prefix);
		result.append(", basePackage: ");
		result.append(basePackage);
		result.append(", resource: ");
		result.append(resource);
		result.append(", disposableProviderFactory: ");
		result.append(disposableProviderFactory);
		result.append(", adapterFactory: ");
		result.append(adapterFactory);
		result.append(", loadInitialization: ");
		result.append(loadInitialization);
		result.append(", interfacePackageSuffix: ");
		result.append(interfacePackageSuffix);
		result.append(", metaDataPackageSuffix: ");
		result.append(metaDataPackageSuffix);
		result.append(", classPackageSuffix: ");
		result.append(classPackageSuffix);
		result.append(", utilityPackageSuffix: ");
		result.append(utilityPackageSuffix);
		result.append(", providerPackageSuffix: ");
		result.append(providerPackageSuffix);
		result.append(", presentationPackageSuffix: ");
		result.append(presentationPackageSuffix);
		result.append(", testsPackageSuffix: ");
		result.append(testsPackageSuffix);
		result.append(", generateExampleClass: ");
		result.append(generateExampleClass);
		result.append(", literalsInterface: ");
		result.append(literalsInterface);
		result.append(", dataTypeConverters: ");
		result.append(dataTypeConverters);
		result.append(", multipleEditorPages: ");
		result.append(multipleEditorPages);
		result.append(", generateModelWizard: ");
		result.append(generateModelWizard);
		result.append(", extensibleProviderFactory: ");
		result.append(extensibleProviderFactory);
		result.append(", childCreationExtenders: ");
		result.append(childCreationExtenders);
		result.append(", contentTypeIdentifier: ");
		result.append(contentTypeIdentifier);
		result.append(", fileExtensions: ");
		result.append(fileExtensions);
		result.append(", publicationLocation: ");
		result.append(publicationLocation);
		result.append(')');
		return result.toString();
	}

} //GenPackageImpl
