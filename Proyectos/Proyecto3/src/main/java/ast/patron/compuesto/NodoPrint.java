package ast.patron.compuesto;
import ast.patron.visitante.*;

Public class NodoPrint extends compuesto{

    Public NodoPrint(Nodo l, Nodo r){
        this.agregaHijoPrint(l);
        this.agregaHijoFinal(r);
    }

    public void accept(Visitor v){
     	v.visit(this);
    }

}
