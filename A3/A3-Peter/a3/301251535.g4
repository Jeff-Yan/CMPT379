grammar A3Code;

//---------------------------------------------------------------------------------------------------
// Session 1: ANTLR API, You SHOULD NOT make any modification to this session
//---------------------------------------------------------------------------------------------------
@header {
import java.io.*;
import java.util.Arrays;
}



@parser::members {

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

}



//---------------------------------------------------------------------------------------------------
// Session 2: Fill your code here
//---------------------------------------------------------------------------------------------------
prog
: Class Program '{' field_decls method_decls '}'
{
	if (printEmptyLine) {
		q.Add(-1, -1, -1,"extra_line");
	}

	// s.Print();
	// System.out.println("------------------------------------");
	q.Print();
}
;

field_decls 
: f=field_decls field_decl ';'
| f=field_decls inited_field_decl ';'
|
;


field_decl returns [DataType t]
: f=field_decl ',' Ident
{
	$t = $f.t;
	s.insert($Ident.text, $t);
}
| f=field_decl ',' Ident '[' num ']'
{
	$t = $f.t;
	s.insert($Ident.text, $t);
}
| Type Ident
{
	$t = DataType.valueOf($Type.text.toUpperCase());
	s.insert($Ident.text, $t);					
}
| Type Ident '[' num ']'
{
	$t = DataType.valueOf($Type.text.toUpperCase());
	s.insert($Ident.text, $t);	
}
;


inited_field_decl returns [DataType t]
: Type Ident '=' literal 
{
	$t = DataType.valueOf($Type.text.toUpperCase());
	int id = s.insert($Ident.text, $t);
    q.Add(id, $literal.id, -1, "");
}
;


method_decls
: m=method_decls method_decl
|
;

method_decl
: Type Ident funcMarker '(' params ')' block
{
	int funcId = s.insert($Ident.text, DataType.valueOf($Type.text.toUpperCase()));
	
	// Backpatch the function name back to the instruction
	q.qt[$funcMarker.label].dst = funcId;
}
| Void Ident funcMarker '(' params ')' block
{
    int funcId = s.insert($Ident.text, DataType.INVALID);

	// Backpatch the function name back to the instruction
	q.qt[$funcMarker.label].dst = funcId;

	q.Add(-1, -1, -1, "ret");
}
;




params
: Type Ident nextParams
{
	DataType t = DataType.valueOf($Type.text.toUpperCase());
	int id = s.insert($Ident.text, t);
}
|
;


nextParams
: n=nextParams ',' Type Ident
{
	DataType t = DataType.valueOf($Type.text.toUpperCase());
	int id = s.insert($Ident.text, t);
}
|
;



block 
: '{' var_decls statements '}'
;

var_decls 
: v=var_decls var_decl ';'
| 
;


var_decl returns [DataType t]
: v=var_decl ',' Ident
{
	$t = $v.t;
	s.insert($Ident.text, $t);
}
| Type Ident
{
	$t = DataType.valueOf($Type.text.toUpperCase());
	s.insert($Ident.text, $t);
}
;


statements 
: statement t=statements
| controlFlowStmt marker statements
{
	if ($controlFlowStmt.nextlist != null && ! $controlFlowStmt.nextlist.isEmpty()) {
		printEmptyLine = true;
	}
	backpatch($controlFlowStmt.nextlist, $marker.label);
}
|
;



controlFlowStmtList returns [List<Integer> nextlist]
: controlFlowStmt
{
	$nextlist = $controlFlowStmt.nextlist;
}
| l1=controlFlowStmtList marker controlFlowStmt
{
	// Cannot backpatch continue and break statements here, so propagate up.
	List<Integer> contBreakList = new ArrayList<>();
	if ($l1.nextlist != null) {
		for (int line : $l1.nextlist) {
			if (line < 0)
				contBreakList.add(line);
		}

		$l1.nextlist.removeAll(contBreakList);
	}

	backpatch($l1.nextlist, $marker.label);
	$nextlist = merge($controlFlowStmt.nextlist, contBreakList);

}
;

