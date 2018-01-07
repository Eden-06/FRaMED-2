package attributeAndOperation.references;

import org.framed.iorm.model.Type;

/**
 * The reference class which saves in which other module feature's shapes a attribute or
 * operation can be added with specific informations for Role Types.
 */
public class RoleTypeUsedInReference extends AbstractUsedInReference {

	/**
	 * the object to get names, ids and so on for the datatype feature
	 */
	private roletype.Literals literals = new roletype.Literals();
	
	/**
	 * the object to call utility operations of the datatype feature on
	 */
	private roletype.Util util = new roletype.Util();
	
	/**
	 * class constructor
	 */
	public RoleTypeUsedInReference() {
		modelType = Type.ROLE_TYPE;
		shadowShapeID = literals.SHAPE_ID_ROLETYPE_SHADOW;
	}
	
	/** */
	@Override
	public int getHorizontalCenter(int height) {
		return util.calculateHorizontalCenter(height);
	}

}
