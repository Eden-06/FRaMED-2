package interRelationshipConstraints.references;

public class RelationshipReference {
	
	relationship.Literals literals = new relationship.Literals();

	/**
	 * values for the property shape id gathered from {@link IdentifierLiterals}
	 */
	private final String SHAPE_ID_RELATIONSHIP_ANCHOR_DECORATOR = literals.SHAPE_ID_RELATIONSHIP_ANCHOR_DECORATOR;
	
	public String getShapeIdRelationshipAnchor() {
		return SHAPE_ID_RELATIONSHIP_ANCHOR_DECORATOR;
	}
}
