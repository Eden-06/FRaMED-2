package org.framed.iorm.ui.util;

import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.framed.iorm.ui.literals.IdentifierLiterals;

/**
 * This class delivers operations to change and access specific properties graphiti model elements.
 * <p>
 * It can change and access the property "shape-id" for {@link GraphicsAlgorithm}s. 
 * @author Kevin Kassin
 */
public class PropertyUtil {
	
	//Shape Identifier
	//~~~~~~~~~~~~~~~~
	/**
	 * the key to identify the property shape id gathered from {@link IdentifierLiterals}
	 */
	public static final String KEY_SHAPE_ID = IdentifierLiterals.KEY_SHAPE_ID;
	
	/**
	 * set the property shape id for a given shape
	 * @param shape the shape to set the property for
	 * @param value the new value of the property
	 */
	public static final void setShape_IdValue(Shape shape, String value) {
		Graphiti.getPeService().setPropertyValue(shape, KEY_SHAPE_ID, value);
	}
	
	/**
	 * checks if the property shape id for a given shape equals the given value
	 * @param shape the shape to check the property for
	 * @param value the value to check the property against
	 * @return boolean if the property value equals the given value
	 */
	public static final boolean isShape_IdValue(Shape shape, String value) {
		return (Graphiti.getPeService().getPropertyValue(shape, KEY_SHAPE_ID).equals(value));
	}
	
	//Diagram Kind
	//~~~~~~~~~~~~~~~~~~
	/**
	 * the key to identify the property diagram kind gathered from {@link IdentifierLiterals}
	 * <P>
	 * The word <em>kind</em> is chosen to differ this property from the <em>diagram types</em> of the 
	 * graphiti framework.
	 */
	public static final String KEY_DIAGRAM_KIND = IdentifierLiterals.KEY_DIAGRAM_KIND;
	
	/**
	 * set the property diagram kind for a given diagram
	 * <P>
	 * The word <em>kind</em> is chosen to differ this property from the <em>diagram types</em> of the 
	 * graphiti framework.
	 * @param diagram the diagram to set the property for
	 * @param value the new value of the property
	 */
	public static final void setDiagram_KindValue(Diagram diagram, String value) {
		Graphiti.getPeService().setPropertyValue(diagram, KEY_DIAGRAM_KIND, value);
	}
	
	/**
	 * checks if the property diagram kind for a given graphic algorithm equals the given value
	 * <P>
	 * The word <em>kind</em> is chosen to differ this property from the <em>diagram types</em> of the 
	 * graphiti framework.
	 * @param diagram the diagram to check the property for
	 * @param value the value to check the property against
	 * @return boolean if the property value equals the given value
	 */
	public static final boolean isDiagram_KindValue(Diagram diagram, String value) {
		return (Graphiti.getPeService().getPropertyValue(diagram, KEY_DIAGRAM_KIND).equals(value));
	}
}
