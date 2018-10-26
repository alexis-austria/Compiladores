package ast.patron.compuesto;
import ast.patron.visitante.*;

public class NodoIf extends Compuesto
{
    public NodoIf(){
	   super();
    }

    public NodoIf(Hijos h){
       hijos = h;
    }

    public void accept(Visitor v){
     	v.visit(this);
    }
}
