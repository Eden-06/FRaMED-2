package interRelationshipConstraints;

import org.eclipse.graphiti.util.IColorConstant;
import org.framed.iorm.ui.UILiterals;

public class Literals {

	/**
	 * feature names of the inter relationship constraints
	 */
	public final String RELATIONSHIP_IMPLICATION_FEATURE_NAME = "Relationship Implication",
						RELATIONSHIP_EXCLUSION_FEATURE_NAME = "Relationship Exclusion";
	
	/**
	 * the id or the path for icon used for palette entry of this feature
	 */		
	public final String	RELATIONSHIP_IMPLICATION_ICON_IMG_ID = "org.framed.iorm.ui.modules.intraRelationshipConstraints.relImpl",
						RELATIONSHIP_IMPLICATION_ICON_IMG_PATH = "modules/interRelationshipConstraints/icon_relationship_implication.png",
						RELATIONSHIP_EXCLUSION_ICON_IMG_ID = "org.framed.iorm.ui.modules.intraRelationshipConstraints.relExcl",
						RELATIONSHIP_EXCLUSION_ICON_IMG_PATH = "modules/interRelationshipConstraints/icon_relationship_exclusion.png";
	
	//Layout
	//~~~~~~
	/**
	 * the layout integers used to layout the arrowhead of the inter relationship constraint
	 */
	public final int INTER_REL_ARROWHEAD_LENGTH = UILiterals.ARROWHEAD_LENGTH,
					 INTER_REL_ARROWHEAD_HEIGHT = UILiterals.ARROWHEAD_HEIGHT;
	
	/**
	 * identifier used for role constraint connection decorators
	 */
	public final String SHAPE_ID_INTER_REL_CON = "shape_inter_rel_con";
	
	/**
	 * the color values used for the polyline and the arrowhead of role constraints
	 */
	public final IColorConstant COLOR_INTER_REL_CONNECTIONS = UILiterals.COLOR_CONSTRAINTS,
								COLOR_INTER_REL_ARROWHEAD = UILiterals.COLOR_ARROWHEAD;
}
