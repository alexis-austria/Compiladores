package ast.patron.visitante;
import ast.patron.compuesto.*;

public interface Visitor
{
    public void visit(IntHoja n);
    public void visit(Nodo n);
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
