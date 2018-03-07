package rolegroup;

import java.util.List;

import org.eclipse.graphiti.features.IDirectEditingInfo;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.impl.MoveShapeContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.LineStyle;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.framed.iorm.model.Model;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.FRaMEDPropertyService;
import org.framed.iorm.ui.UILiterals;
import org.framed.iorm.ui.UIUtil;
import org.framed.iorm.ui.exceptions.NoModelFoundException;
import org.framed.iorm.ui.palette.FeaturePaletteDescriptor;
import org.framed.iorm.ui.palette.PaletteCategory;
import org.framed.iorm.ui.palette.PaletteView;
import org.framed.iorm.ui.palette.ViewVisibility;
import org.framed.iorm.ui.providers.FeatureProvider;

/**
 * This pattern implements operations that differ from the {@link RoleGroupPattern} when a role group is in another
 * role group. Namely these are:
 * <p>
 * (1) adding a role group to the diagram, especially its pictogram elements<br>
 * (2) moves the role group and its inner elements<br>
 */
public class RoleGroupInRoleGroupPattern extends RoleGroupPattern {
		
	/**
	 * the feature palette descriptor manages the palette visibility, see {@link FeaturePaletteDescriptor}
	 */	
	private final FeaturePaletteDescriptor spec_FPD = new FeaturePaletteDescriptor(
		PaletteCategory.NONE,
		ViewVisibility.NO_VIEW) {
			@Override
			public boolean featureExpression(List<String> framedFeatureNames, PaletteView paletteView) {
				return false;
		}	};
		
	/**
	 * Class constructor
	 */
	public RoleGroupInRoleGroupPattern() {
		FEATURE_NAME = literals.ROLEGROUP_IN_RG_FEATURE_NAME;
		FPD = spec_FPD;
		ICON_IMG_ID = literals.ROLEGROUP_IN_RG_ICON_IMG_ID;
	}
	
	/**
	 * checks if pattern is applicable for a given business object
	 * <p>
	 * Note: At creation of a role group there is no container of the iorm shape assigned. Therefore the else-branch uses
	 *       the {@link FRaMEDPropertyService} to get in which container a role group was created in. The property managed with the 
	 *       {@link FRaMEDPropertyService} is deleted when adding the role group. After that point in the life cycle of a 
	 *       role group the now set container is used to identify if this pattern is the right one to apply.
	 * @return true, if business object is a {@link org.framed.iorm.model.Shape} of type {@link Type#ROLE_GROUP} in a Role Group
	 */
	@Override
	public boolean isMainBusinessObjectApplicable(Object businessObject) {
		if(businessObject instanceof org.framed.iorm.model.Shape) {
			org.framed.iorm.model.Shape iormShape = (org.framed.iorm.model.Shape) businessObject;
			if(iormShape.getType() == modelType) {
				//Note
				if(iormShape.getContainer() != null) {
					return iormShape.getContainer().getParent().getType() == Type.ROLE_GROUP;
				} else {
					FRaMEDPropertyService framedPropertyService = ((FeatureProvider) getFeatureProvider()).getFRaMEDPropertyService();
					if(!(framedPropertyService.getIormShapeProperty(iormShape) instanceof Diagram)) {
						ContainerShape containerShape = framedPropertyService.getIormShapeProperty(iormShape);
						if(UIUtil.isShape_IdValue(containerShape, literals.SHAPE_ID_ROLEGROUP_TYPEBODY))
							return true;
		}	}	}	}
		return false;
	}

	/**
	 * checks if pattern is applicable for a given pictogram element
	 * @return true, if business object of the pictogram element is a {@link org.framed.iorm.model.Shape} of type {@link Type#ROLE_GROUP}
	 * in a Role Group
	 */
	@Override
	protected boolean isPatternControlled(PictogramElement pictogramElement) {
		Object businessObject = getBusinessObjectForPictogramElement(pictogramElement);
		return isMainBusinessObjectApplicable(businessObject);
	}

