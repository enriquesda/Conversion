import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class Menu {

    private String ruta;
    private ArrayList<File> archivos;
    private Archivo selec;

    /**
     * comprueba si la ruta selecioda existe y si es asi la establece y guarda los
     * archivos que tiene
     * 
     * @param r
     */
    public void selecRuta(String r) {

    }

    /**
     * Comprueba si la ruta del fichero es correcta(pertenece al directorio que
     * estamos) y lo guarda como archivo selec
     * 
     * @param r
     */
    public void selecFichero(String r) {

    }

    /**
     * 
     * @param formato
     * @param ruta
     */

    public void conversion(String formato, String nombre) { //CORREGIR, NO ME MOLA NADA
        if (selec != null) {
            try {
                if (formato.equals("xml")) {
                    File copia = new File(selec.getRuta() + "/" + nombre + ".xml");
                    selec.escribirXML(copia.getPath());
                } else if (formato.equals("json")) {
                    File copia = new File(selec.getRuta() + "/" + nombre + ".json");
                    selec.escribirJSON(copia.getPath());
                } else if (formato.equals("csv")) {
                    File copia = new File(selec.getRuta() + "/" + nombre + ".csv");
                    selec.escribirCSV(copia.getPath());
                }
            } catch (IOException e) {
                System.err.println("Error during conversion: " + e.getMessage());
            }
        }
    }

    public boolean comprobarRuta(String r) {
        File ruta = new File(r);
        if(ruta.exists()){
            return true;
        }
        else{
            return false;
        }
        
    }

    public String imprimirMenu() {
        return " ";
    }

}
