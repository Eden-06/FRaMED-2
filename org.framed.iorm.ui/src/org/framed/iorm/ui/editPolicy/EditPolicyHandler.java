package org.framed.iorm.ui.editPolicy;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.IReconnectionContext;

import Editpolicymodel.ActionEnum;
import Editpolicymodel.ConstraintRule;
import Editpolicymodel.Policy;

import org.framed.iorm.featuremodel.FRaMEDConfiguration;
import org.framed.iorm.model.*;

/**
 * For each diagram on EditPolicyHandler is used
 * 
 * @author Christian Deussen
 *
 */
public class EditPolicyHandler {
	/**
	 *  a list with activated policies
	 */
	private List<Editpolicymodel.Policy> activatedPolicies;
	
	public EditPolicyHandler() {
		this.activatedPolicies = new LinkedList<>();
	}
	
	public void updateConfig(List<Editpolicymodel.Model> models, FRaMEDConfiguration config) {
		//parse all editpolicies to create list with activated policies
		//load all rules which are activated by current configuration
		activatedPolicies = new LinkedList<>();

		FeatureRuleVisitor featureRuleVisitor = new FeatureRuleVisitor(config); 
		for(Editpolicymodel.Model model : models) {
			for(Editpolicymodel.Policy policy : model.getPolicies()) {
				if(featureRuleVisitor.checkRule(policy.getFeatureRule())) {
					activatedPolicies.add(policy); 
				}
			}
		}
	}
	
	/**
	 * get all constraints which are relevant for action/type combination
	 * @param action
	 * @param type
	 * @return
	 */
	private List<ConstraintRule> getConstraints(ActionEnum action, Type type) {
		List<ConstraintRule> rules = new LinkedList<>();
		
		System.out.println("getting Constraints for action: " + action.toString() + " and type: " + type.toString());
		for(Policy policy: this.activatedPolicies) {
			if(policy.getAction().getValue() == action.getValue() && policy.getActionType().getLiteral().equals(type.getLiteral()))
				rules.add(policy.getConstraintRule());
		}
		System.out.println("constraints: " + rules.toString());

		return rules;
	}

	public boolean canCreate(ICreateConnectionContext context, Type type) 
	{
		List<ConstraintRule> constraints = this.getConstraints(ActionEnum.CREATE, type);
		return this.checkConstraints(constraints, context, type);
	}

	public boolean canStart(ICreateConnectionContext context, Type type) {
		System.out.println("properties: " + context.getPropertyKeys());
		List<ConstraintRule> constraints = this.getConstraints(ActionEnum.START, type);
		return this.checkConstraints(constraints, context, type);
	}

	public boolean canExecute(ICustomContext context, Type type) {
		List<ConstraintRule> constraints = this.getConstraints(ActionEnum.EXECUTE, type);
		return this.checkConstraints(constraints, context, type);
	}

	public boolean canReconnect(IReconnectionContext context, Type type) {
		List<ConstraintRule> constraints = this.getConstraints(ActionEnum.RECONNECT, type);
		return this.checkConstraints(constraints, context, type);
	}

	public boolean canAdd(IAddConnectionContext context, Type type) { 
		List<ConstraintRule> constraints = this.getConstraints(ActionEnum.ADD, type);
		return this.checkConstraints(constraints, context, type);
	}
	
	public boolean canDirectEdit(IDirectEditingContext context, Type type) {
		List<ConstraintRule> constraints = this.getConstraints(ActionEnum.DIRECT_EDIT, type);
		return this.checkConstraints(constraints, context, type);
	}
	
	private boolean checkConstraints(List<ConstraintRule> constraints, Object context, Type type)
	{
		ConstraintRuleVisitor constraintVisitor = new ConstraintRuleVisitor(context, type, false);
		for(ConstraintRule constraintRule: constraints) {
			if(constraintVisitor.checkRule(constraintRule))
				return true;
		}
		return false;
	}
	
	public boolean canAdd(IAddContext context) {
		//new Object is either relation or shape
		Relation relation = (Relation) context.getNewObject();
		Type type = relation.getType();
		return this.canAdd(context, type);
	}
	
	public boolean canAdd(IAddContext context, Type type) {
		List<ConstraintRule> constraints = this.getConstraints(ActionEnum.ADD, type);
		
		return this.checkConstraints(constraints, context, type);
	}
	
	public boolean canCreate(ICreateContext context, Type type) {
		List<ConstraintRule> constraints = this.getConstraints(ActionEnum.CREATE, type);
		return this.checkConstraints(constraints, context, type);
	}
	
	public boolean canAddProperty(IAddContext context, Type type) {
		List<ConstraintRule> constraints = this.getConstraints(ActionEnum.ADD_PROPERTY, type);
		return this.checkConstraints(constraints, context, type);
	}

	public boolean canCreateProperty(ICreateContext context, Type type) {
		List<ConstraintRule> constraints = this.getConstraints(ActionEnum.CREATE_PROPERTY, type);
		return this.checkConstraints(constraints, context, type);
	}

	public boolean canCreateAttribute(ICreateContext context, Type type) {
		List<ConstraintRule> constraints = this.getConstraints(ActionEnum.CREATE_ATTRIBUTE, type);
		return this.checkConstraints(constraints, context, type);
	}

	public boolean canCreateOperation(ICreateContext context, Type type) {
		List<ConstraintRule> constraints = this.getConstraints(ActionEnum.CREATE_OPERATION, type);
		return this.checkConstraints(constraints, context, type);
	}

}