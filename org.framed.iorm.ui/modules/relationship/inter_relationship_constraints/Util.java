package relationship.inter_relationship_constraints;

import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.framed.iorm.ui.UIUtil;
import org.framed.iorm.ui.references.AbstractRelationshipFeatureReference;

public class Util {
	
	/**
	 * the reference to the relationship class to which the constraint belong 
	 */
	AbstractRelationshipFeatureReference relationshipReference = UIUtil.getRelationshipFeatureReference();

	/**
	 * fetches the anchor used for the pictogram model for a given anchor that is used by a business model element
	 * of a inter relationship constraint uses
	 * <p>
	 * See the implementation of the relationship feature for further informations.
	 * @param businessModelAnchor the anchor a business model element of a inter relationship constraint uses
	 * @return the equivalent anchor for the pictogram element of the inter relationship constraint
	 */
	public Anchor getGraphicalAnchorForBusinessModelAnchor(Anchor businessModelAnchor) {
		Connection connection = (Connection) businessModelAnchor.getParent();
		for(ConnectionDecorator connectionDecorator : connection.getConnectionDecorators()) {
	    	if(UIUtil.isShape_IdValue(connectionDecorator, relationshipReference.getShapeIdRelationshipAnchor()))
	    		return connectionDecorator.getAnchors().get(0);
	    }
		return null;
	}
}
