package org.framed.iorm.ui.references;

import org.framed.iorm.ui.UILiterals;

/**
 * This exception is thrown when there were 0 or more than 1 attribute and operation features references were found in the module and core
 * folders.
 * @author Kevin Kassin
 */
public class NotExactlyOneAttributeAndOperationFeatureFoundException extends RuntimeException {

	/**
	 * serial
	 */
	private static final long serialVersionUID = 8548514226358339890L;
	
	/**
	 * the exceptions message
	 */
	private static final String NOT_EXACTLY_ONE_ATT_OP_FEATURE_FOUND = UILiterals.NOT_EXACTLY_ONE_ATT_OP_FEATURE_FOUND;
	
	/**
	 * Class constructor
	 */
	public NotExactlyOneAttributeAndOperationFeatureFoundException(int amountOfReferences) {
		super(NOT_EXACTLY_ONE_ATT_OP_FEATURE_FOUND + amountOfReferences);
	}
}
