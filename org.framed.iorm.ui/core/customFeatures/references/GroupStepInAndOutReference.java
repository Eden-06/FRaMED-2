package customFeatures.references;

import org.framed.iorm.model.Type;

/**
 * The reference class that encapsulate the informations for groups to step in and out.
 * @author Kevin Kassin
 */
public class GroupStepInAndOutReference extends AbstractStepInAndOutReference {
	
	/**
	 * the group's literals
	 */
	group.Literals literals = new group.Literals();
	
	/**
	 * class constructor
	 */
	public GroupStepInAndOutReference() {
		modelType = Type.GROUP;
		SHAPE_ID_TYPEBODY = literals.SHAPE_ID_GROUP_TYPEBODY;
		SHAPE_ID_NAME = literals.SHAPE_ID_GROUP_NAME;
		DIAGRAM_KIND = literals.DIAGRAM_KIND;
	}
}
