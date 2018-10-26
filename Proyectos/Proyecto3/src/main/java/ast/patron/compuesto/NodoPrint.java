package ast.patron.compuesto;
import ast.patron.visitante.*;

public class NodoPrint extends Compuesto{

    public NodoPrint(Nodo l){
        this.agregaHijoPrincipio(l);
        //this.agregaHijoFinal(null);
    }

    public void accept(Visitor v){
     	v.visit(this);
    }

}
