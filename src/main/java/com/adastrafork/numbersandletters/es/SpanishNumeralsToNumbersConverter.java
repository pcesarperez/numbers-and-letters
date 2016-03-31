package com.adastrafork.numbersandletters.es;

import com.adastrafork.numbersandletters.es.exceptions.UnrecognizedNumeralException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class to convert Spanish numerals to their numeric equivalents.
 */
public class SpanishNumeralsToNumbersConverter {
	private Pattern numeralRecognitionPattern;
	private SpanishNumeralValues numeralValues;
	private Matcher matcher;


	/**
	 * Sets up the converter.
	 */
	public SpanishNumeralsToNumbersConverter ( ) {
		numeralRecognitionPattern = new SpanishNumeralRecognitionPattern ( ).pattern ( );
		numeralValues = new SpanishNumeralValues ( );
	}


	/**
	 * Converts a Spanish numeral to its numeric equivalent.
	 *
	 * @param numeral Spanish numeral to convert.
	 * @return The numeric equivalent of the numeral.
	 * @throws UnrecognizedNumeralException
	 */
	public Integer convertNumeralToNumber (String numeral) throws UnrecognizedNumeralException {
		matcher = numeralRecognitionPattern.matcher (numeral);

		if (theNumeralIsValid ( )) {
			if (r0Fired ( )) {
				return numeralValues.v0 ( );
			} else if (r1Fired ( )) {
				String oneWordNumeral = matcher.group ("r1");

				return numeralValues.v1 (oneWordNumeral);
			} else if (r2Fired ( )) {
				String tens = matcher.group ("r2x");
				String units = matcher.group ("r2y");

				return numeralValues.v2 (tens, units);
			} else {
				throw new UnrecognizedNumeralException ("The given numeral is not a valid Spanish numeral");
			}
		} else {
			throw new UnrecognizedNumeralException ("The given numeral is not a valid Spanish numeral");
		}
	}


	/**
	 * Finds out if the numeral to convert is valid, this is, it has fired any of the conversion rules.
	 *
	 * @return Returns <code>true</code> if the converted numeral is valid, or <code>false</code> otherwise.
	 */
	private boolean theNumeralIsValid ( ) {
		return matcher.matches ( );
	}


	/**
	 * Finds out if the rule <code>r0</code> has been fired.
	 *
	 * @return Returns <code>true</code> if the rule <code>r0</code> has been fired, or <code>false</code> otherwise.
	 */
	private boolean r0Fired ( ) {
		return matcher.group ("r0") != null;
	}


	/**
	 * Finds out if the rule <code>r1</code> has been fired.
	 *
	 * @return Returns <code>true</code> if the rule <code>r1</code> has been fired, or <code>false</code> otherwise.
	 */
	private boolean r1Fired ( ) {
		return matcher.group ("r1") != null;
	}


	/**
	 * Finds out if the rule <code>r2</code> has been fired.
	 *
	 * @return Returns <code>true</code> if the rule <code>r2</code> has been fired, or <code>false</code> otherwise.
	 */
	private boolean r2Fired ( ) {
		return matcher.group ("r2") != null;
	}
}