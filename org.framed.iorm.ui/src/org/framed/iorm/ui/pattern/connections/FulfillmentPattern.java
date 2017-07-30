package org.framed.iorm.ui.pattern.connections;

import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.CustomContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.algorithms.Polygon;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.util.IColorConstant;
import org.framed.iorm.model.OrmFactory;
import org.framed.iorm.model.Relation;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.graphitifeatures.EditFulfillmentFeature;
import org.framed.iorm.ui.graphitifeatures.EditRelationshipFeature;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.literals.LayoutLiterals;
import org.framed.iorm.ui.literals.NameLiterals;
import org.framed.iorm.ui.util.ConnectionPatternUtil;
import org.framed.iorm.ui.util.GeneralUtil;
import org.framed.iorm.ui.util.PropertyUtil;

/**
 * This graphiti pattern is used to work with {@link Relation}s
 * of the type {@link Type#FULFILLMENT} in the editor.
 * <p>
 * It deals with the following aspects of fulfillments:<br>
 * (1) creating fulfillments, especially their business object<br>
 * (2) adding fulfillments to the diagram, especially their pictogram elements<br>
 * @author Kevin Kassin
 */
public class FulfillmentPattern extends FRaMEDConnectionPattern {
	
	/**
	 * the name of the feature gathered from {@link NameLiterals}
	 */
	private static final String FULFILLMENT_FEATURE_NAME = NameLiterals.FULFILLMENT_FEATURE_NAME;
	
	/**
	 * the name of the edit relationship feature gathered from {@link NameLiterals}
	 */
	private final String EDIT_FULFILLMENT_FEATURE_NAME = NameLiterals.EDIT_FULFILLMENT_FEATURE_NAME;
	
	/**
	 * the identifier for the icon of the create feature gathered from {@link IdentifierLiterals}
	 */
	private static final String IMG_ID_FEATURE_FULFILLMENT = IdentifierLiterals.IMG_ID_FEATURE_FULFILLMENT;
	
	/**
	 * the value for the property shape id  for the connection decorator of the inheritance
	 */
	private static final String SHAPE_ID_FULFILLMENT_ARROWHEAD = IdentifierLiterals.SHAPE_ID_FULFILLMENT_ARROWHEAD,
								SHAPE_ID_FULFILLMENT_ROLES = IdentifierLiterals.SHAPE_ID_FULFILLMENT_ROLES;
	
	/**
	 * layout integers gathered from {@link LayoutLiterals}
	 */
	private static final int DISTANCE_FROM_CONNECTION_LINE = LayoutLiterals.DISTANCE_FROM_CONNECTION_LINE,
							 FULFILLMENT_ARROWHEAD_LENGTH = LayoutLiterals.ARROWHEAD_LENGTH,
							 FULFILLMENT_ARROWHEAD_HEIGHT = LayoutLiterals.ARROWHEAD_HEIGHT;
							 
	/**
	 * the color values gathered from {@link LayoutLiterals}
	 */
	private static final IColorConstant COLOR_CONNECTIONS = LayoutLiterals.COLOR_CONNECTIONS,
										COLOR_TEXT = LayoutLiterals.COLOR_TEXT;

	/**
	 * Class constructor
	 */
	public FulfillmentPattern() {
		super();
	}
	
	/**
	 * get method for the features name
	 * @return the name of the feature
	 */
	@Override
	public String getCreateName() {
		return FULFILLMENT_FEATURE_NAME;
	}
	
	/**
	 * get method for the identifier of the icon for the create feature
	 * @return the id of the icon
	 */
	@Override
	public String getCreateImageId() {
		return IMG_ID_FEATURE_FULFILLMENT;
	}
	
