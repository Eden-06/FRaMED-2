package org.framed.iorm.ui.references;

/**
 * the super class for classes that reference the used relationship feature
 * @author Kevin Kassin
 */
public abstract class AbstractRelationshipFeatureReference {
	
	/**
	 * the shape id of the relationship anchor 
	 */
	protected String SHAPE_ID_RELATIONSHIP_ANCHOR_DECORATOR;
	
	/**
	 * getter method for SHAPE_ID_RELATIONSHIP_ANCHOR_DECORATOR
	 * @return 
	 */
	public String getShapeIdRelationshipAnchor() {
		return SHAPE_ID_RELATIONSHIP_ANCHOR_DECORATOR;
	}
}
