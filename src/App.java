
import java.io.IOException;

public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Archivo ar = new Archivo("src/archivos/coches.xml");
        System.out.println("La ruta es : " + ar.getRuta());
        System.err.println("Su extension es :" + ar.getFormato());
        System.out.println("Contenido de archivo:");
        ar.imprimirContenido();

        try {
            ar.escribirCSV("src/archivos/copiacoches.csv");
        } catch (IOException e) {
            System.err.println("No se pudo escribir el archivo: " + e.getMessage());
        }
        try {
            ar.escribirJSON("src/archivos/copiacoches.json");
        } catch (IOException e) {
            System.err.println("No se pudo escribir el archivo: " + e.getMessage());
        }

    }
}
