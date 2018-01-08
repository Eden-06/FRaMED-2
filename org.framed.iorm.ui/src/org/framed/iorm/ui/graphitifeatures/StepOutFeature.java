package org.framed.iorm.ui.graphitifeatures;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.ui.editor.DiagramEditorInput;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.framed.iorm.model.Model;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.exceptions.NoDiagramFoundException;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.literals.NameLiterals;
import org.framed.iorm.ui.literals.UILiterals;
import org.framed.iorm.ui.multipage.MultipageEditor;
import org.framed.iorm.ui.util.DiagramUtil;
import org.framed.iorm.ui.util.EditorInputUtil;
import org.framed.iorm.ui.util.UIUtil;

/**
 * This graphiti custom feature is used to step out of groups and compartment types remaining still showing the same number of tabs.
 * @author Kevin Kassin
 */
public class StepOutFeature extends AbstractCustomFeature {
	
	/**
	 * the name of the feature gathered from {@link NameLiterals}
	 */
	private final String STEP_OUT_FEATURE_NAME = NameLiterals.STEP_OUT_FEATURE_NAME;
	
	/**
	 * the value of the property diagram kind to identify a diagram that belongs to a group
	 */
	private final String DIAGRAM_KIND_GROUP_DIAGRAM = UILiterals.DIAGRAM_KIND_GROUP_DIAGRAM,
						 DIAGRAM_KIND_COMPARTMENT_DIAGRAM = UILiterals.DIAGRAM_KIND_COMPARTMENTTYPE_DIAGRAM;
	
	/**
	 * identifiers used to open a new editor for the groups or compartment types diagram gathered from {@link IdentifierLiterals}
	 * <p>
	 * can be:<br>
	 * (1) the identifier for the diagram provider that is used to create an IDiagramEditorInput
	 *     in the operation {@link #execute} or<br>
	 * (2) the identifier for the multipage editor that is used to open a new multipage editor in 
	 *     the operation {@link #execute} 
	 */
	protected final String DIAGRAM_PROVIDER_ID = UILiterals.DIAGRAM_PROVIDER_ID,
						   EDITOR_ID = UILiterals.EDITOR_ID;
	
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
	 * (2) the diagram of the editor to step out of a group or compartment type diagram is and<br>
	 * (3) there are no unsaved changes of the diagram editor in which the pictogram element is shown
	 * @return if the feature can be executed
	 */
	@Override
	public boolean canExecute(ICustomContext customContext) {
		if(customContext.getPictogramElements().length == 1) {
			if(UIUtil.isDiagram_KindValue(getDiagram(), DIAGRAM_KIND_GROUP_DIAGRAM) ||
			   UIUtil.isDiagram_KindValue(getDiagram(), DIAGRAM_KIND_COMPARTMENT_DIAGRAM)) {
				MultipageEditor multipageEditor = 
					(MultipageEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				if(!(multipageEditor.isDirty()))
					return true;
		}	}
		return false;
	}

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
			Model groupModel = DiagramUtil.getLinkedModelForDiagram(getDiagram());
			Model modelToStepOutTo = groupModel.getParent().getContainer();
			org.framed.iorm.model.Shape ShapeToStepOutTo = modelToStepOutTo.getParent();
			//Step 2
			if(ShapeToStepOutTo == null) {
				Resource resource = EditorInputUtil.getResourceFromEditorInput(multipageEditorToClose.getEditorInput());
				IFileEditorInput fileEditorInput = EditorInputUtil.getIFileEditorInputForResource(resource);
				stepOutWithEditorInput(fileEditorInput);
			} else {
				//Step 3		
				Diagram diagramToStepOutTo = null;
				String diagramNameToStepOutTo = ShapeToStepOutTo.getName();
				Diagram containerDiagram = DiagramUtil.getContainerDiagramForAnyDiagram(getDiagram());
				Type type = null;
				if(UIUtil.isDiagram_KindValue(getDiagram(), DIAGRAM_KIND_GROUP_DIAGRAM))
					type = Type.GROUP;
				else if(UIUtil.isDiagram_KindValue(getDiagram(), DIAGRAM_KIND_COMPARTMENT_DIAGRAM)) 
						type = Type.COMPARTMENT_TYPE;
				else return;
				for(Shape shape : containerDiagram.getChildren()) {
					if(shape instanceof Diagram) {
						if((UIUtil.isDiagram_KindValue((Diagram) shape, DIAGRAM_KIND_GROUP_DIAGRAM) &&
						    type == Type.GROUP) ||
						   (UIUtil.isDiagram_KindValue((Diagram) shape, DIAGRAM_KIND_COMPARTMENT_DIAGRAM) &&
						    type == Type.COMPARTMENT_TYPE)) {
							if(((Diagram) shape).getName().equals(diagramNameToStepOutTo))
								diagramToStepOutTo = (Diagram) shape;
				}	}	}
				if(diagramToStepOutTo == null) throw new NoDiagramFoundException();
				DiagramEditorInput diagramEditorInput = 
						DiagramEditorInput.createEditorInput(diagramToStepOutTo, DIAGRAM_PROVIDER_ID);
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
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(editorInput, EDITOR_ID);
		} catch (PartInitException e) { e.printStackTrace(); }
	}
}
