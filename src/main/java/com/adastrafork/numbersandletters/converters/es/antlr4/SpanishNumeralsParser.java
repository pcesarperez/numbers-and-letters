// Generated from SpanishNumerals.g4 by ANTLR 4.5.3

    package com.adastrafork.numbersandletters.converters.es.antlr4;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SpanishNumeralsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, WHITESPACES=49;
	public static final int
		RULE_numeralExpression = 0, RULE_r0 = 1, RULE_r1 = 2, RULE_r2 = 3, RULE_r3 = 4, 
		RULE_r4 = 5, RULE_r5 = 6, RULE_hundreds = 7, RULE_tens = 8, RULE_units = 9;
	public static final String[] ruleNames = {
		"numeralExpression", "r0", "r1", "r2", "r3", "r4", "r5", "hundreds", "tens", 
		"units"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'cero'", "'uno'", "'dos'", "'tres'", "'cuatro'", "'cinco'", "'seis'", 
		"'siete'", "'ocho'", "'nueve'", "'diez'", "'once'", "'doce'", "'trece'", 
		"'catorce'", "'quince'", "'dieciséis'", "'diecisiete'", "'dieciocho'", 
		"'diecinueve'", "'veinte'", "'veintiuno'", "'veintidós'", "'veintitrés'", 
		"'veinticuatro'", "'veinticinco'", "'veintiséis'", "'veintisiete'", "'veintiocho'", 
		"'veintinueve'", "'y'", "'cien'", "'ciento'", "'doscientos'", "'trescientos'", 
		"'cuatrocientos'", "'quinientos'", "'seiscientos'", "'setecientos'", "'ochocientos'", 
		"'novecientos'", "'treinta'", "'cuarenta'", "'cincuenta'", "'sesenta'", 
		"'setenta'", "'ochenta'", "'noventa'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "WHITESPACES"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SpanishNumerals.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SpanishNumeralsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class NumeralExpressionContext extends ParserRuleContext {
		public R0Context r0() {
			return getRuleContext(R0Context.class,0);
		}
		public R1Context r1() {
			return getRuleContext(R1Context.class,0);
		}
		public R2Context r2() {
			return getRuleContext(R2Context.class,0);
		}
		public R3Context r3() {
			return getRuleContext(R3Context.class,0);
		}
		public R4Context r4() {
			return getRuleContext(R4Context.class,0);
		}
		public R5Context r5() {
			return getRuleContext(R5Context.class,0);
		}
		public NumeralExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numeralExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpanishNumeralsVisitor ) return ((SpanishNumeralsVisitor<? extends T>)visitor).visitNumeralExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumeralExpressionContext numeralExpression() throws RecognitionException {
		NumeralExpressionContext _localctx = new NumeralExpressionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_numeralExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			switch (_input.LA(1)) {
			case T__0:
				{
				setState(20);
				r0();
				}
				break;
			case T__1:
			case T__2:
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__14:
			case T__15:
			case T__16:
			case T__17:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__29:
				{
				setState(21);
				r1();
				}
				break;
			case T__41:
			case T__42:
			case T__43:
			case T__44:
			case T__45:
			case T__46:
			case T__47:
				{
				setState(22);
				r2();
				}
				break;
			case T__31:
				{
				setState(23);
				r3();
				}
				break;
			case T__32:
				{
				setState(24);
				r4();
				}
				break;
			case T__33:
			case T__34:
			case T__35:
			case T__36:
			case T__37:
			case T__38:
			case T__39:
			case T__40:
				{
				setState(25);
				r5();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class R0Context extends ParserRuleContext {
		public R0Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_r0; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpanishNumeralsVisitor ) return ((SpanishNumeralsVisitor<? extends T>)visitor).visitR0(this);
			else return visitor.visitChildren(this);
		}
	}

	public final R0Context r0() throws RecognitionException {
		R0Context _localctx = new R0Context(_ctx, getState());
		enterRule(_localctx, 2, RULE_r0);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(28);
			match(T__0);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class R1Context extends ParserRuleContext {
		public R1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_r1; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpanishNumeralsVisitor ) return ((SpanishNumeralsVisitor<? extends T>)visitor).visitR1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final R1Context r1() throws RecognitionException {
		R1Context _localctx = new R1Context(_ctx, getState());
		enterRule(_localctx, 4, RULE_r1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class R2Context extends ParserRuleContext {
		public TensContext tens() {
			return getRuleContext(TensContext.class,0);
		}
		public UnitsContext units() {
			return getRuleContext(UnitsContext.class,0);
		}
		public List<TerminalNode> WHITESPACES() { return getTokens(SpanishNumeralsParser.WHITESPACES); }
		public TerminalNode WHITESPACES(int i) {
			return getToken(SpanishNumeralsParser.WHITESPACES, i);
		}
		public R2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_r2; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpanishNumeralsVisitor ) return ((SpanishNumeralsVisitor<? extends T>)visitor).visitR2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final R2Context r2() throws RecognitionException {
		R2Context _localctx = new R2Context(_ctx, getState());
		enterRule(_localctx, 6, RULE_r2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			{
			setState(32);
			tens();
			}
			setState(38);
			_la = _input.LA(1);
			if (_la==WHITESPACES) {
				{
				{
				{
				setState(33);
				match(WHITESPACES);
				}
				setState(34);
				match(T__30);
				{
				setState(35);
				match(WHITESPACES);
				}
				}
				{
				setState(37);
				units();
				}
				}
			}

			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class R3Context extends ParserRuleContext {
		public R3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_r3; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpanishNumeralsVisitor ) return ((SpanishNumeralsVisitor<? extends T>)visitor).visitR3(this);
			else return visitor.visitChildren(this);
		}
	}

	public final R3Context r3() throws RecognitionException {
		R3Context _localctx = new R3Context(_ctx, getState());
		enterRule(_localctx, 8, RULE_r3);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(40);
			match(T__31);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class R4Context extends ParserRuleContext {
		public TerminalNode WHITESPACES() { return getToken(SpanishNumeralsParser.WHITESPACES, 0); }
		public R1Context r1() {
			return getRuleContext(R1Context.class,0);
		}
		public R2Context r2() {
			return getRuleContext(R2Context.class,0);
		}
		public R4Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_r4; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpanishNumeralsVisitor ) return ((SpanishNumeralsVisitor<? extends T>)visitor).visitR4(this);
			else return visitor.visitChildren(this);
		}
	}

	public final R4Context r4() throws RecognitionException {
		R4Context _localctx = new R4Context(_ctx, getState());
		enterRule(_localctx, 10, RULE_r4);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			{
			setState(42);
			match(T__32);
			}
			{
			{
			setState(43);
			match(WHITESPACES);
			}
			setState(46);
			switch (_input.LA(1)) {
			case T__1:
			case T__2:
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__14:
			case T__15:
			case T__16:
			case T__17:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__29:
				{
				setState(44);
				r1();
				}
				break;
			case T__41:
			case T__42:
			case T__43:
			case T__44:
			case T__45:
			case T__46:
			case T__47:
				{
				setState(45);
				r2();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class R5Context extends ParserRuleContext {
		public HundredsContext hundreds() {
			return getRuleContext(HundredsContext.class,0);
		}
		public TerminalNode WHITESPACES() { return getToken(SpanishNumeralsParser.WHITESPACES, 0); }
		public R1Context r1() {
			return getRuleContext(R1Context.class,0);
		}
		public R2Context r2() {
			return getRuleContext(R2Context.class,0);
		}
		public R5Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_r5; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpanishNumeralsVisitor ) return ((SpanishNumeralsVisitor<? extends T>)visitor).visitR5(this);
			else return visitor.visitChildren(this);
		}
	}

	public final R5Context r5() throws RecognitionException {
		R5Context _localctx = new R5Context(_ctx, getState());
		enterRule(_localctx, 12, RULE_r5);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			{
			setState(48);
			hundreds();
			}
			setState(54);
			_la = _input.LA(1);
			if (_la==WHITESPACES) {
				{
				{
				setState(49);
				match(WHITESPACES);
				}
				setState(52);
				switch (_input.LA(1)) {
				case T__1:
				case T__2:
				case T__3:
				case T__4:
				case T__5:
				case T__6:
				case T__7:
				case T__8:
				case T__9:
				case T__10:
				case T__11:
				case T__12:
				case T__13:
				case T__14:
				case T__15:
				case T__16:
				case T__17:
				case T__18:
				case T__19:
				case T__20:
				case T__21:
				case T__22:
				case T__23:
				case T__24:
				case T__25:
				case T__26:
				case T__27:
				case T__28:
				case T__29:
					{
					setState(50);
					r1();
					}
					break;
				case T__41:
				case T__42:
				case T__43:
				case T__44:
				case T__45:
				case T__46:
				case T__47:
					{
					setState(51);
					r2();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
			}

			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HundredsContext extends ParserRuleContext {
		public HundredsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hundreds; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpanishNumeralsVisitor ) return ((SpanishNumeralsVisitor<? extends T>)visitor).visitHundreds(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HundredsContext hundreds() throws RecognitionException {
		HundredsContext _localctx = new HundredsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_hundreds);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TensContext extends ParserRuleContext {
		public TensContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tens; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpanishNumeralsVisitor ) return ((SpanishNumeralsVisitor<? extends T>)visitor).visitTens(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TensContext tens() throws RecognitionException {
		TensContext _localctx = new TensContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_tens);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnitsContext extends ParserRuleContext {
		public UnitsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_units; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpanishNumeralsVisitor ) return ((SpanishNumeralsVisitor<? extends T>)visitor).visitUnits(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnitsContext units() throws RecognitionException {
		UnitsContext _localctx = new UnitsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_units);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\63A\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\5\2\35\n\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\5\5)\n\5\3\6\3\6\3\7\3\7\3\7\3\7\5\7\61\n\7\3\b\3\b\3\b\3\b\5\b\67"+
		"\n\b\5\b9\n\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\2\2\f\2\4\6\b\n\f\16\20\22"+
		"\24\2\6\3\2\4 \3\2$+\3\2,\62\3\2\4\f?\2\34\3\2\2\2\4\36\3\2\2\2\6 \3\2"+
		"\2\2\b\"\3\2\2\2\n*\3\2\2\2\f,\3\2\2\2\16\62\3\2\2\2\20:\3\2\2\2\22<\3"+
		"\2\2\2\24>\3\2\2\2\26\35\5\4\3\2\27\35\5\6\4\2\30\35\5\b\5\2\31\35\5\n"+
		"\6\2\32\35\5\f\7\2\33\35\5\16\b\2\34\26\3\2\2\2\34\27\3\2\2\2\34\30\3"+
		"\2\2\2\34\31\3\2\2\2\34\32\3\2\2\2\34\33\3\2\2\2\35\3\3\2\2\2\36\37\7"+
		"\3\2\2\37\5\3\2\2\2 !\t\2\2\2!\7\3\2\2\2\"(\5\22\n\2#$\7\63\2\2$%\7!\2"+
		"\2%&\7\63\2\2&\'\3\2\2\2\')\5\24\13\2(#\3\2\2\2()\3\2\2\2)\t\3\2\2\2*"+
		"+\7\"\2\2+\13\3\2\2\2,-\7#\2\2-\60\7\63\2\2.\61\5\6\4\2/\61\5\b\5\2\60"+
		".\3\2\2\2\60/\3\2\2\2\61\r\3\2\2\2\628\5\20\t\2\63\66\7\63\2\2\64\67\5"+
		"\6\4\2\65\67\5\b\5\2\66\64\3\2\2\2\66\65\3\2\2\2\679\3\2\2\28\63\3\2\2"+
		"\289\3\2\2\29\17\3\2\2\2:;\t\3\2\2;\21\3\2\2\2<=\t\4\2\2=\23\3\2\2\2>"+
		"?\t\5\2\2?\25\3\2\2\2\7\34(\60\668";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}