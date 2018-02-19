package rolegroup;

import java.util.List;

import org.eclipse.graphiti.features.IDirectEditingInfo;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.impl.MoveShapeContext;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.framed.iorm.model.Model;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.FRaMEDPropertyService;
import org.framed.iorm.ui.UIUtil;
import org.framed.iorm.ui.exceptions.NoModelFoundException;
import org.framed.iorm.ui.palette.FeaturePaletteDescriptor;
import org.framed.iorm.ui.palette.PaletteCategory;
import org.framed.iorm.ui.palette.PaletteView;
import org.framed.iorm.ui.palette.ViewVisibility;
import org.framed.iorm.ui.providers.FeatureProvider;

import roletype.RoleTypePattern;

/**
 * This pattern implements operations that differ from the {@link RoleTypePattern} when a role type is in a
 * role group. Namely these are:
 * <p>
 * (1) adding a role group to the diagram, especially its pictogram elements<br>
 * (2) moves the role group and its inner elements<br>
 */
public class RoleTypeInRoleGroupPattern extends RoleTypePattern {
	
	/**
	 * the object to get names, ids and so on for the role group feature
	 */
	rolegroup.Literals roleGroupLiterals = new rolegroup.Literals();
	
	/**
	 * the object to call utility operations of the role group feature on
	 */
	rolegroup.Util roleGroupUtil = new rolegroup.Util();
	
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
	public RoleTypeInRoleGroupPattern() {
		FEATURE_NAME = roleGroupLiterals.ROLETYPE_IN_RG_FEATURE_NAME;
		FPD = spec_FPD;
		ICON_IMG_ID = roleGroupLiterals.ROLETYPE_IN_RG_ICON_IMG_ID;
	}
	
	/**
	 * checks if pattern is applicable for a given business object
	 * <p>
	 * Note: At creation of a role type there is no container of the iorm shape assigned. Therefore the else-branch uses
	 *       the {@link FRaMEDPropertyService} to get in which container a role type was created in. The property managed with the 
	 *       {@link FRaMEDPropertyService} is deleted when adding the role type. After that point in the life cycle of a 
	 *       role type the now set container is used to identify if this pattern is the right one to apply.
	 * @return true, if business object is a {@link org.framed.iorm.model.Shape} of type {@link Type#ROLE_TYPE} in Role Group
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
						if(UIUtil.isShape_IdValue(containerShape, roleGroupLiterals.SHAPE_ID_ROLEGROUP_TYPEBODY))
							return true;
		}	}	}	}
		return false;
	}

	/**
	 * checks if pattern is applicable for a given pictogram element
	 * @return true, if business object of the pictogram element is a {@link org.framed.iorm.model.Shape} of type {@link Type#ROLE_TYPE}
	 * in a Role Group
	 */
	@Override
	protected boolean isPatternControlled(PictogramElement pictogramElement) {
		Object businessObject = getBusinessObjectForPictogramElement(pictogramElement);
		return isMainBusinessObjectApplicable(businessObject);
	}

	/**
	 * checks if the pictogram element to edit with the pattern is its root
	 * @return true, if business object of the pictogram element is a {@link org.framed.iorm.model.Shape} of type {@link Type#ROLE_TYPE}
	 * in a Role Group
	 */
	@Override
	protected boolean isPatternRoot(PictogramElement pictogramElement) {
		Object businessObject = getBusinessObjectForPictogramElement(pictogramElement);
		return isMainBusinessObjectApplicable(businessObject);
	}
	
