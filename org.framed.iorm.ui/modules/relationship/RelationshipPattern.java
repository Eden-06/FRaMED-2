package relationship;

import java.util.List;

import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.CustomContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.framed.iorm.model.NamedElement;
import org.framed.iorm.model.OrmFactory;
import org.framed.iorm.model.Relation;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.editPolicy.EditPolicyService;
import org.framed.iorm.ui.palette.FeaturePaletteDescriptor;
import org.framed.iorm.ui.palette.PaletteCategory;
import org.framed.iorm.ui.palette.PaletteView;
import org.framed.iorm.ui.palette.ViewVisibility;
import org.framed.iorm.ui.pattern.connections.FRaMEDConnectionPattern;
import org.framed.iorm.ui.util.UIUtil;

import relationship.references.TypeReferences;

/**
 * This graphiti pattern is used to work with {@link Relation}s
 * of the type {@link Type#RELATIONSHIP} in the editor.
 * <p>
 * It deals with the following aspects of Relationships:<br>
 * (1) creating relationships, especially their business object<br>
 * (2) adding relationships to the diagram, especially their pictogram elements<br>
 * @author Kevin Kassin
 */
public class RelationshipPattern extends FRaMEDConnectionPattern {
	
	/**
	 * the object to get names, ids and so on for this feature
	 */
	Literals literals = new Literals();
	
	/**
	 * the object to call utility operations on
	 */
	private final Util util = new Util();
	
	/**
	 * the reference for which model types a inheritance is applicable
	 */
	private final TypeReferences typeReferences = new TypeReferences();
	
	/**
	 * the feature palette descriptor manages the palette visibility, see {@link FeaturePaletteDescriptor}
	 */
	private final FeaturePaletteDescriptor spec_FPD = new FeaturePaletteDescriptor(
			PaletteCategory.RELATIONS_CATEGORY,
			ViewVisibility.COMPARTMENT_VIEW) {
				@Override
				public boolean featureExpression(List<String> framedFeatureNames, PaletteView paletteView) {
					return framedFeatureNames.contains("Relationships");
			}	};
	
	/**
	 * class constructor		
	 */
	public RelationshipPattern() {
		super();
		FEATURE_NAME = literals.FEATURE_NAME;
		ICON_IMG_ID = literals.ICON_IMG_ID;
		ICON_IMG_PATH = literals.ICON_IMG_PATH;
		FPD = spec_FPD;
	}
	
	//add feature
	//~~~~~~~~~~~
	/**
	 * calculates if a relationship can be added to the pictogram diagram
	 * <p>
	 * returns true if the business object is a relationship
	 * @return if a relationship can be added
	 */
	@Override
	public boolean canAdd(IAddContext addContext) {
		if(addContext.getNewObject() instanceof Relation) {
		   Relation relation = (Relation) addContext.getNewObject();
		   if(relation.getType() == Type.RELATIONSHIP) {
			   return true && EditPolicyService.canAdd(addContext, this.getDiagram());
		}	}
		return false;
	}
		
	/**
	 * adds the relationship to the pictogram diagram using the following steps:
	 * <p>
	 * Step 1: creates the connection shape and polyline as its graphic algorithm<br>
	 * Step 2: creates a connection decorator for the relationships name<br>
	 * Step 3: creates the connection decorators for the cardinalities<br>
	 * Step 4: creates a connection decorator for the anchor for inter relationship constraints
	 * 		   in the visual model
	 * Step 5: link the pictogram elements and the business objects<br>
	 * Step 6: set the values for the property shape id of all connection decorators
	 * Step 7: adds the anchor for inter relationship constraints in the business model
	 * Step 8: opens the wizard to edit the relationships name and cardinalities
	 * <p>
	 * Relationships have two different anchors attached to them. One for the inter relationship
	 * constraint to hook in the pictogram model. This anchor is used in the operation {@link #add}.
	 * The other is hooked in by inter relationship constraints in business model and is used in the 
	 * operation {@link #create}.
	 */
	@Override
	public PictogramElement add(IAddContext addContext) {
		IAddConnectionContext addConnectionContext = (IAddConnectionContext) addContext;
	    Relation addedRelationship = (Relation) addContext.getNewObject();
	    Anchor sourceAnchor = addConnectionContext.getSourceAnchor();
	    Anchor targetAnchor = addConnectionContext.getTargetAnchor();
	    //Step 1
	    Connection connection = pictogramElementCreateService.createFreeFormConnection(getDiagram());
	    connection.setStart(sourceAnchor);
	    connection.setEnd(targetAnchor);
	    Polyline polyline = graphicAlgorithmService.createPolyline(connection);
	    polyline.setForeground(manageColor(literals.COLOR_CONNECTIONS));
	    polyline.setLineWidth(2);
	    //Step 2
	    ConnectionDecorator connectionDecoratorForName = 
	    	pictogramElementCreateService.createConnectionDecorator(connection, true, 0.5, true);   
	    Text nameText = graphicAlgorithmService.createText(connectionDecoratorForName, addedRelationship.getName());
	    graphicAlgorithmService.setLocation(nameText, literals.DISTANCE_FROM_CONNECTION_LINE, -1*literals.DISTANCE_FROM_CONNECTION_LINE);
	    nameText.setForeground(manageColor(literals.COLOR_TEXT)); 
	    //Step 3
	    ConnectionDecorator connectionDecoratorForSourceLabel = 
	    	pictogramElementCreateService.createConnectionDecorator(connection, true, 0.1, true);
	    Text sourceLabel = graphicAlgorithmService.createText(connectionDecoratorForSourceLabel, addedRelationship.getSourceLabel().getName());
	    graphicAlgorithmService.setLocation(sourceLabel, literals.DISTANCE_FROM_CONNECTION_LINE, -1*literals.DISTANCE_FROM_CONNECTION_LINE);
	    sourceLabel.setForeground(manageColor(literals.COLOR_TEXT));
	    ConnectionDecorator connectionDecoratorForTargetLabel = 
	    	pictogramElementCreateService.createConnectionDecorator(connection, true, 0.9, true);
	    Text targetLabel = graphicAlgorithmService.createText(connectionDecoratorForTargetLabel, addedRelationship.getTargetLabel().getName());
	    graphicAlgorithmService.setLocation(targetLabel, literals.DISTANCE_FROM_CONNECTION_LINE, -1*literals.DISTANCE_FROM_CONNECTION_LINE);
	    targetLabel.setForeground(manageColor(literals.COLOR_TEXT));
	    //Step 4
	    ConnectionDecorator connectionDecoratorForAnchor = 
	    	pictogramElementCreateService.createConnectionDecorator(connection, true, 0.5, true);
	    Rectangle rectangle = graphicAlgorithmService.createRectangle(connectionDecoratorForAnchor);
	    graphicAlgorithmService.setSize(rectangle, 1, 1);
	    pictogramElementCreateService.createChopboxAnchor(connectionDecoratorForAnchor);
	    //Step 5
		link(connection, addedRelationship);
		link(connectionDecoratorForName, addedRelationship);
		link(connectionDecoratorForSourceLabel, addedRelationship);
		link(connectionDecoratorForTargetLabel, addedRelationship);
		link(connectionDecoratorForAnchor, addedRelationship);
		//Step 6
		UIUtil.setShape_IdValue(connectionDecoratorForName, literals.SHAPE_ID_RELATIONSHIP_NAME_DECORATOR);
		UIUtil.setShape_IdValue(connectionDecoratorForSourceLabel, literals.SHAPE_ID_RELATIONSHIP_SOURCE_CARDINALITY_DECORATOR);
		UIUtil.setShape_IdValue(connectionDecoratorForTargetLabel, literals.SHAPE_ID_RELATIONSHIP_TARGET_CARDINALITY_DECORATOR);
		UIUtil.setShape_IdValue(connectionDecoratorForAnchor, literals.SHAPE_ID_RELATIONSHIP_ANCHOR_DECORATOR);
		//Step 7
		pictogramElementCreateService.createChopboxAnchor(connection);
		//Step 8
		CustomContext customContext = new CustomContext();
		PictogramElement[] pictogramElement = new PictogramElement[1];
		pictogramElement[0] = connection;
		customContext.setPictogramElements(pictogramElement);
		ICustomFeature[] customFeatures = getFeatureProvider().getCustomFeatures(customContext);
		EditRelationshipFeature editRelationshipFeature = 
				(EditRelationshipFeature) UIUtil.findFeatureByName(customFeatures, literals.EDIT_RELATIONSHIP_FEATURE_NAME);
		if(editRelationshipFeature.canExecute(customContext))
			editRelationshipFeature.execute(customContext);
		return connection;
	}
		
