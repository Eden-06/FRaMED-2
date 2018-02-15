/**
 */
package genmodel;

import org.eclipse.emf.codegen.ecore.genmodel.GenBase;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.ETypeParameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Type Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenTypeParameter#getEcoreTypeParameter <em>Ecore Type Parameter</em>}</li>
 * </ul>
 *
 * @see genmodel.GenmodelPackage#getGenTypeParameter()
 * @model
 * @generated
 */
public interface GenTypeParameter extends EObject, GenBase {
	/**
	 * Returns the value of the '<em><b>Ecore Type Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ecore Type Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ecore Type Parameter</em>' reference.
	 * @see #setEcoreTypeParameter(ETypeParameter)
	 * @see genmodel.GenmodelPackage#getGenTypeParameter_EcoreTypeParameter()
	 * @model required="true"
	 * @generated
	 */
	ETypeParameter getEcoreTypeParameter();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenTypeParameter#getEcoreTypeParameter <em>Ecore Type Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ecore Type Parameter</em>' reference.
	 * @see #getEcoreTypeParameter()
	 * @generated
	 */
	void setEcoreTypeParameter(ETypeParameter value);

} // GenTypeParameter
