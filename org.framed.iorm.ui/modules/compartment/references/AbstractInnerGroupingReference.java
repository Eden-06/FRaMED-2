package compartment.references;

/**
 * This is the abstract super class for classes which encapsulated the dependency between grouping (e.g. Groups and
 * Compartment Types) and Group feature. This is needed since grouping elements in a group need to be handled specific
 * when deleting a group.
 * @author Kevin Kassin
 */
public abstract class AbstractInnerGroupingReference {

	/**
	 * the id of the container shape of the grouping feature in the group
	 */
	protected String SHAPE_ID_CONTAINER;
	
	/**
	 * the id of the typebody shape of the grouping feature in the group
	 */
	protected String SHAPE_ID_TYPEBODY;
	
	/**
	 * getter for the id of the container shape of the grouping feature in the group
	 * @return {@link #SHAPE_ID_CONTAINER}
	 */
	public String getShapeIdContainer() {
		return SHAPE_ID_CONTAINER;
	}
	
	/**
	 * getter for the id of the typebody shape of the grouping feature in the group
	 * @return {@link #SHAPE_ID_CONTAINER}
	 */
	public String getShapeIdTypebody() {
		return SHAPE_ID_TYPEBODY;
	}
}
