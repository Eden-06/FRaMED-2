/**
 */
package Editpolicymodel.tests;

import Editpolicymodel.EditpolicymodelFactory;
import Editpolicymodel.IsParentConstraintRule;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Is Parent Constraint Rule</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class IsParentConstraintRuleTest extends AbstractConstraintRuleTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(IsParentConstraintRuleTest.class);
	}

	/**
	 * Constructs a new Is Parent Constraint Rule test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IsParentConstraintRuleTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Is Parent Constraint Rule test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected IsParentConstraintRule getFixture() {
		return (IsParentConstraintRule)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(EditpolicymodelFactory.eINSTANCE.createIsParentConstraintRule());
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

} //IsParentConstraintRuleTest
