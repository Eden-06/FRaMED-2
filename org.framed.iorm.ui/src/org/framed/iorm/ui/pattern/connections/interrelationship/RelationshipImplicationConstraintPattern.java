package org.framed.iorm.ui.pattern.connections.interrelationship;

import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.literals.LayoutLiterals;
import org.framed.iorm.ui.literals.NameLiterals;
import org.framed.iorm.ui.pattern.connections.roleconstraint.AbstractRoleConstraintPattern;

//TODO
public class RelationshipImplicationConstraintPattern extends AbstractInterRelationshipConstraintPattern {

	/**
	 * the name of the feature gathered from {@link NameLiterals}
	 */
	private final String RELATIONSHIP_IMPLICATION_FEATURE_NAME = NameLiterals.RELATIONSHIP_IMPLICATION_FEATURE_NAME;
		     
	/**
	 * the identifier for the icon of the create feature gathered from {@link IdentifierLiterals}
	 */
	private static final String IMG_ID_FEATURE_RELATIONSHIP_IMPLICATION = IdentifierLiterals.IMG_ID_FEATURE_RELATIONSHIP_IMPLICATION;
	
	/**
	 * Class constructor
	 */
	public RelationshipImplicationConstraintPattern() {
		super();
	}
	
	/**
	 * get method for the features name
	 * @return the name of the feature
	 */
	@Override
	public String getCreateName() {
		return RELATIONSHIP_IMPLICATION_FEATURE_NAME;
	}
	
	/**
	 * get method for the identifier of the icon for the create feature
	 * @return the id of the icon
	 */
	@Override
	public String getCreateImageId() {
		return IMG_ID_FEATURE_RELATIONSHIP_IMPLICATION;
	}
	
	//create feature
	//~~~~~~~~~~~~~~  
	/**
	 * uses the super types equivalent operation to create the relationship implications
	 */
	@Override
	public Connection create(ICreateConnectionContext createContext) {
		return super.createInterRelationshipConstraint(createContext, Type.RELATIONSHIP_IMPLICATION, this);
	}
}
