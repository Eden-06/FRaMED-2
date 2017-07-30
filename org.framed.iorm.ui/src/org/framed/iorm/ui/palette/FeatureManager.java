package org.framed.iorm.ui.palette;

import java.util.HashMap;
import java.util.Map;

import org.framed.iorm.ui.literals.NameLiterals;

/**
 * This static class is used to get information about when and where a feature with a specific name 
 * is shown in the palette.
 * @author Kevin Kassin
 */
public class FeatureManager {
	
	/**
	 * the name literals for shape create features gathered from {@link NameLiterals}
	 */
	private static final String ATTRIBUTE_OPERATION_COMMON_FEATURE_NAME = NameLiterals.ATTRIBUTE_OPERATION_COMMON_FEATURE_NAME,
								MODEL_FEATURE_NAME = NameLiterals.MODEL_FEATURE_NAME,
								GROUP_OR_COMPARTMENT_TYPE_ELEMENT_FEATURE_NAME = NameLiterals.GROUP_OR_COMPARTMENT_TYPE_ELEMENT_FEATURE_NAME,
								COMPARTMENTTYPE_FEATURE_NAME = NameLiterals.COMPARTMENTTYPE_FEATURE_NAME,
								NATURALTYPE_FEATURE_NAME = NameLiterals.NATURALTYPE_FEATURE_NAME,
								DATATYPE_FEATURE_NAME = NameLiterals.DATATYPE_FEATURE_NAME,
								GROUP_FEATURE_NAME = NameLiterals.GROUP_FEATURE_NAME,
								ROLETYPE_FEATURE_NAME = NameLiterals.ROLETYPE_FEATURE_NAME,
								ATTRIBUTE_FEATURE_NAME = NameLiterals.ATTRIBUTE_FEATURE_NAME,
								OPERATION_FEATURE_NAME = NameLiterals.OPERATION_FEATURE_NAME;
						 
	/**
	 * the name literals for connection create features gathered from {@link NameLiterals}
	 */					 
	private static final String RELATIONSHIP_FEATURE_NAME = NameLiterals.RELATIONSHIP_FEATURE_NAME,
		     			 		INHERITANCE_FEATURE_NAME = NameLiterals.INHERITANCE_FEATURE_NAME,
		     			 		ROLEIMPLICATION_FEATURE_NAME = NameLiterals.ROLEIMPLICATION_FEATURE_NAME,
		     			 		ROLEEQUIVALENCE_FEATURE_NAME = NameLiterals.ROLEEQUIVALENCE_FEATURE_NAME,
		     			 		ROLEPROHIBITION_FEATURE_NAME = NameLiterals.ROLEPROHIBITION_FEATURE_NAME,
		     			 		ACYCLIC_FEATURE_NAME = NameLiterals.ACYCLIC_FEATURE_NAME,
		     			 		CYCLIC_FEATURE_NAME = NameLiterals.CYCLIC_FEATURE_NAME,
		     			 		IRREFLEXIVE_FEATURE_NAME = NameLiterals.IRREFLEXIVE_FEATURE_NAME,
		     			 		REFLEXIVE_FEATURE_NAME = NameLiterals.REFLEXIVE_FEATURE_NAME,
		     			 		TOTAL_FEATURE_NAME = NameLiterals.TOTAL_FEATURE_NAME,
		     			 		RELATIONSHIP_IMPLICATION_FEATURE_NAME = NameLiterals.RELATIONSHIP_IMPLICATION_FEATURE_NAME,
		     			 		RELATIONSHIP_EXCLUSION_FEATURE_NAME = NameLiterals.RELATIONSHIP_EXCLUSION_FEATURE_NAME,
		     			 		FULFILLMENT_FEATURE_NAME = NameLiterals.FULFILLMENT_FEATURE_NAME;

