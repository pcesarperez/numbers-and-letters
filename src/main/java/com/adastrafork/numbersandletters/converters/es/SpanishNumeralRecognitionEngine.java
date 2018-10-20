package com.adastrafork.numbersandletters.converters.es;


import com.adastrafork.numbersandletters.generated.antlr4.SpanishNumeralsBaseVisitor;
import com.adastrafork.numbersandletters.generated.antlr4.SpanishNumeralsParser;


/**
 * Class to visit the nodes of the tree wich add value to the result of the evaluation of a Spanish numeral.
 */
public final class SpanishNumeralRecognitionEngine extends SpanishNumeralsBaseVisitor<Integer> {
	@Override
	public Integer visitNumeralExpression (SpanishNumeralsParser.NumeralExpressionContext ctx) {
		return super.visitNumeralExpression (ctx);
	}


	@Override
	public Integer visitR0 (SpanishNumeralsParser.R0Context ctx) {
		return 0;
	}


	@Override
	public Integer visitR1 (SpanishNumeralsParser.R1Context ctx) {
		String oneWordNumeral = ctx.getText ( );

		return SpanishNumeralValues.fromNumeral (oneWordNumeral);
	}


	@Override
	public Integer visitR2 (SpanishNumeralsParser.R2Context ctx) {
		String oneWordNumeral = ctx.getText ( );

		return SpanishNumeralValues.fromNumeral (oneWordNumeral);
	}


	@Override
	public Integer visitR3 (SpanishNumeralsParser.R3Context ctx) {
		Integer tens = visitTens (ctx.tens ( ));

		if (ctx.r1 ( ) != null) {
			Integer units = visitR1 (ctx.r1 ( ));

			return tens + units;
		} else {
			return tens;
		}
	}


	@Override
	public Integer visitR4 (SpanishNumeralsParser.R4Context ctx) {
		return 100;
	}


	@Override
	public Integer visitR5 (SpanishNumeralsParser.R5Context ctx) {
		if (ctx.r1 ( ) != null) {
			return 100 + visitR1 (ctx.r1 ( ));
		} else if (ctx.r2 ( ) != null) {
			return 100 + visitR2 (ctx.r2 ( ));
		} else {
			return 100 +visitR3 (ctx.r3 ( ));
		}
	}


	@Override
	public Integer visitR6 (SpanishNumeralsParser.R6Context ctx) {
		Integer hundreds = visitHundreds (ctx.hundreds ( ));

		if (ctx.r1 ( ) != null) {
			return hundreds + visitR1 (ctx.r1 ( ));
		} else if (ctx.r2 ( ) != null) {
			return hundreds + visitR2 (ctx.r2 ( ));
		} else if (ctx.r3 ( ) != null) {
			return hundreds + visitR3 (ctx.r3 ( ));
		} else {
			return hundreds;
		}
	}


	@Override
	public Integer visitTens (SpanishNumeralsParser.TensContext ctx) {
		String tensNumeral = ctx.getText ( );

		return SpanishNumeralValues.fromNumeral (tensNumeral);
	}


	@Override
	public Integer visitHundreds (SpanishNumeralsParser.HundredsContext ctx) {
		String hundredsNumeral = ctx.getText ( );

		return SpanishNumeralValues.fromNumeral (hundredsNumeral);
	}
}