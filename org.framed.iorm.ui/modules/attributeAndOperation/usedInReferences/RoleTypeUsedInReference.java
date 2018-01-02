package attributeAndOperation.usedInReferences;

import org.framed.iorm.model.Type;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.util.GeneralUtil;

public class RoleTypeUsedInReference extends AbstractUsedInReference {

	public RoleTypeUsedInReference() {
		modelType = Type.ROLE_TYPE;
		shadowShapeID = IdentifierLiterals.SHAPE_ID_ROLETYPE_SHADOW;
	}
	
	@Override
	public int getHorizontalCenter(int height) {
		return GeneralUtil.calculateHorizontalCenter(Type.ROLE_TYPE, height);
	}

}
