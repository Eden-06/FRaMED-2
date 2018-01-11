package org.framed.iorm.ui.references;

import org.framed.iorm.model.Type;

/**
 * This is the grouping feature reference which contain informations about the compartment type
 * @author Kevin Kassin
 */
public class CompartmentGroupingFeatureReference extends AbstractGroupingFeatureReference {

	/**
	 * the compartment type's literals
	 */
	compartment.Literals literals = new compartment.Literals();
	
	/**
	 * class constructor
	 */
	public CompartmentGroupingFeatureReference() {
		modelType = Type.COMPARTMENT_TYPE;
		DIAGRAM_KIND = literals.DIAGRAM_KIND;
		SHAPE_ID_CONTAINER = literals.SHAPE_ID_COMPARTMENTTYPE_CONTAINER;
		SHAPE_ID_NAME = literals.SHAPE_ID_COMPARTMENTTYPE_NAME;
		SHAPE_ID_TYPEBODY = literals.SHAPE_ID_COMPARTMENTTYPE_TYPEBODY;
		paletteView = literals.paletteView;
	}
}
