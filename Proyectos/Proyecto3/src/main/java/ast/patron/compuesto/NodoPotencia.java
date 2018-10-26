package ast.patron.compuesto;
import ast.patron.visitante.*;

Public class NodoPotencia extends compuesto{

    Public NodoPotencia(Nodo l, Nodo r){
        this.agregaHijoPrincipio(l);
        this.agregaHijoFinal(r);
    }

    public void accept(Visitor v){
     	v.visit(this);
    }

}
