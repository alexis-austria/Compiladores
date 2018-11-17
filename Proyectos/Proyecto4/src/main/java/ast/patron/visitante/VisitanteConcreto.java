package ast.patron.visitante;

import ast.patron.compuesto.*;
import java.util.Iterator;
import java.util.Hashtable;
import java.util.LinkedList;


public class VisitanteConcreto implements Visitor {

    //Se implementara la tabla de simbolos mediante un Hashtable para poder acceder
    //con el nombre con el que es llamado el identificador en el codigo ademas de poder almacenar
    //El tipo que tiene este identificador.
    private Hashtable<String, Integer> tablaDeSimbolos;
    
    //Los booleanos se representan con 0,enteros con 1, reales con 2 y cadenas con 3.
    private static final int BOOLEANO = 0;
    private static final int ENTERO = 1;
    private static final int REAL = 2;
    private static final int CADENA = 3;
    SistemaTipos verificadorSistemaTipos;

    public VisitanteConcreto(){
        //El string es para almacenar el nombre del identificador.
        //El entero es para almacenar el tipo del identificador.
        tablaDeSimbolos = new Hashtable<String, Integer>();
        //Creamos un objeto del sistema de tipos para poder verificar si son compatibles los tipos encada operacion.
        verificadorSistemaTipos = new SistemaTipos(); 
    }

    //Metodo que nos regresara el nombre de los tipos.
    public String regresaTipo(int tipo){
        if(tipo == 0) return "Bool";
        if(tipo == 1) return "Entero";
        if(tipo == 2) return "Real";
        if(tipo == 3) return "Cadena";
        else{//Esto nunca deberia pasar.
            return "Error";
        }
    }

    //Metodo para asignarle a un nodo el tipo que tendra.
    //Si la operacion se efectua entre dos tipos incompatibles se imprime un mensaje de error.
    public void visit(NodoGr n) {
        n.getPrimerHijo().accept(this);
        n.getUltimoHijo().accept(this); 
        int tipo = verificadorSistemaTipos.verificadorGr(n.getPrimerHijo().getType(), n.getUltimoHijo().getType());
        //Si el tipo no es -1 significa que la operacion esta conformada por tipos correctos.
        if(tipo != -1){    
            n.setTipo(tipo);
        //Si el tipo es -1 significa que uno o ambos tipos son incorrectos para la operacion.
        }else{
            System.out.printf("Error de tipos en operacion > " + regresaTipo(n.getPrimerHijo().getType()) 
                                                               + regresaTipo(n.getUltimoHijo().getType()));
            System.exit(0);
        }   
    }

     //Metodo para asignarle a un nodo el tipo que tendra.
    //Si la operacion se efectua entre dos tipos incompatibles se imprime un mensaje de error.
    public void visit(NodoGrq n) {
        n.getPrimerHijo().accept(this);
        n.getUltimoHijo().accept(this); 
        int tipo = verificadorSistemaTipos.verificadorGrq(n.getPrimerHijo().getType(), n.getUltimoHijo().getType());
        //Si el tipo no es -1 significa que la operacion esta conformada por tipos correctos.
        if(tipo != -1){    
            n.setTipo(tipo);
        //Si el tipo es -1 significa que uno o ambos tipos son incorrectos para la operacion.
        }else{
            System.out.printf("Error de tipos en operacion >= " + regresaTipo(n.getPrimerHijo().getType()) 
                                                               + regresaTipo(n.getUltimoHijo().getType()));
            System.exit(0);
        }   
    }

     //Metodo para asignarle a un nodo el tipo que tendra.
    //Si la operacion se efectua entre dos tipos incompatibles se imprime un mensaje de error.
    public void visit(NodoLe n) {
        n.getPrimerHijo().accept(this);
        n.getUltimoHijo().accept(this); 
        int tipo = verificadorSistemaTipos.verificadorLe(n.getPrimerHijo().getType(), n.getUltimoHijo().getType());
        //Si el tipo no es -1 significa que la operacion esta conformada por tipos correctos.
        if(tipo != -1){    
            n.setTipo(tipo);
        //Si el tipo es -1 significa que uno o ambos tipos son incorrectos para la operacion.
        }else{
            System.out.printf("Error de tipos en operacion < " + regresaTipo(n.getPrimerHijo().getType()) 
                                                               + regresaTipo(n.getUltimoHijo().getType()));
            System.exit(0);
        }   
    }

