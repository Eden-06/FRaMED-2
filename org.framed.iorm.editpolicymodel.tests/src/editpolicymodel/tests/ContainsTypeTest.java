/**
 */
package editpolicymodel.tests;

import editpolicymodel.ContainsType;
import editpolicymodel.editpolicymodelFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Contains Type</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ContainsTypeTest extends TypeArgumentRuleTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ContainsTypeTest.class);
	}

	/**
	 * Constructs a new Contains Type test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContainsTypeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Contains Type test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ContainsType getFixture() {
		return (ContainsType)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(editpolicymodelFactory.eINSTANCE.createContainsType());
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

} //ContainsTypeTest
