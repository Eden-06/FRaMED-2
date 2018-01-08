package org.framed.iorm.ui.util;

import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.literals.UILiterals;
import org.framed.iorm.ui.wizards.RoleModelWizard; //*import for javadoc link

import group.GroupPattern;

/**
 * This class offers several utility operations mostly used by the graphiti shape patterns.
 * @author Kevin Kassin
 */
public class ShapePatternUtil {
	
	/**
	 * the identifiers for groups pictogram elements gathered from {@link IdentifierLiterals}
	 */
	private static final String SHAPE_ID_GROUP_CONTAINER = IdentifierLiterals.SHAPE_ID_GROUP_CONTAINER,
								SHAPE_ID_GROUP_TYPEBODY = IdentifierLiterals.SHAPE_ID_GROUP_TYPEBODY,
								SHAPE_ID_GROUP_NAME = IdentifierLiterals.SHAPE_ID_GROUP_NAME;
							    
	/**
	 * the identifiers for compartment types pictogram elements gathered from {@link IdentifierLiterals}
	 */
	private static final String SHAPE_ID_COMPARTMENTTYPE_CONTAINER = IdentifierLiterals.SHAPE_ID_COMPARTMENTTYPE_CONTAINER,
								SHAPE_ID_COMPARTMENTTYPE_TYPEBODY = IdentifierLiterals.SHAPE_ID_COMPARTMENTTYPE_TYPEBODY,
								SHAPE_ID_COMPARTMENTTYPE_NAME = IdentifierLiterals.SHAPE_ID_COMPARTMENTTYPE_NAME;
	
	/**
	 * values for the property diagram kind used to differ between diagrams of groups and compartments
	 */
	private static final String DIAGRAM_KIND_GROUP_DIAGRAM = UILiterals.DIAGRAM_KIND_GROUP_DIAGRAM,
		    					DIAGRAM_KIND_COMPARTMENT_DIAGRAM = UILiterals.DIAGRAM_KIND_COMPARTMENTTYPE_DIAGRAM;
				
	/**
	 * fetches the <em>type body shape</em> of group or compartment type that has the given diagram attached to
	 * <p>
	 * To do that it basicly searches in all diagram of the <em>container diagram</em> for a <em>group container shape</em>
	 * or a <em>compartment container shape and compares the diagram name to the found groups or compartment types name.
	 * <p>
	 * If its not clear what <em>type body shape</em> and <em>container shape</em> means, 
	 * see {@link GroupPattern#add} for example.<br>
	 * If its not clear what <em>container diagram</em> means, see {@link RoleModelWizard#createEmfFileForDiagram} for
	 * reference.
	 * @param diagram the diagram to find the groups or compartment types type body shape for
	 * @return the type body shape of the group or compartment type that has the given diagram attached to
	 */
	public static ContainerShape getGroupTypeBodyForGroupsDiagram(Diagram diagram) {
		Diagram containerDiagram = DiagramUtil.getContainerDiagramForAnyDiagram(diagram);
		for(Shape containerDiagramChild : containerDiagram.getChildren()) {
			if(containerDiagramChild instanceof Diagram) {
				for(Shape diagramChild : ((Diagram) containerDiagramChild).getChildren()) {
					if(diagramChild instanceof ContainerShape) {
						if(UIUtil.isDiagram_KindValue(diagram, DIAGRAM_KIND_GROUP_DIAGRAM) &&
								UIUtil.isShape_IdValue(diagramChild, SHAPE_ID_GROUP_CONTAINER)) {
							if(getNameForGroupOrCompartmentTypeContainer((ContainerShape) diagramChild, Type.GROUP).equals(diagram.getName())) {
								return getTypeBodyForGroupOrCompartmentContainer((ContainerShape) diagramChild, Type.GROUP);
						}	}	}	
						if(UIUtil.isDiagram_KindValue(diagram, DIAGRAM_KIND_COMPARTMENT_DIAGRAM) && 		
						   UIUtil.isShape_IdValue(diagramChild, SHAPE_ID_COMPARTMENTTYPE_CONTAINER)) {
							if(getNameForGroupOrCompartmentTypeContainer((ContainerShape) diagramChild, Type.COMPARTMENT_TYPE).equals(diagram.getName())) {
								return getTypeBodyForGroupOrCompartmentContainer((ContainerShape) diagramChild, Type.COMPARTMENT_TYPE);
		}	}	}	}	}		
		return null;
	}	
		
	/**
	 * fetches the name of a group or compartment type to thats the given <em>container shape</em> shape belongs to
	 * <p>
	 * If its not clear what <em>container shape</em> means, see {@link GroupPattern#add} for example.
	 * @param container the groups or compartment types container shape of the group to get the name for
	 * @return the name of group or compartment type with the given shape
	 */
	private static String getNameForGroupOrCompartmentTypeContainer(ContainerShape container, Type type) {
		ContainerShape typeBodyShape = getTypeBodyForGroupOrCompartmentContainer(container, type);
		for(Shape shape : typeBodyShape.getChildren()) {
			if((UIUtil.isShape_IdValue(shape, SHAPE_ID_GROUP_NAME) &&
			    type == Type.GROUP) ||
			   (UIUtil.isShape_IdValue(shape, SHAPE_ID_COMPARTMENTTYPE_NAME) &&
		        type == Type.COMPARTMENT_TYPE))
				return ((Text) shape.getGraphicsAlgorithm()).getValue();
		}
		return null;
	}	
		
	/**
	 * fetches the <em>type body shape</em> of a group or compartment type to thats the givem <em>container shape</em> belongs to
	 * <p>
	 * If its not clear what <em>type body shape</em> and <em>container shape</em> means, see 
	 * {@link GroupPattern#add} for example.
	 * @param groupContainer the container shape of the group or compartment type to get the type body shape for
	 * @return the type body shape of group or compartment type with the given shape
	 */
	public static ContainerShape getTypeBodyForGroupOrCompartmentContainer(ContainerShape groupContainer, Type type) {
		for(Shape shape : groupContainer.getChildren()) {
			if(shape instanceof ContainerShape) {
			   if(UIUtil.isShape_IdValue(shape, SHAPE_ID_GROUP_TYPEBODY)) {
				   if(type == Type.GROUP)
					   return (ContainerShape) shape; 
			   }	   
			   if(UIUtil.isShape_IdValue(shape, SHAPE_ID_COMPARTMENTTYPE_TYPEBODY)) {
				   if(type == Type.COMPARTMENT_TYPE) 
		        	   return (ContainerShape) shape; 
			   }    
	    }	}  
		return null;
	}	
}
