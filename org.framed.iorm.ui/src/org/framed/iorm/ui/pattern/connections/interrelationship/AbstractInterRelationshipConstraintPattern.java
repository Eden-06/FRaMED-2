package org.framed.iorm.ui.pattern.connections.interrelationship;

import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.util.IColorConstant;
import org.framed.iorm.model.OrmFactory;
import org.framed.iorm.model.Relation;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.literals.LayoutLiterals;
import org.framed.iorm.ui.pattern.connections.FRaMEDConnectionPattern;
import org.framed.iorm.ui.util.ConnectionPatternUtil;

//TODO
public class AbstractInterRelationshipConstraintPattern extends FRaMEDConnectionPattern {
	
	//TODO
	protected final String SHAPE_ID_INTER_REL_CON = IdentifierLiterals.SHAPE_ID_INTER_REL_CON,
					       SHAPE_ID_RELATIONSHIP_ANCHOR_DECORATOR = IdentifierLiterals.SHAPE_ID_RELATIONSHIP_ANCHOR_DECORATOR;
	
	/**
	 * the layout integers used to layout the arrowhead of the inheritances gathered from {@link LayoutLiterals}
	 */
	protected final int ARROWHEAD_LENGTH = LayoutLiterals.ARROWHEAD_LENGTH,
					    ARROWHEAD_HEIGHT = LayoutLiterals.ARROWHEAD_HEIGHT;
	
	/**
	 * the color values used for the polyline and the arrowhead gathered from {@link LayoutLiterals}
	 */
	protected final IColorConstant COLOR_CONNECTIONS = LayoutLiterals.COLOR_CONNECTIONS,
								   COLOR_ARROWHEAD = LayoutLiterals.COLOR_ARROWHEAD;
	
	/**
	 * Class constructor
	 */
	public AbstractInterRelationshipConstraintPattern() {
		super();
	}
	
	//add feature
	//~~~~~~~~~~~
	/**
	 * calculates if a inter relationship constraint can be added to the pictogram diagram
	 * <p>
	 * returns true if the business object is a inter relationship constraint of the given type
	 * @return if an inter relationship constraint can be added
	 */
	public boolean canAddInterRelationshipConstraint(IAddContext addContext, Type type) {
		if(addContext.getNewObject() instanceof Relation) {
			Relation relation = (Relation) addContext.getNewObject();
			if(relation.getType() == type) {
				return true; 
			}   
		}
		return false;
	}
	
	//create feature
	//~~~~~~~~~~~~~~
	/**
	 * calculates if an inter relationship constraint can be created
	 * <p>
	 * returns true if<br>
	 * (1) target and source connection are not null and<br>
	 * (2) target and source connection is of valid type and<br>
	 * (3) source connection container and targets connection container are the same and<br>
	 * (4) the source connection is not equals the target connection and<br>
	 * (5) target and source connection are of the same type
	 * @return if the inter relationship constraint can be added
	 */
		@Override
		public boolean canCreate(ICreateConnectionContext createContext) {
			Anchor sourceAnchor = createContext.getSourceAnchor();
		    Anchor targetAnchor = createContext.getTargetAnchor();
		    org.framed.iorm.model.ModelElement sourceConnection = ConnectionPatternUtil.getModelElementForAnchor(sourceAnchor);
		    org.framed.iorm.model.ModelElement targetConnection = ConnectionPatternUtil.getModelElementForAnchor(targetAnchor);
		    if(sourceConnection != null && targetConnection != null) {
		    	if(sourceConnection.getContainer() == targetConnection.getContainer() &&
		    	   !(sourceConnection.equals(targetConnection))) {
		    		if(sourceConnection.getType() == Type.RELATIONSHIP)
		    			if(targetConnection.getType() == sourceConnection.getType())
			   				return true;
			}	}
		    return false;
		}
		
		/**
		 * checks if a inter relationship constraint can be started from a given source connection
		 * <p>
		 * returns true if<br>
		 * (1) source connection is not null and<br>
		 * (2) source connection is of valid type 
		 * @return if a inter relationship constraint can be started
		 */
		@Override
		public boolean canStartConnection(ICreateConnectionContext createContext) {
			Anchor sourceAnchor = createContext.getSourceAnchor();
			org.framed.iorm.model.ModelElement sourceConnection = ConnectionPatternUtil.getModelElementForAnchor(sourceAnchor);
			if(sourceConnection != null){	
				if(sourceConnection.getType() == Type.RELATIONSHIP)
					return true;
			}	
			return false;
		}
		
		/**
		 * creates the business object of a inter relationship constraint of the given type using the following steps:
		 * <p>
		 * Step 1: get source and target connection<br>
		 * Step 2: get new inter relationship constraint and add it to the resource of the diagram<br>
		 * Step 3: set source, target and container of inter relationship constraint<br>
		 * @param type the type to create a inter relationship constraint of
		 * @param aircp the sub class calling this operation
		 */
		public Connection createInterRelationshipConstraint(ICreateConnectionContext createContext, Type type, AbstractInterRelationshipConstraintPattern aircp) {
			//Step 1
			Anchor sourceAnchor = createContext.getSourceAnchor();
		    Anchor targetAnchor = createContext.getTargetAnchor();
		    org.framed.iorm.model.ModelElement sourceConnection = ConnectionPatternUtil.getModelElementForAnchor(sourceAnchor);
		    org.framed.iorm.model.ModelElement targetConnection = ConnectionPatternUtil.getModelElementForAnchor(targetAnchor);
			//Step 2
			Relation newInterRelationshipConstraint = OrmFactory.eINSTANCE.createRelation();
		    newInterRelationshipConstraint.setType(type); 
		    if(newInterRelationshipConstraint.eResource() != null) getDiagram().eResource().getContents().add(newInterRelationshipConstraint);
		    //Step 3
		    newInterRelationshipConstraint.setContainer(sourceConnection.getContainer());
		    sourceConnection.getContainer().getElements().add(newInterRelationshipConstraint);
			newInterRelationshipConstraint.setSource(sourceConnection);
			newInterRelationshipConstraint.setTarget(targetConnection);
		    //Step 4
		    AddConnectionContext addContext = new AddConnectionContext(sourceAnchor, targetAnchor);
		    addContext.setNewObject(newInterRelationshipConstraint);
		    Connection newConnection = null;
		    if(aircp.canAdd(addContext)) newConnection = (Connection) aircp.add(addContext); 	        
		    return newConnection;
		}
}
