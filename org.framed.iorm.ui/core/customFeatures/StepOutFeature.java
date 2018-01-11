package customFeatures;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.ui.editor.DiagramEditorInput;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.framed.iorm.model.Model;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.FRaMEDCustomFeature;
import org.framed.iorm.ui.UILiterals;
import org.framed.iorm.ui.UIUtil;
import org.framed.iorm.ui.exceptions.NoDiagramFoundException;
import org.framed.iorm.ui.multipage.MultipageEditor;

import customFeatures.references.AbstractStepInAndOutReference;

/**
 * This graphiti custom feature is used to step out of groups and compartment types remaining still showing the same number of tabs.
 * @author Kevin Kassin
 */
public class StepOutFeature extends FRaMEDCustomFeature {
	
	/**
	 * the object to get names, ids and so on for this feature
	 */
	private final Literals literals = new Literals();
	
	/**
	 * the object to call utility operations on
	 */
	private final Util util = new Util();
	
	/**
	 * the list of reference classes which save in which other module feature's shapes a attribute or
	 * operation can be added with specific informations for these.
	 * @see AbstractUsedInReference
	 */
	private List<AbstractStepInAndOutReference> stepInAndOutReferences; 
	
	/**
	 * Class constructor
	 * <p>
	 * Note: It gets the references which save in which other module feature's shapes a attribute or
	 * operations can be added here and saves them it into {@link #stepInAndOutReferences}.	
	 * @param featureProvider the feature provider the feature belongs to
	 */
	public StepOutFeature(IFeatureProvider featureProvider) {
		super(featureProvider);
		FEATURE_NAME = literals.STEP_OUT_FEATURE_NAME;
		//Note
		List<Class<?>> classes = UIUtil.findModuleJavaClasses();
		stepInAndOutReferences = util.getStepInAndOutReferences(classes);
	}
	
	/**
	 * this operation encapsulates when the custom feature should be visible in the context menu
	 * @return false, since the feature is never visible in the context menu
	 */
	public boolean contextMenuExpression(PictogramElement pictogramElement, EObject businessObject) {
		if(pictogramElement instanceof Diagram) {
			Diagram diagram = (Diagram) pictogramElement;
			if(util.diagramIsFittingToStepInAndOutFeature(diagram, stepInAndOutReferences))
				return true;
		} else {
			if(pictogramElement instanceof Shape) {
				Diagram diagram = UIUtil.getDiagramForContainedShape((Shape) pictogramElement);
				if(diagram != null) {
					if(util.diagramIsFittingToStepInAndOutFeature(diagram, stepInAndOutReferences))
						return true;
		}	}	}	
		return false;
	}	
	
	/**
	 * This methods checks if the feature can be executed.
	 * <p>
	 * It returns true if:<br>
	 * (1) exactly one pictogram element is selected and<br>
	 * (2) the diagram of the editor to step out of a group or compartment type diagram is and<br>
	 * (3) there are no unsaved changes of the diagram editor in which the pictogram element is shown
	 * @return if the feature can be executed
	 */
	@Override
	public boolean canExecute(ICustomContext customContext) {
		if(customContext.getPictogramElements().length == 1) {
			if(util.diagramIsFittingToStepInAndOutFeature(getDiagram(), stepInAndOutReferences)) {
				MultipageEditor multipageEditor = 
					(MultipageEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				if(!(multipageEditor.isDirty()))
					return true;
		}	}
		return false;
	}

	//TODO doku?
	/**
	 * This operation executes the step out itself using the following steps:
	 * <p>
	 * Step 1: It gets the model to step out to and tries to get the name of the group or compartment type that 
	 * 		   contains the model if there is one.<br>
	 * Step 2: If not, it means that the root model of the file is to open using an {@link IFileEditorInput} on the
	 * 		   operation {@link #stepOutWithEditorInput}.<br>
	 * Step 3: If there is one, it means the the diagram with the same name to the group or compartment type is to open.
	 * 		   Therefore it call {@link #stepOutWithEditorInput} with a {@link DiagramEditorInput}.
	 * <p>
	 * There is no check for the size of the list of selected pictograms needed since this check is already done in 
	 * {@link #canExecute}.<br>
	 */
	@Override
	public void execute(ICustomContext customContext) {
			MultipageEditor multipageEditorToClose = 
					(MultipageEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
			//Step 1
			Model groupModel = UIUtil.getLinkedModelForDiagram(getDiagram());
			Model modelToStepOutTo = groupModel.getParent().getContainer();
			org.framed.iorm.model.Shape ShapeToStepOutTo = modelToStepOutTo.getParent();
			//Step 2
			if(ShapeToStepOutTo == null) {
				Resource resource = UIUtil.getResourceFromEditorInput(multipageEditorToClose.getEditorInput());
				IFileEditorInput fileEditorInput = UIUtil.getIFileEditorInputForResource(resource);
				stepOutWithEditorInput(fileEditorInput);
			} else {
				//Step 3		
				Diagram diagramToStepOutTo = null;
				String diagramNameToStepOutTo = ShapeToStepOutTo.getName();
				Diagram containerDiagram = UIUtil.getContainerDiagramForAnyDiagram(getDiagram());
				Type type = ShapeToStepOutTo.getType();
				for(Shape shape : containerDiagram.getChildren()) {
					if(shape instanceof Diagram) {
						AbstractStepInAndOutReference siaorOfContainerChildren = util.getStepInAndOutReferenceForDiagramKind((Diagram) shape, stepInAndOutReferences);
						if(siaorOfContainerChildren != null) {
							if(type == siaorOfContainerChildren.getModelType()) {
								if(((Diagram) shape).getName().equals(diagramNameToStepOutTo)) 
									diagramToStepOutTo = (Diagram) shape;
				}	}	}	}
				if(diagramToStepOutTo == null) throw new NoDiagramFoundException();
				DiagramEditorInput diagramEditorInput = 
						DiagramEditorInput.createEditorInput(diagramToStepOutTo, UILiterals.DIAGRAM_PROVIDER_ID);
				stepOutWithEditorInput(diagramEditorInput);
	}	}	
		
	/**
	 * closes the editor in which the step out feature is called and opens an multipage editor for the diagram one level 
	 * above the closed one
	 * <p>
	 * The operation {@link GeneralUtil#closeMultipageEditorWhenPossible} knows how to close the editor when its not used anymore. 
	 * That why the operation can be called at the start of the operation.
	 * @param editorInput the editor input to open the new multipage editor with
	 */
	private void stepOutWithEditorInput(IEditorInput editorInput) {
		MultipageEditor multipageEditorToClose = 
				(MultipageEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		UIUtil.closeMultipageEditorWhenPossible(multipageEditorToClose);
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(editorInput, UILiterals.EDITOR_ID);
		} catch (PartInitException e) { e.printStackTrace(); }
	}
}
