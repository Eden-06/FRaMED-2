/**
 */
package org.framed.iorm.model.impl;

import org.eclipse.emf.ecore.EClass;

import org.framed.iorm.model.Model;
import org.framed.iorm.model.NamedElement;
import org.framed.iorm.model.OrmPackage;
import org.framed.iorm.model.Segment;
import org.framed.iorm.model.Shape;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Shape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.framed.iorm.model.impl.ShapeImpl#getFirstSegment <em>First Segment</em>}</li>
 *   <li>{@link org.framed.iorm.model.impl.ShapeImpl#getSecondSegment <em>Second Segment</em>}</li>
 *   <li>{@link org.framed.iorm.model.impl.ShapeImpl#getModel <em>Model</em>}</li>
 *   <li>{@link org.framed.iorm.model.impl.ShapeImpl#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ShapeImpl extends ModelElementImpl implements Shape {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ShapeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OrmPackage.Literals.SHAPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Segment getFirstSegment() {
		return (Segment) eGet(OrmPackage.Literals.SHAPE__FIRST_SEGMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstSegment(Segment newFirstSegment) {
		eSet(OrmPackage.Literals.SHAPE__FIRST_SEGMENT, newFirstSegment);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Segment getSecondSegment() {
		return (Segment) eGet(OrmPackage.Literals.SHAPE__SECOND_SEGMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecondSegment(Segment newSecondSegment) {
		eSet(OrmPackage.Literals.SHAPE__SECOND_SEGMENT, newSecondSegment);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model getModel() {
		return (Model) eGet(OrmPackage.Literals.SHAPE__MODEL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModel(Model newModel) {
		eSet(OrmPackage.Literals.SHAPE__MODEL, newModel);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement getDescription() {
		return (NamedElement) eGet(OrmPackage.Literals.SHAPE__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(NamedElement newDescription) {
		eSet(OrmPackage.Literals.SHAPE__DESCRIPTION, newDescription);
	}

} //ShapeImpl
