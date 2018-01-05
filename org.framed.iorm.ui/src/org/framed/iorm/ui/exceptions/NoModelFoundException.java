package org.framed.iorm.ui.exceptions;

import org.framed.iorm.ui.literals.UILiterals;

/**
 * This exception is thrown if a model can not be gathered in a operation that is supposed to find one.
 * @author Kevin Kassin
 */
public class NoModelFoundException extends RuntimeException {

	/**
	 * serial
	 */
	private static final long serialVersionUID = 2773087627369093055L;
	
	/**
	 * the exceptions message 
	 */
	private static final String ERROR_NO_MODEL_FOUND = UILiterals.ERROR_NO_MODEL_FOUND;

	/**
	 * Class constructor
	 */
	public NoModelFoundException() {
		super(ERROR_NO_MODEL_FOUND);
	}
}

