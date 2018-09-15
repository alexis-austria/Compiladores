package lexico;
import java.io.*;

public class AnalizadorLexico {
    Flexer lexer;

    public AnalizadorLexico(String archivo){
        try {
            PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
            System.setOut(out);
            Reader lector = new FileReader("src/main/resources/test.txt");
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
