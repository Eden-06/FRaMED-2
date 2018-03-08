/**
 */
package Editpolicymodel;

import org.framed.iorm.featuremodel.FeatureName;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Is Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Editpolicymodel.IsFeature#getFeatureName <em>Feature Name</em>}</li>
 * </ul>
 *
 * @see Editpolicymodel.EditpolicymodelPackage#getIsFeature()
 * @model
 * @generated
 */
public interface IsFeature extends FeatureRule {
	/**
	 * Returns the value of the '<em><b>Feature Name</b></em>' attribute.
	 * The literals are from the enumeration {@link org.framed.iorm.featuremodel.FeatureName}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Name</em>' attribute.
	 * @see org.framed.iorm.featuremodel.FeatureName
	 * @see #setFeatureName(FeatureName)
	 * @see Editpolicymodel.EditpolicymodelPackage#getIsFeature_FeatureName()
	 * @model
	 * @generated
	 */
	FeatureName getFeatureName();

	/**
	 * Sets the value of the '{@link Editpolicymodel.IsFeature#getFeatureName <em>Feature Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Name</em>' attribute.
	 * @see org.framed.iorm.featuremodel.FeatureName
	 * @see #getFeatureName()
	 * @generated
	 */
	void setFeatureName(FeatureName value);

} // IsFeature
