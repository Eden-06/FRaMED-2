package attributeAndOperation.usedInReferences;

import org.framed.iorm.model.Type;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.util.GeneralUtil;

public class NaturalTypeUsedInReference extends AbstractUsedInReference {

	public NaturalTypeUsedInReference() {
		modelType = Type.NATURAL_TYPE;
		shadowShapeID = IdentifierLiterals.SHAPE_ID_NATURALTYPE_SHADOW;
	}
	
	@Override
	public int getHorizontalCenter(int height) {
		return GeneralUtil.calculateHorizontalCenter(Type.NATURAL_TYPE, height);
	}

}
