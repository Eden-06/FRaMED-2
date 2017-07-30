package org.framed.iorm.ui.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDoubleClickContext;
import org.eclipse.graphiti.features.context.IPictogramElementContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.palette.IPaletteCompartmentEntry;
import org.eclipse.graphiti.palette.impl.ConnectionCreationToolEntry;
import org.eclipse.graphiti.palette.impl.ObjectCreationToolEntry;
import org.eclipse.graphiti.palette.impl.PaletteCompartmentEntry;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IContextButtonPadData;
import org.eclipse.graphiti.tb.IContextMenuEntry;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.literals.NameLiterals;
import org.framed.iorm.ui.palette.FeatureManager;
import org.framed.iorm.ui.palette.FeaturePaletteDescriptor;
import org.framed.iorm.ui.palette.PaletteView;
import org.framed.iorm.ui.palette.ViewVisibility;
import org.framed.iorm.ui.util.DiagramUtil;
import org.framed.iorm.ui.util.GeneralUtil;
import org.framed.iorm.ui.util.PropertyUtil;
import org.framed.iorm.ui.providers.FeatureProvider; //*import for javadoc link
import org.framed.iorm.model.Relation;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.exceptions.FeatureHasNoPaletteDescriptorException;
import org.framed.iorm.ui.graphitifeatures.EditRelationshipFeature;
import org.framed.iorm.ui.graphitifeatures.StepInFeature; //*import for javadoc link
import org.framed.iorm.ui.graphitifeatures.StepInNewTabFeature; //*import for javadoc link
import org.framed.iorm.ui.graphitifeatures.StepOutFeature; //*import for javadoc link

/**
 * This class enables context buttons and can manipulate the palette of the editor.
 * @author Kevin Kassin
 */
public class ToolBehaviorProvider extends DefaultToolBehaviorProvider{
		
	/**
	 * names for the palette categories gathered from {@link NameLiterals}
	 */
	private final String ENTITIES_PALETTE_CATEGORY_NAME = NameLiterals.ENTITIES_PALETTE_CATEGORY_NAME,
						 PROPERTIES_PALETTE_CATEGORY_NAME = NameLiterals.PROPERTIES_PALETTE_CATEGORY_NAME,
						 RELATIONS_PALETTE_CATEGORY_NAME = NameLiterals.RELATIONS_PALETTE_CATEGORY_NAME,
						 CONSTRAINTS_PALETTE_CATEGORY_NAME = NameLiterals.CONSTRAINTS_PALETTE_CATEGORY_NAME;
	
	/**
	 * the value for the property diagram kind to identify diagrams belonging to a group or compartment type gathered
	 * from {@link IdentiferLiterals}
	 */
	private final String DIAGRAM_KIND_GROUP_DIAGRAM = IdentifierLiterals.DIAGRAM_KIND_GROUP_DIAGRAM,
						 DIAGRAM_KIND_COMPARTMENT_DIAGRAM = IdentifierLiterals.DIAGRAM_KIND_COMPARTMENTTYPE_DIAGRAM;
	
	/**
	 * the name literals for features to probaly add to the context menu for the diagram type
	 * gathered from {@link NameLiterals}
	 */
	private final String CHANGE_CONFIGURATION_FEATURE_NAME = NameLiterals.CHANGE_CONFIGURATION_FEATURE_NAME,
						 EDIT_RELATIONSHIP_FEATURE_NAME = NameLiterals.EDIT_RELATIONSHIP_FEATURE_NAME,
					     EDIT_FULFILLMENT_FEATURE_NAME = NameLiterals.EDIT_FULFILLMENT_FEATURE_NAME,
						 STEP_IN_FEATURE_NAME = NameLiterals.STEP_IN_FEATURE_NAME,
						 STEP_IN_NEW_TAB_FEATURE_NAME = NameLiterals.STEP_IN_NEW_TAB_FEATURE_NAME,
						 STEP_OUT_FEATURE_NAME = NameLiterals.STEP_OUT_FEATURE_NAME,
						 RESET_LAYOUT_FEATURE_NAME = NameLiterals.RESET_LAYOUT_FEATURE_NAME;
	
	/**
	 * the shape identifiers of the shapes the step in feature can be used on gathered from {@link IdentifierLiterals}
	 * <p>
	 * can be:<br>
	 * (1) the shape identifier of type body rectangle of a group or<br>
	 * (2) the shape identifier of type body rectangle of a compartment type
	 */
	private final String SHAPE_ID_GROUP_TYPEBODY = IdentifierLiterals.SHAPE_ID_GROUP_TYPEBODY,
						 SHAPE_ID_COMPARTMENTTYPE_TYPEBODY = IdentifierLiterals.SHAPE_ID_COMPARTMENTTYPE_TYPEBODY;
	
