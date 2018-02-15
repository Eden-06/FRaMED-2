/**
 */
package Editpolicymodel.tests;

import Editpolicymodel.AndConstraintRule;
import Editpolicymodel.EditpolicymodelFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>And Constraint Rule</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AndConstraintRuleTest extends AbstractConstraintRuleTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AndConstraintRuleTest.class);
	}

	/**
	 * Constructs a new And Constraint Rule test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AndConstraintRuleTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this And Constraint Rule test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected AndConstraintRule getFixture() {
		return (AndConstraintRule)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(EditpolicymodelFactory.eINSTANCE.createAndConstraintRule());
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

} //AndConstraintRuleTest
