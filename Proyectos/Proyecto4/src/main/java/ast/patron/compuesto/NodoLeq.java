package ast.patron.compuesto;
import ast.patron.visitante.*;

public class NodoLeq extends Compuesto{

    public NodoLeq(Nodo l, Nodo r){
        this.agregaHijoPrincipio(l);
        this.agregaHijoFinal(r);
    }

    public void accept(Visitor v){
     	v.visit(this);
    }

}
