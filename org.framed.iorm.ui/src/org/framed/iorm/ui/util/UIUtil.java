package org.framed.iorm.ui.util;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IMappingProvider;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.framed.iorm.model.Model;
import org.framed.iorm.ui.exceptions.NoLinkedModelYet;
import org.framed.iorm.ui.exceptions.NoModelFoundException;
import org.framed.iorm.ui.literals.UILiterals;
import org.framed.iorm.ui.providers.ToolBehaviorProvider;
import org.osgi.framework.Bundle;

/**
 * This class offers utility operations in the scope of the UI. Modules can use these operations if they want to,
 * e.g. for UI specific aspects like diagrams, models and the property service.
 * @author Kevin Kassin
 */
public class UIUtil {

	//Model
	//~~~~~
	/**
	 * This operation gets the root {@link Model} for a given {@link Diagram}.
	 * @param diagram The diagram to get the model from
	 * @return the root model of the given diagram if there is exactly one model linked and returns null else
	 */
	public static final Model getLinkedModelForDiagram(Diagram diagram) {
		if(diagram.getLink() != null) {
			if(diagram.getLink().getBusinessObjects().size() == 1 &&
			   diagram.getLink().getBusinessObjects().get(0) instanceof Model) {
				return (Model) diagram.getLink().getBusinessObjects().get(0);
			}
		}
		return null;
	}
	
	/**
	 * helper method to get the {@link ModelElement} for a given anchor
	 * @param anchor the anchor that belongs to the model element to get
	 * @return the model element that has the give anchor
	 */
	public static org.framed.iorm.model.ModelElement getModelElementForAnchor(Anchor anchor) {
		Object object = null;
		if (anchor != null) { object = GeneralUtil.getBusinessObjectForPictogramElement(anchor.getParent()); }
		if (object != null) {
			if (object instanceof org.framed.iorm.model.Shape)
				return (org.framed.iorm.model.Shape) object;
			if (object instanceof org.framed.iorm.model.Relation)
				return (org.framed.iorm.model.Relation) object;
		}
		return null;
	}
	
	/**
	 * fetches the root model of role model which contains the given diagram
	 * <p>
	 * Note: See {@link NoLinkedModelYet} and {@link ToolBehaviorProvider#getListOfFramedFeatureNames} for further
	 * informations.
	 * @param diagram the diagram to search the root model for
	 * @return the root model of a role model
	 */
	public static Model getRootModelForAnyDiagram(Diagram diagram) throws NullPointerException {
		Model rootModel = null;
		Diagram containerDiagram = DiagramUtil.getContainerDiagramForAnyDiagram(diagram);
		for(Shape shape : containerDiagram.getChildren()) {
			if(shape instanceof Diagram &&
			   PropertyUtil.isDiagram_KindValue((Diagram) shape, UILiterals.DIAGRAM_KIND_MAIN_DIAGRAM)) {
				//Note
				if(shape.getLink() == null) throw new NoLinkedModelYet();
				else { 
					if(shape.getLink().getBusinessObjects().size() == 1) {
						rootModel = (Model) shape.getLink().getBusinessObjects().get(0);
		}	}	}	}
		if(rootModel == null) throw new NoModelFoundException();
		else return rootModel;
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
	
	//finding pattern dynamically
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * fetches all java classes in the module source folder
	 * @return all java classes in in the module source folder
	 */
	public static List<Class<?>> findModulePatterns() {
		Bundle bundle = Platform.getBundle("org.framed.iorm.ui");
	    List<URL> patternURLs = Collections.list(bundle.findEntries("/modules", "*.java", true));
	    List<Class<?>> patternClasses = new ArrayList<Class<?>>();
	    for(URL patternURL : patternURLs) {
	    	try {
	    		Class<?> classForPattern = Class.forName(formatURL(patternURL.toString()));
	    		patternClasses.add(classForPattern);
			} catch (ClassNotFoundException e) { e.printStackTrace(); }
	    }
	    return patternClasses;
	}
	
	/**
	 * formats the given string url by cutting and replacing character in specific manner
	 * @param patternURL the string url to format
	 * @return the formatted string url
	 */
	public static String formatURL(String patternURL) {
		int cutStart = patternURL.indexOf("modules/")+"modules/".length(),
			cutEnd = patternURL.indexOf(".java");	
		patternURL = patternURL.substring(cutStart, cutEnd);
		return patternURL.replace("/", ".");
	}
	
	//Properties
	//Shape Identifier
	//~~~~~~~~~~~~~~~~
	/**
	 * the key to identify the property shape id gathered from {@link IdentifierLiterals}
	 */
	public static final String KEY_SHAPE_ID = UILiterals.KEY_SHAPE_ID;
		
	/**
	 * set the property shape id for a given shape
	 * @param shape the shape to set the property for
	 * @param value the new value of the property
	 */
	public static final void setShape_IdValue(Shape shape, String value) {
		Graphiti.getPeService().setPropertyValue(shape, KEY_SHAPE_ID, value);
	}
		
	/**
	 * checks if the property shape id for a given shape equals the given value
	 * @param shape the shape to check the property for
	 * @param value the value to check the property against
	 * @return boolean if the property value equals the given value
	 */
	public static final boolean isShape_IdValue(Shape shape, String value) {
		return (Graphiti.getPeService().getPropertyValue(shape, KEY_SHAPE_ID).equals(value));
	}
	
	//Diagram Kind
	//~~~~~~~~~~~~
	/**
	 * the key to identify the property diagram kind gathered from {@link IdentifierLiterals}
	 * <P>
	 * The word <em>kind</em> is chosen to differ this property from the <em>diagram types</em> of the 
	 * graphiti framework.
	 */
	public static final String KEY_DIAGRAM_KIND = UILiterals.KEY_DIAGRAM_KIND;
	
	/**
	 * set the property diagram kind for a given diagram
	 * <P>
	 * The word <em>kind</em> is chosen to differ this property from the <em>diagram types</em> of the 
	 * graphiti framework.
	 * @param diagram the diagram to set the property for
	 * @param value the new value of the property
	 */
	public static final void setDiagram_KindValue(Diagram diagram, String value) {
		Graphiti.getPeService().setPropertyValue(diagram, KEY_DIAGRAM_KIND, value);
	}
		
	/**
	 * checks if the property diagram kind for a given graphic algorithm equals the given value
	 * <P>
	 * The word <em>kind</em> is chosen to differ this property from the <em>diagram types</em> of the 
	 * graphiti framework.
	 * @param diagram the diagram to check the property for
	 * @param value the value to check the property against
	 * @return boolean if the property value equals the given value
	 */
	public static final boolean isDiagram_KindValue(Diagram diagram, String value) {
		return (Graphiti.getPeService().getPropertyValue(diagram, KEY_DIAGRAM_KIND).equals(value));
	}
}
