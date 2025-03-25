import java.util.ArrayList;
import java.util.HashMap;

public class Archivo {
    private String ruta;
    private ArrayList <HashMap<String,String>> archivo;
    private int formato; //0->csv 1->json 2->xml
    
    
    public Archivo(String ruta){
        this.ruta=ruta;

    }   


}
