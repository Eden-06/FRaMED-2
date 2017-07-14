package org.framed.iorm.ui.util;

import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.graphiti.ui.editor.DiagramEditorInput;
import org.eclipse.graphiti.ui.editor.IDiagramEditorInput;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.part.FileEditorInput;
import org.framed.iorm.ui.exceptions.InvalidTypeOfEditorInputException;

/**
 * This class offers utility methods for working with editor inputs.
 * @author Kevin Kassin
 */
public class EditorInputUtil {

	/**
	 * generates an {@link IFileEditorInput} for a given resource
	 * @param resource the resource to create the editor input for
	 * @return the generated editor input
	 */
	public static IFileEditorInput getIFileEditorInputForResource(Resource resource) {
		IPath path = new Path(resource.getURI().toFileString());
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(path);
		return new FileEditorInput(file);
	}

	/**
	 * fetches the {@link Resource} for a given {@link IEditorInput}
	 * @param editorInput the editor input to get the resource for
	 * @return the resource if edtior input is of type {@link IFileEditorInput} and the resource and be loaded 
	 * and returns null else
	 */
	public static Resource getResourceFromEditorInput(IEditorInput editorInput) {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = null;
	 	if (editorInput instanceof IFileEditorInput) {
	    	IFileEditorInput fileInput = (IFileEditorInput) editorInput;
	    	IFile file = fileInput.getFile();
	    	resource = resourceSet.createResource(URI.createURI(file.getLocationURI().toString()));
	 	} 
	 	if(editorInput instanceof IDiagramEditorInput) {
	 		IDiagramEditorInput diagramInput = (IDiagramEditorInput) editorInput;
	 		resource = resourceSet.createResource(diagramInput.getUri());
	 	}	
	 	if(resource != null) {
	    	try {
	    		resource.load(null);
	    		return resource;
	    	} catch (IOException e) { e.printStackTrace(); }
	    }
	 	return null;
	}

	/**
	 * This operation creates an {@link IFile} of an file in the role model project for a given {@link IEditorInput} using two steps:
	 * <p>
	 * Step 1: It gets the project the editor input is located in.<br>
	 * Step 2: The method searches for the file in the project the editor input is located in. With the found file
	 * 		   it creates an IFile.
	 * @param editorInput the editor input to get the IFile for
	 * @return the created IFile
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static final IFile getIFileForFile(IEditorInput editorInput, IPath PathToFile) throws IOException, URISyntaxException {
		//Step 1
		IFileEditorInput fileInput = (IFileEditorInput) editorInput;
		IFile file = fileInput.getFile();
		String projectNameOfDiagram = file.getParent().getParent().getName();
		//Step 2		
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot(); 
		IPath pathToEmptyTectFile = new Path(projectNameOfDiagram + PathToFile);
		return root.getFile(pathToEmptyTectFile);		
	}
	
	//TODO
	public static final IFile getIFileForEditorInput(IEditorInput editorInput) {
		Resource resource = EditorInputUtil.getResourceFromEditorInput(editorInput);
		IPath path = new Path(resource.getURI().toFileString());
		return ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(path);
	}

}
