
import java.io.IOException;
import java.util.Scanner;

public class App {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        Menu menu = new Menu();
        boolean funcionando = true;
        do {

            System.out.println("Selecciona una opción del menú");
            System.out.println("1: Seleccionar carpeta");
            System.out.println("2: Lectura de archivos");
            System.out.println("3: Conversión");
            System.out.println("0: SALIR");

            int numero = Integer.parseInt(sc.nextLine());
            switch (numero) {
                case 1 ->
                    ejercicio1();
                case 2 ->
                    ejercicio2();
                case 3 ->
                    convertirEn();

                default ->
                    funcionando = false;
            }
        } while (funcionando);
        sc.close();

        String path = "Conversion/src/archivos";
        if (menu.selecRuta(path)) {
            System.out.println("Ruta valida");
            System.out.println(menu.getRuta());
            System.out.println(menu.imprimirArchivos());
            if (menu.selecFichero("coches.xml")) {
                Archivo a = menu.getSelec();
                a.imprimirContenido();
            }

        } else {
            System.out.println("Ruta no valida");
        }

    }

    public static void convertirEn() throws IOException {
        boolean funcionando = true;
        do {

            System.out.println("A qué formato quieres convertir?");
            System.out.println("1: Convertir a JSON");
            System.out.println("2: Convertir a XML");
            System.out.println("3: Convertir a CSV");
            System.out.println("0: SALIR");

            int numero = Integer.parseInt(sc.nextLine());
            switch (numero) {
                case 1:

                    break;
                case 2:
                    break;
                case 3:
                    break;

                default ->
                    funcionando = false;
            }
        } while (funcionando);
        sc.close();
    }
}
