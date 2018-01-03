package core.naturaltype;

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
	public final String FEATURE_NAME = "Natural Type";
	
	/**
	 * the standart name for a pictogramm element and business object created by the feature
	 */
	public final String STANDARD_NAME = "naturalType";
						
	/**
	 * the id or the path for icon used for palette entry of this feature
	 */		
	public final String	ICON_IMG_ID = "org.framed.iorm.ui.modules.core.naturaltype",
						ICON_IMG_PATH = "modules/core/naturaltype/icon_naturaltype.png";
	
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
	public final String SHAPE_ID_NATURALTYPE_CONTAINER = "shape_nt_container",
						SHAPE_ID_NATURALTYPE_TYPEBODY = "shape_nt_typebody",
						SHAPE_ID_NATURALTYPE_SHADOW = "shape_nt_shadow",
						SHAPE_ID_NATURALTYPE_NAME = "shape_nt_name", 
						SHAPE_ID_NATURALTYPE_FIRSTLINE = "shape_nt_firstline",
						SHAPE_ID_NATURALTYPE_SECONDLINE = "shape_nt_secondline", 
						SHAPE_ID_NATURALTYPE_ATTRIBUTECONTAINER = "shape_nt_attcontainer",
						SHAPE_ID_NATURALTYPE_OPERATIONCONTAINER = "shape_nt_opcontainer";
	
	/**
	 * messages used as direct editing tips
	 */
	public final String DIRECTEDITING_NATURALTYPE = "A natural types name cant be empty and cant contains spaces. Numbers are allowed but not as first symbol.",
						NAME_ALREADY_USED_NATURALTYPE = "Another natural type already has the same name!";
	
	/**
	 * integers used to layout this features pictogramm elements 
	 */
	public final int MIN_WIDTH = UILiterals.MIN_WIDTH_FOR_CLASS_OR_ROLE, 
					 MIN_HEIGHT = UILiterals.MIN_HEIGHT_FOR_CLASS_OR_ROLE,
					 HEIGHT_NAME_SHAPE = UILiterals.HEIGHT_NAME_SHAPE,
					 PUFFER_BETWEEN_ELEMENTS = UILiterals.PUFFER_BETWEEN_ELEMENTS,
					 SHADOW_SIZE = UILiterals.SHADOW_SIZE;
	
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
	 * reason messages used in the operation {@link #updateNeeded}
	 */
	public final String REASON_NAME_NULL = "Name of a Natural Type is null.",
						REASON_NAME_OUT_OF_DATE = "Name of a Natural Type is out of date.";
	
	/**
	 * regular expression for a natural type names:
	 * <p>
	 * string of letters and digits, first is no digit (for names)
	 */
	public final String REG_EXP_NAME = "[a-zA-Z_$][a-zA-Z\\d_$]*";
	
	/**
	 * the limit of the suffix for standard names
	 * <p>
	 * This means that if the limit is 10 the following standard names are used:<br>
	 * <em>standardName</em><br>
	 * <em>standardName1</em><br>
	 * <em>...</em><br>
	 * <em>standardName10</em><br>
	 */
	public final int STANDARD_NAMES_COUNTER_LIMIT = 10;
}
