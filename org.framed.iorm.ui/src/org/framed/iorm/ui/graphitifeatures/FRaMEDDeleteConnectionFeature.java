package org.framed.iorm.ui.graphitifeatures;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.impl.DeleteContext;
import org.eclipse.graphiti.features.context.impl.MultiDeleteInfo;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.ui.features.DefaultDeleteFeature;
import org.framed.iorm.model.Relation;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.providers.FeatureProvider;
import org.framed.iorm.ui.util.ConnectionPatternUtil;

/**
 * This graphiti custom feature is used to disabling the possibility of deleting connection decorators and the 
 * "Are you sure?" message when deleting connections.
 * <p>
 * It is returned by the operation {@link FeatureProvider#getDeleteFeatureAdditional}.
 * @author Kevin Kassin
 */
public class FRaMEDDeleteConnectionFeature extends DefaultDeleteFeature {

	/**
	 * the identifiers for the connection decorators to delete with when deleting a connection
	 */
	protected static final String SHAPE_ID_INTRA_REL_CON_NAME_DECORATOR = IdentifierLiterals.SHAPE_ID_INTRA_REL_CON_NAME_DECORATOR,
								  SHAPE_ID_RELATIONSHIP_ANCHOR_DECORATOR = IdentifierLiterals.SHAPE_ID_RELATIONSHIP_ANCHOR_DECORATOR;
	
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
	 * <p>
	 * Also deletes intra and inter relationship constraints when deleting relationships. This is needed to
	 * be done explicitly because graphiti does not automaticly deletes the business object of these constraints.
	 */
	@Override
	public void delete(IDeleteContext deleteContext) {
		Relation relation = (Relation) getBusinessObjectForPictogramElement(deleteContext.getPictogramElement());
		if(relation.getType() == Type.RELATIONSHIP) deleteAttachedConstraints(deleteContext);
		((DeleteContext) deleteContext).setMultiDeleteInfo(new MultiDeleteInfo(false, false, 0));
		super.delete(deleteContext);
	}
	
	/**
	 * deletes intra and inter relationship constraints when deleting a relationship using the
	 * following steps:
	 * <p>
	 * Step 1: find intra relationship constraints business elements by checking the referenced relations of the relationship
	 * 		   to delete<br>
	 * Step 2: find inter relationship constraints pictogram elements by checking the anchor for the pictogram model 
	 * 		   of the relationship to delete
	 * Step 3: delete the business objects and pictogram elements of all found intra and inter relationship constraints
	 * @param deleteContext the context with a reference to the relationship to delete
	 */
	private void deleteAttachedConstraints(IDeleteContext deleteContext) {
		Connection connection = (Connection) deleteContext.getPictogramElement();
		Relation relation = (Relation) getBusinessObjectForPictogramElement(connection);
		List<Relation> relationsToDeleteAlso = new ArrayList<Relation>();
		List<Connection> connectionsToDeleteAlso = new ArrayList<Connection>();
		//Step 1
		relationsToDeleteAlso.addAll(relation.getReferencedRelation());
		//Step 2
		ConnectionDecorator anchorDecorator = 
			ConnectionPatternUtil.getConnectionDecoratorByShapeId(connection, SHAPE_ID_RELATIONSHIP_ANCHOR_DECORATOR);
		connectionsToDeleteAlso.addAll(anchorDecorator.getAnchors().get(0).getIncomingConnections());
		connectionsToDeleteAlso.addAll(anchorDecorator.getAnchors().get(0).getOutgoingConnections());
		//Step 4
		for(Relation relationToDeleteAlso : relationsToDeleteAlso) {
			deleteBusinessObject(relationToDeleteAlso);
		}
		for(Connection connectionToDeleteAlso : connectionsToDeleteAlso) {
			DeleteContext deleteContextForInterRelCon = new DeleteContext(connectionToDeleteAlso);
			delete(deleteContextForInterRelCon);
	}	}		
}
