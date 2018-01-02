package attributeAndOperation.references;

import org.framed.iorm.model.Type;

/**
 * This is the super class for references classes which save in which other module feature's shapes a attribute or
 * operation can be added with specific informations for these.
 * @author Kevin Kassin
 */
public abstract class AbstractUsedInReference {

	/**
	 * the {@link Type} of the shape in which a attribute or operations can be added
	 */
	protected Type modelType = null;
	
	/**
	 * the id of the drop shadow of the shape in which a attribute or operations can be added
	 */
	protected String shadowShapeID = null;
	
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
	public abstract int getHorizontalCenter(int height);
}