	//add feature
	//~~~~~~~~~~~
	/**
	 * calculates if a fulfillment can be added to the pictogram diagram
	 * <p>
	 * returns true if the business object is a fulfillment
	 * @return if a fulfillment can be added
	 */
	@Override
	public boolean canAdd(IAddContext addContext) {
		if(addContext.getNewObject() instanceof Relation) {
		   Relation relation = (Relation) addContext.getNewObject();
		   if(relation.getType() == Type.FULFILLMENT)
			   return true;
		}
		return false;
	}
		
	/**
	 * adds the fulfillment to the pictogram diagram using the following steps:
	 * <p>
	 * Step 1: create a connection shape and polyline as its graphic algorithm<br>
	 * Step 2: create the a connection decorator and a arrowhead as its graphic algorithm<br>
	 * Step 3: create the connection decorator for the fulfilled roles<br>
	 * Step 4: link the pictogram elements and the business objects<br>
	 * Step 5: opens the wizard to edit the fulfillments referenced roles
	 */
	@Override
	public PictogramElement add(IAddContext addContext) {
		IAddConnectionContext addConnectionContext = (IAddConnectionContext) addContext;
	    Relation addedFulfillment = (Relation) addContext.getNewObject();
	    Anchor sourceAnchor = addConnectionContext.getSourceAnchor();
	    Anchor targetAnchor = addConnectionContext.getTargetAnchor();
	    //Step 1
	    Connection connection = pictogramElementCreateService.createFreeFormConnection(getDiagram());
	    connection.setStart(sourceAnchor);
	    connection.setEnd(targetAnchor);
	    Polyline polyline = graphicAlgorithmService.createPolyline(connection);
	    polyline.setForeground(manageColor(COLOR_CONNECTIONS));
	    polyline.setLineWidth(2);
		//Step2
		ConnectionDecorator arrowheadShape = pictogramElementCreateService.createConnectionDecorator(connection, false, 1.0, true);
		int points[] = new int[] { -1*FULFILLMENT_ARROWHEAD_LENGTH, FULFILLMENT_ARROWHEAD_HEIGHT, 		//Point 1
		    						0, 0, 																//P2
		    						-1*FULFILLMENT_ARROWHEAD_LENGTH, -1*FULFILLMENT_ARROWHEAD_HEIGHT };	//P3						 
		Polygon arrowhead = graphicAlgorithmService.createPolygon(arrowheadShape, points);
		arrowhead.setForeground(manageColor(COLOR_CONNECTIONS));
		arrowhead.setBackground(manageColor(COLOR_CONNECTIONS));
		PropertyUtil.setShape_IdValue(arrowheadShape, SHAPE_ID_FULFILLMENT_ARROWHEAD);
		//Step 3
		ConnectionDecorator rolesShape = pictogramElementCreateService.createConnectionDecorator(connection, true, 0.9, true);
		Text roles = graphicAlgorithmService.createText(rolesShape, "TEST");
		graphicAlgorithmService.setLocation(roles, DISTANCE_FROM_CONNECTION_LINE, -1*DISTANCE_FROM_CONNECTION_LINE);
		roles.setForeground(manageColor(COLOR_TEXT));
		PropertyUtil.setShape_IdValue(rolesShape, SHAPE_ID_FULFILLMENT_ROLES);
		//Step 4
		link(connection, addedFulfillment);
		link(arrowheadShape, addedFulfillment);
		link(rolesShape, addedFulfillment);
		//Step 5
		CustomContext customContext = new CustomContext();
		PictogramElement[] pictogramElement = new PictogramElement[1];
		pictogramElement[0] = connection;
		customContext.setPictogramElements(pictogramElement);
		ICustomFeature[] customFeatures = getFeatureProvider().getCustomFeatures(customContext);
		EditFulfillmentFeature editFulfillmentFeature = 
			(EditFulfillmentFeature) GeneralUtil.findFeatureByName(customFeatures, EDIT_FULFILLMENT_FEATURE_NAME);
		if(editFulfillmentFeature.canExecute(customContext))
			editFulfillmentFeature.execute(customContext);
		return connection;
	}
	
