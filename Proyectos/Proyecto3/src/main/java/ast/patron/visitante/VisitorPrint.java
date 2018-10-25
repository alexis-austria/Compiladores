package ast.patron.visitante;
import ast.patron.compuesto.*;
import java.util.LinkedList;
import java.util.Iterator;

public class VisitorPrint implements Visitor
{

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

    public void visit(Nodo n){

    }

    public void visit(NodoStmt n) {

    }

    public void visit(NodoSimpStmt n) {

    }

    public void visit(NodoCompStmt n) {

    }

    public void visit(NodoIfStmt n) {

    }

    public void visit(NodoWhStmt n) {

    }

    public void visit(NodoSuite n) {

    }

    public void visit(NodoAuxStmt n) {

    }

    public void visit(NodoSmallStmt n) {

    }

    public void visit(NodoExprStmt n) {

    }

    public void visit(NodoPrintStmt n) {

    }

    public void visit(NodoTest n) {

    }

    public void visit(NodoOrTest n) {

    }
}
