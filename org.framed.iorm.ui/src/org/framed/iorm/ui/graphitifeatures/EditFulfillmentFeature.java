package org.framed.iorm.ui.graphitifeatures;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.PlatformUI;
import org.framed.iorm.model.Relation;
import org.framed.iorm.model.Shape;
import org.framed.iorm.ui.literals.NameLiterals;
import org.framed.iorm.ui.providers.ToolBehaviorProvider;
import org.framed.iorm.ui.wizards.EditFulfillmentDialog;
import org.framed.iorm.ui.wizards.EditRelationshipDialog;

public class EditFulfillmentFeature extends AbstractCustomFeature {

	/**
	 * the name of the feature gathered from {@link NameLiterals}
	 */
	private final String EDIT_FULFILLMENT_FEATURE_NAME = NameLiterals.EDIT_FULFILLMENT_FEATURE_NAME;
	
	public EditFulfillmentFeature(IFeatureProvider featureProvider) {
		super(featureProvider);
	}
	
	/**
	 * get method for the features name
	 * @return the name of the feature 
	 */
	@Override
	public String getName() {
		return EDIT_FULFILLMENT_FEATURE_NAME;
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

	/**
	 * opens an TODO {@link } to take the user input for the edit of the fulfillment
	 * and propagates the edits to the pictogram and business model	 
	 * <p> 
	 * there hardly no checks for sizes of collections and types when casting since these checks are done
	 * {@link ToolBehaviorProvider}.
	 */
	@Override
	public void execute(ICustomContext context) {
		List<Shape> newReferencedRoles = new ArrayList<Shape>();
		Connection connection = null;
		if(context.getPictogramElements()[0] instanceof Connection) {
			connection = (Connection) context.getPictogramElements()[0];
		}
		if(context.getPictogramElements()[0] instanceof ConnectionDecorator) {
			connection = ((ConnectionDecorator) context.getPictogramElements()[0]).getConnection();
		}
		if(connection == null) return;
		Relation businessObject = (Relation) getBusinessObjectForPictogramElement(connection);
				
		EditFulfillmentDialog editDialog = new EditFulfillmentDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
													getDiagram(), businessObject, newReferencedRoles);
		int returnCode = editDialog.open();
		if(returnCode == Window.OK) {
			businessObject.getReferencedRoles().clear();
			for(Shape role : newReferencedRoles)
				businessObject.getReferencedRoles().add(role);
		}
	}
	
}
