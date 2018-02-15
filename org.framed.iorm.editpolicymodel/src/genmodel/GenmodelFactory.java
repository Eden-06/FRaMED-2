/**
 */
package genmodel;

import org.eclipse.emf.codegen.ecore.genmodel.GenAnnotation;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenDataType;
import org.eclipse.emf.codegen.ecore.genmodel.GenEnum;
import org.eclipse.emf.codegen.ecore.genmodel.GenEnumLiteral;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenOperation;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenParameter;
import org.eclipse.emf.codegen.ecore.genmodel.GenTypeParameter;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see genmodel.GenmodelPackage
 * @generated
 */
public interface GenmodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GenmodelFactory eINSTANCE = genmodel.impl.GenmodelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Gen Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Model</em>'.
	 * @generated
	 */
	GenModel createGenModel();

	/**
	 * Returns a new object of class '<em>Gen Package</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Package</em>'.
	 * @generated
	 */
	GenPackage createGenPackage();

	/**
	 * Returns a new object of class '<em>Gen Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Class</em>'.
	 * @generated
	 */
	GenClass createGenClass();

	/**
	 * Returns a new object of class '<em>Gen Feature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Feature</em>'.
	 * @generated
	 */
	GenFeature createGenFeature();

	/**
	 * Returns a new object of class '<em>Gen Enum</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Enum</em>'.
	 * @generated
	 */
	GenEnum createGenEnum();

	/**
	 * Returns a new object of class '<em>Gen Enum Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Enum Literal</em>'.
	 * @generated
	 */
	GenEnumLiteral createGenEnumLiteral();

	/**
	 * Returns a new object of class '<em>Gen Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Data Type</em>'.
	 * @generated
	 */
	GenDataType createGenDataType();

	/**
	 * Returns a new object of class '<em>Gen Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Operation</em>'.
	 * @generated
	 */
	GenOperation createGenOperation();

	/**
	 * Returns a new object of class '<em>Gen Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Parameter</em>'.
	 * @generated
	 */
	GenParameter createGenParameter();

	/**
	 * Returns a new object of class '<em>Gen Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Annotation</em>'.
	 * @generated
	 */
	GenAnnotation createGenAnnotation();

	/**
	 * Returns a new object of class '<em>Gen Type Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Type Parameter</em>'.
	 * @generated
	 */
	GenTypeParameter createGenTypeParameter();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GenmodelPackage getGenmodelPackage();

} //GenmodelFactory
