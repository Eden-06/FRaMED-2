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
			case EditpolicymodelPackage.ABSTRACT_CONSTRAINT_RULE: {
				AbstractConstraintRule abstractConstraintRule = (AbstractConstraintRule)theEObject;
				T1 result = caseAbstractConstraintRule(abstractConstraintRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.AND_CONSTRAINT_RULE: {
				AndConstraintRule andConstraintRule = (AndConstraintRule)theEObject;
				T1 result = caseAndConstraintRule(andConstraintRule);
				if (result == null) result = caseAbstractConstraintRule(andConstraintRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.OR_CONSTRAINT_RULE: {
				OrConstraintRule orConstraintRule = (OrConstraintRule)theEObject;
				T1 result = caseOrConstraintRule(orConstraintRule);
				if (result == null) result = caseAbstractConstraintRule(orConstraintRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.CONTAINS_CONSTRAINT_RULE: {
				ContainsConstraintRule containsConstraintRule = (ContainsConstraintRule)theEObject;
				T1 result = caseContainsConstraintRule(containsConstraintRule);
				if (result == null) result = caseAbstractConstraintRule(containsConstraintRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.IS_STEP_OUT_CONSTRAINT_RULE: {
				IsStepOutConstraintRule isStepOutConstraintRule = (IsStepOutConstraintRule)theEObject;
				T1 result = caseIsStepOutConstraintRule(isStepOutConstraintRule);
				if (result == null) result = caseAbstractConstraintRule(isStepOutConstraintRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.IS_TARGET_CONSTRAINT_RULE: {
				IsTargetConstraintRule isTargetConstraintRule = (IsTargetConstraintRule)theEObject;
				T1 result = caseIsTargetConstraintRule(isTargetConstraintRule);
				if (result == null) result = caseAbstractConstraintRule(isTargetConstraintRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.IS_SOURCE_CONSTRAINT_RULE: {
				IsSourceConstraintRule isSourceConstraintRule = (IsSourceConstraintRule)theEObject;
				T1 result = caseIsSourceConstraintRule(isSourceConstraintRule);
				if (result == null) result = caseAbstractConstraintRule(isSourceConstraintRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.IS_PARENT_CONSTRAINT_RULE: {
				IsParentConstraintRule isParentConstraintRule = (IsParentConstraintRule)theEObject;
				T1 result = caseIsParentConstraintRule(isParentConstraintRule);
				if (result == null) result = caseAbstractConstraintRule(isParentConstraintRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.TRUE_CONSTRAINT_RULE: {
				TrueConstraintRule trueConstraintRule = (TrueConstraintRule)theEObject;
				T1 result = caseTrueConstraintRule(trueConstraintRule);
				if (result == null) result = caseAbstractConstraintRule(trueConstraintRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.FALSE_CONSTRAINT_RULE: {
				FalseConstraintRule falseConstraintRule = (FalseConstraintRule)theEObject;
				T1 result = caseFalseConstraintRule(falseConstraintRule);
				if (result == null) result = caseAbstractConstraintRule(falseConstraintRule);
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
			case EditpolicymodelPackage.FEATURE: {
				Feature feature = (Feature)theEObject;
				T1 result = caseFeature(feature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.IS_FEATURE: {
				IsFeature isFeature = (IsFeature)theEObject;
				T1 result = caseIsFeature(isFeature);
				if (result == null) result = caseFeature(isFeature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.CONSTRAINT: {
				Constraint constraint = (Constraint)theEObject;
				T1 result = caseConstraint(constraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.IS_TARGET_TYPE: {
				IsTargetType isTargetType = (IsTargetType)theEObject;
				T1 result = caseIsTargetType(isTargetType);
				if (result == null) result = caseConstraint(isTargetType);
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
				if (result == null) result = caseAbstractRule(notRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.AND_RULE: {
				AndRule andRule = (AndRule)theEObject;
				T1 result = caseAndRule(andRule);
				if (result == null) result = (T1)caseBinaryRule(andRule);
				if (result == null) result = caseAbstractRule(andRule);
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
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Constraint Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Constraint Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAbstractConstraintRule(AbstractConstraintRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>And Constraint Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>And Constraint Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAndConstraintRule(AndConstraintRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Or Constraint Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Or Constraint Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseOrConstraintRule(OrConstraintRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Contains Constraint Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Contains Constraint Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseContainsConstraintRule(ContainsConstraintRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Is Step Out Constraint Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Is Step Out Constraint Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIsStepOutConstraintRule(IsStepOutConstraintRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Is Target Constraint Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Is Target Constraint Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIsTargetConstraintRule(IsTargetConstraintRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Is Source Constraint Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Is Source Constraint Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIsSourceConstraintRule(IsSourceConstraintRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Is Parent Constraint Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Is Parent Constraint Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIsParentConstraintRule(IsParentConstraintRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>True Constraint Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>True Constraint Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTrueConstraintRule(TrueConstraintRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>False Constraint Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>False Constraint Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseFalseConstraintRule(FalseConstraintRule object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseFeature(Feature object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseConstraint(Constraint object) {
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
