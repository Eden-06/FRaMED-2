package org.framed.iorm.ui.pattern.connections;

import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.pattern.AbstractConnectionPattern;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.framed.iorm.model.Shape; //*import for javadoc link

/**
 * This class is an abstract super class for the graphiti connection patterns.
 * <p>
 * It collects common attributes and operations of these classes.
 * @author Kevin Kassin
 */
public class FRaMEDConnectionPattern extends AbstractConnectionPattern {
	
	/**
	 * Class constructor
	 */
	public FRaMEDConnectionPattern() {
		super();
	}
	
	/**
	 * the pictogram elements service used to creates pictogram elements in the subclasses
	 */
	protected final IPeCreateService pictogramElementCreateSerive = Graphiti.getPeCreateService();
	
	/**
	 * the graphics algorithm service used to create graphics algorithms in the subclasses
	 */
	protected final IGaService graphicAlgorithmService = Graphiti.getGaService();
	
	/**
	 * helper method to get the {@link Shape} for a given anchor
	 * @param anchor the anchor that belongs to the shape to get
	 * @return the shape that has the give anchor
	 */
	public org.framed.iorm.model.Shape getShapeForAnchor(Anchor anchor) {
		Object object = null;
		if (anchor != null) { object = getBusinessObjectForPictogramElement(anchor.getParent()); }
		if (object != null) {
			if (object instanceof org.framed.iorm.model.Shape)
				return (org.framed.iorm.model.Shape) object;
		}
		return null;
	}	
}
