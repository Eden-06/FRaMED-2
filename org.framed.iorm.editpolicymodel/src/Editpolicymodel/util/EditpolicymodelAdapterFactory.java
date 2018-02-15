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
			public Adapter caseAbstractFeatureRule(AbstractFeatureRule object) {
				return createAbstractFeatureRuleAdapter();
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
			public Adapter caseNotConstraintRule(NotConstraintRule object) {
				return createNotConstraintRuleAdapter();
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
			public Adapter caseAndFeatureRule(AndFeatureRule object) {
				return createAndFeatureRuleAdapter();
			}
			@Override
			public Adapter caseOrFeatureRule(OrFeatureRule object) {
				return createOrFeatureRuleAdapter();
			}
			@Override
			public Adapter caseNotFeatureRule(NotFeatureRule object) {
				return createNotFeatureRuleAdapter();
			}
			@Override
			public Adapter caseTrueFeatureRule(TrueFeatureRule object) {
				return createTrueFeatureRuleAdapter();
			}
			@Override
			public Adapter caseFalseFeatureRule(FalseFeatureRule object) {
				return createFalseFeatureRuleAdapter();
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
	 * Creates a new adapter for an object of class '{@link Editpolicymodel.AbstractFeatureRule <em>Abstract Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Editpolicymodel.AbstractFeatureRule
	 * @generated
	 */
	public Adapter createAbstractFeatureRuleAdapter() {
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
