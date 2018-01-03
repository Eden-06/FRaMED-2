package attributeAndOperation.references;

import org.framed.iorm.model.Type;
import org.framed.iorm.ui.util.GeneralUtil;

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
	 * class constructor
	 */
	public NaturalTypeUsedInReference() {
		modelType = Type.NATURAL_TYPE;
		shadowShapeID = literals.SHAPE_ID_NATURALTYPE_SHADOW;
	}
	
	/** */
	@Override
	public int getHorizontalCenter(int height) {
		return GeneralUtil.calculateHorizontalCenter(Type.NATURAL_TYPE, height);
	}

}
