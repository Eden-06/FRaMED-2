package relationship;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.framed.iorm.model.Model;
import org.framed.iorm.model.ModelElement;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.util.DiagramUtil;

public class Util {

	/**
	 * the object to get names, ids and so on for this feature
	 */
	Literals literals = new Literals();
	
	/**
	 * calculates if another relationship in a compartment type already has a name equivalent 
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
			if(modelElement.getType() == Type.RELATIONSHIP)  
				modelElementNames.add(modelElement.getName());
		}	
	}
	
	/**
	 * matching operation for the regular expression of relationship names (identifier)
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
	
}
