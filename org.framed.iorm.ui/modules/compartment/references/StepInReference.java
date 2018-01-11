package compartment.references;

/**
 * the reference of the step in feature that this module pattern references as double click feature
 * @author Kevin Kassin
 */
public class StepInReference {
	
	/**
	 * the literals of the custom features module
	 */
	customFeatures.Literals literals = new customFeatures.Literals();
	
	/**
	 * getter method for STEP_IN_FEATURE_NAME
	 * @return the step in feature's name
	 */
	public String getStepInFeatureName() {
		return literals.STEP_IN_FEATURE_NAME;
	}
}
