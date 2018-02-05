package org.framed.iorm.ui.editPolicy;

/**
 * This class provides the rule-parse for the command-rules. Using VisitorPattern
 *
 * @author Christian Deussen
 *
 */
public class EditPolicyRuleVisitor {

	
	/**
	 * command to check rules against
	 */
	@SuppressWarnings("unused")
	private Object context;

	/**
	 * whether editor is in StepIn/StepOut-View
	 */
	@SuppressWarnings("unused")
	private boolean isStepOut;

	public EditPolicyRuleVisitor(Object context, boolean isStepOut) {
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
	/*
	public boolean abstractRuleVisitor(model.AbstractRule rule) {
		System.out.println("NodeVisitor for " + rule.getClass().toString() + " not implemented");
		return true;
	}
	*/

}