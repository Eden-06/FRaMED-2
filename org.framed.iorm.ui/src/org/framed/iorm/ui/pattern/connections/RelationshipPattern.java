package org.framed.iorm.ui.pattern.connections;

import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.CustomContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.util.IColorConstant;
import org.framed.iorm.model.NamedElement;
import org.framed.iorm.model.OrmFactory;
import org.framed.iorm.model.Relation;
import org.framed.iorm.model.Shape;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.graphitifeatures.EditRelationshipFeature;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.literals.LayoutLiterals;
import org.framed.iorm.ui.literals.NameLiterals;
import org.framed.iorm.ui.util.ConnectionPatternUtil;
import org.framed.iorm.ui.util.NameUtil;
import org.framed.iorm.ui.util.PropertyUtil;

/**
 * This graphiti pattern is used to work with {@link Relation}s
 * of the type {@link Type#RELATIONSHIP} in the editor.
 * <p>
 * It deals with the following aspects of Relationships:<br>
 * (1) creating relationships, especially their business object<br>
 * (2) adding relationships to the diagram, especially their pictogram elements<br>
 * @author Kevin Kassin
 */
public class RelationshipPattern extends FRaMEDConnectionPattern {
	
	/**
	 * the name of the feature and the standard name for relationships gathered from {@link NameLiterals}
	 */
	private static final String RELATIONSHIP_FEATURE_NAME = NameLiterals.RELATIONSHIP_FEATURE_NAME,
								STANDARD_RELATIONSHIP_NAME = NameLiterals.STANDARD_RELATIONSHIP_NAME;
	
	/**
	 * the standard value of cardinalities gathered from {@link NameLiterals}
	 */
	private static final String STANDARD_CARDINALITY = NameLiterals.STANDARD_CARDINALITY;
	
	/**
	 * the name of the edit relationship feature gathered from {@link NameLiterals}
	 */
	private String EDIT_RELATIONSHIP_FEATURE_NAME = NameLiterals.EDIT_RELATIONSHIP_FEATURE_NAME;
	
	/**
	 * the identifier for the icon of the create feature gathered from {@link IdentifierLiterals}
	 */
	private static final String IMG_ID_FEATURE_RELATIONSHIP = IdentifierLiterals.IMG_ID_FEATURE_RELATIONSHIP;
	
	/**
	 * values for property shape id of the connection decorators of the relationship
	 */
	private static final String SHAPE_ID_RELATIONSHIP_NAME_DECORATOR = IdentifierLiterals.SHAPE_ID_RELATIONSHIP_NAME_DECORATOR,
			   					SHAPE_ID_RELATIONSHIP_SOURCE_CARDINALITY_DECORATOR = IdentifierLiterals.SHAPE_ID_RELATIONSHIP_SOURCE_CARDINALITY_DECORATOR,
			   					SHAPE_ID_RELATIONSHIP_TARGET_CARDINALITY_DECORATOR = IdentifierLiterals.SHAPE_ID_RELATIONSHIP_TARGET_CARDINALITY_DECORATOR,
			   					SHAPE_ID_RELATIONSHIP_ANCHOR_DECORATOR = IdentifierLiterals.SHAPE_ID_RELATIONSHIP_ANCHOR_DECORATOR;
	
	/**
	 * the color values used for the polyline and the texts of the relationship gathered from {@link LayoutLiterals}
	 */
	private static final IColorConstant COLOR_CONNECTIONS = LayoutLiterals.COLOR_CONNECTIONS,
									    COLOR_TEXT = LayoutLiterals.COLOR_TEXT;
	
	/**
	 * layout integers gathered from {@link LayoutLiterals}
	 */
	private static final int DISTANCE_FROM_CONNECTION_LINE = LayoutLiterals.DISTANCE_FROM_CONNECTION_LINE;
	
	/**
	 * Class constructor
	 */
	public RelationshipPattern() {
		super();
	}
	
	/**
	 * get method for the features name
	 * @return the name of the feature
	 */
	@Override
	public String getCreateName() {
		return RELATIONSHIP_FEATURE_NAME;
	}
	
	/**
	 * get method for the identifier of the icon for the create feature
	 * @return the id of the icon
	 */
	@Override
	public String getCreateImageId() {
		return IMG_ID_FEATURE_RELATIONSHIP;
	}
	
	//add feature
	//~~~~~~~~~~~
	/**
	 * calculates if a relationship can be added to the pictogram diagram
	 * <p>
	 * returns true if the business object is a relationship
	 * @return if a relationship can be added
	 */
	@Override
	public boolean canAdd(IAddContext addContext) {
		if(addContext.getNewObject() instanceof Relation) {
		   Relation relation = (Relation) addContext.getNewObject();
		   if(relation.getType() == Type.RELATIONSHIP) {
			   return true;
		}	}
		return false;
	}
		
