package org.framed.iorm.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.graphiti.mm.pictograms.ContainerShape;

/**
 * This class offers a service to manage any type of properties during runtime.
 * @author Kevin Kassin
 */
public class FRaMEDPropertyService {
	
	/**
	 * Class constructor
	 */
	public FRaMEDPropertyService() {
		addShape_iormShapeList = new ArrayList<org.framed.iorm.model.Shape>();
		addShape_containerShapeList = new ArrayList<ContainerShape>();
	}
	
	//addShape property
	//~~~~~~~~~~~~~~~~~
	/**
	 * the list to save the iorm shape created 
	 */
	public List<org.framed.iorm.model.Shape> addShape_iormShapeList;
	
	/**
	 * the list to save the container shape the iorm element is created in
	 */
	public List<ContainerShape> addShape_containerShapeList;
	
	/**
	 * set the addShape property for a given iorm shape
	 * @param iormShape the iorm shape to set the addShape property for
	 * @param containerShape the value of the addShape property to set
	 */
	public void setIormShapeProperty(org.framed.iorm.model.Shape iormShape, ContainerShape containerShape) {
		addShape_iormShapeList.add(iormShape);
		addShape_containerShapeList.add(containerShape);
	}
	
	/**
	 * gets the addShape properties' value for a given iorm shape
	 * @param iormShape the iorm shape to get the addShape property for
	 * @return the value of the addShape property to get
	 */
	public ContainerShape getIormShapeProperty(org.framed.iorm.model.Shape iormShape) {
		if(addShape_iormShapeList.contains(iormShape)) {
			return addShape_containerShapeList.get(addShape_iormShapeList.indexOf(iormShape));
		}
		return null;
	}
	
	/**
	 * delete an entry for the addShape property
	 * @param iormShape the iorm shape to delete the addShape property entry for
	 */
	public void deleteIormShapeProperty(org.framed.iorm.model.Shape iormShape) {
		if(addShape_iormShapeList.contains(iormShape)) {
			addShape_containerShapeList.remove(addShape_iormShapeList.indexOf(iormShape));
			addShape_iormShapeList.remove(iormShape);
	}	}
}
