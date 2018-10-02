// tokens.flex

package asintactico;
import java.util.*;

%%
%public
%class Flexer
%unicode
%line
%standalone
%line

%{
    private Parser yyparser;

    /** Nuevo constructor
    * @param FileReader r
    * @param parser parser - parser
    */
    public Flexer(java.io.Reader r, Parser parser){
    	   this(r);
    	   yyparser = parser;
    }

	Stack<Integer> indentaciones = new Stack<Integer>();
	int espacios = 0;
	int contadorIndentaciones = 0;

	public void analiza(int espacios){
		if(indentaciones.empty()){
			if(espacios == 0){
				//System.out.printf("%s(%s)",lexema,yytext());
			}else{
				//System.out.printf("INDENTA(%d)",espacios);
				//System.out.printf("%s(%s)",lexema,yytext());
				indentaciones.push(espacios);
			}
		}else{
			if(espacios == 0){
				while(!indentaciones.empty()){
					//System.out.printf("DEINDENTA(%d)\n",indentaciones.pop());
				}
				//System.out.printf("%s(%s)",lexema,yytext());
			}else if(espacios < indentaciones.peek()){
				while (espacios < indentaciones.peek()) {
					//System.out.printf("DEINDENTA(%d)\n",espacios);
                    indentaciones.pop();
				}
				//System.out.printf("%s(%s)",lexema,yytext());
			}else if(espacios == indentaciones.peek()){
				
				
				//System.out.printf("%s(%s)",lexema,yytext());
			}else{
				//System.out.printf("INDENTA(%d)",espacios);
				//System.out.printf("%s(%s)",lexema,yytext());
				indentaciones.push(espacios);
				contadorIndentaciones = 1;
			}
		}
		espacios = 0;
		yybegin(YYINITIAL);
}
%}


ESPACIO        = " "
ENTERO         = 0 | [1-9][0-9]*
BOOLEANO       = ("True" | "False")
REAL           = "."[0-9]+ | {ENTERO}"."[0-9]+ | {ENTERO}"."
EQUAL          = "="
PRINT          = "print"
IF             = "if"
COLON          = ":"
ELSE           = "else"
WHILE          = "while"
OR             = "or"
AND            = "and"
NOT            = "not"
LESS           = "<"
MORE           = ">"
DEQ            = "=="
GEQ            = ">="
LEQ            = "<="
DIFF           = "!="
PLUS           = "+"
MINUS          = "-"
TIMES          = "*"
DIVIDE         = "/"
MODULO         = "%"
DASH           = "//"
BY             = "**"
ID             = ("_"|[a-z]|[A-Z])("_"|[a-z]|[A-Z]|{ENTERO})*
LEFTP          = "("
RIGHTP         = ")"
CADENAINVALIDA = (\".*)+ (\".*|\\.*) + (\")
CADENA         = (\".*)(\")
SALTO          = "\n"

%state INDENTA

%%
<YYINITIAL> {
  \# ~"\n" 	    {/*IGNORAR*/}
  {ESPACIO}         {/*IGNORAR*/}
  "True"            { yyparser.yylval = new ParserVal(Integer.parseBoolean(yytext())); return Parser.BOOLEANO;}
  "False"           { yyparser.yylval = new ParserVal(Integer.parseBoolean(yytext())); return Parser.BOOLEANO;}
  {ENTERO}          { yyparser.yylval = new ParserVal(Integer.parseInt(yytext())); return Parset.ENTERO;}
  {REAL}	        { yyparser.yylval = new ParserVal(Integer.parseInt(yytext())); return Parser.REAL;}
  {EQUAL}           { yyparser.yylval = new ParserVal(yytext()); return Parser.EQUAL;}
  {PRINT}           { yyparser.yylval = new ParserVal (yytext()); return Parser.PRINT;}
  {IF}              { yyparser.yylval = new ParserVal (yytext()); return Parser.IF;}
  {COLON}           { yyparser.yylval = new ParserVal (yytext()); return Parser.COLON;}
  {ELSE}            { yyparser.yylval = new ParserVal (yytext()); return Parser.ELSE;}
  {WHILE}           { yyparser.yylval = new ParserVal (yytext()); return Parser.WHILE;}
  {OR}              { yyparser.yylval = new ParserVal (yytext()); return Parser.OR;}
  {AND}             { yyparser.yylval = new ParserVal (yytext()); return Parser.AND;}
  {NOT}             { yyparser.yylval = new ParserVal (yytext()); return Parser.NOT;}
  {LESS}            { yyparser.yylval = new ParserVal (yytext()); return Parser.LESS;}
  {MORE}            { yyparser.yylval = new ParserVal (yytext()); return Parser.MORE;}
  {DEQ}             { yyparser.yylval = new ParserVal (yytext()); return Parser.DEQ;}
  {GEQ}             { yyparser.yylval = new ParserVal (yytext()); return Parser.GEQ;}
  {LEQ}             { yyparser.yylval = new ParserVal (yytext()); return Parser.LEQ;}
  {DIFF}            { yyparser.yylval = new ParserVal (yytext()); return Parser.DIFF;}
  {PLUS}            { yyparser.yylval = new ParserVal (yytext()); return Parser.PLUS;}
  {MINUS}           { yyparser.yylval = new ParserVal (yytext()); return Parser.MINUS;}
  {TIMES}           { yyparser.yylval = new ParserVal (yytext()); return Parser.TIMES;}
  {DIVIDE}          { yyparser.yylval = new ParserVal (yytext()); return Parser.DIVIDE;}
  {MODULO}          { yyparser.yylval = new ParserVal (yytext()); return Parser.MODULO;}
  {DASH}            { yyparser.yylval = new ParserVal (yytext()); return Parser.DASH;}
  {BY}              { yyparser.yylval = new ParserVal (yytext()); return Parser.BY;}
  {ID}              { yyparser.yylval = new ParserVal (yytext()); return Parser.ID;}
  {LEFTP}           { yyparser.yylval = new ParserVal (yytext()); return Parser.LEFTP;}
  {RIGHTP}          { yyparser.yylval = new ParserVal (yytext()); return Parser.RIGHTP;}
  //{INDENTA}         { return Parser.INDENTA}
  {CADENAINVALIDA}  { System.out.println("\n" + "Error:Cadena mal formada" + " en linea " + (yyline+1)); System.exit(1);}
  {CADENA}          { yyparser.yylval = new ParserVal (yytext()); return Parser.CADENA;}
  {SALTO}	        {yybegin(INDENTA); espacios = 0; return Parser.SALTO;}
  [^] 	            { System.out.println("\n" + "Error:Lexema no reconocido" + " en linea " + (yyline+1)); System.exit(1); }
}

<INDENTA> {
	{ESPACIO}			{ espacios++; }
	"\t"				{ espacios+=4; }
	. 				    {yypushback(1);
					    this.analiza(espacios);
						    if (contadorIndentaciones == 1) {
							    contadorIndentaciones = 0;
							    return Parser.INDENTA;
						    }}

	
}
