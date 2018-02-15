package rolegroup;

import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.framed.iorm.ui.references.AbstractRoleGroupReference;

/**
 * TODO
 */
public class RoleGroupReference extends AbstractRoleGroupReference {
	
	/**
	 * the object to get names, ids and so on for this feature
	 */
	private final Literals literals = new Literals();
	
	/**
	 * the object to call utility operations on
	 */
	private final Util util = new Util();
	
	public RoleGroupReference() {
		SHAPE_ID_ROLEGROUP_TYPEBODY = literals.SHAPE_ID_ROLEGROUP_TYPEBODY;
	}

	public Diagram getRoleGroupDiagramForItsShape(Shape typeBodyShape, Diagram diagram) {
		return util.getRoleGroupDiagramForItsShape(typeBodyShape, diagram);
	}
}

