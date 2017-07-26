package org.framed.iorm.ui.util;

import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;

/**
 * This class offers several utility operations mostly used by the graphiti connection patterns.
 * @author Kevin Kassin
 */
public class ConnectionPatternUtil {

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
	
	//TODO
	public static ConnectionDecorator getConnectionDecoratorByShapeId(Connection connection, String SHAPE_ID) {
		for(ConnectionDecorator decorator : connection.getConnectionDecorators()) {
			if(PropertyUtil.isShape_IdValue(decorator,SHAPE_ID))
				return decorator;
		}
		return null;
	}
}
