package group.references;

import org.framed.iorm.ui.literals.IdentifierLiterals;

/**
 * The class which encapsulated the dependency between the compartment type feature and group feature. This is needed 
 * since compartment type elements in a group need to be handled specific when deleting a group.
 * @author Kevin Kassin
 */
public class CompartmentInnerGroupingReference extends AbstractInnerGroupingReference{

	//TODO delete when possible
	/**
	 * value of the property shape id for a container shape and a type body shape of a compartment type
	 */
	private final String SHAPE_ID_COMPARTMENTTYPE_CONTAINER = IdentifierLiterals.SHAPE_ID_COMPARTMENTTYPE_CONTAINER,
						 A = IdentifierLiterals.SHAPE_ID_COMPARTMENTTYPE_TYPEBODY;
	
	/**
	 * class constructor
	 */
	public CompartmentInnerGroupingReference() {
		SHAPE_ID_CONTAINER = SHAPE_ID_COMPARTMENTTYPE_CONTAINER;
		SHAPE_ID_TYPEBODY = A;
	}
}
