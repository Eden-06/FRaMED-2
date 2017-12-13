package org.framed.iorm.ui.pattern.connections;

import org.eclipse.graphiti.pattern.AbstractConnectionPattern;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.framed.iorm.ui.palette.FeaturePaletteDescriptor;

/**
 * This class is an abstract super class for the graphiti connection patterns.
 * <p>
 * It collects common attributes and operations of these classes.
 * @author Kevin Kassin
 */
public abstract class FRaMEDConnectionPattern extends AbstractConnectionPattern {
	
	/**
	 * the name of the feature
	 */
	protected String FEATURE_NAME;
	
	/**
	 * the identifier for the icon of the create feature
	 */
	protected String ICON_IMG_ID;
	
	/**
	 * the fpd manages the palette visibility, see {@link FeaturePaletteDescriptor}
	 */
	protected FeaturePaletteDescriptor FPD;
	
	/**
	 * get method for the features name
	 * 
	 * @return the name of the feature
	 */
	@Override
	public String getCreateName() {
		return FEATURE_NAME;
	}

	/**
	 * get method for the identifier of the icon for the create feature
	 * 
	 * @return the id of the icon
	 */
	@Override
	public String getCreateImageId() {
		return ICON_IMG_ID;
	}
	
	/**
	 * get method for the fpd
	 * @return the feature palette descriptor
	 */
	public FeaturePaletteDescriptor getFeaturePaletteDescriptor() {
		return FPD;
	}
	
	/**
	 * Class constructor
	 */
	public FRaMEDConnectionPattern() {
		super();
	}
	
	/**
	 * the pictogram elements service used to creates pictogram elements in the subclasses
	 */
	protected final IPeCreateService pictogramElementCreateService = Graphiti.getPeCreateService();
	
	/**
	 * the graphics algorithm service used to create graphics algorithms in the subclasses
	 */
	protected final IGaService graphicAlgorithmService = Graphiti.getGaService();	
}
