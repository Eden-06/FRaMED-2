package rolegroup;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IDirectEditingInfo;
import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.DeleteContext;
import org.eclipse.graphiti.features.context.impl.MoveShapeContext;
import org.eclipse.graphiti.features.context.impl.MultiDeleteInfo;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.pattern.AbstractPattern;
import org.eclipse.graphiti.pattern.IPattern;
import org.eclipse.graphiti.ui.editor.DiagramEditorInput;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.framed.iorm.model.Model;
import org.framed.iorm.model.ModelElement;
import org.framed.iorm.model.OrmFactory;
import org.framed.iorm.model.Segment;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.FRaMEDShapePattern;
import org.framed.iorm.ui.UILiterals;
import org.framed.iorm.ui.UIUtil;
import org.framed.iorm.ui.editPolicy.EditPolicyService;
import org.framed.iorm.ui.exceptions.NoDiagramFoundException;
import org.framed.iorm.ui.palette.FeaturePaletteDescriptor;
import org.framed.iorm.ui.palette.PaletteCategory;
import org.framed.iorm.ui.palette.PaletteView;
import org.framed.iorm.ui.palette.ViewVisibility;
import org.framed.iorm.ui.references.AbstractAttributeAndOperationReference;
import org.framed.iorm.ui.references.AbstractGroupingFeatureReference;
import org.framed.iorm.ui.references.AbstractStepInReference;
import org.framed.iorm.ui.wizards.RoleModelWizard;

/**
 * This graphiti pattern class is used to work with {@link org.framed.iorm.model.Shape}s
 * of the type {@link Type#COMPARTMENT_TYPE} in the editor.
 * <p>
 * It deals with the following aspects of compartment types:<br>
 * (1) adding a compartment type to the diagram, especially its pictogram elements<br>
 * (2) creating the compartment type, especially its business object<br>
 * (3) direct editing of the compartment types name<br>
 * (4) layout the group, especially setting lines, attributes, operations and  group elements at the right positions<br>
 * (5) updating the groups name, attributes, operations and its content overview<br>
 * (6) moves the drop shadow with the type body and disables moving the drop shadow manually<br>
 * (7) resizes the drop shadow with the type body and disables resizing the drop shadow manually<br>
 * (8) deleting all the compartments pictogram elements and its diagram, also disables deleting the drop 
 *     shadow manually
 * @author Kevin Kassin
 */
public class RoleGroupPattern extends FRaMEDShapePattern implements IPattern {

	/**
	 * the object to get names, ids and so on for this feature
	 */
	private final Literals literals = new Literals();
	
	/**
	 * the object to call utility operations on
	 */
	private final Util util = new Util();
	
	/**
	 * the feature palette descriptor manages the palette visibility, see {@link FeaturePaletteDescriptor}
	 */	
	private final FeaturePaletteDescriptor spec_FPD = new FeaturePaletteDescriptor(
		PaletteCategory.ENTITIES_CATEGORY,
		ViewVisibility.ALL_VIEWS) {
			@Override
			public boolean featureExpression(List<String> framedFeatureNames, PaletteView paletteView) {
				switch(paletteView) {
					case TOPLEVEL_VIEW: return false;
					case COMPARTMENT_VIEW: return framedFeatureNames.contains("Group_Constraints");
					default: return false;
		}	}	};
	
	/**
	 * class constructor		
	 */
	public RoleGroupPattern() {
		super();
		FEATURE_NAME = literals.FEATURE_NAME;
		ICON_IMG_ID = literals.ICON_IMG_ID;
		ICON_IMG_PATH = literals.ICON_IMG_PATH;
		modelType = Type.ROLE_GROUP;
		FPD = spec_FPD;
	}
	
	/**
	 * checks if pattern is applicable for a given business object
	 * @return true, if business object is a {@link org.framed.iorm.model.Shape} of type {@link Type#ROLE_GROUP}
	 */
	@Override
	public boolean isMainBusinessObjectApplicable(Object businessObject) {
		if(businessObject instanceof org.framed.iorm.model.Shape) {
			org.framed.iorm.model.Shape shape = (org.framed.iorm.model.Shape) businessObject;
			if(shape.getType() == modelType) return true;
		}
		return false;
	}

