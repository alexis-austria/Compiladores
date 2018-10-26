package ast.patron.compuesto;
import ast.patron.visitante.*;

Public class NodoLeq extends compuesto{

    Public NodoLeq(Nodo l, Nodo r){
        this.agregaHijoPrint(l);
        this.agregaHijoFinal(r);
    }

    public void accept(Visitor v){
     	v.visit(this);
    }

}
