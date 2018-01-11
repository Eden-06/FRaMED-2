package group;

import org.eclipse.graphiti.util.IColorConstant;
import org.framed.iorm.ui.literals.UILiterals;

public class Literals {

	/**
	 * the features names used for the palette entry of this feature
	 */
	public final String FEATURE_NAME = "Group",
						ELEMENTS_FEATURE_NAME = "GroupElementPattern";
	
	/**
	 * the standard name for a pictogramm element and business object created by the feature
	 */
	public final String STANDARD_NAME = "group";
						
	/**
	 * the ids or the paths for icon used for palette entry of this feature
	 */		
	public final String	ICON_IMG_ID = "org.framed.iorm.ui.core.group",
						ELEMENTS_ICON_IMG_ID = "org.framed.iorm.ui.modules.GroupElements",
						ICON_IMG_PATH = "core/group/icon_group.png";
						
	//TODO
	public final String DIAGRAM_KIND = "group_diagram";

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
	public final String SHAPE_ID_GROUP_CONTAINER = "shape_group_container",
						SHAPE_ID_GROUP_TYPEBODY = "shape_group_typebody",
						SHAPE_ID_GROUP_SHADOW = "shape_group_shadow",
						SHAPE_ID_GROUP_NAME = "shape_group_name", 
						SHAPE_ID_GROUP_LINE = "shape_group_line",
						SHAPE_ID_GROUP_CONTENT_PREVIEW = "shape_content_preview",
						SHAPE_ID_GROUP_ELEMENT = "shape_group_element",
						SHAPE_ID_GROUPS_INDICATOR_DOTS = "shape_group_indicator_dots";
	
	/**
	 * messages used as direct editing tips
	 */
	public final String DIRECTEDITING_GROUP = "A groups name cant be empty and cant contains spaces. Numbers are allowed but not as first symbol.",
						NAME_ALREADY_USED_GROUP = "Another group already has the same name!";
	
	/**
	 * reason messages used in the <em>updateNeeded</em> operations of the shape pattern
	 */
	public final String REASON_NAME_NULL = "Name is null.",
						REASON_NAME_OUT_OF_DATE = "Name is out of date.",
						REASON_AMOUNT_ELEMENTS = "Different amount of elements.",
						REASON_NAMES_ELEMENTS = "Different names of elements.";
	
	/**
	 * layout integers gathered from {@link IdentifierLiterals}, look there for reference
	 */
	public final int MIN_WIDTH = UILiterals.MIN_WIDTH_FOR_CLASS_OR_ROLE,
					 MIN_HEIGHT = UILiterals.MIN_HEIGHT_FOR_CLASS_OR_ROLE,
					 HEIGHT_NAME_SHAPE = UILiterals.HEIGHT_NAME_SHAPE,
					 PUFFER_BETWEEN_ELEMENTS = UILiterals.PUFFER_BETWEEN_ELEMENTS,
					 GROUP_CORNER_RADIUS = 2*HEIGHT_NAME_SHAPE,
					 SHADOW_SIZE = UILiterals.SHADOW_SIZE,
					 HEIGHT_GROUP_ELEMENT_SHAPE = UILiterals.HEIGHT_ELEMENT_SHAPE;

	
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
	
}
