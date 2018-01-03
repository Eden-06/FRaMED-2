package attributeAndOperation.references;

import org.framed.iorm.model.Type;

/**
 * The reference class which saves in which other module feature's shapes a attribute or
 * operation can be added with specific informations for Natural Types.
 */
public class NaturalTypeUsedInReference extends AbstractUsedInReference {

	/**
	 * the object to get names, ids and so on for the datatype feature
	 */
	private core.naturaltype.Literals literals = new core.naturaltype.Literals();
	
	/**
	 * the object to call utility operations of the datatype feature on
	 */
	private core.naturaltype.Util util = new core.naturaltype.Util();
	
	/**
	 * class constructor
	 */
	public NaturalTypeUsedInReference() {
		modelType = Type.NATURAL_TYPE;
		shadowShapeID = literals.SHAPE_ID_NATURALTYPE_SHADOW;
	}
	
	/** */
	@Override
	public int getHorizontalCenter(int height) {
		return util.calculateHorizontalCenter(height);
	}

}
