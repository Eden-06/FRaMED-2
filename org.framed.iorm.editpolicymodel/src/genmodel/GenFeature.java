/**
 */
package genmodel;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenTypedElement;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenFeature#getProperty <em>Property</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenFeature#isNotify <em>Notify</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenFeature#isChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenFeature#isCreateChild <em>Create Child</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenFeature#getPropertyCategory <em>Property Category</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenFeature#getPropertyFilterFlags <em>Property Filter Flags</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenFeature#getPropertyDescription <em>Property Description</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenFeature#isPropertyMultiLine <em>Property Multi Line</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenFeature#isPropertySortChoices <em>Property Sort Choices</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenFeature#getGenClass <em>Gen Class</em>}</li>
 *   <li>{@link org.eclipse.emf.codegen.ecore.genmodel.GenFeature#getEcoreFeature <em>Ecore Feature</em>}</li>
 * </ul>
 *
 * @see genmodel.GenmodelPackage#getGenFeature()
 * @model
 * @generated
 */
public interface GenFeature extends EObject, GenTypedElement {
	/**
	 * Returns the value of the '<em><b>Property</b></em>' attribute.
	 * The literals are from the enumeration {@link genmodel.GenPropertyKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property</em>' attribute.
	 * @see genmodel.GenPropertyKind
	 * @see #setProperty(GenPropertyKind)
	 * @see genmodel.GenmodelPackage#getGenFeature_Property()
	 * @model
	 * @generated
	 */
	GenPropertyKind getProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenFeature#getProperty <em>Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property</em>' attribute.
	 * @see genmodel.GenPropertyKind
	 * @see #getProperty()
	 * @generated
	 */
	void setProperty(GenPropertyKind value);

	/**
	 * Returns the value of the '<em><b>Notify</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Notify</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Notify</em>' attribute.
	 * @see #setNotify(boolean)
	 * @see genmodel.GenmodelPackage#getGenFeature_Notify()
	 * @model default="true"
	 * @generated
	 */
	boolean isNotify();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenFeature#isNotify <em>Notify</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Notify</em>' attribute.
	 * @see #isNotify()
	 * @generated
	 */
	void setNotify(boolean value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' attribute.
	 * @see #setChildren(boolean)
	 * @see genmodel.GenmodelPackage#getGenFeature_Children()
	 * @model
	 * @generated
	 */
	boolean isChildren();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenFeature#isChildren <em>Children</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Children</em>' attribute.
	 * @see #isChildren()
	 * @generated
	 */
	void setChildren(boolean value);

	/**
	 * Returns the value of the '<em><b>Create Child</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Create Child</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Create Child</em>' attribute.
	 * @see #isSetCreateChild()
	 * @see #unsetCreateChild()
	 * @see #setCreateChild(boolean)
	 * @see genmodel.GenmodelPackage#getGenFeature_CreateChild()
	 * @model unsettable="true"
	 * @generated
	 */
	boolean isCreateChild();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenFeature#isCreateChild <em>Create Child</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Create Child</em>' attribute.
	 * @see #isSetCreateChild()
	 * @see #unsetCreateChild()
	 * @see #isCreateChild()
	 * @generated
	 */
	void setCreateChild(boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenFeature#isCreateChild <em>Create Child</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCreateChild()
	 * @see #isCreateChild()
	 * @see #setCreateChild(boolean)
	 * @generated
	 */
	void unsetCreateChild();

	/**
	 * Returns whether the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenFeature#isCreateChild <em>Create Child</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Create Child</em>' attribute is set.
	 * @see #unsetCreateChild()
	 * @see #isCreateChild()
	 * @see #setCreateChild(boolean)
	 * @generated
	 */
	boolean isSetCreateChild();

	/**
	 * Returns the value of the '<em><b>Property Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Category</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Category</em>' attribute.
	 * @see #setPropertyCategory(String)
	 * @see genmodel.GenmodelPackage#getGenFeature_PropertyCategory()
	 * @model
	 * @generated
	 */
	String getPropertyCategory();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenFeature#getPropertyCategory <em>Property Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Category</em>' attribute.
	 * @see #getPropertyCategory()
	 * @generated
	 */
	void setPropertyCategory(String value);

	/**
	 * Returns the value of the '<em><b>Property Filter Flags</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Filter Flags</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Filter Flags</em>' attribute list.
	 * @see genmodel.GenmodelPackage#getGenFeature_PropertyFilterFlags()
	 * @model
	 * @generated
	 */
	EList<String> getPropertyFilterFlags();

	/**
	 * Returns the value of the '<em><b>Property Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Description</em>' attribute.
	 * @see #setPropertyDescription(String)
	 * @see genmodel.GenmodelPackage#getGenFeature_PropertyDescription()
	 * @model
	 * @generated
	 */
	String getPropertyDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenFeature#getPropertyDescription <em>Property Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Description</em>' attribute.
	 * @see #getPropertyDescription()
	 * @generated
	 */
	void setPropertyDescription(String value);

	/**
	 * Returns the value of the '<em><b>Property Multi Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Multi Line</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Multi Line</em>' attribute.
	 * @see #setPropertyMultiLine(boolean)
	 * @see genmodel.GenmodelPackage#getGenFeature_PropertyMultiLine()
	 * @model
	 * @generated
	 */
	boolean isPropertyMultiLine();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenFeature#isPropertyMultiLine <em>Property Multi Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Multi Line</em>' attribute.
	 * @see #isPropertyMultiLine()
	 * @generated
	 */
	void setPropertyMultiLine(boolean value);

	/**
	 * Returns the value of the '<em><b>Property Sort Choices</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Sort Choices</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Sort Choices</em>' attribute.
	 * @see #setPropertySortChoices(boolean)
	 * @see genmodel.GenmodelPackage#getGenFeature_PropertySortChoices()
	 * @model
	 * @generated
	 */
	boolean isPropertySortChoices();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenFeature#isPropertySortChoices <em>Property Sort Choices</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Sort Choices</em>' attribute.
	 * @see #isPropertySortChoices()
	 * @generated
	 */
	void setPropertySortChoices(boolean value);

	/**
	 * Returns the value of the '<em><b>Gen Class</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.codegen.ecore.genmodel.GenClass#getGenFeatures <em>Gen Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gen Class</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gen Class</em>' container reference.
	 * @see #setGenClass(GenClass)
	 * @see genmodel.GenmodelPackage#getGenFeature_GenClass()
	 * @see org.eclipse.emf.codegen.ecore.genmodel.GenClass#getGenFeatures
	 * @model opposite="genFeatures" resolveProxies="false" required="true"
	 * @generated
	 */
	GenClass getGenClass();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenFeature#getGenClass <em>Gen Class</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gen Class</em>' container reference.
	 * @see #getGenClass()
	 * @generated
	 */
	void setGenClass(GenClass value);

	/**
	 * Returns the value of the '<em><b>Ecore Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ecore Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ecore Feature</em>' reference.
	 * @see #setEcoreFeature(EStructuralFeature)
	 * @see genmodel.GenmodelPackage#getGenFeature_EcoreFeature()
	 * @model required="true"
	 * @generated
	 */
	EStructuralFeature getEcoreFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.codegen.ecore.genmodel.GenFeature#getEcoreFeature <em>Ecore Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ecore Feature</em>' reference.
	 * @see #getEcoreFeature()
	 * @generated
	 */
	void setEcoreFeature(EStructuralFeature value);

} // GenFeature
