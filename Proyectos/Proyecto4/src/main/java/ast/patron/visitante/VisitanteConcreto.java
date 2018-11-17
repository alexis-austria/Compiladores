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
            System.out.printf("Error de tipos en operacion > " + "\n" + regresaTipo(n.getPrimerHijo().getType()) + " No se puede operar con "
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
            System.out.printf("Error de tipos en operacion >= " + "\n" + regresaTipo(n.getPrimerHijo().getType()) + " No se puede operar con "
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
            System.out.printf("Error de tipos en operacion < " + "\n" + regresaTipo(n.getPrimerHijo().getType()) + " No se puede operar con "
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
            System.out.printf("Error de tipos en operacion <= " + "\n" + regresaTipo(n.getPrimerHijo().getType()) + " No se puede operar con "
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
            System.out.printf("Error de tipos en operacion % " + "\n" + regresaTipo(n.getPrimerHijo().getType()) + " No se puede operar con "
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
            System.out.printf("Error de tipos en operacion not " + "\n" + " No se puede operar con " + regresaTipo(n.getPrimerHijo().getType()));
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
            System.out.printf("Error de tipos en operacion * " + "\n" + regresaTipo(n.getPrimerHijo().getType()) + " No se puede operar con "
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
            System.out.printf("Error de tipos en operacion ** " + "\n" + regresaTipo(n.getPrimerHijo().getType()) + " No se puede operar con "
                                                               + regresaTipo(n.getUltimoHijo().getType()));
            System.exit(0);
        }       
    }

     //Metodo para asignarle a un nodo el tipo que tendra.
    //Si la operacion se efectua entre dos tipos incompatibles se imprime un mensaje de error.
    public void visit(NodoWhile n) {
        n.getPrimerHijo().accept(this); 
        n.getUltimoHijo().accept(this); 
        int tipo = verificadorSistemaTipos.verificadorWhile(n.getPrimerHijo().getType());
        //Si el tipo no es -1 significa que la operacion esta conformada por tipos correctos.
        if(tipo != -1){    
            n.setTipo(tipo);
        //Si el tipo es -1 significa que uno o ambos tipos son incorrectos para la operacion.
        }else{
            System.out.printf("Error de tipos en operacion while " + "\n" + " No se puede operar con " +  regresaTipo(n.getPrimerHijo().getType()));
            System.exit(0);
        }   
    }

    //Metodo para el nodo if, en caso de que en el cuerpo del if no haya un booleano manda un mensaje de error.
    public void visit(NodoIf n) {
        int numeroHijos = n.obtenNumeroHijos();
        LinkedList<Nodo> hijos = n.getTotal();
        hijos.get(0).accept(this);
        hijos.get(1).accept(this);
        //En caso de que sean 3 hijos aplicamos el metodo accept para los tres.
        if (numeroHijos == 3) {
            hijos.get(2).accept(this);
        }
        int tipo = verificadorSistemaTipos.verificadorWhile(n.getPrimerHijo().getType());
        //Si el tipo no es -1 significa que la operacion esta conformada por tipos correctos.
        if(tipo != -1){    
            n.setTipo(tipo);
        //Si el tipo es -1 significa que uno o ambos tipos son incorrectos para la operacion.
        }else{
            System.out.printf("Error de tipos en operacion if " + "\n" + " No se puede evaluar el if con en el cuerpo" +  regresaTipo(n.getPrimerHijo().getType()));
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
            System.out.printf("Error de tipos en operacion != " + "\n" + regresaTipo(n.getPrimerHijo().getType()) + " No se puede operar con "
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
            System.out.printf("Error de tipos en operacion / " + "\n" + regresaTipo(n.getPrimerHijo().getType()) + " No se puede operar con "
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
            System.out.printf("Error de tipos en operacion == " + "\n" + regresaTipo(n.getPrimerHijo().getType()) + " No se puede operar con "
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
            System.out.println("Error de tipos en operacion // " + "\n" + regresaTipo(n.getPrimerHijo().getType()) + " No se puede operar con "
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
            System.out.printf("Error de tipos en operacion - " + "\n" + regresaTipo(n.getPrimerHijo().getType()) + " No se puede operar con "
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
            System.out.printf("Error de tipos en operacion + " + "\n" + regresaTipo(n.getPrimerHijo().getType()) + " No se puede operar con "
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

    //Metodo que verificara que un identificador tenga un valor que lo defina.
    public void visit(IdentificadorHoja n){
        if( !tablaDeSimbolos.containsKey(n.getNombre())){
            System.err.println("\n\nLa variable " + n.getNombre() + " no tiene un valor definido");   
            System.exit(0);
        }else{
            n.setTipo(tablaDeSimbolos.get(n.getNombre()));
        }
    }

    //Metodo para las asignaciones.
    //Se encargara de actualizar los valores de los identificadores en caso de cambios.
    public void visit(NodoEq n){
        n.getUltimoHijo().accept(this);
        String nombre = n.getPrimerHijo().getNombre();  
        //Verificamos si existe en nuetra tabla de simbolos.
        if (tablaDeSimbolos.containsKey(nombre)){            
            //Si el tipo nuevo es diferente al antiguo manda un error.
            if(tablaDeSimbolos.get(nombre) != n.getUltimoHijo().getType()){
                System.out.println("El nuevo tipo no es del mismo tipo al antiguo");
                System.exit(0);
            }else{
                n.setTipo(tablaDeSimbolos.get(nombre));
            }
        //En caso de tener el mismo tipo lo guardamos en la tabla sin priblemas.    
        }else{  
            tablaDeSimbolos.put(nombre, n.getUltimoHijo().getType());
        }
        
        n.getPrimerHijo().accept(this);
    }

    //Como es una hoja solo se le asigna su tipo.
    public void visit(IntHoja n) {
        n.setTipo(ENTERO);
    }
    //Como es una hoja solo se le asigna su tipo.
     public void visit(CadenaHoja n) {
        n.setTipo(CADENA);
    }
    //Como es una hoja solo se le asigna su tipo.
     public void visit(BooleanoHoja n) {
        n.setTipo(BOOLEANO);
    }
    //Como es una hoja solo se le asigna su tipo.
     public void visit(RealHoja n) {
        n.setTipo(REAL);
    }

    public void visit(NodoStmts n){
    }

    //Metodo para permitir la deteccion de tipos en un else.
     public void visit(NodoElse n){
        n.getPrimerHijo().accept(this);
        n.getUltimoHijo().accept(this);
    }

     public void visit(NodoDoubleP n){
    }

     public void visit(NodoAnd n){
    }

    //En el print solo se le asignara el tipo que tiene.
     public void visit(NodoPrint n){
        n.getPrimerHijo().accept(this);
        int tipo = verificadorSistemaTipos.verificadorPrint(n.getPrimerHijo().getType());
        //Si el tipo no es -1 significa que la operacion esta conformada por tipos correctos.
        if(tipo != -1){    
            n.setTipo(tipo);
        //Si el tipo es -1 significa que uno o ambos tipos son incorrectos para la operacion.
        }else{
            System.out.printf("Error de tipos en operacion print " + "\n" + " No se puede imprimir con " +  regresaTipo(n.getPrimerHijo().getType()));
            System.exit(0);
        }   

    }

     public void visit(NodoOr n) {
    }

    public void visit(Nodo n){
    }
}
