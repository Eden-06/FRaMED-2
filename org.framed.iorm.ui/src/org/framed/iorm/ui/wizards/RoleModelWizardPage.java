package org.framed.iorm.ui.wizards;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.framed.iorm.ui.literals.LayoutLiterals;
import org.framed.iorm.ui.literals.UILiterals;
import org.framed.iorm.ui.util.UIUtil;

/**
 * This class is an Eclipse wizard page that asks for a name of a new diagram. It is used by {@link RoleModelWizard}.
 * <p>
 * The code in this class is mostly taken and customized from the class "DiagramNameWizardPage.java" by Graphiti. 
 * You can find this class in the github repository of Graphiti. Look there for reference too.
 */
public class RoleModelWizardPage extends WizardPage {

	/**
	 * the standard name for new diagrams
	 */
	private final String STANDARD_DIAGRAM_NAME = UILiterals.STANDARD_DIAGRAM_NAME;
	
	/**
	 * the messages used for eclipse wizards gathered from {@link TextLiterals}
	 * <p>
	 * can be:<br>
	 * (1) the message that ask for a name of the new diagram<br>
	 * (2) the message that informs the user about an invalid input for the name<br>
	 * (3) the label for the wizard page that asks for a diagram name
	 */
	private final String WIZARD_PAGE_DESC = UILiterals.WIZARD_PAGE_DESC,
						 WIZARD_MESSAGE_INVALID_INPUT = UILiterals.WIZARD_MESSAGE_INVALID_INPUT,
						 WIZARD_PAGE_LABEL = UILiterals.WIZARD_PAGE_LABEL;

	/**
	 * the layout integer that defines the leght of the used textfield gathered from {@link LayoutLiterals}
	 */
	private final int LENGHT_TEXTFIELD_WIZARD = LayoutLiterals.LENGHT_TEXTFIELD_WIZARD;

	/**
	 * the used textfield to get the user input
	 */
	private Text textField;

	/**
	 * listener that checks if the user input and the workspace is valid
	 */
	private Listener nameModifyListener = new Listener() {
												public void handleEvent(Event e) {
													boolean valid = validatePage();
													setPageComplete(valid);
										  }		};
	/**
	 * validates user input and workspace									
	 * @return if the user input and the workspace is valid
	 */
	private boolean validatePage() {
		String text = getTextFieldValue();
		if (!(UIUtil.matchesIdentifier(text))) { 
			setErrorMessage(null);
			setMessage(WIZARD_MESSAGE_INVALID_INPUT);
			return false;
		}
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IStatus status = workspace.validateName(text, IResource.FILE);
		if (!status.isOK()) {
			setErrorMessage(status.getMessage());
			return false;
		}
		setErrorMessage(null);
		setMessage(null);
		return true;
	}
		
	/**
	 * Class constructor
	 * @param pageName the name of the page which is also used as title
	 */
	protected RoleModelWizardPage(String pageName) {
		super(pageName);
		setTitle(pageName);
		setDescription(WIZARD_PAGE_DESC);
	}
	
	/**
	 * defines the graphic representation of the wizard page
	 * @param parent the parent composite of the wizard
	 */
	@Override
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		composite.setFont(parent.getFont());
		initializeDialogUnits(parent);
		composite.setLayout(new GridLayout());
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		createProjectNameGroup(composite);
		setPageComplete(validatePage());
		
		setErrorMessage(null);
		setMessage(null);
		setControl(composite);
	}

	/**
	 * publishes the user input to the {@link RoleModelWizard}
	 * @return the initial text value or the user input
	 */
	public String getText() {
		if (textField == null)
			return STANDARD_DIAGRAM_NAME;
		return getTextFieldValue();
	}
	
	/**
	 * @return trimmed user input id text is not null
 	 */
	private String getTextFieldValue() {
		if (textField == null) {
			return ""; 
		}
		return textField.getText().trim();
	}

	/**
	 * creates the poject explorer in the framed editor
	 */
	private final void createProjectNameGroup(Composite parent) {
		// project specification group
		Composite projectGroup = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		projectGroup.setLayout(layout);
		projectGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		// new project label
		Label projectLabel = new Label(projectGroup, SWT.NONE);
		projectLabel.setText(WIZARD_PAGE_LABEL);
		projectLabel.setFont(parent.getFont());
		// new project name entry field
		textField = new Text(projectGroup, SWT.BORDER);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.widthHint = LENGHT_TEXTFIELD_WIZARD;
		textField.setLayoutData(data);
		textField.setFont(parent.getFont());
		// Set the initial value first before listener
		// to avoid handling an event during the creation.
		textField.setText(STANDARD_DIAGRAM_NAME);
		textField.addListener(SWT.Modify, nameModifyListener);
	}

	/**
	 * set the page visible
	 */
	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			textField.setFocus();
			textField.selectAll();
		}
	}
}
