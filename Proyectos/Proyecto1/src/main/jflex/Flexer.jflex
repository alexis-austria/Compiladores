package lexico;

%%

%public
%class Flexer
%unicode
%standalone

BOOLEANO = True | False

%%
{BOOLEANO}  {System.out.println("BOOLEANO(yytext())");}
