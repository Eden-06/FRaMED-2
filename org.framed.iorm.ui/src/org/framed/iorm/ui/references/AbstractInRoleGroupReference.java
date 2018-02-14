package org.framed.iorm.ui.references;

import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.framed.iorm.model.Model;
import org.framed.iorm.model.Type;

/**
 * TODO
 */
public abstract class AbstractInRoleGroupReference {
	
	public Type modelType; 
	
	public abstract boolean inRoleGroup(ICreateContext createContext);
	public abstract boolean inRoleGroup(IAddContext addContext);
	
	//TODO
	public abstract Model createInRoleGroup(ICreateContext createContext, Diagram diagram);
	
	//TODO
	public abstract Diagram addInRoleGroup(IAddContext addContext, Diagram diagram);
}

