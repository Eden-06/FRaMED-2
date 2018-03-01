/**
 */
package iorm;

import iorm.featuremodel.FRaMEDConfiguration;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link iorm.Model#getElements <em>Elements</em>}</li>
 *   <li>{@link iorm.Model#getParent <em>Parent</em>}</li>
 *   <li>{@link iorm.Model#getFramedConfiguration <em>Framed Configuration</em>}</li>
 * </ul>
 *
 * @see iorm.IormPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link iorm.ModelElement}.
	 * It is bidirectional and its opposite is '{@link iorm.ModelElement#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see iorm.IormPackage#getModel_Elements()
	 * @see iorm.ModelElement#getContainer
	 * @model opposite="container" containment="true"
	 * @generated
	 */
	EList<ModelElement> getElements();

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link iorm.Shape#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(Shape)
	 * @see iorm.IormPackage#getModel_Parent()
	 * @see iorm.Shape#getModel
	 * @model opposite="model" transient="false"
	 * @generated
	 */
	Shape getParent();

	/**
	 * Sets the value of the '{@link iorm.Model#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Shape value);

	/**
	 * Returns the value of the '<em><b>Framed Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Framed Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Framed Configuration</em>' containment reference.
	 * @see #setFramedConfiguration(FRaMEDConfiguration)
	 * @see iorm.IormPackage#getModel_FramedConfiguration()
	 * @model containment="true"
	 * @generated
	 */
	FRaMEDConfiguration getFramedConfiguration();

	/**
	 * Sets the value of the '{@link iorm.Model#getFramedConfiguration <em>Framed Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Framed Configuration</em>' containment reference.
	 * @see #getFramedConfiguration()
	 * @generated
	 */
	void setFramedConfiguration(FRaMEDConfiguration value);

} // Model
