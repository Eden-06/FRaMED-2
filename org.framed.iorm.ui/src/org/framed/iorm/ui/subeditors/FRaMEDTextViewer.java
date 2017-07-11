package org.framed.iorm.ui.subeditors;

import org.eclipse.ui.editors.text.TextEditor;
import org.framed.iorm.ui.multipage.MultipageEditor; //*import for javadoc link

/**
 * the text viewer used by the {@link MultipageEditor}
 * <p>
 * It extends an {@link Texteditor} and makes this editor not editable.
 * @author Kevin Kassin
 */
public class FRaMEDTextViewer extends TextEditor {
	
	/**
	 * Class constructor
	 */
	public FRaMEDTextViewer() {
		super();
	}
	
	/**
	 * makes text viewer not editable
	 */
	@Override
	public boolean isEditable() {
	    return false;
	}

	/**
	 * makes text viewer not editable
	 */
	@Override
	public boolean isEditorInputModifiable() {
	    return false;
	}

	/**
	 * makes text viewer read only
	 */
	@Override
	public boolean isEditorInputReadOnly() {
	    return true;
	}

	/**
	 * since text viewer is read only, always return false as dirty vairable
	 */
	@Override
	public boolean isDirty() {
	    return false;
	}
}
