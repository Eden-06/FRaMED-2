package org.framed.iorm.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//TODO alles
import org.eclipse.graphiti.mm.pictograms.ContainerShape;

public class FRaMEDPropertyService {
	
	public List<org.framed.iorm.model.Shape> iormShapeList;
	
	public List<ContainerShape> containerShapeList;
	
	public FRaMEDPropertyService() {
		iormShapeList = new ArrayList<org.framed.iorm.model.Shape>();
		containerShapeList = new ArrayList<ContainerShape>();
	}
	
	public void setIormShapeProperty(org.framed.iorm.model.Shape iormShape, ContainerShape containerShape) {
		iormShapeList.add(iormShape);
		containerShapeList.add(containerShape);
	}
	
	public ContainerShape getIormShapeProperty(org.framed.iorm.model.Shape iormShape) {
		if(iormShapeList.contains(iormShape)) {
			return containerShapeList.get(iormShapeList.indexOf(iormShape));
		}
		return null;
	}

}
