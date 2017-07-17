package org.framed.iorm.ui.multipage;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.editor.DiagramEditorInput;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.exceptions.InvalidTypeOfEditorInputException;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.util.DiagramUtil;
import org.framed.iorm.ui.util.EditorInputUtil;
import org.framed.iorm.ui.util.PropertyUtil;

/**
 * This operation offers a register and a synchronizing functionality for multipage editors.
 * <p>
 * This is needed if there are multiple multipage editors opened at the same time. Since they all work on different
 * editor inputs and resources a synchronization is needed. For the implementation of this see {@link #synchronize()}.
 * @author Kevin Kassin
 */
public class MultipageEditorSynchronizationService {
	
	/**
	 * the identifiers for the {@link MultipageEditor} and the {@link DiagramTypeProvider}
	 */
	private static final String EDITOR_ID = IdentifierLiterals.EDITOR_ID,
							    DIAGRAM_PROVIDER_ID = IdentifierLiterals.DIAGRAM_PROVIDER_ID;	
	/**
	 * the values for the property diagram kind to differ between diagram with the same name, but different
	 * kinds like a group and a compartment type diagram called the same gathered form {@link IdentifierLiterals}
	 */
	private static final String DIAGRAM_KIND_GROUP_DIAGRAM = IdentifierLiterals.DIAGRAM_KIND_GROUP_DIAGRAM,
								DIAGRAM_KIND_COMPARTMENT_DIAGRAM = IdentifierLiterals.DIAGRAM_KIND_COMPARTMENT_DIAGRAM;
	
	/**
	 * the register for the multipage editors to synchronize
	 */
	private static List<MultipageEditor> registeredEditors = new ArrayList<MultipageEditor>();
	
	/**
	 * a list to save the dirty states of the registered multipage editors
	 */
	private static List<Boolean> dirtyStatesOfEditors = new ArrayList<Boolean>();
	
	/**
	 * operation to add a multipage editor to the register
	 * @param multipageEditor the multipage editor to add
	 */
	public static void registerEditor(MultipageEditor multipageEditor) {
		registeredEditors.add(multipageEditor);
	}
	
	/**
	 * operation to remove a multipage editor from the register
	 * @param multipageEditor the multipage editor to remove
	 */
	public static void deregisterEditor(MultipageEditor multipageEditor) {
		registeredEditors.remove(multipageEditor);
	}
	
	/**
	 * recalculates the values in the list of the dirty states of the registered multipage editors
	 */
	public static void updateDirtyStates() {
		dirtyStatesOfEditors.clear();
		for(MultipageEditor multipageEditor : registeredEditors) {
			dirtyStatesOfEditors.add(multipageEditor.isDirty());
		}
	}
	
	/**
	 * offers a copy of the list of registered editors
	 * <p>
	 * a copy is often needed to avoid ConcurrentModificationExceptions
	 * @return
	 */
	public static List<MultipageEditor> getCopyOfRegisteredEditors() {
		List<MultipageEditor> copyOfRegisteredEditors = new ArrayList<MultipageEditor>();
		for(MultipageEditor multipageEditor : registeredEditors)
			copyOfRegisteredEditors.add(multipageEditor);
		return copyOfRegisteredEditors;
	}
	
