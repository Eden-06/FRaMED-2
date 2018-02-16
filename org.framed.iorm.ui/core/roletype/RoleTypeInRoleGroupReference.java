package roletype;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.impl.MoveShapeContext;
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
import org.framed.iorm.ui.references.AbstractRoleGroupReference;

/**
 * TODO
 */
public class RoleTypeInRoleGroupReference extends AbstractInRoleGroupReference {
	
	private final Literals literals = new Literals();
	
	//TODO
	private final AbstractRoleGroupReference rgr;
	
	public RoleTypeInRoleGroupReference() {
		modelType = Type.ROLE_TYPE;
		rgr = UIUtil.getRoleGroupReference();
	}
	
	//TODO
	public boolean inRoleGroup(ICreateContext createContext) {
		if(!(createContext.getTargetContainer() instanceof Diagram)) {
			if(UIUtil.isShape_IdValue(createContext.getTargetContainer(), rgr.SHAPE_ID_ROLEGROUP_TYPEBODY)) {
				return true;
		}	}	
		return false;
	}
	
	//TODO
	public boolean inRoleGroup(IAddContext addContext) {
		if(!(addContext.getTargetContainer() instanceof Diagram)) {
			System.out.println(addContext.getTargetContainer());
			if(UIUtil.isShape_IdValue(addContext.getTargetContainer(), rgr.SHAPE_ID_ROLEGROUP_TYPEBODY)) {
				return true;
		}	}	
		return false;
	}
	
	//TODO
	public Model createInRoleGroup(ICreateContext createContext, Diagram diagram) {
		Diagram roleGroupDiagram = rgr.getRoleGroupDiagramForItsShape(createContext.getTargetContainer(), diagram);
		return UIUtil.getLinkedModelForDiagram(roleGroupDiagram);
	}
	
	//TODO
	public Diagram addInRoleGroup(IAddContext addContext, Diagram diagram) {
		return rgr.getRoleGroupDiagramForItsShape(addContext.getTargetContainer(), diagram);
	}
	
	//TODO
	public void moveInRoleGroup(IMoveShapeContext moveContext, Diagram diagram, IFeatureProvider featureProvider) {
		ContainerShape typeBodyShape = (ContainerShape) moveContext.getPictogramElement();
		RoundedRectangle typeBodyRectangle = (RoundedRectangle) typeBodyShape.getGraphicsAlgorithm();
		ContainerShape dropShadowShape = (ContainerShape) ((ContainerShape) typeBodyShape).getContainer().getChildren().get(0);
		RoundedRectangle dropShadowRectangle = (RoundedRectangle) dropShadowShape.getGraphicsAlgorithm();
		Shape OCShape = (Shape) ((ContainerShape) typeBodyShape).getContainer().getChildren().get(1);
		Text OCText = (Text) OCShape.getGraphicsAlgorithm();
		
		int x, y;
		MoveShapeContext moveContextImpl = (MoveShapeContext) moveContext;
		if(moveContextImpl.getProperty("automated") != null) {
			x =  typeBodyRectangle.getX() + moveContext.getDeltaX();
			y =  typeBodyRectangle.getY() + moveContext.getDeltaY();
		} else {
			x =  moveContext.getTargetContainer().getGraphicsAlgorithm().getX() + typeBodyRectangle.getX() + moveContext.getDeltaX();
			y =  moveContext.getTargetContainer().getGraphicsAlgorithm().getY() + typeBodyRectangle.getY() + moveContext.getDeltaY();
		}
			dropShadowRectangle.setX(x + literals.SHADOW_SIZE);
			dropShadowRectangle.setY(y + literals.SHADOW_SIZE);
			Graphiti.getGaService().setLocation(OCText, 
					x+typeBodyRectangle.getWidth()/2-literals.HEIGHT_OCCURRENCE_CONSTRAINT/2, 
					y-literals.HEIGHT_OCCURRENCE_CONSTRAINT-literals.PUFFER_BETWEEN_ELEMENTS);
			typeBodyRectangle.setX(x);
			typeBodyRectangle.setY(y);
	}
}

