/**
 */
package Editpolicymodel.impl;

import Editpolicymodel.AbstractRule;
import Editpolicymodel.ActionEnum;
import Editpolicymodel.AndRule;
import Editpolicymodel.BinaryRule;
import Editpolicymodel.ConstraintRule;
import Editpolicymodel.Contains;
import Editpolicymodel.EditpolicymodelFactory;
import Editpolicymodel.EditpolicymodelPackage;
import Editpolicymodel.FalseRule;
import Editpolicymodel.FeatureRule;
import Editpolicymodel.ImplicationRule;
import Editpolicymodel.IsFeature;
import Editpolicymodel.IsParent;
import Editpolicymodel.IsSource;
import Editpolicymodel.IsSourceType;
import Editpolicymodel.IsStepOut;
import Editpolicymodel.IsTarget;
import Editpolicymodel.IsTargetType;
import Editpolicymodel.Model;
import Editpolicymodel.NotRule;
import Editpolicymodel.OrRule;
import Editpolicymodel.Policy;
import Editpolicymodel.Rule;
import Editpolicymodel.TrueRule;
import Editpolicymodel.TypeArgumentRule;
import Editpolicymodel.UnaryRule;

import iorm.IormPackage;

import iorm.featuremodel.FeaturemodelPackage;

import iorm.featuremodel.impl.FeaturemodelPackageImpl;

