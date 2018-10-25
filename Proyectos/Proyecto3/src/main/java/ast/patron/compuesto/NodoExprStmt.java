package ast.patron.compuesto;
import ast.patron.visitante.*;

public class NodoExprStmt extends Compuesto
{
    public NodoExprStmt(){
	   hijos = new Hijos();
    }

    public NodoExprStmt(Hijos h){
       hijos = h;
    }

    public NodoExprStmt(Nodo l){
       hijos = new Hijos(l);
    }

    public void accept(Visitor v){
     	v.visit(this);
    }
}
