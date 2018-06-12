package roletype.role_constraints;

import java.util.List;

import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.mm.algorithms.Polygon;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.styles.LineStyle;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.framed.iorm.model.Relation;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.UIUtil;
import org.framed.iorm.ui.palette.FeaturePaletteDescriptor;
import org.framed.iorm.ui.palette.PaletteCategory;
import org.framed.iorm.ui.palette.PaletteView;
import org.framed.iorm.ui.palette.ViewVisibility;

/**
 * This graphiti pattern is used to work with {@link Relation}s
 * of the type {@link Type#ROLE_EQUIVALENCEE} in the editor.
 * <p>
 * It deals with the following aspects of role equivalences:<br>
 * (1) creating role equivalences, especially their business object<br>
 * (2) adding role equivalences to the diagram, especially their pictogram elements<br>
 * <p>
 * It is a subclass of {@link AbstractRoleConstraintPattern} and several operations used here are implemented there.
 * @author Kevin Kassin
 */
public class RoleEquivalencePattern extends AbstractRoleConstraintPattern {
	
	/**
	 * the object to get names, ids and so on for this feature
	 */
	Literals literals = new Literals();
		
	/**
	 * the feature palette descriptor manages the palette visibility, see {@link FeaturePaletteDescriptor}
	 */
	/*
	private final FeaturePaletteDescriptor spec_FPD = new FeaturePaletteDescriptor(
			PaletteCategory.CONSTRAINTS_CATEGORY,
			ViewVisibility.COMPARTMENT_VIEW) {
				@Override
				public boolean featureExpression(List<String> framedFeatureNames, PaletteView paletteView) {
					return framedFeatureNames.contains("Role_Equivalence");
			}	};*/
			
			private final FeaturePaletteDescriptor spec_FPD = new FeaturePaletteDescriptor(
					PaletteCategory.CONSTRAINTS_CATEGORY,
					ViewVisibility.ALL_VIEWS) {};
			
		
	/**
	 * Class constructor
	 */
	public RoleEquivalencePattern() {
		super();
		FEATURE_NAME = literals.ROLEEQUIVALENCE_FEATURE_NAME;
		ICON_IMG_ID = literals.ROLEEQUIVALENCE_ICON_IMG_ID;
		ICON_IMG_PATH = literals.ROLEEQUIVALENCE_ICON_IMG_PATH;
		modelType = Type.ROLE_EQUIVALENCE;
		FPD = spec_FPD;
	}
	
	/**
	 * uses the operation {@link AbstractRoleConstraintPattern#canAddRoleConstraint} of the super type to calculate if
	 * the role equivalences can be added
	 */
	@Override
	public boolean canAdd(IAddContext addContext) {
		return canAddRoleConstraint(addContext, Type.ROLE_EQUIVALENCE);
	}
	
	/**
	 * adds the role equivalences to the pictogram diagram using the following steps:
	 * <p>
	 * Step 1: create a connection shape and dashed polyline as its graphic algorithm
	 * Step 2: create the two connection decorators and arrowheads as their graphics algorithms 
	 * Step 3: link the pictogram elements and the business objects
	 */
	@Override
	public PictogramElement add(IAddContext addContext) {
		IAddConnectionContext addConnectionContext = (IAddConnectionContext) addContext;
	    Relation addedRoleEquivalence = (Relation) addContext.getNewObject();
	    Anchor sourceAnchor = addConnectionContext.getSourceAnchor();
	    Anchor targetAnchor = addConnectionContext.getTargetAnchor();
	    //Step 1
	    Connection connection = pictogramElementCreateService.createFreeFormConnection(getDiagram());
	    connection.setStart(sourceAnchor);
	    connection.setEnd(targetAnchor);
	    Polyline polyline = graphicAlgorithmService.createPolyline(connection);
	    polyline.setForeground(manageColor(literals.COLOR_CONNECTIONS));
	    polyline.setLineStyle(LineStyle.DASH);
	    polyline.setLineWidth(2);
	    //Step2
	    ConnectionDecorator connectionDecoratorTarget;
	    connectionDecoratorTarget = pictogramElementCreateService.createConnectionDecorator(connection, false, 1.0, true);
	    int pointsTarget[] = new int[] { -1*literals.ROLECONSTRAINT_ARROWHEAD_LENGTH, literals.ROLECONSTRAINT_ARROWHEAD_HEIGHT,     //Point 1
	    								 0, 0, 										//P2
	    								 -1*literals.ROLECONSTRAINT_ARROWHEAD_LENGTH, -1*literals.ROLECONSTRAINT_ARROWHEAD_HEIGHT };//P3						 
	    Polygon arrowheadTarget = graphicAlgorithmService.createPolygon(connectionDecoratorTarget, pointsTarget);
	    arrowheadTarget.setForeground(manageColor(literals.COLOR_CONNECTIONS));
	    arrowheadTarget.setBackground(manageColor(literals.COLOR_ARROWHEAD));
	    UIUtil.setShape_IdValue(connectionDecoratorTarget, literals.SHAPE_ID_ROLE_CONSTRAINT_DECORATOR);
	    ConnectionDecorator connectionDecoratorSource;
	    connectionDecoratorSource = pictogramElementCreateService.createConnectionDecorator(connection, false, 0, true);
	    int pointsSource[] = new int[] { -1*literals.ROLECONSTRAINT_ARROWHEAD_LENGTH, literals.ROLECONSTRAINT_ARROWHEAD_HEIGHT, 	//Point 1
	    						   		 0, 0, 									  	 //P2
	    						   		 -1*literals.ROLECONSTRAINT_ARROWHEAD_LENGTH, -1*literals.ROLECONSTRAINT_ARROWHEAD_HEIGHT }; //P3						 
	    Polygon arrowheadSource = graphicAlgorithmService.createPolygon(connectionDecoratorSource, pointsSource);
	    arrowheadSource.setForeground(manageColor(literals.COLOR_CONNECTIONS));
	    arrowheadSource.setBackground(manageColor(literals.COLOR_ARROWHEAD));
	    UIUtil.setShape_IdValue(connectionDecoratorSource, literals.SHAPE_ID_ROLE_CONSTRAINT_DECORATOR);
	    //Step 3
	    link(connection, addedRoleEquivalence);
	    return connection;
	}
	 
	//create feature
	//~~~~~~~~~~~~~~  
	/**
	 * uses the operation {@link AbstractRoleConstraintPattern#createRoleConstraint} of the super type to create the role equivalences
	 */
	@Override
	public Connection create(ICreateConnectionContext createContext) {
		return super.createRoleConstraint(createContext, Type.ROLE_EQUIVALENCE, this);
	}
}
