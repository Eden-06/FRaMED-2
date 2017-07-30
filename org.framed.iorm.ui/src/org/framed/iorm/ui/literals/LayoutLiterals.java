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
	 * color values related to constraints
	 * <p>
	 * can be:<br>
	 * (1) the color of constraint texts or<br>
	 * (2) the color of constraint connections
	 */
	public static final IColorConstant COLOR_CONSTRAINT_TEXT = IColorConstant.DARK_GRAY,
									   COLOR_CONSTRAINT_CONNECTION = IColorConstant.GRAY;
		
	/**
	 * layout integer for wizards
	 * <p>
	 * can be:<br>
	 * (1) the length of the textfield in the role model wizard and role model project wizard or<br>
	 * (2) the height of the dialog to edit relationships or<br>
	 * (3) the width of the dialog to edit relationships or<br>
	 * (4) the height of the dialog to edit fulfillments or<br>
	 * (5) the width of the dialog to edit fulfillments
	 */
	public static final int LENGHT_TEXTFIELD_WIZARD = 250,
							HEIGHT_EDIT_RELATIONSHIP_DIALOG = 185,
							WIDTH_EDIT_RELATIONSHIP_DIALOG = 400,
						    HEIGHT_EDIT_FULFILLMENT_DIALOG = 300,
						    WIDTH_EDIT_FULFILLMENT_DIALOG = 400;
	
	/**
	 * color values for the feature editor
	 * <p>
	 * can be:<br>
	 * (1) the color for a label showing a valid configuration or<br>
	 * (2) the color for a label showing an invalid configuration
	 */
	public static final Color COLOR_VALID_CONFIGURATION = new Color(Display.getCurrent(), 0, 0, 255),
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
	 * layout integer for role types
	 * <p>
	 * the radius of the rounded corners of role types or<br>
	 */
	public static final int ROLE_CORNER_RADIUS = 2*HEIGHT_NAME_SHAPE;
	
	/**
	 * layout integers for the text of occurrence constraints
	 */
	public static final int HEIGHT_CONSTRAINT = 15,
							WIDTH_CONSTRAINT = 30;
		
	/**
	 * color value for connections
	 * <p>
	 * can be:<br>
	 * (1) the color of the line of a connection or<br>
	 * (2) the color of arrowheads of connections
	 */
	public static final IColorConstant COLOR_CONNECTIONS = IColorConstant.BLACK,
									   COLOR_ARROWHEAD = IColorConstant.WHITE;
	
	/**
	 * layout integers for connections
	 * <p>
	 * can be:<br>
	 * (1) the lenght of the arrowheads of connections or<br>
	 * (2) the height of the arrowheads of connections or<br>
	 * (3) the distance of connection decorators from the connections line
	 */
	public static final int ARROWHEAD_LENGTH = 15,	
							ARROWHEAD_HEIGHT = 10,
						    DISTANCE_FROM_CONNECTION_LINE = 15;
}
