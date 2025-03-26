
import java.io.IOException;

public class App {

    public static void main(String[] args) throws Exception {
        String path="src/archivos";
        Menu menu = new Menu();
        if (menu.selecRuta(path)) {
            System.out.println("Ruta valida");
            System.out.println(menu.getRuta());
            System.out.println(menu.imprimirArchivos());
            
        }else{
            System.out.println("Ruta no valida");
        }
        
    }
}
