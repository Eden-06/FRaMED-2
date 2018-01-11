package org.framed.iorm.ui;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

/**
 * This class is an abstract super class for the graphiti custom features.
 * <p>
 * It collects common attributes and operations of these classes.
 * @author Kevin Kassin
 */
public abstract class FRaMEDCustomFeature extends AbstractCustomFeature {

	/**
	 * the custom features name
	 */
	protected String FEATURE_NAME;
	
	/**
	 * class constructor
	 * @param featureProvider the feature provider the custom feature belongs to
	 */
	public FRaMEDCustomFeature(IFeatureProvider featureProvider) {
		super(featureProvider);
	}
	
	/**
	 * getter method for the features name
	 * @return the name of the feature 
	 */
	@Override
	public String getName() {
		return FEATURE_NAME;
	}
	
	/**
	 * this operation encapsulates when the custom feature should be visible in the context menu
	 * <p>
	 * This operation needs to be implemented by sub classes.
	 * @return if the custom feature should be visible in the context menu
	 */
	public abstract boolean contextMenuExpression(PictogramElement pictogramElement,
												  EObject businessObject);	
}
