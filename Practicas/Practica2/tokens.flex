%%
%class Letras
%public
%unicode
%byaccj

%{
  private Parser yyparser;

  public Letras(java.io.Reader r, Parser yyparser) {
    this(r);
    this.yyparser = yyparser;
  }
%}

NUMBER = 0 | [1-9][0-9]*

%%
"+" {return Parser.PLUS;}
"-" {return Parser.MINUS;}
"*" {return Parser.TIMES;}
"/" {return Parser.DIVIDE;}
{NUMBER} {yyparser.yylval = new ParserVal(Integer.parseInt(yytext())); return Parser.NUMBER;}
"\n" {return Parser.NEWLINE;}
" " {}
[^] {System.out.println("ERROR: La expresión aritmética no está bien formada.");
      System.exit(1);}
