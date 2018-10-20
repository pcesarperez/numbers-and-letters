package com.adastrafork.numbersandletters.errorhandling;


import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;


/**
 * Error listener to manage lexer and parser errors.
 * <p/>
 * See http://stackoverflow.com/a/26573239/4491468
 */
public final class ThrowingErrorListener extends BaseErrorListener {
	public static final ThrowingErrorListener INSTANCE = new ThrowingErrorListener ( );


	/**
	 * Error treatment when a syntax error arises.
	 *
	 * @param recognizer Error recognizer (ignored).
	 * @param offendingSymbol Offending symbol in the numeral expression (ignored).
	 * @param line Line number of the error.
	 * @param charPositionInLine Character position of the error.
	 * @param msg Error message.
	 * @param e Internal error captured.
	 *
	 * @throws ParseCancellationException Exception thrown when the parsing process is cancelled due to a syntax error.
	 */
	@Override
	public void syntaxError (Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) throws ParseCancellationException {
		throw new ParseCancellationException (String.format ("Line %s at position %s: %s.", line, charPositionInLine, msg));
	}
}