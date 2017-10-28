package org.framed.iorm.ui.util;

import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.pattern.connections.RelationshipPattern; //*import for javadoc link

/**
 * This class offers several utility operations mostly used by the graphiti connection patterns.
 * @author Kevin Kassin
 */
public class ConnectionPatternUtil {
	
	/**
	 * values for the property shape id gathered from {@link IdentifierLiterals}
	 */
	static String SHAPE_ID_RELATIONSHIP_ANCHOR_DECORATOR = IdentifierLiterals.SHAPE_ID_RELATIONSHIP_ANCHOR_DECORATOR;

	/**
	 * helper method to get the {@link ModelElement} for a given anchor
	 * @param anchor the anchor that belongs to the model element to get
	 * @return the model element that has the give anchor
	 */
	public static org.framed.iorm.model.ModelElement getModelElementForAnchor(Anchor anchor) {
		Object object = null;
		if (anchor != null) { object = GeneralUtil.getBusinessObjectForPictogramElement(anchor.getParent()); }
		if (object != null) {
			if (object instanceof org.framed.iorm.model.Shape)
				return (org.framed.iorm.model.Shape) object;
			if (object instanceof org.framed.iorm.model.Relation)
				return (org.framed.iorm.model.Relation) object;
		}
		return null;
	}
	
	/**
	 * searches over all connection decorators of a given connection to find a specific one by its shape id
	 * @param connection the connection with the decorators to search over
	 * @param SHAPE_ID identifies the searched connection decorators
	 * @return the connection decorator with the given shape id or null if none was found
	 */
	public static ConnectionDecorator getConnectionDecoratorByShapeId(Connection connection, String SHAPE_ID) {
		for(ConnectionDecorator decorator : connection.getConnectionDecorators()) {
			if(PropertyUtil.isShape_IdValue(decorator,SHAPE_ID))
				return decorator;
		}
		return null;
	}
	
	/**
	 * fetches the anchor used for the pictogram model for a given anchor that is used by a business model element
	 * of a inter relationship constraint uses
	 * <p>
	 * See {@link RelationshipPattern#add} for further informations.
	 * @param businessModelAnchor the anchor a business model element of a inter relationship constraint uses
	 * @return the equivalent anchor for the pictogram element of the inter relationship constraint
	 */
	public static Anchor getGraphicalAnchorForBusinessModelAnchor(Anchor businessModelAnchor) {
		Connection connection = (Connection) businessModelAnchor.getParent();
		for(ConnectionDecorator connectionDecorator : connection.getConnectionDecorators()) {
	    	if(PropertyUtil.isShape_IdValue(connectionDecorator, SHAPE_ID_RELATIONSHIP_ANCHOR_DECORATOR))
	    		return connectionDecorator.getAnchors().get(0);
	    }
		return null;
	}
}
