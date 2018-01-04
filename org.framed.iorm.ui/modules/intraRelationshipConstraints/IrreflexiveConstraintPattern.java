package intraRelationshipConstraints;

import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.framed.iorm.model.Relation;
import org.framed.iorm.model.Type;

/**
 * This graphiti pattern is used to work with {@link Relation}s
 * of the type {@link Type#IRREFLEXIVE} in the editor.
 * <p>
 * It deals with the following aspects of irreflexive intra relationship constraints:<br>
 * (1) creating irreflexive constraints, especially their business object<br>
 * (2) adding irreflexive constraints to the diagram, especially their pictogram elements<br>
 * <p>
 * It is a subclass of {@link AbstractIntraRelationshipConstraintPattern} and several operations used here are implemented there.
 * @author Kevin Kassin
 */
public class IrreflexiveConstraintPattern extends AbstractIntraRelationshipConstraintPattern {

	/**
	 * the object to get names, ids and so on for this feature
	 */
	private final Literals literals = new Literals();
	
	/**
	 * Class constructor
	 */
	public IrreflexiveConstraintPattern() {
		super();
		FEATURE_NAME = literals.IRREFLEXIVE_FEATURE_NAME;
		ICON_IMG_ID = literals.IRREFLEXIVE_ICON_IMG_ID;
	}
	
	//add feature
	//~~~~~~~~~~~
	/**
	 * calls its equivalent super class operation to calculate if an irreflexive constraint can be added
	 */
	@Override
	public boolean canAdd(IAddContext addContext) {
		return canAddIntraRelationshipConstraint(addContext, Type.IRREFLEXIVE);
	}
		
	/**
	 * calls its equivalent super class operation to add an irreflexive constraint
	 */
	@Override
	public PictogramElement add(IAddContext addContext) {
		return addIntraRelationshipConstraint(addContext, Type.IRREFLEXIVE);
	}
	
	//create feature
	//~~~~~~~~~~~~~~
	/**
	 * calls its equivalent super class operation to create an irreflexive constraint
	 */
	@Override
	public Object[] create(ICreateContext createContext) {
		return createIntraRelationshipConstraint(createContext, Type.IRREFLEXIVE, this);
	}
}
