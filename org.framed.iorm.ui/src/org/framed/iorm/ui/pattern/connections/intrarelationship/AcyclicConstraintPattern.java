package org.framed.iorm.ui.pattern.connections.intrarelationship;

import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.framed.iorm.model.Relation;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.literals.NameLiterals;

/**
 * This graphiti pattern is used to work with {@link Relation}s
 *	of the type {@link Type#ACYCLIC} in the editor.
 * <p>
 * It deals with the following aspects of acyclic intra relationship constraints:<br>
 * (1) creating acyclic constraints, especially their business object<br>
 * (2) adding acyclic constraints to the diagram, especially their pictogram elements<br>
 * <p>
 * It is a subclass of {@link AbstractIntraRelationshipConstraintPattern} and several operations used here are implemented there.
 * @author Kevin Kassin
 */
public class AcyclicConstraintPattern extends AbstractIntraRelationshipConstraintPattern {

	/**
	 * the name of the feature gathered from {@link NameLiterals}
	 */
	private static final String ACYCLIC_FEATURE_NAME = NameLiterals.ACYCLIC_FEATURE_NAME;
	
	/**
	 * Class constructor
	 */
	public AcyclicConstraintPattern() {
		super();
	}
	
	/**
	 * get method for the features name
	 * @return the name of the feature
	 */
	@Override
	public String getCreateName() {
		return ACYCLIC_FEATURE_NAME;
	}
	
	//add feature
	//~~~~~~~~~~~
	/**
	 * calls its equivalent super class operation to calculate if an acyclic constraint can be added
	 */
	@Override
	public boolean canAdd(IAddContext addContext) {
		return canAddIntraRelationshipConstraint(addContext, Type.ACYCLIC);
	}
	
	/**
	 * calls its equivalent super class operation to add an acyclic constraint
	 */
	@Override
	public PictogramElement add(IAddContext addContext) {
		return addIntraRelationshipConstraint(addContext, Type.ACYCLIC);
	}
	
	//create feature
	//~~~~~~~~~~~~~~
	/**
	 * calls its equivalent super class operation to create an acyclic constraint
	 */
	@Override
	public Object[] create(ICreateContext createContext) {
		return createIntraRelationshipConstraint(createContext, Type.ACYCLIC, this);
	}
}
