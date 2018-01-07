package org.framed.iorm.ui.util;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.features.IMappingProvider;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.framed.iorm.model.Model;
import org.framed.iorm.model.ModelElement;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.exceptions.NoFeatureForPatternFound;
import org.framed.iorm.ui.exceptions.NoLinkedModelYet;
import org.framed.iorm.ui.exceptions.NoModelFoundException;
import org.framed.iorm.ui.literals.UILiterals;
import org.framed.iorm.ui.providers.ToolBehaviorProvider;
import org.framed.iorm.ui.wizards.RoleModelWizard;
import org.osgi.framework.Bundle;

/**
 * This class offers utility operations in the scope of the UI. Modules can use these operations if they want to,
 * e.g. for UI specific aspects like diagrams, models and the property service.
 * @author Kevin Kassin
 */
public class UIUtil {

	/**
	 * gets all superclasses of a given class in a list
	 * @param class 
	 * @return
	 */
	public static List<Class<?>> getSuperClasses(Class<?> cl) {
		List<Class<?>> classList = new ArrayList<Class<?>>();	
		Class<?> superclass = cl.getSuperclass();
		if(superclass != null) {	
			classList.add(superclass);
			while (superclass != null) {   
				cl = superclass;
			    superclass = cl.getSuperclass();
			    classList.add(superclass);
		}	}	
		return classList;
	}
	
