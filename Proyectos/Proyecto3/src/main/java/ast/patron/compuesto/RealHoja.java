package ast.patron.compuesto;
import ast.patron.visitante.*;

public class RealHoja extends Hoja
{
    public RealHoja(Double d){
	valor = new Variable(d);
	tipo = 2;
    }

    public void accept(Visitor v){
     	v.visit(this);
    }
}
