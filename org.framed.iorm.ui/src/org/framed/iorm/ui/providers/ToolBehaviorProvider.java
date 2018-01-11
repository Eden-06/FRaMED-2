
package org.framed.iorm.ui.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDoubleClickContext;
import org.eclipse.graphiti.features.context.IPictogramElementContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.palette.IPaletteCompartmentEntry;
import org.eclipse.graphiti.palette.impl.ConnectionCreationToolEntry;
import org.eclipse.graphiti.palette.impl.ObjectCreationToolEntry;
import org.eclipse.graphiti.palette.impl.PaletteCompartmentEntry;
import org.eclipse.graphiti.pattern.IConnectionPattern;
import org.eclipse.graphiti.pattern.IPattern;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IContextButtonPadData;
import org.eclipse.graphiti.tb.IContextMenuEntry;
import org.framed.iorm.ui.literals.UILiterals;
import org.framed.iorm.ui.palette.FeaturePaletteDescriptor;
import org.framed.iorm.ui.palette.PaletteView;
import org.framed.iorm.ui.palette.ViewVisibility;
import org.framed.iorm.ui.util.UIUtil;

import customFeatures.StepInFeature;
import customFeatures.StepInNewTabFeature;
import customFeatures.StepOutFeature;
import relationship.EditRelationshipFeature;

import org.framed.iorm.ui.providers.FeatureProvider; //*import for javadoc link
import org.framed.iorm.featuremodel.FRaMEDConfiguration;
import org.framed.iorm.featuremodel.FRaMEDFeature;
import org.framed.iorm.model.ModelElement;
import org.framed.iorm.model.Relation;
import org.framed.iorm.ui.FRaMEDConnectionPattern;
import org.framed.iorm.ui.FRaMEDCustomFeature;
import org.framed.iorm.ui.FRaMEDShapePattern;
import org.framed.iorm.ui.exceptions.FeatureHasNoPaletteDescriptorException;
import org.framed.iorm.ui.exceptions.NoLinkedModelYet;

/**
 * This class enables context buttons and can manipulate the palette of the editor.
 * @author Kevin Kassin
 */
public class ToolBehaviorProvider extends DefaultToolBehaviorProvider{
	
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
	
