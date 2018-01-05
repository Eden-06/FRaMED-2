package org.framed.iorm.ui.providers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
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
import org.framed.iorm.ui.FRaMEDConnectionPattern;
import org.framed.iorm.ui.FRaMEDShapePattern;
import org.framed.iorm.ui.graphitifeatures.*;
import org.framed.iorm.ui.pattern.shapes.*;
import org.framed.iorm.ui.util.UIUtil;

/**
 * This class manages the pattern and features for the editing of the diagram type
 * @author Kevin Kassin
 */
public class FeatureProvider extends DefaultFeatureProviderWithPatterns {

	/**
	 * The class constructor adds all graphiti pattern to the provider following these steps:
	 * <p>
	 * Step 1: It uses {@link UIUtil#findModuleJavaClasses()} to find all java classes in the modules dynamically by searching for them
	 * 		   in the module source folder.<br>
	 * Step 2: It checks all found classes for non abstract<br>
	 * 		   (a) {@link FRaMEDShapePattern} and<br>
	 * 		   (b) {@link FRaMEDConnectionPattern} to add to the provider. 
	 * @param diagramTypeProvider the provider of the edited diagram type
	 */
	public FeatureProvider(IDiagramTypeProvider diagramTypeProvider) {
      super(diagramTypeProvider);
      //Step 1
      List<Class<?>> classes = UIUtil.findModuleJavaClasses();
      //Step 2
      for(Class<?> cl : classes) {
    	  if(!Modifier.isAbstract(cl.getModifiers())) {
    		  if(UIUtil.getSuperClasses(cl).contains(FRaMEDShapePattern.class) ||
    			 UIUtil.getSuperClasses(cl).contains(FRaMEDConnectionPattern.class)) {
    			  try {
    				  Object object = cl.newInstance();
    				  //(a)
    				  if(object instanceof FRaMEDShapePattern) {
    					  addPattern((FRaMEDShapePattern) object);
    				  }
    				  //(b)
    				  if(object instanceof FRaMEDConnectionPattern) {
    					  addConnectionPattern((FRaMEDConnectionPattern) object);
    				  }
    			  } catch (InstantiationException | IllegalAccessException e) { e.printStackTrace(); }
      }	  }	  }
      
      //TODO delete after and after
      //Step 1
      addPattern(new CompartmentTypePattern());
      addPattern(new GroupPattern());
      addPattern(new GroupOrCompartmentTypeElementPattern());
	}
		
	/**
	 * sets the graphiti custom features that are used by editor for the diagram type
	 * <p>
	 * Step 1: It uses {@link UIUtil#findModuleJavaClasses()} to find all java classes in the modules dynamically by searching for them
	 * 		   in the module source folder.<br>
	 * Step 2: It checks all found classes for non abstract {@link FRaMEDCustomFeature} to add the custom features
	 */
	@Override
	public ICustomFeature[] getCustomFeatures(ICustomContext context) {
		List<ICustomFeature> customfeatures = new ArrayList<ICustomFeature>();
		//Step 1
	    List<Class<?>> classes = UIUtil.findModuleJavaClasses();
	    //Step 2
	    for(Class<?> cl : classes) {
	    	if(!Modifier.isAbstract(cl.getModifiers())) {
	    		if(UIUtil.getSuperClasses(cl).contains(FRaMEDCustomFeature.class)) {	
		    		try {
		    			Class<?>[] args = new Class<?>[1];
		    			args[0] = IFeatureProvider.class;
		    			Object object = cl.getDeclaredConstructor(args).newInstance(this);
		    			customfeatures.add((FRaMEDCustomFeature) object);
		    		} catch (InstantiationException | IllegalAccessException | 
		    				 IllegalArgumentException | InvocationTargetException | 
		    				 NoSuchMethodException | SecurityException e) { e.printStackTrace(); }
	    }	}	}
	    
	    //TODO get rid of after and after
	    customfeatures.add(new ChangeConfigurationFeature(this));
	    customfeatures.add(new StepInFeature(this));
	    customfeatures.add(new StepInNewTabFeature(this));
	    customfeatures.add(new StepOutFeature(this));
	    customfeatures.add(new ResetLayoutForElementFeature(this));
	
	    ICustomFeature[] customFeatureArray = customfeatures.toArray(new ICustomFeature[0]);
		return customFeatureArray;
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