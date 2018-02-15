/**
 */
package genmodel;

import org.eclipse.emf.codegen.ecore.genmodel.GenBase;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenDataType;
import org.eclipse.emf.codegen.ecore.genmodel.GenEnum;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getBasePackage <em>Base Package</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getResource <em>Resource</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#isDisposableProviderFactory <em>Disposable Provider Factory</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#isAdapterFactory <em>Adapter Factory</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#isLoadInitialization <em>Load Initialization</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getInterfacePackageSuffix <em>Interface Package Suffix</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getMetaDataPackageSuffix <em>Meta Data Package Suffix</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getClassPackageSuffix <em>Class Package Suffix</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getUtilityPackageSuffix <em>Utility Package Suffix</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getProviderPackageSuffix <em>Provider Package Suffix</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getPresentationPackageSuffix <em>Presentation Package Suffix</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getTestsPackageSuffix <em>Tests Package Suffix</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#isGenerateExampleClass <em>Generate Example Class</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#isLiteralsInterface <em>Literals Interface</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#isDataTypeConverters <em>Data Type Converters</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#isMultipleEditorPages <em>Multiple Editor Pages</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#isGenerateModelWizard <em>Generate Model Wizard</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#isExtensibleProviderFactory <em>Extensible Provider Factory</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#isChildCreationExtenders <em>Child Creation Extenders</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getContentTypeIdentifier <em>Content Type Identifier</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getFileExtensions <em>File Extensions</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getEcorePackage <em>Ecore Package</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getGenModel <em>Gen Model</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getGenEnums <em>Gen Enums</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getGenDataTypes <em>Gen Data Types</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getGenClasses <em>Gen Classes</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getNestedGenPackages <em>Nested Gen Packages</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getGenClassifiers <em>Gen Classifiers</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getPublicationLocation <em>Publication Location</em>}</li>
 * </ul>
 *
 * @see genmodel.GenmodelPackage#getGenPackage()
 * @model
 * @generated
 */
public interface GenPackage extends EObject, GenBase {
	/**
	 * Returns the value of the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prefix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prefix</em>' attribute.
	 * @see #setPrefix(String)
	 * @see genmodel.GenmodelPackage#getGenPackage_Prefix()
	 * @model
	 * @generated
	 */
	String getPrefix();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getPrefix <em>Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prefix</em>' attribute.
	 * @see #getPrefix()
	 * @generated
	 */
	void setPrefix(String value);

	/**
	 * Returns the value of the '<em><b>Base Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Package</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Package</em>' attribute.
	 * @see #setBasePackage(String)
	 * @see genmodel.GenmodelPackage#getGenPackage_BasePackage()
	 * @model
	 * @generated
	 */
	String getBasePackage();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getBasePackage <em>Base Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Package</em>' attribute.
	 * @see #getBasePackage()
	 * @generated
	 */
	void setBasePackage(String value);

	/**
	 * Returns the value of the '<em><b>Resource</b></em>' attribute.
	 * The literals are from the enumeration {@link genmodel.GenResourceKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource</em>' attribute.
	 * @see genmodel.GenResourceKind
	 * @see #setResource(GenResourceKind)
	 * @see genmodel.GenmodelPackage#getGenPackage_Resource()
	 * @model
	 * @generated
	 */
	GenResourceKind getResource();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getResource <em>Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource</em>' attribute.
	 * @see genmodel.GenResourceKind
	 * @see #getResource()
	 * @generated
	 */
	void setResource(GenResourceKind value);

	/**
	 * Returns the value of the '<em><b>Disposable Provider Factory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Disposable Provider Factory</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Disposable Provider Factory</em>' attribute.
	 * @see #setDisposableProviderFactory(boolean)
	 * @see genmodel.GenmodelPackage#getGenPackage_DisposableProviderFactory()
	 * @model
	 * @generated
	 */
	boolean isDisposableProviderFactory();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#isDisposableProviderFactory <em>Disposable Provider Factory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Disposable Provider Factory</em>' attribute.
	 * @see #isDisposableProviderFactory()
	 * @generated
	 */
	void setDisposableProviderFactory(boolean value);

	/**
	 * Returns the value of the '<em><b>Adapter Factory</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Adapter Factory</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Adapter Factory</em>' attribute.
	 * @see #setAdapterFactory(boolean)
	 * @see genmodel.GenmodelPackage#getGenPackage_AdapterFactory()
	 * @model default="true"
	 * @generated
	 */
	boolean isAdapterFactory();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#isAdapterFactory <em>Adapter Factory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Adapter Factory</em>' attribute.
	 * @see #isAdapterFactory()
	 * @generated
	 */
	void setAdapterFactory(boolean value);

