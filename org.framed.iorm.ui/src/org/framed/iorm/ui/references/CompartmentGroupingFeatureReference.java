package org.framed.iorm.ui.references;

import org.framed.iorm.model.Type;

//TODO Doku für alles
public class CompartmentGroupingFeatureReference extends AbstractGroupingFeatureReference {

	compartment.Literals literals = new compartment.Literals();
	
	public CompartmentGroupingFeatureReference() {
		modelType = Type.COMPARTMENT_TYPE;
		DIAGRAM_KIND = literals.DIAGRAM_KIND;
		SHAPE_ID_CONTAINER = literals.SHAPE_ID_COMPARTMENTTYPE_CONTAINER;
		SHAPE_ID_NAME = literals.SHAPE_ID_COMPARTMENTTYPE_NAME;
		SHAPE_ID_TYPEBODY = literals.SHAPE_ID_COMPARTMENTTYPE_TYPEBODY;
	}
}
