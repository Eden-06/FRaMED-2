package group;

import org.framed.iorm.model.Type;
import org.framed.iorm.ui.references.AbstractGroupingFeatureReference;

/**
 * This is the grouping feature reference which contain informations about the group
 * @author Kevin Kassin
 */
public class GroupGroupingFeatureReference extends AbstractGroupingFeatureReference {

	/**
	 * the group's literals
	 */
	group.Literals literals = new group.Literals();
	
	/**
	 * class constructor
	 */
	public GroupGroupingFeatureReference() {
		modelType = Type.GROUP;
		DIAGRAM_KIND = literals.DIAGRAM_KIND;
		SHAPE_ID_CONTAINER = literals.SHAPE_ID_GROUP_CONTAINER;
		SHAPE_ID_NAME = literals.SHAPE_ID_GROUP_NAME;
		SHAPE_ID_TYPEBODY = literals.SHAPE_ID_GROUP_TYPEBODY;
		paletteView = literals.paletteView;
	}
}
