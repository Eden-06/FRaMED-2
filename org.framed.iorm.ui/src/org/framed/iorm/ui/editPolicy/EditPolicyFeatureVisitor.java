package org.framed.iorm.ui.editPolicy;

import org.framed.iorm.featuremodel.FRaMEDConfiguration;

import Editpolicymodel.AbstractFeatureRule;


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
		System.out.println("NodeMappingVisitor for " + rule.getClass().toString() + " not implemented");
		return false;
	}
	
}
