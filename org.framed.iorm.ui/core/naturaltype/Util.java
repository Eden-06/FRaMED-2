package naturaltype;

import java.util.List;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.framed.iorm.ui.util.UIUtil;

import naturaltype.references.AttributeAndOperationsReference;

/**
 * This class offers utility operations in the scope of the attribute and operations feature module.
 * @author Kevin Kassin
 */
public class Util {

	/**
	 * the object to get names, id and so on for this feature
	 */
	private final Literals literals = new Literals();
	
	/**
	 * the reference oject to encapsulate the dependency to the datatypes attribute and operation feature
	 */
	private final AttributeAndOperationsReference aaoReference = new AttributeAndOperationsReference();
	
	//Layout
	//~~~~~~
	/**
	 * This operation calculates where the horizontal center of a data type.
	 * @param heightOfDataType the height of the data type
	 * @return the horizontal center position
	 */
	public int calculateHorizontalCenter(int heightOfNaturalType) {
		return ((heightOfNaturalType-literals.HEIGHT_NAME_SHAPE)/2)+literals.HEIGHT_NAME_SHAPE;
	}	
	
	//Update
	//~~~~~~
	/**
	 * Convenience operation to call {@link UIUtil#getNameOfPictogramElement(PictogramElement, String)} with the correct parameters.
	 */
	public String getNameOfPictogramElement(PictogramElement pictogramElement) {
		return UIUtil.getNameOfPictogramElement(pictogramElement, literals.SHAPE_ID_NATURALTYPE_NAME);
	}
		
	/**
	 * Convenience operation to call {@link UIUtil#getpictogramAttributeNames(PictogramElement, String, String)} with the correct parameters.
	 */
	public List<String> getpictogramAttributeNames(PictogramElement pictogramElement) {
		return UIUtil.getpictogramAttributeNames(pictogramElement, literals.SHAPE_ID_NATURALTYPE_ATTRIBUTECONTAINER,  aaoReference.SHAPE_ID_ATTRIBUTE_TEXT);
	}
		
	/**
	 * Convenience operation to call {@link UIUtil#getBusinessAttributeNames(PictogramElement, String, String)} with the correct parameters.
	 */
	public List<String> getBusinessAttributeNames(PictogramElement pictogramElement) {
		return UIUtil.getBusinessAttributeNames(pictogramElement, literals.SHAPE_ID_NATURALTYPE_ATTRIBUTECONTAINER, aaoReference.SHAPE_ID_ATTRIBUTE_TEXT);
	}
		
	/**
	 * Convenience operation to call {@link UIUtil#getpictogramOperationNames(PictogramElement, String, String)} with the correct parameters.
	 */
	public List<String> getpictogramOperationNames(PictogramElement pictogramElement) {
		return UIUtil.getpictogramOperationNames(pictogramElement, literals.SHAPE_ID_NATURALTYPE_OPERATIONCONTAINER, aaoReference.SHAPE_ID_OPERATION_TEXT);
	}	
	
	/**
	 * Convenience operation to call {@link UIUtil#getBusinessOperationNames(PictogramElement, String, String)} with the correct parameters.
	 */
	public List<String> getBusinessOperationNames(PictogramElement pictogramElement) {
		return UIUtil.getBusinessOperationNames(pictogramElement, literals.SHAPE_ID_NATURALTYPE_OPERATIONCONTAINER, aaoReference.SHAPE_ID_OPERATION_TEXT);
	}	
}