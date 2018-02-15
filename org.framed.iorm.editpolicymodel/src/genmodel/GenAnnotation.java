/**
 */
package genmodel;

import org.eclipse.emf.codegen.ecore.genmodel.GenBase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenAnnotation#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenAnnotation#getDetails <em>Details</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenAnnotation#getGenBase <em>Gen Base</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenAnnotation#getReferences <em>References</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenAnnotation#getContents <em>Contents</em>}</li>
 * </ul>
 *
 * @see genmodel.GenmodelPackage#getGenAnnotation()
 * @model
 * @generated
 */
public interface GenAnnotation extends EObject, GenBase {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' attribute.
	 * @see #setSource(String)
	 * @see genmodel.GenmodelPackage#getGenAnnotation_Source()
	 * @model
	 * @generated
	 */
	String getSource();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenAnnotation#getSource <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' attribute.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(String value);

	/**
	 * Returns the value of the '<em><b>Details</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Details</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Details</em>' map.
	 * @see genmodel.GenmodelPackage#getGenAnnotation_Details()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry&lt;org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString&gt;"
	 * @generated
	 */
	EMap<String, String> getDetails();

	/**
	 * Returns the value of the '<em><b>Gen Base</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.codegen.ecore.genmodel.GenBase#getGenAnnotations <em>Gen Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gen Base</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gen Base</em>' container reference.
	 * @see #setGenBase(GenBase)
	 * @see genmodel.GenmodelPackage#getGenAnnotation_GenBase()
	 * @see org.eclipse.emf.codegen.ecore.genmodel.GenBase#getGenAnnotations
	 * @model opposite="genAnnotations" resolveProxies="false"
	 * @generated
	 */
	GenBase getGenBase();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenAnnotation#getGenBase <em>Gen Base</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gen Base</em>' container reference.
	 * @see #getGenBase()
	 * @generated
	 */
	void setGenBase(GenBase value);

	/**
	 * Returns the value of the '<em><b>References</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>References</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>References</em>' reference list.
	 * @see genmodel.GenmodelPackage#getGenAnnotation_References()
	 * @model
	 * @generated
	 */
	EList<EObject> getReferences();

	/**
	 * Returns the value of the '<em><b>Contents</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contents</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contents</em>' containment reference list.
	 * @see genmodel.GenmodelPackage#getGenAnnotation_Contents()
	 * @model containment="true"
	 * @generated
	 */
	EList<EObject> getContents();

} // GenAnnotation
