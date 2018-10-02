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
	int contadorIndentaciones = 0;

	public void analiza(String lexema){
		if(indentaciones.empty()){
			if(espacios == 0)
				//System.out.printf("%s(%s)",lexema,yytext());
			else{
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
  "True"            { return Parser.BOOLEANO}
  "False"           { return Parser.BOOLEANO}
  {ENTERO}          { return Parset.ENTERO}
  {REAL}	    { return Parser.REAL}
  {EQUAL}           { return Parser.EQUAL}
  {PRINT}           { return Parser.PRINT}
  {IF}              { return Parser.IF}
  {COLON}           { return Parser.SEPARADOR}
  {ELSE}            { return Parser.ELSE}
  {WHILE}           { return Parser.WHILE}
  {OR}              { return Parser.OR}
  {AND}             { return Parser.AND}
  {NOT}             { return Parser.NOT}
  {LESS}            { return Parser.LESS}
  {MORE}            { return Parser.MORE}
  {DEQ}             { return Parser.DEQ}
  {GEQ}             { return Parser.GEQ}
  {LEQ}             { return Parser.LEQ}
  {DIFF}            { return Parser.DIFF}
  {PLUS}            { return Parser.PLUS}
  {MINUS}           { return Parser.MINUS}
  {TIMES}           { return Parser.TIMES}
  {DIVIDE}          { return Parser.DIVIDE}
  {MODULO}          { return Parser.MODULO}
  {DASH}            { return Parser.DASH}
  {BY}              { return Parser.BY}
  {ID}              { return Parser.ID}
  {LEFTP}           { return Parser.LEFTP }
  {RIGHTP}          { return Parser.RIGHTP}
  //{INDENTA}         { return Parser.INDENTA}
  {CADENAINVALIDA}  { System.out.println("\n" + "Error:Cadena mal formada" + " en linea " + (yyline+1)); System.exit(1);}
  {CADENA}          { return Parser.CADENA}
  {SALTO}	    {yybegin(INDENTA); espacios = 0; return Parser.SALTO;}
  [^] 	            { System.out.println("\n" + "Error:Lexema no reconocido" + " en linea " + (yyline+1)); System.exit(1); }
}

<INDENTA> {
	{ESPACIO}			{ espacios++; }
	"\t"				{ espacios+=4; }
	. 				{yypushback(1);
					this.analiza(espacios);
						if (contadorIndentaciones == 1) {
							contadorIndentaciones = 0;
							return Parser.INDENTA;
						}}

	
}
