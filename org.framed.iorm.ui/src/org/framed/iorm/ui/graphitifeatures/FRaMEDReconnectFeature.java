package org.framed.iorm.ui.graphitifeatures;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.context.impl.CustomContext;
import org.eclipse.graphiti.features.context.impl.ReconnectionContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.features.impl.DefaultReconnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.framed.iorm.model.Relation;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.literals.NameLiterals;
import org.framed.iorm.ui.pattern.connections.RelationshipPattern;
import org.framed.iorm.ui.util.ConnectionPatternUtil;
import org.framed.iorm.ui.util.GeneralUtil;
import org.framed.iorm.ui.util.PropertyUtil;

/**
 * This class adds checks and needed changes to the business model when reconnecting relations 
 * @author Kevin Kassin
 */
public class FRaMEDReconnectFeature extends DefaultReconnectionFeature  {

	/**
	 * the identifier for a diagram of a stepped in compartment view gathered from
	 * {@link IdentifierLiterals}
	 */
	private static final String DIAGRAM_KIND_COMPARTMENTTYPE_DIAGRAM = IdentifierLiterals.DIAGRAM_KIND_COMPARTMENTTYPE_DIAGRAM;
	
	/**
	 * the name of the edit relationship feature gathered from {@link NameLiterals}
	 */
	private final String EDIT_FULFILLMENT_FEATURE_NAME = NameLiterals.EDIT_FULFILLMENT_FEATURE_NAME;
	
	/**
	 * Class constructor
	 * @param featureProvider the feature provider the feature belongs to
	 */
	public FRaMEDReconnectFeature(IFeatureProvider featureProvider) {
		super(featureProvider);
	}
	
	/**
	 * decides if a reconnect can be executed by delegating the decision depending in the type of the relation to
	 * reconnect
	 */
	@Override
    public boolean canReconnect(IReconnectionContext context) {
		Relation relation = (Relation) getBusinessObjectForPictogramElement(context.getConnection());
		if(relation.getType() == Type.INHERITANCE) return canReconnectInheritance(context);
		if(relation.getType() == Type.RELATIONSHIP) return canReconnectRelationship(context);
		if(relation.getType() == Type.RELATIONSHIP_EXCLUSION ||
		   relation.getType() == Type.RELATIONSHIP_IMPLICATION) return canReconnectInterRelCon(context);
		if(relation.getType() == Type.FULFILLMENT) return canReconnectFulfillment(context);
		return false;
    }	
	
	/**
	 * decides if a {@link Type#INHERITANCE} can be reconnected
	 * @param context the context object holding all the reconnection information
	 * @return if a {@link Type#INHERITANCE} can be reconnected 
	 */
	private boolean canReconnectInheritance(IReconnectionContext context) {
		Anchor oldAnchor = context.getOldAnchor();
	    Anchor newAnchor = context.getNewAnchor();
	    org.framed.iorm.model.ModelElement oldShape = ConnectionPatternUtil.getModelElementForAnchor(oldAnchor);
	    org.framed.iorm.model.ModelElement newShape = ConnectionPatternUtil.getModelElementForAnchor(newAnchor);
	    if(oldShape != null && newShape != null) {
	    	if(oldShape.getContainer() == newShape.getContainer()) {
	    		if(newShape.getType() == oldShape.getType()) {
	    			return true;
	    }	}	}
	    return false;
	}
	
	/**
	 * decides if a {@link Type#RELATIONSHIP} can be reconnected
	 * @param context the context object holding all the reconnection information
	 * @return if a {@link Type#RELATIONSHIP} can be reconnected 
	 */
	private boolean canReconnectRelationship(IReconnectionContext context) {
		Anchor newAnchor = context.getNewAnchor();
		org.framed.iorm.model.ModelElement newShape = ConnectionPatternUtil.getModelElementForAnchor(newAnchor);
		if(newShape != null) 
			return newShape.getType()==Type.ROLE_TYPE;
		return false;
	}
	
	/**
	 * decides if a inter relationship constraint can be reconnected
	 * @param context the context object holding all the reconnection information
	 * @return if a inter relationship constraint can be reconnected 
	 */
	private boolean canReconnectInterRelCon(IReconnectionContext context) {
		Anchor newAnchor = context.getNewAnchor();
		org.framed.iorm.model.ModelElement newRelation = ConnectionPatternUtil.getModelElementForAnchor(newAnchor);
		if(newRelation != null) 
			return (newRelation.getType() == Type.RELATIONSHIP);
		return false;
	}
	
