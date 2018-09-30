// tokens.flex
%%
%class Letras
%public
%unicode
%byaccj

%%
a    {return Parser.A;}
b    { return Parser.B;}
"\n" {}
[^] {System.out.println("ERROR: Token no reconocido.");
     System.exit(1);}