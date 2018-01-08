package customFeatures.references;

import org.framed.iorm.model.Type;
import org.framed.iorm.ui.literals.UILiterals;

public class CompartmentStepInAndOutReference extends AbstractStepInAndOutReference {
		
	compartment.Literals literals = new compartment.Literals();
	
	public CompartmentStepInAndOutReference() {
		modelType = Type.COMPARTMENT_TYPE;
		SHAPE_ID_TYPEBODY = literals.SHAPE_ID_COMPARTMENTTYPE_TYPEBODY;
		SHAPE_ID_NAME = literals.SHAPE_ID_COMPARTMENTTYPE_NAME;
		DIAGRAM_KIND = UILiterals.DIAGRAM_KIND_COMPARTMENTTYPE_DIAGRAM;
	}
}
