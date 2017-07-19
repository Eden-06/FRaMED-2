/**
 */
package org.framed.iorm.model.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.framed.iorm.model.Model;
import org.framed.iorm.model.ModelElement;
import org.framed.iorm.model.OrmPackage;
import org.framed.iorm.model.Relation;
import org.framed.iorm.model.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.framed.iorm.model.impl.ModelElementImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link org.framed.iorm.model.impl.ModelElementImpl#getIncomingRelations <em>Incoming Relations</em>}</li>
 *   <li>{@link org.framed.iorm.model.impl.ModelElementImpl#getOutgoingRelations <em>Outgoing Relations</em>}</li>
 *   <li>{@link org.framed.iorm.model.impl.ModelElementImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelElementImpl extends NamedElementImpl implements ModelElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OrmPackage.Literals.MODEL_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model getContainer() {
		return (Model) eGet(OrmPackage.Literals.MODEL_ELEMENT__CONTAINER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainer(Model newContainer) {
		eSet(OrmPackage.Literals.MODEL_ELEMENT__CONTAINER, newContainer);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Relation> getIncomingRelations() {
		return (EList<Relation>) eGet(OrmPackage.Literals.MODEL_ELEMENT__INCOMING_RELATIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Relation> getOutgoingRelations() {
		return (EList<Relation>) eGet(OrmPackage.Literals.MODEL_ELEMENT__OUTGOING_RELATIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getType() {
		return (Type) eGet(OrmPackage.Literals.MODEL_ELEMENT__TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(Type newType) {
		eSet(OrmPackage.Literals.MODEL_ELEMENT__TYPE, newType);
	}

} //ModelElementImpl
