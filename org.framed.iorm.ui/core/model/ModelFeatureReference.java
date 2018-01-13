package model;

import org.framed.iorm.ui.references.AbstractModelFeatureReference;

/**
 * The reference class of this model feature
 * @author Kevin Kassin
 */
public class ModelFeatureReference extends AbstractModelFeatureReference {

	/**
	 * the model feature's literals
	 */
	Literals literals = new Literals();
	
	/**
	 * class constructor
	 */
	public ModelFeatureReference() {
		MODEL_FEATURE_NAME = literals.FEATURE_NAME;
	}
}
