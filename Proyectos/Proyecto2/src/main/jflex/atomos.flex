package asintactico;
import java.util.*;

%%
%public
%class Flexer
%unicode
%line
%standalone
%line

%{
  
    private Parser yyparser;


   /** Nuevo constructor
    * @param FileReader r
    * @param parser parser - parser
    */
    public Flexer(java.io.Reader r, Parser parser){
         this(r);
         yyparser = parser;
    }

    Stack<Integer> indentaciones = new Stack<Integer>();
    Integer current = 0;
    String cadena = "";
    int numDeindenta = 0;
    int numIndenta = 0;


    public void analiza(int espacios){
        if(indentaciones.empty())
          indentaciones.push(new Integer(0));        
        int tope = indentaciones.peek();
        if(tope != espacios){
            if(tope > espacios){
                while(indentaciones.peek() > espacios &&  indentaciones.peek()!=0 ){
                    indentaciones.pop();
                    numDeindenta += 1;
                }
                if(indentaciones.peek() == espacios){
        yybegin(DEINDENTA);
                }else{
        System.out.print("Error de indentación. Línea "+(yyline+1));
        System.exit(1);
    }            indentaciones.push(espacios);
      yybegin(CODIGO);
            numIndenta = 1;
        }else 
            yybegin(CODIGO);
    }
}
%}

ENTERO              = 0+ | [0-9]+
REAL                = {ENTERO}? \. {ENTERO}?
TRUE                = "True"
FALSE               = "False"
EQUAL               = "="
BY                  = "**"
PLUS                = "+"
MINUS               = "-"
TIMES               = "*"
DIVIDE              = "/"
MODULO                 = "%"
DASH                = "//"
LESS                = "<"
MORE                = ">"
DEQ                 = "=="
GEQ                 = ">="
LEQ                 = "<="
DIFF                = "!="
NOT                 = "not"
AND                 = "and"
OR                  = "or"
IF                  = "if"
WHILE               = "while"
ELSE                = "else"
PRINT               = "print"
COLON               = ":"
LEFTP               = "("
RIGHTP                = ")"
ESC                 = (\\)
CHAR_LITERAL        = ([:letter:] | [:digit:] | "_" | "$" | " " | "#" | {COLON}) | "\\"
COMENTARIO          = "#".*{SALTO}

SALTO               = \n
ID       = ([:letter:] | "_" )([:letter:] | "_" | [0-9])*

%state CADENA INDENTA CODIGO DEINDENTA 

%%

{COMENTARIO}            {}

<YYINITIAL>{
  (" " | "\t" )+[^" ""\t""#""\n"]         { System.out.print("Error de indentación. Línea "+(yyline+1));
              System.exit(1);}
  {SALTO}                                 {}
  [^" ""\t"]                              { yypushback(1); yybegin(CODIGO);}
}

<CADENA>{
  {CHAR_LITERAL}*\"     {yybegin(CODIGO);
                                         System.out.print("");}
  {SALTO}         { System.out.print("Cadena mal construida, linea " + (yyline+1) ); System.exit(1);}
}

<DEINDENTA>{
  .         { yypushback(1);
              if(numDeindenta > 0){
                numDeindenta--;
                //System.out.print("");
                return Parser.DEINDENTA;
              }
              yybegin(CODIGO);
            }
}

<CODIGO>{


" "                   {}
{SALTO}               {yybegin(INDENTA); current=0; System.out.println("");}
{REAL}                { yyparser.yylval = new ParserVal(Double.parseDouble(yytext())); return Parser.REAL;}
{TRUE}                { yyparser.yylval = new ParserVal(Boolean.parseBoolean(yytext())); return Parser.BOOLEANO;}
{FALSE}               { yyparser.yylval = new ParserVal(Boolean.parseBoolean(yytext())); return Parser.BOOLEANO;}
{ENTERO}              { yyparser.yylval = new ParserVal(Integer.parseInt(yytext())); return Parser.ENTERO;}
{BY}                  { yyparser.yylval = new ParserVal (yytext()); return Parser.BY;}
{PLUS}                { yyparser.yylval = new ParserVal (yytext()); return Parser.PLUS;}
{MINUS}               { yyparser.yylval = new ParserVal (yytext()); return Parser.MINUS;}
{TIMES}               { yyparser.yylval = new ParserVal (yytext()); return Parser.TIMES;}
{DIVIDE}              { yyparser.yylval = new ParserVal (yytext()); return Parser.DIVIDE;}
{MODULO}              { yyparser.yylval = new ParserVal (yytext()); return Parser.MODULO;}
{DASH}                { yyparser.yylval = new ParserVal (yytext()); return Parser.DASH;}
{LESS}                { yyparser.yylval = new ParserVal (yytext()); return Parser.LESS;}
{MORE}                { yyparser.yylval = new ParserVal (yytext()); return Parser.MORE;}
{DEQ}                 { yyparser.yylval = new ParserVal (yytext()); return Parser.DEQ;}
{EQUAL}               { yyparser.yylval = new ParserVal (yytext()); return Parser.EQUAL;}
{GEQ}                 { yyparser.yylval = new ParserVal (yytext()); return Parser.GEQ;}
{LEQ}                 { yyparser.yylval = new ParserVal (yytext()); return Parser.LEQ;}
{DIFF}                { yyparser.yylval = new ParserVal (yytext()); return Parser.DIFF;}
{NOT}                 { yyparser.yylval = new ParserVal (yytext()); return Parser.NOT;}
{AND}                 { yyparser.yylval = new ParserVal (yytext()); return Parser.AND;}
{OR}                  { yyparser.yylval = new ParserVal (yytext()); return Parser.OR;}
{IF}                  { yyparser.yylval = new ParserVal (yytext()); return Parser.IF;}
{WHILE}               { yyparser.yylval = new ParserVal (yytext()); return Parser.WHILE;}
{ELSE}                { yyparser.yylval = new ParserVal (yytext()); return Parser.ELSE;}
{PRINT}               { yyparser.yylval = new ParserVal (yytext()); return Parser.PRINT;}
{COLON}               { yyparser.yylval = new ParserVal (yytext()); return Parser.COLON;}
{LEFTP}               { yyparser.yylval = new ParserVal (yytext()); return Parser.LEFTP;}
{RIGHTP}              { yyparser.yylval = new ParserVal (yytext()); return Parser.RIGHTP;}
{SALTO}               {yybegin(INDENTA); System.out.print("SALTORESERVADA ("+yytext()+")");}
{ID}                  { yyparser.yylval = new ParserVal (yytext()); return Parser.ID;}
}
<INDENTA>{
  {SALTO}                                 { current = 0;}
  " "                 { current++;}
  \t            { current += 4;}
  .           { yypushback(1);
              this.analiza(current);
              if(numIndenta == 1){
                numIndenta = 0;
                //System.out.print("SALTOIDENTA("+numIndenta+")");
                return Parser.INDENTA;
              }
            }
}
<<EOF>>                                   { this.analiza(0);
              if(numDeindenta > 0){
                numDeindenta--;
                return Parser.DEINDENTA;
                //System.out.print("SALTODEIDENTA ("+numDeindenta+")");
              }else{
                    }
            }
[^]                               {}
