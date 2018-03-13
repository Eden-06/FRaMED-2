package relationship.intra_relationship_constraints;

import java.util.List;

import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.context.impl.DeleteContext;
import org.eclipse.graphiti.features.context.impl.MultiDeleteInfo;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.LineStyle;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.framed.iorm.model.Model;
import org.framed.iorm.model.OrmFactory;
import org.framed.iorm.model.Relation;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.FRaMEDShapePattern;
import org.framed.iorm.ui.UIUtil;
import org.framed.iorm.ui.editPolicy.EditPolicyService;
import org.framed.iorm.ui.palette.FeaturePaletteDescriptor;
import org.framed.iorm.ui.palette.PaletteCategory;
import org.framed.iorm.ui.palette.PaletteView;
import org.framed.iorm.ui.palette.ViewVisibility;

/**
 * This is the abstract super class of the patterns for intra relationship contraints. It collects similiar operations
 * and attributes of the patterns {@link AcyclicConstraintPattern}, {@link CyclicConstraintPattern}, 
 * {@link IrreflexiveConstraintPattern}, {@link ReflexiveConstraintPattern} and {@link TotalConstraintPattern}.
 * <p>
 * This is implemented as shape pattern instead of a connection pattern since its easier for the user to click on a relationship to
 * add a constraint. This would not be able if a connection pattern would be used. As a developer this solution is also preferred as
 * this way already provides the relationship to add the constraint to. Otherwise the relationship has to be searched and more code
 * would be needed.
 * @author Kevin Kassin
 */
public abstract class AbstractIntraRelationshipConstraintPattern extends FRaMEDShapePattern {

	/**
	 * the object to get names, ids and so on for this feature
	 */
	private final Literals literals = new Literals();
	
	/**
	 * the feature palette descriptor manages the palette visibility, see {@link FeaturePaletteDescriptor}
	 */
	private final FeaturePaletteDescriptor spec_FPD = new FeaturePaletteDescriptor(
			PaletteCategory.CONSTRAINTS_CATEGORY,
			ViewVisibility.COMPARTMENT_VIEW) {
				@Override
				public boolean featureExpression(List<String> framedFeatureNames, PaletteView paletteView) {
					return framedFeatureNames.contains("Intra_Relationship_Constraints");
			}	};
			
	/**
	 * Class constructor
	 */
	public AbstractIntraRelationshipConstraintPattern() {
		super();
		FPD = spec_FPD;
		ICON_IMG_PATH = literals.ICON_IMG_PATH;
	}			
		
