package attributeAndOperation;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.UIUtil;

import attributeAndOperation.references.AbstractUsedInReference;

/**
 * This class offers utility operations in the scope of the attribute and operations feature module.
 * @author Kevin Kassin
 */
public class Util {
	
	/**
	 * attribute and operation literals
	 */
	Literals literals = new Literals();
	
	//usedInReferences
	//~~~~~~~~~~~~~~~~
	/**
	 * get all sub classes of {@link AbstractUsedInReference} for a given list of classes 
	 * @param classes a given list of classes of different types
	 * @return a list of classes have {@link AbstractUsedInReference} as their super class
	 */
	public List<AbstractUsedInReference> getUsedInReferences(List<Class<?>> classes) {
		List<AbstractUsedInReference> usedInReferences = new ArrayList<AbstractUsedInReference>();
		for(Class<?> cl : classes) {
			if(!Modifier.isAbstract(cl.getModifiers())) {
				if(UIUtil.getSuperClasses(cl).contains(AbstractUsedInReference.class)) {
					try {
						Object object = cl.newInstance();
						usedInReferences.add((AbstractUsedInReference) object);
					} catch (InstantiationException | IllegalAccessException e) { e.printStackTrace(); }
		} 	}	}
		return usedInReferences;
	}
	
	/**
	 * fetches a list of {@link Type}s referenced in the given list of sub classes of {@link AbstractUsedInReference}s.
	 * @param usedInReferences the references to get the types of
	 * @return a list of types referenced in the elements of the parameter
	 */
	public List<Type> usedInModelTypes(List<AbstractUsedInReference> usedInReferences) {
		List<Type> modelTypes = new ArrayList<Type>();
		for(AbstractUsedInReference auir : usedInReferences) {
			modelTypes.add(auir.getModelType());
		}
		return modelTypes;
	}
	
	//direct editing
	//~~~~~~~~~~~~~~
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
	 * calculates the standard name of an attribute or operation when creating one
	 * <p>
	 * The standard name will be build by using a given standard name and adding a number as suffix to it
	 * if needed. The limit of this number is set in {@link #STANDART_NAMES_COUNTER_LIMIT}.
	 * @param attributeOrOperationsContainer the container to search the other attributes or operations to check for
	 * 		  already used standard names
	 * @param standardName the normally used standard name for the attribute or operation
	 * @return
	 */
	public String calculateStandardNameForAttributeOrOperation(ContainerShape attributeOrOperationsContainer, String standardName) {
		List<String> attributeOrOperationNames = new ArrayList<String>();
		for(Shape shape : attributeOrOperationsContainer.getChildren()) {
			attributeOrOperationNames.add(((Text) shape.getGraphicsAlgorithm()).getValue());
		}
		return UIUtil.calcluateStandardNameForGivenCollection(attributeOrOperationNames, standardName);
	}
	
	/**
	 * matching operation for the regular expression of operations
	 * @param identifier the string to check against
	 * @return if the given string input matches the regular expression
	 */
	public final boolean matchesAttribute(String attributeName) {
		Matcher attributeMatcher =  Pattern.compile(literals.ATT_REG_EXP_NAME).matcher(attributeName);
		return attributeMatcher.matches();
	}
	
	/**
	 * matching operation for the regular expression of operations
	 * @param identifier the string to check against
	 * @return if the given string input matches the regular expression
	 */
	public final boolean matchesOperation(String operationName) {
		Matcher operationMatcher =  Pattern.compile(literals.OPS_REG_EXP_NAME).matcher(operationName);
		return operationMatcher.matches();
	}
	
}
