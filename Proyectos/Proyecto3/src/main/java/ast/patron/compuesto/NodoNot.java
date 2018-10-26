package ast.patron.compuesto;
import ast.patron.visitante.*;

Public class NodoNot extends compuesto{

    Public NodoNot(Nodo l, Nodo r){
        this.agregaHijoPrincipio(l);
        this.agregaHijoFinal(r);
    }

    public void accept(Visitor v){
     	v.visit(this);
    }

}
