package org.framed.iorm.transformation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.dt.ExtensionPointToolNativeTypeDelegate;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.etl.EtlModule;
import org.osgi.framework.Bundle;

/**
 * the class is needed to perform the model transformation from the IORM to the CROM
 * @author Kevin Kassin
 */
public class TransformationExecutor extends EpsilonStandalone {
	/**
	 * the source model file: IORM 
	 */
	private Resource sourceModelFile;

	/**
	 * the target model file: CROM
	 */
	private Resource targetModelFile;

	/**
	 * the first rule used for the transformation
	 */
	private String transformationFile;
	
	/**
	 * the UI and Transformation Bundles
	 */
	private final Bundle UIBundle = Platform.getBundle("org.framed.iorm.ui"),
				   		 TransformationBundle = Platform.getBundle("org.framed.iorm.transformation");

	/**
	 * the list all by this class' object copied and generated files
	 */
	private final List<File> copiedAndGeneratedFiles;
	
	/**
	 * class constructor
	 * <p>
	 * It uses the following steps:<br>
	 * Step 1: It get the url and file to the folder 'epsilon' of this package.<br>
	 * Step 2: It searches for all etl files in the core and module source folder of the UI package.<br>
	 * Step 3: It (a) copies them into the epsilon folder of this package. This is needed to avoid a cycle of 
	 *     	   dependencies between the UI and the Transformation package. It (b) also add the copied file to
	 *     		{@link #copiedAndGeneratedFiles}.<br>
	 * Step 4: It generated a second ORM2CROM.etl file with the needed imports and sets it as {@link #transformationFile}<br>
	 * <p>
	 * Note: The {@link FileAlreadyExistsException} is ignored in this constructor since its ok, when a file can not be
	 * 		 copied with this reason. The files only need to be copied once.
	 */
	public TransformationExecutor() {
		sourceModelFile = null;
		targetModelFile = null;
		copiedAndGeneratedFiles = new ArrayList<File>();
		//Step 1
		URL epsilonFolderURL = TransformationBundle.getEntry("epsilon");
		File epsilonFolder = null;
		try {
			epsilonFolder = new File(FileLocator.resolve(epsilonFolderURL).toURI());
		} catch (URISyntaxException | IOException e1) { e1.printStackTrace(); };
		if(epsilonFolder == null) {
			System.err.println("No folder 'epsilon' found");
			return;
		}
		//Step 2
		List<URL> moduleClassURLs = null, coreClassURLs = null;
		Enumeration<URL> moduleClassEnumeration = UIBundle.findEntries("/modules", "*.etl", true),
						 coreClassEnumeration = UIBundle.findEntries("/core", "*.etl", true);
		if(moduleClassEnumeration != null) 
			moduleClassURLs = Collections.list(moduleClassEnumeration);
		if((coreClassEnumeration != null)) 
			coreClassURLs = Collections.list(coreClassEnumeration);
		//Step 3
		File etlFile = null;
		List<String> importNames = new ArrayList<String>();
		if(moduleClassURLs != null) {
			for(URL url : moduleClassURLs) {
				//(a)
				try {
					etlFile = new File(FileLocator.resolve(url).toURI());
				} catch (URISyntaxException | IOException e) { e.printStackTrace(); }
				try {
					try {
						Path path = Files.copy(Paths.get(etlFile.getPath()), 
								   		  	   Paths.get(epsilonFolder.getPath() + "\\" + etlFile.getName()));
						copiedAndGeneratedFiles.add(new File(path.toString()));
					//Note
					} catch (FileAlreadyExistsException e) {}
				} catch (IOException e) { e.printStackTrace(); }
				//(b)
				importNames.add(etlFile.getName());
			}
		}
		if(coreClassURLs != null) {
			for(URL url : coreClassURLs) {
				//(a)
				try {
					etlFile = new File(FileLocator.resolve(url).toURI());
				} catch (URISyntaxException | IOException e) { e.printStackTrace(); }
				try {
					try {
						Path path = Files.copy(Paths.get(etlFile.getPath()), 
											   Paths.get(epsilonFolder.getPath() + "\\" + etlFile.getName()));
					copiedAndGeneratedFiles.add(new File(path.toString()));
					//Note
					} catch (FileAlreadyExistsException e) {}	
				} catch (IOException e) { e.printStackTrace(); }
				//(b)
				importNames.add(etlFile.getName());
			}
		}
		//Step 4
		String generatedFileName = generateORM2CROMWithImports(importNames, epsilonFolder);
		transformationFile = "epsilon/" + generatedFileName;
	}
	
