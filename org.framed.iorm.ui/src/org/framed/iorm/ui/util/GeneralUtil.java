package org.framed.iorm.ui.util;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.features.IMappingProvider; //*import for javadoc link
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.exceptions.NoFeatureForPatternFound;
import org.framed.iorm.ui.literals.LayoutLiterals;
import org.framed.iorm.ui.multipage.MultipageEditor;

/**
 * This class offers some general utility methods.
 * @author Kevin Kassin
 */
public class GeneralUtil {
	
	/**
	 * the layout integers this class need to perform the operation {@link #calculateHorizontalCenter}
	 * gathered from {@link LayoutLiterals}
	 */
	private static final int HEIGHT_NAME_SHAPE = LayoutLiterals.HEIGHT_NAME_SHAPE,
			 		  	 	 DATATYPE_CORNER_SIZE = LayoutLiterals.DATATYPE_CORNER_SIZE,
			 		  	 	 ROLE_CORNER_RADIUS = LayoutLiterals.ROLE_CORNER_RADIUS;
		
	/**
	 * This operation calculates where the horizontal center of a class or role is.
	 * <p>
	 * Depending on the the type of the class or role and its height the horizontal center position is returned.
	 * @param type the type of the class or role
	 * @param heightOfClassOrRole the height of the class or role
	 * @return the horizontal center position
	 */
	public static final int calculateHorizontalCenter(Type type, int heightOfClassOrRole) {
		if(type == Type.NATURAL_TYPE) 
			return ((heightOfClassOrRole-HEIGHT_NAME_SHAPE)/2)+HEIGHT_NAME_SHAPE;
		if(type == Type.DATA_TYPE)	
			return ((heightOfClassOrRole-HEIGHT_NAME_SHAPE-DATATYPE_CORNER_SIZE)/2)+HEIGHT_NAME_SHAPE;
		if(type == Type.ROLE_TYPE)
			return ((heightOfClassOrRole-HEIGHT_NAME_SHAPE-ROLE_CORNER_RADIUS/2)/2)+HEIGHT_NAME_SHAPE;
		return 0;
	}
	
	/**
	 * This operation calculates where the horizontal first third of a class or role is.
	 * <p>
	 * This is used for compartment types.
	 * @param heightOfCompartmentType the height of the compartment type
	 * @return the horizontal first third of the compartment type
	 */
	public static final int calculateHorizontaltFirstThird(int heightOfCompartmentType) {
		return ((heightOfCompartmentType-HEIGHT_NAME_SHAPE)/3)+HEIGHT_NAME_SHAPE;
	}
	
	/**
	 * This operation calculates where the horizontal first third of a class or role is.
	 * <p>
	 * This is used for compartment types.
	 * @param heightOfCompartmentType the height of the compartment type
	 * @return the horizontal first third of the compartment type
	 */
	public static final int calculateHorizontaltSecondThird(int heightOfCompartmentType) {
		return 2*calculateHorizontaltFirstThird(heightOfCompartmentType)-HEIGHT_NAME_SHAPE;
	}
	
	/**
	 * sets the values of a given {@link AddContext} using a given {@link CreateContext}
	 * <p>
	 * This operation only deals with add and create contexts for graphiti shapes since graphiti connections use
	 * a special type of create contexts.
	 * @param addContext the {@link AddContext} to set the values in
	 * @param createContext the {@link CreateContext} to get the values of
	 * @return the given {@link AddContext} with set values
	 */
	public static AddContext getAddContextForCreateShapeContext(AddContext addContext, ICreateContext createContext) {
		addContext.setHeight(createContext.getHeight());
		addContext.setWidth(createContext.getWidth());
		addContext.setX(createContext.getX());
		addContext.setY(createContext.getY());
		addContext.setLocation(createContext.getX(), createContext.getY());
		addContext.setSize(createContext.getWidth(), createContext.getHeight());
		return addContext;
	}
	