	/**
	 * checks if pattern is applicable for a given pictogram element
	 * @return true, if business object of the pictogram element is a {@link org.framed.iorm.model.Shape} of type {@link Type#ROLE_GROUP}
	 */
	@Override
	protected boolean isPatternControlled(PictogramElement pictogramElement) {
		Object businessObject = getBusinessObjectForPictogramElement(pictogramElement);
		return isMainBusinessObjectApplicable(businessObject);
	}

	/**
	 * checks if the pictogram element to edit with the pattern is its root
	 * @return true, if business object of the pictogram element is a {@link org.framed.iorm.model.Shape} of type {@link Type#ROLE_GROUP}
	 */
	@Override
	protected boolean isPatternRoot(PictogramElement pictogramElement) {
		Object businessObject = getBusinessObjectForPictogramElement(pictogramElement);
		return isMainBusinessObjectApplicable(businessObject);
	}
	
	// add feature
	//~~~~~~~~~~~~~
	/**
	 * calculates if the role group can be added to the diagram
	 * <p>
	 * returns true if:<br>
	 * (1) if the added business object is a role group and <br>
	 * (2) if the target container is a diagram with a model linked
	 * @return if the rolegroup can be added
	 */
	@Override
	public boolean canAdd(IAddContext addContext) {
		if(addContext.getNewObject() instanceof org.framed.iorm.model.Shape) {
			org.framed.iorm.model.Shape shape = (org.framed.iorm.model.Shape) addContext.getNewObject();
			if(shape.getType()==modelType) {
				if(UIUtil.getLinkedModelForDiagram(getDiagram()) != null) {
					   return EditPolicyService.canAdd(addContext, this.getDiagram());
		}	}	}
		return false;
	}
	
//TODO: DOKU READY
//TODO: IMPL READY	
	
