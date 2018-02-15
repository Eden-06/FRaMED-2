/**
 */
package genmodel;

import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenOperation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenClass#getProvider <em>Provider</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenClass#isImage <em>Image</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenClass#isDynamic <em>Dynamic</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenClass#getEcoreClass <em>Ecore Class</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenClass#getGenFeatures <em>Gen Features</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenClass#getGenOperations <em>Gen Operations</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenClass#getLabelFeature <em>Label Feature</em>}</li>
 * </ul>
 *
 * @see genmodel.GenmodelPackage#getGenClass()
 * @model
 * @generated
 */
public interface GenClass extends EObject, GenClassifier {
	/**
	 * Returns the value of the '<em><b>Provider</b></em>' attribute.
	 * The literals are from the enumeration {@link genmodel.GenProviderKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provider</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provider</em>' attribute.
	 * @see genmodel.GenProviderKind
	 * @see #setProvider(GenProviderKind)
	 * @see genmodel.GenmodelPackage#getGenClass_Provider()
	 * @model
	 * @generated
	 */
	GenProviderKind getProvider();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenClass#getProvider <em>Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provider</em>' attribute.
	 * @see genmodel.GenProviderKind
	 * @see #getProvider()
	 * @generated
	 */
	void setProvider(GenProviderKind value);

	/**
	 * Returns the value of the '<em><b>Image</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Image</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image</em>' attribute.
	 * @see #setImage(boolean)
	 * @see genmodel.GenmodelPackage#getGenClass_Image()
	 * @model default="true"
	 * @generated
	 */
	boolean isImage();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenClass#isImage <em>Image</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image</em>' attribute.
	 * @see #isImage()
	 * @generated
	 */
	void setImage(boolean value);

	/**
	 * Returns the value of the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dynamic</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dynamic</em>' attribute.
	 * @see #setDynamic(boolean)
	 * @see genmodel.GenmodelPackage#getGenClass_Dynamic()
	 * @model
	 * @generated
	 */
	boolean isDynamic();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenClass#isDynamic <em>Dynamic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dynamic</em>' attribute.
	 * @see #isDynamic()
	 * @generated
	 */
	void setDynamic(boolean value);

	/**
	 * Returns the value of the '<em><b>Ecore Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ecore Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ecore Class</em>' reference.
	 * @see #setEcoreClass(EClass)
	 * @see genmodel.GenmodelPackage#getGenClass_EcoreClass()
	 * @model required="true"
	 * @generated
	 */
	EClass getEcoreClass();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenClass#getEcoreClass <em>Ecore Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ecore Class</em>' reference.
	 * @see #getEcoreClass()
	 * @generated
	 */
	void setEcoreClass(EClass value);

	/**
	 * Returns the value of the '<em><b>Gen Features</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.codegen.ecore.genmodel.GenFeature}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.codegen.ecore.genmodel.GenFeature#getGenClass <em>Gen Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gen Features</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gen Features</em>' containment reference list.
	 * @see genmodel.GenmodelPackage#getGenClass_GenFeatures()
	 * @see org.eclipse.emf.codegen.ecore.genmodel.GenFeature#getGenClass
	 * @model opposite="genClass" containment="true"
	 * @generated
	 */
	EList<GenFeature> getGenFeatures();

	/**
	 * Returns the value of the '<em><b>Gen Operations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.codegen.ecore.genmodel.GenOperation}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.codegen.ecore.genmodel.GenOperation#getGenClass <em>Gen Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gen Operations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gen Operations</em>' containment reference list.
	 * @see genmodel.GenmodelPackage#getGenClass_GenOperations()
	 * @see org.eclipse.emf.codegen.ecore.genmodel.GenOperation#getGenClass
	 * @model opposite="genClass" containment="true"
	 * @generated
	 */
	EList<GenOperation> getGenOperations();

	/**
	 * Returns the value of the '<em><b>Label Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label Feature</em>' reference.
	 * @see #setLabelFeature(GenFeature)
	 * @see genmodel.GenmodelPackage#getGenClass_LabelFeature()
	 * @model
	 * @generated
	 */
	GenFeature getLabelFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenClass#getLabelFeature <em>Label Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label Feature</em>' reference.
	 * @see #getLabelFeature()
	 * @generated
	 */
	void setLabelFeature(GenFeature value);

} // GenClass
