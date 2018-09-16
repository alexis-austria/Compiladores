%{
import java.io.*;
%}

%token PLUS, MINUS, TIMES, DIVIDE, NUMBER
%type<dval> expr, term, factor, X, Y, Z

%%
start:   {System.out.println("[OK]");}
         | expr {System.out.println("[OK]");}
         | term {System.out.println("[OK]");}
         | factor {System.out.println("[OK]");}

expr: X term;

X: expr PLUS X | expr  MINUS X
 |
 ;

term: Y factor ;

Y: term TIMES Y | term DIVIDE  Y
 |
 ;

factor: Z NUMBER;

Z: MINUS
 |
 ;
 %%

 private Letras alexico;

 private int yylex() {
    int yyl_return = -1;
    try {
        yyl_return = alexico.yylex();
    } catch (IOException e) {
        System.err.println("Error de IO." + e);
    }
    return yyl_return;
 }

public void yyerror (String error) {
    System.err.println("[ERROR] " + error);
    System.exit(2);
}

 public Parser(Reader r) {
    alexico = new Letras(r);
 }

 public static void main(String args[]) {
    try {
        Parser yyparser = new Parser(new FileReader(args[0]));
        yyparser.yyparse();
    } catch(FileNotFoundException e) {
        System.err.println("El archivo " + args[0] + " no existe");
    }
 }
