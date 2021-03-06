//### This file created by BYACC 1.8(/Java extension  1.15)
//### Java capabilities added 7 Jan 97, Bob Jamison
//### Updated : 27 Nov 97  -- Bob Jamison, Joe Nieten
//###           01 Jan 98  -- Bob Jamison -- fixed generic semantic constructor
//###           01 Jun 99  -- Bob Jamison -- added Runnable support
//###           06 Aug 00  -- Bob Jamison -- made state variables class-global
//###           03 Jan 01  -- Bob Jamison -- improved flags, tracing
//###           16 May 01  -- Bob Jamison -- added custom stack sizing
//###           04 Mar 02  -- Yuval Oren  -- improved java performance, added options
//###           14 Mar 02  -- Tomas Hurka -- -d support, static initializer workaround
//### Please send bug reports to tom@hukatronic.cz
//### static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";



package asintactico;



//#line 3 "/home/pablo/Escritorio/repo/Compiladores-master/Proyectos/Proyecto2/src/main/byaccj/parser.y"

import java.io.*;

//#line 21 "Parser.java"




public class Parser
{

boolean yydebug;        //do I want debug output?
int yynerrs;            //number of errors so far
int yyerrflag;          //was there an error?
int yychar;             //the current working character

//########## MESSAGES ##########
//###############################################################
// method: debug
//###############################################################
void debug(String msg)
{
  if (yydebug)
    System.out.println(msg);
}

//########## STATE STACK ##########
final static int YYSTACKSIZE = 500;  //maximum stack size
int statestk[] = new int[YYSTACKSIZE]; //state stack
int stateptr;
int stateptrmax;                     //highest index of stackptr
int statemax;                        //state when highest index reached
//###############################################################
// methods: state stack push,pop,drop,peek
//###############################################################
final void state_push(int state)
{
  try {
		stateptr++;
		statestk[stateptr]=state;
	 }
	 catch (ArrayIndexOutOfBoundsException e) {
     int oldsize = statestk.length;
     int newsize = oldsize * 2;
     int[] newstack = new int[newsize];
     System.arraycopy(statestk,0,newstack,0,oldsize);
     statestk = newstack;
     statestk[stateptr]=state;
  }
}
final int state_pop()
{
  return statestk[stateptr--];
}
final void state_drop(int cnt)
{
  stateptr -= cnt; 
}
final int state_peek(int relative)
{
  return statestk[stateptr-relative];
}
//###############################################################
// method: init_stacks : allocate and prepare stacks
//###############################################################
final boolean init_stacks()
{
  stateptr = -1;
  val_init();
  return true;
}
//###############################################################
// method: dump_stacks : show n levels of the stacks
//###############################################################
void dump_stacks(int count)
{
int i;
  System.out.println("=index==state====value=     s:"+stateptr+"  v:"+valptr);
  for (i=0;i<count;i++)
    System.out.println(" "+i+"    "+statestk[i]+"      "+valstk[i]);
  System.out.println("======================");
}


//########## SEMANTIC VALUES ##########
//public class ParserVal is defined in ParserVal.java


String   yytext;//user variable to return contextual strings
ParserVal yyval; //used to return semantic vals from action routines
ParserVal yylval;//the 'lval' (result) I got from yylex()
ParserVal valstk[];
int valptr;
//###############################################################
// methods: value stack push,pop,drop,peek.
//###############################################################
void val_init()
{
  valstk=new ParserVal[YYSTACKSIZE];
  yyval=new ParserVal();
  yylval=new ParserVal();
  valptr=-1;
}
void val_push(ParserVal val)
{
  if (valptr>=YYSTACKSIZE)
    return;
  valstk[++valptr]=val;
}
ParserVal val_pop()
{
  if (valptr<0)
    return new ParserVal();
  return valstk[valptr--];
}
void val_drop(int cnt)
{
int ptr;
  ptr=valptr-cnt;
  if (ptr<0)
    return;
  valptr = ptr;
}
ParserVal val_peek(int relative)
{
int ptr;
  ptr=valptr-relative;
  if (ptr<0)
    return new ParserVal();
  return valstk[ptr];
}
final ParserVal dup_yyval(ParserVal val)
{
  ParserVal dup = new ParserVal();
  dup.ival = val.ival;
  dup.dval = val.dval;
  dup.sval = val.sval;
  dup.obj = val.obj;
  return dup;
}
//#### end semantic value section ####
public final static short SALTO=257;
public final static short EQUAL=258;
public final static short PRINT=259;
public final static short IF=260;
public final static short COLON=261;
public final static short ELSE=262;
public final static short WHILE=263;
public final static short INDENTA=264;
public final static short OR=265;
public final static short AND=266;
public final static short NOT=267;
public final static short LESS=268;
public final static short MORE=269;
public final static short DEQ=270;
public final static short LEQ=271;
public final static short GEQ=272;
public final static short DIFF=273;
public final static short PLUS=274;
public final static short MINUS=275;
public final static short TIMES=276;
public final static short DIVIDE=277;
public final static short MODULO=278;
public final static short DASH=279;
public final static short BY=280;
public final static short ID=281;
public final static short ENTERO=282;
public final static short REAL=283;
public final static short BOOLEANO=284;
public final static short LEFTP=285;
public final static short RIGHTP=286;
public final static short DEINDENTA=287;
public final static short CADENA=288;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    0,    1,    1,    2,    2,    3,    3,    4,    6,
    6,    7,    7,    8,    5,    5,   10,   10,   11,   12,
   12,   13,   13,    9,   14,   16,   16,   15,   18,   18,
   17,   17,   19,   21,   21,   22,   22,   22,   22,   22,
   22,   20,   24,   24,   24,   23,   26,   26,   26,   26,
   26,   25,   25,   25,   27,   27,   28,   28,   28,   28,
   28,   28,
};
final static short yylen[] = {                            2,
    1,    1,    2,    0,    2,    0,    1,    1,    2,    1,
    1,    1,    3,    2,    1,    1,    4,    7,    4,    1,
    5,    2,    0,    1,    2,    3,    0,    2,    3,    0,
    2,    2,    2,    3,    0,    1,    1,    1,    1,    1,
    1,    2,    3,    3,    0,    2,    3,    3,    3,    3,
    0,    2,    2,    1,    1,    3,    1,    1,    1,    1,
    1,    3,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,    0,    0,    1,    2,    0,    7,
    8,    0,   10,   11,    0,   15,   16,   24,    0,    0,
    3,   14,    0,    0,    0,    0,   57,   58,   60,   61,
    0,   59,   31,   32,    0,    0,    0,   54,    0,    5,
    9,    0,    0,   25,    0,   28,    0,    0,   52,   53,
    0,   36,   37,   38,   40,   39,   41,   33,    0,    0,
    0,   42,    0,    0,    0,    0,   46,    0,   13,    0,
    0,    0,   20,    0,   19,   62,    0,    0,    0,    0,
    0,    0,    0,   56,   26,   29,    0,    0,   34,   43,
   44,   47,   48,   49,   50,    0,    0,    0,    0,   18,
   22,   21,
};
final static short yydgoto[] = {                          6,
    7,    8,    9,   10,   11,   12,   13,   14,   15,   16,
   17,   74,   99,   18,   19,   44,   20,   46,   34,   35,
   58,   59,   36,   62,   37,   67,   38,   39,
};
final static short yysindex[] = {                      -155,
 -248, -249, -249, -249, -160,    0,    0,    0, -118,    0,
    0, -236,    0,    0, -224,    0,    0,    0, -217, -225,
    0,    0, -210, -203, -148, -148,    0,    0,    0,    0,
 -249,    0,    0,    0, -117, -261, -240,    0, -221,    0,
    0, -249, -249,    0, -249,    0, -128, -128,    0,    0,
 -226,    0,    0,    0,    0,    0,    0,    0, -148, -148,
 -148,    0, -148, -148, -148, -148,    0, -148,    0, -217,
 -225, -201,    0, -156,    0,    0, -117, -261, -261, -240,
 -240, -240, -240,    0,    0,    0, -118, -184,    0,    0,
    0,    0,    0,    0,    0, -118, -128, -118, -208,    0,
    0,    0,
};
final static short yyrindex[] = {                        94,
   94,    0,    0,    0,    0,    0,    0,    0,   96,    0,
    0,    0,    0,    0, -147,    0,    0,    0, -183, -166,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0, -168, -185, -204,    0, -246,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0, -183,
 -166,    0,    0,    1,    0,    0, -168, -185, -185, -204,
 -204, -204, -204,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0, -174,    0, -174,    0,    0,
    0,    0,
};
final static short yygindex[] = {                         0,
  115,  108,   13,  -45,    0,    0,    0,    0,    4,    0,
    0,  -48,   21,    0,   87,   62,    5,   67,    0,   84,
   69,    0,  -44,  -23,  -21,   77,    0,    0,
};
final static int YYTABLESIZE=288;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         75,
   17,   73,   73,   49,   50,   22,   23,   24,    1,   33,
   55,   55,   60,   61,   55,   78,   79,    5,   55,   55,
   41,   55,   55,   55,   55,   55,   55,   55,   55,   55,
   55,   55,   55,   42,   51,   63,   64,   65,   66,   55,
   45,   80,   81,   82,   83,   69,   84,   43,  100,   71,
   47,   73,   51,   51,   90,   91,   51,   48,   68,   76,
   51,   51,   87,   51,   51,   51,   51,   51,   51,   51,
   51,   45,   45,   27,   27,   45,   97,   27,  102,   45,
   45,   51,   45,   45,   45,   45,   45,   45,   35,   35,
   30,   30,   35,    4,   30,    6,   35,   35,   30,   96,
   45,    1,   27,    2,    3,   88,    5,    4,   98,   12,
   98,    5,   23,   25,   26,   21,   40,   35,  101,   30,
   27,   28,   29,   30,   31,   25,   26,   32,   72,   70,
    2,   85,   27,   28,   29,   30,   31,   86,    5,   32,
    2,    3,   77,    0,    4,   89,    0,    0,    5,    0,
   52,   53,   54,   55,   56,   57,   92,   93,   94,   95,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   17,
   17,    0,    0,   17,    0,    0,    0,   17,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   17,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         48,
    0,   47,   48,   25,   26,    2,    3,    4,  257,    5,
  257,  258,  274,  275,  261,   60,   61,  267,  265,  266,
  257,  268,  269,  270,  271,  272,  273,  274,  275,  276,
  277,  278,  279,  258,   31,  276,  277,  278,  279,  286,
  266,   63,   64,   65,   66,   42,   68,  265,   97,   45,
  261,   97,  257,  258,   78,   79,  261,  261,  280,  286,
  265,  266,  264,  268,  269,  270,  271,  272,  273,  274,
  275,  257,  258,  257,  258,  261,  261,  261,  287,  265,
  266,  286,  268,  269,  270,  271,  272,  273,  257,  258,
  257,  258,  261,    0,  261,    0,  265,  266,  265,   87,
  286,  257,  286,  259,  260,  262,  267,  263,   96,  257,
   98,  267,  287,  274,  275,    1,    9,  286,   98,  286,
  281,  282,  283,  284,  285,  274,  275,  288,  257,   43,
  259,   70,  281,  282,  283,  284,  285,   71,  267,  288,
  259,  260,   59,   -1,  263,   77,   -1,   -1,  267,   -1,
  268,  269,  270,  271,  272,  273,   80,   81,   82,   83,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  259,
  260,   -1,   -1,  263,   -1,   -1,   -1,  267,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  287,
};
}
final static short YYFINAL=6;
final static short YYMAXTOKEN=288;
final static String yyname[] = {
"end-of-file",null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,"SALTO","EQUAL","PRINT","IF","COLON","ELSE","WHILE","INDENTA",
"OR","AND","NOT","LESS","MORE","DEQ","LEQ","GEQ","DIFF","PLUS","MINUS","TIMES",
"DIVIDE","MODULO","DASH","BY","ID","ENTERO","REAL","BOOLEANO","LEFTP","RIGHTP",
"DEINDENTA","CADENA",
};
final static String yyrule[] = {
"$accept : fileinput",
"fileinput : aux7",
"fileinput : aux8",
"aux7 : SALTO aux7",
"aux7 :",
"aux8 : stmt aux8",
"aux8 :",
"stmt : simplestmt",
"stmt : compoundstmt",
"simplestmt : smallstmt SALTO",
"smallstmt : exprstmt",
"smallstmt : printstmt",
"exprstmt : test",
"exprstmt : test EQUAL test",
"printstmt : PRINT test",
"compoundstmt : ifstmt",
"compoundstmt : whilestmt",
"ifstmt : IF test COLON suite",
"ifstmt : IF test COLON suite ELSE COLON suite",
"whilestmt : WHILE test COLON suite",
"suite : simplestmt",
"suite : SALTO INDENTA stmt aux DEINDENTA",
"aux : stmt aux",
"aux :",
"test : ortest",
"ortest : andtest aux2",
"aux2 : OR andtest aux2",
"aux2 :",
"andtest : nottest aux3",
"aux3 : AND nottest aux3",
"aux3 :",
"nottest : NOT nottest",
"nottest : NOT comparison",
"comparison : expr aux4",
"aux4 : compop expr aux4",
"aux4 :",
"compop : LESS",
"compop : MORE",
"compop : DEQ",
"compop : GEQ",
"compop : LEQ",
"compop : DIFF",
"expr : term aux5",
"aux5 : PLUS term aux5",
"aux5 : MINUS term aux5",
"aux5 :",
"term : factor aux6",
"aux6 : TIMES factor aux6",
"aux6 : DIVIDE factor aux6",
"aux6 : MODULO factor aux6",
"aux6 : DASH factor aux6",
"aux6 :",
"factor : PLUS factor",
"factor : MINUS factor",
"factor : power",
"power : atom",
"power : atom BY factor",
"atom : ID",
"atom : ENTERO",
"atom : CADENA",
"atom : REAL",
"atom : BOOLEANO",
"atom : LEFTP test RIGHTP",
};

