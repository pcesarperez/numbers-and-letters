package com.adastrafork.numbersandletters.es;


import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Class to hold the regex pattern to parse Spanish numerals.
 */
public final class SpanishNumeralRecognitionEngine {
	public static final String R0 = "r0";
	public static final String R1 = "r1";
	public static final String R1A = "r1a";
	public static final String R1B = "r1b";
	public static final String R2 = "r2";
	public static final String R2A = "r2a";
	public static final String R3 = "r3";
	public static final String R4 = "r4";
	public static final String R4A = "r4a";
	public static final String R5 = "r5";
	public static final String R5A = "r5a";
	public static final String TENS = "tens";
	public static final String UNITS = "units";
	public static final String R4_SUFFIX = "r4suffix";
	public static final String R4A_SUFFIX = "r4asuffix";
	public static final String R5_SUFFIX = "r5suffix";
	public static final String R5A_SUFFIX = "r5asuffix";

	private static final String PATTERN_START = "^";
	private static final String PATTERN_END = "$";

	private Matcher m;
	private String prefixPattern;
	private String suffixPattern;
	private String prefix;
	private String suffix;


	/**
	 * Gets the pattern text corresponding to the initial parsing of a Spanish numeral expression.
	 *
	 * @return Full pattern text with all the rules to perform the initial parsing of a Spanish numeral expression.
	 */
	public String fullPatternText ( ) {
		//@formatter:off
		return boxRules (
			r0 ( ),
			r1 ( ),
			r2 ( ),
			r3 ( ),
			r4 ( )
		);
		//@formatter:on
	}


	/**
	 * Finds out if a Spanish numeral expression matches the given regexp pattern.
	 *
	 * @param numeralExpression Spanish numeral expression to match against the pattern.
	 * @param patternText       Pattern used to check the numeral expression.
	 * @return Returns <code>true</code> if the numeral expression matches the pattern, or <code>false</code> otherwise.
	 */
	public boolean isFound (String numeralExpression, String patternText) {
		Pattern p = Pattern.compile (patternText);
		m = p.matcher (numeralExpression);

		return m.matches ( );
	}


	/**
	 * Gets the rule fired in the last pattern matching process.
	 *
	 * @return An item in the enumeration <code>SpanishNumeralRule</code> with the name of the last rule fired, including a value to state that no rule has been fired.
	 * @see SpanishNumeralRule
	 */
	public SpanishNumeralRule ruleFired ( ) {
		if (m.group (R0) != null) {
			return SpanishNumeralRule.r0;
		} else if (m.group (R1) != null) {
			return SpanishNumeralRule.r1;
		} else if (m.group (R1A) != null) {
			return SpanishNumeralRule.r1a;
		} else if (m.group (R1B) != null) {
			return SpanishNumeralRule.r1b;
		} else if (m.group (R2) != null) {
			return SpanishNumeralRule.r2;
		} else if (m.group (R2A) != null) {
			return SpanishNumeralRule.r2a;
		} else if (m.group (R3) != null) {
			return SpanishNumeralRule.r3;
		} else if (m.group (R4) != null) {
			suffix = m.group (R4_SUFFIX);

			return SpanishNumeralRule.r4;
		} else if (m.group (R4A) != null) {
			suffix = m.group (R4A_SUFFIX);

			return SpanishNumeralRule.r4a;
		} else {
			return SpanishNumeralRule.no_rule_fired;
		}
	}


	/**
	 * Gets the pattern in the prefix of the last fired rule.
	 * <p/>
	 * The prefix pattern will be used to parse recursively the numeral expression.
	 *
	 * @return Prefix pattern contained in the pattern of the last fired rule.
	 */
	public String prefixPattern ( ) {
		return this.prefixPattern;
	}


	/**
	 * Gets the pattern in the suffix of the last fired rule.
	 * <p/>
	 * The suffix pattern will be used to parse recursively the numeral expression.
	 *
	 * @return Suffix pattern contained in the pattern of the last fired rule.
	 */
	public String suffixPattern ( ) {
		return this.suffixPattern;
	}


	/**
	 * Gets the prefix of the last fired rule.
	 * <p/>
	 * The prefix will be used to get the straight value of the last fired rule.
	 *
	 * @return Prefix used in the last fired rule.
	 */
	public String prefix ( ) {
		return this.prefix;
	}


