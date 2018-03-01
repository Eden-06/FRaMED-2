package org.framed.iorm.ui.editPolicy;

import Editpolicymodel.AbstractRule;
import Editpolicymodel.Constraint;
import Editpolicymodel.IsStepOut;
import Editpolicymodel.Rule;

/**
 * This class provides the rule-parse for the command-rules. Using VisitorPattern
 *
 * @author Christian Deussen
 *
 */
public class EditPolicyConstraintVisitor extends AbstractEditPolicyRuleVisitor<Constraint> {

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
	
	public boolean checkRule(AbstractRule<Constraint> rule) 
	{
		if (rule instanceof Rule) {
			Constraint constraint = ((Rule<Constraint>) rule).getRule();
			if(constraint instanceof IsStepOut) {
				return this.isStepOut;
			}
		} 
		return super.checkRule(rule);
	}
}
