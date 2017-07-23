package org.framed.iorm.ui.graphitifeatures;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.impl.DeleteContext;
import org.eclipse.graphiti.features.context.impl.MultiDeleteInfo;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.ui.features.DefaultDeleteFeature;
import org.framed.iorm.ui.providers.FeatureProvider;

/**
 * This graphiti custom feature is used to disabling the possibility of deleting connection decorators and the 
 * "Are you sure?" message when deleting connections.
 * <p>
 * It is returned by the operation {@link FeatureProvider#getDeleteFeatureAdditional}.
 * @author Kevin Kassin
 */
public class FRaMEDDeleteConnectionFeature extends DefaultDeleteFeature {

	/**
	 * Class constructor
	 * @param featureProvider the feature provider the feature belongs to
	 */
	public FRaMEDDeleteConnectionFeature(IFeatureProvider featureProvider) {
		super(featureProvider);
	}
	
	/**
	 * disables the delete option for connection decorators
	 */
	@Override
	public boolean canDelete(IDeleteContext deleteContext) {
		return !(deleteContext.getPictogramElement() instanceof ConnectionDecorator);
	}
	
	/**
	 * disables the "Are you sure?" message when deleting connections
	 */
	@Override
	public void delete(IDeleteContext deleteContext) {
		((DeleteContext) deleteContext).setMultiDeleteInfo(new MultiDeleteInfo(false, false, 0));
		super.delete(deleteContext);
	}
	
}
