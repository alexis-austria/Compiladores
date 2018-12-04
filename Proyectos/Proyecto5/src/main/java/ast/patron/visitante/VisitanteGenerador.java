package ast;
import java.io.*;
import ast.patron.compuesto.*;
import ast.patron.visitante.*;
import java.util.Arrays;

public class VisitanteGenerador implements Visitor {
    Registros reg;

    public VisitanteGenerador(){
      this.reg = new Registros();
    }

    //Generador de codigo para la resta.
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

    public void visit(NodoGr n) {
       
    }

    public void visit(NodoGrq n) {
        
    }

    public void visit(NodoLe n) {
        
    }

    public void visit(NodoLeq n) {
        
    }

    public void visit(NodoModulo n) {
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
        String opcode =  "rem";
        System.out.println(opcode + " " + objetivo + ", " +
                          siguientes[0] + ", " + siguientes[1]);
        
    }

    public void visit(NodoNot n) {
        
    }

    public void visit(NodoPor n) {
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
        String opcode =  "mul";
        System.out.println(opcode + " " + objetivo + ", " +
                          siguientes[0] + ", " + siguientes[1]);
        
    }

    public void visit(NodoPotencia n) {
        
        
    }

    public void visit(NodoWhile n) {
       
    }

    public void visit(NodoIf n) {
       
    }

    public void visit(NodoDiff n) {
        
    }

    public void visit(NodoDiv n) {
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
        String opcode =  "div";
        System.out.println(opcode + " " + objetivo + ", " +
                          siguientes[0] + ", " + siguientes[1]);
       
    }

    public void visit(NodoDoubleEq n) {
        
    }

    public void visit(NodoIntDiv n) {
        
    }

    public void visit(NodoSuma n) {
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
        String opcode =  "add";
        System.out.println(opcode + " " + objetivo + ", " +
                          siguientes[0] + ", " + siguientes[1]);
        
    }

    public void visit(Compuesto n) {
       for(Nodo nodo : n.getHijos().getAll()){
            nodo.accept(this);
       }
    }

    public void visit(IdentificadorHoja n){
        
    }

    public void visit(NodoEq n){
       
    }

    public void visit(IntHoja n) {
        
    }

    public void visit(CadenaHoja n) {
        
    }

    public void visit(BooleanoHoja n) {
        
    }

    public void visit(RealHoja n) {
       
    }

    public void visit(NodoElse n){
        
    }

    public void visit(NodoDoubleP n){
       
    }

    public void visit(NodoAnd n){
        
    }

    //Generador de codigo para el print.
    public void visit(NodoPrint n){
        Nodo hi = n.getPrimerHijo();
        String objetivo = reg.getObjetivo();
        String[] siguientes = reg.getNsiguientes(2);
        // Genero el código del hijo.
        reg.setObjetivo(siguientes[0]);
        hi.accept(this);
        if(hi.getNombre() != null)//Si queremos imprimir algo ya definido lo cargamos.
            System.out.println("lw " + objetivo + ", " + hi.getNombre());
        String opcode ="li    " + "$v0, " + "4" + "\n";//Codigo de llamada al sistema para imprimir.
        opcode = opcode + "syscall" + "\n";
        System.out.println(opcode);
        
    }

    public void visit(NodoOr n) {
       
    }

    public void visit(Nodo n){
       
        
    }
}