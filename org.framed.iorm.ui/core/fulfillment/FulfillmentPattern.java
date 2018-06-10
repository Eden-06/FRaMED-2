package fulfillment;

import java.util.Arrays;
import java.util.List;

import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.CustomContext;
import org.eclipse.graphiti.features.context.impl.ReconnectionContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.algorithms.Polygon;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.framed.iorm.model.OrmFactory;
import org.framed.iorm.model.Relation;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.FRaMEDConnectionPattern;
import org.framed.iorm.ui.UIUtil;
import org.framed.iorm.ui.editPolicy.EditPolicyService;
import org.framed.iorm.ui.palette.FeaturePaletteDescriptor;
import org.framed.iorm.ui.palette.PaletteCategory;
import org.framed.iorm.ui.palette.ViewVisibility;

/**
 * This graphiti pattern is used to work with {@link Relation}s of the type
 * {@link Type#FULFILLMENT} in the editor.
 * <p>
 * It deals with the following aspects of fulfillments:<br>
 * (1) creating fulfillments, especially their business object<br>
 * (2) adding fulfillments to the diagram, especially their pictogram
 * elements<br>
 * 
 * @author Kevin Kassin
 */
public class FulfillmentPattern extends FRaMEDConnectionPattern {

	/**
	 * the object to get names, ids and so on for this feature
	 */
	Literals literals = new Literals();
	
	/**
	 * the feature palette descriptor manages the palette visibility, see {@link FeaturePaletteDescriptor}
	 */
	private final FeaturePaletteDescriptor spec_FPD = new FeaturePaletteDescriptor(
			PaletteCategory.RELATIONS_CATEGORY,
			ViewVisibility.ALL_VIEWS);
	
	/**
	 * class constructor		
	 */
	public FulfillmentPattern() {
		super();
		FEATURE_NAME = literals.FEATURE_NAME;
		ICON_IMG_ID = literals.ICON_IMG_ID;
		ICON_IMG_PATH = literals.ICON_IMG_PATH;
		modelType = Type.FULFILLMENT;
		FPD = spec_FPD;
	}
	
	/**
	 * returns the double click feature of this pattern 
	 */
	@Override
	public IFeature getDoubleClickFeature(ICustomFeature[] customFeatures) {
		return (ICustomFeature) UIUtil.findFeatureByName(customFeatures, literals.EDIT_FULFILLMENT_FEATURE_NAME);
	}
	
	/**
	 * checks if connection can be reconnected
	 * <p>
	 * @return true if the new source or target shape has the right type
	 */
	@Override
	public boolean canReconnect(IReconnectionContext context) {
		Anchor newAnchor = context.getNewAnchor();
		org.framed.iorm.model.ModelElement newShape = UIUtil.getModelElementForAnchor(newAnchor);
		if(newShape != null) {	
			return EditPolicyService.getHandler(this.getDiagram()).canReconnect(context, newShape.getType());
		}
		return false;
	}

	/**
	 * executes needed action after a reconnect was successful
	 * <p>
	 * If the target of a fulfillment was changed the wizard to choose the fulfilled roles has to be opened
	 */
	@Override
	public void postReconnect(IReconnectionContext context) {
		if(context.getReconnectType() == ReconnectionContext.RECONNECT_TARGET) {
			Connection connection = context.getConnection();
			CustomContext customContext = new CustomContext();
			PictogramElement[] pictogramElement = new PictogramElement[1];
			pictogramElement[0] = connection;
			customContext.setPictogramElements(pictogramElement);
			ICustomFeature[] customFeatures = getFeatureProvider().getCustomFeatures(customContext);
			EditFulfillmentFeature editFulfillmentFeature = (EditFulfillmentFeature) UIUtil
					.findFeatureByName(customFeatures, literals.EDIT_FULFILLMENT_FEATURE_NAME);
			if (editFulfillmentFeature.canExecute(customContext))
				editFulfillmentFeature.execute(customContext);
	}	}
	
	/**
	 * calculates if a fulfillment can be added to the pictogram diagram
	 * <p>
	 * returns true if the business object is a fulfillment
	 * 
	 * @return if a fulfillment can be added
	 */
	@Override
	public boolean canAdd(IAddContext addContext) {
		if (addContext.getNewObject() instanceof Relation) {
			Relation relation = (Relation) addContext.getNewObject();
		    return EditPolicyService.getHandler(this.getDiagram()).canAdd(addContext, relation.getType());
		}
		return false;
	}

