/**
 */
package editpolicymodel.tests;

import editpolicymodel.IsTarget;
import editpolicymodel.editpolicymodelFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Is Target</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class IsTargetTest extends TypeArgumentRuleTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(IsTargetTest.class);
	}

	/**
	 * Constructs a new Is Target test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IsTargetTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Is Target test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected IsTarget getFixture() {
		return (IsTarget)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(editpolicymodelFactory.eINSTANCE.createIsTarget());
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

} //IsTargetTest
