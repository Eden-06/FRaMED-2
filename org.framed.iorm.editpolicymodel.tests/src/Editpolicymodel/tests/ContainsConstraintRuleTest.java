/**
 */
package Editpolicymodel.tests;

import Editpolicymodel.ContainsConstraintRule;
import Editpolicymodel.EditpolicymodelFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Contains Constraint Rule</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ContainsConstraintRuleTest extends AbstractConstraintRuleTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ContainsConstraintRuleTest.class);
	}

	/**
	 * Constructs a new Contains Constraint Rule test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContainsConstraintRuleTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Contains Constraint Rule test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ContainsConstraintRule getFixture() {
		return (ContainsConstraintRule)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(EditpolicymodelFactory.eINSTANCE.createContainsConstraintRule());
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

} //ContainsConstraintRuleTest
