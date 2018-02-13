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
	
	/**
	 * Convenience operation to call {@link UIUtil#getOccurenceConstraintOfPictogramElement(PictogramElement, String)} with the correct parameters.
	 */
	public String getOccurenceConstraintOfPictogramElement(PictogramElement pictogramElement) {
		return UIUtil.getOccurenceConstraintOfPictogramElement(pictogramElement, literals.SHAPE_ID_ROLEGROUP_OCCURRENCE_CONSTRAINT);
	}
	
	//Diagram
	//~~~~~~~
	/**
	 * returns the diagram of a role group
	 */
	public Diagram getRoleGroupDiagramForItsShape(Shape typeBodyShape, Diagram diagram) {
		for(Shape children : typeBodyShape.getContainer().getChildren()) {
			if(children instanceof Diagram) {
				return (Diagram) children;
		}	}
		return null;
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
