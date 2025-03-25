public class App {
    public static void main(String[] args) throws Exception {
        Archivo archivo = new Archivo("Conversion/src/archivos/coches.csv");
        System.out.println(archivo.leerArchivoCSV("Conversion/src/archivos/coches.csv"));
        System.out.println("\n");
        System.out.println(archivo.leerArchivoJSON("Conversion/src/archivos/coches.json"));
        
    }
}
