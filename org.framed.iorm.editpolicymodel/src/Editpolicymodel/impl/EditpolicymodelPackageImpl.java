/**
 */
package Editpolicymodel.impl;

import Editpolicymodel.ActionEnum;
import Editpolicymodel.AndConstraintRule;
import Editpolicymodel.AndFeatureRule;
import Editpolicymodel.BinaryConstraintRule;
import Editpolicymodel.BinaryFeatureRule;
import Editpolicymodel.ConstraintRule;
import Editpolicymodel.Contains;
import Editpolicymodel.EditpolicymodelFactory;
import Editpolicymodel.EditpolicymodelPackage;
import Editpolicymodel.FalseConstraintRule;
import Editpolicymodel.FalseFeatureRule;
import Editpolicymodel.FeatureNameEnum;
import Editpolicymodel.FeatureRule;
import Editpolicymodel.ImplicationConstraintRule;
import Editpolicymodel.ImplicationFeatureRule;
import Editpolicymodel.IsFeature;
import Editpolicymodel.IsParent;
import Editpolicymodel.IsSource;
import Editpolicymodel.IsSourceType;
import Editpolicymodel.IsStepIn;
import Editpolicymodel.IsTarget;
import Editpolicymodel.IsTargetType;
import Editpolicymodel.LogicalConstraintRule;
import Editpolicymodel.LogicalFeatureRule;
import Editpolicymodel.Model;
import Editpolicymodel.NaryConstraintRule;
import Editpolicymodel.NaryFeatureRule;
import Editpolicymodel.NotConstraintRule;
import Editpolicymodel.NotFeatureRule;
import Editpolicymodel.OrConstraintRule;
import Editpolicymodel.OrFeatureRule;
import Editpolicymodel.Policy;
import Editpolicymodel.TrueConstraintRule;
import Editpolicymodel.TrueFeatureRule;
import Editpolicymodel.TypeArgumentRule;
import Editpolicymodel.TypeEnum;
import Editpolicymodel.UnaryConstraintRule;
import Editpolicymodel.UnaryFeatureRule;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.framed.iorm.model.OrmPackage;

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
	private EClass isStepInEClass = null;

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
	private EClass unaryConstraintRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass notConstraintRuleEClass = null;

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
	private EClass binaryConstraintRuleEClass = null;

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
	private EClass orConstraintRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass implicationConstraintRuleEClass = null;

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
	private EClass naryConstraintRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass logicalConstraintRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass trueFeatureRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass notFeatureRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass falseFeatureRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass naryFeatureRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binaryFeatureRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass logicalFeatureRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass implicationFeatureRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unaryFeatureRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orFeatureRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass andFeatureRuleEClass = null;

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
	private EEnum typeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum featureNameEnumEEnum = null;

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
		OrmPackage.eINSTANCE.eClass();

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
	public EReference getModel_Policies() {
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
	public EClass getIsStepIn() {
		return isStepInEClass;
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
	public EAttribute getIsFeature_FeatureName() {
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
	public EClass getUnaryConstraintRule() {
		return unaryConstraintRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnaryConstraintRule_Rule() {
		return (EReference)unaryConstraintRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNotConstraintRule() {
		return notConstraintRuleEClass;
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
	public EClass getBinaryConstraintRule() {
		return binaryConstraintRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinaryConstraintRule_LeftRule() {
		return (EReference)binaryConstraintRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinaryConstraintRule_RightRule() {
		return (EReference)binaryConstraintRuleEClass.getEStructuralFeatures().get(1);
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
	public EClass getOrConstraintRule() {
		return orConstraintRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImplicationConstraintRule() {
		return implicationConstraintRuleEClass;
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
	public EClass getNaryConstraintRule() {
		return naryConstraintRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNaryConstraintRule_Rules() {
		return (EReference)naryConstraintRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLogicalConstraintRule() {
		return logicalConstraintRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTrueFeatureRule() {
		return trueFeatureRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNotFeatureRule() {
		return notFeatureRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFalseFeatureRule() {
		return falseFeatureRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNaryFeatureRule() {
		return naryFeatureRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNaryFeatureRule_Rules() {
		return (EReference)naryFeatureRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBinaryFeatureRule() {
		return binaryFeatureRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinaryFeatureRule_RightRule() {
		return (EReference)binaryFeatureRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinaryFeatureRule_LeftRule() {
		return (EReference)binaryFeatureRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLogicalFeatureRule() {
		return logicalFeatureRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImplicationFeatureRule() {
		return implicationFeatureRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnaryFeatureRule() {
		return unaryFeatureRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnaryFeatureRule_Rule() {
		return (EReference)unaryFeatureRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrFeatureRule() {
		return orFeatureRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAndFeatureRule() {
		return andFeatureRuleEClass;
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
	public EEnum getTypeEnum() {
		return typeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFeatureNameEnum() {
		return featureNameEnumEEnum;
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
		createEReference(modelEClass, MODEL__POLICIES);

		policyEClass = createEClass(POLICY);
		createEAttribute(policyEClass, POLICY__OVERRIDE);
		createEAttribute(policyEClass, POLICY__ACTION);
		createEAttribute(policyEClass, POLICY__ACTION_TYPE);
		createEReference(policyEClass, POLICY__FEATURE_RULE);
		createEReference(policyEClass, POLICY__CONSTRAINT_RULE);

		containsEClass = createEClass(CONTAINS);

		isStepInEClass = createEClass(IS_STEP_IN);

		isTargetEClass = createEClass(IS_TARGET);

		isSourceEClass = createEClass(IS_SOURCE);

		isParentEClass = createEClass(IS_PARENT);

		featureRuleEClass = createEClass(FEATURE_RULE);

		isFeatureEClass = createEClass(IS_FEATURE);
		createEAttribute(isFeatureEClass, IS_FEATURE__FEATURE_NAME);

		constraintRuleEClass = createEClass(CONSTRAINT_RULE);

		isTargetTypeEClass = createEClass(IS_TARGET_TYPE);

		unaryConstraintRuleEClass = createEClass(UNARY_CONSTRAINT_RULE);
		createEReference(unaryConstraintRuleEClass, UNARY_CONSTRAINT_RULE__RULE);

		notConstraintRuleEClass = createEClass(NOT_CONSTRAINT_RULE);

		andConstraintRuleEClass = createEClass(AND_CONSTRAINT_RULE);

		binaryConstraintRuleEClass = createEClass(BINARY_CONSTRAINT_RULE);
		createEReference(binaryConstraintRuleEClass, BINARY_CONSTRAINT_RULE__LEFT_RULE);
		createEReference(binaryConstraintRuleEClass, BINARY_CONSTRAINT_RULE__RIGHT_RULE);

		trueConstraintRuleEClass = createEClass(TRUE_CONSTRAINT_RULE);

		falseConstraintRuleEClass = createEClass(FALSE_CONSTRAINT_RULE);

		orConstraintRuleEClass = createEClass(OR_CONSTRAINT_RULE);

		implicationConstraintRuleEClass = createEClass(IMPLICATION_CONSTRAINT_RULE);

		isSourceTypeEClass = createEClass(IS_SOURCE_TYPE);

		typeArgumentRuleEClass = createEClass(TYPE_ARGUMENT_RULE);
		createEAttribute(typeArgumentRuleEClass, TYPE_ARGUMENT_RULE__TYPE);

		naryConstraintRuleEClass = createEClass(NARY_CONSTRAINT_RULE);
		createEReference(naryConstraintRuleEClass, NARY_CONSTRAINT_RULE__RULES);

		logicalConstraintRuleEClass = createEClass(LOGICAL_CONSTRAINT_RULE);

		trueFeatureRuleEClass = createEClass(TRUE_FEATURE_RULE);

		notFeatureRuleEClass = createEClass(NOT_FEATURE_RULE);

		falseFeatureRuleEClass = createEClass(FALSE_FEATURE_RULE);

		naryFeatureRuleEClass = createEClass(NARY_FEATURE_RULE);
		createEReference(naryFeatureRuleEClass, NARY_FEATURE_RULE__RULES);

		binaryFeatureRuleEClass = createEClass(BINARY_FEATURE_RULE);
		createEReference(binaryFeatureRuleEClass, BINARY_FEATURE_RULE__RIGHT_RULE);
		createEReference(binaryFeatureRuleEClass, BINARY_FEATURE_RULE__LEFT_RULE);

		logicalFeatureRuleEClass = createEClass(LOGICAL_FEATURE_RULE);

		implicationFeatureRuleEClass = createEClass(IMPLICATION_FEATURE_RULE);

		unaryFeatureRuleEClass = createEClass(UNARY_FEATURE_RULE);
		createEReference(unaryFeatureRuleEClass, UNARY_FEATURE_RULE__RULE);

		orFeatureRuleEClass = createEClass(OR_FEATURE_RULE);

		andFeatureRuleEClass = createEClass(AND_FEATURE_RULE);

		// Create enums
		actionEnumEEnum = createEEnum(ACTION_ENUM);
		typeEnumEEnum = createEEnum(TYPE_ENUM);
		featureNameEnumEEnum = createEEnum(FEATURE_NAME_ENUM);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		containsEClass.getESuperTypes().add(this.getTypeArgumentRule());
		isStepInEClass.getESuperTypes().add(this.getConstraintRule());
		isTargetEClass.getESuperTypes().add(this.getTypeArgumentRule());
		isSourceEClass.getESuperTypes().add(this.getTypeArgumentRule());
		isParentEClass.getESuperTypes().add(this.getTypeArgumentRule());
		isFeatureEClass.getESuperTypes().add(this.getFeatureRule());
		isTargetTypeEClass.getESuperTypes().add(this.getTypeArgumentRule());
		unaryConstraintRuleEClass.getESuperTypes().add(this.getLogicalConstraintRule());
		notConstraintRuleEClass.getESuperTypes().add(this.getUnaryConstraintRule());
		andConstraintRuleEClass.getESuperTypes().add(this.getNaryConstraintRule());
		binaryConstraintRuleEClass.getESuperTypes().add(this.getLogicalConstraintRule());
		trueConstraintRuleEClass.getESuperTypes().add(this.getLogicalConstraintRule());
		falseConstraintRuleEClass.getESuperTypes().add(this.getLogicalConstraintRule());
		orConstraintRuleEClass.getESuperTypes().add(this.getNaryConstraintRule());
		implicationConstraintRuleEClass.getESuperTypes().add(this.getBinaryConstraintRule());
		isSourceTypeEClass.getESuperTypes().add(this.getTypeArgumentRule());
		typeArgumentRuleEClass.getESuperTypes().add(this.getConstraintRule());
		naryConstraintRuleEClass.getESuperTypes().add(this.getLogicalConstraintRule());
		logicalConstraintRuleEClass.getESuperTypes().add(this.getConstraintRule());
		trueFeatureRuleEClass.getESuperTypes().add(this.getLogicalFeatureRule());
		notFeatureRuleEClass.getESuperTypes().add(this.getUnaryFeatureRule());
		falseFeatureRuleEClass.getESuperTypes().add(this.getLogicalFeatureRule());
		naryFeatureRuleEClass.getESuperTypes().add(this.getLogicalFeatureRule());
		binaryFeatureRuleEClass.getESuperTypes().add(this.getLogicalFeatureRule());
		logicalFeatureRuleEClass.getESuperTypes().add(this.getFeatureRule());
		implicationFeatureRuleEClass.getESuperTypes().add(this.getBinaryFeatureRule());
		unaryFeatureRuleEClass.getESuperTypes().add(this.getLogicalFeatureRule());
		orFeatureRuleEClass.getESuperTypes().add(this.getNaryFeatureRule());
		andFeatureRuleEClass.getESuperTypes().add(this.getNaryFeatureRule());

		// Initialize classes, features, and operations; add parameters
		initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModel_Policies(), this.getPolicy(), null, "policies", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(policyEClass, Policy.class, "Policy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPolicy_Override(), ecorePackage.getEBooleanObject(), "override", "false", 0, 1, Policy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPolicy_Action(), this.getActionEnum(), "action", "Create", 0, 1, Policy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPolicy_ActionType(), this.getTypeEnum(), "actionType", null, 1, 1, Policy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPolicy_FeatureRule(), this.getFeatureRule(), null, "featureRule", null, 0, 1, Policy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPolicy_ConstraintRule(), this.getConstraintRule(), null, "constraintRule", null, 0, 1, Policy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(containsEClass, Contains.class, "Contains", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(isStepInEClass, IsStepIn.class, "IsStepIn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(isTargetEClass, IsTarget.class, "IsTarget", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(isSourceEClass, IsSource.class, "IsSource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(isParentEClass, IsParent.class, "IsParent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(featureRuleEClass, FeatureRule.class, "FeatureRule", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(isFeatureEClass, IsFeature.class, "IsFeature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIsFeature_FeatureName(), this.getFeatureNameEnum(), "featureName", null, 1, 1, IsFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constraintRuleEClass, ConstraintRule.class, "ConstraintRule", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(isTargetTypeEClass, IsTargetType.class, "IsTargetType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(unaryConstraintRuleEClass, UnaryConstraintRule.class, "UnaryConstraintRule", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnaryConstraintRule_Rule(), this.getConstraintRule(), null, "rule", null, 1, 1, UnaryConstraintRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(notConstraintRuleEClass, NotConstraintRule.class, "NotConstraintRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(andConstraintRuleEClass, AndConstraintRule.class, "AndConstraintRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(binaryConstraintRuleEClass, BinaryConstraintRule.class, "BinaryConstraintRule", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBinaryConstraintRule_LeftRule(), this.getConstraintRule(), null, "leftRule", null, 1, 1, BinaryConstraintRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBinaryConstraintRule_RightRule(), this.getConstraintRule(), null, "rightRule", null, 1, 1, BinaryConstraintRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(trueConstraintRuleEClass, TrueConstraintRule.class, "TrueConstraintRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(falseConstraintRuleEClass, FalseConstraintRule.class, "FalseConstraintRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(orConstraintRuleEClass, OrConstraintRule.class, "OrConstraintRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(implicationConstraintRuleEClass, ImplicationConstraintRule.class, "ImplicationConstraintRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(isSourceTypeEClass, IsSourceType.class, "IsSourceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(typeArgumentRuleEClass, TypeArgumentRule.class, "TypeArgumentRule", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTypeArgumentRule_Type(), this.getTypeEnum(), "type", null, 0, 1, TypeArgumentRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(naryConstraintRuleEClass, NaryConstraintRule.class, "NaryConstraintRule", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNaryConstraintRule_Rules(), this.getConstraintRule(), null, "rules", null, 1, -1, NaryConstraintRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(logicalConstraintRuleEClass, LogicalConstraintRule.class, "LogicalConstraintRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(trueFeatureRuleEClass, TrueFeatureRule.class, "TrueFeatureRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(notFeatureRuleEClass, NotFeatureRule.class, "NotFeatureRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(falseFeatureRuleEClass, FalseFeatureRule.class, "FalseFeatureRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(naryFeatureRuleEClass, NaryFeatureRule.class, "NaryFeatureRule", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNaryFeatureRule_Rules(), this.getFeatureRule(), null, "rules", null, 0, -1, NaryFeatureRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(binaryFeatureRuleEClass, BinaryFeatureRule.class, "BinaryFeatureRule", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBinaryFeatureRule_RightRule(), this.getFeatureRule(), null, "rightRule", null, 1, 1, BinaryFeatureRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBinaryFeatureRule_LeftRule(), this.getFeatureRule(), null, "leftRule", null, 1, 1, BinaryFeatureRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(logicalFeatureRuleEClass, LogicalFeatureRule.class, "LogicalFeatureRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(implicationFeatureRuleEClass, ImplicationFeatureRule.class, "ImplicationFeatureRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(unaryFeatureRuleEClass, UnaryFeatureRule.class, "UnaryFeatureRule", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnaryFeatureRule_Rule(), this.getFeatureRule(), null, "rule", null, 1, 1, UnaryFeatureRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(orFeatureRuleEClass, OrFeatureRule.class, "OrFeatureRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(andFeatureRuleEClass, AndFeatureRule.class, "AndFeatureRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(actionEnumEEnum, ActionEnum.class, "ActionEnum");
		addEEnumLiteral(actionEnumEEnum, ActionEnum.CREATE);
		addEEnumLiteral(actionEnumEEnum, ActionEnum.ADD);
		addEEnumLiteral(actionEnumEEnum, ActionEnum.START);
		addEEnumLiteral(actionEnumEEnum, ActionEnum.RECONNECT);
		addEEnumLiteral(actionEnumEEnum, ActionEnum.EXECUTE);

		initEEnum(typeEnumEEnum, TypeEnum.class, "TypeEnum");
		addEEnumLiteral(typeEnumEEnum, TypeEnum.ACYCLIC);
		addEEnumLiteral(typeEnumEEnum, TypeEnum.COMPARTMENT_TYPE);
		addEEnumLiteral(typeEnumEEnum, TypeEnum.IRREFLEXIVE);
		addEEnumLiteral(typeEnumEEnum, TypeEnum.ROLE_PROHIBITION);
		addEEnumLiteral(typeEnumEEnum, TypeEnum.ROLE_IMPLICATION);
		addEEnumLiteral(typeEnumEEnum, TypeEnum.ROLE_GROUP);
		addEEnumLiteral(typeEnumEEnum, TypeEnum.ROLE_EQUIVALENCE);
		addEEnumLiteral(typeEnumEEnum, TypeEnum.ROLE_TYPE);
		addEEnumLiteral(typeEnumEEnum, TypeEnum.RELATIONSHIP_IMPLICATION);
		addEEnumLiteral(typeEnumEEnum, TypeEnum.RELATIONSHIP_EXCLUSION);
		addEEnumLiteral(typeEnumEEnum, TypeEnum.RELATIONSHIP);
		addEEnumLiteral(typeEnumEEnum, TypeEnum.REFLEXIVE);
		addEEnumLiteral(typeEnumEEnum, TypeEnum.GROUP);
		addEEnumLiteral(typeEnumEEnum, TypeEnum.INHERITANCE);
		addEEnumLiteral(typeEnumEEnum, TypeEnum.FULFILLMENT);
		addEEnumLiteral(typeEnumEEnum, TypeEnum.DATA_TYPE);
		addEEnumLiteral(typeEnumEEnum, TypeEnum.CYCLIC);

		initEEnum(featureNameEnumEEnum, FeatureNameEnum.class, "FeatureNameEnum");
		addEEnumLiteral(featureNameEnumEEnum, FeatureNameEnum.ROLES);
		addEEnumLiteral(featureNameEnumEEnum, FeatureNameEnum.ROLE_TYPES);
		addEEnumLiteral(featureNameEnumEEnum, FeatureNameEnum.ROLE_STRUCTURE);
		addEEnumLiteral(featureNameEnumEEnum, FeatureNameEnum.ROLE_PROPERTIES);
		addEEnumLiteral(featureNameEnumEEnum, FeatureNameEnum.ROLE_PROHIBITION);
		addEEnumLiteral(featureNameEnumEEnum, FeatureNameEnum.ROLE_INHERITANCE);
		addEEnumLiteral(featureNameEnumEEnum, FeatureNameEnum.ROLE_IMPLICATION);
		addEEnumLiteral(featureNameEnumEEnum, FeatureNameEnum.ROLE_EQUIVALENCE);
		addEEnumLiteral(featureNameEnumEEnum, FeatureNameEnum.ROLE_CONSTRAINTS);
		addEEnumLiteral(featureNameEnumEEnum, FeatureNameEnum.ROLE_BEHAVIOR);
		addEEnumLiteral(featureNameEnumEEnum, FeatureNameEnum.RML_FEATURE_MODEL);
		addEEnumLiteral(featureNameEnumEEnum, FeatureNameEnum.RELATIONSHIPS);
		addEEnumLiteral(featureNameEnumEEnum, FeatureNameEnum.RELATIONSHIP_CONSTRAINTS);
		addEEnumLiteral(featureNameEnumEEnum, FeatureNameEnum.RELATIONSHIP_CARDINALITY);
		addEEnumLiteral(featureNameEnumEEnum, FeatureNameEnum.PLAYERS);
		addEEnumLiteral(featureNameEnumEEnum, FeatureNameEnum.PLAYABLE_BY_DEFINING_COMPARTMENT);
		addEEnumLiteral(featureNameEnumEEnum, FeatureNameEnum.PLAYABLE);
		addEEnumLiteral(featureNameEnumEEnum, FeatureNameEnum.PARTHOOD_CONSTRAINTS);
		addEEnumLiteral(featureNameEnumEEnum, FeatureNameEnum.ON_RELATIONSHIPS);
		addEEnumLiteral(featureNameEnumEEnum, FeatureNameEnum.ON_COMPARTMENTS);
		addEEnumLiteral(featureNameEnumEEnum, FeatureNameEnum.OCCURRENCE_CONSTRAINTS);
		addEEnumLiteral(featureNameEnumEEnum, FeatureNameEnum.NATURALS);
		addEEnumLiteral(featureNameEnumEEnum, FeatureNameEnum.INTRA_RELATIONSHIP_CONSTRAINTS);
		addEEnumLiteral(featureNameEnumEEnum, FeatureNameEnum.INTER_RELATIONSHIP_CONSTRAINTS);
		addEEnumLiteral(featureNameEnumEEnum, FeatureNameEnum.GROUP_CONSTRAINTS);
		addEEnumLiteral(featureNameEnumEEnum, FeatureNameEnum.DEPENDENT);
		addEEnumLiteral(featureNameEnumEEnum, FeatureNameEnum.DATES);
		addEEnumLiteral(featureNameEnumEEnum, FeatureNameEnum.DATA_TYPES);
		addEEnumLiteral(featureNameEnumEEnum, FeatureNameEnum.COMPARTMENTS);
		addEEnumLiteral(featureNameEnumEEnum, FeatureNameEnum.CONTAINS_COMPARTMENTS);
		addEEnumLiteral(featureNameEnumEEnum, FeatureNameEnum.COMPARTMENT_TYPES);
		addEEnumLiteral(featureNameEnumEEnum, FeatureNameEnum.COMPARTMENT_STRUCTURE);
		addEEnumLiteral(featureNameEnumEEnum, FeatureNameEnum.COMPARTMENT_PROPERTIES);
		addEEnumLiteral(featureNameEnumEEnum, FeatureNameEnum.COMPARTMENT_INHERITANCE);
		addEEnumLiteral(featureNameEnumEEnum, FeatureNameEnum.COMPARTMENT_BEHAVIOR);
		addEEnumLiteral(featureNameEnumEEnum, FeatureNameEnum.PARTICIPANTS);
		addEEnumLiteral(featureNameEnumEEnum, FeatureNameEnum.DATA_TYPE_INHERITANCE);

		// Create resource
		createResource(eNS_URI);
	}

} //EditpolicymodelPackageImpl