     //Metodo para asignarle a un nodo el tipo que tendra.
    //Si la operacion se efectua entre dos tipos incompatibles se imprime un mensaje de error.
    public void visit(NodoLeq n) {
        n.getPrimerHijo().accept(this);
        n.getUltimoHijo().accept(this); 
        int tipo = verificadorSistemaTipos.verificadorLeq(n.getPrimerHijo().getType(), n.getUltimoHijo().getType());
        //Si el tipo no es -1 significa que la operacion esta conformada por tipos correctos.
        if(tipo != -1){    
            n.setTipo(tipo);
        //Si el tipo es -1 significa que uno o ambos tipos son incorrectos para la operacion.
        }else{
            System.out.printf("Error de tipos en operacion <= " + regresaTipo(n.getPrimerHijo().getType()) 
                                                               + regresaTipo(n.getUltimoHijo().getType()));
            System.exit(0);
        }   
    }

     //Metodo para asignarle a un nodo el tipo que tendra.
    //Si la operacion se efectua entre dos tipos incompatibles se imprime un mensaje de error.
    public void visit(NodoModulo n) {
        n.getPrimerHijo().accept(this);
        n.getUltimoHijo().accept(this); 
        int tipo = verificadorSistemaTipos.verificadorModulo(n.getPrimerHijo().getType(), n.getUltimoHijo().getType());
        //Si el tipo no es -1 significa que la operacion esta conformada por tipos correctos.
        if(tipo != -1){    
            n.setTipo(tipo);
        //Si el tipo es -1 significa que uno o ambos tipos son incorrectos para la operacion.
        }else{
            System.out.printf("Error de tipos en operacion % " + regresaTipo(n.getPrimerHijo().getType()) 
                                                               + regresaTipo(n.getUltimoHijo().getType()));
            System.exit(0);
        }   
    }

     //Metodo para asignarle a un nodo el tipo que tendra.
    //Si la operacion se efectua entre dos tipos incompatibles se imprime un mensaje de error.
    public void visit(NodoNot n) {
        n.getPrimerHijo().accept(this);
        int tipo = verificadorSistemaTipos.verificadorNot(n.getPrimerHijo().getType());
        //Si el tipo no es -1 significa que la operacion esta conformada por tipos correctos.
        if(tipo != -1){    
            n.setTipo(tipo);
        //Si el tipo es -1 significa que uno o ambos tipos son incorrectos para la operacion.
        }else{
            System.out.printf("Error de tipos en operacion not " + regresaTipo(n.getPrimerHijo().getType()));
            System.exit(0);
        }   
    }

     //Metodo para asignarle a un nodo el tipo que tendra.
    //Si la operacion se efectua entre dos tipos incompatibles se imprime un mensaje de error.
    public void visit(NodoPor n) {
        n.getPrimerHijo().accept(this);
        n.getUltimoHijo().accept(this); 
        int tipo = verificadorSistemaTipos.verificadorPor(n.getPrimerHijo().getType(), n.getUltimoHijo().getType());
        //Si el tipo no es -1 significa que la operacion esta conformada por tipos correctos.
        if(tipo != -1){    
            n.setTipo(tipo);
        //Si el tipo es -1 significa que uno o ambos tipos son incorrectos para la operacion.
        }else{
            System.out.printf("Error de tipos en operacion * " + regresaTipo(n.getPrimerHijo().getType()) 
                                                               + regresaTipo(n.getUltimoHijo().getType()));
            System.exit(0);
        }   
    }

     //Metodo para asignarle a un nodo el tipo que tendra.
    //Si la operacion se efectua entre dos tipos incompatibles se imprime un mensaje de error.
    public void visit(NodoPotencia n) {
        n.getPrimerHijo().accept(this);
        n.getUltimoHijo().accept(this); 
        int tipo = verificadorSistemaTipos.verificadorPotencia(n.getPrimerHijo().getType(), n.getUltimoHijo().getType());
        //Si el tipo no es -1 significa que la operacion esta conformada por tipos correctos.
        if(tipo != -1){    
            n.setTipo(tipo);
        //Si el tipo es -1 significa que uno o ambos tipos son incorrectos para la operacion.
        }else{
            System.out.printf("Error de tipos en operacion ** " + regresaTipo(n.getPrimerHijo().getType()) 
                                                               + regresaTipo(n.getUltimoHijo().getType()));
            System.exit(0);
        }       
    }

