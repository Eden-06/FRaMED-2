package org.framed.iorm.transformation;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.dom.Import;
import org.eclipse.epsilon.eol.dom.StringLiteral;
import org.eclipse.epsilon.eol.dt.ExtensionPointToolNativeTypeDelegate;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.etl.EtlModule;
import org.osgi.framework.Bundle;

public class TransformationExecutor extends EpsilonStandalone {

  private Resource sourceModelFile;

  private Resource targetModelFile;

  private String transformationFile;

  public TransformationExecutor() {
    sourceModelFile = null;
    targetModelFile = null;
    transformationFile = "epsilon/ORM2CROM.etl";
    
    //TESTAREA 
    /*
    Bundle bundle = Platform.getBundle("org.framed.iorm.ui");
    List<URL> moduleClassURLs = null, coreClassURLs = null;
    if((bundle.findEntries("/modules", "*.etl", true) != null)) 
    	moduleClassURLs = Collections.list(bundle.findEntries("/modules", "*.etl", true));
    if((bundle.findEntries("/core", "*.etl", true) != null)) 
    	coreClassURLs = Collections.list(bundle.findEntries("/core", "*.etl", true));
    
    //WEITER
    
    
    
    
    
    for(URL url : coreClassURLs) {
    	System.out.println(url);
	    module.getImports().add(getImportForModuleURL(url));
	    
    }
    
    for(Import im : module.getImports()) {
    	System.out.println(im + " " +  im.isLoaded());
    }*/
  }
  
  //TESTAREA
  	private Import getImportForModuleURL(URL moduleUrl) {
	  IEolExecutableModule importModule = createModule();
	  try {
		  importModule.parse(moduleUrl.toURI());
	  } catch (Exception e) { e.printStackTrace(); }
	  Import imp = new Import();
	  imp.setModule(importModule.getModule());
	  imp.setImportedModule(importModule.getModule());
	  imp.setParent(importModule.getParent());
	  imp.setParentModule(importModule.getParentModule());
	  imp.setUri(importModule.getUri());
	  imp.setPathLiteral(new StringLiteral(importModule.getUri().getPath()));
	  return imp;
  }

  public Resource getSourceModelFile() {
    return sourceModelFile;
  }

  public void setSourceModelFile(Resource sourceModelFile) {
    this.sourceModelFile = sourceModelFile;
  }

  public Resource getTargetModelFile() {
    return targetModelFile;
  }

  public void setTargetModelFile(Resource targetModelFile) {
    this.targetModelFile = targetModelFile;
  }

  public void setForcedTransformation(String transformationFileName) {
    this.transformationFile = "epsilon/" + transformationFileName;
  }

  @Override
  public IEolExecutableModule createModule() {
    EtlModule module = new EtlModule();
    module.getContext().getNativeTypeDelegates().add(new ExtensionPointToolNativeTypeDelegate());
    return module;
  }

  @Override
  public String getSource() {
    return transformationFile;
  }

  @Override
  public List<IModel> getModels() throws Exception {
    List<IModel> models = new ArrayList<IModel>();

    EmfModel emfModel = new EmfModel();
    emfModel.setMetamodelUri("http://iorm/1.0");
    emfModel.setModelFileUri(sourceModelFile.getURI());
    emfModel.setReadOnLoad(true);
    emfModel.setStoredOnDisposal(true);
    emfModel.setName("source");
    emfModel.load();
    models.add(emfModel);

    emfModel = new EmfModel();
    emfModel.setReadOnLoad(true);
    emfModel.setModelFileUri(targetModelFile.getURI());
    emfModel.setStoredOnDisposal(true);
    emfModel.setMetamodelUri("platform:/resource/org.rosi.crom.metamodel/");
    emfModel.setName("target");
    emfModel.load();
    models.add(emfModel);

    return models;
  }

}
