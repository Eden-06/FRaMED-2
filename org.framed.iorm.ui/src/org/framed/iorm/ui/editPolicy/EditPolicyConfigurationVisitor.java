package org.framed.iorm.ui.editPolicy;

import java.util.ArrayList;
import java.util.List;

import org.framed.iorm.featuremodel.FRaMEDConfiguration;
import org.framed.iorm.featuremodel.FRaMEDFeature;
import org.framed.iorm.model.Model.*;
import model.*;

/**
 * This class provides the rule-parse for the editPolicy-Mapping-configuration. Using VisitorPattern
 *
 * @author Christian Deussen
 *
 */
public class EditPolicyConfigurationVisitor {

	/**
	 * current configuration of editor
	 */
	private FRaMEDConfiguration configuration;

	public EditPolicyConfigurationVisitor(FRaMEDConfiguration framedConfiguration)
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
	public boolean abstractMappingRuleVisitor(AbstractMappingRule rule)
	{
		System.out.println("NodeMappingVisitor for " + rule.getClass().toString() + " not implemented");
		return false;
	}
}
