package org.framed.iorm.ui.literals;

import org.framed.iorm.ui.subeditors.FRaMEDDiagramEditor; //*import for javadoc link
import org.framed.iorm.ui.subeditors.FRaMEDFeatureEditor; //*import for javadoc link

/**
 * This class saves severals static Strings used as identifiers.
 * @author Kevin Kassin
 */
public class IdentifierLiterals {
	
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
							   IMG_ID_FEATURE_GROUP = IMG_ID_PREFIX + "img_group";
							  
	/**
	 * image IDs
	 * <p>
	 * the identifier of images used in the {@link FRaMEDDiagramEditor} for connection create features
	 */
	public static final String IMG_ID_FEATURE_INHERITANCE = IMG_ID_PREFIX + "img_inheritance",
							   IMG_ID_FEATURE_ROLEIMPLICATION = IMG_ID_PREFIX + "img_roleimplication",
							   IMG_ID_FEATURE_ROLEEQUIVALENCE = IMG_ID_PREFIX + "img_roleequivalence",
							   IMG_ID_FEATURE_ROLEPROHIBITION = IMG_ID_PREFIX + "img_roleprohibition",
							   IMG_ID_FEATURE_RELATIONSHIP = IMG_ID_PREFIX + "img_relationship",
							   IMG_ID_FEATURE_INTRARELATIONSHIP_CONSTRAINT = IMG_ID_PREFIX + "img_intrarelationship_constraint",
							   IMG_ID_FEATURE_RELATIONSHIP_IMPLICATION = IMG_ID_PREFIX + "img_relationship_implication",
							   IMG_ID_FEATURE_RELATIONSHIP_EXCLUSION = IMG_ID_PREFIX + "img_relationship_exclusion",
							   IMG_ID_FEATURE_FULFILLMENT = IMG_ID_PREFIX + "img_fulfillment";
	
	/**
	 * feature model identifier
	 * <p>
	 * the identifier of the feature model the {@link FRaMEDFeatureEditor} uses
	 */
	public static final String FEATUREMODEL_ID = "org.framed.iorm.featuremodel";
	
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
	 * identifier used for the connection decorators of the fulfillment relation
	 */
	public static final String SHAPE_ID_FULFILLMENT_ARROWHEAD = "shape_fulfillment_arrowhead",
							   SHAPE_ID_FULFILLMENT_ROLES = "shape_fulfillment_roles";
	
	/**
	 * identifiers used for the connection decorators of the  name and cardinalities of relationships
	 */
	public static final String SHAPE_ID_RELATIONSHIP_NAME_DECORATOR = "shape_rst_name",
							   SHAPE_ID_RELATIONSHIP_SOURCE_CARDINALITY_DECORATOR = "shape_rst_source_cardinality",
							   SHAPE_ID_RELATIONSHIP_TARGET_CARDINALITY_DECORATOR = "shape_rst_target_cardinality",
							   SHAPE_ID_RELATIONSHIP_ANCHOR_DECORATOR = "shape_rst_anchor";
	
	/**
	 * identifier used for the connection decorators of the intra relationship constraints
	 */
	public static final String SHAPE_ID_INTRA_REL_CON_NAME_DECORATOR = "shape_irc_name";
	
	/**
	 * identifier used for role constraint connection decorators
	 */
	public static final String SHAPE_ID_INTER_REL_CON = "shape_inter_rel_con";
	
	/**
	 * identifiers used for role types
	 * <p>
	 * can be for:<br>
	 * (1) type body shape or<br>
	 * (2) occurrence constraint shape or<br>
	 * (3) drop shadow shape or<br>
	 * (4) name shape or<br>
	 * (5) first line shape or<br>
	 * (6) second line shape or<br>
	 * (7) attribute container shape or<br>
	 * (8) operation container shape
	 */
	public static final String SHAPE_ID_ROLETYPE_OCCURRENCE_CONSTRAINT = "shape_rt_cardinality",
							   SHAPE_ID_ROLETYPE_TYPEBODY = "shape_rt_typebody";		
	
}