// Special IDs:
// --  -6001 >= ID > -6999 : Used by "continue" statement to specify line 1 ~ 999 to jump to
// --  -5001 >= ID > -5999 : Used by    "break" statement to specify line 1 ~ 999 to jump to
controlFlowStmt returns [List<Integer> nextlist]
: '{' controlFlowStmtList '}'
{
	$nextlist = $controlFlowStmtList.nextlist;
}
| statement
{
	$nextlist = null;
}
| Brk ';'
{
	// instId for break will always lower than -5000 as a special pattern to recognize
	int instId = - (q.size + 5000);
	$nextlist = Arrays.asList(instId);
	q.Add(-1, -1, -1, "goto");
}
| Cnt ';'
{
	// instId for break will always lower than -6000 as a special pattern to recognize
	int instId = - (q.size + 6000);
	$nextlist = Arrays.asList(instId);
	q.Add(-1, -1, -1, "goto");
}
| If '(' booleanExpr ')' marker s=controlFlowStmt
{
	backpatch($booleanExpr.truelist, $marker.label);
	$nextlist = merge($booleanExpr.falselist, $s.nextlist);
}
| If '(' booleanExpr ')' m1=marker s1=controlFlowStmt nextLbl Else m2=marker s2=controlFlowStmt
{
	backpatch($booleanExpr.truelist, $m1.label);
	backpatch($booleanExpr.falselist, $m2.label);

	// Merging 3 lists
	$nextlist = merge( merge($s1.nextlist, $s2.nextlist), $nextLbl.nextlist );
}
| For forRangeStmt marker s=controlFlowStmt
{
	backpatch($forRangeStmt.truelist, $marker.label);

	// Backpatch $s.nextlist for id > 0
	List<Integer> backpatchList = new ArrayList<>();
	if ($s.nextlist != null) {
		for (int line : $s.nextlist) {
			if (line > 0) {
				backpatchList.add(line);
			}
		}
		backpatch(backpatchList, q.size);
		$s.nextlist.removeAll(backpatchList);
	}


	$nextlist = merge($forRangeStmt.falselist, $s.nextlist);


	// Detect if there is "continue" statement to backpatch
	List<Integer> contList = new ArrayList<>();
	List<Integer> contList_originalNum = new ArrayList<>();
	for (int line : $nextlist) {
		if (line < -6000) {
			contList.add( - (line + 6000) );
			contList_originalNum.add(line);
		}
	}
	backpatch(contList, q.size);
	$nextlist.removeAll(contList_originalNum);


	// Generate increment instruction in for loop
	int oneId = s.Find("1");
	if (oneId == -1) {
		oneId = s.insert("1", DataType.INT);
	}
	q.Add($forRangeStmt.identId, $forRangeStmt.identId, oneId, "+");
	q.Add($forRangeStmt.loopBackToLabel, -1, -1, "goto");



	// Detect if there is "break" statement to backpatch
	List<Integer> breakList = new ArrayList<>();
	List<Integer> breakList_originalNum = new ArrayList<>();
	for (int line : $nextlist) {
		if (line < -5000) {
			breakList.add( - (line + 5000) );
			breakList_originalNum.add(line);
		}
	}
	backpatch(breakList, q.size);
	$nextlist.removeAll(breakList_originalNum);
}
;

forRangeStmt returns [List<Integer> truelist, List<Integer> falselist, int loopBackToLabel, int identId]
: Ident '=' e1=expr ',' e2=expr
{
	$identId = s.Find($Ident.text);

	// eg. x = a, b will have
	// x = a and temp = x < b
	q.Add($identId, $e1.id, -1, "");

	// Will need to loop back to here, right after Ident = expr
	$loopBackToLabel = q.size;

	int comparisonResultId = s.Add(DataType.INT);
	q.Add(comparisonResultId, $identId, $e2.id, "<");

	$truelist = Arrays.asList(q.size);
	q.Add(-1, comparisonResultId, -1, "if");

	$falselist = Arrays.asList(q.size);
	q.Add(-1, comparisonResultId, -1, "ifFalse");

}
;



statement 
: location '=' expr ';'
{
	q.Add($location.id, $expr.id, -1, "");
}
| location '+=' expr ';'
{
	q.Add($location.id, $location.id, $expr.id, "+");
}
| location '-=' expr ';'
{
	q.Add($location.id, $location.id, $expr.id, "-");
}
| block

| method_call

| Ret expr ';'
{
	q.Add(-1, $expr.id, -1, "ret");
}
| Ret ';'
{
	q.Add(-1, -1, -1, "ret");
}
;

