package relationship.intra_relationship_constraints;

import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.framed.iorm.model.Relation;
import org.framed.iorm.model.Type;

/**
 * This graphiti pattern is used to work with {@link Relation}s
 * of the type {@link Type#TOTAL} in the editor.
 * <p>
 * It deals with the following aspects of total intra relationship constraints:<br>
 * (1) creating total constraints, especially their business object<br>
 * (2) adding total constraints to the diagram, especially their pictogram elements<br>
 * <p>
 * It is a subclass of {@link AbstractIntraRelationshipConstraintPattern} and several operations used here are implemented there.
 * @author Kevin Kassin
 */
public class TotalConstraintPattern extends AbstractIntraRelationshipConstraintPattern {

	/**
	 * the object to get names, ids and so on for this feature
	 */
	private final Literals literals = new Literals();
	
	/**
	 * Class constructor
	 */
	public TotalConstraintPattern() {
		super();
		FEATURE_NAME = literals.TOTAL_FEATURE_NAME;
		ICON_IMG_ID = literals.TOTAL_ICON_IMG_ID;
		modelType = Type.TOTAL;
	}
	
	//add feature
	//~~~~~~~~~~~
	/**
	 * calls its equivalent super class operation to calculate if a total constraint can be added
	 */
	@Override
	public boolean canAdd(IAddContext addContext) {
		return canAddIntraRelationshipConstraint(addContext, Type.TOTAL);
		}
	
	/**
	 * calls its equivalent super class operation to add a total constraint
	 */
	@Override
	public PictogramElement add(IAddContext addContext) {
		return addIntraRelationshipConstraint(addContext, Type.TOTAL);
	}
	
	//create feature
	//~~~~~~~~~~~~~~
	/**
	 * calls its equivalent super class operation to create a total constraint
	 */
	@Override
	public Object[] create(ICreateContext createContext) {
		return createIntraRelationshipConstraint(createContext, Type.TOTAL, this);
	}
}
