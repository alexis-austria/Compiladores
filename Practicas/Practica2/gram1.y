

// parser.y
%{
import java.io.*;  
%}


%token PLUS, MINUS, TIMES, DIVIDE, NUMBER
%type<dval> expr, term, factor

%%
start:   {System.out.println("[OK]");}
     | expr {System.out.println("[OK]");}
     | term {System.out.println("[OK]");}
     | factor {System.out.println("[OK]");}

expr:	term
		|expr PLUS term
		|expr MINUS term
		|
		;
term:	factor
		|term TIMES factor
		|term DIVIDE factor
		|
		;
factor:	NUMBER
		|MINUS NUMBER
		|
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
