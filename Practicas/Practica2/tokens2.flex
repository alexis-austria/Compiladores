// tokens.flex
%%
%class Letras2
%public
%unicode
%byaccj

NUMBER = 0 | [1-9][0-9]*

%%
"+" {return Parser2.PLUS;}
"-" {return Parser2.MINUS;}
"*" {return Parser2.TIMES;}
"/" {return Parser2.DIVIDE;}
{NUMBER} {return Parser2.NUMBER;}
"\n" {return Parser2.NEWLINE;}
" " {}
[^] {System.out.println("ERROR: La expresión aritmética no está bien formada.");
      System.exit(1);}
