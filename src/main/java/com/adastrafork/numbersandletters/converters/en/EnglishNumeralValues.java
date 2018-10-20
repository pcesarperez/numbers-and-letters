package com.adastrafork.numbersandletters.converters.en;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


/**
 * Class to calculate the values associated to English numerals.
 */
final class EnglishNumeralValues {
	private static final Map<String, Integer> SpanishNumeralValues = createImmutableNumeralsMap ( );


	/**
	 * Creates an immutable map which holds the numerals and their equivalent numeric values.
	 *
	 * @return An immutable map of numerals and their values.
	 */
	private static Map<String, Integer> createImmutableNumeralsMap ( ) {
		Map<String, Integer> result = new HashMap<> ( );

		result.put ("one", 1);
		result.put ("two", 2);
		result.put ("three", 3);
		result.put ("four", 4);
		result.put ("five", 5);
		result.put ("six", 6);
		result.put ("seven", 7);
		result.put ("eight", 8);
		result.put ("nine", 9);
		result.put ("ten", 10);
		result.put ("eleven", 11);
		result.put ("twelve", 12);
		result.put ("thirteen", 13);
		result.put ("fourteen", 14);
		result.put ("fifteen", 15);
		result.put ("sixteen", 16);
		result.put ("seventeen", 17);
		result.put ("eighteen", 18);
		result.put ("nineteen", 19);
		result.put ("twenty", 20);
		result.put ("thirty", 30);
		result.put ("forty", 40);
		result.put ("fifty", 50);
		result.put ("sixty", 60);
		result.put ("seventy", 70);
		result.put ("eighty", 80);
		result.put ("ninety", 90);

		return Collections.unmodifiableMap (result);
	}


	/**
	 * Gets the numeric equivalent of the given English numeral.
	 *
	 * @param numeral English numeral to convert into its numeric equivalent.
	 *
	 * @return Numeric equivalent of the given English numeral.
	 */
	static Integer fromNumeral (String numeral) {
		return SpanishNumeralValues.get (numeral);
	}
}