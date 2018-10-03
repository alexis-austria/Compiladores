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

ENTERO          = 0+ | [0-9]+
REAL            = {ENTERO}? \. {ENTERO}?
TRUE                = "True"
FALSE               = "False"
IGUAL               = "="
POTENCIA            = "**"
MAS                 = "+"
MENOS               = "-"
MULT                = "*"
DIV                 = "/"
MOD                 = "%"
PISO                = "//"
MENOR               = "<"
MAYOR               = ">"
IGUALIGUAL          = "=="
MAIGUAL             = ">="
MEIGUAL             = "<="
DISTINTO            = "!="
NOT                 = "not"
AND                 = "and"
OR                  = "or"
IF                  = "if"
WHILE               = "while"
ELSE                = "else"
PRINT               = "print"
SEPARADORP          = ":"
PIZQ                = "("
PDER                = ")"
ESC                 = (\\)
CHAR_LITERAL        = ([:letter:] | [:digit:] | "_" | "$" | " " | "#" | {SEPARADORP}) | "\\"
COMENTARIO          = "#".*{SALTO}

SALTO               = \n
IDENTIFICADOR       = ([:letter:] | "_" )([:letter:] | "_" | [0-9])*

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
  {SALTO}       { System.out.print("Cadena mal construida, linea " + (yyline+1) ); System.exit(1);}
}

<DEINDENTA>{
  .         { yypushback(1);
              if(numDeindenta > 0){
                numDeindenta--;
                System.out.print("");
              }
              yybegin(CODIGO);
            }
}

<CODIGO>{


" "                   {}
  {SALTO}       {yybegin(INDENTA); current=0; System.out.println("");}
{REAL}                {System.out.print("REAL ("+yytext()+")");}
{TRUE}                {System.out.print("BOOLEANO ("+yytext()+")");}
{FALSE}               {System.out.print("BOOLEANO ("+yytext()+")");}
{ENTERO}              {System.out.print("ENTERO ("+yytext()+")");}
{POTENCIA}            {System.out.print("OPERADOR ("+yytext()+")");}
{MAS}                 {System.out.print("OPERADOR ("+yytext()+")");}
{MENOS}               {System.out.print("OPERADOR ("+yytext()+")");}
{MULT}                {System.out.print("OPERADOR ("+yytext()+")");}
{DIV}                 {System.out.print("OPERADOR ("+yytext()+")");}
{MOD}                 {System.out.print("OPERADOR ("+yytext()+")");}
{PISO}                {System.out.print("OPERADOR ("+yytext()+")");}
{MENOR}               {System.out.print("OPERADOR ("+yytext()+")");}
{MAYOR}               {System.out.print("OPERADOR ("+yytext()+")");}
{IGUALIGUAL}          {System.out.print("OPERADOR ("+yytext()+")");}
{IGUAL}               {System.out.print("OPERADOR ("+yytext()+")");}
{MAIGUAL}             {System.out.print("OPERADOR ("+yytext()+")");}
{MEIGUAL}             {System.out.print("OPERADOR ("+yytext()+")");}
{DISTINTO}            {System.out.print("OPERADOR ("+yytext()+")");}
{NOT}                 {System.out.print("RESERVADA ("+yytext()+")");}
{AND}                 {System.out.print("RESERVADA ("+yytext()+")");}
{OR}                  {System.out.print("RESERVADA ("+yytext()+")");}
{IF}                  {System.out.print("RESERVADA ("+yytext()+")");}
{WHILE}               {System.out.print("RESERVADA ("+yytext()+")");}
{ELSE}                {System.out.print("RESERVADA ("+yytext()+")");} 
{PRINT}               {System.out.print("RESERVADA ("+yytext()+")");} 
{SEPARADORP}          {System.out.print("SEPARADOR ("+yytext()+")");}
{PIZQ}                {System.out.print("PARENTESISIZQUIERDO ("+yytext()+")");}
{PDER}                {System.out.print("PARENTESISDERECHO ("+yytext()+")");}
{SALTO}               {yybegin(INDENTA); System.out.print("SALTORESERVADA ("+yytext()+")");}
{IDENTIFICADOR}       {System.out.print("IDENTIFICADOR ("+yytext()+")");}
}
<INDENTA>{
  {SALTO}                                 { current = 0;}
  " "                 { current++;}
  \t            { current += 4;}
  .           { yypushback(1);
              this.analiza(current);
              if(numIndenta == 1){
                numIndenta = 0;
                System.out.print("SALTOIDENTA("+numIndenta+")");
              }
            }
}
<<EOF>>                                   { this.analiza(0);
              if(numDeindenta > 0){
                numDeindenta--;
                System.out.print("SALTODEIDENTA ("+numDeindenta+")");
              }else{
                    }
            }
[^]                               {}