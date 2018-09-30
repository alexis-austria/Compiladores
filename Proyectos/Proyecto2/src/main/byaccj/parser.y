// parser.y
%{

import java.io.*;

%}

%token SALTO, EQUAL, PRINT, IF, COLON, ELSE, WHILE, INDENTA, OR, AND, NOT, LESS, MORE,
       DEQ, LEQ, GEQ, DIFF, PLUS, MINUS, TIMES, DIVIDE, MODULO, DASH, BY, ID, ENTERO,
       REAL, BOOLEANO, LEFTP, RIGHTP
%type fileinput, stmt, simplestmt, compundstmt, smallstmt, exprstmt, printstmt, compoundstmt, ifstmt,
      whilestmt, test, suite, aux, ortest, andtest, aux2, aux3, nottest, comparison, compop, aux4,
      expr, aux5, term, factor, aux6, power, atom


%%
fileinput:   {System.out.println("[OK]");}
         | SALTO fileinput {System.out.println("[OK]");}
         | stmt fileinput {System.out.println("[OK]");}
         ;

stmt: simplestmt
    | compundstmt
    ;

simplestmt: smallstmt SALTO;

smallstmt: exprstmt
         | printstmt
         ;

exprstmt: test
        | test EQUAL test
        ;

printstmt: PRINT test;

compoundstmt: ifstmt
            | whilestmt
            ;

ifstmt: IF test COLON suite
      | IF test COLON suite ELSE COLON suite
      ;

whilestmt: WHILE test COLON suite;

suite: simplestmt
     | SALTO INDENTA stmt aux DEINDENTA
     ;

aux: stmt aux
   |
   ;

test: ortest;

ortest: andtest aux2;

aux2: OR andtest aux2
    |
    ;

andtest: nottest aux3;

aux3: AND nottest aux3
    |
    ;

nottest: NOT nottest
       | NOT comparison
       ;

comparison: expr aux4;

aux4: compop expr aux4
    |
    ;

compop: LESS
      | MORE
      | DEQ
      | GEQ
      | LEQ
      | DIFF
      ;

expr: term aux5;

aux5: PLUS term aux5
    | MINUS term aux5
    |
    ;

term: factor aux6;

aux6: TIMES factor aux6
    | DIVIDE factor aux6
    | MODULO factor aux6
    | DASH factor aux6
    |
    ;

factor: PLUS factor
      | MINUS factor
      | power

power: atom
     | atom BY factor

atom: ID
    | ENTERO
    | CADENA
    | REAL
    | BOOLEANO
    | LEFTP test RIGHTP
    ;
%%

private Letras alexico;

// Regresar átomos
private int yylex() {
  int yyl_return = -1;

  try{
    yyl_return = alexico.yylex();

  }catch (IOException e){
    System.err.println("Error de IO." + e);
  }
  return yyl_return;
}

public void yyerror (String error){
  System.err.println("[ERROR] " +error);
  System.exit(2);
}

public Parser(Reader r){
  alexico = new Letras(r,this);
}

public static void main(String args[]){
  try{
   Parser yyparser = new Parser(new FileReader(args[0]));
   yyparser.yyparse();
  }catch(FileNotFoundException e){
    System.err.println("El Archivo " + args[0] + " no existe.");
  }

}
