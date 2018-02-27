/**
 */
package Editpolicymodel.impl;

import Editpolicymodel.AbstractConstraintRule;
import Editpolicymodel.AbstractRule;
import Editpolicymodel.ActionEnum;
import Editpolicymodel.ActionTypeEnum;
import Editpolicymodel.AndConstraintRule;
import Editpolicymodel.AndRule;
import Editpolicymodel.BinaryRule;
import Editpolicymodel.Constraint;
import Editpolicymodel.ContainsConstraintRule;
import Editpolicymodel.EditpolicymodelFactory;
import Editpolicymodel.EditpolicymodelPackage;
import Editpolicymodel.FalseConstraintRule;
import Editpolicymodel.Feature;
import Editpolicymodel.IsFeature;
import Editpolicymodel.IsParentConstraintRule;
import Editpolicymodel.IsSourceConstraintRule;
import Editpolicymodel.IsStepOutConstraintRule;
import Editpolicymodel.IsTargetConstraintRule;
import Editpolicymodel.IsTargetType;
import Editpolicymodel.Model;
import Editpolicymodel.NotRule;
import Editpolicymodel.OrConstraintRule;
import Editpolicymodel.Policy;

import Editpolicymodel.Rule;
import Editpolicymodel.TrueConstraintRule;
import Editpolicymodel.UnaryRule;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

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
	private EClass abstractConstraintRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass andConstraintRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orConstraintRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass containsConstraintRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass isStepOutConstraintRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass isTargetConstraintRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass isSourceConstraintRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass isParentConstraintRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass trueConstraintRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass falseConstraintRuleEClass = null;

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
	private EClass featureEClass = null;

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
	private EClass constraintEClass = null;

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
	private EEnum actionEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum actionTypeEnumEEnum = null;

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

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theEditpolicymodelPackage.createPackageContents();

		// Initialize created meta-data
		theEditpolicymodelPackage.initializePackageContents();

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
	public EClass getAbstractConstraintRule() {
		return abstractConstraintRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractConstraintRule_Rule2() {
		return (EReference)abstractConstraintRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractConstraintRule_Rule1() {
		return (EReference)abstractConstraintRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractConstraintRule_Argument() {
		return (EAttribute)abstractConstraintRuleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAndConstraintRule() {
		return andConstraintRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrConstraintRule() {
		return orConstraintRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContainsConstraintRule() {
		return containsConstraintRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIsStepOutConstraintRule() {
		return isStepOutConstraintRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIsTargetConstraintRule() {
		return isTargetConstraintRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIsSourceConstraintRule() {
		return isSourceConstraintRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIsParentConstraintRule() {
		return isParentConstraintRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTrueConstraintRule() {
		return trueConstraintRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFalseConstraintRule() {
		return falseConstraintRuleEClass;
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
	public EAttribute getRule_Rule() {
		return (EAttribute)ruleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeature() {
		return featureEClass;
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
	public EClass getConstraint() {
		return constraintEClass;
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
	public EEnum getActionEnum() {
		return actionEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getActionTypeEnum() {
		return actionTypeEnumEEnum;
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

		abstractConstraintRuleEClass = createEClass(ABSTRACT_CONSTRAINT_RULE);
		createEReference(abstractConstraintRuleEClass, ABSTRACT_CONSTRAINT_RULE__RULE2);
		createEReference(abstractConstraintRuleEClass, ABSTRACT_CONSTRAINT_RULE__RULE1);
		createEAttribute(abstractConstraintRuleEClass, ABSTRACT_CONSTRAINT_RULE__ARGUMENT);

		andConstraintRuleEClass = createEClass(AND_CONSTRAINT_RULE);

		orConstraintRuleEClass = createEClass(OR_CONSTRAINT_RULE);

		containsConstraintRuleEClass = createEClass(CONTAINS_CONSTRAINT_RULE);

		isStepOutConstraintRuleEClass = createEClass(IS_STEP_OUT_CONSTRAINT_RULE);

		isTargetConstraintRuleEClass = createEClass(IS_TARGET_CONSTRAINT_RULE);

		isSourceConstraintRuleEClass = createEClass(IS_SOURCE_CONSTRAINT_RULE);

		isParentConstraintRuleEClass = createEClass(IS_PARENT_CONSTRAINT_RULE);

		trueConstraintRuleEClass = createEClass(TRUE_CONSTRAINT_RULE);

		falseConstraintRuleEClass = createEClass(FALSE_CONSTRAINT_RULE);

		abstractRuleEClass = createEClass(ABSTRACT_RULE);

		ruleEClass = createEClass(RULE);
		createEAttribute(ruleEClass, RULE__RULE);

		featureEClass = createEClass(FEATURE);

		isFeatureEClass = createEClass(IS_FEATURE);

		constraintEClass = createEClass(CONSTRAINT);

		isTargetTypeEClass = createEClass(IS_TARGET_TYPE);

		unaryRuleEClass = createEClass(UNARY_RULE);
		createEReference(unaryRuleEClass, UNARY_RULE__RULE);

		notRuleEClass = createEClass(NOT_RULE);

		andRuleEClass = createEClass(AND_RULE);

		binaryRuleEClass = createEClass(BINARY_RULE);
		createEReference(binaryRuleEClass, BINARY_RULE__LEFT_RULE);
		createEReference(binaryRuleEClass, BINARY_RULE__RIGHT_RULE);

		// Create enums
		actionEnumEEnum = createEEnum(ACTION_ENUM);
		actionTypeEnumEEnum = createEEnum(ACTION_TYPE_ENUM);
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
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters
		addETypeParameter(abstractRuleEClass, "T");
		ETypeParameter ruleEClass_T = addETypeParameter(ruleEClass, "T");
		ETypeParameter unaryRuleEClass_T = addETypeParameter(unaryRuleEClass, "T");
		ETypeParameter binaryRuleEClass_T = addETypeParameter(binaryRuleEClass, "T");

		// Set bounds for type parameters

		// Add supertypes to classes
		andConstraintRuleEClass.getESuperTypes().add(this.getAbstractConstraintRule());
		orConstraintRuleEClass.getESuperTypes().add(this.getAbstractConstraintRule());
		containsConstraintRuleEClass.getESuperTypes().add(this.getAbstractConstraintRule());
		isStepOutConstraintRuleEClass.getESuperTypes().add(this.getAbstractConstraintRule());
		isTargetConstraintRuleEClass.getESuperTypes().add(this.getAbstractConstraintRule());
		isSourceConstraintRuleEClass.getESuperTypes().add(this.getAbstractConstraintRule());
		isParentConstraintRuleEClass.getESuperTypes().add(this.getAbstractConstraintRule());
		trueConstraintRuleEClass.getESuperTypes().add(this.getAbstractConstraintRule());
		falseConstraintRuleEClass.getESuperTypes().add(this.getAbstractConstraintRule());
		ruleEClass.getESuperTypes().add(this.getAbstractRule());
		isFeatureEClass.getESuperTypes().add(this.getFeature());
		isTargetTypeEClass.getESuperTypes().add(this.getConstraint());
		unaryRuleEClass.getESuperTypes().add(this.getAbstractRule());
		notRuleEClass.getESuperTypes().add(this.getUnaryRule());
		andRuleEClass.getESuperTypes().add(this.getBinaryRule());
		binaryRuleEClass.getESuperTypes().add(this.getAbstractRule());

		// Initialize classes, features, and operations; add parameters
		initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModel_Policy(), this.getPolicy(), null, "policy", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(policyEClass, Policy.class, "Policy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPolicy_Override(), ecorePackage.getEBooleanObject(), "override", "false", 0, 1, Policy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPolicy_Action(), this.getActionEnum(), "action", null, 0, 1, Policy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPolicy_ActionType(), this.getActionTypeEnum(), "ActionType", null, 0, 1, Policy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		EGenericType g1 = createEGenericType(this.getAbstractRule());
		EGenericType g2 = createEGenericType(this.getFeature());
		g1.getETypeArguments().add(g2);
		initEReference(getPolicy_FeatureRule(), g1, null, "featureRule", null, 0, -1, Policy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(this.getAbstractRule());
		g2 = createEGenericType(this.getConstraint());
		g1.getETypeArguments().add(g2);
		initEReference(getPolicy_ConstraintRule(), g1, null, "constraintRule", null, 0, -1, Policy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractConstraintRuleEClass, AbstractConstraintRule.class, "AbstractConstraintRule", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractConstraintRule_Rule2(), this.getAbstractConstraintRule(), null, "rule2", null, 0, 1, AbstractConstraintRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractConstraintRule_Rule1(), this.getAbstractConstraintRule(), null, "rule1", null, 0, 1, AbstractConstraintRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractConstraintRule_Argument(), theXMLTypePackage.getString(), "argument", null, 0, 1, AbstractConstraintRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(andConstraintRuleEClass, AndConstraintRule.class, "AndConstraintRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(orConstraintRuleEClass, OrConstraintRule.class, "OrConstraintRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(containsConstraintRuleEClass, ContainsConstraintRule.class, "ContainsConstraintRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(isStepOutConstraintRuleEClass, IsStepOutConstraintRule.class, "IsStepOutConstraintRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(isTargetConstraintRuleEClass, IsTargetConstraintRule.class, "IsTargetConstraintRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(isSourceConstraintRuleEClass, IsSourceConstraintRule.class, "IsSourceConstraintRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(isParentConstraintRuleEClass, IsParentConstraintRule.class, "IsParentConstraintRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(trueConstraintRuleEClass, TrueConstraintRule.class, "TrueConstraintRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(falseConstraintRuleEClass, FalseConstraintRule.class, "FalseConstraintRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(abstractRuleEClass, AbstractRule.class, "AbstractRule", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ruleEClass, Rule.class, "Rule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(ruleEClass_T);
		initEAttribute(getRule_Rule(), g1, "rule", null, 0, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featureEClass, Feature.class, "Feature", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(isFeatureEClass, IsFeature.class, "IsFeature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(constraintEClass, Constraint.class, "Constraint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

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
		initEReference(getBinaryRule_RightRule(), g1, null, "rightRule", null, 0, -1, BinaryRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(actionEnumEEnum, ActionEnum.class, "ActionEnum");
		addEEnumLiteral(actionEnumEEnum, ActionEnum.CREATE);
		addEEnumLiteral(actionEnumEEnum, ActionEnum.ADD);
		addEEnumLiteral(actionEnumEEnum, ActionEnum.START);
		addEEnumLiteral(actionEnumEEnum, ActionEnum.RECONNECT);

		initEEnum(actionTypeEnumEEnum, ActionTypeEnum.class, "ActionTypeEnum");
		addEEnumLiteral(actionTypeEnumEEnum, ActionTypeEnum.FULFILLMENT);
		addEEnumLiteral(actionTypeEnumEEnum, ActionTypeEnum.INHERITANCE);
		addEEnumLiteral(actionTypeEnumEEnum, ActionTypeEnum.RELATIONSHIP);
		addEEnumLiteral(actionTypeEnumEEnum, ActionTypeEnum.COMPARTMENT);

		// Create resource
		createResource(eNS_URI);
	}

} //EditpolicymodelPackageImpl
