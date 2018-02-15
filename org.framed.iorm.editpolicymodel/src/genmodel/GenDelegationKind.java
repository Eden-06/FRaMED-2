/**
 */
package genmodel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Gen Delegation Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see genmodel.GenmodelPackage#getGenDelegationKind()
 * @model
 * @generated
 */
public enum GenDelegationKind implements Enumerator {
	/**
	 * The '<em><b>None</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NONE_VALUE
	 * @generated
	 * @ordered
	 */
	NONE(0, "None", "None"),

	/**
	 * The '<em><b>Reflective</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REFLECTIVE_VALUE
	 * @generated
	 * @ordered
	 */
	REFLECTIVE(1, "Reflective", "Reflective"),

	/**
	 * The '<em><b>Virtual</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VIRTUAL_VALUE
	 * @generated
	 * @ordered
	 */
	VIRTUAL(2, "Virtual", "Virtual"),

	/**
	 * The '<em><b>Dynamic</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DYNAMIC_VALUE
	 * @generated
	 * @ordered
	 */
	DYNAMIC(3, "Dynamic", "Dynamic");

	/**
	 * The '<em><b>None</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>None</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NONE
	 * @model name="None"
	 * @generated
	 * @ordered
	 */
	public static final int NONE_VALUE = 0;

	/**
	 * The '<em><b>Reflective</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Reflective</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REFLECTIVE
	 * @model name="Reflective"
	 * @generated
	 * @ordered
	 */
	public static final int REFLECTIVE_VALUE = 1;

	/**
	 * The '<em><b>Virtual</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Virtual</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VIRTUAL
	 * @model name="Virtual"
	 * @generated
	 * @ordered
	 */
	public static final int VIRTUAL_VALUE = 2;

	/**
	 * The '<em><b>Dynamic</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Dynamic</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DYNAMIC
	 * @model name="Dynamic"
	 * @generated
	 * @ordered
	 */
	public static final int DYNAMIC_VALUE = 3;

	/**
	 * An array of all the '<em><b>Gen Delegation Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final GenDelegationKind[] VALUES_ARRAY =
		new GenDelegationKind[] {
			NONE,
			REFLECTIVE,
			VIRTUAL,
			DYNAMIC,
		};

	/**
	 * A public read-only list of all the '<em><b>Gen Delegation Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<GenDelegationKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Gen Delegation Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static GenDelegationKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			GenDelegationKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Gen Delegation Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static GenDelegationKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			GenDelegationKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Gen Delegation Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static GenDelegationKind get(int value) {
		switch (value) {
			case NONE_VALUE: return NONE;
			case REFLECTIVE_VALUE: return REFLECTIVE;
			case VIRTUAL_VALUE: return VIRTUAL;
			case DYNAMIC_VALUE: return DYNAMIC;
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
	private GenDelegationKind(int value, String name, String literal) {
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
	
} //GenDelegationKind
