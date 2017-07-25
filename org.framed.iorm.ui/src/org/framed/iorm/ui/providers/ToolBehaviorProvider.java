package org.framed.iorm.ui.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IPictogramElementContext;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.palette.IPaletteCompartmentEntry;
import org.eclipse.graphiti.palette.IToolEntry;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IContextButtonPadData;
import org.eclipse.graphiti.tb.IContextMenuEntry;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.literals.NameLiterals;
import org.framed.iorm.ui.util.DiagramUtil;
import org.framed.iorm.ui.util.GeneralUtil;
import org.framed.iorm.ui.util.PropertyUtil;
import org.framed.iorm.ui.providers.FeatureProvider; //*import for javadoc link
import org.framed.iorm.model.Relation;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.graphitifeatures.StepInFeature; //*import for javadoc link
import org.framed.iorm.ui.graphitifeatures.StepInNewTabFeature; //*import for javadoc link
import org.framed.iorm.ui.graphitifeatures.StepOutFeature; //*import for javadoc link

/**
 * This class enables context buttons and can manipulate the palette of the editor.
 * @author Kevin Kassin
 */
public class ToolBehaviorProvider extends DefaultToolBehaviorProvider{
	
	/**
	 * the name literals for shape create features to remove from the editor palette for the diagram type
	 * gathered from {@link NameLiterals}
	 */
	private final String ATTRIBUTE_OPERATION_COMMON_FEATURE_NAME = NameLiterals.ATTRIBUTE_OPERATION_COMMON_FEATURE_NAME,
						 MODEL_FEATURE_NAME = NameLiterals.MODEL_FEATURE_NAME,
						 GROUP_OR_COMPARTMENT_TYPE_ELEMENT_FEATURE_NAME = NameLiterals.GROUP_OR_COMPARTMENT_TYPE_ELEMENT_FEATURE_NAME,
						 NATURALTYPE_FEATURE_NAME = NameLiterals.NATURALTYPE_FEATURE_NAME,
						 DATATYPE_FEATURE_NAME = NameLiterals.DATATYPE_FEATURE_NAME,
						 GROUP_FEATURE_NAME = NameLiterals.GROUP_FEATURE_NAME,
						 ROLETYPE_FEATURE_NAME = NameLiterals.ROLETYPE_FEATURE_NAME;
						 
	/**
	 * the name literals for connection create features to remove from the editor palette for the diagram type
	 * gathered from {@link NameLiterals}
	 */					 
	private final String ROLEIMPLICATION_FEATURE_NAME = NameLiterals.ROLEIMPLICATION_FEATURE_NAME,
						 ROLEEQUIVALENCE_FEATURE_NAME = NameLiterals.ROLEEQUIVALENCE_FEATURE_NAME,
						 ROLEPROHIBITION_FEATURE_NAME = NameLiterals.ROLEPROHIBITION_FEATURE_NAME,
					     RELATIONSHIP_FEATURE_NAME = NameLiterals.RELATIONSHIP_FEATURE_NAME,
					     RELATIONSHIP_DECORATOR_FEATURE_NAME = NameLiterals.RELATIONSHIP_DECORATOR_FEATURE_NAME,
					     ACYCLIC_FEATURE_NAME = NameLiterals.ACYCLIC_FEATURE_NAME,
					     CYCLIC_FEATURE_NAME = NameLiterals.CYCLIC_FEATURE_NAME,
					     IRREFLEXIVE_FEATURE_NAME = NameLiterals.IRREFLEXIVE_FEATURE_NAME,
			 		 	 REFLEXIVE_FEATURE_NAME = NameLiterals.REFLEXIVE_FEATURE_NAME,
					 	 TOTAL_FEATURE_NAME = NameLiterals.TOTAL_FEATURE_NAME;
						 
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
						 STEP_IN_FEATURE_NAME = NameLiterals.STEP_IN_FEATURE_NAME,
						 STEP_IN_NEW_TAB_FEATURE_NAME = NameLiterals.STEP_IN_NEW_TAB_FEATURE_NAME,
						 STEP_OUT_FEATURE_NAME = NameLiterals.STEP_OUT_FEATURE_NAME;
	
	/**
	 * the shape identifiers of the shapes the step in feature can be used on gathered from {@link IdentifierLiterals}
	 * <p>
	 * can be:<br>
	 * (1) the shape identifier of type body rectangle of a group or<br>
	 * (2) the shape identifier of type body rectangle of a compartment type
	 */
	private final String SHAPE_ID_GROUP_TYPEBODY = IdentifierLiterals.SHAPE_ID_GROUP_TYPEBODY,
						 SHAPE_ID_COMPARTMENTTYPE_TYPEBODY = IdentifierLiterals.SHAPE_ID_COMPARTMENTTYPE_TYPEBODY;
	
