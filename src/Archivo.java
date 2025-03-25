import java.util.ArrayList;
import java.util.HashMap;

public class Archivo {
    private String ruta;
    private ArrayList<HashMap<String, String>> archivo;
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

    public ArrayList<HashMap<String, String>> lecturaXML(String r){
        ArrayList<HashMap<String, String>> lista = new ArrayList<>();


        return lista;
    }

    public ArrayList<HashMap<String, String>> lecturaJSON(String r){
        ArrayList<HashMap<String, String>> lista = new ArrayList<>();


        return lista;
    }

    public ArrayList<HashMap<String, String>> lecturaCSV(String r){
        ArrayList<HashMap<String, String>> lista = new ArrayList<>();


        return lista;
    }


    public Archivo escribirXML(){
        Archivo xml=null;

        return xml;
    }

    public Archivo escribirJSON(){
        Archivo json=null;

        return json;
    }

    public Archivo escribirCSV(){
        Archivo csv=null;

        return csv;
    }

}
