package org.framed.iorm.ui.multipage;

import org.eclipse.gef.ui.actions.DeleteAction;
import org.eclipse.gef.ui.actions.RedoAction;
import org.eclipse.gef.ui.actions.UndoAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.MultiPageEditorActionBarContributor;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;
import org.framed.iorm.ui.subeditors.FRaMEDDiagramEditor;
import org.framed.iorm.ui.subeditors.FRaMEDTextViewer;

/**
 * This class sets the actions for the action bars depending of which type the active editor is.
 * @author Kevin Kassin
 */
public class MultipageEditorContributor extends MultiPageEditorActionBarContributor {
		
	/**
	 * the editor that is active at the moment 
	 */
	private IEditorPart activeEditorPart;
	
	/**
	 * Class constructor
	 */
	public MultipageEditorContributor() {
		super();
	}
	
	/**
	 * get an Action by an specific ID from a given text editor
	 * @param editor the texteditor the action to get is from
	 * @param actionID the id of the action to get
	 * @return the action to get
	 */
	private IAction getAction(ITextEditor editor, String actionID) {
		if(editor == null) return null;
		return editor.getAction(actionID);
	}
	
	/**
	 * This operation sets the actions for the action bars depending on the active editor.
	 * <p>
	 * It gets the different actions from the active editors in respective of which type the active
	 * editor is.
	 */
	public void setActivePage(IEditorPart part) {
		if (activeEditorPart == part) return;
		activeEditorPart = part;
		IActionBars actionBars = getActionBars();
		if (actionBars != null) {
			if((part instanceof FRaMEDDiagramEditor)) {
				FRaMEDDiagramEditor editor = (FRaMEDDiagramEditor) part;
				String undoActionID = new UndoAction(editor).getId(),
					   redoActionID = new RedoAction(editor).getId(),
					   deleteActionID = new DeleteAction((IWorkbenchPart) editor).getId();
				actionBars.setGlobalActionHandler( ActionFactory.UNDO.getId(), editor.getActionRegistry().getAction(undoActionID));
				actionBars.setGlobalActionHandler( ActionFactory.REDO.getId(), editor.getActionRegistry().getAction(redoActionID));
				actionBars.setGlobalActionHandler( ActionFactory.DELETE.getId(), editor.getActionRegistry().getAction(deleteActionID));
				}		
			if((part instanceof FRaMEDTextViewer)) {
				FRaMEDTextViewer editor = (FRaMEDTextViewer) part;
				actionBars.setGlobalActionHandler( ActionFactory.COPY.getId(), getAction(editor, ITextEditorActionConstants.COPY));
				actionBars.setGlobalActionHandler( ActionFactory.SELECT_ALL.getId(), getAction(editor, ITextEditorActionConstants.SELECT_ALL));
				actionBars.setGlobalActionHandler( ActionFactory.FIND.getId(), getAction(editor, ITextEditorActionConstants.FIND));
				actionBars.updateActionBars();
	}	}	}
}