	/**
	 * TODO
	 */
	@Override
	public PictogramElement add(IAddContext addContext) {
		/*
		//Step 1
		org.framed.iorm.model.Shape addedCompartmentType = (org.framed.iorm.model.Shape) addContext.getNewObject();
		ContainerShape targetDiagram = getDiagram();
		int width = addContext.getWidth(), height = addContext.getHeight();
		if(addContext.getWidth() < literals.MIN_WIDTH) width = literals.MIN_WIDTH;
		if(addContext.getHeight() < literals.MIN_HEIGHT) height = literals.MIN_HEIGHT;
				
		//Step 2
		//container for body shape and shadow
		ContainerShape containerShape = pictogramElementCreateService.createContainerShape(targetDiagram, false);
							  
		//drop shadow
		ContainerShape dropShadowShape = pictogramElementCreateService.createContainerShape(containerShape, true);
		Rectangle dropShadowRectangle = graphicAlgorithmService.createRectangle(dropShadowShape);
		dropShadowRectangle.setForeground(manageColor(literals.COLOR_SHADOW));
		dropShadowRectangle.setBackground(manageColor(literals.COLOR_SHADOW));
		graphicAlgorithmService.setLocationAndSize(dropShadowRectangle, addContext.getX()+literals.SHADOW_SIZE, addContext.getY()+literals.SHADOW_SIZE, width, height);
				
		//body shape of type
		ContainerShape typeBodyShape = pictogramElementCreateService.createContainerShape(containerShape, true);		
		Rectangle typeBodyRectangle = graphicAlgorithmService.createRectangle(typeBodyShape);
		typeBodyRectangle.setForeground(manageColor(literals.COLOR_LINES));
		typeBodyRectangle.setBackground(manageColor(literals.COLOR_BACKGROUND));
		graphicAlgorithmService.setLocationAndSize(typeBodyRectangle, addContext.getX(), addContext.getY(), width, height);
				
		//name
		Shape nameShape = pictogramElementCreateService.createShape(typeBodyShape, false);
		Text text = graphicAlgorithmService.createText(nameShape, addedCompartmentType.getName());	
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
		int horizontalFirstThird = util.calculateHorizontaltFirstThird(height);
		graphicAlgorithmService.setLocationAndSize(attributeRectangle, literals.PUFFER_BETWEEN_ELEMENTS, literals.HEIGHT_NAME_SHAPE+literals.PUFFER_BETWEEN_ELEMENTS, 
												   width-2*literals.PUFFER_BETWEEN_ELEMENTS, horizontalFirstThird-literals.HEIGHT_NAME_SHAPE-2*literals.PUFFER_BETWEEN_ELEMENTS);
		//second line
		Shape secondLineShape = pictogramElementCreateService.createShape(typeBodyShape, false);	
		Polyline secondPolyline = graphicAlgorithmService.createPolyline(secondLineShape, new int[] {0, horizontalFirstThird, width, horizontalFirstThird});
		secondPolyline.setForeground(manageColor(literals.COLOR_LINES));
				
		//operation container
		ContainerShape operationContainer = pictogramElementCreateService.createContainerShape(typeBodyShape, false);
		Rectangle operationRectangle = graphicAlgorithmService.createRectangle(operationContainer);
		operationRectangle.setLineVisible(false);
		operationRectangle.setBackground(manageColor(literals.COLOR_BACKGROUND));
		graphicAlgorithmService.setLocationAndSize(operationRectangle, literals.PUFFER_BETWEEN_ELEMENTS, horizontalFirstThird+literals.PUFFER_BETWEEN_ELEMENTS, 
											 	   width-2*literals.PUFFER_BETWEEN_ELEMENTS, horizontalFirstThird-literals.HEIGHT_NAME_SHAPE-2*literals.PUFFER_BETWEEN_ELEMENTS);
		
		//third line
		Shape thirdLineShape = pictogramElementCreateService.createShape(typeBodyShape, false);	
		int horizontalSecondThird = util.calculateHorizontaltSecondThird(height);
		Polyline thirdPolyline = graphicAlgorithmService.createPolyline(thirdLineShape, new int[] {0, horizontalSecondThird, width, horizontalSecondThird});
		thirdPolyline.setForeground(manageColor(literals.COLOR_LINES));
			
		//model content preview container
		ContainerShape modelContainer = pictogramElementCreateService.createContainerShape(typeBodyShape, false);
		Rectangle modelRectangle = graphicAlgorithmService.createRectangle(modelContainer);
		modelRectangle.setLineVisible(false);
		modelRectangle.setBackground(manageColor(literals.COLOR_BACKGROUND));
		graphicAlgorithmService.setLocationAndSize(modelRectangle, literals.PUFFER_BETWEEN_ELEMENTS, horizontalSecondThird+literals.PUFFER_BETWEEN_ELEMENTS, 
												   width-2*literals.PUFFER_BETWEEN_ELEMENTS, horizontalFirstThird-literals.HEIGHT_NAME_SHAPE-2*literals.PUFFER_BETWEEN_ELEMENTS);	
		
		//groups diagram
		Diagram contentDiagram = pictogramElementCreateService.createDiagram(UILiterals.DIAGRAM_TYPE_ID, addedCompartmentType.getName(), 10, true);
		UIUtil.setDiagram_KindValue(contentDiagram, literals.DIAGRAM_KIND);
		AddCompartmentTypeContext agctc = (AddCompartmentTypeContext) addContext;
		link(contentDiagram, agctc.getModelToLink());
		getDiagram().getContainer().getChildren().add(contentDiagram);
		
		//Step 3
		UIUtil.setShape_IdValue(containerShape, literals.SHAPE_ID_COMPARTMENTTYPE_CONTAINER);
		UIUtil.setShape_IdValue(typeBodyShape, literals.SHAPE_ID_COMPARTMENTTYPE_TYPEBODY);
		UIUtil.setShape_IdValue(dropShadowShape, literals.SHAPE_ID_COMPARTMENTTYPE_SHADOW);
		UIUtil.setShape_IdValue(nameShape, literals.SHAPE_ID_COMPARTMENTTYPE_NAME);
		UIUtil.setShape_IdValue(firstLineShape, literals.SHAPE_ID_COMPARTMENTTYPE_FIRSTLINE);
		UIUtil.setShape_IdValue(attributeContainer, literals.SHAPE_ID_COMPARTMENTTYPE_ATTRIBUTECONTAINER);
		UIUtil.setShape_IdValue(secondLineShape, literals.SHAPE_ID_COMPARTMENTTYPE_SECONDLINE);
		UIUtil.setShape_IdValue(operationContainer, literals.SHAPE_ID_COMPARTMENTTYPE_OPERATIONCONTAINER);
		UIUtil.setShape_IdValue(thirdLineShape, literals.SHAPE_ID_COMPARTMENTTYPE_THIRDLINE);
		UIUtil.setShape_IdValue(modelContainer, literals.SHAPE_ID_COMPARTMENTTYPE_CONTENT_PREVIEW);
		
		//Step 4
		link(containerShape, addedCompartmentType);
		link(typeBodyShape, addedCompartmentType);
		link(dropShadowShape, addedCompartmentType);
		link(nameShape, addedCompartmentType);
		link(firstLineShape, addedCompartmentType);
		link(attributeContainer, addedCompartmentType);
		link(secondLineShape, addedCompartmentType);
		link(operationContainer, addedCompartmentType);
		link(thirdLineShape, addedCompartmentType);
		link(modelContainer, addedCompartmentType);
		
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
		*/
		return null;
	}
	
