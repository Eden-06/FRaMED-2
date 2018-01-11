package customFeatures.references;

import org.framed.iorm.model.Type;

public class GroupStepInAndOutReference extends AbstractStepInAndOutReference {
	
	group.Literals literals = new group.Literals();
	
	public GroupStepInAndOutReference() {
		modelType = Type.GROUP;
		SHAPE_ID_TYPEBODY = literals.SHAPE_ID_GROUP_TYPEBODY;
		SHAPE_ID_NAME = literals.SHAPE_ID_GROUP_NAME;
		DIAGRAM_KIND = literals.DIAGRAM_KIND;
	}
}
