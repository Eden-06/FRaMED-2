package rolegroup;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IDirectEditingInfo;
import org.eclipse.graphiti.features.IMoveShapeFeature;
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
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.LineStyle;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.pattern.IPattern;
import org.framed.iorm.model.Model;
import org.framed.iorm.model.NamedElement;
import org.framed.iorm.model.OrmFactory;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.FRaMEDPropertyService;
import org.framed.iorm.ui.FRaMEDShapePattern;
import org.framed.iorm.ui.UILiterals;
import org.framed.iorm.ui.UIUtil;
import org.framed.iorm.ui.editPolicy.EditPolicyService;
import org.framed.iorm.ui.exceptions.NoModelFoundException;
import org.framed.iorm.ui.palette.FeaturePaletteDescriptor;
import org.framed.iorm.ui.palette.PaletteCategory;
import org.framed.iorm.ui.palette.PaletteView;
import org.framed.iorm.ui.palette.ViewVisibility;
import org.framed.iorm.ui.providers.FeatureProvider;

/**
 * This graphiti pattern class is used to work with {@link org.framed.iorm.model.Shape}s
 * of the type {@link Type#ROLE_GROUP} in the editor.
 * <p>
 * It deals with the following aspects of role groups:<br>
 * (1) adding a role group to the diagram, especially its pictogram elements<br>
 * (2) creating the role group, especially its business object<br>
 * (3) direct editing of the role groups name<br>
 * (4) layout the role group, especially setting it names and occurrence constraints text<br>
 * (5) updating the role groups name and occurrence constraint<br>
 * (6) moves the role group and its inner elements<br>
 * (7) resizes the role groups diagram with the type body<br>
 * (8) deletes its diagram and updates the element the role group is contained in
 * <p>
 * For operation that differ when a role group is in another role group see {@link RoleGroupInRoleGroupPattern}.
 * @author Kevin Kassin
 */
public class RoleGroupPattern extends FRaMEDShapePattern implements IPattern {

	/**
	 * the object to get names, ids and so on for this feature
	 */
	protected final Literals literals = new Literals();
	
	/**
	 * the object to call utility operations on
	 */
	protected final Util util = new Util();
		
