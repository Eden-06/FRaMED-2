package org.framed.iorm.ui.graphitifeatures;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.framed.iorm.model.Relation;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.literals.LayoutLiterals;
import org.framed.iorm.ui.literals.NameLiterals;
import org.framed.iorm.ui.providers.ToolBehaviorProvider;
import org.framed.iorm.ui.util.PropertyUtil;

/**
 * This graphiti custom feature is used to reset the layout of relationships and and role types.
 * <p>
 * It is needed because the cardinalities of relationship and role type are moveable. This could lead to 
 * problem with seeing which cardinality belong to which element. To avoid that the user can easily reset the
 * places of the cardinalites with this feature.
 * @author Kevin Kassin
 */
public class ResetLayoutForElementFeature extends AbstractCustomFeature {

	/**
	 * the features name gathered from {@link NameLiterals}
	 */
	private final String RESET_LAYOUT_FEATURE_NAME = NameLiterals.RESET_LAYOUT_FEATURE_NAME;
	
	/**
	 * the values for the property shape id needed to execute this feature
	 * gathered from {@link IdentifierLiterals}
	 */
	private final String SHAPE_ID_ROLETYPE_OCCURRENCE_CONSTRAINT = IdentifierLiterals.SHAPE_ID_ROLETYPE_OCCURRENCE_CONSTRAINT,
						 SHAPE_ID_ROLETYPE_TYPEBODY = IdentifierLiterals.SHAPE_ID_ROLETYPE_TYPEBODY,
						 SHAPE_ID_INTRA_REL_CON_NAME_DECORATOR = IdentifierLiterals.SHAPE_ID_INTRA_REL_CON_NAME_DECORATOR,
						 SHAPE_ID_FULFILLMENT_ROLES = IdentifierLiterals.SHAPE_ID_FULFILLMENT_ROLES;
	
	/**
	 * layout integers gathered from {@link LayoutLiterals}
	 */
	private final int DISTANCE_FROM_CONNECTION_LINE = LayoutLiterals.DISTANCE_FROM_CONNECTION_LINE,
					  PUFFER_BETWEEN_ELEMENTS = LayoutLiterals.PUFFER_BETWEEN_ELEMENTS,
					  HEIGHT_CONSTRAINT = LayoutLiterals.HEIGHT_CONSTRAINT;

	/**
	 * the graphics algorithm service used to edit graphics algorithms
	 */
	protected final IGaService graphicAlgorithmService = Graphiti.getGaService();
	
	/**
	 * Class constructor
	 * @param featureProvider
	 */
	public ResetLayoutForElementFeature(IFeatureProvider featureProvider) {
		super(featureProvider);
	}
	
	/**
	 * get method for the features name
	 * @return the name of the feature
	 */
	public String getName() {
		return RESET_LAYOUT_FEATURE_NAME;
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
	 * differs between relationships, fulfillments and role type to call operations which executes the feature 
	 * more specialized	 
	 * <p> 
	 * there hardly no checks for sizes of collections and types when casting since these checks are done
	 * {@link ToolBehaviorProvider}.
	 */
	@Override 
	public void execute(ICustomContext customContext) {	
		Object businessObject = getBusinessObjectForPictogramElement(customContext.getPictogramElements()[0]);
		if(businessObject instanceof Relation) {
			Relation relation = (Relation) businessObject;
			if(relation.getType() == Type.RELATIONSHIP)
				executeForRelationship(customContext);
			if(relation.getType() == Type.FULFILLMENT)
				executeForFulfillment(customContext);
		}
		if(businessObject instanceof Shape) {	
			org.framed.iorm.model.Shape shape = (org.framed.iorm.model.Shape) businessObject;
			if(shape.getType() == Type.ROLE_TYPE)
				executeForRoleType(customContext);
		}	
	}
	
	/**
	 * executes the feature for the relationships
	 */
	private void executeForRelationship(ICustomContext customContext) {
		FreeFormConnection connection = getConnectionForContext(customContext);
		if(connection == null) return;
		connection.getBendpoints().clear();
		int intraRelConsAdded = 0;
		for(ConnectionDecorator decorator : connection.getConnectionDecorators()) {
			if(PropertyUtil.isShape_IdValue(decorator, SHAPE_ID_INTRA_REL_CON_NAME_DECORATOR)) {
				graphicAlgorithmService.setLocation(decorator.getGraphicsAlgorithm(), DISTANCE_FROM_CONNECTION_LINE, intraRelConsAdded*HEIGHT_CONSTRAINT);
				intraRelConsAdded++;
			} else {
				graphicAlgorithmService.setLocation(decorator.getGraphicsAlgorithm(), DISTANCE_FROM_CONNECTION_LINE, -1*DISTANCE_FROM_CONNECTION_LINE);
	}	}	}
	
	/**
	 * executes the feature for the fulfillments
	 */
	private void executeForFulfillment(ICustomContext customContext) {
		FreeFormConnection connection = getConnectionForContext(customContext);
		if(connection == null) return;
		connection.getBendpoints().clear();
		for(ConnectionDecorator decorator : connection.getConnectionDecorators()) {
			if(PropertyUtil.isShape_IdValue(decorator, SHAPE_ID_FULFILLMENT_ROLES)) {
				graphicAlgorithmService.setLocation(decorator.getGraphicsAlgorithm(), DISTANCE_FROM_CONNECTION_LINE, -1*DISTANCE_FROM_CONNECTION_LINE);
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
	
	/**
	 * executes the feature for the role types
	 */
	private void executeForRoleType(ICustomContext customContext) {
		ContainerShape containerShape = ((Shape) customContext.getPictogramElements()[0]).getContainer();
		Shape typeBodyShape = null, occurenceConstraintShape = null;
		for(Shape shape : containerShape.getChildren()) {
			if(PropertyUtil.isShape_IdValue(shape, SHAPE_ID_ROLETYPE_TYPEBODY))
				typeBodyShape = shape;
			if(PropertyUtil.isShape_IdValue(shape, SHAPE_ID_ROLETYPE_OCCURRENCE_CONSTRAINT))
				occurenceConstraintShape = shape;
		}
		if(typeBodyShape != null && occurenceConstraintShape != null) {
			RoundedRectangle typeBodyRectangle = (RoundedRectangle) typeBodyShape.getGraphicsAlgorithm();
			System.out.println(typeBodyRectangle.getX()+typeBodyRectangle.getWidth()/2-HEIGHT_CONSTRAINT/2);
			graphicAlgorithmService.setLocation(occurenceConstraintShape.getGraphicsAlgorithm(),
				typeBodyRectangle.getX()+typeBodyRectangle.getWidth()/2-HEIGHT_CONSTRAINT/2, 
				typeBodyRectangle.getY()-HEIGHT_CONSTRAINT-PUFFER_BETWEEN_ELEMENTS);
		}
	}
}