	/**
	 * Returns the value of the '<em><b>Load Initialization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Load Initialization</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Load Initialization</em>' attribute.
	 * @see #setLoadInitialization(boolean)
	 * @see genmodel.GenmodelPackage#getGenPackage_LoadInitialization()
	 * @model
	 * @generated
	 */
	boolean isLoadInitialization();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#isLoadInitialization <em>Load Initialization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Load Initialization</em>' attribute.
	 * @see #isLoadInitialization()
	 * @generated
	 */
	void setLoadInitialization(boolean value);

	/**
	 * Returns the value of the '<em><b>Interface Package Suffix</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interface Package Suffix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interface Package Suffix</em>' attribute.
	 * @see #setInterfacePackageSuffix(String)
	 * @see genmodel.GenmodelPackage#getGenPackage_InterfacePackageSuffix()
	 * @model default=""
	 * @generated
	 */
	String getInterfacePackageSuffix();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getInterfacePackageSuffix <em>Interface Package Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface Package Suffix</em>' attribute.
	 * @see #getInterfacePackageSuffix()
	 * @generated
	 */
	void setInterfacePackageSuffix(String value);

	/**
	 * Returns the value of the '<em><b>Meta Data Package Suffix</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Data Package Suffix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Data Package Suffix</em>' attribute.
	 * @see #setMetaDataPackageSuffix(String)
	 * @see genmodel.GenmodelPackage#getGenPackage_MetaDataPackageSuffix()
	 * @model default=""
	 * @generated
	 */
	String getMetaDataPackageSuffix();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getMetaDataPackageSuffix <em>Meta Data Package Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta Data Package Suffix</em>' attribute.
	 * @see #getMetaDataPackageSuffix()
	 * @generated
	 */
	void setMetaDataPackageSuffix(String value);

	/**
	 * Returns the value of the '<em><b>Class Package Suffix</b></em>' attribute.
	 * The default value is <code>"impl"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Package Suffix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Package Suffix</em>' attribute.
	 * @see #setClassPackageSuffix(String)
	 * @see genmodel.GenmodelPackage#getGenPackage_ClassPackageSuffix()
	 * @model default="impl"
	 * @generated
	 */
	String getClassPackageSuffix();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getClassPackageSuffix <em>Class Package Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Package Suffix</em>' attribute.
	 * @see #getClassPackageSuffix()
	 * @generated
	 */
	void setClassPackageSuffix(String value);

	/**
	 * Returns the value of the '<em><b>Utility Package Suffix</b></em>' attribute.
	 * The default value is <code>"util"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Utility Package Suffix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Utility Package Suffix</em>' attribute.
	 * @see #setUtilityPackageSuffix(String)
	 * @see genmodel.GenmodelPackage#getGenPackage_UtilityPackageSuffix()
	 * @model default="util"
	 * @generated
	 */
	String getUtilityPackageSuffix();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getUtilityPackageSuffix <em>Utility Package Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Utility Package Suffix</em>' attribute.
	 * @see #getUtilityPackageSuffix()
	 * @generated
	 */
	void setUtilityPackageSuffix(String value);

	/**
	 * Returns the value of the '<em><b>Provider Package Suffix</b></em>' attribute.
	 * The default value is <code>"provider"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provider Package Suffix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provider Package Suffix</em>' attribute.
	 * @see #setProviderPackageSuffix(String)
	 * @see genmodel.GenmodelPackage#getGenPackage_ProviderPackageSuffix()
	 * @model default="provider"
	 * @generated
	 */
	String getProviderPackageSuffix();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getProviderPackageSuffix <em>Provider Package Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provider Package Suffix</em>' attribute.
	 * @see #getProviderPackageSuffix()
	 * @generated
	 */
	void setProviderPackageSuffix(String value);

	/**
	 * Returns the value of the '<em><b>Presentation Package Suffix</b></em>' attribute.
	 * The default value is <code>"presentation"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Presentation Package Suffix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Presentation Package Suffix</em>' attribute.
	 * @see #setPresentationPackageSuffix(String)
	 * @see genmodel.GenmodelPackage#getGenPackage_PresentationPackageSuffix()
	 * @model default="presentation"
	 * @generated
	 */
	String getPresentationPackageSuffix();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getPresentationPackageSuffix <em>Presentation Package Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Presentation Package Suffix</em>' attribute.
	 * @see #getPresentationPackageSuffix()
	 * @generated
	 */
	void setPresentationPackageSuffix(String value);

