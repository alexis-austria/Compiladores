package lexico;
import java.util.*;
%%

%public
%class Flexer
%unicode
%standalone

IDENTIFICADOR = ("_"|[a-z]|[A-Z])("_"|[a-z]|[A-Z]|{ENTERO})*
ESPACIO       = " "
ENTERO = 0 | [1-9][0-9]*
REAL = "."[0-9]+ | {ENTERO}"."[0-9]+ | {ENTERO}"."
RESERVADA     = "and"|"not"|"while"|"elif"|"or"|"else"|"if"|"print"
OPERADOR = "+" | "-" | "*" |  "/" | "%" | "<" | ">" | ">=" | "<=" | "=" | "!"
CADENA        = (\".*)(\")

%%
<YYINITIAL> {
  {ESPACIO}         {/*IGNORAR*/}
  "True"            { System.out.printf("BOOLEANO(%s)", yytext()); }
  "False"           { System.out.printf("BOOLEANO(%s)", yytext()); }
  ":"               { System.out.printf("SEPARADOR(%s)", yytext()); }
  {ENTERO}          { System.out.printf("ENTERO(%s)", yytext()); }
  {RESERVADA}       { System.out.printf("RESERVADA(%s)", yytext()); }
  {IDENTIFICADOR}   { System.out.printf("IDENTIFICADOR(%s)", yytext()); }
  {REAL}			      { System.out.printf("REAL(%s)",yytext()); }
  {OPERADOR}		    { System.out.printf("OPERADOR(%s)",yytext()); }
  "\n"				      { System.out.println("SALTO\n");}
  {CADENA}          { System.out.printf("CADENA(%s)", yytext()); }
}