	/**
	 * identifiers used to differ the types of palettes gathered from {@link IdentifierLiterals}
	 */
	private final String PALETTE_TYPE_TOPLEVELVIEW = IdentifierLiterals.PALETTE_TYPE_TOPLEVELVIEW,
						 PALETTE_TYPE_COMPARTMENTVIEW = IdentifierLiterals.PALETTE_TYPE_COMPARTMENTVIEW;
	
	/**
	 * the current type of the palette of the editor
	 * <p>
	 * This attribute is set by the {@link StepInFeature}, {@link StepInNewTabFeature} and {@link StepOutFeature}.
	 * It is used to calculate the palette element to display depending on the type of diagram the editor is showing.
	 */
	private String paletteType = PALETTE_TYPE_TOPLEVELVIEW;
	
	private List<String> createFeaturesToHideInEveryView = new ArrayList<String>(),
						 createFeaturesToHideInTopLevelView = new ArrayList<String>(),
						 createFeaturesToHideInCompartmentView = new ArrayList<String>();
	
	/**
	 * Class constructor
	 * <p>
	 * fills the list of features to hide 
	 * @param diagramTypeProvider the provider of the edited diagram type
	 */
	public ToolBehaviorProvider(IDiagramTypeProvider diagramTypeProvider) {
		super(diagramTypeProvider);
		//features to hide in every view
		createFeaturesToHideInEveryView.add(ATTRIBUTE_OPERATION_COMMON_FEATURE_NAME);
		createFeaturesToHideInEveryView.add(MODEL_FEATURE_NAME);
		createFeaturesToHideInEveryView.add(GROUP_OR_COMPARTMENT_TYPE_ELEMENT_FEATURE_NAME);
		createFeaturesToHideInEveryView.add(RELATIONSHIP_DECORATOR_FEATURE_NAME);
		//features to hide in the top level view
		createFeaturesToHideInTopLevelView.add(ROLEIMPLICATION_FEATURE_NAME);
		createFeaturesToHideInTopLevelView.add(ROLEEQUIVALENCE_FEATURE_NAME);
		createFeaturesToHideInTopLevelView.add(ROLEPROHIBITION_FEATURE_NAME);
		createFeaturesToHideInTopLevelView.add(RELATIONSHIP_FEATURE_NAME);
		createFeaturesToHideInTopLevelView.add(ROLETYPE_FEATURE_NAME);
		createFeaturesToHideInTopLevelView.add(ACYCLIC_FEATURE_NAME);
		createFeaturesToHideInTopLevelView.add(CYCLIC_FEATURE_NAME);
		createFeaturesToHideInTopLevelView.add(IRREFLEXIVE_FEATURE_NAME);
		createFeaturesToHideInTopLevelView.add(REFLEXIVE_FEATURE_NAME);
		createFeaturesToHideInTopLevelView.add(TOTAL_FEATURE_NAME);
		//feature to hide in the compartment view
		createFeaturesToHideInCompartmentView.add(NATURALTYPE_FEATURE_NAME);
		createFeaturesToHideInCompartmentView.add(DATATYPE_FEATURE_NAME);
		createFeaturesToHideInCompartmentView.add(GROUP_FEATURE_NAME);
	}
	
