package org.framed.iorm.ui.literals;

import org.framed.iorm.ui.commands.ConfigurationEditorChangeCommand; //*import for javadoc link
import org.framed.iorm.ui.wizards.RoleModelWizard; //*import for javadoc link
import org.framed.iorm.ui.graphitifeatures.*; //*import for javadoc link

/**
 * This class saves severals static Strings used as names.
 * @author Kevin Kassin
 */
public class NameLiterals {
	
	/**
	 * the file extension of the diagram type used in this editor 
	 */
	public static final String FILE_EXTENSION_FOR_DIAGRAMS = ".crom_diagram";
	
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
							  
	/**
	 * standard names for graphiti shapes
	 * <p>
	 * can be:<br>
	 * (1) the standard name for attributes or<br>
	 * (2) the standard name for operations or<br>
	 * (3) the standard name for naturals types or<br>
	 * (4) the standard name for data types or<b>
	 * (5) the standard name for groups
	 */
	public static final String STANDARD_ATTRIBUTE_NAME = "attribute:type",
							   STANDARD_OPERATION_NAME = "operation():type",
							   STANDARD_NATURALTYPE_NAME = "naturalType",
							   STANDARD_DATATYPE_NAME = "dataType",
							   STANDARD_GROUP_NAME = "group";

	/**
	 * name literals for commands
	 * <p>
	 * the name for the {@link ConfigurationEditorChangeCommand}
	 */
	public static final String CONFIGURATION_CHANGE_COMMAND_NAME = "Configuration Change";
	
	/**
	 * name literals used in the shape patterns for shown create features
	 * <p>
	 * can be:<br>
	 * (1) the name of the natural type create feature or<br>
	 * (2) the name of the data type create feature or<br>
	 * (3) the name of the group create feature or<br>
	 * (4) the name of the attribute create feature or<br>
	 * (5) the name of the operation create feature 
	 */
	public static final String NATURALTYPE_FEATURE_NAME = "Natural Type",
			 				   DATATYPE_FEATURE_NAME = "Data Type",
			 				   GROUP_FEATURE_NAME = "Group",
			 				   ATTRIBUTE_FEATURE_NAME = "Attribute",
							   OPERATION_FEATURE_NAME = "Operation";
	
	/**
	 * name literals used in the connection patterns for shown create features
	 * <p>
	 * can be:<br>
	 * (1) the name of the inheritance create feature
	 */
	public static final String INHERITANCE_FEATURE_NAME = "Inheritance";
	
	/**
	 * name literals used in the patterns to be identified by the ToolBehaviorProvider 
	 * <p>
	 * This is needed to not show the pattern with create features the user should not invoke manually
	 * or does not even have even create features implemented.
	 * can be:<br>
	 * (1) the name of the model create feature or<br>
	 * (2) the name of the common pattern for group and compartment type elements or<br>
	 * (3) the name of the common pattern for attributes and operations
	 * <p>
	 * <em>Group and compartment type elements</em> are just text fields which show the content of a group or
	 * compartment type in this case. Here are not the actual elements ment, which are saved in the groups or
	 * compartment types diagram.
	 */
	public static final String MODEL_FEATURE_NAME = "Model", 
							   GROUP_OR_COMPARTMENT_TYPE_ELEMENT_FEATURE_NAME = "GroupOrCompartmentTypeElementPattern",
			                   ATTRIBUTE_OPERATION_COMMON_FEATURE_NAME = "AttributeOperationCommonPattern";
	
	/**
	 * name literals used as names for the graphiti custom features
	 * <p>
	 * can be:<br>
	 * (1) the name of the {@link ChangeConfigurationFeature} or<br>
	 * (2) the name of the {@link StepInFeature} or<br>
	 * (3) the name of the {@link StepInNewTabeFeature} or<br>
	 * (4) the name of the {@link StepOutFeature}
	 */
	public static final String CHANGECONFIGURATION_FEATURE_NAME = "Change Feature Model",
							   STEP_IN_FEATURE_NAME = "Step In",
							   STEP_IN_NEW_TAB_FEATURE_NAME = "Step In New Tab",
							   STEP_OUT_FEATURE_NAME = "Step out";
	
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
}

