import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Menu {
    private String ruta;
    private ArrayList <File> archivos;
    private Archivo selec;

    public Menu(){
        this.ruta="......";
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
     * comprueba si la ruta selecioda existe y si es asi la establece y guarda los archivos que tiene
     * @param r
     */
    public boolean selecRuta(String r){
        File fichero = new File(r);
        if (fichero.exists() && fichero.isDirectory()) {
            this.ruta=r;
            String[] contenido = fichero.list();
            if (archivos != null && contenido.length > 0) {
            for (String archivo : contenido) {
                        File archi = new File(archivo);
                        archivos.add(archi);
                    }
                }
            return true;
        } else {
            return false;
        }
    }


    /**
     * Comprueba si la ruta del fichero es correcta(pertenece al directorio que estamos) y lo guarda como archivo selec
     * @param r
     */
    public void selecFichero(String r){

    }


    /**
     * 
     * @param formato
     * @param ruta
     */

    public void conversion(String formato,String nombre){

    }


    public boolean comprobarRuta(String r){
        return true;
    }

    public String imprimirMenu(){
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
