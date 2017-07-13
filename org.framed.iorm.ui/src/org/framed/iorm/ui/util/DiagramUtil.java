package org.framed.iorm.ui.util;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.ui.editor.DiagramEditorInput;
import org.eclipse.ui.IEditorInput;
import org.framed.iorm.model.Model;
import org.framed.iorm.ui.exceptions.NoDiagramFoundException;
import org.framed.iorm.ui.exceptions.NoModelFoundException;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.wizards.RoleModelWizard;

/**
 * This class offers severals utility operations to handle diagrams.
 * @author Kevin Kassin
 */
public class DiagramUtil {
	
	/**
	 * the identifier of the <em>main diagram</em> and <em>container diagram</em> using the property diagram kind
	 * <p>
	 * If its not clear what <em>main diagram</em> and <em>container diagram</em> means, see 
	 * {@link RoleModelWizard#createEmfFileForDiagram} for reference.
	 */
	private static final String DIAGRAM_KIND_MAIN_DIAGRAM = IdentifierLiterals.DIAGRAM_KIND_MAIN_DIAGRAM,
							    DIAGRAM_KIND_CONTAINER_DIAGRAM = IdentifierLiterals.DIAGRAM_KIND_CONTAINER_DIAGRAM;
	
	/**
	 * the identifiers for graphics algorithms of group pictograms gathered from {@link IdentifierLiterals}
	 */
	static final String SHAPE_ID_GROUP_TYPEBODY = IdentifierLiterals.SHAPE_ID_GROUP_TYPEBODY,
						SHAPE_ID_GROUP_NAME = IdentifierLiterals.SHAPE_ID_GROUP_NAME;

	/**
	 * This operation gets the root {@link Model} for a given {@link Diagram}.
	 * @param diagram The diagram to get the model from
	 * @return the root model of the given diagram if there is exactly one model linked and returns null else
	 */
	public static final Model getLinkedModelForDiagram(Diagram diagram) {
		if(diagram.getLink() != null) {
			if(diagram.getLink().getBusinessObjects().size() == 1 &&
			   diagram.getLink().getBusinessObjects().get(0) instanceof Model) {
				return (Model) diagram.getLink().getBusinessObjects().get(0);
			}
		}
		return null;
	}

	/**
	 * This operation fetches the groups diagram for a shape that is a part of a groups pictogram 
	 * representation using the following steps:
	 * <p>
	 * Step 1: It gets the name of the group depending on the given shape.<br>
	 * Step 2: It searches in the list of children of the container diagram for a diagram with the name
	 * 		   found in step 2. If no such diagram can be found, throw a {@link NoDiagramFoundException}
	 * <p>
	 * If its not clear what the different shapes are look for the pictogram structure of a group here: 
	 * {@link org.framed.iorm.ui.pattern.shapes.GroupPattern#add}.<br>
	 * If its not clear what <em>container diagram</em> means, see {@link RoleModelWizard#createEmfFileForDiagram} for reference.
	 * @param groupShape the shape to start the search for the groups diagram 
	 * @param diagram the diagram the groups pictogram elements are located in
	 * @return the groups diagram, if the given shape was a name shape or the type body shape of a group
	 * @throws NoDiagramFoundException
	 */
	public static Diagram getGroupDiagramForGroupShape(Shape groupShape, Diagram diagram) {
		//Step 1
		String groupName = null;
		if(PropertyUtil.isShape_IdValue(groupShape, SHAPE_ID_GROUP_TYPEBODY)) {
			Shape groupNameShape = ((ContainerShape) groupShape).getChildren().get(0);
			if(PropertyUtil.isShape_IdValue(groupNameShape, SHAPE_ID_GROUP_NAME))
				groupName = ((Text) groupNameShape.getGraphicsAlgorithm()).getValue();
			}	
		if(PropertyUtil.isShape_IdValue(groupShape, SHAPE_ID_GROUP_NAME))
			groupName = ((Text) groupShape.getGraphicsAlgorithm()).getValue();	
		//Step 2
		Diagram containerDiagram = DiagramUtil.getContainerDiagramForAnyDiagram(diagram);
		if(containerDiagram == null) throw new NoDiagramFoundException();
			for(Shape shape : containerDiagram.getChildren()) {
				if(shape instanceof Diagram) {
					if(((Diagram) shape).getName().equals(groupName))
						return ((Diagram) shape);
				}	
		}	
		throw new NoDiagramFoundException();	
	}

