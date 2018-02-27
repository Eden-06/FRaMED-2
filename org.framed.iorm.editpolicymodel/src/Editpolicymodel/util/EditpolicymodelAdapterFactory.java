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
			public Adapter caseAbstractConstraintRule(AbstractConstraintRule object) {
				return createAbstractConstraintRuleAdapter();
			}
			@Override
			public Adapter caseAndConstraintRule(AndConstraintRule object) {
				return createAndConstraintRuleAdapter();
			}
			@Override
			public Adapter caseOrConstraintRule(OrConstraintRule object) {
				return createOrConstraintRuleAdapter();
			}
			@Override
			public Adapter caseContainsConstraintRule(ContainsConstraintRule object) {
				return createContainsConstraintRuleAdapter();
			}
			@Override
			public Adapter caseIsStepOutConstraintRule(IsStepOutConstraintRule object) {
				return createIsStepOutConstraintRuleAdapter();
			}
			@Override
			public Adapter caseIsTargetConstraintRule(IsTargetConstraintRule object) {
				return createIsTargetConstraintRuleAdapter();
			}
			@Override
			public Adapter caseIsSourceConstraintRule(IsSourceConstraintRule object) {
				return createIsSourceConstraintRuleAdapter();
			}
			@Override
			public Adapter caseIsParentConstraintRule(IsParentConstraintRule object) {
				return createIsParentConstraintRuleAdapter();
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
			public <T> Adapter caseAbstractRule(AbstractRule<T> object) {
				return createAbstractRuleAdapter();
			}
			@Override
			public <T> Adapter caseRule(Rule<T> object) {
				return createRuleAdapter();
			}
			@Override
			public Adapter caseFeature(Feature object) {
				return createFeatureAdapter();
			}
			@Override
			public Adapter caseIsFeature(IsFeature object) {
				return createIsFeatureAdapter();
			}
			@Override
			public Adapter caseConstraint(Constraint object) {
				return createConstraintAdapter();
			}
			@Override
			public Adapter caseIsTargetType(IsTargetType object) {
				return createIsTargetTypeAdapter();
			}
			@Override
			public <T> Adapter caseUnaryRule(UnaryRule<T> object) {
				return createUnaryRuleAdapter();
			}
			@Override
			public Adapter caseNotRule(NotRule object) {
				return createNotRuleAdapter();
			}
			@Override
			public Adapter caseAndRule(AndRule object) {
				return createAndRuleAdapter();
			}
			@Override
			public <T> Adapter caseBinaryRule(BinaryRule<T> object) {
				return createBinaryRuleAdapter();
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
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.AbstractConstraintRule <em>Abstract Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.AbstractConstraintRule
	 * @generated
	 */
	public Adapter createAbstractConstraintRuleAdapter() {
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
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.ContainsConstraintRule <em>Contains Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.ContainsConstraintRule
	 * @generated
	 */
	public Adapter createContainsConstraintRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.IsStepOutConstraintRule <em>Is Step Out Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.IsStepOutConstraintRule
	 * @generated
	 */
	public Adapter createIsStepOutConstraintRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.IsTargetConstraintRule <em>Is Target Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.IsTargetConstraintRule
	 * @generated
	 */
	public Adapter createIsTargetConstraintRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.IsSourceConstraintRule <em>Is Source Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.IsSourceConstraintRule
	 * @generated
	 */
	public Adapter createIsSourceConstraintRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.IsParentConstraintRule <em>Is Parent Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.IsParentConstraintRule
	 * @generated
	 */
	public Adapter createIsParentConstraintRuleAdapter() {
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
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.AbstractRule <em>Abstract Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.AbstractRule
	 * @generated
	 */
	public Adapter createAbstractRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.Rule
	 * @generated
	 */
	public Adapter createRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.Feature
	 * @generated
	 */
	public Adapter createFeatureAdapter() {
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
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.Constraint
	 * @generated
	 */
	public Adapter createConstraintAdapter() {
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
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.UnaryRule <em>Unary Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.UnaryRule
	 * @generated
	 */
	public Adapter createUnaryRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.NotRule <em>Not Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.NotRule
	 * @generated
	 */
	public Adapter createNotRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.AndRule <em>And Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.AndRule
	 * @generated
	 */
	public Adapter createAndRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.BinaryRule <em>Binary Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.BinaryRule
	 * @generated
	 */
	public Adapter createBinaryRuleAdapter() {
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
