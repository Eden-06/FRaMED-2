package compartment.properties;

import org.framed.iorm.model.Type;
import org.framed.iorm.ui.references.AbstractHasAttsAndOpsReference;

import compartment.Literals;

/**
 * The reference class which saves in which module feature's shapes a attribute or
 * operation can be added with specific informations for Compartment Types.
 */
public class CompartmentTypeHasAttsAndOpsReference extends AbstractHasAttsAndOpsReference {

	/**
	 * the compartments literals
	 */
	private Literals literals = new Literals();
	
	/**
	 * class constructor
	 */
	public CompartmentTypeHasAttsAndOpsReference() {
		modelType = Type.COMPARTMENT_TYPE;
		shadowShapeID = literals.SHAPE_ID_COMPARTMENTTYPE_SHADOW;
	}
}
