package org.framed.iorm.ui.editPolicy;

import Editpolicymodel.AndConstraintRule;
import Editpolicymodel.ConstraintRule;
import Editpolicymodel.FalseConstraintRule;
import Editpolicymodel.IsStepIn;
import Editpolicymodel.NotConstraintRule;
import Editpolicymodel.OrConstraintRule;
import Editpolicymodel.TrueConstraintRule;

/**
 * This class provides the rule-parse for the command-rules. Using VisitorPattern
 *
 * @author Christian Deussen
 *
 */
public class ConstraintRuleVisitor {

	/**
	 * command to check rules against
	 */
	@SuppressWarnings("unused")
	private Object context;

	/**
	 * whether editor is in StepIn/StepOut-View
	 */
	private boolean isStepOut;

	public ConstraintRuleVisitor(Object context, boolean isStepOut) {
		this.context = context;
		this.isStepOut = isStepOut;
	}

	/**
	 * dispatch abstract rule
	 *
	 * returns whether this.cmd is allowed according to @param rule
	 *
	 * @param rule
	 * @return Boolean
	 */
	
	public boolean checkRule(ConstraintRule rule) 
	{
			if(rule instanceof IsStepIn) {
				return this.isStepOut;
			}
		
		if (rule instanceof AndConstraintRule)
			return andRuleVisitor((AndConstraintRule)rule);
		
		if (rule instanceof OrConstraintRule)
			return orRuleVisitor((OrConstraintRule)rule);
		
		if (rule instanceof NotConstraintRule)
			return notRuleVisitor((NotConstraintRule)rule);
		
		if (rule instanceof TrueConstraintRule)
			return true;		
		
		if (rule instanceof FalseConstraintRule)
			return false;

		System.out.println("checkRule for " + rule.getClass().toString() + " not implemented");
		return true;
	}
	
	private boolean andRuleVisitor(AndConstraintRule rule) {
		for(ConstraintRule abstractRule : rule.getRules()) {
			if(!checkRule(abstractRule))
				return false;
		}
		return true;
	}
	
	private boolean orRuleVisitor(OrConstraintRule rule) {
		for(ConstraintRule abstractRule : rule.getRules()) {
			if(checkRule(abstractRule))
				return true;
		}
		return false;
	}
		
	private boolean notRuleVisitor(NotConstraintRule rule) {
		return !checkRule(rule.getRule());
	}	

}
