package inheritance.references;

import java.util.ArrayList;
import java.util.List;

import org.framed.iorm.model.Type;

/**
 * This reference class captures which for which model types a inheritance is applicable
 * @author Kevin Kassin
 */
public class TypeReferences {
	
	/**
	 * the list of types for which a inheritance is applicable
	 */
	List<Type> types = new ArrayList<Type>();
	
	/**
	 * class constructor
	 */
	public TypeReferences() {
		types.add(Type.NATURAL_TYPE);
		types.add(Type.DATA_TYPE);
		types.add(Type.COMPARTMENT_TYPE);
		types.add(Type.ROLE_TYPE);
	}
	
	/**
	 * @return the types for which a inheritance is applicable
	 */
	public List<Type> getTypes() {
		return types;
	}
}
