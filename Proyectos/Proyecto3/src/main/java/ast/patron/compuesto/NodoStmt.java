package ast.patron.compuesto;
import ast.patron.visitante.*;

public class NodoStmt extends Compuesto
{
    public NodoStmt(){
	   hijos = new Hijos();
    }

    public NodoStmt(Hijos h){
       hijos = h;
    }

    public NodoStmt(Nodo l){
       hijos = new Hijos(l);
    }

    public void accept(Visitor v){
     	v.visit(this);
    }
}