	private final String SHAPE_ID_ROLETYPE_TYPEBODY = IdentifierLiterals.SHAPE_ID_ROLETYPE_TYPEBODY,
						 SHAPE_ID_ROLETYPE_OC = IdentifierLiterals.SHAPE_ID_ROLETYPE_OCCURRENCE_CONSTRAINT;
	
	/**
	 * the current type of the palette of the editor
	 * <p>
	 * This attribute is set by the {@link StepInFeature}, {@link StepInNewTabFeature} and {@link StepOutFeature}.
	 * It is used to calculate the palette element to display depending on the type of diagram the editor is showing.
	 */
	private PaletteView paletteView = PaletteView.TOPLEVEL_VIEW;
	
	/**
	 * the categories of the palette
	 */
	PaletteCompartmentEntry entityCategory,
							propertiesCategory, 
							relationsCategory,
							constraintsCategory;
		
	/**
	 * Class constructor
	 * @param diagramTypeProvider the provider of the edited diagram type
	 */
	public ToolBehaviorProvider(IDiagramTypeProvider diagramTypeProvider) {
		super(diagramTypeProvider);
	}
	
	/**
	 * sets the value of the palette view to be shown
	 * @param paletteType the new palette view to be set
	 */
	public void setPaletteType(PaletteView paletteView) {
		this.paletteView = paletteView; 
	}
	
	/**
	 * sets the context buttons for the editor of the diagram type
	 * <p>
	 * This operation explicitly don't sets the context button for the remove function, since this function is disabled.
	 * @see {@link FeatureProvider#getRemoveFeature}
	 */
	@Override
	public IContextButtonPadData getContextButtonPad(IPictogramElementContext pictogramElementContext) {
		IContextButtonPadData contextButtonPadData = super.getContextButtonPad(pictogramElementContext);
	    PictogramElement pictogramElement = pictogramElementContext.getPictogramElement();
	    setGenericContextButtons(contextButtonPadData, pictogramElement, CONTEXT_BUTTON_DELETE | CONTEXT_BUTTON_UPDATE);
	    return contextButtonPadData;
	}    
	