     //Metodo para asignarle a un nodo el tipo que tendra.
    //Si la operacion se efectua entre dos tipos incompatibles se imprime un mensaje de error.
    public void visit(NodoWhile n) {
        n.getPrimerHijo().accept(this); 
        int tipo = verificadorSistemaTipos.verificadorWhile(n.getPrimerHijo().getType());
        //Si el tipo no es -1 significa que la operacion esta conformada por tipos correctos.
        if(tipo != -1){    
            n.setTipo(tipo);
        //Si el tipo es -1 significa que uno o ambos tipos son incorrectos para la operacion.
        }else{
            System.out.printf("Error de tipos en operacion while " + regresaTipo(n.getPrimerHijo().getType()));
            System.exit(0);
        }   
    }

     //Metodo para asignarle a un nodo el tipo que tendra.
    //Si la operacion se efectua entre dos tipos incompatibles se imprime un mensaje de error.
    public void visit(NodoIf n) {
        n.getPrimerHijo().accept(this);
        int tipo = verificadorSistemaTipos.verificadorIf(n.getPrimerHijo().getType());
        //Si el tipo no es -1 significa que la operacion esta conformada por tipos correctos.
        if(tipo != -1){    
            n.setTipo(tipo);
        //Si el tipo es -1 significa que uno o ambos tipos son incorrectos para la operacion.
        }else{
            System.out.printf("Error de tipos en operacion if " + regresaTipo(n.getPrimerHijo().getType()));
            System.exit(0);
        }   
    }

     //Metodo para asignarle a un nodo el tipo que tendra.
    //Si la operacion se efectua entre dos tipos incompatibles se imprime un mensaje de error.
    public void visit(NodoDiff n) {
        n.getPrimerHijo().accept(this);
        n.getUltimoHijo().accept(this); 
        int tipo = verificadorSistemaTipos.verificadorDiff(n.getPrimerHijo().getType(), n.getUltimoHijo().getType());
        //Si el tipo no es -1 significa que la operacion esta conformada por tipos correctos.
        if(tipo != -1){    
            n.setTipo(tipo);
        //Si el tipo es -1 significa que uno o ambos tipos son incorrectos para la operacion.
        }else{
            System.out.printf("Error de tipos en operacion != " + regresaTipo(n.getPrimerHijo().getType()) 
                                                               + regresaTipo(n.getUltimoHijo().getType()));
            System.exit(0);
        }   
    }

     //Metodo para asignarle a un nodo el tipo que tendra.
    //Si la operacion se efectua entre dos tipos incompatibles se imprime un mensaje de error.
    public void visit(NodoDiv n) {
        n.getPrimerHijo().accept(this);
        n.getUltimoHijo().accept(this); 
        int tipo = verificadorSistemaTipos.verificadorDiv(n.getPrimerHijo().getType(), n.getUltimoHijo().getType());
        //Si el tipo no es -1 significa que la operacion esta conformada por tipos correctos.
        if(tipo != -1){    
            n.setTipo(tipo);
        //Si el tipo es -1 significa que uno o ambos tipos son incorrectos para la operacion.
        }else{
            System.out.printf("Error de tipos en operacion / " + regresaTipo(n.getPrimerHijo().getType()) 
                                                               + regresaTipo(n.getUltimoHijo().getType()));
            System.exit(0);
        }   
    }

     //Metodo para asignarle a un nodo el tipo que tendra.
    //Si la operacion se efectua entre dos tipos incompatibles se imprime un mensaje de error.
    public void visit(NodoDoubleEq n) {
        n.getPrimerHijo().accept(this);
        n.getUltimoHijo().accept(this); 
        int tipo = verificadorSistemaTipos.verificadorDoubleEq(n.getPrimerHijo().getType(), n.getUltimoHijo().getType());
        //Si el tipo no es -1 significa que la operacion esta conformada por tipos correctos.
        if(tipo != -1){    
            n.setTipo(tipo);
        //Si el tipo es -1 significa que uno o ambos tipos son incorrectos para la operacion.
        }else{
            System.out.printf("Error de tipos en operacion == " + regresaTipo(n.getPrimerHijo().getType()) 
                                                               + regresaTipo(n.getUltimoHijo().getType()));
            System.exit(0);
        }   
    }

