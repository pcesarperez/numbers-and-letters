package com.adastrafork.numbersandletters.es.exceptions;

/**
 * Exception thrown when a numeral string is not valid.
 */
public class UnrecognizedNumeralException extends Exception {
	public UnrecognizedNumeralException ( ) {
		super ( );
	}


	public UnrecognizedNumeralException (String message) {
		super (message);
	}
}