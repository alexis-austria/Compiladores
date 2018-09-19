%{
import java.io.*;
%}

%token PLUS, MINUS, TIMES, DIVIDE, NEWLINE
%token <ival> NUMBER
%type<ival> expr, term, factor

%%
start:
     | expr NEWLINE start {System.out.printf("[OK] %d\n", $1);}
     | term NEWLINE start {System.out.printf("[OK] %d\n", $1);}
     | factor NEWLINE start {System.out.printf("[OK] %d\n", $1);}

expr: term {dump_stacks(stateptr);}
    | term PLUS expr {dump_stacks(stateptr);} {$$= $1 + $3;}
    | term MINUS expr {dump_stacks(stateptr);} {$$= $1 - $3;}
    ;

term: factor {dump_stacks(stateptr);}
    | factor TIMES term {dump_stacks(stateptr);} {$$= $1 * $3;}
    | factor DIVIDE term {dump_stacks(stateptr);} {$$= $1 / $3;}
    ;

factor: MINUS NUMBER {dump_stacks(stateptr);} {$$= -$2;}
      | NUMBER {dump_stacks(stateptr);} {$$= $1;}
      ;
%%
 private Letras2 alexico;
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
 public Parser2(Reader r) {
    alexico = new Letras2(r, this);
 }
 public static void main(String args[]) {
    try {
        Parser2 yyparser = new Parser2(new FileReader(args[0]));
        yyparser.yyparse();
    } catch(FileNotFoundException e) {
        System.err.println("El archivo " + args[0] + " no existe");
    }
 }
