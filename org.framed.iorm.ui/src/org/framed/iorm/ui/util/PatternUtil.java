package org.framed.iorm.ui.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.framed.iorm.model.Model;
import org.framed.iorm.model.ModelElement;
import org.framed.iorm.model.NamedElement;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.wizards.RoleModelWizard; //*import for javadoc link
import org.framed.iorm.ui.pattern.shapes.GroupPattern; //*import for javadoc link
import org.eclipse.graphiti.features.IMappingProvider; //*import for javadoc link

/**
 * This class offers several utility operations used by the graphiti patterns.
 * @author Kevin Kassin
 */
public class PatternUtil {
	
	/**
	 * the identifiers for groups pictogram elements gathered from {@link IdentifierLiterals}
	 */
	private static final String SHAPE_ID_GROUP_CONTAINER = IdentifierLiterals.SHAPE_ID_GROUP_CONTAINER,
								SHAPE_ID_GROUP_TYPEBODY = IdentifierLiterals.SHAPE_ID_GROUP_TYPEBODY,
								SHAPE_ID_GROUP_NAME = IdentifierLiterals.SHAPE_ID_GROUP_NAME,
								SHAPE_ID_GROUP_CONTENT_PREVIEW = IdentifierLiterals.SHAPE_ID_GROUP_CONTENT_PREVIEW,
							    SHAPE_ID_GROUP_ELEMENT = IdentifierLiterals.SHAPE_ID_GROUP_ELEMENT;
							    
	/**
	 * the identifiers for compartment types pictogram elements gathered from {@link IdentifierLiterals}
	 */
	private static final String SHAPE_ID_COMPARTMENTTYPE_CONTAINER = IdentifierLiterals.SHAPE_ID_COMPARTMENTTYPE_CONTAINER,
								SHAPE_ID_COMPARTMENTTYPE_TYPEBODY = IdentifierLiterals.SHAPE_ID_COMPARTMENTTYPE_TYPEBODY,
								SHAPE_ID_COMPARTMENTTYPE_NAME = IdentifierLiterals.SHAPE_ID_COMPARTMENTTYPE_NAME,
							    SHAPE_ID_COMPARTMENTTYPE_CONTENT_PREVIEW = IdentifierLiterals.SHAPE_ID_COMPARTMENTTYPE_CONTENT_PREVIEW,
								SHAPE_ID_COMPARTMENTTYPE_ELEMENT = IdentifierLiterals.SHAPE_ID_COMPARTMENTTYPE_ELEMENT;
	
	/**
	 * the identifiers for pictogram elements of attributes and operations gathered from {@link IdentifierLiterals}
	 */
	private static final String SHAPE_ID_OPERATION_TEXT = IdentifierLiterals.SHAPE_ID_OPERATION_TEXT,
								SHAPE_ID_ATTRIBUTE_TEXT = IdentifierLiterals.SHAPE_ID_ATTRIBUTE_TEXT;
	
	/**
	 * values for the property diagram kind used to differ between diagrams of groups and compartments
	 */
	private static final String DIAGRAM_KIND_GROUP_DIAGRAM = IdentifierLiterals.DIAGRAM_KIND_GROUP_DIAGRAM,
		    					DIAGRAM_KIND_COMPARTMENT_DIAGRAM = IdentifierLiterals.DIAGRAM_KIND_COMPARTMENTTYPE_DIAGRAM;
				
