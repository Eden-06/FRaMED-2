package org.framed.iorm.ui.pattern.shapes;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.impl.DeleteContext;
import org.eclipse.graphiti.features.context.impl.MultiDeleteInfo;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.pattern.AbstractPattern;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.framed.iorm.ui.util.PatternUtil;

/**
 * This class is an abstract super class for the graphiti shape patterns.
 * <p>
 * It collects common attributes and operations of these classes.
 * @author Kevin Kassin
 */
public abstract class FRaMEDShapePattern extends AbstractPattern {
	
	/**
	 * Class constructor
	 */
	public FRaMEDShapePattern() {
		super(null);
	}
	
	/**
	 * the pictogram elements service used to creates pictogram elements in the subclasses
	 */
	protected final IPeCreateService pictogramElementCreateService = Graphiti.getPeCreateService();
	
	/**
	 * the graphics algorithm service used to create graphics algorithms in the subclasses
	 */
	protected final IGaService graphicAlgorithmService = Graphiti.getGaService();

	/**
	 * to be overriden in it subclasses
	 */
	@Override
	public abstract boolean isMainBusinessObjectApplicable(Object mainBusinessObject);

	/**
	 * to be overriden in it subclasses
	 */
	@Override
	protected abstract boolean isPatternControlled(PictogramElement pictogramElement);

	/**
	 * to be overriden in it subclasses
	 */
	@Override
	protected abstract boolean isPatternRoot(PictogramElement pictogramElement);
	
	/**
	 * fetches the business object for an direct edited shape 
	 * @param editingContext the context of the direct editing
	 * @return the business object for an direct edited shape
	 */
	protected Object getBusinessObject(IDirectEditingContext editingContext) {
		PictogramElement pictogramElement = editingContext.getPictogramElement();
		return getBusinessObjectForPictogramElement(pictogramElement);
	}
	
	/**
	 * updates the list of the groups or compartment types content of in which an element is added, deleted or renamed
	 */
	protected void updateContainingGroupOrCompartmentType() {
		ContainerShape groupTypeBodyToUpdate = PatternUtil.getGroupTypeBodyForGroupsDiagram(getDiagram());
        updatePictogramElement(groupTypeBodyToUpdate);
	}
	
	/**
	 * deletes {@link Connection} that are attached to a shape that is getting deleted using the following steps:
	 * <p>
	 * Step 1: It gets all attached connections from the anchors of the shape to be deleted.<br>
	 * Step 2: It creates an {@link IDeleteFeature} for the attached connections to be deleted and disables the 
	 * "Are you sure?" dialog when deleting a pictogram element.
	 * <p>
	 * If its not clear what <em>type body shape</em> means, see {@link NaturalTypePattern#add} for example.<br>
	 * The pictogram element referenced in the {@link IDeleteContext} typically should be a type body shape of a class
	 * or role, since this shape have the anchors on which connections are hung to.
	 * @param deleteContext
	 */
	protected void deleteAttachedConnections(IDeleteContext deleteContext) {
		//Step 1
		if(deleteContext.getPictogramElement() instanceof ContainerShape) {
			List<Connection> connectionsToDelete = new ArrayList<Connection>();
			ContainerShape typeBodyShape = (ContainerShape) deleteContext.getPictogramElement();
			for(Anchor anchor : typeBodyShape.getAnchors()) {
				for(Connection connection : anchor.getIncomingConnections())
					connectionsToDelete.add(connection);
				for(Connection connection : anchor.getOutgoingConnections()) 
					connectionsToDelete.add(connection);
			}
			//Step 2
			for(Connection connection : connectionsToDelete) {
				DeleteContext connectionDeleteContext = new DeleteContext(connection);
				connectionDeleteContext.setMultiDeleteInfo(new MultiDeleteInfo(false, false, 0));
				IDeleteFeature deleteFeature = createDeleteFeature(connectionDeleteContext);
				deleteFeature.delete(connectionDeleteContext);
	}	}	}	
}
