package ast.patron.compuesto;
import ast.patron.visitante.*;

public class BooleanoHoja extends Hoja
{
    public BooleanoHoja(Boolean b){
	valor = new Variable(b);
	tipo = 3;
    }

    public void accept(Visitor v){
     	v.visit(this);
    }
}
