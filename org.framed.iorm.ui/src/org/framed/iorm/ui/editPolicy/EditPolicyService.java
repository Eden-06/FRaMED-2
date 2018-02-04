package org.framed.iorm.ui.editPolicy;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.naming.Context;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.framed.iorm.featuremodel.FRaMEDConfiguration;
import org.framed.iorm.featuremodel.FRaMEDFeature;
import org.framed.iorm.model.*;
import org.framed.iorm.ui.UIUtil;

import model.*;
import model.Model;;

/**
 * This class provides canExecute(Command cmd) which checks whether a given command may execute according to editPolicies
 *
 * @author Christian Deussen
 *
 */
public class EditPolicyService {

	/**
	 * current configuration
	 */
	private static Map<String, FRaMEDConfiguration> configurations;

	/**
	 * xmi model
	 */
	private static Model model;
	/**
	 * list of Policy-Rules which need to be evaluated
	 */
	private static Map<String, Set<Policy>> policies;

	public static void initEditPolicyService()
	{
		configurations = new HashMap<>();
		policies = new HashMap<>();
		model = loadModel();
	}
	
	private static Set<Policy> getPolicies(Diagram diagram)
	{
		Diagram mainDiagram = UIUtil.getMainDiagramForAnyDiagram(diagram);
		
		if(!configurations.containsKey(mainDiagram.getName())) {
			//get config from diagram
			FRaMEDConfiguration config = UIUtil.getRootModelForAnyDiagram(mainDiagram).getFramedConfiguration();
			configurations.put(diagram.getName(), config);
			
			//load all rules which are activated by current configuration
			Set<Policy> policySet = new HashSet<>();

			EditPolicyConfigurationVisitor editPolicyConfigurationVisitor = new EditPolicyConfigurationVisitor(config);
			for (Mapping mapping : (Mapping[])  model.getConfiguration().getMappings().toArray()) {
				if (editPolicyConfigurationVisitor.abstractMappingRuleVisitor(mapping.getRule()))
					policySet.add(mapping.getPolicy());
			}
			
			policies.put(diagram.getName(), policySet);
		}

		return policies.get(diagram.getName());
	}

	public static boolean canAdd(IAddContext context, Diagram diagram) {
		 // System.out.println("---can add check----");

		return true;
	}
	
	public static boolean canCreate(ICreateConnectionContext context, Diagram diagram) {
		 // System.out.println("---can create check----");

		return true;
	}
	
	public static boolean canReconnect(IReconnectionContext context, Diagram diagram) {
		 // System.out.println("---can reconnect check----");

		return true;
	}
	
	public static boolean canAdd(IAddConnectionContext context, Diagram diagram) {
		 // System.out.println("---can reconnect check----");

		return true;
	}
	
	/**
	 * canCreate is called to check whether a command is allowed to execute in a given situation
	 * checks each policy
	 *
	 * this function
	 * @param cmd
	 * @return Boolean
	 */
	public static boolean canCreate(ICreateContext context, Diagram diagram) 
	{	
		  //System.out.println("---can create check----");
		  
			EditPolicyRuleVisitor editPolicyRuleVisitor = new EditPolicyRuleVisitor(context, false);
			for (Policy policy : getPolicies(diagram)) {
				if (!editPolicyRuleVisitor.abstractRuleVisitor(policy.getRule())) {
					System.out.println("Not Allowed because of: " + policy.getName());
					return false;
				}
			}
			//System.out.println("-------------------------------");

		
		return true;
	} 

	/*
	 * Load editPolicy ecore Model from file.
	 */
	private static Model loadModel() {
		
		String filename = new String("platform:/plugin/org.framed.iorm.editPolicy.model/model/noRules.xmi");
		//String filename = new String("platform:/plugin/org.framed.iorm.editPolicy.model/model/basicRules.xmi");
		//String filename = new String("platform:/plugin/org.framed.iorm.editPolicy.model/model/featureRules.xmi");
		//String filename = new String("platform:/plugin/org.framed.iorm.editPolicy.model/model/allRules.xmi");
		
		try {
			ResourceSet set = new ResourceSetImpl();
			Resource res = set.createResource(URI.createURI(filename));
			res.load(Collections.EMPTY_MAP);
			// if there are file contents in this directory
			if (res.getContents().size() > 0
					&& res.getContents().get(0) instanceof Model) {
				// load test file and add it to test list

				return (Model) res.getContents().get(0);
			}
		} catch (Exception e) {
			System.err.println("Was not able to load xmi:  \"" + filename + "\" due : " + e.toString());
			for (StackTraceElement el : e.getStackTrace())
				System.err.println(el.toString());
		}
		
		System.err.println("Was not able to load xmi:  \"" + filename + "\" due : null");
		return null;
	}

	/**
	 * This method reloads the configuration. it is called when
	 * configuration has changed.
	 *
	 **/
	/*
	public void update(final ORMGraphicalEditor.EditorType type) {
		this.loadPolicyRules();
	}
			*/

}