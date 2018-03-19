package rolemodel;

import org.framed.iorm.model.Type;
import org.framed.iorm.ui.references.AbstractGroupingFeatureReference;

/**
 * This is the grouping feature reference which contain informations about the role model
 * @author Kevin Kassin
 */
public class RoleModelGroupingFeatureReference extends AbstractGroupingFeatureReference {

	/**
	 * the compartment type's literals
	 */
	Literals literals = new Literals();
	
	/**
	 * class constructor
	 */
	public RoleModelGroupingFeatureReference() {
		modelType = Type.COMPARTMENT_TYPE;
		DIAGRAM_KIND = literals.DIAGRAM_KIND;
		SHAPE_ID_CONTAINER = literals.SHAPE_ID_COMPARTMENTTYPE_CONTAINER;
		SHAPE_ID_NAME = literals.SHAPE_ID_COMPARTMENTTYPE_NAME;
		SHAPE_ID_TYPEBODY = literals.SHAPE_ID_COMPARTMENTTYPE_TYPEBODY;
		paletteView = literals.paletteView;
	}
}
