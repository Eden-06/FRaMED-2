package org.framed.iorm.ui.configuration;

import org.eclipse.gef.commands.Command;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.swt.widgets.TreeItem;
import org.framed.iorm.ui.UILiterals;
import org.framed.iorm.ui.subeditors.FRaMEDDiagramEditor;
import org.framed.iorm.ui.subeditors.FRaMEDFeatureEditor;

import customFeatures.ChangeConfigurationFeature;

/**
 * This command is used when configuration of a role model is changed.
 * <p>
 * It is called by {@link FRaMEDFeatureEditor} when an item is clicked to change the configuration. Its 
 * executions uses {@link ChangeConfigurationContext} as context and the graphiti custom feature {@link 
 * ChangeConfigurationFeature} to change the role model. Its undo functions is not used, since this is 
 * handled by the standart undo function of the diagram editors.
 * @see FRaMEDFeatureEditor 
 * @see ChangeConfigurationContext
 * @see ChangeConfigurationFeature
 * @author Kevin Kassin
 */
public class ChangeConfigurationCommand extends Command {
	
	/**
	 * the feature editor that uses the command
	 */
	private FRaMEDFeatureEditor featureEditor;
	
	/**
	 * the diagram editors that used by the command
	 */
	private FRaMEDDiagramEditor behaviorDiagramEditor;
	
	/**
	 * the boolean value of a feature selection
	 */
	private boolean select;
	
	/**
	 * the tree item that presents a feature 
	 */
	private TreeItem item;

	/**
	 * Class constructor
	 */
	public ChangeConfigurationCommand() {
		super.setLabel(UILiterals.CHANGE_CONFIGURATION_COMMAND_NAME);
	}

	/**
	 * This method executes the graphiti custom feature {@link ChangeConfigurationFeature} using the following steps:
	 * <p>
	 * Step 1: It changes the configuration in the feature editor.<br>
	 * Step 2: It uses the diagram editor to get the custom feature {@link ChangeConfigurationFeature}.<br>
	 * Step 3: It creates a {@link ChangeConfigurationContext} and sets the needed informations in it.<br>
	 * Step 4: It executes the {@link ChangeConfigurationFeature} and catches a {@link ConfigurationInconsistentException}
	 */
	@Override
	public void execute() {	 
		//Step 1
		featureEditor.setSelection(item, select);
		//Step 2
		ICustomFeature changeConfigurationFeature = null;
		ICustomFeature[] customFeatures = behaviorDiagramEditor.getDiagramTypeProvider().getFeatureProvider().getCustomFeatures(new ChangeConfigurationContext());
		for(int i = 0; i<customFeatures.length; i++) {
			if(customFeatures[i].getName().equals(UILiterals.CHANGE_CONFIGURATION_FEATURE_NAME)) 
				changeConfigurationFeature = customFeatures[i];
		}
		if(changeConfigurationFeature != null) {
			//Step 3
			ChangeConfigurationContext changeConfigurationContext = new ChangeConfigurationContext();
			changeConfigurationContext.setBehaviorEditor(behaviorDiagramEditor);
			changeConfigurationContext.setConfiguration(featureEditor.getConfiguration());
			if(changeConfigurationFeature.canExecute(changeConfigurationContext)) {
				//Step 4
				changeConfigurationFeature.execute(changeConfigurationContext);
	}	}	}
			
	/**
	 * sets the class variable featureEditor
	 * @param featureEditor the feature editor to set
	 */
	public void setFeatureEditor(FRaMEDFeatureEditor featureEditor) {
		this.featureEditor = featureEditor;
	}
	  
	/**
	 * sets the class variable beahaviorDiagramEditor
	 * @param behaviorDiagramEditor the diagram editor to set
	 */
	public void setBehaviorDiagramEditor(FRaMEDDiagramEditor behaviorDiagramEditor) {
		this.behaviorDiagramEditor = behaviorDiagramEditor;
	}
		
	/**
	 * sets the class variable item
	 * @param item the item to set
	 */
	public void setItem(TreeItem item) {
		this.item = item;
	}
	  
	/**
	 * sets the class variable select
	 * @param select the boolean value to set as select
	 */
	public void setSelect(boolean select) {
		this.select = select;
	}
}	  
