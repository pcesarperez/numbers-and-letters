package com.adastrafork.numbersandletters.es;

/**
 * Rules applied in Spanish mode.
 */
public enum SpanishNumeralRule {
	//@formatter:off
	no_rule_fired ("no rule"),
	r0 ("r0"),
	r1 ("r1"),
	r1a ("r1a"),
	r1b ("r1b"),
	r2 ("r2"),
	r2a ("r2a"),
	r3 ("r3"),
	r4 ("r4"),
	r4a ("r4a");
	//@formatter:on

	private final String ruleName;


	SpanishNumeralRule (String ruleName) {
		this.ruleName = ruleName;
	}
}