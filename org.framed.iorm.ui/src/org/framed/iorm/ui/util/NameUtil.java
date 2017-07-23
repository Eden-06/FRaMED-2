package org.framed.iorm.ui.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern; 
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.framed.iorm.model.Model;
import org.framed.iorm.model.ModelElement;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.wizards.RoleModelProjectWizard; //*import for javadoc link
import org.framed.iorm.ui.wizards.RoleModelWizard; //*import for javadoc link

/**
 * This class is used to check names when direct editing shapes and connection for their validity. 
 * {@link RoleModelWizard} and {@link RoleModelProjectWizard} also use this class to check the names 
 * of project and file names.
 * @author Kevin Kassin
 */
public class NameUtil {
	
	/**
	 * the limit of the suffix for standard names
	 * <p>
	 * This means that if the limit is 10 the following standard names are used:<br>
	 * <em>standardName</em><br>
	 * <em>standardName1</em><br>
	 * <em>...</em><br>
	 * <em>standardName10</em><br>
	 */
	private final static int STANDART_NAMES_COUNTER_LIMIT = 10;
	
	/**
	 * regular expression for identifiers:
	 * <p>
	 * string of letters and digits, first is no digit (for names)
	 */
	private static final String identifier = "[a-zA-Z_$][a-zA-Z\\d_$]*"; 
	
	/**
	 * regular expression for qualified identifiers
	 * <p>
	 * full classes: (N.)*N (for types)
	 */
	private static final String qualifiedIdentifier = "(" + identifier + "\\.)*" + identifier; 
	
	/**
	 * regular expression for cardinalities
	 * <p>
	 * (integer|"*")[".."(integer|"*")]
	 */
	private static final String cardinality = "(\\d+|\\*)(\\.\\.(\\d+|\\*))?"; 
	
	/**
	 * regular expression for attributes
	 * <p>
	 * name:type
	 */
	private static final String attribute = identifier + ":" + qualifiedIdentifier; 
	
	/**
	 * regular expression for parameters
	 * <p> 
	 * name:type
	 */
	private static final String parameter = attribute; 
	
	/**
	 * regular expression for operations
	 * <p>
	 * name"("[Parameter(","Parameter)*]"):"type, return type is optional
	 */
	private static final String operation = identifier + "\\((" + parameter + "(," + parameter + ")*)?\\)(:" + qualifiedIdentifier + ")?";
	
	/**
	 * regular expression for role groups
	 * <p>
	 * name [ "(" cardinality ")" ]
	 */
	private static final String rolegroup = identifier +"([ ]*[(]"+ cardinality +"[)])?"; 

	/**
	 * patterns to check for the regular expression of this class
	 * <p>
	 * can be:<br>
	 * (1) the pattern for identifiers or<br>
	 * (2) the pattern for attributes or<br>
	 * (3) the pattern for operations or<br>
	 * (4) the pattern for cardinalities
	 */
	private static final Pattern identifierPattern = Pattern.compile(identifier),
								 attributePattern = Pattern.compile(attribute),
								 operationPattern = Pattern.compile(operation),
								 cardinalityPattern = Pattern.compile(cardinality);
	
	/**
	 * matching operation for the regular expression of identifiers
	 * @param identifier the string to check against
	 * @return if the given string input matches the regular expression
	 */
	public static final boolean matchesIdentifier(String identifier) {
		Matcher identifierMatcher = identifierPattern.matcher(identifier);
		return identifierMatcher.matches();
	}
	
	/**
	 * matching operation for the regular expression of attributes
	 * @param identifier the string to check against
	 * @return if the given string input matches the regular expression
	 */
	public static final boolean matchesAttribute(String attributeName) {
		Matcher attributeMatcher = attributePattern.matcher(attributeName);
		return attributeMatcher.matches();
	}
	
	/**
	 * matching operation for the regular expression of operations
	 * @param identifier the string to check against
	 * @return if the given string input matches the regular expression
	 */
	public static final boolean matchesOperation(String operationName) {
		Matcher operationMatcher = operationPattern.matcher(operationName);
		return operationMatcher.matches();
	}
	
	/**
	 * matching operation for the regular expression of cardinalities
	 * @param identifier the string to check against
	 * @return if the given string input matches the regular expression
	 */
	public static final boolean matchesCardinality(String cardinality) {
		Matcher cardinalityMatcher = cardinalityPattern.matcher(cardinality);
		return cardinalityMatcher.matches();
	}
	
	/**
	 * calculates if another model element of a specific {@link org.framed.iorm.model.Type} already has a name equivalent 
	 * to the new given name when direct editing names using the following steps:
	 * <p>
	 * Step 1: It gets the <em>main diagram</em> of the role model that the given diagram belongs to.<br>
	 * Step 2: It fetches a list of the model element names for the given type and checks if this list contains
	 * 		   the new name.
	 * <p>
	 * If its not clear what <em>main diagram</em> means, see {@link RoleModelWizard#createEmfFileForDiagram} for reference.
	 * @param diagram the diagram that is direct edited
	 * @param type the type to the check for if a model element of that type already has the same name
	 * @param newName the name to check against
	 * @return boolean if another model element of a given type already has the same name when direct editing
	 */
	public static boolean nameAlreadyUsedForClass(Diagram diagram, Type type, String newName) {
		List<String> modelElements = new ArrayList<String>();
		//Step 1
		Model rootModel = DiagramUtil.getRootModelForAnyDiagram(diagram);
		//Step 2
		getModelElementsNamesRecursive(rootModel, type, modelElements);
		return modelElements.contains(newName);
	}
	
