package org.framed.iorm.ui.exceptions;

import org.framed.iorm.ui.literals.TextLiterals;

/**
 * This exception is thrown if the transformation triggered at saving a diagram failed.
 * @author Kevin Kassin
 */
public class TransformationFailedException extends RuntimeException {
	
	/**
	 * serial
	 */
	private static final long serialVersionUID = -3971492273757365431L;
	
	/**
	 * the exceptions message gathered from {@link TextLiterals}
	 */
	private static final String ERROR_TRANSFORMATION_FAILED = TextLiterals.ERROR_TRANSFORMATION_FAILED;

	/**
	 * Class constructor
	 */
	public TransformationFailedException() {
		super(ERROR_TRANSFORMATION_FAILED);
	}
}