	/**
	 * fetches all the names of the groups content that are shown in <em>model content preview container</em> of the group
	 * <p>
	 * If its not clear what <em>model content preview container</em> and <em>type body shape</em> means, see 
	 * {@link GroupPattern#add} for example. 
	 * @param pictogramElement the type body shape of of a group
	 * @return a list of the shown names of child elements of a group
	 */
	public static List<String> getContentPreviewElementsNames(PictogramElement pictogramElement) {
		List<String> modelContainerElementsNames = new ArrayList<String>();
		if(pictogramElement instanceof ContainerShape) {
			ContainerShape containerShape = (ContainerShape) pictogramElement;
			for(Shape shape : containerShape.getChildren()) {
				if(PropertyUtil.isShape_IdValue(shape, SHAPE_ID_GROUP_CONTENT_PREVIEW) ||
				   PropertyUtil.isShape_IdValue(shape, SHAPE_ID_COMPARTMENTTYPE_CONTENT_PREVIEW)) {
					ContainerShape previewContentContainer = (ContainerShape) shape; 
					for(Shape previewContentContainerElement : previewContentContainer.getChildren()) {
						if(PropertyUtil.isShape_IdValue(previewContentContainerElement, SHAPE_ID_GROUP_ELEMENT) ||
						   PropertyUtil.isShape_IdValue(previewContentContainerElement, SHAPE_ID_COMPARTMENTTYPE_ELEMENT)) {
							Text text = (Text) previewContentContainerElement.getGraphicsAlgorithm();
							modelContainerElementsNames.add(text.getValue());
		}	}	}	}	}
		return modelContainerElementsNames;
	}

	/**
	 * fetches all the names of the actual direct child elements in a groups model except {@link Relation}s
	 * @param pictogramElement the pictogram/ shape element of the group
	 * @param diagram the diagram the pattern that called this operation works in
	 * @param the type either {@link Type#GROUP} or {@link Type#COMPARTMENT_TYPE}
	 * @return a list of names of all direct child elements in a groups model
	 */
	public static List<String> getGroupOrCompartmentTypeElementNames(PictogramElement pictogramElement, Diagram diagram, Type type) {
		List<String> modelElementsNames = new ArrayList<String>();
		Diagram groupOrCompartmentTypeDiagram = DiagramUtil.getGroupOrCompartmentTypeDiagramForItsShape((ContainerShape) pictogramElement, diagram, type);
		Model groupOrCompartmentTypeModel = DiagramUtil.getLinkedModelForDiagram(groupOrCompartmentTypeDiagram);
		for(ModelElement modelElement : groupOrCompartmentTypeModel.getElements()) {
			if(modelElement instanceof org.framed.iorm.model.Shape)
				modelElementsNames.add(modelElement.getName());
		}
		return modelElementsNames;
	}

	/**
	 * This operation gets the name of a pictogram element with text shape as children.
	 * @param pictogramElement the pictogram element to get the name of
	 * @param SHAPE_ID_NAME the identifier of the textshape
	 * @return the name of a pictogram element if it has a text shape as children and return null else 
	 */
	public static String getNameOfPictogramElement(PictogramElement pictogramElement, String SHAPE_ID_NAME) {
		if (pictogramElement instanceof ContainerShape) {
			ContainerShape containerShape = (ContainerShape) pictogramElement;
			for (Shape shape : containerShape.getChildren()) {
				if (shape.getGraphicsAlgorithm() instanceof Text) {
					Text text = (Text) shape.getGraphicsAlgorithm();
					if(PropertyUtil.isShape_IdValue(shape, SHAPE_ID_NAME)) {
						return text.getValue();
					}
		} 	}	}
		return null;
	}

	/**
	 * This operation gets the name of a business object that is an {@link org.framed.iorm.model.Shape}
	 * @param businessObject the business object to get the name of
	 * @return the name of the business object if it is an {@link org.framed.iorm.model.Shape}
	 */
	public static String getNameOfBusinessObject(Object businessObject) {
		if (businessObject instanceof org.framed.iorm.model.Shape) {
			org.framed.iorm.model.Shape shape = (org.framed.iorm.model.Shape) businessObject;
			return shape.getName();
		}
		return null;
	}
	
