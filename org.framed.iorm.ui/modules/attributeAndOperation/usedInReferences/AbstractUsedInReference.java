package attributeAndOperation.usedInReferences;

import org.framed.iorm.model.Type;

public abstract class AbstractUsedInReference {

	protected Type modelType = null;
	
	protected String shadowShapeID = null;
	
	public Type getModelType() {
		return modelType;
	}
	
	public String getShadowShapeID() {
		return shadowShapeID;
	}
	
	public abstract int getHorizontalCenter(int height);
}
