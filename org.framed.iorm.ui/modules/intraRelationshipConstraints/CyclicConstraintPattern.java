package intraRelationshipConstraints;

import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.framed.iorm.model.Relation;
import org.framed.iorm.model.Type;

/**
 * This graphiti pattern is used to work with {@link Relation}s
 *	of the type {@link Type#CYCLIC} in the editor.
 * <p>
 * It deals with the following aspects of cyclic intra relationship constraints:<br>
 * (1) creating cyclic constraints, especially their business object<br>
 * (2) adding cyclic constraints to the diagram, especially their pictogram elements<br>
 * <p>
 * It is a subclass of {@link AbstractIntraRelationshipConstraintPattern} and several operations used here are implemented there.
 * @author Kevin Kassin
 */
public class CyclicConstraintPattern extends AbstractIntraRelationshipConstraintPattern {

	/**
	 * the object to get names, ids and so on for this feature
	 */
	private final Literals literals = new Literals();
	
	/**
	 * Class constructor
	 */
	public CyclicConstraintPattern() {
		super();
		FEATURE_NAME = literals.CYCLIC_FEATURE_NAME;
		ICON_IMG_ID = literals.CYCLIC_ICON_IMG_ID;
	}
	
	//add feature
	//~~~~~~~~~~~
	/**
	 * calls its equivalent super class operation to calculate if a cyclic constraint can be added
	 */
	@Override
	public boolean canAdd(IAddContext addContext) {
		return canAddIntraRelationshipConstraint(addContext, Type.CYCLIC);
	}
		
	/**
	 * calls its equivalent super class operation to add a cyclic constraint
	 */
	@Override
	public PictogramElement add(IAddContext addContext) {
		return addIntraRelationshipConstraint(addContext, Type.CYCLIC);
	}
	
	//create feature
	//~~~~~~~~~~~~~~
	/**
	 * calls its equivalent super class operation to create a cyclic constraint
	 */
	@Override
	public Object[] create(ICreateContext createContext) {
		return createIntraRelationshipConstraint(createContext, Type.CYCLIC, this);
	}
}
