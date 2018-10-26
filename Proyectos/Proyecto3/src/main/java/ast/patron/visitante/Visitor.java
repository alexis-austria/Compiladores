package ast.patron.visitante;
import ast.patron.compuesto.*;

public interface Visitor
{
    //Hojas
    public void visit(IntHoja n);
    public void visit(BooleanoHoja b);
    public void visit(RealHoja f);
    public void visit(CadenaHoja s);
    public void visit(IdentificadorHoja s);
    public void visit(Nodo n);
    //Nodos
    public void visit(NodoGr n);
    public void visit(NodoGrq n);
    public void visit(NodoLe n);
    public void visit(NodoLeq n);
    public void visit(NodoMas n);
    public void visit(NodoModulo n);
    public void visit(NodoNot n);
    public void visit(NodoOr n);
    public void visit(NodoPor n);
    public void visit(NodoPotencia n);
    public void visit(NodoPrint n);
    public void visit(NodoWhile n);
    public void visit(NodoStmt n);
    public void visit(NodoSimpStmt n);
    public void visit(NodoCompStmt n);
    public void visit(NodoIfStmt n);
    public void visit(NodoWhStmt n);
    public void visit(NodoSuite n);
    public void visit(NodoAuxStmt n);
    public void visit(NodoSmallStmt n);
    public void visit(NodoExprStmt n);
    public void visit(NodoPrintStmt n);
    public void visit(NodoTest n);
    public void visit(NodoOrTest n);
}
