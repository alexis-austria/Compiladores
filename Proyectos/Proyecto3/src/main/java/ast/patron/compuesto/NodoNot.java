package ast.patron.compuesto;
import ast.patron.visitante.*;

Public NodoNot extends compuesto{

    Public NodoNot(Nodo l, Nodo r){
        this.agregaHijoPrint(l);
        this.agregaHijoFinal(r);
    }

    public void accept(Visitor v){
     	v.visit(this);
    }

}