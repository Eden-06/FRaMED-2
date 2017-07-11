/**
 */
package org.framed.iorm.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.framed.iorm.model.ModelElement#getContainer <em>Container</em>}</li>
 *   <li>{@link org.framed.iorm.model.ModelElement#getIncomingRelations <em>Incoming Relations</em>}</li>
 *   <li>{@link org.framed.iorm.model.ModelElement#getOutgoingRelations <em>Outgoing Relations</em>}</li>
 *   <li>{@link org.framed.iorm.model.ModelElement#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see org.framed.iorm.model.OrmPackage#getModelElement()
 * @model
 * @generated
 */
public interface ModelElement extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Container</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.framed.iorm.model.Model#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' container reference.
	 * @see #setContainer(Model)
	 * @see org.framed.iorm.model.OrmPackage#getModelElement_Container()
	 * @see org.framed.iorm.model.Model#getElements
	 * @model opposite="elements" required="true" transient="false"
	 * @generated
	 */
	Model getContainer();

	/**
	 * Sets the value of the '{@link org.framed.iorm.model.ModelElement#getContainer <em>Container</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' container reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(Model value);

	/**
	 * Returns the value of the '<em><b>Incoming Relations</b></em>' reference list.
	 * The list contents are of type {@link org.framed.iorm.model.Relation}.
	 * It is bidirectional and its opposite is '{@link org.framed.iorm.model.Relation#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Relations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Relations</em>' reference list.
	 * @see org.framed.iorm.model.OrmPackage#getModelElement_IncomingRelations()
	 * @see org.framed.iorm.model.Relation#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<Relation> getIncomingRelations();

	/**
	 * Returns the value of the '<em><b>Outgoing Relations</b></em>' reference list.
	 * The list contents are of type {@link org.framed.iorm.model.Relation}.
	 * It is bidirectional and its opposite is '{@link org.framed.iorm.model.Relation#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Relations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Relations</em>' reference list.
	 * @see org.framed.iorm.model.OrmPackage#getModelElement_OutgoingRelations()
	 * @see org.framed.iorm.model.Relation#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<Relation> getOutgoingRelations();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.framed.iorm.model.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.framed.iorm.model.Type
	 * @see #setType(Type)
	 * @see org.framed.iorm.model.OrmPackage#getModelElement_Type()
	 * @model required="true"
	 * @generated
	 */
	Type getType();

	/**
	 * Sets the value of the '{@link org.framed.iorm.model.ModelElement#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.framed.iorm.model.Type
	 * @see #getType()
	 * @generated
	 */
	void setType(Type value);

} // ModelElement
