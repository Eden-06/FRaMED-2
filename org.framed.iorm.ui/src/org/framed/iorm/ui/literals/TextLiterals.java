package org.framed.iorm.ui.literals;

/**
 * This class saves severals static Strings used as messages for the user.
 * @author Kevin Kassin
 */
public class TextLiterals {

	/**
	 * messages used as direct editing tips
	 */
	public static final String DIRECTEDITING_GROUP = "A groups name cant be empty and cant contains spaces. Numbers are allowed but not as first symbol.",
							   NAME_ALREADY_USED_GROUP = "Another group already has the same name!",
							   DIRECTEDITING_COMPARTMENTTYPE = "A compartment types name cant be empty and cant contains spaces. Numbers are allowed but not as first symbol.",
							   NAME_ALREADY_USED_COMPARTMENTTYPE = "Another compartment type already has the same name!";
							   		
	/**
	 * reason messages used in the <em>updateNeeded</em> operations of the shape pattern
	 * <p>
	 * see {@link NaturalTypePattern#updateNeeded} for example
	 */
	public static final String REASON_NAME_NULL = "Name is null.",
							   REASON_NAME_OUT_OF_DATE = "Name is out of date.",
							   REASON_AMOUNT_ATTRIBUTES = "Different amount of attributes.",
							   REASON_AMOUNT_OPERATION = "Different amount of operations.",
							   REASON_NAMES_ATTRIBUTES = "Different names of attributes.",
							   REASON_NAMES_OPERATIONS = "Different names of operations.",
							   REASON_AMOUNT_ELEMENTS = "Different amount of elements.",
							   REASON_NAMES_ELEMENTS = "Different names of elements.";			  
}
