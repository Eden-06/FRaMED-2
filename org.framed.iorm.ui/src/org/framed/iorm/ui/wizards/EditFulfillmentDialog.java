package org.framed.iorm.ui.wizards;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.provider.ItemProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.framed.iorm.model.ModelElement;
import org.framed.iorm.model.Relation;
import org.framed.iorm.model.Shape;
import org.framed.iorm.model.Type;
import org.framed.iorm.model.provider.OrmItemProviderAdapterFactory;
import org.framed.iorm.ui.literals.LayoutLiterals;
import org.framed.iorm.ui.literals.NameLiterals;
import org.framed.iorm.ui.literals.TextLiterals;
import org.framed.iorm.ui.util.NameUtil;
import org.framed.iorm.ui.graphitifeatures.EditFulfillmentFeature; //*import for javadox link

/**
 * This class represents a dialog to edit relationships name and cardinalities.
 * @author Kevin Kassin
 */
public class EditFulfillmentDialog extends Dialog {
	
	/**
	 * the name of the custom feature using this dialog gathered from {@link NameLiterals}
	 */
	private final String EDIT_FULFILLMENT_FEATURE_NAME = NameLiterals.EDIT_FULFILLMENT_FEATURE_NAME;
	
	/**
	 * messages and titles used as tips when invalid inputs happen gathered from {@link TextLiterals}
	 */
	//TODO
	
	/**
	 * the height and width of the dialog gathered from {@link LayoutLiterals}
	 */
	private final int HEIGHT_EDIT_CONNECTION_DIALOG = LayoutLiterals.HEIGHT_EDIT_FULFILLMENT_DIALOG,
					  WIDTH_EDIT_CONNECTION_DIALOG = LayoutLiterals.WIDTH_EDIT_FULFILLMENT_DIALOG;
	
	/**
	 * the business object of the edited relationship 
	 */
	private Relation businessObject;
	
	/**
	 * a reference to a list filled with the referenced roles of the fulfillment commonly used by this dialog and 
	 * the {@link EditFulfillmentFeature}
	 */
	private List<Shape> newReferencedRoles;
	
	/**
	 * The viewer for listing the RoleTypes and the RoleGroups.
	 * 
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
		this.newReferencedRoles = newReferencedRoles;
	}
	
	/**
	 * sets the name and the size of the dialog
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText(EDIT_FULFILLMENT_FEATURE_NAME + " " + businessObject.getName());
		newShell.setSize(WIDTH_EDIT_CONNECTION_DIALOG, HEIGHT_EDIT_CONNECTION_DIALOG);
	}
	
	//TODO
	@Override
	protected Control createDialogArea(Composite parent) {
	    Composite composite = (Composite) super.createDialogArea(parent);
	    
	    List<Shape> allRoles = getAllRolesofTarget();
	    EList<Shape> fulfilledRoles = businessObject.getReferencedRoles();
	    
	    //create checkbox 
	    checkboxViewer = CheckboxTableViewer.newCheckList(composite, SWT.CHECK);
	    checkboxViewer.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	    AdapterFactoryLabelProvider labelProvider =
	        new AdapterFactoryLabelProvider(new OrmItemProviderAdapterFactory());
	    AdapterFactoryContentProvider contentProvider =
	        new AdapterFactoryContentProvider(new OrmItemProviderAdapterFactory());
	    checkboxViewer.setLabelProvider(labelProvider);
	    checkboxViewer.setContentProvider(contentProvider);
	    checkboxViewer.setInput(new ItemProvider(new OrmItemProviderAdapterFactory(), allRoles));
	    // check all the role types and the role groups, which already fulfilled thorugh the fulfillment
	    for (Shape role :  allRoles) {
	    	if (fulfilledRoles.contains(role)) {
	    		checkboxViewer.setChecked(role, true);
	    }	}
	    addSelectionButtons(composite);
	    return composite;
	}
	
	//TODO
	private List<Shape> getAllRolesofTarget() {
		List<Shape> allRoles = new ArrayList<Shape>();
		EList<ModelElement> elementsOfTarget = 
			((Shape) businessObject.getTarget()).getModel().getElements();
		for(ModelElement element : elementsOfTarget) {
			if(element instanceof Shape &&
			  ((Shape) element).getType() == Type.ROLE_TYPE)
				allRoles.add((Shape) element);
		}
		return allRoles;
	}
	
	//TODO
	private void addSelectionButtons(Composite composite) {

		initializeDialogUnits(composite);

		Composite buttonComposite = new Composite(composite, SWT.NONE);

		// setup the button layout
		GridLayout layout = new GridLayout();
		layout.numColumns = 0;
		layout.marginWidth = 0;
		layout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
		buttonComposite.setLayout(layout);
		buttonComposite.setLayoutData(new GridData(SWT.END, SWT.TOP, true, false));
		
		Button selectButton =
			createButton(buttonComposite, IDialogConstants.SELECT_ALL_ID, "Select All", false);
	
		 // set the functionallity of the select all button
		 selectButton.addSelectionListener(new SelectionAdapter() {
			 @Override
		     public void widgetSelected(SelectionEvent event) {
		    	  checkboxViewer.setAllChecked(true);
		      }
		 });
	
		 Button deselectButton =
			createButton(buttonComposite, IDialogConstants.DESELECT_ALL_ID, "Deselect All", false);
	
		 // set the functionallity of the deselect all button
		 deselectButton.addSelectionListener(new SelectionAdapter() {
			 @Override
			 public void widgetSelected(SelectionEvent event) {
				 checkboxViewer.setAllChecked(false);
			 }
	 	 });
	}

	
	//TODO
	@Override
	protected void okPressed() {
		for (Object object : checkboxViewer.getCheckedElements()) 
			newReferencedRoles.add((Shape) object);
		close();
	}
}