	/**
	 * checks if the pictogram element to edit with the pattern is its root
	 * @return true, if business object of the pictogram element is a {@link org.framed.iorm.model.Shape} of type {@link Type#ROLE_GROUP}
	 * in a Role Group
	 */
	@Override
	protected boolean isPatternRoot(PictogramElement pictogramElement) {
		Object businessObject = getBusinessObjectForPictogramElement(pictogramElement);
		return isMainBusinessObjectApplicable(businessObject);
	}
	
	//add feature
	//~~~~~~~~~~~
	/**
	 * adds the graphical representation of a role group in a role group to the pictogram model
	 * <p>
	 * It creates the following structure:<br>
	 * <ul>
	 *   <li>container shape</li>
	 * 	   <ul>
	 * 		 <li>type body shape</li>
	 * 		   <ul><li>type body rectangle</li></ul>
	 * 		   <ul>
	 * 		     <li>name container</li>
	 * 			  <ul><li>name text</li></ul>
	 * 		   </ul>
	 * 		<li>role groups diagram</li>
	 * 	   </ul>
	 * </ul> 
	 * <p>
	 * It uses follows this steps:<br>
	 * Step 1: It adds the role groups business object to the correct model. This is not done in the create operation, since there
	 * 		   is only one create operation handling the creation of role groups in and outside of role groups. To ensure modularity
	 * 		   the code that differs depending on where role groups are created in has be outsourced to this operation.<br>
	 * Step 2: It calculates the location, height and width of the role groups representation.<br>
	 * Step 3: It creates the structure shown above.<br>
	 * Step 4: It sets the shape identifiers for the created graphics algorithms of the role group.<br>
	 * Step 5: It links the created shapes of the group to its business objects.<br> 
	 * Step 6: It enables direct editing, anchors and layouting of the role group. It also updates the group in which 
	 * 		   its created, if any.
	 */
	@Override
	public PictogramElement add(IAddContext addContext) {
		//Step 1
		Diagram targetDiagram = util.getRoleGroupDiagramForItsShape(addContext.getTargetContainer(), getDiagram());
		org.framed.iorm.model.Shape newRoleGroup = (org.framed.iorm.model.Shape) addContext.getNewObject();
		Model model = UIUtil.getLinkedModelForDiagram(targetDiagram);
		if(model == null) throw new NoModelFoundException();
		if(newRoleGroup.eResource() != null) targetDiagram.eResource().getContents().add(newRoleGroup);
		model.getElements().add(newRoleGroup);
		newRoleGroup.setContainer(model);
		
		//Step 2
		int x =  addContext.getX() + targetDiagram.getGraphicsAlgorithm().getX(),
			y =  addContext.getY() + targetDiagram.getGraphicsAlgorithm().getY(),
			width = addContext.getWidth(), height = addContext.getHeight();
		if(addContext.getWidth() < literals.MIN_WIDTH) width = literals.MIN_WIDTH;
		if(addContext.getHeight() < literals.MIN_HEIGHT) height = literals.MIN_HEIGHT;
		
		//Step 3
		//container for body shape
		ContainerShape containerShape = pictogramElementCreateService.createContainerShape(targetDiagram, false);
			
		//occurence costraint
		Shape cardinalityShape = pictogramElementCreateService.createShape(containerShape, true);
		cardinalityShape.setVisible(false);
		Text cardinalityText = graphicAlgorithmService.createText(cardinalityShape, newRoleGroup.getDescription().getName());
		cardinalityText.setForeground(manageColor(literals.COLOR_TEXT));	
		graphicAlgorithmService.setLocationAndSize(cardinalityText, 
			x+width/2-literals.HEIGHT_OCCURRENCE_CONSTRAINT/2, 
			y-literals.HEIGHT_OCCURRENCE_CONSTRAINT-literals.PUFFER_BETWEEN_ELEMENTS, 
			literals.WIDTH_OCCURRENCE_CONSTRAINT, 
			literals.HEIGHT_OCCURRENCE_CONSTRAINT);	
		
		//body shape of type
		ContainerShape typeBodyShape = pictogramElementCreateService.createContainerShape(containerShape, true);		
		RoundedRectangle typeBodyRectangle = graphicAlgorithmService.createRoundedRectangle(typeBodyShape, literals.ROLE_GROUP_CORNER_RADIUS, literals.ROLE_GROUP_CORNER_RADIUS);
		typeBodyRectangle.setLineStyle(LineStyle.DASH);
		typeBodyRectangle.setLineWidth(2);
		typeBodyRectangle.setForeground(manageColor(literals.COLOR_LINES));
		typeBodyRectangle.setBackground(manageColor(literals.COLOR_BACKGROUND));
		typeBodyRectangle.setTransparency(0.7);
		graphicAlgorithmService.setLocationAndSize(typeBodyRectangle, 
			x, y, 
			width, height);
				
		//name
		Shape nameShape = pictogramElementCreateService.createShape(typeBodyShape, false);
		Text text = graphicAlgorithmService.createText(nameShape, newRoleGroup.getName());	
		text.setForeground(manageColor(literals.COLOR_TEXT));	
		text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);	
		graphicAlgorithmService.setLocationAndSize(text, 0, 0, width, literals.HEIGHT_NAME_SHAPE);	
				
