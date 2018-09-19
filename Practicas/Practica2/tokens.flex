// tokens.flex
%%
%class Letras
%public
%unicode
%byaccj

NUMBER = 0 | [1-9][0-9]*

%%
"+" {return Parser.PLUS;}
"-" {return Parser.MINUS;}
"*" {return Parser.TIMES;}
"/" {return Parser.DIVIDE;}
{NUMBER} {return Parser.NUMBER;}
"\n" {}
" " {}
[^] {System.out.println("ERROR: La expresión aritmética no está bien formada.");
      System.exit(1);}
