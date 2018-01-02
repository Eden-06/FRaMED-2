package attributeAndOperation.usedInReferences;

import org.framed.iorm.model.Type;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.util.GeneralUtil;

public class CompartmentTypeUsedInReference extends AbstractUsedInReference {

	public CompartmentTypeUsedInReference() {
		modelType = Type.COMPARTMENT_TYPE;
		shadowShapeID = IdentifierLiterals.SHAPE_ID_COMPARTMENTTYPE_SHADOW;
	}
	
	@Override
	public int getHorizontalCenter(int height) {
		return GeneralUtil.calculateHorizontalCenter(Type.COMPARTMENT_TYPE, height);
	}
}