	//Model
	//~~~~~
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
	 * helper method to get the {@link ModelElement} for a given anchor
	 * @param anchor the anchor that belongs to the model element to get
	 * @return the model element that has the give anchor
	 */
	public static org.framed.iorm.model.ModelElement getModelElementForAnchor(Anchor anchor) {
		Object object = null;
		if (anchor != null) { object = GeneralUtil.getBusinessObjectForPictogramElement(anchor.getParent()); }
		if (object != null) {
			if (object instanceof org.framed.iorm.model.Shape)
				return (org.framed.iorm.model.Shape) object;
			if (object instanceof org.framed.iorm.model.Relation)
				return (org.framed.iorm.model.Relation) object;
		}
		return null;
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
			   PropertyUtil.isDiagram_KindValue((Diagram) shape, UILiterals.DIAGRAM_KIND_MAIN_DIAGRAM)) {
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
	 * returns the first linked business object of a pictogram
	 * <p>
	 * This operation is build after method {@link IMappingProvider#getBusinessObjectForPictogramElement} to avoid
	 * a dependency.<br>
	 * This is a convenience method for getAllBusinessObjectsForPictogramElement(PictogramElement), because in many 
	 * usecases only a single business object is linked.
	 * @param pictogramElement the pictogram element to get business object for
	 * @return the first business object of a pictogram element
	 */
	public static EObject getBusinessObjectForPictogramElement(PictogramElement pictogramElement) {
		return pictogramElement.getLink().getBusinessObjects().get(0);
	}
	
	//features
	//~~~~~~~~
	/**
	 * finds a feature by its name in an array of general features
	 * @param array the array with features to search in
	 * @param featureName the name of the feature to find
	 * @return the found feature or throw exceptions {@link NoFeatureForPatternFound} if it was not found
	 */
	public static IFeature findFeatureByName(IFeature[] array, String featureName) {
		for(int i = 0; i<array.length; i++) {
			if(array[i].getName().equals(featureName)) 
				return array[i];
		}	
		throw new NoFeatureForPatternFound(featureName);
	}
	
	//finding pattern dynamically
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * fetches all java classes in the module source folder
	 * @return all java classes in in the module source folder
	 */
	public static List<Class<?>> findModuleJavaClasses() {
		Bundle bundle = Platform.getBundle("org.framed.iorm.ui");
	    List<URL> moduleClassURLs = Collections.list(bundle.findEntries("/modules", "*.java", true));
	    List<URL> coreClassURLs = Collections.list(bundle.findEntries("/core", "*.java", true));
	    List<Class<?>> patternClasses = new ArrayList<Class<?>>();
	    for(URL classURL : moduleClassURLs) {
	    	try {
	    		Class<?> classForPattern = Class.forName(formatModuleURL(classURL.toString()));
	    		patternClasses.add(classForPattern);
			} catch (ClassNotFoundException e) { e.printStackTrace(); }
	    }
	    for(URL classURL : coreClassURLs) {
	    	try {
	    		Class<?> classForPattern = Class.forName(formatCoreURL(classURL.toString()));
	    		patternClasses.add(classForPattern);
			} catch (ClassNotFoundException e) { e.printStackTrace(); }
	    }
	    return patternClasses;
	}
	
	/**
	 * formats the given string url by cutting and replacing character in specific manner
	 * @param patternURL the string url to format
	 * @return the formatted string url
	 */
	public static String formatModuleURL(String patternURL) {
		int cutStart = patternURL.indexOf("modules/")+"modules/".length(),
			cutEnd = patternURL.indexOf(".java");	
		patternURL = patternURL.substring(cutStart, cutEnd);
		return patternURL.replace("/", ".");
	}
	
	/**
	 * formats the given string url by cutting and replacing character in specific manner
	 * @param patternURL the string url to format
	 * @return the formatted string url
	 */
	public static String formatCoreURL(String patternURL) {
		int cutStart = patternURL.indexOf("core/")+"core/".length(),
			cutEnd = patternURL.indexOf(".java");	
		patternURL = patternURL.substring(cutStart, cutEnd);
		return patternURL.replace("/", ".");
	}
	
	//Properties
	//Shape Identifier
	//~~~~~~~~~~~~~~~~
	/**
	 * the key to identify the property shape id gathered from {@link IdentifierLiterals}
	 */
	public static final String KEY_SHAPE_ID = UILiterals.KEY_SHAPE_ID;
		
	/**
	 * set the property shape id for a given shape
	 * @param shape the shape to set the property for
	 * @param value the new value of the property
	 */
	public static final void setShape_IdValue(Shape shape, String value) {
		Graphiti.getPeService().setPropertyValue(shape, KEY_SHAPE_ID, value);
	}
		
	/**
	 * checks if the property shape id for a given shape equals the given value
	 * @param shape the shape to check the property for
	 * @param value the value to check the property against
	 * @return boolean if the property value equals the given value
	 */
	public static final boolean isShape_IdValue(Shape shape, String value) {
		return (Graphiti.getPeService().getPropertyValue(shape, KEY_SHAPE_ID).equals(value));
	}
	
	//Diagram Kind
	//~~~~~~~~~~~~
	/**
	 * the key to identify the property diagram kind gathered from {@link IdentifierLiterals}
	 * <P>
	 * The word <em>kind</em> is chosen to differ this property from the <em>diagram types</em> of the 
	 * graphiti framework.
	 */
	public static final String KEY_DIAGRAM_KIND = UILiterals.KEY_DIAGRAM_KIND;
	
	/**
	 * set the property diagram kind for a given diagram
	 * <P>
	 * The word <em>kind</em> is chosen to differ this property from the <em>diagram types</em> of the 
	 * graphiti framework.
	 * @param diagram the diagram to set the property for
	 * @param value the new value of the property
	 */
	public static final void setDiagram_KindValue(Diagram diagram, String value) {
		Graphiti.getPeService().setPropertyValue(diagram, KEY_DIAGRAM_KIND, value);
	}
		
	/**
	 * checks if the property diagram kind for a given graphic algorithm equals the given value
	 * <P>
	 * The word <em>kind</em> is chosen to differ this property from the <em>diagram types</em> of the 
	 * graphiti framework.
	 * @param diagram the diagram to check the property for
	 * @param value the value to check the property against
	 * @return boolean if the property value equals the given value
	 */
	public static final boolean isDiagram_KindValue(Diagram diagram, String value) {
		return (Graphiti.getPeService().getPropertyValue(diagram, KEY_DIAGRAM_KIND).equals(value));
	}	
		
	//Names
	//~~~~~
	/**
	 * matching operation for the regular expression of identifiers
	 * @param identifier the string to check against
	 * @return if the given string input matches the regular expression
	 */
	public static final boolean matchesIdentifier(String identifier) {
		Matcher identifierMatcher = Pattern.compile(UILiterals.REG_EXP_IDENTIFIER).matcher(identifier);
		return identifierMatcher.matches();
	}
	
	/**
	 * matching operation for the regular expression of operations
	 * @param identifier the string to check against
	 * @return if the given string input matches the regular expression
	 */
	public static final boolean matchesAttribute(String attributeName) {
		Matcher attributeMatcher =  Pattern.compile(UILiterals.REG_EXP_ATTRIBUTE).matcher(attributeName);
		return attributeMatcher.matches();
	}
	
	/**
	 * matching operation for the regular expression of operations
	 * @param identifier the string to check against
	 * @return if the given string input matches the regular expression
	 */
	public static final boolean matchesOperation(String operationName) {
		Matcher operationMatcher =  Pattern.compile(UILiterals.REG_EXP_OPERATION).matcher(operationName);
		return operationMatcher.matches();
	}
	
	/**
	 * matching operation for the regular expression of cardinalities
	 * @param identifier the string to check against
	 * @return if the given string input matches the regular expression
	 */
	public static final boolean matchesCardinality(String cardinality) {
		Matcher cardinalityMatcher = Pattern.compile(UILiterals.REG_EXP_CARDINALITY).matcher(cardinality);
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
		Model rootModel = UIUtil.getRootModelForAnyDiagram(diagram);
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
		Model compartmentsModel = UIUtil.getLinkedModelForDiagram(diagram);
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
		for(int i=1; i<=UILiterals.STANDARD_NAMES_COUNTER_LIMIT; i++) {
			if(!(collection.contains(standardName + Integer.toString(i))))
				return standardName + Integer.toString(i);
		}
		return standardName;
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
	}	}
		
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
}
