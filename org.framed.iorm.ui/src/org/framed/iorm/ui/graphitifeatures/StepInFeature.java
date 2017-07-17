package org.framed.iorm.ui.graphitifeatures;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.editor.DiagramEditorInput;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.framed.iorm.model.Shape;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.literals.NameLiterals;
import org.framed.iorm.ui.multipage.MultipageEditor;
import org.framed.iorm.ui.providers.ToolBehaviorProvider;
import org.framed.iorm.ui.util.DiagramUtil;
import org.framed.iorm.ui.util.GeneralUtil;

/**
 * This graphiti custom feature is used to step in groups and compartment types remaining still showing the same number of tabs.
 * <p>
 * It extends {@link AbstractStepInFeature}.
 * @author Kevin Kassin
 */
public class StepInFeature extends AbstractStepInFeature {

	/**
	 * the name of the feature gathered from {@link NameLiterals} 
	 */
	private final String STEP_IN_FEATURE_NAME = NameLiterals.STEP_IN_FEATURE_NAME;
	
	/**
	 * identifier used to differ the types of palettes gathered from {@link IdentifierLiterals}
	 */
	private final String PALETTE_TYPE_ROLE = IdentifierLiterals.PALETTE_TYPE_ROLE;
		 	 
	/**
	 * Class constructor 
	 * @param featureProvider the feature provider the feature belongs to
	 */
	public StepInFeature(IFeatureProvider featureProvider) {
		super(featureProvider);
	}
	
	/**
	 * get method for the features name
	 * @return the name of the feature 
	 */
	@Override
	public String getName() {
		return STEP_IN_FEATURE_NAME;
	}

	/**
	 * executes the step in feature using the following steps:
	 * <p>
	 * Step 1: It saves and closes the multipage editor the step in feature was called at the next reasonable time.<br>
	 * Step 2: It gets the diagram to step into.<br>
	 * Step 3: It gets a {@link DiagramEditorInput} and opens a new multipage editor with it.<br>
	 * Step 4: If its was a compartment type in which it's stepped set the palette type to role palette for the new
	 * 		   multipage editor.
	 * <p> 
	 * There are no checks for types and the size of the list of selected pictograms needed since this checks are
	 * already done in {@link AbstractStepInFeature#canExecute}.<br>
	 * The operation {@link GeneralUtil#closeMultipageEditorWhenPossible} knows how to close the editor when its not used anymore. 
	 * That why the operation can be called at the start of the execute operation.
	 */
	@Override
	public void execute(ICustomContext context) {
		//Step 1
		MultipageEditor multipageEditorToClose = 
				(MultipageEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		closeMultipageEditorWhenPossible(multipageEditorToClose);
		//Step 2
		ContainerShape typeBodyShape = (ContainerShape) context.getPictogramElements()[0];
		Type type = null;
		if(getBusinessObjectForPictogramElement(typeBodyShape) instanceof org.framed.iorm.model.Shape) {
			Shape businessobject = (Shape) getBusinessObjectForPictogramElement(typeBodyShape);
			type = businessobject.getType();
		} else return;
		Diagram diagramToStepIn = DiagramUtil.getGroupOrCompartmentTypeDiagramForItsShape(typeBodyShape, getDiagram(), type);
		//Step 3
		IEditorInput diagramEditorInput = DiagramEditorInput.createEditorInput(diagramToStepIn, DIAGRAM_PROVIDER_ID);
		MultipageEditor newEditor = null;
		try {
			newEditor = (MultipageEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(diagramEditorInput, EDITOR_ID);
		} catch (PartInitException e) { e.printStackTrace(); }
		//Step 4
		if(newEditor != null &&	
		   type == Type.COMPARTMENT_TYPE) {
			ToolBehaviorProvider toolBehaviorProvider = 
				(ToolBehaviorProvider) newEditor.getDiagramEditor().getDiagramTypeProvider().getCurrentToolBehaviorProvider();
			toolBehaviorProvider.setPaletteType(PALETTE_TYPE_ROLE);	
			newEditor.getDiagramEditor().getDiagramBehavior().refreshPalette();
	}	}	
}
