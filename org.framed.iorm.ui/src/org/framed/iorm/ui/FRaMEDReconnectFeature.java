package org.framed.iorm.ui;

import java.util.List;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.impl.DefaultReconnectionFeature;
import org.eclipse.graphiti.pattern.IConnectionPattern;
import org.framed.iorm.model.Relation;
import org.framed.iorm.ui.providers.FeatureProvider;

import relationship.RelationshipPattern;

/**
 * This class manages checks and needed changes to the business model when reconnecting relations 
 * @author Kevin Kassin
 */
public class FRaMEDReconnectFeature extends DefaultReconnectionFeature  {
	
	//TODO
	private List<IConnectionPattern> connectionFeatures;
	
	/**
	 * Class constructor
	 * @param featureProvider the feature provider the feature belongs to
	 */
	public FRaMEDReconnectFeature(IFeatureProvider featureProvider) {
		super(featureProvider);
		connectionFeatures = ((FeatureProvider) getFeatureProvider()).getConnectionPatterns();
	}
	
	//TODO doku with steps?
	/**
	 * decides if a reconnect can be executed by delegating the decision depending in the type of the relation to
	 * reconnect
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
	
	//TODO overhaul doku
	/**
	 * Executes needed action after a reconnect was succesful using the following steps:
	 * <p>
	 * Step 1: For every reconnect the source or target of the relations business object has to be changed
	 * 		   using {@link #changeSourceOrTargetOfRelation}.<br>
	 * Step 2: load dynamicly
	 * 
	 * 
	 * 
	 * Depending on the type of the reconnected relation there can be additional needed actions to do.
	 * 		   
	 * 
	 * 
	 * 
	 * 
	 * 
	 * <ul>
	 * 			<li>If a inter relationship constraint was reconnected the connection need to be connected to the anchor
	 * 		   		used in the graphiti pictogram model which is another than used in the business model. See 
	 * 		   		{@link RelationshipPattern#add} for further informations.</li>
	 * 			<li>If the target of a fulfillment was changed the wizard to choose the fulfilled roles has to be opened.</li>
	 *   	   	<li>If a relationship was reconnected its intra relationship constraints need to be reconnected to.</li> 
	 *   	   </ul>
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
