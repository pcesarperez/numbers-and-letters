/*
 * SpanishNumerals.g4
 *
 * Grammar to parse Spanish numerals and convert them to their numeric equivalent.
 */
grammar SpanishNumerals;


/*
 * Java package of the generated sources.
 */
@header {
package com.adastrafork.numbersandletters.converters.es.antlr4;
}


/*
 * This is the root rule.
 * Any Spanish numeral should fit one of the inner rules.
 */
numeralExpression : (r0 | r1 | r2 | r3 | r4 | r5);


/*
 * Rule `r0`.
 *
 * This rule checks the numeral "cero" (0).
 * When this numeral appears, it is pretty much "game over".
 */
r0: ('cero');


/*
 * Rule `r1`.
 *
 * This rule checks the 1-word numerals, from "uno" (1) to "veintinueve" (29).
 */
r1: (
    'uno' |
    'dos' |
    'tres' |
    'cuatro' |
    'cinco' |
    'seis' |
    'siete' |
    'ocho' |
    'nueve' |
    'diez' |
    'once' |
    'doce' |
    'trece' |
    'catorce' |
    'quince' |
    'dieciséis' |
    'diecisiete' |
    'dieciocho' |
    'diecinueve' |
    'veinte' |
    'veintiuno' |
    'veintidós' |
    'veintitrés' |
    'veinticuatro' |
    'veinticinco' |
    'veintiséis' |
    'veintisiete' |
    'veintiocho' |
    'veintinueve'
);


/*
 * Rule `r2`.
 *
 * This rule checks the numerals from "treinta" (30) to "noventa y nueve" (99).
 * Things are getting interesting here, for we have two contributing parts in the rule.
 */
r2: ((tens) (((WHITESPACES) 'y' (WHITESPACES)) (units))?);


/*
 * Rule `r3`.
 *
 * This rule cheks the numeral "cien" (100).
 * This is a "game over" numeral, like "cero".
 */
r3: ('cien');


/*
 * Rule `r4`.
 *
 * This rule checks the numerals from "ciento uno" (101) to "ciento noventa y nueve" (199).
 * And this is the firs recursive rule.
 * The 1-hundreds are a special case, so they have to be treated separately.
 */
r4: (('ciento') ((WHITESPACES) (r1 | r2)));


/*
 * Rule `r5`.
 *
 * This rule checks the numerals from "doscientos" (200) to "novecientos noventa y nueve" (999).
 */
r5: ((hundreds) ((WHITESPACES) (r1 | r2))?);


/*
 * Helper rule to hold hundreds in a numeral.
 */
hundreds: (
    'doscientos' |
    'trescientos' |
    'cuatrocientos' |
    'quinientos' |
    'seiscientos' |
    'setecientos' |
    'ochocientos' |
    'novecientos'
);


/*
 * Helper rule to hold tens in a numeral.
 */
tens: (
    'treinta' |
    'cuarenta' |
    'cincuenta' |
    'sesenta' |
    'setenta' |
    'ochenta' |
    'noventa'
);


/*
 * Helper rule to hold units in a numeral.
 */
units: (
    'uno' |
    'dos' |
    'tres' |
    'cuatro' |
    'cinco' |
    'seis' |
    'siete' |
    'ocho' |
    'nueve'
);


/*
 * Helper token to hold an arbitrary number of whitespaces.
 */
WHITESPACES: [ \t]+;