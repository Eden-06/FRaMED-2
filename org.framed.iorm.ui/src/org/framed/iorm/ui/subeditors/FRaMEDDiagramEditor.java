package org.framed.iorm.ui.subeditors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.framed.iorm.featuremodel.FRaMEDFeature;
import org.framed.iorm.model.Model;
import org.framed.iorm.ui.exceptions.NoModelFoundException;
import org.framed.iorm.ui.multipage.MultipageEditor; //*import for javadoc link
import org.framed.iorm.ui.subeditors.FRaMEDFeatureEditor; //*import for javadoc link
import org.framed.iorm.ui.util.DiagramUtil;

/**
 * the diagram editor used by {@link MultipageEditor}
 * <p>
 * Its extends {@link DiagramEditor} by the variable {@link #selectedFeatures} and its get and set methods.
 * Its also makes the editors CommandStack public.
 * @author Kevin Kassin
 */
public class FRaMEDDiagramEditor extends DiagramEditor  {
	
	/**
	 * the graphics algorithm service used to create graphics algorithms in the subclasses
	 */
	protected final IGaService graphicAlgorithmService = Graphiti.getGaService();
	
	/**
	 * the list of selected features in the diagram
	 * <p>
	 * Its refreshed each time the features are changed by the {@link FRaMEDFeatureEditor}.
	 * On saving the feature editor uses this to synchronize its configuration with the diagrams configuration. This is
	 * needed to implement undo and redo for configuration changes.
	 */
	private EList<FRaMEDFeature> selectedFeatures = null;
				
	/**
	 * Class constructor
	 */
	public FRaMEDDiagramEditor() {
		super();
	}
	
	/**
	 * updates the value of the class variable {@link #selectedFeatures}
	 */
	public void updateSelectedFeatures() {
		Diagram mainDiagram = DiagramUtil.getMainDiagramForIEditorInput(getEditorInput());
		if(mainDiagram.getLink().getBusinessObjects().size() == 1 &&
		   mainDiagram.getLink().getBusinessObjects().get(0) instanceof Model) {
			Model rootModel = (Model) mainDiagram.getLink().getBusinessObjects().get(0);
			selectedFeatures = rootModel.getFramedConfiguration().getFeatures();
		} else throw new NoModelFoundException();
	}
	
	/**
	 * the get method for the variable {@link #selectedFeatures}
	 * @return the selected features of the diagram 
	 */
	public EList<FRaMEDFeature> getSelectedFeatures() {
		return selectedFeatures;
	}

	/**
	 * publishes the editors command stack
	 */
	@Override
	public CommandStack getCommandStack() {
		return super.getCommandStack();
	}
}