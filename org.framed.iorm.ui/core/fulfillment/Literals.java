package fulfillment;

import org.eclipse.graphiti.util.IColorConstant;
import org.framed.iorm.ui.literals.UILiterals;

/**
 * This class saves literals in the scope of the fulfillment feature module.
 * @author Kevin Kassin
 */
public class Literals {
	
	/**
	 * the features name used for the palette entry of this feature
	 */
	public final String FEATURE_NAME = "Fulfillment";
						
	/**
	 * the id or the path for icon used for palette entry of this feature
	 */		
	public final String	ICON_IMG_ID = "org.framed.iorm.ui.core.fulfillment",
						ICON_IMG_PATH = "core/fulfillment/icon_fulfillment.png";
	
	/**
	 * identifier used for the connection decorators of the fulfillment relation
	 */
	public final String SHAPE_ID_FULFILLMENT_ARROWHEAD = "shape_fulfillment_arrowhead",
						SHAPE_ID_FULFILLMENT_ROLES = "shape_fulfillment_roles";
	
	/**
	 * layout integers
	 */
	public final int DISTANCE_FROM_CONNECTION_LINE = UILiterals.DISTANCE_FROM_CONNECTION_LINE,
					 FULFILLMENT_ARROWHEAD_LENGTH = UILiterals.ARROWHEAD_LENGTH,
					 FULFILLMENT_ARROWHEAD_HEIGHT = UILiterals.ARROWHEAD_HEIGHT;
	
	/**
	 * the color values for the fulfillment
	 */
	public final IColorConstant COLOR_CONNECTIONS = UILiterals.COLOR_CONNECTIONS,
								COLOR_TEXT = UILiterals.COLOR_TEXT;
	
	//Custom edit feature and dialog
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * the name of the custom edit feature
	 */
	public final String EDIT_FULFILLMENT_FEATURE_NAME = "Edit Fulfillment";
	
	/**
	 * layout integer for wizards
	 * <p>
	 * can be:<br>
	 * (1) the length of the textfield in the role model wizard and role model project wizard or<br>
	 * (2) the height of the dialog to edit fulfillments or<br>
	 * (3) the width of the dialog to edit fulfillments
	 */
	public final int HEIGHT_EDIT_FULFILLMENT_DIALOG = 300,
		  	  	     WIDTH_EDIT_FULFILLMENT_DIALOG = 400;

}
