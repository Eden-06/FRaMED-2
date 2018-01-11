package org.framed.iorm.ui.references;

import org.framed.iorm.model.Type;

//TODO Doku für alles
public class GroupGroupingFeatureReference extends AbstractGroupingFeatureReference {

	group.Literals literals = new group.Literals();
	
	public GroupGroupingFeatureReference() {
		modelType = Type.GROUP;
		DIAGRAM_KIND = literals.DIAGRAM_KIND;
		SHAPE_ID_CONTAINER = literals.SHAPE_ID_GROUP_CONTAINER;
		SHAPE_ID_NAME = literals.SHAPE_ID_GROUP_NAME;
		SHAPE_ID_TYPEBODY = literals.SHAPE_ID_GROUP_TYPEBODY;
	}
}
