package rolegroup;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	/*public String getNameOfPictogramElement(PictogramElement pictogramElement) {
		return UIUtil.getNameOfPictogramElement(pictogramElement, literals.SHAPE_ID_COMPARTMENTTYPE_NAME);
	}*/
	
	//Direct Editing
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
