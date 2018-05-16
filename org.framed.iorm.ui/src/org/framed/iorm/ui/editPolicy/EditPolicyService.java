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
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.osgi.framework.Bundle;

import org.framed.iorm.featuremodel.FRaMEDConfiguration;
import org.framed.iorm.ui.UIUtil;

/**
 * This class provides canExecute(Command cmd) which checks whether a given
 * command may execute according to an editPolicies
 *
 * @author Christian Deussen
 *
 */
public class EditPolicyService {

	private static List<editpolicymodel.Model> editpolicymodels;

	/**
	 * For every diagram one editpolicyHandler
	 */
	private static Map<String, EditPolicyHandler> editPolicyHandlers;
	
	public static void initEditPolicyService() {
		EditPolicyService.editpolicymodels = new LinkedList<>();
		EditPolicyService.editPolicyHandlers = new HashMap<>();

		loadAllFiles();
		checkEditpolicyConsistency();
	}
	
	public static EditPolicyHandler getHandler(Diagram diagram0) 
	{
		if(diagram0 == null) {
			System.out.println("diagram in getHandler is null!");
			return null;
		}
		Diagram diagram = UIUtil.getMainDiagramForAnyDiagram(diagram0);

		if(!EditPolicyService.editPolicyHandlers.containsKey(diagram.getName())) { 
			EditPolicyHandler handler = new EditPolicyHandler(diagram);
			editPolicyHandlers.put(diagram.getName(), handler);
			FRaMEDConfiguration config = UIUtil.getRootModelForAnyDiagram(diagram).getFramedConfiguration();
			handler.updateConfig(editpolicymodels, config);
		}
		
		return EditPolicyService.editPolicyHandlers.get(diagram.getName());
	}

	public static void setConfiguration(Diagram diagram, FRaMEDConfiguration config) 
	{ 
		diagram = UIUtil.getMainDiagramForAnyDiagram(diagram);
		EditPolicyService.getHandler(diagram).updateConfig(editpolicymodels, config);
	}

	/*
	 * Load editPolicy Model from file.
	 */
	private static void loadEditPolicyFile(String filename) {
		System.out.println("EDITPOLICY loading: " + filename);

		try {
			ResourceSet set = new ResourceSetImpl();
			Resource res = set.createResource(URI.createURI(filename));
			res.load(Collections.EMPTY_MAP);
			if (res.getContents().size() > 0 && res.getContents().get(0) instanceof editpolicymodel.Model) {

				EditPolicyService.editpolicymodels.add((editpolicymodel.Model) res.getContents().get(0));
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
	 * checks if the package part of a file url starts and ends with an _
	 * 
	 * @param url
	 *            the string url to check against
	 * @param sourceFolder
	 *            the source folder in which the class is located in
	 * @return if the package part of a class url starts and ends with an _
	 */
	private static boolean isPackageMarkedAsNotUsed(String url) {
		url = url.substring(url.lastIndexOf('/')+1, url.length());
		return url.startsWith("_") && url.endsWith("_");
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
				if (!isPackageMarkedAsNotUsed(url.toString())) {
					loadEditPolicyFile(url.toString());
				}
			}
		}
		if (coreFileURLs != null) {
			for (URL url : coreFileURLs) {
				if (!isPackageMarkedAsNotUsed(url.toString())) {
					loadEditPolicyFile(url.toString());
				}
			}
		}
	}

	public static void setDirty() {
		//empty handlers to reload config
		EditPolicyService.editPolicyHandlers = new HashMap<>();
	}
	
	/**
	 * do SAT checking whether policies can be used together
	 */
	private static void checkEditpolicyConsistency() {
		//System.out.println("checking editpolicy consistency");
		return;
	}

}