package roletype;

import org.eclipse.graphiti.util.IColorConstant;
import org.framed.iorm.ui.literals.UILiterals;

/**
 * This class saves literals in the scope of the attribute and operations feature module.
 * @author Kevin Kassin
 */
public class Literals {

	/**
	 * the features name used for the palette entry of this feature
	 */
	public final String FEATURE_NAME = "Role Type";
	
	/**
	 * name of the custom feature
	 */
	public final String RESET_LAYOUT_FEATURE_NAME = "Reset Layout";
	
	/**
	 * the standard name for a pictogramm element and business object created by the feature or<br>
	 * the standard value for a new cardinality
	 */
	public final String STANDARD_NAME = "roleType",
					    STANDARD_CARDINALITY = "*";
						
	/**
	 * the id or the path for icon used for palette entry of this feature
	 */		
	public final String	ICON_IMG_ID = "org.framed.iorm.ui.core.roletype",
						ICON_IMG_PATH = "core/roletype/icon_roletype.png";
	
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
	public final String SHAPE_ID_ROLETYPE_CONTAINER = "shape_rt_container",
						SHAPE_ID_ROLETYPE_OCCURRENCE_CONSTRAINT = "shape_rt_cardinality",
						SHAPE_ID_ROLETYPE_TYPEBODY = "shape_rt_typebody",
						SHAPE_ID_ROLETYPE_SHADOW = "shape_rt_shadow",
						SHAPE_ID_ROLETYPE_NAME = "shape_rt_name", 
						SHAPE_ID_ROLETYPE_FIRSTLINE = "shape_rt_firstline",
						SHAPE_ID_ROLETYPE_SECONDLINE = "shape_rt_secondline", 
						SHAPE_ID_ROLETYPE_ATTRIBUTECONTAINER = "shape_rt_attcontainer",
						SHAPE_ID_ROLETYPE_OPERATIONCONTAINER = "shape_rt_opcontainer";
	
	/**
	 * messages used as direct editing tips
	 */
	public final String DIRECTEDITING_ROLETYPE = "A role types name cant be empty and cant contains spaces. Numbers are allowed but not as first symbol.",
			   			NAME_ALREADY_USED_ROLETYPE = "Another role type in this compartment type already has the same name!",
			   			DIRECTEDITING_OCCURRENCE_CONSTRAINT = "The Occurrence Constraint has to be in the form <0-9/*> or <0-9>..<0-9/*>!";
	
	/**
	 * layout integers
	 */
	public final int MIN_WIDTH = UILiterals.MIN_WIDTH_FOR_CLASS_OR_ROLE, 
					 MIN_HEIGHT = UILiterals.MIN_HEIGHT_FOR_CLASS_OR_ROLE, 
					 HEIGHT_NAME_SHAPE = UILiterals.HEIGHT_NAME_SHAPE,
					 PUFFER_BETWEEN_ELEMENTS = UILiterals.PUFFER_BETWEEN_ELEMENTS,
					 ROLE_CORNER_RADIUS = 2*HEIGHT_NAME_SHAPE,
					 SHADOW_SIZE = UILiterals.SHADOW_SIZE,
					 HEIGHT_OCCURRENCE_CONSTRAINT = UILiterals.HEIGHT_CONSTRAINT,
					 WIDTH_OCCURRENCE_CONSTRAINT = UILiterals.WIDTH_CONSTRAINT;
	
	/**
	 * color values
	 * <p>
	 * can be:<br>
	 * (1) the color of text or<br>
	 * (2) the color of lines or<br>
	 * (3) the color of backgrounds or<br>
	 * (4) the color of graphiti shapes shadows
	 */
	public final IColorConstant COLOR_TEXT = UILiterals.COLOR_TEXT,
			   					COLOR_LINES = UILiterals.COLOR_LINES,
			   					COLOR_BACKGROUND = UILiterals.COLOR_BACKGROUND,
			   					COLOR_SHADOW = UILiterals.COLOR_SHADOW;
	
	/**
	 * reason messages used in the operation {@link #updateNeeded} gathered from {@link TextLiterals}
	 */
	public final String REASON_NAME_NULL = "Name of a Role Type is null.",
						REASON_NAME_OUT_OF_DATE = "Name of a Role Type is out of date.",
						REASON_OCCURRENCE_CONSTRAINTS = "Occurrence Constraint is out of date.";
	
	/**
	 * regular expression for a role type names and cardinalities
	 */
	public final String REG_EXP_NAME = UILiterals.REG_EXP_IDENTIFIER,
						REG_EXP_CARDINALITY = UILiterals.REG_EXP_CARDINALITY;
	
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
}
