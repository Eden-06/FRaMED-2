package org.framed.iorm.ui.pattern.connections;

import java.util.List;

import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.util.IColorConstant;
import org.framed.iorm.model.Model;
import org.framed.iorm.model.OrmFactory;
import org.framed.iorm.model.Relation;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.literals.LayoutLiterals;
import org.framed.iorm.ui.pattern.shapes.FRaMEDShapePattern;
import org.framed.iorm.ui.util.ConnectionPatternUtil;
import org.framed.iorm.ui.util.DiagramUtil;
import org.framed.iorm.ui.util.PropertyUtil;

//TODO implemented as shapePattern since it should be clicked on a relationship
public abstract class AbstractIntraRelationshipConstraintFeature extends FRaMEDShapePattern {

	/**
	 * the identifier for the icon of the create feature gathered from {@link IdentifierLiterals}
	 */
	private static final String IMG_ID_FEATURE_INTRARELATIONSHIP_CONSTRAINT = IdentifierLiterals.IMG_ID_FEATURE_INTRARELATIONSHIP_CONSTRAINT;
	
	//TODO
	protected static final String SHAPE_ID_INTRA_REL_CON_NAME_DECORATOR = IdentifierLiterals.SHAPE_ID_INTRA_REL_CON_NAME_DECORATOR;
	
	/**
	 * the color values gathered from {@link LayoutLiterals}
	 */
	protected static final IColorConstant COLOR_CONNECTIONS = LayoutLiterals.COLOR_CONNECTIONS,
										  COLOR_TEXT = LayoutLiterals.COLOR_TEXT;
	
	public AbstractIntraRelationshipConstraintFeature() {
		super();
	}
	
	/**
	 * get method for the identifier of the common icon for the create features of all 
	 * intra relationship constraints
	 * @return the id of the icon
	 */
	@Override
	public String getCreateImageId() {
		return IMG_ID_FEATURE_INTRARELATIONSHIP_CONSTRAINT;
	}
	
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

	@Override
	protected boolean isPatternControlled(PictogramElement pictogramElement) {
		return isMainBusinessObjectApplicable(this.getBusinessObjectForPictogramElement(pictogramElement));
	}

	@Override
	protected boolean isPatternRoot(PictogramElement pictogramElement) {
		return isMainBusinessObjectApplicable(this.getBusinessObjectForPictogramElement(pictogramElement));
	}
	
	//add feature
	//~~~~~~~~~~~
	//TODO
	public boolean canAddIntraRelationshipConstraint(IAddContext addContext, Type type) {
		if(addContext.getNewObject() instanceof Relation) {
		   Relation relation = (Relation) addContext.getNewObject();
		   if(relation.getType() == type) {
			   return true;
		}	}
		return false;
	}
	
	//TODO
	public PictogramElement addIntraRelationshipConstraint(IAddContext addContext, Type type) {
		Connection targetConnection = addContext.getTargetConnection();
		ConnectionDecorator constraintName = 
			pictogramElementCreateService.createConnectionDecorator(targetConnection, true, 0.5, true); 
		Text nameText = graphicAlgorithmService.createText(constraintName, type.getName().toLowerCase());
		nameText.setForeground(manageColor(COLOR_TEXT)); 
		PropertyUtil.setShape_IdValue(constraintName, SHAPE_ID_INTRA_REL_CON_NAME_DECORATOR);
		link(constraintName, addContext.getNewObject());
		return constraintName;
	}	
		
	//create feature
	//~~~~~~~~~~~~~~
	/**
	 * calculates if a intra relationship constraint can be created
	 * <p>
	 * returns true if<br>
	 * TODO
	 * @return if inheritance can be added
	 */
	@Override
	public boolean canCreate(ICreateContext createContext) {
		Connection targetConnection = createContext.getTargetConnection();
		if(targetConnection != null &&
		   getBusinessObjectForPictogramElement(targetConnection) instanceof Relation) {
			Relation relation = (Relation) getBusinessObjectForPictogramElement(targetConnection);
			return (relation.getType() == Type.RELATIONSHIP);
		}
	    return false;
	}
		
	public Object[] createIntraRelationshipConstraint(ICreateContext createContext, Type type) {
		Connection targetConnection = createContext.getTargetConnection();
		Anchor sourceAnchor = targetConnection.getStart(),
			   targetAnchor = targetConnection.getEnd();
		//Step 1...
		Relation newIntraRelCon = OrmFactory.eINSTANCE.createRelation();
	    newIntraRelCon.setType(type); 
	    Model model = DiagramUtil.getLinkedModelForDiagram(getDiagram());
		if(newIntraRelCon.eResource() != null) getDiagram().eResource().getContents().add(newIntraRelCon);
		model.getElements().add(newIntraRelCon);
		newIntraRelCon.setContainer(model);
		newIntraRelCon.setSource(ConnectionPatternUtil.getShapeForAnchor(sourceAnchor));
		newIntraRelCon.setTarget(ConnectionPatternUtil.getShapeForAnchor(targetAnchor));    
		addGraphicalRepresentation(createContext, newIntraRelCon);
		return new Object[] { newIntraRelCon };
	}
}
