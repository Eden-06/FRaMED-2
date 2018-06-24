/**
 */
package editpolicymodel.tests;

import editpolicymodel.IsTargetConnectionType;
import editpolicymodel.editpolicymodelFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Is Target Connection Type</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class IsTargetConnectionTypeTest extends TypeArgumentRuleTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(IsTargetConnectionTypeTest.class);
	}

	/**
	 * Constructs a new Is Target Connection Type test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IsTargetConnectionTypeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Is Target Connection Type test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected IsTargetConnectionType getFixture() {
		return (IsTargetConnectionType)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(editpolicymodelFactory.eINSTANCE.createIsTargetConnectionType());
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

} //IsTargetConnectionTypeTest
