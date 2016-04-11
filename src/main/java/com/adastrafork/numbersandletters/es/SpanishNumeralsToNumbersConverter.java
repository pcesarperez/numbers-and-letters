package com.adastrafork.numbersandletters.es;


import com.adastrafork.numbersandletters.es.antlr4.SpanishNumeralsLexer;
import com.adastrafork.numbersandletters.es.antlr4.SpanishNumeralsParser;
import com.adastrafork.numbersandletters.es.exceptions.UnrecognizedNumeralException;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;


/**
 * Class to convert Spanish numerals to their numeric equivalents.
 */
public class SpanishNumeralsToNumbersConverter {


	/**
	 * Sets up the converter.
	 */
	public SpanishNumeralsToNumbersConverter ( ) {
	}


	/**
	 * Converts a Spanish numeral expression to its numeric equivalent.
	 *
	 * @param numeralExpression Spanish numeral expression to convert.
	 *
	 * @return The numeric equivalent of the numeral expression.
	 *
	 * @throws UnrecognizedNumeralException
	 */
	public Integer convertNumeralToNumber (String numeralExpression) throws UnrecognizedNumeralException {
		SpanishNumeralsLexer lexer = new SpanishNumeralsLexer (new ANTLRInputStream (numeralExpression));
		SpanishNumeralsParser parser = new SpanishNumeralsParser (new CommonTokenStream (lexer));
		SpanishNumeralRecognitionEngine engine = new SpanishNumeralRecognitionEngine ( );
		ParseTree tree = parser.numeralExpression ( );

		Integer result = engine.visit (tree);

		return result;
	}
}