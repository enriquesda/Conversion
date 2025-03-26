import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Archivo {
    private String ruta;
    private ArrayList<LinkedHashMap<String, String>> archivo;
    private int formato; // 0->csv 1->json 2->xml

    public Archivo(String ruta) {
        this.ruta = ruta;
        String[] aux = ruta.split(".");
        switch (aux[aux.length - 1]) {
            case "csv":
                formato = 0;
                break;
            case "json":
                formato = 1;
                break;
            case "xml":
                formato = 2;
                break;
            default:

                break;
        }
    }

    public ArrayList<LinkedHashMap<String, String>> lecturaXML(String r) {
        ArrayList<LinkedHashMap<String, String>> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/archivos/coches.xml"))) {
            String linea;
            boolean cierre=false;
            while ((linea = br.readLine()) != null) {
                String[] palabras = linea.replaceAll("[<>/]", " ").trim().toLowerCase().split("\\s+");
                if(!cierre){
                    if (palabras.length>1) {
                        cierre=true;
                        LinkedHashMap<String, String> a = new LinkedHashMap<>(); 
                        a.put(palabras[0], palabras[1]);
                        lista.add(a);
                    }
                }else{

                }

            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return lista;

    }

    public ArrayList<LinkedHashMap<String, String>> lecturaJSON(String r) {
        ArrayList<LinkedHashMap<String, String>> lista = new ArrayList<>();

        return lista;
    }

    public ArrayList<LinkedHashMap<String, String>> lecturaCSV(String r) {
        ArrayList<LinkedHashMap<String, String>> lista = new ArrayList<>();

        return lista;
    }

    public Archivo escribirXML() {
        Archivo xml = null;

        return xml;
    }

    public Archivo escribirJSON() {
        Archivo json = null;

        return json;
    }

    public Archivo escribirCSV() {
        Archivo csv = null;

        return csv;
    }

}
