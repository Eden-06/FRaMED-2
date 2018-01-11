package customFeatures.references;

import org.framed.iorm.model.Type;

/**
 * The reference class that encapsulate the informations for compartment types to step in and out.
 * @author Kevin Kassin
 */
public class CompartmentStepInAndOutReference extends AbstractStepInAndOutReference {
		
	/**
	 * the compartment type's literals
	 */
	compartment.Literals literals = new compartment.Literals();
	
	/**
	 * class constructor
	 */
	public CompartmentStepInAndOutReference() {
		modelType = Type.COMPARTMENT_TYPE;
		SHAPE_ID_TYPEBODY = literals.SHAPE_ID_COMPARTMENTTYPE_TYPEBODY;
		SHAPE_ID_NAME = literals.SHAPE_ID_COMPARTMENTTYPE_NAME;
		DIAGRAM_KIND = literals.DIAGRAM_KIND;
	}
}