	/**
	 * fetches the diagram in which a given shape in contained
	 * @param shape the shape to get containing diagram for
	 * @return the diagram that contains the given shape
	 */
	public static Diagram getDiagramForContainedShape(Shape shape) {
		if(shape.getContainer() == null) return null;
		if(shape.getContainer() instanceof Diagram) {	 
			return (Diagram) shape.getContainer();
		}
		if(shape.getContainer() instanceof Shape &&
		   !(shape.getContainer() instanceof Diagram)) {
			return getDiagramForContainedShape(shape.getContainer());
		}
		return null;
	}

	/**
	 * uses an recursive algorithm to find the <em>container diagram</em> of a role model
	 * <p>
	 * If its not clear what <em>container diagram</em> means, see {@link RoleModelWizard#createEmfFileForDiagram} for reference.
	 * @param diagram the diagram to search the container diagram from
	 * @return the container diagram of a role model
	 */
	public static Diagram getContainerDiagramForAnyDiagram(Diagram diagram) {
		if(PropertyUtil.isDiagram_KindValue(diagram, DIAGRAM_KIND_CONTAINER_DIAGRAM)) return diagram;
		else {
			if(diagram.getContainer() instanceof Diagram)
				return getContainerDiagramForAnyDiagram((Diagram) diagram.getContainer());
			else return null;
		}	
	}
	
	/**
	 * fetches the root model of role model which contains the given diagram
	 * @param diagram the diagram to search the root model for
	 * @return the root model of a role model
	 */
	public static Model getRootDiagramForAnyDiagram(Diagram diagram) {
		Model rootModel = null;
		Diagram containerDiagram = DiagramUtil.getContainerDiagramForAnyDiagram(diagram);
		for(Shape shape : containerDiagram.getChildren()) {
			if(shape instanceof Diagram &&
			   PropertyUtil.isDiagram_KindValue((Diagram) shape, DIAGRAM_KIND_MAIN_DIAGRAM)) {
				if(shape.getLink().getBusinessObjects().size() == 1) {
					rootModel = (Model) shape.getLink().getBusinessObjects().get(0);
		}	}	}
		if(rootModel == null) throw new NoModelFoundException();
		else return rootModel;
	}	

	/**
	 * returns the diagram for a resource fetched from a {@link DiagramEditorInput}
	 * @param resource the resource to get the diagram from
	 * @return the fetched diagram
	 * @throws NoDiagramFoundException
	 */
	public static Diagram getDiagramForResourceOfDiagramEditorInput(Resource resource) {
		Diagram diagram = null;
		if(resource.getEObject(resource.getURI().fragment()) instanceof Diagram) {
			diagram = (Diagram) resource.getEObject(resource.getURI().fragment());
			return diagram;
		}	
		throw new NoDiagramFoundException();
	}

	/**
	 * fetches the <em>main diagram</em> for a given {@link IEditorInput}.
	 * <p>
	 * If its not clear what <em>main diagram</em> means, see {@link RoleModelWizard#createEmfFileForDiagram} for reference.
	 * @param editorInput the editor input to get the <em>main diagram</em> for
	 * @return the <em>main diagram</em> for an {@link IEditorInput}
	 * @throws NoDiagramFoundException If no diagram can be fetched
	 * @see RoleModelWizard#createEmfFileForDiagram
	 */
	public static Diagram getMainDiagramForIEditorInput(IEditorInput editorInput) {
		Resource resource = EditorInputUtil.getResourceFromEditorInput(editorInput);
		if(resource.getContents().get(0) instanceof Diagram) {
			Diagram containerDiagram = (Diagram) resource.getContents().get(0);
			if(containerDiagram.getChildren().get(0) instanceof Diagram) {
				return (Diagram) containerDiagram.getChildren().get(0);
			}	}	
		throw new NoDiagramFoundException();
	}

	/**
	 * searches for a diagram with the given name in the given resource
	 * <p>
	 * @param resource the resource to search the diagram in
	 * @param diagramName the name to search the diagram with
	 * @return the diagram with the specific name in the resource
	 * @throws NoDiagramFoundException
	 */
	public static Diagram getDiagramFromResourceByName(Resource resource, String diagramName) {
		if(resource.getContents().get(0) instanceof Diagram) {
			if(((Diagram) resource.getContents().get(0)).getContainer() == null) {
				Diagram containerDiagram = (Diagram) resource.getContents().get(0);
				for(Shape shape : containerDiagram.getChildren()) {
					if(shape instanceof Diagram) {
						Diagram diagram = (Diagram) shape;
						if(diagram.getName().equals(diagramName)) 
							return diagram;
		}	}	}	}
		throw new NoDiagramFoundException();
	}
}
