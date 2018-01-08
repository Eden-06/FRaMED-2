package interRelationshipConstraints;

import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.mm.algorithms.Polygon;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.framed.iorm.model.Relation;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.util.UIUtil;

/**
 * This graphiti pattern is used to work with {@link Relation}s
 *	of the type {@link Type#RELATIONSHIP_IMPLICATION} in the editor.
 * <p>
 * It deals with the following aspects of implication inter relationship constraints:<br>
 * (1) creating the constraints, especially their business object<br>
 * (2) adding the constraints to the diagram, especially their pictogram elements<br>
 * <p>
 * It is a subclass of {@link AbstractInterRelationshipConstraintPattern} and several operations used here are implemented there.
 * @author Kevin Kassin
 */
public class RelationshipImplicationConstraintPattern extends AbstractInterRelationshipConstraintPattern {
		     
	/**
	 * Class constructor
	 */
	public RelationshipImplicationConstraintPattern() {
		super();
		FEATURE_NAME = literals.RELATIONSHIP_IMPLICATION_FEATURE_NAME;
		ICON_IMG_ID = literals.RELATIONSHIP_IMPLICATION_ICON_IMG_ID;
		ICON_IMG_PATH = literals.RELATIONSHIP_IMPLICATION_ICON_IMG_PATH;
		modelType = Type.RELATIONSHIP_IMPLICATION;
	}
	
	//add feature
	//~~~~~~~~~~~
	/**
	 * uses the super types equivalent operation to calculate if the relationship implication can be added
	 */
	@Override
	public boolean canAdd(IAddContext addContext) {
		return canAddInterRelationshipConstraint(addContext, Type.RELATIONSHIP_IMPLICATION);
	}
	
	/**
	 * adds the role equivalences to the pictogram diagram using the following steps:
	 * <p>
	 * Step 1: get anchors used to hook in the inter relationship constraint for the pictogram model<br> 
	 * Step 2: create a connection shape and dashed polyline as its graphic algorithm<br>
	 * Step 3: create the connection decorator and an arrowhead as their graphics algorithms<br>
	 * Step 4: link the pictogram elements and the business objects<br>
	 * <p>
	 * Step 1 and 2 are executed by the operation 
	 * {@link AbstractInterRelationshipConstraintPattern#addConnectionForInterRelationshipConstraint}.
	 */
	@Override
	public PictogramElement add(IAddContext addContext) {
		Relation addedRoleImplication = (Relation) addContext.getNewObject();
	    //Step 1 and 2
		Connection connection = addConnectionForInterRelationshipConstraint(addContext);
		if(connection == null) return null;
		//Step 3
	    ConnectionDecorator connectionDecorator;
	    connectionDecorator = pictogramElementCreateService.createConnectionDecorator(connection, false, 1.0, true);
	    int points[] = new int[] { -1*literals.INTER_REL_ARROWHEAD_LENGTH, literals.INTER_REL_ARROWHEAD_HEIGHT, 		//Point 1
	    						   0, 0, 										//P2
	    						   -1*literals.INTER_REL_ARROWHEAD_LENGTH, -1*literals.INTER_REL_ARROWHEAD_HEIGHT };	//P3						 
	    Polygon arrowhead = graphicAlgorithmService.createPolygon(connectionDecorator, points);
	    arrowhead.setForeground(manageColor(literals.COLOR_INTER_REL_CONNECTIONS));
	    arrowhead.setBackground(manageColor(literals.COLOR_INTER_REL_ARROWHEAD));
	    UIUtil.setShape_IdValue(connectionDecorator, literals.SHAPE_ID_INTER_REL_CON);
	    //Step 4
	    link(connection, addedRoleImplication);
	    return connection;
	}
	
	//create feature
	//~~~~~~~~~~~~~~  
	/**
	 * uses the super types equivalent operation to create the relationship implication
	 */
	@Override
	public Connection create(ICreateConnectionContext createContext) {
		return super.createInterRelationshipConstraint(createContext, Type.RELATIONSHIP_IMPLICATION, this);
	}
}
