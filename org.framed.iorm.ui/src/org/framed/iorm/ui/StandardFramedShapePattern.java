package org.framed.iorm.ui;

import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.pattern.IPattern;
import org.framed.iorm.ui.palette.FeaturePaletteDescriptor;
import org.framed.iorm.ui.palette.PaletteCategory;
import org.framed.iorm.ui.palette.ViewVisibility;


/**
 * This class is used to ensure already existing shapes in models of features not implemented cannot be resized, 
 * moved or be deleted. This is needed since the resize, move or delete operation in the pattern of feature modules
 * do often important action. Without these action problems can occur and therefore this needs to be avoided.
 * @author Kevin Kassin
 */
public class StandardFramedShapePattern extends FRaMEDShapePattern implements IPattern {

	/**
	 * the feature palette descriptor manages the palette visibility, see {@link FeaturePaletteDescriptor}
	 */
	private final FeaturePaletteDescriptor spec_FPD = new FeaturePaletteDescriptor(
			PaletteCategory.NONE,
			ViewVisibility.NO_VIEW);
			
	/**
	 * class constructor		
	 */
	public StandardFramedShapePattern() {
		super();
		FPD = spec_FPD;
	}
	
	/**
	 * checks if pattern is applicable for a given business object
	 * @return true, if business object is a {@link org.framed.iorm.model.Shape}
	 */
	@Override
	public boolean isMainBusinessObjectApplicable(Object businessObject) {
		return businessObject instanceof org.framed.iorm.model.Shape;
	}

	/**
	 * checks if pattern is applicable for a given pictogram element
	 * @return true, if business object of the pictogram element is a {@link org.framed.iorm.model.Shape}
	 */
	@Override
	protected boolean isPatternControlled(PictogramElement pictogramElement) { 
		Object businessObject = getBusinessObjectForPictogramElement(pictogramElement);
		return isMainBusinessObjectApplicable(businessObject); 
	}

	/**
	 * checks if the pictogram element to edit with the pattern is its root
	 * @return true, if business object of the pictogram element is a {@link org.framed.iorm.model.Shape}
	 */
	@Override
	protected boolean isPatternRoot(PictogramElement pictogramElement) { 
		Object businessObject = getBusinessObjectForPictogramElement(pictogramElement);
		return isMainBusinessObjectApplicable(businessObject); 
	}
	
	/**
	 * standard implementation to ensure already existing shapes in models of features not implemented cannot be resized
	 */
	@Override
	public boolean canResizeShape(IResizeShapeContext resizeContext) { return false; }
	
	/**
	 * standard implementation to ensure already existing shapes in models of features not implemented cannot be moved
	 */
	@Override
	public boolean canMoveShape(IMoveShapeContext moveContext) { return false; }
	
	/**
	 * standard implementation to ensure already existing shapes in models of features not implemented cannot be deleted
	 */
	@Override
	public boolean canDelete(IDeleteContext deleteContext) { return false; }
}