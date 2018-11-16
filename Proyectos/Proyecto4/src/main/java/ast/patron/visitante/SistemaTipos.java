package ast.patron.visitante;
import ast.patron.compuesto.Variable;
import java.util.ArrayList;


//Clase que servira para definir las reglas para cada operador.
//Se definira con que tipos de  datos puede operar cada tipo mendiante matrices.
public class SistemaTipos {
    
    //Los booleanos se representan con 0,enteros con 1, reales con 2 y cadenas con 3.
    //Los errores los tomamos como -1.
    private static final int ERROR = -1; 
    private static final int BOOLEANO = 0;
    private static final int ENTERO = 1;
    private static final int REAL = 2;
    private static final int CADENA = 3;

    

    //Tabla para definir si los tipos son compatibles en el dif.
    //El primer renglon y la primera columna representan los booleanos.
    //El segundo renglon y la segunda columna representan los Enteros.
    //El tercer renglon y la tercera columna representan los reales. 
    //El cuarto renglon y la cuarta columna representan las cadenas.
    int[][] diff = new int[][]{
                {ERROR,ERROR,ERROR,ERROR},
                {ERROR, BOOLEANO, BOOLEANO, ERROR},
                {ERROR, BOOLEANO, BOOLEANO, ERROR},
                {ERROR, ERROR, ERROR, ERROR}};

    //Funcion para calcular la entrada en la matriz para la operacion diff.
    public int verificadorDiff(int i, int j) {
        return diff[i][j];
    }

    //Tabla para definir si los tipos son compatibles en el divInt.
    //El primer renglon y la primera columna representan los booleanos.
    //El segundo renglon y la segunda columna representan los Enteros.
    //El tercer renglon y la tercera columna representan los reales. 
    //El cuarto renglon y la cuarta columna representan las cadenas.
    int[][] divInt = new int[][]{
                {ERROR,ERROR,ERROR,ERROR},
                {ERROR, ENTERO, ENTERO, ERROR},
                {ERROR, ENTERO, ENTERO, ERROR},
                {ERROR, ERROR, ERROR, ERROR}};

    //Funcion para calcular la entrada en la matriz para la operacion divInt.
    public int verificadorDivInt(int i, int j) {
        return divInt[i][j];
    }
    
    
    //Tabla para definir si los tipos son compatibles en el doubleEq.
    //El primer renglon y la primera columna representan los booleanos.
    //El segundo renglon y la segunda columna representan los Enteros.
    //El tercer renglon y la tercera columna representan los reales. 
    //El cuarto renglon y la cuarta columna representan las cadenas.
    int[][] doubleEq= new int[][]{
                {ERROR,ERROR,ERROR,ERROR},
                {ERROR, BOOLEANO, BOOLEANO, ERROR},
                {ERROR, BOOLEANO, BOOLEANO, ERROR},
                {ERROR, ERROR, ERROR, ERROR}};

    //Funcion para calcular la entrada en la matriz para la operacion doubleEq.
    public int verificadorDoubleEq(int i, int j) {
        return doubleEq[i][j];
    }

    //Tabla para definir si los tipos son compatibles en el gr.
    //El primer renglon y la primera columna representan los booleanos.
    //El segundo renglon y la segunda columna representan los Enteros.
    //El tercer renglon y la tercera columna representan los reales. 
    //El cuarto renglon y la cuarta columna representan las cadenas.
    int[][] gr = new int[][]{
                {ERROR,ERROR,ERROR,ERROR},
                {ERROR, BOOLEANO, BOOLEANO, ERROR},
                {ERROR, BOOLEANO, BOOLEANO, ERROR},
                {ERROR, ERROR, ERROR, ERROR}};

    //Funcion para calcular la entrada en la matriz para la operacion gr.
    public int verificadorGr(int i, int j) {
        return gr[i][j];
    }

    //Tabla para definir si los tipos son compatibles en el grq.
    //El primer renglon y la primera columna representan los booleanos.
    //El segundo renglon y la segunda columna representan los Enteros.
    //El tercer renglon y la tercera columna representan los reales. 
    //El cuarto renglon y la cuarta columna representan las cadenas.
    int[][] grq = new int[][]{
                {ERROR,ERROR,ERROR,ERROR},
                {ERROR, BOOLEANO, BOOLEANO, ERROR},
                {ERROR, BOOLEANO, BOOLEANO, ERROR},
                {ERROR, ERROR, ERROR, ERROR}};
            
    //Funcion para calcular la entrada en la matriz para la operacion grq.
    public int verificadorGrq(int i, int j) {
        return grq[i][j];
    }

    //En el if solo se tomaran en cuenta los booleanos.
    int[] iff = new int[]{BOOLEANO,ERROR,ERROR,ERROR};

    //Funcion para calcular la entrada en la matriz para la operacion if.
    public int verificadorIf(int i) {
        return iff [i];
    }

    //Tabla para definir si los tipos son compatibles en el div.
    //El primer renglon y la primera columna representan los booleanos.
    //El segundo renglon y la segunda columna representan los Enteros.
    //El tercer renglon y la tercera columna representan los reales. 
    //El cuarto renglon y la cuarta columna representan las cadenas.
    int[][] div = new int[][]{
                {ERROR,ERROR,ERROR,ERROR},
                {ERROR, REAL, REAL, ERROR},
                {ERROR, REAL, REAL, ERROR},
                {ERROR, ERROR, ERROR, ERROR}};

    //Funcion para calcular la entrada en la matriz para la operacion div.
    public int verificadorDiv(int i, int j) {
        return div[i][j];
    }
    
