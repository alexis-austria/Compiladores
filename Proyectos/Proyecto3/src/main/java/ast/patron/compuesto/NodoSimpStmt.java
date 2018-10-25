package ast.patron.compuesto;
import ast.patron.visitante.*;

public class NodoSimpStmt extends Compuesto
{
    public NodoSimpStmt(){
	   hijos = new Hijos();
    }

    public NodoSimpStmt(Hijos h){
       hijos = h;
    }

    public NodoSimpStmt(Nodo l){
       hijos = new Hijos(l);
    }

    public void accept(Visitor v){
     	v.visit(this);
    }
}
