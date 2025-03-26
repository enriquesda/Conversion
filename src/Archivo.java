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
    }

    public ArrayList<LinkedHashMap<String, String>> leerArchivoCSV(String ruta) {
        ArrayList<LinkedHashMap<String, String>> archivo = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            String[] cabecera = br.readLine().split(",");
            while ((linea = br.readLine()) != null) {
                String[] valor = linea.split(",");
                LinkedHashMap<String, String> fila = new LinkedHashMap<>();
                for (int i = 0; i < cabecera.length; i++) {
                    fila.put(cabecera[i], valor[i]);
                }
                archivo.add(fila);
            }

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return archivo;
    }

    public ArrayList<LinkedHashMap<String, String>> leerArchivoJSON(String ruta) {
        ArrayList<LinkedHashMap<String, String>> archivo = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            LinkedHashMap<String, String> fila = null; 
            while ((linea = br.readLine()) != null && !linea.equals("]")) {
                linea = linea.trim();
                if (linea.equals("{")) {
                    fila = new LinkedHashMap<>(); 
                } else if (linea.equals("},") || linea.equals("}")) {
                    if (fila != null) {
                        archivo.add(fila); 
                    }
                } else {
                    String[] valor = linea.split(":");
                    for (int i = 0; i < valor.length; i += 2) {
                        if (fila != null) {
                            String key = valor[i].trim();
                            if (key.length() > 2) { // Verifica que la longitud sea suficiente para que no de error
                                key = key.substring(1, key.length() - 1); 
                            } 
                            String dato = valor[valor.length - 1].trim();
                            if (dato.contains("\"")) { // Si contiene comillas
                                if (dato.endsWith("\",")) { // Si termina en ",
                                    dato = dato.substring(1, dato.length() - 2); 
                                } else { // Si no termina en ",
                                    dato = dato.substring(1, dato.length() - 1); 
                                }
                            } else { // Si no contiene comillas
                                if (dato.endsWith(",")) {
                                    dato = dato.substring(0, dato.length() - 1); 
                                } else {
                                    dato = dato.substring(0, dato.length());
                                }
                            }
                            fila.put(key, dato);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return archivo;
    }

    public void escribirXML(String ruta, ArrayList<LinkedHashMap<String, String>> archivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            bw.write("<coches>\n");
            for (LinkedHashMap<String, String> fila : archivo) {
                bw.write("  <coche>\n");
                for (String key : fila.keySet()) {
                    bw.write("\t<" + key + ">" + fila.get(key) + "</" + key + ">\n");
                }
                bw.write("  </coche>\n");
            }
            bw.write("</coches>\n");
        } catch (IOException e) {
            System.err.println("Error al escribir " + e.getMessage());
        }
        
    }

}
