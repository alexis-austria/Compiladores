package ast.patron.compuesto;
import ast.patron.visitante.*;

public class NodoWhStmt extends Compuesto
{
    public NodoWhStmt(){
	   hijos = new Hijos();
    }

    public NodoWhStmt(Hijos h){
       hijos = h;
    }

    public NodoWhStmt(Nodo l){
       hijos = new Hijos(l);
    }

    public void accept(Visitor v){
     	v.visit(this);
    }
}
