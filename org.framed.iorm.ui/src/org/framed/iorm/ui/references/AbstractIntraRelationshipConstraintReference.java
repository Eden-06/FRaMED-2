package org.framed.iorm.ui.references;

/**
 * This class encapsulates the dependency of the relationship to its intra relationship constraint feature.
 * @author Kevin Kassin
 */
public abstract class AbstractIntraRelationshipConstraintReference {

	/**
	 * The shape id of the name decorator of an intra relationship constraint
	 */
	protected String SHAPE_ID_INTRA_REL_CON_NAME_DECORATOR;
	
	/**
	 * getter for SHAPE_ID_INTRA_REL_CON_NAME_DECORATOR
	 * @return the shape id of the name decorator of an intra relationship constraint
	 */
	public String getIntraRelConNameDecorator() {
		return SHAPE_ID_INTRA_REL_CON_NAME_DECORATOR;
	}
}
