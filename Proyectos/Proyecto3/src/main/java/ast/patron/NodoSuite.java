package ast.patron.compuesto;
import ast.patron.visitante.*;

public class NodoSuite extends Compuesto
{
    public NodoWhSuite(){
	   hijos = new Hijos();
    }

    public NodoSuite(Hijos h){
       hijos = h;
    }

    public NodoSuite(Nodo l){
       hijos = new Hijos(l);
    }

    public void accept(Visitor v){
     	v.visit(this);
    }
}