bExprTerm returns [int id]
: term
{
	$id = $term.id;
}
| e3=expr '+' t1=term
{
	$id = s.Add(s.GetType($e3.id));
	q.Add($id, $e3.id, $t1.id, "+");
}
| e4=expr '-' t2=term
{
	$id = s.Add(s.GetType($e4.id));
	q.Add($id, $e4.id, $t2.id, "-");
}
| '(' inner_expr=expr ')'
{
	$id = $inner_expr.id;
}
;

// marker -> {empty string}
// It records the current instruction id.
marker returns [int label]
: {
	$label = q.size;
};


// Used in If-Else statements to jump out of If part
nextLbl returns [List<Integer> nextlist]
: {
	$nextlist = Arrays.asList(q.size);
	q.Add(-1, -1, -1, "goto");
};

funcMarker returns [int label]
: {
	$label = q.size;
	q.Add(-1, -1, -1, "func_name");
};


booleanExpr returns [List<Integer> truelist, List<Integer> falselist]
: e1=bExprTerm RelOp e2=bExprTerm
{
	// Relational operation instruction id
	int id = s.Add(s.GetType($e1.id));
	q.Add(id, $e1.id, $e2.id, $RelOp.text);

	$truelist = Arrays.asList(q.size);
	q.Add(-1, id, -1, "if");
	
	$falselist = Arrays.asList(q.size);
	q.Add(-1, id, -1, "ifFalse");
}
| '(' b=booleanExpr ')'
{
	$truelist = $b.truelist;
	$falselist = $b.falselist;
}
| '!' b=booleanExpr
{
	$truelist = $b.falselist;
	$falselist = $b.truelist;
}
| b1=booleanExpr '&&' marker b2=booleanExpr
{
	backpatch($b1.truelist, $marker.label);
	$falselist = merge($b1.falselist, $b2.falselist);
	$truelist = $b2.truelist;
}
| b1=booleanExpr '||' marker b2=booleanExpr
{
	backpatch($b1.falselist, $marker.label);
	$truelist = merge($b1.truelist, $b2.truelist);
	$falselist = $b2.falselist;
}
| bExprTerm 
{

	$truelist = Arrays.asList(q.size);
	q.Add(-1, $bExprTerm.id, -1, "if");

	$falselist = Arrays.asList(q.size);
	q.Add(-1, $bExprTerm.id, -1, "ifFalse");
}
| 'true'
{
	$truelist = Arrays.asList(q.size);
	$falselist = null;
	q.Add(-1, -1, -1, "goto");
}
| 'false'
{
	$falselist = Arrays.asList(q.size);
	$truelist = null;
	q.Add(-1, -1, -1, "goto");
}
;


method_name returns [int id]
: Ident
{
	$id = s.Find($Ident.text);
}
;


expr_params returns [int count]
: expr nextParam=expr_params
{
	q.Add(-1, $expr.id, -1, "param");
	$count = ++$nextParam.count;
}
| ',' expr nextParam=expr_params
{
	q.Add(-1, $expr.id, -1, "param");
	$count = ++$nextParam.count;
}
|
;


callout_args returns [int count]
: ',' callout_arg c=callout_args
{
	$count = ++$c.count;
}
|
;


callout_arg
: expr
{
	q.Add(-1, $expr.id, -1, "param");
}
| Str
{
	int id = s.insert($Str.text, DataType.STRING);
	q.Add(-1, id, -1, "param");
}
;


method_call returns [int id]
: method_name '(' expr_params ')' ';'?
{
	$id = $method_name.id;

	// Generate perameter number
	int countNumber = s.Find(String.valueOf($expr_params.count));
	if (countNumber == -1) {
		countNumber = s.insert(String.valueOf($expr_params.count), DataType.INT);
	}

	// Do not generate a temp variable if the method return type is void
	if ( s.GetType(s.Find($method_name.text)) == DataType.INVALID ) {
		q.Add(-1, $id, countNumber, "call");
	} else {
		int destId = s.Add(DataType.INT);
		q.Add(destId, $id, countNumber, "call");
		$id = destId;
	}
}
| 'callout' '(' Str callout_args ')' ';'?
{
	$id = s.insert($Str.text, DataType.INVALID);

	// Generate perameter number
	int countNumber = s.Find(String.valueOf($callout_args.count));
	if (countNumber == -1) {
		countNumber = s.insert(String.valueOf($callout_args.count), DataType.INT);
	}
	q.Add(-1, $id, countNumber, "call");
}
;


