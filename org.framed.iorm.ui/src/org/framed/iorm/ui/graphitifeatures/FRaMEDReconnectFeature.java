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
import org.framed.iorm.ui.util.ConnectionPatternUtil;
import org.framed.iorm.ui.util.GeneralUtil;
import org.framed.iorm.ui.util.PropertyUtil;

//TODO
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
	
	//TODO
	public FRaMEDReconnectFeature(IFeatureProvider featureProvider) {
		super(featureProvider);
	}
	
	//TODO
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
	
	//TODO
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
	
	//TODO
	private boolean canReconnectRelationship(IReconnectionContext context) {
		Anchor newAnchor = context.getNewAnchor();
		org.framed.iorm.model.ModelElement newShape = ConnectionPatternUtil.getModelElementForAnchor(newAnchor);
		if(newShape != null) 
			return newShape.getType()==Type.ROLE_TYPE;
		return false;
	}
	
	//TODO
	private boolean canReconnectInterRelCon(IReconnectionContext context) {
		Anchor newAnchor = context.getNewAnchor();
		org.framed.iorm.model.ModelElement newRelation = ConnectionPatternUtil.getModelElementForAnchor(newAnchor);
		if(newRelation != null) 
			return (newRelation.getType() == Type.RELATIONSHIP);
		return false;
	}
	
	//TODO
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
	
	//TODO
	@Override
	public void postReconnect(IReconnectionContext context) {
		//Step 1 TODO
		changeSourceOrTargetOfRelation(context);
		//Step 2 TODO
		Connection connection = context.getConnection();
		Relation relation = (Relation) getBusinessObjectForPictogramElement(connection);			
		//Option 1
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
		//Option 2 TODO
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
