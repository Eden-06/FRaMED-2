package org.framed.iorm.ui.references;

import org.framed.iorm.ui.UILiterals;

/**
 * This exception is thrown when there were 0 or more than 1 feature references were found in the module and core
 * folders, while there should be exatly one of it.
 * @author Kevin Kassin
 */
public class NotExactlyOneFeatureReferenceFoundException extends RuntimeException {

	/**
	 * serial
	 */
	private static final long serialVersionUID = -2311342750933917518L;
	
	/**
	 * the exceptions message
	 */
	private static final String NOT_EXACTLY_ONE_FEATURE_REFERENCE_FOUND = UILiterals.NOT_EXACTLY_ONE_FEATURE_REFERENCE_FOUND;
	
	/**
	 * Class constructor
	 */
	public NotExactlyOneFeatureReferenceFoundException(int amountOfReferences, String reference) {
		super(NOT_EXACTLY_ONE_FEATURE_REFERENCE_FOUND + amountOfReferences + " of " + reference);
	}
}
