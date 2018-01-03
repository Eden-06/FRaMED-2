package core.naturaltype;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.framed.iorm.model.Model;
import org.framed.iorm.model.ModelElement;
import org.framed.iorm.model.NamedElement;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.util.UIUtil;
import org.framed.iorm.ui.wizards.RoleModelWizard; //**import used for javadoc link

import core.naturaltype.Literals;
import core.naturaltype.references.AttributeAndOperationsReference;

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
	public int calculateHorizontalCenter(int heightOfNaturalType) {
		return ((heightOfNaturalType-literals.HEIGHT_NAME_SHAPE)/2)+literals.HEIGHT_NAME_SHAPE;
	}	
	
	//Names
	//~~~~~
	/**
	 * matching operation for the regular expression of natural type names (identifier)
	 * @param identifier the string to check against
	 * @return if the given string input matches the regular expression
	 */
	public final boolean matchesIdentifier(String identifier) {
		Matcher identifierMatcher = Pattern.compile(literals.REG_EXP_NAME).matcher(identifier);
		return identifierMatcher.matches();
	}
		
	/**
	 * calculates if another natural type already has a name equivalent to the new given name when direct editing 
	 * names using the following steps:
	 * <p>
	 * Step 1: It gets the <em>main diagram</em> of the role model that the given diagram belongs to.<br>
	 * Step 2: It fetches a list of the model element names for the given type and checks if this list contains
	 * 		   the new name.
	 * <p>
	 * If its not clear what <em>main diagram</em> means, see {@link RoleModelWizard#createEmfFileForDiagram} for reference.
	 * @param diagram the diagram that is direct edited
	 * @param newName the name to check against
	 * @return boolean if another model element of a given type already has the same name when direct editing
	 */
	public boolean nameAlreadyUsedForClass(Diagram diagram, String newName) {
		List<String> modelElements = new ArrayList<String>();
		//Step 1
		Model rootModel = UIUtil.getRootModelForAnyDiagram(diagram);
		//Step 2
		getNaturalTypeNamesRecursive(rootModel, modelElements);
		return modelElements.contains(newName);
	}
		
	/**
	 * calculates the standard name of a data type when creating one
	 * <p>
	 * The standard name will be build by using a given standard name and adding a number as suffix to it
	 * if needed. The limit of this number is set in {@link Literals#STANDARD_NAMES_COUNTER_LIMIT}.
	 * @param diagram the diagram in that a class is added
	 * @param standardName the normally used standard name for the class
	 * @return
	 */
	public String calculateStandardNameForClass(Diagram diagram) {
		List<String> modelElements = new ArrayList<String>();
		Model rootModel = UIUtil.getRootModelForAnyDiagram(diagram);
		getNaturalTypeNamesRecursive(rootModel, modelElements);
		if(!(modelElements.contains(literals.STANDARD_NAME))) return literals.STANDARD_NAME;
		for(int i=1; i<=literals.STANDARD_NAMES_COUNTER_LIMIT; i++) {
			if(!(modelElements.contains(literals.STANDARD_NAME + Integer.toString(i))))
				return literals.STANDARD_NAME + Integer.toString(i);
		}
		return literals.STANDARD_NAME;
	}
		
	/**
	 * fetches all names data types of the given model and its sub models of a given type in a recursive manner
	 * @param model the model to fetch the model elements names from
	 * @param modelElementNames the list of model element names to fill while using recursion
	 */
	private void getNaturalTypeNamesRecursive(Model model, List<String> modelElementNames) {
		for(ModelElement modelElement : model.getElements()) {
			if(modelElement.getType() == Type.NATURAL_TYPE)  
				modelElementNames.add(modelElement.getName());
			if(modelElement.getType() == Type.COMPARTMENT_TYPE ||
			   modelElement.getType() == Type.GROUP) 
				getNaturalTypeNamesRecursive(((org.framed.iorm.model.Shape) modelElement).getModel(), modelElementNames);
	}	}
	
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
					if(UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_NATURALTYPE_NAME)) {
						return text.getValue();
		}	} 	}	}
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
					if(UIUtil.isShape_IdValue(innerContainerShape, literals.SHAPE_ID_NATURALTYPE_ATTRIBUTECONTAINER)) {
						for(Shape attributeShape : innerContainerShape.getChildren()) {
							if(UIUtil.isShape_IdValue(attributeShape, aaoReference.SHAPE_ID_ATTRIBUTE_TEXT)) {
								Text text = (Text) attributeShape.getGraphicsAlgorithm();
								pictogrammAttributeNames.add(text.getValue());
		}	}	}	}	}	}
		return pictogrammAttributeNames;
	}
		
	/**
	 * This operation gets the names of the attributes in a model of a pictogram element that has an attribute container shape.
	 * @param pictogramElement the pictogram element to get the attribute names 
	 * @return the attribute names in a model of the pictogram element if it has an attribute container shape and returns null else
	 */
	public List<String> getBusinessAttributeNames(PictogramElement pictogramElement) {
		List<String> businessAttributeNames = new ArrayList<String>();
		if (pictogramElement instanceof ContainerShape) {
			ContainerShape containerShape = (ContainerShape) pictogramElement;
			for (Shape shape : containerShape.getChildren()) {
				if(shape instanceof ContainerShape) {
					ContainerShape innerContainerShape = (ContainerShape) shape;
					if(UIUtil.isShape_IdValue(innerContainerShape, literals.SHAPE_ID_NATURALTYPE_ATTRIBUTECONTAINER)) {
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
					if(UIUtil.isShape_IdValue(innerContainerShape, literals.SHAPE_ID_NATURALTYPE_OPERATIONCONTAINER)) {
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
					if(UIUtil.isShape_IdValue(innerContainerShape, literals.SHAPE_ID_NATURALTYPE_OPERATIONCONTAINER)) {
						for(Shape operationShape : innerContainerShape.getChildren()) {
							if(UIUtil.isShape_IdValue(operationShape, aaoReference.SHAPE_ID_OPERATION_TEXT)) {	
								NamedElement operation = (NamedElement) UIUtil.getBusinessObjectForPictogramElement(operationShape);
								businessOperationNames.add(operation.getName());
		}	}	}	}	}	}	
		return businessOperationNames;
	}
}
