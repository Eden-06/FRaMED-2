package roletype.properties;

import org.framed.iorm.model.Type;
import org.framed.iorm.ui.references.AbstractHasAttsAndOpsReference;

import roletype.Literals;
import roletype.Util;

/**
 * The reference class which saves in which other module feature's shapes a attribute or
 * operation can be added with specific informations for Role Types.
 */
public class RoleTypeHasAttsAndOpsReference extends AbstractHasAttsAndOpsReference {

	/**
	 * the object to get names, ids and so on for the role type feature
	 */
	private Literals literals = new Literals();
	
	/**
	 * the object to call utility operations of the role feature on
	 */
	private Util util = new Util();
	
	/**
	 * class constructor
	 */
	public RoleTypeHasAttsAndOpsReference() {
		modelType = Type.ROLE_TYPE;
		shadowShapeID = literals.SHAPE_ID_ROLETYPE_SHADOW;
	}
	
	/** */
	@Override
	public int getHorizontalCenter(int height) {
		return util.calculateHorizontalCenter(height);
	}

}
