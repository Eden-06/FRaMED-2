package org.framed.iorm.ui.editPolicy;

import Editpolicymodel.AbstractConstraintRule;
import Editpolicymodel.AndConstraintRule;
import Editpolicymodel.FalseConstraintRule;
import Editpolicymodel.IsStepOutConstraintRule;
import Editpolicymodel.NotFeatureRule;
import Editpolicymodel.TrueConstraintRule;

/**
 * This class provides the rule-parse for the command-rules. Using VisitorPattern
 *
 * @author Christian Deussen
 *
 */
public class EditPolicyConstraintVisitor {

	/**
	 * command to check rules against
	 */
	@SuppressWarnings("unused")
	private Object context;

	/**
	 * whether editor is in StepIn/StepOut-View
	 */
	private boolean isStepOut;

	public EditPolicyConstraintVisitor(Object context, boolean isStepOut) {
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
	
	public boolean constraintRuleVisitor(AbstractConstraintRule rule) 
	{
		if(rule == null) {
			return true;
		}
		if (rule instanceof AndConstraintRule)
			return this.andRuleVisitor(rule);
		
		if (rule instanceof NotFeatureRule)
			return notRuleVisitor(rule);
		
		if (rule instanceof IsStepOutConstraintRule)
			return this.isStepOutConstraintRuleVisitor(rule);

		if (rule instanceof TrueConstraintRule)
			return true;

		if (rule instanceof FalseConstraintRule)
			return false;

		System.out.println("NodeMappingVisitor for " + rule.getClass().toString() + " not implemented");
		return true;
	}
	
	private boolean andRuleVisitor(AbstractConstraintRule rule) {
		return constraintRuleVisitor(rule.getRule1()) && constraintRuleVisitor(rule.getRule2());
	}
	
	private boolean notRuleVisitor(AbstractConstraintRule rule) {
		return !constraintRuleVisitor(rule.getRule1());
	}
	
	private boolean isStepOutConstraintRuleVisitor(AbstractConstraintRule rule) {
		return this.isStepOut;
	}
}