	/**
	 * This operation gets the names of the attributes of a pictogram element that has an attribute container shape.
	 * @param pictogramElement the pictogram element to get the attribute names of
	 * @param SHAPE_ID_ATTRIBUTECONTAINER the identifier of the attribute container shape
	 * @return the attribute names of the pictogram element if it has an attribute container shape and returns null else
	 */
	public static List<String> getpictogramAttributeNames(PictogramElement pictogramElement, String SHAPE_ID_ATTRIBUTECONTAINER) {
		List<String> pictogrammAttributeNames = new ArrayList<String>();
		if (pictogramElement instanceof ContainerShape) {
			ContainerShape containerShape = (ContainerShape) pictogramElement;
			for (Shape shape : containerShape.getChildren()) {
				if(shape instanceof ContainerShape) {
					ContainerShape innerContainerShape = (ContainerShape) shape;
					if(PropertyUtil.isShape_IdValue(innerContainerShape, SHAPE_ID_ATTRIBUTECONTAINER)) {
						for(Shape attributeShape : innerContainerShape.getChildren()) {
							if(PropertyUtil.isShape_IdValue(attributeShape, SHAPE_ID_ATTRIBUTE_TEXT)) {
								Text text = (Text) attributeShape.getGraphicsAlgorithm();
								pictogrammAttributeNames.add(text.getValue());
		}	}	}	}	}	}
		return pictogrammAttributeNames;
	}
	
	/**
	 * This operation gets the names of the attributes in a model of a pictogram element that has an attribute container shape.
	 * @param pictogramElement the pictogram element to get the attribute names of
	 * @param SHAPE_ID_ATTRIBUTECONTAINER the identifier of the attribute container shape
	 * @return the attribute names in a model of the pictogram element if it has an attribute container shape and returns null else
	 */
	public static List<String> getBusinessAttributeNames(PictogramElement pictogramElement, String SHAPE_ID_ATTRIBUTECONTAINER) {
		List<String> businessAttributeNames = new ArrayList<String>();
		if (pictogramElement instanceof ContainerShape) {
			ContainerShape containerShape = (ContainerShape) pictogramElement;
			for (Shape shape : containerShape.getChildren()) {
				if(shape instanceof ContainerShape) {
					ContainerShape innerContainerShape = (ContainerShape) shape;
					if(PropertyUtil.isShape_IdValue(innerContainerShape, SHAPE_ID_ATTRIBUTECONTAINER)) {
						for(Shape attributeShape : innerContainerShape.getChildren()) {
							if(PropertyUtil.isShape_IdValue(attributeShape, SHAPE_ID_ATTRIBUTE_TEXT)) {	
								NamedElement attribute = (NamedElement) getBusinessObjectForPictogramElement(attributeShape);
								businessAttributeNames.add(attribute.getName());
		}	}	}	}	}	}	
		return businessAttributeNames;
	}
	
	/**
	 * This method gets the names of the operations of a pictogram element that has an operation container shape.
	 * @param pictogramElement the pictogram element to get the operation names of
	 * @param SHAPE_ID_OPERATIONCONTAINER the identifier of the operation container shape
	 * @return the operation names of the pictogram element if it has an operation container shape and returns null else
	 */
	public static List<String> getpictogramOperationNames(PictogramElement pictogramElement, String SHAPE_ID_OPERATIONCONTAINER) {
		List<String> pictogramOperationNames = new ArrayList<String>();
		if (pictogramElement instanceof ContainerShape) {
			ContainerShape containerShape = (ContainerShape) pictogramElement;
			for (Shape shape : containerShape.getChildren()) {
				if(shape instanceof ContainerShape) {
					ContainerShape innerContainerShape = (ContainerShape) shape;
					if(PropertyUtil.isShape_IdValue(innerContainerShape, SHAPE_ID_OPERATIONCONTAINER)) {
						for(Shape operationShape : innerContainerShape.getChildren()) {
							if(PropertyUtil.isShape_IdValue(operationShape, SHAPE_ID_OPERATION_TEXT)) {
								Text text = (Text) operationShape.getGraphicsAlgorithm();
								pictogramOperationNames.add(text.getValue());
		}	}	}	}	}	}
		return pictogramOperationNames;
	}
	
