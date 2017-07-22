package org.framed.iorm.ui.wizards;

import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.framed.iorm.model.Relation;
import org.framed.iorm.ui.literals.LayoutLiterals;
import org.framed.iorm.ui.literals.NameLiterals;
import org.framed.iorm.ui.literals.TextLiterals;
import org.framed.iorm.ui.util.NameUtil;
import org.framed.iorm.ui.graphitifeatures.EditRelationshipFeature; //*import for javadox link

/**
 * This class represents a dialog to edit relationships name and cardinalities.
 * @author Kevin Kassin
 */
public class EditRelationshipDialog extends Dialog {
	
	/**
	 * the name of the custom feature using this dialog gathered from {@link NameLiterals}
	 */
	private final String EDIT_RELATIONSHIP_FEATURE_NAME = NameLiterals.EDIT_RELATIONSHIP_FEATURE_NAME;
	
	/**
	 * messages and titles used as tips when invalid inputs happen gathered from {@link TextLiterals}
	 */
	private final String EDITING_RELATIONSHIPS_NAME_TITLE = TextLiterals.EDITING_RELATIONSHIPS_NAME_TITLE,
						 EDITING_RELATIONSHIPS_NAME = TextLiterals.EDITING_RELATIONSHIPS_NAME,
						 EDITING_RELATIONSHIPS_SOURCE_CARDINALITY_TITLE = TextLiterals.EDITING_RELATIONSHIPS_SOURCE_CARDINALITY_TITLE,
						 EDITING_RELATIONSHIPS_SOURCE_CARDINALITY = TextLiterals.EDITING_RELATIONSHIPS_SOURCE_CARDINALITY,
						 EDITING_RELATIONSHIPS_TARGET_CARDINALITY_TITLE = TextLiterals.EDITING_RELATIONSHIPS_TARGET_CARDINALITY_TITLE,
						 EDITING_RELATIONSHIPS_TARGET_CARDINALITY = TextLiterals.EDITING_RELATIONSHIPS_TARGET_CARDINALITY;
	
	/**
	 * the height and width of the dialog gathered from {@link LayoutLiterals}
	 */
	private final int HEIGHT_EDIT_CONNECTION_DIALOG = LayoutLiterals.HEIGHT_EDIT_CONNECTION_DIALOG,
					  WIDTH_EDIT_CONNECTION_DIALOG = LayoutLiterals.WIDTH_EDIT_CONNECTION_DIALOG;

	/**
	 * the business object of the edited relationship 
	 */
	private Relation businessObject;
	
	/**
	 * a reference to a list filled with the name and the cardinalities of the relationship commonly used by this dialog and 
	 * the {@link EditRelationshipFeature}
	 */
	private List<String> relationshipValues;
	
	/**
	 * the text fields used in the dialog
	 */
	private Text relationshipNameTextField,
				 sourceCardinalityTextField,
			     targetCardinalityTextField;
	
	/**
	 * internal enum used as parameters for operations which work with text fields to reference which text fields should
	 * be created or handled
	 * @author Kevin Kassin
	 */
	private enum TextfieldType {
		RELATIONSHIP_NAME, 
		SOURCE_CARDINALITY,
		TARGET_CARDINALITY;
	}
	
	/**
	 * Class constructor
	 * @param parentShell the used shell
	 * @param businessObject the relationship to edit
	 * @param the commonly used list of the name and the cardinalities of the relationship
	 */
	public EditRelationshipDialog(Shell parentShell, Relation businessObject, List<String> relationshipValues) {
		super(parentShell);
		this.businessObject = businessObject;
		this.relationshipValues = relationshipValues;
	}
	
