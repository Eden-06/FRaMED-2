package core.roletype;

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
import org.framed.iorm.ui.util.DiagramUtil;
import org.framed.iorm.ui.util.PropertyUtil;
import org.framed.iorm.ui.util.UIUtil;

import core.roletype.references.AttributeAndOperationsReference;
import core.roletype.Literals;

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
	public int calculateHorizontalCenter(int heightOfRoleType) {
		return ((heightOfRoleType-literals.HEIGHT_NAME_SHAPE-literals.ROLE_CORNER_RADIUS/2)/2)+literals.HEIGHT_NAME_SHAPE;
	}	
	
	//Names
	//~~~~~
	/**
	 * matching operation for the regular expression of role type names (identifier)
	 * @param identifier the string to check against
	 * @return if the given string input matches the regular expression
	 */
	public final boolean matchesIdentifier(String identifier) {
		Matcher identifierMatcher = Pattern.compile(literals.REG_EXP_NAME).matcher(identifier);
		return identifierMatcher.matches();
	}
	
	/**
	 * matching operation for the regular expression of cardinalities
	 * @param identifier the string to check against
	 * @return if the given string input matches the regular expression
	 */
	public final boolean matchesCardinality(String cardinality) {
		Matcher cardinalityMatcher = Pattern.compile(literals.REG_EXP_CARDINALITY).matcher(cardinality);
		return cardinalityMatcher.matches();
	}
	
	/**
	 * calculates if another role type in a compartment type already has a name equivalent 
	 * to the new given name in the compartment type when direct editing names using the following steps:
	 * <p>
	 * Step 1: It gets the compartments diagram.<br>
	 * Step 2: It fetches a list of the model element names for the given type and checks if this list contains
	 * 		   the new name.
	 * <p>
	 * @param diagram the diagram that is direct edited
	 * @param type the type to the check for if a model element of that type already has the same name
	 * @param newName the name to check against
	 * @return boolean if another model element of a given type already has the same name when direct editing
	 */
	public boolean nameAlreadyUsedForCompartmentTypeElements(Diagram diagram, String newName) {
		List<String> compartmentsElements = new ArrayList<String>();
		//Step 1
		Model compartmentsModel = DiagramUtil.getLinkedModelForDiagram(diagram);
		//Step 2
		getModelElementsNames(compartmentsModel, compartmentsElements);
		return compartmentsElements.contains(newName);
	}
	
	/**
	 * calculates the standard name of a element of a compartment type which should be unique named compartment wide
	 * when creating one
	 * <p>
	 * Standard names of compartment types in a compartment type are calculated by  {@link #calculateStandardNameForClass},
	 * since they need to be unique named over all compartment types in the while role model.
	 * <p>
	 * The standard name will be build by using a given standard name and adding a number as suffix to it
	 * if needed. The limit of this number is set in {@link #STANDART_NAMES_COUNTER_LIMIT}.
	 * @param diagram the diagram in that compartment type element is added
	 * @param type the type to the check for if a model element with the standard name already exists
	 * @param standardName the normally used standard name for the compartment type element
	 * @return
	 */
	public String calculateStandardNameForCompartmentsTypeElement(Diagram diagram) {
		List<String> compartmentsElements = new ArrayList<String>();
		Model compartmentModel = DiagramUtil.getLinkedModelForDiagram(diagram);
		getModelElementsNames(compartmentModel, compartmentsElements);
		if(!(compartmentsElements.contains(literals.STANDARD_NAME))) return literals.STANDARD_NAME;
		for(int i=1; i<=literals.STANDARD_NAMES_COUNTER_LIMIT; i++) {
			if(!(compartmentsElements.contains(literals.STANDARD_NAME + Integer.toString(i))))
				return literals.STANDARD_NAME + Integer.toString(i);
		}
		return literals.STANDARD_NAME;
 	}
	
	/**
	 * fetches all names of model elements only of the given model of a given type in a recursive manner
	 * @param model the model to fetch the model elements names from
	 * @param type the type of the model elements to get the names from
	 * @param modelElementNames the list of model element names to fill
	 */
	private void getModelElementsNames(Model model, List<String> modelElementNames) {
		for(ModelElement modelElement : model.getElements()) {
			if(modelElement.getType() == Type.ROLE_TYPE)  
				modelElementNames.add(modelElement.getName());
		}	
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
					if(UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_ROLETYPE_NAME)) {
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
					if(UIUtil.isShape_IdValue(innerContainerShape, literals.SHAPE_ID_ROLETYPE_ATTRIBUTECONTAINER)) {
						for(Shape attributeShape : innerContainerShape.getChildren()) {
							if(UIUtil.isShape_IdValue(attributeShape, aaoReference.SHAPE_ID_ATTRIBUTE_TEXT)) {
								Text text = (Text) attributeShape.getGraphicsAlgorithm();
								pictogrammAttributeNames.add(text.getValue());
		}	}	}	}	}	}
		return pictogrammAttributeNames;
	}
	
	/**
	 * fetches the shown occurrence constraint of a role type or role group by its given type body shape
	 * @param pictogramElement the pictogram element to get the shown occurrence constraint for
	 * @return the value of the occurrence constraint if it can be found
	 */
	public String getOccurenceConstraintOfPictogramElement(PictogramElement pictogramElement) {
		if(pictogramElement instanceof Shape) {
			Shape shape = (Shape) pictogramElement;
			for(Shape containerChild : shape.getContainer().getChildren()) {
				if(PropertyUtil.isShape_IdValue(containerChild, literals.SHAPE_ID_ROLETYPE_OCCURRENCE_CONSTRAINT))
					return ((Text) containerChild.getGraphicsAlgorithm()).getValue();
		}	}
		return null;
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
					if(UIUtil.isShape_IdValue(innerContainerShape, literals.SHAPE_ID_ROLETYPE_ATTRIBUTECONTAINER)) {
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
					if(UIUtil.isShape_IdValue(innerContainerShape, literals.SHAPE_ID_ROLETYPE_OPERATIONCONTAINER)) {
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
					if(UIUtil.isShape_IdValue(innerContainerShape, literals.SHAPE_ID_ROLETYPE_OPERATIONCONTAINER)) {
						for(Shape operationShape : innerContainerShape.getChildren()) {
							if(UIUtil.isShape_IdValue(operationShape, aaoReference.SHAPE_ID_OPERATION_TEXT)) {	
								NamedElement operation = (NamedElement) UIUtil.getBusinessObjectForPictogramElement(operationShape);
								businessOperationNames.add(operation.getName());
		}	}	}	}	}	}	
		return businessOperationNames;
	}
	
	/**
	 * get the occurrence constraint of a role type or role group in the business model
	 * @param businessObject the business object to get occurrence constraint for
	 * @return the occurrence constraint value
	 */
	public String getOccurrenceConstraintOfBusinessObject(Object businessObject) {
		if (businessObject instanceof org.framed.iorm.model.Shape) {
			org.framed.iorm.model.Shape shape = (org.framed.iorm.model.Shape) businessObject;
			return shape.getDescription().getName();
		}
		return null;
	}	
}
