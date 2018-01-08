package org.framed.iorm.ui.wizards;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.internal.services.GraphitiUiInternal;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.literals.NameLiterals;
import org.framed.iorm.ui.literals.UILiterals;
import org.framed.iorm.ui.util.UIUtil;

/**
 * This class implements an Eclipse wizard to create a role model.
 * <p>
 * The code in this class is mostly taken and customized from the class "CreateDiagramWizard.java" by Graphiti. 
 * You can find this class in the github repository of Graphiti. Look there for reference too.
 */
@SuppressWarnings("restriction")
public class RoleModelWizard extends BasicNewResourceWizard {
	
	/**
	 * identifier literals for the diagram type and the multipage editors identifier
	 * gathered from {@link IdentifierLiterals}
	 */
	private final String DIAGRAM_TYPE = UILiterals.DIAGRAM_TYPE_ID,
						 EDITOR_ID = UILiterals.EDITOR_ID;
	
	/**
	 * the value used to identify the kind of diagrams for the <em>container</em> and <em>main diagram</em>
	 * <p>
	 * If its not clear what <em>container diagram</em> and <em>main diagram</em> means, see 
	 * {@link #createEmfFileForDiagram} for reference.
	 */
	private final String DIAGRAM_KIND_CONTAINER_DIAGRAM = UILiterals.DIAGRAM_KIND_CONTAINER_DIAGRAM,
						 DIAGRAM_KIND_MAIN_DIAGRAM = UILiterals.DIAGRAM_KIND_MAIN_DIAGRAM;
	
	/**
	 * name literals for the file extension of the new diagram, the wizard page and window gathered from {@link NameLiterals}
	 */
	private final String FILE_EXTENSION_FOR_DIAGRAMS = UILiterals.FILE_EXTENSION_FOR_DIAGRAMS,
						 WIZARD_PAGE_NAME = UILiterals.WIZARD_PAGE_NAME,
						 WIZARD_WINDOW_NAME = UILiterals.WIZARD_WINDOW_NAME,
						 CONTAINER_DIAGRAM_NAME = UILiterals.CONTAINER_DIAGRAM_NAME;
	
	/**
	 * the text literals for the wizard errors gathered from {@link TextLiterals}
	 */
	private final String WIZARD_ERROR_NO_PROJECT_TITLE = UILiterals.WIZARD_ERROR_NO_PROJECT_TITLE,
						 WIZARD_ERROR_NO_PROJECT_TEXT = UILiterals.WIZARD_ERROR_NO_PROJECT_TEXT,
						 WIZARD_ERROR_DEADLOCK_DANGER = UILiterals.WIZARD_ERROR_DEADLOCK_DANGER,
						 WIZARD_ERROR_SAVING_FAILED = UILiterals.WIZARD_ERROR_SAVING_FAILED;
	
	/**
	 * the wizard page used by this wizard
	 */
	private RoleModelWizardPage roleModelWizardPage;
	
	/**
	 * creates and adds and {@link RoleModelWizardPage} to the wizard
	 */
	@Override
	public void addPages() {
		super.addPages();
		roleModelWizardPage = new RoleModelWizardPage(WIZARD_PAGE_NAME); 
		addPage(roleModelWizardPage);
	}

	/**
	 * initalize method
	 * <p>
	 * sets the windows title
	 */
	@Override
	public void init(IWorkbench workbench, IStructuredSelection currentSelection) {
		super.init(workbench, currentSelection);
		setWindowTitle(WIZARD_WINDOW_NAME);
	}

