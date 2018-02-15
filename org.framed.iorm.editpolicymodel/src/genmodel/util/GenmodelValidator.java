/**
 */
package genmodel.util;

import genmodel.*;

import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenAnnotation;
import org.eclipse.emf.codegen.ecore.genmodel.GenBase;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenDataType;
import org.eclipse.emf.codegen.ecore.genmodel.GenEnum;
import org.eclipse.emf.codegen.ecore.genmodel.GenEnumLiteral;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenOperation;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenParameter;
import org.eclipse.emf.codegen.ecore.genmodel.GenTypeParameter;
import org.eclipse.emf.codegen.ecore.genmodel.GenTypedElement;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see genmodel.GenmodelPackage
 * @generated
 */
public class GenmodelValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final GenmodelValidator INSTANCE = new GenmodelValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "genmodel";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenmodelValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return GenmodelPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case GenmodelPackage.GEN_MODEL:
				return validateGenModel((GenModel)value, diagnostics, context);
			case GenmodelPackage.GEN_PACKAGE:
				return validateGenPackage((GenPackage)value, diagnostics, context);
			case GenmodelPackage.GEN_CLASS:
				return validateGenClass((GenClass)value, diagnostics, context);
			case GenmodelPackage.GEN_FEATURE:
				return validateGenFeature((GenFeature)value, diagnostics, context);
			case GenmodelPackage.GEN_BASE:
				return validateGenBase((GenBase)value, diagnostics, context);
			case GenmodelPackage.GEN_ENUM:
				return validateGenEnum((GenEnum)value, diagnostics, context);
			case GenmodelPackage.GEN_ENUM_LITERAL:
				return validateGenEnumLiteral((GenEnumLiteral)value, diagnostics, context);
			case GenmodelPackage.GEN_CLASSIFIER:
				return validateGenClassifier((GenClassifier)value, diagnostics, context);
			case GenmodelPackage.GEN_DATA_TYPE:
				return validateGenDataType((GenDataType)value, diagnostics, context);
			case GenmodelPackage.GEN_OPERATION:
				return validateGenOperation((GenOperation)value, diagnostics, context);
			case GenmodelPackage.GEN_PARAMETER:
				return validateGenParameter((GenParameter)value, diagnostics, context);
			case GenmodelPackage.GEN_TYPED_ELEMENT:
				return validateGenTypedElement((GenTypedElement)value, diagnostics, context);
			case GenmodelPackage.GEN_ANNOTATION:
				return validateGenAnnotation((GenAnnotation)value, diagnostics, context);
			case GenmodelPackage.GEN_TYPE_PARAMETER:
				return validateGenTypeParameter((GenTypeParameter)value, diagnostics, context);
			case GenmodelPackage.GEN_PROVIDER_KIND:
				return validateGenProviderKind((GenProviderKind)value, diagnostics, context);
			case GenmodelPackage.GEN_PROPERTY_KIND:
				return validateGenPropertyKind((GenPropertyKind)value, diagnostics, context);
			case GenmodelPackage.GEN_RESOURCE_KIND:
				return validateGenResourceKind((GenResourceKind)value, diagnostics, context);
			case GenmodelPackage.GEN_DELEGATION_KIND:
				return validateGenDelegationKind((GenDelegationKind)value, diagnostics, context);
			case GenmodelPackage.GEN_JDK_LEVEL:
				return validateGenJDKLevel((GenJDKLevel)value, diagnostics, context);
			case GenmodelPackage.GEN_RUNTIME_VERSION:
				return validateGenRuntimeVersion((GenRuntimeVersion)value, diagnostics, context);
			case GenmodelPackage.GEN_RUNTIME_PLATFORM:
				return validateGenRuntimePlatform((GenRuntimePlatform)value, diagnostics, context);
			case GenmodelPackage.GEN_DECORATION:
				return validateGenDecoration((GenDecoration)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGenModel(GenModel genModel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(genModel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGenPackage(GenPackage genPackage, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(genPackage, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGenClass(GenClass genClass, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(genClass, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGenFeature(GenFeature genFeature, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(genFeature, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGenBase(GenBase genBase, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(genBase, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGenEnum(GenEnum genEnum, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(genEnum, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(genEnum, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(genEnum, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(genEnum, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(genEnum, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(genEnum, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(genEnum, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(genEnum, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(genEnum, diagnostics, context);
		if (result || diagnostics != null) result &= validateGenEnum_NoEcoreDataType(genEnum, diagnostics, context);
		return result;
	}

	/**
	 * Validates the NoEcoreDataType constraint of '<em>Gen Enum</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGenEnum_NoEcoreDataType(GenEnum genEnum, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "NoEcoreDataType", getObjectLabel(genEnum, context) },
						 new Object[] { genEnum },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGenEnumLiteral(GenEnumLiteral genEnumLiteral, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(genEnumLiteral, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGenClassifier(GenClassifier genClassifier, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(genClassifier, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGenDataType(GenDataType genDataType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(genDataType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGenOperation(GenOperation genOperation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(genOperation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGenParameter(GenParameter genParameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(genParameter, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGenTypedElement(GenTypedElement genTypedElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(genTypedElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGenAnnotation(GenAnnotation genAnnotation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(genAnnotation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGenTypeParameter(GenTypeParameter genTypeParameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(genTypeParameter, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGenProviderKind(GenProviderKind genProviderKind, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGenPropertyKind(GenPropertyKind genPropertyKind, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGenResourceKind(GenResourceKind genResourceKind, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGenDelegationKind(GenDelegationKind genDelegationKind, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGenJDKLevel(GenJDKLevel genJDKLevel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGenRuntimeVersion(GenRuntimeVersion genRuntimeVersion, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGenRuntimePlatform(GenRuntimePlatform genRuntimePlatform, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGenDecoration(GenDecoration genDecoration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //GenmodelValidator