	/**
	 * adds the graphical representation of a role type to the pictogram model
	 * <p>
	 * It creates the following structure:<br>
	 * <ul>
	 *   <li>container shape</li>
	 * 	   <ul>
	 * 	     <li>drop shadow shape</li>
	 *         <ul><li>drop shadow rectangle</li></ul>
	 * 		<li>occurence costraints shape</li>
	 *         <ul><li>occurence costraints rectangle</li></ul>
	 * 		<li>type body shape</li>
	 * 		   <ul><li>type body rectangle</li></ul>
	 * 		   <ul>
	 * 		     <li>name container</li>
	 * 			  <ul><li>name text</li></ul>
	 * 			<li>first line container</li>
	 * 			  <ul><li>first polyline</li></ul>
	 * 			<li>attribute container shape</li>
	 * 			  <ul><li>attribute container rectangle</li></ul>
	 * 			<li>second line container</li>
	 * 			  <ul><li>second polyline</li></ul>
	 * 			<li>operation container shape</li>
	 * 			  <ul><li>operation container rectangle</li></ul>
	 * 		   </ul>
	 * 	   </ul>
	 * </ul> 
	 * <p>
	 * It uses follows this steps:<br>
	 * Step 1: It adds the role types business object to the correct model. This is not done in the create operation, since there
	 * 		   is only one create operation handling the creation of role types in and outside of role groups. To ensure modularity
	 * 		   the code that differs depending on where role types are created in has be outsourced to this operation.<br>
	 * Step 2: It calculates the height and width of the role types representation.<br>
	 * Step 3: It creates the structure shown above.<br>
	 * Step 4: It sets the shape identifiers for the created graphics algorithms of the role type.<br>
	 * Step 5: It links the created shapes of the role to its business objects.<br> 
	 * Step 6: It enables direct editing, anchors and layouting of the role. It also updates the compartment type in which 
	 * 		   its created, if any.
	 */
	@Override
	public PictogramElement add(IAddContext addContext) {
		//Step 1
		org.framed.iorm.model.Shape newRoleType = (org.framed.iorm.model.Shape) addContext.getNewObject();
		FRaMEDPropertyService framedPropertyService = ((FeatureProvider) getFeatureProvider()).getFRaMEDPropertyService();
		framedPropertyService.deleteIormShapeProperty(newRoleType);
		Diagram targetDiagram = roleGroupUtil.getRoleGroupDiagramForItsShape(addContext.getTargetContainer(), getDiagram()); 
		Model model = UIUtil.getLinkedModelForDiagram(targetDiagram);
		if(model == null) throw new NoModelFoundException();
		if(newRoleType.eResource() != null) targetDiagram.eResource().getContents().add(newRoleType);
		model.getElements().add(newRoleType);
		newRoleType.setContainer(model);
		
		//Step 2
		org.framed.iorm.model.Shape addedRoleType = (org.framed.iorm.model.Shape) addContext.getNewObject();
		int x =  addContext.getX() + targetDiagram.getGraphicsAlgorithm().getX(),
			y =  addContext.getY() + targetDiagram.getGraphicsAlgorithm().getY(), 
			width = addContext.getWidth(), height = addContext.getHeight();
		if(addContext.getWidth() < literals.MIN_WIDTH) width = literals.MIN_WIDTH;
		if(addContext.getHeight() < literals.MIN_HEIGHT) height = literals.MIN_HEIGHT;
					
		//Step 3
		//container for body shape and shadow
		ContainerShape containerShape = pictogramElementCreateService.createContainerShape(targetDiagram, false);
								  
		//drop shadow
		ContainerShape dropShadowShape = pictogramElementCreateService.createContainerShape(containerShape, true);
		RoundedRectangle dropShadowRectangle = graphicAlgorithmService.createRoundedRectangle(dropShadowShape, literals.ROLE_CORNER_RADIUS, literals.ROLE_CORNER_RADIUS);
		dropShadowRectangle.setForeground(manageColor(literals.COLOR_SHADOW));
		dropShadowRectangle.setBackground(manageColor(literals.COLOR_SHADOW));
		graphicAlgorithmService.setLocationAndSize(dropShadowRectangle, x+literals.SHADOW_SIZE, y+literals.SHADOW_SIZE, width, height);
			
		//occurence costraint
		Shape cardinalityShape = pictogramElementCreateService.createShape(containerShape, true);
		Text cardinalityText = graphicAlgorithmService.createText(cardinalityShape, addedRoleType.getDescription().getName());
		cardinalityText.setForeground(manageColor(literals.COLOR_TEXT));													
		graphicAlgorithmService.setLocationAndSize(cardinalityText, 
			x+width/2-literals.HEIGHT_OCCURRENCE_CONSTRAINT/2, 
			y-literals.HEIGHT_OCCURRENCE_CONSTRAINT-literals.PUFFER_BETWEEN_ELEMENTS, 
			literals.WIDTH_OCCURRENCE_CONSTRAINT, 
			literals.HEIGHT_OCCURRENCE_CONSTRAINT);
			
		//body shape of type
		ContainerShape typeBodyShape = pictogramElementCreateService.createContainerShape(containerShape, true);		
		RoundedRectangle typeBodyRectangle = graphicAlgorithmService.createRoundedRectangle(typeBodyShape, literals.ROLE_CORNER_RADIUS, literals.ROLE_CORNER_RADIUS);
		typeBodyRectangle.setForeground(manageColor(literals.COLOR_LINES));
		typeBodyRectangle.setBackground(manageColor(literals.COLOR_BACKGROUND));
		graphicAlgorithmService.setLocationAndSize(typeBodyRectangle, x, y, width, height);
		
		
		//name
		Shape nameShape = pictogramElementCreateService.createShape(typeBodyShape, false);
		Text text = graphicAlgorithmService.createText(nameShape, addedRoleType.getName());	
		text.setForeground(manageColor(literals.COLOR_TEXT));	
		text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);	
		graphicAlgorithmService.setLocationAndSize(text, 0, 0, width, literals.HEIGHT_NAME_SHAPE);	
					
