package customFeatures;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.ui.editor.DiagramEditorInput;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.UILiterals;
import org.framed.iorm.ui.UIUtil;
import org.framed.iorm.ui.multipage.MultipageEditor;

import customFeatures.references.AbstractStepInAndOutReference;

/**
 * This graphiti custom feature is used to step in groups and compartment types by opening a new tab.
 * <p>
 * It extends {@link AbstractStepInFeature}.
 * @author Kevin Kassin
 */
public class StepInNewTabFeature extends AbstractStepInFeature {
	
	/**
	 * the object to get names, ids and so on for this feature
	 */
	Literals literals = new Literals();
		
	/**
	 * Class constructor
	 * @param featureProvider the feature provider the feature belongs to 
	 */
	public StepInNewTabFeature(IFeatureProvider featureProvider) {
		super(featureProvider);
		FEATURE_NAME = literals.STEP_IN_NEW_TAB_FEATURE_NAME;
	}
	
	/**
	 * this operation encapsulates when the custom feature should be visible in the context menu
	 * @return true if the shape to step into is reference in one of the {@link AbstractStepInAndOutReference}s.
	 */
	public boolean contextMenuExpression(PictogramElement pictogramElement, EObject businessObject) {
		if(pictogramElement instanceof Shape &&
		   !(pictogramElement instanceof Diagram)) {
				if(util.shapeIsFittingToStepInAndOutFeature((Shape) pictogramElement, stepInAndOutReferences))
					return true;
		}
		return false;
	}
	 
	/**
	 * executes the step in feature using the following steps:
	 * <p>
	 * Step 1: It saves the multipage editor the step in feature was called at the next reasonable time.<br>
	 * Step 2: It gets the diagram to step into.<br>
	 * Step 3: It gets a {@link DiagramEditorInput} and opens a new multipage editor with it.
	 * <p> 
	 * There are no checks for types and the size of the list of selected pictograms needed since this checks are
	 * already done in {@link AbstractStepInFeature#canExecute}.<br>
	 * The operation {@link GeneralUtil#closeMultipageEditorWhenPossible} knows how to close the editor when its not used anymore. 
	 * That why the operation can be called at the start of the execute operation.
	 */
	@Override
	public void execute(ICustomContext context) {
		//Step 1
		MultipageEditor multipageEditorTosave = 
				(MultipageEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		Display display = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().getDisplay();
		display.asyncExec(new Runnable() {
			@Override
			public void run() {
				multipageEditorTosave.getDiagramEditor().doSave(new NullProgressMonitor());
		}	});	
		//Step 2
		ContainerShape typeBodyShape = (ContainerShape) context.getPictogramElements()[0];
		Type type = null;
		if(getBusinessObjectForPictogramElement(typeBodyShape) instanceof org.framed.iorm.model.Shape) {
			org.framed.iorm.model.Shape businessobject = (org.framed.iorm.model.Shape) getBusinessObjectForPictogramElement(typeBodyShape);
			type = businessobject.getType();
		} else return;
		AbstractStepInAndOutReference siaor = util.getStepInAndOutReferenceForType(type, stepInAndOutReferences);
		if(siaor == null) return;
		Diagram diagramToStepIn = UIUtil.getDiagramForGroupingShape(typeBodyShape, getDiagram(), siaor.getShapeIdTypebody(), 
			siaor.getShapeIdName(), siaor.getDiagramKind());
		//Step 3
		IEditorInput diagramEditorInput = DiagramEditorInput.createEditorInput(diagramToStepIn, UILiterals.DIAGRAM_PROVIDER_ID);
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(diagramEditorInput, UILiterals.EDITOR_ID);
		} catch (PartInitException e) { e.printStackTrace(); }
	}	
}
