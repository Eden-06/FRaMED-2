package fulfillment;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.framed.iorm.model.Relation;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.FRaMEDCustomFeature;
import org.framed.iorm.ui.UIUtil;
import org.framed.iorm.ui.editPolicy.EditPolicyService;
import org.framed.iorm.ui.providers.ToolBehaviorProvider;

/**
 * This graphiti custom feature is used to reset the layout of relationships and and role types.
 * <p>
 * It is needed because the cardinalities of relationship and role type are moveable. This could lead to 
 * problem with seeing which cardinality belong to which element. To avoid that the user can easily reset the
 * places of the cardinalites with this feature.
 * @author Kevin Kassin
 */
public class ResetLayout extends FRaMEDCustomFeature {

	/**
	 * the object to get names, ids and so on for this feature
	 */
	Literals literals = new Literals();
	
	/**
	 * the graphics algorithm service used to edit graphics algorithms
	 */
	private final IGaService graphicAlgorithmService = Graphiti.getGaService();
	
	/**
	 * Class constructor
	 * @param featureProvider the feature provider the feature belongs to
	 */
	public ResetLayout(IFeatureProvider featureProvider) {
		super(featureProvider);
		FEATURE_NAME = literals.RESET_LAYOUT_FEATURE_NAME;
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
		return EditPolicyService.getHandler(this.getDiagram()).canExecute(customContext);
	}
	
	/**
	 * differs between relationships, fulfillments and role type to call operations which executes the feature 
	 * more specialized	 
	 * <p> 
	 * there hardly no checks for sizes of collections and types when casting since these checks are done
	 * {@link ToolBehaviorProvider}.
	 */
	@Override 
	public void execute(ICustomContext customContext) {	
		FreeFormConnection connection = getConnectionForContext(customContext);
		if(connection == null) return;
		connection.getBendpoints().clear();
		for(ConnectionDecorator decorator : connection.getConnectionDecorators()) {
			if(UIUtil.isShape_IdValue(decorator, literals.SHAPE_ID_FULFILLMENT_ROLES)) {
				graphicAlgorithmService.setLocation(decorator.getGraphicsAlgorithm(), literals.DISTANCE_FROM_CONNECTION_LINE, -1*literals.DISTANCE_FROM_CONNECTION_LINE);
	}	}	}
	
	/**
	 * gets the connection for custom context with either a connection or a connection decorator as pictogram element
	 * @return the connection for the custom context or null if there is no connection for the context
	 */
	private FreeFormConnection getConnectionForContext(ICustomContext customContext) {
		FreeFormConnection connection = null;
		if(customContext.getPictogramElements()[0] instanceof Connection) {
			connection = (FreeFormConnection) customContext.getPictogramElements()[0];
		}
		if(customContext.getPictogramElements()[0] instanceof ConnectionDecorator) {
			connection = (FreeFormConnection) ((ConnectionDecorator) customContext.getPictogramElements()[0]).getConnection();
		}
		return connection;
	}
}
