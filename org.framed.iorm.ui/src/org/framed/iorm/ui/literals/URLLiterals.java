package org.framed.iorm.ui.literals;

import java.net.URL;

import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

/**
 * This class saves severals static Strings, bundles, paths and URLs used to access files.
 * @author Kevin Kassin
 */
public class URLLiterals {
	
	/**
	 * bundles to acces packages
	 * <p>
	 * the bundle used to get access to the package "org.framed.iorm.featuremodel"
	 */
	private static final Bundle BUNDLE_FEATUREMODEL = Platform.getBundle("org.framed.iorm.featuremodel");
	
	/**
	 * URLs related to the feature model
	 * <p>
	 * can be:<br>
	 * (1) the URL to the used feature model or<br>
	 * (2) the URL to the standard configuration 
	 */
	public static final URL URL_TO_FEATUREMODEL = BUNDLE_FEATUREMODEL.getEntry("model.xml"),
						  	URL_TO_STANDARD_CONFIGURATION = BUNDLE_FEATUREMODEL.getEntry("/standardframedconfiguration/standardFramedConfiguration.diagram");
}	