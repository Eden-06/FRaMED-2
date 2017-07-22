package org.framed.iorm.ui.literals;

import org.framed.iorm.ui.providers.DiagramTypeProvider; //*import for javadoc link 
import org.framed.iorm.ui.multipage.MultipageEditor; //*import for javadoc link
import org.framed.iorm.ui.subeditors.FRaMEDDiagramEditor; //*import for javadoc link
import org.framed.iorm.ui.subeditors.FRaMEDFeatureEditor; //*import for javadoc link
import org.framed.iorm.ui.util.PropertyUtil; //*import for javadoc link
import org.framed.iorm.ui.wizards.RoleModelWizard;

/**
 * This class saves severals static Strings used as identifiers.
 * @author Kevin Kassin
 */
public class IdentifierLiterals {

	/**
	 * the identifier for the {@link DiagramTypeProvider} as defined in the extensions of this package
	 * <p>
	 * This value should always be the same as the value of the field <em>id</em> of the extension point 
	 * <em>org.eclipse.graphiti.ui.diagramTypeProviders</em>.
	 */
	public static final String DIAGRAM_PROVIDER_ID = "CROM_Diagram_Provider";
	
	/**
	 * the diagram identifier of the diagram type for compartment role object models as defined in the extensions of this package
	 * <p>
	 * This value should always be the same as the value of the field <em>id</em> of the extension point 
	 * <em>org.eclipse.graphiti.ui.diagramTypes</em>.
	 */
	public static final String DIAGRAM_TYPE_ID = "CROM_Diagram";
	
	/**
	 * the editor id of the {@link MultipageEditor}
	 * <p>
	 * This value should always be the same as the value of the field <em>id</em> of the extension point #
	 * <em>org.eclipse.ui.editors</em>.
	 */
	public static final String EDITOR_ID = "CROM_MultipageEditor";

	/**
	 * string used as prefix for image identifiers for icon of create features
	 */
	private static final String IMG_ID_PREFIX = "org.framed.iorm.ui.";
	
	/**
	 * image IDs
	 * <p>
	 * the identifier of images used in the {@link FRaMEDDiagramEditor} for shape create features
	 */
	public static final String IMG_ID_FEATURE_COMPARTMENTTYPE = IMG_ID_PREFIX + "img_compartmenttype",
							   IMG_ID_FEATURE_NATURALTYPE = IMG_ID_PREFIX + "img_naturaltype",
							   IMG_ID_FEATURE_DATATYPE = IMG_ID_PREFIX + "img_datatype",
							   IMG_ID_FEATURE_ATTRIBUTE = IMG_ID_PREFIX + "img_attribute",
							   IMG_ID_FEATURE_OPERATION = IMG_ID_PREFIX + "img_operation",
							   IMG_ID_FEATURE_GROUP = IMG_ID_PREFIX + "img_group",
							   IMG_ID_FEATURE_ROLETYPE = IMG_ID_PREFIX + "img_roletype";
	
	/**
	 * image IDs
	 * <p>
	 * the identifier of images used in the {@link FRaMEDDiagramEditor} for connection create features
	 */
	public static final String IMG_ID_FEATURE_INHERITANCE = IMG_ID_PREFIX + "img_inheritance",
							   IMG_ID_FEATURE_ROLEIMPLICATION = IMG_ID_PREFIX + "img_roleimplication",
							   IMG_ID_FEATURE_ROLEEQUIVALENCE = IMG_ID_PREFIX + "img_roleequivalence",
							   IMG_ID_FEATURE_ROLEPROHIBITION = IMG_ID_PREFIX + "img_roleprohibition",
							   IMG_ID_FEATURE_RELATIONSHIP = IMG_ID_PREFIX + "img_relationship";
	/**
	 * feature model identifier
	 * <p>
	 * the identifier of the feature model the {@link FRaMEDFeatureEditor} uses
	 */
	public static final String FEATUREMODEL_ID = "org.framed.iorm.featuremodel";
	
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
	
