package org.framed.iorm.ui.providers;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IMoveConnectionDecoratorFeature;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IMoveConnectionDecoratorContext;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.features.impl.DefaultRemoveFeature;
import org.eclipse.graphiti.pattern.DefaultFeatureProviderWithPatterns;
import org.framed.iorm.ui.graphitifeatures.ChangeConfigurationFeature;
import org.framed.iorm.ui.graphitifeatures.EditRelationshipFeature;
import org.framed.iorm.ui.graphitifeatures.FRaMEDDeleteConnectionFeature;
import org.framed.iorm.ui.graphitifeatures.FRaMEDMoveConnectionDecoratorFeature;
import org.framed.iorm.ui.graphitifeatures.StepInFeature;
import org.framed.iorm.ui.graphitifeatures.StepInNewTabFeature;
import org.framed.iorm.ui.graphitifeatures.StepOutFeature;
import org.framed.iorm.ui.pattern.connections.*;
import org.framed.iorm.ui.pattern.connections.interrelationship.RelationshipExclusionConstraintPattern;
import org.framed.iorm.ui.pattern.connections.interrelationship.RelationshipImplicationConstraintPattern;
import org.framed.iorm.ui.pattern.connections.intrarelationship.AbstractIntraRelationshipConstraintPattern;
import org.framed.iorm.ui.pattern.connections.intrarelationship.AcyclicConstraintPattern;
import org.framed.iorm.ui.pattern.connections.intrarelationship.CyclicConstraintPattern;
import org.framed.iorm.ui.pattern.connections.intrarelationship.IrreflexiveConstraintPattern;
import org.framed.iorm.ui.pattern.connections.intrarelationship.ReflexiveConstraintPattern;
import org.framed.iorm.ui.pattern.connections.intrarelationship.TotalConstraintPattern;
import org.framed.iorm.ui.pattern.connections.roleconstraint.RoleEquivalencePattern;
import org.framed.iorm.ui.pattern.connections.roleconstraint.RoleImplicationPattern;
import org.framed.iorm.ui.pattern.connections.roleconstraint.RoleProhibitionPattern;
import org.framed.iorm.ui.pattern.shapes.*;

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
	 * <p>
	 * For the reason the intra relationship constraints are implemented as shape pattern see 
	 * {@link AbstractIntraRelationshipConstraintPattern}.
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
      addPattern(new RoleTypePattern()); 
      addPattern(new AttributeOperationCommonPattern());
      addPattern(new AttributePattern());
      addPattern(new OperationPattern());
      
      //Step 2
      addConnectionPattern(new RelationshipPattern());
      addConnectionPattern(new InheritancePattern());
      addConnectionPattern(new RoleImplicationPattern());
      addConnectionPattern(new RoleEquivalencePattern());
      addConnectionPattern(new RoleProhibitionPattern());
      addPattern(new AcyclicConstraintPattern());
      addPattern(new CyclicConstraintPattern());
      addPattern(new IrreflexiveConstraintPattern());
      addPattern(new ReflexiveConstraintPattern());
      addPattern(new TotalConstraintPattern());
      addConnectionPattern(new RelationshipImplicationConstraintPattern());
      addConnectionPattern(new RelationshipExclusionConstraintPattern());
	}
	
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
	    							  new EditRelationshipFeature(this),
	    						 	  new StepInFeature(this),
	    							  new StepInNewTabFeature(this),
	    						 	  new StepOutFeature(this)};
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
	 * replaces the default feature that moves connection decorators with one that differs between different types
	 * of decorators and disables moving some of these
	 */
	@Override
	public IMoveConnectionDecoratorFeature getMoveConnectionDecoratorFeature(IMoveConnectionDecoratorContext context) {
		return new FRaMEDMoveConnectionDecoratorFeature(this);
	}
	
	/**
	 * replaces the default feature that deletes connection decorator and connections with one that disables deleting connection
	 * decorators and changes the deletion of connections 
	 */
	@Override
	public IDeleteFeature getDeleteFeatureAdditional(IDeleteContext Context) {
		return new FRaMEDDeleteConnectionFeature(this);
	}
}