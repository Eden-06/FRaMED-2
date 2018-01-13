package org.framed.iorm.ui.references;

/**
 * the abstract super class for a reference which encapsulates the dependency of the pattern that uses the attributes and operations to 
 * the corresponding attribute and operation feature module
 */
public abstract class AbstractAttributeAndOperationReference {
	
	/**
	  * shape ids from the attribute and operation feature
	  */
	public String SHAPE_ID_ATTRIBUTE_INDICATOR_DOTS,
	 		 	  SHAPE_ID_OPERATION_INDICATOR_DOTS,
	 		 	  SHAPE_ID_ATTRIBUTE_TEXT,
	 		 	  SHAPE_ID_OPERATION_TEXT; 

	/**
	 * layout integers from the attribute and operation feature
	 */
	public int HEIGHT_ATTRIBUTE_SHAPE,
			   HEIGHT_OPERATION_SHAPE;

	/**
	 * reason messages for attributes and operations
	 */
	public String REASON_AMOUNT_ATTRIBUTES,
				  REASON_AMOUNT_OPERATION,
				  REASON_NAMES_ATTRIBUTES,
				  REASON_NAMES_OPERATIONS;
	
}

