package org.framed.iorm.ui.graphitifeatures;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IMoveConnectionDecoratorContext;
import org.eclipse.graphiti.features.impl.DefaultMoveConnectionDecoratorFeature;
import org.framed.iorm.ui.literals.IdentifierLiterals;
import org.framed.iorm.ui.providers.FeatureProvider;
import org.framed.iorm.ui.util.PropertyUtil;

/**
 * This graphiti custom feature is used to determine which connection decorators can be moved and which not.
 * <p>
 * It is returned by the operation {@link FeatureProvider#getMoveConnectionDecoratorFeature}.
 * @author Kevin Kassin
 */
public class FRaMEDMoveConnectionDecoratorFeature extends DefaultMoveConnectionDecoratorFeature {

	/**
	 * values for property shape id of the connection decorators that should be moveable
	 */
	private static final String SHAPE_ID_RELATIONSHIP_NAME_DECORATOR = IdentifierLiterals.SHAPE_ID_RELATIONSHIP_NAME_DECORATOR,
								SHAPE_ID_INTRA_REL_CON_NAME_DECORATOR = IdentifierLiterals.SHAPE_ID_INTRA_REL_CON_NAME_DECORATOR;
	
	/**
	 * Class constructor
	 * @param featureProvider the feature provider the feature belongs to
	 */
	public FRaMEDMoveConnectionDecoratorFeature(IFeatureProvider featureProvider) {
		super(featureProvider);
	}
	
	/**
	 * calculates if a connection decorator can be moved 
	 */
	public boolean canMoveConnectionDecorator(IMoveConnectionDecoratorContext context) {
		if(PropertyUtil.isShape_IdValue(context.getConnectionDecorator(), SHAPE_ID_RELATIONSHIP_NAME_DECORATOR) ||
		   PropertyUtil.isShape_IdValue(context.getConnectionDecorator(), SHAPE_ID_INTRA_REL_CON_NAME_DECORATOR))
			return true;
		return false;
	}
}
