package ast.patron.compuesto;
import ast.patron.visitante.*;

public class NodoCompStmt extends Compuesto
{
    public NodoCompStmt(){
	   hijos = new Hijos();
    }

    public NodoCompStmt(Hijos h){
       hijos = h;
    }

    public NodoCompStmt(Nodo l){
       hijos = new Hijos(l);
    }

    public void accept(Visitor v){
     	v.visit(this);
    }
}