	/**
	 * Returns the value of the '<em><b>Tests Package Suffix</b></em>' attribute.
	 * The default value is <code>"tests"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tests Package Suffix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tests Package Suffix</em>' attribute.
	 * @see #setTestsPackageSuffix(String)
	 * @see genmodel.GenmodelPackage#getGenPackage_TestsPackageSuffix()
	 * @model default="tests"
	 * @generated
	 */
	String getTestsPackageSuffix();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getTestsPackageSuffix <em>Tests Package Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tests Package Suffix</em>' attribute.
	 * @see #getTestsPackageSuffix()
	 * @generated
	 */
	void setTestsPackageSuffix(String value);

	/**
	 * Returns the value of the '<em><b>Generate Example Class</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generate Example Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generate Example Class</em>' attribute.
	 * @see #setGenerateExampleClass(boolean)
	 * @see genmodel.GenmodelPackage#getGenPackage_GenerateExampleClass()
	 * @model default="true"
	 * @generated
	 */
	boolean isGenerateExampleClass();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#isGenerateExampleClass <em>Generate Example Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generate Example Class</em>' attribute.
	 * @see #isGenerateExampleClass()
	 * @generated
	 */
	void setGenerateExampleClass(boolean value);

	/**
	 * Returns the value of the '<em><b>Literals Interface</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literals Interface</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literals Interface</em>' attribute.
	 * @see #setLiteralsInterface(boolean)
	 * @see genmodel.GenmodelPackage#getGenPackage_LiteralsInterface()
	 * @model default="true"
	 * @generated
	 */
	boolean isLiteralsInterface();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#isLiteralsInterface <em>Literals Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Literals Interface</em>' attribute.
	 * @see #isLiteralsInterface()
	 * @generated
	 */
	void setLiteralsInterface(boolean value);

	/**
	 * Returns the value of the '<em><b>Data Type Converters</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Type Converters</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Type Converters</em>' attribute.
	 * @see #setDataTypeConverters(boolean)
	 * @see genmodel.GenmodelPackage#getGenPackage_DataTypeConverters()
	 * @model
	 * @generated
	 */
	boolean isDataTypeConverters();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#isDataTypeConverters <em>Data Type Converters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Type Converters</em>' attribute.
	 * @see #isDataTypeConverters()
	 * @generated
	 */
	void setDataTypeConverters(boolean value);

	/**
	 * Returns the value of the '<em><b>Multiple Editor Pages</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multiple Editor Pages</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multiple Editor Pages</em>' attribute.
	 * @see #setMultipleEditorPages(boolean)
	 * @see genmodel.GenmodelPackage#getGenPackage_MultipleEditorPages()
	 * @model default="true"
	 * @generated
	 */
	boolean isMultipleEditorPages();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#isMultipleEditorPages <em>Multiple Editor Pages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multiple Editor Pages</em>' attribute.
	 * @see #isMultipleEditorPages()
	 * @generated
	 */
	void setMultipleEditorPages(boolean value);

	/**
	 * Returns the value of the '<em><b>Generate Model Wizard</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generate Model Wizard</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generate Model Wizard</em>' attribute.
	 * @see #setGenerateModelWizard(boolean)
	 * @see genmodel.GenmodelPackage#getGenPackage_GenerateModelWizard()
	 * @model default="true"
	 * @generated
	 */
	boolean isGenerateModelWizard();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#isGenerateModelWizard <em>Generate Model Wizard</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generate Model Wizard</em>' attribute.
	 * @see #isGenerateModelWizard()
	 * @generated
	 */
	void setGenerateModelWizard(boolean value);

	/**
	 * Returns the value of the '<em><b>Extensible Provider Factory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extensible Provider Factory</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extensible Provider Factory</em>' attribute.
	 * @see #setExtensibleProviderFactory(boolean)
	 * @see genmodel.GenmodelPackage#getGenPackage_ExtensibleProviderFactory()
	 * @model
	 * @generated
	 */
	boolean isExtensibleProviderFactory();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#isExtensibleProviderFactory <em>Extensible Provider Factory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extensible Provider Factory</em>' attribute.
	 * @see #isExtensibleProviderFactory()
	 * @generated
	 */
	void setExtensibleProviderFactory(boolean value);

	/**
	 * Returns the value of the '<em><b>Child Creation Extenders</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child Creation Extenders</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Child Creation Extenders</em>' attribute.
	 * @see #setChildCreationExtenders(boolean)
	 * @see genmodel.GenmodelPackage#getGenPackage_ChildCreationExtenders()
	 * @model
	 * @generated
	 */
	boolean isChildCreationExtenders();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#isChildCreationExtenders <em>Child Creation Extenders</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Child Creation Extenders</em>' attribute.
	 * @see #isChildCreationExtenders()
	 * @generated
	 */
	void setChildCreationExtenders(boolean value);

