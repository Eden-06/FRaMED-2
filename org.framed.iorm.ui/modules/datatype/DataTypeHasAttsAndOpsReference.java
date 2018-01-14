package datatype;

import org.framed.iorm.model.Type;
import org.framed.iorm.ui.references.AbstractHasAttsAndOpsReference;

/**
 * The reference class which saves in which module feature's shapes a attribute or
 * operation can be added with specific informations for Datatypes.
 */
public class DataTypeHasAttsAndOpsReference extends AbstractHasAttsAndOpsReference {

	/**
	 * the object to get names, ids and so on for the datatype feature
	 */
	private Literals literals = new Literals();
	
	/**
	 * the object to call utility operations of the datatype feature on
	 */
	private Util util = new Util();
	
	/**
	 * class constructor
	 */
	public DataTypeHasAttsAndOpsReference() {
		modelType = Type.DATA_TYPE;
		shadowShapeID = literals.SHAPE_ID_DATATYPE_SHADOW;
	}
	
	/** */
	@Override
	public int getHorizontalCenter(int height) {
		return util.calculateHorizontalCenter(height);
	}

}
