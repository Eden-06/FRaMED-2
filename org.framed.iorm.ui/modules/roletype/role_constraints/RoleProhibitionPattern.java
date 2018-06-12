package roletype.role_constraints;

import java.util.List;

import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
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
 * of the type {@link Type#ROLE_PROHIBITION} in the editor.
 * <p>
 * It deals with the following aspects of role implications:<br>
 * (1) creating role prohibitions, especially their business object<br>
 * (2) adding role prohibitions to the diagram, especially their pictogram elements<br>
 * <p>
 * It is a subclass of {@link AbstractRoleConstraintPattern} and several operations used here are implemented there.
 * @author Kevin Kassin
 */
public class RoleProhibitionPattern extends AbstractRoleConstraintPattern {
	
	/**
	 * the object to get names, ids and so on for this feature
	 */
	Literals literals = new Literals();
		
	/**
	 * the feature palette descriptor manages the palette visibility, see {@link FeaturePaletteDescriptor}
	 */
	private final FeaturePaletteDescriptor spec_FPD = new FeaturePaletteDescriptor(
			PaletteCategory.CONSTRAINTS_CATEGORY,
			ViewVisibility.COMPARTMENT_VIEW) {
				@Override
				public boolean featureExpression(List<String> framedFeatureNames, PaletteView paletteView) {
					return framedFeatureNames.contains("Role_Prohibition");
			}	};
	
	/**
	 * Class constructor
	 */
	public RoleProhibitionPattern() {
		super();
		FEATURE_NAME = literals.ROLEPROHIBITION_FEATURE_NAME;
		ICON_IMG_ID = literals.ROLEPROHIBITION_ICON_IMG_ID;
		ICON_IMG_PATH = literals.ROLEPROHIBITION_ICON_IMG_PATH;
		modelType = Type.ROLE_PROHIBITION;
		FPD = spec_FPD;
	}				
			
	//add feature
	//~~~~~~~~~~~
	/**
	 * uses the operation {@link AbstractRoleConstraintPattern#canAddRoleConstraint} of the super type to calculate if
	 * the role prohibtion can be added
	 */
	@Override
	public boolean canAdd(IAddContext addContext) {
		return canAddRoleConstraint(addContext, Type.ROLE_PROHIBITION);
	}
	
	/**
	 * adds the role prohibition to the pictogram diagram using the following steps:
	 * <p>
	 * Step 1: create a connection shape and dashed polyline as its graphic algorithm
	 * Step 2: create the a connection decorator and two polyline as its graphics algorithms
	 * Step 3: link the pictogram elements and the business objects
	 */
	@Override
	public PictogramElement add(IAddContext addContext) {
		IAddConnectionContext addConnectionContext = (IAddConnectionContext) addContext;
	    Relation addedRoleProhibtion = (Relation) addContext.getNewObject();
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
	    ConnectionDecorator connectionDecoratorTarget = 
	    	pictogramElementCreateService.createConnectionDecorator(connection, false, 1.0, true);
	    int points[] = new int[] { 0, literals.ROLECONSTRAINT_ARROWHEAD_HEIGHT, 		//Point 1
				 						 -1*literals.ROLECONSTRAINT_ARROWHEAD_LENGTH, 0, 	//P2
				 						 0, -1*literals.ROLECONSTRAINT_ARROWHEAD_HEIGHT };	//P3						 
	    Polyline polylineTarget = graphicAlgorithmService.createPolyline(connectionDecoratorTarget, points);
	    polylineTarget.setLineWidth(2); 
	    polylineTarget.setForeground(manageColor(literals.COLOR_CONNECTIONS));
	    UIUtil.setShape_IdValue(connectionDecoratorTarget, literals.SHAPE_ID_ROLE_CONSTRAINT_DECORATOR);
	    ConnectionDecorator connectionDecoratorSource = 
	    	pictogramElementCreateService.createConnectionDecorator(connection, false, 0, true);					 
	    Polyline polylineSource = graphicAlgorithmService.createPolyline(connectionDecoratorSource, points);
	    polylineSource.setLineWidth(2); 
	    polylineSource.setForeground(manageColor(literals.COLOR_CONNECTIONS));
	    UIUtil.setShape_IdValue(connectionDecoratorSource, literals.SHAPE_ID_ROLE_CONSTRAINT_DECORATOR);
	    //Step 3
	    link(connection, addedRoleProhibtion);
	    return connection;
	}
	 
	//create feature
	//~~~~~~~~~~~~~~  
	/**
	 * uses the operation {@link AbstractRoleConstraintPattern#createRoleConstraint} of the super type to create the role prohibition
	 */
	@Override
	public Connection create(ICreateConnectionContext createContext) {
		return super.createRoleConstraint(createContext, Type.ROLE_PROHIBITION, this);
	}
}
