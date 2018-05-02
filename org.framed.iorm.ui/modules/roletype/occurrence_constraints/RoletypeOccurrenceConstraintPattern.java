package roletype.occurrence_constraints;

import java.util.List;

import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.pattern.IPattern;
import org.framed.iorm.ui.FRaMEDShapePattern;
import org.framed.iorm.ui.UIUtil;
import org.framed.iorm.ui.palette.FeaturePaletteDescriptor;
import org.framed.iorm.ui.palette.PaletteCategory;
import org.framed.iorm.ui.palette.ViewVisibility;
import org.framed.iorm.ui.wizards.RoleModelWizard;

import customFeatures.ChangeConfigurationListener;

/**
 * This pattern manages setting occurrence constraints of role types (in)visible when changing the configuration. It is 
 * a {@link ChangeConfigurationListener} for that reason.
 * @author Kevin Kassin
 */
public class RoletypeOccurrenceConstraintPattern extends FRaMEDShapePattern implements IPattern, ChangeConfigurationListener {

	/**
	 * literals of role types
	 */
	roletype.Literals literals = new roletype.Literals();
	
	/**
	 * the feature palette descriptor manages the palette visibility, see {@link FeaturePaletteDescriptor}
	 */
	private final FeaturePaletteDescriptor spec_FPD = new FeaturePaletteDescriptor(
			PaletteCategory.NONE,
			ViewVisibility.NO_VIEW);
	
	/**
	 * class constructor		
	 */
	public RoletypeOccurrenceConstraintPattern() {
		super();
		FEATURE_NAME = literals.OC_FEATURE_NAME;
		ICON_IMG_ID = literals.OC_ICON_IMG_ID;
		FPD = spec_FPD;
	}
	
	/**
	 * checks if pattern is applicable for a given business object
	 * <p>
	 * return false since the pattern is never used by graphiti
	 */
	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) { return false; }

	/**
	 * checks if pattern is applicable for a given pictogram element
	 * <p>
	 * return false since the pattern is never used by graphiti
	 */
	@Override
	protected boolean isPatternControlled(PictogramElement pictogramElement) { return false; }

	/**
	 * checks if the pictogram element to edit with the pattern is its root
	 * <p>
	 * return false since the pattern is never used by graphiti
	 */
	@Override
	protected boolean isPatternRoot(PictogramElement pictogramElement) { return false; }

	/**
	 * If the editor's configuration changes this operation is called. It takes the old and the new chosen features 
	 * as a list of strings. If the occurrence constraints feature changes its status {@link #setVisibilityOfOccurrenceConstraints}
	 * is called.
	 */
	@Override
	public void configurationChanged(List<String> newframedFeatureNames, List<String> oldframedFeatureNames) {
		if(newframedFeatureNames.contains("Occurrence_Constraints") && 
		   !(oldframedFeatureNames.contains("Occurrence_Constraints")))
			 setVisibilityOfOccurrenceConstraints(true);
		if(!(newframedFeatureNames.contains("Occurrence_Constraints")) && 
		   oldframedFeatureNames.contains("Occurrence_Constraints"))
			setVisibilityOfOccurrenceConstraints(false);
	}
		
	/**
	 * Sets the visibility of all occurrence constraints of role groups to a given boolean using the following steps:
	 * <p>
	 * Step 1: It gets the container diagram to interate over it.<br>
	 * Step 2: For every child diagram of the container diagram iterates over the its element.<br>
	 * Step 3: If the inner elements are a role type it find its occurrence constraint and set it (in)visible.
	 * <p>
	 * If its not clear what <em>container diagram</em> and <em>main diagram</em> means, see 
	 * {@link RoleModelWizard#createEmfFileForDiagram} for reference.
	 * @param visible the boolean to set the visibility of all occurrence constraints to
	 */
	private void setVisibilityOfOccurrenceConstraints(boolean visible) {
		//Step 1
		Diagram mainDiagram = UIUtil.getMainDiagramForAnyDiagram(getDiagram());
		if(mainDiagram.getContainer() instanceof Diagram) {
			Diagram containerDiagram = (Diagram) mainDiagram.getContainer();
			for(Shape shape : containerDiagram.getChildren()) {
				//Step 2
				if(shape instanceof Diagram) {
					Diagram diagram = (Diagram) shape;
					for(Shape innerShape : diagram.getChildren()) {
						//Step 3
						if(UIUtil.isShape_IdValue(innerShape, literals.SHAPE_ID_ROLETYPE_CONTAINER)) {
							for(Shape innerInnerShape : ((ContainerShape) innerShape).getChildren()) {
								if(UIUtil.isShape_IdValue(innerInnerShape, literals.SHAPE_ID_ROLETYPE_OCCURRENCE_CONSTRAINT)) {
									innerInnerShape.setVisible(visible);
	}	}	}	}	}	}	}	}
}