	/**
	 * decides if a {@link Type#FULFILLMENT} can be reconnected
	 * @param context the context object holding all the reconnection information
	 * @return if a {@link Type#FULFILLMENT} can be reconnected 
	 */
	private boolean canReconnectFulfillment(IReconnectionContext context) {
		Anchor newAnchor = context.getNewAnchor();
		org.framed.iorm.model.ModelElement newShape = ConnectionPatternUtil.getModelElementForAnchor(newAnchor);
		if(newShape != null) {	
			if(context.getReconnectType() == ReconnectionContext.RECONNECT_SOURCE)
				return newShape.getType() == Type.NATURAL_TYPE || newShape.getType() == Type.DATA_TYPE || 
						newShape.getType() == Type.COMPARTMENT_TYPE || 
					   (newShape.getType() == Type.ROLE_TYPE && PropertyUtil.isDiagram_KindValue(getDiagram(), DIAGRAM_KIND_COMPARTMENTTYPE_DIAGRAM));
			else
				return newShape.getType() == Type.COMPARTMENT_TYPE;
		}
		return false;
	}
	
	/**
	 * Executes needed action after a reconnect was succesful using the following steps:
	 * <p>
	 * Step 1: For every reconnect the source or target of the relations business object has to be changed
	 * 		   using {@link #changeSourceOrTargetOfRelation}.<br>
	 * Step 2: Depending on the type of the reconnected relation there can be additional needed actions to do.
	 * 		   <ul>
	 * 			<li>If a inter relationship constraint was reconnected the connection need to be connected to the anchor
	 * 		   		used in the graphiti pictogram model which is another than used in the business model. See 
	 * 		   		{@link RelationshipPattern#add} for further informations.</li>
	 * 			<li>If the target of a fulfillment was changed the wizard to choose the fulfilled roles has to be opened.</li>  
	 */
	@Override
	public void postReconnect(IReconnectionContext context) {
		//Step 1
		changeSourceOrTargetOfRelation(context);
		//Step 2
		Connection connection = context.getConnection();
		Relation relation = (Relation) getBusinessObjectForPictogramElement(connection);			
		//inter relationship constraint
		if(relation.getType() == Type.RELATIONSHIP_EXCLUSION ||
		   relation.getType() == Type.RELATIONSHIP_IMPLICATION) {
			Anchor graphicalNewAnchor = null;
			graphicalNewAnchor = ConnectionPatternUtil.getGraphicalAnchorForBusinessModelAnchor(context.getNewAnchor());
			if(graphicalNewAnchor == null) return;
			if(context.getReconnectType() == ReconnectionContext.RECONNECT_SOURCE)
				connection.setStart(graphicalNewAnchor);
			else     
				connection.setEnd(graphicalNewAnchor);
		}
		//fulfillment
		if(relation.getType() == Type.FULFILLMENT) {
			if(context.getReconnectType() == ReconnectionContext.RECONNECT_TARGET) {
				changeSourceOrTargetOfRelation(context);
				CustomContext customContext = new CustomContext();
				PictogramElement[] pictogramElement = new PictogramElement[1];
				pictogramElement[0] = connection;
				customContext.setPictogramElements(pictogramElement);
				ICustomFeature[] customFeatures = getFeatureProvider().getCustomFeatures(customContext);
				EditFulfillmentFeature editFulfillmentFeature = (EditFulfillmentFeature) GeneralUtil
						.findFeatureByName(customFeatures, EDIT_FULFILLMENT_FEATURE_NAME);
				if (editFulfillmentFeature.canExecute(customContext))
					editFulfillmentFeature.execute(customContext);
			}
		}
	}
	
	/**
	 * Changes the source or target reference of the business object relation depending which node of the
	 * relation was changed
	 * @param context the context object holding all the reconnection information
	 */
	private void changeSourceOrTargetOfRelation(IReconnectionContext context) {
		Connection connection = context.getConnection();
		Relation relation = (Relation) getBusinessObjectForPictogramElement(connection);
		Anchor newAnchor = context.getNewAnchor();
		org.framed.iorm.model.ModelElement newShape = ConnectionPatternUtil.getModelElementForAnchor(newAnchor);
		if(context.getReconnectType() == ReconnectionContext.RECONNECT_SOURCE)
			relation.setSource(newShape);
		else
			relation.setTarget(newShape);
	}
}