expr returns [int id]
: term
{
	$id = $term.id;
}
| e1=expr binOp e2=expr
{
	$id = s.Add(s.GetType($e1.id));
	q.Add($id, $e1.id, $e2.id, $binOp.text);
}
| e3=expr '+' t1=term
{
	$id = s.Add(s.GetType($e3.id));
	q.Add($id, $e3.id, $t1.id, "+");
}
| e4=expr '-' t2=term
{
	$id = s.Add(s.GetType($e4.id));
	q.Add($id, $e4.id, $t2.id, "-");
}
| '(' inner_expr=expr ')'
{
	$id = $inner_expr.id;
}
;


term returns [int id]
: t1=term '%' expr
{
	int id1 = s.Add(s.GetType($t1.id));
	q.Add(id1, $t1.id, $expr.id, "/");
	int id2 = s.Add(s.GetType($t1.id));
	q.Add(id2, $t1.id, id1, "*");
	int id3 = s.Add(s.GetType($t1.id));
	q.Add(id3, $t1.id, id2, "-");
	$id = id3;
}
| t1=term ArithOp expr
{
	$id = s.Add(s.GetType($t1.id));
	q.Add($id, $t1.id, $expr.id, $ArithOp.text);
}
| literal 
{
	$id = $literal.id;
}
| location
{
	$id = $location.id;
}
| method_call
{
	$id = $method_call.id;
}
| '-' minus_expr=expr
{
	$id = s.Add(s.GetType($minus_expr.id));

	int zero = s.Find("0");
	if (zero == -1) {
		zero = s.insert("0", DataType.INT);
	}
	q.Add($id, zero, $minus_expr.id, "-");
}
| '!' exclaim_expr=expr
{
	$id = s.Add(s.GetType($exclaim_expr.id));
	q.Add($id, $exclaim_expr.id, -1, "!");
}
| '(' inner_expr=expr ')'
{
	$id = $inner_expr.id;
}
;


location returns [int id]
:Ident
{
	$id = s.Find($Ident.text);
}
| Ident '[' expr ']' 
{
	$id = s.Add(DataType.INT);
	int fourId = s.Find("4");
	if (fourId == -1) {
		fourId = s.insert("4", DataType.INT);
	}
	q.Add($id, $expr.id, fourId, "*");
	$id = s.insert($Ident.text + "[ " + s.GetName($id) + " ] ", s.GetType($id));
}
;


num
: DecNum
| HexNum
;

literal returns [int id]
: num
{
	$id = s.insert($num.text, DataType.INT);
}
| Char
{
	$id = s.insert($Char.text, DataType.INVALID);
}
| BoolLit
{
	$id = s.insert($BoolLit.text, DataType.BOOLEAN);
}
;

eqOp
: '='
| AssignOp
;

boolOp
: '!'
| CondOp
;

binOp
: RelOp
| CondOp
;


//--------------------------------------------- END OF SESSION 2 -----------------------------------


//---------------------------------------------------------------------------------------------------
// Session 3: Lexical definition, You SHOULD NOT make any modification to this session
//---------------------------------------------------------------------------------------------------
fragment Delim
: ' '
| '\t'
| '\n'
;

fragment Letter
: [a-zA-Z]
;

fragment Digit
: [0-9]
;

fragment HexDigit
: Digit
| [a-f]
| [A-F]
;

fragment Alpha
: Letter
| '_'
;

fragment AlphaNum
: Alpha
| Digit
;


WhiteSpace
: Delim+ -> skip
;



Char
: '\'' ~('\\') '\''
| '\'\\' . '\'' 
;

Str
:'"' ((~('\\' | '"')) | ('\\'.))* '"'
; 



Class
: 'class'
;

Program
: 'Program'
;

Void
: 'void'
;

If
: 'if'
;

Else
: 'else'
;

For
: 'for'
;

Ret
: 'return'
;

Brk
: 'break'
;

Cnt
: 'continue'
;

Callout
: 'callout'
;

DecNum
: Digit+
;


HexNum
: '0x'HexDigit+
;

BoolLit
: 'true'
| 'false'
;



RelOp
: '<='
| '>=' 
| '<'
| '>'
| '=='
| '!='
;

AssignOp
: '+='
| '-='
;

ArithOp
: '*'
| '/'
| '%'
;

CondOp
: '&&'
| '||'
;



Type
: 'int'
| 'boolean'
;

Ident
: Alpha AlphaNum* 
;






