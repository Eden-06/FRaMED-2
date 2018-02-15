/**
 */
package genmodel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Gen JDK Level</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see genmodel.GenmodelPackage#getGenJDKLevel()
 * @model
 * @generated
 */
public enum GenJDKLevel implements Enumerator {
	/**
	 * The '<em><b>JDK14</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JDK14_VALUE
	 * @generated
	 * @ordered
	 */
	JDK14(0, "JDK14", "1.4"),

	/**
	 * The '<em><b>JDK50</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JDK50_VALUE
	 * @generated
	 * @ordered
	 */
	JDK50(1, "JDK50", "5.0"),

	/**
	 * The '<em><b>JDK60</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JDK60_VALUE
	 * @generated
	 * @ordered
	 */
	JDK60(2, "JDK60", "6.0"),

	/**
	 * The '<em><b>JDK70</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JDK70_VALUE
	 * @generated
	 * @ordered
	 */
	JDK70(3, "JDK70", "7.0"),

	/**
	 * The '<em><b>JDK80</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JDK80_VALUE
	 * @generated
	 * @ordered
	 */
	JDK80(4, "JDK80", "8.0");

	/**
	 * The '<em><b>JDK14</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>JDK14</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #JDK14
	 * @model literal="1.4"
	 * @generated
	 * @ordered
	 */
	public static final int JDK14_VALUE = 0;

	/**
	 * The '<em><b>JDK50</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>JDK50</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #JDK50
	 * @model literal="5.0"
	 * @generated
	 * @ordered
	 */
	public static final int JDK50_VALUE = 1;

	/**
	 * The '<em><b>JDK60</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>JDK60</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #JDK60
	 * @model literal="6.0"
	 * @generated
	 * @ordered
	 */
	public static final int JDK60_VALUE = 2;

	/**
	 * The '<em><b>JDK70</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>JDK70</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #JDK70
	 * @model literal="7.0"
	 * @generated
	 * @ordered
	 */
	public static final int JDK70_VALUE = 3;

	/**
	 * The '<em><b>JDK80</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>JDK80</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #JDK80
	 * @model literal="8.0"
	 * @generated
	 * @ordered
	 */
	public static final int JDK80_VALUE = 4;

	/**
	 * An array of all the '<em><b>Gen JDK Level</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final GenJDKLevel[] VALUES_ARRAY =
		new GenJDKLevel[] {
			JDK14,
			JDK50,
			JDK60,
			JDK70,
			JDK80,
		};

	/**
	 * A public read-only list of all the '<em><b>Gen JDK Level</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<GenJDKLevel> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Gen JDK Level</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static GenJDKLevel get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			GenJDKLevel result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Gen JDK Level</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static GenJDKLevel getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			GenJDKLevel result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Gen JDK Level</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static GenJDKLevel get(int value) {
		switch (value) {
			case JDK14_VALUE: return JDK14;
			case JDK50_VALUE: return JDK50;
			case JDK60_VALUE: return JDK60;
			case JDK70_VALUE: return JDK70;
			case JDK80_VALUE: return JDK80;
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
	private GenJDKLevel(int value, String name, String literal) {
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
	
} //GenJDKLevel
