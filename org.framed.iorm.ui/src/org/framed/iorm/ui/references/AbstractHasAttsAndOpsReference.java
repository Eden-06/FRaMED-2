package org.framed.iorm.ui.references;

import org.framed.iorm.model.Type;

/**
 * This is the super class for reference classes which save in which modules feature's shapes a attribute or
 * operation can be added with specific informations for these.
 * @author Kevin Kassin
 */
public abstract class AbstractHasAttsAndOpsReference {

	/**
	 * the {@link Type} of the shape in which a attribute or operations can be added
	 */
	protected Type modelType;
	
	/**
	 * the id of the drop shadow of the shape in which a attribute or operations can be added
	 */
	protected String shadowShapeID;
	
	/**
	 * getter method for modelType
	 */
	public Type getModelType() {
		return modelType;
	}
	
	/**
	 * getter method for shadowShapeID
	 */
	public String getShadowShapeID() {
		return shadowShapeID;
	}
	
	/**
	 * calculation where the horizontal center for a shape is
	 * @param height the height of the shape
	 * @return the height of the horizontal center
	 */
	public int getHorizontalCenter(int height) {
		return 0;
	}
}
