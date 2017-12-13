package org.framed.iorm.ui.pattern.connections.interrelationship;

import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.framed.iorm.model.Relation;
import org.framed.iorm.model.Type;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.literals.NameLiterals;
import org.framed.iorm.ui.util.PropertyUtil;

/**
 * This graphiti pattern is used to work with {@link Relation}s
 *	of the type {@link Type#RELATIONSHIP_EXCLUSION} in the editor.
 * <p>
 * It deals with the following aspects of exclusion inter relationship constraints:<br>
 * (1) creating the constraints, especially their business object<br>
 * (2) adding the constraints to the diagram, especially their pictogram elements<br>
 * <p>
 * It is a subclass of {@link AbstractInterRelationshipConstraintPattern} and several operations used here are implemented there.
 * @author Kevin Kassin
 */
public class RelationshipExclusionConstraintPattern extends AbstractInterRelationshipConstraintPattern {

	/**
	 * the name of the feature gathered from {@link NameLiterals}
	 */
	private final String RELATIONSHIP_EXCLUSION_FEATURE_NAME = NameLiterals.RELATIONSHIP_EXCLUSION_FEATURE_NAME;
		     
	/**
	 * the identifier for the icon of the create feature gathered from {@link IdentifierLiterals}
	 */
	private static final String IMG_ID_FEATURE_RELATIONSHIP_EXCLUSION = IdentifierLiterals.IMG_ID_FEATURE_RELATIONSHIP_EXCLUSION;
	
	/**
	 * Class constructor
	 */
	public RelationshipExclusionConstraintPattern() {
		super();
	}
	
	/**
	 * get method for the features name
	 * @return the name of the feature
	 */
	@Override
	public String getCreateName() {
		return RELATIONSHIP_EXCLUSION_FEATURE_NAME;
	}
	
	/**
	 * get method for the identifier of the icon for the create feature
	 * @return the id of the icon
	 */
	@Override
	public String getCreateImageId() {
		return IMG_ID_FEATURE_RELATIONSHIP_EXCLUSION;
	}
	
	//add feature
	//~~~~~~~~~~~
	/**
	 * uses the super types equivalent operation to calculate if the relationship exclusion can be added
	 */
	@Override
	public boolean canAdd(IAddContext addContext) {
		return canAddInterRelationshipConstraint(addContext, Type.RELATIONSHIP_EXCLUSION);
		}
	
	/**
	 * adds the role equivalences to the pictogram diagram using the following steps:
	 * <p>
	 * Step 1: get anchors used to hook in the inter relationship constraint for the pictogram model<br> 
	 * Step 2: create a connection shape and dashed polyline as its graphic algorithm<br>
	 * Step 3: create the connection decorators and their graphics algorithms<br>
	 * Step 4: link the pictogram elements and the business objects<br>
	 * <p>
	 * Step 1 and 2 are executed by the operation 
	 * {@link AbstractInterRelationshipConstraintPattern#addConnectionForInterRelationshipConstraint}.
	 */
	@Override
	public PictogramElement add(IAddContext addContext) {
		Relation addedRoleImplication = (Relation) addContext.getNewObject();
	    //Step 1 and 2
		Connection connection = addConnectionForInterRelationshipConstraint(addContext);
		if(connection == null) return null;
		//Step 3
	    ConnectionDecorator connectionDecoratorTarget = 
	    	pictogramElementCreateService.createConnectionDecorator(connection, false, 1.0, true);
	    int points[] = new int[] { 0, ARROWHEAD_HEIGHT, 	//Point 1
				 				  -1*ARROWHEAD_LENGTH, 0, 	//P2
				 				   0, -1*ARROWHEAD_HEIGHT };//P3						 
	    Polyline polylineTarget = graphicAlgorithmService.createPolyline(connectionDecoratorTarget, points);
	    polylineTarget.setLineWidth(2); 
	    polylineTarget.setForeground(manageColor(COLOR_CONSTRAINT_CONNECTION));
	    PropertyUtil.setShape_IdValue(connectionDecoratorTarget, SHAPE_ID_INTER_REL_CON);
	    ConnectionDecorator connectionDecoratorSource = 
	    	pictogramElementCreateService.createConnectionDecorator(connection, false, 0, true);					 
	    Polyline polylineSource = graphicAlgorithmService.createPolyline(connectionDecoratorSource, points);
	    polylineSource.setLineWidth(2); 
	    polylineSource.setForeground(manageColor(COLOR_CONSTRAINT_CONNECTION));
	    PropertyUtil.setShape_IdValue(connectionDecoratorSource, SHAPE_ID_INTER_REL_CON);
	    //Step 4
	    link(connection, addedRoleImplication);
	    return connection;
	}
	
	//create feature
	//~~~~~~~~~~~~~~  
	/**
	 * uses the super types equivalent operation to create the relationship exclusion
	 */
	@Override
	public Connection create(ICreateConnectionContext createContext) {
		return super.createInterRelationshipConstraint(createContext, Type.RELATIONSHIP_EXCLUSION, this);
	}
}
