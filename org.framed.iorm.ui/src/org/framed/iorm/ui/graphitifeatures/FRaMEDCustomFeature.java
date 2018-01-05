package org.framed.iorm.ui.graphitifeatures;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;

public class FRaMEDCustomFeature extends AbstractCustomFeature {

	protected String FEATURE_NAME;
	
	public FRaMEDCustomFeature(IFeatureProvider featureProvider) {
		super(featureProvider);
	}
	
	/**
	 * get method for the features name
	 * @return the name of the feature 
	 */
	@Override
	public String getName() {
		return FEATURE_NAME;
	}

	@Override
	public void execute(ICustomContext context) {}
	
}
