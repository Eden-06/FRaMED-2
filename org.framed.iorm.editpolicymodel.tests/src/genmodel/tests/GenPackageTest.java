/**
 */
package genmodel.tests;

import genmodel.GenmodelFactory;

import junit.textui.TestRunner;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Gen Package</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getGenClassifiers() <em>Gen Classifiers</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class GenPackageTest extends GenBaseTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(GenPackageTest.class);
	}

	/**
	 * Constructs a new Gen Package test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenPackageTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Gen Package test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected GenPackage getFixture() {
		return (GenPackage)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(GenmodelFactory.eINSTANCE.createGenPackage());
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

	/**
	 * Tests the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getGenClassifiers() <em>Gen Classifiers</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getGenClassifiers()
	 * @generated
	 */
	public void testGetGenClassifiers() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

} //GenPackageTest
