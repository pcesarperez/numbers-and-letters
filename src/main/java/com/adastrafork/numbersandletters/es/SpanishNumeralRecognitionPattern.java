package com.adastrafork.numbersandletters.es;


import java.util.regex.Pattern;


/**
 * Class to hold the regex pattern to parse Spanish numerals.
 */
public final class SpanishNumeralRecognitionPattern {
	public static final String R0 = "r0";
	public static final String R1 = "r1";
	public static final String R1A = "r1a";
	public static final String R1B = "r1b";
	public static final String R2 = "r2";
	public static final String R2A = "r2a";
	public static final String TENS = "tens";
	public static final String UNITS = "units";

	private static final String PATTERN_START = "^";
	private static final String PATTERN_END = "$";


	/**
	 * Gets the pattern to parse Spanish numerals.
	 *
	 * @return Regex pattern to parse Spanish numerals.
	 */
	public Pattern pattern ( ) {
		//@formatter:off
		return Pattern.compile (
			String.format (
				"%s|%s|%s",
				wrappedRegex (r0 ( )),
				wrappedRegex (r1 ( )),
				wrappedRegex (r2 ( ))
			)
		);
		//@formatter:on
	}


	/**
	 * Rule <code>r0</code>.
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
	 * Rule <code>r1</code>.
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
	 * Rule <code>r1a</code>.
	 * <p/>
	 * This is a variation of the <code>r1</code> rule, applied when it's used as a prefix.
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
	 * Rule <code>r1b</code>.
	 * <p/>
	 * This is a variation of the <code>r1</code> rule, applied when it's used as a prefix but the numeral "uno" is not needed.
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
	 * Rule <code>r2</code>.
	 * <p/>
	 * This rule checks the numerals from "treinta" (30) to "noventa y nueve" (99).
	 *
	 * @return Partial regexp pattern to check numerals from "treinta" (30) to "noventa y nueve" (99).
	 */
	private String r2 ( ) {
		String tens = "treinta|cuarenta|cincuenta|sesenta|setenta|ochenta|noventa";
		String connector = "\\s*y\\s*";
		String units = "uno|dos|tres|cuatro|cinco|seis|siete|ocho|nueve";

		String r2 = String.format ("(?<%s>(?<%s>%s)((?:%s)(?<%s>%s))?)", R2, TENS, tens, connector, UNITS, units);

		return r2;
	}


	/**
	 * Rule <code>r2a</code>.
	 * <p/>
	 * This is a variation of the <code>r2</code> rule, applied when it's used as a prefix.
	 * <p/>
	 * For example, you may say "cuarenta y un millones" (41000000), but no "cuarenta y uno millones".
	 *
	 * @return Partial regex pattern to check numerals from "treinta" (30) to "noventa y nueve" (99), used as a prefix.
	 */
	private String r2a ( ) {
		String tens = "treinta|cuarenta|cincuenta|sesenta|setenta|ochenta|noventa";
		String connector = "\\s*y\\s*";
		String units = "un|dos|tres|cuatro|cinco|seis|siete|ocho|nueve";

		String r2a = String.format ("(?<%s>(?<%s>%s)((?:%s)(?<%s>%s))?)", R2A, TENS, tens, connector, UNITS, units);

		return r2a;
	}


	/**
	 * Wraps a partial regexp between start (<code>^</code>) and end (<code>$</code>) tags.
	 *
	 * @param partialRegex Partial regexp to wrap.
	 *
	 * @return Partial regexp wrapped between start (<code>^</code>) and end (<code>$</code>) tags.
	 */
	private String wrappedRegex (String partialRegex) {
		return String.format ("%s%s%s", PATTERN_START, partialRegex, PATTERN_END);
	}
}