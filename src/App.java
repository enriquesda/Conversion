
public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Archivo ar = new Archivo("src/archivos/coches.xml");
        System.out.println("La ruta es : " + ar.getRuta());
        System.err.println("Su extension es :" + ar.getFormato());
        System.out.println("Contenido de archivo:");
        ar.imprimirContenido();
        ar.escribirCSV("src/archivos/copiacoches.csv");

    }
}
