package org.framed.iorm.ui.pattern.shapes;

import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.pattern.IPattern;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.literals.NameLiterals;
import org.framed.iorm.ui.palette.FeaturePaletteDescriptor;
import org.framed.iorm.ui.palette.PaletteCategory;
import org.framed.iorm.ui.palette.ViewVisibility;
import org.framed.iorm.ui.util.PropertyUtil;

/**
 * This graphiti pattern is used to work with text shapes
 * of the preview of the groups or compartment types content.
 * <p>
 * It deals with the following aspect of text shapes for group or compartment type elements:<br>
 * (1) disables deleting the text shapes<br>
 * (2) disables moving the text shapes<br>
 * (3) disables resizing the text shapes
 * @see GroupPattern
 * @author Kevin Kassin
 */
public class GroupOrCompartmentTypeElementPattern extends FRaMEDShapePattern implements IPattern {

	private final FeaturePaletteDescriptor spec_FPD = new FeaturePaletteDescriptor(
			PaletteCategory.NONE,
			ViewVisibility.NO_VIEW);
	
	/**
	 * the value of the property shape id for the text shapes of the group and compartment types elements
	 */
	private final String SHAPE_ID_GROUP_ELEMENT = IdentifierLiterals.SHAPE_ID_GROUP_ELEMENT,
						 SHAPE_ID_COMPARTMENTTYPE_ELEMENT = IdentifierLiterals.SHAPE_ID_COMPARTMENTTYPE_ELEMENT;
	
	/**
	 * the feature name of the create feature in this pattern gathered from {@link NameLiterals}
	 */
	private final String GROUP_OR_COMPARTMENT_TYPE_ELEMENT_FEATURE_NAME = NameLiterals.GROUP_OR_COMPARTMENT_TYPE_ELEMENT_FEATURE_NAME;
	
	/**
	 * Class constructor
	 */
	public GroupOrCompartmentTypeElementPattern() {
		super();
		FPD = spec_FPD;
	}
	

	/**
	 * get method for the create features name
	 * @return the name of the create feature
	 */
	@Override
	public String getCreateName() {
		return GROUP_OR_COMPARTMENT_TYPE_ELEMENT_FEATURE_NAME;
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
	 * @return true, if the pictogram element is text shape for a group or compartment 
	 * type element
	 */
	@Override
	protected boolean isPatternControlled(PictogramElement pictogramElement) {
		if(pictogramElement instanceof Shape) {
			Shape shape = (Shape) pictogramElement;
			if(shape.getGraphicsAlgorithm() instanceof Text)
				if(PropertyUtil.isShape_IdValue(shape, SHAPE_ID_GROUP_ELEMENT) ||
				   PropertyUtil.isShape_IdValue(shape, SHAPE_ID_COMPARTMENTTYPE_ELEMENT)) {
					return true;
		}	}	
		return false;
	}

	/**
	 * checks if the pictogram element to edit with the pattern is its root
	 * @return true, if the pictogram element is text shape for a group or compartment 
	 * type element
	 */
	@Override
	protected boolean isPatternRoot(PictogramElement pictogramElement) {
		if(pictogramElement instanceof Shape) {
			Shape shape = (Shape) pictogramElement;
			if(shape.getGraphicsAlgorithm() instanceof Text)
				if(PropertyUtil.isShape_IdValue(shape, SHAPE_ID_GROUP_ELEMENT) ||
				   PropertyUtil.isShape_IdValue(shape, SHAPE_ID_COMPARTMENTTYPE_ELEMENT))
					return true;
		}	
		return false;
	}

	//delete feature
	//~~~~~~~~~~~~~~
	/**
	 * disables the move feature for attributes and operations
	 */
	@Override
	public boolean canDelete(IDeleteContext deleteContext) {
		return false;
	}
	
	//move feature
	//~~~~~~~~~~~~
	/**
	 * disables the move feature for attributes and operations
	 */
	@Override
	public boolean canMoveShape(IMoveShapeContext moveContext) {
		return false;
	}
			
	//resize feature
	//~~~~~~~~~~~~~~
	/**
	 * disables the resize feature for attributes and operations
	 */
	@Override
	public boolean canResizeShape(IResizeShapeContext context) {
		return false; 
	}
}
