package org.framed.iorm.ui.editPolicy;

import java.lang.reflect.Method;

import org.eclipse.gef.commands.Command;
import org.framed.iorm.model.Model;
import org.framed.iorm.model.ModelElement;
import org.framed.iorm.model.Relation;
import org.framed.iorm.model.Shape;
import org.framed.iorm.model.Type;

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
	private Command cmd;

	/**
	 * whether editor is in StepIn/StepOut-View
	 */
	private boolean isStepOut;

	public EditPolicyRuleVisitor(Command cmd, boolean isStepOut) {
		this.cmd = cmd;
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
	public boolean abstractRuleVisitor(model.AbstractRule rule) {
		System.out.println("NodeVisitor for " + rule.getClass().toString() + " not implemented");
		return true;
	}

}