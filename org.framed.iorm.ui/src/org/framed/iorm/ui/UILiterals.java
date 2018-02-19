package org.framed.iorm.ui;

import java.net.URL;

import org.eclipse.core.runtime.Platform;
import org.eclipse.graphiti.util.IColorConstant;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PartInitException;
import org.framed.iorm.ui.exceptions.*;
import org.framed.iorm.ui.multipage.MultipageEditor;
import org.framed.iorm.ui.providers.DiagramTypeProvider;
import org.framed.iorm.ui.wizards.RoleModelWizard;
import org.framed.iorm.ui.wizards.RoleModelWizardPage;
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
	 * the file extension of the diagram type used in this editor 
	 */
	public static final String FILE_EXTENSION_FOR_DIAGRAMS = ".crom_diagram";
	
	/**
	 * the kinds of diagrams used in the editor
	 * <p>
	 * can be:<br>
	 * (1) the container diagram of the role model or<br>
	 * (2) the main diagram of the role model.
	 * <p>
	 * If its not clear what <em>main diagram</em> and <em>container diagram</em> means, see 
	 * {@link RoleModelWizard#createEmfFileForDiagram} for reference.<br>
	 * The word <em>kind</em> is chosen to differ this property from the <em>diagram types</em> of the 
	 * graphiti framework.
	 */
	public static final String DIAGRAM_KIND_CONTAINER_DIAGRAM = "container_diagram",
							   DIAGRAM_KIND_MAIN_DIAGRAM = "main_diagram";
	
	/**
	 * the diagram identifier of the diagram type for compartment role object models as defined in the extensions of this package
	 * <p>
	 * This value should always be the same as the value of the field <em>id</em> of the extension point 
	 * <em>org.eclipse.graphiti.ui.diagramTypes</em>.
	 */
	public static final String DIAGRAM_TYPE_ID = "CROM_Diagram";
	
	/**
	 * the identifier for the {@link DiagramTypeProvider} as defined in the extensions of this package
	 * <p>
	 * This value should always be the same as the value of the field <em>id</em> of the extension point 
	 * <em>org.eclipse.graphiti.ui.diagramTypeProviders</em>.
	 */
	public static final String DIAGRAM_PROVIDER_ID = "CROM_Diagram_Provider";
	
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
	
	//Feature Model
	//~~~~~~~~~~~~~
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
						  	URL_TO_STANDARD_CONFIGURATION = BUNDLE_FEATUREMODEL.getEntry("/standardframedconfiguration/standardFramedConfiguration.crom_diagram");
	
	/**
	 * name literals for the command and feature to change the configuration
	 */
	public static final String CHANGE_CONFIGURATION_COMMAND_NAME = "Configuration Change",
							   CHANGE_CONFIGURATION_FEATURE_NAME = "Change Feature Model";
			
	//Editors
	//~~~~~~~
	/**
	 * the editor id of the {@link MultipageEditor}
	 * <p>
	 * This value should always be the same as the value of the field <em>id</em> of the extension point #
	 * <em>org.eclipse.ui.editors</em>.
	 */
	public static final String EDITOR_ID = "CROM_MultipageEditor";
	
	//Exceptions
	//~~~~~~~~~~
	/**
	 * messages used in the feature sub editor
	 * <p>
	 * the message for the {@link FeatureModelNotReadableException}
	 */
	public static final String FEATUREMODEL_NOT_READABLE_MESSAGE = "The feature model could not be read!";
	
	/**
	 * the error message for the {@link NoDiagramFoundException}
	 */
	public static final String ERROR_NO_DIAGRAM_FOUND = "A diagram could not be found!";
		
	/**
	 * the error message for the {@link NoModelFoundException}
	 */
	public static final String ERROR_NO_MODEL_FOUND = "A model could not be found!";
	
	/**
	 * the error message for the {@link NoLinkedModelYet}
	 */
	public static final String ERROR_NO_LINKED_MODEL_YET = "There is no model linked for the diagram yet!";
	
	/**
	 * the message for the {@link FeatureHasNoPaletteDescriptorException}
	 */
	public static final String FEATURE_HAS_NO_DESCRIPTOR_MESSAGE = "A Feature has no palette descriptor: ";
	
	/**
	 * the message for the {@link NoFeatureForPatternFound} 
	 */
	public static final String NO_FEATURE_FOR_PATTERN_FOUND = "No feature could found for the pattern: ";
	
	/**
	 * the message for the {@link NotExactlyOneFeatureReferenceFoundException}
	 */
	public static final String NOT_EXACTLY_ONE_FEATURE_REFERENCE_FOUND = "Not exactly one feature reference was found: ";
	
	/**
	 * the message for the {@link MoreThanOneFeatureReferenceFoundException}
	 */
	public static final String MORE_THAN_ONE_FEATURE_REFERENCE_FOUND = "More than one feature reference was found: ";
	
	/**
	 * the message for the {@link TransformationFailedException}
	 */
	public static final String ERROR_TRANSFORMATION_FAILED = "The transformation of the IORM to the CROM failed!";
	
	//Multipage Editor
	//~~~~~~~~~~~~~~~~
	/**
	 * messages used for the multipage editor
	 * <p>
	 * can be:<br>
	 * (1) the error message if the editor input can not be used for the {@link MultipageEditor} or<br>
	 * (2) the error message if the {@link MultipageEditor} could not gather a the file imput to refresh a file or<br>
	 * (3) the message of the workbench status line if there are unsaved changes or<br>
	 * (4) the title for the message dialog if there are unsaved changes in a different multipage editor than the active one or<br>
	 * (5) the text for the message dialog described in (5) or<br>
	 * (6) the message for {@link PartInitException} if the file editor input for a source could not be created
	 */
	public static final String MULTIPAGE_EDITOR_ERROR_NO_VALID_EDITOR_INPUT = "The editor input of the multipage editor is not of a valid type!",
							   MUTLIPAGE_EDITOR_ERROR_NULLPOINTER_ON_FILE_EDITOR_INPUT = "The file editor input used to refresh the file is null!",
							   STATUS_MESSAGE_UNSAVED_CHANGES = "Unsaved changes - the pages are out of sync!",
							   MESSAGE_UNSAVED_CHANGES_IN_OTHER_MULTIPAGE_EDITORS_TITLE = "Unsaved changes in other multipage editors!",
							   MESSAGE_UNSAVED_CHANGES_IN_OTHER_MULTIPAGE_EDITORS_TEXT = "There are unsaved changes in other opened mutlipage editors. "
									   + "Save these editors first to ensure no changes to the model get lost!",
							   MESSAGE_FILE_EDITOR_INPUT_FOR_RESOURCE_IS_NULL = "No file editor input could be created for a given resource!";
	
	/**
	 * name literals for editors/ pages
	 * <p>
	 * can be:<br>
	 * (1) the name for the diagram page or<br>
	 * (2) the name for the iorm textviewer page or<br>
	 * (3) the name for the crom textviewer page or<br>
	 * (4) the name for the feature configuration editor page
	 */
	public static final String DIAGRAM_PAGE_NAME = "CROM Diagram",
							   TEXT_IORM_PAGE_NAME = "IORM",
							   TEXT_CROM_PAGE_NAME = "CROM",
							   FEATURE_PAGE_NAME = "Configuration";
	
	//Wizard
	//~~~~~~
	/**
	 * messages used in the Eclipse wizards
	 * <p>
	 * can be:<br>
	 * (1) the label of the {@link RoleModelWizardPage} for the diagram name or<br>
	 * (2) the description message for the {@link RoleModelWizardPage} or<br>
	 * (3) the message for the user if his input for the diagrams name is invalid or<br>
	 * (4) the title of the error message if no project is selected at role model creation or<br>
	 * (5) the error message if no project is selected at role model creation or<br>
	 * (6) the warning for a risk of deadlock when creating a role model in {@link RoleModelWizard} or<br>
	 * (7) the message if saving the file of a new role model failed in {@link RoleModelWizard} 
	 */
	public static final String WIZARD_PAGE_LABEL = "Diagram Name",
							   WIZARD_PAGE_DESC = "Enter the name of the Role Model",
							   WIZARD_MESSAGE_INVALID_INPUT = "A diagrams name cant be empty and cant contains spaces. Numbers are allowed but as first symbol.",
							   WIZARD_ERROR_NO_PROJECT_TITLE = "No Project Selected",
							   WIZARD_ERROR_NO_PROJECT_TEXT = "Please choose a CROM project to create the role model in!",
							   WIZARD_ERROR_DEADLOCK_DANGER = "Saving called from within a command (likely produces a deadlock)",
							   WIZARD_ERROR_SAVING_FAILED = "Saving failed";
	
	/**
	 * name literals used in the role model wizard or role model project wizard
	 * <p>
	 * can be:<br>
	 * (1) the name of the wizard or<br>
	 * (2) the name of the role model wizard page or<br>
	 * (3) the default name of a new diagram or<br>
	 * (4) the name of of the container diagram
	 * <p>
	 *  If its not clear what <em>container diagram</em> means, see {@link RoleModelWizard#createEmfFileForDiagram} for reference.
	 */
	public static final String WIZARD_WINDOW_NAME = "Role Model Wizard", 
							   WIZARD_PAGE_NAME = "Role Model",
							   STANDARD_DIAGRAM_NAME = "newDiagram",
							   CONTAINER_DIAGRAM_NAME = "Container";
		
	//Palette
	//~~~~~~~
	/**
	 * name literals used for the palette categories
	 * <p>
	 * can be:<br>
	 * (1) the name of the palette category of entities (classes and roles)<br>
	 * (2) the name of the palette category of properties (attributes and operations)<br>
	 * (3) the name of the palette category of relations (inheritances and relationships)<br>
	 * (4) the name of the palette category of constraints (role, intra and inter relationship constraints)
	 */
	public static final String ENTITIES_PALETTE_CATEGORY_NAME = "Entities",
							   PROPERTIES_PALETTE_CATEGORY_NAME = "Properties",
							   RELATIONS_PALETTE_CATEGORY_NAME = "Relations",
							   CONSTRAINTS_PALETTE_CATEGORY_NAME = "Constraints";
	
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
	 * (5) the minimal height for typebody rectangles of classes or roles or<br>
	 * (6) the lenght of textfields
	 */
	public static final int HEIGHT_NAME_SHAPE = 20,
							HEIGHT_ATTRITBUTE_SHAPE = 15,
							HEIGHT_OPERATION_SHAPE = 15,
							MIN_WIDTH_FOR_CLASS_OR_ROLE = 200,
							MIN_HEIGHT_FOR_CLASS_OR_ROLE = 100,
							LENGHT_TEXTFIELD_WIZARD = 250;
	
	/**
	 * layout integers for connections
	 * <p>
	 * can be:<br>
	 * (1) the lenght of the arrowheads of connections or<br>
	 * (2) the height of the arrowheads of connections or<br>
	 * (3) the distance of connection decorators from the connections line
	 */
	public static final int ARROWHEAD_LENGTH = 15,	
							ARROWHEAD_HEIGHT = 10,
						    DISTANCE_FROM_CONNECTION_LINE = 15;
	
	/**
	 * layout integers for the text of occurrence constraints
	 */
	public static final int HEIGHT_CONSTRAINT = 15,
					 		WIDTH_CONSTRAINT = 30;
	
	/**
	 * layout integer(s) for groups and compartment types 
	 */
	public static final int HEIGHT_ELEMENT_SHAPE = 15;
	
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
	
	/**
	 * color value for connections
	 * <p>
	 * can be:<br>
	 * (1) the color of the line of a connection or<br>
	 * (2) the color of arrowheads of connections
	 */
	public static final IColorConstant COLOR_CONNECTIONS = IColorConstant.BLACK,
									   COLOR_ARROWHEAD = IColorConstant.WHITE;
	
	/**
	 * color values for the feature editor
	 * <p>
	 * can be:<br>
	 * (1) the color for a label showing a valid configuration or<br>
	 * (2) the color for a label showing an invalid configuration
	 */
	public static final Color COLOR_VALID_CONFIGURATION = new Color(Display.getCurrent(), 0, 0, 255),
							  COLOR_INVALID_CONFIGURATION = new Color(Display.getCurrent(), 255, 0, 0);
	
	//Names
	//~~~~~
	/**
	 * the limit of the suffix for standard names
	 * <p>
	 * This means that if the limit is 10 the following standard names are used:<br>
	 * <em>standardName</em><br>
	 * <em>standardName1</em><br>
	 * <em>...</em><br>
	 * <em>standardName10</em><br>
	 */
	public final static int STANDARD_NAMES_COUNTER_LIMIT = 10;
	
	/**
	 * regular expression for identifiers:
	 * <p>
	 * string of letters and digits, first is no digit (for names)
	 */
	public static final String REG_EXP_IDENTIFIER = "[a-zA-Z_$][a-zA-Z\\d_$]*"; 
		
	/**
	 * regular expression for qualified identifiers
	 * <p>
	 * full classes: (N.)*N (for types)
	 */
	public static final String REG_EXP_QUALIFIED_IDENTIFIER = "(" + REG_EXP_IDENTIFIER + "\\.)*" + REG_EXP_IDENTIFIER; 
	
	/**
	 * regular expression for cardinalities
	 * <p>
	 * (integer|"*")[".."(integer|"*")]
	 */
	public static final String REG_EXP_CARDINALITY = "(\\d+|\\*)(\\.\\.(\\d+|\\*))?"; 
	
	/**
	 * regular expression for attributes
	 * <p>
	 * name:type
	 */
	public static final String REG_EXP_ATTRIBUTE = REG_EXP_IDENTIFIER + ":" + REG_EXP_QUALIFIED_IDENTIFIER; 
	
	/**
	 * regular expression for parameters
	 * <p> 
	 * name:type
	 */
	public static final String REG_EXP_PARAMETER = REG_EXP_ATTRIBUTE; 
		
	/**
	 * regular expression for operations
	 * <p>
	 * name"("[Parameter(","Parameter)*]"):"type, return type is optional
	 */
	public static final String REG_EXP_OPERATION = REG_EXP_IDENTIFIER + "\\((" + REG_EXP_PARAMETER + "(," + REG_EXP_PARAMETER + ")*)?\\)(:" + REG_EXP_QUALIFIED_IDENTIFIER + ")?";
		
	/**
	 * regular expression for role groups
	 * <p>
	 * name [ "(" cardinality ")" ]
	 */
	public static final String REG_EXP_ROLEGROUP = REG_EXP_IDENTIFIER +"([ ]*[(]"+ REG_EXP_CARDINALITY +"[)])?"; 
}
