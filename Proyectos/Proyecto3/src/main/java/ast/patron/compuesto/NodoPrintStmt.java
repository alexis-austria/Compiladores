package ast.patron.compuesto;
import ast.patron.visitante.*;

public class NodoPrintStmt extends Compuesto
{
    public NodoPrintStmt(){
	   hijos = new Hijos();
    }

    public NodoPrintStmt(Hijos h){
       hijos = h;
    }

    public NodoPrintStmt(Nodo l){
       hijos = new Hijos(l);
    }

    public void accept(Visitor v){
     	v.visit(this);
    }
}
