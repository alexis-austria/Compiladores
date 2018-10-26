package ast.patron.compuesto;
import ast.patron.visitante.*;

Public NodoGrq extends compuesto{

    Public NodoGrq(Nodo l, Nodo r){
        this.agregaHijoPrint(l);
        this.agregaHijoFinal(r);
    }

    public void accept(Visitor v){
     	v.visit(this);
    }

}