	/**
	 * Gets the suffix of the last fired rule.
	 * <p/>
	 * The sufix will be used to get the straight value of the last fired rule.
	 *
	 * @return Suffix used in the last fired rule.
	 */
	public String suffix ( ) {
		return this.suffix;
	}


	/**
	 * Boxes a set of rules into one compound regular expression.
	 * <p/>
	 * This is used in the recursion through the rules in the parsing process.
	 *
	 * @param rules Set of rules <code>[r<sub>n</sub>..r<sub>m</sub>]</code>to be used in the regular expression.
	 * @return Regular expression <code>r<sub>n</sub>|r<sub>n + 1</sub>|...|r<sub>m</sub></code>.
	 */
	private String boxRules (String... rules) {
		StringJoiner joiner = new StringJoiner ("|");

		for (String rule : rules) {
			joiner.add (wrappedRegex (rule));
		}

		return joiner.toString ( );
	}


	/**
	 * Wraps a partial regexp between start (<code>^</code>) and end (<code>$</code>) tags.
	 *
	 * @param partialRegex Partial regexp to wrap.
	 * @return Partial regexp wrapped between start (<code>^</code>) and end (<code>$</code>) tags.
	 */
	private String wrappedRegex (String partialRegex) {
		return String.format ("%s%s%s", PATTERN_START, partialRegex, PATTERN_END);
	}


	/**
	 * Rule <code>r<sub>0</sub></code>.
	 * <p/>
	 * This rule checks the numeral "cero" (0).
	 * <p/>
	 * When this numeral appears, it is pretty much "game over".
	 *
	 * @return Partial regex pattern to check the numeral "cero" (0).
	 */
	private String r0 ( ) {
		String zero = "cero";

		String r0 = String.format ("(?<%s>%s)", R0, zero);

		return r0;
	}


	/**
	 * Rule <code>r<sub>1</sub></code>.
	 * <p/>
	 * This rule checks the 1-word numerals, from "uno" (1) to "veintinueve" (29).
	 *
	 * @return Partial regex pattern to check 1-word numerals, from "uno" (1) to "veintinueve" (29).
	 */
	private String r1 ( ) {
		String oneWordNumerals = "uno|dos|tres|cuatro|cinco|seis|siete|ocho|nueve|diez|once|doce|trece|catorce|quince|dieciséis|diecisiete|dieciocho|diecinueve|veinte|veintiuno|veintidós|veintitrés|veinticuatro|veinticinco|veintiséis|veintisiete|veintiocho|veintinueve";

		String r1 = String.format ("(?<%s>%s)", R1, oneWordNumerals);

		return r1;
	}


	/**
	 * Rule <code>r<sub>1a</sub></code>.
	 * <p/>
	 * This is a variation of the <code>r<sub>1</sub></code> rule, applied when it's used as a prefix.
	 * <p/>
	 * For example, you may say "treinta y un mil" (31000), but no "treinta y uno mil".
	 *
	 * @return Partial regex pattern to check 1-word numerals, from "un" (1) to "veintinueve" (29), used as a prefix.
	 */
	private String r1a ( ) {
		String oneWordNumerals = "un|dos|tres|cuatro|cinco|seis|siete|ocho|nueve|diez|once|doce|trece|catorce|quince|dieciséis|diecisiete|dieciocho|diecinueve|veinte|veintiuno|veintidós|veintitrés|veinticuatro|veinticinco|veintiséis|veintisiete|veintiocho|veintinueve";

		String r1a = String.format ("(?<%s>%s)", R1A, oneWordNumerals);

		return r1a;
	}


	/**
	 * Rule <code>r<sub>1b</sub></code>.
	 * <p/>
	 * This is a variation of the <code>r<sub>1</sub></code> rule, applied when it's used as a prefix but the numeral "uno" is not needed.
	 * <p/>
	 * For example, you may say "dos millones" (2000000), but no "uno millones".
	 *
	 * @return Partial regex pattern to check 1-word numerals, from "dos" (2) to "veintinueve" (29), used as a prefix when the numeral "uno" is not needed.
	 */
	private String r1b ( ) {
		String oneWordNumerals = "dos|tres|cuatro|cinco|seis|siete|ocho|nueve|diez|once|doce|trece|catorce|quince|dieciséis|diecisiete|dieciocho|diecinueve|veinte|veintiuno|veintidós|veintitrés|veinticuatro|veinticinco|veintiséis|veintisiete|veintiocho|veintinueve";

		String r1b = String.format ("(?<%s>%s)", R1B, oneWordNumerals);

		return r1b;
	}