	/**
	 * calculates if another model element in a comparment type already has a name equivalent 
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
	public static boolean nameAlreadyUsedForCompartmentTypeElements(Diagram diagram, Type type, String newName) {
		List<String> compartmentsElements = new ArrayList<String>();
		//Step 1
		Model compartmentsModel = DiagramUtil.getLinkedModelForDiagram(diagram);
		//Step 2
		getModelElementsNames(compartmentsModel, type, compartmentsElements);
		return compartmentsElements.contains(newName);
	}
			
	/**
	 * calculates if another attribute or operation in the same class or role already have the same name when 
	 * direct editing names of attributes or operations 
	 * @param attributeOrOperationsContainer the container to search the other attributes or operations to check against
	 * @param newName the name to check against
	 * @return boolean if another attribute or operation in the same class or role already has the same name when 
	 * 		   direct editing
	 */
	public static boolean nameAlreadyUsedForAttributeOrOperation(ContainerShape attributeOrOperationsContainer, String newName) {
		List<String> attributeOrOperationNames = new ArrayList<String>();
		for(Shape shape : attributeOrOperationsContainer.getChildren()) {
			attributeOrOperationNames.add(((Text) shape.getGraphicsAlgorithm()).getValue());
		}
		return attributeOrOperationNames.contains(newName);
	}
	
	/**
	 * calculates the standard name of a class ({@link Type#NATURAL_TYPE} for example) when creating one
	 * <p>
	 * The standard name will be build by using a given standard name and adding a number as suffix to it
	 * if needed. The limit of this number is set in {@link #STANDART_NAMES_COUNTER_LIMIT}.
	 * @param diagram the diagram in that a class is added
	 * @param type the type to the check for if a model element with the a standard name already exists
	 * @param standardName the normally used standard name for the class
	 * @return
	 */
	public static String calculateStandardNameForClass(Diagram diagram, Type type, String standardName) {
		List<String> modelElements = new ArrayList<String>();
		Model rootModel = DiagramUtil.getRootModelForAnyDiagram(diagram);
		getModelElementsNamesRecursive(rootModel, type, modelElements);
		return calcluateStandardNameForGivenCollection(modelElements, standardName);
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
	public static String calculateStandardNameForCompartmentsTypeElement(Diagram diagram, Type type, String standardName) {
		List<String> compartmentsElements = new ArrayList<String>();
		Model compartmentModel = DiagramUtil.getLinkedModelForDiagram(diagram);
		getModelElementsNames(compartmentModel, type, compartmentsElements);
		return calcluateStandardNameForGivenCollection(compartmentsElements, standardName);
 	}
	
	/**
	 * calculates the standard name of an attribute or operation when creating one
	 * <p>
	 * The standard name will be build by using a given standard name and adding a number as suffix to it
	 * if needed. The limit of this number is set in {@link #STANDART_NAMES_COUNTER_LIMIT}.
	 * @param attributeOrOperationsContainer the container to search the other attributes or operations to check for
	 * 		  already used standard names
	 * @param standardName the normally used standard name for the attribute or operation
	 * @return
	 */
	public static String calculateStandardNameForAttributeOrOperation(ContainerShape attributeOrOperationsContainer, String standardName) {
		List<String> attributeOrOperationNames = new ArrayList<String>();
		for(Shape shape : attributeOrOperationsContainer.getChildren()) {
			attributeOrOperationNames.add(((Text) shape.getGraphicsAlgorithm()).getValue());
		}
		return calcluateStandardNameForGivenCollection(attributeOrOperationNames, standardName);
	}
	
	/**
	 * fetches all names of model elements only of the given model of a given type in a recursive manner
	 * @param model the model to fetch the model elements names from
	 * @param type the type of the model elements to get the names from
	 * @param modelElementNames the list of model element names to fill
	 */
	private static void getModelElementsNames(Model model, Type type, List<String> modelElementNames) {
		for(ModelElement modelElement : model.getElements()) {
			if(modelElement.getType() == type)  
				modelElementNames.add(modelElement.getName());
		}	
	}
	
	/**
	 * fetches all names of model elements of the given model and its sub models of a given type in a recursive manner
	 * @param model the model to fetch the model elements names from
	 * @param type the type of the model elements to get the names from
	 * @param modelElementNames the list of model element names to fill while using recursion
	 */
	private static void getModelElementsNamesRecursive(Model model, Type type, List<String> modelElementNames) {
		for(ModelElement modelElement : model.getElements()) {
			if(modelElement.getType() == type)  
				modelElementNames.add(modelElement.getName());
			if(modelElement.getType() == Type.COMPARTMENT_TYPE ||
			   modelElement.getType() == Type.GROUP) 
				getModelElementsNamesRecursive(((org.framed.iorm.model.Shape) modelElement).getModel(), type, modelElementNames);
	}	}
	
	/**
	 * calculates a standard name checking a given collection if an equivalent name already exists in that collection
	 * <p>
	 * The standard name will be build by using a given standard name and adding a number as suffix to it
	 * if needed. The limit of this number is set in {@link #STANDART_NAMES_COUNTER_LIMIT}.
	 * @param collection
	 * @param standardName
	 * @return
	 */
	private static String calcluateStandardNameForGivenCollection(List<String> collection, String standardName) {
		if(!(collection.contains(standardName))) return standardName;
		for(int i=1; i<=STANDART_NAMES_COUNTER_LIMIT; i++) {
			if(!(collection.contains(standardName + Integer.toString(i))))
				return standardName + Integer.toString(i);
		}
		return standardName;
	}
}
