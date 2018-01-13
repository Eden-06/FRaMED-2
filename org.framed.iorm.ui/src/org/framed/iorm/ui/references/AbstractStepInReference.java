package org.framed.iorm.ui.references;

/**
 * the super class for the class that references the step in feature
 * @author Kevin Kassin
 */
public abstract class AbstractStepInReference {
	
	/**
	 * the name of the step in feature
	 */
	public String STEP_IN_FEATURE_NAME;
	
	/**
	 * getter method for STEP_IN_FEATURE_NAME
	 * @return the step in feature's name
	 */
	public String getStepInFeatureName() {
		return STEP_IN_FEATURE_NAME;
	}
}
