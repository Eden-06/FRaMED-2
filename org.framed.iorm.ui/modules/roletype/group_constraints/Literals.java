package roletype.group_constraints;

import org.eclipse.graphiti.util.IColorConstant;
import org.framed.iorm.ui.UILiterals;

/**
 * This class saves literals in the scope of the role group feature module.
 * @author Kevin Kassin
 */
public class Literals {
	
	/**
	 * the features names used for the palette entry of this feature
	 */
	public final String FEATURE_NAME = "Role Group";
	
	/**
	 * name of the custom feature
	 */
	public final String RESET_LAYOUT_FEATURE_NAME = "Reset Layout";
	
	/**
	 * the standard name and cardinality for a pictogramm element and business object created by the feature
	 */
	public final String STANDARD_NAME = "roleGroup",
						STANDARD_CARDINALITY = "*";
						
	/**
	 * the ids or the paths for icon used for palette entry of this feature
	 */		
	public final String	ICON_IMG_ID = "org.framed.iorm.ui.modules.rolegroup",
						ICON_IMG_PATH = "modules/roletype/group_constraints/icon_rolegroup.png";
	
	/**
	 * literals for the InRoleGroupPatterns
	 */
	public final String ROLEGROUP_IN_RG_FEATURE_NAME = "Role Group in Role Group",
						ROLETYPE_IN_RG_FEATURE_NAME = "Role Type in Role Group",
						ROLEGROUP_IN_RG_ICON_IMG_ID = "org.framed.iorm.ui.modules.rolegroup_in_rg",
						ROLETYPE_IN_RG_ICON_IMG_ID = "org.framed.iorm.ui.modules.roletype_in_rg";
	
	/**
	 * the kind of diagram this module's pattern creates
	 */
	public final String DIAGRAM_KIND = "role_group_diagram";

	/**
	 * identifiers used for role groups pictogramm shapes
	 * <p>
	 * can be for:<br>
	 * (1) the container shape or<br>
	 * (2) type body shape or<br>
	 * (3) name shape or<br>
	 * (4) occurrence constraint
	 */
	public final String SHAPE_ID_ROLEGROUP_CONTAINER = "shape_rg_container",
						SHAPE_ID_ROLEGROUP_TYPEBODY = "shape_rg_typebody",
						SHAPE_ID_ROLEGROUP_NAME = "shape_rg_name",
						SHAPE_ID_ROLEGROUP_OCCURRENCE_CONSTRAINT = "shape_rg_cardinality";
	
	/**
	 * messages used as direct editing tips
	 */
	public final String DIRECTEDITING_ROLEGROUP = "A role group's name cant be empty or contain spaces. Numbers are allowed but not as first symbol. There can be a cardinality written in parenthesis.",
						NAME_ALREADY_USED_ROLEGROUP = "Another role group already has the same name!",
						DIRECTEDITING_OCCURRENCE_CONSTRAINT = "The Occurrence Constraint has to be in the form <0-9/*> or <0-9>..<0-9/*>!";
	
	/**
	 * reason messages used in the <em>updateNeeded</em> operations of the shape pattern
	 */
	public final String REASON_NAME_NULL = "Name is null.",
						REASON_NAME_OUT_OF_DATE = "Name is out of date.",
						REASON_OCCURRENCE_CONSTRAINTS = "Occurrence Constraint is out of date.";
	
	/**
	 * integers used to layout this features pictogramm elements 
	 */
	public final int MIN_WIDTH = UILiterals.MIN_WIDTH_FOR_CLASS_OR_ROLE, 
					 MIN_HEIGHT = UILiterals.MIN_HEIGHT_FOR_CLASS_OR_ROLE,
					 HEIGHT_NAME_SHAPE = UILiterals.HEIGHT_NAME_SHAPE,
					 ROLE_GROUP_CORNER_RADIUS = 2*HEIGHT_NAME_SHAPE,
					 PUFFER_BETWEEN_ELEMENTS = UILiterals.PUFFER_BETWEEN_ELEMENTS,
					 SHADOW_SIZE = UILiterals.SHADOW_SIZE,
					 HEIGHT_OCCURRENCE_CONSTRAINT = UILiterals.HEIGHT_CONSTRAINT,
					 WIDTH_OCCURRENCE_CONSTRAINT = UILiterals.WIDTH_CONSTRAINT;
	
	/**
	 * color values
	 * <p>
	 * can be:<br>
	 * (1) the color of text or<br>
	 * (2) the color of lines or<br>
	 * (3) the color of backgrounds
	 */
	public final IColorConstant COLOR_TEXT = UILiterals.COLOR_TEXT,
			   					COLOR_LINES = IColorConstant.BLACK,
			   					COLOR_BACKGROUND = UILiterals.COLOR_BACKGROUND;  		
	
	//Name
	//~~~~~
	/**
	 * regular expression for role group names
	 */
	public final String REG_EXP_NAME = UILiterals.REG_EXP_ROLEGROUP;
}
