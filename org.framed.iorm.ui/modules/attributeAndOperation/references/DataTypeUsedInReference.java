package attributeAndOperation.references;

import org.framed.iorm.model.Type;

/**
 * The reference class which saves in which other module feature's shapes a attribute or
 * operation can be added with specific informations for Datatypes.
 */
public class DataTypeUsedInReference extends AbstractUsedInReference {

	/**
	 * the object to get names, ids and so on for the datatype feature
	 */
	private datatype.Literals literals = new datatype.Literals();
	
	/**
	 * the object to call utility operations of the datatype feature on
	 */
	private datatype.Util util = new datatype.Util();
	
	/**
	 * class constructor
	 */
	public DataTypeUsedInReference() {
		modelType = Type.DATA_TYPE;
		shadowShapeID = literals.SHAPE_ID_DATATYPE_SHADOW;
	}
	
	/** */
	@Override
	public int getHorizontalCenter(int height) {
		return util.calculateHorizontalCenter(height);
	}

}
