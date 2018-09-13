package lexico;

%%

%public
%class Flexer
%unicode
%standalone

ESPACIO       = " "
ENTERO = 0 | [1-9][0-9]*
IDENTIFICADOR = ("_"|[a-z]|[A-Z])("_"|[a-z]|[A-Z]|{ENTERO})*
RESERVADA     = "and"|"del"|"from"|"not"|"while"|"as"|"elif"|"global"|"or"|"with"|"assert"|"else"|"if"|"pass"|"yield"|"break"|"except"|"import"|"print"|"class"|"exec"|"in"|"raise"|"continue"|"finally"|"is"|"return"|"def"|"for"|"lambda"|"try"


%%
<YYINITIAL> {
  {ESPACIO}         {/*IGNORE*/}
  "True"            { System.out.printf("BOOLEANO(%s)", yytext()); }
  "False"           { System.out.printf("BOOLEANO(%s)", yytext()); }
  {ENTERO}          { System.out.printf("ENTERO(%s)", yytext()); }
  {RESERVADA}       { System.out.printf("RESERVADA(%s)", yytext()); }
  {IDENTIFICADOR}   { System.out.printf("IDENTIFICADOR(%s)", yytext()); }
}
