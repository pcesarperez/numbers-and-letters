package com.adastrafork.numbersandletters.converters.en;


import com.adastrafork.numbersandletters.generated.antlr4.EnglishNumeralsBaseVisitor;
import com.adastrafork.numbersandletters.generated.antlr4.EnglishNumeralsParser;


/**
 * Class to visit the nodes of the tree wich add value to the result of the evaluation of a English numeral.
 */
final class EnglishNumeralRecognitionEngine extends EnglishNumeralsBaseVisitor<Integer> {
	@Override
	public Integer visitNumeralExpression (EnglishNumeralsParser.NumeralExpressionContext ctx) {
		return super.visitNumeralExpression (ctx);
	}


	@Override
	public Integer visitR0 (EnglishNumeralsParser.R0Context ctx) {
		return 0;
	}


	@Override
	public Integer visitR1 (EnglishNumeralsParser.R1Context ctx) {
		String oneWordNumeral = ctx.getText ( );

		return EnglishNumeralValues.fromNumeral (oneWordNumeral);
	}


	@Override
	public Integer visitR2 (EnglishNumeralsParser.R2Context ctx) {
		String oneWordNumeral = ctx.getText ( );

		return EnglishNumeralValues.fromNumeral (oneWordNumeral);
	}


	@Override
	public Integer visitR3 (EnglishNumeralsParser.R3Context ctx) {
		Integer tens = visitTens (ctx.tens ( ));

		if (ctx.r1 ( ) != null) {
			Integer units = visitR1 (ctx.r1 ( ));

			return tens + units;
		} else {
			return tens;
		}
	}


	@Override
	public Integer visitR4 (EnglishNumeralsParser.R4Context ctx) {
		Integer hundreds = 100 * visitR1 (ctx.r1 (0));

		if (ctx.r1 (1) != null) {
			return hundreds + visitR1 (ctx.r1 (1));
		} else if (ctx.r2 ( ) != null) {
			return hundreds + visitR2 (ctx.r2 ( ));
		} else if (ctx.r3 ( ) != null) {
			return hundreds +visitR3 (ctx.r3 ( ));
		} else {
			return hundreds;
		}
	}


	@Override
	public Integer visitTens (EnglishNumeralsParser.TensContext ctx) {
		String tensNumeral = ctx.getText ( );

		return EnglishNumeralValues.fromNumeral (tensNumeral);
	}
}