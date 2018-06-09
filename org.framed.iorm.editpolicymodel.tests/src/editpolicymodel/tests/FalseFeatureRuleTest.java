/**
 */
package editpolicymodel.tests;

import editpolicymodel.FalseFeatureRule;
import editpolicymodel.editpolicymodelFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>False Feature Rule</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class FalseFeatureRuleTest extends LogicalFeatureRuleTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(FalseFeatureRuleTest.class);
	}

	/**
	 * Constructs a new False Feature Rule test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FalseFeatureRuleTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this False Feature Rule test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected FalseFeatureRule getFixture() {
		return (FalseFeatureRule)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(editpolicymodelFactory.eINSTANCE.createFalseFeatureRule());
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

} //FalseFeatureRuleTest
