/**
 */
package genmodel.util;

import genmodel.*;

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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see genmodel.GenmodelPackage
 * @generated
 */
public class GenmodelSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GenmodelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenmodelSwitch() {
		if (modelPackage == null) {
			modelPackage = GenmodelPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case GenmodelPackage.GEN_MODEL: {
				GenModel genModel = (GenModel)theEObject;
				T result = caseGenModel(genModel);
				if (result == null) result = caseGenBase(genModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GenmodelPackage.GEN_PACKAGE: {
				GenPackage genPackage = (GenPackage)theEObject;
				T result = caseGenPackage(genPackage);
				if (result == null) result = caseGenBase(genPackage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GenmodelPackage.GEN_CLASS: {
				GenClass genClass = (GenClass)theEObject;
				T result = caseGenClass(genClass);
				if (result == null) result = caseGenClassifier(genClass);
				if (result == null) result = caseGenBase(genClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GenmodelPackage.GEN_FEATURE: {
				GenFeature genFeature = (GenFeature)theEObject;
				T result = caseGenFeature(genFeature);
				if (result == null) result = caseGenTypedElement(genFeature);
				if (result == null) result = caseGenBase(genFeature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GenmodelPackage.GEN_BASE: {
				GenBase genBase = (GenBase)theEObject;
				T result = caseGenBase(genBase);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GenmodelPackage.GEN_ENUM: {
				GenEnum genEnum = (GenEnum)theEObject;
				T result = caseGenEnum(genEnum);
				if (result == null) result = caseGenDataType(genEnum);
				if (result == null) result = caseGenClassifier(genEnum);
				if (result == null) result = caseGenBase(genEnum);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GenmodelPackage.GEN_ENUM_LITERAL: {
				GenEnumLiteral genEnumLiteral = (GenEnumLiteral)theEObject;
				T result = caseGenEnumLiteral(genEnumLiteral);
				if (result == null) result = caseGenBase(genEnumLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GenmodelPackage.GEN_CLASSIFIER: {
				GenClassifier genClassifier = (GenClassifier)theEObject;
				T result = caseGenClassifier(genClassifier);
				if (result == null) result = caseGenBase(genClassifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GenmodelPackage.GEN_DATA_TYPE: {
				GenDataType genDataType = (GenDataType)theEObject;
				T result = caseGenDataType(genDataType);
				if (result == null) result = caseGenClassifier(genDataType);
				if (result == null) result = caseGenBase(genDataType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GenmodelPackage.GEN_OPERATION: {
				GenOperation genOperation = (GenOperation)theEObject;
				T result = caseGenOperation(genOperation);
				if (result == null) result = caseGenTypedElement(genOperation);
				if (result == null) result = caseGenBase(genOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GenmodelPackage.GEN_PARAMETER: {
				GenParameter genParameter = (GenParameter)theEObject;
				T result = caseGenParameter(genParameter);
				if (result == null) result = caseGenTypedElement(genParameter);
				if (result == null) result = caseGenBase(genParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GenmodelPackage.GEN_TYPED_ELEMENT: {
				GenTypedElement genTypedElement = (GenTypedElement)theEObject;
				T result = caseGenTypedElement(genTypedElement);
				if (result == null) result = caseGenBase(genTypedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GenmodelPackage.GEN_ANNOTATION: {
				GenAnnotation genAnnotation = (GenAnnotation)theEObject;
				T result = caseGenAnnotation(genAnnotation);
				if (result == null) result = caseGenBase(genAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GenmodelPackage.GEN_TYPE_PARAMETER: {
				GenTypeParameter genTypeParameter = (GenTypeParameter)theEObject;
				T result = caseGenTypeParameter(genTypeParameter);
				if (result == null) result = caseGenBase(genTypeParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenModel(GenModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Package</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Package</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenPackage(GenPackage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenClass(GenClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenFeature(GenFeature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Base</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Base</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenBase(GenBase object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Enum</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Enum</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenEnum(GenEnum object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Enum Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Enum Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenEnumLiteral(GenEnumLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Classifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Classifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenClassifier(GenClassifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Data Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenDataType(GenDataType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenOperation(GenOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenParameter(GenParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Typed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Typed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenTypedElement(GenTypedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenAnnotation(GenAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Type Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Type Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenTypeParameter(GenTypeParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //GenmodelSwitch