	/**
	 * performs the creation of a role model using the following steps:
	 * <p>
	 * Step 1: ask for the diagrams name via the wizard page
	 * Step 2: checks if project is selected into which the diagram can be created
	 * Step 3: create a diagram, write it to a file and opens it
	 */
	@Override
	public boolean performFinish() {
		//Step 1
		final String diagramName = roleModelWizardPage.getText();
		//Step 2
		IProject project = null;
		Object element = getSelection().getFirstElement();
		if (element instanceof IProject) {
			project = (IProject) element;
		} else if (element instanceof IFolder) {
			IFolder diagramFolder = (IFolder) element;
			project = diagramFolder.getProject();
		}
		if (project == null || !project.isAccessible()) {
			MessageDialog.openError(getShell(), WIZARD_ERROR_NO_PROJECT_TITLE, WIZARD_ERROR_NO_PROJECT_TEXT);
			return false;
		}
		//Step 3
		Diagram mainDiagram = Graphiti.getPeCreateService().createDiagram(DIAGRAM_TYPE, diagramName, true);
		UIUtil.setDiagram_KindValue(mainDiagram, DIAGRAM_KIND_MAIN_DIAGRAM);
		IFile diagramFile = project.getFile(diagramName + FILE_EXTENSION_FOR_DIAGRAMS);
		URI uri = URI.createPlatformResourceURI(diagramFile.getFullPath().toString(), true);
		createEmfFileForDiagram(uri, mainDiagram);
		IFileEditorInput editorInput = new FileEditorInput(diagramFile);
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(editorInput, EDITOR_ID);
		} catch (PartInitException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * creates an emf file with a specific structure a given diagram
	 * <p>
	 * The structure looks as following:<br>
	 * <ul>
	 *   <li>xml</li>
	 * 	   <ul>
	 * 	  	 <li>container diagram</li>
	 *         <ul>
	 *           <li>main diagram</li>
	 *         </ul>
	 *     </ul>
	 * </ul>      
	 * (1) The container diagram is not intended to be displayed, since it just a container for the <em>main diagram</em>
	 *     and the diagrams of groups and compartment types.<br>
	 * (2) The <em>main diagram</em> is the one which is showed if the user don't steped in a group or compartment type.
	 * <p>
	 * The code in this class is mostly taken and customized from the class "FileService.java" by Graphiti. 
	 * You can find this class in the github repository of Graphiti. Look there for reference too.
	 * @param diagramResourceUri the URI to save the emf file to
	 * @param mainDiagram the <em>main diagram<em> to create the emf file file
	 */
	public void createEmfFileForDiagram(URI diagramResourceUri, final Diagram mainDiagram) {
		// Create a resource set and EditingDomain
				final TransactionalEditingDomain editingDomain = GraphitiUiInternal.getEmfService()
						.createResourceSetAndEditingDomain();
				final ResourceSet resourceSet = editingDomain.getResourceSet();
				// Create a resource for this file.
				final Resource resource = resourceSet.createResource(diagramResourceUri);
				final CommandStack commandStack = editingDomain.getCommandStack();
				commandStack.execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						resource.setTrackingModification(true);
						Diagram containerDiagram = Graphiti.getPeCreateService().createDiagram(DIAGRAM_TYPE, CONTAINER_DIAGRAM_NAME);
						UIUtil.setDiagram_KindValue(containerDiagram, DIAGRAM_KIND_CONTAINER_DIAGRAM);
						resource.getContents().add(containerDiagram);
						((Diagram) resource.getContents().get(0)).getChildren().add(mainDiagram);
					}
				});
				save(editingDomain, Collections.<Resource, Map<?, ?>> emptyMap());
				editingDomain.dispose();
	}

	/**
	 * saves the created emf file
	 * <p>
	 * The code in this class is mostly taken and customized from the class "FileService.java" by Graphiti. 
	 * You can find this class in the github repository of Graphiti. Look there for reference too.
	 * @param editingDomain
	 * @param options
	 */
	private void save(TransactionalEditingDomain editingDomain, Map<Resource, Map<?, ?>> options) {
		final Map<URI, Throwable> failedSaves = new HashMap<URI, Throwable>();
		final IWorkspaceRunnable wsRunnable = new IWorkspaceRunnable() {
			public void run(final IProgressMonitor monitor) throws CoreException {
				final Runnable runnable = new Runnable() {
					public void run() {
						Transaction parentTx;
						if (editingDomain != null
								&& (parentTx = ((TransactionalEditingDomainImpl) editingDomain).getActiveTransaction()) != null) {
							do {
								if (!parentTx.isReadOnly()) {
									throw new IllegalStateException(WIZARD_ERROR_DEADLOCK_DANGER);
								}
							} while ((parentTx = ((TransactionalEditingDomainImpl) editingDomain).getActiveTransaction().getParent()) != null);
						}
						final EList<Resource> resources = editingDomain.getResourceSet().getResources();
						Resource[] resourcesArray = new Resource[resources.size()];
						resourcesArray = resources.toArray(resourcesArray);
						final Set<Resource> savedResources = new HashSet<Resource>();
						for (int i = 0; i < resourcesArray.length; i++) {
							final Resource resource = resourcesArray[i];
							if (resource.isModified()) {
								try {
									resource.save(options.get(resource));
									savedResources.add(resource);
								} catch (final Throwable t) {
									failedSaves.put(resource.getURI(), t);
				}	}	}	}	};
				try {
					editingDomain.runExclusive(runnable);
				} catch (final InterruptedException e) {
					throw new RuntimeException(e);
				}
				editingDomain.getCommandStack().flush();
			}
		};
		try {
			ResourcesPlugin.getWorkspace().run(wsRunnable, null);
			if (!failedSaves.isEmpty()) {
				throw new WrappedException(WIZARD_ERROR_SAVING_FAILED, new RuntimeException()); 			}
		} catch (final CoreException e) {
			final Throwable cause = e.getStatus().getException();
			if (cause instanceof RuntimeException) {
				throw (RuntimeException) cause;
			}
			throw new RuntimeException(e);
	}	}	
}	