		//role groups diagram
		Diagram contentDiagram = pictogramElementCreateService.createDiagram(UILiterals.DIAGRAM_TYPE_ID, newRoleGroup.getName(), 10, true);
		graphicAlgorithmService.setLocationAndSize(contentDiagram.getGraphicsAlgorithm(), 
			x, y, 
			width, height);
		UIUtil.setDiagram_KindValue(contentDiagram, literals.DIAGRAM_KIND);
		link(contentDiagram, newRoleGroup.getModel());
		containerShape.getChildren().add(contentDiagram);
		
		//Step 4
		UIUtil.setShape_IdValue(containerShape, literals.SHAPE_ID_ROLEGROUP_CONTAINER);
		UIUtil.setShape_IdValue(typeBodyShape, literals.SHAPE_ID_ROLEGROUP_TYPEBODY);
		UIUtil.setShape_IdValue(nameShape, literals.SHAPE_ID_ROLEGROUP_NAME);
		UIUtil.setShape_IdValue(cardinalityShape, literals.SHAPE_ID_ROLEGROUP_OCCURRENCE_CONSTRAINT);
		
		//Step 5
		link(containerShape, newRoleGroup);
		link(typeBodyShape, newRoleGroup);
		link(nameShape, newRoleGroup);
		link(cardinalityShape, newRoleGroup);
		
