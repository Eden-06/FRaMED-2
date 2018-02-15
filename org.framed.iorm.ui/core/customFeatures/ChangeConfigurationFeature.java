package customFeatures;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.framed.iorm.featuremodel.FRaMEDConfiguration;
import org.framed.iorm.featuremodel.FRaMEDFeature;
import org.framed.iorm.featuremodel.FeatureName;
import org.framed.iorm.featuremodel.FeaturemodelFactory;
import org.framed.iorm.ui.FRaMEDCustomFeature;
import org.framed.iorm.ui.UIUtil;

import de.ovgu.featureide.fm.core.base.IFeature;
import de.ovgu.featureide.fm.core.configuration.Configuration;

import org.framed.iorm.ui.palette.FeaturePaletteDescriptor; //*import for javadoc link
import org.framed.iorm.ui.configuration.ChangeConfigurationContext; //*import for javadoc link
import org.framed.iorm.ui.editPolicy.EditPolicyService;
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
	 * Class constructor
	 * @param featureProvider the feature provider the feature belongs to
	 */
	public ChangeConfigurationFeature(IFeatureProvider featureProvider) {
		super(featureProvider);
		FEATURE_NAME = literals.CHANGE_CONFIGURATION_FEATURE_NAME;
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
	 * Step 1: It creates a new empty {@link FRaMEDConfiguration}.<br>
	 * Step 2: For every selected feature in the feature editors configuration add an equivalent
	 *    	   {@link FRaMEDFeature} to the created FRaMEDConfiguration.<br>
	 * Step 3: Set the created FRaMEDConfiguration as configuration of the edited role model.
	 * Step 4: Refresh the palette to change the shown palette entries according to their feature expressions. 
	 * 	       See {@link FeaturePaletteDescriptor} for further informations.
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
			framedFeatureConfiguration.getFeatures().add(framedFeature);	
		}
		//Step 3
		Diagram mainDiagram = UIUtil.getMainDiagramForAnyDiagram(getDiagram());    
		UIUtil.getLinkedModelForDiagram(mainDiagram).setFramedConfiguration(framedFeatureConfiguration);
		EditPolicyService.setConfiguration(mainDiagram, framedFeatureConfiguration);
		//Step 4 
		this.getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().refreshPalette();
	}
}
