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
public class EditpolicymodelSwitch<T> extends Switch<T> {
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
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case EditpolicymodelPackage.MODEL: {
				Model model = (Model)theEObject;
				T result = caseModel(model);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.POLICY: {
				Policy policy = (Policy)theEObject;
				T result = casePolicy(policy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.ABSTRACT_CONSTRAINT_RULE: {
				AbstractConstraintRule abstractConstraintRule = (AbstractConstraintRule)theEObject;
				T result = caseAbstractConstraintRule(abstractConstraintRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.ABSTRACT_FEATURE_RULE: {
				AbstractFeatureRule abstractFeatureRule = (AbstractFeatureRule)theEObject;
				T result = caseAbstractFeatureRule(abstractFeatureRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.AND_CONSTRAINT_RULE: {
				AndConstraintRule andConstraintRule = (AndConstraintRule)theEObject;
				T result = caseAndConstraintRule(andConstraintRule);
				if (result == null) result = caseAbstractConstraintRule(andConstraintRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.OR_CONSTRAINT_RULE: {
				OrConstraintRule orConstraintRule = (OrConstraintRule)theEObject;
				T result = caseOrConstraintRule(orConstraintRule);
				if (result == null) result = caseAbstractConstraintRule(orConstraintRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.CONTAINS_CONSTRAINT_RULE: {
				ContainsConstraintRule containsConstraintRule = (ContainsConstraintRule)theEObject;
				T result = caseContainsConstraintRule(containsConstraintRule);
				if (result == null) result = caseAbstractConstraintRule(containsConstraintRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.NOT_CONSTRAINT_RULE: {
				NotConstraintRule notConstraintRule = (NotConstraintRule)theEObject;
				T result = caseNotConstraintRule(notConstraintRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.IS_STEP_OUT_CONSTRAINT_RULE: {
				IsStepOutConstraintRule isStepOutConstraintRule = (IsStepOutConstraintRule)theEObject;
				T result = caseIsStepOutConstraintRule(isStepOutConstraintRule);
				if (result == null) result = caseAbstractConstraintRule(isStepOutConstraintRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.IS_TARGET_CONSTRAINT_RULE: {
				IsTargetConstraintRule isTargetConstraintRule = (IsTargetConstraintRule)theEObject;
				T result = caseIsTargetConstraintRule(isTargetConstraintRule);
				if (result == null) result = caseAbstractConstraintRule(isTargetConstraintRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.IS_SOURCE_CONSTRAINT_RULE: {
				IsSourceConstraintRule isSourceConstraintRule = (IsSourceConstraintRule)theEObject;
				T result = caseIsSourceConstraintRule(isSourceConstraintRule);
				if (result == null) result = caseAbstractConstraintRule(isSourceConstraintRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.IS_PARENT_CONSTRAINT_RULE: {
				IsParentConstraintRule isParentConstraintRule = (IsParentConstraintRule)theEObject;
				T result = caseIsParentConstraintRule(isParentConstraintRule);
				if (result == null) result = caseAbstractConstraintRule(isParentConstraintRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.AND_FEATURE_RULE: {
				AndFeatureRule andFeatureRule = (AndFeatureRule)theEObject;
				T result = caseAndFeatureRule(andFeatureRule);
				if (result == null) result = caseAbstractFeatureRule(andFeatureRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.OR_FEATURE_RULE: {
				OrFeatureRule orFeatureRule = (OrFeatureRule)theEObject;
				T result = caseOrFeatureRule(orFeatureRule);
				if (result == null) result = caseAbstractFeatureRule(orFeatureRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.NOT_FEATURE_RULE: {
				NotFeatureRule notFeatureRule = (NotFeatureRule)theEObject;
				T result = caseNotFeatureRule(notFeatureRule);
				if (result == null) result = caseAbstractFeatureRule(notFeatureRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.TRUE_FEATURE_RULE: {
				TrueFeatureRule trueFeatureRule = (TrueFeatureRule)theEObject;
				T result = caseTrueFeatureRule(trueFeatureRule);
				if (result == null) result = caseAbstractFeatureRule(trueFeatureRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.FALSE_FEATURE_RULE: {
				FalseFeatureRule falseFeatureRule = (FalseFeatureRule)theEObject;
				T result = caseFalseFeatureRule(falseFeatureRule);
				if (result == null) result = caseAbstractFeatureRule(falseFeatureRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.TRUE_CONSTRAINT_RULE: {
				TrueConstraintRule trueConstraintRule = (TrueConstraintRule)theEObject;
				T result = caseTrueConstraintRule(trueConstraintRule);
				if (result == null) result = caseAbstractConstraintRule(trueConstraintRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditpolicymodelPackage.FALSE_CONSTRAINT_RULE: {
				FalseConstraintRule falseConstraintRule = (FalseConstraintRule)theEObject;
				T result = caseFalseConstraintRule(falseConstraintRule);
				if (result == null) result = caseAbstractConstraintRule(falseConstraintRule);
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
	public T caseModel(Model object) {
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
	public T casePolicy(Policy object) {
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
	public T caseAbstractConstraintRule(AbstractConstraintRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Feature Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Feature Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractFeatureRule(AbstractFeatureRule object) {
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
	public T caseAndConstraintRule(AndConstraintRule object) {
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
	public T caseOrConstraintRule(OrConstraintRule object) {
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
	public T caseContainsConstraintRule(ContainsConstraintRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Not Constraint Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Not Constraint Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNotConstraintRule(NotConstraintRule object) {
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
	public T caseIsStepOutConstraintRule(IsStepOutConstraintRule object) {
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
	public T caseIsTargetConstraintRule(IsTargetConstraintRule object) {
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
	public T caseIsSourceConstraintRule(IsSourceConstraintRule object) {
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
	public T caseIsParentConstraintRule(IsParentConstraintRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>And Feature Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>And Feature Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAndFeatureRule(AndFeatureRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Or Feature Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Or Feature Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrFeatureRule(OrFeatureRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Not Feature Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Not Feature Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNotFeatureRule(NotFeatureRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>True Feature Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>True Feature Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTrueFeatureRule(TrueFeatureRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>False Feature Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>False Feature Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFalseFeatureRule(FalseFeatureRule object) {
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
	public T caseTrueConstraintRule(TrueConstraintRule object) {
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
	public T caseFalseConstraintRule(FalseConstraintRule object) {
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

} //EditpolicymodelSwitch