    //Tabla para definir si los tipos son compatibles en el le.
    //El primer renglon y la primera columna representan los booleanos.
    //El segundo renglon y la segunda columna representan los Enteros.
    //El tercer renglon y la tercera columna representan los reales. 
    //El cuarto renglon y la cuarta columna representan las cadenas.
    int[][] le = new int[][]{
                {ERROR,ERROR,ERROR,ERROR},
                {ERROR, BOOLEANO, BOOLEANO, ERROR},
                {ERROR, BOOLEANO, BOOLEANO, ERROR},
                {ERROR, ERROR, ERROR, ERROR}};

    //Funcion para calcular la entrada en la matriz para la operacion le.
    public int verificadorLe(int i, int j) {
        return le[i][j];
    }

    //Tabla para definir si los tipos son compatibles en el grq.
    //El primer renglon y la primera columna representan los booleanos.
    //El segundo renglon y la segunda columna representan los Enteros.
    //El tercer renglon y la tercera columna representan los reales. 
    //El cuarto renglon y la cuarta columna representan las cadenas.
    int[][] leq = new int[][]{
                {ERROR,ERROR,ERROR,ERROR},
                {ERROR, BOOLEANO, BOOLEANO, ERROR},
                {ERROR, BOOLEANO, BOOLEANO, ERROR},
                {ERROR, ERROR, ERROR, ERROR}};

    //Funcion para calcular la entrada en la matriz para la operacion leq.
    public int verificadorLeq(int i, int j) {
        return leq[i][j];
    }

    //Tabla para definir si los tipos son compatibles en el modulo.
    //El primer renglon y la primera columna representan los booleanos.
    //El segundo renglon y la segunda columna representan los Enteros.
    //El tercer renglon y la tercera columna representan los reales. 
    //El cuarto renglon y la cuarta columna representan las cadenas.
    int[][] modulo = new int[][]{
                {ERROR,ERROR,ERROR,ERROR},
                {ERROR, ENTERO, REAL, ERROR},
                {ERROR, REAL, REAL, ERROR},
                {ERROR, ERROR, ERROR, ERROR}};

    //Funcion para calcular la entrada en la matriz para la operacion modulo.
    public int verificadorModulo(int i, int j) {
        return modulo[i][j];
    }

    //En el not se regresara un booleano para todos. 
    int[] not = new int[]{BOOLEANO,ENTERO,REAL,ERROR};

    //Funcion para calcular la entrada en la matriz para la operacion not.
    public int verificadorNot(int i) {
        return not[i];
    }

    //Tabla para definir si los tipos son compatibles en el por.
    //El primer renglon y la primera columna representan los booleanos.
    //El segundo renglon y la segunda columna representan los Enteros.
    //El tercer renglon y la tercera columna representan los reales. 
    //El cuarto renglon y la cuarta columna representan las cadenas.
    int[][] por = new int[][]{
                {ERROR,ERROR,ERROR,ERROR},
                {ERROR, ENTERO, REAL, ERROR},
                {ERROR, REAL, REAL, ERROR},
                {ERROR, ERROR, ERROR, ERROR}};

    //Funcion para calcular la entrada en la matriz para la operacion por.
    public int verificadorPor(int i, int j) {
        return por[i][j];
    }

    //Tabla para definir si los tipos son compatibles en el potencia.
    //El primer renglon y la primera columna representan los booleanos.
    //El segundo renglon y la segunda columna representan los Enteros.
    //El tercer renglon y la tercera columna representan los reales. 
    //El cuarto renglon y la cuarta columna representan las cadenas.
    int[][] potencia = new int[][]{
                {ERROR,ERROR,ERROR,ERROR},
                {ERROR, ENTERO, REAL, ERROR},
                {ERROR, REAL, REAL, ERROR},
                {ERROR, ERROR, ERROR, ERROR}};
        
    //Funcion para calcular la entrada en la matriz para la operacion potencia.
    public int verificadorPotencia(int i, int j) {
        return potencia[i][j];
    }


    //Tabla para definir si los tipos son compatibles en el resta.
    //El primer renglon y la primera columna representan los booleanos.
    //El segundo renglon y la segunda columna representan los Enteros.
    //El tercer renglon y la tercera columna representan los reales. 
    //El cuarto renglon y la cuarta columna representan las cadenas.
    int[][] resta = new int[][]{
                {ERROR,ERROR,ERROR,ERROR},
                {ERROR, ENTERO, REAL, ERROR},
                {ERROR, REAL, REAL, ERROR},
                {ERROR, ERROR, ERROR, ERROR}};

    //Funcion para calcular la entrada en la matriz para la operacion resta.
    public int verificadorResta(int i, int j) {
        return resta[i][j];
    }

    //Tabla para definir si los tipos son compatibles en la suma.
    //El primer renglon y la primera columna representan los booleanos.
    //El segundo renglon y la segunda columna representan los Enteros.
    //El tercer renglon y la tercera columna representan los reales. 
    //El cuarto renglon y la cuarta columna representan las cadenas.
    int[][] suma = new int[][]{
                {ERROR,ERROR,ERROR,ERROR},
                {ERROR, ENTERO, REAL, ERROR},
                {ERROR, REAL, REAL, ERROR},
                {ERROR, ERROR, ERROR, ERROR}};
    
    //Funcion para calcular la entrada en la matriz para la operacion suma.
    public int verificadorSuma(int i, int j) {
        return suma[i][j];
    }

    //El While solo se efectua con booleanos
    int[] whilee = new int[]{BOOLEANO,ERROR,ERROR,ERROR};

    //Funcion para calcular la entrada en la matriz para la operacion while.
    public int verificadorWhile(int i) {
        return whilee[i];
    }

}