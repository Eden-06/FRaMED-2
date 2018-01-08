package compartment;

import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.pattern.IPattern;
import org.framed.iorm.ui.FRaMEDShapePattern;
import org.framed.iorm.ui.palette.FeaturePaletteDescriptor;
import org.framed.iorm.ui.palette.PaletteCategory;
import org.framed.iorm.ui.palette.ViewVisibility;
import org.framed.iorm.ui.util.UIUtil;

/**
 * This graphiti pattern is used to work with text shapes
 * of the preview of compartment types content.
 * <p>
 * It deals with the following aspect of text shapes for group or compartment type elements:<br>
 * (1) disables deleting the text shapes<br>
 * (2) disables moving the text shapes<br>
 * (3) disables resizing the text shapes
 * @author Kevin Kassin
 */
public class CompartmentTypeElementPattern extends FRaMEDShapePattern implements IPattern {

	/**
	 * the object to get names, ids and so on for this feature
	 */
	private final Literals literals = new Literals();
	
	/**
	 * the feature palette descriptor manages the palette visibility, see {@link FeaturePaletteDescriptor}
	 */
	private final FeaturePaletteDescriptor spec_FPD = new FeaturePaletteDescriptor(
			PaletteCategory.NONE,
			ViewVisibility.NO_VIEW);
	
	/**
	 * Class constructor
	 */
	public CompartmentTypeElementPattern() {
		super();
		FEATURE_NAME = literals.ELEMENTS_FEATURE_NAME;
		ICON_IMG_ID = literals.ELEMENTS_ICON_IMG_ID;
		ICON_IMG_PATH = literals.ELEMENTS_ICON_IMG_PATH;
		modelType = null;
		FPD = spec_FPD;
	}

	/**
	 * return null since this pattern does not offer a double click feature
	 */
	public IFeature getDoubleClickFeature(ICustomFeature[] customFeatures) {
		return null;
	}
	
	/**
	 * checks if pattern is applicable for a given business object
	 * @return true, if business object is null
	 */
	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
		if(mainBusinessObject == null) {
			return true;
		}
		return false;
	}

	/**
	 * checks if pattern is applicable for a given pictogram element
	 * @return true, if the pictogram element is text shape for a compartment 
	 * type element
	 */
	@Override
	protected boolean isPatternControlled(PictogramElement pictogramElement) {
		if(pictogramElement instanceof Shape) {
			Shape shape = (Shape) pictogramElement;
			if(shape.getGraphicsAlgorithm() instanceof Text)
				if(UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_COMPARTMENTTYPE_ELEMENT))
					return true;
		}
		return false;
	}

	/**
	 * checks if the pictogram element to edit with the pattern is its root
	 * @return true, if the pictogram element is text shape for a compartment 
	 * type element
	 */
	@Override
	protected boolean isPatternRoot(PictogramElement pictogramElement) {
		if(pictogramElement instanceof Shape) {
			Shape shape = (Shape) pictogramElement;
			if(shape.getGraphicsAlgorithm() instanceof Text)
				if(UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_COMPARTMENTTYPE_ELEMENT))
					return true;
		}	
		return false;
	}

	//delete feature
	//~~~~~~~~~~~~~~
	/**
	 * disables the move feature for elements
	 */
	@Override
	public boolean canDelete(IDeleteContext deleteContext) {
		return false;
	}
	
	//move feature
	//~~~~~~~~~~~~
	/**
	 * disables the move feature for elements
	 */
	@Override
	public boolean canMoveShape(IMoveShapeContext moveContext) {
		return false;
	}
			
	//resize feature
	//~~~~~~~~~~~~~~
	/**
	 * disables the resize feature for elements
	 */
	@Override
	public boolean canResizeShape(IResizeShapeContext context) {
		return false; 
	}
}
