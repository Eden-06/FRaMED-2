package org.framed.iorm.ui.pattern.connections.roleconstraint;

import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.mm.algorithms.Polygon;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.styles.LineStyle;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.util.IColorConstant;
import org.framed.iorm.model.Relation;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.literals.LayoutLiterals;
import org.framed.iorm.ui.literals.NameLiterals;
import org.framed.iorm.ui.util.PropertyUtil;

/**
 * This graphiti pattern is used to work with {@link Relation}s
 * of the type {@link Type#ROLE_EQUIVALENCEE} in the editor.
 * <p>
 * It deals with the following aspects of role equivalences:<br>
 * (1) creating role equivalences, especially their business object<br>
 * (2) adding role equivalences to the diagram, especially their pictogram elements<br>
 * <p>
 * It is a subclass of {@link AbstractRoleConstraintPattern} and several operations used here are implemented there.
 * @author Kevin Kassin
 */
public class RoleEquivalencePattern extends AbstractRoleConstraintPattern {
	
	/**
	 * the name of the feature gathered from {@link NameLiterals}
	 */
	private static final String ROLEEQUIVALENCE_FEATURE_NAME = NameLiterals.ROLEEQUIVALENCE_FEATURE_NAME;
	
	/**
	 * the identifier for the icon of the create feature gathered from {@link IdentifierLiterals}
	 */
	private static final String IMG_ID_FEATURE_ROLEEQUIVALENCE = IdentifierLiterals.IMG_ID_FEATURE_ROLEEQUIVALENCE;
	
	/**
	 * the layout integers used to layout the arrowhead of the inheritances gathered from {@link LayoutLiterals}
	 */
	private static final int ARROWHEAD_LENGTH = LayoutLiterals.ARROWHEAD_LENGTH,
							 ARROWHEAD_HEIGHT = LayoutLiterals.ARROWHEAD_HEIGHT;
							 
	/**
	 * the color values used for the polyline and the arrowhead of the role equivalences gathered from {@link LayoutLiterals}
	 */
	private static final IColorConstant COLOR_CONNECTIONS = LayoutLiterals.COLOR_CONNECTIONS,
										COLOR_ARROWHEAD = LayoutLiterals.COLOR_ARROWHEAD;		
	
	/**
	 * Class constructor
	 */
	public RoleEquivalencePattern() {
		super();
	}
	
	/**
	 * get method for the features name
	 * @return the name of the feature
	 */
	@Override
	public String getCreateName() {
		return ROLEEQUIVALENCE_FEATURE_NAME;
	}
	
	/**
	 * get method for the identifier of the icon for the create feature
	 * @return the id of the icon
	 */
	@Override
	public String getCreateImageId() {
		return IMG_ID_FEATURE_ROLEEQUIVALENCE;
	}
	
	
	//add feature
	//~~~~~~~~~~~
	/**
	 * uses the operation {@link AbstractRoleConstraintPattern#canAddRoleConstraint} of the super type to calculate if
	 * the role equivalences can be added
	 */
	@Override
	public boolean canAdd(IAddContext addContext) {
		return canAddRoleConstraint(addContext, Type.ROLE_EQUIVALENCE);
	}
	
	/**
	 * adds the role equivalences to the pictogram diagram using the following steps:
	 * <p>
	 * Step 1: create a connection shape and dashed polyline as its graphic algorithm
	 * Step 2: create the two connection decorators and arrowheads as their graphics algorithms 
	 * Step 3: link the pictogram elements and the business objects
	 */
	@Override
	public PictogramElement add(IAddContext addContext) {
		IAddConnectionContext addConnectionContext = (IAddConnectionContext) addContext;
	    Relation addedRoleEquivalence = (Relation) addContext.getNewObject();
	    Anchor sourceAnchor = addConnectionContext.getSourceAnchor();
	    Anchor targetAnchor = addConnectionContext.getTargetAnchor();
	    //Step 1
	    Connection connection = pictogramElementCreateSerive.createFreeFormConnection(getDiagram());
	    connection.setStart(sourceAnchor);
	    connection.setEnd(targetAnchor);
	    Polyline polyline = graphicAlgorithmService.createPolyline(connection);
	    polyline.setForeground(manageColor(COLOR_CONNECTIONS));
	    polyline.setLineStyle(LineStyle.DASH);
	    polyline.setLineWidth(2);
	    //Step2
	    ConnectionDecorator connectionDecoratorTarget;
	    connectionDecoratorTarget = pictogramElementCreateSerive.createConnectionDecorator(connection, false, 1.0, true);
	    int pointsTarget[] = new int[] { -1*ARROWHEAD_LENGTH, ARROWHEAD_HEIGHT,     //Point 1
	    								 0, 0, 										//P2
	    								 -1*ARROWHEAD_LENGTH, -1*ARROWHEAD_HEIGHT };//P3						 
	    Polygon arrowheadTarget = graphicAlgorithmService.createPolygon(connectionDecoratorTarget, pointsTarget);
	    arrowheadTarget.setForeground(manageColor(COLOR_CONNECTIONS));
	    arrowheadTarget.setBackground(manageColor(COLOR_ARROWHEAD));
	    PropertyUtil.setShape_IdValue(connectionDecoratorTarget, SHAPE_ID_ROLE_CONSTRAINT_DECORATOR);
	    ConnectionDecorator connectionDecoratorSource;
	    connectionDecoratorSource = pictogramElementCreateSerive.createConnectionDecorator(connection, false, 0, true);
	    int pointsSource[] = new int[] { -1*ARROWHEAD_LENGTH, ARROWHEAD_HEIGHT, 	//Point 1
	    						   		 0, 0, 									  	 //P2
	    						   		 -1*ARROWHEAD_LENGTH, -1*ARROWHEAD_HEIGHT }; //P3						 
	    Polygon arrowheadSource = graphicAlgorithmService.createPolygon(connectionDecoratorSource, pointsSource);
	    arrowheadSource.setForeground(manageColor(COLOR_CONNECTIONS));
	    arrowheadSource.setBackground(manageColor(COLOR_ARROWHEAD));
	    PropertyUtil.setShape_IdValue(connectionDecoratorSource, SHAPE_ID_ROLE_CONSTRAINT_DECORATOR);
	    //Step 3
	    link(connection, addedRoleEquivalence);
	    return connection;
	}
	 
	//create feature
	//~~~~~~~~~~~~~~  
	/**
	 * uses the operation {@link AbstractRoleConstraintPattern#createRoleConstraint} of the super type to create the role equivalences
	 */
	@Override
	public Connection create(ICreateConnectionContext createContext) {
		return super.createRoleConstraint(createContext, Type.ROLE_EQUIVALENCE, this);
	}
}