	/**
	 * This method gets the names of the operations in a model of pictogram element that has an operation container shape.
	 * @param pictogramElement the pictogram element to get the operation names of
	 * @param SHAPE_ID_OPERATIONCONTAINER the identifier of the operation container shape
	 * @return the operation names in a model of the pictogram element if it has an operation container shape and returns null else
	 */
	public static List<String> getBusinessOperationNames(PictogramElement pictogramElement, String SHAPE_ID_OPERATIONCONTAINER) {
		List<String> businessOperationNames = new ArrayList<String>();
		if (pictogramElement instanceof ContainerShape) {
			ContainerShape containerShape = (ContainerShape) pictogramElement;
			for (Shape shape : containerShape.getChildren()) {
				if(shape instanceof ContainerShape) {
					ContainerShape innerContainerShape = (ContainerShape) shape;
					if(PropertyUtil.isShape_IdValue(innerContainerShape, SHAPE_ID_OPERATIONCONTAINER)) {
						for(Shape operationShape : innerContainerShape.getChildren()) {
							if(PropertyUtil.isShape_IdValue(operationShape, SHAPE_ID_OPERATION_TEXT)) {	
								NamedElement operation = (NamedElement) getBusinessObjectForPictogramElement(operationShape);
								businessOperationNames.add(operation.getName());
		}	}	}	}	}	}	
		return businessOperationNames;
	}
		
		/**
		 * returns the first linked business object of a pictogram
		 * <p>
		 * This operation is build after method {@link IMappingProvider#getBusinessObjectForPictogramElement} to avoid
		 * an dependency.<br>
		 * This is a convenience method for getAllBusinessObjectsForPictogramElement(PictogramElement), because in many 
		 * usecases only a single business object is linked.
		 * @param pictogramElement
		 * @return
		 */
		private static EObject getBusinessObjectForPictogramElement(PictogramElement pictogramElement) {
			return pictogramElement.getLink().getBusinessObjects().get(0);
		}

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
						if(PropertyUtil.isDiagram_KindValue(diagram, DIAGRAM_KIND_GROUP_DIAGRAM) &&
						   PropertyUtil.isShape_IdValue(diagramChild, SHAPE_ID_GROUP_CONTAINER)) {
							if(getNameForGroupOrCompartmentTypeContainer((ContainerShape) diagramChild, Type.GROUP).equals(diagram.getName())) {
								return getTypeBodyForGroupOrCompartmentContainer((ContainerShape) diagramChild, Type.GROUP);
						}	}	}	
						if(PropertyUtil.isDiagram_KindValue(diagram, DIAGRAM_KIND_COMPARTMENT_DIAGRAM) && 		
						   PropertyUtil.isShape_IdValue(diagramChild, SHAPE_ID_COMPARTMENTTYPE_CONTAINER)) {
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
			if((PropertyUtil.isShape_IdValue(shape, SHAPE_ID_GROUP_NAME) &&
			    type == Type.GROUP) ||
			   (PropertyUtil.isShape_IdValue(shape, SHAPE_ID_COMPARTMENTTYPE_NAME) &&
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
			   if(PropertyUtil.isShape_IdValue(shape, SHAPE_ID_GROUP_TYPEBODY)) {
				   if(type == Type.GROUP)
					   return (ContainerShape) shape; 
			   }	   
			   if(PropertyUtil.isShape_IdValue(shape, SHAPE_ID_COMPARTMENTTYPE_TYPEBODY)) {
				   if(type == Type.COMPARTMENT_TYPE) 
		        	   return (ContainerShape) shape; 
			   }    
	    }	}  
		return null;
	}	
	
	/**
	 * calculate the string for a group or compartment type element that is shown in the group as
	 * preview of its content
	 * @param modelElement the model elemen in the group or compartment type to calculate the shown string for
	 * @return the value of preview string of group or compartment type content for the given modelElement
	 */
	public static String getGroupOrCompartmentTypeElementText(ModelElement modelElement) {
		return modelElement.getType().toString() + " " + modelElement.getName();
	}

}
