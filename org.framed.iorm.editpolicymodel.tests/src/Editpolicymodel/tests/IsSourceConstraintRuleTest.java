/**
 */
package Editpolicymodel.tests;

import Editpolicymodel.EditpolicymodelFactory;
import Editpolicymodel.IsSourceConstraintRule;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Is Source Constraint Rule</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class IsSourceConstraintRuleTest extends AbstractConstraintRuleTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(IsSourceConstraintRuleTest.class);
	}

	/**
	 * Constructs a new Is Source Constraint Rule test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IsSourceConstraintRuleTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Is Source Constraint Rule test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected IsSourceConstraintRule getFixture() {
		return (IsSourceConstraintRule)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(EditpolicymodelFactory.eINSTANCE.createIsSourceConstraintRule());
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

} //IsSourceConstraintRuleTest
