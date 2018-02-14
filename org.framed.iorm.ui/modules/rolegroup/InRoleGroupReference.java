package rolegroup;

import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.framed.iorm.model.Model;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.UIUtil;
import org.framed.iorm.ui.references.AbstractInRoleGroupReference;

/**
 * TODO
 */
public class InRoleGroupReference extends AbstractInRoleGroupReference {
	
	/**
	 * the object to get names, ids and so on for this feature
	 */
	private final Literals literals = new Literals();
	
	/**
	 * the object to call utility operations on
	 */
	private final Util util = new Util();
	
	public InRoleGroupReference() {
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
	public Model createInRoleGroup(ICreateContext createContext, Diagram diagram) {
		Diagram roleGroupDiagram = util.getRoleGroupDiagramForItsShape(createContext.getTargetContainer(), diagram);
		return UIUtil.getLinkedModelForDiagram(roleGroupDiagram);
	}
	
	//TODO
	//public abstract Object[] addInRoleGroup();
}