	/**
	 * Returns the value of the '<em><b>Content Type Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content Type Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content Type Identifier</em>' attribute.
	 * @see #setContentTypeIdentifier(String)
	 * @see genmodel.GenmodelPackage#getGenPackage_ContentTypeIdentifier()
	 * @model
	 * @generated
	 */
	String getContentTypeIdentifier();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getContentTypeIdentifier <em>Content Type Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content Type Identifier</em>' attribute.
	 * @see #getContentTypeIdentifier()
	 * @generated
	 */
	void setContentTypeIdentifier(String value);

	/**
	 * Returns the value of the '<em><b>File Extensions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Extensions</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File Extensions</em>' attribute.
	 * @see #setFileExtensions(String)
	 * @see genmodel.GenmodelPackage#getGenPackage_FileExtensions()
	 * @model
	 * @generated
	 */
	String getFileExtensions();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getFileExtensions <em>File Extensions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Extensions</em>' attribute.
	 * @see #getFileExtensions()
	 * @generated
	 */
	void setFileExtensions(String value);

	/**
	 * Returns the value of the '<em><b>Ecore Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ecore Package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ecore Package</em>' reference.
	 * @see #setEcorePackage(EPackage)
	 * @see genmodel.GenmodelPackage#getGenPackage_EcorePackage()
	 * @model required="true"
	 * @generated
	 */
	EPackage getEcorePackage();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getEcorePackage <em>Ecore Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ecore Package</em>' reference.
	 * @see #getEcorePackage()
	 * @generated
	 */
	void setEcorePackage(EPackage value);

	/**
	 * Returns the value of the '<em><b>Gen Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.codegen.ecore.genmodel.GenModel#getGenPackages <em>Gen Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gen Model</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gen Model</em>' container reference.
	 * @see #setGenModel(GenModel)
	 * @see genmodel.GenmodelPackage#getGenPackage_GenModel()
	 * @see org.eclipse.emf.codegen.ecore.genmodel.GenModel#getGenPackages
	 * @model opposite="genPackages" resolveProxies="false"
	 * @generated
	 */
	GenModel getGenModel();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getGenModel <em>Gen Model</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gen Model</em>' container reference.
	 * @see #getGenModel()
	 * @generated
	 */
	void setGenModel(GenModel value);

	/**
	 * Returns the value of the '<em><b>Gen Enums</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.codegen.ecore.genmodel.GenEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gen Enums</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gen Enums</em>' containment reference list.
	 * @see genmodel.GenmodelPackage#getGenPackage_GenEnums()
	 * @model containment="true"
	 * @generated
	 */
	EList<GenEnum> getGenEnums();

	/**
	 * Returns the value of the '<em><b>Gen Data Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.codegen.ecore.genmodel.GenDataType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gen Data Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gen Data Types</em>' containment reference list.
	 * @see genmodel.GenmodelPackage#getGenPackage_GenDataTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<GenDataType> getGenDataTypes();

	/**
	 * Returns the value of the '<em><b>Gen Classes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.codegen.ecore.genmodel.GenClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gen Classes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gen Classes</em>' containment reference list.
	 * @see genmodel.GenmodelPackage#getGenPackage_GenClasses()
	 * @model containment="true"
	 * @generated
	 */
	EList<GenClass> getGenClasses();

	/**
	 * Returns the value of the '<em><b>Nested Gen Packages</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nested Gen Packages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nested Gen Packages</em>' containment reference list.
	 * @see genmodel.GenmodelPackage#getGenPackage_NestedGenPackages()
	 * @model containment="true"
	 * @generated
	 */
	EList<org.eclipse.emf.codegen.ecore.genmodel.GenPackage> getNestedGenPackages();

	/**
	 * Returns the value of the '<em><b>Gen Classifiers</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.codegen.ecore.genmodel.GenClassifier}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.codegen.ecore.genmodel.GenClassifier#getGenPackage <em>Gen Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gen Classifiers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gen Classifiers</em>' reference list.
	 * @see genmodel.GenmodelPackage#getGenPackage_GenClassifiers()
	 * @see org.eclipse.emf.codegen.ecore.genmodel.GenClassifier#getGenPackage
	 * @model opposite="genPackage" resolveProxies="false" transient="true" changeable="false" volatile="true"
	 * @generated
	 */
	EList<GenClassifier> getGenClassifiers();

	/**
	 * Returns the value of the '<em><b>Publication Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Publication Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Publication Location</em>' attribute.
	 * @see #setPublicationLocation(String)
	 * @see genmodel.GenmodelPackage#getGenPackage_PublicationLocation()
	 * @model
	 * @generated
	 */
	String getPublicationLocation();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getPublicationLocation <em>Publication Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Publication Location</em>' attribute.
	 * @see #getPublicationLocation()
	 * @generated
	 */
	void setPublicationLocation(String value);

} // GenPackage
