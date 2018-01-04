package relationship;

import java.util.List;

import org.eclipse.graphiti.mm.pictograms.Diagram;
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

/**
 * This class represents a dialog to edit relationships name and cardinalities.
 * @author Kevin Kassin
 */
public class EditRelationshipDialog extends Dialog {
		
	/**
	 * the object to get names, ids and so on for this feature
	 */
	Literals literals = new Literals();
	
	/**
	 * the object to call utility operations on
	 */
	private final Util util = new Util();
	
	/**
	 * the diagram of the compartment type the relation is created in
	 */
	private Diagram diagram;
	
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
	public EditRelationshipDialog(Shell parentShell, Diagram diagram, Relation businessObject, List<String> relationshipValues) {
		super(parentShell);
		this.diagram = diagram;
		this.businessObject = businessObject;
		this.relationshipValues = relationshipValues;
	}
	
	/**
	 * sets the name and the size of the dialog
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText(literals.EDIT_RELATIONSHIP_FEATURE_NAME + " " + businessObject.getName());
		newShell.setSize(literals.WIDTH_EDIT_RELATIONSHIP_DIALOG, literals.HEIGHT_EDIT_RELATIONSHIP_DIALOG);
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
        		label.setText("Source cardinality (" + businessObject.getSource().getName() + "):");
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
		   !(NameAlreadyUsed()) &&
		   isValid(TextfieldType.SOURCE_CARDINALITY) &&
		   isValid(TextfieldType.TARGET_CARDINALITY)) {
			relationshipValues.add(relationshipNameTextField.getText());
			relationshipValues.add(sourceCardinalityTextField.getText());
			relationshipValues.add(targetCardinalityTextField.getText());
			close();
		}
		else {
			if(!(isValid(TextfieldType.RELATIONSHIP_NAME))) {
				MessageDialog.openError(getParentShell(), literals.EDITING_RELATIONSHIPS_NAME_INVALID_TITLE, literals.EDITING_RELATIONSHIPS_NAME_INVALID);
				return;
			}
			if(NameAlreadyUsed()) {
				MessageDialog.openError(getParentShell(), literals.EDITING_RELATIONSHIPS_NAME_ALREADY_USED_TITLE, literals.EDITING_RELATIONSHIPS_NAME_ALREADY_USED);
				return;
			}
			if(!(isValid(TextfieldType.SOURCE_CARDINALITY))) {
				MessageDialog.openError(getParentShell(), literals.EDITING_RELATIONSHIPS_SOURCE_CARDINALITY_TITLE, literals.EDITING_RELATIONSHIPS_SOURCE_CARDINALITY);
				return;
			}
			if(!(isValid(TextfieldType.TARGET_CARDINALITY))) {
				MessageDialog.openError(getParentShell(), literals.EDITING_RELATIONSHIPS_TARGET_CARDINALITY_TITLE, literals.EDITING_RELATIONSHIPS_TARGET_CARDINALITY);
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
	    		return util.matchesIdentifier(name);
	    	case SOURCE_CARDINALITY:
	    		String sourceCardinality = sourceCardinalityTextField.getText();
	    		return util.matchesCardinality(sourceCardinality);
	    	case TARGET_CARDINALITY:
	    		String targetCardinality = targetCardinalityTextField.getText();
	    		return util.matchesCardinality(targetCardinality);
		}
		return false;
	}
	
	/**
	 * checks if a relationships name is already used by another relationship of the same compartment type when editing
	 * a relationship
	 * @return if a newly chosen relationships name is already used
	 */
	private boolean NameAlreadyUsed() {
		String newName = relationshipNameTextField.getText();
		if(newName.equals(businessObject.getName())) return false;
		return util.nameAlreadyUsedForCompartmentTypeElements(diagram, newName);
	}
}