	/**
	 * synchronizes mutiple opened multipage editors using the following steps:
	 * <p>
	 * Step 1: It gets the first multipage editor in its register that is dirty to use it as a synchronization base.
			   If there is no dirty multipage editor return instantly since there is no change to synchronize.<br>
	 * Step 2: Its calculates an equivalent editor input for all registered multipage editors except the synchronization base.<br>
	 * Step 3: It closes these multipage editors and uses the equivalent editor inputs to reopen them. Also change focus back to the
	 * 		   active editor before synchronizing to avoid changing the focus without a user input to do this.
	 */
	public static void synchronize() {
		//Step 1
		MultipageEditor synchronizationBase = null;
		for(int i = 0; i<dirtyStatesOfEditors.size(); i++) {
			if(dirtyStatesOfEditors.get(i)) {
				synchronizationBase = registeredEditors.get(i);
				break;
				
			}
		}
		if(synchronizationBase == null) return;
		else {
			//Step 2
			List<MultipageEditor> copyOfRegisteredEditors = getCopyOfRegisteredEditors();
			MultipageEditor activeMultipageEditor = 
					(MultipageEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
			for(MultipageEditor multipageEditor : copyOfRegisteredEditors) {
				if(areTheSameRoleModels(synchronizationBase, multipageEditor)) {	
					if(multipageEditor.getPartName() != synchronizationBase.getPartName()) {
						IEditorInput newEditorInput = 
							getEquivalentEditorInput(synchronizationBase.getEditorInput(), multipageEditor.getEditorInput());
						try {
							//Step 3
							PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeEditor(multipageEditor, false);
							PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(newEditorInput, EDITOR_ID, false);	
						} catch (PartInitException e) {	e.printStackTrace(); }
			}	}	}
			try {
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(activeMultipageEditor.getEditorInput(), EDITOR_ID, false);
			} catch (PartInitException e) { e.printStackTrace(); }
	}	}
	
	/**
	 * calculates of two multipage editors work on the same role model
	 * @param multipageEditor1 the first to multipage editor to compare
	 * @param multipageEditor2 the second to multipage editor to compare
	 * @return if the two multipage editors work on the same role model file
	 */
	private static boolean areTheSameRoleModels(MultipageEditor multipageEditor1, MultipageEditor multipageEditor2) {
		//synchrobase
		IFile firstFile = EditorInputUtil.getIFileForEditorInput(multipageEditor1.getEditorInput());
		IFile secondFile = EditorInputUtil.getIFileForEditorInput(multipageEditor2.getEditorInput());
		return firstFile.equals(secondFile);
	}
	
    /**
     * creates an equivalent editor input for another editor input depending on the editor input of the synchronization base
     * using the following steps:
     * <p>
     * Step 1: If the editor input of the synchronization base is of the right type it gets its resource. Otherwise it throws
     * an {@link InvalidTypeOfEditorInputException}.<br>
     * Step 2: If the editor input of the multipage editor that is not the synchronize base is of the type {@link IFileEditorInput}, 
     * 		   return an file editor input for the synchronization base.<br>
     * Step 3: If the editor input of the multipage editor that is not the synchronize base is of the type {@link DiagramEditorInput},
     * 		   get the diagram of the editor input, search with its name the same diagram in the synchronization base and create a
     * 		   diagram editor input with the found diagram.<br> 
     * Step 4: If neither Step 2 or 3 can be executed throw an {@link InvalidTypeOfEditorInputException}.
     * @param baseEditorInput the editor input of the synchronization base
     * @param changedEditorInput the editor input of the multipage editor that is not the synchronization base
     * @return an equivalent editor input for another editor input depending on the editor input of the synchronization base
     * @throws InvalidTypeOfEditorInputException
     */
	private static IEditorInput getEquivalentEditorInput(IEditorInput baseEditorInput, IEditorInput changedEditorInput) {
		//Step 1
		Resource baseResource = null;
		if(baseEditorInput instanceof IFileEditorInput || baseEditorInput instanceof DiagramEditorInput)
			baseResource = EditorInputUtil.getResourceFromEditorInput(baseEditorInput);
		else throw new InvalidTypeOfEditorInputException();
		//Step 2
		if(changedEditorInput instanceof IFileEditorInput)
			return EditorInputUtil.getIFileEditorInputForResource(baseResource);
		//Step 3
		if(changedEditorInput instanceof DiagramEditorInput) {
			Resource changedEditorResource = EditorInputUtil.getResourceFromEditorInput(changedEditorInput);
			Diagram changedEditorDiagram = DiagramUtil.getDiagramForResourceOfDiagramEditorInput(changedEditorResource);
			Type type = null;
			if(PropertyUtil.isDiagram_KindValue(changedEditorDiagram, DIAGRAM_KIND_GROUP_DIAGRAM))
				type = Type.GROUP;
			else if(PropertyUtil.isDiagram_KindValue(changedEditorDiagram, DIAGRAM_KIND_COMPARTMENT_DIAGRAM))
					type = Type.COMPARTMENT_TYPE;
			else return null;
			Diagram equivalentDiagramInBaseResource =
				DiagramUtil.getDiagramFromResourceByName(baseResource, changedEditorDiagram.getName(), type);
			return DiagramEditorInput.createEditorInput(equivalentDiagramInBaseResource, DIAGRAM_PROVIDER_ID);
		} 
		//Step 4
		throw new InvalidTypeOfEditorInputException();		
	}
}
