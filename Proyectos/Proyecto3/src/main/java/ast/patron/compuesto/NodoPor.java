package ast.patron.compuesto;
import ast.patron.visitante.*;

Public class NodoPro extends compuesto{

    Public NodoPor(Nodo l, Nodo r){
        this.agregaHijoPrincipio(l);
        this.agregaHijoFinal(r);
    }

    public void accept(Visitor v){
     	v.visit(this);
    }

}
