package org.framed.iorm.ui.exceptions;

import org.framed.iorm.ui.literals.TextLiterals;

/**
 * This exception is thrown if a there is no linked model for a diagram to be found. This is distinct from the 
 * {@link NoModelFoundException} to catch the case if a model will be linked later, but isn't right now.
 * @author Kevin Kassin
 */
public class NoLinkedModelYet extends RuntimeException {

	/**
	 * serial
	 */
	private static final long serialVersionUID = 2773087627369093055L;
	
	/**
	 * the exceptions message gathered from {@link TextLiterals}
	 */
	private static final String ERROR_NO_LINKED_MODEL_YET = TextLiterals.ERROR_NO_LINKED_MODEL_YET;

	/**
	 * Class constructor
	 */
	public NoLinkedModelYet() {
		super(ERROR_NO_LINKED_MODEL_YET);
	}
}

