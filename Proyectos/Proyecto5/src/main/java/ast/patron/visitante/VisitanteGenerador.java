package ast;
import java.io.*;
import ast.patron.compuesto.*;
import ast.patron.visitante.*;
import java.util.Arrays;

public class VisitanteGenerador implements Visitor {
    Registros reg = new Registros();

    //Genarador de codigo para la resta.
    public void visit(NodoResta n){
        Nodo hi = n.getPrimerHijo();
        Nodo hd = n.getUltimoHijo();
        String objetivo = reg.getObjetivo();
        String[] siguientes = reg.getNsiguientes(2);
        // Genero el código del subárbol izquiero
        reg.setObjetivo(siguientes[0]);
        hi.accept(this);
        // Genero el código del subárbol derecho
        reg.setObjetivo(siguientes[1]);
        hd.accept(this);
        String opcode =  "sub";
        System.out.println(opcode + " " + objetivo + ", " +
                          siguientes[0] + ", " + siguientes[1]);
  }

    public void visit(NodoStmts n){
    }
}