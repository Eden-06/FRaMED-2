package customFeatures.references;

/**
 * This exception is thrown no fitting {@link AbstractStepInAndOutReference} is found in the utility class of this module.
 * @author Kevin Kassin
 */
public class StepInAndOutReferenceNotFoundException extends RuntimeException {

	/**
	 * serial
	 */
	private static final long serialVersionUID = -8519772785429897811L;
	
	/**
	 * Class constructor
	 */
	public StepInAndOutReferenceNotFoundException() {
		super("There was no fitting AbstractStepInAndOutReference found.");
	}

}