		//first line
		Shape firstLineShape = pictogramElementCreateService.createShape(typeBodyShape, false);
		Polyline firstPolyline = graphicAlgorithmService.createPolyline(firstLineShape, new int[] {0, literals.HEIGHT_NAME_SHAPE, width, literals.HEIGHT_NAME_SHAPE});
		firstPolyline.setForeground(manageColor(literals.COLOR_LINES));
					
		//attribute container
		ContainerShape attributeContainer = pictogramElementCreateService.createContainerShape(typeBodyShape, false);
		Rectangle attributeRectangle = graphicAlgorithmService.createRectangle(attributeContainer);
		attributeRectangle.setLineVisible(false);
		attributeRectangle.setBackground(manageColor(literals.COLOR_BACKGROUND));
		int horizontalCenter = util.calculateHorizontalCenter(height);
		graphicAlgorithmService.setLocationAndSize(attributeRectangle, literals.PUFFER_BETWEEN_ELEMENTS, literals.HEIGHT_NAME_SHAPE+literals.PUFFER_BETWEEN_ELEMENTS, 
															   width-2*literals.PUFFER_BETWEEN_ELEMENTS, horizontalCenter-literals.HEIGHT_NAME_SHAPE-2*literals.PUFFER_BETWEEN_ELEMENTS);
		//second line
		Shape secondLineShape = pictogramElementCreateService.createShape(typeBodyShape, false);	
		Polyline secondPolyline = graphicAlgorithmService.createPolyline(secondLineShape, new int[] {0, horizontalCenter, width, horizontalCenter});
		secondPolyline.setForeground(manageColor(literals.COLOR_LINES));
					
		//operation container
		ContainerShape operationContainer = pictogramElementCreateService.createContainerShape(typeBodyShape, false);
		Rectangle operationRectangle = graphicAlgorithmService.createRectangle(operationContainer);
		operationRectangle.setLineVisible(false);
		operationRectangle.setBackground(manageColor(literals.COLOR_BACKGROUND));
		graphicAlgorithmService.setLocationAndSize(operationRectangle, 
			literals.PUFFER_BETWEEN_ELEMENTS, horizontalCenter+literals.PUFFER_BETWEEN_ELEMENTS, 
			width-2*literals.PUFFER_BETWEEN_ELEMENTS, horizontalCenter-literals.ROLE_CORNER_RADIUS/2);
					
		//Step 4
		UIUtil.setShape_IdValue(containerShape, literals.SHAPE_ID_ROLETYPE_CONTAINER);
		UIUtil.setShape_IdValue(cardinalityShape, literals.SHAPE_ID_ROLETYPE_OCCURRENCE_CONSTRAINT);
		UIUtil.setShape_IdValue(typeBodyShape, literals.SHAPE_ID_ROLETYPE_TYPEBODY);
		UIUtil.setShape_IdValue(dropShadowShape, literals.SHAPE_ID_ROLETYPE_SHADOW);
		UIUtil.setShape_IdValue(nameShape, literals.SHAPE_ID_ROLETYPE_NAME);
		UIUtil.setShape_IdValue(firstLineShape, literals.SHAPE_ID_ROLETYPE_FIRSTLINE);
		UIUtil.setShape_IdValue(attributeContainer, literals.SHAPE_ID_ROLETYPE_ATTRIBUTECONTAINER);
		UIUtil.setShape_IdValue(secondLineShape, literals.SHAPE_ID_ROLETYPE_SECONDLINE);
		UIUtil.setShape_IdValue(operationContainer, literals.SHAPE_ID_ROLETYPE_OPERATIONCONTAINER);
					
