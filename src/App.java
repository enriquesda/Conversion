import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
         try (BufferedReader br = new BufferedReader(new FileReader("src/archivos/coches.xml"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] palabras = linea.replaceAll("[<>/]", " ").trim().toLowerCase().split("\\s+");
                for (String n : palabras) {
                    System.out.print(n+" ");
                }
                System.out.println("\n");
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
  
    }
}
