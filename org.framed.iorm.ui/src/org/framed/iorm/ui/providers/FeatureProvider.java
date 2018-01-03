package org.framed.iorm.ui.providers;

import java.lang.reflect.Modifier;
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
import org.framed.iorm.ui.util.UIUtil;

import core.roletype.RoleTypePattern;

/**
 * This class manages the pattern and features for the editing of the diagram type
 * @author Kevin Kassin
 */
public class FeatureProvider extends DefaultFeatureProviderWithPatterns {

	/**
	 * The class constructor adds all graphiti pattern to the provider following these steps:
	 * <p>
	 * Step 1: It uses {@link UIUtil#findModulePatterns()} to find all java classes in the modules dynamically by searching for them
	 * 		   in the module source folder.<br>
	 * Step 2: It checks all found classes for non abstract<br>
	 * 		   (a) {@link FRaMEDShapePattern} and<br>
	 * 		   (b) {@link FRaMEDConnectionPattern} to add to the provider. 
	 * @param diagramTypeProvider the provider of the edited diagram type
	 */
	public FeatureProvider(IDiagramTypeProvider diagramTypeProvider) {
      super(diagramTypeProvider);
      //Step 1
      List<Class<?>> patterns = UIUtil.findModulePatterns();
      //Step 2
      for(Class<?> patternClass : patterns) {
    	  if(!Modifier.isAbstract(patternClass.getModifiers())) {
	    	  try {
				Object object = patternClass.newInstance();
				//(a)
				if(object instanceof FRaMEDShapePattern) {
					addPattern((FRaMEDShapePattern) object);
				}
				//(b)
				if(object instanceof FRaMEDConnectionPattern) {
					addConnectionPattern((FRaMEDConnectionPattern) object);
				}
	    	  } catch (InstantiationException | IllegalAccessException e) { e.printStackTrace(); }
      }	  }	
      
      //TODO delete after and after
      //Step 1
      addPattern(new CompartmentTypePattern());
      addPattern(new GroupPattern());
      addPattern(new GroupOrCompartmentTypeElementPattern());
      addPattern(new RoleTypePattern()); 
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