package org.framed.iorm.ui.pattern.connections;

import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.framed.iorm.model.OrmFactory;
import org.framed.iorm.model.Relation;
import org.framed.iorm.model.Type;

/**
 * This is the abstract sub class of the pattern for role constraint. It collects similiar operations
 * of the patterns {@link RoleImplicationPattern}, {@link RoleEquivalencePattern} and 
 * {@link RoleProhibitionPattern}.
 * @author Kevin Kassin
 */
public abstract class AbstractRoleConstraintPattern extends FRaMEDConnectionPattern{
	
	public AbstractRoleConstraintPattern() {
		super();
	}
	
	//add feature
	//~~~~~~~~~~~
	/**
	 * calculates if a role constraint can be added to the pictogram diagram
	 * <p>
	 * returns true if the business object is a role constraint of the given type
	 * @return if a role constraint can be added
	 */
	public boolean canAddRoleConstraint(IAddContext addContext, Type type) {
		if(addContext.getNewObject() instanceof Relation) {
		   Relation relation = (Relation) addContext.getNewObject();
		   if(relation.getType() == Type.ROLE_IMPLICATION)
			   return true;
		}
		return false;
	}
	
	//create feature
	//~~~~~~~~~~~~~~
	/**
	 * calculates if a role constraint can be created
	 * <p>
	 * returns true if<br>
	 * (1) target and source shape are not null and<br>
	 * (2) target and source shape is of valid type and<br>
	 * (3) source shapes container and targets shapes container are the same and<br>
	 * (4) the source shape is not equals the target shape and<br>
	 * (5) target and source shape are of the same type
	 * @return if the role constraint can be added
	 */
	@Override
	public boolean canCreate(ICreateConnectionContext createContext) {
		Anchor sourceAnchor = createContext.getSourceAnchor();
	    Anchor targetAnchor = createContext.getTargetAnchor();
	    org.framed.iorm.model.Shape sourceShape = getShapeForAnchor(sourceAnchor);
	    org.framed.iorm.model.Shape targetShape = getShapeForAnchor(targetAnchor);
	    if(sourceShape != null && targetShape != null) {
	    	if(sourceShape.getContainer() == targetShape.getContainer() &&
	    	   !(sourceShape.equals(targetShape))) {
	    		if(sourceShape.getType() == Type.ROLE_TYPE)
	    			if(targetShape.getType() == sourceShape.getType())
		   				return true;
		}	}
	    return false;
	}
	
	/**
	 * checks if a role constraint can be started from a given source shape
	 * <p>
	 * returns true if<br>
	 * (1) source shape is not null and<br>
	 * (2) source shape is of valid type 
	 * @return if a role constraint can be started
	 */
	@Override
	public boolean canStartConnection(ICreateConnectionContext createContext) {
		Anchor sourceAnchor = createContext.getSourceAnchor();
		org.framed.iorm.model.Shape sourceShape = getShapeForAnchor(sourceAnchor);
		if(sourceShape != null){	
			if(sourceShape.getType() == Type.ROLE_TYPE)
				return true;
		}	
		return false;
	}
	
 
	/**
	 * creates the business object of a role constraint of the given type using the following steps:
	 * <p>
	 * Step 1: get source and target shapes<br>
	 * Step 2: get new role constraint and add it to the resource of the diagram<br>
	 * Step 3: set source, target and container of role constraint<br>
	 * Step 4: call add operation of the pattern
	 */
	public Connection createRoleConstraint(ICreateConnectionContext createContext, Type type) {
		//Step 1
		Anchor sourceAnchor = createContext.getSourceAnchor();
	    Anchor targetAnchor = createContext.getTargetAnchor();
	    org.framed.iorm.model.Shape sourceShape = getShapeForAnchor(sourceAnchor);
	    org.framed.iorm.model.Shape targetShape = getShapeForAnchor(targetAnchor);
		Connection newConnection = null;
		//Step 2
		Relation newRoleImplication = OrmFactory.eINSTANCE.createRelation();
	    newRoleImplication.setType(type); 
	    if(newRoleImplication.eResource() != null) getDiagram().eResource().getContents().add(newRoleImplication);
	    //Step 3
	    newRoleImplication.setContainer(sourceShape.getContainer());
	    sourceShape.getContainer().getElements().add(newRoleImplication);
		newRoleImplication.setSource(sourceShape);
		newRoleImplication.setTarget(targetShape);
	    //Step 4
	    AddConnectionContext addContext = new AddConnectionContext(sourceAnchor, targetAnchor);
	    addContext.setNewObject(newRoleImplication);
	    if(canAdd(addContext)) add(addContext); 	        
	    return newConnection;
	}
}
