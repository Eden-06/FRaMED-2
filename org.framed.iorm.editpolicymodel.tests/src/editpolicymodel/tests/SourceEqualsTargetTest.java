/**
 */
package editpolicymodel.tests;

import editpolicymodel.SourceEqualsTarget;
import editpolicymodel.editpolicymodelFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Source Equals Target</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SourceEqualsTargetTest extends ConstraintRuleTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SourceEqualsTargetTest.class);
	}

	/**
	 * Constructs a new Source Equals Target test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceEqualsTargetTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Source Equals Target test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SourceEqualsTarget getFixture() {
		return (SourceEqualsTarget)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(editpolicymodelFactory.eINSTANCE.createSourceEqualsTarget());
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

} //SourceEqualsTargetTest