		//Step 5
		link(containerShape, addedRoleType);
		link(cardinalityShape, addedRoleType);
		link(typeBodyShape, addedRoleType);
		link(dropShadowShape, addedRoleType);
		link(nameShape, addedRoleType);
		link(firstLineShape, addedRoleType);
		link(attributeContainer, addedRoleType);
		link(secondLineShape, addedRoleType);
		link(operationContainer, addedRoleType);
					
		//Step 6
		getFeatureProvider().getDirectEditingInfo().setActive(true);
		IDirectEditingInfo directEditingInfo = getFeatureProvider().getDirectEditingInfo();
		directEditingInfo.setMainPictogramElement(typeBodyShape);
		directEditingInfo.setPictogramElement(nameShape);
		directEditingInfo.setGraphicsAlgorithm(text);
		pictogramElementCreateService.createChopboxAnchor(typeBodyShape);
		layoutPictogramElement(typeBodyShape);
		updateContainingGroupingFeaturesObject();
		return containerShape;
	}	
	
	/**
	 * disables that the user can move the drop shadow manually
	 * <p>
	 * alos checks if the role group is moved inside the same role group
	 * TODO role group move auf schatten
	 */
	@Override
	public boolean canMoveShape(IMoveShapeContext moveContext) {
		if(UIUtil.isShape_IdValue((Shape) moveContext.getPictogramElement(), literals.SHAPE_ID_ROLETYPE_SHADOW)) {
			return false;
		}
		if(UIUtil.isShape_IdValue((Shape) moveContext.getPictogramElement(), literals.SHAPE_ID_ROLETYPE_TYPEBODY)) {
			ContainerShape sourcon = moveContext.getSourceContainer(),
						   tarcon = moveContext.getTargetContainer();
			return sourcon.getContainer().equals(roleGroupUtil.getRoleGroupDiagramForItsShape(tarcon, getDiagram()));
		}
		return false;
	}
	
	/**
	 * moves a role type in a role group by following these steps:
	 * <p>
	 * Step 1: It gets the pictogram shapes and graphic algorithms of the role type.<br>
	 * Step 2: It calculates the coordinates the role type is moved to. Since the role type is in a
	 * 		   role group it might be needed to add the coordinates of the outer role groups and also
	 * 		   differ between automated moved (e.g. when the outer role group would be moved) and the
	 * 		   movement triggered by a user.<br>
	 * Step 3: Its sets the role groups graphic algorithms to previously calculated coordinates.
	 */
	@Override
	public void moveShape(IMoveShapeContext moveContext) {
		//Step 1
		ContainerShape typeBodyShape = (ContainerShape) moveContext.getPictogramElement();
		RoundedRectangle typeBodyRectangle = (RoundedRectangle) typeBodyShape.getGraphicsAlgorithm();
		ContainerShape dropShadowShape = (ContainerShape) ((ContainerShape) typeBodyShape).getContainer().getChildren().get(0);
		RoundedRectangle dropShadowRectangle = (RoundedRectangle) dropShadowShape.getGraphicsAlgorithm();
		Shape OCShape = (Shape) ((ContainerShape) typeBodyShape).getContainer().getChildren().get(1);
		Text OCText = (Text) OCShape.getGraphicsAlgorithm();
		
		//Step 2
		int x, y;
		MoveShapeContext moveContextImpl = (MoveShapeContext) moveContext;
		if(moveContextImpl.getProperty("automated") != null) {
			x =  typeBodyRectangle.getX() + moveContext.getDeltaX();
			y =  typeBodyRectangle.getY() + moveContext.getDeltaY();
		} else {
			x =  moveContext.getTargetContainer().getGraphicsAlgorithm().getX() + typeBodyRectangle.getX() + moveContext.getDeltaX();
			y =  moveContext.getTargetContainer().getGraphicsAlgorithm().getY() + typeBodyRectangle.getY() + moveContext.getDeltaY();
		}
		
		//Step 3
		dropShadowRectangle.setX(x + literals.SHADOW_SIZE);
		dropShadowRectangle.setY(y + literals.SHADOW_SIZE);
		Graphiti.getGaService().setLocation(OCText, 
				x+typeBodyRectangle.getWidth()/2-literals.HEIGHT_OCCURRENCE_CONSTRAINT/2, 
				y-literals.HEIGHT_OCCURRENCE_CONSTRAINT-literals.PUFFER_BETWEEN_ELEMENTS);
		typeBodyRectangle.setX(x);
		typeBodyRectangle.setY(y);
	}	
}

