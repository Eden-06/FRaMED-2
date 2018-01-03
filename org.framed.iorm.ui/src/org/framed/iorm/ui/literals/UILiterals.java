package org.framed.iorm.ui.literals;

import java.net.URL;

import org.eclipse.core.runtime.Platform;
import org.eclipse.graphiti.util.IColorConstant;
import org.framed.iorm.ui.util.PropertyUtil;
import org.framed.iorm.ui.wizards.RoleModelWizard;
import org.osgi.framework.Bundle;

/**
 * This class saves all literals in the scope of the UI. Modules can use these literals if they want to, e.g. to get layout integers
 * recommended by the UI.
 * @author Kevin Kassin
 */
public class UILiterals {

	//Diagram
	//~~~~~~~
	/**
	 * the kinds of diagrams used in the editor
	 * <p>
	 * can be:<br>
	 * (1) the container diagram of the role model or<br>
	 * (2) the main diagram of the role model or<br>
	 * (3) a diagram used to save the graphical content of a group or<br>
	 * (4) a diagram used to save the graphical content of a compartment type
	 * <p>
	 * If its not clear what <em>main diagram</em> and <em>container diagram</em> means, see 
	 * {@link RoleModelWizard#createEmfFileForDiagram} for reference.<br>
	 * The word <em>kind</em> is chosen to differ this property from the <em>diagram types</em> of the 
	 * graphiti framework.
	 */
	public static final String DIAGRAM_KIND_CONTAINER_DIAGRAM = "container_diagram",
							   DIAGRAM_KIND_MAIN_DIAGRAM = "main_diagram",
							   DIAGRAM_KIND_GROUP_DIAGRAM = "group_diagram",
							   DIAGRAM_KIND_COMPARTMENTTYPE_DIAGRAM = "compartment_diagram";
	
	//Properties
	//~~~~~~~~~~
	/**
	 * key values used to identify properties in {@link PropertyUtil}
	 * <p>
	 * can be:<br>
	 * (1) the key value for the property shape id or<br>
	 * (2) the key value for the property diagram kind
	 * <p>
	 * The word <em>kind</em> is chosen to differ the diagram kind property from the <em>diagram types</em> 
	 * of the graphiti framework.
	 */
	public static final String KEY_SHAPE_ID = "shape id",
							   KEY_DIAGRAM_KIND = "diagram kind";
	
	//URLs
	//~~~~
	/**
	 * bundles to acces packages
	 * <p>
	 * the bundle used to get access to the package "org.framed.iorm.featuremodel"
	 */
	private static final Bundle BUNDLE_FEATUREMODEL = Platform.getBundle("org.framed.iorm.featuremodel");
	
	/**
	 * URLs related to the feature model
	 * <p>
	 * can be:<br>
	 * (1) the URL to the used feature model or<br>
	 * (2) the URL to the standard configuration 
	 */
	public static final URL URL_TO_FEATUREMODEL = BUNDLE_FEATUREMODEL.getEntry("model.xml"),
						  	URL_TO_STANDARD_CONFIGURATION = BUNDLE_FEATUREMODEL.getEntry("/standardframedconfiguration/standardFramedConfiguration.diagram");
	
	//Layout
	//~~~~~~
	/**
	 * general layout integers
	 * <p>
	 * can be:<br>
	 * (1) the puffer space between elements or<br>
	 * (2) the size of the shadows of graphiti shapes
	 */
	public static final int PUFFER_BETWEEN_ELEMENTS = 3,
							SHADOW_SIZE = 3;
	
	/**
	 * layout integers for graphiti shapes 
	 * <p>
	 * can be:<br>
	 * (1) the height of the name rectangle or<br>
	 * (2) the height of the attribute rectangle or<br>
	 * (3) the height of the operation rectangle or<br>
	 * (4) the minimal width for typebody rectangles of classes or roles or<br>
	 * (5) the minimal height for typebody rectangles of classes or roles 
	 */
	public static final int HEIGHT_NAME_SHAPE = 20,
							HEIGHT_ATTRITBUTE_SHAPE = 15,
							HEIGHT_OPERATION_SHAPE = 15,
							MIN_WIDTH_FOR_CLASS_OR_ROLE = 200,
							MIN_HEIGHT_FOR_CLASS_OR_ROLE = 100;
	
	/**
	 * general color values
	 * <p>
	 * can be:<br>
	 * (1) the color of text or<br>
	 * (2) the color of lines or<br>
	 * (3) the color of backgrounds or<br>
	 * (4) the color of graphiti shapes shadows
	 */
	public static final IColorConstant COLOR_TEXT = IColorConstant.BLACK,
			   						   COLOR_LINES = IColorConstant.BLACK,
			   						   COLOR_BACKGROUND = IColorConstant.WHITE,
			   						   COLOR_SHADOW = IColorConstant.GRAY;	
}
