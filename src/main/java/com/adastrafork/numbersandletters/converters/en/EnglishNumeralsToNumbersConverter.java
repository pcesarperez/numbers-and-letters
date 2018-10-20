package com.adastrafork.numbersandletters.converters.en;


import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import com.adastrafork.numbersandletters.converters.INumeralsToNumbersConverter;
import com.adastrafork.numbersandletters.errorhandling.ThrowingErrorListener;
import com.adastrafork.numbersandletters.exceptions.UnrecognizedNumeralException;

import com.adastrafork.numbersandletters.generated.antlr4.EnglishNumeralsLexer;
import com.adastrafork.numbersandletters.generated.antlr4.EnglishNumeralsParser;


/**
 * Class to convert English numerals to their numeric equivalents.
 */
public class EnglishNumeralsToNumbersConverter implements INumeralsToNumbersConverter {
	/**
	 * Converts an English numeral expression to its numeric equivalent.
	 *
	 * @param numeralExpression English numeral expression to convert.
	 *
	 * @return The numeric equivalent of the numeral expression.
	 *
	 * @throws UnrecognizedNumeralException Exception thrown when the numeral expression is not valid.
	 */
	public Integer convertNumeralToNumber (String numeralExpression) throws UnrecognizedNumeralException {
		EnglishNumeralsLexer lexer = newLexer (numeralExpression);
		EnglishNumeralsParser parser = newParser (lexer);

		ParseTree tree;
		try {
			tree = parser.numeralExpression ( );
		} catch (Exception e) {
			throw new UnrecognizedNumeralException (String.format ("The English numeral expression '%s' is not valid.", numeralExpression), e);
		}

		EnglishNumeralRecognitionEngine engine = new EnglishNumeralRecognitionEngine ( );

		return engine.visit (tree);
	}


	/**
	 * Sets up a new English numerals lexer with proper error handling attached.
	 *
	 * @param numeralExpression English numeral expression to parse.
	 *
	 * @return An object of type <code>EnglishNumeralsLexer</code> to perform the lexical analysis of the English numeral expression.
	 */
	private EnglishNumeralsLexer newLexer (String numeralExpression) {
		EnglishNumeralsLexer lexer = new EnglishNumeralsLexer (new ANTLRInputStream (numeralExpression));

		lexer.removeErrorListeners ( );
		lexer.addErrorListener (ThrowingErrorListener.INSTANCE);

		return lexer;
	}


	/**
	 * Sets up a new English numerals parser with proper error handling attached.
	 *
	 * @param lexer An object of type <code>EnglishNumeralsLexer</code> to perform the lexical analysis of a English numeral expression.
	 *
	 * @return An object of type <code>EnglishNumeralsParser</code> to perform the parsing of a English numeral expression.
	 */
	private EnglishNumeralsParser newParser (EnglishNumeralsLexer lexer) {
		EnglishNumeralsParser parser = new EnglishNumeralsParser (new CommonTokenStream (lexer));

		parser.removeErrorListeners ( );
		parser.addErrorListener (ThrowingErrorListener.INSTANCE);

		return parser;
	}
}