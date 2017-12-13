package org.framed.iorm.ui.exceptions;

import org.framed.iorm.ui.literals.TextLiterals;
import org.framed.iorm.ui.palette.FeaturePaletteDescriptor;
import org.framed.iorm.ui.providers.ToolBehaviorProvider; //*import for javadoc link

/**
 * This exception is thrown when a feature has no {@link FeaturePaletteDescriptor} when the 
 * {@link ToolBehaviorProvider} builds the palette.
 * @author Kevin Kassin
 */
public class FeatureHasNoPaletteDescriptorException extends RuntimeException {

	/**
	 * serial
	 */
	private static final long serialVersionUID = -1153983811660560751L;
	
	/**
	 * the exceptions message gathered from {@link TextLiterals}
	 */
	private static final String FEATURE_HAS_NO_DESCRIPTOR_MESSAGE = TextLiterals.FEATURE_HAS_NO_DESCRIPTOR_MESSAGE;
	
	/**
	 * Class constructor
	 */
	public FeatureHasNoPaletteDescriptorException(String featureName) {
		super(FEATURE_HAS_NO_DESCRIPTOR_MESSAGE + featureName);
	}

}