	//create feature
	//~~~~~~~~~~~~~~
	/**
	 * calculates if a role group can be created
	 * <p>
	 * returns true if:<br>
	 * (1) the target container is a diagram with a model linked
	 * @return if an role group can be created
	 */
	@Override
	public boolean canCreate(ICreateContext createContext) {
		if(UIUtil.getLinkedModelForDiagram(getDiagram()) != null) {
			return EditPolicyService.canCreate(createContext, this.getDiagram());
		}   
		return false;
	}
	
	/**
	 * creates the business objects of the role group, adds it to model of the diagram in which the role group is 
	 * created in and calls the add function for the role group
	 * <p>
	 * It creates the following structure:<br>
	 * <ul>
	 *   <li>(org.framed.iorm.model.Shape) role group</li>
	 * 	   <ul>
	 * 		 <li>(Model) compartment types model</li> 
	 * 	   </ul>
	 * </ul> 
	 * <p>
	 * It follows this steps:<br>
	 * Step 1: It creates the structure shown above.<br>
	 * Step 2: It adds the new role group to the elements of the model of the diagram in which its created.<br>
	 * Step 3: It call the add function to add the pictogram elements of the role group using a 
	 * 		   {@link AddRoleGroupContext}.
	 * @return the created business object of the role group
	 */
	@Override
	public Object[] create(ICreateContext createContext) {
		//Step 1
		//compartment type
		org.framed.iorm.model.Shape newRoleGroup = OrmFactory.eINSTANCE.createShape();
		newRoleGroup.setType(modelType);
		String standardName = UIUtil.calculateStandardNameDiagramWide(getDiagram(), modelType, literals.STANDARD_NAME);
		newRoleGroup.setName(standardName);
		
		//model
		Model roleGroupModel = OrmFactory.eINSTANCE.createModel();
		getDiagram().eResource().getContents().add(roleGroupModel);
		newRoleGroup.setModel(roleGroupModel);
		
		//Step 2
		Model model = UIUtil.getLinkedModelForDiagram(getDiagram());
		if(newRoleGroup.eResource() != null) getDiagram().eResource().getContents().add(newRoleGroup);
		model.getElements().add(newRoleGroup);
		newRoleGroup.setContainer(model);
	
		//Step 3
		AddRoleGroupContext argc = new AddRoleGroupContext();
		UIUtil.getAddContextForCreateShapeContext(argc, createContext);
		argc.setNewObject(newRoleGroup);
		argc.setModelToLink(roleGroupModel);
		if(canAdd(argc)) add(argc);
		return new Object[] { newRoleGroup };
	}
}	
	