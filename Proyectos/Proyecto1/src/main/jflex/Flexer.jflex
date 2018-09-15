package lexico;
import java.util.*;
%%

%public
%class Flexer
%unicode
%line
%standalone
%line

%{
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
				System.out.printf("DEINDENTA(%d)",espacios);
                        	System.out.printf("%s(%s)",lexema,yytext());	
                        	indentaciones.pop();
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

IDENTIFICADOR = ("_"|[a-z]|[A-Z])("_"|[a-z]|[A-Z]|{ENTERO})*
ESPACIO       = " "
ENTERO = 0 | [1-9][0-9]*
REAL = "."[0-9]+ | {ENTERO}"."[0-9]+ | {ENTERO}"."
RESERVADA     = "and"|"not"|"while"|"elif"|"or"|"else"|"if"|"print"
OPERADOR = "+" | "-" | "*" |  "/" | "%" | "<" | ">" | ">=" | "<=" | "=" | "!"| "+=" | "==" | "-=" | "(" | ")"
CADENAINVALIDA = (\".*)+ (\".*|\\.*) + (\")
CADENA        = (\".*)(\")

%state INDENTACION

%%
<YYINITIAL> {
  \# ~"\n" 			{/*IGNORAR*/}
  {ESPACIO}         {/*IGNORAR*/}
  "True"            { System.out.printf("BOOLEANO(%s)", yytext()); }
  "False"           { System.out.printf("BOOLEANO(%s)", yytext()); }
  ":"               { System.out.printf("SEPARADOR(%s)", yytext()); }
  {ENTERO}          { System.out.printf("ENTERO(%s)", yytext()); }
  {RESERVADA}       { System.out.printf("RESERVADA(%s)", yytext()); }
  {IDENTIFICADOR}   { System.out.printf("IDENTIFICADOR(%s)", yytext()); }
  {REAL}			{ System.out.printf("REAL(%s)",yytext()); }
  {OPERADOR}		{ System.out.printf("OPERADOR(%s)",yytext()); }
  "\n"				{ System.out.println("SALTO\n"); yybegin(INDENTACION);}
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
  	":"         	    { analiza("SEPARADOR"); }
  	{ENTERO}        	{ analiza("ENTERO"); }
  	{RESERVADA} 	    { analiza("RESERVADA"); }
  	{IDENTIFICADOR} 	{ analiza("IDENTIFICADOR"); }
  	{REAL}				{ analiza("REAL"); }
  	{OPERADOR}			{ analiza("OPERADOR"); }
  	"\n"				{ yybegin(YYINITIAL); }
	{CADENAINVALIDA}    { analiza("CADENAINVALIDA"); }
  	{CADENA}          	{ analiza("CADENA"); }
	[^] 				{ System.out.println("\n" + "Error:Lexema no reconocido" + " en linea " + (yyline+1)); System.exit(1); }
}
