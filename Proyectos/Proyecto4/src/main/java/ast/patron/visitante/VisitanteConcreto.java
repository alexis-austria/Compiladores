package ast.patron.visitante;

import ast.patron.compuesto.*;
import java.util.Iterator;
import java.util.Hashtable;
import java.util.LinkedList;


public abstract class VisitanteConcreto implements Visitor {

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
}