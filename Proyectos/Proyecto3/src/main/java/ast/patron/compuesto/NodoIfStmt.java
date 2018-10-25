package ast.patron.compuesto;
import ast.patron.visitante.*;

public class NodoIfStmt extends Compuesto
{
    public NodoIfStmt(){
	   hijos = new Hijos();
    }

    public NodoIfStmt(Hijos h){
       hijos = h;
    }

    public NodoIfStmt(Nodo l){
       hijos = new Hijos(l);
    }

    public void accept(Visitor v){
     	v.visit(this);
    }
}
