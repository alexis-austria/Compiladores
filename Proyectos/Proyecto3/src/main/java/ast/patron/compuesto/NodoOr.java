package ast.patron.compuesto;
import ast.patron.visitante.*;

Public NodoOr extends compuesto{

    Public NodoOr(Nodo l, Nodo r){
        this.agregaHijoPrint(l);
        this.agregaHijoFinal(r);
    }

    public void accept(Visitor v){
     	v.visit(this);
    }

}