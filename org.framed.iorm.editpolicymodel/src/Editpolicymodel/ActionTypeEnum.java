/**
 */
package Editpolicymodel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Action Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see Editpolicymodel.EditpolicymodelPackage#getActionTypeEnum()
 * @model
 * @generated
 */
public enum ActionTypeEnum implements Enumerator {
	/**
	 * The '<em><b>Fulfillment</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FULFILLMENT_VALUE
	 * @generated
	 * @ordered
	 */
	FULFILLMENT(0, "Fulfillment", "Fulfillment"),

	/**
	 * The '<em><b>Inheritance</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INHERITANCE_VALUE
	 * @generated
	 * @ordered
	 */
	INHERITANCE(1, "Inheritance", "Inheritance"),

	/**
	 * The '<em><b>Relationship</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RELATIONSHIP_VALUE
	 * @generated
	 * @ordered
	 */
	RELATIONSHIP(2, "Relationship", "Relationship"),

	/**
	 * The '<em><b>Compartment</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMPARTMENT_VALUE
	 * @generated
	 * @ordered
	 */
	COMPARTMENT(3, "Compartment", "Compartment");

	/**
	 * The '<em><b>Fulfillment</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Fulfillment</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FULFILLMENT
	 * @model name="Fulfillment"
	 * @generated
	 * @ordered
	 */
	public static final int FULFILLMENT_VALUE = 0;

	/**
	 * The '<em><b>Inheritance</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Inheritance</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INHERITANCE
	 * @model name="Inheritance"
	 * @generated
	 * @ordered
	 */
	public static final int INHERITANCE_VALUE = 1;

	/**
	 * The '<em><b>Relationship</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Relationship</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RELATIONSHIP
	 * @model name="Relationship"
	 * @generated
	 * @ordered
	 */
	public static final int RELATIONSHIP_VALUE = 2;

	/**
	 * The '<em><b>Compartment</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Compartment</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COMPARTMENT
	 * @model name="Compartment"
	 * @generated
	 * @ordered
	 */
	public static final int COMPARTMENT_VALUE = 3;

	/**
	 * An array of all the '<em><b>Action Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ActionTypeEnum[] VALUES_ARRAY =
		new ActionTypeEnum[] {
			FULFILLMENT,
			INHERITANCE,
			RELATIONSHIP,
			COMPARTMENT,
		};

	/**
	 * A public read-only list of all the '<em><b>Action Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ActionTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Action Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ActionTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ActionTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Action Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ActionTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ActionTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Action Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ActionTypeEnum get(int value) {
		switch (value) {
			case FULFILLMENT_VALUE: return FULFILLMENT;
			case INHERITANCE_VALUE: return INHERITANCE;
			case RELATIONSHIP_VALUE: return RELATIONSHIP;
			case COMPARTMENT_VALUE: return COMPARTMENT;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ActionTypeEnum(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //ActionTypeEnum
