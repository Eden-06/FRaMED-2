/**
 */
package genmodel.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>genmodel</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class GenmodelTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new GenmodelTests("genmodel Tests");
		suite.addTestSuite(GenModelTest.class);
		suite.addTestSuite(GenPackageTest.class);
		suite.addTestSuite(GenClassTest.class);
		suite.addTestSuite(GenFeatureTest.class);
		suite.addTestSuite(GenEnumTest.class);
		suite.addTestSuite(GenEnumLiteralTest.class);
		suite.addTestSuite(GenDataTypeTest.class);
		suite.addTestSuite(GenOperationTest.class);
		suite.addTestSuite(GenParameterTest.class);
		suite.addTestSuite(GenAnnotationTest.class);
		suite.addTestSuite(GenTypeParameterTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenmodelTests(String name) {
		super(name);
	}

} //GenmodelTests