import iorm.impl.IormPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EditpolicymodelPackageImpl extends EPackageImpl implements EditpolicymodelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass policyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass containsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass isStepOutEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass isTargetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass isSourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass isParentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass isFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass isTargetTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unaryRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass notRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass andRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binaryRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass trueRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass falseRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass implicationRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass isSourceTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeArgumentRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum actionEnumEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see Editpolicymodel.EditpolicymodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EditpolicymodelPackageImpl() {
		super(eNS_URI, EditpolicymodelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link EditpolicymodelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EditpolicymodelPackage init() {
		if (isInited) return (EditpolicymodelPackage)EPackage.Registry.INSTANCE.getEPackage(EditpolicymodelPackage.eNS_URI);

		// Obtain or create and register package
		EditpolicymodelPackageImpl theEditpolicymodelPackage = (EditpolicymodelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EditpolicymodelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EditpolicymodelPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		IormPackageImpl theIormPackage = (IormPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(IormPackage.eNS_URI) instanceof IormPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(IormPackage.eNS_URI) : IormPackage.eINSTANCE);
		FeaturemodelPackageImpl theFeaturemodelPackage = (FeaturemodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(FeaturemodelPackage.eNS_URI) instanceof FeaturemodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(FeaturemodelPackage.eNS_URI) : FeaturemodelPackage.eINSTANCE);
		featuremodel.impl.FeaturemodelPackageImpl theFeaturemodelPackage_1 = (featuremodel.impl.FeaturemodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(featuremodel.FeaturemodelPackage.eNS_URI) instanceof featuremodel.impl.FeaturemodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(featuremodel.FeaturemodelPackage.eNS_URI) : featuremodel.FeaturemodelPackage.eINSTANCE);

		// Create package meta-data objects
		theEditpolicymodelPackage.createPackageContents();
		theIormPackage.createPackageContents();
		theFeaturemodelPackage.createPackageContents();
		theFeaturemodelPackage_1.createPackageContents();

		// Initialize created meta-data
		theEditpolicymodelPackage.initializePackageContents();
		theIormPackage.initializePackageContents();
		theFeaturemodelPackage.initializePackageContents();
		theFeaturemodelPackage_1.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEditpolicymodelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EditpolicymodelPackage.eNS_URI, theEditpolicymodelPackage);
		return theEditpolicymodelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModel() {
		return modelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_Policy() {
		return (EReference)modelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPolicy() {
		return policyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPolicy_Override() {
		return (EAttribute)policyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPolicy_Action() {
		return (EAttribute)policyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPolicy_ActionType() {
		return (EAttribute)policyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPolicy_FeatureRule() {
		return (EReference)policyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPolicy_ConstraintRule() {
		return (EReference)policyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContains() {
		return containsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIsStepOut() {
		return isStepOutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIsTarget() {
		return isTargetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIsSource() {
		return isSourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIsParent() {
		return isParentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractRule() {
		return abstractRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRule() {
		return ruleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRule_Rule() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureRule() {
		return featureRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIsFeature() {
		return isFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIsFeature_Name() {
		return (EAttribute)isFeatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstraintRule() {
		return constraintRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIsTargetType() {
		return isTargetTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnaryRule() {
		return unaryRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnaryRule_Rule() {
		return (EReference)unaryRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNotRule() {
		return notRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAndRule() {
		return andRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBinaryRule() {
		return binaryRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinaryRule_LeftRule() {
		return (EReference)binaryRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinaryRule_RightRule() {
		return (EReference)binaryRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTrueRule() {
		return trueRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFalseRule() {
		return falseRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrRule() {
		return orRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImplicationRule() {
		return implicationRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIsSourceType() {
		return isSourceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeArgumentRule() {
		return typeArgumentRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypeArgumentRule_Type() {
		return (EAttribute)typeArgumentRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getActionEnum() {
		return actionEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EditpolicymodelFactory getEditpolicymodelFactory() {
		return (EditpolicymodelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		modelEClass = createEClass(MODEL);
		createEReference(modelEClass, MODEL__POLICY);

		policyEClass = createEClass(POLICY);
		createEAttribute(policyEClass, POLICY__OVERRIDE);
		createEAttribute(policyEClass, POLICY__ACTION);
		createEAttribute(policyEClass, POLICY__ACTION_TYPE);
		createEReference(policyEClass, POLICY__FEATURE_RULE);
		createEReference(policyEClass, POLICY__CONSTRAINT_RULE);

		containsEClass = createEClass(CONTAINS);

		isStepOutEClass = createEClass(IS_STEP_OUT);

		isTargetEClass = createEClass(IS_TARGET);

		isSourceEClass = createEClass(IS_SOURCE);

		isParentEClass = createEClass(IS_PARENT);

		abstractRuleEClass = createEClass(ABSTRACT_RULE);

		ruleEClass = createEClass(RULE);
		createEReference(ruleEClass, RULE__RULE);

		featureRuleEClass = createEClass(FEATURE_RULE);

		isFeatureEClass = createEClass(IS_FEATURE);
		createEAttribute(isFeatureEClass, IS_FEATURE__NAME);

		constraintRuleEClass = createEClass(CONSTRAINT_RULE);

		isTargetTypeEClass = createEClass(IS_TARGET_TYPE);

		unaryRuleEClass = createEClass(UNARY_RULE);
		createEReference(unaryRuleEClass, UNARY_RULE__RULE);

		notRuleEClass = createEClass(NOT_RULE);

		andRuleEClass = createEClass(AND_RULE);

		binaryRuleEClass = createEClass(BINARY_RULE);
		createEReference(binaryRuleEClass, BINARY_RULE__LEFT_RULE);
		createEReference(binaryRuleEClass, BINARY_RULE__RIGHT_RULE);

		trueRuleEClass = createEClass(TRUE_RULE);

		falseRuleEClass = createEClass(FALSE_RULE);

		orRuleEClass = createEClass(OR_RULE);

		implicationRuleEClass = createEClass(IMPLICATION_RULE);

		isSourceTypeEClass = createEClass(IS_SOURCE_TYPE);

		typeArgumentRuleEClass = createEClass(TYPE_ARGUMENT_RULE);
		createEAttribute(typeArgumentRuleEClass, TYPE_ARGUMENT_RULE__TYPE);

		// Create enums
		actionEnumEEnum = createEEnum(ACTION_ENUM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		IormPackage theIormPackage = (IormPackage)EPackage.Registry.INSTANCE.getEPackage(IormPackage.eNS_URI);
		FeaturemodelPackage theFeaturemodelPackage = (FeaturemodelPackage)EPackage.Registry.INSTANCE.getEPackage(FeaturemodelPackage.eNS_URI);

		// Create type parameters
		addETypeParameter(abstractRuleEClass, "T");
		ETypeParameter ruleEClass_T = addETypeParameter(ruleEClass, "T");
		ETypeParameter unaryRuleEClass_T = addETypeParameter(unaryRuleEClass, "T");
		ETypeParameter binaryRuleEClass_T = addETypeParameter(binaryRuleEClass, "T");

		// Set bounds for type parameters

		// Add supertypes to classes
		containsEClass.getESuperTypes().add(this.getTypeArgumentRule());
		isStepOutEClass.getESuperTypes().add(this.getConstraintRule());
		isTargetEClass.getESuperTypes().add(this.getTypeArgumentRule());
		isSourceEClass.getESuperTypes().add(this.getTypeArgumentRule());
		isParentEClass.getESuperTypes().add(this.getTypeArgumentRule());
		ruleEClass.getESuperTypes().add(this.getAbstractRule());
		isFeatureEClass.getESuperTypes().add(this.getFeatureRule());
		isTargetTypeEClass.getESuperTypes().add(this.getTypeArgumentRule());
		unaryRuleEClass.getESuperTypes().add(this.getAbstractRule());
		notRuleEClass.getESuperTypes().add(this.getUnaryRule());
		andRuleEClass.getESuperTypes().add(this.getBinaryRule());
		binaryRuleEClass.getESuperTypes().add(this.getAbstractRule());
		trueRuleEClass.getESuperTypes().add(this.getAbstractRule());
		falseRuleEClass.getESuperTypes().add(this.getAbstractRule());
		orRuleEClass.getESuperTypes().add(this.getBinaryRule());
		implicationRuleEClass.getESuperTypes().add(this.getBinaryRule());
		isSourceTypeEClass.getESuperTypes().add(this.getTypeArgumentRule());
		typeArgumentRuleEClass.getESuperTypes().add(this.getConstraintRule());

		// Initialize classes, features, and operations; add parameters
		initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModel_Policy(), this.getPolicy(), null, "policy", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(policyEClass, Policy.class, "Policy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPolicy_Override(), ecorePackage.getEBooleanObject(), "override", "false", 0, 1, Policy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPolicy_Action(), this.getActionEnum(), "action", "Create", 0, 1, Policy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPolicy_ActionType(), theIormPackage.getType(), "ActionType", "CompartmentType", 0, 1, Policy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		EGenericType g1 = createEGenericType(this.getAbstractRule());
		EGenericType g2 = createEGenericType(this.getFeatureRule());
		g1.getETypeArguments().add(g2);
		initEReference(getPolicy_FeatureRule(), g1, null, "featureRule", null, 0, 1, Policy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(this.getAbstractRule());
		g2 = createEGenericType(this.getConstraintRule());
		g1.getETypeArguments().add(g2);
		initEReference(getPolicy_ConstraintRule(), g1, null, "constraintRule", null, 0, 1, Policy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(containsEClass, Contains.class, "Contains", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(isStepOutEClass, IsStepOut.class, "IsStepOut", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(isTargetEClass, IsTarget.class, "IsTarget", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(isSourceEClass, IsSource.class, "IsSource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(isParentEClass, IsParent.class, "IsParent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(abstractRuleEClass, AbstractRule.class, "AbstractRule", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ruleEClass, Rule.class, "Rule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(ruleEClass_T);
		initEReference(getRule_Rule(), g1, null, "rule", null, 0, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featureRuleEClass, FeatureRule.class, "FeatureRule", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(isFeatureEClass, IsFeature.class, "IsFeature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIsFeature_Name(), theFeaturemodelPackage.getFeatureName(), "name", null, 0, 1, IsFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constraintRuleEClass, ConstraintRule.class, "ConstraintRule", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(isTargetTypeEClass, IsTargetType.class, "IsTargetType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(unaryRuleEClass, UnaryRule.class, "UnaryRule", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(this.getAbstractRule());
		g2 = createEGenericType(unaryRuleEClass_T);
		g1.getETypeArguments().add(g2);
		initEReference(getUnaryRule_Rule(), g1, null, "rule", null, 0, 1, UnaryRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(notRuleEClass, NotRule.class, "NotRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(andRuleEClass, AndRule.class, "AndRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(binaryRuleEClass, BinaryRule.class, "BinaryRule", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(this.getAbstractRule());
		g2 = createEGenericType(binaryRuleEClass_T);
		g1.getETypeArguments().add(g2);
		initEReference(getBinaryRule_LeftRule(), g1, null, "leftRule", null, 0, 1, BinaryRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(this.getAbstractRule());
		g2 = createEGenericType(binaryRuleEClass_T);
		g1.getETypeArguments().add(g2);
		initEReference(getBinaryRule_RightRule(), g1, null, "rightRule", null, 0, 1, BinaryRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(trueRuleEClass, TrueRule.class, "TrueRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(falseRuleEClass, FalseRule.class, "FalseRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(orRuleEClass, OrRule.class, "OrRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(implicationRuleEClass, ImplicationRule.class, "ImplicationRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(isSourceTypeEClass, IsSourceType.class, "IsSourceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(typeArgumentRuleEClass, TypeArgumentRule.class, "TypeArgumentRule", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTypeArgumentRule_Type(), theIormPackage.getType(), "type", null, 0, 1, TypeArgumentRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(actionEnumEEnum, ActionEnum.class, "ActionEnum");
		addEEnumLiteral(actionEnumEEnum, ActionEnum.CREATE);
		addEEnumLiteral(actionEnumEEnum, ActionEnum.ADD);
		addEEnumLiteral(actionEnumEEnum, ActionEnum.START);
		addEEnumLiteral(actionEnumEEnum, ActionEnum.RECONNECT);

		// Create resource
		createResource(eNS_URI);
	}

} //EditpolicymodelPackageImpl