	/**
	 * generates a second ORM2CROM.etl file with the needed imports of file found in importNames using the following
	 * steps:
	 * <p>
	 * Step 1: It gets the original ORM2CROM file.<br>
	 * Step 2: It reads the text content of the original ORM2CROM file.<br>
	 * Step 3: It adds the needed imports to the text content.<br>
	 * Step 4: It generates a new file with the changed text content and adds the generated file to
	 * 		   {@link #copiedAndGeneratedFiles}.
	 * @param importNames the list of names of needed imports
	 * @param epsilonFolder the folder to create the generated file in
	 * @return the name of the generated file
	 */
	private String generateORM2CROMWithImports(List<String> importNames, File epsilonFolder) {
		String generatedFileName = "generatedORM2CROM.etl";
		String fileText = "";
		//Step 1
		List<URL> ORM2CROMUrls = Collections.list(TransformationBundle.findEntries("/epsilon", "ORM2CROM.etl", true));
		if(ORM2CROMUrls.size() != 1) { 
			System.err.println(ORM2CROMUrls.size() + " elements of ORM2CROM.etl were found: 1 Element is expected.");
			return null;
		} else {
			//Step 2
			try {
				File ORM2CROMUrl = new File(FileLocator.resolve(ORM2CROMUrls.get(0)).toURI());
				BufferedReader buff = new BufferedReader(new FileReader(ORM2CROMUrl.getPath()));
				String str = "";
				while ((str = buff.readLine()) != null) {
					fileText = fileText + str + "\n";
				}
				buff.close();	
			} catch (URISyntaxException | IOException e) { e.printStackTrace(); }
			//Step 3
			for(String s : importNames)	
				fileText = fileText.replace("//import marker", "//import marker\n import \"" + s + "\";\n");
			//Step 4
			try {
				String generatedORM2CROMPath = epsilonFolder.getPath() + "\\" + generatedFileName;
				File generatedORM2CROM = new File(generatedORM2CROMPath);
				generatedORM2CROM.createNewFile();
				copiedAndGeneratedFiles.add(generatedORM2CROM);
				FileOutputStream fileOutputStream = new FileOutputStream(generatedORM2CROM.getPath());
				for (int i=0; i < fileText.length(); i++)
					fileOutputStream.write((byte) fileText.charAt(i));
				fileOutputStream.close();
			} catch (Exception  e) { e.printStackTrace(); }
		}
		return generatedFileName;
	}
	
	/**
	 * deletes files this object copied and generated 
	 */
	public void deleteCopiedAndGeneratedFiles () {
		for(File file : copiedAndGeneratedFiles) {
			if(file.exists()) file.delete();
	}	}
	
	/**
	 * getter method for {@link module}
	 * @return the module that belongs to the {@link #transformationFile}
	 */
	public String getModule() {
		return module.toString();
	}
  
	/**
	 * getter method for {@link sourceModelFile}
	 * @return the IORM model file
	 */
	public Resource getSourceModelFile() {
		return sourceModelFile;
	}

	/**
	 * setter method for {@link sourceModelFile}
	 */
	public void setSourceModelFile(Resource sourceModelFile) {
		this.sourceModelFile = sourceModelFile;
	}

	/**
	 * getter method for {@link targetModelFile}
	 * @return the CROM model file
	 */
	public Resource getTargetModelFile() {
		return targetModelFile;
	}

	/**
	 * setter method for {@link targetModelFile}
	 */
	public void setTargetModelFile(Resource targetModelFile) {
		this.targetModelFile = targetModelFile;
	}

	/**
	 * sets the {@link #transformationFile} as forced transforamtion file
	 * @param transformationFileName the name of the transformation to set
	 */
	public void setForcedTransformation(String transformationFileName) {
		this.transformationFile = "epsilon/" + transformationFileName;
	}

	/**
	 * creates a module with the extension point to the native java classes
	 */
	@Override
	public IEolExecutableModule createModule() {
		EtlModule module = new EtlModule();
		module.getContext().getNativeTypeDelegates().add(new ExtensionPointToolNativeTypeDelegate());
		return module;
	}

	/**
	 * sets the {@link #transformationFile} as source rule of the transformation
	 */
	@Override
	public String getSource() {
		return transformationFile;
	}

	/**
	 * set the models and their properties for transformation
	 */
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
