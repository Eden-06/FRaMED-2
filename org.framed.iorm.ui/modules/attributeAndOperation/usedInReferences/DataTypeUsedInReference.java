package attributeAndOperation.usedInReferences;

import org.framed.iorm.model.Type;

public class DataTypeUsedInReference extends AbstractUsedInReference {

	private datatype.Literals literals = new datatype.Literals();
	
	private datatype.Util util = new datatype.Util();
	
	public DataTypeUsedInReference() {
		modelType = Type.DATA_TYPE;
		shadowShapeID = literals.SHAPE_ID_DATATYPE_SHADOW;
	}
	
	@Override
	public int getHorizontalCenter(int height) {
		return util.calculateHorizontalCenter(height);
	}

}
