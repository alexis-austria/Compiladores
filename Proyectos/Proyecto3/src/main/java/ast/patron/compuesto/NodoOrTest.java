package ast.patron.compuesto;
import ast.patron.visitante.*;

public class NodoOrTest extends Compuesto
{
    public NodoOrTest(){
	   hijos = new Hijos();
    }

    public NodoOrTest(Hijos h){
       hijos = h;
    }

    public NodoOrTest(Nodo l){
       hijos = new Hijos(l);
    }

    public void accept(Visitor v){
     	v.visit(this);
    }
}
