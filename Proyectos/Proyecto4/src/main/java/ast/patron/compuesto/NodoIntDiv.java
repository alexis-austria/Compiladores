package ast.patron.compuesto;
import ast.patron.visitante.*;

public class NodoIntDiv extends Compuesto
{
    public NodoIntDiv(Nodo l, Nodo r) {
        this.agregaHijoPrincipio(l);
    	this.agregaHijoFinal(r);
    }

    public void accept(Visitor v){
     	v.visit(this);
    }
}
