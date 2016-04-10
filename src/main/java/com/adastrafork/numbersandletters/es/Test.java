package com.adastrafork.numbersandletters.es;

import com.adastrafork.numbersandletters.es.antlr4.SpanishNumeralsBaseVisitor;
import com.adastrafork.numbersandletters.es.antlr4.SpanishNumeralsLexer;
import com.adastrafork.numbersandletters.es.antlr4.SpanishNumeralsParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Created by adastra on 30/03/16.
 */
public class Test {
	public static void main (String [ ] args) {
		SpanishNumeralsLexer lexer = new SpanishNumeralsLexer (new ANTLRInputStream ("ciento noventa y nueve"));
		SpanishNumeralsParser parser = new SpanishNumeralsParser (new CommonTokenStream (lexer));
		SpanishNumeralsBaseVisitor<Integer> visitor = new SpanishNumeralsBaseVisitor<Integer> ( );
		ParseTree tree = parser.numeralExpression ( );

		Integer result = visitor.visit (tree);
		System.out.println (result);

		/*
		SpanishNumeralsToNumbersConverter numeralsConverter = new SpanishNumeralsToNumbersConverter ( );

		try {
			System.out.println (numeralsConverter.convertNumeralToNumber ("cero"));
		} catch (UnrecognizedNumeralException e) {
			e.printStackTrace ( );
		}
		*/
	}
}
