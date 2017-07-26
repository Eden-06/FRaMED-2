package org.framed.iorm.ui.pattern.connections.interrelationship;

import org.eclipse.graphiti.datatypes.ILocation;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.mm.algorithms.Polygon;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.styles.LineStyle;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.framed.iorm.model.Relation;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.literals.NameLiterals;
import org.framed.iorm.ui.util.PropertyUtil;

//TODO
public class RelationshipImplicationConstraintPattern extends AbstractInterRelationshipConstraintPattern {

	/**
	 * the name of the feature gathered from {@link NameLiterals}
	 */
	private final String RELATIONSHIP_IMPLICATION_FEATURE_NAME = NameLiterals.RELATIONSHIP_IMPLICATION_FEATURE_NAME;
		     
	/**
	 * the identifier for the icon of the create feature gathered from {@link IdentifierLiterals}
	 */
	private static final String IMG_ID_FEATURE_RELATIONSHIP_IMPLICATION = IdentifierLiterals.IMG_ID_FEATURE_RELATIONSHIP_IMPLICATION;
	
	/**
	 * Class constructor
	 */
	public RelationshipImplicationConstraintPattern() {
		super();
	}
	
	/**
	 * get method for the features name
	 * @return the name of the feature
	 */
	@Override
	public String getCreateName() {
		return RELATIONSHIP_IMPLICATION_FEATURE_NAME;
	}
	
	/**
	 * get method for the identifier of the icon for the create feature
	 * @return the id of the icon
	 */
	@Override
	public String getCreateImageId() {
		return IMG_ID_FEATURE_RELATIONSHIP_IMPLICATION;
	}
	
	//add feature
	//~~~~~~~~~~~
	/**
	 * uses the super types equivalent operation to calculate if the relationship implications can be added
	 */
	@Override
	public boolean canAdd(IAddContext addContext) {
		return canAddInterRelationshipConstraint(addContext, Type.RELATIONSHIP_IMPLICATION);
	}
	
	/**
	 * adds the role equivalences to the pictogram diagram using the following steps:
	 * <p>
	 * Step 1: create a connection shape and dashed polyline as its graphic algorithm
	 * Step 2: create the connection decorators and arrowheads as their graphics algorithms 
	 * Step 3: link the pictogram elements and the business objects
	 */
	@Override
	public PictogramElement add(IAddContext addContext) {
		IAddConnectionContext addConnectionContext = (IAddConnectionContext) addContext;
	    Relation addedRoleImplication = (Relation) addContext.getNewObject();
	    //TEST
	    Connection sourceConnection = (Connection) addConnectionContext.getSourceAnchor().getParent();
	    Connection targetConnection = (Connection) addConnectionContext.getTargetAnchor().getParent();
	    Anchor graphicalSourceAnchor = null,
	    	   graphicalTargetAnchor = null;
	    for(ConnectionDecorator connectionDecorator : sourceConnection.getConnectionDecorators()) {
	    	if(PropertyUtil.isShape_IdValue(connectionDecorator, SHAPE_ID_RELATIONSHIP_ANCHOR_DECORATOR))
	    		graphicalSourceAnchor = connectionDecorator.getAnchors().get(0);
	    }
	    for(ConnectionDecorator connectionDecorator : targetConnection.getConnectionDecorators()) {
	    	if(PropertyUtil.isShape_IdValue(connectionDecorator, SHAPE_ID_RELATIONSHIP_ANCHOR_DECORATOR))
	    		graphicalTargetAnchor = connectionDecorator.getAnchors().get(0);
	    }
	    if(graphicalSourceAnchor == null || graphicalTargetAnchor == null) return null;
	    //Step 1
	    Connection connection = pictogramElementCreateService.createFreeFormConnection(getDiagram());
	    connection.setStart(graphicalSourceAnchor);
	    connection.setEnd(graphicalTargetAnchor);
	    Polyline polyline = graphicAlgorithmService.createPolyline(connection);
	    polyline.setForeground(manageColor(COLOR_CONNECTIONS));
	    polyline.setLineStyle(LineStyle.DASH);
	    polyline.setLineWidth(2);
	    //Step2
	    ConnectionDecorator connectionDecorator;
	    connectionDecorator = pictogramElementCreateService.createConnectionDecorator(connection, false, 1.0, true);
	    int points[] = new int[] { -1*ARROWHEAD_LENGTH, ARROWHEAD_HEIGHT, 		//Point 1
	    						   0, 0, 										//P2
	    						   -1*ARROWHEAD_LENGTH, -1*ARROWHEAD_HEIGHT };	//P3						 
	    Polygon arrowhead = graphicAlgorithmService.createPolygon(connectionDecorator, points);
	    arrowhead.setForeground(manageColor(COLOR_CONNECTIONS));
	    arrowhead.setBackground(manageColor(COLOR_ARROWHEAD));
	    PropertyUtil.setShape_IdValue(connectionDecorator, SHAPE_ID_INTER_REL_CON);
	    //Step 3
	    link(connection, addedRoleImplication);
	    return connection;
	}
	
	//create feature
	//~~~~~~~~~~~~~~  
	/**
	 * uses the super types equivalent operation to create the relationship implications
	 */
	@Override
	public Connection create(ICreateConnectionContext createContext) {
		return super.createInterRelationshipConstraint(createContext, Type.RELATIONSHIP_IMPLICATION, this);
	}
}
