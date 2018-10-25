%%
%class Letras2
%public
%unicode
%byaccj

%{
  private Parser2 yyparser;

  public Letras2(java.io.Reader r, Parser2 yyparser) {
    this(r);
    this.yyparser = yyparser;
  }
%}

NUMBER = 0 | [1-9][0-9]*

%%
"+" {return Parser2.PLUS;}
"-" {return Parser2.MINUS;}
"*" {return Parser2.TIMES;}
"/" {return Parser2.DIVIDE;}
{NUMBER} {yyparser.yylval = new Parser2Val(Integer.parseInt(yytext())); return Parser2.NUMBER;}
"\n" {return Parser2.NEWLINE;}
" " {}
[^] {System.out.println("ERROR: La expresión aritmética no está bien formada.");
      System.exit(1);}
