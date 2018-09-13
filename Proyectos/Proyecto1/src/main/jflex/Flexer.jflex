package lexico;

%%

%public
%class Flexer
%unicode
%standalone

ENTERO = 0 | [1-9][0-9]*

%%
<YYINITIAL> {
  "True"      { System.out.printf("BOOLEANO(%s)", yytext()); }
  "False"     { System.out.printf("BOOLEANO(%s)", yytext()); }
  {ENTERO}    { System.out.printf("ENTERO(%s)", yytext()); }
}
