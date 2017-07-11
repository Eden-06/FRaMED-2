package org.framed.iorm.ui.wizards;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;

/**
 * This class creates an Eclipse wizard is used to create a role model project
 * <p>
 * The code in this class is mostly taken and customized from the class "CreateSampleProjectWizard.java" by Graphiti. 
 * You can find this class in the github repository of Graphiti. Look there for reference too.
 */
public class RoleModelProjectWizard extends BasicNewProjectResourceWizard {

	/**
	 * evaluates if the wizard can be finished and creates the project if yes
	 */
	@Override
	public boolean performFinish() {
		if (!super.performFinish()) return false;
		IProject newProject = getNewProject();
		IProjectDescription description;
		try {
			description = newProject.getDescription();
			newProject.setDescription(description, null);
		} catch (CoreException e) { e.printStackTrace();}
		return true;
	}
}
