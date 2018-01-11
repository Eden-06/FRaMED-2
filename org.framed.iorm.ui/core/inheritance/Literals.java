package inheritance;

import org.eclipse.graphiti.util.IColorConstant;
import org.framed.iorm.ui.UILiterals;

/**
 * This class saves literals in the scope of the inheritance feature module.
 * @author Kevin Kassin
 */
public class Literals {

	/**
	 * the features name used for the palette entry of this feature
	 */
	public final String FEATURE_NAME = "Inheritance";
						
	/**
	 * the id or the path for icon used for palette entry of this feature
	 */		
	public final String	ICON_IMG_ID = "org.framed.iorm.ui.core.inheritance",
						ICON_IMG_PATH = "core/inheritance/icon_inheritance.png";
	
	/**
	 * identifier used for the connection decorator of the inheritance relation
	 */
	public final String SHAPE_ID_INHERITANCE_DECORATOR = "shape_inheritance_decorator";
	
	/**
	 * the layout integers used to layout the arrowhead of the inheritances
	 */
	public final int INHERITANCE_ARROWHEAD_LENGTH = UILiterals.ARROWHEAD_LENGTH,
					 INHERITANCE_ARROWHEAD_HEIGHT = UILiterals.ARROWHEAD_HEIGHT;
	
	/**
	 * the color values used for the polyline and the arrowhead of inheritances
	 */
	public final IColorConstant COLOR_CONNECTIONS = UILiterals.COLOR_CONNECTIONS,
								COLOR_INHERITANCE_ARROWHEAD = UILiterals.COLOR_ARROWHEAD;	
}
