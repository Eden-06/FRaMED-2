package org.framed.iorm.ui.exceptions;

import org.framed.iorm.ui.UILiterals;

/**
 * This exception is thrown when there were 0 or more than 1 model feature references were found in the module and core
 * folders.
 * @author Kevin Kassin
 */
public class NotExactlyOneModelFeatureFoundException extends RuntimeException {

	/**
	 * serial
	 */
	private static final long serialVersionUID = -2311342750933917518L;
	
	/**
	 * the exceptions message
	 */
	private static final String NOT_EXACTLY_ONE_MODEL_FEATURE_FOUND = UILiterals.NOT_EXACTLY_ONE_MODEL_FEATURE_FOUND;
	
	/**
	 * Class constructor
	 */
	public NotExactlyOneModelFeatureFoundException(int amountOfReferences) {
		super(NOT_EXACTLY_ONE_MODEL_FEATURE_FOUND + amountOfReferences);
	}
}
