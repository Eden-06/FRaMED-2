package org.framed.iorm.ui.exceptions;

import org.framed.iorm.ui.literals.TextLiterals;
import org.framed.iorm.ui.multipage.MultipageEditor; //*import for javadoc link

/**
 * This exception is thrown if the {@link MultipageEditor} cant work with editor input when it
 * performs the operation {@link MultipageEditor#addPages} because the editor input is of a not 
 * supported type.
 * @author Kevin Kassin
 */
public class InvalidTypeOfEditorInputException extends RuntimeException {

	/**
	 * serial
	 */
	private static final long serialVersionUID = -4203349335656800650L;
	
	/**
	 * the exceptions message gathered from {@link TextLiterals}
	 */
	private static final String MULTIPAGE_EDITOR_ERROR_NO_VALID_EDITOR_INPUT = TextLiterals.MULTIPAGE_EDITOR_ERROR_NO_VALID_EDITOR_INPUT; 

	/**
	 * Class constructor
	 */
	public InvalidTypeOfEditorInputException() {
		super(MULTIPAGE_EDITOR_ERROR_NO_VALID_EDITOR_INPUT);
	}
}
