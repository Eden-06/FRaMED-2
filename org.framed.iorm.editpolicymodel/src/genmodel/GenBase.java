/**
 */
package genmodel;

import org.eclipse.emf.codegen.ecore.genmodel.GenAnnotation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Base</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenBase#getGenAnnotations <em>Gen Annotations</em>}</li>
 * </ul>
 *
 * @see genmodel.GenmodelPackage#getGenBase()
 * @model abstract="true"
 * @generated
 */
public interface GenBase extends EObject {
	/**
	 * Returns the value of the '<em><b>Gen Annotations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.codegen.ecore.genmodel.GenAnnotation}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.codegen.ecore.genmodel.GenAnnotation#getGenBase <em>Gen Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gen Annotations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gen Annotations</em>' containment reference list.
	 * @see genmodel.GenmodelPackage#getGenBase_GenAnnotations()
	 * @see org.eclipse.emf.codegen.ecore.genmodel.GenAnnotation#getGenBase
	 * @model opposite="genBase" containment="true"
	 * @generated
	 */
	EList<GenAnnotation> getGenAnnotations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	GenAnnotation getGenAnnotation(String source);

} // GenBase