	/**
	 * adds the fulfillment to the pictogram diagram using the following steps:
	 * <p>
	 * Step 1: create a connection shape and polyline as its graphic algorithm<br>
	 * Step 2: create the a connection decorator and a arrowhead as its graphic
	 * algorithm<br>
	 * Step 3: create the connection decorator for the fulfilled roles<br>
	 * Step 4: link the pictogram elements and the business objects<br>
	 * Step 5: opens the wizard to edit the fulfillments referenced roles
	 */
	@Override
	public PictogramElement add(IAddContext addContext) {
		IAddConnectionContext addConnectionContext = (IAddConnectionContext) addContext;
		Relation addedFulfillment = (Relation) addContext.getNewObject();
		Anchor sourceAnchor = addConnectionContext.getSourceAnchor();
		Anchor targetAnchor = addConnectionContext.getTargetAnchor();
		// Step 1
		Connection connection = pictogramElementCreateService.createFreeFormConnection(getDiagram());
		connection.setStart(sourceAnchor);
		connection.setEnd(targetAnchor);
		Polyline polyline = graphicAlgorithmService.createPolyline(connection);
		polyline.setForeground(manageColor(literals.COLOR_CONNECTIONS));
		polyline.setLineWidth(2);
		// Step2
		ConnectionDecorator arrowheadShape = pictogramElementCreateService.createConnectionDecorator(connection, false,
				1.0, true);
		int points[] = new int[] { -1 * literals.FULFILLMENT_ARROWHEAD_LENGTH, literals.FULFILLMENT_ARROWHEAD_HEIGHT, // Point 1
				0, 0, // P2
				-1 * literals.FULFILLMENT_ARROWHEAD_LENGTH, -1 * literals.FULFILLMENT_ARROWHEAD_HEIGHT }; // P3
		Polygon arrowhead = graphicAlgorithmService.createPolygon(arrowheadShape, points);
		arrowhead.setForeground(manageColor(literals.COLOR_CONNECTIONS));
		arrowhead.setBackground(manageColor(literals.COLOR_CONNECTIONS));
		UIUtil.setShape_IdValue(arrowheadShape, literals.SHAPE_ID_FULFILLMENT_ARROWHEAD);
		// Step 3
		ConnectionDecorator rolesShape = pictogramElementCreateService.createConnectionDecorator(connection, true, 0.8,
				true);
		Text roles = graphicAlgorithmService.createText(rolesShape, "");
		graphicAlgorithmService.setLocation(roles, literals.DISTANCE_FROM_CONNECTION_LINE, -1 * literals.DISTANCE_FROM_CONNECTION_LINE);
		roles.setForeground(manageColor(literals.COLOR_TEXT));
		UIUtil.setShape_IdValue(rolesShape, literals.SHAPE_ID_FULFILLMENT_ROLES);
		// Step 4
		link(connection, addedFulfillment);
		link(arrowheadShape, addedFulfillment);
		link(rolesShape, addedFulfillment);
		// Step 5
		CustomContext customContext = new CustomContext();
		PictogramElement[] pictogramElement = new PictogramElement[1];
		pictogramElement[0] = connection;
		customContext.setPictogramElements(pictogramElement);
		ICustomFeature[] customFeatures = getFeatureProvider().getCustomFeatures(customContext);
		EditFulfillmentFeature editFulfillmentFeature = (EditFulfillmentFeature) UIUtil.findFeatureByName(customFeatures, literals.EDIT_FULFILLMENT_FEATURE_NAME);
		if (editFulfillmentFeature.canExecute(customContext))
			editFulfillmentFeature.execute(customContext);
		return connection;
	}

	/**
	 * calculates if a fulfillment can be created
	 * <p>
	 * returns true if<br>
	 * (1) target and source shape are not null and<br>
	 * (2) target and source shape are of valid types and<br>
	 * (3) source shapes container and targets shapes container are the same and<br>
	 * 
	 * @return if fulfillment can be added
	 */
	@Override
	public boolean canCreate(ICreateConnectionContext createContext) {
		Anchor sourceAnchor = createContext.getSourceAnchor();
		Anchor targetAnchor = createContext.getTargetAnchor();
		org.framed.iorm.model.ModelElement sourceShape = UIUtil.getModelElementForAnchor(sourceAnchor);
		org.framed.iorm.model.ModelElement targetShape = UIUtil.getModelElementForAnchor(targetAnchor);
		if (sourceShape != null && targetShape != null) {
			if (sourceShape.getContainer() == targetShape.getContainer()) {
				return EditPolicyService.getHandler(this.getDiagram()).canCreate(createContext, this.modelType);
			}
		}
		return false;
	}

	/**
	 * checks if a fulfillment can be started from a given source shape
	 * <p>
	 * returns true if<br>
	 * (1) source shape is not null and<br>
	 * (2) source shape is of valid type
	 * 
	 * @return if fulfillment can be started
	 */
	@Override
	public boolean canStartConnection(ICreateConnectionContext createContext) {
		Anchor sourceAnchor = createContext.getSourceAnchor();
		org.framed.iorm.model.ModelElement sourceShape = UIUtil.getModelElementForAnchor(sourceAnchor);
		if (sourceShape != null) {
			return EditPolicyService.getHandler(this.getDiagram()).canStart(createContext, Type.FULFILLMENT);
		}
		return false;
	}

	/**
	 * creates the business object of a fulfillment using the following steps:
	 * <p>
	 * Step 1: get source and target shapes<br>
	 * Step 2: get new fulfillments and add it to the resource of the diagram<br>
	 * Step 3: set source, target and container of the fulfillment<br>
	 * Step 4: call add operation of this pattern
	 */
	@Override
	public Connection create(ICreateConnectionContext createContext) {
		// Step 1
		Anchor sourceAnchor = createContext.getSourceAnchor();
		Anchor targetAnchor = createContext.getTargetAnchor();
		org.framed.iorm.model.ModelElement sourceShape = UIUtil.getModelElementForAnchor(sourceAnchor);
		org.framed.iorm.model.ModelElement targetShape = UIUtil.getModelElementForAnchor(targetAnchor);
		// Step 2
		Relation newFulfillment = OrmFactory.eINSTANCE.createRelation();
		newFulfillment.setType(Type.FULFILLMENT);
		if (newFulfillment.eResource() != null)
			getDiagram().eResource().getContents().add(newFulfillment);
		// Step 3
		newFulfillment.setContainer(sourceShape.getContainer());
		sourceShape.getContainer().getElements().add(newFulfillment);
		newFulfillment.setSource(sourceShape);
		newFulfillment.setTarget(targetShape);
		// Step 4
		AddConnectionContext addContext = new AddConnectionContext(sourceAnchor, targetAnchor);
		addContext.setNewObject(newFulfillment);
		Connection newConnection = null;
		if (canAdd(addContext))
			newConnection = (Connection) add(addContext);
		return newConnection;
	}
}
