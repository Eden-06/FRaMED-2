package org.framed.iorm.ui;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

public abstract class FRaMEDCustomFeature extends AbstractCustomFeature {

	protected String FEATURE_NAME;
	
	/**
	 * class constructor
	 * @param featureProvider
	 */
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
	
	/**
	 * this operation encapsulates when the custom feature should be visible in the context menu, to be overwritten by sub
	 * classes
	 * @return if the custom feature should be visible in the context menu
	 */
	public abstract boolean contextMenuExpression(PictogramElement pictogramElement,
												  EObject businessObject);

	/**
	 * the execute operation of the feature, to overwrite by the sub classes
	 */
	public void execute(ICustomContext context) {}
	
}
