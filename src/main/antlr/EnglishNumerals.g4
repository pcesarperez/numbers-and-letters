/*
 * EnglishNumerals.g4
 *
 * Grammar to parse English numerals and convert them to their numeric equivalent.
 */
grammar EnglishNumerals;


/*
 * This is the root rule.
 * Any English numeral should fit one of the inner rules.
 */
numeralExpression : (r0 | r1 | r2 | r3 | r4);


/*
 * Rule `r0`.
 *
 * This rule checks the numeral "zero" (0).
 * When this numeral appears, it is pretty much "game over", meaning it cannot be combined with other numerals.
 */
r0: ('zero');


/*
 * Rule `r1`.
 *
 * This rule checks 1-word numerals from "one" (1) to "nine" (9).
 * This rule will be reused later on.
 */
r1: ('one' | 'two' | 'three' | 'four' | 'five' | 'six' | 'seven' | 'eight' | 'nine');


/*
 * Rule `r2`.
 *
 * This rule checks the remaining 1-word numerals, from "ten" (10) to "nineteen" (19).
 */
r2: (
    'ten' |
    'eleven' |
    'twelve' |
    'thirteen' |
    'fourteen' |
    'fifteen' |
    'sixteen' |
    'seventeen' |
    'eighteen' |
    'nineteen'
);


/*
 * Rule `r3`.
 *
 * This rule checks the numerals from "twenty" (20) to "ninety-nine" (99).
 * This is the first composite rule, using `r1` declared before.
 */
r3: (tens (HYPHEN r1)?);


/*
 * Rule `r4`.
 *
 * This rule checks the numerals from "one hundred" (101) to "nine hundred and ninety" (199).
 * The "and" connector is optional to conform American english style.
 */
r4: (r1 WHITESPACES HUNDRED (WHITESPACES (CONNECTOR WHITESPACES)? (r1 | r2 | r3))?);


/*
 * Helper rule to hold tens in a numeral.
 */
tens: (
    'twenty' |
    'thirty' |
    'forty' |
    'fifty' |
    'sixty' |
    'seventy' |
    'eighty' |
    'ninety'
);


/*
 * Helper tokens.
 */
HYPHEN: ('-');
HUNDRED: ('hundred');
CONNECTOR: ('and');
WHITESPACES: ([ \t]+);