	/**
	 * identifiers used for natural types
	 * <p>
	 * can be for:<br>
	 * (1) type body shape or<br>
	 * (2) drop shadow shape or<br>
	 * (3) name shape or<br>
	 * (4) first line shape or<br>
	 * (5) second line shape or<br>
	 * (6) attribute container shape or<br>
	 * (7) operation container shape
	 */
	public static final String SHAPE_ID_COMPARTMENTTYPE_CONTAINER = "shape_ct_container",
							   SHAPE_ID_COMPARTMENTTYPE_TYPEBODY = "shape_ct_typebody",
						 	   SHAPE_ID_COMPARTMENTTYPE_SHADOW = "shape_ct_shadow",
						 	   SHAPE_ID_COMPARTMENTTYPE_NAME = "shape_ct_name", 
						 	   SHAPE_ID_COMPARTMENTTYPE_FIRSTLINE = "shape_ct_firstline",
						 	   SHAPE_ID_COMPARTMENTTYPE_SECONDLINE = "shape_ct_secondline", 
						 	   SHAPE_ID_COMPARTMENTTYPE_THIRDLINE = "shape_ct_thirdline", 
						 	   SHAPE_ID_COMPARTMENTTYPE_ATTRIBUTECONTAINER = "shape_ct_attcontainer",
						 	   SHAPE_ID_COMPARTMENTTYPE_OPERATIONCONTAINER = "shape_ct_opcontainer",
						 	   SHAPE_ID_COMPARTMENTTYPE_CONTENT_PREVIEW = "shape_ct_contentpreview",
						 	   SHAPE_ID_COMPARTMENTTYPE_ELEMENT = "shape_ct_element",
						 	   SHAPE_ID_COMPARTMENTTYPE_INDICATOR_DOTS = "shape_ct_indicator_dots";
	
	/**
	 * identifiers used for natural types
	 * <p>
	 * can be for:<br>
	 * (1) type body shape or<br>
	 * (2) drop shadow shape or<br>
	 * (3) name shape or<br>
	 * (4) first line shape or<br>
	 * (5) second line shape or<br>
	 * (6) attribute container shape or<br>
	 * (7) operation container shape
	 */
	public static final String SHAPE_ID_NATURALTYPE_CONTAINER = "shape_nt_container",
							   SHAPE_ID_NATURALTYPE_TYPEBODY = "shape_nt_typebody",
						 	   SHAPE_ID_NATURALTYPE_SHADOW = "shape_nt_shadow",
						 	   SHAPE_ID_NATURALTYPE_NAME = "shape_nt_name", 
						 	   SHAPE_ID_NATURALTYPE_FIRSTLINE = "shape_nt_firstline",
						 	   SHAPE_ID_NATURALTYPE_SECONDLINE = "shape_nt_secondline", 
						 	   SHAPE_ID_NATURALTYPE_ATTRIBUTECONTAINER = "shape_nt_attcontainer",
						 	   SHAPE_ID_NATURALTYPE_OPERATIONCONTAINER = "shape_nt_opcontainer";
	
	/**
	 * identifiers used for data types
	 * <p>
	 * can be for:<br>
	 * (1) container shape or<br>
	 * (2) typebody shape or<br>
	 * (3) shadow shape or<br>
	 * (4) name shape or<br>
	 * (5) first line shape or<br>
	 * (6) second line shape or<br>
	 * (7) attribute container shape or<br>
	 * (8) operation container shape 
	 */
	public static final String SHAPE_ID_DATATYPE_CONTAINER = "shape_dt_container",
							   SHAPE_ID_DATATYPE_TYPEBODY = "shape_dt_typebody",
						 	   SHAPE_ID_DATATYPE_SHADOW = "shape_dt_shadow",
						 	   SHAPE_ID_DATATYPE_NAME = "shape_dt_name", 
						 	   SHAPE_ID_DATATYPE_FIRSTLINE = "shape_dt_firstline",
						 	   SHAPE_ID_DATATYPE_SECONDLINE = "shape_dt_secondline", 
						 	   SHAPE_ID_DATATYPE_ATTRIBUTECONTAINER = "shape_dt_attcontainer",
						 	   SHAPE_ID_DATATYPE_OPERATIONCONTAINER = "shape_dt_opcontainer";
	
