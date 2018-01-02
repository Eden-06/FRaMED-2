package attributeAndOperation.references;

import org.framed.iorm.model.Type;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.util.GeneralUtil;

/**
 * The reference class which saves in which other module feature's shapes a attribute or
 * operation can be added with specific informations for Compartment Types.
 */
public class CompartmentTypeUsedInReference extends AbstractUsedInReference {

	/**
	 * class constructor
	 */
	public CompartmentTypeUsedInReference() {
		modelType = Type.COMPARTMENT_TYPE;
		shadowShapeID = IdentifierLiterals.SHAPE_ID_COMPARTMENTTYPE_SHADOW;
	}
	
	/** */
	@Override
	public int getHorizontalCenter(int height) {
		return GeneralUtil.calculateHorizontalCenter(Type.COMPARTMENT_TYPE, height);
	}
}
