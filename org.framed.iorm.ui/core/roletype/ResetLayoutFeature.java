package roletype;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.framed.iorm.ui.FRaMEDCustomFeature;
import org.framed.iorm.ui.UIUtil;
import org.framed.iorm.ui.providers.ToolBehaviorProvider;

/**
 * This graphiti custom feature is used to reset the layout of relationships and and role types.
 * <p>
 * It is needed because the cardinalities of relationship and role type are moveable. This could lead to 
 * problem with seeing which cardinality belong to which element. To avoid that the user can easily reset the
 * places of the cardinalites with this feature.
 * @author Kevin Kassin
 */
public class ResetLayoutFeature extends FRaMEDCustomFeature {

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
	public ResetLayoutFeature(IFeatureProvider featureProvider) {
		super(featureProvider);
		FEATURE_NAME = literals.RESET_LAYOUT_FEATURE_NAME;
	}
	
	/**
	 * this operation encapsulates when the custom feature should be visible in the context menu
	 * @return 
	 */
	public boolean contextMenuExpression(PictogramElement pictogramElement, EObject businessObject) {
		if(pictogramElement instanceof Shape &&
		   !(pictogramElement instanceof Diagram)) {
			if(UIUtil.isShape_IdValue((Shape) pictogramElement, literals.SHAPE_ID_ROLETYPE_TYPEBODY) ||
	    	   UIUtil.isShape_IdValue((Shape) pictogramElement, literals.SHAPE_ID_ROLETYPE_OCCURRENCE_CONSTRAINT)) 
				return true;
		}
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
	 * differs between relationships, fulfillments and role type to call operations which executes the feature 
	 * more specialized	 
	 * <p> 
	 * there hardly no checks for sizes of collections and types when casting since these checks are done
	 * {@link ToolBehaviorProvider}.
	 */
	@Override 
	public void execute(ICustomContext customContext) {	
		ContainerShape containerShape = ((Shape) customContext.getPictogramElements()[0]).getContainer();
		Shape typeBodyShape = null, occurenceConstraintShape = null;
		for(Shape shape : containerShape.getChildren()) {
			if(UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_ROLETYPE_TYPEBODY))
				typeBodyShape = shape;
			if(UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_ROLETYPE_OCCURRENCE_CONSTRAINT))
				occurenceConstraintShape = shape;
		}
		if(typeBodyShape != null && occurenceConstraintShape != null) {
			RoundedRectangle typeBodyRectangle = (RoundedRectangle) typeBodyShape.getGraphicsAlgorithm();
			graphicAlgorithmService.setLocation(occurenceConstraintShape.getGraphicsAlgorithm(),
				typeBodyRectangle.getX()+typeBodyRectangle.getWidth()/2-literals.HEIGHT_OCCURRENCE_CONSTRAINT/2, 
				typeBodyRectangle.getY()-literals.HEIGHT_OCCURRENCE_CONSTRAINT-literals.PUFFER_BETWEEN_ELEMENTS);
	}	}
}
