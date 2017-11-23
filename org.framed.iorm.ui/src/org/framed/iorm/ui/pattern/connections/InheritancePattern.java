package org.framed.iorm.ui.pattern.connections;

import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.mm.algorithms.Polygon;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.util.IColorConstant;
import org.framed.iorm.model.ModelElement;
import org.framed.iorm.model.OrmFactory;
import org.framed.iorm.model.Relation;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.editPolicy.EditPolicyHandler;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.literals.LayoutLiterals;
import org.framed.iorm.ui.literals.NameLiterals;
import org.framed.iorm.ui.util.ConnectionPatternUtil;
import org.framed.iorm.ui.util.PropertyUtil;

/**
 * This graphiti pattern is used to work with {@link Relation}s
 * of the type {@link Type#INHERITANCE} in the editor.
 * <p>
 * It deals with the following aspects of Inheritances:<br>
 * (1) creating inheritances, especially their business object<br>
 * (2) adding inheritances to the diagram, especially their pictogram elements<br>
 * @author Kevin Kassin
 */
public class InheritancePattern extends FRaMEDConnectionPattern {
	
	/**
	 * the name of the feature gathered from {@link NameLiterals}
	 */
	private static final String INHERITANCE_FEATURE_NAME = NameLiterals.INHERITANCE_FEATURE_NAME;
	
	/**
	 * the identifier for the icon of the create feature gathered from {@link IdentifierLiterals}
	 */
	private static final String IMG_ID_FEATURE_INHERITANCE = IdentifierLiterals.IMG_ID_FEATURE_INHERITANCE;
	
	/**
	 * the value for the property shape id for the connection decorator of the inheritance
	 */
	private static final String SHAPE_ID_INHERITANCE_DECORATOR = IdentifierLiterals.SHAPE_ID_INHERITANCE_DECORATOR;
	
	/**
	 * the layout integers used to layout the arrowhead of the inheritances gathered from {@link LayoutLiterals}
	 */
	private static final int INHERITANCE_ARROWHEAD_LENGTH = LayoutLiterals.ARROWHEAD_LENGTH,
							 INHERITANCE_ARROWHEAD_HEIGHT = LayoutLiterals.ARROWHEAD_HEIGHT;
							 
	/**
	 * the color values used for the polyline and the arrowhead of inheritances gathered from {@link LayoutLiterals}
	 */
	private static final IColorConstant COLOR_CONNECTIONS = LayoutLiterals.COLOR_CONNECTIONS,
										COLOR_INHERITANCE_ARROWHEAD = LayoutLiterals.COLOR_ARROWHEAD;		
	
	/**
	 * Class constructor
	 */
	public InheritancePattern() {
		super();
	}
	
	/**
	 * get method for the features name
	 * @return the name of the feature
	 */
	@Override
	public String getCreateName() {
		return INHERITANCE_FEATURE_NAME;
	}
	
	/**
	 * get method for the identifier of the icon for the create feature
	 * @return the id of the icon
	 */
	@Override
	public String getCreateImageId() {
		return IMG_ID_FEATURE_INHERITANCE;
	}
	
	//add feature
	//~~~~~~~~~~~
	/**
	 * calculates if a inheritance can be added to the pictogram diagram
	 * <p>
	 * returns true if the business object is a inheritance
	 * @return if a inheritance can be added
	 */
	@Override
	public boolean canAdd(IAddContext addContext) {
		if(addContext.getNewObject() instanceof Relation) {
		   Relation relation = (Relation) addContext.getNewObject();
		   if(relation.getType() == Type.INHERITANCE)
			   return true && EditPolicyHandler.canAdd(addContext, this.getDiagram());
		}
		return false;
	}
	
