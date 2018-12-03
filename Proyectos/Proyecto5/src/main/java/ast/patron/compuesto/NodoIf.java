package ast.patron.compuesto;
import ast.patron.visitante.*;
import java.util.LinkedList;

public class NodoIf extends Compuesto
{
    public NodoIf(){
	   super();
    }

     //Se obtiene el total de hijos.
    public LinkedList<Nodo> getTotal(){
        return hijos.getAll();
    }
    
    //Se obtiene el numero de hijos.
    public int obtenNumeroHijos(){
        return hijos.size();
    }
    

    public void accept(Visitor v){
     	v.visit(this);
    }
}
