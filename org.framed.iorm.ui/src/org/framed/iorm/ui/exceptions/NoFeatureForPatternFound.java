package org.framed.iorm.ui.exceptions;

import org.framed.iorm.ui.literals.TextLiterals;

//TODO
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