	/**
	 * simple short forms of the palette categories to make code more readable
	 */
	private static PaletteCategory entities = PaletteCategory.ENTITIES_CATEGORY,
								   properties = PaletteCategory.PROPERTIES_CATEGORY,
								   relations = PaletteCategory.RELATIONS_CATEGORY,
								   constraints = PaletteCategory.CONSTRAINTS_CATEGORY,
								   none = PaletteCategory.NONE;
	/**
	 * simple short forms of the view visibility to make code more readable
	 */
	private static ViewVisibility all = ViewVisibility.ALL_VIEWS,
								  top = ViewVisibility.TOPLEVEL_VIEW,
								  compartment = ViewVisibility.COMPARTMENT_VIEW,
								  no_view = ViewVisibility.NO_VIEW;
	
	/**
	 * the map that saves when and where a feature with a specific name is shown in the palette
	 */
	public static Map<String, FeaturePaletteDescriptor> features = createFeatureCategoryMap();
	
	/**
	 * creates the map that saves when and where a feature with a specific name is shown in the palette
	 * using the following steps:
	 * <p>
	 * Step 1: features shown in none of the categories<br>
	 * Step 2: features shown in the category "Entities"<br>
	 * Step 3: features shown in the category "Properties"<br>
	 * Step 4: features shown in the category "Relations"<br>
	 * Step 5: features shown in the category "Constraints"<br>
	 * @return
	 */
	private static Map<String, FeaturePaletteDescriptor> createFeatureCategoryMap() {
		features = new HashMap<String, FeaturePaletteDescriptor>();
		//Step 1
		features.put(ATTRIBUTE_OPERATION_COMMON_FEATURE_NAME, new FeaturePaletteDescriptor(none, no_view));
		features.put(MODEL_FEATURE_NAME, new FeaturePaletteDescriptor(none, no_view));
		features.put(GROUP_OR_COMPARTMENT_TYPE_ELEMENT_FEATURE_NAME, new FeaturePaletteDescriptor(none, no_view));
		//Step 2
		features.put(COMPARTMENTTYPE_FEATURE_NAME, new FeaturePaletteDescriptor(entities, all));
		features.put(NATURALTYPE_FEATURE_NAME, new FeaturePaletteDescriptor(entities, top));
		features.put(DATATYPE_FEATURE_NAME, new FeaturePaletteDescriptor(entities, top));
		features.put(GROUP_FEATURE_NAME, new FeaturePaletteDescriptor(entities, top));
		features.put(ROLETYPE_FEATURE_NAME, new FeaturePaletteDescriptor(entities, compartment));
		//Step 3
		features.put(ATTRIBUTE_FEATURE_NAME, new FeaturePaletteDescriptor(properties, all));
		features.put(OPERATION_FEATURE_NAME, new FeaturePaletteDescriptor(properties, all));
		//Step 4
		features.put(INHERITANCE_FEATURE_NAME, new FeaturePaletteDescriptor(relations, all));
		features.put(RELATIONSHIP_FEATURE_NAME, new FeaturePaletteDescriptor(relations, compartment));
		features.put(FULFILLMENT_FEATURE_NAME, new FeaturePaletteDescriptor(relations, all));
		//Step 5
		features.put(ROLEIMPLICATION_FEATURE_NAME, new FeaturePaletteDescriptor(constraints, compartment));
		features.put(ROLEEQUIVALENCE_FEATURE_NAME, new FeaturePaletteDescriptor(constraints, compartment));
		features.put(ROLEPROHIBITION_FEATURE_NAME, new FeaturePaletteDescriptor(constraints, compartment));
		features.put(ACYCLIC_FEATURE_NAME, new FeaturePaletteDescriptor(constraints, compartment));
		features.put(CYCLIC_FEATURE_NAME, new FeaturePaletteDescriptor(constraints, compartment));
		features.put(IRREFLEXIVE_FEATURE_NAME, new FeaturePaletteDescriptor(constraints, compartment));
		features.put(REFLEXIVE_FEATURE_NAME, new FeaturePaletteDescriptor(constraints, compartment));
		features.put(TOTAL_FEATURE_NAME, new FeaturePaletteDescriptor(constraints, compartment));
		features.put(RELATIONSHIP_IMPLICATION_FEATURE_NAME, new FeaturePaletteDescriptor(constraints, compartment));
		features.put(RELATIONSHIP_EXCLUSION_FEATURE_NAME, new FeaturePaletteDescriptor(constraints, compartment));
		return features;
	}
}
