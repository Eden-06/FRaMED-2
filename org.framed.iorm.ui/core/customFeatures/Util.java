package customFeatures;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.literals.UILiterals;
import org.framed.iorm.ui.util.UIUtil;

import attributeAndOperation.references.AbstractUsedInReference;
import customFeatures.references.AbstractStepInAndOutReference;
import customFeatures.references.StepInAndOutReferenceNotFoundException;

public class Util {

	//StepInAndOutReferences
	//~~~~~~~~~~~~~~~~
	/**
	 * get all sub classes of {@link AbstractUsedInReference} for a given list of classes 
	 * @param classes a given list of classes of different types
	 * @return a list of classes have {@link AbstractUsedInReference} as their super class
	 */
	public List<AbstractStepInAndOutReference> getStepInAndOutReferences(List<Class<?>> classes) {
		List<AbstractStepInAndOutReference> stepInAndOutReferences = new ArrayList<AbstractStepInAndOutReference>();
		for(Class<?> cl : classes) {
			if(!Modifier.isAbstract(cl.getModifiers())) {
				if(UIUtil.getSuperClasses(cl).contains(AbstractStepInAndOutReference.class)) {
					try {
						Object object = cl.newInstance();
						stepInAndOutReferences.add((AbstractStepInAndOutReference) object);
					} catch (InstantiationException | IllegalAccessException e) { e.printStackTrace(); }
		} 	}	}
		return stepInAndOutReferences;
	}
	
	/**
	 * checks if the given {@link Shape} is typebody referenced in a list of {@link AbstractStepInAndOutReference}s.
	 * @param shape
	 * @param stepInAndOutReferences
	 * @return
	 */
	public boolean shapeIsFittingToStepInAndOutFeature(Shape shape, List<AbstractStepInAndOutReference> stepInAndOutReferences) {
		boolean fitting = false;
		for(AbstractStepInAndOutReference siaor : stepInAndOutReferences) {
			if(UIUtil.isShape_IdValue(shape, siaor.getShapeIdTypebody()))
				fitting = true;
		}
		return fitting;
	}
	
	/**
	 * checks if the given {@link Diagram} is typebody referenced in a list of {@link AbstractStepInAndOutReference}s.
	 * @param shape
	 * @param stepInAndOutReferences
	 * @return
	 */
	public boolean diagramIsFittingToStepInAndOutFeature(Diagram diagram, List<AbstractStepInAndOutReference> stepInAndOutReferences) {
		boolean fitting = false;
		for(AbstractStepInAndOutReference siaor : stepInAndOutReferences) {
			if(UIUtil.isDiagram_KindValue(diagram, siaor.getDiagramKind()))
				fitting = true;
		}
		return fitting;
	}
	
	//TODO doku
	public AbstractStepInAndOutReference getStepInAndOutReferenceForType(Type type, List<AbstractStepInAndOutReference> stepInAndOutReferences) {
		for(AbstractStepInAndOutReference siaor : stepInAndOutReferences) {
			if(type == siaor.getModelType())
				return siaor;
		}
		throw new StepInAndOutReferenceNotFoundException();
	}
	
	//TODO doku
	public AbstractStepInAndOutReference getStepInAndOutReferenceForDiagramKind(Diagram diagram, List<AbstractStepInAndOutReference> stepInAndOutReferences) {
		//Step 1
		if(UIUtil.isDiagram_KindValue(diagram, UILiterals.DIAGRAM_KIND_CONTAINER_DIAGRAM) ||
		   UIUtil.isDiagram_KindValue(diagram, UILiterals.DIAGRAM_KIND_MAIN_DIAGRAM))
			return null;
		//Step 2
		for(AbstractStepInAndOutReference siaor : stepInAndOutReferences) {
			if(UIUtil.isDiagram_KindValue(diagram, siaor.getDiagramKind()))
				return siaor;
		}
		throw new StepInAndOutReferenceNotFoundException();
	}
}
