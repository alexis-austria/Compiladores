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
    public void visit(Compuesto n);
    public void visit(NodoGrq n);
    public void visit(NodoLe n);
    public void visit(NodoLeq n);
    public void visit(NodoModulo n);
    public void visit(NodoNot n);
    public void visit(NodoOr n);
    public void visit(NodoPor n);
    public void visit(NodoPotencia n);
    public void visit(NodoPrint n);
    public void visit(NodoWhile n);
    public void visit(NodoIf n);
    public void visit(NodoAnd n);
    public void visit(NodoDiff n);
    public void visit(NodoDiv n);
    public void visit(NodoDoubleEq n);
    public void visit(NodoDoubleP n);
    public void visit(NodoElse n);
    public void visit(NodoEq n);
    public void visit(NodoIntDiv n);
    public void visit(NodoResta n);
    public void visit(NodoSuma n);
    public void visit(NodoStmts n);
}