	/**
	 * sets the value of the palette type to be shown
	 * @param paletteType the new palette to be set
	 */
	public void setPaletteType(String paletteType) {
		this.paletteType = paletteType; 
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
	 * Step 3: If its the change configuration custom feature, never add it to this list.<br>
	 * Step 4: If its the edit relationship custom feature, only add it to the list if a connection or decorator of
	 * 		   a relationship is right clicked.<br>
	 * Step 5: If its the step in or the step in new tab feature, check if the right clicked pictogram element 
	 * 		   has a graphics algorithm that is the type body of a group or compartment type. If yes, add the
	 * 		   corresponding context menu entry to the context menu.<br>
	 * Step 6: If its the step out feature check, show the feature for a diagram only if its one of a group or compartment type.
	 * 		   If a shape is right clicked, get the diagram that contains the shape first and then check for the same criteria
	 * 		   for this diagram.
	 */
	@Override
	public IContextMenuEntry[] getContextMenu(ICustomContext customContext) {
		IContextMenuEntry[] superContextEntries = super.getContextMenu(customContext);
		List<IContextMenuEntry> contextMenuEntries = new ArrayList<IContextMenuEntry>();
		//Step 1
		if(customContext.getPictogramElements().length == 1) {
			PictogramElement pictogramElement = customContext.getPictogramElements()[0];
			if(pictogramElement.getLink() != null &&
			   pictogramElement.getLink().getBusinessObjects().size() == 1) {
				EObject businessObject = pictogramElement.getLink().getBusinessObjects().get(0);
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
						case STEP_IN_FEATURE_NAME :
						case STEP_IN_NEW_TAB_FEATURE_NAME:	
							if(pictogramElement instanceof Shape &&
							   !(pictogramElement instanceof Diagram)) {
								if(PropertyUtil.isShape_IdValue((Shape) pictogramElement, SHAPE_ID_GROUP_TYPEBODY) ||
								   PropertyUtil.isShape_IdValue((Shape) pictogramElement, SHAPE_ID_COMPARTMENTTYPE_TYPEBODY)) 
									contextMenuEntries.add(superContextEntries[i]);
							} break;
						//Step 6	
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
						default: 
							break;	
		}	}	}	}
		return contextMenuEntries.toArray(new IContextMenuEntry[contextMenuEntries.size()]);
	}
	
	/**
	 * removes create features implemented by the pattern from the palette using the following steps:
	 * <p>
	 * Step 1: It hides patterns that dont have a create features or whichs create features should not be used by the user
	 * 		   manually.
	 * Step 2: It hides patterns that should not be shown if the palette type of the provider is set to class palette.<br>
	 * Step 3: It hides patterns that should not be shown if the palette type of the provider is set to role palette.
	 */
	@Override
	public IPaletteCompartmentEntry[] getPalette() {
		List<IPaletteCompartmentEntry> paletteCompartmentEntry = new ArrayList<IPaletteCompartmentEntry>();
		List<IToolEntry> toolEntriesShapesToDelete = new ArrayList<IToolEntry>();
		List<IToolEntry> toolEntriesConnectionToDelete = new ArrayList<IToolEntry>();
		IPaletteCompartmentEntry[] superCompartments = super.getPalette();		
	    //Step 1
		for(int i = 0; i < superCompartments[1].getToolEntries().size(); i++) {
	    	IToolEntry toolEntry = superCompartments[1].getToolEntries().get(i);
	    	if(GeneralUtil.containsEqual(createFeaturesToHideInEveryView, toolEntry.getLabel()))
	    		toolEntriesShapesToDelete.add(toolEntry);
	    }
		//Step 2
		if(paletteType.equals(PALETTE_TYPE_TOPLEVELVIEW)) {
			for(int i = 0; i < superCompartments[0].getToolEntries().size(); i++) {
				IToolEntry toolEntry = superCompartments[0].getToolEntries().get(i);
				if(GeneralUtil.containsEqual(createFeaturesToHideInTopLevelView, toolEntry.getLabel()))
					toolEntriesConnectionToDelete.add(toolEntry);
			}
			for(int i = 0; i < superCompartments[1].getToolEntries().size(); i++) {
		    	IToolEntry toolEntry = superCompartments[1].getToolEntries().get(i);
		    	if(GeneralUtil.containsEqual(createFeaturesToHideInTopLevelView, toolEntry.getLabel()))
		    		toolEntriesShapesToDelete.add(toolEntry);
		}   }
		//Step 3
		if(paletteType.equals(PALETTE_TYPE_COMPARTMENTVIEW)) {
			for(int i = 0; i < superCompartments[1].getToolEntries().size(); i++) {
		    	IToolEntry toolEntry = superCompartments[1].getToolEntries().get(i);
		    	if(GeneralUtil.containsEqual(createFeaturesToHideInCompartmentView, toolEntry.getLabel()))
			   		toolEntriesShapesToDelete.add(toolEntry);
		}   }	
		for(IToolEntry toolEntryConnectionToDelete : toolEntriesConnectionToDelete) {
	    	superCompartments[0].getToolEntries().remove(toolEntryConnectionToDelete);
	    }
	    for(IToolEntry toolEntryShapeToDelete : toolEntriesShapesToDelete) {
	    	superCompartments[1].getToolEntries().remove(toolEntryShapeToDelete);
	    }	
	    for (int j = 0; j < superCompartments.length; j++) {
	    	paletteCompartmentEntry.add(superCompartments[j]);
	    }
	    return paletteCompartmentEntry.toArray(new IPaletteCompartmentEntry[paletteCompartmentEntry.size()]);
	}	 
}
