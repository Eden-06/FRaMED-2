package intraRelationshipConstraints;

import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.framed.iorm.model.Relation;
import org.framed.iorm.model.Type;

/**
 * This graphiti pattern is used to work with {@link Relation}s
 * of the type {@link Type#REFLEXIVE} in the editor.
 * <p>
 * It deals with the following aspects of irreflexive intra relationship constraints:<br>
 * (1) creating reflexive constraints, especially their business object<br>
 * (2) adding reflexive constraints to the diagram, especially their pictogram elements<br>
 * <p>
 * It is a subclass of {@link AbstractIntraRelationshipConstraintPattern} and several operations used here are implemented there.
 * @author Kevin Kassin
 */
public class ReflexiveConstraintPattern extends AbstractIntraRelationshipConstraintPattern {

	/**
	 * the object to get names, ids and so on for this feature
	 */
	private final Literals literals = new Literals();
	
	/**
	 * Class constructor
	 */
	public ReflexiveConstraintPattern() {
		super();
		FEATURE_NAME = literals.REFLEXIVE_FEATURE_NAME;
		ICON_IMG_ID = literals.REFLEXIVE_ICON_IMG_ID;
		modelType = Type.REFLEXIVE;
	}
	
	//add feature
	//~~~~~~~~~~~
	/**
	 * calls its equivalent super class operation to calculate if a reflexive constraint can be added
	 */
	@Override
	public boolean canAdd(IAddContext addContext) {
		return canAddIntraRelationshipConstraint(addContext, Type.REFLEXIVE);
	}
		
	/**
	 * calls its equivalent super class operation to add a reflexive constraint
	 */
	@Override
	public PictogramElement add(IAddContext addContext) {
		return addIntraRelationshipConstraint(addContext, Type.REFLEXIVE);
	}
	
	//create feature
	//~~~~~~~~~~~~~~
	/**
	 * calls its equivalent super class operation to create a reflexive constraint
	 */
	@Override
	public Object[] create(ICreateContext createContext) {
		return createIntraRelationshipConstraint(createContext, Type.REFLEXIVE, this);
	}
}
