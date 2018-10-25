package ast.patron.compuesto;
import ast.patron.visitante.*;

public class IdentificadorHoja extends Hoja
{
    public IntHoja(String s){
	name = s
    }

    public void accept(Visitor v){
     	v.visit(this);
    }
}
