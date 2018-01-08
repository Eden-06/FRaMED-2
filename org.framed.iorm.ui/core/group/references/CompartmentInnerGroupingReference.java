package group.references;

/**
 * The class which encapsulated the dependency between the compartment type feature and group feature. This is needed 
 * since compartment type elements in a group need to be handled specific when deleting a group.
 * @author Kevin Kassin
 */
public class CompartmentInnerGroupingReference extends AbstractInnerGroupingReference{

	/**
	 * literals class of the compartment type feature
	 */
	compartment.Literals literals = new compartment.Literals();
	
	/**
	 * class constructor
	 */
	public CompartmentInnerGroupingReference() {
		SHAPE_ID_CONTAINER = literals.SHAPE_ID_COMPARTMENTTYPE_CONTAINER;
		SHAPE_ID_TYPEBODY = literals.SHAPE_ID_COMPARTMENTTYPE_TYPEBODY;
	}
}
