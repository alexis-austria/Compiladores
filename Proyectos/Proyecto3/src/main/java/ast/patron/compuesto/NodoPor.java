package ast.patron.compuesto;
import ast.patron.visitante.*;

Public NodoPro extends compuesto{

    Public NodoPor(Nodo l, Nodo r){
        this.agregaHijoPrint(l);
        this.agregaHijoFinal(r);
    }

    public void accept(Visitor v){
     	v.visit(this);
    }

}