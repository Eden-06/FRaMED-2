package org.framed.iorm.ui.util;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.ui.editor.DiagramEditorInput;
import org.eclipse.ui.IEditorInput;
import org.framed.iorm.model.Model;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.exceptions.NoDiagramFoundException;
import org.framed.iorm.ui.exceptions.NoLinkedModelYet;
import org.framed.iorm.ui.exceptions.NoModelFoundException;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.literals.UILiterals;
import org.framed.iorm.ui.wizards.RoleModelWizard;
import org.framed.iorm.ui.pattern.shapes.GroupPattern; //*import for javadoc link
import org.framed.iorm.ui.pattern.shapes.CompartmentTypePattern; //*import for javadoc link
import org.framed.iorm.ui.providers.ToolBehaviorProvider; //*import for javadoc link

/**
 * This class offers severals utility operations to handle diagrams.
 * @author Kevin Kassin
 */
public class DiagramUtil {
	
	/**
	 * the identifier of the <em>main diagram</em>, <em>container diagram</em>, group and compartment type
	 * diagram using the property diagram kind
	 * <p>
	 * If its not clear what <em>main diagram</em> and <em>container diagram</em> means, see 
	 * {@link RoleModelWizard#createEmfFileForDiagram} for reference.
	 */
	private static final String DIAGRAM_KIND_MAIN_DIAGRAM = UILiterals.DIAGRAM_KIND_MAIN_DIAGRAM,
							    DIAGRAM_KIND_CONTAINER_DIAGRAM = UILiterals.DIAGRAM_KIND_CONTAINER_DIAGRAM,
							    DIAGRAM_KIND_GROUP_DIAGRAM = UILiterals.DIAGRAM_KIND_GROUP_DIAGRAM,
							    DIAGRAM_KIND_COMPARTMENT_DIAGRAM = UILiterals.DIAGRAM_KIND_COMPARTMENTTYPE_DIAGRAM;
	
