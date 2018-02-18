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
import org.eclipse.graphiti.pattern.AbstractPattern;
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
import org.framed.iorm.ui.wizards.RoleModelWizard;

/**
 * TODO
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
		
	//TODO	
	public RoleGroupInRoleGroupPattern() {
		FEATURE_NAME = literals.ROLEGROUP_IN_RG_FEATURE_NAME;
		FPD = spec_FPD;
		ICON_IMG_ID = literals.ROLEGROUP_IN_RG_ICON_IMG_ID;
	}
	
	/**
	 * checks if pattern is applicable for a given business object
	 * @return true, if business object is a {@link org.framed.iorm.model.Shape} of type {@link Type#ROLE_GROUP} in a Role Group
	 */
	@Override
	public boolean isMainBusinessObjectApplicable(Object businessObject) {
		if(businessObject instanceof org.framed.iorm.model.Shape) {
			org.framed.iorm.model.Shape iormShape = (org.framed.iorm.model.Shape) businessObject;
			if(iormShape.getType() == modelType) {
				//TODO check for container, only unset if just created
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
	
	/**
	 * TODO
	 * adds the graphical representation of a role group to the pictogram model
	 * <p>
	 * It creates the following structure:<br>
	 * <ul>
	 *   <li>container shape</li>
	 * 	   <ul>
	 * 	     <li>occurrence constraint shape</li>
	 *         <ul><li>occurrence constraint text</li></ul>
	 * 		 <li>type body shape</li>
	 * 		   <ul><li>type body rectangle</li></ul>
	 * 		   <ul>
	 * 		     <li>name container</li>
	 * 			  <ul><li>name text</li></ul>
	 * 		   </ul>
	 * 	   </ul>
	 * </ul> 
	 * <p>
	 * The compartment types diagram will be created outside of the compartment types <em>container shape</em>. It can be 
	 * found as child of the <em>container diagram</em> of the role model. If its not clear what <em>container diagram</em> 
	 * means, see {@link RoleModelWizard#createEmfFileForDiagram} for reference.
	 * <p>
	 * It uses follows this steps:<br>
	 * Step 1: It gets the new object, the diagram to create the role group in and calculates the height and width 
	 * 		   of the role group representation.<br>
	 * Step 2: It creates the structure shown above.<br>
	 * Step 3: It sets the shape identifiers for the created graphics algorithms of the role group.<br>
	 * Step 4: It links the created shapes of the group to its business objects.<br> 
	 * Step 5: It enables direct editing, anchors and layouting of the role group. It also updates the group in which 
	 * 		   its created, if any.
	 */
	@Override
	public PictogramElement add(IAddContext addContext) {
		//Step 2
		//TODO doku because!
		Diagram targetDiagram = util.getRoleGroupDiagramForItsShape(addContext.getTargetContainer(), getDiagram());
		org.framed.iorm.model.Shape newRoleGroup = (org.framed.iorm.model.Shape) addContext.getNewObject();
		Model model = UIUtil.getLinkedModelForDiagram(targetDiagram);
		if(model == null) throw new NoModelFoundException();
		if(newRoleGroup.eResource() != null) targetDiagram.eResource().getContents().add(newRoleGroup);
		model.getElements().add(newRoleGroup);
		newRoleGroup.setContainer(model);
		
		//Step 1
		org.framed.iorm.model.Shape addedRoleGroup = (org.framed.iorm.model.Shape) addContext.getNewObject();
		
		int x =  addContext.getX() + targetDiagram.getGraphicsAlgorithm().getX(),
			y =  addContext.getY() + targetDiagram.getGraphicsAlgorithm().getY(),
			width = addContext.getWidth(), height = addContext.getHeight();
		if(addContext.getWidth() < literals.MIN_WIDTH) width = literals.MIN_WIDTH;
		if(addContext.getHeight() < literals.MIN_HEIGHT) height = literals.MIN_HEIGHT;
		
		//Step 2
		//container for body shape
		ContainerShape containerShape = pictogramElementCreateService.createContainerShape(targetDiagram, false);
			
		//occurence costraint
		Shape cardinalityShape = pictogramElementCreateService.createShape(containerShape, true);
		Text cardinalityText = graphicAlgorithmService.createText(cardinalityShape, addedRoleGroup.getDescription().getName());
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
		graphicAlgorithmService.setLocationAndSize(typeBodyRectangle, 
			x, y, 
			width, height);
				
		//name
		Shape nameShape = pictogramElementCreateService.createShape(typeBodyShape, false);
		Text text = graphicAlgorithmService.createText(nameShape, addedRoleGroup.getName());	
		text.setForeground(manageColor(literals.COLOR_TEXT));	
		text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);	
		graphicAlgorithmService.setLocationAndSize(text, 0, 0, width, literals.HEIGHT_NAME_SHAPE);	
				
		//role groups diagram
		Diagram contentDiagram = pictogramElementCreateService.createDiagram(UILiterals.DIAGRAM_TYPE_ID, addedRoleGroup.getName(), 10, true);
		graphicAlgorithmService.setLocationAndSize(contentDiagram.getGraphicsAlgorithm(), 
			x, y, 
			width, height);
		UIUtil.setDiagram_KindValue(contentDiagram, literals.DIAGRAM_KIND);
		link(contentDiagram, newRoleGroup.getModel());
		containerShape.getChildren().add(contentDiagram);
		
		//Step 3
		UIUtil.setShape_IdValue(containerShape, literals.SHAPE_ID_ROLEGROUP_CONTAINER);
		UIUtil.setShape_IdValue(typeBodyShape, literals.SHAPE_ID_ROLEGROUP_TYPEBODY);
		UIUtil.setShape_IdValue(nameShape, literals.SHAPE_ID_ROLEGROUP_NAME);
		UIUtil.setShape_IdValue(cardinalityShape, literals.SHAPE_ID_ROLEGROUP_OCCURRENCE_CONSTRAINT);
		
		//Step 4
		link(containerShape, addedRoleGroup);
		link(typeBodyShape, addedRoleGroup);
		link(nameShape, addedRoleGroup);
		link(cardinalityShape, addedRoleGroup);
		
		//Step 5
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
	 * disables that the user can move the drop shadow manually
	 * <p>
	 * Its also checks if the type body shape is moved onto the drop shadow shape and allows this. Therefore it takes
	 * and expands some code of {@link AbstractPattern#canMoveShape}.
	 */
	@Override
	public boolean canMoveShape(IMoveShapeContext moveContext) {
		ContainerShape sourcon = moveContext.getSourceContainer(),
				   	   tarcon = moveContext.getTargetContainer();
		return sourcon.getContainer().equals(util.getRoleGroupDiagramForItsShape(tarcon, getDiagram()));
	}
	
	//move the type body and its inner elements
	@Override
	public void moveShape(IMoveShapeContext moveContext) {
		ContainerShape typeBodyShape = (ContainerShape) moveContext.getPictogramElement();
		RoundedRectangle typeBodyRectangle = (RoundedRectangle) typeBodyShape.getGraphicsAlgorithm();
		Shape OCShape = (Shape) ((ContainerShape) typeBodyShape).getContainer().getChildren().get(0);
		Text OCText = (Text) OCShape.getGraphicsAlgorithm();
		Diagram diagram = util.getRoleGroupDiagramForItsShape(typeBodyShape, getDiagram());
		GraphicsAlgorithm diagramRectangle = diagram.getGraphicsAlgorithm();

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
		graphicAlgorithmService.setLocation(typeBodyRectangle, x, y);
		graphicAlgorithmService.setLocation(diagramRectangle, x, y);
		graphicAlgorithmService.setLocation(OCText, 
				x+typeBodyRectangle.getWidth()/2-literals.HEIGHT_OCCURRENCE_CONSTRAINT/2, 
				y-literals.HEIGHT_OCCURRENCE_CONSTRAINT-literals.PUFFER_BETWEEN_ELEMENTS);
		for(Shape innerShape : diagram.getChildren()) {
			if(innerShape instanceof ContainerShape) {
				ContainerShape innerTypeBody = (ContainerShape) ((ContainerShape) innerShape).getChildren().get(2);
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

