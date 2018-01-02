package attributeAndOperation.references;

import org.framed.iorm.model.Type;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.util.GeneralUtil;

/**
 * The reference class which saves in which other module feature's shapes a attribute or
 * operation can be added with specific informations for Natural Types.
 */
public class NaturalTypeUsedInReference extends AbstractUsedInReference {

	/**
	 * class constructor
	 */
	public NaturalTypeUsedInReference() {
		modelType = Type.NATURAL_TYPE;
		shadowShapeID = IdentifierLiterals.SHAPE_ID_NATURALTYPE_SHADOW;
	}
	
	/** */
	@Override
	public int getHorizontalCenter(int height) {
		return GeneralUtil.calculateHorizontalCenter(Type.NATURAL_TYPE, height);
	}

}
