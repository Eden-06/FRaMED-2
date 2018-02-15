/**
 */
package genmodel;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenParameter;
import org.eclipse.emf.codegen.ecore.genmodel.GenTypeParameter;
import org.eclipse.emf.codegen.ecore.genmodel.GenTypedElement;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenOperation#getGenClass <em>Gen Class</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenOperation#getEcoreOperation <em>Ecore Operation</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenOperation#getGenParameters <em>Gen Parameters</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenOperation#getGenTypeParameters <em>Gen Type Parameters</em>}</li>
 * </ul>
 *
 * @see genmodel.GenmodelPackage#getGenOperation()
 * @model
 * @generated
 */
public interface GenOperation extends EObject, GenTypedElement {
	/**
	 * Returns the value of the '<em><b>Gen Class</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.codegen.ecore.genmodel.GenClass#getGenOperations <em>Gen Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gen Class</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gen Class</em>' container reference.
	 * @see #setGenClass(GenClass)
	 * @see genmodel.GenmodelPackage#getGenOperation_GenClass()
	 * @see org.eclipse.emf.codegen.ecore.genmodel.GenClass#getGenOperations
	 * @model opposite="genOperations" resolveProxies="false" required="true"
	 * @generated
	 */
	GenClass getGenClass();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenOperation#getGenClass <em>Gen Class</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gen Class</em>' container reference.
	 * @see #getGenClass()
	 * @generated
	 */
	void setGenClass(GenClass value);

	/**
	 * Returns the value of the '<em><b>Ecore Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ecore Operation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ecore Operation</em>' reference.
	 * @see #setEcoreOperation(EOperation)
	 * @see genmodel.GenmodelPackage#getGenOperation_EcoreOperation()
	 * @model required="true"
	 * @generated
	 */
	EOperation getEcoreOperation();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenOperation#getEcoreOperation <em>Ecore Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ecore Operation</em>' reference.
	 * @see #getEcoreOperation()
	 * @generated
	 */
	void setEcoreOperation(EOperation value);

	/**
	 * Returns the value of the '<em><b>Gen Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.codegen.ecore.genmodel.GenParameter}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.codegen.ecore.genmodel.GenParameter#getGenOperation <em>Gen Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gen Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gen Parameters</em>' containment reference list.
	 * @see genmodel.GenmodelPackage#getGenOperation_GenParameters()
	 * @see org.eclipse.emf.codegen.ecore.genmodel.GenParameter#getGenOperation
	 * @model opposite="genOperation" containment="true"
	 * @generated
	 */
	EList<GenParameter> getGenParameters();

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
	 * @see genmodel.GenmodelPackage#getGenOperation_GenTypeParameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<GenTypeParameter> getGenTypeParameters();

} // GenOperation
