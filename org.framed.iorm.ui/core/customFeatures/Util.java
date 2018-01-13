package customFeatures;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.UILiterals;
import org.framed.iorm.ui.UIUtil;
import org.framed.iorm.ui.references.AbstractGroupingFeatureReference;
import attributeAndOperation.references.AbstractUsedInReference;

public class Util {

	//StepInAndOutReferences
	//~~~~~~~~~~~~~~~~
	/**
	 * get all sub classes of {@link AbstractUsedInReference} for a given list of classes 
	 * @param classes a given list of classes of different types
	 * @return a list of classes have {@link AbstractUsedInReference} as their super class
	 */
	public List<AbstractGroupingFeatureReference> getStepInAndOutReferences(List<Class<?>> classes) {
		List<AbstractGroupingFeatureReference> stepInAndOutReferences = new ArrayList<AbstractGroupingFeatureReference>();
		for(Class<?> cl : classes) {
			if(!Modifier.isAbstract(cl.getModifiers())) {
				if(UIUtil.getSuperClasses(cl).contains(AbstractGroupingFeatureReference.class)) {
					try {
						Object object = cl.newInstance();
						stepInAndOutReferences.add((AbstractGroupingFeatureReference) object);
					} catch (InstantiationException | IllegalAccessException e) { e.printStackTrace(); }
		} 	}	}
		return stepInAndOutReferences;
	}
	
	/**
	 * checks if the given {@link Shape} is typebody referenced in a list of {@link AbstractGroupingFeatureReference}s.
	 * @param shape
	 * @param stepInAndOutReferences
	 * @return
	 */
	public boolean shapeIsFittingToStepInAndOutFeature(Shape shape, List<AbstractGroupingFeatureReference> stepInAndOutReferences) {
		boolean fitting = false;
		for(AbstractGroupingFeatureReference siaor : stepInAndOutReferences) {
			if(UIUtil.isShape_IdValue(shape, siaor.getShapeIdTypebody()))
				fitting = true;
		}
		return fitting;
	}
	
	/**
	 * checks if the given {@link Diagram} is typebody referenced in a list of {@link AbstractGroupingFeatureReference}s.
	 * @param shape
	 * @param stepInAndOutReferences
	 * @return
	 */
	public boolean diagramIsFittingToStepInAndOutFeature(Diagram diagram, List<AbstractGroupingFeatureReference> stepInAndOutReferences) {
		boolean fitting = false;
		for(AbstractGroupingFeatureReference siaor : stepInAndOutReferences) {
			if(UIUtil.isDiagram_KindValue(diagram, siaor.getDiagramKind()))
				fitting = true;
		}
		return fitting;
	}
	
	/**
	 * fetches the sub class of {@link AbstractGroupingFeatureReference} fitting to the given type
	 * @param type the type referenced in the {@link AbstractGroupingFeatureReference} to search
	 * @param stepInAndOutReferences all sub classes of {@link AbstractGroupingFeatureReference}
	 * @return a stepInAndOutReference fitting the given type
	 */
	public AbstractGroupingFeatureReference getStepInAndOutReferenceForType(Type type, List<AbstractGroupingFeatureReference> stepInAndOutReferences) {
		for(AbstractGroupingFeatureReference siaor : stepInAndOutReferences) {
			if(type == siaor.getModelType())
				return siaor;
		}
		throw new StepInAndOutReferenceNotFoundException();
	}
	
	/**
	 * fetches the sub class of {@link AbstractGroupingFeatureReference} fitting to the given diagram
	 * @param diagram the diagram with the diagram kind in the {@link AbstractGroupingFeatureReference} to search
	 * @param stepInAndOutReferences all sub classes of {@link AbstractGroupingFeatureReference}
	 * @return a stepInAndOutReference fitting the diagram type
	 */
	public AbstractGroupingFeatureReference getStepInAndOutReferenceForDiagramKind(Diagram diagram, List<AbstractGroupingFeatureReference> stepInAndOutReferences) {
		if(UIUtil.isDiagram_KindValue(diagram, UILiterals.DIAGRAM_KIND_CONTAINER_DIAGRAM) ||
		   UIUtil.isDiagram_KindValue(diagram, UILiterals.DIAGRAM_KIND_MAIN_DIAGRAM))
			return null;
		for(AbstractGroupingFeatureReference siaor : stepInAndOutReferences) {
			if(UIUtil.isDiagram_KindValue(diagram, siaor.getDiagramKind()))
				return siaor;
		}
		throw new StepInAndOutReferenceNotFoundException();
	}
}
