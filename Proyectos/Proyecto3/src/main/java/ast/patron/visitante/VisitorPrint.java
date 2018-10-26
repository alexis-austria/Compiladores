package ast.patron.visitante;
import ast.patron.compuesto.*;
import java.util.LinkedList;
import java.util.Iterator;

public class VisitorPrint implements Visitor
{

    public void visit(IntHoja n){
	System.out.print("[Hoja Entera] valor: " + n.getValor().ival);
    }

    public void visit(Nodo n){

    }

    public void visit(NodoAnd n){
        System.out.println("and");
        System.out.print("(");
        n.getPrimerHijo().accept(this);
        System.out.print(")");
        System.out.print("(");
        n.getUltimoHijo().accept(this);
        System.out.println(")");
    }

    public void visit(NodoDiff n){
        System.out.println("!=");
        System.out.print("(");
        n.getPrimerHijo().accept(this);
        System.out.print(")");
        System.out.print("(");
        n.getUltimoHijo().accept(this);
        System.out.println(")");
    }

    public void visit(NodoDiv n){
        System.out.println("/");
        System.out.print("(");
        n.getPrimerHijo().accept(this);
        System.out.print(")");
        System.out.print("(");
        n.getUltimoHijo().accept(this);
        System.out.println(")");
    }

    public void visit(NodoDoubleEq n){
        System.out.println("==");
        System.out.print("(");
        n.getPrimerHijo().accept(this);
        System.out.print(")");
        System.out.print("(");
        n.getUltimoHijo().accept(this);
        System.out.println(")");
    }

    public void visit(NodoDoubleP n){
        System.out.println(":");
        System.out.print("(");
        n.getPrimerHijo().accept(this);
        System.out.print(")");
        System.out.print("(");
        n.getUltimoHijo().accept(this);
        System.out.println(")");
    }

    public void visit(NodoElse n){
        System.out.println("else");
        System.out.print("(");
        n.getPrimerHijo().accept(this);
        System.out.print(")");
        System.out.print("(");
        n.getUltimoHijo().accept(this);
        System.out.println(")");
    }

    public void visit(NodoEq n){
        System.out.println("=");
        System.out.print("(");
        n.getPrimerHijo().accept(this);
        System.out.print(")");
        System.out.print("(");
        n.getUltimoHijo().accept(this);
        System.out.println(")");
    }

    public void visit(NodoIf n){
        System.out.println("If");
        LinkedList<Nodo> hijos = n.hijos.getAll();
        System.out.print("Condicion: ");
        hijos.get(0).accept(this);
        System.out.print("Then: ");
        hijos.get(1).accept(this);
        if (hijos.size() == 3) {
            System.out.print("Else: ");
            hijos.get(2).accept(this);
        }
    }

    public void visit(NodoIntDiv n){
        System.out.println("//");
        System.out.print("(");
        n.getPrimerHijo().accept(this);
        System.out.print(")");
        System.out.print("(");
        n.getUltimoHijo().accept(this);
        System.out.println(")");
    }

    public void visit(NodoResta n){
        System.out.println("-");
        System.out.print("(");
        n.getPrimerHijo().accept(this);
        System.out.print(")");
        System.out.print("(");
        n.getUltimoHijo().accept(this);
        System.out.println(")");
    }

    public void visit(NodoSuma n){
        System.out.println("+");
        System.out.print("(");
        n.getPrimerHijo().accept(this);
        System.out.print(")");
        System.out.print("(");
        n.getUltimoHijo().accept(this);
        System.out.println(")");
    }

    
}
