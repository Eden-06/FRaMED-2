package attributeAndOperation.references;

import org.framed.iorm.model.Type;

/**
 * The reference class which saves in which other module feature's shapes a attribute or
 * operation can be added with specific informations for Compartment Types.
 */
public class CompartmentTypeUsedInReference extends AbstractUsedInReference {

	private compartment.Literals literals = new compartment.Literals();
	
	/**
	 * class constructor
	 */
	public CompartmentTypeUsedInReference() {
		modelType = Type.COMPARTMENT_TYPE;
		shadowShapeID = literals.SHAPE_ID_COMPARTMENTTYPE_SHADOW;
	}

	//nicht benutzt!
	@Override
	public int getHorizontalCenter(int height) {
		return 0;
	}
}
