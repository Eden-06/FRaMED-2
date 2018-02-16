package org.framed.iorm.ui.editPolicy;

import java.util.ArrayList;
import java.util.List;

import org.framed.iorm.featuremodel.FRaMEDConfiguration;
import org.framed.iorm.featuremodel.FRaMEDFeature;

import Editpolicymodel.AbstractFeatureRule;
import Editpolicymodel.AndFeatureRule;
import Editpolicymodel.FalseFeatureRule;
import Editpolicymodel.NameFeatureRule;
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
		
		if (rule instanceof NameFeatureRule)
			return featureNameRuleVisitor(rule);

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
	
	private boolean featureNameRuleVisitor(AbstractFeatureRule rule)
	{
 		List<String> features = new ArrayList<>();

 		for (FRaMEDFeature feature : this.configuration.getFeatures()) {
 			features.add(feature.getName().getName());
 			//System.out.println("EditPolicyHandler feature: " + feature.getName().getName());
 		}

		if(features.contains(rule.getArgument())) {
			return true;
		}
		return false;
	}
	
}
