package org.framed.iorm.ui.palette;

import java.util.List;

/**
 * An object of this class describes when and where to show a feature in the palette. This depends on its category, its view 
 * visibility (in which diagram views its visible) and on the current configuration of the edited diagram.
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
	
	/**
	 * A standard implemention of the check if a palette entry is shown dependant on the current feature configuration
	 * of the edited diagram.
	 * <p>
	 * This method is overwritten in the graphitti pattern of the feature modules, if there its palette entry is dependant
	 * on the feature configuration.
	 * @param featureNames list of the names of the chosen features in the current feature configuration
	 * @return true
	 */
	public boolean featureExpression(List<String> featureNames, PaletteView paletteView) {
		return true;
	}

}
