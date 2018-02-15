/**
 */
package genmodel;

import org.eclipse.emf.codegen.ecore.genmodel.GenBase;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenTypeParameter;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Classifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenClassifier#getGenPackage <em>Gen Package</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenClassifier#getGenTypeParameters <em>Gen Type Parameters</em>}</li>
 * </ul>
 *
 * @see genmodel.GenmodelPackage#getGenClassifier()
 * @model abstract="true"
 * @generated
 */
public interface GenClassifier extends EObject, GenBase {
	/**
	 * Returns the value of the '<em><b>Gen Package</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getGenClassifiers <em>Gen Classifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gen Package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gen Package</em>' reference.
	 * @see genmodel.GenmodelPackage#getGenClassifier_GenPackage()
	 * @see org.eclipse.emf.codegen.ecore.genmodel.GenPackage#getGenClassifiers
	 * @model opposite="genClassifiers" resolveProxies="false" required="true" transient="true" changeable="false" volatile="true"
	 * @generated
	 */
	GenPackage getGenPackage();

	/**
	 * Returns the value of the '<em><b>Gen Type Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.codegen.ecore.genmodel.GenTypeParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gen Type Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gen Type Parameters</em>' containment reference list.
	 * @see genmodel.GenmodelPackage#getGenClassifier_GenTypeParameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<GenTypeParameter> getGenTypeParameters();

} // GenClassifier
