package ast.patron.compuesto;
import ast.patron.visitante.*;

public class IdentificadorHoja extends Hoja
{
    public IdentificadorHoja(String s){
	   name = s;
    }

    public void accept(Visitor v){
     	v.visit(this);
    }
}
