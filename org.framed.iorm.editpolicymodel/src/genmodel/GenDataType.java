/**
 */
package genmodel;

import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Data Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenDataType#getEcoreDataType <em>Ecore Data Type</em>}</li>
 * </ul>
 *
 * @see genmodel.GenmodelPackage#getGenDataType()
 * @model
 * @generated
 */
public interface GenDataType extends EObject, GenClassifier {
	/**
	 * Returns the value of the '<em><b>Ecore Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ecore Data Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ecore Data Type</em>' reference.
	 * @see #setEcoreDataType(EDataType)
	 * @see genmodel.GenmodelPackage#getGenDataType_EcoreDataType()
	 * @model required="true"
	 * @generated
	 */
	EDataType getEcoreDataType();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenDataType#getEcoreDataType <em>Ecore Data Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ecore Data Type</em>' reference.
	 * @see #getEcoreDataType()
	 * @generated
	 */
	void setEcoreDataType(EDataType value);

} // GenDataType
