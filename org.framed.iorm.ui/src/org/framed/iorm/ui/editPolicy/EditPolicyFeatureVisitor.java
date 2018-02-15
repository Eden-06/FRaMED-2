package org.framed.iorm.ui.editPolicy;

import org.framed.iorm.featuremodel.FRaMEDConfiguration;

import Editpolicymodel.AbstractFeatureRule;
import Editpolicymodel.AndFeatureRule;
import Editpolicymodel.FalseFeatureRule;
import Editpolicymodel.NotFeatureRule;
import Editpolicymodel.TrueFeatureRule;


/**
 * This class provides the rule-parse for the editPolicy-Mapping-configuration. Using VisitorPattern
 *
 * @author Christian Deussen
 *
 */
public class EditPolicyFeatureVisitor {

	/**
	 * current configuration of editor
	 */
	@SuppressWarnings("unused")
	private FRaMEDConfiguration configuration;

	public EditPolicyFeatureVisitor(FRaMEDConfiguration framedConfiguration)
	{
		this.configuration = framedConfiguration;
	}
	
	/**
	 * root Visitor of mappingRule:
	 * dispatches to specific rule
	 *
	 * returns whether the given rule is enabled according to configuration
	 *
	 * @param rule
	 * @return Boolean
	 */
	
	public boolean featureRuleVisitor(AbstractFeatureRule rule)
	{
		if (rule instanceof AndFeatureRule)
			return andRuleVisitor(rule);
		
		if (rule instanceof NotFeatureRule)
			return notRuleVisitor(rule);

		if (rule instanceof TrueFeatureRule)
			return true;

		if (rule instanceof FalseFeatureRule)
			return false;

		System.out.println("NodeMappingVisitor for " + rule.getClass().toString() + " not implemented");
		return true;
	}
	
	private boolean andRuleVisitor(AbstractFeatureRule rule) {
		return true;
	}
	
	private boolean notRuleVisitor(AbstractFeatureRule rule) {
		return true;
	}
	
}
