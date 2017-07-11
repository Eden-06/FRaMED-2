package org.framed.iorm.ui.graphitifeatures;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.framed.iorm.ui.exceptions.NoDiagramFoundException;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.literals.NameLiterals;
import org.framed.iorm.ui.multipage.MultipageEditor;
import org.framed.iorm.ui.util.DiagramUtil;
import org.framed.iorm.ui.util.EditorInputUtil;
import org.framed.iorm.ui.util.GeneralUtil;
import org.framed.iorm.ui.util.PropertyUtil;

/**
 * This graphiti custom feature is used to step out of groups and compartment types remaining still showing the same number of tabs.
 * @author Kevin Kassin
 */
public class StepOutFeature extends AbstractCustomFeature {
	
	/**
	 * the name of the feature gathered from {@link NameLiterals}
	 */
	private final String STEP_OUT_FEATURE_NAME = NameLiterals.STEP_OUT_FEATURE_NAME;
	
	private final String DIAGRAM_KIND_GROUP_DIAGRAM = IdentifierLiterals.DIAGRAM_KIND_GROUP_DIAGRAM,
						 DIAGRAM_KIND_MAIN_DIAGRAM = IdentifierLiterals.DIAGRAM_KIND_MAIN_DIAGRAM;
	
	/**
	 * identifiers used to open a new editor for the groups or compartment types diagram gathered from {@link IdentifierLiterals}
	 * <p>
	 * can be:<br>
	 * (1) the identifier for the diagram provider that is used to create an IDiagramEditorInput
	 *     in the operation {@link #execute} or<br>
	 * (2) the identifier for the multipage editor that is used to open a new multipage editor in 
	 *     the operation {@link #execute} 
	 */
	protected final String DIAGRAM_PROVIDER_ID = IdentifierLiterals.DIAGRAM_PROVIDER_ID,
						   EDITOR_ID = IdentifierLiterals.EDITOR_ID;
	
	/**
	 * Class constructor
	 * @param featureProvider the feature provider the feature belongs to
	 */
	public StepOutFeature(IFeatureProvider featureProvider) {
		super(featureProvider);
	}
	 
	/**
	 * get method for the features name
	 * @return the name of the feature
	 */
	@Override
	public String getName() {
		return STEP_OUT_FEATURE_NAME;
	}
	
	/**
	 * This methods checks if the feature can be executed.
	 * <p>
	 * It returns true if:<br>
	 * (1) exactly one pictogram element is selected and<br>
	 * (2) there are no unsaved changes of the diagram editor in which the pictogram element is shown
	 * @return if the feature can be executed
	 */
	@Override
	public boolean canExecute(ICustomContext customContext) {
		if(customContext.getPictogramElements().length == 1) {
			MultipageEditor multipageEditor = 
				(MultipageEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
			if(!(multipageEditor.isDirty()))
				return true;
		}	
		return false;
	}

	/**
	 * This operation opens a new multipage editor with the diagram one level above the groups or compartment types
	 * diagram and closes the the multipage editor the step out feature was called. It uses {@link #stepOutOfDiagramIfPossible}
	 * to do that.
	 * <p>
	 * It needs to find the diagram that is open at the moment to step out of it.
	 * <p>
	 * There is no check for the size of the list of selected pictograms needed since this check is already done in 
	 * {@link #canExecute}.<br>
	 */
	@Override
	public void execute(ICustomContext customContext) {
		if(customContext.getPictogramElements()[0] instanceof Diagram) {
			stepOutOfDiagramIfPossible((Diagram) customContext.getPictogramElements()[0]);
		}
		if(customContext.getPictogramElements()[0] instanceof Shape &&
		   !(customContext.getPictogramElements()[0] instanceof Diagram)) {
			Diagram diagramContainingShape = 
				DiagramUtil.getDiagramForContainedShape((Shape) customContext.getPictogramElements()[0]);
			if(diagramContainingShape == null) throw new NoDiagramFoundException();
			stepOutOfDiagramIfPossible(diagramContainingShape);
		}
	}
	
	/**
	 * opens a new multipage editor with the diagram one level above the groups or compartment types
	 * diagram and closes the the multipage editor the step out feature was called.
	 * <p>
	 * For the given diagram it searches for the diagram its group or compartmentment type belongs too (Step 1). For that diagram it
	 * open an new multipage editor and closes the one that called the step out feature (Step 2).
	 * <p>
	 * The operation {@link GeneralUtil#closeMultipageEditorWhenPossible} knows how to close the editor when its not used anymore. 
	 * That why the operation can be called before the end of this operation.
	 * @param diagram the diagram to step out
	 * @throws NoDiagramFoundException
	 */
	private void stepOutOfDiagramIfPossible(Diagram diagram) {
		//Step 1
		if(PropertyUtil.isDiagram_KindValue(diagram, DIAGRAM_KIND_GROUP_DIAGRAM)) {
			Diagram diagramToStepOutTo = null;
			Diagram containerDiagram = (Diagram) diagram.getContainer();
			for(Shape shape : containerDiagram.getChildren()) {
				if(shape instanceof Diagram &&
				   PropertyUtil.isDiagram_KindValue((Diagram) shape, DIAGRAM_KIND_MAIN_DIAGRAM))
					diagramToStepOutTo = (Diagram) shape;
			}
			if(diagramToStepOutTo == null) throw new NoDiagramFoundException();
			else {
				//Step 2
				MultipageEditor multipageEditorToClose = 
						(MultipageEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				GeneralUtil.closeMultipageEditorWhenPossible(multipageEditorToClose);
				Resource resource = EditorInputUtil.getResourceFromEditorInput(multipageEditorToClose.getEditorInput());
				IFileEditorInput fileEditorInput = EditorInputUtil.getIFileEditorInputForResource(resource);
				try {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(fileEditorInput, EDITOR_ID);
				} catch (PartInitException e) { e.printStackTrace(); }
	}	}	}
}
