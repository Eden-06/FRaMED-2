package org.framed.iorm.ui.exceptions;

import org.framed.iorm.ui.literals.UILiterals;
import org.framed.iorm.ui.providers.ToolBehaviorProvider; //*import for javadoc link

/**
 * This exception is thrown when no feature if found for a pattern when 
 * {@link ToolBehaviorProvider} builds the palette.
 * @author Kevin Kassin
 */
public class NoFeatureForPatternFound extends RuntimeException {

	/**
	 * serial
	 */
	private static final long serialVersionUID = 3388372441551168352L;

	/**
	 * the exceptions message
	 */
	private static final String NO_FEATURE_FOR_PATTERN_FOUND = UILiterals.NO_FEATURE_FOR_PATTERN_FOUND;
	
	/**
	 * Class constructor
	 */
	public NoFeatureForPatternFound(String featureName) {
		super(NO_FEATURE_FOR_PATTERN_FOUND + featureName);
	}
}
