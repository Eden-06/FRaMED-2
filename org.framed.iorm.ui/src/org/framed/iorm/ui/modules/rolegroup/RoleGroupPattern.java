package org.framed.iorm.ui.modules.rolegroup;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.pattern.IPattern;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.palette.FeaturePaletteDescriptor;
import org.framed.iorm.ui.palette.PaletteCategory;
import org.framed.iorm.ui.palette.ViewVisibility;
import org.framed.iorm.ui.pattern.shapes.FRaMEDShapePattern;

public class RoleGroupPattern extends FRaMEDShapePattern implements IPattern {

	String spec_FEATURE_NAME = "Role Group";
	
	String spec_ICON_IMG_ID = "org.framed.iorm.ui.modules.rolegroup";
	
	FeaturePaletteDescriptor spec_FPD = new FeaturePaletteDescriptor(
											PaletteCategory.ENTITIES_CATEGORY,
											ViewVisibility.COMPARTMENT_VIEW);
	
	public RoleGroupPattern() {
		super();
		FEATURE_NAME = spec_FEATURE_NAME;
		ICON_IMG_ID = spec_ICON_IMG_ID;
		FPD = spec_FPD;
	}
	
	@Override
	public boolean isMainBusinessObjectApplicable(Object businessObject) {
		if(businessObject instanceof org.framed.iorm.model.Shape) {
			org.framed.iorm.model.Shape shape = (org.framed.iorm.model.Shape) businessObject;
			if(shape.getType() == Type.DATA_TYPE) return true;
		}
		return false;
	}

	@Override
	protected boolean isPatternControlled(PictogramElement pictogramElement) {
		Object businessObject = getBusinessObjectForPictogramElement(pictogramElement);
		return isMainBusinessObjectApplicable(businessObject);
	}

	@Override
	protected boolean isPatternRoot(PictogramElement pictogramElement) {
		Object businessObject = getBusinessObjectForPictogramElement(pictogramElement);
		return isMainBusinessObjectApplicable(businessObject);
	}

}
