package ast.patron.compuesto;
import ast.patron.visitante.*;

public class NodoTest extends Compuesto
{
    public NodoTest(){
	   hijos = new Hijos();
    }

    public NodoTest(Hijos h){
       hijos = h;
    }

    public NodoTest(Nodo l){
       hijos = new Hijos(l);
    }

    public void accept(Visitor v){
     	v.visit(this);
    }
}
