package fulfillment;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.PlatformUI;
import org.framed.iorm.model.Relation;
import org.framed.iorm.model.Shape;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.FRaMEDCustomFeature;
import org.framed.iorm.ui.providers.ToolBehaviorProvider;
import org.framed.iorm.ui.util.UIUtil;

/**
 * This graphiti custom feature is used to edit the referenced role types of fulfillments.
 * <p>
 * It is uses the {@link EditFulfillmentDialog}.
 * @author Kevin Kassin
 */
public class EditFulfillmentFeature extends FRaMEDCustomFeature {

	/**
	 * the object to get names, ids and so on for this feature
	 */
	Literals literals = new Literals();
	
	/**
	 * Class constructor
	 * @param featureProvider the feature provider the feature belongs to
	 */
	public EditFulfillmentFeature(IFeatureProvider featureProvider) {
		super(featureProvider);
		FEATURE_NAME = literals.EDIT_FULFILLMENT_FEATURE_NAME;
	}
	
	/**
	 * this operation encapsulates when the custom feature should be visible in the context menu
	 * @return 
	 */
	public boolean contextMenuExpression(PictogramElement pictogramElement, EObject businessObject) {
		if(pictogramElement instanceof FreeFormConnection ||
		   pictogramElement instanceof ConnectionDecorator) {
			if(businessObject instanceof Relation) {
				Relation relation = (Relation) businessObject;
				if(relation.getType() == Type.FULFILLMENT)
					return true;
		}	}
		return false;
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
	 * opens an {@link EditFulfillmentDialog} to take the user input for the edit of the fulfillment
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
			for(ConnectionDecorator decorator : connection.getConnectionDecorators()) {
				if(UIUtil.isShape_IdValue(decorator, literals.SHAPE_ID_FULFILLMENT_ROLES))
					setDecoratorTextForFulfilledRoles((Text) decorator.getGraphicsAlgorithm(), newReferencedRoles);
	}	}	}
	
	/**
	 * builds and sets the string of the referenced roles label of the fulfillment connection
	 * @param decoratorText the referenced roles label
	 * @param newReferencedRoles the newly chosen role types to reference
	 */
	private void setDecoratorTextForFulfilledRoles(Text decoratorText, List<Shape> newReferencedRoles) {
		String newLabelText = "";
		for(int i=0; i<newReferencedRoles.size(); i++) {
			if(i == 0) newLabelText = newLabelText + newReferencedRoles.get(i).getName();
			else newLabelText = newLabelText + ", " + newReferencedRoles.get(i).getName();
		}	
		decoratorText.setValue(newLabelText);		
	}
}
