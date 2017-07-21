package org.framed.iorm.ui.graphitifeatures;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.framed.iorm.ui.literals.NameLiterals;
import org.framed.iorm.ui.providers.ToolBehaviorProvider; //* import for javadoc link

/**
 * This graphiti custom feature is used to edit the name and the cardinalities of a relationship.
 * <p>
 * It is uses the TODO.
 * @author Kevin Kassin
 */
public class EditRelationshipFeature extends AbstractCustomFeature {

	/**
	 * the name of the feature gathered from {@link NameLiterals}
	 */
	private String EDIT_RELATIONSHIP_FEATURE_NAME = NameLiterals.EDIT_RELATIONSHIP_FEATURE_NAME;
	
	/**
	 * Class constructor
	 * @param featureProvider the feature provider the feature belongs to
	 */
	public EditRelationshipFeature(IFeatureProvider featureProvider) {
		super(featureProvider);
	}
	
	/**
	 * get method for the features name
	 * @return the name of the feature 
	 */
	@Override
	public String getName() {
		return EDIT_RELATIONSHIP_FEATURE_NAME;
	}
	
	/**
	 * This methods checks if the feature can be executed.
	 * <p>
	 * return simply true since the check if the feature can be called on the given pictogram element
	 * is done in the {@link ToolBehaviorProvider}.
	 * @return if the feature can be executed
	 */
	@Override
	public boolean canExecute(ICustomContext customContext) {
		return true;
	}

	//TODO
	@Override
	public void execute(ICustomContext context) {
		System.out.println("CALLED");
	}

}