//#line 124 "/home/pablo/Escritorio/repo/Compiladores-master/Proyectos/Proyecto2/src/main/byaccj/parser.y"

private Flexer alexico;

// Regresar átomos
private int yylex() {
  int yyl_return = -1;

  try{
    yyl_return = alexico.yylex();

  }catch (IOException e){
    System.err.println("Error de IO." + e);
  }
  return yyl_return;
}

public void yyerror (String error){
  System.err.println("[ERROR] " +error);
  System.exit(2);
}

public Parser(Reader r){
  alexico = new Flexer(r,this);
}

public static void main(String args[]){
  try{
   Parser yyparser = new Parser(new FileReader(args[0]));
   yyparser.yydebug = true;
   yyparser.yyparse();
  }catch(FileNotFoundException e){
    System.err.println("El Archivo " + args[0] + " no existe.");
  }

}
//#line 387 "Parser.java"
//###############################################################
// method: yylexdebug : check lexer state
//###############################################################
void yylexdebug(int state,int ch)
{
String s=null;
  if (ch < 0) ch=0;
  if (ch <= YYMAXTOKEN) //check index bounds
     s = yyname[ch];    //now get it
  if (s==null)
    s = "illegal-symbol";
  debug("state "+state+", reading "+ch+" ("+s+")");
}





