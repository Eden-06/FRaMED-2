package org.framed.iorm.ui.editPolicy;

import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.context.impl.CreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.CreateContext;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.framed.iorm.model.ModelElement;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.UIUtil;
import org.framed.iorm.ui.exceptions.NoDiagramFoundException;

import Editpolicymodel.AndConstraintRule;
import Editpolicymodel.ConstraintRule;
import Editpolicymodel.ContainsCompartment;
import Editpolicymodel.FalseConstraintRule;
import Editpolicymodel.InCompartment;
import Editpolicymodel.IsSourceType;
import Editpolicymodel.IsTargetType;
import Editpolicymodel.NotConstraintRule;
import Editpolicymodel.OrConstraintRule;
import Editpolicymodel.SourceEqualsTarget;
import Editpolicymodel.SourceEqualsTargetType;
import Editpolicymodel.TrueConstraintRule;
import compartment.AddCompartmentTypeContext;

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
	private Object context;
	
	@SuppressWarnings("unused")
	private Type type;

	private Diagram diagram;
	
	public ConstraintRuleVisitor(Object context, Type type, Diagram diagram) {
		this.context = context;
		this.type = type;
		this.diagram = diagram;
	}
	
	public Diagram getDiagramWithName(String name, Diagram rootDiagram)
	{
		Diagram containerDiagram = UIUtil.getContainerDiagramForAnyDiagram(rootDiagram);
		if(containerDiagram == null) throw new NoDiagramFoundException();
		for(Shape shape : containerDiagram.getChildren()) {
			if(shape instanceof Diagram) {
					if(((Diagram) shape).getName().equals(name))
						return ((Diagram) shape);
			}
		}
		return null;
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
		if(rule instanceof InCompartment) {
			return isInCompartmentRuleVisitor((InCompartment)rule);
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
		
		if(rule instanceof IsTargetType) {
			return isTargetTypeVisitor((IsTargetType)rule);
		}
		
		if(rule instanceof ContainsCompartment) {
			return containsCompartmentVisitor((ContainsCompartment)rule);
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
		
	private boolean isInCompartmentRuleVisitor(InCompartment rule) {
		org.framed.iorm.model.Shape parent = null;
		if(this.context instanceof AddCompartmentTypeContext) {
			AddCompartmentTypeContext  ctx = (AddCompartmentTypeContext) context;
			parent = ctx.getModelToLink().getParent();
		} else if(this.context instanceof AddContext) {
			AddContext  ctx = (AddContext) context;
			Diagram contextDiagram = (Diagram)ctx.getTargetContainer();
			if(contextDiagram.getName().startsWith("compartmentType"))
				return true;
		} else if(this.context instanceof CreateContext) {
			CreateContext  ctx = (CreateContext) context;
			Diagram contextDiagram = (Diagram)ctx.getTargetContainer();
			if(contextDiagram.getName().startsWith("compartmentType"))
				return true;
		}
		if(parent == null) {
			System.out.println("Parent null. Wrong context InCompartment(): " + this.context.getClass());
			return false;
		}

		String parentDiagramName = null;
		try {
			parentDiagramName = parent.getContainer().getParent().getName();
		} catch (Exception e) {}
		Diagram myDiagram = this.getDiagramWithName(parentDiagramName, this.diagram);
		if(myDiagram == null)
			return false;
		if(myDiagram.getName().startsWith("compartmentType"))
			return true;

		return false;
	}
	
	private boolean andRuleVisitor(AndConstraintRule rule) {
		for(ConstraintRule abstractRule : rule.getRules()) {
			if(!checkRule(abstractRule))
				return false;
		}
		return true;
	}
	
	private boolean isSourceTypeVisitor(IsSourceType rule) {
		Anchor sourceAnchor = this.getSourceAnchorFromContext(this.context);
		if(sourceAnchor == null) {
			System.out.println("failed isSourceType() sourceAnchor== null,  this.context: " + this.context.toString());
			return false;
		}
		ModelElement source = UIUtil.getModelElementForAnchor(sourceAnchor);
		return rule.getType().getLiteral().equals(source.getType().getLiteral());
	}
	
	private boolean isTargetTypeVisitor(IsTargetType rule) {
		Anchor anchor = this.getTargetAnchorFromContext(this.context);
		if(anchor == null) {
			System.out.println("failed isTargetType() anchor== null,  this.context: " + this.context.toString());
			return false;
		}
		ModelElement source = UIUtil.getModelElementForAnchor(anchor);
		return rule.getType().getLiteral().equals(source.getType().getLiteral());
	}
	
	private boolean containsCompartmentVisitor(ContainsCompartment rule) {
		System.out.println("containsCompartmentVisitor: TODO, implement!: " + this.diagram.getChildren().toString());
		return false;
	}
	
	private boolean sourceEqualsTargetVisitor(SourceEqualsTarget rule) {
		//System.out.println("class is: " + this.context.getClass());
		Anchor sourceAnchor = this.getSourceAnchorFromContext(this.context);
		ModelElement source = UIUtil.getModelElementForAnchor(sourceAnchor);
			
		Anchor targetAnchor = this.getTargetAnchorFromContext(this.context);
		ModelElement target = UIUtil.getModelElementForAnchor(targetAnchor);
		
		if(targetAnchor == null || sourceAnchor == null)
			return false;

		return source.hashCode() == target.hashCode();		
	}

	private Anchor getSourceAnchorFromContext(Object context) {
		Anchor sourceAnchor = null;
		if(this.context instanceof AddConnectionContext) {
			AddConnectionContext ctx = (AddConnectionContext) this.context;
			sourceAnchor = ctx.getSourceAnchor();
		} else if(this.context instanceof CreateConnectionContext) {
			CreateConnectionContext ctx = (CreateConnectionContext) this.context;
			sourceAnchor = ctx.getSourceAnchor();
		}
		return sourceAnchor;
	}

	private Anchor getTargetAnchorFromContext(Object context) {
		Anchor anchor = null;
		if(this.context instanceof AddConnectionContext) {
			AddConnectionContext ctx = (AddConnectionContext) this.context;
			anchor = ctx.getTargetAnchor();
		} else if(this.context instanceof CreateConnectionContext) {
			CreateConnectionContext ctx = (CreateConnectionContext) this.context;
			anchor = ctx.getTargetAnchor();
		}
		return anchor;
	}
	
	private boolean sourceEqualsTargetTypeVisitor(SourceEqualsTargetType rule) {
		//System.out.println("class is: " + this.context.getClass());
		try {
			Anchor sourceAnchor = this.getSourceAnchorFromContext(this.context);
			ModelElement source = UIUtil.getModelElementForAnchor(sourceAnchor);
			
			Anchor targetAnchor = this.getTargetAnchorFromContext(this.context);
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
