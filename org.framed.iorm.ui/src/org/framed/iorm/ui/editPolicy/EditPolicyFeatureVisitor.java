package org.framed.iorm.ui.editPolicy;

import java.util.ArrayList;
import java.util.List;

import org.framed.iorm.featuremodel.FRaMEDConfiguration;
import org.framed.iorm.featuremodel.FRaMEDFeature;

import Editpolicymodel.AbstractRule;
import Editpolicymodel.Feature;
import Editpolicymodel.IsFeature;
import Editpolicymodel.Rule;

/**
 * This class provides the rule-parse for the editPolicy-Mapping-configuration. Using VisitorPattern
 *
 * @author Christian Deussen
 *
 */
public class EditPolicyFeatureVisitor extends AbstractEditPolicyRuleVisitor<Feature> {

	/**
	 * current configuration of editor
	 */
	@SuppressWarnings("unused")
	private FRaMEDConfiguration configuration;

	public EditPolicyFeatureVisitor(FRaMEDConfiguration framedConfiguration)
	{
		super(framedConfiguration);
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
	
	public boolean checkRule(AbstractRule<Feature> rule) 
	{
		if (rule instanceof Rule) {
			Feature feature = ((Rule<Feature>) rule).getRule();
			if(feature instanceof IsFeature) {
				return featureNameVisitor((IsFeature)feature);
			}
		} 
		return super.checkRule(rule);
	}

	private boolean featureNameVisitor(IsFeature rule)
	{
 		List<String> features = new ArrayList<>();

 		for (FRaMEDFeature feature : this.configuration.getFeatures()) {
 			features.add(feature.getName().getName());
 			//System.out.println("EditPolicyHandler feature: " + feature.getName().getName());
 		}

		//if(features.contains(rule.getArgument())) {
		//	return true;
		//}
		return false;
	}
	
}
