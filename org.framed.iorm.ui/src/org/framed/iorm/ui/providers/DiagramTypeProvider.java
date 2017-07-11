package org.framed.iorm.ui.providers;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;

/**
 * This class provides the used diagrams and manages the feature and tool behavior providers of the diagram type
 * @author Kevin Kassin
 */
public class DiagramTypeProvider extends AbstractDiagramTypeProvider {
	
	/**
	 * the list of {@link ToolBehaviorProvider}s of the diagram type
	 */
	private IToolBehaviorProvider[] toolBehaviorProviders;
	
	/**
	 * Class constructor
	 */
	public DiagramTypeProvider() { 
		super(); 
		setFeatureProvider(new FeatureProvider(this));
	}
	
	/**
	 * returns existing {@link ToolBehaviorProvider}s or creates an new list of {@link ToolBehaviorProvider}s with one in it	
	*/
	@Override
	public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() {
		if (toolBehaviorProviders == null)
			toolBehaviorProviders = new IToolBehaviorProvider[] { new ToolBehaviorProvider(this) };
		return toolBehaviorProviders;
	}
}
