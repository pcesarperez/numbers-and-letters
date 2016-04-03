package com.adastrafork.numbersandletters.es;

import com.adastrafork.numbersandletters.es.exceptions.UnrecognizedNumeralException;


/**
 * Class to convert Spanish numerals to their numeric equivalents.
 */
public class SpanishNumeralsToNumbersConverter {
	private SpanishNumeralValues numeralValues;
	private SpanishNumeralRecognitionEngine numeralRecognitionEngine;


	/**
	 * Sets up the converter.
	 */
	public SpanishNumeralsToNumbersConverter ( ) {
		numeralRecognitionEngine = new SpanishNumeralRecognitionEngine ( );
		numeralValues = new SpanishNumeralValues ( );
	}


	/**
	 * Converts a Spanish numeral expression to its numeric equivalent.
	 *
	 * @param numeralExpression Spanish numeral expression to convert.
	 * @return The numeric equivalent of the numeral expression.
	 * @throws UnrecognizedNumeralException
	 */
	public Integer convertNumeralToNumber (String numeralExpression) throws UnrecognizedNumeralException {
		return parseNumeralExpression (numeralExpression, numeralRecognitionEngine.fullPatternText ( ));
	}


	/**
	 * Parses recursively a Spanish numeral expression to get its numeric equivalent.
	 *
	 * @param numeralExpression Spanish numeral expression to convert.
	 * @param patternText       Pattern used to check the numeral expression.
	 * @return The numeric equivalent of the numeral expression with the given pattern.
	 * @throws UnrecognizedNumeralException
	 */
	private Integer parseNumeralExpression (String numeralExpression, String patternText) throws UnrecognizedNumeralException {
		if (numeralRecognitionEngine.isFound (numeralExpression, patternText)) {
			switch (numeralRecognitionEngine.ruleFired ( )) {
				case r0:
					return numeralValues.v0 ( );

				case r1:
					return numeralValues.v1 (numeralExpression);

				case r2:
					//@formatter:off
					return numeralValues.v2 (
						numeralRecognitionEngine.prefix ( ),
						numeralRecognitionEngine.suffix ( )
					);
					//@formatter:on

				case r3:
					return numeralValues.v3 ( );

				case r4:
					//@formatter:off
					return
						numeralValues.v4 ( ) +
						parseNumeralExpression (
							numeralRecognitionEngine.suffix ( ),
							numeralRecognitionEngine.suffixPattern ( )
						);
					//@formatter:on

				case no_rule_fired:
					throw new UnrecognizedNumeralException ("The given numeral expression is not valid.");

				default:
					throw new UnrecognizedNumeralException ("The given numeral expression is not valid.");
			}
		} else {
			throw new UnrecognizedNumeralException ("The given numeral expression is not valid.");
		}
	}
}