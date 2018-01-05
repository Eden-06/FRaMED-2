package org.framed.iorm.ui.exceptions;

import org.framed.iorm.ui.literals.UILiterals;
import org.framed.iorm.ui.util.DiagramUtil; //*import for javadoc link

/**
 * 
 * This exception is thrown if a diagram can not be gathered in a operation that is supposed to find one.
 * <p>
 * This exceptions heavily used for methods in {@link DiagramUtil}.
 * @author Kevin Kassin
 */
public class NoDiagramFoundException extends RuntimeException {

	/**
	 * serial
	 */
	private static final long serialVersionUID = -8634710412326399635L;
	
	/**
	 * the exceptions message
	 */
	private static final String ERROR_NO_DIAGRAM_FOUND = UILiterals.ERROR_NO_DIAGRAM_FOUND;

	/**
	 * Class constructor
	 */
	public NoDiagramFoundException() {
		super(ERROR_NO_DIAGRAM_FOUND);
	}
}
