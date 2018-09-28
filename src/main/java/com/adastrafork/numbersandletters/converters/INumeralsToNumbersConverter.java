package com.adastrafork.numbersandletters.converters;


import com.adastrafork.numbersandletters.exceptions.UnrecognizedNumeralException;


/**
 * Interface which every converter should stick to.
 */
public interface INumeralsToNumbersConverter {
	/**
	 * Converts a numeral expression to its numeric equivalent.
	 *
	 * @param numeralExpression Numeral expression to convert.
	 *
	 * @return The numeric equivalent of the numeral expression.
	 *
	 * @throws UnrecognizedNumeralException Exception thrown when the numeral expression is not valid.
	 */
	Integer convertNumeralToNumber (String numeralExpression) throws UnrecognizedNumeralException;
}