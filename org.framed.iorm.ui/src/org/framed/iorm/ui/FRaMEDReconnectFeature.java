package org.framed.iorm.ui;

import java.util.List;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.impl.DefaultReconnectionFeature;
import org.eclipse.graphiti.pattern.IConnectionPattern;
import org.framed.iorm.model.Relation;
import org.framed.iorm.ui.providers.FeatureProvider;

/**
 * This class manages checks and needed changes to the business model when reconnecting relations
 * <p>
 * It uses the {@link FRaMEDConnectionPattern#canReconnect(IReconnectionContext)} and 
 * {@link FRaMEDConnectionPattern#postReconnect(IReconnectionContext)} operations to get
 * pattern specific reconnect behavior. 
 * @author Kevin Kassin
 */
public class FRaMEDReconnectFeature extends DefaultReconnectionFeature  {
	
	/**
	 * the list of connection patterns known to the feature provider to which this feature belongs to
	 */
	private List<IConnectionPattern> connectionFeatures;
	
	/**
	 * Class constructor
	 * @param featureProvider the feature provider the feature belongs to
	 */
	public FRaMEDReconnectFeature(IFeatureProvider featureProvider) {
		super(featureProvider);
		connectionFeatures = ((FeatureProvider) getFeatureProvider()).getConnectionPatterns();
	}
	
	/**
	 * decides if a reconnect can be executed by delegating the decision to the 
	 * {@link FRaMEDConnectionPattern#canReconnect(IReconnectionContext)} implementations of the
	 * connection patterns
	 */
	@Override
    public boolean canReconnect(IReconnectionContext context) {
		Relation relation = (Relation) getBusinessObjectForPictogramElement(context.getConnection());
		for(IConnectionPattern iConPattern :  connectionFeatures) {
			if(iConPattern instanceof FRaMEDConnectionPattern) {
				FRaMEDConnectionPattern framedConnectionFeature = (FRaMEDConnectionPattern) iConPattern;
				if(relation.getType() == framedConnectionFeature.getModelType())
					return framedConnectionFeature.canReconnect(context);
		}	}
		return false;
    }	
	
	/**
	 * Executes needed action after a reconnect was successful using the following steps:
	 * <p>
	 * Step 1: For every reconnect the source or target of the relations business object has to be changed
	 * 		   using {@link #changeSourceOrTargetOfRelation}.<br>
	 * Step 2: It calls the {@link FRaMEDConnectionPattern#postReconnect(IReconnectionContext)} implementations to 
	 * 		   execute pattern specific reconnect behavior. 
	 */
	@Override
	public void postReconnect(IReconnectionContext context) {
		//Step 1
		UIUtil.changeSourceOrTargetOfRelation(context);
		//Step 2
		Relation relation = (Relation) getBusinessObjectForPictogramElement(context.getConnection());
		for(IConnectionPattern iConPattern :  connectionFeatures) {
			if(iConPattern instanceof FRaMEDConnectionPattern) {
				FRaMEDConnectionPattern framedConnectionFeature = (FRaMEDConnectionPattern) iConPattern;
				if(relation.getType() == framedConnectionFeature.getModelType())
					framedConnectionFeature.postReconnect(context);
	}	}	}
}
