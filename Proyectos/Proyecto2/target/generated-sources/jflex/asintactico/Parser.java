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



//#line 3 "/home/alexis/Documents/Compiladores/Compiladores/Proyectos/Proyecto2/src/main/byaccj/parser.y"

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
    0,    0,    0,    1,    1,    2,    4,    4,    5,    5,
    6,    3,    3,    8,    8,    9,   10,   10,   11,   11,
    7,   12,   14,   14,   13,   16,   16,   15,   15,   17,
   19,   19,   20,   20,   20,   20,   20,   20,   18,   22,
   22,   22,   21,   24,   24,   24,   24,   24,   23,   23,
   23,   25,   25,   26,   26,   26,   26,   26,   26,
};
final static short yylen[] = {                            2,
    0,    2,    2,    1,    1,    2,    1,    1,    1,    3,
    2,    1,    1,    4,    7,    4,    1,    5,    2,    0,
    1,    2,    3,    0,    2,    3,    0,    2,    2,    2,
    3,    0,    1,    1,    1,    1,    1,    1,    2,    3,
    3,    0,    2,    3,    3,    3,    3,    0,    2,    2,
    1,    1,    3,    1,    1,    1,    1,    1,    3,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    4,    5,    0,
    7,    8,    0,   12,   13,   21,    0,    0,    2,   11,
    0,    0,    0,    0,   54,   55,   57,   58,    0,   56,
   28,   29,    0,    0,    0,   51,    0,    3,    6,    0,
    0,   22,    0,   25,    0,    0,   49,   50,    0,   33,
   34,   35,   37,   36,   38,   30,    0,    0,    0,   39,
    0,    0,    0,    0,   43,    0,   10,    0,    0,    0,
   17,    0,   16,   59,    0,    0,    0,    0,    0,    0,
    0,   53,   23,   26,    0,    0,   31,   40,   41,   44,
   45,   46,   47,    0,    0,    0,    0,   15,   19,   18,
};
final static short yydgoto[] = {                          6,
    7,    8,    9,   10,   11,   12,   13,   14,   15,   72,
   97,   16,   17,   42,   18,   44,   32,   33,   56,   57,
   34,   60,   35,   65,   36,   37,
};
final static short yysindex[] = {                      -145,
 -145, -260, -260, -260, -154,    0, -145,    0,    0, -243,
    0,    0, -240,    0,    0,    0, -239, -232,    0,    0,
 -225, -210, -142, -142,    0,    0,    0,    0, -260,    0,
    0,    0, -114, -250, -141,    0, -221,    0,    0, -260,
 -260,    0, -260,    0, -246, -246,    0,    0, -226,    0,
    0,    0,    0,    0,    0,    0, -142, -142, -142,    0,
 -142, -142, -142, -142,    0, -142,    0, -239, -232, -201,
    0, -184,    0,    0, -114, -250, -250, -141, -141, -141,
 -141,    0,    0,    0, -115, -182,    0,    0,    0,    0,
    0,    0,    0, -115, -246, -115, -206,    0,    0,    0,
};
final static short yyrindex[] = {                        83,
   83,    0,    0,    0,    0,    0,   83,    0,    0,    0,
    0,    0, -171,    0,    0,    0, -160, -228,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0, -238, -162, -181,    0, -204,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0, -160, -228,    0,
    0,    1,    0,    0, -238, -162, -162, -181, -181, -181,
 -181,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0, -187,    0, -187,    0,    0,    0,    0,
};
final static short yygindex[] = {                        15,
  -79,  -43,    0,    0,    0,    0,    6,    0,    0,  -46,
   20,    0,   61,   49,    7,   50,    0,   66,   72,    0,
  -27,  -21,  -19,  -40,    0,    0,
};
final static int YYTABLESIZE=288;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         73,
   14,   71,   71,   47,   48,   94,    5,   20,   21,   22,
   70,   31,    2,   39,   96,   19,   96,   40,   32,   32,
    5,   38,   32,   58,   59,   41,   32,   32,   27,   27,
   76,   77,   27,   43,   49,   45,   27,   90,   91,   92,
   93,   78,   79,   80,   81,   67,   82,   32,   98,   69,
   46,   71,   52,   52,   88,   89,   52,   27,   66,   74,
   52,   52,   85,   52,   52,   52,   52,   52,   52,   52,
   52,   52,   52,   52,   52,   48,   48,   86,   95,   48,
  100,   52,    1,   48,   48,    9,   48,   48,   48,   48,
   48,   48,   48,   48,   42,   42,   24,   24,   42,   20,
   24,   68,   42,   42,   48,   42,   42,   42,   42,   42,
   42,    1,    5,    2,    3,   99,   83,    4,   84,   23,
   24,    5,   75,   42,    0,   24,   25,   26,   27,   28,
   29,   23,   24,   30,   61,   62,   63,   64,   25,   26,
   27,   28,   29,    2,    3,   30,   87,    4,    0,    0,
    0,    5,    0,   50,   51,   52,   53,   54,   55,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   14,    0,   14,
   14,    0,    0,   14,    0,    0,    0,   14,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   14,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         46,
    0,   45,   46,   23,   24,   85,  267,    2,    3,    4,
  257,    5,  259,  257,   94,    1,   96,  258,  257,  258,
  267,    7,  261,  274,  275,  265,  265,  266,  257,  258,
   58,   59,  261,  266,   29,  261,  265,   78,   79,   80,
   81,   61,   62,   63,   64,   40,   66,  286,   95,   43,
  261,   95,  257,  258,   76,   77,  261,  286,  280,  286,
  265,  266,  264,  268,  269,  270,  271,  272,  273,  274,
  275,  276,  277,  278,  279,  257,  258,  262,  261,  261,
  287,  286,    0,  265,  266,  257,  268,  269,  270,  271,
  272,  273,  274,  275,  257,  258,  257,  258,  261,  287,
  261,   41,  265,  266,  286,  268,  269,  270,  271,  272,
  273,  257,  267,  259,  260,   96,   68,  263,   69,  274,
  275,  267,   57,  286,   -1,  286,  281,  282,  283,  284,
  285,  274,  275,  288,  276,  277,  278,  279,  281,  282,
  283,  284,  285,  259,  260,  288,   75,  263,   -1,   -1,
   -1,  267,   -1,  268,  269,  270,  271,  272,  273,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  257,   -1,  259,
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
"fileinput :",
"fileinput : SALTO fileinput",
"fileinput : stmt fileinput",
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

//#line 117 "/home/alexis/Documents/Compiladores/Compiladores/Proyectos/Proyecto2/src/main/byaccj/parser.y"

private Letras alexico;

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
  alexico = new Letras(r,this);
}

public static void main(String args[]){
  try{
   Parser yyparser = new Parser(new FileReader(args[0]));
   yyparser.yyparse();
  }catch(FileNotFoundException e){
    System.err.println("El Archivo " + args[0] + " no existe.");
  }

}
//#line 378 "Parser.java"
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
//#line 15 "/home/alexis/Documents/Compiladores/Compiladores/Proyectos/Proyecto2/src/main/byaccj/parser.y"
{System.out.println("[OK]");}
break;
case 2:
//#line 16 "/home/alexis/Documents/Compiladores/Compiladores/Proyectos/Proyecto2/src/main/byaccj/parser.y"
{System.out.println("[OK]");}
break;
case 3:
//#line 17 "/home/alexis/Documents/Compiladores/Compiladores/Proyectos/Proyecto2/src/main/byaccj/parser.y"
{System.out.println("[OK]");}
break;
//#line 539 "Parser.java"
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
