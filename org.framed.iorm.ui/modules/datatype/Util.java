package datatype;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.framed.iorm.model.NamedElement;
import org.framed.iorm.ui.util.UIUtil;

import datatype.references.AttributeAndOperationsReference;

/**
 * This class offers utility operations in the scope of the attribute and operations feature module.
 * @author Kevin Kassin
 */
public class Util {
	
	/**
	 * the object to get names, id and so on for this feature
	 */
	private final Literals literals = new Literals();
	
	/**
	 * the reference oject to encapsulate the dependency to the datatypes attribute and operation feature
	 */
	private final AttributeAndOperationsReference aaoReference = new AttributeAndOperationsReference();
	
	//Layout
	//~~~~~~
	/**
	 * This operation calculates where the horizontal center of a data type.
	 * @param heightOfDataType the height of the data type
	 * @return the horizontal center position
	 */
	public int calculateHorizontalCenter(int heightOfDataType) {
		return ((heightOfDataType-literals.HEIGHT_NAME_SHAPE-literals.DATATYPE_CORNER_SIZE)/2)+literals.HEIGHT_NAME_SHAPE;
	}	
	
	//Update
	//~~~~~~
	/**
	 * This operation gets the name of a pictogram element with text shape as children.
	 * @param pictogramElement the pictogram element to get the name of
	 * @return the name of a pictogram element if it has a text shape as children and return null else 
	 */
	public String getNameOfPictogramElement(PictogramElement pictogramElement) {
		if (pictogramElement instanceof ContainerShape) {
			ContainerShape containerShape = (ContainerShape) pictogramElement;
			for (Shape shape : containerShape.getChildren()) {
				if (shape.getGraphicsAlgorithm() instanceof Text) {
					Text text = (Text) shape.getGraphicsAlgorithm();
					if(UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_DATATYPE_NAME)) {
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
	public String getNameOfBusinessObject(Object businessObject) {
		if (businessObject instanceof org.framed.iorm.model.Shape) {
			org.framed.iorm.model.Shape shape = (org.framed.iorm.model.Shape) businessObject;
			return shape.getName();
		}
		return null;
	}

	/**
	 * This operation gets the names of the attributes of a pictogram element that has an attribute container shape.
	 * @param pictogramElement the pictogram element to get the attribute names of
	 * @return the attribute names of the pictogram element if it has an attribute container shape and returns null else
	 */
	public List<String> getpictogramAttributeNames(PictogramElement pictogramElement) {
		List<String> pictogrammAttributeNames = new ArrayList<String>();
		if (pictogramElement instanceof ContainerShape) {
			ContainerShape containerShape = (ContainerShape) pictogramElement;
			for (Shape shape : containerShape.getChildren()) {
				if(shape instanceof ContainerShape) {
					ContainerShape innerContainerShape = (ContainerShape) shape;
					if(UIUtil.isShape_IdValue(innerContainerShape, literals.SHAPE_ID_DATATYPE_ATTRIBUTECONTAINER)) {
						for(Shape attributeShape : innerContainerShape.getChildren()) {
							if(UIUtil.isShape_IdValue(attributeShape, aaoReference.SHAPE_ID_ATTRIBUTE_TEXT)) {
								Text text = (Text) attributeShape.getGraphicsAlgorithm();
								pictogrammAttributeNames.add(text.getValue());
		}	}	}	}	}	}
		return pictogrammAttributeNames;
	}
	
	/**
	 * This operation gets the names of the attributes in a model of a pictogram element that has an attribute container shape.
	 * @param pictogramElement the pictogram element to get the attribute names of
	 * @return the attribute names in a model of the pictogram element if it has an attribute container shape and returns null else
	 */
	public List<String> getBusinessAttributeNames(PictogramElement pictogramElement) {
		List<String> businessAttributeNames = new ArrayList<String>();
		if (pictogramElement instanceof ContainerShape) {
			ContainerShape containerShape = (ContainerShape) pictogramElement;
			for (Shape shape : containerShape.getChildren()) {
				if(shape instanceof ContainerShape) {
					ContainerShape innerContainerShape = (ContainerShape) shape;
					if(UIUtil.isShape_IdValue(innerContainerShape, literals.SHAPE_ID_DATATYPE_ATTRIBUTECONTAINER)) {
						for(Shape attributeShape : innerContainerShape.getChildren()) {
							if(UIUtil.isShape_IdValue(attributeShape, aaoReference.SHAPE_ID_ATTRIBUTE_TEXT)) {	
								NamedElement attribute = (NamedElement) UIUtil.getBusinessObjectForPictogramElement(attributeShape);
								businessAttributeNames.add(attribute.getName());
		}	}	}	}	}	}	
		return businessAttributeNames;
	}
	
	/**
	 * This method gets the names of the operations of a pictogram element that has an operation container shape.
	 * @param pictogramElement the pictogram element to get the operation names of
	 * @return the operation names of the pictogram element if it has an operation container shape and returns null else
	 */
	public List<String> getpictogramOperationNames(PictogramElement pictogramElement) {
		List<String> pictogramOperationNames = new ArrayList<String>();
		if (pictogramElement instanceof ContainerShape) {
			ContainerShape containerShape = (ContainerShape) pictogramElement;
			for (Shape shape : containerShape.getChildren()) {
				if(shape instanceof ContainerShape) {
					ContainerShape innerContainerShape = (ContainerShape) shape;
					if(UIUtil.isShape_IdValue(innerContainerShape, literals.SHAPE_ID_DATATYPE_OPERATIONCONTAINER)) {
						for(Shape operationShape : innerContainerShape.getChildren()) {
							if(UIUtil.isShape_IdValue(operationShape, aaoReference.SHAPE_ID_OPERATION_TEXT)) {
								Text text = (Text) operationShape.getGraphicsAlgorithm();
								pictogramOperationNames.add(text.getValue());
		}	}	}	}	}	}
		return pictogramOperationNames;
	}	
	
	/**
	 * This method gets the names of the operations in a model of pictogram element that has an operation container shape.
	 * @param pictogramElement the pictogram element to get the operation names of
	 * @return the operation names in a model of the pictogram element if it has an operation container shape and returns null else
	 */
	public List<String> getBusinessOperationNames(PictogramElement pictogramElement) {
		List<String> businessOperationNames = new ArrayList<String>();
		if (pictogramElement instanceof ContainerShape) {
			ContainerShape containerShape = (ContainerShape) pictogramElement;
			for (Shape shape : containerShape.getChildren()) {
				if(shape instanceof ContainerShape) {
					ContainerShape innerContainerShape = (ContainerShape) shape;
					if(UIUtil.isShape_IdValue(innerContainerShape, literals.SHAPE_ID_DATATYPE_OPERATIONCONTAINER)) {
						for(Shape operationShape : innerContainerShape.getChildren()) {
							if(UIUtil.isShape_IdValue(operationShape, aaoReference.SHAPE_ID_OPERATION_TEXT)) {	
								NamedElement operation = (NamedElement) UIUtil.getBusinessObjectForPictogramElement(operationShape);
								businessOperationNames.add(operation.getName());
		}	}	}	}	}	}	
		return businessOperationNames;
	}
}