	/**
	 * adds the relationship to the pictogram diagram using the following steps:
	 * <p>
	 * Step 1: creates the connection shape and polyline as its graphic algorithm<br>
	 * Step 2: creates a connection decorator for the relationships name<br>
	 * Step 3: creates the connection decorators for the cardinalities<br>
	 * Step 4: creates a connection decorator for the anchor for inter relationship constraints
	 * 		   in the visual model
	 * Step 5: link the pictogram elements and the business objects<br>
	 * Step 6: set the values for the property shape id of all connection decorators
	 * Step 7: adds the anchor for inter relationship constraints in the business model
	 * Step 8: opens the wizard to edit the relationships name and cardinalities
	 * <p>
	 * Relationships have two different anchors attached to them. One for the inter relationship
	 * constraint to hook in the pictogram model. This anchor is used in the operation {@link #add}.
	 * The other is hooked in by inter relationship constraints in business model and is used in the 
	 * operation {@link #create}.
	 */
	@Override
	public PictogramElement add(IAddContext addContext) {
		IAddConnectionContext addConnectionContext = (IAddConnectionContext) addContext;
	    Relation addedRelationship = (Relation) addContext.getNewObject();
	    Anchor sourceAnchor = addConnectionContext.getSourceAnchor();
	    Anchor targetAnchor = addConnectionContext.getTargetAnchor();
	    //Step 1
	    Connection connection = pictogramElementCreateService.createFreeFormConnection(getDiagram());
	    connection.setStart(sourceAnchor);
	    connection.setEnd(targetAnchor);
	    Polyline polyline = graphicAlgorithmService.createPolyline(connection);
	    polyline.setForeground(manageColor(COLOR_CONNECTIONS));
	    polyline.setLineWidth(2);
	    //Step 2
	    ConnectionDecorator connectionDecoratorForName = 
	    	pictogramElementCreateService.createConnectionDecorator(connection, true, 0.5, true);   
	    Text nameText = graphicAlgorithmService.createText(connectionDecoratorForName, addedRelationship.getName());
	    graphicAlgorithmService.setLocation(nameText, DISTANCE_FROM_CONNECTION_LINE, -1*DISTANCE_FROM_CONNECTION_LINE);
	    nameText.setForeground(manageColor(COLOR_TEXT)); 
	    //Step 3
	    ConnectionDecorator connectionDecoratorForSourceLabel = 
	    	pictogramElementCreateService.createConnectionDecorator(connection, true, 0.1, true);
	    Text sourceLabel = graphicAlgorithmService.createText(connectionDecoratorForSourceLabel, addedRelationship.getSourceLabel().getName());
	    graphicAlgorithmService.setLocation(sourceLabel, DISTANCE_FROM_CONNECTION_LINE, -1*DISTANCE_FROM_CONNECTION_LINE);
	    sourceLabel.setForeground(manageColor(COLOR_TEXT));
	    ConnectionDecorator connectionDecoratorForTargetLabel = 
	    	pictogramElementCreateService.createConnectionDecorator(connection, true, 0.9, true);
	    Text targetLabel = graphicAlgorithmService.createText(connectionDecoratorForTargetLabel, addedRelationship.getTargetLabel().getName());
	    graphicAlgorithmService.setLocation(targetLabel, DISTANCE_FROM_CONNECTION_LINE, -1*DISTANCE_FROM_CONNECTION_LINE);
	    targetLabel.setForeground(manageColor(COLOR_TEXT));
	    //Step 4
	    ConnectionDecorator connectionDecoratorForAnchor = 
	    	pictogramElementCreateService.createConnectionDecorator(connection, true, 0.5, true);
	    Rectangle rectangle = graphicAlgorithmService.createRectangle(connectionDecoratorForAnchor);
	    graphicAlgorithmService.setSize(rectangle, 1, 1);
	    pictogramElementCreateService.createChopboxAnchor(connectionDecoratorForAnchor);
	    //Step 5
		link(connection, addedRelationship);
		link(connectionDecoratorForName, addedRelationship);
		link(connectionDecoratorForSourceLabel, addedRelationship);
		link(connectionDecoratorForTargetLabel, addedRelationship);
		link(connectionDecoratorForAnchor, addedRelationship);
		//Step 6
		PropertyUtil.setShape_IdValue(connectionDecoratorForName, SHAPE_ID_RELATIONSHIP_NAME_DECORATOR);
		PropertyUtil.setShape_IdValue(connectionDecoratorForSourceLabel, SHAPE_ID_RELATIONSHIP_SOURCE_CARDINALITY_DECORATOR);
		PropertyUtil.setShape_IdValue(connectionDecoratorForTargetLabel, SHAPE_ID_RELATIONSHIP_TARGET_CARDINALITY_DECORATOR);
		PropertyUtil.setShape_IdValue(connectionDecoratorForAnchor, SHAPE_ID_RELATIONSHIP_ANCHOR_DECORATOR);
		//Step 7
		pictogramElementCreateService.createChopboxAnchor(connection);
		//Step 8
		CustomContext customContext = new CustomContext();
		PictogramElement[] pictogramElement = new PictogramElement[1];
		pictogramElement[0] = connection;
		customContext.setPictogramElements(pictogramElement);
		EditRelationshipFeature editRelationshipFeature = getEditRelationshipFeature(customContext);
		if(editRelationshipFeature.canExecute(customContext))
			editRelationshipFeature.execute(customContext);
		return connection;
	}
	
