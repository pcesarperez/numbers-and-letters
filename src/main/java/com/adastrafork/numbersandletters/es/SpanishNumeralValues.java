package com.adastrafork.numbersandletters.es;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Class to calculate the values associated to Spanish numerals.
 */
public final class SpanishNumeralValues {
	private static final Map<String, Integer> SPANISH_NUMERAL_VALUES = createImmutableNumeralsMap ( );


	/**
	 * Creates an immutable map which holds the numerals and their equivalent numeric values.
	 *
	 * @return An immutable map of numerals and their values.
	 */
	private static Map<String, Integer> createImmutableNumeralsMap ( ) {
		Map<String, Integer> result = new HashMap<> ( );

		result.put ("uno", 1);
		result.put ("un", 1);
		result.put ("dos", 2);
		result.put ("tres", 3);
		result.put ("cuatro", 4);
		result.put ("cinco", 5);
		result.put ("seis", 6);
		result.put ("siete", 7);
		result.put ("ocho", 8);
		result.put ("nueve", 9);
		result.put ("diez", 10);
		result.put ("once", 11);
		result.put ("doce", 12);
		result.put ("trece", 13);
		result.put ("catorce", 14);
		result.put ("quince", 15);
		result.put ("dieciséis", 16);
		result.put ("diecisiete", 17);
		result.put ("dieciocho", 18);
		result.put ("diecinueve", 19);
		result.put ("veinte", 20);
		result.put ("veintiuno", 21);
		result.put ("veintidós", 22);
		result.put ("veintitrés", 23);
		result.put ("veinticuatro", 24);
		result.put ("veinticinco", 25);
		result.put ("veintiséis", 26);
		result.put ("veintisiete", 27);
		result.put ("veintiocho", 28);
		result.put ("veintinueve", 29);
		result.put ("treinta", 30);
		result.put ("cuarenta", 40);
		result.put ("cincuenta", 50);
		result.put ("sesenta", 60);
		result.put ("setenta", 70);
		result.put ("ochenta", 80);
		result.put ("noventa", 90);
		result.put ("cien", 100);
		result.put ("ciento", 100);
		result.put ("doscientos", 200);
		result.put ("trescientos", 300);
		result.put ("cuatrocientos", 400);
		result.put ("quinientos", 500);
		result.put ("seiscientos", 600);
		result.put ("setecientos", 700);
		result.put ("ochocientos", 800);
		result.put ("novecientos", 900);

		return Collections.unmodifiableMap (result);
	}


	/**
	 * Gets the value corresponding to the rule <code>r<sub>0</sub></code>.
	 * <p/>
	 * The numeral "cero" always yields the value 0.
	 *
	 * @return The value corresponding to the rule <code>r<sub>0</sub></code>.
	 */
	public Integer v0 ( ) {
		return 0;
	}


	/**
	 * Gets the value corresponding to the rule <code>r<sub>1</sub></code>.
	 * <p/>
	 * <code>r<code>1</code></code> is a straightforward rule, with just one value to yield.
	 *
	 * @param numeral Numeral of the rule <code>r1</code> of which the value is to be extracted.
	 * @return The value corresponding to the rule <code>r<sub>1</sub></code>.
	 */
	public Integer v1 (String numeral) {
		return SPANISH_NUMERAL_VALUES.get (numeral);
	}


	/**
	 * Gets the value corresponding to the rule <code>r<sub>2</sub></code>.
	 * <p/>
	 * This is a compound rule, with two parts:
	 * <ul>
	 * <li>The first part contains the tens of the number.</li>
	 * <li>The second part, if any, contains the units of the number.</li>
	 * </ul>
	 *
	 * @param tens  Part of the numeral corresponding to the tens of the number.
	 * @param units Part of the numeral corresponding to the units of the number (if any).
	 * @return The value corresponding to the rule <code>r<sub>2</sub></code>.
	 */
	public Integer v2 (String tens, String units) {
		Integer result = 0;

		result += SPANISH_NUMERAL_VALUES.get (tens);

		if (units != null) {
			result += SPANISH_NUMERAL_VALUES.get (units);
		}

		return result;
	}


	/**
	 * Gets the value corresponding to the rule <code>r<sub>3</sub></code>.
	 * <p/>
	 * The numeral "cien" always yields the value 100.
	 *
	 * @return The value corresponding to the rule <code>r<sub>3</sub></code>.
	 */
	public Integer v3 ( ) {
		return 100;
	}


	/**
	 * Gets the value corresponding to the rule <code>r<sub>4</sub></code>.
	 * <p/>
	 * The rule <code>r<sub>4</sub></code> is a compound rule, so we just return the fixed part.
	 *
	 * @return The value corresponding to the fixed part of the rule <code>r<sub>4</sub></code>.
	 */
	public Integer v4 ( ) {
		return 100;
	}
}