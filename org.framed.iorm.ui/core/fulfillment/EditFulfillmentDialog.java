package fulfillment;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.provider.ItemProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.framed.iorm.model.ModelElement;
import org.framed.iorm.model.Relation;
import org.framed.iorm.model.Shape;
import org.framed.iorm.model.Type;
import org.framed.iorm.model.provider.OrmItemProviderAdapterFactory;

/**
 * This class represents a dialog to edit the referenced roles of fulfillments.
 * <p>
 * Large parts of the code in this class is taken and modified from the original implementation of
 * FRaMED by authors Kay Bierzynski and Lars Schuetze.
 */
public class EditFulfillmentDialog extends Dialog {
	
	/**
	 * the object to get names, ids and so on for this feature
	 */
	Literals literals = new Literals();
	
	/**
	 * the business object of the edited fulfillment 
	 */
	private Relation businessObject;
	
	/**
	 * a reference to a list filled with the referenced roles of the fulfillment commonly used by this dialog and 
	 * the {@link EditFulfillmentFeature}
	 */
	private List<Shape> newReferencedRoleTypes;
	
	/**
	 * The checkbox viewer for listing the role types and the role groups of the fulfillments target
	 * shape.
	 */
	private CheckboxTableViewer checkboxViewer;
			
	/**
	 * Class constructor
	 * @param parentShell the used shell
	 * @param businessObject the fulfillment to edit
	 * @param the commonly used list of the referenced roles of the fulfillment
	 */
	public EditFulfillmentDialog(Shell parentShell, Diagram diagram, Relation businessObject, List<org.framed.iorm.model.Shape> newReferencedRoles) {
		super(parentShell);
		this.businessObject = businessObject;
		this.newReferencedRoleTypes = newReferencedRoles;
	}
	
	/**
	 * sets the name and the size of the dialog
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText(literals.EDIT_FULFILLMENT_FEATURE_NAME);
		newShell.setSize(literals.WIDTH_EDIT_FULFILLMENT_DIALOG, literals.HEIGHT_EDIT_FULFILLMENT_DIALOG);
	}
	
	/**
	 * creates a checkbox list with all role types in the fulfillments target shapes model (Step 1)
	 * and checks all already fulfilled role types (Step 2)
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
	    Composite composite = (Composite) super.createDialogArea(parent);
	    //Step 1
	    List<Shape> allRoleTypes = getAllRolesofTarget();
	    checkboxViewer = CheckboxTableViewer.newCheckList(composite, SWT.CHECK);
	    checkboxViewer.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	    AdapterFactoryLabelProvider labelProvider =
	        new AdapterFactoryLabelProvider(new OrmItemProviderAdapterFactory());
	    AdapterFactoryContentProvider contentProvider =
	        new AdapterFactoryContentProvider(new OrmItemProviderAdapterFactory());
	    checkboxViewer.setLabelProvider(labelProvider);
	    checkboxViewer.setContentProvider(contentProvider);
	    checkboxViewer.setInput(new ItemProvider(new OrmItemProviderAdapterFactory(), allRoleTypes));
	    //Step 2
	    EList<Shape> fulfilledRoleTypes = businessObject.getReferencedRoles();
	    for (Shape role :  allRoleTypes) {
	    	if (fulfilledRoleTypes.contains(role)) {
	    		checkboxViewer.setChecked(role, true);
	    }	}
	    addSelectionButtons(composite);
	    return composite;
	}
	
	/**
	 * interates through all of the fulfillments target model elements and return all role types of these
	 * @return all role types of the fulfillments target shape 
	 */
	private List<Shape> getAllRolesofTarget() {
		List<Shape> RoleTypesAndGroups = new ArrayList<Shape>();
		EList<ModelElement> elementsOfTarget = 
			((Shape) businessObject.getTarget()).getModel().getElements();
		for(ModelElement element : elementsOfTarget) {
			if(element instanceof Shape) {	
				Shape shape = (Shape) element;
				if(shape.getType() == Type.ROLE_TYPE ||
				   shape.getType() == Type.ROLE_GROUP)
					RoleTypesAndGroups.add(shape);
		}	}
		return RoleTypesAndGroups;
	}
	
	/**
	 * add the <em>select all</em> and <em>deselect all</em> button to the wizard 
	 * @param composite the composite to the buttons in
	 */
	private void addSelectionButtons(Composite composite) {
		initializeDialogUnits(composite);
		Composite buttonComposite = new Composite(composite, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 0;
		layout.marginWidth = 0;
		layout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
		buttonComposite.setLayout(layout);
		buttonComposite.setLayoutData(new GridData(SWT.END, SWT.TOP, true, false));
		
		Button selectButton =
			createButton(buttonComposite, IDialogConstants.SELECT_ALL_ID, "Select All", false);
		 selectButton.addSelectionListener(new SelectionAdapter() {
			 @Override
		     public void widgetSelected(SelectionEvent event) {
		    	  checkboxViewer.setAllChecked(true);
		 }	});
	
		 Button deselectButton =
			createButton(buttonComposite, IDialogConstants.DESELECT_ALL_ID, "Deselect All", false);
		 deselectButton.addSelectionListener(new SelectionAdapter() {
			 @Override
			 public void widgetSelected(SelectionEvent event) {
				 checkboxViewer.setAllChecked(false);
	}	});	}

	
	/**
	 * saves the changes in the list of references role types and closes the dialog
	 */
	@Override
	protected void okPressed() {
		for (Object object : checkboxViewer.getCheckedElements()) 
			newReferencedRoleTypes.add((Shape) object);
		close();
	}
}
