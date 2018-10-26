package ast.patron.compuesto;
import ast.patron.visitante.*;

Public class NodoMas extends compuesto{

    Public NodoMas(Nodo l, Nodo r){
        this.agregaHijoPrint(l);
        this.agregaHijoFinal(r);
    }

    public void accept(Visitor v){
     	v.visit(this);
    }

}
