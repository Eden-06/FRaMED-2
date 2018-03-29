/**
 */
package Editpolicymodel.util;

import Editpolicymodel.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see Editpolicymodel.EditpolicymodelPackage
 * @generated
 */
public class EditpolicymodelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EditpolicymodelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EditpolicymodelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = EditpolicymodelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EditpolicymodelSwitch<Adapter> modelSwitch =
		new EditpolicymodelSwitch<Adapter>() {
			@Override
			public Adapter caseModel(Model object) {
				return createModelAdapter();
			}
			@Override
			public Adapter casePolicy(Policy object) {
				return createPolicyAdapter();
			}
			@Override
			public Adapter caseContains(Contains object) {
				return createContainsAdapter();
			}
			@Override
			public Adapter caseIsStepIn(IsStepIn object) {
				return createIsStepInAdapter();
			}
			@Override
			public Adapter caseIsTarget(IsTarget object) {
				return createIsTargetAdapter();
			}
			@Override
			public Adapter caseIsParent(IsParent object) {
				return createIsParentAdapter();
			}
			@Override
			public Adapter caseFeatureRule(FeatureRule object) {
				return createFeatureRuleAdapter();
			}
			@Override
			public Adapter caseIsFeature(IsFeature object) {
				return createIsFeatureAdapter();
			}
			@Override
			public Adapter caseConstraintRule(ConstraintRule object) {
				return createConstraintRuleAdapter();
			}
			@Override
			public Adapter caseIsTargetType(IsTargetType object) {
				return createIsTargetTypeAdapter();
			}
			@Override
			public Adapter caseUnaryConstraintRule(UnaryConstraintRule object) {
				return createUnaryConstraintRuleAdapter();
			}
			@Override
			public Adapter caseNotConstraintRule(NotConstraintRule object) {
				return createNotConstraintRuleAdapter();
			}
			@Override
			public Adapter caseAndConstraintRule(AndConstraintRule object) {
				return createAndConstraintRuleAdapter();
			}
			@Override
			public Adapter caseBinaryConstraintRule(BinaryConstraintRule object) {
				return createBinaryConstraintRuleAdapter();
			}
			@Override
			public Adapter caseTrueConstraintRule(TrueConstraintRule object) {
				return createTrueConstraintRuleAdapter();
			}
			@Override
			public Adapter caseFalseConstraintRule(FalseConstraintRule object) {
				return createFalseConstraintRuleAdapter();
			}
			@Override
			public Adapter caseOrConstraintRule(OrConstraintRule object) {
				return createOrConstraintRuleAdapter();
			}
			@Override
			public Adapter caseImplicationConstraintRule(ImplicationConstraintRule object) {
				return createImplicationConstraintRuleAdapter();
			}
			@Override
			public Adapter caseIsSourceType(IsSourceType object) {
				return createIsSourceTypeAdapter();
			}
			@Override
			public Adapter caseTypeArgumentRule(TypeArgumentRule object) {
				return createTypeArgumentRuleAdapter();
			}
			@Override
			public Adapter caseNaryConstraintRule(NaryConstraintRule object) {
				return createNaryConstraintRuleAdapter();
			}
			@Override
			public Adapter caseLogicalConstraintRule(LogicalConstraintRule object) {
				return createLogicalConstraintRuleAdapter();
			}
			@Override
			public Adapter caseTrueFeatureRule(TrueFeatureRule object) {
				return createTrueFeatureRuleAdapter();
			}
			@Override
			public Adapter caseNotFeatureRule(NotFeatureRule object) {
				return createNotFeatureRuleAdapter();
			}
			@Override
			public Adapter caseFalseFeatureRule(FalseFeatureRule object) {
				return createFalseFeatureRuleAdapter();
			}
			@Override
			public Adapter caseNaryFeatureRule(NaryFeatureRule object) {
				return createNaryFeatureRuleAdapter();
			}
			@Override
			public Adapter caseBinaryFeatureRule(BinaryFeatureRule object) {
				return createBinaryFeatureRuleAdapter();
			}
			@Override
			public Adapter caseLogicalFeatureRule(LogicalFeatureRule object) {
				return createLogicalFeatureRuleAdapter();
			}
			@Override
			public Adapter caseImplicationFeatureRule(ImplicationFeatureRule object) {
				return createImplicationFeatureRuleAdapter();
			}
			@Override
			public Adapter caseUnaryFeatureRule(UnaryFeatureRule object) {
				return createUnaryFeatureRuleAdapter();
			}
			@Override
			public Adapter caseOrFeatureRule(OrFeatureRule object) {
				return createOrFeatureRuleAdapter();
			}
			@Override
			public Adapter caseAndFeatureRule(AndFeatureRule object) {
				return createAndFeatureRuleAdapter();
			}
			@Override
			public Adapter caseSourceEqualsTarget(SourceEqualsTarget object) {
				return createSourceEqualsTargetAdapter();
			}
			@Override
			public Adapter caseSourceEqualsTargetType(SourceEqualsTargetType object) {
				return createSourceEqualsTargetTypeAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.Model
	 * @generated
	 */
	public Adapter createModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.Policy <em>Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.Policy
	 * @generated
	 */
	public Adapter createPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.Contains <em>Contains</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.Contains
	 * @generated
	 */
	public Adapter createContainsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.IsStepIn <em>Is Step In</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.IsStepIn
	 * @generated
	 */
	public Adapter createIsStepInAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.IsTarget <em>Is Target</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.IsTarget
	 * @generated
	 */
	public Adapter createIsTargetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.IsParent <em>Is Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.IsParent
	 * @generated
	 */
	public Adapter createIsParentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.FeatureRule <em>Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.FeatureRule
	 * @generated
	 */
	public Adapter createFeatureRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.IsFeature <em>Is Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.IsFeature
	 * @generated
	 */
	public Adapter createIsFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.ConstraintRule <em>Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.ConstraintRule
	 * @generated
	 */
	public Adapter createConstraintRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.IsTargetType <em>Is Target Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.IsTargetType
	 * @generated
	 */
	public Adapter createIsTargetTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.UnaryConstraintRule <em>Unary Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.UnaryConstraintRule
	 * @generated
	 */
	public Adapter createUnaryConstraintRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.NotConstraintRule <em>Not Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.NotConstraintRule
	 * @generated
	 */
	public Adapter createNotConstraintRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.AndConstraintRule <em>And Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.AndConstraintRule
	 * @generated
	 */
	public Adapter createAndConstraintRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.BinaryConstraintRule <em>Binary Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.BinaryConstraintRule
	 * @generated
	 */
	public Adapter createBinaryConstraintRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.TrueConstraintRule <em>True Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.TrueConstraintRule
	 * @generated
	 */
	public Adapter createTrueConstraintRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.FalseConstraintRule <em>False Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.FalseConstraintRule
	 * @generated
	 */
	public Adapter createFalseConstraintRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.OrConstraintRule <em>Or Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.OrConstraintRule
	 * @generated
	 */
	public Adapter createOrConstraintRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.ImplicationConstraintRule <em>Implication Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.ImplicationConstraintRule
	 * @generated
	 */
	public Adapter createImplicationConstraintRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.IsSourceType <em>Is Source Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.IsSourceType
	 * @generated
	 */
	public Adapter createIsSourceTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.TypeArgumentRule <em>Type Argument Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.TypeArgumentRule
	 * @generated
	 */
	public Adapter createTypeArgumentRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.NaryConstraintRule <em>Nary Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.NaryConstraintRule
	 * @generated
	 */
	public Adapter createNaryConstraintRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.LogicalConstraintRule <em>Logical Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.LogicalConstraintRule
	 * @generated
	 */
	public Adapter createLogicalConstraintRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.TrueFeatureRule <em>True Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.TrueFeatureRule
	 * @generated
	 */
	public Adapter createTrueFeatureRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.NotFeatureRule <em>Not Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.NotFeatureRule
	 * @generated
	 */
	public Adapter createNotFeatureRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.FalseFeatureRule <em>False Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.FalseFeatureRule
	 * @generated
	 */
	public Adapter createFalseFeatureRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.NaryFeatureRule <em>Nary Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.NaryFeatureRule
	 * @generated
	 */
	public Adapter createNaryFeatureRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.BinaryFeatureRule <em>Binary Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.BinaryFeatureRule
	 * @generated
	 */
	public Adapter createBinaryFeatureRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.LogicalFeatureRule <em>Logical Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.LogicalFeatureRule
	 * @generated
	 */
	public Adapter createLogicalFeatureRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.ImplicationFeatureRule <em>Implication Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.ImplicationFeatureRule
	 * @generated
	 */
	public Adapter createImplicationFeatureRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.UnaryFeatureRule <em>Unary Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.UnaryFeatureRule
	 * @generated
	 */
	public Adapter createUnaryFeatureRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.OrFeatureRule <em>Or Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.OrFeatureRule
	 * @generated
	 */
	public Adapter createOrFeatureRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.AndFeatureRule <em>And Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.AndFeatureRule
	 * @generated
	 */
	public Adapter createAndFeatureRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.SourceEqualsTarget <em>Source Equals Target</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.SourceEqualsTarget
	 * @generated
	 */
	public Adapter createSourceEqualsTargetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.SourceEqualsTargetType <em>Source Equals Target Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.SourceEqualsTargetType
	 * @generated
	 */
	public Adapter createSourceEqualsTargetTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //EditpolicymodelAdapterFactory
