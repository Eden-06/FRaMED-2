package inheritance;

import java.util.Arrays;
import java.util.List;

import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.mm.algorithms.Polygon;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.framed.iorm.model.ModelElement;
import org.framed.iorm.model.OrmFactory;
import org.framed.iorm.model.Relation;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.FRaMEDConnectionPattern;
import org.framed.iorm.ui.UIUtil;
import org.framed.iorm.ui.editPolicy.EditPolicyService;
import org.framed.iorm.ui.palette.FeaturePaletteDescriptor;
import org.framed.iorm.ui.palette.PaletteCategory;
import org.framed.iorm.ui.palette.PaletteView;
import org.framed.iorm.ui.palette.ViewVisibility;

/**
 * This graphiti pattern is used to work with {@link Relation}s
 * of the type {@link Type#INHERITANCE} in the editor.
 * <p>
 * It deals with the following aspects of Inheritances:<br>
 * (1) creating inheritances, especially their business object<br>
 * (2) adding inheritances to the diagram, especially their pictogram elements<br>
 * @author Kevin Kassin
 */
public class InheritancePattern extends FRaMEDConnectionPattern {
	
	//TODO To be delete when the type checks are done by the edit policies
	/**
	 * the lists of types for which a inheritance is applicable
	 */
	List<Type> types = Arrays.asList(Type.NATURAL_TYPE, Type.DATA_TYPE, Type.COMPARTMENT_TYPE, Type.ROLE_TYPE);
	
	/**
	 * the object to get names, ids and so on for this feature
	 */
	private final Literals literals = new Literals();
	
	/**
	 * the feature palette descriptor manages the palette visibility, see {@link FeaturePaletteDescriptor}
	 */
	private final FeaturePaletteDescriptor spec_FPD = new FeaturePaletteDescriptor(
		PaletteCategory.RELATIONS_CATEGORY,
		ViewVisibility.ALL_VIEWS) {
			@Override
			public boolean featureExpression(List<String> framedFeatureNames, PaletteView paletteView) {
				switch(paletteView) {
					case TOPLEVEL_VIEW: return true;
					case COMPARTMENT_VIEW: 
						return (framedFeatureNames.contains("Role_Inheritance") ||
							    (framedFeatureNames.contains("Compartment_Inheritance") &&
							     framedFeatureNames.contains("Contains_Compartments")));
					default: return false;
			}	}	};
	
	/**
	 * class constructor		
	 */
	public InheritancePattern() {
		super();
		FEATURE_NAME = literals.FEATURE_NAME;
		ICON_IMG_ID = literals.ICON_IMG_ID;
		ICON_IMG_PATH = literals.ICON_IMG_PATH;
		modelType = Type.INHERITANCE;
		FPD = spec_FPD;
	}
	
	/**
	 * checks if connection can be reconnected
	 * <p>
	 * @return true if the shapes the new and old anchors belong to have the same type
	 */
	@Override
	public boolean canReconnect(IReconnectionContext context) {
		Anchor oldAnchor = context.getOldAnchor();
	    Anchor newAnchor = context.getNewAnchor();
	    org.framed.iorm.model.ModelElement oldShape = UIUtil.getModelElementForAnchor(oldAnchor);
	    org.framed.iorm.model.ModelElement newShape = UIUtil.getModelElementForAnchor(newAnchor);
	    if(oldShape != null && newShape != null) {
	    	if(oldShape.getContainer() == newShape.getContainer()) {
	    		if(newShape.getType() == oldShape.getType()) {
	    			return true;
	    }	}	}
	    return false;
	}
	
	//add feature
	//~~~~~~~~~~~
	/**
	 * calculates if a inheritance can be added to the pictogram diagram
	 * <p>
	 * returns true if the business object is a inheritance
	 * @return if a inheritance can be added
	 */
	@Override
	public boolean canAdd(IAddContext addContext) {
		if(addContext.getNewObject() instanceof Relation) {
		   Relation relation = (Relation) addContext.getNewObject();
		   if(relation.getType() == Type.INHERITANCE)
			   return EditPolicyService.getHandler(this.getDiagram()).canAdd(addContext);
		}
		return false;
	}
		
