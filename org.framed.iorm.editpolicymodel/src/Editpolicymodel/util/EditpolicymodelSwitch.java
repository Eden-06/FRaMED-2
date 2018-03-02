/**
 */
package Editpolicymodel.util;

import Editpolicymodel.*;

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
 * @see Editpolicymodel.EditpolicymodelPackage
 * @generated
 */
public class EditpolicymodelSwitch<T1> extends Switch<T1> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EditpolicymodelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EditpolicymodelSwitch() {
		if (modelPackage == null) {
			modelPackage = EditpolicymodelPackage.eINSTANCE;
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
	protected T1 doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case EditpolicymodelPackage.MODEL: {
				Model model = (Model)theEObject;
				T1 result = caseModel(model);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.POLICY: {
				Policy policy = (Policy)theEObject;
				T1 result = casePolicy(policy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.CONTAINS: {
				Contains contains = (Contains)theEObject;
				T1 result = caseContains(contains);
				if (result == null) result = caseTypeArgumentRule(contains);
				if (result == null) result = caseConstraintRule(contains);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.IS_STEP_IN: {
				IsStepIn isStepIn = (IsStepIn)theEObject;
				T1 result = caseIsStepIn(isStepIn);
				if (result == null) result = caseConstraintRule(isStepIn);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.IS_TARGET: {
				IsTarget isTarget = (IsTarget)theEObject;
				T1 result = caseIsTarget(isTarget);
				if (result == null) result = caseTypeArgumentRule(isTarget);
				if (result == null) result = caseConstraintRule(isTarget);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.IS_SOURCE: {
				IsSource isSource = (IsSource)theEObject;
				T1 result = caseIsSource(isSource);
				if (result == null) result = caseTypeArgumentRule(isSource);
				if (result == null) result = caseConstraintRule(isSource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.IS_PARENT: {
				IsParent isParent = (IsParent)theEObject;
				T1 result = caseIsParent(isParent);
				if (result == null) result = caseTypeArgumentRule(isParent);
				if (result == null) result = caseConstraintRule(isParent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.ABSTRACT_RULE: {
				AbstractRule<?> abstractRule = (AbstractRule<?>)theEObject;
				T1 result = caseAbstractRule(abstractRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.RULE: {
				Rule<?> rule = (Rule<?>)theEObject;
				T1 result = caseRule(rule);
				if (result == null) result = (T1)caseAbstractRule(rule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.FEATURE_RULE: {
				FeatureRule featureRule = (FeatureRule)theEObject;
				T1 result = caseFeatureRule(featureRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.IS_FEATURE: {
				IsFeature isFeature = (IsFeature)theEObject;
				T1 result = caseIsFeature(isFeature);
				if (result == null) result = caseFeatureRule(isFeature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.CONSTRAINT_RULE: {
				ConstraintRule constraintRule = (ConstraintRule)theEObject;
				T1 result = caseConstraintRule(constraintRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.IS_TARGET_TYPE: {
				IsTargetType isTargetType = (IsTargetType)theEObject;
				T1 result = caseIsTargetType(isTargetType);
				if (result == null) result = caseTypeArgumentRule(isTargetType);
				if (result == null) result = caseConstraintRule(isTargetType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.UNARY_RULE: {
				UnaryRule<?> unaryRule = (UnaryRule<?>)theEObject;
				T1 result = caseUnaryRule(unaryRule);
				if (result == null) result = (T1)caseAbstractRule(unaryRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.NOT_RULE: {
				NotRule notRule = (NotRule)theEObject;
				T1 result = caseNotRule(notRule);
				if (result == null) result = (T1)caseUnaryRule(notRule);
				if (result == null) result = (T1)caseAbstractRule(notRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.AND_RULE: {
				AndRule andRule = (AndRule)theEObject;
				T1 result = caseAndRule(andRule);
				if (result == null) result = (T1)caseNaryRule(andRule);
				if (result == null) result = (T1)caseAbstractRule(andRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.BINARY_RULE: {
				BinaryRule<?> binaryRule = (BinaryRule<?>)theEObject;
				T1 result = caseBinaryRule(binaryRule);
				if (result == null) result = (T1)caseAbstractRule(binaryRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.TRUE_RULE: {
				TrueRule trueRule = (TrueRule)theEObject;
				T1 result = caseTrueRule(trueRule);
				if (result == null) result = (T1)caseAbstractRule(trueRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.FALSE_RULE: {
				FalseRule falseRule = (FalseRule)theEObject;
				T1 result = caseFalseRule(falseRule);
				if (result == null) result = (T1)caseAbstractRule(falseRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.OR_RULE: {
				OrRule orRule = (OrRule)theEObject;
				T1 result = caseOrRule(orRule);
				if (result == null) result = (T1)caseNaryRule(orRule);
				if (result == null) result = (T1)caseAbstractRule(orRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.IMPLICATION_RULE: {
				ImplicationRule implicationRule = (ImplicationRule)theEObject;
				T1 result = caseImplicationRule(implicationRule);
				if (result == null) result = (T1)caseBinaryRule(implicationRule);
				if (result == null) result = (T1)caseAbstractRule(implicationRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.IS_SOURCE_TYPE: {
				IsSourceType isSourceType = (IsSourceType)theEObject;
				T1 result = caseIsSourceType(isSourceType);
				if (result == null) result = caseTypeArgumentRule(isSourceType);
				if (result == null) result = caseConstraintRule(isSourceType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.TYPE_ARGUMENT_RULE: {
				TypeArgumentRule typeArgumentRule = (TypeArgumentRule)theEObject;
				T1 result = caseTypeArgumentRule(typeArgumentRule);
				if (result == null) result = caseConstraintRule(typeArgumentRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.NARY_RULE: {
				NaryRule<?> naryRule = (NaryRule<?>)theEObject;
				T1 result = caseNaryRule(naryRule);
				if (result == null) result = (T1)caseAbstractRule(naryRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseModel(Model object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Policy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Policy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePolicy(Policy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Contains</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Contains</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseContains(Contains object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Is Step In</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Is Step In</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIsStepIn(IsStepIn object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Is Target</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Is Target</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIsTarget(IsTarget object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Is Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Is Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIsSource(IsSource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Is Parent</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Is Parent</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIsParent(IsParent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseAbstractRule(AbstractRule<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseRule(Rule<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseFeatureRule(FeatureRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Is Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Is Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIsFeature(IsFeature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseConstraintRule(ConstraintRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Is Target Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Is Target Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIsTargetType(IsTargetType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unary Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unary Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseUnaryRule(UnaryRule<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Not Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Not Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseNotRule(NotRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>And Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>And Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAndRule(AndRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseBinaryRule(BinaryRule<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>True Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>True Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTrueRule(TrueRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>False Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>False Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseFalseRule(FalseRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Or Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Or Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseOrRule(OrRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Implication Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Implication Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseImplicationRule(ImplicationRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Is Source Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Is Source Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIsSourceType(IsSourceType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Argument Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Argument Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTypeArgumentRule(TypeArgumentRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nary Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nary Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseNaryRule(NaryRule<T> object) {
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
	public T1 defaultCase(EObject object) {
		return null;
	}

} //EditpolicymodelSwitch