	//TODO overhaul doku
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
		PictogramElement pictogramElement = customContext.getPictogramElements()[0];
		EObject businessObject = UIUtil.getBusinessObjectIfExactlyOne(pictogramElement);
		//Step 2
		for(IContextMenuEntry contextMenuEntry : superContextEntries) {
			if(contextMenuEntry.getFeature() instanceof FRaMEDCustomFeature) {
				FRaMEDCustomFeature framedCustomFeature = (FRaMEDCustomFeature) contextMenuEntry.getFeature();
				if(framedCustomFeature.contextMenuExpression(pictogramElement, businessObject)) 
					contextMenuEntries.add(contextMenuEntry);
			}
		}
		return contextMenuEntries.toArray(new IContextMenuEntry[contextMenuEntries.size()]);
	}
	
	//TODO doku anpassen
	/**
	 * builds the palette of the editor using the following steps
	 * <p>
	 * Step 1: It creates the different palette categories.<br>
	 * Step 2: See {@link #getListOfFramedFeatureNames()}.<br>
	 * Step 3: It adds create features of shape patterns to the correct categories according to the {@link FeatureManager}
	 * 		   using the operation {@link #addShapeFeature}.<br>
	 * Step 4: It adds create features of connection patterns to the correct categories according to the {@link FeatureManager}
	 * 		   using the operation {@link #addConnectionFeature}.<br>
	 * Step 5: It adds the categories with the added features to the palette.
	 */
	@Override
	public IPaletteCompartmentEntry[] getPalette() {
		List<IPaletteCompartmentEntry> pallete = new ArrayList<IPaletteCompartmentEntry>();
		//Step 1
		entityCategory = new PaletteCompartmentEntry(UILiterals.ENTITIES_PALETTE_CATEGORY_NAME, null);
		propertiesCategory = new PaletteCompartmentEntry(UILiterals.PROPERTIES_PALETTE_CATEGORY_NAME, null);
		relationsCategory = new PaletteCompartmentEntry(UILiterals.RELATIONS_PALETTE_CATEGORY_NAME, null);
		constraintsCategory = new PaletteCompartmentEntry(UILiterals.CONSTRAINTS_PALETTE_CATEGORY_NAME, null);
		//Step 2
		List<String> framedFeatureNames = getListOfFramedFeatureNames();
		//Step 3 
		for(IPattern iPattern :  ((FeatureProvider) getFeatureProvider()).getPatterns()) {
			if(iPattern instanceof FRaMEDShapePattern)
				addShapeFeature((FRaMEDShapePattern) iPattern, framedFeatureNames);
		}
		//Step 4
		for(IConnectionPattern iConPattern :  ((FeatureProvider) getFeatureProvider()).getConnectionPatterns()) {
			if(iConPattern instanceof FRaMEDConnectionPattern)
				addConnectionFeature((FRaMEDConnectionPattern) iConPattern, framedFeatureNames);
		}
		//Step 5
		pallete.add(entityCategory); 
		pallete.add(propertiesCategory); 
		pallete.add(relationsCategory); 
		pallete.add(constraintsCategory);
	    return pallete.toArray(new IPaletteCompartmentEntry[pallete.size()]);
	}	 
	
	/**
	 * Gets the current feature configuration of the edited diagram and transforms it into a list of the chosen features' names.
	 * @return a list of chosen features' names in the current feature configuration
	 * <p>
	 * Note: At the creation of diagram the main diagram is not linked to a model, but the this class already asks for one. Therefore
	 * the method searching for the model throws a special exception for this case, which is caught here. In this case an empty list
	 * of feature names is returned. The palette will updated later when a model is linked then.
	 */
	private List<String> getListOfFramedFeatureNames() {
		List<String> framedFeatureNames = new ArrayList<String>();
		Diagram diagram = getDiagramTypeProvider().getDiagram();
		if(diagram == null) return framedFeatureNames;
		FRaMEDConfiguration config = null;
		//Note
		try { config = UIUtil.getRootModelForAnyDiagram(diagram).getFramedConfiguration(); }
		catch(NoLinkedModelYet e) {return framedFeatureNames;}
		for(FRaMEDFeature framedFeature : config.getFeatures()) {
			framedFeatureNames.add(framedFeature.getName().getLiteral());
		}
		return framedFeatureNames;
	}
	
	/**
	 * adds a shape feature to a palette category if wanted
	 * <p>
	 * It uses the {@link FeaturePaletteDescriptor} of the pattern to calculate if and where to add its
	 * feature. 
	 * @param feature the feature to probably add to the palette
	 */
	private void addShapeFeature(FRaMEDShapePattern pattern, List<String> framedFeatureNames) {
		FeaturePaletteDescriptor fpd = pattern.getFeaturePaletteDescriptor();
		if(fpd == null) throw new FeatureHasNoPaletteDescriptorException(pattern.getCreateName());
		if((fpd.viewVisibility == ViewVisibility.ALL_VIEWS) ||
		   (paletteView == PaletteView.TOPLEVEL_VIEW &&
		    fpd.viewVisibility == ViewVisibility.TOPLEVEL_VIEW) ||
		   (paletteView == PaletteView.COMPARTMENT_VIEW &&
		    fpd.viewVisibility == ViewVisibility.COMPARTMENT_VIEW)) {
			if(fpd.featureExpression(framedFeatureNames, paletteView)) {
				IFeature featureForPattern = UIUtil.findFeatureByName(getFeatureProvider().getCreateFeatures(), pattern.getCreateName());
				ObjectCreationToolEntry objectCreationToolEntry = 
					new ObjectCreationToolEntry( pattern.getCreateName(), 
						pattern.getCreateDescription(), pattern.getCreateImageId(), 
						pattern.getCreateLargeImageId(), (ICreateFeature) featureForPattern);
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
	}	}	}	}
	
	/**
	 * adds a connection feature to a palette category if wanted
	 * <p>
	 * It uses the {@link FeaturePaletteDescriptor} of the pattern to calculate if and where to add its
	 * feature. 
	 * @param feature the feature to probably add to the palette
	 */
	private void addConnectionFeature(FRaMEDConnectionPattern iConPattern, List<String> framedFeatureNames) {
		FeaturePaletteDescriptor fpd = iConPattern.getFeaturePaletteDescriptor();
		if(fpd == null) throw new FeatureHasNoPaletteDescriptorException(iConPattern.getCreateName());
		if((fpd.viewVisibility == ViewVisibility.ALL_VIEWS) ||
		   (paletteView == PaletteView.TOPLEVEL_VIEW &&
		    fpd.viewVisibility == ViewVisibility.TOPLEVEL_VIEW) ||
		   (paletteView == PaletteView.COMPARTMENT_VIEW &&
		    fpd.viewVisibility == ViewVisibility.COMPARTMENT_VIEW)) {
			if(fpd.featureExpression(framedFeatureNames, paletteView)) {
				ConnectionCreationToolEntry connectionCreationToolEntry = 
					new ConnectionCreationToolEntry(iConPattern.getCreateName(), 
						iConPattern.getCreateDescription(), iConPattern.getCreateImageId(),
						iConPattern.getCreateLargeImageId());			
				ICreateConnectionFeature feature = UIUtil.findCreateConnectionFeatureByName(getFeatureProvider().getCreateConnectionFeatures(), iConPattern.getCreateName());
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
	}	}	}	}
	
	//TODO doku
	/**
	 * enables the edit features for relationships and fulfillments when double clicking such a relation
	 */
	@Override
	public ICustomFeature getDoubleClickFeature(IDoubleClickContext context) {
		if(context.getPictogramElements().length == 1) {
			PictogramElement pictogramElement = context.getPictogramElements()[0];
			EObject businessObject = UIUtil.getBusinessObjectIfExactlyOne(pictogramElement);
			ICustomFeature[] customFeatures = getFeatureProvider().getCustomFeatures(context);
			if(businessObject instanceof Relation) {
				//Step 4
				for(IConnectionPattern iConPattern :  ((FeatureProvider) getFeatureProvider()).getConnectionPatterns()) {
					if(iConPattern instanceof FRaMEDConnectionPattern) {
						FRaMEDConnectionPattern framedConnectionPattern = (FRaMEDConnectionPattern) iConPattern;
						if(framedConnectionPattern.getModelType() == ((Relation) businessObject).getType())
							return (ICustomFeature) framedConnectionPattern.getDoubleClickFeature(customFeatures);
			}	}	}
			if(businessObject instanceof org.framed.iorm.model.Shape) {
				for(IPattern iPattern :  ((FeatureProvider) getFeatureProvider()).getPatterns()) {
					if(iPattern instanceof FRaMEDShapePattern) {
						FRaMEDShapePattern framedShapePattern = (FRaMEDShapePattern) iPattern;
						if(framedShapePattern.getModelType() == ((ModelElement) businessObject).getType())
							return (ICustomFeature) framedShapePattern.getDoubleClickFeature(customFeatures);
		}	}	}	}
		return null;
	}	
}

