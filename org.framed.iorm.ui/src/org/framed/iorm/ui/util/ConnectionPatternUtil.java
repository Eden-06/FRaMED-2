package org.framed.iorm.ui.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IMappingProvider; //*import for javadoc link
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.framed.iorm.model.Relation;
import org.framed.iorm.model.Shape;
import org.framed.iorm.model.Type;

public class ConnectionPatternUtil {

	public static List<Relation> getRelationForClassOrRole(Shape classOrRole, Type type) {
		List<Relation> relations = new ArrayList<Relation>();
		for(Relation relation : classOrRole.getIncomingRelations()) {
			if(relation.getType() == type) relations.add(relation);
		}
		for(Relation relation : classOrRole.getOutgoingRelations()) {
			if(relation.getType() == type) relations.add(relation);
		}
		return relations;
	}
	
	public static List<Relation> getRelationsBetweenClassesOrRoles(Shape sourceClassOrRole, Shape targetClassOrRole, Type type) {
		List<Relation> commonRelations = new ArrayList<Relation>();
		List<Relation> sourceRelations = getRelationForClassOrRole(sourceClassOrRole, type);
		List<Relation> targetRelations = getRelationForClassOrRole(targetClassOrRole, type);
		for(Relation relation : targetRelations) {
			if(sourceRelations.contains(relation))
				commonRelations.add(relation);
		}
		return commonRelations;
	}
	
	/**
	 * helper method to get the {@link Shape} for a given anchor
	 * @param anchor the anchor that belongs to the shape to get
	 * @return the shape that has the give anchor
	 */
	public static org.framed.iorm.model.Shape getShapeForAnchor(Anchor anchor) {
		Object object = null;
		if (anchor != null) { object = getBusinessObjectForPictogramElement(anchor.getParent()); }
		if (object != null) {
			if (object instanceof org.framed.iorm.model.Shape)
				return (org.framed.iorm.model.Shape) object;
		}
		return null;
	}
	
	/**
	 * returns the first linked business object of a pictogram
	 * <p>
	 * This operation is build after method {@link IMappingProvider#getBusinessObjectForPictogramElement} to avoid
	 * a dependency.<br>
	 * This is a convenience method for getAllBusinessObjectsForPictogramElement(PictogramElement), because in many 
	 * usecases only a single business object is linked.
	 * @param pictogramElement the pictogram element to get business object for
	 * @return the first business object of a pictogram element
	 */
	private static EObject getBusinessObjectForPictogramElement(PictogramElement pictogramElement) {
		return pictogramElement.getLink().getBusinessObjects().get(0);
	}
	
}
