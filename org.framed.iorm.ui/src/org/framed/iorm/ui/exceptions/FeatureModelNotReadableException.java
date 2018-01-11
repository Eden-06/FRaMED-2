package org.framed.iorm.ui.exceptions;

import org.framed.iorm.ui.UILiterals;
import org.framed.iorm.ui.subeditors.FRaMEDFeatureEditor; //*import for javadoc link

/**
 * This exception is thrown if the feature model cant be read when the 
 * {@link FRaMEDFeatureEditor} is created.
 * @author Kevin Kassin
 */
public class FeatureModelNotReadableException extends RuntimeException {
	
	/**
	 * serial
	 */
	private static final long serialVersionUID = 8396630214250470131L;
	
	/**
	 * the exceptions message 
	 */
	private static final String FEATUREMODEL_NOT_READABLE_MESSAGE = UILiterals.FEATUREMODEL_NOT_READABLE_MESSAGE;
	
	/**
	 * Class constructor
	 */
	public FeatureModelNotReadableException() {
		super(FEATUREMODEL_NOT_READABLE_MESSAGE);
	}
}