	/**
	 * identifiers used for the group
	 * <p>
	 * can be for:<br>
	 * (1) type body shape or<br>
	 * (2) shadow shape or<br>
	 * (3) name shape or<br>
	 * (4) line shape or<br>
	 * (5) model container shape or<br>
	 * (6) model element shape or<br>
	 * (7) indicator dots if not all model element names fit in to the groups type body shape
	 */
	public static final String SHAPE_ID_GROUP_CONTAINER = "shape_group_container",
							   SHAPE_ID_GROUP_TYPEBODY = "shape_group_typebody",
						 	   SHAPE_ID_GROUP_SHADOW = "shape_group_shadow",
						 	   SHAPE_ID_GROUP_NAME = "shape_group_name", 
						 	   SHAPE_ID_GROUP_LINE = "shape_group_line",
						 	   SHAPE_ID_GROUP_CONTENT_PREVIEW = "shape_content_preview",
						 	   SHAPE_ID_GROUP_ELEMENT = "shape_group_element",
						 	   SHAPE_ID_GROUPS_INDICATOR_DOTS = "shape_group_indicator_dots";
	
	/**
	 * identifiers used for attributes and operations
	 * <p>
	 * can be for:<br>
	 * (1) the attribute text shape or<br>
	 * (2) the indicator dots if not all attributes fit in to the class or roles type body shape or<br>
	 * (3) the operation text shape or<br>
	 * (4) the indicator dots if not all operations fit in to the class or roles type body shape
	 */
	public static final String SHAPE_ID_ATTRIBUTE_TEXT = "shape_att_text",
							   SHAPE_ID_ATTRIBUTE_INDICATOR_DOTS = "shape_att_indicator_dots",
							   SHAPE_ID_OPERATION_TEXT = "shape_op_text",
							   SHAPE_ID_OPERATION_INDICATOR_DOTS = "shape_op_indicator_dots";
	
	/**
	 * identifier used for role constraint connection decorators
	 */
	public static final String SHAPE_ID_ROLE_CONSTRAINT_DECORATOR = "shape_rc_decorator";
	
	/**
	 * identifier used for the connection decorator of the inheritance relation
	 */
	public static final String SHAPE_ID_INHERITANCE_DECORATOR = "shape_inheritance_decorator";
	
	/**
	 * identifiers used for the connection decoratos of the  name and cardinalities of relationships
	 */
	public static final String SHAPE_ID_RELATIONSHIP_NAME_DECORATOR = "shape_rst_name",
							   SHAPE_ID_RELATIONSHIP_SOURCE_CARDINALITY_DECORATOR = "shape_rst_source_cardinality",
							   SHAPE_ID_RELATIONSHIP_TARGET_CARDINALITY_DECORATOR = "shape_rst_target_cardinality";
	
	/**
	 * identifiers used for role types
	 * <p>
	 * can be for:<br>
	 * (1) type body shape or<br>
	 * (2) drop shadow shape or<br>
	 * (3) name shape or<br>
	 * (4) first line shape or<br>
	 * (5) second line shape or<br>
	 * (6) attribute container shape or<br>
	 * (7) operation container shape
	 */
	public static final String SHAPE_ID_ROLETYPE_CONTAINER = "shape_rt_container",
							   SHAPE_ID_ROLETYPE_TYPEBODY = "shape_rt_typebody",
						 	   SHAPE_ID_ROLETYPE_SHADOW = "shape_rt_shadow",
						 	   SHAPE_ID_ROLETYPE_NAME = "shape_rt_name", 
						 	   SHAPE_ID_ROLETYPE_FIRSTLINE = "shape_rt_firstline",
						 	   SHAPE_ID_ROLETYPE_SECONDLINE = "shape_rt_secondline", 
						 	   SHAPE_ID_ROLETYPE_ATTRIBUTECONTAINER = "shape_rt_attcontainer",
						 	   SHAPE_ID_ROLETYPE_OPERATIONCONTAINER = "shape_rt_opcontainer";
	
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
	
	/**
	 * identifiers to differ between the editor palettes
	 * <p>
	 * can be:<br>
	 * (1) the palette type used outside a stepped in compartment type or<br>
	 * (2) the pallete type used in a editor of a diagram of a compartment type
	 */
	public static final String PALETTE_TYPE_TOPLEVELVIEW = "palette_type_toplevel",
							   PALETTE_TYPE_COMPARTMENTVIEW = "palette_type_compartment";
}
