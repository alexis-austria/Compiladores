package ast.patron.compuesto;
import ast.patron.visitante.*;

Public NodoPotencia extends compuesto{

    Public NodoPotencia(Nodo l, Nodo r){
        this.agregaHijoPrint(l);
        this.agregaHijoFinal(r);
    }

    public void accept(Visitor v){
     	v.visit(this);
    }

}