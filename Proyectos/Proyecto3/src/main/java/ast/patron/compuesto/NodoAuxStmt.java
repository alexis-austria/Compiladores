package ast.patron.compuesto;
import ast.patron.visitante.*;

public class NodoAuxStmt extends Compuesto
{
    public NodoAuxStmt(){
	   hijos = new Hijos();
    }

    public NodoAuxStmt(Hijos h){
       hijos = h;
    }

    public NodoAuxStmt(Nodo l){
       hijos = new Hijos(l);
    }

    public void accept(Visitor v){
     	v.visit(this);
    }
}
