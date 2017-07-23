package org.framed.iorm.ui.pattern.connections;

import java.util.List;

import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.framed.iorm.model.OrmFactory;
import org.framed.iorm.model.Relation;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.util.ConnectionPatternUtil;

//TODO
public abstract class AbstractIntraRelationshipConstraintFeature extends FRaMEDConnectionPattern {

	/**
	 * the identifier for the icon of the create feature gathered from {@link IdentifierLiterals}
	 */
	private static final String IMG_ID_FEATURE_INTRARELATIONSHIP_CONSTRAINT = IdentifierLiterals.IMG_ID_FEATURE_INTRARELATIONSHIP_CONSTRAINT;
	
	public AbstractIntraRelationshipConstraintFeature() {
		super();
	}
	
	/**
	 * get method for the identifier of the common icon for the create features of all 
	 * intra relationship constraints
	 * @return the id of the icon
	 */
	@Override
	public String getCreateImageId() {
		return IMG_ID_FEATURE_INTRARELATIONSHIP_CONSTRAINT;
	}
	
	//add feature
	//~~~~~~~~~~~
	//TODO
	public boolean canAddIntraRelationshipConstraint(IAddContext addContext, Type type) {
		if(addContext.getNewObject() instanceof Relation) {
		   Relation relation = (Relation) addContext.getNewObject();
		   if(relation.getType() == type)
			   return true;
		}
		return false;
	}
	
	//create feature
	//~~~~~~~~~~~~~~
	/**
	 * calculates if a intra relationship constraint can be created
	 * <p>
	 * returns true if<br>
	 * (1) target and source shape are not null and<br>
	 * (2) target and source shape is of valid type and<br>
	 * (3) source shapes container and targets shapes container are the same and<br>
	 * (4) the source shape is not equals the target shape and<br>
	 * (5) target and source shape are of the same type
	 * @return if inheritance can be added
	 */
	//TODO auftrennen, übersichtlicher
	public boolean canCreate(ICreateConnectionContext createContext) {
		Anchor sourceAnchor = createContext.getSourceAnchor();
	    Anchor targetAnchor = createContext.getTargetAnchor();
	    org.framed.iorm.model.Shape sourceShape = getShapeForAnchor(sourceAnchor);
	    org.framed.iorm.model.Shape targetShape = getShapeForAnchor(targetAnchor);
	    if(sourceShape != null && targetShape != null) {
	    	if(sourceShape.getContainer() == targetShape.getContainer() &&
	    	   !(sourceShape.equals(targetShape))) {
	    		if(sourceShape.getType() == Type.ROLE_TYPE && 
	    		   targetShape.getType() == sourceShape.getType()) {
	    			List<Relation> commonRelationships =
	    				ConnectionPatternUtil.getRelationsBetweenClassesOrRoles(sourceShape, targetShape, Type.RELATIONSHIP);
	    			if(commonRelationships.size() == 1) 
	    				return true;
	    }	}	}
	    return false;
	}
	
	/**
	 * checks if a intra relationship constraint can be started from a given source shape
	 * <p>
	 * returns true if<br>
	 * (1) source shape is not null and<br>
	 * (2) source shape is of valid type and<br>
	 * (3) source shape has at least one relationship
	 * @return if a intra relationship constraint can be started
	 */
	@Override
	public boolean canStartConnection(ICreateConnectionContext createContext) {
		Anchor sourceAnchor = createContext.getSourceAnchor();
		org.framed.iorm.model.Shape sourceShape = getShapeForAnchor(sourceAnchor);
		if(sourceShape != null){	
			if(sourceShape.getType() == Type.ROLE_TYPE) {
				List<Relation> relationships = 
						ConnectionPatternUtil.getRelationForClassOrRole(sourceShape, Type.RELATIONSHIP);
				if(relationships.size() >0) return true;
		}	}
		return false;
	}
	
	public Connection createIntraRelationshipConstraint(ICreateConnectionContext createContext, Type type) {
		//Step 1
		Anchor sourceAnchor = createContext.getSourceAnchor();
	    Anchor targetAnchor = createContext.getTargetAnchor();
	    org.framed.iorm.model.Shape sourceShape = getShapeForAnchor(sourceAnchor);
	    org.framed.iorm.model.Shape targetShape = getShapeForAnchor(targetAnchor);
		//Step 2
		Relation newIntraRelCon = OrmFactory.eINSTANCE.createRelation();
	    newIntraRelCon.setType(type); 
	    if(newIntraRelCon.eResource() != null) getDiagram().eResource().getContents().add(newIntraRelCon);
	    //Step 3
	    newIntraRelCon.setContainer(sourceShape.getContainer());
		sourceShape.getContainer().getElements().add(newIntraRelCon);
		newIntraRelCon.setSource(sourceShape);
		newIntraRelCon.setTarget(targetShape);
		//Step 4
		AddConnectionContext addContext = new AddConnectionContext(sourceAnchor, targetAnchor);
		addContext.setNewObject(newIntraRelCon);
		Connection newConnection = null;
	    //if(canAdd(addContext)) newConnection = (Connection) add(addContext); 	        
	    return newConnection;
	}
}
