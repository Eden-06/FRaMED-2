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
 * This graphiti custom feature is used to disabling the possibility of deleting connection decorators and the 
 * "Are you sure?" message when deleting connections.
 * <p>
 * It is returned by the operation {@link FeatureProvider#getDeleteFeatureAdditional}.
 * @author Kevin Kassin
 */
public class FRaMEDDeleteConnectionFeature extends DefaultDeleteFeature {

	//TODO
	private List<IConnectionPattern> connectionFeatures;
	
	/**
	 * Class constructor
	 * @param featureProvider the feature provider the feature belongs to
	 */
	public FRaMEDDeleteConnectionFeature(IFeatureProvider featureProvider) {
		super(featureProvider);
		connectionFeatures = ((FeatureProvider) getFeatureProvider()).getConnectionPatterns();
	}
	
	/**
	 * disables the delete option for connection decorators
	 */
	@Override
	public boolean canDelete(IDeleteContext deleteContext) {
		return !(deleteContext.getPictogramElement() instanceof ConnectionDecorator);
	}
	
	//TODO
	/**
	 * disables the "Are you sure?" message when deleting connections
	 * <p>
	 * Also deletes intra and inter relationship constraints when deleting relationships. This is needed to
	 * be done explicitly because graphiti does not automaticly deletes the business object of these constraints.
	 */
	@Override
	public void delete(IDeleteContext deleteContext) {
		//Step 1
		Relation relation = (Relation) getBusinessObjectForPictogramElement(deleteContext.getPictogramElement());
		for(IConnectionPattern iConPattern :  connectionFeatures) {
			if(iConPattern instanceof FRaMEDConnectionPattern) {
				FRaMEDConnectionPattern framedConnectionFeature = (FRaMEDConnectionPattern) iConPattern;
				if(relation.getType() == framedConnectionFeature.getModelType())
					framedConnectionFeature.delete(this, deleteContext);
		}	}
		//Step 2
		((DeleteContext) deleteContext).setMultiDeleteInfo(new MultiDeleteInfo(false, false, 0));
		super.delete(deleteContext);
	
	}
	
	//TODO publish	
	public void deleteBusinessObject(Object object) {
		super.deleteBusinessObject(object);
	}
}
