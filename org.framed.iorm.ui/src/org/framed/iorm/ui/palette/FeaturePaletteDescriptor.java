package org.framed.iorm.ui.palette;

/**
 * An object of this class describes when and where to show a feature in the palette.
 * @author Kevin Kassin
 */
public class FeaturePaletteDescriptor {
	
	/**
	 * in which category to show a feature in the palette
	 */
	public PaletteCategory paletteCategory = PaletteCategory.NONE;
	
	/**
	 * depending on the current palette view when to show the feature in the palette
	 */
	public ViewVisibility viewVisibility = ViewVisibility.NO_VIEW;
	
	/**
	 * Class constructor
	 */
	public FeaturePaletteDescriptor(PaletteCategory paletteCategory, ViewVisibility viewVisibility) {
		this.paletteCategory = paletteCategory;
		this.viewVisibility = viewVisibility;
	}

}
