/**
 */
package genmodel.tests;

import genmodel.GenmodelFactory;

import junit.textui.TestRunner;

import org.eclipse.emf.codegen.ecore.genmodel.GenAnnotation;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Gen Annotation</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class GenAnnotationTest extends GenBaseTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(GenAnnotationTest.class);
	}

	/**
	 * Constructs a new Gen Annotation test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenAnnotationTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Gen Annotation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected GenAnnotation getFixture() {
		return (GenAnnotation)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(GenmodelFactory.eINSTANCE.createGenAnnotation());
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

} //GenAnnotationTest