	private EditRelationshipFeature getEditRelationshipFeature(CustomContext customContext) {
		for(ICustomFeature customFeature : getFeatureProvider().getCustomFeatures(customContext)) {
			if(customFeature.getName().equals(EDIT_RELATIONSHIP_FEATURE_NAME))
				return (EditRelationshipFeature) customFeature;
		}
		return null;
	}
	
	//create feature
	//~~~~~~~~~~~~~~
	/**
	 * calculates if a relationship can be created
	 * <p>
	 * returns true if<br>
	 * (1) target and source shape are not null and<br>
	 * (2) target and source shape is of valid type and<br>
	 * (3) source shapes container and targets shapes container are the same and<br>
	 * (4) target and source shape are of the same type
	 * @return if relationship can be added
	 */
	@Override
	public boolean canCreate(ICreateConnectionContext createContext) {
		Anchor sourceAnchor = createContext.getSourceAnchor();
	    Anchor targetAnchor = createContext.getTargetAnchor();
	    org.framed.iorm.model.ModelElement sourceShape = ConnectionPatternUtil.getModelElementForAnchor(sourceAnchor);
	    org.framed.iorm.model.ModelElement targetShape = ConnectionPatternUtil.getModelElementForAnchor(targetAnchor);
	    if(sourceShape != null && targetShape != null) {
	    	if(sourceShape.getContainer() == targetShape.getContainer()) {
	    		if(sourceShape.getType() == Type.ROLE_TYPE)
		    		if(targetShape.getType() == sourceShape.getType())
		    			return true;
		}	}
		return false;
	}
		 
	/**
	 * checks if a relationship can be started from a given source shape
	 * <p>
	 * returns true if<br>
	 * (1) source shape is not null and<br>
	 * (2) source shape is of valid type 
	 * @return if relationship can be started
	 */
	@Override
	public boolean canStartConnection(ICreateConnectionContext createContext) {
		Anchor sourceAnchor = createContext.getSourceAnchor();
		org.framed.iorm.model.ModelElement sourceShape = ConnectionPatternUtil.getModelElementForAnchor(sourceAnchor);
		if(sourceShape != null){	
			if(sourceShape.getType() == Type.ROLE_TYPE)
				return true;
		}	
		return false;
	}
		  
	/**
	 * creates the business object of a relationship using the following steps:
	 * <p>
	 * Step 1: get source and target shapes<br>
	 * Step 2: get new relationship and add it to the resource of the diagram<br>
	 * Step 3: set source, target, referenced roles and container of inheritance<br>
	 * Step 4: sets the cardinalities of the relationship to the standard value <b>*</b><br>
	 * Step 5: call add operation of this pattern
	 */
	@Override
	public Connection create(ICreateConnectionContext createContext) {
		//Step 1
		Anchor sourceAnchor = createContext.getSourceAnchor();
	    Anchor targetAnchor = createContext.getTargetAnchor();
	    org.framed.iorm.model.ModelElement sourceShape = ConnectionPatternUtil.getModelElementForAnchor(sourceAnchor);
	    org.framed.iorm.model.ModelElement targetShape = ConnectionPatternUtil.getModelElementForAnchor(targetAnchor);
		
		//Step 2
		Relation newRelationship = OrmFactory.eINSTANCE.createRelation();
		String standardName = NameUtil.calculateStandardNameForCompartmentsTypeElement(getDiagram(), Type.RELATIONSHIP, STANDARD_RELATIONSHIP_NAME);
		newRelationship.setName(standardName);
		newRelationship.setType(Type.RELATIONSHIP); 
	    if(newRelationship.eResource() != null) getDiagram().eResource().getContents().add(newRelationship);
	    //Step 3
	    newRelationship.setContainer(sourceShape.getContainer());
	    sourceShape.getContainer().getElements().add(newRelationship);
	    newRelationship.setSource(sourceShape);
	    newRelationship.getReferencedRoles().add((Shape) sourceShape);
	    newRelationship.setTarget(targetShape);
	    newRelationship.getReferencedRoles().add((Shape) targetShape);
	    //Step 4
	    NamedElement sourceLabel = OrmFactory.eINSTANCE.createNamedElement();
	    NamedElement targetLabel = OrmFactory.eINSTANCE.createNamedElement();
	    sourceLabel.setName(STANDARD_CARDINALITY);
	    targetLabel.setName(STANDARD_CARDINALITY);
	    newRelationship.setSourceLabel(sourceLabel);
	    newRelationship.setTargetLabel(targetLabel);
	    //Step 5
	    Connection newConnection = null;
	    AddConnectionContext addContext = new AddConnectionContext(sourceAnchor, targetAnchor);
	    addContext.setNewObject(newRelationship);
		if(canAdd(addContext)) newConnection = (Connection) add(addContext); 	
	    return newConnection;
	}
}
