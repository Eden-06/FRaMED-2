package relationship.references;

import java.util.ArrayList;
import java.util.List;

import org.framed.iorm.model.Type;

public class TypeReferences {

	/**
	 * the list of types for which a inheritance is applicable
	 */
	List<Type> types = new ArrayList<Type>();
		
	/**
	 * class constructor
	 */
	public TypeReferences() {
		types.add(Type.ROLE_TYPE);
	}
	
	/**
	 * @return the types for which a inheritance is applicable
	 */
	public List<Type> getTypes() {
		return types;
	}
}
