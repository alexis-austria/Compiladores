package ast.patron.visitante;
import ast.patron.compuesto.*;
import java.util.LinkedList;
import java.util.Iterator;

public class VisitorPrint implements Visitor
{
    //Hojas
    public void visit(IntHoja n){
	System.out.print("[Hoja Entera] valor: " + n.getValor().ival);
    }

     public void visit(CadenaHoja s){
	System.out.print("[Hoja Cadena] valor: " + s.getValor().sval);
    }

    public void visit(RealHoja d){
	System.out.print("[Hoja Real] valor: " + d.getValor().dval);
    }

    public void visit(BooleanoHoja b){
	System.out.print("[Hoja Booleano] valor: " + b.getValor().bval);
    }

    public void visit(IdentificadorHoja s){
	System.out.print("[Hoja Identificador] id: " + s.getNombre());
    }

    //Nodos
    public void visit(NodoGr n){
        System.out.println("GR");
        System.out.print("(");
        n.getPrimerHijo().accept(this);
        System.out.print(")");
        System.out.print("(");
        n.getUltimoHijo().accept(this);
        System.out.println(")");
    }

    public void visit(NodoGrq n){
        System.out.println("GRQ");
        System.out.print("(");
        n.getPrimerHijo().accept(this);
        System.out.print(")");
        System.out.print("(");
        n.getUltimoHijo().accept(this);
        System.out.println(")");
    }

    public void visit(NodoLe n){
        System.out.println("LE");
        System.out.print("(");
        n.getPrimerHijo().accept(this);
        System.out.print(")");
        System.out.print("(");
        n.getUltimoHijo().accept(this);
        System.out.println(")");
    }

    public void visit(NodoLeq n){
        System.out.println("LEQ");
        System.out.print("(");
        n.getPrimerHijo().accept(this);
        System.out.print(")");
        System.out.print("(");
        n.getUltimoHijo().accept(this);
        System.out.println(")");
    }

    public void visit(NodoModulo n){
        System.out.println("MODULO");
        System.out.print("(");
        n.getPrimerHijo().accept(this);
        System.out.print(")");
        System.out.print("(");
        n.getUltimoHijo().accept(this);
        System.out.println(")");
    }

    public void visit(NodoNot n){
        System.out.println("NOT");
        System.out.print("(");
        n.getPrimerHijo().accept(this);
        System.out.print(")");
        System.out.print("(");
        n.getUltimoHijo().accept(this);
        System.out.println(")");
    }

    public void visit(NodoOr n){
        System.out.println("OR");
        System.out.print("(");
        n.getPrimerHijo().accept(this);
        System.out.print(")");
        System.out.print("(");
        n.getUltimoHijo().accept(this);
        System.out.println(")");
    }

    public void visit(NodoPor n){
        System.out.println("POR");
        System.out.print("(");
        n.getPrimerHijo().accept(this);
        System.out.print(")");
        System.out.print("(");
        n.getUltimoHijo().accept(this);
        System.out.println(")");
    }


    public void visit(NodoPotencia n){
        System.out.println("POTENCIA");
        System.out.print("(");
        n.getPrimerHijo().accept(this);
        System.out.print(")");
        System.out.print("(");
        n.getUltimoHijo().accept(this);
        System.out.println(")");
    }

    public void visit(NodoPrint n){
        System.out.println("PRINT");
        System.out.print("(");
        n.getPrimerHijo().accept(this);
        System.out.print(")");
    }

    public void visit(NodoWhile n){
        System.out.println("WHILE");
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

    public void visit(NodoStmts n){
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

    public void visit(Compuesto n){
        int i = 0;
        while (i < n.getHijos().size()) {
            Nodo h = n.getHijos().getAll().get(i);
            System.out.print("(");
            h.accept(this);
            System.out.println(")");
        }
    }

    public void visit(Nodo n){
    }
}
