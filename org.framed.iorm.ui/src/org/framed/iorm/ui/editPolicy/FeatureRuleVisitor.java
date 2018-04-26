package org.framed.iorm.ui.editPolicy;

import java.util.ArrayList;
import java.util.List;

import org.framed.iorm.featuremodel.FRaMEDConfiguration;
import org.framed.iorm.featuremodel.FRaMEDFeature;

import Editpolicymodel.AndFeatureRule;
import Editpolicymodel.FalseFeatureRule;
import Editpolicymodel.FeatureRule;
import Editpolicymodel.IsFeature;
import Editpolicymodel.NotFeatureRule;
import Editpolicymodel.OrFeatureRule;
import Editpolicymodel.TrueFeatureRule;

/**
 * This class provides the rule-parse for the editPolicy-Mapping-configuration. Using VisitorPattern
 *
 * @author Christian Deussen
 *
 */
public class FeatureRuleVisitor {

	/**
	 * current configuration of editor
	 */
	private FRaMEDConfiguration configuration;

	public FeatureRuleVisitor(FRaMEDConfiguration framedConfiguration)
	{
		this.configuration = framedConfiguration;
	}
	
	/**
	 * dispatch abstract rule
	 *
	 * returns whether this.cmd is allowed according to @param rule
	 *
	 * @param rule
	 * @return Boolean
	 */
	
	public boolean checkRule(FeatureRule rule) 
	{
			if(rule instanceof IsFeature) {
				return featureNameVisitor((IsFeature)rule);
			}
			if (rule instanceof AndFeatureRule)
				return andRuleVisitor((AndFeatureRule)rule);
			
			if (rule instanceof OrFeatureRule)
				return orRuleVisitor((OrFeatureRule)rule);
			
			if (rule instanceof NotFeatureRule)
				return notRuleVisitor((NotFeatureRule)rule);
			
			if (rule instanceof TrueFeatureRule)
				return true;		
			
			if (rule instanceof FalseFeatureRule)
				return false;

			System.out.println("checkRule for " + rule.getClass().toString() + " not implemented");
			return true;
	}

	private boolean featureNameVisitor(IsFeature rule)
	{
 		List<String> features = new ArrayList<>();

 		for (FRaMEDFeature feature : this.configuration.getFeatures()) {
 			features.add(feature.getName().getName());
 			//System.out.println("EditPolicyHandler featureEnabled: " + feature.getName().getName());
 		}

 		if(features.contains(rule.getFeatureName().getName())) {
			return true;
		}
		return false;
	}
	
	
	private boolean andRuleVisitor(AndFeatureRule rule) {
		for(FeatureRule abstractRule : rule.getRules()) {
			if(!checkRule(abstractRule))
				return false;
		}
		return true;
	}
	
	private boolean orRuleVisitor(OrFeatureRule rule) {
		for(FeatureRule abstractRule : rule.getRules()) {
			if(checkRule(abstractRule))
				return true;
		}
		return false;
	}
		
	private boolean notRuleVisitor(NotFeatureRule rule) {
		return !checkRule(rule.getRule());
	}		
}
