package attributeAndOperation;

import org.framed.iorm.ui.references.AbstractAttributeAndOperationReference;

/**
 * a reference class which encapsulates the dependency of the pattern that uses the attributes and operations to this feature
 * module
 */
public class AttributeAndOperationReference extends AbstractAttributeAndOperationReference {
	
	/**
	 *  the object to get names, ids for the attribute and operation feature
	 */
	 private final Literals literals = new Literals();
	 
	 /**
	  * class constructor
	  */
	 public AttributeAndOperationReference() {
		 SHAPE_ID_ATTRIBUTE_INDICATOR_DOTS = literals.SHAPE_ID_ATTRIBUTE_INDICATOR_DOTS;
		 SHAPE_ID_OPERATION_INDICATOR_DOTS = literals.SHAPE_ID_OPERATION_INDICATOR_DOTS;
		 SHAPE_ID_ATTRIBUTE_TEXT = literals.SHAPE_ID_ATTRIBUTE_TEXT;
		 SHAPE_ID_OPERATION_TEXT = literals.SHAPE_ID_OPERATION_TEXT;
		 HEIGHT_ATTRIBUTE_SHAPE = literals.HEIGHT_ATTRIBUTE_SHAPE;
		 HEIGHT_OPERATION_SHAPE = literals.HEIGHT_OPERATION_SHAPE;
		 REASON_AMOUNT_ATTRIBUTES = literals.REASON_AMOUNT_ATTRIBUTES;
		 REASON_AMOUNT_OPERATION = literals.REASON_AMOUNT_OPERATION;			
		 REASON_NAMES_ATTRIBUTES = literals.REASON_NAMES_ATTRIBUTES;
		 REASON_NAMES_OPERATIONS = literals.REASON_NAMES_OPERATIONS;
	 }
}