	/**
	 * set the context menu for a specific context, for example a right clicked pictogram element.
	 * <p>
	 * This operation controls which custom features are shown in the context menu depending on the
	 * right clicked pictogram element. It does this using the following steps:<br>
	 * Step 1: It gathers the selected pictogram element and its business object.
	 * Step 2: It iterates over all custom feature to probably add to the list of custom feature to show in
	 * 		   the context menu.<br>
	 * Step 3: If its the {@link ChangeConfigurationFeature}, never add it to this list.<br>
	 * Step 4: If its the {@link EditRelationshipFeature}, only add it to the list if a connection or decorator of
	 * 		   a relationship is right clicked.<br>
	 * Step 5: If its the {@link EditFulfillmentFeature}, only add it to the list if a connection or decorator of a
	 * 		   fulfillment is right clicked.<br>
	 * Step 6: If its the {@link StepInFeature} or the {@link StepInNewTabFeature} feature, check if the right clicked 
	 * 		   pictogram element has a graphics algorithm that is the type body of a group or compartment type. If yes, 
	 * 		   add the corresponding context menu entry to the context menu.<br>
	 * Step 7: If its the {@link StepOutFeature} feature check, show the feature for a diagram only if its one of a group or compartment type.
	 * 		   If a shape is right clicked, get the diagram that contains the shape first and then check for the same criteria
	 * 		   for this diagram.<br>
	 * Step 8: If its the {@link ResetLayoutForElementFeature} add it to the context menu if a relationships connection or
	 * 		   connection decorator is right clicked. Also add it if a role types body shape or occurence constraint is selected.
	 */
	@Override
	public IContextMenuEntry[] getContextMenu(ICustomContext customContext) {
		IContextMenuEntry[] superContextEntries = super.getContextMenu(customContext);
		List<IContextMenuEntry> contextMenuEntries = new ArrayList<IContextMenuEntry>();
		//Step 1
		if(customContext.getPictogramElements().length == 1) {
			PictogramElement pictogramElement = customContext.getPictogramElements()[0];
			EObject businessObject = GeneralUtil.getBusinessObjectIfExactlyOne(pictogramElement);
			if(businessObject != null) {
				//Step 2
				for(int i = 0; i < superContextEntries.length; i++) {
					switch(superContextEntries[i].getText()) {
						//Step 3
						case CHANGE_CONFIGURATION_FEATURE_NAME: 
							break;
						//Step 4	
						case EDIT_RELATIONSHIP_FEATURE_NAME: 
							if(pictogramElement instanceof FreeFormConnection ||
							   pictogramElement instanceof ConnectionDecorator) {
								if(businessObject instanceof Relation) {
									Relation relation = (Relation) businessObject;
									if(relation.getType() == Type.RELATIONSHIP)
										contextMenuEntries.add(superContextEntries[i]);
							}	} break;
						//Step 5
						case EDIT_FULFILLMENT_FEATURE_NAME:
							if(pictogramElement instanceof FreeFormConnection ||
							   pictogramElement instanceof ConnectionDecorator) {
								if(businessObject instanceof Relation) {
									Relation relation = (Relation) businessObject;
									if(relation.getType() == Type.FULFILLMENT)
										contextMenuEntries.add(superContextEntries[i]);
							}	} break;
						//Step 6
						case STEP_IN_FEATURE_NAME :
						case STEP_IN_NEW_TAB_FEATURE_NAME:	
							if(pictogramElement instanceof Shape &&
							   !(pictogramElement instanceof Diagram)) {
								if(PropertyUtil.isShape_IdValue((Shape) pictogramElement, SHAPE_ID_GROUP_TYPEBODY) ||
								   PropertyUtil.isShape_IdValue((Shape) pictogramElement, SHAPE_ID_COMPARTMENTTYPE_TYPEBODY)) 
									contextMenuEntries.add(superContextEntries[i]);
							} break;
						//Step 7	
						case STEP_OUT_FEATURE_NAME:	
							if(pictogramElement instanceof Diagram) {
								Diagram diagram = (Diagram) pictogramElement;
								if(PropertyUtil.isDiagram_KindValue(diagram, DIAGRAM_KIND_GROUP_DIAGRAM) ||
								   PropertyUtil.isDiagram_KindValue(diagram, DIAGRAM_KIND_COMPARTMENT_DIAGRAM))
									contextMenuEntries.add(superContextEntries[i]);
							} else {
								if(pictogramElement instanceof Shape) {
									Diagram diagram = DiagramUtil.getDiagramForContainedShape((Shape) pictogramElement);
									if(diagram != null) {
										if(PropertyUtil.isDiagram_KindValue(diagram, DIAGRAM_KIND_GROUP_DIAGRAM) ||
										   PropertyUtil.isDiagram_KindValue(diagram, DIAGRAM_KIND_COMPARTMENT_DIAGRAM))
											contextMenuEntries.add(superContextEntries[i]);
							}	}	} break;
						//Step 8	
						case RESET_LAYOUT_FEATURE_NAME:
							if(pictogramElement instanceof FreeFormConnection ||
							   pictogramElement instanceof ConnectionDecorator) {
								if(businessObject instanceof Relation) {
									Relation relation = (Relation) businessObject;
									if(relation.getType() == Type.RELATIONSHIP)
										contextMenuEntries.add(superContextEntries[i]);
								}	}					
							if(pictogramElement instanceof Shape &&
							   !(pictogramElement instanceof Diagram)) {
								if(PropertyUtil.isShape_IdValue((Shape) pictogramElement, SHAPE_ID_ROLETYPE_TYPEBODY) ||
								   PropertyUtil.isShape_IdValue((Shape) pictogramElement, SHAPE_ID_ROLETYPE_OC)) 
									contextMenuEntries.add(superContextEntries[i]);
							}
							break;
						default: 
							break;	
		}	}	}	}
		return contextMenuEntries.toArray(new IContextMenuEntry[contextMenuEntries.size()]);
	}
	
	/**
	 * builds the palette of the editor using the following steps
	 * <p>
	 * Step 1: It creates the different palette categories.<br>
	 * Step 2: It adds create shape features to the correct categories according to the {@link FeatureManager}
	 * 		   using the operation {@link #addShapeFeature}.<br>
	 * Step 3: It adds create connection features to the correct categories according to the {@link FeatureManager}
	 * 		   using the operation {@link #addConnectionFeature}.<br>
	 * Step 4: It adds the categories with the added features to the palette.
	 */
	@Override
	public IPaletteCompartmentEntry[] getPalette() {
		List<IPaletteCompartmentEntry> pallete = new ArrayList<IPaletteCompartmentEntry>();
		//Step 1
		entityCategory = new PaletteCompartmentEntry(ENTITIES_PALETTE_CATEGORY_NAME, null);
		propertiesCategory = new PaletteCompartmentEntry(PROPERTIES_PALETTE_CATEGORY_NAME, null);
		relationsCategory = new PaletteCompartmentEntry(RELATIONS_PALETTE_CATEGORY_NAME, null);
		constraintsCategory = new PaletteCompartmentEntry(CONSTRAINTS_PALETTE_CATEGORY_NAME, null);
		//Step 2
		for(ICreateFeature feature :  getFeatureProvider().getCreateFeatures()) {
			addShapeFeature(feature);
		}
		//Step 3
		for(ICreateConnectionFeature feature :  getFeatureProvider().getCreateConnectionFeatures()) {
			addConnectionFeature(feature);
		}
		//Step 4
		pallete.add(entityCategory); 
		pallete.add(propertiesCategory); 
		pallete.add(relationsCategory); 
		pallete.add(constraintsCategory);
	    return pallete.toArray(new IPaletteCompartmentEntry[pallete.size()]);
	}	 
	
