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
    public void visit(Nodo n){
	System.out.print("Nodo Genérico");
    }

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

    public void visit(NodoMas n){
        System.out.println("MAS");
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

    public void visit(NodoStmts n){
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
