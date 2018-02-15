package roletype;

import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.framed.iorm.model.Model;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.UIUtil;
import org.framed.iorm.ui.references.AbstractInRoleGroupReference;
import org.framed.iorm.ui.references.AbstractRoleGroupReference;

/**
 * TODO
 */
public class RoleTypeInRoleGroupReference extends AbstractInRoleGroupReference {
	
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
}

