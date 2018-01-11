package org.framed.iorm.ui;

import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.pattern.AbstractConnectionPattern;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.palette.FeaturePaletteDescriptor;

/**
 * This class is an abstract super class for the graphiti connection patterns.
 * <p>
 * It collects common attributes and operations of these classes.
 * @author Kevin Kassin
 */
public abstract class FRaMEDConnectionPattern extends AbstractConnectionPattern {
	
	/**
	 * the pictogram elements service used to creates pictogram elements in the subclasses
	 */
	protected final IPeCreateService pictogramElementCreateService = Graphiti.getPeCreateService();
	
	/**
	 * the graphics algorithm service used to create graphics algorithms in the subclasses
	 */
	protected final IGaService graphicAlgorithmService = Graphiti.getGaService();
	
	/**
	 * the {@link Type} of business object the pattern creates 
	 * <p>
	 * The standard value is null, but sub classes can set the attribute if needed.
	 */
	protected Type modelType = null;
	
	/**
	 * the name of the feature
	 */
	protected String FEATURE_NAME;
	
	/**
	 * the identifier or the path for the icon of the create feature
	 * <p>
	 * The image id has to be set, so there is no standard value. Meanwhile the standard value of the path 
	 * is an empty string, but sub classes can set the attribute if needed.
	 */
	protected String ICON_IMG_ID,
				     ICON_IMG_PATH= "";
	
	/**
	 * the fpd manages the palette visibility, see {@link FeaturePaletteDescriptor}
	 */
	protected FeaturePaletteDescriptor FPD;
	
	/**
	 * Class constructor
	 */
	public FRaMEDConnectionPattern() {
		super();
	}	
	
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
	 * getter method for the icon id for the create feature in this pattern
	 * @return the image identifier for the icon of the create feature 
	 */
	@Override
	public String getCreateImageId() {
		return ICON_IMG_ID;
	}
	
	/**
	 * getter method for the icon file path for the create feature in this pattern
	 * @return the image file path for the icon of the create feature
	 */
	public String getCreateImagePath() {
		return ICON_IMG_PATH ;
	}
	
	/**
	 * getter method for the model type of the pattern
	 * @return the model type of the pattern
	 */
	public Type getModelType() {
		return modelType;
	}
 	
	/**
	 * getter method for the fpd
	 * @return the feature palette descriptor
	 */
	public FeaturePaletteDescriptor getFeaturePaletteDescriptor() {
		return FPD;
	}
	
	/**
	 * encapsulates if and which custom feature should be used when double clicking a pictogram element
	 * created by the pattern
	 * <p>
	 * The standard implementation gives back null since most pattern don't use a double click feature. A
	 * sub class can override this implementation if needed.
 	 * @param customFeatures the list of possible custom feature to call
	 * @return the custom feature that should be used when double clicking a pictogram element
	 * created by the pattern or null if none should be called
	 */
	public IFeature getDoubleClickFeature(ICustomFeature[] customFeatures) {
		return null;
	}
	
	/**
	 * checks if connection can be reconnected
	 * <p>
	 * The standard implementation returns false to handle reconnects more safely. 
	 * A sub class can override this implementation if needed.
	 * @param context contains information about the reconnect 
	 * @return if a reconnect can be executed
	 */
	public boolean canReconnect(IReconnectionContext context) {
		return false;
	}
	
	/**
	 * executes needed action after a reconnect was successful
	 * <p>
	 * The standard implementation does nothing. A sub class can override this implementation if needed.
	 * @param context contains information about the reconnect
	 */
	public void postReconnect(IReconnectionContext context) {}
	
	/**
	 * executes needed actions when a connection is deleted
	 * <p>
	 * /**
	 * The standard implementation does nothing. A sub class can override this implementation if needed.
	 * @param deleteConnectionFeature the managing delete feature for all connections
	 * @param deleteContext contains informations about the deletion
	 */
	public void delete(FRaMEDDeleteConnectionFeature deleteConnectionFeature, IDeleteContext deleteContext) {};
}
