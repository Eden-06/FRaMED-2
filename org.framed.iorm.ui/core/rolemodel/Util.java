package rolemodel;

import java.util.List;

import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.framed.iorm.ui.UIUtil;
import org.framed.iorm.ui.references.AbstractAttributeAndOperationReference;

/**
* This class offers utility operations in the scope of the role model feature module. This operations are mostly the same as the 
* ones of a compartment type, since a created role model is handled like a compartment type if the corresponding feature is chosen. 
* @author Kevin Kassin
*/
public class Util {

	/**
	 * the object to get names, ids and so on for this feature
	 */
	private final Literals literals = new Literals();
	
	/**
	 * a reference class which encapsulates the dependency to the attribute and operation features
	 */
	private final AbstractAttributeAndOperationReference aaoReference = UIUtil.getAttributeAndOperationFeatureReference();
	
	/**
	 * This operation calculates where the horizontal first third of a role model is.
	 * @param heightOfCompartmentType the height of the role model 
	 * @return the horizontal first third of the role model 
	 */
	public final int calculateHorizontaltFirstThird(int heightOfCompartmentType) {
		return ((heightOfCompartmentType-literals.HEIGHT_NAME_SHAPE)/3)+literals.HEIGHT_NAME_SHAPE;
	}
	
	/**
	 * This operation calculates where the horizontal second third of a role model is.
	 * @param heightOfCompartmentType the height of the role model 
	 * @return the horizontal second third of the role model 
	 */
	public final int calculateHorizontaltSecondThird(int heightOfCompartmentType) {
		return 2*calculateHorizontaltFirstThird(heightOfCompartmentType)-literals.HEIGHT_NAME_SHAPE;
	}
	
	//Diagram
	//~~~~~~~
	/**
	 * Convenience operation to call {@link UIUtil#getDiagramForGroupingShape(Shape, Diagram, String, String, String)} 
	 * with the correct parameters.
	 */
	public Diagram getCompartmentTypeDiagramForItsShape(Shape groupOrCompartmentTypeShape, Diagram diagram) {
		return UIUtil.getDiagramForGroupingShape(groupOrCompartmentTypeShape, diagram, 
				literals.SHAPE_ID_ROLEMODEL_TYPEBODY, literals.SHAPE_ID_ROLEMODEL_NAME, literals.DIAGRAM_KIND);
	}
	
	//Update
	//~~~~~~
	/**
	 * Convenience operation to call {@link UIUtil#getNameOfPictogramElement(PictogramElement, String)} with the correct parameters.
	 */
	public String getNameOfPictogramElement(PictogramElement pictogramElement) {
		return UIUtil.getNameOfPictogramElement(pictogramElement, literals.SHAPE_ID_ROLEMODEL_NAME);
	}
		
	/**
	 * Convenience operation to call {@link UIUtil#getpictogramAttributeNames(PictogramElement, String, String)} with the correct parameters.
	 */
	public List<String> getpictogramAttributeNames(PictogramElement pictogramElement) {
		return UIUtil.getpictogramAttributeNames(pictogramElement, literals.SHAPE_ID_ROLEMODEL_ATTRIBUTECONTAINER,  aaoReference.SHAPE_ID_ATTRIBUTE_TEXT);
	}
		
	/**
	 * Convenience operation to call {@link UIUtil#getBusinessAttributeNames(PictogramElement, String, String)} with the correct parameters.
	 */
	public List<String> getBusinessAttributeNames(PictogramElement pictogramElement) {
		return UIUtil.getBusinessAttributeNames(pictogramElement, literals.SHAPE_ID_ROLEMODEL_ATTRIBUTECONTAINER, aaoReference.SHAPE_ID_ATTRIBUTE_TEXT);
	}
		
	/**
	 * Convenience operation to call {@link UIUtil#getpictogramOperationNames(PictogramElement, String, String)} with the correct parameters.
	 */
	public List<String> getpictogramOperationNames(PictogramElement pictogramElement) {
		return UIUtil.getpictogramOperationNames(pictogramElement, literals.SHAPE_ID_ROLEMODEL_OPERATIONCONTAINER, aaoReference.SHAPE_ID_OPERATION_TEXT);
	}	
		
	/**
	 * Convenience operation to call {@link UIUtil#getBusinessOperationNames(PictogramElement, String, String)} with the correct parameters.
	 */
	public List<String> getBusinessOperationNames(PictogramElement pictogramElement) {
		return UIUtil.getBusinessOperationNames(pictogramElement, literals.SHAPE_ID_ROLEMODEL_OPERATIONCONTAINER, aaoReference.SHAPE_ID_OPERATION_TEXT);
	}
	
	/**
	 * Convenience operation to call {@link UIUtil#getContentPreviewElementsNames(PictogramElement, String, String)} 
	 * with the correct parameters.
	 */
	public List<String> getContentPreviewElementsNames(PictogramElement pictogramElement) {
		return UIUtil.getContentPreviewElementsNames(pictogramElement, literals.SHAPE_ID_ROLEMODEL_CONTENT_PREVIEW, literals.SHAPE_ID_ROLEMODEL_ELEMENT);
	}
}
