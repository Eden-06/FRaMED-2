package customFeatures;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.pattern.IPattern;
import org.framed.iorm.featuremodel.FRaMEDConfiguration;
import org.framed.iorm.featuremodel.FRaMEDFeature;
import org.framed.iorm.featuremodel.FeatureName;
import org.framed.iorm.featuremodel.FeaturemodelFactory;
import org.framed.iorm.model.Model;
import org.framed.iorm.ui.FRaMEDCustomFeature;
import org.framed.iorm.ui.UIUtil;

import de.ovgu.featureide.fm.core.base.IFeature;
import de.ovgu.featureide.fm.core.configuration.Configuration;

import org.framed.iorm.ui.palette.FeaturePaletteDescriptor; //*import for javadoc link
import org.framed.iorm.ui.providers.FeatureProvider;
import org.framed.iorm.ui.configuration.ChangeConfigurationContext; //*import for javadoc link
import org.framed.iorm.ui.configuration.ChangeConfigurationCommand; //*import for javadoc link


/**
 * This graphiti custom feature is used to change the role models configuration.
 * <p>
 * It is called by {@link ChangeConfigurationCommand} and uses the {@link ChangeConfigurationContext}.
 * @see ChangeConfigurationCommand
 * @see ChangeConfigurationContext
 * @author Kevin Kassin
 */
public class ChangeConfigurationFeature extends FRaMEDCustomFeature  {
	
	/**
	 * the object to get names, ids and so on for this feature
	 */
	Literals literals = new Literals();
	
	/**
	 * the register for the multipage editors to synchronize
	 */
	private List<ChangeConfigurationListener> registeredListeners = new ArrayList<ChangeConfigurationListener>();
	
	/**
	 * Class constructor
	 * <p>
	 * It adds any pattern of its feature provider which is also a {@link ChangeConfigurationListener} to its list of
	 * listeners.
	 * @param featureProvider the feature provider the feature belongs to
	 */
	public ChangeConfigurationFeature(IFeatureProvider featureProvider) {
		super(featureProvider);
		FEATURE_NAME = literals.CHANGE_CONFIGURATION_FEATURE_NAME;
		if(featureProvider instanceof FeatureProvider) {
			FeatureProvider framedFeatureProvider = (FeatureProvider) featureProvider;
			for(IPattern ipattern : framedFeatureProvider.getPatterns()) {
				if(ipattern instanceof ChangeConfigurationListener) {
					registerListener((ChangeConfigurationListener) ipattern);
				}
			}
		}
	}
	
	/**
	 * operation to add a pattern to the list of listeners
	 * @param multipageEditor the multipage editor to add
	 */
	private void registerListener(ChangeConfigurationListener listener) {
		registeredListeners.add(listener);
	}
	
	/**
	 * notify listeners about changes in the configuration by giving the the old and new configuration in the form of a string list
	 * @param framedFeatureConfiguration the newly changed configuration
	 * @param oldFramedConfiguration the configuration before the changes
	 */
	private void notifyListeners(FRaMEDConfiguration framedFeatureConfiguration, FRaMEDConfiguration oldFramedConfiguration) {
		List<String> newFramedFeatureNames = new ArrayList<String>();
		for(FRaMEDFeature framedFeature : framedFeatureConfiguration.getFeatures()) {
			newFramedFeatureNames.add(framedFeature.getName().getLiteral());
		}
		List<String> oldFramedFeatureNames = new ArrayList<String>();
		for(FRaMEDFeature framedFeature : oldFramedConfiguration.getFeatures()) {
			oldFramedFeatureNames.add(framedFeature.getName().getLiteral());
		}
		for(ChangeConfigurationListener listener : registeredListeners) {
			listener.configurationChanged(newFramedFeatureNames, oldFramedFeatureNames);
		}
	}
	
	/**
	 * this operation encapsulates when the custom feature should be visible in the context menu
	 * @return false, since the feature is never visible in the context menu
	 */
	public boolean contextMenuExpression(PictogramElement pictogramElement, EObject businessObject) {
		return false;
	}
	
	/**
	 * This methods checks if the feature can be executed.
	 * <p>
	 * return true if<p>
	 * (1) all needed context informations are set and<br>
	 * (2) the root model of the diagram to work is not null
	 * @return if the feature can be executed
	 */
	@Override
	public boolean canExecute(ICustomContext context) {
		ChangeConfigurationContext cfmc = (ChangeConfigurationContext) context;		
		return (cfmc.getBehaviorEditor() != null &&
				cfmc.getConfiguration() != null &&
				UIUtil.getLinkedModelForDiagram(getDiagram()) != null);
	}
	 
	/**
	 * This method changes the role models configuration using the following steps:
	 * <p>
	 * Step 1: It saves the configuration before the changes done.<br>
	 * Step 2: It executes the changes.<br>
	 * Step 3: It creates a new empty {@link FRaMEDConfiguration}.<br>
	 * Step 4: For every selected feature in the feature editors configuration add an equivalent
	 *    	   {@link FRaMEDFeature} to the created FRaMEDConfiguration.<br>
	 * Step 5: Set the created FRaMEDConfiguration as configuration of the edited role model.
	 * Step 6: Refresh the palette to change the shown palette entries according to their feature expressions. 
	 * 	       See {@link FeaturePaletteDescriptor} for further informations.<br>
	 * Step 7: It notifies its listeners about the changes in the configuration.
	 * @throws ConfigurationInconsistentException
	 */
	@Override
	public void execute(ICustomContext context) {
		//Step 1
		Diagram mainDiagram = UIUtil.getMainDiagramForAnyDiagram(getDiagram());    
		Model mainModel = UIUtil.getLinkedModelForDiagram(mainDiagram);
		FRaMEDConfiguration oldFramedConfiguration = mainModel.getFramedConfiguration();
		//Step 2
		ChangeConfigurationContext cfmc = (ChangeConfigurationContext) context;
		//Step 3
		FRaMEDConfiguration framedFeatureConfiguration = FeaturemodelFactory.eINSTANCE.createFRaMEDConfiguration();
		Configuration editorFeatureConfiguration = cfmc.getConfiguration();
		for(IFeature editorFeature : editorFeatureConfiguration.getSelectedFeatures()) {
			//Step 4
			FRaMEDFeature framedFeature = FeaturemodelFactory.eINSTANCE.createFRaMEDFeature();
			framedFeature.setName(FeatureName.getByName(editorFeature.getName()));
			framedFeatureConfiguration.getFeatures().add(framedFeature);	
		}
		//Step 5
		mainModel.setFramedConfiguration(framedFeatureConfiguration);
		//Step 6 
		getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().refreshPalette();
		//Step 7
		notifyListeners(framedFeatureConfiguration, oldFramedConfiguration);
	}
}