	//create feature
	//~~~~~~~~~~~~~~
	/**
	 * calculates if a relationship can be created
	 * <p>
	 * returns true if<br>
	 * (1) target and source shape are not null and<br>
	 * (2) target and source shape is of valid type and<br>
	 * (3) source shapes container and targets shapes container are the same and<br>
	 * (4) target and source shape are of the same type
	 * @return if relationship can be added
	 */
	@Override
	public boolean canCreate(ICreateConnectionContext createContext) {
		Anchor sourceAnchor = createContext.getSourceAnchor();
	    Anchor targetAnchor = createContext.getTargetAnchor();
	    org.framed.iorm.model.ModelElement sourceShape = UIUtil.getModelElementForAnchor(sourceAnchor);
	    org.framed.iorm.model.ModelElement targetShape = UIUtil.getModelElementForAnchor(targetAnchor);
	    if(sourceShape != null && targetShape != null) {
	    	if(sourceShape.getContainer() == targetShape.getContainer()) {
	    		if(typeReferences.getTypes().contains(sourceShape.getType()))
		    		if(targetShape.getType() == sourceShape.getType())
						   return true && EditPolicyService.canCreate(createContext, this.getDiagram());
		}	}
		return false;
	}
		 
	/**
	 * checks if a relationship can be started from a given source shape
	 * <p>
	 * returns true if<br>
	 * (1) source shape is not null and<br>
	 * (2) source shape is of valid type 
	 * @return if relationship can be started
	 */
	@Override
	public boolean canStartConnection(ICreateConnectionContext createContext) {
		Anchor sourceAnchor = createContext.getSourceAnchor();
		org.framed.iorm.model.ModelElement sourceShape = UIUtil.getModelElementForAnchor(sourceAnchor);
		if(sourceShape != null){	
			if(typeReferences.getTypes().contains(sourceShape.getType()))
				return true;
		}	
		return false;
	}
		  
	/**
	 * creates the business object of a relationship using the following steps:
	 * <p>
	 * Step 1: get source and target shapes<br>
	 * Step 2: get new relationship and add it to the resource of the diagram<br>
	 * Step 3: set source, target and container of inheritance<br>
	 * Step 4: sets the cardinalities of the relationship to the standard value <b>*</b><br>
	 * Step 5: call add operation of this pattern
	 */
	@Override
	public Connection create(ICreateConnectionContext createContext) {
		//Step 1
		Anchor sourceAnchor = createContext.getSourceAnchor();
	    Anchor targetAnchor = createContext.getTargetAnchor();
	    org.framed.iorm.model.ModelElement sourceShape = UIUtil.getModelElementForAnchor(sourceAnchor);
	    org.framed.iorm.model.ModelElement targetShape = UIUtil.getModelElementForAnchor(targetAnchor);
		
		//Step 2
		Relation newRelationship = OrmFactory.eINSTANCE.createRelation();
		String standardName = util.calculateStandardNameForCompartmentsTypeElement(getDiagram());
		newRelationship.setName(standardName);
		newRelationship.setType(Type.RELATIONSHIP); 
	    if(newRelationship.eResource() != null) getDiagram().eResource().getContents().add(newRelationship);
	    //Step 3
	    newRelationship.setContainer(sourceShape.getContainer());
	    sourceShape.getContainer().getElements().add(newRelationship);
	    newRelationship.setSource(sourceShape);
	    newRelationship.setTarget(targetShape);
	    //Step 4
	    NamedElement sourceLabel = OrmFactory.eINSTANCE.createNamedElement();
	    NamedElement targetLabel = OrmFactory.eINSTANCE.createNamedElement();
	    sourceLabel.setName(literals.STANDARD_CARDINALITY);
	    targetLabel.setName(literals.STANDARD_CARDINALITY);
	    newRelationship.setSourceLabel(sourceLabel);
	    newRelationship.setTargetLabel(targetLabel);
	    //Step 5
	    Connection newConnection = null;
	    AddConnectionContext addContext = new AddConnectionContext(sourceAnchor, targetAnchor);
	    addContext.setNewObject(newRelationship);
		if(canAdd(addContext)) newConnection = (Connection) add(addContext); 	
	    return newConnection;
	}
}
