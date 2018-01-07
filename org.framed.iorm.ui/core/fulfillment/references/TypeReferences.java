package fulfillment.references;

import java.util.ArrayList;
import java.util.List;

import org.framed.iorm.model.Type;

/**
* encapsulates the types for which a fulfillment is applicable
* @author Kevin Kassin
*/
public class TypeReferences {

	/**
	 * the lists of types for which a fulfillment is applicable
	 */
	List<Type> sourceTypes = new ArrayList<Type>(),
			   targetTypes = new ArrayList<Type>();
		
	/**
	 * class constructor
	 */
	public TypeReferences() {
		sourceTypes.add(Type.NATURAL_TYPE);
		sourceTypes.add(Type.DATA_TYPE);
		sourceTypes.add(Type.COMPARTMENT_TYPE);
		sourceTypes.add(Type.ROLE_TYPE);
		targetTypes.add(Type.COMPARTMENT_TYPE);
	}
	
	/**
	 * @return the types for which a fulfillment is applicable as source
	 */
	public List<Type> getSourceTypes() {
		return sourceTypes;
	}
	
	/**
	 * @return the types for which a fulfillment is applicable as target
	 */
	public List<Type> getTargetTypes() {
		return targetTypes;
	}
}
