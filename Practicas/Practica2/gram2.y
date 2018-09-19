%{
import java.io.*;
%}

%token PLUS, MINUS, TIMES, DIVIDE, NUMBER, NEWLINE
%type<dval> expr, term, factor

%%
start:   {System.out.println("[OK]");}
     | expr NEWLINE start {System.out.println("[OK]");}
     | term NEWLINE start {System.out.println("[OK]");}
     | factor NEWLINE start {System.out.println("[OK]");}

expr: term {dump_stacks(stateptr);}
    | term PLUS expr {dump_stacks(stateptr);}
    | term MINUS expr {dump_stacks(stateptr);};

term: factor {dump_stacks(stateptr);}
    | factor TIMES term {dump_stacks(stateptr);}
    | factor DIVIDE term {dump_stacks(stateptr);};

factor: MINUS NUMBER {dump_stacks(stateptr);}
      | NUMBER {dump_stacks(stateptr);};
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
    alexico = new Letras2(r);
 }

 public static void main(String args[]) {
    try {
        Parser2 yyparser = new Parser2(new FileReader(args[0]));
        yyparser.yyparse();
    } catch(FileNotFoundException e) {
        System.err.println("El archivo " + args[0] + " no existe");
    }
 }
