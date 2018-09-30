package com.adastrafork.numbersandletters.converters.es;


import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import com.adastrafork.numbersandletters.converters.INumeralsToNumbersConverter;
import com.adastrafork.numbersandletters.errorhandling.ThrowingErrorListener;
import com.adastrafork.numbersandletters.exceptions.UnrecognizedNumeralException;
import com.adastrafork.numbersandletters.converters.es.antlr4.SpanishNumeralsLexer;
import com.adastrafork.numbersandletters.converters.es.antlr4.SpanishNumeralsParser;


/**
 * Class to convert Spanish numerals to their numeric equivalents.
 */
public class SpanishNumeralsToNumbersConverter implements INumeralsToNumbersConverter {
	/**
	 * Converts a Spanish numeral expression to its numeric equivalent.
	 *
	 * @param numeralExpression Spanish numeral expression to convert.
	 *
	 * @return The numeric equivalent of the numeral expression.
	 *
	 * @throws UnrecognizedNumeralException Exception thrown when the numeral expression is not valid.
	 */
	public Integer convertNumeralToNumber (String numeralExpression) throws UnrecognizedNumeralException {
		SpanishNumeralsLexer lexer = newLexer (numeralExpression);
		SpanishNumeralsParser parser = newParser (lexer);

		ParseTree tree;
		try {
			tree = parser.numeralExpression ( );
		} catch (Exception e) {
			throw new UnrecognizedNumeralException (String.format ("The Spanish numeral expression '{0}' is not valid.", numeralExpression), e);
		}

		SpanishNumeralRecognitionEngine engine = new SpanishNumeralRecognitionEngine ( );

		return engine.visit (tree);
	}


	/**
	 * Sets up a new Spanish numerals lexer with proper error handling attached.
	 *
	 * @param numeralExpression Spanish numeral expression to parse.
	 *
	 * @return An object of type <code>SpanishNumeralsLexer</code> to perform the lexical analysis of the Spanish numeral expression.
	 */
	private SpanishNumeralsLexer newLexer (String numeralExpression) {
		SpanishNumeralsLexer lexer = new SpanishNumeralsLexer (new ANTLRInputStream (numeralExpression));

		lexer.removeErrorListeners ( );
		lexer.addErrorListener (ThrowingErrorListener.INSTANCE);

		return lexer;
	}


	/**
	 * Sets up a new Spanish numerals parser with proper error handling attached.
	 *
	 * @param lexer An object of type <code>SpanishNumeralsLexer</code> to perform the lexical analysis of a Spanish numeral expression.
	 *
	 * @return An object of type <code>SpanishNumeralsParser</code> to perform the parsing of a Spanish numeral expression.
	 */
	private SpanishNumeralsParser newParser (SpanishNumeralsLexer lexer) {
		SpanishNumeralsParser parser = new SpanishNumeralsParser (new CommonTokenStream (lexer));

		parser.removeErrorListeners ( );
		parser.addErrorListener (ThrowingErrorListener.INSTANCE);

		return parser;
	}
}