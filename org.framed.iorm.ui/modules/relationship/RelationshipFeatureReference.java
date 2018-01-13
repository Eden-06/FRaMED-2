package relationship;

import org.framed.iorm.ui.references.AbstractRelationshipFeatureReference;

/**
 * makes some informations about relationship feature accessable for other features modules
 * @author Kevin Kassin
 */
public class RelationshipFeatureReference extends AbstractRelationshipFeatureReference {
	
	/**
	 * the relationships literals class
	 */
	Literals literals = new Literals();

	/**
	 * class constructor
	 */
	public RelationshipFeatureReference() {
		SHAPE_ID_RELATIONSHIP_ANCHOR_DECORATOR = literals.SHAPE_ID_RELATIONSHIP_ANCHOR_DECORATOR;
	}
}