	/**
	 * adds the inheritance to the pictogram diagram using the following steps:
	 * <p>
	 * Step 1: create a connection shape and polyline as its graphic algorithm
	 * Step 2: create the a connection decorator and a arrowhead as its graphic algorithm 
	 * Step 3: link the pictogram elements and the business objects
	 */
	@Override
	public PictogramElement add(IAddContext addContext) {
		IAddConnectionContext addConnectionContext = (IAddConnectionContext) addContext;
	    Relation addedInheritance = (Relation) addContext.getNewObject();
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
	    ConnectionDecorator connectionDecorator;
	    connectionDecorator = pictogramElementCreateService.createConnectionDecorator(connection, false, 1.0, true);
	    int points[] = new int[] { -1*INHERITANCE_ARROWHEAD_LENGTH, INHERITANCE_ARROWHEAD_HEIGHT, 		//Point 1
	    						   0, 0, 																//P2
	    						   -1*INHERITANCE_ARROWHEAD_LENGTH, -1*INHERITANCE_ARROWHEAD_HEIGHT };	//P3						 
	    Polygon arrowhead = graphicAlgorithmService.createPolygon(connectionDecorator, points);
	    arrowhead.setForeground(manageColor(COLOR_CONNECTIONS));
	    arrowhead.setBackground(manageColor(COLOR_INHERITANCE_ARROWHEAD));
	    PropertyUtil.setShape_IdValue(connectionDecorator, SHAPE_ID_INHERITANCE_DECORATOR);
	    //Step 3
	    link(connection, addedInheritance);
	    return connection;
	}
	 
	//create feature
	//~~~~~~~~~~~~~~
	/**
	 * calculates if a inheritance can be created
	 * <p>
	 * returns true if<br>
	 * (1) target and source shape are not null and<br>
	 * (2) target and source shape is of valid type and<br>
	 * (3) source shapes container and targets shapes container are the same and<br>
	 * (4) the source shape is not equals the target shape and<br>
	 * (5) target and source shape are of the same type
	 * @return if inheritance can be added
	 */
	@Override
	public boolean canCreate(ICreateConnectionContext createContext) {
		Anchor sourceAnchor = createContext.getSourceAnchor();
	    Anchor targetAnchor = createContext.getTargetAnchor();
	    ModelElement sourceShape = ConnectionPatternUtil.getModelElementForAnchor(sourceAnchor);
	    ModelElement targetShape = ConnectionPatternUtil.getModelElementForAnchor(targetAnchor);
	    if(sourceShape != null && targetShape != null) {
	    	if(sourceShape.getContainer() == targetShape.getContainer() &&
	    	   !(sourceShape.equals(targetShape))) {
	    		if(sourceShape.getType() == Type.NATURAL_TYPE ||
	    		   sourceShape.getType() == Type.DATA_TYPE ||
	    		   sourceShape.getType() == Type.COMPARTMENT_TYPE ||
	    		   sourceShape.getType() == Type.ROLE_TYPE)
	    			if(targetShape.getType() == sourceShape.getType())
						   return true && EditPolicyHandler.canCreate(createContext, this.getDiagram());
	    }	}
	    return false;
	}
	 
	/**
	 * checks if a inheritance can be started from a given source shape
	 * <p>
	 * returns true if<br>
	 * (1) source shape is not null and<br>
	 * (2) source shape is of valid type 
	 * @return if inheritance can be started
	 */
	@Override
	public boolean canStartConnection(ICreateConnectionContext createContext) {
		Anchor sourceAnchor = createContext.getSourceAnchor();
		ModelElement sourceShape = ConnectionPatternUtil.getModelElementForAnchor(sourceAnchor);
		if(sourceShape != null){	
			if(sourceShape.getType() == Type.NATURAL_TYPE || 
			   sourceShape.getType() == Type.DATA_TYPE ||
			   sourceShape.getType() == Type.COMPARTMENT_TYPE ||
			   sourceShape.getType() == Type.ROLE_TYPE)
				return true;
		}	
		return false;
	}
	  
	/**
	 * creates the business object of an inheritance using the following steps:
	 * <p>
	 * Step 1: get source and target shapes<br>
	 * Step 2: get new inheritance and add it to the resource of the diagram<br>
	 * Step 3: set source, target and container of inheritance<br>
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
		Relation newInheritance = OrmFactory.eINSTANCE.createRelation();
	    newInheritance.setType(Type.INHERITANCE); 
	    if(newInheritance.eResource() != null) getDiagram().eResource().getContents().add(newInheritance);
	    //Step 3
	    newInheritance.setContainer(sourceShape.getContainer());
	    sourceShape.getContainer().getElements().add(newInheritance);
	    newInheritance.setSource(sourceShape);
	    newInheritance.setTarget(targetShape);
	    //Step 4
	    AddConnectionContext addContext = new AddConnectionContext(sourceAnchor, targetAnchor);
	    addContext.setNewObject(newInheritance);
	    Connection newConnection = null;
	    if(canAdd(addContext)) newConnection = (Connection) add(addContext); 	        
	    return newConnection;
	}
}
