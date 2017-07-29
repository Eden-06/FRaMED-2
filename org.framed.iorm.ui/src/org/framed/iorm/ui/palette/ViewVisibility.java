package org.framed.iorm.ui.palette;

import org.framed.iorm.ui.providers.ToolBehaviorProvider; //*import for javadoc link

/**
 * This enum creates possible values to save in which palette view to show a feature in the palette. It is used in
 * {@link FeatureManager} and the {@link ToolBehaviorProvider}.
 * @author Kevin Kassin
 */
public enum ViewVisibility {
	
	ALL_VIEWS,
	TOPLEVEL_VIEW,
	COMPARTMENT_VIEW,
	NO_VIEW;

}
