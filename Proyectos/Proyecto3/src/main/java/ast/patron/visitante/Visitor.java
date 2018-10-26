package ast.patron.visitante;
import ast.patron.compuesto.*;

public interface Visitor
{
    public void visit(IntHoja n);
    public void visit(Nodo n);
    public void visit(NodoAnd n);
    public void visit(NodoDiff n);
    public void visit(NodoDiv n);
    public void visit(NodoDoubleEq n);
    public void visit(NodoDoubleP n);
    public void visit(NodoElse n);
    public void visit(NodoEq n);
    public void visit(NodoIf n);
    public void visit(NodoIntDIv n);
    public void visit(NodoResta n);
    public void visit(NodoSuma n);
}
