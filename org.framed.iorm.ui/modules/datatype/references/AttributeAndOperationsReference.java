package datatype.references;

import attributeAndOperation.Literals;

/**
 * a reference class which encapsulates the dependency of the datatype pattern to the attribute and operation features
 */
public class AttributeAndOperationsReference {
	
	/**
	 *  the object to get names, ids for the attribute and operation feature
	 */
	 private final Literals att_ops_literal = new Literals();
	 
	/**
	 * shorthand definitions for the used literals from the attribute and operation features 
	 */
	 public final String SHAPE_ID_ATTRIBUTE_INDICATOR_DOTS = att_ops_literal.SHAPE_ID_ATTRIBUTE_INDICATOR_DOTS,
			 			 SHAPE_ID_OPERATION_INDICATOR_DOTS = att_ops_literal.SHAPE_ID_OPERATION_INDICATOR_DOTS,
			 			 SHAPE_ID_ATTRIBUTE_TEXT = att_ops_literal.SHAPE_ID_ATTRIBUTE_TEXT,
			 			 SHAPE_ID_OPERATION_TEXT = att_ops_literal.SHAPE_ID_OPERATION_TEXT;
}
