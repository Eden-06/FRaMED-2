package org.framed.iorm.ui.literals;

import org.framed.iorm.ui.commands.ConfigurationEditorChangeCommand; //*import for javadoc link
import org.framed.iorm.ui.wizards.RoleModelWizard; //*import for javadoc link

import relationship.EditRelationshipFeature;

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
							   STANDARD_NATURALTYPE_NAME = "naturalType",
			   				   STANDARD_GROUP_NAME = "group",
			   				   STANDARD_ROLETYPE_NAME = "roleType",
			   				   STANDARD_RELATIONSHIP_NAME = "rst",
			   				   STANDARD_CARDINALITY = "*";
							  
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
							   NATURALTYPE_FEATURE_NAME = "Natural Type",
			 				   GROUP_FEATURE_NAME = "Group",
							   ROLETYPE_FEATURE_NAME = "Role Type";
	
	/**
	 * name literals used in the connection patterns for shown create features
	 * <p>
	 * can be:<br>
	 * (1) the name of the inheritance create feature or<br>
	 * (2) the name of the role implication create feature or<br>
	 * (3) the name of the role equivalence create feature or<br>
	 * (4) the name of the role prohibition create feature or<br>
	 * (5) the name of the relationship create feature or<br>
	 * (6) the name of the acyclic constraint create feature or<br>
	 * (7) the name of the cyclic constraint create feature or<br>
	 * (8) the name of the irreflexive constraint create feature or<br>
	 * (9) the name of the reflexive constraint create feature or<br>
	 * (10) the name of the total constraint create feature or<br>
	 * (11) the name of the relationship implication create feature or<br>
	 * (12) the name of the relationship exclusion create feature or<br>
	 * (13) the name of the fulfillment create feature
	 */
	public static final String INHERITANCE_FEATURE_NAME = "Inheritance",
							   ROLEIMPLICATION_FEATURE_NAME = "Role Implication",
							   ROLEEQUIVALENCE_FEATURE_NAME = "Role Eqivalence",
						       ROLEPROHIBITION_FEATURE_NAME = "Role Prohibition",
						       RELATIONSHIP_FEATURE_NAME = "Relationship",
						       ACYCLIC_FEATURE_NAME = "Acyclic",
						       CYCLIC_FEATURE_NAME = "Cyclic",
						       IRREFLEXIVE_FEATURE_NAME = "Irreflexve",
						       REFLEXIVE_FEATURE_NAME = "Reflexive",
						       TOTAL_FEATURE_NAME = "Total",
						       RELATIONSHIP_IMPLICATION_FEATURE_NAME = "Relationship Implication",
						       RELATIONSHIP_EXCLUSION_FEATURE_NAME = "Relationship Exclusion",
						       FULFILLMENT_FEATURE_NAME = "Fulfillment";
	
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

