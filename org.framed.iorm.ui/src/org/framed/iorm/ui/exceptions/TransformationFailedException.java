package org.framed.iorm.ui.exceptions;

import org.framed.iorm.ui.literals.UILiterals;

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
	 * the exceptions message 
	 */
	private static final String ERROR_TRANSFORMATION_FAILED = UILiterals.ERROR_TRANSFORMATION_FAILED;

	/**
	 * Class constructor
	 */
	public TransformationFailedException() {
		super(ERROR_TRANSFORMATION_FAILED);
	}
}
