package testfeature;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.framed.iorm.ui.palette.FeaturePaletteDescriptor;
import org.framed.iorm.ui.palette.PaletteCategory;
import org.framed.iorm.ui.palette.ViewVisibility;
import org.framed.iorm.ui.pattern.shapes.FRaMEDShapePattern;

public class TestFeature extends FRaMEDShapePattern {

	String spec_FEATURE_NAME = "Role Group";
	
	String spec_ICON_IMG_ID = "org.framed.iorm.ui.modules.rolegroup",
		   spec_ICON_IMG_PATH = "modules/testfeature/icon_attribute.png";
	
	FeaturePaletteDescriptor spec_FPD = new FeaturePaletteDescriptor(
											PaletteCategory.ENTITIES_CATEGORY,
											ViewVisibility.COMPARTMENT_VIEW);
	
	public TestFeature() {
		super();
		FEATURE_NAME = spec_FEATURE_NAME;
		ICON_IMG_ID = spec_ICON_IMG_ID;
		ICON_IMG_PATH = spec_ICON_IMG_PATH;
		FPD = spec_FPD;
	}
	
	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean isPatternControlled(PictogramElement pictogramElement) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean isPatternRoot(PictogramElement pictogramElement) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
