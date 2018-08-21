// Clase de analizador léxico C++

%%

%public
%class AL
%unicode
%standalone

COMENTARIO = "//".*
IDENTIFICADOR = _.* | [a-z].* | [A_Z].*
ENTEROS = 0 | [1-9][0-9]*

%%
{COMENTARIO}      {System.out.println("COMENTARIO");}
{IDENTIFICADOR}   {System.out.println("IDENTIFICADOR");}
{ENTEROS}         {System.out.println("ENTEROS");}
