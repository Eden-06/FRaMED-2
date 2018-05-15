/**
 */
package editpolicymodel.util;

import editpolicymodel.*;

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
 * @see editpolicymodel.editpolicymodelPackage
 * @generated
 */
public class editpolicymodelSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static editpolicymodelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public editpolicymodelSwitch() {
		if (modelPackage == null) {
			modelPackage = editpolicymodelPackage.eINSTANCE;
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
			case editpolicymodelPackage.MODEL: {
				Model model = (Model)theEObject;
				T result = caseModel(model);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case editpolicymodelPackage.POLICY: {
				Policy policy = (Policy)theEObject;
				T result = casePolicy(policy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case editpolicymodelPackage.CONTAINS_COMPARTMENT: {
				ContainsCompartment containsCompartment = (ContainsCompartment)theEObject;
				T result = caseContainsCompartment(containsCompartment);
				if (result == null) result = caseConstraintRule(containsCompartment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case editpolicymodelPackage.IS_TARGET: {
				IsTarget isTarget = (IsTarget)theEObject;
				T result = caseIsTarget(isTarget);
				if (result == null) result = caseTypeArgumentRule(isTarget);
				if (result == null) result = caseConstraintRule(isTarget);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case editpolicymodelPackage.IS_PARENT: {
				IsParent isParent = (IsParent)theEObject;
				T result = caseIsParent(isParent);
				if (result == null) result = caseTypeArgumentRule(isParent);
				if (result == null) result = caseConstraintRule(isParent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case editpolicymodelPackage.FEATURE_RULE: {
				FeatureRule featureRule = (FeatureRule)theEObject;
				T result = caseFeatureRule(featureRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case editpolicymodelPackage.IS_FEATURE: {
				IsFeature isFeature = (IsFeature)theEObject;
				T result = caseIsFeature(isFeature);
				if (result == null) result = caseFeatureRule(isFeature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case editpolicymodelPackage.CONSTRAINT_RULE: {
				ConstraintRule constraintRule = (ConstraintRule)theEObject;
				T result = caseConstraintRule(constraintRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case editpolicymodelPackage.IS_TARGET_TYPE: {
				IsTargetType isTargetType = (IsTargetType)theEObject;
				T result = caseIsTargetType(isTargetType);
				if (result == null) result = caseTypeArgumentRule(isTargetType);
				if (result == null) result = caseConstraintRule(isTargetType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case editpolicymodelPackage.UNARY_CONSTRAINT_RULE: {
				UnaryConstraintRule unaryConstraintRule = (UnaryConstraintRule)theEObject;
				T result = caseUnaryConstraintRule(unaryConstraintRule);
				if (result == null) result = caseLogicalConstraintRule(unaryConstraintRule);
				if (result == null) result = caseConstraintRule(unaryConstraintRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case editpolicymodelPackage.NOT_CONSTRAINT_RULE: {
				NotConstraintRule notConstraintRule = (NotConstraintRule)theEObject;
				T result = caseNotConstraintRule(notConstraintRule);
				if (result == null) result = caseUnaryConstraintRule(notConstraintRule);
				if (result == null) result = caseLogicalConstraintRule(notConstraintRule);
				if (result == null) result = caseConstraintRule(notConstraintRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case editpolicymodelPackage.AND_CONSTRAINT_RULE: {
				AndConstraintRule andConstraintRule = (AndConstraintRule)theEObject;
				T result = caseAndConstraintRule(andConstraintRule);
				if (result == null) result = caseNaryConstraintRule(andConstraintRule);
				if (result == null) result = caseLogicalConstraintRule(andConstraintRule);
				if (result == null) result = caseConstraintRule(andConstraintRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case editpolicymodelPackage.BINARY_CONSTRAINT_RULE: {
				BinaryConstraintRule binaryConstraintRule = (BinaryConstraintRule)theEObject;
				T result = caseBinaryConstraintRule(binaryConstraintRule);
				if (result == null) result = caseLogicalConstraintRule(binaryConstraintRule);
				if (result == null) result = caseConstraintRule(binaryConstraintRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case editpolicymodelPackage.TRUE_CONSTRAINT_RULE: {
				TrueConstraintRule trueConstraintRule = (TrueConstraintRule)theEObject;
				T result = caseTrueConstraintRule(trueConstraintRule);
				if (result == null) result = caseLogicalConstraintRule(trueConstraintRule);
				if (result == null) result = caseConstraintRule(trueConstraintRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case editpolicymodelPackage.FALSE_CONSTRAINT_RULE: {
				FalseConstraintRule falseConstraintRule = (FalseConstraintRule)theEObject;
				T result = caseFalseConstraintRule(falseConstraintRule);
				if (result == null) result = caseLogicalConstraintRule(falseConstraintRule);
				if (result == null) result = caseConstraintRule(falseConstraintRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case editpolicymodelPackage.OR_CONSTRAINT_RULE: {
				OrConstraintRule orConstraintRule = (OrConstraintRule)theEObject;
				T result = caseOrConstraintRule(orConstraintRule);
				if (result == null) result = caseNaryConstraintRule(orConstraintRule);
				if (result == null) result = caseLogicalConstraintRule(orConstraintRule);
				if (result == null) result = caseConstraintRule(orConstraintRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case editpolicymodelPackage.IMPLICATION_CONSTRAINT_RULE: {
				ImplicationConstraintRule implicationConstraintRule = (ImplicationConstraintRule)theEObject;
				T result = caseImplicationConstraintRule(implicationConstraintRule);
				if (result == null) result = caseBinaryConstraintRule(implicationConstraintRule);
				if (result == null) result = caseLogicalConstraintRule(implicationConstraintRule);
				if (result == null) result = caseConstraintRule(implicationConstraintRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case editpolicymodelPackage.IS_SOURCE_TYPE: {
				IsSourceType isSourceType = (IsSourceType)theEObject;
				T result = caseIsSourceType(isSourceType);
				if (result == null) result = caseTypeArgumentRule(isSourceType);
				if (result == null) result = caseConstraintRule(isSourceType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case editpolicymodelPackage.TYPE_ARGUMENT_RULE: {
				TypeArgumentRule typeArgumentRule = (TypeArgumentRule)theEObject;
				T result = caseTypeArgumentRule(typeArgumentRule);
				if (result == null) result = caseConstraintRule(typeArgumentRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case editpolicymodelPackage.NARY_CONSTRAINT_RULE: {
				NaryConstraintRule naryConstraintRule = (NaryConstraintRule)theEObject;
				T result = caseNaryConstraintRule(naryConstraintRule);
				if (result == null) result = caseLogicalConstraintRule(naryConstraintRule);
				if (result == null) result = caseConstraintRule(naryConstraintRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case editpolicymodelPackage.LOGICAL_CONSTRAINT_RULE: {
				LogicalConstraintRule logicalConstraintRule = (LogicalConstraintRule)theEObject;
				T result = caseLogicalConstraintRule(logicalConstraintRule);
				if (result == null) result = caseConstraintRule(logicalConstraintRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case editpolicymodelPackage.TRUE_FEATURE_RULE: {
				TrueFeatureRule trueFeatureRule = (TrueFeatureRule)theEObject;
				T result = caseTrueFeatureRule(trueFeatureRule);
				if (result == null) result = caseLogicalFeatureRule(trueFeatureRule);
				if (result == null) result = caseFeatureRule(trueFeatureRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case editpolicymodelPackage.NOT_FEATURE_RULE: {
				NotFeatureRule notFeatureRule = (NotFeatureRule)theEObject;
				T result = caseNotFeatureRule(notFeatureRule);
				if (result == null) result = caseUnaryFeatureRule(notFeatureRule);
				if (result == null) result = caseLogicalFeatureRule(notFeatureRule);
				if (result == null) result = caseFeatureRule(notFeatureRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case editpolicymodelPackage.FALSE_FEATURE_RULE: {
				FalseFeatureRule falseFeatureRule = (FalseFeatureRule)theEObject;
				T result = caseFalseFeatureRule(falseFeatureRule);
				if (result == null) result = caseLogicalFeatureRule(falseFeatureRule);
				if (result == null) result = caseFeatureRule(falseFeatureRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case editpolicymodelPackage.NARY_FEATURE_RULE: {
				NaryFeatureRule naryFeatureRule = (NaryFeatureRule)theEObject;
				T result = caseNaryFeatureRule(naryFeatureRule);
				if (result == null) result = caseLogicalFeatureRule(naryFeatureRule);
				if (result == null) result = caseFeatureRule(naryFeatureRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case editpolicymodelPackage.BINARY_FEATURE_RULE: {
				BinaryFeatureRule binaryFeatureRule = (BinaryFeatureRule)theEObject;
				T result = caseBinaryFeatureRule(binaryFeatureRule);
				if (result == null) result = caseLogicalFeatureRule(binaryFeatureRule);
				if (result == null) result = caseFeatureRule(binaryFeatureRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case editpolicymodelPackage.LOGICAL_FEATURE_RULE: {
				LogicalFeatureRule logicalFeatureRule = (LogicalFeatureRule)theEObject;
				T result = caseLogicalFeatureRule(logicalFeatureRule);
				if (result == null) result = caseFeatureRule(logicalFeatureRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case editpolicymodelPackage.IMPLICATION_FEATURE_RULE: {
				ImplicationFeatureRule implicationFeatureRule = (ImplicationFeatureRule)theEObject;
				T result = caseImplicationFeatureRule(implicationFeatureRule);
				if (result == null) result = caseBinaryFeatureRule(implicationFeatureRule);
				if (result == null) result = caseLogicalFeatureRule(implicationFeatureRule);
				if (result == null) result = caseFeatureRule(implicationFeatureRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case editpolicymodelPackage.UNARY_FEATURE_RULE: {
				UnaryFeatureRule unaryFeatureRule = (UnaryFeatureRule)theEObject;
				T result = caseUnaryFeatureRule(unaryFeatureRule);
				if (result == null) result = caseLogicalFeatureRule(unaryFeatureRule);
				if (result == null) result = caseFeatureRule(unaryFeatureRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case editpolicymodelPackage.OR_FEATURE_RULE: {
				OrFeatureRule orFeatureRule = (OrFeatureRule)theEObject;
				T result = caseOrFeatureRule(orFeatureRule);
				if (result == null) result = caseNaryFeatureRule(orFeatureRule);
				if (result == null) result = caseLogicalFeatureRule(orFeatureRule);
				if (result == null) result = caseFeatureRule(orFeatureRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case editpolicymodelPackage.AND_FEATURE_RULE: {
				AndFeatureRule andFeatureRule = (AndFeatureRule)theEObject;
				T result = caseAndFeatureRule(andFeatureRule);
				if (result == null) result = caseNaryFeatureRule(andFeatureRule);
				if (result == null) result = caseLogicalFeatureRule(andFeatureRule);
				if (result == null) result = caseFeatureRule(andFeatureRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case editpolicymodelPackage.SOURCE_EQUALS_TARGET: {
				SourceEqualsTarget sourceEqualsTarget = (SourceEqualsTarget)theEObject;
				T result = caseSourceEqualsTarget(sourceEqualsTarget);
				if (result == null) result = caseConstraintRule(sourceEqualsTarget);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case editpolicymodelPackage.SOURCE_EQUALS_TARGET_TYPE: {
				SourceEqualsTargetType sourceEqualsTargetType = (SourceEqualsTargetType)theEObject;
				T result = caseSourceEqualsTargetType(sourceEqualsTargetType);
				if (result == null) result = caseConstraintRule(sourceEqualsTargetType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case editpolicymodelPackage.IN_COMPARTMENT: {
				InCompartment inCompartment = (InCompartment)theEObject;
				T result = caseInCompartment(inCompartment);
				if (result == null) result = caseConstraintRule(inCompartment);
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
	 * Returns the result of interpreting the object as an instance of '<em>Contains Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Contains Compartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContainsCompartment(ContainsCompartment object) {
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
	public T caseIsTarget(IsTarget object) {
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
	public T caseIsParent(IsParent object) {
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
	public T caseFeatureRule(FeatureRule object) {
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
	public T caseIsFeature(IsFeature object) {
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
	public T caseConstraintRule(ConstraintRule object) {
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
	public T caseIsTargetType(IsTargetType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unary Constraint Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unary Constraint Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnaryConstraintRule(UnaryConstraintRule object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Binary Constraint Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Constraint Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryConstraintRule(BinaryConstraintRule object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Implication Constraint Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Implication Constraint Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImplicationConstraintRule(ImplicationConstraintRule object) {
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
	public T caseIsSourceType(IsSourceType object) {
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
	public T caseTypeArgumentRule(TypeArgumentRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nary Constraint Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nary Constraint Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNaryConstraintRule(NaryConstraintRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Logical Constraint Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Logical Constraint Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLogicalConstraintRule(LogicalConstraintRule object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Nary Feature Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nary Feature Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNaryFeatureRule(NaryFeatureRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Feature Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Feature Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryFeatureRule(BinaryFeatureRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Logical Feature Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Logical Feature Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLogicalFeatureRule(LogicalFeatureRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Implication Feature Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Implication Feature Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImplicationFeatureRule(ImplicationFeatureRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unary Feature Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unary Feature Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnaryFeatureRule(UnaryFeatureRule object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Source Equals Target</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Source Equals Target</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSourceEqualsTarget(SourceEqualsTarget object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Source Equals Target Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Source Equals Target Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSourceEqualsTargetType(SourceEqualsTargetType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>In Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>In Compartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInCompartment(InCompartment object) {
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

} //editpolicymodelSwitch
