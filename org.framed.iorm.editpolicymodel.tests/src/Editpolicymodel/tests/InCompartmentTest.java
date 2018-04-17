/**
 */
package Editpolicymodel.tests;

import Editpolicymodel.EditpolicymodelFactory;
import Editpolicymodel.InCompartment;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>In Compartment</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class InCompartmentTest extends ConstraintRuleTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(InCompartmentTest.class);
	}

	/**
	 * Constructs a new In Compartment test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InCompartmentTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this In Compartment test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected InCompartment getFixture() {
		return (InCompartment)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(EditpolicymodelFactory.eINSTANCE.createInCompartment());
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

} //InCompartmentTest
