package intraRelationshipConstraints;

import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;
import org.framed.iorm.ui.literals.UILiterals;

public class Literals {
	
	/**
	 * the feature names of intra relationship constraints
	 */
	public final String ACYCLIC_FEATURE_NAME = "Acyclic",
		       			CYCLIC_FEATURE_NAME = "Cyclic",
		       			IRREFLEXIVE_FEATURE_NAME = "Irreflexive",
		       			REFLEXIVE_FEATURE_NAME = "Reflexive",
		       			TOTAL_FEATURE_NAME = "Total";
	
	/**
	 * identifier used for the connection decorators of the intra relationship constraints
	 */
	public final String SHAPE_ID_INTRA_REL_CON_NAME_DECORATOR = "shape_irc_name";
	
	/**
	 * the ids or the path for icons used for palette entry of this feature
	 */		
	public final String	ACYCLIC_ICON_IMG_ID = "org.framed.iorm.ui.modules.intraRelationshipConstraints.acyclic",
						CYCLIC_ICON_IMG_ID = "org.framed.iorm.ui.modules.intraRelationshipConstraints.cyclic",
						IRREFLEXIVE_ICON_IMG_ID = "org.framed.iorm.ui.modules.intraRelationshipConstraints.irreflexive",
						REFLEXIVE_ICON_IMG_ID = "org.framed.iorm.ui.modules.intraRelationshipConstraints.reflexiv",
						TOTAL_ICON_IMG_ID = "org.framed.iorm.ui.modules.intraRelationshipConstraints.total",
						ICON_IMG_PATH = "modules/intraRelationshipConstraints/icon_intrarelationship_constraint.png";
	
	/**
	 * layout integers
	 */
	public final int DISTANCE_FROM_CONNECTION_LINE = UILiterals.DISTANCE_FROM_CONNECTION_LINE,
					 HEIGHT_INTRAREL_CONSTRAINT = UILiterals.HEIGHT_CONSTRAINT,
					 WIDTH_INTRAREL_CONSTRAINT = UILiterals.WIDTH_CONSTRAINT;
	
	/**
	 * color values related to constraints
	 * <p>
	 * the color of constraint texts
	 */
	public final IColorConstant COLOR_CONSTRAINT_TEXT = new ColorConstant(48, 48, 48);
	
}
