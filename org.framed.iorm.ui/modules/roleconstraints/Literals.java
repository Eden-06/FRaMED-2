package roleconstraints;

import org.eclipse.graphiti.util.IColorConstant;
import org.framed.iorm.ui.literals.UILiterals;

public class Literals {

	/**
	 * the feature names of the role constraints
	 */
	public final String ROLEIMPLICATION_FEATURE_NAME = "Role Implication",
			   			ROLEEQUIVALENCE_FEATURE_NAME = "Role Eqivalence",
			   			ROLEPROHIBITION_FEATURE_NAME = "Role Prohibition";
	
	/**
	 * the id or the path for icon used for palette entry of this feature
	 */		
	public final String	ROLEIMPLICATION_ICON_IMG_ID = "org.framed.iorm.ui.modules.roleconstraints.roleimplication",
						ROLEIMPLICATION_ICON_IMG_PATH = "modules/roleconstraints/icon_roleimplication.png",
						ROLEEQUIVALENCE_ICON_IMG_ID = "org.framed.iorm.ui.modules.roleconstraint.roleequivalence",
						ROLEEQUIVALENCE_ICON_IMG_PATH = "modules/roleconstraints/icon_roleequivalence.png",
						ROLEPROHIBITION_ICON_IMG_ID = "org.framed.iorm.ui.modules.roleconstraints.roleprohibtion",
						ROLEPROHIBITION_ICON_IMG_PATH = "modules/roleconstraints/icon_roleprohibition.png";
	
	/**
	 * identifier used for role constraint connection decorators
	 */
	public final String SHAPE_ID_ROLE_CONSTRAINT_DECORATOR = "shape_rc_decorator";
	
	//Layout
	//~~~~~~
	/**
	 * the layout integers used to layout the arrowhead of the role constraints
	 */
	public final int ROLECONSTRAINT_ARROWHEAD_LENGTH = UILiterals.ARROWHEAD_LENGTH,
					 ROLECONSTRAINT_ARROWHEAD_HEIGHT = UILiterals.ARROWHEAD_HEIGHT;
	
	/**
	 * the color values used for the polyline and the arrowhead of role constraints
	 */
	public final IColorConstant COLOR_CONNECTIONS = UILiterals.COLOR_CONNECTIONS,
								COLOR_ARROWHEAD = UILiterals.COLOR_ARROWHEAD;
}
