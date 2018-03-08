package org.framed.iorm.ui.editPolicy;

import Editpolicymodel.AbstractRule;
import Editpolicymodel.ConstraintRule;
import Editpolicymodel.IsStepIn;
import Editpolicymodel.Rule;

/**
 * This class provides the rule-parse for the command-rules. Using VisitorPattern
 *
 * @author Christian Deussen
 *
 */
public class ConstraintRuleVisitor extends AbstractRuleVisitor<ConstraintRule> {

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
		super(null);
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
	
	public boolean checkRule(AbstractRule<ConstraintRule> rule) 
	{
		if (rule instanceof Rule) {
			ConstraintRule constraint = ((Rule<ConstraintRule>) rule).getRule();
			if(constraint instanceof IsStepIn) {
				return this.isStepOut;
			}
		} 
		return super.checkRule(rule);
	}
}
