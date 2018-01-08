package group;

import org.eclipse.graphiti.features.context.impl.AddContext;
import org.framed.iorm.model.Model;

/**
 * This context is used to save needed information for the create of a group.
 * <p>
 * It extends the {@link AddContext} by some variables and their get and set methods.
 * @see AddContext
 * @author Kevin Kassin
 */
public class AddGroupContext extends AddContext {

	/**
	 * the model to link to the diagram of the group
	 */
	private Model modelToLink;
	
	/**
	 * sets the class variable modelToLink
	 * @param modelToLink the model to link to the groups diagram
	 */
	public void setModelToLink(Model modelToLink) {
		this.modelToLink = modelToLink;
	}
	
	/**
	 * get method for the model to link to the groups diagram
	 * @return the class variable modelToLink
	 */
	public Model getModelToLink() {
		return modelToLink;
	}
}