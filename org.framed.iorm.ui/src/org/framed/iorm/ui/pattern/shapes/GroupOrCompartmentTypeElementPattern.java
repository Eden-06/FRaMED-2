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
import org.framed.iorm.ui.util.PropertyUtil;

public class GroupOrCompartmentTypeElementPattern extends FRaMEDShapePattern implements IPattern {

	private final String SHAPE_ID_GROUP_ELEMENT = IdentifierLiterals.SHAPE_ID_GROUP_ELEMENT;
	
	private final String GROUP_OR_COMPARTMENT_TYPE_ELEMENT_FEATURE_NAME = NameLiterals.GROUP_OR_COMPARTMENT_TYPE_ELEMENT_FEATURE_NAME;
	
	public GroupOrCompartmentTypeElementPattern() {
		super();
	}
	
	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
		if(mainBusinessObject == null) {
			return true;
		}
		return false;
	}

	@Override
	protected boolean isPatternControlled(PictogramElement pictogramElement) {
		if(pictogramElement instanceof Shape) {
			Shape shape = (Shape) pictogramElement;
			if(shape.getGraphicsAlgorithm() instanceof Text &&
			   PropertyUtil.isShape_IdValue(shape, SHAPE_ID_GROUP_ELEMENT)) 
				return true;
		}	
		return false;
	}

	@Override
	protected boolean isPatternRoot(PictogramElement pictogramElement) {
		if(pictogramElement instanceof Shape) {
			Shape shape = (Shape) pictogramElement;
			if(shape.getGraphicsAlgorithm() instanceof Text
			   && PropertyUtil.isShape_IdValue(shape, SHAPE_ID_GROUP_ELEMENT)) 
				return true;
		}	
		return false;
	}
	
	/**
	 * get method for the create features name
	 * @return the name of the create feature
	 */
	@Override
	public String getCreateName() {
		return GROUP_OR_COMPARTMENT_TYPE_ELEMENT_FEATURE_NAME;
	}
	
	//delete feature
	//~~~~~~~~~~~~~~
	/**TODO
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
