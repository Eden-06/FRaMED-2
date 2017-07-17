package org.framed.iorm.ui.providers;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.features.impl.DefaultRemoveFeature;
import org.eclipse.graphiti.pattern.DefaultFeatureProviderWithPatterns;
import org.framed.iorm.ui.graphitifeatures.ChangeConfigurationFeature;
import org.framed.iorm.ui.graphitifeatures.StepInFeature;
import org.framed.iorm.ui.graphitifeatures.StepInNewTabFeature;
import org.framed.iorm.ui.graphitifeatures.StepOutFeature;
import org.framed.iorm.ui.pattern.connections.InheritancePattern;
import org.framed.iorm.ui.pattern.shapes.AttributeOperationCommonPattern;
import org.framed.iorm.ui.pattern.shapes.AttributePattern;
import org.framed.iorm.ui.pattern.shapes.CompartmentTypePattern;
import org.framed.iorm.ui.pattern.shapes.DataTypePattern;
import org.framed.iorm.ui.pattern.shapes.GroupOrCompartmentTypeElementPattern;
import org.framed.iorm.ui.pattern.shapes.GroupPattern;
import org.framed.iorm.ui.pattern.shapes.ModelPattern;
import org.framed.iorm.ui.pattern.shapes.NaturalTypePattern;
import org.framed.iorm.ui.pattern.shapes.OperationPattern;
import org.framed.iorm.ui.pattern.shapes.RoleTypePattern;

/**
 * This class manages the pattern and features for the editing of the diagram type
 * @author Kevin Kassin
 */
public class FeatureProvider extends DefaultFeatureProviderWithPatterns {
	
	/**
	 * Class constructor
	 * <p>
	 * It sets the pattern that are used to created, edit and delete shape (Step 1) and 
	 * connections (Step 2) in the editor for the diagram type.
	 * @param diagramTypeProvider the provider of the edited diagram type
	 */
	public FeatureProvider(IDiagramTypeProvider diagramTypeProvider) {
      super(diagramTypeProvider);
      //Step 1
      addPattern(new ModelPattern());
      addPattern(new CompartmentTypePattern());
      addPattern(new NaturalTypePattern());
      addPattern(new DataTypePattern());
      addPattern(new GroupPattern());
      addPattern(new GroupOrCompartmentTypeElementPattern());
      addPattern(new AttributeOperationCommonPattern());
      addPattern(new AttributePattern());
      addPattern(new OperationPattern());
      addPattern(new RoleTypePattern()); 
      //Step 2
      addConnectionPattern(new InheritancePattern());
	}	
	
	/**
	 * disables the remove feature
	 * <p>
	 * This is done since the remove feature only removes the pictogram elements of a diagram content but not its
	 * business object. This behavior is not wanted.
	 */
	@Override
	public IRemoveFeature getRemoveFeature(IRemoveContext context) {
		return new DefaultRemoveFeature(this) {
			@Override
			public boolean isAvailable(IContext context) {
				return false;
	}	};	}
	
	/**
	 * sets the graphiti custom features that are used by editor for the diagram type
	 * <p>
	 * It makes the following features available:<br>
	 * (1) the feature to change the configuration of the diagram 
	 * (2) the feature to step in a group or compartment type 
	 * (3) the feature to step in a group or compartment type in a new tab
	 * (4) the feature to step out of a group or compartment type
	 */
	@Override
	public ICustomFeature[] getCustomFeatures(ICustomContext context) {
	    return new ICustomFeature[] { new ChangeConfigurationFeature(this),
	    						 	  new StepInFeature(this),
	    							  new StepInNewTabFeature(this),
	    						 	  new StepOutFeature(this)};
	} 
}