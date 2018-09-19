// parser.y
%{
import java.io.*;
%}


%token PLUS, MINUS, TIMES, DIVIDE, NEWLINE
%token <ival> NUMBER
%type<ival> expr, term, factor

%%
start:
     | expr NEWLINE start {System.out.println("[OK]");} {System.out.printf("[OK] %d\n", $1);}
     | term NEWLINE start {System.out.println("[OK]");} {System.out.printf("[OK] %d\n", $1);}
     | factor NEWLINE start {System.out.println("[OK]");} {System.out.printf("[OK] %d\n", $1);}

expr:	term	 {dump_stacks(stateptr);}
		|expr PLUS term	{dump_stacks(stateptr);} {$$= $1 + $3;}
		|expr MINUS term	{dump_stacks(stateptr);} {$$= $1 - $3;}
		;
term:	factor	{dump_stacks(stateptr);}
		|term TIMES factor	{dump_stacks(stateptr);} {$$= $1 * $3;}
		|term DIVIDE factor	{dump_stacks(stateptr);} {$$= $1 / $3;}
		;
factor:	NUMBER	{dump_stacks(stateptr);} {$$= $1;}
		|MINUS NUMBER	{dump_stacks(stateptr);} {$$= $2;}
		;
 %%


private Letras alexico;

/* Regresar átomos */
private int yylex() {
	int yyl_return = -1;
	try {
		yyl_return = alexico.yylex();
	} catch (IOException e) {
		System.err.println("Error de IO. "+e);
	}
	return yyl_return;
}

/* Reportar error. */
public void yyerror(String error) {
	System.err.println("[ERROR] "+error);
	System.exit(1);
}

/* Constructor. */
public Parser(Reader r) {
	alexico = new Letras(r, this);
}

/* Analizador sintáctico sobre un archivo. */
public static void main(String[] args) {
	try {
		Parser yyparser = new Parser(new FileReader(args[0]));
		yyparser.yyparse();
	} catch(FileNotFoundException e) {
		System.err.println("El archivo " + args[0] + " no existe.");
	}
}
