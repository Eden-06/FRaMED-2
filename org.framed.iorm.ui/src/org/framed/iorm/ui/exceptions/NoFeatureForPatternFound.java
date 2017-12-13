package org.framed.iorm.ui.exceptions;

import org.framed.iorm.ui.literals.TextLiterals;
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
	 * the exceptions message gathered from {@link TextLiterals}
	 */
	private static final String NO_FEATURE_FOR_PATTERN_FOUND = TextLiterals.NO_FEATURE_FOR_PATTERN_FOUND;
	
	/**
	 * Class constructor
	 */
	public NoFeatureForPatternFound(String featureName) {
		super(NO_FEATURE_FOR_PATTERN_FOUND + featureName);
	}
}
