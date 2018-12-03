package ast.patron.compuesto;
import ast.patron.visitante.*;

public class NodoPor extends Compuesto{

    public NodoPor(Nodo l, Nodo r){
        this.agregaHijoPrincipio(l);
        this.agregaHijoFinal(r);
    }

    public void accept(Visitor v){
     	v.visit(this);
    }

}
