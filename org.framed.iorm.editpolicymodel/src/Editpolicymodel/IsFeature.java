/**
 */
package Editpolicymodel;

import iorm.featuremodel.FeatureName;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Is Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Editpolicymodel.IsFeature#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see Editpolicymodel.EditpolicymodelPackage#getIsFeature()
 * @model
 * @generated
 */
public interface IsFeature extends FeatureRule {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The literals are from the enumeration {@link iorm.featuremodel.FeatureName}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see iorm.featuremodel.FeatureName
	 * @see #setName(FeatureName)
	 * @see Editpolicymodel.EditpolicymodelPackage#getIsFeature_Name()
	 * @model
	 * @generated
	 */
	FeatureName getName();

	/**
	 * Sets the value of the '{@link Editpolicymodel.IsFeature#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see iorm.featuremodel.FeatureName
	 * @see #getName()
	 * @generated
	 */
	void setName(FeatureName value);

} // IsFeature
