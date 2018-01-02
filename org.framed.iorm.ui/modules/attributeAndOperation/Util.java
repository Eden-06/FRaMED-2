package attributeAndOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;

import attributeAndOperation.Literals;

public class Util {

	/**
	 * the object to get names, id and so on for this feature
	 */
	private final Literals literals = new Literals();
	
	//Names
	//~~~~~
	/**
	 * matching operation for the regular expression of attributes
	 * @param attributeName the string to check against
	 * @return if the given string input matches the regular expression
	 */
	public final boolean matchesAttribute(String attributeName) {
		Matcher attributeMatcher = Pattern.compile(literals.ATT_REG_EXP_NAME).matcher(attributeName);
		return attributeMatcher.matches();
	}
	
	/**
	 * matching operation for the regular expression of operations
	 * @param operationName the string to check against
	 * @return if the given string input matches the regular expression
	 */
	public final boolean matchesOperation(String operationName) {
		Matcher operationMatcher = Pattern.compile(literals.OPS_REG_EXP_NAME).matcher(operationName);
		return operationMatcher.matches();
	}
	
	/**
	 * calculates if another attribute or operation in the same class or role already have the same name when 
	 * direct editing names of attributes or operations 
	 * @param attributeOrOperationsContainer the container to search the other attributes or operations to check against
	 * @param newName the name to check against
	 * @return boolean if another attribute or operation in the same class or role already has the same name when 
	 * 		   direct editing
	 */
	public boolean nameAlreadyUsedForAttributeOrOperation(ContainerShape attributeOrOperationsContainer, String newName) {
		List<String> attributeOrOperationNames = new ArrayList<String>();
		for(Shape shape : attributeOrOperationsContainer.getChildren()) {
			attributeOrOperationNames.add(((Text) shape.getGraphicsAlgorithm()).getValue());
		}
		return attributeOrOperationNames.contains(newName);
	}
	
	/**
	 * calculates the standard name of an attribute when creating one
	 * <p>
	 * The standard name will be build by using a given standard name and adding a number as suffix to it
	 * if needed. The limit of this number is set in {@link Literals#STANDARD_NAMES_COUNTER_LIMIT}.
	 * @param attributeContainer the container to search the other attributes to check for
	 * 		  already used standard names
	 * @return a not yet used standard name
	 */
	public String calculateStandardNameForAttribute(ContainerShape attributeContainer) {
		List<String> attributeNames = new ArrayList<String>();
		for(Shape shape : attributeContainer.getChildren()) {
			attributeNames.add(((Text) shape.getGraphicsAlgorithm()).getValue());
		}
		if(!(attributeNames.contains(literals.ATT_STANDARD_NAME))) return literals.ATT_STANDARD_NAME;
		for(int i=1; i<=literals.STANDARD_NAMES_COUNTER_LIMIT; i++) {
			if(!(attributeNames.contains(literals.ATT_STANDARD_NAME + Integer.toString(i))))
				return literals.ATT_STANDARD_NAME + Integer.toString(i);
		}
		return literals.ATT_STANDARD_NAME;
	}
	
	/**
	 * calculates the standard name of an operation when creating one
	 * <p>
	 * The standard name will be build by using a given standard name and adding a number as suffix to it
	 * if needed. The limit of this number is set in {@link Literals#STANDARD_NAMES_COUNTER_LIMIT}.
	 * @param attributeOrOperationsContainer the container to search the other attributes or operations to check for
	 * 		  already used standard names
	 * @return a not yet used standard name
	 */
	public String calculateStandardNameForOperation(ContainerShape operationContainer) {
		List<String> operationNames = new ArrayList<String>();
		for(Shape shape : operationContainer.getChildren()) {
			operationNames.add(((Text) shape.getGraphicsAlgorithm()).getValue());
		}
		if(!(operationNames.contains(literals.OPS_STANDARD_NAME))) return literals.OPS_STANDARD_NAME;
		for(int i=1; i<=literals.STANDARD_NAMES_COUNTER_LIMIT; i++) {
			if(!(operationNames.contains(literals.OPS_STANDARD_NAME + Integer.toString(i))))
				return literals.OPS_STANDARD_NAME + Integer.toString(i);
		}
		return literals.OPS_STANDARD_NAME;
	}
}
