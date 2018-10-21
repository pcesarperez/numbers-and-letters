/*
 * SpanishNumerals.g4
 *
 * Grammar to parse Spanish numerals and convert them to their numeric equivalent.
 */
grammar SpanishNumerals;


/*
 * This is the root rule.
 * Any Spanish numeral should fit one of the inner rules.
 */
numeralExpression : (r0 | r1 | r2 | r3 | r4 | r5 | r6) EOF;


/*
 * Rule `r0`.
 *
 * This rule checks the numeral "cero" (0).
 * When this numeral appears, it is pretty much "game over", meaning it cannot be combined with other numerals.
 */
r0: ('cero');


/*
 * Rule `r1`.
 *
 * This rule checks 1-word numerals from "uno" (1) to "nueve" (9).
 * This rule will be reused later on.
 */
r1: ('uno' | 'dos' | 'tres' | 'cuatro' | 'cinco' | 'seis' | 'siete' | 'ocho' | 'nueve');


/*
 * Rule `r2`.
 *
 * This rule checks the remaining 1-word numerals, from "diez" (10) to "veintinueve" (29).
 */
r2: (
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
 * Rule `r3`.
 *
 * This rule checks the numerals from "treinta" (30) to "noventa y nueve" (99).
 * This is the first composite rule, using `r1` declared before.
 */
r3: (tens (WHITESPACES CONNECTOR WHITESPACES r1)?);


/*
 * Rule `r4`.
 *
 * This rule cheks the numeral "cien" (100).
 * This is a "game over" numeral, like "cero".
 */
r4: ('cien');


/*
 * Rule `r5`.
 *
 * This rule checks the numerals from "ciento uno" (101) to "ciento noventa y nueve" (199).
 * The 1-hundreds are a special case, so they have to be treated separately.
 */
r5: ('ciento' WHITESPACES (r1 | r2 | r3));


/*
 * Rule `r6`.
 *
 * This rule checks the numerals from "doscientos" (200) to "novecientos noventa y nueve" (999).
 */
r6: (hundreds (WHITESPACES (r1 | r2 | r3))?);


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
 * Lexer tokens.
 */
CONNECTOR: 'y';
WHITESPACES: [ \t]+;