package org.framed.iorm.ui.references;

import org.framed.iorm.model.Type;
import org.framed.iorm.ui.palette.PaletteView;

/**
 * This is the abstract superclass for references which contain informations about feature patterns that can
 * group other objects.
 * @author Kevin Kassin
 */
public abstract class AbstractGroupingFeatureReference {

	/**
	 * the model type of the grouping feature
	 */
	protected Type modelType;
	
	/**
	 * the kind of diagram the grouping feature creates
	 */
	protected String DIAGRAM_KIND;
	
	/**
	 * some shape ids of the grouping feature's pattern
	 */
	protected String SHAPE_ID_CONTAINER,
					 SHAPE_ID_NAME,
					 SHAPE_ID_TYPEBODY;
	
	/**
	 * the palette view of the grouping feature when stepped in it
	 */
	protected PaletteView paletteView;
	
	/**
	 * getter method for modelType
	 * @return the model type
	 */
	public Type getModelType() {
		return modelType;
	}
	
	/**
	 * getter method for DIAGRAM_KIND
	 * @return the diagram kind
	 */
	public String getDiagramKind() {
		return DIAGRAM_KIND;
	}
	
	/**
	 * getter method for SHAPE_ID_CONTAINER
	 * @return the shape id of the container
	 */
	public String getShapeIdContainer() {
		return SHAPE_ID_CONTAINER;
	}
	
	/**
	 * getter method for SHAPE_ID_NAME
	 * @return the shape id of the name shape
	 */
	public String getShapeIdName() {
		return SHAPE_ID_NAME;
	}
	
	/**
	 * getter method for SHAPE_ID_TYPEBODY
	 * @return the shape id of the typebody
	 */
	public String getShapeIdTypebody() {
		return SHAPE_ID_TYPEBODY;
	}
	
	/**
	 * getter method for paletteView
	 * @return the palette view of the grouping feature when stepped in it
	 */
	public PaletteView getPaletteView() {
		return paletteView;
	}
}
