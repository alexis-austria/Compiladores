package lexico;
import java.io.*;

public class AnalizadorLexico {
    Flexer lexer;

    public AnalizadorLexico(String archivo){
        String file = "fzz_error_cadena";
        try {
            PrintStream out = new PrintStream(new FileOutputStream("out/" + file + ".plx"));
            System.setOut(out);
            Reader lector = new FileReader("src/main/resources/" + file + ".p");
            lexer = new Flexer(lector);
        }
        catch(FileNotFoundException ex) {
            System.out.println(ex.getMessage() + " No se encontró el archivo;");
        }
    }

    public void analiza(){
        try{
          lexer.yylex();
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

}
