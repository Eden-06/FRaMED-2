package org.framed.iorm.ui.editPolicy;

import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.CreateConnectionContext;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.framed.iorm.model.ModelElement;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.UIUtil;

import Editpolicymodel.AndConstraintRule;
import Editpolicymodel.ConstraintRule;
import Editpolicymodel.FalseConstraintRule;
import Editpolicymodel.IsSourceType;
import Editpolicymodel.IsStepIn;
import Editpolicymodel.NotConstraintRule;
import Editpolicymodel.OrConstraintRule;
import Editpolicymodel.SourceEqualsTarget;
import Editpolicymodel.SourceEqualsTargetType;
import Editpolicymodel.TrueConstraintRule;
import Editpolicymodel.TypeEnum;
import de.ovgu.featureide.fm.ui.editors.featuremodel.figures.anchors.TargetAnchor;

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
	
	private Type type;

	public ConstraintRuleVisitor(Object context, Type type, boolean isStepOut) {
		this.context = context;
		this.isStepOut = isStepOut;
		this.type = type;
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
				System.out.println("isStepOutRule");
				return this.isStepOut;
			}
		
		if (rule instanceof AndConstraintRule)
			return andRuleVisitor((AndConstraintRule)rule);
		
		if (rule instanceof OrConstraintRule)
			return orRuleVisitor((OrConstraintRule)rule);
		
		if (rule instanceof NotConstraintRule)
			return notRuleVisitor((NotConstraintRule)rule);
		
		if(rule instanceof IsSourceType) {
			return isSourceTypeVisitor((IsSourceType)rule);
		}
		
		if(rule instanceof SourceEqualsTargetType) {
			return sourceEqualsTargetTypeVisitor((SourceEqualsTargetType)rule);
		}
		
		if(rule instanceof SourceEqualsTarget) {
			return sourceEqualsTargetVisitor((SourceEqualsTarget)rule);
		}
		
		if(rule instanceof IsSourceType) {
			return isSourceTypeVisitor((IsSourceType)rule);
		}
		
		if (rule instanceof TrueConstraintRule) {
			return true;		
		}
		
		if (rule instanceof FalseConstraintRule) {
			return false;
		}

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
	
	private boolean isSourceTypeVisitor(IsSourceType rule) {
		//System.out.println("class is: " + this.context.getClass());
		try {
			AddConnectionContext ctx = (AddConnectionContext) this.context;
			Anchor sourceAnchor = ctx.getSourceAnchor();
			ModelElement source = UIUtil.getModelElementForAnchor(sourceAnchor);
			return rule.getType().getLiteral().equals(source.getType().getLiteral());
		} catch(Exception e) {
			System.out.println("failed isSourceType: " + e.getMessage());
		}
		
		return false;
	}
	
	private boolean sourceEqualsTargetVisitor(SourceEqualsTarget rule) {
		//System.out.println("class is: " + this.context.getClass());
		AddConnectionContext ctx = (AddConnectionContext) this.context;
			Anchor sourceAnchor = ctx.getSourceAnchor();
			ModelElement source = UIUtil.getModelElementForAnchor(sourceAnchor);
			
			Anchor targetAnchor = ctx.getTargetAnchor();
			ModelElement target = UIUtil.getModelElementForAnchor(targetAnchor);

			System.out.println("sourceEqualsTargetVisitor comparison: " + source.hashCode()  + " == " + target.hashCode());

			return source.hashCode() == target.hashCode();		
	}

	private boolean sourceEqualsTargetTypeVisitor(SourceEqualsTargetType rule) {
		//System.out.println("class is: " + this.context.getClass());
		try {
			AddConnectionContext ctx = (AddConnectionContext) this.context;
			Anchor sourceAnchor = ctx.getSourceAnchor();
			ModelElement source = UIUtil.getModelElementForAnchor(sourceAnchor);
			
			Anchor targetAnchor = ctx.getTargetAnchor();
			ModelElement target = UIUtil.getModelElementForAnchor(targetAnchor);

			System.out.println("sourceEqualsTargetTypeVisitor comparison: " + source.getType().getLiteral()  + " == " + target.getType().getLiteral());

			return target.getType().getLiteral().equals(source.getType().getLiteral());
		} catch(Exception e) {
			System.out.println("failed sourceEqualsTargetVisitor: " + e.getMessage());
		}
		
		return false;
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
