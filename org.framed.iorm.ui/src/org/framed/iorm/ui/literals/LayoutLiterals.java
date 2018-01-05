package org.framed.iorm.ui.literals;

/**
 * This class saves severals static layout integers and color values used for layouting.
 * @author Kevin Kassin
 */
public class LayoutLiterals {

	
		
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
	public static final int LENGHT_TEXTFIELD_WIZARD = 250;
		
	/**
	 * layout integer for groups
	 * <p>
	 * can be:<br>
	 * (1) the radius of the rounded corners of groups or<br>
	 * (2) the height of the 
	 */
	public static final int GROUP_CORNER_RADIUS = 2*UILiterals.HEIGHT_NAME_SHAPE,
							HEIGHT_ELEMENT_SHAPE = 15;
	
	/**
	 * layout integers for the text of occurrence constraints
	 */
	public static final int HEIGHT_CONSTRAINT = 15,
							WIDTH_CONSTRAINT = 30;
			
	/**
	 * layout integers for connections
	 * <p>
	 * can be:<br>
	 * (1) the lenght of the arrowheads of connections or<br>
	 * (2) the height of the arrowheads of connections or<br>
	 * (3) the distance of connection decorators from the connections line
	 */
	public static final int DISTANCE_FROM_CONNECTION_LINE = 15;
}
