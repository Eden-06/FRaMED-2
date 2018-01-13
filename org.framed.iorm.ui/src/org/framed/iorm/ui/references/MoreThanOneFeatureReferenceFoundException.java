package org.framed.iorm.ui.references;

import org.framed.iorm.ui.UILiterals;

/**
 * This exception is thrown when there were more than 1 feature references were found in the module and core
 * folders, while there should be 1 or 0 of it.
 * @author Kevin Kassin
 */
public class MoreThanOneFeatureReferenceFoundException extends RuntimeException {

	/**
	 * serial
	 */
	private static final long serialVersionUID = -2953655160683524806L;
	
	/**
	 * the exceptions message
	 */
	private static final String MORE_THAN_ONE_FEATURE_REFERENCE_FOUND = UILiterals.MORE_THAN_ONE_FEATURE_REFERENCE_FOUND;
	
	/**
	 * Class constructor
	 */
	public MoreThanOneFeatureReferenceFoundException(int amountOfReferences, String reference) {
		super(MORE_THAN_ONE_FEATURE_REFERENCE_FOUND + amountOfReferences + " of " + reference);
	}
}