//The following are now global, to aid in error reporting
int yyn;       //next next thing to do
int yym;       //
int yystate;   //current parsing state from state table
String yys;    //current token string


//###############################################################
// method: yyparse : parse input and execute indicated items
//###############################################################
int yyparse()
{
boolean doaction;
  init_stacks();
  yynerrs = 0;
  yyerrflag = 0;
  yychar = -1;          //impossible char forces a read
  yystate=0;            //initial state
  state_push(yystate);  //save it
  val_push(yylval);     //save empty value
  while (true) //until parsing is done, either correctly, or w/error
    {
    doaction=true;
    if (yydebug) debug("loop"); 
    //#### NEXT ACTION (from reduction table)
    for (yyn=yydefred[yystate];yyn==0;yyn=yydefred[yystate])
      {
      if (yydebug) debug("yyn:"+yyn+"  state:"+yystate+"  yychar:"+yychar);
      if (yychar < 0)      //we want a char?
        {
        yychar = yylex();  //get next token
        if (yydebug) debug(" next yychar:"+yychar);
        //#### ERROR CHECK ####
        if (yychar < 0)    //it it didn't work/error
          {
          yychar = 0;      //change it to default string (no -1!)
          if (yydebug)
            yylexdebug(yystate,yychar);
          }
        }//yychar<0
      yyn = yysindex[yystate];  //get amount to shift by (shift index)
      if ((yyn != 0) && (yyn += yychar) >= 0 &&
          yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
        {
        if (yydebug)
          debug("state "+yystate+", shifting to state "+yytable[yyn]);
        //#### NEXT STATE ####
        yystate = yytable[yyn];//we are in a new state
        state_push(yystate);   //save it
        val_push(yylval);      //push our lval as the input for next rule
        yychar = -1;           //since we have 'eaten' a token, say we need another
        if (yyerrflag > 0)     //have we recovered an error?
           --yyerrflag;        //give ourselves credit
        doaction=false;        //but don't process yet
        break;   //quit the yyn=0 loop
        }

    yyn = yyrindex[yystate];  //reduce
    if ((yyn !=0 ) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
      {   //we reduced!
      if (yydebug) debug("reduce");
      yyn = yytable[yyn];
      doaction=true; //get ready to execute
      break;         //drop down to actions
      }
    else //ERROR RECOVERY
      {
      if (yyerrflag==0)
        {
        yyerror("syntax error");
        yynerrs++;
        }
      if (yyerrflag < 3) //low error count?
        {
        yyerrflag = 3;
        while (true)   //do until break
          {
          if (stateptr<0)   //check for under & overflow here
            {
            yyerror("stack underflow. aborting...");  //note lower case 's'
            return 1;
            }
          yyn = yysindex[state_peek(0)];
          if ((yyn != 0) && (yyn += YYERRCODE) >= 0 &&
                    yyn <= YYTABLESIZE && yycheck[yyn] == YYERRCODE)
            {
            if (yydebug)
              debug("state "+state_peek(0)+", error recovery shifting to state "+yytable[yyn]+" ");
            yystate = yytable[yyn];
            state_push(yystate);
            val_push(yylval);
            doaction=false;
            break;
            }
          else
            {
            if (yydebug)
              debug("error recovery discarding state "+state_peek(0)+" ");
            if (stateptr<0)   //check for under & overflow here
              {
              yyerror("Stack underflow. aborting...");  //capital 'S'
              return 1;
              }
            state_pop();
            val_pop();
            }
          }
        }
      else            //discard this token
        {
        if (yychar == 0)
          return 1; //yyabort
        if (yydebug)
          {
          yys = null;
          if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
          if (yys == null) yys = "illegal-symbol";
          debug("state "+yystate+", error recovery discards token "+yychar+" ("+yys+")");
          }
        yychar = -1;  //read another
        }
      }//end error recovery
    }//yyn=0 loop
    if (!doaction)   //any reason not to proceed?
      continue;      //skip action
    yym = yylen[yyn];          //get count of terminals on rhs
    if (yydebug)
      debug("state "+yystate+", reducing "+yym+" by rule "+yyn+" ("+yyrule[yyn]+")");
    if (yym>0)                 //if count of rhs not 'nil'
      yyval = val_peek(yym-1); //get current semantic value
    yyval = dup_yyval(yyval); //duplicate yyval if ParserVal is used as semantic value
    switch(yyn)
      {
//########## USER-SUPPLIED ACTIONS ##########
case 1:
//#line 15 "/home/pablo/Escritorio/repo/Compiladores-master/Proyectos/Proyecto2/src/main/byaccj/parser.y"
{System.out.println("[OK]");}
break;
case 2:
//#line 16 "/home/pablo/Escritorio/repo/Compiladores-master/Proyectos/Proyecto2/src/main/byaccj/parser.y"
{System.out.println("[OK]");}
break;
//#line 544 "Parser.java"
//########## END OF USER-SUPPLIED ACTIONS ##########
    }//switch
    //#### Now let's reduce... ####
    if (yydebug) debug("reduce");
    state_drop(yym);             //we just reduced yylen states
    yystate = state_peek(0);     //get new state
    val_drop(yym);               //corresponding value drop
    yym = yylhs[yyn];            //select next TERMINAL(on lhs)
    if (yystate == 0 && yym == 0)//done? 'rest' state and at first TERMINAL
      {
      if (yydebug) debug("After reduction, shifting from state 0 to state "+YYFINAL+"");
      yystate = YYFINAL;         //explicitly say we're done
      state_push(YYFINAL);       //and save it
      val_push(yyval);           //also save the semantic value of parsing
      if (yychar < 0)            //we want another character?
        {
        yychar = yylex();        //get next character
        if (yychar<0) yychar=0;  //clean, if necessary
        if (yydebug)
          yylexdebug(yystate,yychar);
        }
      if (yychar == 0)          //Good exit (if lex returns 0 ;-)
         break;                 //quit the loop--all DONE
      }//if yystate
    else                        //else not done yet
      {                         //get next state and push, for next yydefred[]
      yyn = yygindex[yym];      //find out where to go
      if ((yyn != 0) && (yyn += yystate) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yystate)
        yystate = yytable[yyn]; //get new state
      else
        yystate = yydgoto[yym]; //else go to new defred
      if (yydebug) debug("after reduction, shifting from state "+state_peek(0)+" to state "+yystate+"");
      state_push(yystate);     //going again, so push state & val...
      val_push(yyval);         //for next action
      }
    }//main loop
  return 0;//yyaccept!!
}
//## end of method parse() ######################################



//## run() --- for Thread #######################################
/**
 * A default run method, used for operating this parser
 * object in the background.  It is intended for extending Thread
 * or implementing Runnable.  Turn off with -Jnorun .
 */
public void run()
{
  yyparse();
}
//## end of method run() ########################################



//## Constructors ###############################################
/**
 * Default constructor.  Turn off with -Jnoconstruct .

 */
public Parser()
{
  //nothing to do
}


/**
 * Create a parser, setting the debug to true or false.
 * @param debugMe true for debugging, false for no debug.
 */
public Parser(boolean debugMe)
{
  yydebug=debugMe;
}
//###############################################################



}
//################### END OF CLASS ##############################
