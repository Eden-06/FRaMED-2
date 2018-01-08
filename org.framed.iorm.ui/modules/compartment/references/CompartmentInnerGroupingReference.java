package compartment.references;

import compartment.Literals;

/**
 * This is needed since inner compartment type elements in a compartment type need to be handled specific when deleting a compartment type. 
 * Such references are loaded dynamicly by the CompartmentPattern. Thats why a reference for the compartment itself is needed.
 * @author Kevin Kassin
 */
public class CompartmentInnerGroupingReference extends AbstractInnerGroupingReference{

	/**
	 * the object to get names, ids and so on for the compartment type feature
	 */
	private final Literals literals = new Literals();
	
	/**
	 * class constructor
	 */
	public CompartmentInnerGroupingReference() {
		SHAPE_ID_CONTAINER = literals.SHAPE_ID_COMPARTMENTTYPE_CONTAINER;
		SHAPE_ID_TYPEBODY = literals.SHAPE_ID_COMPARTMENTTYPE_TYPEBODY;
	}
}
