package org.framed.iorm.ui.exceptions;

import org.framed.iorm.ui.literals.TextLiterals;

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
	 * the exceptions message gathered from {@link TextLiterals}
	 */
	private static final String ERROR_NO_MODEL_FOUND = TextLiterals.ERROR_NO_MODEL_FOUND;

	/**
	 * Class constructor
	 */
	public NoModelFoundException() {
		super(ERROR_NO_MODEL_FOUND);
	}
}

