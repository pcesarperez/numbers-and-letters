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
	private static final Map<String, Integer> createImmutableNumeralsMap ( ) {
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
	 * Gets the numeric equivalent of the given Spanish numeral.
	 *
	 * @param numeral Spanish numeral to convert into its numeric equivalent.
	 *
	 * @return Numeric equivalent of the given Spanish numeral.
	 */
	public static Integer fromNumeral (String numeral) {
		return SPANISH_NUMERAL_VALUES.get (numeral);
	}
}