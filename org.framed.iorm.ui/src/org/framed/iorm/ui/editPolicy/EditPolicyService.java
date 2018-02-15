package org.framed.iorm.ui.editPolicy;

import java.net.URL;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.osgi.framework.Bundle;
import org.framed.iorm.featuremodel.FRaMEDConfiguration;
import org.framed.iorm.model.*;
import org.framed.iorm.ui.UIUtil;

/**
 * This class provides canExecute(Command cmd) which checks whether a given
 * command may execute according to an editPolicies
 *
 * @author Christian Deussen
 *
 */
public class EditPolicyService {

	/**
	 * configuration for each diagram
	 */
	private static Map<String, FRaMEDConfiguration> configurations;

	private static List<Editpolicymodel.Model> editpolicymodels;

	/**
	 * for each diagram a list with activated policies
	 */
	private static Map<String, List<Editpolicymodel.Policy>> activatedPolicies;

	public static void initEditPolicyService() {
		EditPolicyService.editpolicymodels = new LinkedList<>();
		EditPolicyService.activatedPolicies = new HashMap<>();
		EditPolicyService.configurations = new HashMap<>();

		loadAllFiles();
		checkEditpolicyConsistency();
		// EditPolicyService.getActivatedPolicies();
	}

	private static List<Editpolicymodel.Policy> getActivatedPolicies(Diagram diagram) { 
		Diagram mainDiagram = UIUtil.getMainDiagramForAnyDiagram(diagram);

		if(!EditPolicyService.configurations.containsKey(mainDiagram.getName())) { 
			FRaMEDConfiguration config = UIUtil.getRootModelForAnyDiagram(mainDiagram).getFramedConfiguration();
			EditPolicyService.configurations.put(diagram.getName(), config);

			//load all rules which are activated by current configuration
			List<Editpolicymodel.Policy> policyList = new LinkedList<>();

			EditPolicyFeatureVisitor editPolicyFeatureVisitor = new EditPolicyFeatureVisitor(config); 
			for(Editpolicymodel.Model model : editpolicymodels) {
				for(Editpolicymodel.Policy policy : model.getPolicy()) {
					if(editPolicyFeatureVisitor.featureRuleVisitor(policy.getFeatureRule())) {
						policyList.add(policy); 
					}
				}
			}

			activatedPolicies.put(diagram.getName(), policyList);
		}
		return activatedPolicies.get(diagram.getName()); 
	}

	public static boolean canAdd(IAddContext context, Diagram diagram) {
		// System.out.println("---can add check----");
		return true;
	}

	public static boolean canCreate(ICreateConnectionContext context, Diagram diagram) {
		// System.out.println("---can create check----");
		return true;
	}

	public static boolean canStart(ICreateConnectionContext context, Diagram diagram) {
		// System.out.println("---can create check----");
		return true;
	}

	public static boolean canExecute(ICustomContext context, Diagram diagram) {
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
	 * canCreate is called to check whether a command is allowed to execute in a
	 * given situation checks each policy
	 *
	 * this function
	 * 
	 * @param cmd
	 * @return Boolean
	 */
	public static boolean canCreate(ICreateContext context, Diagram diagram) {
		// System.out.println("---can create check----");

		/*
		 * EditPolicyRuleVisitor editPolicyRuleVisitor = new
		 * EditPolicyRuleVisitor(context, false); for (Policy policy :
		 * getPolicies(diagram)) { if
		 * (!editPolicyRuleVisitor.abstractRuleVisitor(policy.getRule())) {
		 * System.out.println("Not Allowed because of: " + policy.getName()); return
		 * false; } }
		 */
		// System.out.println("-------------------------------");
		return true;
	}

	/*
	 * Load editPolicy ecore Model from file.
	 */
	private static void loadEditPolicyFile(String filename) {
		System.out.println("EDITPOLICY loading: " + filename);

		try {
			ResourceSet set = new ResourceSetImpl();
			Resource res = set.createResource(URI.createURI(filename));
			res.load(Collections.EMPTY_MAP);
			if (res.getContents().size() > 0 && res.getContents().get(0) instanceof Editpolicymodel.Model) {

				EditPolicyService.editpolicymodels.add((Editpolicymodel.Model) res.getContents().get(0));
			} else {
				System.err.println("Was not able to load xmi: \"" + filename + "\" due : null");
			}
		} catch (Exception e) {
			System.err.println("Was not able to load xmi:  \"" + filename + "\" due : " + e.toString());
			for (StackTraceElement el : e.getStackTrace())
				System.err.println(el.toString());
		}
	}

	/**
	 * This method reloads the configuration. it is called when configuration has
	 * changed.
	 *
	 **/
	/*
	 * public void update(final ORMGraphicalEditor.EditorType type) {
	 * this.loadPolicyRules(); }
	 */

	/**
	 * checks if the package part of a file url starts and ends with an _
	 * 
	 * @param url
	 *            the string url to check against
	 * @param sourceFolder
	 *            the source folder in which the class is located in
	 * @return if the package part of a class url starts and ends with an _
	 */
	private static boolean packageMarkedAsNotUsed(String url, String sourceFolder) {
		url = url.substring(url.indexOf(sourceFolder) + sourceFolder.length());
		url = url.substring(0, url.indexOf("/"));
		if (url.startsWith("_") && url.endsWith("_"))
			return true;
		return false;
	}

	private static void loadAllFiles() {
		Bundle UIBundle = Platform.getBundle("org.framed.iorm.ui");

		List<URL> moduleFileURLs = null, coreFileURLs = null;
		Enumeration<URL> moduleFileEnumeration = UIBundle.findEntries("/modules", "*.editpolicy", true),
				coreFileEnumeration = UIBundle.findEntries("/core", "*.editpolicy", true);
		if (moduleFileEnumeration != null)
			moduleFileURLs = Collections.list(moduleFileEnumeration);
		if (coreFileEnumeration != null)
			coreFileURLs = Collections.list(coreFileEnumeration);

		if (moduleFileURLs != null) {
			for (URL url : moduleFileURLs) {
				if (!packageMarkedAsNotUsed(url.toString(), "modules/")) {
					loadEditPolicyFile(url.toString());
				}
			}
		}
		if (coreFileURLs != null) {
			for (URL url : coreFileURLs) {
				if (!packageMarkedAsNotUsed(url.toString(), "core/")) {
					loadEditPolicyFile(url.toString());
				}
			}
		}
	}

	/**
	 * do SAT checking whether policies can be used together
	 */
	private static void checkEditpolicyConsistency() {
		return;
	}

}