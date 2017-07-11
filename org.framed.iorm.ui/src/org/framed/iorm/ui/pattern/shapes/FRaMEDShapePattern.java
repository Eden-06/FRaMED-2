package org.framed.iorm.ui.pattern.shapes;

import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.pattern.AbstractPattern;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.framed.iorm.ui.util.PatternUtil;
import org.framed.iorm.ui.util.PropertyUtil;

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
	 * updates the list of the group content of a group in which an element is added, deleted or renamed
	 */
	protected void updateContainingGroup() {
		ContainerShape groupTypeBodyToUpdate = PatternUtil.getGroupTypeBodyForGroupsDiagram(getDiagram());
        updatePictogramElement(groupTypeBodyToUpdate);
	}
}
