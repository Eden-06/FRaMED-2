package org.framed.iorm.ui.pattern.connections;

import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.framed.iorm.model.OrmFactory;
import org.framed.iorm.model.Relation;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.literals.NameLiterals;

//TODO
public class CyclicConstraintPattern extends AbstractIntraRelationshipConstraintFeature {

	/**
	 * the name of the feature gathered from {@link NameLiterals}
	 */
	private static final String CYCLIC_FEATURE_NAME = NameLiterals.CYCLIC_FEATURE_NAME;

	/**
	 * Class constructor
	 */
	public CyclicConstraintPattern() {
		super();
	}
	
	/**
	 * get method for the features name
	 * @return the name of the feature
	 */
	@Override
	public String getCreateName() {
		return CYCLIC_FEATURE_NAME;
	}
	
	//add feature
	//~~~~~~~~~~~
	@Override
	public boolean canAdd(IAddContext addContext) {
		return canAddIntraRelationshipConstraint(addContext, Type.CYCLIC);
	}
	
	
	
	//create feature
	//~~~~~~~~~~~~~~
	@Override
	public Connection create(ICreateConnectionContext createContext) {
		return createIntraRelationshipConstraint(createContext, Type.CYCLIC);
	}

}
