package attributeAndOperation;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.UIUtil;

import attributeAndOperation.references.AbstractUsedInReference;

/**
 * This class offers utility operations in the scope of the attribute and operations feature module.
 * @author Kevin Kassin
 */
public class Util {
	
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
}
