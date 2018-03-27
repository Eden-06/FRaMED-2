package relationship;

import org.eclipse.graphiti.util.IColorConstant;
import org.framed.iorm.ui.UILiterals;

/**
 * This class saves literals in the scope of the relationship feature module.
 * @author Kevin Kassin
 */
public class Literals {

	/**
	 * the features name used for the palette entry of this feature
	 */
	public final String FEATURE_NAME = "Relationship",
						CARDINALITY_FEATURE_NAME = "Relationship Cardinality";
	
	/**
	 * the standard name for a pictogramm element and business object created by the feature or<br>
	 * the standard value for a new cardinality
	 */
	public final String STANDARD_NAME = "rst",
					    STANDARD_CARDINALITY = "*";
						
	/**
	 * the id or the path for icon used for palette entry of this feature
	 */		
	public final String	ICON_IMG_ID = "org.framed.iorm.ui.modules.relationship",
						CARDINALITIY_ICON_IMG_ID = "org.framed.iorm.ui.modules.rel_cardinality",
						ICON_IMG_PATH = "modules/relationship/icon_relationship.png";
	
	/**
	 * identifiers used for the connection decorators of the  name and cardinalities of relationships
	 */
	public final String SHAPE_ID_RELATIONSHIP_NAME_DECORATOR = "shape_rst_name",
						SHAPE_ID_RELATIONSHIP_SOURCE_CARDINALITY_DECORATOR = "shape_rst_source_cardinality",
						SHAPE_ID_RELATIONSHIP_TARGET_CARDINALITY_DECORATOR = "shape_rst_target_cardinality",
						SHAPE_ID_RELATIONSHIP_ANCHOR_DECORATOR = "shape_rst_anchor";
	
	/**
	 * layout integers for the feature
	 */
	public final int DISTANCE_FROM_CONNECTION_LINE = UILiterals.DISTANCE_FROM_CONNECTION_LINE,
					 HEIGHT_OCCURRENCE_CONSTRAINT = UILiterals.HEIGHT_CONSTRAINT;
	
	/**
	 * the color values used for the polyline and the texts of the relationship
	 */
	public final IColorConstant COLOR_CONNECTIONS = UILiterals.COLOR_CONNECTIONS,
								COLOR_TEXT = UILiterals.COLOR_TEXT;
	
	/**
	 * regular expression for a relationship names:
	 * <p>
	 * string of letters and digits, first is no digit (for names)
	 */
	public final String REG_EXP_NAME = UILiterals.REG_EXP_IDENTIFIER;
	
	/**
	 * regular expression for cardinalities
	 * <p>
	 * (integer|"*")[".."(integer|"*")]
	 */
	public final String REG_EXP_CARDINALITY = UILiterals.REG_EXP_CARDINALITY;
	
	/**
	 * the limit of the suffix for standard names
	 * <p>
	 * This means that if the limit is 10 the following standard names are used:<br>
	 * <em>standardName</em><br>
	 * <em>standardName1</em><br>
	 * <em>...</em><br>
	 * <em>standardName10</em><br>
	 */
	public final int STANDARD_NAMES_COUNTER_LIMIT = UILiterals.STANDARD_NAMES_COUNTER_LIMIT;;
	
	//Custom edit feature and edit dialog
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * the name of the custom edit feature
	 */
	public final String EDIT_RELATIONSHIP_FEATURE_NAME = "Edit Relationship",
						RESET_LAYOUT_FEATURE_NAME = "Reset Layout";
	
	/**
	 * messages and titles used in the {@link EditRelationshipDialog} as tips when invalid inputs happen
	 */
	public final String EDITING_RELATIONSHIPS_NAME_INVALID_TITLE = "Relationships name is invalid!",
						EDITING_RELATIONSHIPS_NAME_INVALID = "A relationships name cant be empty and cant contains spaces. Numbers are allowed but as first symbol!",
						EDITING_RELATIONSHIPS_NAME_ALREADY_USED_TITLE = "Relationships name is already used!",
						EDITING_RELATIONSHIPS_NAME_ALREADY_USED = "Another relationship already in this compartment type already has the same name!",
						EDITING_RELATIONSHIPS_SOURCE_CARDINALITY_TITLE = "Relationships source cardinality is invalid!",
						EDITING_RELATIONSHIPS_SOURCE_CARDINALITY = "The source cardinality has to be in the form <0-9/*> or <0-9>..<0-9/*>!",
						EDITING_RELATIONSHIPS_TARGET_CARDINALITY_TITLE = "Relationships target cardinality is invalid!",
						EDITING_RELATIONSHIPS_TARGET_CARDINALITY = "The target cardinality has to be in the form <0-9/*> or <0-9>..<0-9/*>!";
	
	/**
	 * layout integer for wizards
	 * <p>
	 * can be:<br>
	 * (1) the length of the textfield in the role model wizard and role model project wizard or<br>
	 * (2) the height of the dialog to edit relationships or<br>
	 * (3) the width of the dialog to edit relationships
	 */
	public final int LENGHT_TEXTFIELD_WIZARD = 250,
					 HEIGHT_EDIT_RELATIONSHIP_DIALOG = 250,
					 WIDTH_EDIT_RELATIONSHIP_DIALOG = 400;
	
}
