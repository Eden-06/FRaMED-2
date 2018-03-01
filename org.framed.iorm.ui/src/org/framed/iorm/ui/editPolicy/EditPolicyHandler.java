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
import org.eclipse.graphiti.mm.pictograms.Diagram;

import Editpolicymodel.AbstractRule;
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
			for(Editpolicymodel.Policy policy : model.getPolicy()) {
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
	private List<Editpolicymodel.AbstractRule<ConstraintRule>> getConstraints(ActionEnum action, Type type) {
		List<AbstractRule<ConstraintRule>> rules = new LinkedList<>();
		
		for(Policy policy: this.activatedPolicies) {
			System.out.println("Action: " + policy.getAction().toString());
			System.out.println("Type: " + policy.getActionType().toString());

			if(policy.getAction().getValue() == action.getValue() && policy.getActionType().getValue() == type.getValue())
				rules.add(policy.getConstraintRule());
		}

		return rules;
	}

	public boolean canCreate(ICreateConnectionContext context, Type type, Diagram diagram) 
	{
		List<Editpolicymodel.AbstractRule<ConstraintRule>> constraints = this.getConstraints(ActionEnum.CREATE, type);
		ConstraintRuleVisitor constraintVisitor = new ConstraintRuleVisitor(context, false);
		for(AbstractRule<ConstraintRule> constraintRule: constraints) {
			if(!constraintVisitor.checkRule(constraintRule))
				return false;
		}
		return true;
	}

	public boolean canStart(ICreateConnectionContext context, Diagram diagram) {
		// System.out.println("---can create check----");
		return true;
	}

	public boolean canExecute(ICustomContext context, Diagram diagram) {
		// System.out.println("---can create check----");
		return true;
	}

	public boolean canReconnect(IReconnectionContext context, Diagram diagram) {
		// System.out.println("---can reconnect check----");
		return true;
	}

	public boolean canAdd(IAddConnectionContext context, Diagram diagram) {
		// System.out.println("---can reconnect check----");
		return true;
	}
	
	public boolean canDirectEdit(IDirectEditingContext editingContext) {
		return true;
	}
	
	public boolean canAdd(IAddContext context, Diagram diagram) {
		// System.out.println("---can add check----");
		return true;
	}
	
	public boolean canCreate(ICreateContext context, Diagram diagram) {
		// System.out.println("---can create check----");

		/*
		 * EditPolicyRuleVisitor editPolicyRuleVisitor = new
		 * EditPolicyRuleVisitor(context, false); for (Policy policy :
		 * getPolicies(diagram)) { if
		 * (!editPolicyRuleVisitor.abstractRuleVisitor(policy.getRule())) {
		 * System.out.println("Not Allowed because of: " + policy.getName()); return
		 * false; } }
		 */
		// System.out.println("-------------------------------");
		return true;
	}
}