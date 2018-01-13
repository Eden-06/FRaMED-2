package org.framed.iorm.ui.references;

/**
 * This is the abstract super class of references for the used model feature.
 * <p>
 * You can find the sub classes in the module of the model feature. If there found more than one model feature
 * an TODO is thrown.
 * @author Kevin Kassin
 */
public abstract class AbstractModelFeatureReference {

	/**
	 * The feature name of the feature pattern to create models
	 */
	protected String MODEL_FEATURE_NAME;
	
	/**
	 * getter method for MODEL_FEATURE_NAME
	 * @return the feature name of the feature pattern to create models
	 */
	public String getModelFeatureName() {
		return MODEL_FEATURE_NAME;
	}
}
