package relationship.references;

import java.util.ArrayList;
import java.util.List;

import org.framed.iorm.model.Type;

/**
* encapsulates the types for which a fulfillment is applicable
* @author Kevin Kassin
*/
public class TypeReferences {

	/**
	 * the list of types for which a realtionship is applicable
	 */
	List<Type> types = new ArrayList<Type>();
		
	/**
	 * class constructor
	 */
	public TypeReferences() {
		types.add(Type.ROLE_TYPE);
	}
	
	/**
	 * @return the types for which a relationship is applicable
	 */
	public List<Type> getTypes() {
		return types;
	}
}