	/**
	 * the identifiers for of groups and compartment types pictograms gathered from {@link IdentifierLiterals}
	 */
	static final String SHAPE_ID_GROUP_TYPEBODY = IdentifierLiterals.SHAPE_ID_GROUP_TYPEBODY,
						SHAPE_ID_COMPARTMENTTYPE_TYPEBODY = IdentifierLiterals.SHAPE_ID_COMPARTMENTTYPE_TYPEBODY,
						SHAPE_ID_GROUP_NAME = IdentifierLiterals.SHAPE_ID_GROUP_NAME,
						SHAPE_ID_COMPARTMENTTYPE_NAME = IdentifierLiterals.SHAPE_ID_COMPARTMENTTYPE_NAME;

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
	 * This operation fetches a groups or compartment types diagram for a shape that is a part of a groups
	 * or compartments pictogram representation using the following steps:
	 * <p>
	 * Step 1: It gets the name of the group or compartment depending on the given shape.<br>
	 * Step 2: It searches in the list of children of the container diagram for a diagram with the name
	 * 		   found in step 2. If no such diagram can be found, throw a {@link NoDiagramFoundException}
	 * <p>
	 * If its not clear what the different shapes are look for the pictogram structure of a group or compartment type here: 
	 * {@link GroupPattern#add}<br>
	 * {@link CompartmentTypePattern#add}.<br>
	 * TODO if its not cleat typbe body
	 * If its not clear what <em>container diagram</em> means, see {@link RoleModelWizard#createEmfFileForDiagram} for reference.
	 * @param groupOrCompartmentTypeShape the shape to start the search for the groups diagram 
	 * @param diagram the diagram the group or compartment type is located in
	 * @param the type either {@link Type#GROUP} or {@link Type#COMPARTMENT_TYPE}
	 * @return the groups or compartment types diagram, if the given shape was a name shape or the type body shape
	 * @throws NoDiagramFoundException
	 */
	public static Diagram getGroupOrCompartmentTypeDiagramForItsShape(Shape groupOrCompartmentTypeShape, Diagram diagram, Type type) {
		//Step 1
		String name = null;
		if(PropertyUtil.isShape_IdValue(groupOrCompartmentTypeShape, SHAPE_ID_GROUP_TYPEBODY) ||
	       PropertyUtil.isShape_IdValue(groupOrCompartmentTypeShape, SHAPE_ID_COMPARTMENTTYPE_TYPEBODY)) {
			Shape nameShape = ((ContainerShape) groupOrCompartmentTypeShape).getChildren().get(0);
			if(PropertyUtil.isShape_IdValue(nameShape, SHAPE_ID_GROUP_NAME) ||
			   PropertyUtil.isShape_IdValue(nameShape, SHAPE_ID_COMPARTMENTTYPE_NAME))
				name = ((Text) nameShape.getGraphicsAlgorithm()).getValue();
			}	
		if(PropertyUtil.isShape_IdValue(groupOrCompartmentTypeShape, SHAPE_ID_GROUP_NAME) ||
		   PropertyUtil.isShape_IdValue(groupOrCompartmentTypeShape, SHAPE_ID_COMPARTMENTTYPE_NAME))
			name = ((Text) groupOrCompartmentTypeShape.getGraphicsAlgorithm()).getValue();	
		//Step 2
		Diagram containerDiagram = DiagramUtil.getContainerDiagramForAnyDiagram(diagram);
		if(containerDiagram == null) throw new NoDiagramFoundException();
		for(Shape shape : containerDiagram.getChildren()) {
			if(shape instanceof Diagram) {
				if(((PropertyUtil.isDiagram_KindValue((Diagram) shape, DIAGRAM_KIND_GROUP_DIAGRAM)) &&
				    type == Type.GROUP) ||
				   ((PropertyUtil.isDiagram_KindValue((Diagram) shape, DIAGRAM_KIND_COMPARTMENT_DIAGRAM)) &&
					type == Type.COMPARTMENT_TYPE)) {
					if(((Diagram) shape).getName().equals(name))
						return ((Diagram) shape);
		}	}	}	
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
	 * finds the <em>main diagram</em> of a role model
	 * <p>
	 * If its not clear what <em>main diagram</em> means, see {@link RoleModelWizard#createEmfFileForDiagram} for reference.
	 * @param diagram the diagram to search the main diagram from
	 * @return the container diagram of a role model
	 */
	public static Diagram getMainDiagramForAnyDiagram(Diagram diagram) {
		Diagram containerDiagram = getContainerDiagramForAnyDiagram(diagram);
		for(Shape shape : containerDiagram.getChildren()) {
			if(shape instanceof Diagram &&
			    PropertyUtil.isDiagram_KindValue((Diagram) shape, DIAGRAM_KIND_MAIN_DIAGRAM));
				return (Diagram) shape;
		}
		throw new NoDiagramFoundException();
	}
	
	/**
	 * fetches the root model of role model which contains the given diagram
	 * <p>
	 * Note: See {@link NoLinkedModelYet} and {@link ToolBehaviorProvider#getListOfFramedFeatureNames} for further
	 * informations.
	 * @param diagram the diagram to search the root model for
	 * @return the root model of a role model
	 */
	public static Model getRootModelForAnyDiagram(Diagram diagram) throws NullPointerException {
		Model rootModel = null;
		Diagram containerDiagram = DiagramUtil.getContainerDiagramForAnyDiagram(diagram);
		for(Shape shape : containerDiagram.getChildren()) {
			if(shape instanceof Diagram &&
			   PropertyUtil.isDiagram_KindValue((Diagram) shape, DIAGRAM_KIND_MAIN_DIAGRAM)) {
				//Note
				if(shape.getLink() == null) throw new NoLinkedModelYet();
				else { 
					if(shape.getLink().getBusinessObjects().size() == 1) {
						rootModel = (Model) shape.getLink().getBusinessObjects().get(0);
		}	}	}	}
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
			}	
		}	
		throw new NoDiagramFoundException();
	}

	/**
	 * searches for a diagram with the given name in the given resource
	 * <p>
	 * @param resource the resource to search the diagram in
	 * @param diagramName the name to search the diagram with
	 * @param type either {@link Type#GROUP} or {@link Type#COMPARTMENT_TYPE}
	 * @return the diagram with the specific name in the resource
	 * @throws NoDiagramFoundException
	 */
	public static Diagram getDiagramFromResourceByName(Resource resource, String diagramName, Type type) {
		if(resource.getContents().get(0) instanceof Diagram) {
			if(((Diagram) resource.getContents().get(0)).getContainer() == null) {
				Diagram containerDiagram = (Diagram) resource.getContents().get(0);
				for(Shape shape : containerDiagram.getChildren()) {
					if(shape instanceof Diagram) {
						Diagram diagram = (Diagram) shape;
						if((PropertyUtil.isDiagram_KindValue(diagram, DIAGRAM_KIND_GROUP_DIAGRAM) &&
							type == Type.GROUP) ||
						   (PropertyUtil.isDiagram_KindValue(diagram, DIAGRAM_KIND_COMPARTMENT_DIAGRAM) &&
						    type == Type.COMPARTMENT_TYPE)) {	
							if(diagram.getName().equals(diagramName)) 
								return diagram;
		}	}	}	}	}
		throw new NoDiagramFoundException();
	}
}
