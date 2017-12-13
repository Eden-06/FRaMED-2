package org.framed.iorm.ui.providers;

import java.util.List;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IReconnectionFeature;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.features.impl.DefaultRemoveFeature;
import org.eclipse.graphiti.pattern.DefaultFeatureProviderWithPatterns;
import org.eclipse.graphiti.pattern.IConnectionPattern;
import org.eclipse.graphiti.pattern.IPattern;
import org.framed.iorm.ui.graphitifeatures.*;
import org.framed.iorm.ui.pattern.connections.*;
import org.framed.iorm.ui.pattern.connections.interrelationship.*;
import org.framed.iorm.ui.pattern.connections.intrarelationship.*;
import org.framed.iorm.ui.pattern.connections.roleconstraint.*;
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
      addConnectionPattern(new FulfillmentPattern());
	}
	
	/**
	 * sets the graphiti custom features that are used by editor for the diagram type
	 */
	@Override
	public ICustomFeature[] getCustomFeatures(ICustomContext context) {
	    return new ICustomFeature[] { new ChangeConfigurationFeature(this),
	    							  new EditRelationshipFeature(this),
	    							  new EditFulfillmentFeature(this),
	    						 	  new StepInFeature(this),
	    							  new StepInNewTabFeature(this),
	    						 	  new StepOutFeature(this), 
	    						 	  new ResetLayoutForElementFeature(this) };
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
	 * replaces the default feature that deletes connection decorator and connections with one that disables deleting connection
	 * decorators and changes the deletion of connections 
	 * <p>
	 * See {@link FRaMEDDeleteConnectionFeature} for reference
	 */
	@Override
	public IDeleteFeature getDeleteFeatureAdditional(IDeleteContext Context) {
		return new FRaMEDDeleteConnectionFeature(this);
	}
	
	/**
	 * replaces the default feature to reconnect connections
	 * <p>
	 * See {@link FRaMEDReconnectFeature} for reference
	 */
	@Override
	public IReconnectionFeature getReconnectionFeature(IReconnectionContext context) {
	    return new FRaMEDReconnectFeature(this);
	}
	
	/**
	 * publish the getPatterns() operation of its super type
	 */
	public List<IPattern> getPatterns() {
		return super.getPatterns();
	}
	
	/**
	 * publish the getConnectionPatterns() operation of its super type
	 */
	public List<IConnectionPattern> getConnectionPatterns() {
		return super.getConnectionPatterns();
	}
}