		//Step 6
		getFeatureProvider().getDirectEditingInfo().setActive(true);
		IDirectEditingInfo directEditingInfo = getFeatureProvider().getDirectEditingInfo();
		directEditingInfo.setMainPictogramElement(typeBodyShape);
		directEditingInfo.setPictogramElement(nameShape);
		directEditingInfo.setGraphicsAlgorithm(text);
		pictogramElementCreateService.createChopboxAnchor(typeBodyShape);
		layoutPictogramElement(containerShape);
		updateContainingGroupingFeaturesObject();
		return containerShape;
	}
	
	//move feature
	//~~~~~~~~~~~~
	/**
	 * returns if a role group in a role group can be moved and disables to move the occurrence constraint manually
	 * <p>
	 * checks if the role group is moved inside the same role group
	 */
	@Override
	public boolean canMoveShape(IMoveShapeContext moveContext) {
		if(UIUtil.isShape_IdValue((Shape) moveContext.getPictogramElement(), literals.SHAPE_ID_ROLEGROUP_OCCURRENCE_CONSTRAINT)) {
					return false;
		}
		if(UIUtil.isShape_IdValue((Shape) moveContext.getPictogramElement(), literals.SHAPE_ID_ROLEGROUP_TYPEBODY)) {
			ContainerShape sourcon = moveContext.getSourceContainer(),
					   	   tarcon = moveContext.getTargetContainer();
			return sourcon.getContainer().equals(util.getRoleGroupDiagramForItsShape(tarcon, getDiagram()));
		}
		return false;
	}
	
	/**
	 * moves a role group in a role group by following these steps:
	 * <p>
	 * Step 1: It gets the pictogram shapes and graphic algorithms of the role group.<br>
	 * Step 2: It calculates the coordinates the role group is moved. Since the role group is in a
	 * 		   role group it might be needed to add the coordinates of the outer role groups and also
	 * 		   differ between automated moved (e.g. when the outer role group would be moved) and the
	 * 		   movement triggered by a user.<br>
	 * Step 3: Its sets the role groups graphic algorithms to previously calculated coordinates.<br>
	 * Step 4: It creates move contexts for its inner elements and calls their move operations.
	 */
	@Override
	public void moveShape(IMoveShapeContext moveContext) {
		//Step 1
		ContainerShape typeBodyShape = (ContainerShape) moveContext.getPictogramElement();
		RoundedRectangle typeBodyRectangle = (RoundedRectangle) typeBodyShape.getGraphicsAlgorithm();
		Diagram diagram = util.getRoleGroupDiagramForItsShape(typeBodyShape, getDiagram());
		GraphicsAlgorithm diagramRectangle = diagram.getGraphicsAlgorithm();
		
		//Step 2
		int x, y;
		MoveShapeContext moveContextImpl = (MoveShapeContext) moveContext;
		if(moveContextImpl.getProperty("automated") != null) {
			x =  typeBodyRectangle.getX() + moveContextImpl.getDeltaX();
			y =  typeBodyRectangle.getY() + moveContextImpl.getDeltaY();
		} else {
			x =  moveContext.getTargetContainer().getGraphicsAlgorithm().getX() + typeBodyRectangle.getX() + moveContextImpl.getDeltaX();
			y =  moveContext.getTargetContainer().getGraphicsAlgorithm().getY() + typeBodyRectangle.getY() + moveContextImpl.getDeltaY();
			moveContextImpl.setDeltaX(moveContext.getDeltaX() + moveContext.getTargetContainer().getGraphicsAlgorithm().getX());
			moveContextImpl.setDeltaY(moveContext.getDeltaY() + moveContext.getTargetContainer().getGraphicsAlgorithm().getY());
		}
		
		//Step 3
		graphicAlgorithmService.setLocation(typeBodyRectangle, x, y);
		graphicAlgorithmService.setLocation(diagramRectangle, x, y);
		//Step 4
		for(Shape innerShape : diagram.getChildren()) {
			if(innerShape instanceof ContainerShape) {
				ContainerShape innerTypeBody;
				//TODO better
				if(UIUtil.isShape_IdValue(innerShape, "shape_rt_container")) {
					innerTypeBody = (ContainerShape) ((ContainerShape) innerShape).getChildren().get(2);
				} else {
					innerTypeBody = (ContainerShape) ((ContainerShape) innerShape).getChildren().get(1);
				}
				MoveShapeContext moveContextForInnerShape = new MoveShapeContext(innerTypeBody);
				moveContextForInnerShape.setDeltaX(moveContextImpl.getDeltaX());
				moveContextForInnerShape.setDeltaY(moveContextImpl.getDeltaY());
				moveContextForInnerShape.setTargetContainer(typeBodyShape);
				moveContextForInnerShape.setSourceContainer(innerTypeBody.getContainer());
				moveContextForInnerShape.putProperty("automated", true);
				IMoveShapeFeature moveFeature = getFeatureProvider().getMoveShapeFeature(moveContextForInnerShape);
				if(moveFeature.canMoveShape(moveContextForInnerShape)) moveFeature.moveShape(moveContextForInnerShape);
	}	}	}
}

