package lexico;

%%

%public
%class Flexer
%unicode
%standalone

IDENTIFICADOR = ("_"|[a-z]|[A-Z])([a-z]|[A-Z]|{ENTERO})*
ESPACIO       = " "
ENTERO = 0 | [1-9][0-9]*
REAL = "."[0-9]+ | {ENTERO}"."[0-9]+ | {ENTERO}"."
RESERVADA     = "and"|"not"|"while"|"elif"|"or"|"else"|"if"|"print"
<<<<<<< HEAD
OPERADOR = "+" | "-" | "*" |  "/" | "%" | "<" | ">" | ">=" | "<=" | "=" | "!" 
=======
CADENAINVALIDA = (\".*)(\.*|\".*)(\")
CADENA        = (\".*)(\")

>>>>>>> 843871e6914313a2ca6af9aa7193520af2958518

%%
<YYINITIAL> {
  {ESPACIO}         {/*IGNORAR*/}
  "True"            { System.out.printf("BOOLEANO(%s)", yytext()); }
  "False"           { System.out.printf("BOOLEANO(%s)", yytext()); }
  {ENTERO}          { System.out.printf("ENTERO(%s)", yytext()); }
  {RESERVADA}       { System.out.printf("RESERVADA(%s)", yytext()); }
  {IDENTIFICADOR}   { System.out.printf("IDENTIFICADOR(%s)", yytext()); }
<<<<<<< HEAD
  {REAL}			{ System.out.printf("REAL(%s)",yytext()); }
  {OPERADOR}		{ System.out.printf("OPERADOR(%s)",yytext()); }
  "\n"				{ System.out.printf(yystate());}
=======
  {CADENAINVALIDA}  { throw new Error("\n" + "Caracter ilegal en cadena "+yytext()+" " + "linea "+yyline+" "); }   
  {CADENA}          { System.out.printf("CADENA(%s)", yytext()); }
>>>>>>> 843871e6914313a2ca6af9aa7193520af2958518
}
