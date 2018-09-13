package lexico;

%%

%public
%class Flexer
%unicode
%standalone

IDENTIFICADOR = ("_"|[a-z]|[A-Z])("_"|[a-z]|[A-Z]|{ENTERO})*
ESPACIO       = " "
ENTERO = 0 | [1-9][0-9]*
REAL = "."[0-9]+ | {ENTERO}"."[0-9]+ | {ENTERO}"."
RESERVADA     = "and"|"del"|"from"|"not"|"while"|"as"|"elif"|"global"|"or"|"with"|"assert"|"else"|"if"|"pass"|"yield"|"break"|"except"|"import"|"print"|"class"|"exec"|"in"|"raise"|"continue"|"finally"|"is"|"return"|"def"|"for"|"lambda"|"try"
<<<<<<< HEAD
OPERADOR = "+" | "-" | "*" |  "/" | "%" | "<" | ">" | ">=" | "<=" | "=" | "!" 
=======
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
  {CADENA}          { System.out.printf("CADENA(%s)", yytext()); }
>>>>>>> 843871e6914313a2ca6af9aa7193520af2958518
}
