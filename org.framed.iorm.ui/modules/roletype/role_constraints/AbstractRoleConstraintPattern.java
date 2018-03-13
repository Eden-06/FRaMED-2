package roletype.role_constraints;

import java.util.Arrays;
import java.util.List;

import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.framed.iorm.model.Model;
import org.framed.iorm.model.OrmFactory;
import org.framed.iorm.model.Relation;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.FRaMEDConnectionPattern;
import org.framed.iorm.ui.UIUtil;
import org.framed.iorm.ui.editPolicy.EditPolicyService;
import org.framed.iorm.ui.exceptions.NoModelFoundException;

/**
 * This is the abstract super class of the patterns for role constraint. It collects similiar operations
 * and attributes of the patterns {@link RoleImplicationPattern}, {@link RoleEquivalencePattern} and 
 * {@link RoleProhibitionPattern}.
 * @author Kevin Kassin
 */
public abstract class AbstractRoleConstraintPattern extends FRaMEDConnectionPattern{
	
	//TODO To be delete when the type checks are done by the edit policies
	/**
	 * the lists of types for which a role constraint is applicable
	 */
	List<Type> types = Arrays.asList(Type.ROLE_TYPE, Type.ROLE_GROUP);
	
	/**
	 * Class constructor
	 */
	public AbstractRoleConstraintPattern() {
		super();
	}
	
	/**
	 * checks if connection can be reconnected
	 * <p>
	 * @return true if the shapes the new and old anchors are both role types in the same container
	 */
	@Override
	public boolean canReconnect(IReconnectionContext context) {
		Anchor newAnchor = context.getNewAnchor();
	    Anchor oldAnchor = context.getOldAnchor();
	    org.framed.iorm.model.ModelElement newShape = UIUtil.getModelElementForAnchor(newAnchor);
	    org.framed.iorm.model.ModelElement oldShape = UIUtil.getModelElementForAnchor(oldAnchor);
	    if(newShape != null && oldShape != null) {
	    	if(newShape.getContainer() == oldShape.getContainer() &&
	    	   !(newShape.equals(oldShape))) {
	    		if(newShape.getType() == Type.ROLE_TYPE)
	    			if(oldShape.getType() == newShape.getType())
	    				return true;
		}	}
	    return false;
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
		   if(relation.getType() == type)
				return EditPolicyService.canAdd(addContext, this.getDiagram());
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
	    org.framed.iorm.model.ModelElement sourceShape = UIUtil.getModelElementForAnchor(sourceAnchor);
	    org.framed.iorm.model.ModelElement targetShape = UIUtil.getModelElementForAnchor(targetAnchor);
	    if(sourceShape != null && targetShape != null) {
	    	if(sourceShape.getContainer() == targetShape.getContainer() &&
	    	   !(sourceShape.equals(targetShape))) {
	    		if(types.contains(sourceShape.getType()) &&
	    		   types.contains(targetShape.getType()))
	    			return EditPolicyService.canCreate(createContext, this.getDiagram());
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
		org.framed.iorm.model.ModelElement sourceShape = UIUtil.getModelElementForAnchor(sourceAnchor);
		if(sourceShape != null){	
			if(types.contains(sourceShape.getType()))
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
	 * @param type the type to create a role constraint of
	 * @param arcp the sub class calling this operation
	 */
	public Connection createRoleConstraint(ICreateConnectionContext createContext, Type type, AbstractRoleConstraintPattern arcp) {
		//Step 1
		Anchor sourceAnchor = createContext.getSourceAnchor();
	    Anchor targetAnchor = createContext.getTargetAnchor();
	    org.framed.iorm.model.ModelElement sourceShape = UIUtil.getModelElementForAnchor(sourceAnchor);
	    org.framed.iorm.model.ModelElement targetShape = UIUtil.getModelElementForAnchor(targetAnchor);
		//Step 2
		Relation newRoleConstraint = OrmFactory.eINSTANCE.createRelation();
	    newRoleConstraint.setType(type); 
	    if(newRoleConstraint.eResource() != null) getDiagram().eResource().getContents().add(newRoleConstraint);
	    //Step 3
	    Model model = getModelToCreateIn(sourceShape);
	    newRoleConstraint.setContainer(model);
	    model.getElements().add(newRoleConstraint);
		newRoleConstraint.setSource(sourceShape);
		newRoleConstraint.setTarget(targetShape);
	    //Step 4
	    AddConnectionContext addContext = new AddConnectionContext(sourceAnchor, targetAnchor);
	    addContext.setNewObject(newRoleConstraint);
	    Connection newConnection = null;
	    if(arcp.canAdd(addContext)) newConnection = (Connection) arcp.add(addContext); 	        
	    return newConnection;
	}
	
	/**
	 * searches for model of the compartment type the connected role types are created in
	 * <p>
	 * This operation also works for nested role groups in role groups in such a way that
	 * the compartment type is found in which the top level role group is contained in.
	 * @param sourceShape the shape of the role to get the compartment type for
	 * @return the model of the compartment type the connected role types are created
	 */
	public Model getModelToCreateIn(org.framed.iorm.model.ModelElement sourceShape) {
		while(sourceShape.getContainer() != null) {
			if(sourceShape.getContainer().getParent().getType() == Type.COMPARTMENT_TYPE)
				return sourceShape.getContainer();
			else sourceShape = sourceShape.getContainer().getParent();
		}
		throw new NoModelFoundException();
	}
}
