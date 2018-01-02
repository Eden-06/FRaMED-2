package attributeAndOperation.references;

import org.framed.iorm.model.Type;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.util.GeneralUtil;

/**
 * The reference class which saves in which other module feature's shapes a attribute or
 * operation can be added with specific informations for Role Types.
 */
public class RoleTypeUsedInReference extends AbstractUsedInReference {

	/**
	 * class constructor
	 */
	public RoleTypeUsedInReference() {
		modelType = Type.ROLE_TYPE;
		shadowShapeID = IdentifierLiterals.SHAPE_ID_ROLETYPE_SHADOW;
	}
	
	/** */
	@Override
	public int getHorizontalCenter(int height) {
		return GeneralUtil.calculateHorizontalCenter(Type.ROLE_TYPE, height);
	}

}
