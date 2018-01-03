package core.roletype.references;

import attributeAndOperation.Literals;

/**
 * a reference class which encapsulates the dependency of the natural type pattern to the attribute and operation features
 */
public class AttributeAndOperationsReference {
	
	/**
	 *  the object to get names, ids for the attribute and operation feature
	 */
	 private final Literals att_ops_literal = new Literals();
	 
	 /**
	  * shape ids from the attribute and operation feature
	  */
	 public final String SHAPE_ID_ATTRIBUTE_INDICATOR_DOTS = att_ops_literal.SHAPE_ID_ATTRIBUTE_INDICATOR_DOTS,
				 		 SHAPE_ID_OPERATION_INDICATOR_DOTS = att_ops_literal.SHAPE_ID_OPERATION_INDICATOR_DOTS,
						 SHAPE_ID_ATTRIBUTE_TEXT = att_ops_literal.SHAPE_ID_ATTRIBUTE_TEXT,
				 		 SHAPE_ID_OPERATION_TEXT = att_ops_literal.SHAPE_ID_OPERATION_TEXT;
		 
	 /**
	  * layout integers from the attribute and operation feature
	  */
	 public final int HEIGHT_ATTRIBUTE_SHAPE = att_ops_literal.HEIGHT_ATTRIBUTE_SHAPE,
			 		  HEIGHT_OPERATION_SHAPE = att_ops_literal.HEIGHT_OPERATION_SHAPE;
	 
	 /**
	  * reason messages for attributes and operations
	  */
	public final String REASON_AMOUNT_ATTRIBUTES = att_ops_literal.REASON_AMOUNT_ATTRIBUTES,
						REASON_AMOUNT_OPERATION = att_ops_literal.REASON_AMOUNT_OPERATION,
						REASON_NAMES_ATTRIBUTES = att_ops_literal.REASON_NAMES_ATTRIBUTES,
						REASON_NAMES_OPERATIONS = att_ops_literal.REASON_NAMES_OPERATIONS;
}