	/**
	 * checks if pattern is applicable for a given business object
	 * @return true, if the business object is a {@link org.framed.iorm.model.Relation} of the right type 
	 */
	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
		if(mainBusinessObject instanceof Relation) {
			Relation relation = (Relation) mainBusinessObject;
			if(relation.getType() == Type.ACYCLIC ||
			   relation.getType() == Type.CYCLIC ||
			   relation.getType() == Type.REFLEXIVE ||
			   relation.getType() == Type.IRREFLEXIVE ||
			   relation.getType() == Type.TOTAL)
			return true;	
		}
		return false;
	}

	/**
	 * checks if pattern is applicable for a given pictogram element
	 * @return true, if business object of the pictogram element is a {@link org.framed.iorm.model.Relation} of the right type 
	 */
	@Override
	protected boolean isPatternControlled(PictogramElement pictogramElement) {
		return isMainBusinessObjectApplicable(this.getBusinessObjectForPictogramElement(pictogramElement));
	}
	
	/**
	 * checks if pattern is applicable for a given pictogram element
	 * @return true, if the business object of the pictogram element is a {@link org.framed.iorm.model.Relation} of the right type
	 */
	@Override
	protected boolean isPatternRoot(PictogramElement pictogramElement) {
		return isMainBusinessObjectApplicable(this.getBusinessObjectForPictogramElement(pictogramElement));
	}
	
	//add feature
	//~~~~~~~~~~~
	/**
	 * calculates if the intra relationship constraint can be added to the relationship
	 * <p>
	 * returns true if:<br>
	 * (1) the new business object is a {@link org.framed.iorm.model.Relation} of the right type 
	 * @return if the intra relationship constraint can be added
	 */
	public boolean canAddIntraRelationshipConstraint(IAddContext addContext, Type type) {
		if(addContext.getNewObject() instanceof Relation) {
		   Relation relation = (Relation) addContext.getNewObject();
		   if(relation.getType() == type) {
			   return EditPolicyService.canAdd(addContext, this.getDiagram());
		}	}
		return false;
	}
	
	/**
	 * adds the graphical representation of an intra relationship constraint in the relationship and changes the visual
	 * appearance of the relationship if it didn't had an intra relationship constraint before 
	 * <p>
	 * @param addContext the context which has a reference to the relationship to add the constraint to
	 * @param type the type of the constraint to add
	 * @return the connection decorator with the constraints name added
	 */
	public PictogramElement addIntraRelationshipConstraint(IAddContext addContext, Type type) {
		Connection targetConnection = addContext.getTargetConnection();
		Relation targetRelation = (Relation) getBusinessObjectForPictogramElement(targetConnection);
		Polyline poyline = (Polyline) targetConnection.getGraphicsAlgorithm();
		((Relation) addContext.getNewObject()).getReferencedRelation().add(targetRelation);
		int numberOfReferencedRelations = targetRelation.getReferencedRelation().size();
		poyline.setLineStyle(LineStyle.DASH);
		ConnectionDecorator constraintName = 
			pictogramElementCreateService.createConnectionDecorator(targetConnection, true, 0.5, true); 
		Text nameText = graphicAlgorithmService.createText(constraintName, type.getName().toLowerCase());
		nameText.setForeground(manageColor(literals.COLOR_CONSTRAINT_TEXT));
		graphicAlgorithmService.setLocation(nameText, literals.DISTANCE_FROM_CONNECTION_LINE, (numberOfReferencedRelations-1)*literals.HEIGHT_INTRAREL_CONSTRAINT);
		UIUtil.setShape_IdValue(constraintName, literals.SHAPE_ID_INTRA_REL_CON_NAME_DECORATOR);
		link(constraintName, addContext.getNewObject());
		return constraintName;
	}	
		
	//create feature
	//~~~~~~~~~~~~~~
	/**
	 * calculates if a intra relationship constraint can be created
	 * <p>
	 * returns true if the clicked on pictogram element belongs to a relationship
	 * @return if inheritance can be added
	 */
	@Override
	public boolean canCreate(ICreateContext createContext) {
		Connection targetConnection = createContext.getTargetConnection();
		if(targetConnection != null &&
		   getBusinessObjectForPictogramElement(targetConnection) instanceof Relation) {
			Relation relation = (Relation) getBusinessObjectForPictogramElement(targetConnection);
			return (relation.getType() == Type.RELATIONSHIP) && EditPolicyService.canCreate(createContext, this.getDiagram());
		}
	    return false;
	}
	
	/**
	 * creates the business object of an intra relationship constraint of the given type 
	 * @param createContext the context which has a reference to the relationship to add the constraint to 
	 * @param type the type of the constraint to add to
	 * @param aircp the sub class calling this operation
	 * @return the created business object
	 */
	public Object[] createIntraRelationshipConstraint(ICreateContext createContext, Type type, AbstractIntraRelationshipConstraintPattern aircp) {
		Connection targetConnection = createContext.getTargetConnection();
		Relation targetRelation = (Relation) getBusinessObjectForPictogramElement(targetConnection);
		Anchor sourceAnchor = targetConnection.getStart(),
			   targetAnchor = targetConnection.getEnd();
		Relation newIntraRelCon = OrmFactory.eINSTANCE.createRelation();
	    newIntraRelCon.setType(type); 
	    Model model = targetRelation.getContainer();
		model.getElements().add(newIntraRelCon);
		newIntraRelCon.setContainer(model);
		newIntraRelCon.setSource(UIUtil.getModelElementForAnchor(sourceAnchor));
		newIntraRelCon.setTarget(UIUtil.getModelElementForAnchor(targetAnchor)); 
		targetRelation.getReferencedRelation().add(newIntraRelCon);
		AddContext addContext = new AddContext();
	    addContext.setNewObject(newIntraRelCon);
	    addContext.setTargetConnection(targetConnection);
	    if(aircp.canAdd(addContext)) aircp.add(addContext);
		return new Object[] { newIntraRelCon };
	}
	
	//delete feature
	//~~~~~~~~~~~~~~
	/**
	 * disables the "Are you sure?" message when intra relationship constraints and changes the visual appearance of the 
	 * relation if it does not longer has a intra relationship constraint after the execution of delete
	 */
	@Override
	public void delete(IDeleteContext deleteContext) {
		Connection targetConnection = ((ConnectionDecorator) deleteContext.getPictogramElement()).getConnection();
		Relation targetRelation = (Relation) getBusinessObjectForPictogramElement(targetConnection);
		if(targetRelation.getReferencedRelation().size() == 1) {
			Polyline poyline = (Polyline) targetConnection.getGraphicsAlgorithm();
			poyline.setLineStyle(LineStyle.SOLID);
		}	
		((DeleteContext) deleteContext).setMultiDeleteInfo(new MultiDeleteInfo(false, false, 0));
		super.delete(deleteContext);
	}
}
