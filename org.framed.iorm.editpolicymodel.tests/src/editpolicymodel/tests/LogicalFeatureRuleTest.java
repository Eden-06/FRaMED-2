/**
 */
package editpolicymodel.tests;

import editpolicymodel.LogicalFeatureRule;
import editpolicymodel.editpolicymodelFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Logical Feature Rule</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class LogicalFeatureRuleTest extends FeatureRuleTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(LogicalFeatureRuleTest.class);
	}

	/**
	 * Constructs a new Logical Feature Rule test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogicalFeatureRuleTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Logical Feature Rule test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected LogicalFeatureRule getFixture() {
		return (LogicalFeatureRule)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(editpolicymodelFactory.eINSTANCE.createLogicalFeatureRule());
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

} //LogicalFeatureRuleTest
