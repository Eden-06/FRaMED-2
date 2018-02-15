/**
 */
package genmodel;

import org.eclipse.emf.codegen.ecore.genmodel.GenOperation;
import org.eclipse.emf.codegen.ecore.genmodel.GenTypedElement;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EParameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenParameter#getGenOperation <em>Gen Operation</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenParameter#getEcoreParameter <em>Ecore Parameter</em>}</li>
 * </ul>
 *
 * @see genmodel.GenmodelPackage#getGenParameter()
 * @model
 * @generated
 */
public interface GenParameter extends EObject, GenTypedElement {
	/**
	 * Returns the value of the '<em><b>Gen Operation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.codegen.ecore.genmodel.GenOperation#getGenParameters <em>Gen Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gen Operation</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gen Operation</em>' container reference.
	 * @see #setGenOperation(GenOperation)
	 * @see genmodel.GenmodelPackage#getGenParameter_GenOperation()
	 * @see org.eclipse.emf.codegen.ecore.genmodel.GenOperation#getGenParameters
	 * @model opposite="genParameters" resolveProxies="false" required="true"
	 * @generated
	 */
	GenOperation getGenOperation();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenParameter#getGenOperation <em>Gen Operation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gen Operation</em>' container reference.
	 * @see #getGenOperation()
	 * @generated
	 */
	void setGenOperation(GenOperation value);

	/**
	 * Returns the value of the '<em><b>Ecore Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ecore Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ecore Parameter</em>' reference.
	 * @see #setEcoreParameter(EParameter)
	 * @see genmodel.GenmodelPackage#getGenParameter_EcoreParameter()
	 * @model required="true"
	 * @generated
	 */
	EParameter getEcoreParameter();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenParameter#getEcoreParameter <em>Ecore Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ecore Parameter</em>' reference.
	 * @see #getEcoreParameter()
	 * @generated
	 */
	void setEcoreParameter(EParameter value);

} // GenParameter
