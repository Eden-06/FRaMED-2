package org.framed.iorm.ui.util;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.literals.LayoutLiterals;
import org.framed.iorm.ui.multipage.MultipageEditor;

/**
 * This class offers some general utility methods.
 * @author Kevin Kassin
 */
public class GeneralUtil {
	
	/**
	 * the layout integers this class need to perform the operation {@link #calculateHorizontalCenter}
	 * gathered from {@link LayoutLiterals}
	 */
	private static final int HEIGHT_NAME_SHAPE = LayoutLiterals.HEIGHT_NAME_SHAPE,
			 		  	 	 DATATYPE_CORNER_SIZE = LayoutLiterals.DATATYPE_CORNER_SIZE;
		
	/**
	 * This operation calculates where the horizontal center of a class or role is.
	 * <p>
	 * Depending on the the type of the class or role and its height the horizontal center position is returned.
	 * @param type the type of the class or role
	 * @param heightOfClassOrRole the height of the class or role
	 * @return the horizontal center position
	 */
	public static final int calculateHorizontalCenter(Type type, int heightOfClassOrRole) {
		if(type == Type.NATURAL_TYPE) 
			return ((heightOfClassOrRole-HEIGHT_NAME_SHAPE)/2)+HEIGHT_NAME_SHAPE;
		if(type == Type.DATA_TYPE)	
			return ((heightOfClassOrRole-HEIGHT_NAME_SHAPE-DATATYPE_CORNER_SIZE)/2)+HEIGHT_NAME_SHAPE;
		return 0;
	}
	
	/**
	 * sets the values of a given {@link AddContext} using a given {@link CreateContext}
	 * <p>
	 * This operation only deals with add and create contexts for graphiti shapes since graphiti connections use
	 * a special type of create contexts.
	 * @param addContext the {@link AddContext} to set the values in
	 * @param createContext the {@link CreateContext} to get the values of
	 * @return the given {@link AddContext} with set values
	 */
	public static AddContext getAddContextForCreateShapeContext(AddContext addContext, ICreateContext createContext) {
		addContext.setHeight(createContext.getHeight());
		addContext.setWidth(createContext.getWidth());
		addContext.setX(createContext.getX());
		addContext.setY(createContext.getY());
		addContext.setLocation(createContext.getX(), createContext.getY());
		addContext.setSize(createContext.getWidth(), createContext.getHeight());
		return addContext;
	}
	
	/**
	 * manages to close a given multipage editor at the next reasonable opportunity using the operation 
	 * {@link Display#asyncExec}
	 * <p>
	 * It also saves the multipage editor before closing it to clean up the dirty state of the whole workbench.
	 * @param multipageEditorToClose
	 */
	public static void closeMultipageEditorWhenPossible(MultipageEditor multipageEditorToClose) {
		Display display = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().getDisplay();
		display.asyncExec(new Runnable() {
			@Override
			public void run() {
				multipageEditorToClose.getDiagramEditor().doSave(new NullProgressMonitor());
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeEditor(multipageEditorToClose, false);
			}
		});
	}
}
