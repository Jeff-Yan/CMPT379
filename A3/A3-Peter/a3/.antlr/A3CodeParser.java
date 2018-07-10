// Generated from /Users/i852960/Documents/SFU/379/a3/A3Code.g4 by ANTLR 4.7

import java.io.*;
import java.util.Arrays;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class A3CodeParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, WhiteSpace=20, Char=21, Str=22, Class=23, Program=24, 
		Void=25, If=26, Else=27, For=28, Ret=29, Brk=30, Cnt=31, Callout=32, DecNum=33, 
		HexNum=34, BoolLit=35, RelOp=36, AssignOp=37, ArithOp=38, CondOp=39, Type=40, 
		Ident=41;
	public static final int
		RULE_prog = 0, RULE_field_decls = 1, RULE_field_decl = 2, RULE_inited_field_decl = 3, 
		RULE_method_decls = 4, RULE_method_decl = 5, RULE_params = 6, RULE_nextParams = 7, 
		RULE_block = 8, RULE_var_decls = 9, RULE_var_decl = 10, RULE_statements = 11, 
		RULE_controlFlowStmtList = 12, RULE_controlFlowStmt = 13, RULE_forRangeStmt = 14, 
		RULE_statement = 15, RULE_bExprTerm = 16, RULE_marker = 17, RULE_nextLbl = 18, 
		RULE_funcMarker = 19, RULE_booleanExpr = 20, RULE_method_name = 21, RULE_expr_params = 22, 
		RULE_callout_args = 23, RULE_callout_arg = 24, RULE_method_call = 25, 
		RULE_expr = 26, RULE_term = 27, RULE_location = 28, RULE_num = 29, RULE_literal = 30, 
		RULE_eqOp = 31, RULE_boolOp = 32, RULE_binOp = 33;
	public static final String[] ruleNames = {
		"prog", "field_decls", "field_decl", "inited_field_decl", "method_decls", 
		"method_decl", "params", "nextParams", "block", "var_decls", "var_decl", 
		"statements", "controlFlowStmtList", "controlFlowStmt", "forRangeStmt", 
		"statement", "bExprTerm", "marker", "nextLbl", "funcMarker", "booleanExpr", 
		"method_name", "expr_params", "callout_args", "callout_arg", "method_call", 
		"expr", "term", "location", "num", "literal", "eqOp", "boolOp", "binOp"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'{'", "'}'", "';'", "','", "'['", "']'", "'='", "'('", "')'", "'+='", 
		"'-='", "'+'", "'-'", "'!'", "'&&'", "'||'", "'true'", "'false'", "'%'", 
		null, null, null, "'class'", "'Program'", "'void'", "'if'", "'else'", 
		"'for'", "'return'", "'break'", "'continue'", "'callout'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, "WhiteSpace", "Char", 
		"Str", "Class", "Program", "Void", "If", "Else", "For", "Ret", "Brk", 
		"Cnt", "Callout", "DecNum", "HexNum", "BoolLit", "RelOp", "AssignOp", 
		"ArithOp", "CondOp", "Type", "Ident"
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
	public String getGrammarFileName() { return "A3Code.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }



	public enum DataType {
		INT, BOOLEAN, INVALID , STRING
	}


	public class Symbol {
		
		String name;
		DataType dt;

		Symbol (String n, DataType d) {
			name = n;
			dt = d;
		}

		Symbol (int id, DataType d) {
			name = "t_" + id;
			dt = d;
		}

		boolean Equal (String n) {
			return (name.equals(n));
		}

		DataType GetType () {
			return dt;
		}

		String GetName () {
			return name;
		}

		void Print() {
			System.out.println(name + "\t" + dt);
		}

		
		
	}

	public class SymTab {
		
		Symbol st[];
		int size;
		int temps;

		SymTab () {
			st = new Symbol[1000];
			size = 0;
			temps = 0;
		}

		int Find (String n) {
			for (int  i = 0; i < size; i ++) {
				if (st[i].Equal(n)) return i;
			}
			
			return -1;
		}

		int insert(String n, DataType d) {
			int id = Find(n);
			if (id != -1) return id;
		
			st[size] = new Symbol(n, d);
			return (size ++);
		}

		int Add (DataType d) {
			st [size] = new Symbol (temps, d);
			temps ++;
			return (size ++);
		}

		DataType GetType (int id) {
			if (id == -1) return DataType.INVALID;
			return (st[id].GetType());
		}

		String GetName (int id) {
			if (id == -1) return ("");
			return (st[id].GetName()); 
		}

		void Print() {
			for (int  i = 0; i < size; i ++) {
				st[i].Print();
			}
		}

		

	}

	SymTab s = new SymTab();



	public class Quad {

		int label;
		String op;
		int src1;
		int src2;
		int dst;


		Quad (int l, int d, int s1, int s2, String o) {
			label = l;
			dst = d;
			src1 = s1;
			src2 = s2;
			op = o;
		}

		void Print () {

			if (op.startsWith("if")) {
				System.out.println("L_" + label + ": " +op + " " + s.GetName(src1) + " goto L_" + dst);
			}
			else if (op.equals("goto")) {
				System.out.println("L_" + label + ": goto L_" + dst);
			}
			else if (op.equals("extra_line")) {
				System.out.println("L_" + label + ": ");
			}
			else if (op.equals("func_name")) {
				System.out.println(s.GetName(dst) + ": ");
			}
			else if (dst == -1) {
				System.out.println("L_" + label + ": " + s.GetName(src1) + " " + op + " " + s.GetName(src2));	
			}
			else {
				System.out.println("L_" + label + ": " + s.GetName(dst) + " = " 
						+ s.GetName(src1) + " " + op + " " + s.GetName(src2));
			}
		}

	}

	public class QuadTab {

		Quad qt[];
		int size;

		QuadTab () {
			qt = new Quad[1000];
			size = 0;
		}


		int Add(int dst, int src1, int src2, String op) {
				
			qt[size] = new Quad(size, dst, src1, src2, op);
			return (size ++);
		}

		void Print() {
			for (int  i = 0; i < size; i ++) {
				qt[i].Print();
			}
		}


	}

	QuadTab q = new QuadTab();

	boolean printEmptyLine = false;


	void backpatch(List<Integer> listToPatch, int label) {
		// empty list -> no patching is needed
		if (listToPatch == null) {
			return;
		}

		for (int line : listToPatch) {
			q.qt[line].dst = label;
		}
	}

	List<Integer> merge(List<Integer> l1, List<Integer> l2) {
		if (l1 == null && l2 == null) {
			return new ArrayList<>();
		}

		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		} else {
			List<Integer> result = new ArrayList<>();
			result.addAll(l1);
			result.addAll(l2);
			return result;
		}
	}


	public A3CodeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public TerminalNode Class() { return getToken(A3CodeParser.Class, 0); }
		public TerminalNode Program() { return getToken(A3CodeParser.Program, 0); }
		public Field_declsContext field_decls() {
			return getRuleContext(Field_declsContext.class,0);
		}
		public Method_declsContext method_decls() {
			return getRuleContext(Method_declsContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(Class);
			setState(69);
			match(Program);
			setState(70);
			match(T__0);
			setState(71);
			field_decls(0);
			setState(72);
			method_decls(0);
			setState(73);
			match(T__1);

				if (printEmptyLine) {
					q.Add(-1, -1, -1,"extra_line");
				}

				// s.Print();
				// System.out.println("------------------------------------");
				q.Print();

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

	public static class Field_declsContext extends ParserRuleContext {
		public Field_declsContext f;
		public Field_declContext field_decl() {
			return getRuleContext(Field_declContext.class,0);
		}
		public Field_declsContext field_decls() {
			return getRuleContext(Field_declsContext.class,0);
		}
		public Inited_field_declContext inited_field_decl() {
			return getRuleContext(Inited_field_declContext.class,0);
		}
		public Field_declsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_decls; }
	}

	public final Field_declsContext field_decls() throws RecognitionException {
		return field_decls(0);
	}

	private Field_declsContext field_decls(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Field_declsContext _localctx = new Field_declsContext(_ctx, _parentState);
		Field_declsContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_field_decls, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			}
			_ctx.stop = _input.LT(-1);
			setState(87);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(85);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
					case 1:
						{
						_localctx = new Field_declsContext(_parentctx, _parentState);
						_localctx.f = _prevctx;
						_localctx.f = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_field_decls);
						setState(77);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(78);
						field_decl(0);
						setState(79);
						match(T__2);
						}
						break;
					case 2:
						{
						_localctx = new Field_declsContext(_parentctx, _parentState);
						_localctx.f = _prevctx;
						_localctx.f = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_field_decls);
						setState(81);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(82);
						inited_field_decl();
						setState(83);
						match(T__2);
						}
						break;
					}
					} 
				}
				setState(89);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Field_declContext extends ParserRuleContext {
		public DataType t;
		public Field_declContext f;
		public Token Type;
		public Token Ident;
		public TerminalNode Type() { return getToken(A3CodeParser.Type, 0); }
		public TerminalNode Ident() { return getToken(A3CodeParser.Ident, 0); }
		public NumContext num() {
			return getRuleContext(NumContext.class,0);
		}
		public Field_declContext field_decl() {
			return getRuleContext(Field_declContext.class,0);
		}
		public Field_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_decl; }
	}

	public final Field_declContext field_decl() throws RecognitionException {
		return field_decl(0);
	}

	private Field_declContext field_decl(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Field_declContext _localctx = new Field_declContext(_ctx, _parentState);
		Field_declContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_field_decl, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(91);
				((Field_declContext)_localctx).Type = match(Type);
				setState(92);
				((Field_declContext)_localctx).Ident = match(Ident);

					((Field_declContext)_localctx).t =  DataType.valueOf((((Field_declContext)_localctx).Type!=null?((Field_declContext)_localctx).Type.getText():null).toUpperCase());
					s.insert((((Field_declContext)_localctx).Ident!=null?((Field_declContext)_localctx).Ident.getText():null), _localctx.t);					

				}
				break;
			case 2:
				{
				setState(94);
				((Field_declContext)_localctx).Type = match(Type);
				setState(95);
				((Field_declContext)_localctx).Ident = match(Ident);
				setState(96);
				match(T__4);
				setState(97);
				num();
				setState(98);
				match(T__5);

					((Field_declContext)_localctx).t =  DataType.valueOf((((Field_declContext)_localctx).Type!=null?((Field_declContext)_localctx).Type.getText():null).toUpperCase());
					s.insert((((Field_declContext)_localctx).Ident!=null?((Field_declContext)_localctx).Ident.getText():null), _localctx.t);	

				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(117);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(115);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new Field_declContext(_parentctx, _parentState);
						_localctx.f = _prevctx;
						_localctx.f = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_field_decl);
						setState(103);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(104);
						match(T__3);
						setState(105);
						((Field_declContext)_localctx).Ident = match(Ident);

						          	((Field_declContext)_localctx).t =  ((Field_declContext)_localctx).f.t;
						          	s.insert((((Field_declContext)_localctx).Ident!=null?((Field_declContext)_localctx).Ident.getText():null), _localctx.t);
						          
						}
						break;
					case 2:
						{
						_localctx = new Field_declContext(_parentctx, _parentState);
						_localctx.f = _prevctx;
						_localctx.f = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_field_decl);
						setState(107);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(108);
						match(T__3);
						setState(109);
						((Field_declContext)_localctx).Ident = match(Ident);
						setState(110);
						match(T__4);
						setState(111);
						num();
						setState(112);
						match(T__5);

						          	((Field_declContext)_localctx).t =  ((Field_declContext)_localctx).f.t;
						          	s.insert((((Field_declContext)_localctx).Ident!=null?((Field_declContext)_localctx).Ident.getText():null), _localctx.t);
						          
						}
						break;
					}
					} 
				}
				setState(119);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Inited_field_declContext extends ParserRuleContext {
		public DataType t;
		public Token Type;
		public Token Ident;
		public LiteralContext literal;
		public TerminalNode Type() { return getToken(A3CodeParser.Type, 0); }
		public TerminalNode Ident() { return getToken(A3CodeParser.Ident, 0); }
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public Inited_field_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inited_field_decl; }
	}

	public final Inited_field_declContext inited_field_decl() throws RecognitionException {
		Inited_field_declContext _localctx = new Inited_field_declContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_inited_field_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			((Inited_field_declContext)_localctx).Type = match(Type);
			setState(121);
			((Inited_field_declContext)_localctx).Ident = match(Ident);
			setState(122);
			match(T__6);
			setState(123);
			((Inited_field_declContext)_localctx).literal = literal();

				((Inited_field_declContext)_localctx).t =  DataType.valueOf((((Inited_field_declContext)_localctx).Type!=null?((Inited_field_declContext)_localctx).Type.getText():null).toUpperCase());
				int id = s.insert((((Inited_field_declContext)_localctx).Ident!=null?((Inited_field_declContext)_localctx).Ident.getText():null), _localctx.t);
			    q.Add(id, ((Inited_field_declContext)_localctx).literal.id, -1, "");

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

	public static class Method_declsContext extends ParserRuleContext {
		public Method_declsContext m;
		public Method_declContext method_decl() {
			return getRuleContext(Method_declContext.class,0);
		}
		public Method_declsContext method_decls() {
			return getRuleContext(Method_declsContext.class,0);
		}
		public Method_declsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_decls; }
	}

	public final Method_declsContext method_decls() throws RecognitionException {
		return method_decls(0);
	}

	private Method_declsContext method_decls(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Method_declsContext _localctx = new Method_declsContext(_ctx, _parentState);
		Method_declsContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_method_decls, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			}
			_ctx.stop = _input.LT(-1);
			setState(131);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Method_declsContext(_parentctx, _parentState);
					_localctx.m = _prevctx;
					_localctx.m = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_method_decls);
					setState(127);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(128);
					method_decl();
					}
					} 
				}
				setState(133);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Method_declContext extends ParserRuleContext {
		public Token Type;
		public Token Ident;
		public FuncMarkerContext funcMarker;
		public TerminalNode Type() { return getToken(A3CodeParser.Type, 0); }
		public TerminalNode Ident() { return getToken(A3CodeParser.Ident, 0); }
		public FuncMarkerContext funcMarker() {
			return getRuleContext(FuncMarkerContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode Void() { return getToken(A3CodeParser.Void, 0); }
		public Method_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_decl; }
	}

	public final Method_declContext method_decl() throws RecognitionException {
		Method_declContext _localctx = new Method_declContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_method_decl);
		try {
			setState(152);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Type:
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				((Method_declContext)_localctx).Type = match(Type);
				setState(135);
				((Method_declContext)_localctx).Ident = match(Ident);
				setState(136);
				((Method_declContext)_localctx).funcMarker = funcMarker();
				setState(137);
				match(T__7);
				setState(138);
				params();
				setState(139);
				match(T__8);
				setState(140);
				block();

					int funcId = s.insert((((Method_declContext)_localctx).Ident!=null?((Method_declContext)_localctx).Ident.getText():null), DataType.valueOf((((Method_declContext)_localctx).Type!=null?((Method_declContext)_localctx).Type.getText():null).toUpperCase()));
					
					// Backpatch the function name back to the instruction
					q.qt[((Method_declContext)_localctx).funcMarker.label].dst = funcId;

				}
				break;
			case Void:
				enterOuterAlt(_localctx, 2);
				{
				setState(143);
				match(Void);
				setState(144);
				((Method_declContext)_localctx).Ident = match(Ident);
				setState(145);
				((Method_declContext)_localctx).funcMarker = funcMarker();
				setState(146);
				match(T__7);
				setState(147);
				params();
				setState(148);
				match(T__8);
				setState(149);
				block();

				    int funcId = s.insert((((Method_declContext)_localctx).Ident!=null?((Method_declContext)_localctx).Ident.getText():null), DataType.INVALID);

					// Backpatch the function name back to the instruction
					q.qt[((Method_declContext)_localctx).funcMarker.label].dst = funcId;

					q.Add(-1, -1, -1, "ret");

				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ParamsContext extends ParserRuleContext {
		public Token Type;
		public Token Ident;
		public TerminalNode Type() { return getToken(A3CodeParser.Type, 0); }
		public TerminalNode Ident() { return getToken(A3CodeParser.Ident, 0); }
		public NextParamsContext nextParams() {
			return getRuleContext(NextParamsContext.class,0);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_params);
		try {
			setState(160);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Type:
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				((ParamsContext)_localctx).Type = match(Type);
				setState(155);
				((ParamsContext)_localctx).Ident = match(Ident);
				setState(156);
				nextParams(0);

					DataType t = DataType.valueOf((((ParamsContext)_localctx).Type!=null?((ParamsContext)_localctx).Type.getText():null).toUpperCase());
					int id = s.insert((((ParamsContext)_localctx).Ident!=null?((ParamsContext)_localctx).Ident.getText():null), t);

				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class NextParamsContext extends ParserRuleContext {
		public NextParamsContext n;
		public Token Type;
		public Token Ident;
		public TerminalNode Type() { return getToken(A3CodeParser.Type, 0); }
		public TerminalNode Ident() { return getToken(A3CodeParser.Ident, 0); }
		public NextParamsContext nextParams() {
			return getRuleContext(NextParamsContext.class,0);
		}
		public NextParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nextParams; }
	}

	public final NextParamsContext nextParams() throws RecognitionException {
		return nextParams(0);
	}

	private NextParamsContext nextParams(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		NextParamsContext _localctx = new NextParamsContext(_ctx, _parentState);
		NextParamsContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_nextParams, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			}
			_ctx.stop = _input.LT(-1);
			setState(170);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new NextParamsContext(_parentctx, _parentState);
					_localctx.n = _prevctx;
					_localctx.n = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_nextParams);
					setState(163);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(164);
					match(T__3);
					setState(165);
					((NextParamsContext)_localctx).Type = match(Type);
					setState(166);
					((NextParamsContext)_localctx).Ident = match(Ident);

					          	DataType t = DataType.valueOf((((NextParamsContext)_localctx).Type!=null?((NextParamsContext)_localctx).Type.getText():null).toUpperCase());
					          	int id = s.insert((((NextParamsContext)_localctx).Ident!=null?((NextParamsContext)_localctx).Ident.getText():null), t);
					          
					}
					} 
				}
				setState(172);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public Var_declsContext var_decls() {
			return getRuleContext(Var_declsContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(T__0);
			setState(174);
			var_decls(0);
			setState(175);
			statements();
			setState(176);
			match(T__1);
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

	public static class Var_declsContext extends ParserRuleContext {
		public Var_declsContext v;
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public Var_declsContext var_decls() {
			return getRuleContext(Var_declsContext.class,0);
		}
		public Var_declsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decls; }
	}

	public final Var_declsContext var_decls() throws RecognitionException {
		return var_decls(0);
	}

	private Var_declsContext var_decls(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Var_declsContext _localctx = new Var_declsContext(_ctx, _parentState);
		Var_declsContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_var_decls, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			}
			_ctx.stop = _input.LT(-1);
			setState(185);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Var_declsContext(_parentctx, _parentState);
					_localctx.v = _prevctx;
					_localctx.v = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_var_decls);
					setState(179);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(180);
					var_decl(0);
					setState(181);
					match(T__2);
					}
					} 
				}
				setState(187);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Var_declContext extends ParserRuleContext {
		public DataType t;
		public Var_declContext v;
		public Token Type;
		public Token Ident;
		public TerminalNode Type() { return getToken(A3CodeParser.Type, 0); }
		public TerminalNode Ident() { return getToken(A3CodeParser.Ident, 0); }
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public Var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl; }
	}

	public final Var_declContext var_decl() throws RecognitionException {
		return var_decl(0);
	}

	private Var_declContext var_decl(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Var_declContext _localctx = new Var_declContext(_ctx, _parentState);
		Var_declContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_var_decl, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(189);
			((Var_declContext)_localctx).Type = match(Type);
			setState(190);
			((Var_declContext)_localctx).Ident = match(Ident);

				((Var_declContext)_localctx).t =  DataType.valueOf((((Var_declContext)_localctx).Type!=null?((Var_declContext)_localctx).Type.getText():null).toUpperCase());
				s.insert((((Var_declContext)_localctx).Ident!=null?((Var_declContext)_localctx).Ident.getText():null), _localctx.t);

			}
			_ctx.stop = _input.LT(-1);
			setState(199);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Var_declContext(_parentctx, _parentState);
					_localctx.v = _prevctx;
					_localctx.v = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_var_decl);
					setState(193);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(194);
					match(T__3);
					setState(195);
					((Var_declContext)_localctx).Ident = match(Ident);

					          	((Var_declContext)_localctx).t =  ((Var_declContext)_localctx).v.t;
					          	s.insert((((Var_declContext)_localctx).Ident!=null?((Var_declContext)_localctx).Ident.getText():null), _localctx.t);
					          
					}
					} 
				}
				setState(201);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class StatementsContext extends ParserRuleContext {
		public StatementsContext t;
		public ControlFlowStmtContext controlFlowStmt;
		public MarkerContext marker;
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public ControlFlowStmtContext controlFlowStmt() {
			return getRuleContext(ControlFlowStmtContext.class,0);
		}
		public MarkerContext marker() {
			return getRuleContext(MarkerContext.class,0);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_statements);
		try {
			setState(211);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(202);
				statement();
				setState(203);
				((StatementsContext)_localctx).t = statements();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(205);
				((StatementsContext)_localctx).controlFlowStmt = controlFlowStmt();
				setState(206);
				((StatementsContext)_localctx).marker = marker();
				setState(207);
				statements();

					if (((StatementsContext)_localctx).controlFlowStmt.nextlist != null && ! ((StatementsContext)_localctx).controlFlowStmt.nextlist.isEmpty()) {
						printEmptyLine = true;
					}
					backpatch(((StatementsContext)_localctx).controlFlowStmt.nextlist, ((StatementsContext)_localctx).marker.label);

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
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

	public static class ControlFlowStmtListContext extends ParserRuleContext {
		public List<Integer> nextlist;
		public ControlFlowStmtListContext l1;
		public ControlFlowStmtContext controlFlowStmt;
		public MarkerContext marker;
		public ControlFlowStmtContext controlFlowStmt() {
			return getRuleContext(ControlFlowStmtContext.class,0);
		}
		public MarkerContext marker() {
			return getRuleContext(MarkerContext.class,0);
		}
		public ControlFlowStmtListContext controlFlowStmtList() {
			return getRuleContext(ControlFlowStmtListContext.class,0);
		}
		public ControlFlowStmtListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_controlFlowStmtList; }
	}

	public final ControlFlowStmtListContext controlFlowStmtList() throws RecognitionException {
		return controlFlowStmtList(0);
	}

	private ControlFlowStmtListContext controlFlowStmtList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ControlFlowStmtListContext _localctx = new ControlFlowStmtListContext(_ctx, _parentState);
		ControlFlowStmtListContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_controlFlowStmtList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(214);
			((ControlFlowStmtListContext)_localctx).controlFlowStmt = controlFlowStmt();

				((ControlFlowStmtListContext)_localctx).nextlist =  ((ControlFlowStmtListContext)_localctx).controlFlowStmt.nextlist;

			}
			_ctx.stop = _input.LT(-1);
			setState(224);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ControlFlowStmtListContext(_parentctx, _parentState);
					_localctx.l1 = _prevctx;
					_localctx.l1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_controlFlowStmtList);
					setState(217);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(218);
					((ControlFlowStmtListContext)_localctx).marker = marker();
					setState(219);
					((ControlFlowStmtListContext)_localctx).controlFlowStmt = controlFlowStmt();

					          	// Cannot backpatch continue and break statements here, so propagate up.
					          	List<Integer> contBreakList = new ArrayList<>();
					          	if (((ControlFlowStmtListContext)_localctx).l1.nextlist != null) {
					          		for (int line : ((ControlFlowStmtListContext)_localctx).l1.nextlist) {
					          			if (line < 0)
					          				contBreakList.add(line);
					          		}

					          		((ControlFlowStmtListContext)_localctx).l1.nextlist.removeAll(contBreakList);
					          	}

					          	backpatch(((ControlFlowStmtListContext)_localctx).l1.nextlist, ((ControlFlowStmtListContext)_localctx).marker.label);
					          	((ControlFlowStmtListContext)_localctx).nextlist =  merge(((ControlFlowStmtListContext)_localctx).controlFlowStmt.nextlist, contBreakList);

					          
					}
					} 
				}
				setState(226);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ControlFlowStmtContext extends ParserRuleContext {
		public List<Integer> nextlist;
		public ControlFlowStmtListContext controlFlowStmtList;
		public BooleanExprContext booleanExpr;
		public MarkerContext marker;
		public ControlFlowStmtContext s;
		public MarkerContext m1;
		public ControlFlowStmtContext s1;
		public NextLblContext nextLbl;
		public MarkerContext m2;
		public ControlFlowStmtContext s2;
		public ForRangeStmtContext forRangeStmt;
		public ControlFlowStmtListContext controlFlowStmtList() {
			return getRuleContext(ControlFlowStmtListContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode Brk() { return getToken(A3CodeParser.Brk, 0); }
		public TerminalNode Cnt() { return getToken(A3CodeParser.Cnt, 0); }
		public TerminalNode If() { return getToken(A3CodeParser.If, 0); }
		public BooleanExprContext booleanExpr() {
			return getRuleContext(BooleanExprContext.class,0);
		}
		public List<MarkerContext> marker() {
			return getRuleContexts(MarkerContext.class);
		}
		public MarkerContext marker(int i) {
			return getRuleContext(MarkerContext.class,i);
		}
		public List<ControlFlowStmtContext> controlFlowStmt() {
			return getRuleContexts(ControlFlowStmtContext.class);
		}
		public ControlFlowStmtContext controlFlowStmt(int i) {
			return getRuleContext(ControlFlowStmtContext.class,i);
		}
		public NextLblContext nextLbl() {
			return getRuleContext(NextLblContext.class,0);
		}
		public TerminalNode Else() { return getToken(A3CodeParser.Else, 0); }
		public TerminalNode For() { return getToken(A3CodeParser.For, 0); }
		public ForRangeStmtContext forRangeStmt() {
			return getRuleContext(ForRangeStmtContext.class,0);
		}
		public ControlFlowStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_controlFlowStmt; }
	}

	public final ControlFlowStmtContext controlFlowStmt() throws RecognitionException {
		ControlFlowStmtContext _localctx = new ControlFlowStmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_controlFlowStmt);
		try {
			setState(267);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(227);
				match(T__0);
				setState(228);
				((ControlFlowStmtContext)_localctx).controlFlowStmtList = controlFlowStmtList(0);
				setState(229);
				match(T__1);

					((ControlFlowStmtContext)_localctx).nextlist =  ((ControlFlowStmtContext)_localctx).controlFlowStmtList.nextlist;

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(232);
				statement();

					((ControlFlowStmtContext)_localctx).nextlist =  null;

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(235);
				match(Brk);
				setState(236);
				match(T__2);

					// instId for break will always lower than -5000 as a special pattern to recognize
					int instId = - (q.size + 5000);
					((ControlFlowStmtContext)_localctx).nextlist =  Arrays.asList(instId);
					q.Add(-1, -1, -1, "goto");

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(238);
				match(Cnt);
				setState(239);
				match(T__2);

					// instId for break will always lower than -6000 as a special pattern to recognize
					int instId = - (q.size + 6000);
					((ControlFlowStmtContext)_localctx).nextlist =  Arrays.asList(instId);
					q.Add(-1, -1, -1, "goto");

				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(241);
				match(If);
				setState(242);
				match(T__7);
				setState(243);
				((ControlFlowStmtContext)_localctx).booleanExpr = booleanExpr(0);
				setState(244);
				match(T__8);
				setState(245);
				((ControlFlowStmtContext)_localctx).marker = marker();
				setState(246);
				((ControlFlowStmtContext)_localctx).s = controlFlowStmt();

					backpatch(((ControlFlowStmtContext)_localctx).booleanExpr.truelist, ((ControlFlowStmtContext)_localctx).marker.label);
					((ControlFlowStmtContext)_localctx).nextlist =  merge(((ControlFlowStmtContext)_localctx).booleanExpr.falselist, ((ControlFlowStmtContext)_localctx).s.nextlist);

				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(249);
				match(If);
				setState(250);
				match(T__7);
				setState(251);
				((ControlFlowStmtContext)_localctx).booleanExpr = booleanExpr(0);
				setState(252);
				match(T__8);
				setState(253);
				((ControlFlowStmtContext)_localctx).m1 = marker();
				setState(254);
				((ControlFlowStmtContext)_localctx).s1 = controlFlowStmt();
				setState(255);
				((ControlFlowStmtContext)_localctx).nextLbl = nextLbl();
				setState(256);
				match(Else);
				setState(257);
				((ControlFlowStmtContext)_localctx).m2 = marker();
				setState(258);
				((ControlFlowStmtContext)_localctx).s2 = controlFlowStmt();

					backpatch(((ControlFlowStmtContext)_localctx).booleanExpr.truelist, ((ControlFlowStmtContext)_localctx).m1.label);
					backpatch(((ControlFlowStmtContext)_localctx).booleanExpr.falselist, ((ControlFlowStmtContext)_localctx).m2.label);

					// Merging 3 lists
					((ControlFlowStmtContext)_localctx).nextlist =  merge( merge(((ControlFlowStmtContext)_localctx).s1.nextlist, ((ControlFlowStmtContext)_localctx).s2.nextlist), ((ControlFlowStmtContext)_localctx).nextLbl.nextlist );

				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(261);
				match(For);
				setState(262);
				((ControlFlowStmtContext)_localctx).forRangeStmt = forRangeStmt();
				setState(263);
				((ControlFlowStmtContext)_localctx).marker = marker();
				setState(264);
				((ControlFlowStmtContext)_localctx).s = controlFlowStmt();

					backpatch(((ControlFlowStmtContext)_localctx).forRangeStmt.truelist, ((ControlFlowStmtContext)_localctx).marker.label);

					// Backpatch ((ControlFlowStmtContext)_localctx).s.nextlist for id > 0
					List<Integer> backpatchList = new ArrayList<>();
					if (((ControlFlowStmtContext)_localctx).s.nextlist != null) {
						for (int line : ((ControlFlowStmtContext)_localctx).s.nextlist) {
							if (line > 0) {
								backpatchList.add(line);
							}
						}
						backpatch(backpatchList, q.size);
						((ControlFlowStmtContext)_localctx).s.nextlist.removeAll(backpatchList);
					}


					((ControlFlowStmtContext)_localctx).nextlist =  merge(((ControlFlowStmtContext)_localctx).forRangeStmt.falselist, ((ControlFlowStmtContext)_localctx).s.nextlist);


					// Detect if there is "continue" statement to backpatch
					List<Integer> contList = new ArrayList<>();
					List<Integer> contList_originalNum = new ArrayList<>();
					for (int line : _localctx.nextlist) {
						if (line < -6000) {
							contList.add( - (line + 6000) );
							contList_originalNum.add(line);
						}
					}
					backpatch(contList, q.size);
					_localctx.nextlist.removeAll(contList_originalNum);


					// Generate increment instruction in for loop
					int oneId = s.Find("1");
					if (oneId == -1) {
						oneId = s.insert("1", DataType.INT);
					}
					q.Add(((ControlFlowStmtContext)_localctx).forRangeStmt.identId, ((ControlFlowStmtContext)_localctx).forRangeStmt.identId, oneId, "+");
					q.Add(((ControlFlowStmtContext)_localctx).forRangeStmt.loopBackToLabel, -1, -1, "goto");



					// Detect if there is "break" statement to backpatch
					List<Integer> breakList = new ArrayList<>();
					List<Integer> breakList_originalNum = new ArrayList<>();
					for (int line : _localctx.nextlist) {
						if (line < -5000) {
							breakList.add( - (line + 5000) );
							breakList_originalNum.add(line);
						}
					}
					backpatch(breakList, q.size);
					_localctx.nextlist.removeAll(breakList_originalNum);

				}
				break;
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

	public static class ForRangeStmtContext extends ParserRuleContext {
		public List<Integer> truelist;
		public List<Integer> falselist;
		public int loopBackToLabel;
		public int identId;
		public Token Ident;
		public ExprContext e1;
		public ExprContext e2;
		public TerminalNode Ident() { return getToken(A3CodeParser.Ident, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ForRangeStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forRangeStmt; }
	}

	public final ForRangeStmtContext forRangeStmt() throws RecognitionException {
		ForRangeStmtContext _localctx = new ForRangeStmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_forRangeStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			((ForRangeStmtContext)_localctx).Ident = match(Ident);
			setState(270);
			match(T__6);
			setState(271);
			((ForRangeStmtContext)_localctx).e1 = expr(0);
			setState(272);
			match(T__3);
			setState(273);
			((ForRangeStmtContext)_localctx).e2 = expr(0);

				((ForRangeStmtContext)_localctx).identId =  s.Find((((ForRangeStmtContext)_localctx).Ident!=null?((ForRangeStmtContext)_localctx).Ident.getText():null));

				// eg. x = a, b will have
				// x = a and temp = x < b
				q.Add(_localctx.identId, ((ForRangeStmtContext)_localctx).e1.id, -1, "");

				// Will need to loop back to here, right after Ident = expr
				((ForRangeStmtContext)_localctx).loopBackToLabel =  q.size;

				int comparisonResultId = s.Add(DataType.INT);
				q.Add(comparisonResultId, _localctx.identId, ((ForRangeStmtContext)_localctx).e2.id, "<");

				((ForRangeStmtContext)_localctx).truelist =  Arrays.asList(q.size);
				q.Add(-1, comparisonResultId, -1, "if");

				((ForRangeStmtContext)_localctx).falselist =  Arrays.asList(q.size);
				q.Add(-1, comparisonResultId, -1, "ifFalse");


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

	public static class StatementContext extends ParserRuleContext {
		public LocationContext location;
		public ExprContext expr;
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Method_callContext method_call() {
			return getRuleContext(Method_callContext.class,0);
		}
		public TerminalNode Ret() { return getToken(A3CodeParser.Ret, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_statement);
		try {
			setState(304);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(276);
				((StatementContext)_localctx).location = location();
				setState(277);
				match(T__6);
				setState(278);
				((StatementContext)_localctx).expr = expr(0);
				setState(279);
				match(T__2);

					q.Add(((StatementContext)_localctx).location.id, ((StatementContext)_localctx).expr.id, -1, "");

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(282);
				((StatementContext)_localctx).location = location();
				setState(283);
				match(T__9);
				setState(284);
				((StatementContext)_localctx).expr = expr(0);
				setState(285);
				match(T__2);

					q.Add(((StatementContext)_localctx).location.id, ((StatementContext)_localctx).location.id, ((StatementContext)_localctx).expr.id, "+");

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(288);
				((StatementContext)_localctx).location = location();
				setState(289);
				match(T__10);
				setState(290);
				((StatementContext)_localctx).expr = expr(0);
				setState(291);
				match(T__2);

					q.Add(((StatementContext)_localctx).location.id, ((StatementContext)_localctx).location.id, ((StatementContext)_localctx).expr.id, "-");

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(294);
				block();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(295);
				method_call();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(296);
				match(Ret);
				setState(297);
				((StatementContext)_localctx).expr = expr(0);
				setState(298);
				match(T__2);

					q.Add(-1, ((StatementContext)_localctx).expr.id, -1, "ret");

				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(301);
				match(Ret);
				setState(302);
				match(T__2);

					q.Add(-1, -1, -1, "ret");

				}
				break;
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

	public static class BExprTermContext extends ParserRuleContext {
		public int id;
		public TermContext term;
		public ExprContext e3;
		public TermContext t1;
		public ExprContext e4;
		public TermContext t2;
		public ExprContext inner_expr;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BExprTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bExprTerm; }
	}

	public final BExprTermContext bExprTerm() throws RecognitionException {
		BExprTermContext _localctx = new BExprTermContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_bExprTerm);
		try {
			setState(324);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(306);
				((BExprTermContext)_localctx).term = term(0);

					((BExprTermContext)_localctx).id =  ((BExprTermContext)_localctx).term.id;

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(309);
				((BExprTermContext)_localctx).e3 = expr(0);
				setState(310);
				match(T__11);
				setState(311);
				((BExprTermContext)_localctx).t1 = term(0);

					((BExprTermContext)_localctx).id =  s.Add(s.GetType(((BExprTermContext)_localctx).e3.id));
					q.Add(_localctx.id, ((BExprTermContext)_localctx).e3.id, ((BExprTermContext)_localctx).t1.id, "+");

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(314);
				((BExprTermContext)_localctx).e4 = expr(0);
				setState(315);
				match(T__12);
				setState(316);
				((BExprTermContext)_localctx).t2 = term(0);

					((BExprTermContext)_localctx).id =  s.Add(s.GetType(((BExprTermContext)_localctx).e4.id));
					q.Add(_localctx.id, ((BExprTermContext)_localctx).e4.id, ((BExprTermContext)_localctx).t2.id, "-");

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(319);
				match(T__7);
				setState(320);
				((BExprTermContext)_localctx).inner_expr = expr(0);
				setState(321);
				match(T__8);

					((BExprTermContext)_localctx).id =  ((BExprTermContext)_localctx).inner_expr.id;

				}
				break;
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

	public static class MarkerContext extends ParserRuleContext {
		public int label;
		public MarkerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_marker; }
	}

	public final MarkerContext marker() throws RecognitionException {
		MarkerContext _localctx = new MarkerContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_marker);
		try {
			enterOuterAlt(_localctx, 1);
			{

				((MarkerContext)_localctx).label =  q.size;

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

	public static class NextLblContext extends ParserRuleContext {
		public List<Integer> nextlist;
		public NextLblContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nextLbl; }
	}

	public final NextLblContext nextLbl() throws RecognitionException {
		NextLblContext _localctx = new NextLblContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_nextLbl);
		try {
			enterOuterAlt(_localctx, 1);
			{

				((NextLblContext)_localctx).nextlist =  Arrays.asList(q.size);
				q.Add(-1, -1, -1, "goto");

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

	public static class FuncMarkerContext extends ParserRuleContext {
		public int label;
		public FuncMarkerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcMarker; }
	}

	public final FuncMarkerContext funcMarker() throws RecognitionException {
		FuncMarkerContext _localctx = new FuncMarkerContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_funcMarker);
		try {
			enterOuterAlt(_localctx, 1);
			{

				((FuncMarkerContext)_localctx).label =  q.size;
				q.Add(-1, -1, -1, "func_name");

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

	public static class BooleanExprContext extends ParserRuleContext {
		public List<Integer> truelist;
		public List<Integer> falselist;
		public BooleanExprContext b1;
		public BExprTermContext e1;
		public BExprTermContext bExprTerm;
		public Token RelOp;
		public BExprTermContext e2;
		public BooleanExprContext b;
		public MarkerContext marker;
		public BooleanExprContext b2;
		public TerminalNode RelOp() { return getToken(A3CodeParser.RelOp, 0); }
		public List<BExprTermContext> bExprTerm() {
			return getRuleContexts(BExprTermContext.class);
		}
		public BExprTermContext bExprTerm(int i) {
			return getRuleContext(BExprTermContext.class,i);
		}
		public List<BooleanExprContext> booleanExpr() {
			return getRuleContexts(BooleanExprContext.class);
		}
		public BooleanExprContext booleanExpr(int i) {
			return getRuleContext(BooleanExprContext.class,i);
		}
		public MarkerContext marker() {
			return getRuleContext(MarkerContext.class,0);
		}
		public BooleanExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanExpr; }
	}

	public final BooleanExprContext booleanExpr() throws RecognitionException {
		return booleanExpr(0);
	}

	private BooleanExprContext booleanExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BooleanExprContext _localctx = new BooleanExprContext(_ctx, _parentState);
		BooleanExprContext _prevctx = _localctx;
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_booleanExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(333);
				((BooleanExprContext)_localctx).e1 = ((BooleanExprContext)_localctx).bExprTerm = bExprTerm();
				setState(334);
				((BooleanExprContext)_localctx).RelOp = match(RelOp);
				setState(335);
				((BooleanExprContext)_localctx).e2 = ((BooleanExprContext)_localctx).bExprTerm = bExprTerm();

					// Relational operation instruction id
					int id = s.Add(s.GetType(((BooleanExprContext)_localctx).e1.id));
					q.Add(id, ((BooleanExprContext)_localctx).e1.id, ((BooleanExprContext)_localctx).e2.id, (((BooleanExprContext)_localctx).RelOp!=null?((BooleanExprContext)_localctx).RelOp.getText():null));

					((BooleanExprContext)_localctx).truelist =  Arrays.asList(q.size);
					q.Add(-1, id, -1, "if");
					
					((BooleanExprContext)_localctx).falselist =  Arrays.asList(q.size);
					q.Add(-1, id, -1, "ifFalse");

				}
				break;
			case 2:
				{
				setState(338);
				match(T__7);
				setState(339);
				((BooleanExprContext)_localctx).b = booleanExpr(0);
				setState(340);
				match(T__8);

					((BooleanExprContext)_localctx).truelist =  ((BooleanExprContext)_localctx).b.truelist;
					((BooleanExprContext)_localctx).falselist =  ((BooleanExprContext)_localctx).b.falselist;

				}
				break;
			case 3:
				{
				setState(343);
				match(T__13);
				setState(344);
				((BooleanExprContext)_localctx).b = booleanExpr(6);

					((BooleanExprContext)_localctx).truelist =  ((BooleanExprContext)_localctx).b.falselist;
					((BooleanExprContext)_localctx).falselist =  ((BooleanExprContext)_localctx).b.truelist;

				}
				break;
			case 4:
				{
				setState(347);
				((BooleanExprContext)_localctx).bExprTerm = bExprTerm();


					((BooleanExprContext)_localctx).truelist =  Arrays.asList(q.size);
					q.Add(-1, ((BooleanExprContext)_localctx).bExprTerm.id, -1, "if");

					((BooleanExprContext)_localctx).falselist =  Arrays.asList(q.size);
					q.Add(-1, ((BooleanExprContext)_localctx).bExprTerm.id, -1, "ifFalse");

				}
				break;
			case 5:
				{
				setState(350);
				match(T__16);

					((BooleanExprContext)_localctx).truelist =  Arrays.asList(q.size);
					((BooleanExprContext)_localctx).falselist =  null;
					q.Add(-1, -1, -1, "goto");

				}
				break;
			case 6:
				{
				setState(352);
				match(T__17);

					((BooleanExprContext)_localctx).falselist =  Arrays.asList(q.size);
					((BooleanExprContext)_localctx).truelist =  null;
					q.Add(-1, -1, -1, "goto");

				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(370);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(368);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new BooleanExprContext(_parentctx, _parentState);
						_localctx.b1 = _prevctx;
						_localctx.b1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_booleanExpr);
						setState(356);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(357);
						match(T__14);
						setState(358);
						((BooleanExprContext)_localctx).marker = marker();
						setState(359);
						((BooleanExprContext)_localctx).b2 = booleanExpr(6);

						          	backpatch(((BooleanExprContext)_localctx).b1.truelist, ((BooleanExprContext)_localctx).marker.label);
						          	((BooleanExprContext)_localctx).falselist =  merge(((BooleanExprContext)_localctx).b1.falselist, ((BooleanExprContext)_localctx).b2.falselist);
						          	((BooleanExprContext)_localctx).truelist =  ((BooleanExprContext)_localctx).b2.truelist;
						          
						}
						break;
					case 2:
						{
						_localctx = new BooleanExprContext(_parentctx, _parentState);
						_localctx.b1 = _prevctx;
						_localctx.b1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_booleanExpr);
						setState(362);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(363);
						match(T__15);
						setState(364);
						((BooleanExprContext)_localctx).marker = marker();
						setState(365);
						((BooleanExprContext)_localctx).b2 = booleanExpr(5);

						          	backpatch(((BooleanExprContext)_localctx).b1.falselist, ((BooleanExprContext)_localctx).marker.label);
						          	((BooleanExprContext)_localctx).truelist =  merge(((BooleanExprContext)_localctx).b1.truelist, ((BooleanExprContext)_localctx).b2.truelist);
						          	((BooleanExprContext)_localctx).falselist =  ((BooleanExprContext)_localctx).b2.falselist;
						          
						}
						break;
					}
					} 
				}
				setState(372);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Method_nameContext extends ParserRuleContext {
		public int id;
		public Token Ident;
		public TerminalNode Ident() { return getToken(A3CodeParser.Ident, 0); }
		public Method_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_name; }
	}

	public final Method_nameContext method_name() throws RecognitionException {
		Method_nameContext _localctx = new Method_nameContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_method_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
			((Method_nameContext)_localctx).Ident = match(Ident);

				((Method_nameContext)_localctx).id =  s.Find((((Method_nameContext)_localctx).Ident!=null?((Method_nameContext)_localctx).Ident.getText():null));

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

	public static class Expr_paramsContext extends ParserRuleContext {
		public int count;
		public ExprContext expr;
		public Expr_paramsContext nextParam;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_paramsContext expr_params() {
			return getRuleContext(Expr_paramsContext.class,0);
		}
		public Expr_paramsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_params; }
	}

	public final Expr_paramsContext expr_params() throws RecognitionException {
		Expr_paramsContext _localctx = new Expr_paramsContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_expr_params);
		try {
			setState(386);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
			case T__12:
			case T__13:
			case Char:
			case Callout:
			case DecNum:
			case HexNum:
			case BoolLit:
			case Ident:
				enterOuterAlt(_localctx, 1);
				{
				setState(376);
				((Expr_paramsContext)_localctx).expr = expr(0);
				setState(377);
				((Expr_paramsContext)_localctx).nextParam = expr_params();

					q.Add(-1, ((Expr_paramsContext)_localctx).expr.id, -1, "param");
					((Expr_paramsContext)_localctx).count =  ++((Expr_paramsContext)_localctx).nextParam.count;

				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(380);
				match(T__3);
				setState(381);
				((Expr_paramsContext)_localctx).expr = expr(0);
				setState(382);
				((Expr_paramsContext)_localctx).nextParam = expr_params();

					q.Add(-1, ((Expr_paramsContext)_localctx).expr.id, -1, "param");
					((Expr_paramsContext)_localctx).count =  ++((Expr_paramsContext)_localctx).nextParam.count;

				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Callout_argsContext extends ParserRuleContext {
		public int count;
		public Callout_argsContext c;
		public Callout_argContext callout_arg() {
			return getRuleContext(Callout_argContext.class,0);
		}
		public Callout_argsContext callout_args() {
			return getRuleContext(Callout_argsContext.class,0);
		}
		public Callout_argsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callout_args; }
	}

	public final Callout_argsContext callout_args() throws RecognitionException {
		Callout_argsContext _localctx = new Callout_argsContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_callout_args);
		try {
			setState(394);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(388);
				match(T__3);
				setState(389);
				callout_arg();
				setState(390);
				((Callout_argsContext)_localctx).c = callout_args();

					((Callout_argsContext)_localctx).count =  ++((Callout_argsContext)_localctx).c.count;

				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Callout_argContext extends ParserRuleContext {
		public ExprContext expr;
		public Token Str;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Str() { return getToken(A3CodeParser.Str, 0); }
		public Callout_argContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callout_arg; }
	}

	public final Callout_argContext callout_arg() throws RecognitionException {
		Callout_argContext _localctx = new Callout_argContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_callout_arg);
		try {
			setState(401);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
			case T__12:
			case T__13:
			case Char:
			case Callout:
			case DecNum:
			case HexNum:
			case BoolLit:
			case Ident:
				enterOuterAlt(_localctx, 1);
				{
				setState(396);
				((Callout_argContext)_localctx).expr = expr(0);

					q.Add(-1, ((Callout_argContext)_localctx).expr.id, -1, "param");

				}
				break;
			case Str:
				enterOuterAlt(_localctx, 2);
				{
				setState(399);
				((Callout_argContext)_localctx).Str = match(Str);

					int id = s.insert((((Callout_argContext)_localctx).Str!=null?((Callout_argContext)_localctx).Str.getText():null), DataType.STRING);
					q.Add(-1, id, -1, "param");

				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Method_callContext extends ParserRuleContext {
		public int id;
		public Method_nameContext method_name;
		public Expr_paramsContext expr_params;
		public Token Str;
		public Callout_argsContext callout_args;
		public Method_nameContext method_name() {
			return getRuleContext(Method_nameContext.class,0);
		}
		public Expr_paramsContext expr_params() {
			return getRuleContext(Expr_paramsContext.class,0);
		}
		public TerminalNode Str() { return getToken(A3CodeParser.Str, 0); }
		public Callout_argsContext callout_args() {
			return getRuleContext(Callout_argsContext.class,0);
		}
		public Method_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_call; }
	}

	public final Method_callContext method_call() throws RecognitionException {
		Method_callContext _localctx = new Method_callContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_method_call);
		try {
			setState(422);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Ident:
				enterOuterAlt(_localctx, 1);
				{
				setState(403);
				((Method_callContext)_localctx).method_name = method_name();
				setState(404);
				match(T__7);
				setState(405);
				((Method_callContext)_localctx).expr_params = expr_params();
				setState(406);
				match(T__8);
				setState(408);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(407);
					match(T__2);
					}
					break;
				}

					((Method_callContext)_localctx).id =  ((Method_callContext)_localctx).method_name.id;

					// Generate perameter number
					int countNumber = s.Find(String.valueOf(((Method_callContext)_localctx).expr_params.count));
					if (countNumber == -1) {
						countNumber = s.insert(String.valueOf(((Method_callContext)_localctx).expr_params.count), DataType.INT);
					}

					// Do not generate a temp variable if the method return type is void
					if ( s.GetType(s.Find((((Method_callContext)_localctx).method_name!=null?_input.getText(((Method_callContext)_localctx).method_name.start,((Method_callContext)_localctx).method_name.stop):null))) == DataType.INVALID ) {
						q.Add(-1, _localctx.id, countNumber, "call");
					} else {
						int destId = s.Add(DataType.INT);
						q.Add(destId, _localctx.id, countNumber, "call");
						((Method_callContext)_localctx).id =  destId;
					}

				}
				break;
			case Callout:
				enterOuterAlt(_localctx, 2);
				{
				setState(412);
				match(Callout);
				setState(413);
				match(T__7);
				setState(414);
				((Method_callContext)_localctx).Str = match(Str);
				setState(415);
				((Method_callContext)_localctx).callout_args = callout_args();
				setState(416);
				match(T__8);
				setState(418);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(417);
					match(T__2);
					}
					break;
				}

					((Method_callContext)_localctx).id =  s.insert((((Method_callContext)_localctx).Str!=null?((Method_callContext)_localctx).Str.getText():null), DataType.INVALID);

					// Generate perameter number
					int countNumber = s.Find(String.valueOf(((Method_callContext)_localctx).callout_args.count));
					if (countNumber == -1) {
						countNumber = s.insert(String.valueOf(((Method_callContext)_localctx).callout_args.count), DataType.INT);
					}
					q.Add(-1, _localctx.id, countNumber, "call");

				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ExprContext extends ParserRuleContext {
		public int id;
		public ExprContext e1;
		public ExprContext e3;
		public ExprContext e4;
		public TermContext term;
		public ExprContext inner_expr;
		public BinOpContext binOp;
		public ExprContext e2;
		public TermContext t1;
		public TermContext t2;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BinOpContext binOp() {
			return getRuleContext(BinOpContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 52;
		enterRecursionRule(_localctx, 52, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(433);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(425);
				((ExprContext)_localctx).term = term(0);

					((ExprContext)_localctx).id =  ((ExprContext)_localctx).term.id;

				}
				break;
			case 2:
				{
				setState(428);
				match(T__7);
				setState(429);
				((ExprContext)_localctx).inner_expr = expr(0);
				setState(430);
				match(T__8);

					((ExprContext)_localctx).id =  ((ExprContext)_localctx).inner_expr.id;

				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(452);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(450);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(435);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(436);
						((ExprContext)_localctx).binOp = binOp();
						setState(437);
						((ExprContext)_localctx).e2 = expr(5);

						          	((ExprContext)_localctx).id =  s.Add(s.GetType(((ExprContext)_localctx).e1.id));
						          	q.Add(_localctx.id, ((ExprContext)_localctx).e1.id, ((ExprContext)_localctx).e2.id, (((ExprContext)_localctx).binOp!=null?_input.getText(((ExprContext)_localctx).binOp.start,((ExprContext)_localctx).binOp.stop):null));
						          
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e3 = _prevctx;
						_localctx.e3 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(440);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(441);
						match(T__11);
						setState(442);
						((ExprContext)_localctx).t1 = ((ExprContext)_localctx).term = term(0);

						          	((ExprContext)_localctx).id =  s.Add(s.GetType(((ExprContext)_localctx).e3.id));
						          	q.Add(_localctx.id, ((ExprContext)_localctx).e3.id, ((ExprContext)_localctx).t1.id, "+");
						          
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e4 = _prevctx;
						_localctx.e4 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(445);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(446);
						match(T__12);
						setState(447);
						((ExprContext)_localctx).t2 = ((ExprContext)_localctx).term = term(0);

						          	((ExprContext)_localctx).id =  s.Add(s.GetType(((ExprContext)_localctx).e4.id));
						          	q.Add(_localctx.id, ((ExprContext)_localctx).e4.id, ((ExprContext)_localctx).t2.id, "-");
						          
						}
						break;
					}
					} 
				}
				setState(454);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public int id;
		public TermContext t1;
		public LiteralContext literal;
		public LocationContext location;
		public Method_callContext method_call;
		public ExprContext minus_expr;
		public ExprContext expr;
		public ExprContext exclaim_expr;
		public ExprContext inner_expr;
		public Token ArithOp;
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public Method_callContext method_call() {
			return getRuleContext(Method_callContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode ArithOp() { return getToken(A3CodeParser.ArithOp, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	}

	public final TermContext term() throws RecognitionException {
		return term(0);
	}

	private TermContext term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermContext _localctx = new TermContext(_ctx, _parentState);
		TermContext _prevctx = _localctx;
		int _startState = 54;
		enterRecursionRule(_localctx, 54, RULE_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(478);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(456);
				((TermContext)_localctx).literal = literal();

					((TermContext)_localctx).id =  ((TermContext)_localctx).literal.id;

				}
				break;
			case 2:
				{
				setState(459);
				((TermContext)_localctx).location = location();

					((TermContext)_localctx).id =  ((TermContext)_localctx).location.id;

				}
				break;
			case 3:
				{
				setState(462);
				((TermContext)_localctx).method_call = method_call();

					((TermContext)_localctx).id =  ((TermContext)_localctx).method_call.id;

				}
				break;
			case 4:
				{
				setState(465);
				match(T__12);
				setState(466);
				((TermContext)_localctx).minus_expr = ((TermContext)_localctx).expr = expr(0);

					((TermContext)_localctx).id =  s.Add(s.GetType(((TermContext)_localctx).minus_expr.id));

					int zero = s.Find("0");
					if (zero == -1) {
						zero = s.insert("0", DataType.INT);
					}
					q.Add(_localctx.id, zero, ((TermContext)_localctx).minus_expr.id, "-");

				}
				break;
			case 5:
				{
				setState(469);
				match(T__13);
				setState(470);
				((TermContext)_localctx).exclaim_expr = ((TermContext)_localctx).expr = expr(0);

					((TermContext)_localctx).id =  s.Add(s.GetType(((TermContext)_localctx).exclaim_expr.id));
					q.Add(_localctx.id, ((TermContext)_localctx).exclaim_expr.id, -1, "!");

				}
				break;
			case 6:
				{
				setState(473);
				match(T__7);
				setState(474);
				((TermContext)_localctx).inner_expr = ((TermContext)_localctx).expr = expr(0);
				setState(475);
				match(T__8);

					((TermContext)_localctx).id =  ((TermContext)_localctx).inner_expr.id;

				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(492);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(490);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
					case 1:
						{
						_localctx = new TermContext(_parentctx, _parentState);
						_localctx.t1 = _prevctx;
						_localctx.t1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(480);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(481);
						match(T__18);
						setState(482);
						((TermContext)_localctx).expr = expr(0);

						          	int id1 = s.Add(s.GetType(((TermContext)_localctx).t1.id));
						          	q.Add(id1, ((TermContext)_localctx).t1.id, ((TermContext)_localctx).expr.id, "/");
						          	int id2 = s.Add(s.GetType(((TermContext)_localctx).t1.id));
						          	q.Add(id2, ((TermContext)_localctx).t1.id, id1, "*");
						          	int id3 = s.Add(s.GetType(((TermContext)_localctx).t1.id));
						          	q.Add(id3, ((TermContext)_localctx).t1.id, id2, "-");
						          	((TermContext)_localctx).id =  id3;
						          
						}
						break;
					case 2:
						{
						_localctx = new TermContext(_parentctx, _parentState);
						_localctx.t1 = _prevctx;
						_localctx.t1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(485);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(486);
						((TermContext)_localctx).ArithOp = match(ArithOp);
						setState(487);
						((TermContext)_localctx).expr = expr(0);

						          	((TermContext)_localctx).id =  s.Add(s.GetType(((TermContext)_localctx).t1.id));
						          	q.Add(_localctx.id, ((TermContext)_localctx).t1.id, ((TermContext)_localctx).expr.id, (((TermContext)_localctx).ArithOp!=null?((TermContext)_localctx).ArithOp.getText():null));
						          
						}
						break;
					}
					} 
				}
				setState(494);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LocationContext extends ParserRuleContext {
		public int id;
		public Token Ident;
		public ExprContext expr;
		public TerminalNode Ident() { return getToken(A3CodeParser.Ident, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_location; }
	}

	public final LocationContext location() throws RecognitionException {
		LocationContext _localctx = new LocationContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_location);
		try {
			setState(503);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(495);
				((LocationContext)_localctx).Ident = match(Ident);

					((LocationContext)_localctx).id =  s.Find((((LocationContext)_localctx).Ident!=null?((LocationContext)_localctx).Ident.getText():null));

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(497);
				((LocationContext)_localctx).Ident = match(Ident);
				setState(498);
				match(T__4);
				setState(499);
				((LocationContext)_localctx).expr = expr(0);
				setState(500);
				match(T__5);

					((LocationContext)_localctx).id =  s.Add(DataType.INT);
					int fourId = s.Find("4");
					if (fourId == -1) {
						fourId = s.insert("4", DataType.INT);
					}
					q.Add(_localctx.id, ((LocationContext)_localctx).expr.id, fourId, "*");
					((LocationContext)_localctx).id =  s.insert((((LocationContext)_localctx).Ident!=null?((LocationContext)_localctx).Ident.getText():null) + "[ " + s.GetName(_localctx.id) + " ] ", s.GetType(_localctx.id));

				}
				break;
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

	public static class NumContext extends ParserRuleContext {
		public TerminalNode DecNum() { return getToken(A3CodeParser.DecNum, 0); }
		public TerminalNode HexNum() { return getToken(A3CodeParser.HexNum, 0); }
		public NumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_num; }
	}

	public final NumContext num() throws RecognitionException {
		NumContext _localctx = new NumContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_num);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(505);
			_la = _input.LA(1);
			if ( !(_la==DecNum || _la==HexNum) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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

	public static class LiteralContext extends ParserRuleContext {
		public int id;
		public NumContext num;
		public Token Char;
		public Token BoolLit;
		public NumContext num() {
			return getRuleContext(NumContext.class,0);
		}
		public TerminalNode Char() { return getToken(A3CodeParser.Char, 0); }
		public TerminalNode BoolLit() { return getToken(A3CodeParser.BoolLit, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_literal);
		try {
			setState(514);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DecNum:
			case HexNum:
				enterOuterAlt(_localctx, 1);
				{
				setState(507);
				((LiteralContext)_localctx).num = num();

					((LiteralContext)_localctx).id =  s.insert((((LiteralContext)_localctx).num!=null?_input.getText(((LiteralContext)_localctx).num.start,((LiteralContext)_localctx).num.stop):null), DataType.INT);

				}
				break;
			case Char:
				enterOuterAlt(_localctx, 2);
				{
				setState(510);
				((LiteralContext)_localctx).Char = match(Char);

					((LiteralContext)_localctx).id =  s.insert((((LiteralContext)_localctx).Char!=null?((LiteralContext)_localctx).Char.getText():null), DataType.INVALID);

				}
				break;
			case BoolLit:
				enterOuterAlt(_localctx, 3);
				{
				setState(512);
				((LiteralContext)_localctx).BoolLit = match(BoolLit);

					((LiteralContext)_localctx).id =  s.insert((((LiteralContext)_localctx).BoolLit!=null?((LiteralContext)_localctx).BoolLit.getText():null), DataType.BOOLEAN);

				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class EqOpContext extends ParserRuleContext {
		public TerminalNode AssignOp() { return getToken(A3CodeParser.AssignOp, 0); }
		public EqOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eqOp; }
	}

	public final EqOpContext eqOp() throws RecognitionException {
		EqOpContext _localctx = new EqOpContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_eqOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(516);
			_la = _input.LA(1);
			if ( !(_la==T__6 || _la==AssignOp) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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

	public static class BoolOpContext extends ParserRuleContext {
		public TerminalNode CondOp() { return getToken(A3CodeParser.CondOp, 0); }
		public BoolOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolOp; }
	}

	public final BoolOpContext boolOp() throws RecognitionException {
		BoolOpContext _localctx = new BoolOpContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_boolOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(518);
			_la = _input.LA(1);
			if ( !(_la==T__13 || _la==CondOp) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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

	public static class BinOpContext extends ParserRuleContext {
		public TerminalNode RelOp() { return getToken(A3CodeParser.RelOp, 0); }
		public TerminalNode CondOp() { return getToken(A3CodeParser.CondOp, 0); }
		public BinOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binOp; }
	}

	public final BinOpContext binOp() throws RecognitionException {
		BinOpContext _localctx = new BinOpContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_binOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(520);
			_la = _input.LA(1);
			if ( !(_la==RelOp || _la==CondOp) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return field_decls_sempred((Field_declsContext)_localctx, predIndex);
		case 2:
			return field_decl_sempred((Field_declContext)_localctx, predIndex);
		case 4:
			return method_decls_sempred((Method_declsContext)_localctx, predIndex);
		case 7:
			return nextParams_sempred((NextParamsContext)_localctx, predIndex);
		case 9:
			return var_decls_sempred((Var_declsContext)_localctx, predIndex);
		case 10:
			return var_decl_sempred((Var_declContext)_localctx, predIndex);
		case 12:
			return controlFlowStmtList_sempred((ControlFlowStmtListContext)_localctx, predIndex);
		case 20:
			return booleanExpr_sempred((BooleanExprContext)_localctx, predIndex);
		case 26:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 27:
			return term_sempred((TermContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean field_decls_sempred(Field_declsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean field_decl_sempred(Field_declContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean method_decls_sempred(Method_declsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean nextParams_sempred(NextParamsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean var_decls_sempred(Var_declsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean var_decl_sempred(Var_declContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean controlFlowStmtList_sempred(ControlFlowStmtListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean booleanExpr_sempred(BooleanExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 5);
		case 10:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 11:
			return precpred(_ctx, 4);
		case 12:
			return precpred(_ctx, 3);
		case 13:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 14:
			return precpred(_ctx, 8);
		case 15:
			return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3+\u020d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\7\3X\n\3\f\3\16\3[\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\5\4h\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\7\4v\n\4\f\4\16\4y\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\7\6\u0084"+
		"\n\6\f\6\16\6\u0087\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u009b\n\7\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00a3"+
		"\n\b\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00ab\n\t\f\t\16\t\u00ae\13\t\3\n\3\n"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\7\13\u00ba\n\13\f\13\16\13\u00bd"+
		"\13\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00c8\n\f\f\f\16\f\u00cb"+
		"\13\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00d6\n\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00e1\n\16\f\16\16\16\u00e4\13\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u010e"+
		"\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0133\n\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\5\22\u0147\n\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\5\26\u0165\n\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\7\26\u0173\n\26\f\26\16\26\u0176\13\26\3\27"+
		"\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0185"+
		"\n\30\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u018d\n\31\3\32\3\32\3\32\3\32"+
		"\3\32\5\32\u0194\n\32\3\33\3\33\3\33\3\33\3\33\5\33\u019b\n\33\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u01a5\n\33\3\33\3\33\5\33\u01a9"+
		"\n\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u01b4\n\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\7\34\u01c5\n\34\f\34\16\34\u01c8\13\34\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\5\35\u01e1\n\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\7\35\u01ed\n\35\f\35\16\35\u01f0\13\35\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\5\36\u01fa\n\36\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \5"+
		" \u0205\n \3!\3!\3\"\3\"\3#\3#\3#\2\f\4\6\n\20\24\26\32*\668$\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BD\2\6\3\2#$"+
		"\4\2\t\t\'\'\4\2\20\20))\4\2&&))\2\u0223\2F\3\2\2\2\4N\3\2\2\2\6g\3\2"+
		"\2\2\bz\3\2\2\2\n\u0080\3\2\2\2\f\u009a\3\2\2\2\16\u00a2\3\2\2\2\20\u00a4"+
		"\3\2\2\2\22\u00af\3\2\2\2\24\u00b4\3\2\2\2\26\u00be\3\2\2\2\30\u00d5\3"+
		"\2\2\2\32\u00d7\3\2\2\2\34\u010d\3\2\2\2\36\u010f\3\2\2\2 \u0132\3\2\2"+
		"\2\"\u0146\3\2\2\2$\u0148\3\2\2\2&\u014a\3\2\2\2(\u014c\3\2\2\2*\u0164"+
		"\3\2\2\2,\u0177\3\2\2\2.\u0184\3\2\2\2\60\u018c\3\2\2\2\62\u0193\3\2\2"+
		"\2\64\u01a8\3\2\2\2\66\u01b3\3\2\2\28\u01e0\3\2\2\2:\u01f9\3\2\2\2<\u01fb"+
		"\3\2\2\2>\u0204\3\2\2\2@\u0206\3\2\2\2B\u0208\3\2\2\2D\u020a\3\2\2\2F"+
		"G\7\31\2\2GH\7\32\2\2HI\7\3\2\2IJ\5\4\3\2JK\5\n\6\2KL\7\4\2\2LM\b\2\1"+
		"\2M\3\3\2\2\2NY\b\3\1\2OP\f\5\2\2PQ\5\6\4\2QR\7\5\2\2RX\3\2\2\2ST\f\4"+
		"\2\2TU\5\b\5\2UV\7\5\2\2VX\3\2\2\2WO\3\2\2\2WS\3\2\2\2X[\3\2\2\2YW\3\2"+
		"\2\2YZ\3\2\2\2Z\5\3\2\2\2[Y\3\2\2\2\\]\b\4\1\2]^\7*\2\2^_\7+\2\2_h\b\4"+
		"\1\2`a\7*\2\2ab\7+\2\2bc\7\7\2\2cd\5<\37\2de\7\b\2\2ef\b\4\1\2fh\3\2\2"+
		"\2g\\\3\2\2\2g`\3\2\2\2hw\3\2\2\2ij\f\6\2\2jk\7\6\2\2kl\7+\2\2lv\b\4\1"+
		"\2mn\f\5\2\2no\7\6\2\2op\7+\2\2pq\7\7\2\2qr\5<\37\2rs\7\b\2\2st\b\4\1"+
		"\2tv\3\2\2\2ui\3\2\2\2um\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2x\7\3\2"+
		"\2\2yw\3\2\2\2z{\7*\2\2{|\7+\2\2|}\7\t\2\2}~\5> \2~\177\b\5\1\2\177\t"+
		"\3\2\2\2\u0080\u0085\b\6\1\2\u0081\u0082\f\4\2\2\u0082\u0084\5\f\7\2\u0083"+
		"\u0081\3\2\2\2\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2"+
		"\2\2\u0086\13\3\2\2\2\u0087\u0085\3\2\2\2\u0088\u0089\7*\2\2\u0089\u008a"+
		"\7+\2\2\u008a\u008b\5(\25\2\u008b\u008c\7\n\2\2\u008c\u008d\5\16\b\2\u008d"+
		"\u008e\7\13\2\2\u008e\u008f\5\22\n\2\u008f\u0090\b\7\1\2\u0090\u009b\3"+
		"\2\2\2\u0091\u0092\7\33\2\2\u0092\u0093\7+\2\2\u0093\u0094\5(\25\2\u0094"+
		"\u0095\7\n\2\2\u0095\u0096\5\16\b\2\u0096\u0097\7\13\2\2\u0097\u0098\5"+
		"\22\n\2\u0098\u0099\b\7\1\2\u0099\u009b\3\2\2\2\u009a\u0088\3\2\2\2\u009a"+
		"\u0091\3\2\2\2\u009b\r\3\2\2\2\u009c\u009d\7*\2\2\u009d\u009e\7+\2\2\u009e"+
		"\u009f\5\20\t\2\u009f\u00a0\b\b\1\2\u00a0\u00a3\3\2\2\2\u00a1\u00a3\3"+
		"\2\2\2\u00a2\u009c\3\2\2\2\u00a2\u00a1\3\2\2\2\u00a3\17\3\2\2\2\u00a4"+
		"\u00ac\b\t\1\2\u00a5\u00a6\f\4\2\2\u00a6\u00a7\7\6\2\2\u00a7\u00a8\7*"+
		"\2\2\u00a8\u00a9\7+\2\2\u00a9\u00ab\b\t\1\2\u00aa\u00a5\3\2\2\2\u00ab"+
		"\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\21\3\2\2"+
		"\2\u00ae\u00ac\3\2\2\2\u00af\u00b0\7\3\2\2\u00b0\u00b1\5\24\13\2\u00b1"+
		"\u00b2\5\30\r\2\u00b2\u00b3\7\4\2\2\u00b3\23\3\2\2\2\u00b4\u00bb\b\13"+
		"\1\2\u00b5\u00b6\f\4\2\2\u00b6\u00b7\5\26\f\2\u00b7\u00b8\7\5\2\2\u00b8"+
		"\u00ba\3\2\2\2\u00b9\u00b5\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3\2"+
		"\2\2\u00bb\u00bc\3\2\2\2\u00bc\25\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be\u00bf"+
		"\b\f\1\2\u00bf\u00c0\7*\2\2\u00c0\u00c1\7+\2\2\u00c1\u00c2\b\f\1\2\u00c2"+
		"\u00c9\3\2\2\2\u00c3\u00c4\f\4\2\2\u00c4\u00c5\7\6\2\2\u00c5\u00c6\7+"+
		"\2\2\u00c6\u00c8\b\f\1\2\u00c7\u00c3\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9"+
		"\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\27\3\2\2\2\u00cb\u00c9\3\2\2"+
		"\2\u00cc\u00cd\5 \21\2\u00cd\u00ce\5\30\r\2\u00ce\u00d6\3\2\2\2\u00cf"+
		"\u00d0\5\34\17\2\u00d0\u00d1\5$\23\2\u00d1\u00d2\5\30\r\2\u00d2\u00d3"+
		"\b\r\1\2\u00d3\u00d6\3\2\2\2\u00d4\u00d6\3\2\2\2\u00d5\u00cc\3\2\2\2\u00d5"+
		"\u00cf\3\2\2\2\u00d5\u00d4\3\2\2\2\u00d6\31\3\2\2\2\u00d7\u00d8\b\16\1"+
		"\2\u00d8\u00d9\5\34\17\2\u00d9\u00da\b\16\1\2\u00da\u00e2\3\2\2\2\u00db"+
		"\u00dc\f\3\2\2\u00dc\u00dd\5$\23\2\u00dd\u00de\5\34\17\2\u00de\u00df\b"+
		"\16\1\2\u00df\u00e1\3\2\2\2\u00e0\u00db\3\2\2\2\u00e1\u00e4\3\2\2\2\u00e2"+
		"\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\33\3\2\2\2\u00e4\u00e2\3\2\2"+
		"\2\u00e5\u00e6\7\3\2\2\u00e6\u00e7\5\32\16\2\u00e7\u00e8\7\4\2\2\u00e8"+
		"\u00e9\b\17\1\2\u00e9\u010e\3\2\2\2\u00ea\u00eb\5 \21\2\u00eb\u00ec\b"+
		"\17\1\2\u00ec\u010e\3\2\2\2\u00ed\u00ee\7 \2\2\u00ee\u00ef\7\5\2\2\u00ef"+
		"\u010e\b\17\1\2\u00f0\u00f1\7!\2\2\u00f1\u00f2\7\5\2\2\u00f2\u010e\b\17"+
		"\1\2\u00f3\u00f4\7\34\2\2\u00f4\u00f5\7\n\2\2\u00f5\u00f6\5*\26\2\u00f6"+
		"\u00f7\7\13\2\2\u00f7\u00f8\5$\23\2\u00f8\u00f9\5\34\17\2\u00f9\u00fa"+
		"\b\17\1\2\u00fa\u010e\3\2\2\2\u00fb\u00fc\7\34\2\2\u00fc\u00fd\7\n\2\2"+
		"\u00fd\u00fe\5*\26\2\u00fe\u00ff\7\13\2\2\u00ff\u0100\5$\23\2\u0100\u0101"+
		"\5\34\17\2\u0101\u0102\5&\24\2\u0102\u0103\7\35\2\2\u0103\u0104\5$\23"+
		"\2\u0104\u0105\5\34\17\2\u0105\u0106\b\17\1\2\u0106\u010e\3\2\2\2\u0107"+
		"\u0108\7\36\2\2\u0108\u0109\5\36\20\2\u0109\u010a\5$\23\2\u010a\u010b"+
		"\5\34\17\2\u010b\u010c\b\17\1\2\u010c\u010e\3\2\2\2\u010d\u00e5\3\2\2"+
		"\2\u010d\u00ea\3\2\2\2\u010d\u00ed\3\2\2\2\u010d\u00f0\3\2\2\2\u010d\u00f3"+
		"\3\2\2\2\u010d\u00fb\3\2\2\2\u010d\u0107\3\2\2\2\u010e\35\3\2\2\2\u010f"+
		"\u0110\7+\2\2\u0110\u0111\7\t\2\2\u0111\u0112\5\66\34\2\u0112\u0113\7"+
		"\6\2\2\u0113\u0114\5\66\34\2\u0114\u0115\b\20\1\2\u0115\37\3\2\2\2\u0116"+
		"\u0117\5:\36\2\u0117\u0118\7\t\2\2\u0118\u0119\5\66\34\2\u0119\u011a\7"+
		"\5\2\2\u011a\u011b\b\21\1\2\u011b\u0133\3\2\2\2\u011c\u011d\5:\36\2\u011d"+
		"\u011e\7\f\2\2\u011e\u011f\5\66\34\2\u011f\u0120\7\5\2\2\u0120\u0121\b"+
		"\21\1\2\u0121\u0133\3\2\2\2\u0122\u0123\5:\36\2\u0123\u0124\7\r\2\2\u0124"+
		"\u0125\5\66\34\2\u0125\u0126\7\5\2\2\u0126\u0127\b\21\1\2\u0127\u0133"+
		"\3\2\2\2\u0128\u0133\5\22\n\2\u0129\u0133\5\64\33\2\u012a\u012b\7\37\2"+
		"\2\u012b\u012c\5\66\34\2\u012c\u012d\7\5\2\2\u012d\u012e\b\21\1\2\u012e"+
		"\u0133\3\2\2\2\u012f\u0130\7\37\2\2\u0130\u0131\7\5\2\2\u0131\u0133\b"+
		"\21\1\2\u0132\u0116\3\2\2\2\u0132\u011c\3\2\2\2\u0132\u0122\3\2\2\2\u0132"+
		"\u0128\3\2\2\2\u0132\u0129\3\2\2\2\u0132\u012a\3\2\2\2\u0132\u012f\3\2"+
		"\2\2\u0133!\3\2\2\2\u0134\u0135\58\35\2\u0135\u0136\b\22\1\2\u0136\u0147"+
		"\3\2\2\2\u0137\u0138\5\66\34\2\u0138\u0139\7\16\2\2\u0139\u013a\58\35"+
		"\2\u013a\u013b\b\22\1\2\u013b\u0147\3\2\2\2\u013c\u013d\5\66\34\2\u013d"+
		"\u013e\7\17\2\2\u013e\u013f\58\35\2\u013f\u0140\b\22\1\2\u0140\u0147\3"+
		"\2\2\2\u0141\u0142\7\n\2\2\u0142\u0143\5\66\34\2\u0143\u0144\7\13\2\2"+
		"\u0144\u0145\b\22\1\2\u0145\u0147\3\2\2\2\u0146\u0134\3\2\2\2\u0146\u0137"+
		"\3\2\2\2\u0146\u013c\3\2\2\2\u0146\u0141\3\2\2\2\u0147#\3\2\2\2\u0148"+
		"\u0149\b\23\1\2\u0149%\3\2\2\2\u014a\u014b\b\24\1\2\u014b\'\3\2\2\2\u014c"+
		"\u014d\b\25\1\2\u014d)\3\2\2\2\u014e\u014f\b\26\1\2\u014f\u0150\5\"\22"+
		"\2\u0150\u0151\7&\2\2\u0151\u0152\5\"\22\2\u0152\u0153\b\26\1\2\u0153"+
		"\u0165\3\2\2\2\u0154\u0155\7\n\2\2\u0155\u0156\5*\26\2\u0156\u0157\7\13"+
		"\2\2\u0157\u0158\b\26\1\2\u0158\u0165\3\2\2\2\u0159\u015a\7\20\2\2\u015a"+
		"\u015b\5*\26\b\u015b\u015c\b\26\1\2\u015c\u0165\3\2\2\2\u015d\u015e\5"+
		"\"\22\2\u015e\u015f\b\26\1\2\u015f\u0165\3\2\2\2\u0160\u0161\7\23\2\2"+
		"\u0161\u0165\b\26\1\2\u0162\u0163\7\24\2\2\u0163\u0165\b\26\1\2\u0164"+
		"\u014e\3\2\2\2\u0164\u0154\3\2\2\2\u0164\u0159\3\2\2\2\u0164\u015d\3\2"+
		"\2\2\u0164\u0160\3\2\2\2\u0164\u0162\3\2\2\2\u0165\u0174\3\2\2\2\u0166"+
		"\u0167\f\7\2\2\u0167\u0168\7\21\2\2\u0168\u0169\5$\23\2\u0169\u016a\5"+
		"*\26\b\u016a\u016b\b\26\1\2\u016b\u0173\3\2\2\2\u016c\u016d\f\6\2\2\u016d"+
		"\u016e\7\22\2\2\u016e\u016f\5$\23\2\u016f\u0170\5*\26\7\u0170\u0171\b"+
		"\26\1\2\u0171\u0173\3\2\2\2\u0172\u0166\3\2\2\2\u0172\u016c\3\2\2\2\u0173"+
		"\u0176\3\2\2\2\u0174\u0172\3\2\2\2\u0174\u0175\3\2\2\2\u0175+\3\2\2\2"+
		"\u0176\u0174\3\2\2\2\u0177\u0178\7+\2\2\u0178\u0179\b\27\1\2\u0179-\3"+
		"\2\2\2\u017a\u017b\5\66\34\2\u017b\u017c\5.\30\2\u017c\u017d\b\30\1\2"+
		"\u017d\u0185\3\2\2\2\u017e\u017f\7\6\2\2\u017f\u0180\5\66\34\2\u0180\u0181"+
		"\5.\30\2\u0181\u0182\b\30\1\2\u0182\u0185\3\2\2\2\u0183\u0185\3\2\2\2"+
		"\u0184\u017a\3\2\2\2\u0184\u017e\3\2\2\2\u0184\u0183\3\2\2\2\u0185/\3"+
		"\2\2\2\u0186\u0187\7\6\2\2\u0187\u0188\5\62\32\2\u0188\u0189\5\60\31\2"+
		"\u0189\u018a\b\31\1\2\u018a\u018d\3\2\2\2\u018b\u018d\3\2\2\2\u018c\u0186"+
		"\3\2\2\2\u018c\u018b\3\2\2\2\u018d\61\3\2\2\2\u018e\u018f\5\66\34\2\u018f"+
		"\u0190\b\32\1\2\u0190\u0194\3\2\2\2\u0191\u0192\7\30\2\2\u0192\u0194\b"+
		"\32\1\2\u0193\u018e\3\2\2\2\u0193\u0191\3\2\2\2\u0194\63\3\2\2\2\u0195"+
		"\u0196\5,\27\2\u0196\u0197\7\n\2\2\u0197\u0198\5.\30\2\u0198\u019a\7\13"+
		"\2\2\u0199\u019b\7\5\2\2\u019a\u0199\3\2\2\2\u019a\u019b\3\2\2\2\u019b"+
		"\u019c\3\2\2\2\u019c\u019d\b\33\1\2\u019d\u01a9\3\2\2\2\u019e\u019f\7"+
		"\"\2\2\u019f\u01a0\7\n\2\2\u01a0\u01a1\7\30\2\2\u01a1\u01a2\5\60\31\2"+
		"\u01a2\u01a4\7\13\2\2\u01a3\u01a5\7\5\2\2\u01a4\u01a3\3\2\2\2\u01a4\u01a5"+
		"\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a7\b\33\1\2\u01a7\u01a9\3\2\2\2"+
		"\u01a8\u0195\3\2\2\2\u01a8\u019e\3\2\2\2\u01a9\65\3\2\2\2\u01aa\u01ab"+
		"\b\34\1\2\u01ab\u01ac\58\35\2\u01ac\u01ad\b\34\1\2\u01ad\u01b4\3\2\2\2"+
		"\u01ae\u01af\7\n\2\2\u01af\u01b0\5\66\34\2\u01b0\u01b1\7\13\2\2\u01b1"+
		"\u01b2\b\34\1\2\u01b2\u01b4\3\2\2\2\u01b3\u01aa\3\2\2\2\u01b3\u01ae\3"+
		"\2\2\2\u01b4\u01c6\3\2\2\2\u01b5\u01b6\f\6\2\2\u01b6\u01b7\5D#\2\u01b7"+
		"\u01b8\5\66\34\7\u01b8\u01b9\b\34\1\2\u01b9\u01c5\3\2\2\2\u01ba\u01bb"+
		"\f\5\2\2\u01bb\u01bc\7\16\2\2\u01bc\u01bd\58\35\2\u01bd\u01be\b\34\1\2"+
		"\u01be\u01c5\3\2\2\2\u01bf\u01c0\f\4\2\2\u01c0\u01c1\7\17\2\2\u01c1\u01c2"+
		"\58\35\2\u01c2\u01c3\b\34\1\2\u01c3\u01c5\3\2\2\2\u01c4\u01b5\3\2\2\2"+
		"\u01c4\u01ba\3\2\2\2\u01c4\u01bf\3\2\2\2\u01c5\u01c8\3\2\2\2\u01c6\u01c4"+
		"\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7\67\3\2\2\2\u01c8\u01c6\3\2\2\2\u01c9"+
		"\u01ca\b\35\1\2\u01ca\u01cb\5> \2\u01cb\u01cc\b\35\1\2\u01cc\u01e1\3\2"+
		"\2\2\u01cd\u01ce\5:\36\2\u01ce\u01cf\b\35\1\2\u01cf\u01e1\3\2\2\2\u01d0"+
		"\u01d1\5\64\33\2\u01d1\u01d2\b\35\1\2\u01d2\u01e1\3\2\2\2\u01d3\u01d4"+
		"\7\17\2\2\u01d4\u01d5\5\66\34\2\u01d5\u01d6\b\35\1\2\u01d6\u01e1\3\2\2"+
		"\2\u01d7\u01d8\7\20\2\2\u01d8\u01d9\5\66\34\2\u01d9\u01da\b\35\1\2\u01da"+
		"\u01e1\3\2\2\2\u01db\u01dc\7\n\2\2\u01dc\u01dd\5\66\34\2\u01dd\u01de\7"+
		"\13\2\2\u01de\u01df\b\35\1\2\u01df\u01e1\3\2\2\2\u01e0\u01c9\3\2\2\2\u01e0"+
		"\u01cd\3\2\2\2\u01e0\u01d0\3\2\2\2\u01e0\u01d3\3\2\2\2\u01e0\u01d7\3\2"+
		"\2\2\u01e0\u01db\3\2\2\2\u01e1\u01ee\3\2\2\2\u01e2\u01e3\f\n\2\2\u01e3"+
		"\u01e4\7\25\2\2\u01e4\u01e5\5\66\34\2\u01e5\u01e6\b\35\1\2\u01e6\u01ed"+
		"\3\2\2\2\u01e7\u01e8\f\t\2\2\u01e8\u01e9\7(\2\2\u01e9\u01ea\5\66\34\2"+
		"\u01ea\u01eb\b\35\1\2\u01eb\u01ed\3\2\2\2\u01ec\u01e2\3\2\2\2\u01ec\u01e7"+
		"\3\2\2\2\u01ed\u01f0\3\2\2\2\u01ee\u01ec\3\2\2\2\u01ee\u01ef\3\2\2\2\u01ef"+
		"9\3\2\2\2\u01f0\u01ee\3\2\2\2\u01f1\u01f2\7+\2\2\u01f2\u01fa\b\36\1\2"+
		"\u01f3\u01f4\7+\2\2\u01f4\u01f5\7\7\2\2\u01f5\u01f6\5\66\34\2\u01f6\u01f7"+
		"\7\b\2\2\u01f7\u01f8\b\36\1\2\u01f8\u01fa\3\2\2\2\u01f9\u01f1\3\2\2\2"+
		"\u01f9\u01f3\3\2\2\2\u01fa;\3\2\2\2\u01fb\u01fc\t\2\2\2\u01fc=\3\2\2\2"+
		"\u01fd\u01fe\5<\37\2\u01fe\u01ff\b \1\2\u01ff\u0205\3\2\2\2\u0200\u0201"+
		"\7\27\2\2\u0201\u0205\b \1\2\u0202\u0203\7%\2\2\u0203\u0205\b \1\2\u0204"+
		"\u01fd\3\2\2\2\u0204\u0200\3\2\2\2\u0204\u0202\3\2\2\2\u0205?\3\2\2\2"+
		"\u0206\u0207\t\3\2\2\u0207A\3\2\2\2\u0208\u0209\t\4\2\2\u0209C\3\2\2\2"+
		"\u020a\u020b\t\5\2\2\u020bE\3\2\2\2#WYguw\u0085\u009a\u00a2\u00ac\u00bb"+
		"\u00c9\u00d5\u00e2\u010d\u0132\u0146\u0164\u0172\u0174\u0184\u018c\u0193"+
		"\u019a\u01a4\u01a8\u01b3\u01c4\u01c6\u01e0\u01ec\u01ee\u01f9\u0204";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}