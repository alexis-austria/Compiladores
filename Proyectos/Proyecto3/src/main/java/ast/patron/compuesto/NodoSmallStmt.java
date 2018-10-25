package ast.patron.compuesto;
import ast.patron.visitante.*;

public class NodoSmallStmt extends Compuesto
{
    public NodoSmallStmt(){
	   hijos = new Hijos();
    }

    public NodoSmallStmt(Hijos h){
       hijos = h;
    }

    public NodoSmallStmt(Nodo l){
       hijos = new Hijos(l);
    }

    public void accept(Visitor v){
     	v.visit(this);
    }
}
