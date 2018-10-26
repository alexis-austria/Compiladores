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

    public NodoTest(Nodo l){
       hijos = new Hijos(l);
    }

    public void accept(Visitor v){
     	v.visit(this);
    }
}
