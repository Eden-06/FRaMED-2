package compartment;

import org.eclipse.graphiti.util.IColorConstant;
import org.framed.iorm.ui.UILiterals;
import org.framed.iorm.ui.palette.PaletteView;

public class Literals {
	
	/**
	 * the features names used for the palette entry of this feature
	 */
	public final String FEATURE_NAME = "Compartment Type",
						ELEMENTS_FEATURE_NAME = "CompartmentTypeElementPattern";
	
	/**
	 * the standard name for a pictogramm element and business object created by the feature
	 */
	public final String STANDARD_NAME = "compartmentType";
						
	/**
	 * the ids or the paths for icon used for palette entry of this feature
	 */		
	public final String	ICON_IMG_ID = "org.framed.iorm.ui.modules.compartment",
						ELEMENTS_ICON_IMG_ID = "org.framed.iorm.ui.modules.compartmentElements",
						ICON_IMG_PATH = "modules/compartment/icon_compartmenttype.png";
	
	/**
	 * the kind of diagram this module's pattern creates
	 */
	public final String DIAGRAM_KIND = "compartment_diagram";
	
	/**
	 * the palette view of this module's patterns
	 */
	public final PaletteView paletteView = PaletteView.COMPARTMENT_VIEW; 
	
	/**
	 * identifiers used for compartment types
	 * <p>
	 * can be for:<br>
	 * (1) the container shape or<br>
	 * (2) type body shape or<br>
	 * (3) drop shadow shape or<br>
	 * (4) name shape or<br>
	 * (5) first line shape or<br>
	 * (6) second line shape or<br>
	 * (7) third line shape or<br>
	 * (8) attribute container shape or<br>
	 * (9) operation container shape or<br>
	 * (10) content preview segment or<br>
	 * (11) the elements in the content preview segment or<br>
	 * (12) the dot elements that indicate some elements are not shown in the preview
	 */
	public final String SHAPE_ID_COMPARTMENTTYPE_CONTAINER = "shape_ct_container",
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
	 * messages used as direct editing tips
	 */
	public final String DIRECTEDITING_COMPARTMENTTYPE = "A compartment types name cant be empty or contain spaces. Numbers are allowed but not as first symbol.",
						NAME_ALREADY_USED_COMPARTMENTTYPE = "Another compartment type already has the same name!";
	
	/**
	 * reason messages used in the <em>updateNeeded</em> operations of the shape pattern
	 */
	public final String REASON_NAME_NULL = "Name is null.",
						REASON_NAME_OUT_OF_DATE = "Name is out of date.",
						REASON_AMOUNT_ELEMENTS = "Different amount of elements.",
						REASON_NAMES_ELEMENTS = "Different names of elements.";	
	
	/**
	 * integers used to layout this features pictogramm elements 
	 */
	public final int MIN_WIDTH = UILiterals.MIN_WIDTH_FOR_CLASS_OR_ROLE, 
					 MIN_HEIGHT = UILiterals.MIN_HEIGHT_FOR_CLASS_OR_ROLE,
					 HEIGHT_NAME_SHAPE = UILiterals.HEIGHT_NAME_SHAPE,
					 PUFFER_BETWEEN_ELEMENTS = UILiterals.PUFFER_BETWEEN_ELEMENTS,
					 SHADOW_SIZE = UILiterals.SHADOW_SIZE,
					 HEIGHT_COMPARTMENT_ELEMENT_SHAPE = UILiterals.HEIGHT_ELEMENT_SHAPE;

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
