package org.framed.iorm.ui.contexts;

import org.eclipse.graphiti.features.context.impl.AddContext;
import org.framed.iorm.model.Model;
import org.framed.iorm.ui.pattern.shapes.CompartmentTypePattern; //*import for javadoc link

import group.GroupPattern;

/**
 * This context is used to save needed information for the create of the groups and compartment
 * types.
 * <p>
 * It extends the {@link AddContext} by some variables and their get and set methods.
 * @see GroupPattern
 * @see CompartmentTypePattern
 * @see AddContext
 * @author Kevin Kassin
 */
public class AddGroupOrCompartmentTypeContext extends AddContext {

	/**
	 * the model to link to the diagram of the group or compartment type
	 */
	private Model modelToLink;
	
	/**
	 * sets the class variable modelToLink
	 * @param modelToLink the model to link to the groups or compartment types diagram
	 */
	public void setModelToLink(Model modelToLink) {
		this.modelToLink = modelToLink;
	}
	
	/**
	 * get method for the model to link to the groups or compartment types diagram
	 * @return the class variable modelToLink
	 */
	public Model getModelToLink() {
		return modelToLink;
	}
}