	/**
	 * the feature palette descriptor manages the palette visibility, see {@link FeaturePaletteDescriptor}
	 */	
	private final FeaturePaletteDescriptor spec_FPD = new FeaturePaletteDescriptor(
		PaletteCategory.ENTITIES_CATEGORY,
		ViewVisibility.ALL_VIEWS) {
			@Override
			public boolean featureExpression(List<String> framedFeatureNames, PaletteView paletteView) {
				switch(paletteView) {
					case NON_COMPARTMENT_VIEW: return false;
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
	 * <p>
	 * Note: At creation of a role group there is no container of the iorm shape assigned. Therefore the else-branch uses
	 *       the {@link FRaMEDPropertyService} to get in which container a role group was created in. The property managed with the 
	 *       {@link FRaMEDPropertyService} is deleted when adding the role group. After that point in the life cycle of a 
	 *       role group the now set container is used to identify if this pattern is the right one to apply.
	 * @return true, if business object is a {@link org.framed.iorm.model.Shape} of type {@link Type#ROLE_GROUP}
	 */
	@Override
	public boolean isMainBusinessObjectApplicable(Object businessObject) {
		if(businessObject instanceof org.framed.iorm.model.Shape) {
			org.framed.iorm.model.Shape shape = (org.framed.iorm.model.Shape) businessObject;
			if(shape.getType() == modelType) {
				if(shape.getContainer() != null) {
					return shape.getContainer().getParent().getType() != Type.ROLE_GROUP;
				} else {	
					FRaMEDPropertyService framedPropertyService = ((FeatureProvider) getFeatureProvider()).getFRaMEDPropertyService();
					if(framedPropertyService.getIormShapeProperty(shape) instanceof Diagram)
						return true;
		}	}	}
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
		
	/**
	 * adds the graphical representation of a role group in a role group to the pictogram model
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
		org.framed.iorm.model.Shape newRoleGroup = (org.framed.iorm.model.Shape) addContext.getNewObject();
		FRaMEDPropertyService framedPropertyService = ((FeatureProvider) getFeatureProvider()).getFRaMEDPropertyService();
		framedPropertyService.deleteIormShapeProperty(newRoleGroup);
		Model model = UIUtil.getLinkedModelForDiagram(getDiagram());	
		if(model == null) throw new NoModelFoundException();
		if(newRoleGroup.eResource() != null) getDiagram().eResource().getContents().add(newRoleGroup);
		model.getElements().add(newRoleGroup);
		newRoleGroup.setContainer(model);
			
		//Step 2
		org.framed.iorm.model.Shape addedRoleGroup = (org.framed.iorm.model.Shape) addContext.getNewObject();
		Diagram targetDiagram = getDiagram();
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
		
		//Step 4
		UIUtil.setShape_IdValue(containerShape, literals.SHAPE_ID_ROLEGROUP_CONTAINER);
		UIUtil.setShape_IdValue(typeBodyShape, literals.SHAPE_ID_ROLEGROUP_TYPEBODY);
		UIUtil.setShape_IdValue(nameShape, literals.SHAPE_ID_ROLEGROUP_NAME);
		UIUtil.setShape_IdValue(cardinalityShape, literals.SHAPE_ID_ROLEGROUP_OCCURRENCE_CONSTRAINT);
		
		//Step 5
		link(containerShape, addedRoleGroup);
		link(typeBodyShape, addedRoleGroup);
		link(nameShape, addedRoleGroup);
		link(cardinalityShape, addedRoleGroup);
		
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
	 * 		 <li>(Model) role groups model</li> 
	 * 		 <li>(Description) role groups occurrence constraint</li>
	 * 	   </ul>
	 * </ul> 
	 * <p>
	 * It follows this steps:<br>
	 * Step 1: It creates the structure shown above.<br>
	 * Step 2: It sets uses the {@link FRaMEDPropertyService} to make the business objects target container available to the 
	 * 		   patterns that work with role groups. It also call the add function to add the pictogram elements of the role group.
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
		newRoleGroup.setModel(roleGroupModel);
			
		//occurence constraint
		NamedElement occurenceConstraint = OrmFactory.eINSTANCE.createNamedElement();
		occurenceConstraint.setName(literals.STANDARD_CARDINALITY);
		newRoleGroup.setDescription(occurenceConstraint);
						
		//Step 2
		FRaMEDPropertyService framedPropertyService = ((FeatureProvider) getFeatureProvider()).getFRaMEDPropertyService();
		framedPropertyService.setIormShapeProperty(newRoleGroup, createContext.getTargetContainer());
		addGraphicalRepresentation(createContext, newRoleGroup);
		return new Object[] { newRoleGroup };
	}	

	//direct editing
	//~~~~~~~~~~~~~~
	/**
	 * sets the editing type as a text field for the direct editing of the role group name and occurrence constraint
	 */
	@Override
	public int getEditingType() {
		return TYPE_TEXT;
	}
		
	/**
	 * calculates if a pictogram element of a role group can be direct edited
	 * <p>
	 * returns true if:<br>
	 * (1) the business object of the pictogram element is a {@link org.framed.iorm.model.Shape} 
	 * 	   of the type {@link Type#ROLE_GROUP} and<br>
	 * (2) the double clicked pictogram element is the name or the occurrence constraint
	 * @return if the selected pictogram can be direct edited
	 */
	@Override
	public boolean canDirectEdit(IDirectEditingContext editingContext) {
		PictogramElement pictogramElement = editingContext.getPictogramElement();
		if(pictogramElement instanceof Shape) {
		   if(UIUtil.isShape_IdValue((Shape) pictogramElement, literals.SHAPE_ID_ROLEGROUP_NAME) ||
			  UIUtil.isShape_IdValue((Shape) pictogramElement, literals.SHAPE_ID_ROLEGROUP_OCCURRENCE_CONSTRAINT))
			  return true;
		}   
		return false;
	}

	/**
	 * returns the current role groups name or occurrence constraint as initial value for direct editing
	 */
	@Override
	public String getInitialValue(IDirectEditingContext editingContext) {
		org.framed.iorm.model.Shape roleGroup = (org.framed.iorm.model.Shape) getBusinessObject(editingContext);
		PictogramElement pictogramElement = editingContext.getPictogramElement();
		if(UIUtil.isShape_IdValue((Shape) pictogramElement, literals.SHAPE_ID_ROLEGROUP_NAME)) 
			return roleGroup.getName();
		if(UIUtil.isShape_IdValue((Shape) pictogramElement, literals.SHAPE_ID_ROLEGROUP_OCCURRENCE_CONSTRAINT))
			return roleGroup.getDescription().getName();
		return null;
	}
		
	/**
	 * calculates if a chosen value for the role group's name or occurrence constraint is valid
	 * @return if a chosen value for the role group's name or occurrence constraint is valid
	 */
	@Override
	public String checkValueValid(String newValue, IDirectEditingContext editingContext) {
		PictogramElement pictogramElement = editingContext.getPictogramElement();
		if(getInitialValue(editingContext).contentEquals(newValue)) return null;
		if(UIUtil.isShape_IdValue((Shape) pictogramElement, literals.SHAPE_ID_ROLEGROUP_NAME)) {
			if(!(util.matchesRoleGroupName(newValue))) return literals.DIRECTEDITING_ROLEGROUP;
			if(UIUtil.nameAlreadyUsedRoleModelWide(getDiagram(), modelType, newValue)) 
				return literals.NAME_ALREADY_USED_ROLEGROUP;
		}	
		if(UIUtil.isShape_IdValue((Shape) pictogramElement, literals.SHAPE_ID_ROLEGROUP_OCCURRENCE_CONSTRAINT)) {
			if(!(UIUtil.matchesCardinality(newValue))) return literals.DIRECTEDITING_OCCURRENCE_CONSTRAINT;
		}
		return null;
	}
		
	/**
	 * sets value of the role groups name or occurrence constraint, updates its own pictogram element and a grouping 
	 * features object in which its in, if any
	 */
	@Override
	public void setValue(String value, IDirectEditingContext editingContext) {	     
		org.framed.iorm.model.Shape roleGroup = (org.framed.iorm.model.Shape) getBusinessObject(editingContext);
		Shape shape = (Shape) editingContext.getPictogramElement();
		if(UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_ROLEGROUP_NAME)) {
			roleGroup.setName(value);
			updatePictogramElement(((Shape) editingContext.getPictogramElement()).getContainer());
			updateContainingGroupingFeaturesObject();
		}	
		if(UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_ROLEGROUP_OCCURRENCE_CONSTRAINT)) {
			roleGroup.getDescription().setName(value);
			for(Shape containerChild : shape.getContainer().getChildren()) {
				if(!(containerChild instanceof Diagram)) {
		    		if(UIUtil.isShape_IdValue(containerChild, literals.SHAPE_ID_ROLEGROUP_TYPEBODY)) 
		    			updatePictogramElement(containerChild);
	}	}	}	}
	
	//layout feature
	//~~~~~~~~~~~~~~
	/**
	 * calculates if a pictogram element of a role group can be layouted
	 * <p>
	 * returns true if:<br>
	 * (1) if exactly one pictogram element is given by the layout context
	 * (2) the business object of the pictogram element is a {@link org.framed.iorm.model.Shape} 
	 * 	   of the type {@link Type#ROLE_GROUP} 
	 * @return if the given pictogram can be layouted
	 */
	@Override
	public boolean canLayout(ILayoutContext layoutContext) {
		PictogramElement element = layoutContext.getPictogramElement();
		if(element instanceof ContainerShape) {
			EList<EObject> businessObjects = element.getLink().getBusinessObjects();
			if(businessObjects.size()==1) {
				if(businessObjects.get(0) instanceof org.framed.iorm.model.Shape) {
					org.framed.iorm.model.Shape shape = (org.framed.iorm.model.Shape) businessObjects.get(0);
					if(shape.getType() == modelType) return true;
		}	}	}
		return false;
	}
	
	/**
	 * layouts the whole role group using the following steps:
	 * <p>
	 * Step 1: Its fetches the type body shape and drop shadow shape<br>
	 * Step 2: It calculates the new height, width and horizontal center. It also uses this data to set
	 * 		   the size of the type body and drop shadow shape.<br>
	 * Step 3: It now iterates over all shapes of the role group:<br>
	 * (a) It sets the width of the names shape.<br>
	 * TODO: occurence set
	 * <p>
	 * If its not clear what the different shapes means, see {@link #add} for reference.
	 */
	@Override
	public boolean layout(ILayoutContext layoutContext) {
		boolean layoutChanged = false;
		ContainerShape container = (ContainerShape) layoutContext.getPictogramElement();
		//Step 1
		if(!(UIUtil.isShape_IdValue(container, literals.SHAPE_ID_ROLEGROUP_TYPEBODY))) return false;
		else {
			RoundedRectangle typeBodyRectangle = (RoundedRectangle) container.getGraphicsAlgorithm();
		    //Step 2
		    if(typeBodyRectangle.getWidth() < literals.MIN_WIDTH) typeBodyRectangle.setWidth(literals.MIN_WIDTH);
		    if(typeBodyRectangle.getHeight() < literals.MIN_HEIGHT) typeBodyRectangle.setHeight(literals.MIN_HEIGHT);
			int width = typeBodyRectangle.getWidth();
		    //Step 3    
		    for (Shape shape : container.getChildren()){
		    	GraphicsAlgorithm graphicsAlgorithm = shape.getGraphicsAlgorithm(); 
		    	//(a) name shape
 		        if (graphicsAlgorithm instanceof Text) {
		        	Text text = (Text) graphicsAlgorithm;	
		        	if(UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_ROLEGROUP_NAME)) {
		        		graphicAlgorithmService.setLocationAndSize(text, 0, 0, width, literals.HEIGHT_NAME_SHAPE);
		            	layoutChanged=true;
		        	}
		}	}	}  
	    return layoutChanged;
	}
	
	//update feature
	//~~~~~~~~~~~~~~
	@Override
	public boolean canUpdate(IUpdateContext updateContext) {
		//check if object to update is a role group
		PictogramElement pictogramElement = updateContext.getPictogramElement();
		Object businessObject =  getBusinessObjectForPictogramElement(pictogramElement);
		if(businessObject instanceof org.framed.iorm.model.Shape) {
			org.framed.iorm.model.Shape shape = (org.framed.iorm.model.Shape) businessObject;
			if(shape.getType() == modelType) {
				return true;
		}	}
		return false;
	}

	@Override
	public IReason updateNeeded(IUpdateContext updateContext) {
		PictogramElement pictogramElement = updateContext.getPictogramElement();
	
		if(UIUtil.isShape_IdValue((Shape) pictogramElement, literals.SHAPE_ID_ROLEGROUP_TYPEBODY)) {
			//pictogram name
			String pictogramTypeName = util.getNameOfPictogramElement(pictogramElement);
			String pictogramOccurrenceConstraint = util.getOccurenceConstraintOfPictogramElement(pictogramElement);
			//business name and attributes
			String businessTypeName = UIUtil.getNameOfBusinessObject(getBusinessObjectForPictogramElement(pictogramElement));
			String businessTypeOccurrenceConstraint = UIUtil.getOccurrenceConstraintOfBusinessObject(getBusinessObjectForPictogramElement(pictogramElement));
			
			//check for update: different names, different occurence constraint
			if(pictogramTypeName==null || businessTypeName==null) return Reason.createTrueReason(literals.REASON_NAME_NULL);
			if(!(pictogramTypeName.equals(businessTypeName))) return Reason.createTrueReason(literals.REASON_NAME_OUT_OF_DATE);
			if(!pictogramOccurrenceConstraint.equals(businessTypeOccurrenceConstraint)) return Reason.createTrueReason(literals.REASON_OCCURRENCE_CONSTRAINTS);
		}
		return Reason.createFalseReason();
	}
			
	@Override
	public boolean update(IUpdateContext updateContext) {
		boolean changed = false;
	         
		PictogramElement pictogramElement = updateContext.getPictogramElement();
			
		//business names of natural type, attributes and operations
		String businessTypeName = UIUtil.getNameOfBusinessObject(getBusinessObjectForPictogramElement(pictogramElement));
		String businessTypeOccurrenceConstraint = UIUtil.getOccurrenceConstraintOfBusinessObject(getBusinessObjectForPictogramElement(pictogramElement));	
			
		//set type and diagram name in pictogram model
	    if (pictogramElement instanceof ContainerShape) {     
	    	ContainerShape typeBodyShape = (ContainerShape) pictogramElement;
	    	//occurrence
		   	for(Shape containerChild : typeBodyShape.getContainer().getChildren()) {
		   		if(!(containerChild instanceof Diagram)) {
		   			if(UIUtil.isShape_IdValue(containerChild, literals.SHAPE_ID_ROLEGROUP_OCCURRENCE_CONSTRAINT)) 
		   				((Text) containerChild.getGraphicsAlgorithm()).setValue(businessTypeOccurrenceConstraint);
		   	}	}
        	Diagram diagram = util.getRoleGroupDiagramForItsShape(typeBodyShape, getDiagram());
	        for (Shape shape : typeBodyShape.getChildren()) {
	        	if (shape.getGraphicsAlgorithm() instanceof Text) {
	        		Text text = (Text) shape.getGraphicsAlgorithm();
	                if(UIUtil.isShape_IdValue(shape, literals.SHAPE_ID_ROLEGROUP_NAME)) {
	                	diagram.setName(businessTypeName);
	                	//change group name
	                	text.setValue(businessTypeName);
	                	changed = true;
	        }   }	} 	
	        layoutPictogramElement(typeBodyShape);
	    }	      
	    return changed;
	}	
	
	//move feature
	//~~~~~~~~~~~~
			
	/**
	 * moves a role group in a role group by following these steps:
	 * <p>
	 * Step 1: It gets the pictogram shapes and graphic algorithms of the role group.<br>
	 * Step 2: Its sets the role groups graphic algorithms to its changed coordinates.<br>
	 * Step 3: It creates move contexts for its inner elements and calls their move operations.
	 */
	@Override
	public void moveShape(IMoveShapeContext moveContext) {
		if(UIUtil.isShape_IdValue((Shape) moveContext.getPictogramElement(), literals.SHAPE_ID_ROLEGROUP_OCCURRENCE_CONSTRAINT))
			super.moveShape(moveContext);
		else {
			//Step 1
			ContainerShape typeBodyShape = (ContainerShape) moveContext.getPictogramElement();
			Shape OCShape = (Shape) ((ContainerShape) typeBodyShape).getContainer().getChildren().get(0);
			Text OCText = (Text) OCShape.getGraphicsAlgorithm();
			Diagram diagram = util.getRoleGroupDiagramForItsShape(typeBodyShape, getDiagram());
			GraphicsAlgorithm diagramRectangle = diagram.getGraphicsAlgorithm();
					
			//Step 2
			if(moveContext.getSourceContainer().equals(moveContext.getTargetContainer())) {
				graphicAlgorithmService.setLocation(OCText, OCText.getX() + moveContext.getDeltaX(), OCText.getY() + moveContext.getDeltaY());
				graphicAlgorithmService.setLocation(diagramRectangle, moveContext.getX(), moveContext.getY());
				//Step 3
				for(Shape innerShape : diagram.getChildren()) {
					if(innerShape instanceof ContainerShape) {
						//TODO better
						ContainerShape innerTypeBody;
						if(UIUtil.isShape_IdValue(innerShape, "shape_rt_container")) {
							innerTypeBody = (ContainerShape) ((ContainerShape) innerShape).getChildren().get(2);
						} else {
							innerTypeBody = (ContainerShape) ((ContainerShape) innerShape).getChildren().get(1);
						}
						MoveShapeContext moveContextForInnerShape = new MoveShapeContext(innerTypeBody);
						moveContextForInnerShape.setDeltaX(moveContext.getDeltaX());
						moveContextForInnerShape.setDeltaY(moveContext.getDeltaY());
						moveContextForInnerShape.setTargetContainer(typeBodyShape);
						moveContextForInnerShape.setSourceContainer((ContainerShape) innerShape);
						moveContextForInnerShape.putProperty("automated", true);
						IMoveShapeFeature moveFeature = getFeatureProvider().getMoveShapeFeature(moveContextForInnerShape);
						if(moveFeature.canMoveShape(moveContextForInnerShape)) moveFeature.moveShape(moveContextForInnerShape);
				}	}
				super.moveShape(moveContext);
				getDiagramBehavior().refresh();
		}	}
	}
	
	
	//resize feature
	//~~~~~~~~~~~~~~
	/**
	 * disables that the user can resize the occurrence constraint manually
	 */
	@Override
	public boolean canResizeShape(IResizeShapeContext resizeContext) {
		if(UIUtil.isShape_IdValue((Shape) resizeContext.getPictogramElement(), literals.SHAPE_ID_ROLEGROUP_OCCURRENCE_CONSTRAINT))
			return false;
		return super.canResizeShape(resizeContext);
	}
	
	/**
	 * when resizing the type body, resize the role groups diagram also
	 */
	public void resizeShape(IResizeShapeContext resizeContext) {
		super.resizeShape(resizeContext);
		ContainerShape typeBodyShape = (ContainerShape) resizeContext.getPictogramElement();
		Diagram diagram = util.getRoleGroupDiagramForItsShape(typeBodyShape, getDiagram());
		graphicAlgorithmService.setLocationAndSize(diagram.getGraphicsAlgorithm(), 
			resizeContext.getX(), resizeContext.getY(), 
			resizeContext.getWidth(), resizeContext.getHeight());
		getDiagramBehavior().refresh();
	}

	//delete feature
	//~~~~~~~~~~~~~~
	/**
	 * disables that the user can delete the occurrence constraint manually
	 */
	@Override
	public boolean canDelete(IDeleteContext deleteContext) {
		if(UIUtil.isShape_IdValue((Shape) deleteContext.getPictogramElement(), literals.SHAPE_ID_ROLEGROUP_OCCURRENCE_CONSTRAINT)) 
			return false;
		return super.canDelete(deleteContext);
	}
			
	/**
	 * deletes the group as cares about all related concerns using the following steps
	 * <p>
	 * Step 1: It deletes attached connection to it.<br>
	 * Step 2: It gets the role groups diagram and creates a {@link DeleteContext} for it.<br>
	 * Step 3: It gets the container shape of the group, so this can be deleted instead of the type body shape.<br>
	 * Step 4: It deletes the shapes gathered in Step 2 and 3. It also updates a group in which the group is in, if any.
	 * <p>
	 * If its not clear what the different shapes means, see {@link #add} for reference.
	 */
	@Override
	public void delete(IDeleteContext deleteContext) {
		//Step 1
		deleteAttachedConnections(deleteContext);
		//Step 2
		Diagram diagram = util.getRoleGroupDiagramForItsShape((Shape) deleteContext.getPictogramElement(), getDiagram());
		if(diagram != null) {	
			DeleteContext deleteContextForGroupingDiagram = new DeleteContext(diagram);
			deleteContextForGroupingDiagram.setMultiDeleteInfo(new MultiDeleteInfo(false, false, 0));
			//Step 3
			ContainerShape containerShape = (ContainerShape) ((ContainerShape) deleteContext.getPictogramElement()).getContainer();
			DeleteContext deleteContextForAllShapes = new DeleteContext(containerShape);
			deleteContextForAllShapes.setMultiDeleteInfo(new MultiDeleteInfo(false, false, 0));
			//Step 4
			super.delete(deleteContextForAllShapes);
			updateContainingGroupingFeaturesObject();
		}
	}
}
	