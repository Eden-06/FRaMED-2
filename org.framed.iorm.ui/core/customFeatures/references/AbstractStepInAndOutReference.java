package customFeatures.references;

import org.framed.iorm.model.Type;

/**
 * This is the abstract super class for references that encapsulate the informations for grouping feature's patterns. For
 * these features the step in and out features need to work.
 * @author Kevin Kassin
 */
public abstract class AbstractStepInAndOutReference {

	/**
	 * the type of the grouping feature
	 */
	protected Type modelType;
	
	/**
	 * the shape id and diagram type of the grouping feature's patterns
	 */
	protected String SHAPE_ID_TYPEBODY,
					 SHAPE_ID_NAME,
					 DIAGRAM_KIND;

	/**
	 * getter method for modelType
	 * @return the model type
	 */
	public Type getModelType() {
		return modelType;
	}
	
	/**
	 * getter method for SHAPE_ID_TYPEBODY
	 * @return the shape id of the grouping feature's typebody
	 */
	public String getShapeIdTypebody() {
		return SHAPE_ID_TYPEBODY;
	}
	
	/**
	 * getter method for SHAPE_ID_NAME
	 * @return the shape id of the grouping feature's name shape
	 */
	public String getShapeIdName() {
		return SHAPE_ID_NAME;
	}
	
	/**
	 * getter method for DIAGRAM_KIND
	 * @return the kind of the diagram the grouping feature creates
	 */
	public String getDiagramKind() {
		return DIAGRAM_KIND;
	}
}
