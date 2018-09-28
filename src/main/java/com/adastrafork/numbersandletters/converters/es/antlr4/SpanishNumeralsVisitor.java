// Generated from SpanishNumerals.g4 by ANTLR 4.5.3

    package com.adastrafork.numbersandletters.converters.es.antlr4;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SpanishNumeralsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SpanishNumeralsVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SpanishNumeralsParser#numeralExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumeralExpression(SpanishNumeralsParser.NumeralExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpanishNumeralsParser#r0}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitR0(SpanishNumeralsParser.R0Context ctx);
	/**
	 * Visit a parse tree produced by {@link SpanishNumeralsParser#r1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitR1(SpanishNumeralsParser.R1Context ctx);
	/**
	 * Visit a parse tree produced by {@link SpanishNumeralsParser#r2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitR2(SpanishNumeralsParser.R2Context ctx);
	/**
	 * Visit a parse tree produced by {@link SpanishNumeralsParser#r3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitR3(SpanishNumeralsParser.R3Context ctx);
	/**
	 * Visit a parse tree produced by {@link SpanishNumeralsParser#r4}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitR4(SpanishNumeralsParser.R4Context ctx);
	/**
	 * Visit a parse tree produced by {@link SpanishNumeralsParser#r5}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitR5(SpanishNumeralsParser.R5Context ctx);
	/**
	 * Visit a parse tree produced by {@link SpanishNumeralsParser#hundreds}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHundreds(SpanishNumeralsParser.HundredsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpanishNumeralsParser#tens}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTens(SpanishNumeralsParser.TensContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpanishNumeralsParser#units}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnits(SpanishNumeralsParser.UnitsContext ctx);
}