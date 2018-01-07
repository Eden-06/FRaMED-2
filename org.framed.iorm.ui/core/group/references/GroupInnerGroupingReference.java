package group.references;

import group.Literals;

/**
 * This is needed since inner group elements in a group need to be handled specific when deleting a group. Such references are
 * loaded dynamicly by Group Pattern. Thats why a reference for the group itself is needed.
 * @author Kevin Kassin
 */
public class GroupInnerGroupingReference extends AbstractInnerGroupingReference{

	/**
	 * the object to get names, id and so on for this feature
	 */
	private final Literals literals = new Literals();
	
	/**
	 * class constructor
	 */
	public GroupInnerGroupingReference() {
		SHAPE_ID_CONTAINER = literals.SHAPE_ID_GROUP_CONTAINER;
		SHAPE_ID_TYPEBODY = literals.SHAPE_ID_GROUP_TYPEBODY;
	}
}
