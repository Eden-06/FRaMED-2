package rolegroup;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.framed.iorm.ui.UIUtil;

public class Util {

	/**
	 * the object to get names, ids and so on for this feature
	 */
	private final Literals literals = new Literals();
	
	//Update
	//~~~~~~
	/**
	 * Convenience operation to call {@link UIUtil#getNameOfPictogramElement(PictogramElement, String)} with the correct parameters.
	 */
	public String getNameOfPictogramElement(PictogramElement pictogramElement) {
		return UIUtil.getNameOfPictogramElement(pictogramElement, literals.SHAPE_ID_ROLEGROUP_NAME);
	}
	
	//Diagram
	//~~~~~~~
	/**
	 * Convenience operation to call {@link UIUtil#getDiagramForGroupingShape(Shape, Diagram, String, String, String)} 
	 * with the correct parameters.
	 */
	public Diagram getRoleGroupDiagramForItsShape(Shape typeShape, Diagram diagram) {
		return UIUtil.getDiagramForGroupingShape(typeShape, diagram, 
			   literals.SHAPE_ID_ROLEGROUP_TYPEBODY, literals.SHAPE_ID_ROLEGROUP_NAME, literals.DIAGRAM_KIND);
	}
	
	//Direct Editing
	//~~~~~~~~~~~~~~
	/**
	 * matching operation for the regular expression of operations
	 * @param identifier the string to check against
	 * @return if the given string input matches the regular expression
	 */
	public final boolean matchesRoleGroupName(String roleGroupName) {
		Matcher roleGroupMatcher =  Pattern.compile(literals.REG_EXP_NAME).matcher(roleGroupName);
		return roleGroupMatcher.matches();
	}
}
