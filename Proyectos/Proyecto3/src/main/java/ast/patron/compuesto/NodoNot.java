package ast.patron.compuesto;
import ast.patron.visitante.*;

public class NodoNot extends Compuesto{

    public NodoNot(Nodo l){
        super(l);
    }

    public void accept(Visitor v){
     	v.visit(this);
    }

}
