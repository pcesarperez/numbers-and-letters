package com.adastrafork.numbersandletters.es;

import com.adastrafork.numbersandletters.es.exceptions.UnrecognizedNumeralException;

/**
 * Created by adastra on 30/03/16.
 */
public class Test {
	public static void main (String [ ] args) {
		SpanishNumeralsToNumbersConverter numeralsConverter = new SpanishNumeralsToNumbersConverter ( );

		try {
			System.out.println (numeralsConverter.convertNumeralToNumber ("noventa y nueve"));
		} catch (UnrecognizedNumeralException e) {
			e.printStackTrace ( );
		}
	}
}
