package customFeatures;

import java.util.List;

/**
 * This interface is meant for graphiti pattern that 
 */
public interface ChangeConfigurationListener {
		
	/**
	 * When the configuration is changed this operation is called on the listener implementing this interface.
	 * @param newframedFeatureNames the newly changed configuration
	 * @param oldframedFeatureNames the configuration before the changes
	 */
	public void configurationChanged(List<String> newframedFeatureNames, List<String> oldframedFeatureNames);
}
