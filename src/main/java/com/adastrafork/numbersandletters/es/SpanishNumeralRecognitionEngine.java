package com.adastrafork.numbersandletters.es;


import com.adastrafork.numbersandletters.es.antlr4.SpanishNumeralsBaseVisitor;
import com.adastrafork.numbersandletters.es.antlr4.SpanishNumeralsParser;


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
		Integer tens = visitTens (ctx.tens ( ));

		if (ctx.units ( ) != null) {
			Integer units = visitUnits (ctx.units ( ));

			return tens + units;
		} else {
			return tens;
		}
	}


	@Override
	public Integer visitR3 (SpanishNumeralsParser.R3Context ctx) {
		return 100;
	}


	@Override
	public Integer visitR4 (SpanishNumeralsParser.R4Context ctx) {
		if (ctx.r1 ( ) != null) {
			return 100 + visitR1 (ctx.r1 ( ));
		} else {
			return 100 + visitR2 (ctx.r2 ( ));
		}
	}


	@Override
	public Integer visitR5 (SpanishNumeralsParser.R5Context ctx) {
		Integer hundreds = visitHundreds (ctx.hundreds ( ));

		if (ctx.r1 ( ) != null) {
			return hundreds + visitR1 (ctx.r1 ( ));
		} else if (ctx.r2 ( ) != null) {
			return hundreds + visitR2 (ctx.r2 ( ));
		} else {
			return hundreds;
		}
	}


	@Override
	public Integer visitHundreds (SpanishNumeralsParser.HundredsContext ctx) {
		String hundredsNumeral = ctx.getText ( );

		return SpanishNumeralValues.fromNumeral (hundredsNumeral);
	}


	@Override
	public Integer visitTens (SpanishNumeralsParser.TensContext ctx) {
		String tensNumeral = ctx.getText ( );

		return SpanishNumeralValues.fromNumeral (tensNumeral);
	}


	@Override
	public Integer visitUnits (SpanishNumeralsParser.UnitsContext ctx) {
		String unitsNumeral = ctx.getText ( );

		return SpanishNumeralValues.fromNumeral (unitsNumeral);
	}
}