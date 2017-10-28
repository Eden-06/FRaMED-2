package org.framed.iorm.ui.graphitifeatures;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.impl.DefaultReconnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.framed.iorm.model.Relation;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.util.ConnectionPatternUtil;

//TODO
public class FRaMEDReconnectFeature extends DefaultReconnectionFeature  {

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
	
}
