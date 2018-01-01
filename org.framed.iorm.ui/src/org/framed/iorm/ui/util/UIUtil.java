package org.framed.iorm.ui.util;

import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.framed.iorm.model.Model;
import org.framed.iorm.ui.literals.UILiterals;

public class UIUtil {

	//Model
	//~~~~~
	/**
	 * This operation gets the root {@link Model} for a given {@link Diagram}.
	 * @param diagram The diagram to get the model from
	 * @return the root model of the given diagram if there is exactly one model linked and returns null else
	 */
	public static final Model getLinkedModelForDiagram(Diagram diagram) {
		if(diagram.getLink() != null) {
			if(diagram.getLink().getBusinessObjects().size() == 1 &&
			   diagram.getLink().getBusinessObjects().get(0) instanceof Model) {
				return (Model) diagram.getLink().getBusinessObjects().get(0);
			}
		}
		return null;
	}
	
	//Properties
	//Shape Identifier
	//~~~~~~~~~~~~~~~~
	/**
	 * the key to identify the property shape id gathered from {@link IdentifierLiterals}
	 */
	public static final String KEY_SHAPE_ID = UILiterals.KEY_SHAPE_ID;
		
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
	public static final String KEY_DIAGRAM_KIND = UILiterals.KEY_DIAGRAM_KIND;
	
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