	//create feature
	//~~~~~~~~~~~~~~
	/**
	 * calculates if a fulfillment can be created
	 * <p>
	 * returns true if<br>
	 * (1) target and source shape are not null and<br>
	 * (2) target and source shape are of valid types and<br>
	 * (3) source shapes container and targets shapes container are the same and<br>
	 * @return if fulfillment can be added
	 */
	@Override
	public boolean canCreate(ICreateConnectionContext createContext) {
		Anchor sourceAnchor = createContext.getSourceAnchor();
	    Anchor targetAnchor = createContext.getTargetAnchor();
	    org.framed.iorm.model.ModelElement sourceShape = ConnectionPatternUtil.getModelElementForAnchor(sourceAnchor);
	    org.framed.iorm.model.ModelElement targetShape = ConnectionPatternUtil.getModelElementForAnchor(targetAnchor);
	    if(sourceShape != null && targetShape != null) {
	    	if(sourceShape.getContainer() == targetShape.getContainer()) {
	    		if(sourceShape.getType() == Type.NATURAL_TYPE ||
	    		   sourceShape.getType() == Type.DATA_TYPE ||
	    		   sourceShape.getType() == Type.COMPARTMENT_TYPE)
	    			if(targetShape.getType() == Type.COMPARTMENT_TYPE)
	    				return true;
	    }	}
	    return false;
	}
		 
	/**
	 * checks if a fulfillment can be started from a given source shape
	 * <p>
	 * returns true if<br>
	 * (1) source shape is not null and<br>
	 * (2) source shape is of valid type 
	 * @return if fulfillment can be started
	 */
	@Override
	public boolean canStartConnection(ICreateConnectionContext createContext) {
		Anchor sourceAnchor = createContext.getSourceAnchor();
		org.framed.iorm.model.ModelElement sourceShape = ConnectionPatternUtil.getModelElementForAnchor(sourceAnchor);
		if(sourceShape != null){	
			if(sourceShape.getType() == Type.NATURAL_TYPE || 
			   sourceShape.getType() == Type.DATA_TYPE ||
			   sourceShape.getType() == Type.COMPARTMENT_TYPE)
				return true;
		}	
		return false;
	}
		  
	/**
	 * creates the business object of a fulfillment using the following steps:
	 * <p>
	 * Step 1: get source and target shapes<br>
	 * Step 2: get new inheritance and add it to the resource of the diagram<br>
	 * Step 3: set source, target, referenced roles and container of the fulfillment<br>
	 * Step 4: call add operation of this pattern
	 */
	@Override
	public Connection create(ICreateConnectionContext createContext) {
		//Step 1
		Anchor sourceAnchor = createContext.getSourceAnchor();
	    Anchor targetAnchor = createContext.getTargetAnchor();
	    org.framed.iorm.model.ModelElement sourceShape = ConnectionPatternUtil.getModelElementForAnchor(sourceAnchor);
	    org.framed.iorm.model.ModelElement targetShape = ConnectionPatternUtil.getModelElementForAnchor(targetAnchor);
		//Step 2
		Relation newFulfillment = OrmFactory.eINSTANCE.createRelation();
		newFulfillment.setType(Type.FULFILLMENT); 
		if(newFulfillment.eResource() != null) getDiagram().eResource().getContents().add(newFulfillment);
		//Step 3
		newFulfillment.setContainer(sourceShape.getContainer());
		sourceShape.getContainer().getElements().add(newFulfillment);
		newFulfillment.setSource(sourceShape);
		newFulfillment.setTarget(targetShape);
		//Step 4
		AddConnectionContext addContext = new AddConnectionContext(sourceAnchor, targetAnchor);
		addContext.setNewObject(newFulfillment);
		Connection newConnection = null;
		if(canAdd(addContext)) newConnection = (Connection) add(addContext); 	        
		return newConnection;
	}
}
