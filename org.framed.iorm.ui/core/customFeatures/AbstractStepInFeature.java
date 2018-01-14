package customFeatures;

import java.util.List;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.ui.PlatformUI;
import org.framed.iorm.ui.FRaMEDCustomFeature;
import org.framed.iorm.ui.UIUtil;
import org.framed.iorm.ui.multipage.MultipageEditor;
import org.framed.iorm.ui.references.AbstractGroupingFeatureReference;

/**
 * This class is an abstract super class for the graphiti custom features {@link StepInFeature} and
 * {@link StepInNewTabFeature}.
 * <p>
 * It collects common attributes and operations of those two features.
 * @author Kevin Kassin
 */
public abstract class AbstractStepInFeature extends FRaMEDCustomFeature {
	
	/**
	 * the object to call utility operations on
	 */
	protected final Util util = new Util();
	
	/**
	 * the list of reference classes which save in module feature's shapes can group objects
	 * @see AbstractGroupingFeatureReference
	 */
	protected List<AbstractGroupingFeatureReference> groupingFeatureReferences; 

	/**
	 * Class constructor
	 * <p>
	 * Note: It gets the references which save in which other module feature's shapes a attribute or
	 * operations can be added here and saves them it into {@link #stepInAndOutReferences}.	
	 * @param featureProvider the feature provider the feature belongs to
	 */
	public AbstractStepInFeature(IFeatureProvider featureProvider) {
		super(featureProvider);
		//Note
		groupingFeatureReferences = UIUtil.getGroupingFeatureReferences();
	}
	
	/**
	 * This methods checks if the feature can be executed.
	 * <p>
	 * It returns true if<br>
	 * (1) exactly one pictogram element is selected and<br>
	 * (2) this pictogram element is the type body of a group, compartment and<br>
	 * (3) there are no unsaved changes of the diagram editor in which the pictogram element is shown
	 * @return if the feature can be executed
	 */
	@Override
	public boolean canExecute(ICustomContext customContext) {
		if(customContext.getPictogramElements().length == 1) {
			if(util.shapeIsFittingToStepInAndOutFeature((Shape) customContext.getPictogramElements()[0], groupingFeatureReferences)) {
				MultipageEditor multipageEditor = 
					(MultipageEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				if(!(multipageEditor.isDirty()))
					return true;
		}	}	
		return false;
	}
}