     //Metodo para asignarle a un nodo el tipo que tendra.
    //Si la operacion se efectua entre dos tipos incompatibles se imprime un mensaje de error.
    public void visit(NodoIntDiv n) {
        n.getPrimerHijo().accept(this);
        n.getUltimoHijo().accept(this); 
        int tipo = verificadorSistemaTipos.verificadorDivInt(n.getPrimerHijo().getType(), n.getUltimoHijo().getType());
        //Si el tipo no es -1 significa que la operacion esta conformada por tipos correctos.
        if(tipo != -1){    
            n.setTipo(tipo);
        //Si el tipo es -1 significa que uno o ambos tipos son incorrectos para la operacion.
        }else{
            System.out.printf("Error de tipos en operacion // " + regresaTipo(n.getPrimerHijo().getType()) 
                                                               + regresaTipo(n.getUltimoHijo().getType()));
            System.exit(0);
        }   
    }

     //Metodo para asignarle a un nodo el tipo que tendra.
    //Si la operacion se efectua entre dos tipos incompatibles se imprime un mensaje de error.
    public void visit(NodoResta n) {
        n.getPrimerHijo().accept(this);
        n.getUltimoHijo().accept(this); 
        int tipo = verificadorSistemaTipos.verificadorResta(n.getPrimerHijo().getType(), n.getUltimoHijo().getType());
        //Si el tipo no es -1 significa que la operacion esta conformada por tipos correctos.
        if(tipo != -1){    
            n.setTipo(tipo);
        //Si el tipo es -1 significa que uno o ambos tipos son incorrectos para la operacion.
        }else{
            System.out.printf("Error de tipos en operacion - " + regresaTipo(n.getPrimerHijo().getType()) 
                                                               + regresaTipo(n.getUltimoHijo().getType()));
            System.exit(0);
        }   
    }

     //Metodo para asignarle a un nodo el tipo que tendra.
    //Si la operacion se efectua entre dos tipos incompatibles se imprime un mensaje de error.
    public void visit(NodoSuma n) {
        n.getPrimerHijo().accept(this);
        n.getUltimoHijo().accept(this); 
        int tipo = verificadorSistemaTipos.verificadorSuma(n.getPrimerHijo().getType(), n.getUltimoHijo().getType());
        //Si el tipo no es -1 significa que la operacion esta conformada por tipos correctos.
        if(tipo != -1){    
            n.setTipo(tipo);
        //Si el tipo es -1 significa que uno o ambos tipos son incorrectos para la operacion.
        }else{
            System.out.printf("Error de tipos en operacion > " + regresaTipo(n.getPrimerHijo().getType()) 
                                                               + regresaTipo(n.getUltimoHijo().getType()));
            System.exit(0);
        }   
    }

    // Sup que sólo tiene que visitar a todos y no tiene tipo
    public void visit(Compuesto n) {
        for(Nodo nodo : n.getHijos().getAll()){
            nodo.accept(this);
        }
    }

    public void visit(IdentificadorHoja n){
        if( !tablaDeSimbolos.containsKey(n.getNombre())){
            System.err.println("\n\nLa variable " + n.getNombre() + " no tiene un valor definido");
            //System.out.println(tablaSim.keySet());
            
            System.exit(0);
        }else{
            n.setTipo(tablaDeSimbolos.get(n.getNombre()));
        }
    }

    public void visit(NodoEq n){
        n.getUltimoHijo().accept(this);
        String name = n.getPrimerHijo().getNombre();  
        // Verifica en la TS si existe
        if (tablaDeSimbolos.containsKey(name)){            
            // Verifica si el tipo que tenía es igual al nuevo
            if(tablaDeSimbolos.get(name) != n.getUltimoHijo().getType()){
                System.out.println("El nuevo tipo no es del mismo tipo al antiguo");
            }else{
                n.setTipo(tablaDeSimbolos.get(name));
            }
        }else{  
            tablaDeSimbolos.put(name, n.getUltimoHijo().getType());
        }
        
        n.getPrimerHijo().accept(this);
    }

    public void visit(IntHoja n) {
        n.setTipo(ENTERO);
    }

     public void visit(CadenaHoja n) {
        n.setTipo(CADENA);
    }

     public void visit(BooleanoHoja n) {
        n.setTipo(BOOLEANO);
    }

     public void visit(RealHoja n) {
        n.setTipo(REAL);
    }

    public void visit(NodoStmts n){
    }

     public void visit(NodoElse n){
    }

     public void visit(NodoDoubleP n){
    }

     public void visit(NodoAnd n){
    }

     public void visit(NodoPrint n){
    }

     public void visit(NodoOr n) {
    }

    public void visit(Nodo n){
    }
}
