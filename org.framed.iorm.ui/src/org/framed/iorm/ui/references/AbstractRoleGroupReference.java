package org.framed.iorm.ui.references;

import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;

/**
 * TODO
 */
public abstract class AbstractRoleGroupReference {
	
	public String SHAPE_ID_ROLEGROUP_TYPEBODY;
	
	public abstract Diagram getRoleGroupDiagramForItsShape(Shape typeBodyShape, Diagram diagram);
	
}

