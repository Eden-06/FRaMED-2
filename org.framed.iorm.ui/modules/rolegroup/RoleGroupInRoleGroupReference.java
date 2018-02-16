package rolegroup;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.impl.MoveShapeContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.framed.iorm.model.Model;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.UIUtil;
import org.framed.iorm.ui.references.AbstractInRoleGroupReference;

/**
 * TODO
 */
public class RoleGroupInRoleGroupReference extends AbstractInRoleGroupReference {
	
	/**
	 * the object to get names, ids and so on for this feature
	 */
	private final Literals literals = new Literals();
	
	/**
	 * the object to call utility operations on
	 */
	private final Util util = new Util();
	
	public RoleGroupInRoleGroupReference() {
		modelType = Type.ROLE_GROUP;
	}
	
	//TODO
	public boolean inRoleGroup(ICreateContext createContext) {
		if(!(createContext.getTargetContainer() instanceof Diagram)) {
			if(UIUtil.isShape_IdValue(createContext.getTargetContainer(), literals.SHAPE_ID_ROLEGROUP_TYPEBODY)) {
				return true;
		}	}	
		return false;
	}
	
	//TODO
	public boolean inRoleGroup(IAddContext addContext) {
		if(!(addContext.getTargetContainer() instanceof Diagram)) {
			System.out.println(addContext.getTargetContainer());
			if(UIUtil.isShape_IdValue(addContext.getTargetContainer(), literals.SHAPE_ID_ROLEGROUP_TYPEBODY)) {
				return true;
		}	}	
		return false;
	}
	
	//TODO
	public Model createInRoleGroup(ICreateContext createContext, Diagram diagram) {
		Diagram roleGroupDiagram = util.getRoleGroupDiagramForItsShape(createContext.getTargetContainer(), diagram);
		return UIUtil.getLinkedModelForDiagram(roleGroupDiagram);
	}
	
	//TODO
	public Diagram addInRoleGroup(IAddContext addContext, Diagram diagram) {
		return util.getRoleGroupDiagramForItsShape(addContext.getTargetContainer(), diagram);
	}
	
	//TODO
	public void moveInRoleGroup(IMoveShapeContext moveContext, Diagram diagram, IFeatureProvider featureProvider) {
		ContainerShape typeBodyShape = (ContainerShape) moveContext.getPictogramElement();
		RoundedRectangle typeBodyRectangle = (RoundedRectangle) typeBodyShape.getGraphicsAlgorithm();
		ContainerShape dropShadowShape = (ContainerShape) ((ContainerShape) typeBodyShape).getContainer().getChildren().get(0);
		RoundedRectangle dropShadowRectangle = (RoundedRectangle) dropShadowShape.getGraphicsAlgorithm();
		Shape OCShape = (Shape) ((ContainerShape) typeBodyShape).getContainer().getChildren().get(1);
		Text OCText = (Text) OCShape.getGraphicsAlgorithm();
		Diagram RoleGroupDiagram = util.getRoleGroupDiagramForItsShape(typeBodyShape, diagram);
		GraphicsAlgorithm diagramRectangle = RoleGroupDiagram.getGraphicsAlgorithm();

		int x, y;
		MoveShapeContext moveContextImpl = (MoveShapeContext) moveContext;
		if(moveContextImpl.getProperty("automated") != null) {
			x =  typeBodyRectangle.getX() + moveContextImpl.getDeltaX();
			y =  typeBodyRectangle.getY() + moveContextImpl.getDeltaY();
		} else {
			x =  moveContext.getTargetContainer().getGraphicsAlgorithm().getX() + typeBodyRectangle.getX() + moveContextImpl.getDeltaX();
			y =  moveContext.getTargetContainer().getGraphicsAlgorithm().getY() + typeBodyRectangle.getY() + moveContextImpl.getDeltaY();
			moveContextImpl.setDeltaX(moveContext.getDeltaX() + moveContext.getTargetContainer().getGraphicsAlgorithm().getX());
			moveContextImpl.setDeltaY(moveContext.getDeltaY() + moveContext.getTargetContainer().getGraphicsAlgorithm().getY());
		}
		Graphiti.getGaService().setLocation(dropShadowRectangle, x+literals.SHADOW_SIZE, y+literals.SHADOW_SIZE);
		Graphiti.getGaService().setLocation(diagramRectangle, x, y);
		Graphiti.getGaService().setLocation(OCText, 
				x+typeBodyRectangle.getWidth()/2-literals.HEIGHT_OCCURRENCE_CONSTRAINT/2, 
				y-literals.HEIGHT_OCCURRENCE_CONSTRAINT-literals.PUFFER_BETWEEN_ELEMENTS);
		typeBodyRectangle.setX(x);
		typeBodyRectangle.setY(y);
		for(Shape innerShape : RoleGroupDiagram.getChildren()) {
			if(innerShape instanceof ContainerShape) {
				ContainerShape innerTypeBody = (ContainerShape) ((ContainerShape) innerShape).getChildren().get(2);
				MoveShapeContext moveContextForInnerShape = new MoveShapeContext(innerTypeBody);
				moveContextForInnerShape.setDeltaX(moveContextImpl.getDeltaX());
				moveContextForInnerShape.setDeltaY(moveContextImpl.getDeltaY());
				moveContextForInnerShape.setTargetContainer(typeBodyShape);
				moveContextForInnerShape.setSourceContainer(innerTypeBody.getContainer());
				moveContextForInnerShape.putProperty("automated", "");
				IMoveShapeFeature moveFeature = featureProvider.getMoveShapeFeature(moveContextForInnerShape);
				if(moveFeature.canMoveShape(moveContextForInnerShape)) moveFeature.moveShape(moveContextForInnerShape);
		}	}
	}
}