	/**
	 * sets the name and the size of the dialog
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText(EDIT_RELATIONSHIP_FEATURE_NAME + " " + businessObject.getName());
		newShell.setSize(WIDTH_EDIT_CONNECTION_DIALOG, HEIGHT_EDIT_CONNECTION_DIALOG);
	}
	
	/**
	 * uses the operation {@link #createTextfield} to create the labels and text fields of the dialog
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
        Composite container = new Composite(composite, SWT.NONE);
        container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        GridLayout layout = new GridLayout(2, false);
        container.setLayout(layout);
        
        createTextfield(container, TextfieldType.RELATIONSHIP_NAME);
        createTextfield(container, TextfieldType.SOURCE_CARDINALITY);
        createTextfield(container, TextfieldType.TARGET_CARDINALITY);
        return composite;
	}
	
	/**
	 * creates the label and the text field depending on the given {@link TextfieldType}
	 * @param container the composite to create the label and text field in
	 * @param type reference which label and text field should be created 
	 */
	private void createTextfield(Composite container, TextfieldType type) {
        Label label = new Label(container, SWT.NONE);
        GridData layoutData = new GridData();
        layoutData.grabExcessHorizontalSpace = true;
        layoutData.horizontalAlignment = GridData.FILL;
        switch(type) {
        	case RELATIONSHIP_NAME:
        		relationshipNameTextField = new Text(container, SWT.BORDER);
                relationshipNameTextField.setLayoutData(layoutData);
        		label.setText("Name:");
		        relationshipNameTextField.setText(businessObject.getName());
		        break;
        	case SOURCE_CARDINALITY:
        		sourceCardinalityTextField = new Text(container, SWT.BORDER);
        		sourceCardinalityTextField.setLayoutData(layoutData);
        		label.setText("Source cardinality (" +businessObject.getSource().getName() + "):");
        		sourceCardinalityTextField.setText(businessObject.getSourceLabel().getName());
	        	break;
        	case TARGET_CARDINALITY:
        		targetCardinalityTextField = new Text(container, SWT.BORDER);
        		targetCardinalityTextField.setLayoutData(layoutData);
        		label.setText("Target cardinality (" +businessObject.getTarget().getName() + "):");
        		targetCardinalityTextField.setText(businessObject.getTargetLabel().getName());
        		 break;
    }	}
	
	/**
	 * checks if all user inputs are valid
	 * <p>
	 * If yes, it closes the dialog. If not it gives the user a hint which and what is wrong with its input.
	 */
	@Override
	protected void okPressed() {
		if(isValid(TextfieldType.RELATIONSHIP_NAME) &&
		   isValid(TextfieldType.SOURCE_CARDINALITY) &&
		   isValid(TextfieldType.TARGET_CARDINALITY)) {
			relationshipValues.add(relationshipNameTextField.getText());
			relationshipValues.add(sourceCardinalityTextField.getText());
			relationshipValues.add(targetCardinalityTextField.getText());
			close();
		}
		else {
			if(!(isValid(TextfieldType.RELATIONSHIP_NAME))) {
				MessageDialog.openError(getParentShell(), EDITING_RELATIONSHIPS_NAME_TITLE, EDITING_RELATIONSHIPS_NAME);
				return;
			}
			if(!(isValid(TextfieldType.SOURCE_CARDINALITY))) {
				MessageDialog.openError(getParentShell(), EDITING_RELATIONSHIPS_SOURCE_CARDINALITY_TITLE, EDITING_RELATIONSHIPS_SOURCE_CARDINALITY);
				return;
			}
			if(!(isValid(TextfieldType.TARGET_CARDINALITY))) {
				MessageDialog.openError(getParentShell(), EDITING_RELATIONSHIPS_TARGET_CARDINALITY_TITLE, EDITING_RELATIONSHIPS_TARGET_CARDINALITY);
			}
		}
	}
	
	/**
	 * checks if a single user input (name, source or target cardinality) is valid
	 * @param type reference to which user input should be checked
	 * @return if a user input fitting the given type is valid
	 */
	private boolean isValid(TextfieldType type) {
		switch(type) {
	    	case RELATIONSHIP_NAME:
	    		String name = relationshipNameTextField.getText();
	    		return NameUtil.matchesIdentifier(name);
	    	case SOURCE_CARDINALITY:
	    		String sourceCardinality = sourceCardinalityTextField.getText();
	    		return NameUtil.matchesCardinality(sourceCardinality);
	    	case TARGET_CARDINALITY:
	    		String targetCardinality = targetCardinalityTextField.getText();
	    		return NameUtil.matchesCardinality(targetCardinality);
		}
		return false;
	}
}
