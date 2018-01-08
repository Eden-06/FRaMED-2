package customFeatures.references;

//TODO doku
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
