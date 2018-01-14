package org.framed.iorm.ui;

import java.util.List;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.impl.DeleteContext;
import org.eclipse.graphiti.features.context.impl.MultiDeleteInfo;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.pattern.IConnectionPattern;
import org.eclipse.graphiti.ui.features.DefaultDeleteFeature;
import org.framed.iorm.model.Relation;
import org.framed.iorm.ui.providers.FeatureProvider;

/**
 * This graphiti delete feature is used to disabling the possibility of deleting connection decorators and the 
 * "Are you sure?" message when deleting connections.
 * <p>
 * It also calls the {@link FRaMEDConnectionPattern#delete(FRaMEDDeleteConnectionFeature, IDeleteContext)} operation to get
 * pattern specific deletion behavior. 
 * @author Kevin Kassin
 */
public class FRaMEDDeleteConnectionFeature extends DefaultDeleteFeature {

	/**
	 * the list of connection patterns known to the feature provider to which this feature belongs to
	 */
	private List<FRaMEDConnectionPattern> connectionPatterns;
	
	/**
	 * Class constructor
	 * <p>
	 * It fills the lists of patterns and casts them into the right type of {@link FRaMEDConnectionPattern}.
	 * @param featureProvider the feature provider the feature belongs to
	 */
	public FRaMEDDeleteConnectionFeature(IFeatureProvider featureProvider) {
		super(featureProvider);
		for(IConnectionPattern iConPattern : ((FeatureProvider) getFeatureProvider()).getConnectionPatterns()) {
			if(iConPattern instanceof FRaMEDConnectionPattern)
				connectionPatterns.add((FRaMEDConnectionPattern) iConPattern);
		}
	}
	
	/**
	 * disables the delete option for connection decorators
	 */
	@Override
	public boolean canDelete(IDeleteContext deleteContext) {
		return !(deleteContext.getPictogramElement() instanceof ConnectionDecorator);
	}
	
	/**
	 * calls pattern specific deletion behavior for the connection patterns (Step 1) and
	 * disables the "Are you sure?" message when deleting connections (Step 2)
	 */
	@Override
	public void delete(IDeleteContext deleteContext) {
		//Step 1
		Relation relation = (Relation) getBusinessObjectForPictogramElement(deleteContext.getPictogramElement());
		for(FRaMEDConnectionPattern framedConnectionPattern :  connectionPatterns) {
			if(relation.getType() == framedConnectionPattern.getModelType())
				framedConnectionPattern.delete(this, deleteContext);
		}	
		//Step 2
		((DeleteContext) deleteContext).setMultiDeleteInfo(new MultiDeleteInfo(false, false, 0));
		super.delete(deleteContext);
	
	}
	
	/**
	 * publishes the deleteBusinessObject(Object) operation of the super class
	 */
	public void deleteBusinessObject(Object object) {
		super.deleteBusinessObject(object);
	}
}
