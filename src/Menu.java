import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class Menu {

    private String ruta;
    private ArrayList <File> archivos;
    private Archivo selec;

    public Menu(){
        this.ruta=".........";
        this.archivos= new ArrayList<>();
        this.selec=null;
    }
    

    public String getRuta() {
        return ruta;
    }


    public void setRuta(String ruta) {
        this.ruta = ruta;
    }


    public ArrayList<File> getArchivos() {
        return archivos;
    }


    public void setArchivos(ArrayList<File> archivos) {
        this.archivos = archivos;
    }


    public Archivo getSelec() {
        return selec;
    }


    public void setSelec(Archivo selec) {
        this.selec = selec;
    }


    /**
     * comprueba si la ruta selecioda existe y si es asi la establece y guarda los
     * archivos que tiene
     * 
     * @param r
     */
    public boolean selecRuta(String r) {
        File directorio = new File(r);
        if (directorio.exists() && directorio.isDirectory()) {
            this.ruta = directorio.getAbsolutePath(); 
            this.archivos.clear();
            
            File[] contenido = directorio.listFiles();
            if (contenido != null) {
                for (File archivo : contenido) {
                    if (archivo.isFile()) {
                        archivos.add(archivo);
                    }
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Comprueba si la ruta del fichero es correcta(pertenece al directorio que
     * estamos) y lo guarda como archivo selec
     * 
     * @param r
     */
    public boolean selecFichero(String r) {
        if (archivos == null || archivos.isEmpty()) {
            return false;
        }
    
        for (File file : archivos) {
            if (file.getName().equals(r)) {
                this.selec = new Archivo(file.getAbsolutePath());
                return true;
            }
        }
        return false; 
    }

    /**
     * 
     * @param formato
     * @param ruta
     */

    public void conversion(String formato, String nombre) { //CORREGIR, NO ME MOLA NADA
        if (this.selec != null) {
            try {
                if (formato.equals("xml")) {
                    File copia = new File(this.selec.getRuta() + "/" + nombre + ".xml");
                    selec.escribirXML(copia.getPath());
                } else if (formato.equals("json")) {
                    File copia = new File(this.selec.getRuta() + "/" + nombre + ".json");
                    selec.escribirJSON(copia.getPath());
                } else if (formato.equals("csv")) {
                    File copia = new File(this.selec.getRuta() + "/" + nombre + ".csv");
                    selec.escribirCSV(copia.getPath());
                }
            } catch (IOException e) {
                System.err.println("Error durante la conversión: " + e.getMessage());
            }
        }
    }

    //REPE¿?¿?¿ SEGURAMENTE BORRARS
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

    public String imprimirArchivos(){
        StringBuilder dev= new StringBuilder();
        for (File file : archivos) {
            dev.append(file.getName()).append("\n");
            

        }
        return dev.toString();
    }


    
}
