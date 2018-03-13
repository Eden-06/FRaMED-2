package relationship.intra_relationship_constraints;

import org.framed.iorm.ui.references.AbstractIntraRelationshipConstraintReference;

/**
 * This class encapsulates the dependency of the relationship to its intra relationship constraint feature.
 * @author Kevin Kassin
 */
public class IntraRelationshipConstraintReference extends AbstractIntraRelationshipConstraintReference {

	/**
	 * the intra relationship constraint literals
	 */
	Literals literals = new Literals();
	
	/**
	 * class constructor
	 */
	public IntraRelationshipConstraintReference() {
		SHAPE_ID_INTRA_REL_CON_NAME_DECORATOR = literals.SHAPE_ID_INTRA_REL_CON_NAME_DECORATOR; 
	}	
}
