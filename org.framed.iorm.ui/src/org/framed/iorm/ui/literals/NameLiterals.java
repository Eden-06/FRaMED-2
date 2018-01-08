package org.framed.iorm.ui.literals;

import fulfillment.EditFulfillmentFeature;
import relationship.EditRelationshipFeature;

import org.framed.iorm.ui.configuration.ConfigurationEditorChangeCommand;
import org.framed.iorm.ui.graphitifeatures.*; //*import for javadoc link

/**
 * This class saves severals static Strings used as names.
 * @author Kevin Kassin
 */
public class NameLiterals {
	
						  
	/**
	 * standard values for graphiti shape names and cardinalities
	 * <p>
	 * can be:<br>
	 * (1) the standard name for compartment types or<br>
	 * (2) the standard name for naturals types or<br>
	 * (3) the standard name for data types or<br>
	 * (4) the standard name for groups or<br>
	 * (5) the standard name for attributes or<br>
	 * (6) the standard name for operations or<br>
	 * (7) the standard name for relationships or<br>
	 * (8) the standard value for cardinalities
	 */
	public static final String STANDARD_COMPARTMENTTYPE_NAME = "compartmentType",
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
	 * (1) the name of the compartment type create feature or<br>
	 * (2) the name of the natural type create feature or<br>
	 * (3) the name of the data type create feature or<br>
	 * (4) the name of the group create feature or<br>
	 * (5) the name of the attribute create feature or<br>
	 * (6) the name of the operation create feature or<br>
	 * (7) the name of the role type create feature
	 */
	public static final String COMPARTMENTTYPE_FEATURE_NAME = "Compartment Type",
			 				   GROUP_FEATURE_NAME = "Group";
		
	/**
	 * name literals used in the patterns to be identified by the ToolBehaviorProvider 
	 * <p>
	 * This is needed to not show the pattern with create features the user should not invoke manually
	 * or does not even have even create features implemented.
	 * can be:<br>
	 * (1) the name of the model create feature or<br>
	 * (2) the name of the common pattern for group and compartment type elements or<br>
	 * (3) the name of the common pattern for attributes and operations or<br>
	 * (4) the name of the pattern for the decorator of relationships
	 * <p>
	 * <em>Group and compartment type elements</em> are just text fields which show the content of a group or
	 * compartment type in this case. Here are not the actual elements meant, which are saved in the groups or
	 * compartment types diagram.
	 */
	public static final String GROUP_OR_COMPARTMENT_TYPE_ELEMENT_FEATURE_NAME = "GroupOrCompartmentTypeElementPattern",
			                   RELATIONSHIP_DECORATOR_FEATURE_NAME = "Relationship Decorator";
	
	/**
	 * name literals used as names for the graphiti custom features
	 * <p>
	 * can be:<br>
	 * (1) the name of the {@link ChangeConfigurationFeature} or<br>
	 * (2) the name of the {@link EditRelationshipFeature} or<br>
	 * (3) the name of the {@link EditFulfillmentFeature} or<br>
	 * (4) the name of the {@link StepInFeature} or<br>
	 * (5) the name of the {@link StepInNewTabeFeature} or<br>
	 * (6) the name of the {@link StepOutFeature} or<br>
	 * (7) the name of the {@link ResetLayoutForElementFeature}
	 */
	public static final String CHANGE_CONFIGURATION_FEATURE_NAME = "Change Feature Model",
							   EDIT_RELATIONSHIP_FEATURE_NAME = "Edit Relationship",
							   EDIT_FULFILLMENT_FEATURE_NAME = "Edit Fulfillment",
							   STEP_IN_FEATURE_NAME = "Step In",
							   STEP_IN_NEW_TAB_FEATURE_NAME = "Step In New Tab",
							   STEP_OUT_FEATURE_NAME = "Step out",
							   RESET_LAYOUT_FEATURE_NAME = "Reset Layout of Element";
}

