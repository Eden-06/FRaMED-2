package customFeatures.references;

import org.framed.iorm.model.Type;

public abstract class AbstractStepInAndOutReference {

	protected Type modelType;
	
	protected String SHAPE_ID_TYPEBODY,
					 SHAPE_ID_NAME,
					 DIAGRAM_KIND;

	public Type getModelType() {
		return modelType;
	}
	
	public String getShapeIdTypebody() {
		return SHAPE_ID_TYPEBODY;
	}
	
	public String getShapeIdName() {
		return SHAPE_ID_NAME;
	}
	
	public String getDiagramKind() {
		return DIAGRAM_KIND;
	}
}
