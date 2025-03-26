
import java.io.IOException;

public class App {

    public static void main(String[] args) throws Exception {
        String path="Conversion/src/archivos/CopiaXML.xml";
        String path2="Conversion/src/archivos/CopiaJSONAXML.xml";
        String path3="Conversion/src/archivos/coches.csv";
        Archivo archivo = new Archivo("Conversion/src/archivos/coches.csv");
        System.out.println(archivo.leerArchivoCSV("Conversion/src/archivos/coches.csv"));
        System.out.println("\n");
        System.out.println(archivo.leerArchivoJSON("Conversion/src/archivos/coches.json"));
        archivo.escribirXML(path);
        archivo.escribirXML(path2);
        System.out.println("\n");
        
    }
}
