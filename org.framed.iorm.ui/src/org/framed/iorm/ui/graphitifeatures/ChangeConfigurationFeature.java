package org.framed.iorm.ui.graphitifeatures;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.framed.iorm.featuremodel.FRaMEDConfiguration;
import org.framed.iorm.featuremodel.FRaMEDFeature;
import org.framed.iorm.featuremodel.FeatureName;
import org.framed.iorm.featuremodel.FeaturemodelFactory;
import org.framed.iorm.ui.contexts.ChangeConfigurationContext;
import org.framed.iorm.ui.literals.NameLiterals;
import org.framed.iorm.ui.util.DiagramUtil;
import de.ovgu.featureide.fm.core.base.IFeature;
import de.ovgu.featureide.fm.core.configuration.Configuration;
import org.framed.iorm.ui.commands.ConfigurationEditorChangeCommand; //*import for javadoc link 

/**
 * This graphiti custom feature is used to change the role models configuration.
 * <p>
 * It is called by {@link ConfigurationEditorChangeCommand} and uses the {@link ChangeConfigurationContext}.
 * @see ConfigurationEditorChangeCommand
 * @see ChangeConfigurationContext
 * @author Kevin Kassin
 */
public class ChangeConfigurationFeature extends AbstractCustomFeature  {
	
	/**
	 * the name of the feature gathered from {@link NameLiterals}
	 */
	private String CHANGECONFIGURATION_FEATURE_NAME = NameLiterals.CHANGE_CONFIGURATION_FEATURE_NAME; 
	
	/**
	 * Class constructor
	 * @param featureProvider the feature provider the feature belongs to
	 */
	public ChangeConfigurationFeature(IFeatureProvider featureProvider) {
		super(featureProvider);
	}
	 
	/**
	 * get method for the features name
	 * @return the name of the feature
	 */
	@Override
	public String getName() {
		return CHANGECONFIGURATION_FEATURE_NAME;
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
				DiagramUtil.getLinkedModelForDiagram(getDiagram()) != null);
	}
	 
	/**
	 * This method changes the role models configuration using the following steps:
	 * <p>
	 * Step 1: It creates a new empty {@link FRaMEDConfiguration}.<br>
	 * Step 2: For every selected feature in the feature editors configuration add an equivalent
	 *    	   {@link FRaMEDFeature} to the created FRaMEDConfiguration.<br>
	 * Step 3: Set the created FRaMEDConfiguration as configuration of the edited role model.
	 * @throws ConfigurationInconsistentException
	 */
	@Override
	public void execute(ICustomContext context) {
		ChangeConfigurationContext cfmc = (ChangeConfigurationContext) context;
		//Step 1
		FRaMEDConfiguration framedFeatureConfiguration = FeaturemodelFactory.eINSTANCE.createFRaMEDConfiguration();
		Configuration editorFeatureConfiguration = cfmc.getConfiguration();
		for(IFeature editorFeature : editorFeatureConfiguration.getSelectedFeatures()) {
			//Step 2
			FRaMEDFeature framedFeature = FeaturemodelFactory.eINSTANCE.createFRaMEDFeature();
			framedFeature.setName(FeatureName.getByName(editorFeature.getName()));
			if(editorFeatureConfiguration.getManualFeatures().contains(editorFeature))
				framedFeature.setManuallySelected(true);
			framedFeatureConfiguration.getFeatures().add(framedFeature);	
		}
		//Step 3
		Diagram mainDiagram = DiagramUtil.getMainDiagramForAnyDiagram(getDiagram());    
		DiagramUtil.getLinkedModelForDiagram(mainDiagram).setFramedConfiguration(framedFeatureConfiguration);
	}
}
