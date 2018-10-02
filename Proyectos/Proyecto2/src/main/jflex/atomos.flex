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
    public Letras(java.io.Reader r, Parser parser){
    	   this(r);
    	   yyparser = parser;
    }

	Stack<Integer> indentaciones = new Stack<Integer>();
	int espacios = 0;

	public void analiza(String lexema){
		if(indentaciones.empty()){
			if(espacios == 0)
				System.out.printf("%s(%s)",lexema,yytext());
			else{
				System.out.printf("INDENTA(%d)",espacios);
				System.out.printf("%s(%s)",lexema,yytext());
				indentaciones.push(espacios);
			}
		}else{
			if(espacios == 0){
				while(!indentaciones.empty()){
					System.out.printf("DEINDENTA(%d)\n",indentaciones.pop());
				}
				System.out.printf("%s(%s)",lexema,yytext());
			}else if(espacios < indentaciones.peek()){
				while (espacios < indentaciones.peek()) {
					System.out.printf("DEINDENTA(%d)\n",espacios);
                    indentaciones.pop();
				}
				System.out.printf("%s(%s)",lexema,yytext());
			}else if(espacios == indentaciones.peek()){
				System.out.printf("%s(%s)",lexema,yytext());
			}else{
				System.out.printf("INDENTA(%d)",espacios);
				System.out.printf("%s(%s)",lexema,yytext());
				indentaciones.push(espacios);
			}
		}
		espacios = 0;
		yybegin(YYINITIAL);
}
%}


ESPACIO        = " "
ENTERO         = 0 | [1-9][0-9]*
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
INDENTA        = "\n"
CADENAINVALIDA = (\".*)+ (\".*|\\.*) + (\")
CADENA         = (\".*)(\")

%state INDENTACION

%%
<YYINITIAL> {
  \# ~"\n" 			{/*IGNORAR*/}
  {ESPACIO}         {/*IGNORAR*/}
  "True"            { System.out.printf("BOOLEANO(%s)", yytext()); }
  "False"           { System.out.printf("BOOLEANO(%s)", yytext()); }
  {ENTERO}          { System.out.printf("ENTERO(%s)", yytext()); }
  {REAL}			{ System.out.printf("REAL(%s)",yytext()); }
  {EQUAL}           { System.out.printf("EQUAL(%s)",yytext()); }
  {PRINT}           { System.out.printf("PRINT(%s)",yytext()); }
  {IF}              { System.out.printf("IF(%s)",yytext()); }
  {COLON}           { System.out.printf("SEPARADOR(%s)", yytext()); }
  {ELSE}            { System.out.printf("ELSE(%s)",yytext()); }
  {WHILE}           { System.out.printf("WHILE(%s)",yytext()); }
  {OR}              { System.out.printf("OR(%s)",yytext()); }
  {AND}             { System.out.printf("AND(%s)",yytext()); }
  {NOT}             { System.out.printf("NOT(%s)",yytext()); }
  {LESS}            { System.out.printf("LESS(%s)",yytext()); }
  {MORE}            { System.out.printf("MORE(%s)",yytext()); }
  {DEQ}             { System.out.printf("DEQ(%s)",yytext()); }
  {GEQ}             { System.out.printf("GEQ(%s)",yytext()); }
  {LEQ}             { System.out.printf("LEQ(%s)",yytext()); }
  {DIFF}            { System.out.printf("DIFF(%s)",yytext()); }
  {PLUS}            { System.out.printf("PLUS(%s)",yytext()); }
  {MINUS}           { System.out.printf("MINUS(%s)",yytext()); }
  {TIMES}           { System.out.printf("TIMES(%s)",yytext()); }
  {DIVIDE}          { System.out.printf("DIVIDE(%s)",yytext()); }
  {MODULO}          { System.out.printf("MODULO(%s)",yytext()); }
  {DASH}            { System.out.printf("DASH(%s)",yytext()); }
  {BY}              { System.out.printf("BY(%s)",yytext()); }
  {ID}              { System.out.printf("ID(%s)", yytext()); }
  {LEFTP}           { System.out.printf("LEFTP(%s)", yytext()); }
  {RIGHTP}          { System.out.printf("RIGHTP(%s)", yytext()); }
  {INDENTA}         { System.out.printf("INDENTA(%s)", yytext()); }
  {CADENAINVALIDA}  { System.out.println("\n" + "Error:Cadena mal formada" + " en linea " + (yyline+1)); System.exit(1);}
  {CADENA}          { System.out.printf("CADENA(%s)", yytext()); }
  [^] 				{ System.out.println("\n" + "Error:Lexema no reconocido" + " en linea " + (yyline+1)); System.exit(1); }
}

<INDENTACION> {
	\# ~"\n" 			{ /*IGNORAR*/ }
	{ESPACIO}			{ espacios++; }
	"\t"				{ espacios+=4; }
	"True"              { analiza("BOOLEANO"); }
  	"False"  	        { analiza("BOOLEANO"); }
  	{ENTERO}        	{ analiza("ENTERO"); }
  	{REAL}				{ analiza("REAL"); }
  	{EQUAL}             { analiza("EQUAL"); }
    {PRINT}             { analiza("PRINT"); }
    {IF}                { analiza("IF"); }
    {COLON}             { analiza("COLON"); }
    {ELSE}              { analiza("ELSE"); }
    {WHILE}             { analiza("WHILE"); }
    {OR}                { analiza("OR"); }
    {AND}               { analiza("AND"); }
    {NOT}               { analiza("NOT"); }
    {LESS}              { analiza("LESS"); }
    {MORE}              { analiza("MORE"); }
    {DEQ}               { analiza("DEQ"); }
    {GEQ}               { analiza("GEQ"); }
    {LEQ}               { analiza("LEQ"); }
    {DIFF}              { analiza("DIFF"); }
    {PLUS}              { analiza("PLUS"); }
    {MINUS}             { analiza("MINUS"); }
    {TIMES}             { analiza("TIMES"); }
    {DIVIDE}            { analiza("DIVIDE"); }
    {MODULO}            { analiza("MODULO"); }
    {DASH}              { analiza("DASH"); }
    {BY}                { analiza("BY"); }
    {ID}                { analiza("ID"); }
    {LEFTP}             { analiza("LEFTP"); }
    {RIGHTP}            { analiza("RIGHTP"); }
    {INDENTA}           { analiza("INDENTA"); }
	{CADENAINVALIDA}    { analiza("CADENAINVALIDA"); }
  	{CADENA}          	{ analiza("CADENA"); }
	[^] 				{ System.out.println("\n" + "Error:Lexema no reconocido" + " en linea " + (yyline+1)); System.exit(1); }
}
