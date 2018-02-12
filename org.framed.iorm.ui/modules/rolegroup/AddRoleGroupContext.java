package rolegroup;

import org.eclipse.graphiti.features.context.impl.AddContext;
import org.framed.iorm.model.Model;

/**
 * This context is used to save needed information for the creation of a role group.
 * <p>
 * It extends the {@link AddContext} by some variables and their get and set methods.
 * @see AddContext
 * @author Kevin Kassin
 */
public class AddRoleGroupContext extends AddContext {

	/**
	 * the model to link to the diagram of the compartment type
	 */
	private Model modelToLink;
	
	/**
	 * sets the class variable modelToLink
	 * @param modelToLink the model to link to the compartment types diagram
	 */
	public void setModelToLink(Model modelToLink) {
		this.modelToLink = modelToLink;
	}
	
	/**
	 * get method for the model to link to the compartment types diagram
	 * @return the class variable modelToLink
	 */
	public Model getModelToLink() {
		return modelToLink;
	}
}