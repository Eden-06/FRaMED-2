package org.framed.iorm.ui.providers;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.DiagnosticListener;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Platform;
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
import org.eclipse.graphiti.func.IAdd;
import org.eclipse.graphiti.pattern.DefaultFeatureProviderWithPatterns;
import org.eclipse.graphiti.pattern.IConnectionPattern;
import org.eclipse.graphiti.pattern.IPattern;
import org.framed.iorm.ui.graphitifeatures.*;
import org.framed.iorm.ui.modules.rolegroup.RoleGroupPattern;
import org.framed.iorm.ui.pattern.connections.*;
import org.framed.iorm.ui.pattern.connections.interrelationship.*;
import org.framed.iorm.ui.pattern.connections.intrarelationship.*;
import org.framed.iorm.ui.pattern.connections.roleconstraint.*;
import org.framed.iorm.ui.pattern.shapes.*;
import org.osgi.framework.Bundle;

/**
 * This class manages the pattern and features for the editing of the diagram type
 * @author Kevin Kassin
 */
public class FeatureProvider extends DefaultFeatureProviderWithPatterns {

	private final Bundle bundle = Platform.getBundle("org.framed.iorm.ui");
	
	private final String classOutputFolder = "C:/Users/Medion/Desktop/eclipse-modeling-oxygen-R-win32-x86_64/eclipse/github/FRaMED-2a/org.framed.iorm.ui//modules/classes";
	
	private static final class ResourceSourceJavaFileObject extends SimpleJavaFileObject {
		Path completePath; 	
		
		protected ResourceSourceJavaFileObject(URI resourceUri, Path path) {
			super(resourceUri, deduceKind(resourceUri));
			this.completePath = path;
		}
		    
		@Override
		public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
			return new String(Files.readAllBytes(completePath));
		}
		    
		private static Kind deduceKind(URI uri) {
		    String path = uri.getPath();
		    for (Kind kind : Kind.values()) {
		    	if (path.endsWith(kind.extension)) {
		    		return kind;
		    }	}
		    return Kind.OTHER;
	}	}   
	
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
      //TODO Step 1
      //List<URL> patterns = findModulePatterns();
      //TODO Step 2
      //compilePatterns(patterns);
      //TODO Steo 3
      //loadClasses();
      
      
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
      //addPattern(new RoleGroupPattern());
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
	
	private List<URL> findModulePatterns() {
	    URL fileURL = bundle.getEntry("modules/test/HW.java");
	    List<URL> patterns = new ArrayList<URL>();
	    patterns.add(fileURL);
	    return patterns;
	}
	
	private void compilePatterns(List<URL> patterns) {
		//Step 1
	    List<ResourceSourceJavaFileObject> filesObjects = new ArrayList<ResourceSourceJavaFileObject>();
	    for(URL patternURL : patterns) {
	    	ResourceSourceJavaFileObject fileObject = null;
			String patternPath = bundle.getLocation().toString() + patternURL.getPath();
			patternPath = patternPath.substring(patternPath.indexOf("/")+1);
			try {
				fileObject = new ResourceSourceJavaFileObject(patternURL.toURI(), Paths.get(patternPath));
			} catch (URISyntaxException e) { e.printStackTrace(); }
			(filesObjects).add(fileObject);
	    }		
		//Step 2      
	    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		DiagnosticCollector<JavaFileObject> collector = new DiagnosticCollector<JavaFileObject>();
		StandardJavaFileManager fileManager = compiler.getStandardFileManager(collector, Locale.GERMAN, null);
	    //TODO eigene Methode
		List<String> options = new ArrayList<String>();
		options.addAll(Arrays.asList("-d", classOutputFolder));   
		options.addAll(Arrays.asList());
		//System.out.println(System.getProperty("java.class.path"));
	    //Step 3
		JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, collector, options, null, filesObjects);
			Boolean result = task.call();
			for(Diagnostic<? extends JavaFileObject> d : collector.getDiagnostics()) {
				System.out.println(d.getMessage(Locale.GERMAN));
			}
			System.out.println(result);
			
			//TODO fehlerbehandlung
		    if (result == true) System.out.println("Succeeded");
	}	      
	
	private void loadClasses() {
		// Create a File object on the root of the directory
		// containing the class file
		File file = new File(classOutputFolder);
		String[] a = file.list();
		for(String s : a) {
			System.out.println(s);
		}
		try {
			URL url = file.toURL(); // file:/classes/demo
			URL[] urls = new URL[] { url };
			
			// Create a new class loader with the directory
			ClassLoader loader = new URLClassLoader(urls);
			
			// Load in the class; Class.childclass should be located in
			// the directory file:/class/demo/
			Class thisClass;
				thisClass = loader.loadClass("HW");
			
			Class params[] = {};
			Object paramsObj[] = {};
			Object instance = thisClass.newInstance();
			Method thisMethod = thisClass.getDeclaredMethod("HW", params);
			
			// run the testAdd() method on the instance:
			System.out.println(thisMethod.invoke(instance, paramsObj));
		} catch(MalformedURLException | ClassNotFoundException | InstantiationException | 
				IllegalAccessException | NoSuchMethodException | SecurityException | 
				IllegalArgumentException | InvocationTargetException e) { e.printStackTrace();}
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