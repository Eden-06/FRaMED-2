/**
 */
package iorm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Shape</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link iorm.Shape#getFirstSegment <em>First Segment</em>}</li>
 *   <li>{@link iorm.Shape#getSecondSegment <em>Second Segment</em>}</li>
 *   <li>{@link iorm.Shape#getModel <em>Model</em>}</li>
 *   <li>{@link iorm.Shape#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @see iorm.IormPackage#getShape()
 * @model
 * @generated
 */
public interface Shape extends ModelElement {
	/**
	 * Returns the value of the '<em><b>First Segment</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Segment</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Segment</em>' containment reference.
	 * @see #setFirstSegment(Segment)
	 * @see iorm.IormPackage#getShape_FirstSegment()
	 * @model containment="true"
	 * @generated
	 */
	Segment getFirstSegment();

	/**
	 * Sets the value of the '{@link iorm.Shape#getFirstSegment <em>First Segment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Segment</em>' containment reference.
	 * @see #getFirstSegment()
	 * @generated
	 */
	void setFirstSegment(Segment value);

	/**
	 * Returns the value of the '<em><b>Second Segment</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Second Segment</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Second Segment</em>' containment reference.
	 * @see #setSecondSegment(Segment)
	 * @see iorm.IormPackage#getShape_SecondSegment()
	 * @model containment="true"
	 * @generated
	 */
	Segment getSecondSegment();

	/**
	 * Sets the value of the '{@link iorm.Shape#getSecondSegment <em>Second Segment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Second Segment</em>' containment reference.
	 * @see #getSecondSegment()
	 * @generated
	 */
	void setSecondSegment(Segment value);

	/**
	 * Returns the value of the '<em><b>Model</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link iorm.Model#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' containment reference.
	 * @see #setModel(Model)
	 * @see iorm.IormPackage#getShape_Model()
	 * @see iorm.Model#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	Model getModel();

	/**
	 * Sets the value of the '{@link iorm.Shape#getModel <em>Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' containment reference.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(Model value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' containment reference.
	 * @see #setDescription(NamedElement)
	 * @see iorm.IormPackage#getShape_Description()
	 * @model containment="true"
	 * @generated
	 */
	NamedElement getDescription();

	/**
	 * Sets the value of the '{@link iorm.Shape#getDescription <em>Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' containment reference.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(NamedElement value);

} // Shape