	/**
	 * adds the inheritance to the pictogram diagram using the following steps:
	 * <p>
	 * Step 1: create a connection shape and polyline as its graphic algorithm
	 * Step 2: create the a connection decorator and a arrowhead as its graphic algorithm 
	 * Step 3: link the pictogram elements and the business objects
	 */
	@Override
	public PictogramElement add(IAddContext addContext) {
		IAddConnectionContext addConnectionContext = (IAddConnectionContext) addContext;
	    Relation addedInheritance = (Relation) addContext.getNewObject();
	    Anchor sourceAnchor = addConnectionContext.getSourceAnchor();
	    Anchor targetAnchor = addConnectionContext.getTargetAnchor();
	    //Step 1
	    Connection connection = pictogramElementCreateService.createFreeFormConnection(getDiagram());
	    connection.setStart(sourceAnchor);
	    connection.setEnd(targetAnchor);
	    Polyline polyline = graphicAlgorithmService.createPolyline(connection);
	    polyline.setForeground(manageColor(literals.COLOR_CONNECTIONS));
	    polyline.setLineWidth(2);
	    //Step2
	    ConnectionDecorator connectionDecorator;
	    connectionDecorator = pictogramElementCreateService.createConnectionDecorator(connection, false, 1.0, true);
	    int points[] = new int[] { -1*literals.INHERITANCE_ARROWHEAD_LENGTH, literals.INHERITANCE_ARROWHEAD_HEIGHT, 		//Point 1
	    						   0, 0, 																					//P2
	    						   -1*literals.INHERITANCE_ARROWHEAD_LENGTH, -1*literals.INHERITANCE_ARROWHEAD_HEIGHT };	//P3						 
		Polygon arrowhead = graphicAlgorithmService.createPolygon(connectionDecorator, points);
		arrowhead.setForeground(manageColor(literals.COLOR_CONNECTIONS));
	    arrowhead.setBackground(manageColor(literals.COLOR_INHERITANCE_ARROWHEAD));
	    UIUtil.setShape_IdValue(connectionDecorator, literals.SHAPE_ID_INHERITANCE_DECORATOR);
	    //Step 3
	    link(connection, addedInheritance);
	    return connection;
	}
		 
	//create feature
	//~~~~~~~~~~~~~~
	/**
	 * calculates if a inheritance can be created
	 * <p>
	 * returns true if<br>
	 * (1) target and source shape are not null and<br>
	 * (2) target and source shape is of valid type and<br>
	 * (3) source shapes container and targets shapes container are the same and<br>
	 * (4) the source shape is not equals the target shape and<br>
	 * (5) target and source shape are of the same type
	 * @return if inheritance can be added
	 */
	@Override
	public boolean canCreate(ICreateConnectionContext createContext) {
		Anchor sourceAnchor = createContext.getSourceAnchor();
	    Anchor targetAnchor = createContext.getTargetAnchor();
	    ModelElement sourceShape = UIUtil.getModelElementForAnchor(sourceAnchor);
	    ModelElement targetShape = UIUtil.getModelElementForAnchor(targetAnchor);
	    if(sourceShape != null && targetShape != null) {
	    	if(sourceShape.getContainer() == targetShape.getContainer() &&
	    	   !(sourceShape.equals(targetShape))) {
	    		if(types.contains(sourceShape.getType()))
	    			if(targetShape.getType() == sourceShape.getType())
						return EditPolicyService.getHandler(this.getDiagram()).canCreate(createContext, Type.INHERITANCE);
	    }	}
	    return false;
	}
	 
	/**
	 * checks if a inheritance can be started from a given source shape
	 * <p>
	 * returns true if<br>
	 * (1) source shape is not null and<br>
	 * (2) source shape is of valid type 
	 * @return if inheritance can be started
	 */
	@Override
	public boolean canStartConnection(ICreateConnectionContext createContext) {
		Anchor sourceAnchor = createContext.getSourceAnchor();
		ModelElement sourceShape = UIUtil.getModelElementForAnchor(sourceAnchor);
		if(sourceShape != null){	
			if(types.contains(sourceShape.getType()))
				return EditPolicyService.getHandler(this.getDiagram()).canStart(createContext);
		}	
		return false;
	}
	  
	/**
	 * creates the business object of an inheritance using the following steps:
	 * <p>
	 * Step 1: get source and target shapes<br>
	 * Step 2: get new inheritance and add it to the resource of the diagram<br>
	 * Step 3: set source, target and container of inheritance<br>
	 * Step 4: call add operation of this pattern
	 */
	@Override
	public Connection create(ICreateConnectionContext createContext) {
		//Step 1
		Anchor sourceAnchor = createContext.getSourceAnchor();
	    Anchor targetAnchor = createContext.getTargetAnchor();
	    org.framed.iorm.model.ModelElement sourceShape = UIUtil.getModelElementForAnchor(sourceAnchor);
	    org.framed.iorm.model.ModelElement targetShape = UIUtil.getModelElementForAnchor(targetAnchor);
		//Step 2
		Relation newInheritance = OrmFactory.eINSTANCE.createRelation();
	    newInheritance.setType(Type.INHERITANCE); 
	    if(newInheritance.eResource() != null) getDiagram().eResource().getContents().add(newInheritance);
	    //Step 3
	    newInheritance.setContainer(sourceShape.getContainer());
	    sourceShape.getContainer().getElements().add(newInheritance);
	    newInheritance.setSource(sourceShape);
	    newInheritance.setTarget(targetShape);
	    //Step 4
	    AddConnectionContext addContext = new AddConnectionContext(sourceAnchor, targetAnchor);
	    addContext.setNewObject(newInheritance);
	    Connection newConnection = null;
	    if(canAdd(addContext)) newConnection = (Connection) add(addContext); 	        
	    return newConnection;
	}
}
