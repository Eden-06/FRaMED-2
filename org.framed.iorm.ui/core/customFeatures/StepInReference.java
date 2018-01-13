package customFeatures;

import org.framed.iorm.ui.references.AbstractStepInReference;

/**
 * the reference of the step in feature that this module pattern references as double click feature
 * @author Kevin Kassin
 */
public class StepInReference extends AbstractStepInReference {
	
	/**
	 * the literals of the custom features module
	 */
	Literals literals = new Literals();
	
	public StepInReference() {
		STEP_IN_FEATURE_NAME = literals.STEP_IN_FEATURE_NAME;
	}
}
