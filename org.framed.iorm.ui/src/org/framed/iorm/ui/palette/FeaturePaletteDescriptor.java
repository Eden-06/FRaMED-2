package org.framed.iorm.ui.palette;

public class FeaturePaletteDescriptor {
	
	public PaletteCategory paletteCategory = PaletteCategory.NONE;
	public ViewVisibility viewVisibility = ViewVisibility.NO_VIEW;
	
	public FeaturePaletteDescriptor(PaletteCategory paletteCategory, ViewVisibility viewVisibility) {
		this.paletteCategory = paletteCategory;
		this.viewVisibility = viewVisibility;
	}

}
