/**
 */
package genmodel.tests;

import genmodel.GenmodelFactory;

import junit.textui.TestRunner;

import org.eclipse.emf.codegen.ecore.genmodel.GenTypeParameter;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Gen Type Parameter</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class GenTypeParameterTest extends GenBaseTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(GenTypeParameterTest.class);
	}

	/**
	 * Constructs a new Gen Type Parameter test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenTypeParameterTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Gen Type Parameter test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected GenTypeParameter getFixture() {
		return (GenTypeParameter)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(GenmodelFactory.eINSTANCE.createGenTypeParameter());
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

} //GenTypeParameterTest
