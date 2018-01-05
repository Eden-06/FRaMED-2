package relationship;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.PlatformUI;
import org.framed.iorm.model.Relation;
import org.framed.iorm.ui.graphitifeatures.FRaMEDCustomFeature;
import org.framed.iorm.ui.providers.ToolBehaviorProvider; //* import for javadoc link
import org.framed.iorm.ui.util.UIUtil;

/**
 * This graphiti custom feature is used to edit the name and the cardinalities of a relationship.
 * <p>
 * It is uses the {@link EditRelationshipDialog}.
 * @author Kevin Kassin
 */
public class EditRelationshipFeature extends FRaMEDCustomFeature {
	
	/**
	 * the object to get names, ids and so on for this feature
	 */
	Literals literals = new Literals();
	
	/**
	 * Class constructor
	 * @param featureProvider the feature provider the feature belongs to
	 */
	public EditRelationshipFeature(IFeatureProvider featureProvider) {
		super(featureProvider);
		FEATURE_NAME = literals.EDIT_RELATIONSHIP_FEATURE_NAME;
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
	 * opens an {@link EditRelationshipDialog} to take the user input for the edit of the relationship
	 * and propagates the edits to the pictogram and business model	 
	 * <p> 
	 * there hardly no checks for sizes of collections and types when casting since these checks are done
	 * {@link ToolBehaviorProvider}.
	 */
	@Override
	public void execute(ICustomContext context) {	
		List<String> relationshipValues = new ArrayList<String>();
		Connection connection = null;
		if(context.getPictogramElements()[0] instanceof Connection) {
			connection = (Connection) context.getPictogramElements()[0];
		}
		if(context.getPictogramElements()[0] instanceof ConnectionDecorator) {
			connection = ((ConnectionDecorator) context.getPictogramElements()[0]).getConnection();
		}
		if(connection == null) return;
		Relation businessObject = (Relation) getBusinessObjectForPictogramElement(connection);
				
		EditRelationshipDialog editDialog = new EditRelationshipDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
													getDiagram(), businessObject, relationshipValues);
		int returnCode = editDialog.open();
		if(returnCode == Window.OK) {
			for(ConnectionDecorator decorator : connection.getConnectionDecorators()) {
				if(decorator.getGraphicsAlgorithm() instanceof Text) {
					Text text = (Text) decorator.getGraphicsAlgorithm();
					if(UIUtil.isShape_IdValue(decorator, literals.SHAPE_ID_RELATIONSHIP_NAME_DECORATOR)) {
						text.setValue(relationshipValues.get(0));
						businessObject.setName(relationshipValues.get(0));
					}
					if(UIUtil.isShape_IdValue(decorator, literals.SHAPE_ID_RELATIONSHIP_SOURCE_CARDINALITY_DECORATOR)) {
						text.setValue(relationshipValues.get(1));
						businessObject.getSourceLabel().setName(relationshipValues.get(1));
					}
					if(UIUtil.isShape_IdValue(decorator, literals.SHAPE_ID_RELATIONSHIP_TARGET_CARDINALITY_DECORATOR)) {
						text.setValue(relationshipValues.get(2));
						businessObject.getTargetLabel().setName(relationshipValues.get(2));
	}	}	}	}	}
}
