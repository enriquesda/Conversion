public class App {
    public static void main(String[] args) throws Exception {
        String path="Conversion/src/archivos/CopiaXML.xml";
        String path2="Conversion/src/archivos/CopiaJSONAXML.xml";
        Archivo archivo = new Archivo("Conversion/src/archivos/coches.csv");
        System.out.println(archivo.leerArchivoCSV("Conversion/src/archivos/coches.csv"));
        System.out.println("\n");
        System.out.println(archivo.leerArchivoJSON("Conversion/src/archivos/coches.json"));
        archivo.escribirXML(path, archivo.leerArchivoCSV("Conversion/src/archivos/coches.csv"));
        archivo.escribirXML(path2, archivo.leerArchivoJSON("Conversion/src/archivos/coches.json"));
        
    }
}
