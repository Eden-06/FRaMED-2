package datatype;

import org.eclipse.graphiti.util.IColorConstant;
import org.framed.iorm.ui.literals.TextLiterals;
import org.framed.iorm.ui.literals.UILiterals;

public class Literals {

	/**
	 * the features name used for the palette entry of this feature
	 */
	public final String FEATURE_NAME = "Data Type";
	
	/**
	 * the standart name for a pictogramm element and business object created by the feature
	 */
	public final String STANDARD_NAME = "dataType";
						
	/**
	 * the id or the path for icon used for palette entry of this feature
	 */		
	public final String	ICON_IMG_ID = "org.framed.iorm.ui.modules.datatype",
						ICON_IMG_PATH = "modules/datatype/icon_datatype.png";
	
	/**
	 * messages used as direct editing tips
	 */
	public final String DIRECTEDITING_DATATYPE = "A data types name cant be empty and cant contains spaces. Numbers are allowed but not as first symbol.",
			   			NAME_ALREADY_USED_DATATYPE = "Another data type already has the same name!";
	
	/**
	 * identifiers used for this feature
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
	public final String SHAPE_ID_DATATYPE_CONTAINER = "shape_dt_container",
						SHAPE_ID_DATATYPE_TYPEBODY = "shape_dt_typebody",
					    SHAPE_ID_DATATYPE_SHADOW = "shape_dt_shadow",
				 	   	SHAPE_ID_DATATYPE_NAME = "shape_dt_name", 
						SHAPE_ID_DATATYPE_FIRSTLINE = "shape_dt_firstline",
						SHAPE_ID_DATATYPE_SECONDLINE = "shape_dt_secondline", 
						SHAPE_ID_DATATYPE_ATTRIBUTECONTAINER = "shape_dt_attcontainer",
						SHAPE_ID_DATATYPE_OPERATIONCONTAINER = "shape_dt_opcontainer";

	/**
	 * integers used to layout this features pictogramm elements 
	 */
	public final int MIN_WIDTH = UILiterals.MIN_WIDTH_FOR_CLASS_OR_ROLE, 
					 MIN_HEIGHT = UILiterals.MIN_HEIGHT_FOR_CLASS_OR_ROLE,
					 HEIGHT_NAME_SHAPE = UILiterals.HEIGHT_NAME_SHAPE,
					 HEIGHT_ATTRITBUTE_SHAPE = UILiterals.HEIGHT_ATTRITBUTE_SHAPE,
					 HEIGHT_OPERATION_SHAPE = UILiterals.HEIGHT_OPERATION_SHAPE,
					 DATATYPE_CORNER_SIZE = HEIGHT_NAME_SHAPE,
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
	 * reason messages used in the operation {@link #updateNeeded} gathered from {@link TextLiterals}
	 */
	public final String REASON_NAME_NULL = "Name of a Data Type is null.",
						REASON_NAME_OUT_OF_DATE = "Name of a Data Type is out of date.",
					 	REASON_AMOUNT_ATTRIBUTES = TextLiterals.REASON_AMOUNT_ATTRIBUTES,
					 	REASON_AMOUNT_OPERATION = TextLiterals.REASON_AMOUNT_OPERATION,
					 	REASON_NAMES_ATTRIBUTES = TextLiterals.REASON_NAMES_ATTRIBUTES,
					 	REASON_NAMES_OPERATIONS = TextLiterals.REASON_NAMES_OPERATIONS;
	
	/**
	 * regular expression for a data types names:
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
