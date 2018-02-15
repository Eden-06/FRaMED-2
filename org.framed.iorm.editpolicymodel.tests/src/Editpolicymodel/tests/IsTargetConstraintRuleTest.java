/**
 */
package Editpolicymodel.tests;

import Editpolicymodel.EditpolicymodelFactory;
import Editpolicymodel.IsTargetConstraintRule;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Is Target Constraint Rule</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class IsTargetConstraintRuleTest extends AbstractConstraintRuleTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(IsTargetConstraintRuleTest.class);
	}

	/**
	 * Constructs a new Is Target Constraint Rule test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IsTargetConstraintRuleTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Is Target Constraint Rule test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected IsTargetConstraintRule getFixture() {
		return (IsTargetConstraintRule)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(EditpolicymodelFactory.eINSTANCE.createIsTargetConstraintRule());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //IsTargetConstraintRuleTest
