package ast.patron.compuesto;
import ast.patron.visitante.*;

Public class NodoPrint extends compuesto{

    Public NodoPrint(Nodo l){
        this.agregaHijoPrincipio(l);
        //this.agregaHijoFinal(null);
    }

    public void accept(Visitor v){
     	v.visit(this);
    }

}
