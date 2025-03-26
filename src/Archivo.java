
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
        String[] aux = ruta.split("\\.");
        switch (aux[aux.length - 1]) {
            case "csv":
                formato = 0;
                this.archivo = lecturaCSV(ruta);
                break;
            case "json":
                formato = 1;
                this.archivo = lecturaJSON(ruta);
                break;
            case "xml":
                formato = 2;
                this.archivo = lecturaXML(ruta);
                break;
            default:
                break;
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

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public ArrayList<LinkedHashMap<String, String>> getArchivo() {
        return archivo;
    }

    public void setArchivo(ArrayList<LinkedHashMap<String, String>> archivo) {
        this.archivo = archivo;
    }

    public int getFormato() {
        return formato;
    }

    public void setFormato(int formato) {
        this.formato = formato;
    }

    public ArrayList<LinkedHashMap<String, String>> lecturaXML(String r) {
        ArrayList<LinkedHashMap<String, String>> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(r))) {
            String linea;
            boolean cierre = false;
            while ((linea = br.readLine()) != null) {
                String[] palabras = linea.replaceAll("[<>/]", " ").trim().toLowerCase().split("\\s+");
                if (!cierre) {
                    if (palabras.length > 1) {
                        cierre = true;
                        LinkedHashMap<String, String> a = new LinkedHashMap<>();
                        a.put(palabras[0], palabras[1]);
                        lista.add(a);
                    }
                } else {
                    if (palabras.length > 1) {
                        LinkedHashMap<String, String> ultimoMapa = lista.get(lista.size() - 1);
                        ultimoMapa.put(palabras[0], palabras[1]);
                    } else {
                        cierre = false;
                    }
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

    public void escribirXML(String rutadest) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutadest))) {
            String nombre = obtenerNombre();
            bw.write("<" + nombre + ">\n");
            for (LinkedHashMap<String, String> fila : archivo) {
                bw.write("  <" + (nombre.length()-1) + ">\n");
                for (String key : fila.keySet()) {
                    bw.write("\t<" + key + ">" + fila.get(key) + "</" + key + ">\n");
                }
                bw.write("  </" + (nombre.substring(0, nombre.length()-1)) + ">\n");
            }
            bw.write("</"+ nombre + ">\n");
        } catch (IOException e) {
            System.err.println("Error al escribir " + e.getMessage());
        }

    }

    private String obtenerNombre(){
        String[] partes = ruta.split("/");
        return partes[partes.length-1].substring(0, partes[partes.length-1].length()-4);
    }

    public Archivo escribirXML() {
        Archivo xml = null;

        return xml;
    }

    public void escribirJSON(String r) throws IOException {
        if (archivo.isEmpty()) {
            return;
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(r))) {
            bw.write("[");
            bw.write("\n");
            int longitud = archivo.size();
            int contador = 0;
            for (LinkedHashMap<String, String> mapa : archivo) {
                bw.write("  {");
                bw.write("\n");

                StringBuilder lineacon = new StringBuilder();
                for (String clave : mapa.keySet()) {
                    lineacon.append("    ");
                    lineacon.append("\"").append(Character.toUpperCase(clave.charAt(0))).append(clave.substring(1)).append("\": ");
                    try {
                        Double.parseDouble(mapa.get(clave));
                        lineacon.append(mapa.get(clave)).append(",\n");
                    } catch (NumberFormatException e) {
                        lineacon.append("\"").append(Character.toUpperCase(mapa.get(clave).charAt(0)) + mapa.get(clave).substring(1)).append("\",\n");
                    }
                }
                if (lineacon.length() > 0) {
                    lineacon.setLength(lineacon.length() - 2);
                }
                bw.write(lineacon.toString());
                bw.write("\n");
                if (contador < longitud - 1) {
                    bw.write("  },");
                    bw.write("\n");
                } else {
                    bw.write("  }");
                    bw.write("\n");
                }
                contador++;
            }
            bw.write("]");
            bw.write("\n");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void escribirCSV(String r) throws IOException {
        if (archivo.isEmpty()) {
            return;
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(r))) {
            StringBuilder encabezados = new StringBuilder();
            LinkedHashMap<String, String> primerMapa = archivo.get(0);

            for (String clave : primerMapa.keySet()) {
                encabezados.append(Character.toUpperCase(clave.charAt(0))).append(clave.substring(1)).append(",");
            }

            if (encabezados.length() > 0) {
                encabezados.setLength(encabezados.length() - 1);
            }

            bw.write(encabezados.toString());
            bw.write("\n");

            for (LinkedHashMap<String, String> mapa : archivo) {
                StringBuilder lineacon = new StringBuilder();
                for (String clave : mapa.keySet()) {
                    String aniadir = Character.toUpperCase(mapa.get(clave).charAt(0)) + mapa.get(clave).substring(1);
                    lineacon.append(aniadir).append(",");
                }
                if (lineacon.length() > 0) {
                    lineacon.setLength(lineacon.length() - 1);
                }
                bw.write(lineacon.toString());
                bw.write("\n");
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

    public void imprimirContenido() {
        for (LinkedHashMap<String, String> mapa : archivo) {
            System.out.println("---- Nuevo coche ----");
            for (String clave : mapa.keySet()) {
                System.out.println(clave + " : " + mapa.get(clave));
            }
        }
    }
}
