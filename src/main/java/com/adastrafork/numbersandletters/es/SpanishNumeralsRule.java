package com.adastrafork.numbersandletters.es;


/**
 * Rules used in the Spanish numerals recognition engine.
 */
public enum SpanishNumeralsRule {
	R0 ("r0"),
	R1 ("r1"),
	R2 ("r2"),
	R3 ("r3"),
	R4 ("r4"),
	R5 ("r5");

	private final String ruleName;


	private SpanishNumeralsRule (String ruleName) {
		this.ruleName = ruleName;
	}
}