	/**
	 * adds a shape feature to a palette category if wanted
	 * <p>
	 * It uses the {@link FeaturePaletteDescriptor} of the feature to calculate if and where to add the
	 * feature. 
	 * @param feature the feature to probably add to the palette
	 */
	private void addShapeFeature(ICreateFeature feature) {
		FeaturePaletteDescriptor fpd = FeatureManager.features.get(feature.getCreateName());
		if(fpd == null) throw new FeatureHasNoPaletteDescriptorException(feature.getCreateName());
		if((fpd.viewVisibility == ViewVisibility.ALL_VIEWS) ||
		   (paletteView == PaletteView.TOPLEVEL_VIEW &&
		    fpd.viewVisibility == ViewVisibility.TOPLEVEL_VIEW) ||
		   (paletteView == PaletteView.COMPARTMENT_VIEW &&
		    fpd.viewVisibility == ViewVisibility.COMPARTMENT_VIEW)) {
			ObjectCreationToolEntry objectCreationToolEntry = 
				new ObjectCreationToolEntry( feature.getCreateName(), 
					feature.getCreateDescription(), feature.getCreateImageId(), 
					feature.getCreateLargeImageId(), feature);
			switch(fpd.paletteCategory) {
				case ENTITIES_CATEGORY: 
					entityCategory.addToolEntry(objectCreationToolEntry);
					break;
				case PROPERTIES_CATEGORY: 
					propertiesCategory.addToolEntry(objectCreationToolEntry);
					break;
				case RELATIONS_CATEGORY: 
					relationsCategory.addToolEntry(objectCreationToolEntry);
					break;
				case CONSTRAINTS_CATEGORY: 
					constraintsCategory.addToolEntry(objectCreationToolEntry);
					break;
			default:
				break;
	}	}	}	
	
	/**
	 * adds a connection feature to a palette category if wanted
	 * <p>
	 * It uses the {@link FeaturePaletteDescriptor} of the feature to calculate if and where to add the
	 * feature. 
	 * @param feature the feature to probably add to the palette
	 */
	private void addConnectionFeature(ICreateConnectionFeature feature) {
		FeaturePaletteDescriptor fpd = FeatureManager.features.get(feature.getCreateName());
		if(fpd == null) throw new FeatureHasNoPaletteDescriptorException(feature.getCreateName());
		if((fpd.viewVisibility == ViewVisibility.ALL_VIEWS) ||
		   (paletteView == PaletteView.TOPLEVEL_VIEW &&
		    fpd.viewVisibility == ViewVisibility.TOPLEVEL_VIEW) ||
		   (paletteView == PaletteView.COMPARTMENT_VIEW &&
		    fpd.viewVisibility == ViewVisibility.COMPARTMENT_VIEW)) {
			ConnectionCreationToolEntry connectionCreationToolEntry = 
				new ConnectionCreationToolEntry(feature.getCreateName(), 
					feature.getCreateDescription(), feature.getCreateImageId(),
					feature.getCreateLargeImageId());
			    connectionCreationToolEntry.addCreateConnectionFeature(feature);
			switch(fpd.paletteCategory) {
				case ENTITIES_CATEGORY: 
					entityCategory.addToolEntry(connectionCreationToolEntry);
					break;
				case PROPERTIES_CATEGORY: 
					propertiesCategory.addToolEntry(connectionCreationToolEntry);
					break;
				case RELATIONS_CATEGORY: 
					relationsCategory.addToolEntry(connectionCreationToolEntry);
					break;
				case CONSTRAINTS_CATEGORY: 
					constraintsCategory.addToolEntry(connectionCreationToolEntry);
					break;
			default:
				break;
	}	}	}
	
	/**
	 * enables the edit features for relationships and fulfillments when double clicking such a relation
	 */
	@Override
	public ICustomFeature getDoubleClickFeature(IDoubleClickContext context) {
		if(context.getPictogramElements().length == 1) {
			PictogramElement pictogramElement = context.getPictogramElements()[0];
			EObject businessObject = GeneralUtil.getBusinessObjectIfExactlyOne(pictogramElement);
			if(businessObject instanceof Relation &&
			   ((Relation) businessObject).getType() == Type.RELATIONSHIP) {
				ICustomFeature[] customFeatures = getFeatureProvider().getCustomFeatures(context);
				return (ICustomFeature) GeneralUtil.findFeatureByName(customFeatures, EDIT_RELATIONSHIP_FEATURE_NAME);
		}	}
		return null;
	}	
}

