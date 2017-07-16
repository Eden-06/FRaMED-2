package org.framed.iorm.ui.literals;

import org.eclipse.graphiti.util.IColorConstant;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

/**
 * This class saves severals static layout integers and color values used for layouting.
 * @author Kevin Kassin
 */
public class LayoutLiterals {

	/**
	 * general layout integers
	 * <p>
	 * can be:<br>
	 * (1) the puffer space between elements or<br>
	 * (2) the size of the shadows of graphiti shapes
	 */
	public static final int PUFFER_BETWEEN_ELEMENTS = 3,
							SHADOW_SIZE = 3;
	
	/**
	 * general color values
	 * <p>
	 * can be:<br>
	 * (1) the color of text or<br>
	 * (2) the color of lines or<br>
	 * (3) the color of backgrounds or<br>
	 * (4) the color of graphiti shapes shadows
	 */
	public static final IColorConstant COLOR_TEXT = IColorConstant.BLACK,
			   						   COLOR_LINES = IColorConstant.BLACK,
			   						   COLOR_BACKGROUND = IColorConstant.WHITE,
			   						   COLOR_SHADOW = IColorConstant.GRAY;
		
	/**
	 * layout integer for wizard
	 * <p>
	 * the length of the textfield in the role model wizard and role model project wizard
	 */
	public static final int LENGHT_TEXTFIELD_WIZARD = 250;
	
	/**
	 * color values for the feature editor
	 * <p>
	 * can be:<br>
	 * (1) the color for a label showing a valid configuration or<br>
	 * (2) the color for a label showing an invalid configuration
	 */
	public static Color COLOR_VALID_CONFIGURATION = new Color(Display.getCurrent(), 0, 0, 255),
						COLOR_INVALID_CONFIGURATION = new Color(Display.getCurrent(), 255, 0, 0);
	
	/**
	 * layout integers for graphiti shapes 
	 * <p>
	 * can be:<br>
	 * (1) the height of the name rectangle or<br>
	 * (2) the height of the attribute rectangle or<br>
	 * (3) the height of the operation rectangle or<br>
	 * (4) the minimal width for typebody rectangles of classes or roles or<br>
	 * (5) the minimal height for typebody rectangles of classes or roles 
	 */
	public static final int HEIGHT_NAME_SHAPE = 20,
							HEIGHT_ATTRITBUTE_SHAPE = 15,
							HEIGHT_OPERATION_SHAPE = 15,
							MIN_WIDTH_FOR_CLASS_OR_ROLE = 200,
							MIN_HEIGHT_FOR_CLASS_OR_ROLE = 100;
	
	/**
	 * layout integer for data types
	 * <p>
	 * the size of the corners of a data type
	 */
	public static final int DATATYPE_CORNER_SIZE = HEIGHT_NAME_SHAPE;
	
	/**
	 * layout integer for groups
	 * <p>
	 * can be:<br>
	 * (1) the radius of the rounded corners of groups or<br>
	 * (2) the height of the 
	 */
	public static final int GROUP_CORNER_RADIUS = 2*HEIGHT_NAME_SHAPE,
							HEIGHT_ELEMENT_SHAPE = 15;
	
	/**
	 * color value for connections
	 * <p>
	 * the color of the line of a connection
	 */
	public static final IColorConstant COLOR_CONNECTIONS = IColorConstant.BLACK;
	
	/**
	 * layout integers for inhertances
	 * <p>
	 * can be:<br>
	 * (1) the length of the arrowhead of an inheritance
	 * (2) the height of the arrowhead of an inheritance 
	 */
	public static final int INHERITANCE_ARROWHEAD_LENGTH = 15,	
							INHERITANCE_ARROWHEAD_HEIGHT = 10;
	
	/**
	 * color values for inheritances
	 * <p>
	 * the color of the inner place of the arrowhead of an inheritance
	 */
	public static final IColorConstant COLOR_INHERITANCE_ARROWHEAD = IColorConstant.WHITE;
	
}
