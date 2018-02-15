/**
 */
package genmodel.tests;

import genmodel.GenmodelFactory;

import junit.textui.TestRunner;

import org.eclipse.emf.codegen.ecore.genmodel.GenParameter;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Gen Parameter</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class GenParameterTest extends GenTypedElementTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(GenParameterTest.class);
	}

	/**
	 * Constructs a new Gen Parameter test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenParameterTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Gen Parameter test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected GenParameter getFixture() {
		return (GenParameter)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(GenmodelFactory.eINSTANCE.createGenParameter());
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

} //GenParameterTest
