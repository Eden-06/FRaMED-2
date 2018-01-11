package org.framed.iorm.ui.references;

import org.framed.iorm.model.Type;

//TODO doku für alles!
public abstract class AbstractGroupingFeatureReference {

	protected Type modelType;
	
	protected String DIAGRAM_KIND;
	
	protected String SHAPE_ID_CONTAINER,
					 SHAPE_ID_NAME,
					 SHAPE_ID_TYPEBODY;
	
	public Type getModelType() {
		return modelType;
	}
	
	public String getDiagramKind() {
		return DIAGRAM_KIND;
	}
	
	public String getShapeIdContainer() {
		return SHAPE_ID_CONTAINER;
	}
	
	public String getShapeIdName() {
		return SHAPE_ID_NAME;
	}
	
	public String getShapeIdTypebody() {
		return SHAPE_ID_TYPEBODY;
	}
}
