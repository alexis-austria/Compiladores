package ast.patron.compuesto;
import ast.patron.visitante.*;

public class NodoAnd extends Compuesto
{
    public NodoAnd(Nodo l, Nodo r) {
        this.agregaHijoPrincipio(l);
    	this.agregaHijoFinal(r);
    }

    public void accept(Visitor v){
     	v.visit(this);
    }
}