	/**
	 * manages to close a given multipage editor at the next reasonable opportunity using the operation 
	 * {@link Display#asyncExec}
	 * <p>
	 * It also saves the multipage editor before closing it to clean up the dirty state of the whole workbench.
	 * @param multipageEditorToClose
	 */
	public static void closeMultipageEditorWhenPossible(MultipageEditor multipageEditorToClose) {
		Display display = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().getDisplay();
		display.asyncExec(new Runnable() {
			@Override
			public void run() {
				multipageEditorToClose.getDiagramEditor().doSave(new NullProgressMonitor());
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeEditor(multipageEditorToClose, false);
			}
		});
	}
	
	/**
	 * Similar to the contains operation of lists this method offers a comparison using the equal operation
	 * of strings to search for equal string in a list of strings.
	 * @param list the list to search an equal string in
	 * @param stringToCheckAgainst the string to search an equal one for
	 * @return if an equal string is found in a given list
	 */
	public static boolean containsEqual(List<String> list, String stringToCheckAgainst) {
		for(String string : list)
			if(string.equals(stringToCheckAgainst)) return true;
		return false;
	}
		
	/**
	 * returns the first linked business object of a pictogram
	 * <p>
	 * This operation is build after method {@link IMappingProvider#getBusinessObjectForPictogramElement} to avoid
	 * a dependency.<br>
	 * This is a convenience method for getAllBusinessObjectsForPictogramElement(PictogramElement), because in many 
	 * usecases only a single business object is linked.
	 * @param pictogramElement the pictogram element to get business object for
	 * @return the first business object of a pictogram element
	 */
	public static EObject getBusinessObjectForPictogramElement(PictogramElement pictogramElement) {
		return pictogramElement.getLink().getBusinessObjects().get(0);
	}
	
	/**
	 * return a linked business object for a pictogram element if there is exactly one business object linked 
	 * @param pictogramElement the element to get the linked business object for
	 * @return the one linked business object if or null 
	 */
	public static EObject getBusinessObjectIfExactlyOne(PictogramElement pictogramElement) {
		if(pictogramElement.getLink() != null &&
		   pictogramElement.getLink().getBusinessObjects().size() == 1) {
			return getBusinessObjectForPictogramElement(pictogramElement);
		}	
		return null;
	}		
	
	/**
	 * finds a feature by its name in an array of general create features
	 * @param array the array with features to search in
	 * @param featureName the name of the feature to find
	 * @return the found feature or throw exceptions {@link NoFeatureForPatternFound} if it was not found
	 */
	public static IFeature findFeatureByName(IFeature[] array, String featureName) {
		for(int i = 0; i<array.length; i++) {
			if(array[i].getName().equals(featureName)) 
				return array[i];
		}	
		throw new NoFeatureForPatternFound(featureName);
	}	
	
	/**
	 * finds a feature by its name in an array of connection create features
	 * @param array the array with features to search in
	 * @param featureName the name of the feature to find
	 * @return the found feature or throw exceptions {@link NoFeatureForPatternFound} if it was not found
	 */
	public static ICreateConnectionFeature findCreateConnectionFeatureByName(ICreateConnectionFeature[] array, String featureName) {
		for(int i = 0; i<array.length; i++) {
			if(array[i].getCreateName().equals(featureName)) 
				return array[i];
		}	
		throw new NoFeatureForPatternFound(featureName);
	}	
	
	
	/**
	 * gets the {@link IFile} of the CROM for a diagram
	 * @param diagram_resource the resource of the diagram to get the CROM file for
	 * @return the file of the CROM
	 */
	public static IFile getCROMFileForDiagramResource(Resource diagram_resource) {
		URI sourceURI = diagram_resource.getURI();
		sourceURI = sourceURI.trimFileExtension();
		sourceURI = sourceURI.appendFileExtension("crom");
		Path path = new Path(sourceURI.toFileString());
		return ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(path);
	}
}
