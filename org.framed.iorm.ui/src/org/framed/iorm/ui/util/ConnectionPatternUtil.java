package org.framed.iorm.ui.util;

import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.framed.iorm.model.Shape;

/**
 * This class offers several utility operations mostly used by the graphiti connection patterns.
 * @author Kevin Kassin
 */
public class ConnectionPatternUtil {

	/**
	 * helper method to get the {@link Shape} for a given anchor
	 * @param anchor the anchor that belongs to the shape to get
	 * @return the shape that has the give anchor
	 */
	public static org.framed.iorm.model.Shape getShapeForAnchor(Anchor anchor) {
		Object object = null;
		if (anchor != null) { object = GeneralUtil.getBusinessObjectForPictogramElement(anchor.getParent()); }
		if (object != null) {
			if (object instanceof org.framed.iorm.model.Shape)
				return (org.framed.iorm.model.Shape) object;
		}
		return null;
	}
	
	
	
}
