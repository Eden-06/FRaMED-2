/**
 */
package editpolicymodel.util;

import editpolicymodel.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see editpolicymodel.editpolicymodelPackage
 * @generated
 */
public class editpolicymodelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static editpolicymodelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public editpolicymodelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = editpolicymodelPackage.eINSTANCE;
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
	protected editpolicymodelSwitch<Adapter> modelSwitch =
		new editpolicymodelSwitch<Adapter>() {
			@Override
			public Adapter caseModel(Model object) {
				return createModelAdapter();
			}
			@Override
			public Adapter casePolicy(Policy object) {
				return createPolicyAdapter();
			}
			@Override
			public Adapter caseContainsCompartment(ContainsCompartment object) {
				return createContainsCompartmentAdapter();
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
			public Adapter caseInType(InType object) {
				return createInTypeAdapter();
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
	 * Creates a new adapter for an object of class '{@link editpolicymodel.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see editpolicymodel.Model
	 * @generated
	 */
	public Adapter createModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link editpolicymodel.Policy <em>Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see editpolicymodel.Policy
	 * @generated
	 */
	public Adapter createPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link editpolicymodel.ContainsCompartment <em>Contains Compartment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see editpolicymodel.ContainsCompartment
	 * @generated
	 */
	public Adapter createContainsCompartmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link editpolicymodel.IsTarget <em>Is Target</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see editpolicymodel.IsTarget
	 * @generated
	 */
	public Adapter createIsTargetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link editpolicymodel.IsParent <em>Is Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see editpolicymodel.IsParent
	 * @generated
	 */
	public Adapter createIsParentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link editpolicymodel.FeatureRule <em>Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see editpolicymodel.FeatureRule
	 * @generated
	 */
	public Adapter createFeatureRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link editpolicymodel.IsFeature <em>Is Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see editpolicymodel.IsFeature
	 * @generated
	 */
	public Adapter createIsFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link editpolicymodel.ConstraintRule <em>Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see editpolicymodel.ConstraintRule
	 * @generated
	 */
	public Adapter createConstraintRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link editpolicymodel.IsTargetType <em>Is Target Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see editpolicymodel.IsTargetType
	 * @generated
	 */
	public Adapter createIsTargetTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link editpolicymodel.UnaryConstraintRule <em>Unary Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see editpolicymodel.UnaryConstraintRule
	 * @generated
	 */
	public Adapter createUnaryConstraintRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link editpolicymodel.NotConstraintRule <em>Not Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see editpolicymodel.NotConstraintRule
	 * @generated
	 */
	public Adapter createNotConstraintRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link editpolicymodel.AndConstraintRule <em>And Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see editpolicymodel.AndConstraintRule
	 * @generated
	 */
	public Adapter createAndConstraintRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link editpolicymodel.BinaryConstraintRule <em>Binary Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see editpolicymodel.BinaryConstraintRule
	 * @generated
	 */
	public Adapter createBinaryConstraintRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link editpolicymodel.TrueConstraintRule <em>True Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see editpolicymodel.TrueConstraintRule
	 * @generated
	 */
	public Adapter createTrueConstraintRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link editpolicymodel.FalseConstraintRule <em>False Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see editpolicymodel.FalseConstraintRule
	 * @generated
	 */
	public Adapter createFalseConstraintRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link editpolicymodel.OrConstraintRule <em>Or Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see editpolicymodel.OrConstraintRule
	 * @generated
	 */
	public Adapter createOrConstraintRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link editpolicymodel.ImplicationConstraintRule <em>Implication Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see editpolicymodel.ImplicationConstraintRule
	 * @generated
	 */
	public Adapter createImplicationConstraintRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link editpolicymodel.IsSourceType <em>Is Source Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see editpolicymodel.IsSourceType
	 * @generated
	 */
	public Adapter createIsSourceTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link editpolicymodel.TypeArgumentRule <em>Type Argument Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see editpolicymodel.TypeArgumentRule
	 * @generated
	 */
	public Adapter createTypeArgumentRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link editpolicymodel.NaryConstraintRule <em>Nary Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see editpolicymodel.NaryConstraintRule
	 * @generated
	 */
	public Adapter createNaryConstraintRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link editpolicymodel.LogicalConstraintRule <em>Logical Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see editpolicymodel.LogicalConstraintRule
	 * @generated
	 */
	public Adapter createLogicalConstraintRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link editpolicymodel.TrueFeatureRule <em>True Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see editpolicymodel.TrueFeatureRule
	 * @generated
	 */
	public Adapter createTrueFeatureRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link editpolicymodel.NotFeatureRule <em>Not Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see editpolicymodel.NotFeatureRule
	 * @generated
	 */
	public Adapter createNotFeatureRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link editpolicymodel.FalseFeatureRule <em>False Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see editpolicymodel.FalseFeatureRule
	 * @generated
	 */
	public Adapter createFalseFeatureRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link editpolicymodel.NaryFeatureRule <em>Nary Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see editpolicymodel.NaryFeatureRule
	 * @generated
	 */
	public Adapter createNaryFeatureRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link editpolicymodel.BinaryFeatureRule <em>Binary Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see editpolicymodel.BinaryFeatureRule
	 * @generated
	 */
	public Adapter createBinaryFeatureRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link editpolicymodel.LogicalFeatureRule <em>Logical Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see editpolicymodel.LogicalFeatureRule
	 * @generated
	 */
	public Adapter createLogicalFeatureRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link editpolicymodel.ImplicationFeatureRule <em>Implication Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see editpolicymodel.ImplicationFeatureRule
	 * @generated
	 */
	public Adapter createImplicationFeatureRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link editpolicymodel.UnaryFeatureRule <em>Unary Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see editpolicymodel.UnaryFeatureRule
	 * @generated
	 */
	public Adapter createUnaryFeatureRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link editpolicymodel.OrFeatureRule <em>Or Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see editpolicymodel.OrFeatureRule
	 * @generated
	 */
	public Adapter createOrFeatureRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link editpolicymodel.AndFeatureRule <em>And Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see editpolicymodel.AndFeatureRule
	 * @generated
	 */
	public Adapter createAndFeatureRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link editpolicymodel.SourceEqualsTarget <em>Source Equals Target</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see editpolicymodel.SourceEqualsTarget
	 * @generated
	 */
	public Adapter createSourceEqualsTargetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link editpolicymodel.SourceEqualsTargetType <em>Source Equals Target Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see editpolicymodel.SourceEqualsTargetType
	 * @generated
	 */
	public Adapter createSourceEqualsTargetTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link editpolicymodel.InType <em>In Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see editpolicymodel.InType
	 * @generated
	 */
	public Adapter createInTypeAdapter() {
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

} //editpolicymodelAdapterFactory
