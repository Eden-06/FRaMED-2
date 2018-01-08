package customFeatures.references;

import org.framed.iorm.model.Type;
import org.framed.iorm.ui.literals.UILiterals;

public class GroupStepInAndOutReference extends AbstractStepInAndOutReference {
	
	group.Literals literals = new group.Literals();
	
	public GroupStepInAndOutReference() {
		modelType = Type.GROUP;
		SHAPE_ID_TYPEBODY = literals.SHAPE_ID_GROUP_TYPEBODY;
		SHAPE_ID_NAME = literals.SHAPE_ID_GROUP_NAME;
		DIAGRAM_KIND = UILiterals.DIAGRAM_KIND_GROUP_DIAGRAM;
	}
}
