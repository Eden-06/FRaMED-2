package naturaltype;

import org.framed.iorm.model.Type;
import org.framed.iorm.ui.references.AbstractHasAttsAndOpsReference;

/**
 * The reference class which saves in which module feature's shapes a attribute or
 * operation can be added with specific informations for Natural Types.
 */
public class NaturalTypeHasAttsAndOpsReference extends AbstractHasAttsAndOpsReference {

	/**
	 * the object to get names, ids and so on for the natural type feature
	 */
	private Literals literals = new Literals();
	
	/**
	 * the object to call utility operations of the natural type feature on
	 */
	private Util util = new Util();
	
	/**
	 * class constructor
	 */
	public NaturalTypeHasAttsAndOpsReference() {
		modelType = Type.NATURAL_TYPE;
		shadowShapeID = literals.SHAPE_ID_NATURALTYPE_SHADOW;
	}
	
	/** */
	@Override
	public int getHorizontalCenter(int height) {
		return util.calculateHorizontalCenter(height);
	}

}
