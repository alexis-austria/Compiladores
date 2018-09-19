// parser.y
%{
import java.io.*;
%}


%token PLUS, MINUS, TIMES, DIVIDE, NEWLINE
%token <dval> NUMBER
%type<dval> expr, term, factor

%%
start:  {System.out.println("[OK]");}
     | expr start {System.out.println("[OK]");}
     | term start {System.out.println("[OK]");}
     | factor start  {System.out.println("[OK]");}

expr:	term	 {dump_stacks(stateptr);}
		|expr PLUS term	{dump_stacks(stateptr);}
		|expr MINUS term	{dump_stacks(stateptr);}
		;
term:	factor	{dump_stacks(stateptr);}
		|term TIMES factor	{dump_stacks(stateptr);}
		|term DIVIDE factor	{dump_stacks(stateptr);}
		;
factor:	NUMBER	{dump_stacks(stateptr);}
		|MINUS NUMBER	{dump_stacks(stateptr);}
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
	alexico = new Letras(r);
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
