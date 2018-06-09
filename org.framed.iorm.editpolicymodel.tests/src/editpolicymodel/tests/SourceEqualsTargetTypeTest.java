/**
 */
package editpolicymodel.tests;

import editpolicymodel.SourceEqualsTargetType;
import editpolicymodel.editpolicymodelFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Source Equals Target Type</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SourceEqualsTargetTypeTest extends ConstraintRuleTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SourceEqualsTargetTypeTest.class);
	}

	/**
	 * Constructs a new Source Equals Target Type test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceEqualsTargetTypeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Source Equals Target Type test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SourceEqualsTargetType getFixture() {
		return (SourceEqualsTargetType)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(editpolicymodelFactory.eINSTANCE.createSourceEqualsTargetType());
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

} //SourceEqualsTargetTypeTest