	/**
	 * Rule <code>r<sub>2</sub></code>.
	 * <p/>
	 * This rule checks the numerals from "treinta" (30) to "noventa y nueve" (99).
	 *
	 * @return Partial regexp pattern to check numerals from "treinta" (30) to "noventa y nueve" (99).
	 */
	private String r2 ( ) {
		String tens = "treinta|cuarenta|cincuenta|sesenta|setenta|ochenta|noventa";
		String connector = "\\s*y\\s*";
		String units = "uno|dos|tres|cuatro|cinco|seis|siete|ocho|nueve";

		prefix = tens;
		suffix = units;

		String r2 = String.format ("(?<%s>(?<%s>%s)((?:%s)(?<%s>%s))?)", R2, TENS, tens, connector, UNITS, units);

		return r2;
	}


	/**
	 * Rule <code>r<sub>2a</sub></code>.
	 * <p/>
	 * This is a variation of the <code>r<sub>2</sub></code> rule, applied when it's used as a prefix.
	 * <p/>
	 * For example, you may say "cuarenta y un millones" (41000000), but no "cuarenta y uno millones".
	 *
	 * @return Partial regex pattern to check numerals from "treinta" (30) to "noventa y nueve" (99), used as a prefix.
	 */
	private String r2a ( ) {
		String tens = "treinta|cuarenta|cincuenta|sesenta|setenta|ochenta|noventa";
		String connector = "\\s*y\\s*";
		String units = "un|dos|tres|cuatro|cinco|seis|siete|ocho|nueve";

		prefix = tens;
		suffix = units;

		String r2a = String.format ("(?<%s>(?<%s>%s)((?:%s)(?<%s>%s))?)", R2A, TENS, tens, connector, UNITS, units);

		return r2a;
	}


	/**
	 * Rule <code>r<sub>3</sub></code>.
	 * <p/>
	 * This rule cheks the numeral "cien" (100).
	 * <p/>
	 * This is a "game over" numeral, like "cero".
	 *
	 * @return Partial regex pattern to check the numeral "cien" (100).
	 */
	private String r3 ( ) {
		String hundred = "cien";

		String r3 = String.format ("(?<%s>%s)", R3, hundred);

		return r3;
	}


	/**
	 * Rule <code>r<sub>4</sub></code>.
	 * <p/>
	 * This rule checks the numerals from "ciento uno" (101) to "ciento noventa y nueve" (199).
	 * <p/>
	 * The 1-hundreds are a special case, so they have to be treated separately.
	 *
	 * @return Partial regex pattern to check numerals from "ciento uno" (101) to "ciento noventa y nueve" (199);
	 */
	private String r4 ( ) {
		String hundred = "ciento";
		String r4Suffix = String.format (boxRules (r1 ( ), r2 ( )));

		suffixPattern = r4Suffix;

		String r4 = String.format ("(?<%s>%s(?:\\s(?<%s>%s)))", R4, hundred, R4_SUFFIX, r4Suffix);

		return r4;
	}


	/**
	 * Rule <code>r<sub>4a</sub></code>.
	 * <p/>
	 * This is a variation of the <code>r<sub>4</sub></code> rule, applied when it's used as a prefix.
	 * <p/>
	 * For example, you may say "ciento un mil" (101000), but no "ciento uno mil".
	 *
	 * @return Partial regex pattern to check numerals from "ciento un" (101) to "ciento noventa y nueve" (199), used as a prefix.
	 */
	private String r4a ( ) {
		String hundred = "ciento";
		String r4aSuffix = String.format (boxRules (r1a ( ), r2a ( )));

		suffixPattern = r4aSuffix;

		String r4a = String.format ("(?<%s>%s(?:\\s(?<%s>%s)))", hundred, R4A, R4A_SUFFIX, r4aSuffix);

		return r4a;
	}
}