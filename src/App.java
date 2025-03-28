
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App {

    public static Scanner sc = new Scanner(System.in);

    public static Menu menu = new Menu();

    public static void main(String[] args) throws Exception {
        boolean funcionando = true;
        do {

            System.out.println(imprimirMenu());
            System.out.print("Selecciona una opcion: ");
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

    public static void ejercicio1() {
        System.out.print("Introduce la ruta en la que quieres buscar: ");
        if (menu.selecRuta(sc.nextLine().trim())) {
            System.out.println("Ruta seleccionada con exito");
        } else {
            System.out.println("La ruta seleccionada no existe o es erronea");
        }
    }

    public static void ejercicio2() {
        if (menu.getRuta().equals(" ")) {
            System.out.println("Primero selecciona una ruta.");
        } else {
            System.out.print("Introduce el nombre con su extension del fichero que deseeas seleccionar: ");
            if (menu.selecFichero(sc.nextLine().trim())) {
                System.out.println("Archivo seleccionada con exito.");
            } else {
                System.out.println("El archivo seleccionado no existe o es erroneo.");
            }
        }

    }

    public static String imprimirMenu() {
        StringBuilder impresion = new StringBuilder();
        if (menu.getRuta().equals(" ")) {
            impresion.append("Ruta: .........").append("\n");
        } else {
            impresion.append("Ruta:").append(menu.getRuta()).append("\n");
        }

        if (menu.getArchivos() == null || menu.getArchivos().isEmpty()) {
            impresion.append("Archivos: .........").append(menu.getRuta()).append("\n");
        } else {
            impresion.append("Archivos: ").append(menu.getRuta()).append("\n");
            int cont = 1;
            for (File file : menu.getArchivos()) {
                impresion.append(cont).append("º Archivo:").append(file.getName()).append("\n");
                cont++;
            }
        }
        if (menu.getSelec() == null) {
            impresion.append("Archivo seleccionado: .........").append("\n");
        } else {
            impresion.append("Archivo seleccionado:").append(menu.getSelec().getRuta()).append("\n");
        }

        impresion.append("-----------------------------------").append("\n");
        impresion.append("Selecciona una opción del menú").append("\n");
        impresion.append("1: Seleccionar carpeta").append("\n");
        impresion.append("2: Lectura de archivos").append("\n");
        impresion.append("3: Conversión").append("\n");
        impresion.append("0: SALIR").append("\n");

        return impresion.toString();
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
                    System.out.println("Convirtiendo a JSON...");
                    // Aquí deberías implementar la lógica para convertir a JSON
                    break;
                case 2:
                    System.out.println("Convirtiendo a XML...");
                    // Aquí deberías implementar la lógica para convertir a XML
                    break;
                case 3:
                    System.out.println("Convirtiendo a CSV...");
                    // Aquí deberías implementar la lógica para convertir a CSV
                    break;
                default:
                    funcionando = false;
                    System.out.println("Saliendo del menú de conversión...");
            }
        } while (funcionando);
        sc.close();
    }
}
