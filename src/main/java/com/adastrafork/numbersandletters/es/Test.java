package com.adastrafork.numbersandletters.es;


import com.adastrafork.numbersandletters.es.exceptions.UnrecognizedNumeralException;


public class Test {
	public static void main (String[] args) {
		SpanishNumeralsToNumbersConverter numeralsConverter = new SpanishNumeralsToNumbersConverter ( );

		try {
			System.out.println (numeralsConverter.convertNumeralToNumber (args [0]));
		} catch (UnrecognizedNumeralException e) {
			e.printStackTrace ( );
		}
	}
}