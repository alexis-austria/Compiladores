package ast.patron.visitante;
import ast.patron.compuesto.*;
import java.util.LinkedList;
import java.util.Iterator;

public class VisitorPrint implements Visitor
{
    //Hojas
    public void visit(IntHoja n){
	System.out.println("[Hoja Entera] valor: " + n.getValor().ival);
    }

     public void visit(CadenaHoja s){
	System.out.println("[Hoja Cadena] valor: " + s.getValor().sval);
    }

    public void visit(RealHoja d){
	System.out.println("[Hoja Real] valor: " + d.getValor().dval);
    }

    public void visit(BooleanoHoja b){
	System.out.println("[Hoja Booleano] valor: " + b.getValor().bval);
    }

    public void visit(IdentificadorHoja s){
	System.out.println("[Hoja Identificador] id: " + s.getNombre());
    }

    //Nodos
    public void visit(NodoGr n){
        System.out.println("GR");
        n.getPrimerHijo().accept(this);
        n.getUltimoHijo().accept(this);
    }

    public void visit(NodoGrq n){
        System.out.println("GRQ");
        n.getPrimerHijo().accept(this);
        n.getUltimoHijo().accept(this);
    }

    public void visit(NodoLe n){
        System.out.println("LE");
        n.getPrimerHijo().accept(this);
        n.getUltimoHijo().accept(this);
    }

    public void visit(NodoLeq n){
        System.out.println("LEQ");
        n.getPrimerHijo().accept(this);
        n.getUltimoHijo().accept(this);
    }

    public void visit(NodoModulo n){
        System.out.println("MODULO");
        n.getPrimerHijo().accept(this);
        n.getUltimoHijo().accept(this);
    }

    public void visit(NodoNot n){
        System.out.println("NOT");
        n.getPrimerHijo().accept(this);
        n.getUltimoHijo().accept(this);
    }

    public void visit(NodoOr n){
        System.out.println("OR");
        n.getPrimerHijo().accept(this);
        n.getUltimoHijo().accept(this);
    }

    public void visit(NodoPor n){
        System.out.println("POR");
        n.getPrimerHijo().accept(this);
        n.getUltimoHijo().accept(this);
    }


    public void visit(NodoPotencia n){
        System.out.println("POTENCIA");
        n.getPrimerHijo().accept(this);
        n.getUltimoHijo().accept(this);
    }

    public void visit(NodoPrint n){
        System.out.println("PRINT");
        n.getPrimerHijo().accept(this);
    }

    public void visit(NodoWhile n){
        System.out.println("While");
        System.out.print("Condicion: ");
        n.getPrimerHijo().accept(this);
        n.getUltimoHijo().accept(this);
    }

    public void visit(NodoSuma n){
        System.out.println("+");
        n.getPrimerHijo().accept(this);
        n.getUltimoHijo().accept(this);
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
        n.getPrimerHijo().accept(this);
        n.getUltimoHijo().accept(this);
    }

    public void visit(NodoDiff n){
        System.out.println("!=");
        n.getPrimerHijo().accept(this);
        n.getUltimoHijo().accept(this);
    }

    public void visit(NodoDiv n){
        System.out.println("/");
        n.getPrimerHijo().accept(this);
        n.getUltimoHijo().accept(this);
    }

    public void visit(NodoDoubleEq n){
        System.out.println("==");
        n.getPrimerHijo().accept(this);
        n.getUltimoHijo().accept(this);
    }

    public void visit(NodoDoubleP n){
        System.out.println(":");
        n.getPrimerHijo().accept(this);
        n.getUltimoHijo().accept(this);
    }

    public void visit(NodoElse n){
        System.out.println("else");
        n.getPrimerHijo().accept(this);
        n.getUltimoHijo().accept(this);
    }

    public void visit(NodoEq n){
        System.out.println("=");
        n.getPrimerHijo().accept(this);
        n.getUltimoHijo().accept(this);
    }

    public void visit(NodoIntDiv n){
        System.out.println("//");
        n.getPrimerHijo().accept(this);
        n.getUltimoHijo().accept(this);
    }

    public void visit(NodoResta n){
        System.out.println("-");
        n.getPrimerHijo().accept(this);
        n.getUltimoHijo().accept(this);
    }

    public void visit(Compuesto n){
        int i = 0;
        while (i < n.getHijos().size()) {
            Nodo h = n.getHijos().getAll().get(i);
            if (h != null)
                h.accept(this);
            i++;
        }
    }

    public void visit(Nodo n){
    }
}
