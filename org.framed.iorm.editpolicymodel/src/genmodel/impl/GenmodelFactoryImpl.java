/**
 */
package genmodel.impl;

import genmodel.*;

import org.eclipse.emf.codegen.ecore.genmodel.GenAnnotation;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenDataType;
import org.eclipse.emf.codegen.ecore.genmodel.GenEnum;
import org.eclipse.emf.codegen.ecore.genmodel.GenEnumLiteral;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenOperation;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenParameter;
import org.eclipse.emf.codegen.ecore.genmodel.GenTypeParameter;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GenmodelFactoryImpl extends EFactoryImpl implements GenmodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GenmodelFactory init() {
		try {
			GenmodelFactory theGenmodelFactory = (GenmodelFactory)EPackage.Registry.INSTANCE.getEFactory(GenmodelPackage.eNS_URI);
			if (theGenmodelFactory != null) {
				return theGenmodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GenmodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenmodelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case GenmodelPackage.GEN_MODEL: return createGenModel();
			case GenmodelPackage.GEN_PACKAGE: return createGenPackage();
			case GenmodelPackage.GEN_CLASS: return createGenClass();
			case GenmodelPackage.GEN_FEATURE: return createGenFeature();
			case GenmodelPackage.GEN_ENUM: return createGenEnum();
			case GenmodelPackage.GEN_ENUM_LITERAL: return createGenEnumLiteral();
			case GenmodelPackage.GEN_DATA_TYPE: return createGenDataType();
			case GenmodelPackage.GEN_OPERATION: return createGenOperation();
			case GenmodelPackage.GEN_PARAMETER: return createGenParameter();
			case GenmodelPackage.GEN_ANNOTATION: return createGenAnnotation();
			case GenmodelPackage.GEN_TYPE_PARAMETER: return createGenTypeParameter();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case GenmodelPackage.GEN_PROVIDER_KIND:
				return createGenProviderKindFromString(eDataType, initialValue);
			case GenmodelPackage.GEN_PROPERTY_KIND:
				return createGenPropertyKindFromString(eDataType, initialValue);
			case GenmodelPackage.GEN_RESOURCE_KIND:
				return createGenResourceKindFromString(eDataType, initialValue);
			case GenmodelPackage.GEN_DELEGATION_KIND:
				return createGenDelegationKindFromString(eDataType, initialValue);
			case GenmodelPackage.GEN_JDK_LEVEL:
				return createGenJDKLevelFromString(eDataType, initialValue);
			case GenmodelPackage.GEN_RUNTIME_VERSION:
				return createGenRuntimeVersionFromString(eDataType, initialValue);
			case GenmodelPackage.GEN_RUNTIME_PLATFORM:
				return createGenRuntimePlatformFromString(eDataType, initialValue);
			case GenmodelPackage.GEN_DECORATION:
				return createGenDecorationFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case GenmodelPackage.GEN_PROVIDER_KIND:
				return convertGenProviderKindToString(eDataType, instanceValue);
			case GenmodelPackage.GEN_PROPERTY_KIND:
				return convertGenPropertyKindToString(eDataType, instanceValue);
			case GenmodelPackage.GEN_RESOURCE_KIND:
				return convertGenResourceKindToString(eDataType, instanceValue);
			case GenmodelPackage.GEN_DELEGATION_KIND:
				return convertGenDelegationKindToString(eDataType, instanceValue);
			case GenmodelPackage.GEN_JDK_LEVEL:
				return convertGenJDKLevelToString(eDataType, instanceValue);
			case GenmodelPackage.GEN_RUNTIME_VERSION:
				return convertGenRuntimeVersionToString(eDataType, instanceValue);
			case GenmodelPackage.GEN_RUNTIME_PLATFORM:
				return convertGenRuntimePlatformToString(eDataType, instanceValue);
			case GenmodelPackage.GEN_DECORATION:
				return convertGenDecorationToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenModel createGenModel() {
		GenModelImpl genModel = new GenModelImpl();
		return genModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenPackage createGenPackage() {
		GenPackageImpl genPackage = new GenPackageImpl();
		return genPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenClass createGenClass() {
		GenClassImpl genClass = new GenClassImpl();
		return genClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenFeature createGenFeature() {
		GenFeatureImpl genFeature = new GenFeatureImpl();
		return genFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenEnum createGenEnum() {
		GenEnumImpl genEnum = new GenEnumImpl();
		return genEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenEnumLiteral createGenEnumLiteral() {
		GenEnumLiteralImpl genEnumLiteral = new GenEnumLiteralImpl();
		return genEnumLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenDataType createGenDataType() {
		GenDataTypeImpl genDataType = new GenDataTypeImpl();
		return genDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenOperation createGenOperation() {
		GenOperationImpl genOperation = new GenOperationImpl();
		return genOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenParameter createGenParameter() {
		GenParameterImpl genParameter = new GenParameterImpl();
		return genParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenAnnotation createGenAnnotation() {
		GenAnnotationImpl genAnnotation = new GenAnnotationImpl();
		return genAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenTypeParameter createGenTypeParameter() {
		GenTypeParameterImpl genTypeParameter = new GenTypeParameterImpl();
		return genTypeParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenProviderKind createGenProviderKindFromString(EDataType eDataType, String initialValue) {
		GenProviderKind result = GenProviderKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertGenProviderKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenPropertyKind createGenPropertyKindFromString(EDataType eDataType, String initialValue) {
		GenPropertyKind result = GenPropertyKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertGenPropertyKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenResourceKind createGenResourceKindFromString(EDataType eDataType, String initialValue) {
		GenResourceKind result = GenResourceKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertGenResourceKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenDelegationKind createGenDelegationKindFromString(EDataType eDataType, String initialValue) {
		GenDelegationKind result = GenDelegationKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertGenDelegationKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenJDKLevel createGenJDKLevelFromString(EDataType eDataType, String initialValue) {
		GenJDKLevel result = GenJDKLevel.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertGenJDKLevelToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenRuntimeVersion createGenRuntimeVersionFromString(EDataType eDataType, String initialValue) {
		GenRuntimeVersion result = GenRuntimeVersion.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertGenRuntimeVersionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenRuntimePlatform createGenRuntimePlatformFromString(EDataType eDataType, String initialValue) {
		GenRuntimePlatform result = GenRuntimePlatform.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertGenRuntimePlatformToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenDecoration createGenDecorationFromString(EDataType eDataType, String initialValue) {
		GenDecoration result = GenDecoration.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertGenDecorationToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenmodelPackage getGenmodelPackage() {
		return (GenmodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GenmodelPackage getPackage() {
		return GenmodelPackage.eINSTANCE;
	}

} //GenmodelFactoryImpl
